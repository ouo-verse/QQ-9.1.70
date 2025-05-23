package com.tencent.tuxmetersdk.impl;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.tuxmetersdk.export.config.BeforeTriggerErrorCode;
import com.tencent.tuxmetersdk.export.config.DisappearReason;
import com.tencent.tuxmetersdk.export.config.EventErrorCode;
import com.tencent.tuxmetersdk.export.config.TriggerErrorCode;
import com.tencent.tuxmetersdk.export.config.TuxSurveyEvent;
import com.tencent.tuxmetersdk.export.injector.event.ITuxRemoteEventReport;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.export.injector.event.RuleProcessInfo;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxThread;
import com.tencent.tuxmetersdk.impl.event.EventType;
import com.tencent.tuxmetersdk.model.Survey;
import com.tencent.tuxmetersdk.model.SurveyConfig;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxSurveyEventCallback implements ITuxSurveyEventCallback {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TuxSurveyEventCallback";
    private final String beaconAppkey;
    private final TuxDataManager dataManager;
    private final TuxDataStorage dataStorage;
    private final Handler handler;
    private final ITuxLog logger;
    private final ITuxRemoteEventReport remoteEventReporter;
    private final TuxMeterSDKSetting setting;
    private final TriggerState triggerState;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class SurveyEventHandler extends Handler {
        static IPatchRedirector $redirector_;
        private final WeakReference<TuxSurveyEventCallback> surveyEventCallbackRef;

        /* synthetic */ SurveyEventHandler(Looper looper, TuxSurveyEventCallback tuxSurveyEventCallback, AnonymousClass1 anonymousClass1) {
            this(looper, tuxSurveyEventCallback);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, looper, tuxSurveyEventCallback, anonymousClass1);
        }

        SurveyEventHandler(Looper looper, TuxSurveyEventCallback tuxSurveyEventCallback) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.surveyEventCallbackRef = new WeakReference<>(tuxSurveyEventCallback);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) tuxSurveyEventCallback);
            }
        }
    }

    public TuxSurveyEventCallback(TuxMeterSDKSetting tuxMeterSDKSetting, ITuxThread iTuxThread, TuxDataManager tuxDataManager, TuxDataStorage tuxDataStorage, TriggerState triggerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tuxMeterSDKSetting, iTuxThread, tuxDataManager, tuxDataStorage, triggerState);
            return;
        }
        this.setting = tuxMeterSDKSetting;
        this.logger = tuxMeterSDKSetting.getLogger();
        this.remoteEventReporter = tuxMeterSDKSetting.getBeaconReporter();
        this.handler = new SurveyEventHandler(iTuxThread.getSurveyEventLooper(), this, null);
        this.dataManager = tuxDataManager;
        this.dataStorage = tuxDataStorage;
        this.triggerState = triggerState;
        this.beaconAppkey = getBeaconAppkey();
    }

    private String getBeaconAppkey() {
        TuxDataManager tuxDataManager = this.dataManager;
        if (tuxDataManager != null && tuxDataManager.getSDKConfig() != null && Utils.isValidBeaconInfo(this.dataManager.getSDKConfig().getBeaconInfo())) {
            return this.dataManager.getSDKConfig().getBeaconInfo().getAppkey();
        }
        return null;
    }

    private void report(String str, Map<String, String> map) {
        ITuxRemoteEventReport iTuxRemoteEventReport = this.remoteEventReporter;
        if (iTuxRemoteEventReport == null) {
            return;
        }
        String str2 = this.beaconAppkey;
        if (str2 == null) {
            this.logger.i(TAG, "beacon appkey is null, fail to report survey event");
        } else {
            iTuxRemoteEventReport.report(str2, EventType.REALTIME, str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAfterTriggerEvent(TuxSurveyConfig tuxSurveyConfig, TriggerErrorCode triggerErrorCode) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (triggerErrorCode != null) {
            generateBasicEventParams.put("error_code", String.valueOf(triggerErrorCode.getCode()));
        }
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.AFTER_TRIGGER, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAnswerDurationEvent(TuxSurveyConfig tuxSurveyConfig) {
        Map<String, Date> surveyFirstClickServerTime;
        Date date;
        if (tuxSurveyConfig == null || tuxSurveyConfig.getDeliveryId() == null || (surveyFirstClickServerTime = this.dataManager.getSurveyFirstClickServerTime()) == null || (date = surveyFirstClickServerTime.get(tuxSurveyConfig.getDeliveryId())) == null) {
            return;
        }
        long time = this.dataManager.getServerTime().getTime() - date.getTime();
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        generateBasicEventParams.put("answer_duration", String.valueOf(time));
        report(TuxSurveyEvent.ANSWER_DURATION, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportBeforeTriggerEvent(TuxSurveyConfig tuxSurveyConfig, BeforeTriggerErrorCode beforeTriggerErrorCode) {
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (beforeTriggerErrorCode != null) {
            generateBasicEventParams.put("error_code", String.valueOf(beforeTriggerErrorCode.getCode()));
        }
        report(TuxSurveyEvent.BEFORE_TRIGGER, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickEvent(TuxSurveyConfig tuxSurveyConfig) {
        report(TuxSurveyEvent.CLICK, Utils.generateBasicEventParams(tuxSurveyConfig, this.setting));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDelayDeliverEvent(TuxSurveyConfig tuxSurveyConfig, long j3) {
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        generateBasicEventParams.put("delay_millisecond", String.valueOf(j3));
        report(TuxSurveyEvent.DELAY_DELIVER, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDeliverWhenTriggerEvent(TuxSurveyConfig tuxSurveyConfig) {
        report(TuxSurveyEvent.DELIVER_WHEN_TRIGGER, Utils.generateBasicEventParams(tuxSurveyConfig, this.setting));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDisappearEvent(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (disappearReason != null) {
            generateBasicEventParams.put("reason", String.valueOf(disappearReason.getCode()));
        }
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.DISAPPEAR, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportExposeEvent(TuxSurveyConfig tuxSurveyConfig) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.EXPOSE, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportHalfFloatingLayerDisappearEvent(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (disappearReason != null) {
            generateBasicEventParams.put("reason", String.valueOf(disappearReason.getCode()));
        }
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.HALF_FLOATING_LAYER_DISAPPEAR, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportHalfFloatingLayerExposeEvent(TuxSurveyConfig tuxSurveyConfig) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.HALF_FLOATING_LAYER_EXPOSE, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportOnEventErrorCode(EventErrorCode eventErrorCode, Map<String, String> map, TuxSurveyConfig tuxSurveyConfig) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            map.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        map.put(TuxSurveyEvent.TUX_EVENT_ERROR_CODE, String.valueOf(eventErrorCode.getCode()));
        map.putAll(generateBasicEventParams);
        report(TuxSurveyEvent.TUX_SURVEY_EVENT_ERROR, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportOnTrigger(TuxSurveyConfig tuxSurveyConfig) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.TUX_SURVEY_ON_TRIGGER, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPreSubmitEvent(TuxSurveyConfig tuxSurveyConfig) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.PRE_SUBMIT, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportProcessRuleEvent(SurveyConfig surveyConfig, RuleProcessInfo ruleProcessInfo) {
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(surveyConfig, this.setting);
        if (ruleProcessInfo != null) {
            generateBasicEventParams.put(CrashHianalyticsData.PROCESS_ID, String.valueOf(ruleProcessInfo.getId()));
            generateBasicEventParams.put(TransferConfig.ExtendParamFloats.KEY_RULE, String.valueOf(ruleProcessInfo.getRule()));
            generateBasicEventParams.put("pr", String.valueOf(ruleProcessInfo.getProbability()));
            generateBasicEventParams.put("actual_pr", String.valueOf(ruleProcessInfo.getActualProbability()));
            generateBasicEventParams.put("chose_index", String.valueOf(ruleProcessInfo.getChoseIndex()));
            generateBasicEventParams.put("is_father_rule", String.valueOf(ruleProcessInfo.isFatherRule()));
            generateBasicEventParams.put("is_hit_pr", String.valueOf(ruleProcessInfo.isHitProbability()));
            generateBasicEventParams.put("candidate_survey_ids", Utils.join(",", ruleProcessInfo.getCandidateSurveyIDs()));
        }
        report(TuxSurveyEvent.PROCESS_RULE, generateBasicEventParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSubmitEvent(TuxSurveyConfig tuxSurveyConfig) {
        String extInfoJsonString;
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(tuxSurveyConfig, this.setting);
        if (tuxSurveyConfig != null && (extInfoJsonString = tuxSurveyConfig.getExtInfoJsonString()) != null && !extInfoJsonString.isEmpty()) {
            generateBasicEventParams.put(TuxSurveyEvent.TUX_EXT_INFO, extInfoJsonString);
        }
        report(TuxSurveyEvent.SUBMIT, generateBasicEventParams);
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onClick(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        try {
            Map<String, Date> surveyFirstClickServerTime = this.dataManager.getSurveyFirstClickServerTime();
            Map<String, Date> surveyFirstClickClientTime = this.dataManager.getSurveyFirstClickClientTime();
            if (tuxSurveyConfig != null && tuxSurveyConfig.getSurvey() != null && surveyFirstClickServerTime != null && !surveyFirstClickServerTime.containsKey(tuxSurveyConfig.getDeliveryId()) && surveyFirstClickClientTime != null && !surveyFirstClickClientTime.containsKey(tuxSurveyConfig.getDeliveryId())) {
                surveyFirstClickServerTime.put(tuxSurveyConfig.getDeliveryId(), this.dataManager.getServerTime());
                surveyFirstClickClientTime.put(tuxSurveyConfig.getDeliveryId(), new Date());
                this.handler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.7
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ TuxSurveyConfig val$config;

                    {
                        this.val$config = tuxSurveyConfig;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyEventCallback.this, (Object) tuxSurveyConfig);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            if (!Utils.isValidTuxSurveyConfig(this.val$config)) {
                                return;
                            }
                            TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onClick");
                            TuxSurveyEventCallback.this.reportClickEvent(this.val$config);
                        } catch (Exception e16) {
                            TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onClick post\u5f02\u5e38: " + e16.getLocalizedMessage());
                        }
                    }
                });
            }
        } catch (Exception e16) {
            this.logger.e(TAG, "onClick\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onDelayDeliver(TuxSurveyConfig tuxSurveyConfig, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, tuxSurveyConfig, Long.valueOf(j3));
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig, j3) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.12
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;
                final /* synthetic */ long val$delayMillisecond;

                {
                    this.val$config = tuxSurveyConfig;
                    this.val$delayMillisecond = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TuxSurveyEventCallback.this, tuxSurveyConfig, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (Utils.isValidTuxSurveyConfig(this.val$config)) {
                            TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onDelayDeliver, delayMillisecond:" + this.val$delayMillisecond);
                            TuxSurveyEventCallback.this.reportDelayDeliverEvent(this.val$config, this.val$delayMillisecond);
                        }
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onDelayDeliver post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onDelayDeliver\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onDeliverWhenTrigger(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;

                {
                    this.val$config = tuxSurveyConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyEventCallback.this, (Object) tuxSurveyConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!Utils.isValidTuxSurveyConfig(this.val$config)) {
                            return;
                        }
                        TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onDeliverWhenTrigger");
                        TuxSurveyEventCallback.this.reportDeliverWhenTriggerEvent(this.val$config);
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onDeliverWhenTrigger post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onDeliverWhenTrigger\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onDisappear(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) tuxSurveyConfig, (Object) disappearReason);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig, disappearReason) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;
                final /* synthetic */ DisappearReason val$reason;

                {
                    this.val$config = tuxSurveyConfig;
                    this.val$reason = disappearReason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TuxSurveyEventCallback.this, tuxSurveyConfig, disappearReason);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (Utils.isValidTuxSurveyConfig(this.val$config)) {
                            TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onDisappear, disappearReason:" + this.val$reason);
                            TuxSurveyEventCallback.this.reportDisappearEvent(this.val$config, this.val$reason);
                        }
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onDisappear post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onDisappear\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onEventAction(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) map);
        } else {
            map.putAll(Utils.generateBasicEventParams(this.setting));
            report(str, map);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onEventErrorCode(EventErrorCode eventErrorCode, Map<String, String> map, TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, eventErrorCode, map, tuxSurveyConfig);
            return;
        }
        try {
            this.handler.post(new Runnable(eventErrorCode, map, tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.14
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;
                final /* synthetic */ EventErrorCode val$errorCode;
                final /* synthetic */ Map val$params;

                {
                    this.val$errorCode = eventErrorCode;
                    this.val$params = map;
                    this.val$config = tuxSurveyConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TuxSurveyEventCallback.this, eventErrorCode, map, tuxSurveyConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            TuxSurveyEventCallback.this.reportOnEventErrorCode(this.val$errorCode, this.val$params, this.val$config);
                            return;
                        } catch (Exception e16) {
                            TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onEventErrorCode post\u5f02\u5e38: " + e16.getLocalizedMessage());
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onEventErrorCode\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onHalfFloatingLayerDisappear(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) tuxSurveyConfig, (Object) disappearReason);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig, disappearReason) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.11
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;
                final /* synthetic */ DisappearReason val$reason;

                {
                    this.val$config = tuxSurveyConfig;
                    this.val$reason = disappearReason;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TuxSurveyEventCallback.this, tuxSurveyConfig, disappearReason);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (Utils.isValidTuxSurveyConfig(this.val$config)) {
                            TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onHalfFloatingLayerDisappear, disappearReason:" + this.val$reason);
                            TuxSurveyEventCallback.this.reportHalfFloatingLayerDisappearEvent(this.val$config, this.val$reason);
                        }
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onHalfFloatingLayerDisappear post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onHalfFloatingLayerDisappear\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onHalfFloatingLayerShow(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.10
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;

                {
                    this.val$config = tuxSurveyConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyEventCallback.this, (Object) tuxSurveyConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!Utils.isValidTuxSurveyConfig(this.val$config)) {
                            return;
                        }
                        TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onHalfFloatingLayerShow");
                        TuxSurveyEventCallback.this.reportHalfFloatingLayerExposeEvent(this.val$config);
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onHalfFloatingLayerShow post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onHalfFloatingLayerShow\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onPreSubmit(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;

                {
                    this.val$config = tuxSurveyConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyEventCallback.this, (Object) tuxSurveyConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!Utils.isValidTuxSurveyConfig(this.val$config)) {
                            return;
                        }
                        TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onPreSubmit");
                        TuxSurveyEventCallback.this.reportPreSubmitEvent(this.val$config);
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onPreSubmit post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onPreSubmit\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onProcessRule(SurveyConfig surveyConfig, RuleProcessInfo ruleProcessInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surveyConfig, (Object) ruleProcessInfo);
            return;
        }
        try {
            this.handler.post(new Runnable(surveyConfig, ruleProcessInfo) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ SurveyConfig val$config;
                final /* synthetic */ RuleProcessInfo val$ruleProcessInfo;

                {
                    this.val$config = surveyConfig;
                    this.val$ruleProcessInfo = ruleProcessInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TuxSurveyEventCallback.this, surveyConfig, ruleProcessInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onProcessRule");
                        TuxSurveyEventCallback.this.reportProcessRuleEvent(this.val$config, this.val$ruleProcessInfo);
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onProcessRule post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onProcessRule\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onReceiveBeforeTriggerErrorCode(TuxSurveyConfig tuxSurveyConfig, BeforeTriggerErrorCode beforeTriggerErrorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tuxSurveyConfig, (Object) beforeTriggerErrorCode);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig, beforeTriggerErrorCode) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;
                final /* synthetic */ BeforeTriggerErrorCode val$errorCode;

                {
                    this.val$config = tuxSurveyConfig;
                    this.val$errorCode = beforeTriggerErrorCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TuxSurveyEventCallback.this, tuxSurveyConfig, beforeTriggerErrorCode);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (Utils.isValidTuxSurveyConfig(this.val$config)) {
                            TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onReceiveBeforeTriggerErrorCode\uff0cerrorCode:" + this.val$errorCode);
                            if (this.val$errorCode != BeforeTriggerErrorCode.SUCCESS) {
                                TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "beforeTrigger\u56de\u8c03\u9519\u8bef\uff0cerrorCode\u4e3a" + this.val$errorCode);
                                if (TuxSurveyEventCallback.this.triggerState != null) {
                                    TuxSurveyEventCallback.this.triggerState.setNotWaitingForRsp(this.val$config.getDeliveryId());
                                }
                            }
                            TuxSurveyEventCallback.this.reportBeforeTriggerEvent(this.val$config, this.val$errorCode);
                        }
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onReceiveBeforeTriggerErrorCode post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onReceiveBeforeTriggerErrorCode\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onReceiveTriggerErrorCode(TuxSurveyConfig tuxSurveyConfig, TriggerErrorCode triggerErrorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tuxSurveyConfig, (Object) triggerErrorCode);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig, triggerErrorCode) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;
                final /* synthetic */ TriggerErrorCode val$errorCode;

                {
                    this.val$config = tuxSurveyConfig;
                    this.val$errorCode = triggerErrorCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TuxSurveyEventCallback.this, tuxSurveyConfig, triggerErrorCode);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (Utils.isValidTuxSurveyConfig(this.val$config)) {
                            TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onReceiveTriggerErrorCode\uff0cerrorCode:" + this.val$errorCode);
                            if (this.val$errorCode != TriggerErrorCode.SUCCESS) {
                                TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "trigger\u56de\u8c03\u9519\u8bef\uff0cerrorCode\u4e3a" + this.val$errorCode);
                                if (TuxSurveyEventCallback.this.triggerState != null) {
                                    TuxSurveyEventCallback.this.triggerState.setNotWaitingForRsp(this.val$config.getDeliveryId());
                                }
                            }
                            TuxSurveyEventCallback.this.reportAfterTriggerEvent(this.val$config, this.val$errorCode);
                        }
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onReceiveTriggerErrorCode post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onReceiveTriggerErrorCode\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onShow(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;

                {
                    this.val$config = tuxSurveyConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyEventCallback.this, (Object) tuxSurveyConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!Utils.isValidTuxSurveyConfig(this.val$config)) {
                            return;
                        }
                        TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onShow");
                        TuxSurveyEventCallback.this.reportExposeEvent(this.val$config);
                        if (!this.val$config.isPermanent()) {
                            if (TuxSurveyEventCallback.this.triggerState != null) {
                                TuxSurveyEventCallback.this.triggerState.setAnySurveyExpose();
                                TuxSurveyEventCallback.this.triggerState.setNotWaitingForRsp(this.val$config.getDeliveryId());
                            }
                            Survey survey = this.val$config.getSurvey();
                            if (survey != null) {
                                TuxSurveyEventCallback.this.dataManager.recordExposedSurveySet(survey.getId());
                            }
                            if (!this.val$config.isWhite()) {
                                TuxSurveyEventCallback.this.dataStorage.putExposeInfo(new ExposeInfo(new Date()));
                            }
                        }
                        TuxSurveyEventCallback.this.dataManager.getEventQueue().clear();
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onShow post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onShow\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onStartWhenTrigger(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.13
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;

                {
                    this.val$config = tuxSurveyConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyEventCallback.this, (Object) tuxSurveyConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (Utils.isValidTuxSurveyConfig(this.val$config)) {
                            TuxSurveyEventCallback.this.reportOnTrigger(this.val$config);
                        }
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onStartWhenTrigger post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onStartWhenTrigger\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback
    public void onSubmit(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        try {
            this.handler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxSurveyEventCallback.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxSurveyConfig val$config;

                {
                    this.val$config = tuxSurveyConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyEventCallback.this, (Object) tuxSurveyConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!Utils.isValidTuxSurveyConfig(this.val$config)) {
                            return;
                        }
                        TuxSurveyEventCallback.this.logger.i(TuxSurveyEventCallback.TAG, "report onSubmit");
                        TuxSurveyEventCallback.this.reportSubmitEvent(this.val$config);
                        TuxSurveyEventCallback.this.reportAnswerDurationEvent(this.val$config);
                    } catch (Exception e16) {
                        TuxSurveyEventCallback.this.logger.e(TuxSurveyEventCallback.TAG, "onSubmit post\u5f02\u5e38: " + e16.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception e16) {
            this.logger.e(TAG, "onSubmit\u5f02\u5e38: " + e16.getLocalizedMessage());
        }
    }
}

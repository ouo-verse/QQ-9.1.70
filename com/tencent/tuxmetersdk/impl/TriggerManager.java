package com.tencent.tuxmetersdk.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.config.EventErrorHelper;
import com.tencent.tuxmetersdk.export.config.TuxSurveyEvent;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.export.injector.event.RuleProcessInfo;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxThread;
import com.tencent.tuxmetersdk.export.listener.ITuxSelfTriggerListener;
import com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener;
import com.tencent.tuxmetersdk.export.listener.TriggerListenerHelper;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRule;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleType;
import com.tencent.tuxmetersdk.model.FrontSurvey;
import com.tencent.tuxmetersdk.model.Page;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Survey;
import com.tencent.tuxmetersdk.model.SurveyConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TriggerManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TuxTriggerManager";
    private final TuxDataManager dataManager;
    private final TuxDataStorage dataStorage;
    private final boolean debug;
    private final Handler deliveryHandler;
    private final ITuxLog logger;
    private final ITuxSurveyEventCallback surveyEventCallback;
    private final Runnable timerTriggerRunnableRef;
    private final Handler triggerHandler;
    private final ITuxTriggerListener triggerListener;
    private final TriggerListenerHelper triggerListenerHelper;
    private final TriggerState triggerState;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DeliveryHandler extends Handler {
        static IPatchRedirector $redirector_;

        /* synthetic */ DeliveryHandler(Looper looper, AnonymousClass1 anonymousClass1) {
            this(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper, (Object) anonymousClass1);
        }

        DeliveryHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class TimerTriggerTask implements Runnable {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "TuxTimerTriggerTask";

        TimerTriggerTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TriggerManager.this);
        }

        void callbackOnTimeTrigger() {
            if (!TriggerManager.this.isAnySurveyExpose() && !TriggerManager.this.isWaitingForRsp()) {
                try {
                    try {
                        TriggerManager.this.dataManager.getRwl().readLock().lock();
                        List<TuxEvent> list = TriggerManager.this.dataManager.getEventQueue().get();
                        TriggerManager triggerManager = TriggerManager.this;
                        triggerManager.process(list, triggerManager.dataManager.getTimerTriggerIndexAndJsonRuleMap(), TriggerManager.this.dataManager.getTriggerIndexAndChildJsonRulesMap(), null, false);
                    } catch (Exception e16) {
                        TriggerManager.this.logger.e(TAG, "triggerByTimePulse\u5f02\u5e38:" + e16.getLocalizedMessage());
                    }
                } finally {
                    TriggerManager.this.dataManager.getRwl().readLock().unlock();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                callbackOnTimeTrigger();
                TriggerManager.this.startTimePulseTrigger();
            }
        }

        /* synthetic */ TimerTriggerTask(TriggerManager triggerManager, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) triggerManager, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TriggerManagerHandler extends Handler {
        static IPatchRedirector $redirector_;

        /* synthetic */ TriggerManagerHandler(Looper looper, AnonymousClass1 anonymousClass1) {
            this(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper, (Object) anonymousClass1);
        }

        TriggerManagerHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
        }
    }

    public TriggerManager(TuxMeterSDKSetting tuxMeterSDKSetting, ITuxThread iTuxThread, TuxDataManager tuxDataManager, TuxDataStorage tuxDataStorage, TriggerListenerHelper triggerListenerHelper, ITuxTriggerListener iTuxTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tuxMeterSDKSetting, iTuxThread, tuxDataManager, tuxDataStorage, triggerListenerHelper, iTuxTriggerListener);
            return;
        }
        ITuxLog logger = tuxMeterSDKSetting.getLogger();
        this.logger = logger;
        this.debug = tuxMeterSDKSetting.isDebug();
        this.dataManager = tuxDataManager;
        this.dataStorage = tuxDataStorage;
        TriggerState triggerState = new TriggerState(logger);
        this.triggerState = triggerState;
        AnonymousClass1 anonymousClass1 = null;
        this.triggerHandler = new TriggerManagerHandler(iTuxThread.getTriggerLooper(), anonymousClass1);
        this.deliveryHandler = new DeliveryHandler(iTuxThread.getDeliveryLooper(), anonymousClass1);
        this.timerTriggerRunnableRef = new TimerTriggerTask(this, anonymousClass1);
        this.triggerListenerHelper = triggerListenerHelper;
        this.triggerListener = iTuxTriggerListener;
        this.surveyEventCallback = new TuxSurveyEventCallback(tuxMeterSDKSetting, iTuxThread, tuxDataManager, tuxDataStorage, triggerState);
    }

    private void afterProcess(TuxSurveyConfig tuxSurveyConfig, List<TuxEvent> list, ITuxTriggerListener iTuxTriggerListener, boolean z16) {
        tuxSurveyConfig.fixBh(list);
        this.surveyEventCallback.onDeliverWhenTrigger(tuxSurveyConfig);
        ITuxTriggerListener iTuxTriggerListener2 = this.triggerListener;
        if (iTuxTriggerListener == null) {
            iTuxTriggerListener = iTuxTriggerListener2;
        }
        getPersonalizedSurvey(tuxSurveyConfig, list, iTuxTriggerListener, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrontSurvey buildFrontSurveyBySurvey(Survey survey) {
        List<Question> questions;
        FrontSurvey frontSurvey = new FrontSurvey();
        if (survey == null) {
            return frontSurvey;
        }
        try {
            frontSurvey.setTitle(survey.getTitle());
            Survey deepCopy = survey.deepCopy();
            List<Page> pages = deepCopy.getPages();
            if (pages != null && !pages.isEmpty()) {
                Page page = pages.get(0);
                if (page != null && (questions = page.getQuestions()) != null && !questions.isEmpty()) {
                    Question question = questions.get(0);
                    questions.clear();
                    questions.add(question);
                }
                pages.clear();
                pages.add(page);
            }
            frontSurvey.setSurvey(deepCopy);
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "buildFrontSurveyBySurvey Exception" + e16.getMessage());
            }
        }
        return frontSurvey;
    }

    private boolean canDoAfterProcessSetWaiting(List<TuxEvent> list, TuxSurveyConfig tuxSurveyConfig, boolean z16) {
        if (tuxSurveyConfig.isPermanent()) {
            return true;
        }
        if (checkSurveyExposed(tuxSurveyConfig)) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "\u5f53\u524d\u95ee\u5377\u5df2\u7ecf\u66dd\u5149");
            }
            if (z16) {
                EventErrorHelper.reportEventExposed(this.surveyEventCallback, list, tuxSurveyConfig);
            }
            return false;
        }
        if (isAnySurveyExpose()) {
            ITuxLog iTuxLog2 = this.logger;
            if (iTuxLog2 != null) {
                iTuxLog2.e(TAG, "\u5df2\u7ecf\u66dd\u5149\u8fc7\u95ee\u5377\u4e86");
            }
            if (z16) {
                EventErrorHelper.reportEventExposed(this.surveyEventCallback, list, tuxSurveyConfig);
            }
            return false;
        }
        if (isWaitingForRsp()) {
            ITuxLog iTuxLog3 = this.logger;
            if (iTuxLog3 != null) {
                iTuxLog3.e(TAG, "\u5b58\u5728\u7b49\u5f85\u4e2d\u7684\u4e8b\u4ef6");
            }
            if (z16) {
                EventErrorHelper.reportEventWaiting(this.surveyEventCallback, list, tuxSurveyConfig);
            }
            return false;
        }
        if (isSilentPeriodCover(tuxSurveyConfig)) {
            if (z16) {
                EventErrorHelper.reportEventInSilent(this.surveyEventCallback, list, tuxSurveyConfig);
            }
            return false;
        }
        this.triggerState.setWaitingForRsp(Collections.singletonList(tuxSurveyConfig.getDeliveryId()));
        return true;
    }

    private boolean checkSurveyExposed(TuxSurveyConfig tuxSurveyConfig) {
        if (tuxSurveyConfig != null && tuxSurveyConfig.getSurvey() != null) {
            return this.dataManager.inExposedSurveySet(tuxSurveyConfig.getSurvey().getId());
        }
        return false;
    }

    private void getPersonalizedSurvey(TuxSurveyConfig tuxSurveyConfig, List<TuxEvent> list, ITuxTriggerListener iTuxTriggerListener, boolean z16) {
        this.deliveryHandler.post(new Runnable(tuxSurveyConfig, iTuxTriggerListener, z16, list) { // from class: com.tencent.tuxmetersdk.impl.TriggerManager.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ ITuxTriggerListener val$finalTempTriggerListener;
            final /* synthetic */ boolean val$needReportEvent;
            final /* synthetic */ TuxSurveyConfig val$surveyConfig;
            final /* synthetic */ List val$tuxEvents;

            {
                this.val$surveyConfig = tuxSurveyConfig;
                this.val$finalTempTriggerListener = iTuxTriggerListener;
                this.val$needReportEvent = z16;
                this.val$tuxEvents = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TriggerManager.this, tuxSurveyConfig, iTuxTriggerListener, Boolean.valueOf(z16), list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (TriggerManager.this.dataManager.getSDKConfig().isToggle()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        Survey personalizedSurvey = TriggerManager.this.dataManager.getPersonalizedSurvey(this.val$surveyConfig);
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (personalizedSurvey != null) {
                            this.val$surveyConfig.setSurvey(personalizedSurvey);
                            this.val$surveyConfig.setFrontSurvey(TriggerManager.this.buildFrontSurveyBySurvey(personalizedSurvey));
                            TriggerManager.this.surveyEventCallback.onDelayDeliver(this.val$surveyConfig, elapsedRealtime2);
                            if (TriggerManager.this.logger != null) {
                                TriggerManager.this.logger.i(TriggerManager.TAG, "\u6210\u529f\u89e6\u53d1onTrigger");
                            }
                            ITuxTriggerListener iTuxTriggerListener2 = this.val$finalTempTriggerListener;
                            if (iTuxTriggerListener2 != null) {
                                iTuxTriggerListener2.onTrigger(this.val$surveyConfig, TriggerManager.this.surveyEventCallback);
                            }
                            if (TriggerManager.this.triggerListenerHelper != null) {
                                TriggerManager.this.triggerListenerHelper.doTriggerListeners(this.val$surveyConfig, TriggerManager.this.surveyEventCallback);
                                return;
                            }
                            return;
                        }
                        Utils.doTriggerIfFailure(this.val$finalTempTriggerListener, "no_survey");
                        if (TriggerManager.this.logger != null) {
                            TriggerManager.this.logger.i(TriggerManager.TAG, "\u5b9e\u65f6\u62c9\u53d6\u95ee\u5377\u4e3anull");
                        }
                        TriggerManager.this.triggerState.setNotWaitingForRsp(this.val$surveyConfig.getDeliveryId());
                        return;
                    }
                    TriggerManager.this.surveyEventCallback.onDelayDeliver(this.val$surveyConfig, 0L);
                    if (TriggerManager.this.logger != null) {
                        TriggerManager.this.logger.i(TriggerManager.TAG, "\u6210\u529f\u89e6\u53d1onTrigger");
                    }
                    ITuxTriggerListener iTuxTriggerListener3 = this.val$finalTempTriggerListener;
                    if (iTuxTriggerListener3 != null) {
                        iTuxTriggerListener3.onTrigger(this.val$surveyConfig, TriggerManager.this.surveyEventCallback);
                    }
                    if (TriggerManager.this.triggerListenerHelper != null) {
                        TriggerManager.this.triggerListenerHelper.doTriggerListeners(this.val$surveyConfig, TriggerManager.this.surveyEventCallback);
                    }
                } catch (Exception e16) {
                    Utils.doTriggerIfFailure(this.val$finalTempTriggerListener, "exception");
                    if (TriggerManager.this.logger != null) {
                        TriggerManager.this.logger.e(TriggerManager.TAG, String.format("triggerListener.onTrigger\u5f02\u5e38: %s", e16.getLocalizedMessage()));
                    }
                    if (this.val$needReportEvent) {
                        EventErrorHelper.reportEventsException(TriggerManager.this.surveyEventCallback, this.val$tuxEvents, this.val$surveyConfig, e16.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedToReportEvent(TuxEvent tuxEvent) {
        Set<TuxEvent> needReportTuxEvents;
        TuxDataManager tuxDataManager = this.dataManager;
        if (tuxDataManager == null || tuxEvent == null || (needReportTuxEvents = tuxDataManager.getNeedReportTuxEvents()) == null) {
            return false;
        }
        Iterator<TuxEvent> it = needReportTuxEvents.iterator();
        while (it.hasNext()) {
            if (tuxEvent.contain(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean match(List<TuxEvent> list, JsonRule jsonRule) {
        if (jsonRule == null) {
            return false;
        }
        return jsonRule.match(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process(List<TuxEvent> list, Map<Integer, JsonRule> map, Map<Integer, List<JsonRule>> map2, ITuxTriggerListener iTuxTriggerListener, boolean z16) {
        ITuxLog iTuxLog;
        if (map != null && map.size() != 0) {
            TuxSurveyConfig satisfiedSurveyConfig = getSatisfiedSurveyConfig(list, map, map2);
            if (satisfiedSurveyConfig == null) {
                Utils.doTriggerIfFailure(iTuxTriggerListener, "satisfied_null");
                if (this.debug) {
                    for (JsonRule jsonRule : map.values()) {
                        if (jsonRule != null && jsonRule.getType() == JsonRuleType.EVENT && (iTuxLog = this.logger) != null) {
                            iTuxLog.e(TAG, "\u5339\u914d\u5931\u8d25\u89c4\u5219\uff1a" + jsonRule.getRuleStr());
                        }
                    }
                }
                if (z16) {
                    EventErrorHelper.reportEventSatisfiedFailed(this.surveyEventCallback, list, null);
                    return;
                }
                return;
            }
            if (canDoAfterProcessSetWaiting(list, satisfiedSurveyConfig, z16)) {
                afterProcess(satisfiedSurveyConfig, list, iTuxTriggerListener, z16);
                return;
            } else {
                Utils.doTriggerIfFailure(iTuxTriggerListener, "other");
                return;
            }
        }
        Utils.doTriggerIfFailure(iTuxTriggerListener, "data_null");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TuxSurveyConfig getSatisfiedSurveyConfig(List<TuxEvent> list, Map<Integer, JsonRule> map, Map<Integer, List<JsonRule>> map2) {
        ArrayList arrayList;
        Iterator<Map.Entry<Integer, JsonRule>> it;
        ArrayList arrayList2;
        Iterator<Map.Entry<Integer, JsonRule>> it5;
        boolean z16;
        List<JsonRule> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TuxSurveyConfig) iPatchRedirector.redirect((short) 6, this, list, map, map2);
        }
        TuxDataManager tuxDataManager = this.dataManager;
        if (tuxDataManager != null && tuxDataManager.getSurveyConfigs() != null && this.dataManager.getSurveyConfigs().size() != 0) {
            String uuid = UUID.randomUUID().toString();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<Map.Entry<Integer, JsonRule>> it6 = map.entrySet().iterator();
            boolean z17 = false;
            while (it6.hasNext()) {
                Map.Entry<Integer, JsonRule> next = it6.next();
                int intValue = next.getKey().intValue();
                JsonRule value = next.getValue();
                SurveyConfig surveyConfig = this.dataManager.getSurveyConfigs().get(intValue);
                if (surveyConfig != null && surveyConfig.isInValidityPeriod()) {
                    if (!match(list, value)) {
                        arrayList = arrayList4;
                        it = it6;
                    } else {
                        if (map2 != null && (list2 = map2.get(Integer.valueOf(intValue))) != null && list2.size() != 0) {
                            for (JsonRule jsonRule : list2) {
                                if (match(list, jsonRule)) {
                                    ArrayList arrayList5 = arrayList4;
                                    it5 = it6;
                                    double generateRandomNumber = Utils.generateRandomNumber(0.0d, 1.0d, 6);
                                    if (Utils.isLessThan(generateRandomNumber, jsonRule.getProbability())) {
                                        this.surveyEventCallback.onProcessRule(surveyConfig, new RuleProcessInfo.Builder().id(uuid).rule(jsonRule.getRuleStr()).probability(Double.valueOf(jsonRule.getProbability())).actualProbability(Double.valueOf(generateRandomNumber)).isFatherRule(Boolean.FALSE).isHitProbability(Boolean.TRUE).build());
                                        arrayList3.add(surveyConfig);
                                        arrayList2 = arrayList5;
                                        arrayList2.add(surveyConfig.getSurvey().getId());
                                    } else {
                                        arrayList2 = arrayList5;
                                        ITuxSurveyEventCallback iTuxSurveyEventCallback = this.surveyEventCallback;
                                        RuleProcessInfo.Builder actualProbability = new RuleProcessInfo.Builder().id(uuid).rule(jsonRule.getRuleStr()).probability(Double.valueOf(jsonRule.getProbability())).actualProbability(Double.valueOf(generateRandomNumber));
                                        Boolean bool = Boolean.FALSE;
                                        iTuxSurveyEventCallback.onProcessRule(surveyConfig, actualProbability.isFatherRule(bool).isHitProbability(bool).build());
                                    }
                                    z16 = true;
                                    if (z16) {
                                        double generateRandomNumber2 = Utils.generateRandomNumber(0.0d, 1.0d, 6);
                                        if (Utils.isLessThan(generateRandomNumber2, value.getProbability())) {
                                            ITuxSurveyEventCallback iTuxSurveyEventCallback2 = this.surveyEventCallback;
                                            RuleProcessInfo.Builder actualProbability2 = new RuleProcessInfo.Builder().id(uuid).rule(value.getRuleStr()).probability(Double.valueOf(value.getProbability())).actualProbability(Double.valueOf(generateRandomNumber2));
                                            Boolean bool2 = Boolean.TRUE;
                                            iTuxSurveyEventCallback2.onProcessRule(surveyConfig, actualProbability2.isFatherRule(bool2).isHitProbability(bool2).build());
                                            arrayList3.add(surveyConfig);
                                            arrayList2.add(surveyConfig.getSurvey().getId());
                                        } else {
                                            this.surveyEventCallback.onProcessRule(surveyConfig, new RuleProcessInfo.Builder().id(uuid).rule(value.getRuleStr()).probability(Double.valueOf(value.getProbability())).actualProbability(Double.valueOf(generateRandomNumber2)).isFatherRule(Boolean.TRUE).isHitProbability(Boolean.FALSE).build());
                                        }
                                    }
                                    arrayList4 = arrayList2;
                                    it6 = it5;
                                    z17 = true;
                                }
                            }
                        }
                        arrayList2 = arrayList4;
                        it5 = it6;
                        z16 = false;
                        if (z16) {
                        }
                        arrayList4 = arrayList2;
                        it6 = it5;
                        z17 = true;
                    }
                } else {
                    arrayList = arrayList4;
                    it = it6;
                    ITuxLog iTuxLog = this.logger;
                    if (iTuxLog != null) {
                        iTuxLog.e(TAG, "\u95ee\u5377\u8fc7\u671f");
                    }
                }
                arrayList4 = arrayList;
                it6 = it;
            }
            ArrayList arrayList6 = arrayList4;
            if (arrayList3.size() == 0) {
                if (z17) {
                    this.surveyEventCallback.onProcessRule(null, new RuleProcessInfo.Builder().id(uuid).build());
                    return null;
                }
                return null;
            }
            int generateRandomNumber3 = Utils.generateRandomNumber(0, arrayList3.size() - 1);
            SurveyConfig surveyConfig2 = (SurveyConfig) arrayList3.get(generateRandomNumber3);
            this.surveyEventCallback.onProcessRule(surveyConfig2, new RuleProcessInfo.Builder().id(uuid).candidateSurveyIDs(arrayList6).choseIndex(Integer.valueOf(generateRandomNumber3)).build());
            return surveyConfig2.transferToTuxSurveyConfig();
        }
        return null;
    }

    public ITuxSurveyEventCallback getSurveyEventCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ITuxSurveyEventCallback) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.surveyEventCallback;
    }

    public TriggerState getTriggerState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TriggerState) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.triggerState;
    }

    public boolean isAnySurveyExpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        TriggerState triggerState = this.triggerState;
        if (triggerState == null) {
            return true;
        }
        return triggerState.getIsAnySurveyExpose();
    }

    public boolean isSilentPeriodCover(TuxSurveyConfig tuxSurveyConfig) {
        ExposeInfo exposeInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) tuxSurveyConfig)).booleanValue();
        }
        if (tuxSurveyConfig != null && this.dataStorage != null) {
            try {
                if (tuxSurveyConfig.isWhite() || tuxSurveyConfig.isPermanent() || (exposeInfo = this.dataStorage.getExposeInfo()) == null) {
                    return false;
                }
                int silentPeriod = this.dataManager.getSDKConfig().getSilentPeriod();
                Date exposeTime = exposeInfo.getExposeTime();
                if (exposeTime == null) {
                    this.logger.i(TAG, "exposeInfo.exposeTime is null, remove expose info");
                    this.dataStorage.removeExposeInfo();
                    return false;
                }
                Date date = new Date();
                double diffHours = Utils.diffHours(date, exposeTime);
                this.logger.i(TAG, String.format("\u5f53\u524d\u65f6\u95f4: %s, \u6700\u8fd1\u4e00\u6b21\u95ee\u5377\u66dd\u5149\u65f6\u95f4: %s, \u76f8\u5dee\u5c0f\u65f6\u6570: %s", Utils.formatDate(date), Utils.formatDate(exposeTime), Double.valueOf(diffHours)));
                if (diffHours > 0.0d && diffHours < silentPeriod) {
                    return true;
                }
                if (diffHours > silentPeriod || diffHours < 0.0d) {
                    this.logger.i(TAG, String.format("\u66dd\u5149\u65f6\u95f4\u5dee\u5927\u4e8e%s\u5c0f\u65f6\u6216\u8005\u5c0f\u4e8e0, currentTime: %s, exposeTime: %s, remove expose info", Integer.valueOf(silentPeriod), Utils.formatDate(date), Utils.formatDate(exposeTime)));
                    this.dataStorage.removeExposeInfo();
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean isWaitingForRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        TriggerState triggerState = this.triggerState;
        if (triggerState == null) {
            return true;
        }
        return triggerState.getIsWaitingForRsp();
    }

    public void resetControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            try {
                this.dataManager.getRwl().readLock().lock();
                this.surveyEventCallback.onEventAction(TuxSurveyEvent.TUX_RESET_CONTROL, new HashMap());
                this.triggerState.resetControl();
            } catch (Exception e16) {
                ITuxLog iTuxLog = this.logger;
                if (iTuxLog != null) {
                    iTuxLog.e(TAG, "resetControl exception" + e16.getMessage());
                }
            }
        } finally {
            this.dataManager.getRwl().readLock().unlock();
        }
    }

    public void startTimePulseTrigger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            this.triggerHandler.removeCallbacks(this.timerTriggerRunnableRef);
            this.triggerHandler.postDelayed(this.timerTriggerRunnableRef, 1000L);
        } catch (Exception e16) {
            this.logger.e(TAG, "startTimePulseTrigger\u5f02\u5e38:" + e16.getLocalizedMessage());
        }
    }

    public void triggerByEvent(TuxEvent tuxEvent, ITuxTriggerListener iTuxTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tuxEvent, (Object) iTuxTriggerListener);
            return;
        }
        if (tuxEvent == null) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "\u8bf7\u786e\u4fdd\u8bbe\u7f6etrigger\u76d1\u4e8b\u4ef6");
            }
            Utils.doTriggerIfFailure(iTuxTriggerListener, "event_null");
            return;
        }
        this.triggerHandler.post(new Runnable(tuxEvent, iTuxTriggerListener) { // from class: com.tencent.tuxmetersdk.impl.TriggerManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ITuxTriggerListener val$inputTriggerListener;
            final /* synthetic */ TuxEvent val$tuxEvent;

            {
                this.val$tuxEvent = tuxEvent;
                this.val$inputTriggerListener = iTuxTriggerListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TriggerManager.this, tuxEvent, iTuxTriggerListener);
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
                    try {
                        TriggerManager.this.dataManager.getRwl().readLock().lock();
                    } catch (Exception e16) {
                        if (TriggerManager.this.logger != null) {
                            TriggerManager.this.logger.e(TriggerManager.TAG, "triggerByEvent\u5f02\u5e38:" + e16.getLocalizedMessage());
                        }
                        Utils.doTriggerIfFailure(this.val$inputTriggerListener, "exception");
                        EventErrorHelper.reportEventException(TriggerManager.this.surveyEventCallback, this.val$tuxEvent, null, e16.getMessage());
                    }
                    if (!TriggerManager.this.isNeedToReportEvent(this.val$tuxEvent)) {
                        if (TriggerManager.this.logger != null) {
                            TriggerManager.this.logger.e(TriggerManager.TAG, "\u4e8b\u4ef6\u4e0d\u5305\u542b\u5728\u914d\u7f6e\u4e2d");
                        }
                        Utils.doTriggerIfFailure(this.val$inputTriggerListener, "not_match");
                    } else {
                        TriggerManager.this.dataManager.getEventQueue().add(this.val$tuxEvent);
                        List<TuxEvent> list = TriggerManager.this.dataManager.getEventQueue().get();
                        TriggerManager triggerManager = TriggerManager.this;
                        triggerManager.process(list, triggerManager.dataManager.getEventRelatedEventTriggerIndexAndJsonRuleMap(this.val$tuxEvent), TriggerManager.this.dataManager.getTriggerIndexAndChildJsonRulesMap(), this.val$inputTriggerListener, true);
                    }
                } finally {
                    TriggerManager.this.dataManager.getRwl().readLock().unlock();
                }
            }
        });
    }

    public void triggerBySelf(String str, ITuxSelfTriggerListener iTuxSelfTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) iTuxSelfTriggerListener);
        } else if (str != null && iTuxSelfTriggerListener != null) {
            this.triggerHandler.post(new Runnable(iTuxSelfTriggerListener, str) { // from class: com.tencent.tuxmetersdk.impl.TriggerManager.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$sceneId;
                final /* synthetic */ ITuxSelfTriggerListener val$selfTriggerListener;

                {
                    this.val$selfTriggerListener = iTuxSelfTriggerListener;
                    this.val$sceneId = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TriggerManager.this, iTuxSelfTriggerListener, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList;
                    TuxSurveyConfig transferToTuxSurveyConfigWithTrigger;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!TriggerManager.this.isAnySurveyExpose() && !TriggerManager.this.isWaitingForRsp()) {
                        try {
                            try {
                                TriggerManager.this.dataManager.getRwl().readLock().lock();
                                arrayList = new ArrayList();
                                for (SurveyConfig surveyConfig : TriggerManager.this.dataManager.getSurveyConfigs()) {
                                    if (surveyConfig != null && surveyConfig.getResource() != null && surveyConfig.getResource().getSceneId() != null && surveyConfig.getResource().getSceneId().equals(this.val$sceneId) && surveyConfig.isInValidityPeriod() && (transferToTuxSurveyConfigWithTrigger = TriggerManager.this.dataManager.transferToTuxSurveyConfigWithTrigger(surveyConfig)) != null) {
                                        arrayList.add(transferToTuxSurveyConfigWithTrigger);
                                    }
                                }
                            } catch (Exception e16) {
                                TriggerManager.this.logger.e(TriggerManager.TAG, String.format("\u83b7\u53d6\u573a\u666fid\u4e3a%s\u7684\u95ee\u5377\u914d\u7f6e\u5931\u8d25, \u5f02\u5e38\u4fe1\u606f: %s", this.val$sceneId, e16.getLocalizedMessage()));
                            }
                            if (arrayList.size() == 0) {
                                this.val$selfTriggerListener.onSelfTrigger(null, null);
                                return;
                            }
                            TuxSurveyConfig tuxSurveyConfig = (TuxSurveyConfig) arrayList.get(Utils.generateRandomNumber(0, arrayList.size() - 1));
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(tuxSurveyConfig.getDeliveryId());
                            TriggerManager.this.triggerState.setWaitingForRsp(arrayList2);
                            TriggerManager.this.deliveryHandler.post(new Runnable(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TriggerManager.2.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ TuxSurveyConfig val$finalSurveyConfig;

                                {
                                    this.val$finalSurveyConfig = tuxSurveyConfig;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) tuxSurveyConfig);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    try {
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        ArrayList arrayList3 = new ArrayList();
                                        if (TriggerManager.this.dataManager.getSDKConfig().isToggle()) {
                                            Survey personalizedSurvey = TriggerManager.this.dataManager.getPersonalizedSurvey(this.val$finalSurveyConfig);
                                            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                                            if (personalizedSurvey != null) {
                                                this.val$finalSurveyConfig.setSurvey(personalizedSurvey);
                                                this.val$finalSurveyConfig.setFrontSurvey(TriggerManager.this.buildFrontSurveyBySurvey(personalizedSurvey));
                                                TriggerManager.this.surveyEventCallback.onDelayDeliver(this.val$finalSurveyConfig, elapsedRealtime2);
                                                arrayList3.add(this.val$finalSurveyConfig);
                                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                                anonymousClass2.val$selfTriggerListener.onSelfTrigger(arrayList3, TriggerManager.this.surveyEventCallback);
                                                return;
                                            }
                                            TriggerManager.this.triggerState.setNotWaitingForRsp(this.val$finalSurveyConfig.getDeliveryId());
                                            return;
                                        }
                                        TriggerManager.this.surveyEventCallback.onDelayDeliver(this.val$finalSurveyConfig, 0L);
                                        arrayList3.add(this.val$finalSurveyConfig);
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        anonymousClass22.val$selfTriggerListener.onSelfTrigger(arrayList3, TriggerManager.this.surveyEventCallback);
                                    } catch (Exception e17) {
                                        TriggerManager.this.logger.e(TriggerManager.TAG, String.format("selfTriggerListener.onSelfTrigger\u5f02\u5e38: %s", e17.getLocalizedMessage()));
                                    }
                                }
                            });
                            return;
                        } finally {
                            TriggerManager.this.dataManager.getRwl().readLock().unlock();
                        }
                    }
                    this.val$selfTriggerListener.onSelfTrigger(null, null);
                }
            });
        }
    }
}

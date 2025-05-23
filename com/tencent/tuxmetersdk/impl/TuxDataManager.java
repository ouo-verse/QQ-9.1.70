package com.tencent.tuxmetersdk.impl;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.tuxmetersdk.BuildConfig;
import com.tencent.tuxmetersdk.export.config.TuxConstants;
import com.tencent.tuxmetersdk.export.config.TuxSurveyEvent;
import com.tencent.tuxmetersdk.export.injector.event.ITuxRemoteEventReport;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxThread;
import com.tencent.tuxmetersdk.export.listener.ITuxInitSDKListener;
import com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener;
import com.tencent.tuxmetersdk.export.listener.ITuxSubmitAnswerListener;
import com.tencent.tuxmetersdk.impl.event.EventType;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRule;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleEngine;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleType;
import com.tencent.tuxmetersdk.model.ChildTrigger;
import com.tencent.tuxmetersdk.model.GetConfigReq;
import com.tencent.tuxmetersdk.model.GetConfigRsp;
import com.tencent.tuxmetersdk.model.InitReq;
import com.tencent.tuxmetersdk.model.InitRsp;
import com.tencent.tuxmetersdk.model.PersonalizedSurveyReq;
import com.tencent.tuxmetersdk.model.PersonalizedSurveyRsp;
import com.tencent.tuxmetersdk.model.SignInfo;
import com.tencent.tuxmetersdk.model.Survey;
import com.tencent.tuxmetersdk.model.SurveyConfig;
import com.tencent.tuxmetersdk.model.SurveyReportReq;
import com.tencent.tuxmetersdk.model.SurveyReportRsp;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.Nullable;
import retrofit2.ab;
import retrofit2.d;
import retrofit2.f;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxDataManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TuxDataManager";
    private final TuxBackEndService dataFetcher;
    private final TuxDataStorage dataStorage;
    private Map<TuxEvent, Set<Integer>> eventAndEventTriggerIndexesMap;
    private final EventQueue eventQueue;
    private Map<Integer, JsonRule> eventTriggerIndexAndJsonRuleMap;
    private Set<String> exposedSurveyIdSets;
    private final JsonRuleEngine jsonRuleEngine;
    private final ITuxLog logger;
    private Set<TuxEvent> needReportTuxEvents;
    private final ReentrantReadWriteLock rwl;
    private SDKConfig sdkConfig;
    private long serverTimeGap;
    private final TuxMeterSDKSetting setting;
    private ITuxStorage storageImpl;
    private List<SurveyConfig> surveyConfigs;
    private final Map<String, Date> surveyFirstClickClientTime;
    private final Map<String, Date> surveyFirstClickServerTime;
    private final ITuxThread threadImpl;
    private Map<Integer, JsonRule> timerTriggerIndexAndJsonRuleMap;
    private Map<Integer, List<JsonRule>> triggerIndexAndChildJsonRulesMap;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class InitSDKTask extends TuxSoftTask<TuxBackEndService> {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "TuxInitSDKTask";
        private final WeakReference<ITuxInitSDKListener> initListenerRef;
        private final ITuxLog logger;
        private final InitReq req;
        private TuxMeterSDKSetting setting;

        protected InitSDKTask(TuxBackEndService tuxBackEndService, InitReq initReq, WeakReference<ITuxInitSDKListener> weakReference, TuxMeterSDKSetting tuxMeterSDKSetting) {
            super(tuxBackEndService);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, tuxBackEndService, initReq, weakReference, tuxMeterSDKSetting);
                return;
            }
            this.setting = tuxMeterSDKSetting;
            this.logger = tuxMeterSDKSetting.getLogger();
            this.req = initReq;
            this.initListenerRef = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TuxBackEndService ref = getRef();
            ITuxInitSDKListener iTuxInitSDKListener = this.initListenerRef.get();
            if (ref != null) {
                this.logger.i(TAG, "init\u8bf7\u6c42\u53c2\u6570: " + new Gson().toJson(this.req));
                ref.initSDK(this.req, new f<InitRsp>(iTuxInitSDKListener) { // from class: com.tencent.tuxmetersdk.impl.TuxDataManager.InitSDKTask.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ITuxInitSDKListener val$initListenerRef;

                    {
                        this.val$initListenerRef = iTuxInitSDKListener;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InitSDKTask.this, (Object) iTuxInitSDKListener);
                        }
                    }

                    @Override // retrofit2.f
                    public void onFailure(d<InitRsp> dVar, Throwable th5) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                            InitSDKTask.this.logger.e(InitSDKTask.TAG, "initSDK\u56de\u8c03\u5931\u8d25\uff1a" + th5.getMessage());
                            ITuxInitSDKListener iTuxInitSDKListener2 = this.val$initListenerRef;
                            if (iTuxInitSDKListener2 != null) {
                                iTuxInitSDKListener2.onFailure(10000, th5.getMessage());
                                return;
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) dVar, (Object) th5);
                    }

                    @Override // retrofit2.f
                    public void onResponse(d<InitRsp> dVar, ab<InitRsp> abVar) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar, (Object) abVar);
                            return;
                        }
                        InitRsp a16 = abVar.a();
                        if (!abVar.d() || a16 == null || a16.getCode() == null || a16.getCode().intValue() != 0 || !Utils.isValidSignInfo(a16.getSignInfo()) || !Utils.isValidBeaconInfo(a16.getBeaconInfo())) {
                            InitSDKTask.this.logger.e(InitSDKTask.TAG, "init rsp\u5f02\u5e38: " + new Gson().toJson(a16));
                            if (this.val$initListenerRef != null) {
                                int i3 = 10000;
                                String str = TuxConstants.ERROR_MSG;
                                if (a16 != null) {
                                    if (a16.getCode() != null) {
                                        i3 = a16.getCode().intValue();
                                    }
                                    if (a16.getMsg() != null) {
                                        str = a16.getMsg();
                                    }
                                }
                                this.val$initListenerRef.onFailure(i3, str);
                                return;
                            }
                            return;
                        }
                        InitSDKTask.this.logger.i(InitSDKTask.TAG, "init\u6210\u529f");
                        ITuxInitSDKListener iTuxInitSDKListener2 = this.val$initListenerRef;
                        if (iTuxInitSDKListener2 != null) {
                            iTuxInitSDKListener2.onSuccess(a16.isSuccess(), new SDKConfig(a16.isWhite(), a16.getSignInfo(), a16.getBeaconInfo(), a16.getSilentPeriod(), a16.isToggle(), a16.isContainPermanent()));
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class PreUploadSurveyTask extends TuxSoftTask<TuxBackEndService> {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "TuxPreUploadSurveyTask";
        private final String business;
        private final TuxDataManager dataManager;
        private final ITuxLog logger;
        private final SurveyReportReq req;
        private final SignInfo signInfo;
        private final WeakReference<ITuxSubmitAnswerListener> submitAnswerListenerWeakRef;

        protected PreUploadSurveyTask(TuxDataManager tuxDataManager, SurveyReportReq surveyReportReq, WeakReference<ITuxSubmitAnswerListener> weakReference) {
            super(tuxDataManager.dataFetcher);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, tuxDataManager, surveyReportReq, weakReference);
                return;
            }
            this.req = surveyReportReq;
            this.submitAnswerListenerWeakRef = weakReference;
            this.logger = tuxDataManager.logger;
            this.signInfo = tuxDataManager.sdkConfig.getSignInfo();
            this.business = tuxDataManager.setting.getAppId();
            this.dataManager = tuxDataManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TuxBackEndService ref = getRef();
            ITuxSubmitAnswerListener iTuxSubmitAnswerListener = this.submitAnswerListenerWeakRef.get();
            if (ref != null) {
                ref.surveyReportPre(this.business, Utils.generateToken(this.signInfo, this.dataManager.getServerTime()), this.req, new f<SurveyReportRsp>(iTuxSubmitAnswerListener) { // from class: com.tencent.tuxmetersdk.impl.TuxDataManager.PreUploadSurveyTask.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ITuxSubmitAnswerListener val$submitAnswerListenerWeakRef;

                    {
                        this.val$submitAnswerListenerWeakRef = iTuxSubmitAnswerListener;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreUploadSurveyTask.this, (Object) iTuxSubmitAnswerListener);
                        }
                    }

                    @Override // retrofit2.f
                    public void onFailure(d<SurveyReportRsp> dVar, Throwable th5) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                            PreUploadSurveyTask.this.logger.e(PreUploadSurveyTask.TAG, "surveyReportPre\u56de\u8c03\u5931\u8d25\uff1a" + th5.getMessage());
                            ITuxSubmitAnswerListener iTuxSubmitAnswerListener2 = this.val$submitAnswerListenerWeakRef;
                            if (iTuxSubmitAnswerListener2 != null) {
                                iTuxSubmitAnswerListener2.onFailure();
                                return;
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) dVar, (Object) th5);
                    }

                    @Override // retrofit2.f
                    public void onResponse(d<SurveyReportRsp> dVar, ab<SurveyReportRsp> abVar) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar, (Object) abVar);
                            return;
                        }
                        SurveyReportRsp a16 = abVar.a();
                        if (!abVar.d() || a16 == null || a16.getCode() == null || a16.getCode().intValue() != 0) {
                            PreUploadSurveyTask.this.logger.e(PreUploadSurveyTask.TAG, "\u9884\u63d0\u4ea4\u95ee\u5377rsp\u5f02\u5e38: " + new Gson().toJson(a16));
                            ITuxSubmitAnswerListener iTuxSubmitAnswerListener2 = this.val$submitAnswerListenerWeakRef;
                            if (iTuxSubmitAnswerListener2 != null) {
                                iTuxSubmitAnswerListener2.onFailure();
                                return;
                            }
                            return;
                        }
                        PreUploadSurveyTask.this.logger.i(PreUploadSurveyTask.TAG, "\u6210\u529f\u63d0\u4ea4\u95ee\u5377");
                        ITuxSubmitAnswerListener iTuxSubmitAnswerListener3 = this.val$submitAnswerListenerWeakRef;
                        if (iTuxSubmitAnswerListener3 != null) {
                            iTuxSubmitAnswerListener3.onSuccess();
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class RefreshSurveyConfigTask extends TuxSoftTask<TuxBackEndService> {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "TuxRefreshSurveyConfigTask";
        private final ITuxLog logger;
        private final WeakReference<ITuxRefreshListener> refreshListenerRef;
        private final GetConfigReq req;

        protected RefreshSurveyConfigTask(TuxBackEndService tuxBackEndService, GetConfigReq getConfigReq, WeakReference<ITuxRefreshListener> weakReference, ITuxLog iTuxLog) {
            super(tuxBackEndService);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, tuxBackEndService, getConfigReq, weakReference, iTuxLog);
                return;
            }
            this.req = getConfigReq;
            this.logger = iTuxLog;
            this.refreshListenerRef = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TuxBackEndService ref = getRef();
            ITuxRefreshListener iTuxRefreshListener = this.refreshListenerRef.get();
            if (ref != null) {
                ref.getSurveyConfig(this.req, new f<GetConfigRsp>(iTuxRefreshListener) { // from class: com.tencent.tuxmetersdk.impl.TuxDataManager.RefreshSurveyConfigTask.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ITuxRefreshListener val$refreshListenerRef;

                    {
                        this.val$refreshListenerRef = iTuxRefreshListener;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RefreshSurveyConfigTask.this, (Object) iTuxRefreshListener);
                        }
                    }

                    @Override // retrofit2.f
                    public void onFailure(d<GetConfigRsp> dVar, Throwable th5) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                            RefreshSurveyConfigTask.this.logger.e(RefreshSurveyConfigTask.TAG, "getSurveyConfig\u56de\u8c03\u5931\u8d25\uff1a" + th5.getMessage());
                            ITuxRefreshListener iTuxRefreshListener2 = this.val$refreshListenerRef;
                            if (iTuxRefreshListener2 != null) {
                                iTuxRefreshListener2.onFailure(10000, th5.getMessage());
                                return;
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) dVar, (Object) th5);
                    }

                    @Override // retrofit2.f
                    public void onResponse(d<GetConfigRsp> dVar, ab<GetConfigRsp> abVar) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar, (Object) abVar);
                            return;
                        }
                        GetConfigRsp a16 = abVar.a();
                        if (abVar.d() && a16 != null && a16.getConfig() != null && a16.getCode() != null && a16.getCode().intValue() == 0) {
                            if (a16.getConfig().size() == 0) {
                                RefreshSurveyConfigTask.this.logger.i(RefreshSurveyConfigTask.TAG, "\u95ee\u5377\u914d\u7f6e\u4e3a\u7a7a");
                            }
                            RefreshSurveyConfigTask.this.logger.i(RefreshSurveyConfigTask.TAG, "\u6210\u529f\u83b7\u53d6\u95ee\u5377\u914d\u7f6e");
                            ITuxRefreshListener iTuxRefreshListener2 = this.val$refreshListenerRef;
                            if (iTuxRefreshListener2 != null) {
                                iTuxRefreshListener2.onSuccess(a16.getConfig(), a16.getUnixMilli(), a16.getExpiredTime());
                                return;
                            }
                            return;
                        }
                        String str = "\u95ee\u5377\u914d\u7f6ersp\u5f02\u5e38: " + new Gson().toJson(a16);
                        RefreshSurveyConfigTask.this.logger.e(RefreshSurveyConfigTask.TAG, str);
                        if (this.val$refreshListenerRef != null) {
                            int i3 = 10000;
                            if (a16 != null) {
                                if (a16.getCode() != null) {
                                    i3 = a16.getCode().intValue();
                                }
                                if (a16.getMsg() != null) {
                                    str = a16.getMsg();
                                }
                            }
                            this.val$refreshListenerRef.onFailure(i3, str);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class UploadSurveyTask extends TuxSoftTask<TuxBackEndService> {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "TuxUploadSurveyTask";
        private final String business;
        private final TuxDataManager dataManager;
        private final ITuxLog logger;
        private final SurveyReportReq req;
        private final SignInfo signInfo;
        private final WeakReference<ITuxSubmitAnswerListener> submitAnswerListenerWeakRef;

        protected UploadSurveyTask(TuxDataManager tuxDataManager, SurveyReportReq surveyReportReq, WeakReference<ITuxSubmitAnswerListener> weakReference) {
            super(tuxDataManager.dataFetcher);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, tuxDataManager, surveyReportReq, weakReference);
                return;
            }
            this.req = surveyReportReq;
            this.submitAnswerListenerWeakRef = weakReference;
            this.signInfo = tuxDataManager.getSDKConfig().getSignInfo();
            this.logger = tuxDataManager.logger;
            this.business = tuxDataManager.setting.getAppId();
            this.dataManager = tuxDataManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TuxBackEndService ref = getRef();
            ITuxSubmitAnswerListener iTuxSubmitAnswerListener = this.submitAnswerListenerWeakRef.get();
            if (ref != null) {
                ref.surveyReport(this.business, Utils.generateToken(this.signInfo, this.dataManager.getServerTime()), this.req, new f<SurveyReportRsp>(iTuxSubmitAnswerListener) { // from class: com.tencent.tuxmetersdk.impl.TuxDataManager.UploadSurveyTask.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ITuxSubmitAnswerListener val$submitAnswerListenerWeakRef;

                    {
                        this.val$submitAnswerListenerWeakRef = iTuxSubmitAnswerListener;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadSurveyTask.this, (Object) iTuxSubmitAnswerListener);
                        }
                    }

                    @Override // retrofit2.f
                    public void onFailure(d<SurveyReportRsp> dVar, Throwable th5) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                            UploadSurveyTask.this.logger.e(UploadSurveyTask.TAG, "surveyReport\u56de\u8c03\u5931\u8d25\uff1a" + th5.getMessage());
                            ITuxSubmitAnswerListener iTuxSubmitAnswerListener2 = this.val$submitAnswerListenerWeakRef;
                            if (iTuxSubmitAnswerListener2 != null) {
                                iTuxSubmitAnswerListener2.onFailure();
                                return;
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) dVar, (Object) th5);
                    }

                    @Override // retrofit2.f
                    public void onResponse(d<SurveyReportRsp> dVar, ab<SurveyReportRsp> abVar) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar, (Object) abVar);
                            return;
                        }
                        SurveyReportRsp a16 = abVar.a();
                        if (!abVar.d() || a16 == null || a16.getCode() == null || a16.getCode().intValue() != 0) {
                            UploadSurveyTask.this.logger.e(UploadSurveyTask.TAG, "\u63d0\u4ea4\u95ee\u5377rsp\u5f02\u5e38: " + new Gson().toJson(a16));
                            ITuxSubmitAnswerListener iTuxSubmitAnswerListener2 = this.val$submitAnswerListenerWeakRef;
                            if (iTuxSubmitAnswerListener2 != null) {
                                iTuxSubmitAnswerListener2.onFailure();
                                return;
                            }
                            return;
                        }
                        UploadSurveyTask.this.logger.i(UploadSurveyTask.TAG, "\u6210\u529f\u63d0\u4ea4\u95ee\u5377");
                        ITuxSubmitAnswerListener iTuxSubmitAnswerListener3 = this.val$submitAnswerListenerWeakRef;
                        if (iTuxSubmitAnswerListener3 != null) {
                            iTuxSubmitAnswerListener3.onSuccess();
                        }
                    }
                });
            }
        }
    }

    public TuxDataManager(TuxMeterSDKSetting tuxMeterSDKSetting, ITuxThread iTuxThread, TuxDataStorage tuxDataStorage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tuxMeterSDKSetting, iTuxThread, tuxDataStorage);
            return;
        }
        this.rwl = new ReentrantReadWriteLock();
        this.surveyFirstClickServerTime = new ConcurrentHashMap();
        this.surveyFirstClickClientTime = new ConcurrentHashMap();
        this.surveyConfigs = new ArrayList();
        this.eventTriggerIndexAndJsonRuleMap = new HashMap();
        this.timerTriggerIndexAndJsonRuleMap = new HashMap();
        this.triggerIndexAndChildJsonRulesMap = new HashMap();
        this.needReportTuxEvents = new HashSet();
        this.eventAndEventTriggerIndexesMap = new HashMap();
        this.exposedSurveyIdSets = new HashSet();
        this.setting = tuxMeterSDKSetting;
        this.logger = tuxMeterSDKSetting.getLogger();
        this.threadImpl = iTuxThread;
        if (iTuxThread != null) {
            this.dataFetcher = new TuxBackEndService(tuxMeterSDKSetting, iTuxThread);
        } else {
            this.dataFetcher = null;
        }
        this.storageImpl = null;
        this.eventQueue = new EventQueue();
        this.jsonRuleEngine = new JsonRuleEngine(tuxMeterSDKSetting.getLogger());
        this.dataStorage = tuxDataStorage;
    }

    private void clearData() {
        this.timerTriggerIndexAndJsonRuleMap.clear();
        this.eventTriggerIndexAndJsonRuleMap.clear();
        this.eventAndEventTriggerIndexesMap.clear();
        this.triggerIndexAndChildJsonRulesMap.clear();
        this.needReportTuxEvents.clear();
    }

    public static SurveyConfig deepCopySurveyConfig(SurveyConfig surveyConfig) {
        Gson createGson = Utils.createGson();
        return (SurveyConfig) createGson.fromJson(createGson.toJson(surveyConfig), SurveyConfig.class);
    }

    private GetConfigReq generateGetSurveyConfigReq() {
        GetConfigReq getConfigReq = new GetConfigReq();
        getConfigReq.setBusiness(this.setting.getAppId());
        getConfigReq.setUserId(this.setting.getUid());
        getConfigReq.setAppVersion(this.setting.getAppVersion());
        getConfigReq.setSdkVersion(BuildConfig.VERSION);
        getConfigReq.setMachine(this.setting.getMobileModel());
        getConfigReq.setSilent(isInSilent());
        getConfigReq.setZoneId(this.setting.getZoneId());
        return getConfigReq;
    }

    private InitReq generateInitReq() {
        InitReq initReq = new InitReq();
        initReq.setAppVersion(this.setting.getAppVersion());
        initReq.setBusiness(this.setting.getAppId());
        initReq.setAppKey(this.setting.getAppKey());
        initReq.setUserId(this.setting.getUid());
        initReq.setMachine(this.setting.getMobileModel());
        initReq.setSdkVersion(BuildConfig.VERSION);
        initReq.setZoneId(this.setting.getZoneId());
        return initReq;
    }

    private boolean isInSilent() {
        SDKConfig sDKConfig;
        Date exposeTime;
        if (this.dataStorage != null && (sDKConfig = this.sdkConfig) != null) {
            try {
                int silentPeriod = sDKConfig.getSilentPeriod();
                ExposeInfo exposeInfo = this.dataStorage.getExposeInfo();
                if (exposeInfo == null || (exposeTime = exposeInfo.getExposeTime()) == null) {
                    return false;
                }
                double diffHours = Utils.diffHours(new Date(), exposeTime);
                if (diffHours > 0.0d && diffHours < silentPeriod) {
                    return true;
                }
            } catch (Exception e16) {
                this.logger.e(TAG, "isInSilent:" + e16.getLocalizedMessage());
            }
        }
        return false;
    }

    private void populateEventAndEventTriggerIndexesMap(int i3, Set<TuxEvent> set) {
        for (TuxEvent tuxEvent : set) {
            if (this.eventAndEventTriggerIndexesMap.get(tuxEvent) == null) {
                this.eventAndEventTriggerIndexesMap.put(tuxEvent, new HashSet());
            }
            this.eventAndEventTriggerIndexesMap.get(tuxEvent).add(Integer.valueOf(i3));
        }
    }

    private void report(String str, Map<String, String> map) {
        TuxMeterSDKSetting tuxMeterSDKSetting = this.setting;
        if (tuxMeterSDKSetting != null && tuxMeterSDKSetting.getBeaconReporter() != null) {
            ITuxRemoteEventReport beaconReporter = this.setting.getBeaconReporter();
            if (getSDKConfig() != null && Utils.isValidBeaconInfo(getSDKConfig().getBeaconInfo())) {
                beaconReporter.report(getSDKConfig().getBeaconInfo().getAppkey(), EventType.REALTIME, str, map);
            } else {
                this.logger.i(TAG, "beacon appkey is null, fail to report survey event");
            }
        }
    }

    private void reportParseSurveyFailEvent(SurveyConfig surveyConfig, String str, String str2) {
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(surveyConfig, this.setting);
        generateBasicEventParams.put("field", String.valueOf(str));
        generateBasicEventParams.put("field_value", String.valueOf(str2));
        this.logger.i(TAG, "report ParseSurveyFailEvent");
        report(TuxSurveyEvent.PARSE_FAIL, generateBasicEventParams);
    }

    protected void execWorkTask(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) runnable);
            return;
        }
        ITuxThread iTuxThread = this.threadImpl;
        if (iTuxThread != null) {
            iTuxThread.execWorkTask(runnable);
        }
    }

    public void fixTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, j3);
        } else {
            setServerTimeGap(j3 - new Date().getTime());
        }
    }

    public EventQueue getEventQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EventQueue) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.eventQueue;
    }

    public Map<Integer, JsonRule> getEventRelatedEventTriggerIndexAndJsonRuleMap(TuxEvent tuxEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Map) iPatchRedirector.redirect((short) 18, (Object) this, (Object) tuxEvent);
        }
        if (tuxEvent == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (Map.Entry<TuxEvent, Set<Integer>> entry : this.eventAndEventTriggerIndexesMap.entrySet()) {
            if (tuxEvent.contain(entry.getKey())) {
                hashSet.addAll(entry.getValue());
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            JsonRule jsonRule = this.eventTriggerIndexAndJsonRuleMap.get(Integer.valueOf(intValue));
            if (jsonRule != null) {
                hashMap.put(Integer.valueOf(intValue), jsonRule);
            }
        }
        return hashMap;
    }

    public Set<TuxEvent> getNeedReportTuxEvents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.needReportTuxEvents;
    }

    public Survey getPersonalizedSurvey(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Survey) iPatchRedirector.redirect((short) 23, (Object) this, (Object) tuxSurveyConfig);
        }
        if (tuxSurveyConfig == null || tuxSurveyConfig.getSurvey() == null) {
            return null;
        }
        String id5 = tuxSurveyConfig.getSurvey().getId();
        PersonalizedSurveyReq personalizedSurveyReq = new PersonalizedSurveyReq(this.setting.getAppId(), id5, this.setting.getUid());
        personalizedSurveyReq.setWhite(tuxSurveyConfig.isWhite());
        personalizedSurveyReq.setPf(tuxSurveyConfig.getPf());
        personalizedSurveyReq.setPermanent(tuxSurveyConfig.isPermanent());
        personalizedSurveyReq.setBh(tuxSurveyConfig.getBh());
        personalizedSurveyReq.setZoneId(this.setting.getZoneId());
        long currentTimeMillis = System.currentTimeMillis();
        PersonalizedSurveyRsp personalizedSurvey = this.dataFetcher.getPersonalizedSurvey(personalizedSurveyReq);
        long currentTimeMillis2 = System.currentTimeMillis();
        String valueOf = String.valueOf(currentTimeMillis2 - currentTimeMillis);
        if (personalizedSurvey != null && personalizedSurvey.getLegacy() != null && personalizedSurvey.getCode() != null && personalizedSurvey.getCode().intValue() == 0) {
            Survey legacy = personalizedSurvey.getLegacy();
            legacy.setId(id5);
            this.logger.i(TAG, "getPersonalizedSurvey-\u6210\u529f\u83b7\u53d6\u95ee\u5377");
            return legacy;
        }
        Map<String, String> generateBasicEventParams = Utils.generateBasicEventParams(this.setting);
        generateBasicEventParams.put(DTConstants.TAG.API, "inapp");
        generateBasicEventParams.put("start_time", String.valueOf(currentTimeMillis));
        generateBasicEventParams.put("end_time", String.valueOf(currentTimeMillis2));
        generateBasicEventParams.put("time", valueOf);
        if (personalizedSurvey != null && personalizedSurvey.getCode().intValue() == 0 && personalizedSurvey.getLegacy() == null) {
            generateBasicEventParams.put("code", "0");
            generateBasicEventParams.put("tux_error_info", "legacy_null");
        } else if (personalizedSurvey != null && personalizedSurvey.getLegacy() == null) {
            generateBasicEventParams.put("code", String.valueOf(personalizedSurvey.getCode()));
            generateBasicEventParams.put("tux_error_info", personalizedSurvey.getMsg());
        }
        generateBasicEventParams.put("status", "1");
        this.logger.e(TAG, "getPersonalizedSurvey-\u95ee\u5377\u83b7\u53d6\u5f02\u5e38: " + new Gson().toJson(personalizedSurvey));
        Utils.report(this.setting, getSDKConfig().getBeaconInfo().getAppkey(), TuxSurveyEvent.CALL_BACKEND_API, generateBasicEventParams);
        return null;
    }

    public ReentrantReadWriteLock getRwl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ReentrantReadWriteLock) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.rwl;
    }

    public SDKConfig getSDKConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (SDKConfig) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.sdkConfig;
    }

    public Date getServerTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Date) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return new Date(new Date().getTime() + getServerTimeGap());
    }

    public long getServerTimeGap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.serverTimeGap;
    }

    public List<SurveyConfig> getSurveyConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.surveyConfigs;
    }

    public Map<String, Date> getSurveyFirstClickClientTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.surveyFirstClickClientTime;
    }

    public Map<String, Date> getSurveyFirstClickServerTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.surveyFirstClickServerTime;
    }

    public Map<Integer, JsonRule> getTimerTriggerIndexAndJsonRuleMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.timerTriggerIndexAndJsonRuleMap;
    }

    public Map<Integer, List<JsonRule>> getTriggerIndexAndChildJsonRulesMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Map) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.triggerIndexAndChildJsonRulesMap;
    }

    public boolean inExposedSurveySet(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        return this.exposedSurveyIdSets.contains(str);
    }

    public void initSDK(ITuxInitSDKListener iTuxInitSDKListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) iTuxInitSDKListener);
            return;
        }
        execWorkTask(new InitSDKTask(this.dataFetcher, generateInitReq(), new WeakReference(iTuxInitSDKListener), this.setting));
    }

    public ChildTrigger parseChildJsonRules(String str, JsonParser jsonParser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ChildTrigger) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) jsonParser);
        }
        double d16 = 1.0d;
        ChildTrigger childTrigger = new ChildTrigger(1.0d);
        if (str != null && !str.trim().equals("")) {
            ArrayList arrayList = new ArrayList();
            try {
                JsonObject asJsonObject = jsonParser.parse(str).getAsJsonObject();
                JsonElement jsonElement = asJsonObject.get("default_probability");
                if (jsonElement != null) {
                    d16 = jsonElement.getAsDouble();
                }
                JsonElement jsonElement2 = asJsonObject.get("details");
                if (jsonElement2 != null) {
                    Iterator<JsonElement> it = jsonElement2.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject2 = it.next().getAsJsonObject();
                        traverseMultiDimensionProbability(asJsonObject2.get("rule_template").getAsString(), asJsonObject2.get("probability"), new ArrayList(), asJsonObject2.get("dimensions").getAsJsonArray(), arrayList);
                    }
                }
                childTrigger.setDefaultProbability(d16);
                childTrigger.setJsonRules(arrayList);
                return childTrigger;
            } catch (Exception e16) {
                this.logger.e(TAG, String.format("childTrigger\u89e3\u6790\u5931\u8d25\uff1a%s\uff0cchildTrigger: %s", e16.getLocalizedMessage(), str));
                return null;
            }
        }
        return childTrigger;
    }

    public void parseSurveyConfig(List<SurveyConfig> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) list);
            return;
        }
        clearData();
        ArrayList arrayList = new ArrayList();
        JsonParser jsonParser = new JsonParser();
        for (int i3 = 0; i3 < list.size(); i3++) {
            SurveyConfig surveyConfig = list.get(i3);
            if (surveyConfig != null) {
                String str = new String(Base64.decode(surveyConfig.getTrigger(), 0), StandardCharsets.UTF_8);
                ChildTrigger parseChildJsonRules = parseChildJsonRules(surveyConfig.getChildTrigger(), jsonParser);
                if (parseChildJsonRules == null) {
                    reportParseSurveyFailEvent(surveyConfig, "child_trigger", "child_trigger\u89e3\u6790\u5931\u8d25");
                } else {
                    JsonRule parseOneWithJsonString = this.jsonRuleEngine.parseOneWithJsonString(str, parseChildJsonRules.getDefaultProbability());
                    if (parseOneWithJsonString == null) {
                        reportParseSurveyFailEvent(surveyConfig, "trigger", str);
                    } else {
                        Set<TuxEvent> relatedEvents = parseOneWithJsonString.getRelatedEvents();
                        if (relatedEvents != null) {
                            surveyConfig.setTrigger(str);
                            arrayList.add(surveyConfig);
                            this.needReportTuxEvents.addAll(relatedEvents);
                            this.triggerIndexAndChildJsonRulesMap.put(Integer.valueOf(i3), parseChildJsonRules.getJsonRules());
                            if (parseOneWithJsonString.getType() == JsonRuleType.TIMER) {
                                this.timerTriggerIndexAndJsonRuleMap.put(Integer.valueOf(i3), parseOneWithJsonString);
                            } else {
                                this.eventTriggerIndexAndJsonRuleMap.put(Integer.valueOf(i3), parseOneWithJsonString);
                                populateEventAndEventTriggerIndexesMap(i3, relatedEvents);
                            }
                        }
                    }
                }
            }
        }
        setSurveyConfigs(arrayList);
    }

    public void preUploadSurvey(SurveyReportReq surveyReportReq, @Nullable ITuxSubmitAnswerListener iTuxSubmitAnswerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) surveyReportReq, (Object) iTuxSubmitAnswerListener);
        } else {
            execWorkTask(new PreUploadSurveyTask(this, surveyReportReq, new WeakReference(iTuxSubmitAnswerListener)));
        }
    }

    public void recordExposedSurveySet(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.exposedSurveyIdSets.add(str);
        }
    }

    public void refreshSurveyConfig(ITuxRefreshListener iTuxRefreshListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) iTuxRefreshListener);
            return;
        }
        execWorkTask(new RefreshSurveyConfigTask(this.dataFetcher, generateGetSurveyConfigReq(), new WeakReference(iTuxRefreshListener), this.logger));
    }

    public void setSDKConfig(SDKConfig sDKConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) sDKConfig);
        } else {
            this.sdkConfig = sDKConfig;
        }
    }

    public void setServerTimeGap(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        } else {
            this.serverTimeGap = j3;
        }
    }

    public void setSurveyConfigs(List<SurveyConfig> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.surveyConfigs = list;
        }
    }

    public void setTriggerIndexAndChildJsonRulesMap(Map<Integer, List<JsonRule>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) map);
        } else {
            this.triggerIndexAndChildJsonRulesMap = map;
        }
    }

    public TuxSurveyConfig transferToTuxSurveyConfigWithTrigger(SurveyConfig surveyConfig) {
        JsonObject jsonObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (TuxSurveyConfig) iPatchRedirector.redirect((short) 28, (Object) this, (Object) surveyConfig);
        }
        TuxSurveyConfig transferToTuxSurveyConfig = surveyConfig.transferToTuxSurveyConfig();
        JsonObject jsonObject2 = null;
        if (transferToTuxSurveyConfig == null) {
            return null;
        }
        JsonParser jsonParser = new JsonParser();
        try {
            jsonObject = jsonParser.parse(surveyConfig.getTrigger()).getAsJsonObject();
        } catch (Exception e16) {
            this.logger.e(TAG, "[transferToTuxSurveyConfigWithTrigger]\u89e3\u6790trigger\u5931\u8d25:" + e16.getLocalizedMessage());
            jsonObject = null;
        }
        if (jsonObject == null) {
            return null;
        }
        try {
            jsonObject2 = jsonParser.parse(surveyConfig.getChildTrigger()).getAsJsonObject();
        } catch (Exception e17) {
            this.logger.e(TAG, "[transferToTuxSurveyConfigWithTrigger]\u89e3\u6790child_trigger\u5931\u8d25:" + e17.getLocalizedMessage());
        }
        transferToTuxSurveyConfig.setTriggerInfo(jsonObject);
        transferToTuxSurveyConfig.setChildTriggerInfo(jsonObject2);
        return transferToTuxSurveyConfig;
    }

    public void traverseMultiDimensionProbability(String str, JsonElement jsonElement, List<String> list, JsonArray jsonArray, List<JsonRule> list2) {
        double d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, str, jsonElement, list, jsonArray, list2);
            return;
        }
        if (list.size() == jsonArray.size()) {
            for (int i3 = 0; i3 < jsonArray.size(); i3++) {
                str = str.replace(jsonArray.get(i3).getAsString(), list.get(i3));
            }
            if (jsonElement.isJsonPrimitive()) {
                d16 = jsonElement.getAsDouble();
            } else {
                d16 = 1.0d;
            }
            list2.add(this.jsonRuleEngine.parseOneWithJsonString(str, d16));
            return;
        }
        if (jsonElement.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                String key = entry.getKey();
                JsonElement value = entry.getValue();
                list.add(key);
                traverseMultiDimensionProbability(str, value, list, jsonArray, list2);
                list.remove(list.size() - 1);
            }
        }
    }

    public void uploadSurvey(SurveyReportReq surveyReportReq, @Nullable ITuxSubmitAnswerListener iTuxSubmitAnswerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) surveyReportReq, (Object) iTuxSubmitAnswerListener);
        } else {
            execWorkTask(new UploadSurveyTask(this, surveyReportReq, new WeakReference(iTuxSubmitAnswerListener)));
        }
    }
}

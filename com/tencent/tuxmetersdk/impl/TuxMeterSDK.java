package com.tencent.tuxmetersdk.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmetersdk.BuildConfig;
import com.tencent.tuxmetersdk.export.config.TuxSurveyType;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxThread;
import com.tencent.tuxmetersdk.export.listener.ITuxFetchDataListener;
import com.tencent.tuxmetersdk.export.listener.ITuxInitListener;
import com.tencent.tuxmetersdk.export.listener.ITuxInitSDKListener;
import com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener;
import com.tencent.tuxmetersdk.export.listener.ITuxSelfTriggerListener;
import com.tencent.tuxmetersdk.export.listener.ITuxSubmitAnswerListener;
import com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener;
import com.tencent.tuxmetersdk.export.listener.TriggerListenerHelper;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import com.tencent.tuxmetersdk.impl.refresh.OnSingleTaskListener;
import com.tencent.tuxmetersdk.impl.refresh.SingleTaskHelper;
import com.tencent.tuxmetersdk.impl.utils.TuxSurveyUtils;
import com.tencent.tuxmetersdk.model.Sheet;
import com.tencent.tuxmetersdk.model.SurveyConfig;
import com.tencent.tuxmetersdk.model.SurveyReportReq;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class TuxMeterSDK {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TuxMeterSDK";
    private TuxDataManager dataManager;
    private TuxDataStorage dataStorage;
    private final ITuxHandlerThread handlerThread;
    private ITuxLog logger;
    private TuxMeterSDKSetting meterSDKSetting;
    private final Handler sdkDataReadyHandler;
    private final BlockingQueue<SelfTriggerTask> selfTriggerTasks;
    private SingleTaskHelper singleTaskHelper;
    private final TriggerListenerHelper triggerListenerHelper;
    private TriggerManager triggerManager;
    private final TuxUseState useState;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class SDKDataReadyHandler extends Handler {
        static IPatchRedirector $redirector_;
        private final WeakReference<TuxMeterSDK> tuxMeterSDKRef;

        /* synthetic */ SDKDataReadyHandler(Looper looper, TuxMeterSDK tuxMeterSDK, AnonymousClass1 anonymousClass1) {
            this(looper, tuxMeterSDK);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, looper, tuxMeterSDK, anonymousClass1);
        }

        SDKDataReadyHandler(Looper looper, TuxMeterSDK tuxMeterSDK) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.tuxMeterSDKRef = new WeakReference<>(tuxMeterSDK);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) tuxMeterSDK);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class SelfTriggerTask implements Runnable {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "TuxSelfTriggerTask";
        private final WeakReference<ITuxSelfTriggerListener> mRef;
        private final String sceneId;

        public SelfTriggerTask(String str, ITuxSelfTriggerListener iTuxSelfTriggerListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TuxMeterSDK.this, str, iTuxSelfTriggerListener);
            } else {
                this.mRef = new WeakReference<>(iTuxSelfTriggerListener);
                this.sceneId = str;
            }
        }

        public String getSceneId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.sceneId;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            ITuxSelfTriggerListener iTuxSelfTriggerListener = this.mRef.get();
            if (iTuxSelfTriggerListener == null) {
                return;
            }
            try {
                if (!TuxMeterSDK.this.useState.isInitSDKSuccess()) {
                    iTuxSelfTriggerListener.onSelfTrigger(null, null);
                    return;
                }
                try {
                    TuxMeterSDK.this.triggerManager.triggerBySelf(this.sceneId, iTuxSelfTriggerListener);
                } catch (Exception e16) {
                    if (TuxMeterSDK.this.logger != null) {
                        TuxMeterSDK.this.logger.e(TAG, "getSurveyConfigWithTriggerBySceneId\u51fa\u73b0\u5f02\u5e38:" + e16.getLocalizedMessage());
                    }
                }
            } catch (Exception e17) {
                if (TuxMeterSDK.this.logger != null) {
                    TuxMeterSDK.this.logger.e(TAG, "getSurveyConfigWithTriggerBySceneId \u52a0\u9501\u5f02\u5e38: " + e17.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SelfTriggerTaskConsumer implements Runnable {
        static IPatchRedirector $redirector_ = null;
        public static final String TAG = "TuxSelfTriggerTaskConsumer";

        SelfTriggerTaskConsumer() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxMeterSDK.this);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (true) {
                try {
                    try {
                        SelfTriggerTask selfTriggerTask = (SelfTriggerTask) TuxMeterSDK.this.selfTriggerTasks.take();
                        if (selfTriggerTask != null) {
                            selfTriggerTask.run();
                        }
                    } catch (Exception e16) {
                        TuxMeterSDK.this.logger.e(TAG, "\u6d88\u8d39selfTriggerTask\u5f02\u5e38: " + e16.getLocalizedMessage());
                        TuxMeterSDK.this.logger.i(TAG, "\u6d88\u8d39selfTriggerTask\u7ed3\u675f");
                        return;
                    }
                } catch (Throwable th5) {
                    TuxMeterSDK.this.logger.i(TAG, "\u6d88\u8d39selfTriggerTask\u7ed3\u675f");
                    throw th5;
                }
            }
        }

        /* synthetic */ SelfTriggerTaskConsumer(TuxMeterSDK tuxMeterSDK, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tuxMeterSDK, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TuxMeterSDKHolder {
        static IPatchRedirector $redirector_;
        private static final TuxMeterSDK SINGLETON;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10597);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                SINGLETON = new TuxMeterSDK(null);
            }
        }

        TuxMeterSDKHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ TuxMeterSDK(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consumeSelfTriggerTask() {
        try {
            this.sdkDataReadyHandler.post(new SelfTriggerTaskConsumer(this, null));
        } catch (Exception e16) {
            this.logger.e(TAG, "consumeSelfTriggerTask\u5f02\u5e38:" + e16.getLocalizedMessage());
        }
    }

    public static TuxMeterSDK getInstance() {
        return TuxMeterSDKHolder.SINGLETON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedToRefreshSurveyConfig(SDKConfig sDKConfig) {
        if (sDKConfig == null) {
            return true;
        }
        try {
            boolean isWhite = sDKConfig.isWhite();
            boolean isContainPermanent = sDKConfig.isContainPermanent();
            if (!isWhite && !isContainPermanent && this.dataStorage != null) {
                int silentPeriod = sDKConfig.getSilentPeriod();
                ExposeInfo exposeInfo = this.dataStorage.getExposeInfo();
                this.logger.i(TAG, "exposeInfo: " + exposeInfo);
                if (exposeInfo == null) {
                    return true;
                }
                Date exposeTime = exposeInfo.getExposeTime();
                if (exposeTime == null) {
                    this.logger.i(TAG, "exposeInfo.exposeTime is null, remove expose info");
                    this.dataStorage.removeExposeInfo();
                    return true;
                }
                Date date = new Date();
                double diffHours = Utils.diffHours(date, exposeTime);
                this.logger.i(TAG, String.format("\u5f53\u524d\u65f6\u95f4: %s, \u6700\u8fd1\u4e00\u6b21\u95ee\u5377\u66dd\u5149\u65f6\u95f4: %s, \u76f8\u5dee\u5c0f\u65f6\u6570: %s", Utils.formatDate(date), Utils.formatDate(exposeTime), Double.valueOf(diffHours)));
                if (diffHours <= silentPeriod && diffHours >= 0.0d) {
                    return false;
                }
                this.logger.i(TAG, String.format("\u66dd\u5149\u65f6\u95f4\u5dee\u5927\u4e8e%s\u5c0f\u65f6\u6216\u8005\u5c0f\u4e8e0, currentTime: %s, exposeTime: %s, remove expose info", Integer.valueOf(silentPeriod), Utils.formatDate(date), Utils.formatDate(exposeTime)));
                this.dataStorage.removeExposeInfo();
            }
            return true;
        } catch (Exception e16) {
            this.logger.e(TAG, "isNeedToRefreshSurveyConfig\u5f02\u5e38:" + e16.getLocalizedMessage());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startTimerRefresh$0() {
        selfRefresh(new ITuxRefreshListener() { // from class: com.tencent.tuxmetersdk.impl.TuxMeterSDK.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxMeterSDK.this);
                }
            }

            @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
            public void onFailure(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                    return;
                }
                try {
                    if (TuxMeterSDK.this.singleTaskHelper != null) {
                        TuxMeterSDK.this.singleTaskHelper.start();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
            public void onSuccess(List<SurveyConfig> list, long j3, long j16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Long.valueOf(j16));
                    return;
                }
                try {
                    if (TuxMeterSDK.this.singleTaskHelper != null && j16 > 0) {
                        TuxMeterSDK.this.singleTaskHelper.updateInterval(j16);
                        TuxMeterSDK.this.singleTaskHelper.start();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realRefresh(ITuxRefreshListener iTuxRefreshListener) {
        this.dataManager.refreshSurveyConfig(new ITuxRefreshListener(iTuxRefreshListener) { // from class: com.tencent.tuxmetersdk.impl.TuxMeterSDK.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ ITuxRefreshListener val$fetchDataListener;

            {
                this.val$fetchDataListener = iTuxRefreshListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxMeterSDK.this, (Object) iTuxRefreshListener);
                }
            }

            @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
            public void onFailure(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                    return;
                }
                String str2 = "\u5237\u65b0\u95ee\u5377\u914d\u7f6e\u5931\u8d25\uff1a" + str;
                TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, str2);
                ITuxRefreshListener iTuxRefreshListener2 = this.val$fetchDataListener;
                if (iTuxRefreshListener2 != null) {
                    iTuxRefreshListener2.onFailure(10000, str2);
                }
            }

            @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
            public void onSuccess(List<SurveyConfig> list, long j3, long j16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Long.valueOf(j16));
                    return;
                }
                try {
                    try {
                        TuxMeterSDK.this.dataManager.getRwl().writeLock().lock();
                        TuxMeterSDK.this.dataManager.fixTime(j3);
                        TuxMeterSDK.this.dataManager.parseSurveyConfig(list);
                        TuxMeterSDK.this.logger.i(TuxMeterSDK.TAG, "\u6210\u529f\u5237\u65b0\u95ee\u5377\u914d\u7f6e");
                        ITuxRefreshListener iTuxRefreshListener2 = this.val$fetchDataListener;
                        if (iTuxRefreshListener2 != null) {
                            iTuxRefreshListener2.onSuccess(list, j3, j16);
                        }
                        TuxMeterSDK.this.useState.setSDKDataReadyStateSuccess();
                    } catch (Exception e16) {
                        String str = "\u5237\u65b0\u95ee\u5377\u914d\u7f6e\u51fa\u73b0\u5f02\u5e38\uff1a" + e16.getLocalizedMessage();
                        TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, str);
                        ITuxRefreshListener iTuxRefreshListener3 = this.val$fetchDataListener;
                        if (iTuxRefreshListener3 != null) {
                            iTuxRefreshListener3.onFailure(10000, str);
                        }
                    }
                } finally {
                    TuxMeterSDK.this.dataManager.getRwl().writeLock().unlock();
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        r4.onFailure(10000, "init failed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void selfRefresh(ITuxRefreshListener iTuxRefreshListener) {
        TriggerManager triggerManager;
        TuxDataManager tuxDataManager;
        try {
            if (!this.useState.isSDKDataReadyInit() && (triggerManager = this.triggerManager) != null && triggerManager.getTriggerState() != null && (tuxDataManager = this.dataManager) != null && tuxDataManager.getSDKConfig() != null) {
                if (!isNeedToRefreshSurveyConfig(this.dataManager.getSDKConfig())) {
                    if (iTuxRefreshListener != null) {
                        iTuxRefreshListener.onFailure(10000, "exposed");
                        return;
                    }
                    return;
                }
                realRefresh(iTuxRefreshListener);
            }
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "selfRefresh\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimerRefresh(long j3) {
        if (j3 <= 0) {
            return;
        }
        try {
            SingleTaskHelper singleTaskHelper = new SingleTaskHelper(j3, new OnSingleTaskListener() { // from class: com.tencent.tuxmetersdk.impl.a
                @Override // com.tencent.tuxmetersdk.impl.refresh.OnSingleTaskListener
                public final void onAction() {
                    TuxMeterSDK.this.lambda$startTimerRefresh$0();
                }
            });
            this.singleTaskHelper = singleTaskHelper;
            singleTaskHelper.start();
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "startTimerRefresh error: " + e16.getMessage());
            }
        }
    }

    public ITuxLog getLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ITuxLog) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.logger;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        r5.onSelfTrigger(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getSurveyConfigWithTriggerBySceneId(String str, ITuxSelfTriggerListener iTuxSelfTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) iTuxSelfTriggerListener);
            return;
        }
        try {
            if (!this.useState.isInitSDKFail() && !this.useState.isSDKDataReadyFail()) {
                if (this.useState.isSDKDataReadySuccess()) {
                    this.triggerManager.triggerBySelf(str, iTuxSelfTriggerListener);
                } else if (!this.selfTriggerTasks.offer(new SelfTriggerTask(str, iTuxSelfTriggerListener)) && iTuxSelfTriggerListener != null) {
                    iTuxSelfTriggerListener.onSelfTrigger(null, null);
                }
            }
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "getSurveyConfigWithTriggerBySceneId\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        }
    }

    public ITuxSurveyEventCallback getSurveyEventCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ITuxSurveyEventCallback) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        try {
            if (this.useState.isInitSDKSuccess()) {
                return this.triggerManager.getSurveyEventCallback();
            }
            return null;
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "getSurveyEventCallback\u51fa\u73b0\u5f02\u5e38:" + e16.getLocalizedMessage());
                return null;
            }
            return null;
        }
    }

    public TriggerListenerHelper getTriggerListenerHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TriggerListenerHelper) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.triggerListenerHelper;
    }

    public boolean isAnySurveyExpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        TriggerManager triggerManager = this.triggerManager;
        if (triggerManager == null) {
            return false;
        }
        return triggerManager.isAnySurveyExpose();
    }

    public void refresh(ITuxFetchDataListener iTuxFetchDataListener) {
        TriggerManager triggerManager;
        TuxDataManager tuxDataManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iTuxFetchDataListener);
            return;
        }
        try {
            if (!this.useState.isSDKDataReadyInit() && (triggerManager = this.triggerManager) != null && triggerManager.getTriggerState() != null && (tuxDataManager = this.dataManager) != null && tuxDataManager.getSDKConfig() != null && isNeedToRefreshSurveyConfig(this.dataManager.getSDKConfig())) {
                realRefresh(new ITuxRefreshListener(iTuxFetchDataListener) { // from class: com.tencent.tuxmetersdk.impl.TuxMeterSDK.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ITuxFetchDataListener val$fetchDataListener;

                    {
                        this.val$fetchDataListener = iTuxFetchDataListener;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxMeterSDK.this, (Object) iTuxFetchDataListener);
                        }
                    }

                    @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
                    public void onFailure(int i3, String str) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                            return;
                        }
                        ITuxFetchDataListener iTuxFetchDataListener2 = this.val$fetchDataListener;
                        if (iTuxFetchDataListener2 != null) {
                            iTuxFetchDataListener2.onFailure(10000, str);
                        }
                    }

                    @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
                    public void onSuccess(List<SurveyConfig> list, long j3, long j16) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, list, Long.valueOf(j3), Long.valueOf(j16));
                            return;
                        }
                        ITuxFetchDataListener iTuxFetchDataListener2 = this.val$fetchDataListener;
                        if (iTuxFetchDataListener2 != null) {
                            iTuxFetchDataListener2.onSuccess();
                        }
                    }
                });
            }
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "refresh\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        }
    }

    public void report(TuxEvent tuxEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tuxEvent);
            return;
        }
        try {
            if (!this.useState.isInitSDKSuccess()) {
                return;
            }
            this.triggerManager.triggerByEvent(tuxEvent, null);
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "report\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        }
    }

    public void reportWithTriggerListener(TuxEvent tuxEvent, ITuxTriggerListener iTuxTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) tuxEvent, (Object) iTuxTriggerListener);
            return;
        }
        try {
            if (!this.useState.isInitSDKSuccess()) {
                Utils.doTriggerIfFailure(iTuxTriggerListener, "not_init");
            } else {
                this.triggerManager.triggerByEvent(tuxEvent, iTuxTriggerListener);
            }
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "report\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
            Utils.doTriggerIfFailure(iTuxTriggerListener, "exception");
        }
    }

    public void resetControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.i(TAG, "resetControl used");
            }
            this.triggerManager.resetControl();
        } catch (Exception e16) {
            ITuxLog iTuxLog2 = this.logger;
            if (iTuxLog2 != null) {
                iTuxLog2.e(TAG, "resetControl: " + e16.getLocalizedMessage());
            }
        }
    }

    public void resetUserData(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.meterSDKSetting.resetUserData(str, str2);
        TuxDataManager tuxDataManager = this.dataManager;
        if (tuxDataManager != null) {
            tuxDataManager.initSDK(new ITuxInitSDKListener() { // from class: com.tencent.tuxmetersdk.impl.TuxMeterSDK.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxMeterSDK.this);
                    }
                }

                @Override // com.tencent.tuxmetersdk.export.listener.ITuxInitSDKListener
                public void onFailure(int i3, String str3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str3);
                    }
                }

                @Override // com.tencent.tuxmetersdk.export.listener.ITuxInitSDKListener
                public void onSuccess(boolean z16, SDKConfig sDKConfig) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), sDKConfig);
                        return;
                    }
                    TuxMeterSDK.this.dataManager.setSDKConfig(sDKConfig);
                    if (z16 && sDKConfig != null) {
                        TuxMeterSDK.this.realRefresh(null);
                        TuxMeterSDK.this.resetControl();
                        TuxMeterSDK.this.dataManager.getEventQueue().clear();
                    }
                }
            });
            Log.e(TAG, "resetLoginData: ");
        }
    }

    public void start(Context context, TuxMeterSDKSetting tuxMeterSDKSetting, ITuxInitListener iTuxInitListener, ITuxFetchDataListener iTuxFetchDataListener, ITuxTriggerListener iTuxTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            start(tuxMeterSDKSetting, iTuxInitListener, iTuxFetchDataListener, iTuxTriggerListener);
        } else {
            iPatchRedirector.redirect((short) 2, this, context, tuxMeterSDKSetting, iTuxInitListener, iTuxFetchDataListener, iTuxTriggerListener);
        }
    }

    public void submitAnswer(TuxSurveyConfig tuxSurveyConfig, Sheet sheet, TuxSurveyType tuxSurveyType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tuxSurveyConfig, sheet, tuxSurveyType);
            return;
        }
        try {
            if (this.useState.isInitSDKSuccess() && tuxSurveyConfig != null && tuxSurveyConfig.getSurvey() != null) {
                Date date = this.dataManager.getSurveyFirstClickServerTime().get(tuxSurveyConfig.getDeliveryId());
                if (date != null) {
                    sheet.setStartedAt(Utils.formatDate(date));
                    sheet.setStartUnix(date.getTime());
                }
                Date date2 = this.dataManager.getSurveyFirstClickClientTime().get(tuxSurveyConfig.getDeliveryId());
                if (date2 != null) {
                    sheet.setClientStartedAt(Utils.formatDate(date2));
                }
                Date serverTime = this.dataManager.getServerTime();
                sheet.setEndedAt(Utils.formatDate(serverTime));
                if (serverTime != null) {
                    sheet.setEndUnix(serverTime.getTime());
                }
                sheet.setClientEndedAt(Utils.formatDate(new Date()));
                ITuxLog iTuxLog = this.logger;
                if (iTuxLog != null) {
                    iTuxLog.i(TAG, String.format("\u5ba2\u6237\u7aef\u5f00\u59cb\u65f6\u95f4\uff08\u4e1c\u516b\u533a\uff09\uff1a%s\uff0c\u5ba2\u6237\u7aef\u7ed3\u675f\u65f6\u95f4\uff08\u4e1c\u516b\u533a\uff09\uff1a%s\uff0c\u6821\u51c6\u540e\u7684\u5f00\u59cb\u65f6\u95f4\uff08\u4e1c\u516b\u533a\uff09\uff1a%s\uff0c\u6821\u51c6\u540e\u7684\u7ed3\u675f\u65f6\u95f4\uff08\u4e1c\u516b\u533a\uff09\uff1a%s", sheet.getClientStartedAt(), sheet.getClientEndedAt(), sheet.getStartedAt(), sheet.getEndedAt()));
                }
                SurveyReportReq surveyReportReq = new SurveyReportReq();
                surveyReportReq.setSurveyId(tuxSurveyConfig.getSurvey().getId());
                surveyReportReq.setWhite(tuxSurveyConfig.isWhite());
                surveyReportReq.setPf(tuxSurveyConfig.getPf());
                TuxMeterSDKSetting tuxMeterSDKSetting = this.meterSDKSetting;
                if (tuxMeterSDKSetting != null) {
                    surveyReportReq.setAppId(tuxMeterSDKSetting.getAppId());
                    sheet.setZoneId(this.meterSDKSetting.getZoneId());
                }
                surveyReportReq.setExtInfo(tuxSurveyConfig.getBase64ExtInfoJson());
                surveyReportReq.setBh(tuxSurveyConfig.getBh());
                surveyReportReq.setPayload(sheet);
                if (tuxSurveyType == TuxSurveyType.SELF_RENDING_WITH_TUXH5) {
                    this.triggerManager.getSurveyEventCallback().onPreSubmit(tuxSurveyConfig);
                    this.dataManager.preUploadSurvey(surveyReportReq, null);
                    return;
                } else {
                    if (!TuxSurveyUtils.inSubmitSurveySet(tuxSurveyConfig.getDeliveryId())) {
                        this.triggerManager.getSurveyEventCallback().onSubmit(tuxSurveyConfig);
                        surveyReportReq.setPayload(TuxSurveyUtils.fillSheet(tuxSurveyConfig, sheet, this.logger));
                        this.dataManager.uploadSurvey(surveyReportReq, new ITuxSubmitAnswerListener(tuxSurveyConfig) { // from class: com.tencent.tuxmetersdk.impl.TuxMeterSDK.3
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ TuxSurveyConfig val$surveyConfig;

                            {
                                this.val$surveyConfig = tuxSurveyConfig;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxMeterSDK.this, (Object) tuxSurveyConfig);
                                }
                            }

                            @Override // com.tencent.tuxmetersdk.export.listener.ITuxSubmitAnswerListener
                            public void onFailure() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                    iPatchRedirector2.redirect((short) 3, (Object) this);
                                } else if (TuxMeterSDK.this.logger != null) {
                                    TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, "\u63d0\u4ea4\u5931\u8d25");
                                }
                            }

                            @Override // com.tencent.tuxmetersdk.export.listener.ITuxSubmitAnswerListener
                            public void onSuccess() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (TuxMeterSDK.this.logger != null) {
                                    TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, "\u63d0\u4ea4\u6210\u529f");
                                }
                                TuxSurveyUtils.recordSubmitSurveySet(this.val$surveyConfig.getDeliveryId());
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            ITuxLog iTuxLog2 = this.logger;
            if (iTuxLog2 != null) {
                iTuxLog2.e(TAG, "\u63d0\u4ea4\u95ee\u5377\u5f02\u5e38");
            }
        } catch (Exception e16) {
            ITuxLog iTuxLog3 = this.logger;
            if (iTuxLog3 != null) {
                iTuxLog3.e(TAG, "submitAnswer\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        }
    }

    TuxMeterSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.selfTriggerTasks = new LinkedBlockingQueue(50);
        this.useState = new TuxUseState();
        TuxHandlerThread tuxHandlerThread = new TuxHandlerThread();
        this.handlerThread = tuxHandlerThread;
        this.sdkDataReadyHandler = new SDKDataReadyHandler(tuxHandlerThread.getSDKDataReadyLooper(), this, null);
        this.triggerListenerHelper = new TriggerListenerHelper();
    }

    public void start(TuxMeterSDKSetting tuxMeterSDKSetting, ITuxInitListener iTuxInitListener, ITuxFetchDataListener iTuxFetchDataListener, ITuxTriggerListener iTuxTriggerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tuxMeterSDKSetting, iTuxInitListener, iTuxFetchDataListener, iTuxTriggerListener);
            return;
        }
        if (tuxMeterSDKSetting == null) {
            return;
        }
        try {
            synchronized (this.useState) {
                if (!this.useState.isReadyToUse()) {
                    this.meterSDKSetting = tuxMeterSDKSetting;
                    ITuxLog logger = tuxMeterSDKSetting.getLogger();
                    this.logger = logger;
                    logger.i(TAG, String.format("tuxmetersdk version:%s, snapshot:%s, env: %s", BuildConfig.VERSION, "true", tuxMeterSDKSetting.getEnvironment()));
                    this.dataStorage = new TuxDataStorage(tuxMeterSDKSetting, this.logger);
                    TuxThreadImpl tuxThreadImpl = new TuxThreadImpl(tuxMeterSDKSetting.getThreadPool(), this.handlerThread);
                    this.dataManager = new TuxDataManager(tuxMeterSDKSetting, tuxThreadImpl, this.dataStorage);
                    this.useState.setReadyToUse();
                    this.dataManager.initSDK(new ITuxInitSDKListener(iTuxInitListener, tuxMeterSDKSetting, tuxThreadImpl, iTuxTriggerListener, iTuxFetchDataListener) { // from class: com.tencent.tuxmetersdk.impl.TuxMeterSDK.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ITuxFetchDataListener val$fetchDataListener;
                        final /* synthetic */ ITuxInitListener val$initListener;
                        final /* synthetic */ TuxMeterSDKSetting val$setting;
                        final /* synthetic */ ITuxThread val$threadImpl;
                        final /* synthetic */ ITuxTriggerListener val$triggerListener;

                        {
                            this.val$initListener = iTuxInitListener;
                            this.val$setting = tuxMeterSDKSetting;
                            this.val$threadImpl = tuxThreadImpl;
                            this.val$triggerListener = iTuxTriggerListener;
                            this.val$fetchDataListener = iTuxFetchDataListener;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, TuxMeterSDK.this, iTuxInitListener, tuxMeterSDKSetting, tuxThreadImpl, iTuxTriggerListener, iTuxFetchDataListener);
                            }
                        }

                        @Override // com.tencent.tuxmetersdk.export.listener.ITuxInitSDKListener
                        public void onFailure(int i3, String str) {
                            ITuxInitListener iTuxInitListener2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                                return;
                            }
                            try {
                                try {
                                    TuxMeterSDK.this.useState.setInitSDKStateFail();
                                    iTuxInitListener2 = this.val$initListener;
                                } catch (Exception e16) {
                                    TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, "\u8c03\u7528init\u63a5\u53e3\u5931\u8d25\uff0c\u5f02\u5e38\u4fe1\u606f:" + e16.getLocalizedMessage());
                                }
                                if (iTuxInitListener2 == null) {
                                    return;
                                }
                                iTuxInitListener2.onFailure(i3, str);
                            } finally {
                                TuxMeterSDK.this.consumeSelfTriggerTask();
                            }
                        }

                        @Override // com.tencent.tuxmetersdk.export.listener.ITuxInitSDKListener
                        public void onSuccess(boolean z16, SDKConfig sDKConfig) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), sDKConfig);
                                return;
                            }
                            TuxMeterSDK.this.dataManager.setSDKConfig(sDKConfig);
                            if (z16 && sDKConfig != null) {
                                TuxMeterSDK tuxMeterSDK = TuxMeterSDK.this;
                                tuxMeterSDK.triggerManager = new TriggerManager(this.val$setting, this.val$threadImpl, tuxMeterSDK.dataManager, TuxMeterSDK.this.dataStorage, TuxMeterSDK.this.triggerListenerHelper, this.val$triggerListener);
                                TuxMeterSDK.this.useState.setInitSDKStateSuccess();
                                ITuxInitListener iTuxInitListener2 = this.val$initListener;
                                if (iTuxInitListener2 != null) {
                                    iTuxInitListener2.onSuccess();
                                }
                                if (!TuxMeterSDK.this.isNeedToRefreshSurveyConfig(sDKConfig)) {
                                    TuxMeterSDK.this.logger.i(TuxMeterSDK.TAG, "\u5df2\u6709\u95ee\u5377\u66dd\u5149\uff0c\u4e0d\u518d\u83b7\u53d6\u95ee\u5377\u914d\u7f6e");
                                    return;
                                } else {
                                    TuxMeterSDK.this.dataManager.refreshSurveyConfig(new ITuxRefreshListener() { // from class: com.tencent.tuxmetersdk.impl.TuxMeterSDK.1.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                            }
                                        }

                                        @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
                                        public void onFailure(int i3, String str) {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 3)) {
                                                iPatchRedirector3.redirect((short) 3, (Object) this, i3, (Object) str);
                                                return;
                                            }
                                            try {
                                                try {
                                                    TuxMeterSDK.this.useState.setSDKDataReadyStateFail();
                                                    TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, "\u4ece\u540e\u53f0\u83b7\u53d6\u95ee\u5377\u914d\u7f6e\u5931\u8d25: " + str);
                                                    ITuxFetchDataListener iTuxFetchDataListener2 = AnonymousClass1.this.val$fetchDataListener;
                                                    if (iTuxFetchDataListener2 != null) {
                                                        iTuxFetchDataListener2.onFailure(i3, "\u4ece\u540e\u53f0\u83b7\u53d6\u95ee\u5377\u914d\u7f6e\u5931\u8d25: " + str);
                                                    }
                                                } catch (Exception e16) {
                                                    TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, "\u4ece\u540e\u53f0\u83b7\u53d6\u95ee\u5377\u914d\u7f6e\u5931\u8d25\u5e76\u53d1\u751f\u5f02\u5e38:" + e16.getLocalizedMessage());
                                                }
                                            } finally {
                                                TuxMeterSDK.this.consumeSelfTriggerTask();
                                            }
                                        }

                                        @Override // com.tencent.tuxmetersdk.export.listener.ITuxRefreshListener
                                        public void onSuccess(List<SurveyConfig> list, long j3, long j16) {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                iPatchRedirector3.redirect((short) 2, this, list, Long.valueOf(j3), Long.valueOf(j16));
                                                return;
                                            }
                                            try {
                                                try {
                                                    TuxMeterSDK.this.dataManager.getRwl().writeLock().lock();
                                                    TuxMeterSDK.this.dataManager.fixTime(j3);
                                                    TuxMeterSDK.this.dataManager.parseSurveyConfig(list);
                                                    TuxMeterSDK.this.logger.i(TuxMeterSDK.TAG, "\u6210\u529f\u89e3\u6790\u95ee\u5377\u914d\u7f6e");
                                                    ITuxFetchDataListener iTuxFetchDataListener2 = AnonymousClass1.this.val$fetchDataListener;
                                                    if (iTuxFetchDataListener2 != null) {
                                                        iTuxFetchDataListener2.onSuccess();
                                                    }
                                                    TuxMeterSDK.this.triggerManager.startTimePulseTrigger();
                                                    TuxMeterSDK.this.useState.setSDKDataReadyStateSuccess();
                                                    TuxMeterSDK.this.startTimerRefresh(j16);
                                                } catch (Exception e16) {
                                                    TuxMeterSDK.this.useState.setSDKDataReadyStateFail();
                                                    String str = "\u89e3\u6790\u95ee\u5377\u914d\u7f6e\u5f02\u5e38: " + e16.getLocalizedMessage();
                                                    TuxMeterSDK.this.logger.e(TuxMeterSDK.TAG, str);
                                                    ITuxFetchDataListener iTuxFetchDataListener3 = AnonymousClass1.this.val$fetchDataListener;
                                                    if (iTuxFetchDataListener3 != null) {
                                                        iTuxFetchDataListener3.onFailure(10000, str);
                                                    }
                                                }
                                            } finally {
                                                TuxMeterSDK.this.dataManager.getRwl().writeLock().unlock();
                                                TuxMeterSDK.this.consumeSelfTriggerTask();
                                            }
                                        }
                                    });
                                    return;
                                }
                            }
                            TuxMeterSDK.this.useState.setInitSDKStateFail();
                            ITuxInitListener iTuxInitListener3 = this.val$initListener;
                            if (iTuxInitListener3 == null) {
                                return;
                            }
                            iTuxInitListener3.onFailure(10000, "SDK\u542f\u52a8\u5931\u8d25");
                        }
                    });
                } else {
                    this.logger.i(TAG, "SDK\u6b63\u5728\u542f\u52a8\u4e2d\u6216\u8005\u5df2\u7ecf\u542f\u52a8\u4e86");
                }
            }
        } catch (Exception e16) {
            ITuxLog iTuxLog = this.logger;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "SDK start\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        }
    }
}

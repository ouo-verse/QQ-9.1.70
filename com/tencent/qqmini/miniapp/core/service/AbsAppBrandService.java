package com.tencent.qqmini.miniapp.core.service;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class AbsAppBrandService extends JsStatMachine implements IAppBrandService {
    public static final int EVENT_INIT_SUCC = 3;
    public static final int EVENT_JS_APP_CONFIG_READY = 6;
    public static final int EVENT_JS_APP_READY = 7;
    public static final int EVENT_JS_CONFIG_READY = 4;
    public static final int EVENT_JS_WA_READY = 5;
    private static final String TAG = "AbsAppBrandService";
    protected IMiniAppContext miniAppContext;
    public StateMachine.State stateInitial = new StateMachine.State(1);
    public StateMachine.State stateInited = new StateMachine.State(2);
    public StateMachine.State stateInitFailed = new StateMachine.State(-1);
    public StateMachine.State stateDefaulConfigJsLoadSucc = new StateMachine.State(4);
    public JsStatMachine.JsState stateDefaulConfigJsLoading = new JsStatMachine.JsState(3).nextState(this.stateDefaulConfigJsLoadSucc);
    public StateMachine.State stateWaJsLoadSucc = new StateMachine.State(6);
    public JsStatMachine.JsState stateWaJsLoading = new JsStatMachine.JsState(5).nextState(this.stateWaJsLoadSucc);
    public StateMachine.State stateGlobalConfigJsLoadSucc = new StateMachine.State(8);
    public JsStatMachine.JsState stateGlobalConfigJsLoading = new JsStatMachine.JsState(7).nextState(this.stateGlobalConfigJsLoadSucc);
    public StateMachine.State stateLoadSucc = new StateMachine.State(10);
    public JsStatMachine.JsState stateAppServiceJsLoading = new JsStatMachine.JsState(9).nextState(this.stateLoadSucc);
    protected List<String> mWaitingJsList = new ArrayList();

    public AbsAppBrandService(IMiniAppContext iMiniAppContext) {
        this.miniAppContext = iMiniAppContext;
        initStateConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addWaitEvaluateJs(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mWaitingJsList) {
                this.mWaitingJsList.add(str);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public int createNativeBuffer(byte[] bArr, long j3, long j16) {
        return 0;
    }

    protected void evaluateWaitJs() {
        QMLog.e(TAG, "Evaluate waiting js list!");
        ArrayList arrayList = new ArrayList();
        synchronized (this.mWaitingJsList) {
            arrayList.addAll(this.mWaitingJsList);
            this.mWaitingJsList.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            evaluateJs((String) it.next(), null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public byte[] getNativeBuffer(int i3) {
        return new byte[0];
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public abstract void initBaseJs(BaselibLoader.BaselibContent baselibContent);

    protected void initStateConfig() {
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateInitial).next(this.stateInited).registEvent(3));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateInited).next(this.stateDefaulConfigJsLoading).registEvent(4));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateDefaulConfigJsLoadSucc).next(this.stateWaJsLoading).registEvent(5));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateWaJsLoadSucc).next(this.stateGlobalConfigJsLoading).registEvent(6));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateGlobalConfigJsLoadSucc).next(this.stateAppServiceJsLoading).registEvent(7));
        setCurrState(this.stateInitial);
    }

    public boolean isStateSucc() {
        if (this.stateLoadSucc == getCurrState()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public abstract void setApkgInfo(ApkgInfo apkgInfo);

    public void setAppServiceJs(String str) {
        this.stateAppServiceJsLoading.setJsContent(str);
        appendEvent(7);
    }

    @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine
    public void setCurrState(StateMachine.State state) {
        if (state == this.stateWaJsLoading) {
            MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 14, "0");
        } else if (this.stateWaJsLoadSucc == state) {
            MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 15, "0");
        } else if (state == this.stateAppServiceJsLoading) {
            MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 104, "0");
        } else if (this.stateLoadSucc == state) {
            MiniReportManager.reportEventType(this.miniAppContext.getMiniAppInfo(), 105, "0");
        }
        if (this.stateLoadSucc == state) {
            evaluateWaitJs();
        }
        super.setCurrState(state);
    }

    public void setDefaultConfigJs(String str) {
        this.stateDefaulConfigJsLoading.setJsContent(str);
        appendEvent(4);
    }

    public void setGlobalConfigJs(String str) {
        this.stateGlobalConfigJsLoading.setJsContent(str);
        appendEvent(6);
    }

    public void setWaServiceJS(String str, String str2) {
        this.stateWaJsLoading.setJsContent(str, str2);
        appendEvent(5);
    }
}

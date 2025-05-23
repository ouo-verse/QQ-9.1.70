package com.tencent.mtt.hippy.modules;

import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.runtime.builtins.e;
import com.tencent.mtt.hippy.runtime.builtins.i;
import java.lang.ref.WeakReference;

/* loaded from: classes20.dex */
public class PromiseImpl implements Promise {
    private static final String CALL_ID_NO_CALLBACK = "-1";
    public static final int PROMISE_CODE_NORMAN_ERROR = 1;
    public static final int PROMISE_CODE_OTHER_ERROR = 2;
    public static final int PROMISE_CODE_SUCCESS = 0;
    private final String mCallId;
    private WeakReference<HippyEngineContext> mContextRef;
    private final String mModuleFunc;
    private final String mModuleName;
    private boolean mNeedResolveBySelf = true;
    private HippyEngine.BridgeTransferType transferType = HippyEngine.BridgeTransferType.BRIDGE_TRANSFER_TYPE_NORMAL;

    public PromiseImpl(HippyEngineContext hippyEngineContext, String str, String str2, String str3) {
        this.mContextRef = new WeakReference<>(hippyEngineContext);
        this.mModuleName = str;
        this.mModuleFunc = str2;
        this.mCallId = str3;
    }

    private boolean onInterceptPromiseCallBack(Object obj) {
        HippyEngineMonitorAdapter engineMonitorAdapter;
        HippyEngineContext hippyEngineContext = this.mContextRef.get();
        if (hippyEngineContext == null || (engineMonitorAdapter = hippyEngineContext.getGlobalConfigs().getEngineMonitorAdapter()) == null) {
            return false;
        }
        return engineMonitorAdapter.onInterceptPromiseCallback(hippyEngineContext.getComponentName(), this.mModuleName, this.mModuleFunc, this.mCallId, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doCallback(int i3, Object obj) {
        HippyMap hippyMap;
        HippyEngineContext hippyEngineContext = this.mContextRef.get();
        if (hippyEngineContext != null && !onInterceptPromiseCallBack(obj) && !TextUtils.equals("-1", this.mCallId)) {
            if (obj instanceof i) {
                e eVar = new e();
                eVar.a("result", Integer.valueOf(i3));
                eVar.a("moduleName", this.mModuleName);
                eVar.a("moduleFunc", this.mModuleFunc);
                eVar.a("callId", this.mCallId);
                eVar.a("params", obj);
                hippyMap = eVar;
            } else {
                HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushInt("result", i3);
                hippyMap2.pushString("moduleName", this.mModuleName);
                hippyMap2.pushString("moduleFunc", this.mModuleFunc);
                hippyMap2.pushString("callId", this.mCallId);
                hippyMap2.pushObject("params", obj);
                hippyMap = hippyMap2;
            }
            hippyEngineContext.getBridgeManager().a(hippyMap, this.transferType);
        }
    }

    @Override // com.tencent.mtt.hippy.modules.Promise
    public String getCallId() {
        return this.mCallId;
    }

    @Override // com.tencent.mtt.hippy.modules.Promise
    public boolean isCallback() {
        return !TextUtils.equals(this.mCallId, "-1");
    }

    public boolean needResolveBySelf() {
        return this.mNeedResolveBySelf;
    }

    @Override // com.tencent.mtt.hippy.modules.Promise
    public void reject(Object obj) {
        doCallback(2, obj);
    }

    @Override // com.tencent.mtt.hippy.modules.Promise
    public void resolve(Object obj) {
        doCallback(0, obj);
    }

    public void setContext(HippyEngineContext hippyEngineContext) {
        this.mContextRef = new WeakReference<>(hippyEngineContext);
    }

    public void setNeedResolveBySelf(boolean z16) {
        this.mNeedResolveBySelf = z16;
    }

    @Override // com.tencent.mtt.hippy.modules.Promise
    public void setTransferType(HippyEngine.BridgeTransferType bridgeTransferType) {
        this.transferType = bridgeTransferType;
    }
}

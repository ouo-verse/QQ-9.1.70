package com.tencent.hippy.qq.module;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQBaseModule extends HippyNativeModuleBase {
    volatile int mCallbackIdCounter;
    HashMap<String, Promise> mapCallbacks;

    public QQBaseModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mCallbackIdCounter = 0;
        this.mapCallbacks = new HashMap<>();
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        this.mapCallbacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity getActivity() {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine == null) {
            return null;
        }
        return hippyQQEngine.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AppInterface getAppInterface() {
        return HippyUtils.getAppInterface();
    }

    public final QBaseActivity getBaseActivity() {
        if (getActivity() instanceof QBaseActivity) {
            return (QBaseActivity) getActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getBundleName() {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine == null) {
            return "";
        }
        return hippyQQEngine.getModuleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Promise getCallback(String str) {
        return this.mapCallbacks.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QBaseFragment getFragment() {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine == null) {
            return null;
        }
        return hippyQQEngine.getFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final HippyQQEngine getHippyQQEngine() {
        return HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isInMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int saveCallback(Promise promise) {
        int i3 = this.mCallbackIdCounter + 1;
        this.mCallbackIdCounter = i3;
        this.mapCallbacks.put(String.valueOf(i3), promise);
        return i3;
    }
}

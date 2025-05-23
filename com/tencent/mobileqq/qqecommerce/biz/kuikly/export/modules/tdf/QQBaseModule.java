package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.tdf.module.TDFBaseModule;
import com.tencent.tdf.module.TDFModuleContext;
import com.tencent.tdf.module.TDFModulePromise;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QQBaseModule extends TDFBaseModule {
    volatile int mCallbackIdCounter;
    HashMap<String, TDFModulePromise> mapCallbacks;

    public QQBaseModule(TDFModuleContext tDFModuleContext) {
        super(tDFModuleContext);
        this.mCallbackIdCounter = 0;
        this.mapCallbacks = new HashMap<>();
    }

    @Override // com.tencent.tdf.module.TDFBaseModule
    public void destroy() {
        super.destroy();
        this.mapCallbacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AppInterface getAppInterface() {
        return HippyUtils.getAppInterface();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TDFModulePromise getCallback(String str) {
        return this.mapCallbacks.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isInMainProcess() {
        return MobileQQ.sProcessId == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int saveCallback(TDFModulePromise tDFModulePromise) {
        int i3 = this.mCallbackIdCounter + 1;
        this.mCallbackIdCounter = i3;
        this.mapCallbacks.put(String.valueOf(i3), tDFModulePromise);
        return i3;
    }
}

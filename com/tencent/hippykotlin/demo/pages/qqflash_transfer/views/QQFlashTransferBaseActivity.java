package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.module.QQFlashTransferKuiklyModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.a;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QQFlashTransferBaseActivity extends BaseComponentActivity {
    public static int currentFileActivityCount;

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final Map<String, Module> createExternalModules() {
        registerModule("QQFlashTransferKuiklyModule", new a() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFlashTransferBaseActivity$createExternalModules$1
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new QQFlashTransferKuiklyModule();
            }
        });
        registerModule("KTIKernelFlashTransferService", new a() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFlashTransferBaseActivity$createExternalModules$2
            @Override // com.tencent.kuikly.core.pager.a
            public final Module createModule() {
                return new IKernelFlashTransferService();
            }
        });
        return super.createExternalModules();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onCreatePager(String str, e eVar) {
        if (currentFileActivityCount <= 0) {
            KLog.INSTANCE.i("QQFlashTransferBaseActivity", "CGManager.usePerformanceGCMode");
        }
        currentFileActivityCount = Math.max(currentFileActivityCount + 1, 1);
        super.onCreatePager(str, eVar);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public void onDestroy() {
        super.onDestroy();
        int max = Math.max(currentFileActivityCount - 1, 0);
        currentFileActivityCount = max;
        if (max <= 0) {
            KLog.INSTANCE.i("QQFlashTransferBaseActivity", "CGManager.useDefaultGCMode");
        }
    }
}

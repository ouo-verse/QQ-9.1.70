package com.tencent.mobileqq.mini.entry.expDesktop.part;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.IRefreshStatusListener;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopPartHost$getMiniRefreshStatusListener$1", "Lcom/tencent/mobileqq/mini/entry/IRefreshStatusListener;", "onReleaseToRefresh", "", "onReleaseToTwoLevel", "onTwoLevelRelease", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopPartHost$getMiniRefreshStatusListener$1 implements IRefreshStatusListener {
    final /* synthetic */ MiniAppExpDesktopPartHost this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniAppExpDesktopPartHost$getMiniRefreshStatusListener$1(MiniAppExpDesktopPartHost miniAppExpDesktopPartHost) {
        this.this$0 = miniAppExpDesktopPartHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTwoLevelRelease$lambda$0() {
        AppBrandLaunchManager.g().onMiniAppUIOpen();
    }

    @Override // com.tencent.mobileqq.mini.entry.IRefreshStatusListener
    public void onReleaseToRefresh() {
        QLog.i(this.this$0.getViewTagData().toString(), 1, "onReleaseToRefresh");
    }

    @Override // com.tencent.mobileqq.mini.entry.IRefreshStatusListener
    public void onReleaseToTwoLevel() {
        QLog.i(this.this$0.getViewTagData().toString(), 1, "onReleaseToTwoLevel");
    }

    @Override // com.tencent.mobileqq.mini.entry.IRefreshStatusListener
    public void onTwoLevelRelease() {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i(this.this$0.getViewTagData().toString(), 1, "onTwoLevelRelease");
        this.this$0.miniAppDesktopOpen();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.o
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopPartHost$getMiniRefreshStatusListener$1.onTwoLevelRelease$lambda$0();
            }
        }, 128, null, true);
        MiniAppUtils.asyncMiniAppDesktopOpenCostReport(Long.valueOf(currentTimeMillis));
    }
}

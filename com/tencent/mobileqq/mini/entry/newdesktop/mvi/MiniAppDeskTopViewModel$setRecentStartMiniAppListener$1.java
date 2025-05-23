package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.RecentStartMiniAppListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel$setRecentStartMiniAppListener$1", "Lcom/tencent/mobileqq/mini/entry/newdesktop/RecentStartMiniAppListener;", "recentStartMiniApp", "", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDeskTopViewModel$setRecentStartMiniAppListener$1 implements RecentStartMiniAppListener {
    final /* synthetic */ MiniAppDeskTopViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniAppDeskTopViewModel$setRecentStartMiniAppListener$1(MiniAppDeskTopViewModel miniAppDeskTopViewModel) {
        this.this$0 = miniAppDeskTopViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recentStartMiniApp$lambda$0(MiniAppDeskTopViewModel this$0, MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppInfo, "$miniAppInfo");
        this$0.updateRecentStartMiniAppInfo(miniAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.RecentStartMiniAppListener
    public void recentStartMiniApp(final MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        final MiniAppDeskTopViewModel miniAppDeskTopViewModel = this.this$0;
        miniAppDeskTopViewModel.runningInMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDeskTopViewModel$setRecentStartMiniAppListener$1.recentStartMiniApp$lambda$0(MiniAppDeskTopViewModel.this, miniAppInfo);
            }
        });
    }
}

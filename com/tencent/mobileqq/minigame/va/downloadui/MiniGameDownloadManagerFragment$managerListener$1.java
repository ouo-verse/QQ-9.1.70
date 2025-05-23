package com.tencent.mobileqq.minigame.va.downloadui;

import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import pb3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadManagerFragment$managerListener$1", "Lpb3/a;", "", "curCount", "", "onDownloadCountChanged", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameDownloadManagerFragment$managerListener$1 implements pb3.a {
    final /* synthetic */ MiniGameDownloadManagerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniGameDownloadManagerFragment$managerListener$1(MiniGameDownloadManagerFragment miniGameDownloadManagerFragment) {
        this.this$0 = miniGameDownloadManagerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDownloadCountChanged$lambda$0(MiniGameDownloadManagerFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setDownloadingCount(i3);
    }

    @Override // pb3.a
    public void onDownloadCountChanged(final int curCount) {
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final MiniGameDownloadManagerFragment miniGameDownloadManagerFragment = this.this$0;
        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameDownloadManagerFragment$managerListener$1.onDownloadCountChanged$lambda$0(MiniGameDownloadManagerFragment.this, curCount);
            }
        });
    }

    @Override // pb3.a
    public void onDownloadingCountChanged(int i3) {
        a.C10996a.b(this, i3);
    }

    @Override // pb3.a
    public void onTaskDelete(String str) {
        a.C10996a.c(this, str);
    }
}

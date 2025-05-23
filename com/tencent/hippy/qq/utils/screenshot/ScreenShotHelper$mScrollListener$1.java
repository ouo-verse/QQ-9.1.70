package com.tencent.hippy.qq.utils.screenshot;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$mScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class ScreenShotHelper$mScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ScreenShotHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScreenShotHelper$mScrollListener$1(ScreenShotHelper screenShotHelper) {
        this.this$0 = screenShotHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScrollStateChanged$lambda$0(ScreenShotHelper this$0, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        this$0.scrollAndCaptureRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull final RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0) {
            if (!recyclerView.canScrollVertically(-1)) {
                this.this$0.scrollAndCaptureRecyclerView(recyclerView);
            } else {
                final ScreenShotHelper screenShotHelper = this.this$0;
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.hippy.qq.utils.screenshot.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenShotHelper$mScrollListener$1.onScrollStateChanged$lambda$0(ScreenShotHelper.this, recyclerView);
                    }
                }, 16, null, true, 100L);
            }
        }
    }
}

package com.tencent.mobileqq.zplan.meme.frameanim;

import android.view.View;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import li3.BubbleReportData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&R\u0014\u0010\u0011\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "", "Lcom/tencent/mobileqq/zplan/bubble/b;", "bubbleController", "", "e", "Lli3/a;", "data", "b", "", "needTimeout", "d", "a", "release", "Landroid/view/View;", "f", "()Landroid/view/View;", "overlayView", "Landroidx/lifecycle/LiveData;", "c", "()Landroidx/lifecycle/LiveData;", "isShowingOverlay", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(e eVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                eVar.d(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadingStart");
        }
    }

    void a();

    void b(@NotNull BubbleReportData data);

    @NotNull
    LiveData<Boolean> c();

    void d(boolean needTimeout);

    void e(@Nullable com.tencent.mobileqq.zplan.bubble.b bubbleController);

    @NotNull
    View f();

    void release();
}

package b42;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateView;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&\u00a8\u0006\u0016"}, d2 = {"Lb42/b;", "", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "callback", "", "isForce", "", "a", "fullScreen", "c", "", "text", "g", "Lcom/tencent/mobileqq/icgame/room/touchdelegate/TouchDelegateView;", "f", "Landroid/view/View;", "e", "d", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/LinearLayout;", "b", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b {
    void a(@Nullable OnQueryGiftIconCallback callback, boolean isForce);

    @Nullable
    LinearLayout b();

    void c(boolean fullScreen);

    @Nullable
    View d();

    @Nullable
    View e();

    @Nullable
    TouchDelegateView f();

    void g(@NotNull String text);

    @Nullable
    FrameLayout h();
}

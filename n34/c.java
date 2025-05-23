package n34;

import android.widget.ImageView;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Ln34/c;", "", "", "uin", "Landroid/widget/ImageView;", "targetView", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f418125a = new c();

    c() {
    }

    public final void a(@NotNull String uin, @NotNull ImageView targetView) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.q(targetView.getContext(), 1, uin);
        targetView.setImageDrawable(qQProAvatarDrawable);
    }
}

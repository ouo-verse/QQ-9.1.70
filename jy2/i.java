package jy2;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.view.ToastTipView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Ljy2/i;", "", "Landroid/view/ViewGroup;", "viewGroup", "", "tips", "", "c", "a", "", "duration", "b", "(Ljava/lang/String;Ljava/lang/Integer;)V", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f411173a = new i();

    i() {
    }

    public final void a(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        ToastTipView toastTipView = (ToastTipView) viewGroup.findViewById(R.id.f112786ov);
        if (toastTipView != null) {
            toastTipView.f();
        }
        viewGroup.setVisibility(8);
    }

    public final void b(@NotNull String tips, @Nullable Integer duration) {
        ViewGroup viewGroup;
        int i3;
        Intrinsics.checkNotNullParameter(tips, "tips");
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null || topActivity.isFinishing() || (viewGroup = (ViewGroup) topActivity.findViewById(android.R.id.content)) == null) {
            return;
        }
        ToastTipView toastTipView = new ToastTipView(topActivity, null, 0, 0, 14, null);
        toastTipView.setId(R.id.f112766ot);
        viewGroup.addView(toastTipView, new ViewGroup.LayoutParams(-1, -1));
        toastTipView.setText(tips);
        if (duration != null) {
            i3 = duration.intValue();
        } else {
            i3 = 3000;
        }
        toastTipView.j(i3);
    }

    public final void c(@NotNull ViewGroup viewGroup, @NotNull String tips) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(tips, "tips");
        ToastTipView toastTipView = (ToastTipView) viewGroup.findViewById(R.id.f112786ov);
        if (toastTipView == null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
            toastTipView = new ToastTipView(context, null, 0, 0, 14, null);
            toastTipView.setId(R.id.f112786ov);
            viewGroup.addView(toastTipView, new ViewGroup.LayoutParams(-1, -1));
        }
        toastTipView.setText(tips);
        toastTipView.j(3000);
        viewGroup.setVisibility(0);
    }
}

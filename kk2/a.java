package kk2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lkk2/a;", "", "Landroid/app/Dialog;", ToastView.ICON_LOADING, "", "a", "", "b", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f412601a = new a();

    a() {
    }

    private final boolean a(Dialog loading) {
        if (!loading.isShowing()) {
            return false;
        }
        Context context = loading.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "loading.context");
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialogContext.baseContext");
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return false;
            }
        }
        return true;
    }

    public final void b(@NotNull Dialog loading) {
        Intrinsics.checkNotNullParameter(loading, "loading");
        if (a(loading)) {
            try {
                loading.dismiss();
            } catch (IllegalArgumentException unused) {
                QLog.e("DialogUtils", 1, "dialog dismiss IllegalArgumentException");
            }
        }
    }
}

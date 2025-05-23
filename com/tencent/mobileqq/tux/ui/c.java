package com.tencent.mobileqq.tux.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/tux/ui/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/lang/Runnable;", "runnable", "", "e", "c", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "dismissListener", "d", "b", "", "toastType", "f", "Lcom/tencent/mobileqq/tux/ui/a;", "a", "Lcom/tencent/mobileqq/tux/ui/a;", "mTuxPopupDialog", "<init>", "()V", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mTuxPopupDialog;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(Activity activity, Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            activity.runOnUiThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    QQToast.makeText(activity, 1, R.string.f236827fe, 0).show();
                    return;
                }
                return;
            }
            QQToast.makeText(activity, 0, R.string.f236817fd, 0).show();
            return;
        }
        QQToast.makeText(activity, 2, R.string.f236837ff, 0).show();
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a aVar = this.mTuxPopupDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
        this.mTuxPopupDialog = null;
    }

    @Nullable
    public final Activity c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return QBaseActivity.sTopActivity;
        }
        return topActivity;
    }

    public final void d(@NotNull Context context, @NotNull View view, @Nullable QUSBaseHalfScreenFloatingView.l dismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, view, dismissListener);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        a aVar = this.mTuxPopupDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
        a aVar2 = new a(context, view, dismissListener);
        aVar2.show();
        this.mTuxPopupDialog = aVar2;
    }

    public final void f(final int toastType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, toastType);
            return;
        }
        final Activity c16 = c();
        if (c16 != null) {
            e(c16, new Runnable() { // from class: com.tencent.mobileqq.tux.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.g(toastType, c16);
                }
            });
        }
    }
}

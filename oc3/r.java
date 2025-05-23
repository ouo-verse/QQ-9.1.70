package oc3;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JT\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Loc3/r;", "", "Landroid/content/Context;", "context", "", "title", "msg", "negativeBtnTxt", "Landroid/content/DialogInterface$OnClickListener;", "negativeBtnListener", "positiveBtnTxt", "positiveBtnListener", "", "cancelable", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f422495a = new r();

    r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, String title, String msg2, String negativeBtnTxt, DialogInterface.OnClickListener onClickListener, String positiveBtnTxt, DialogInterface.OnClickListener onClickListener2, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(negativeBtnTxt, "$negativeBtnTxt");
        Intrinsics.checkNotNullParameter(positiveBtnTxt, "$positiveBtnTxt");
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle(title);
        qQCustomDialog.setMessage(msg2);
        qQCustomDialog.setNegativeButton(negativeBtnTxt, onClickListener);
        qQCustomDialog.setPositiveButton(positiveBtnTxt, onClickListener2);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(z16);
        try {
            qQCustomDialog.show();
            QLog.i("Minors_UiUtils", 1, "showDialog context:" + context + ", title:" + title + ", msg:" + msg2 + " succeed!");
        } catch (Exception e16) {
            QLog.e("UiUtils", 1, "showDialog error", e16);
        }
    }

    public final void b(final Context context, final String title, final String msg2, final String negativeBtnTxt, final DialogInterface.OnClickListener negativeBtnListener, final String positiveBtnTxt, final DialogInterface.OnClickListener positiveBtnListener, final boolean cancelable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(negativeBtnTxt, "negativeBtnTxt");
        Intrinsics.checkNotNullParameter(positiveBtnTxt, "positiveBtnTxt");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: oc3.q
            @Override // java.lang.Runnable
            public final void run() {
                r.d(context, title, msg2, negativeBtnTxt, negativeBtnListener, positiveBtnTxt, positiveBtnListener, cancelable);
            }
        }, 1000L);
    }
}

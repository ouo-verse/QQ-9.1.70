package com.tencent.open.agent.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AuthUIUtil {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f340595d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MaxHeightScrollView f340596e;

        a(Activity activity, MaxHeightScrollView maxHeightScrollView) {
            this.f340595d = activity;
            this.f340596e = maxHeightScrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (al.f(this.f340595d) && ScreenUtil.isNavigationBarExist(this.f340595d)) {
                this.f340596e.setMaxHeight(this.f340596e.a() - al.d(this.f340595d));
            }
            int top = ((View) this.f340595d.findViewById(R.id.root).getParent()).getTop();
            if (top > 0) {
                MaxHeightScrollView maxHeightScrollView = this.f340596e;
                maxHeightScrollView.setMaxHeight(maxHeightScrollView.a() - top);
            }
            this.f340596e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public static void a(MaxHeightScrollView maxHeightScrollView, Activity activity) {
        maxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new a(activity, maxHeightScrollView));
    }

    public static ActionSheet b(Context context, View view) {
        ActionSheet create = ActionSheet.create(context, -1, null);
        create.setActionContentView(view, null);
        return create;
    }

    public static void c(Activity activity, Dialog dialog) {
        t.e("AuthUIUtil", "dismissDialog");
        if (activity != null && !activity.isFinishing()) {
            if (dialog != null && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e16) {
                    t.d("AuthUIUtil", "Exception", e16);
                    return;
                }
            }
            t.e("AuthUIUtil", "dismissDialog dialog is invalid");
            return;
        }
        t.e("AuthUIUtil", "dismissDialog activity is invalid");
    }

    public static String d(Bundle bundle) {
        String string = bundle.getString("sdkp");
        if ("web".equals(string)) {
            return HardCodeUtil.qqStr(R.string.jso);
        }
        if ("android".equals(string)) {
            return HardCodeUtil.qqStr(R.string.jsu);
        }
        return HardCodeUtil.qqStr(R.string.jst);
    }

    private static void e(Dialog dialog) {
        try {
            dialog.show();
        } catch (Exception e16) {
            t.a("AuthUIUtil", "showProgressDialog", e16);
        }
    }

    public static void f(Activity activity, String str, DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            DialogUtil.createCustomDialogUrl(activity, 230).setMessageWithUrl(str).setTitle(activity.getString(R.string.h5k)).setPositiveButton(android.R.string.ok, onClickListener).show();
            return;
        }
        t.e("AuthUIUtil", "showDialog activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
    }

    public static void g(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            QQCustomDialog positiveButton = DialogUtil.createCustomDialogUrl(activity, 230).setMessageWithUrl(str2).setTitle(str).setPositiveButton(android.R.string.ok, onClickListener);
            positiveButton.setCanceledOnTouchOutside(false);
            positiveButton.show();
        } else {
            t.e("AuthUIUtil", "showDialog activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
        }
    }

    public static void h(Context context, String str) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str);
        builder.setNegativeButton(HardCodeUtil.qqStr(R.string.oyu), new b());
        builder.show();
    }

    @TargetApi(17)
    public static void i(String str, Activity activity, DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing()) {
            if (activity.isDestroyed()) {
                t.b("AuthUIUtil", "activity isDestroyed");
                return;
            } else {
                DialogUtil.createCustomDialogUrl(activity, 230).setMessageWithUrl(str).setTitle(activity.getString(R.string.h5k)).setPositiveButton(android.R.string.ok, onClickListener).show();
                return;
            }
        }
        t.b("AuthUIUtil", "activity invalid");
    }

    public static void j(Activity activity, int i3) {
        QQToast.makeText(activity, 1, HardCodeUtil.qqStr(i3), 0).show();
    }

    public static QQProgressDialog k(Activity activity, QQProgressDialog qQProgressDialog, int i3) {
        t.e("AuthUIUtil", UIJsPlugin.EVENT_SHOW_LOADING);
        if (activity != null && !activity.isFinishing()) {
            if (qQProgressDialog == null) {
                QQProgressDialog qQProgressDialog2 = new QQProgressDialog(activity, 0, i3, 17);
                qQProgressDialog2.setHeightParams(-1);
                e(qQProgressDialog2);
                return qQProgressDialog2;
            }
            if (!qQProgressDialog.isShowing()) {
                e(qQProgressDialog);
                return qQProgressDialog;
            }
            return qQProgressDialog;
        }
        t.f("AuthUIUtil", "showLoading activity is finishing");
        return null;
    }

    public static void l(final Activity activity, final String str, final boolean z16) {
        if (activity != null && !activity.isFinishing()) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.util.AuthUIUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast qQToast = new QQToast(activity);
                    if (z16) {
                        qQToast.setToastIcon(QQToast.getIconRes(2));
                    } else {
                        qQToast.setToastIcon(QQToast.getIconRes(1));
                    }
                    qQToast.setDuration(1);
                    qQToast.setToastMsg(str);
                    qQToast.show();
                }
            });
        } else {
            t.e("AuthUIUtil", "showToast activity is null/finished");
        }
    }
}

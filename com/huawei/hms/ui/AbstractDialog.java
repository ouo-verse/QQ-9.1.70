package com.huawei.hms.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.UIUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AbstractDialog {

    /* renamed from: a, reason: collision with root package name */
    private Activity f37635a;

    /* renamed from: b, reason: collision with root package name */
    private AlertDialog f37636b;

    /* renamed from: c, reason: collision with root package name */
    private Callback f37637c;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Callback {
        void onCancel(AbstractDialog abstractDialog);

        void onDoWork(AbstractDialog abstractDialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AbstractDialog.this.fireDoWork();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AbstractDialog.this.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AbstractDialog.this.fireCancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class d implements DialogInterface.OnKeyListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (4 == i3 && keyEvent.getAction() == 1) {
                AbstractDialog.this.cancel();
                return true;
            }
            return false;
        }
    }

    public void cancel() {
        AlertDialog alertDialog = this.f37636b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.f37636b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    protected void fireCancel() {
        Callback callback = this.f37637c;
        if (callback != null) {
            callback.onCancel(this);
        }
    }

    protected void fireDoWork() {
        Callback callback = this.f37637c;
        if (callback != null) {
            callback.onDoWork(this);
        }
    }

    protected Activity getActivity() {
        return this.f37635a;
    }

    protected int getDialogThemeId() {
        return UIUtil.getDialogThemeId(getActivity());
    }

    protected AlertDialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getDialogThemeId());
        String onGetTitleString = onGetTitleString(activity);
        if (onGetTitleString != null) {
            builder.setTitle(onGetTitleString);
        }
        String onGetMessageString = onGetMessageString(activity);
        if (onGetMessageString != null) {
            builder.setMessage(onGetMessageString);
        }
        String onGetPositiveButtonString = onGetPositiveButtonString(activity);
        if (onGetPositiveButtonString != null) {
            builder.setPositiveButton(onGetPositiveButtonString, new a());
        }
        String onGetNegativeButtonString = onGetNegativeButtonString(activity);
        if (onGetNegativeButtonString != null) {
            builder.setNegativeButton(onGetNegativeButtonString, new b());
        }
        return builder.create();
    }

    protected abstract String onGetMessageString(Context context);

    protected abstract String onGetNegativeButtonString(Context context);

    protected abstract String onGetPositiveButtonString(Context context);

    protected abstract String onGetTitleString(Context context);

    public void setMessage(CharSequence charSequence) {
        AlertDialog alertDialog = this.f37636b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        AlertDialog alertDialog = this.f37636b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(Activity activity, Callback callback) {
        this.f37635a = activity;
        this.f37637c = callback;
        if (activity != null && !activity.isFinishing()) {
            AlertDialog onCreateDialog = onCreateDialog(this.f37635a);
            this.f37636b = onCreateDialog;
            onCreateDialog.setCanceledOnTouchOutside(false);
            this.f37636b.setOnCancelListener(new c());
            this.f37636b.setOnKeyListener(new d());
            this.f37636b.show();
            return;
        }
        HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
    }
}

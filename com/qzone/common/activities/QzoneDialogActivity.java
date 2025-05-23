package com.qzone.common.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDialogActivity extends BaseFragment {
    private static final String G = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleTrafficTips", "\u6b63\u5728\u4f7f\u7528\u8fd0\u8425\u5546\u7f51\u7edc\uff0c\u7ee7\u7eed\u4e0b\u8f7d\u89c6\u9891\u5c06\u6d88\u8017\u6d41\u91cf");
    private static final String H = l.a(R.string.j6l);
    private static final String I = l.a(R.string.rqy);
    private static WeakReference<DialogInterface.OnClickListener> J;
    private static WeakReference<DialogInterface.OnClickListener> K;
    private static WeakReference<DialogInterface.OnCancelListener> L;
    private QQCustomDialog C;
    private String D;
    private String E;
    private String F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener;
            if (QzoneDialogActivity.K != null && (onClickListener = (DialogInterface.OnClickListener) QzoneDialogActivity.K.get()) != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            QzoneDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener;
            if (QzoneDialogActivity.J != null && (onClickListener = (DialogInterface.OnClickListener) QzoneDialogActivity.J.get()) != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            QzoneDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DialogInterface.OnCancelListener onCancelListener;
            if (QzoneDialogActivity.L != null && (onCancelListener = (DialogInterface.OnCancelListener) QzoneDialogActivity.L.get()) != null) {
                onCancelListener.onCancel(dialogInterface);
            }
            QzoneDialogActivity.this.finish();
        }
    }

    private void dismissDialog() {
        QLog.d("QzoneDialogActivity", 1, "DialogActivity dimissDialog dialog=" + this.C);
        QQCustomDialog qQCustomDialog = this.C;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            finish();
            this.C = null;
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.D = intent.getStringExtra("extra_dialog_msg_text");
            this.E = intent.getStringExtra("extra_dialog_neg_btn_text");
            this.F = intent.getStringExtra("extra_dialog_pos_btn_text");
        }
        if (TextUtils.isEmpty(this.D)) {
            this.D = G;
        }
        if (TextUtils.isEmpty(this.E)) {
            this.E = H;
        }
        if (TextUtils.isEmpty(this.F)) {
            this.F = I;
        }
    }

    private void showDialog() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        this.C = createCustomDialog;
        createCustomDialog.setMessage(this.D);
        this.C.setNegativeButton(this.E, new a());
        this.C.setPositiveButton(this.F, new b());
        this.C.setOnCancelListener(new c());
        yh(this.C);
    }

    private static void wh(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        K = new WeakReference<>(onClickListener);
        J = new WeakReference<>(onClickListener2);
        L = new WeakReference<>(onCancelListener);
    }

    public static void xh(Bundle bundle, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        wh(onClickListener, onClickListener2, onCancelListener);
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) JumpActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.addFlags(131072);
        intent.setData(Uri.parse("mqqapi://qzone/to_qzone_dialog"));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        BaseApplication.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(final QQCustomDialog qQCustomDialog) {
        QLog.d("QzoneDialogActivity", 1, "showDialog dialog=" + qQCustomDialog);
        try {
            qQCustomDialog.show();
        } catch (WindowManager.BadTokenException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QzoneDialogActivity", 2, "showDialog ", e16);
            }
            getWindow().getDecorView().post(new Runnable() { // from class: com.qzone.common.activities.QzoneDialogActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    QzoneDialogActivity.this.yh(qQCustomDialog);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getWindow().setBackgroundDrawable(null);
        initData();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismissDialog();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showDialog();
    }
}

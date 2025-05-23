package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.cw;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Dialog f211020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f211021d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f211022e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f211023f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f211024h;

        a(Intent intent, int i3, Activity activity, QQAppInterface qQAppInterface) {
            this.f211021d = intent;
            this.f211022e = i3;
            this.f211023f = activity;
            this.f211024h = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, intent, Integer.valueOf(i3), activity, qQAppInterface);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            long longExtra = this.f211021d.getLongExtra("sdk_mult_share_source_app_id", 0L);
            int intExtra = this.f211021d.getIntExtra("sdk_mult_share_msg_service_id", 0);
            if (i3 != 0) {
                if (i3 == 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ForwardDialogMgr", 2, "-->showMultShareDialog--stay");
                    }
                    int i16 = this.f211022e;
                    if (i16 == 901503) {
                        x.p(this.f211023f, "shareToQQ", longExtra, 0, x.f211080d);
                    } else if (i16 == 3) {
                        x.e(longExtra, intExtra, this.f211023f, null);
                    } else {
                        x.q(longExtra, intExtra, this.f211023f);
                    }
                    int i17 = this.f211022e;
                    if (i17 == 1) {
                        ForwardUtils.h0(this.f211024h, "0X800A73F", new String[0]);
                        return;
                    }
                    if (i17 == 0) {
                        ForwardUtils.h0(this.f211024h, "0X800A73B", new String[0]);
                        return;
                    } else {
                        if (i17 == 2 || i17 == 901503) {
                            ForwardUtils.h0(this.f211024h, "0X800A73D", new String[0]);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ForwardDialogMgr", 2, "-->showMultShareDialog--back");
            }
            if (this.f211022e == 2) {
                x.p(this.f211023f, "shareToQQ", longExtra, 0, x.f211080d);
            } else {
                x.e(longExtra, intExtra, this.f211023f, null);
            }
            int i18 = this.f211022e;
            if (i18 == 1) {
                ForwardUtils.h0(this.f211024h, "0X800A740", new String[0]);
                return;
            }
            if (i18 == 0) {
                ForwardUtils.h0(this.f211024h, "0X800A73C", new String[0]);
            } else if (i18 == 2 || i18 == 901503) {
                ForwardUtils.h0(this.f211024h, "0X800A73E", new String[0]);
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(Activity activity, Intent intent) {
        if (activity != null && !activity.isFinishing()) {
            if (!intent.getBooleanExtra("sdk_mult_share", false)) {
                return;
            }
            ForwardStatisticsReporter.c("KEY_STAGE_2_TOTAL");
            intent.removeExtra("sdk_mult_share");
            String num = Integer.toString(intent.getIntExtra("sdk_mult_share_total_count", 0));
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (intent.getBooleanExtra("sdk_mult_share_for_local", false)) {
                QLog.d("ForwardDialogMgr", 1, "showMultShareDialog SDK_MULT_SHARE_FOR_LOCAL");
                QQToast.makeText(qQAppInterface.getApp(), 2, R.string.f170969bc3, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                ForwardUtils.h0(qQAppInterface, "0X800A738", num);
                return;
            }
            int intExtra = intent.getIntExtra("sdk_mult_share_result_code", -1);
            a aVar = new a(intent, intExtra, activity, qQAppInterface);
            QLog.d("ForwardDialogMgr", 1, "-->showMultShareDialog--RESULT_CODE=", Integer.valueOf(intExtra), ", count=", num);
            if (901503 == intExtra) {
                ForwardUtils.h0(qQAppInterface, "0X800A739", num);
                c(activity, intent.getStringExtra("sdk_mult_share_error_wording"), aVar);
                return;
            }
            if (intExtra == 0) {
                ForwardUtils.h0(qQAppInterface, "0X800A738", num);
                e(activity, intent, HardCodeUtil.qqStr(R.string.hik), aVar);
                return;
            }
            if (2 == intExtra) {
                ForwardUtils.h0(qQAppInterface, "0X800A739", num);
                e(activity, intent, HardCodeUtil.qqStr(R.string.hij), aVar);
                return;
            } else if (1 == intExtra) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("sdk_mult_share_fail_record");
                ForwardUtils.h0(qQAppInterface, "0X800A73A", num, Integer.toString(parcelableArrayListExtra.size()));
                d(activity, intent, parcelableArrayListExtra, aVar);
                return;
            } else {
                if (3 == intExtra) {
                    ForwardUtils.h0(qQAppInterface, "0X800A739", num);
                    c(activity, intent.getStringExtra("sdk_mult_share_error_wording"), aVar);
                    return;
                }
                return;
            }
        }
        QLog.e("ForwardDialogMgr", 1, "-->showMultShareDialog: (null == activity) || activity.isFinishing()");
    }

    public static void c(Activity activity, String str, DialogInterface.OnClickListener onClickListener) {
        QLog.d("ForwardDialogMgr", 1, "showOtherErrorDialog errorMsg=", str);
        if (activity != null && !activity.isFinishing()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
            createCustomDialog.setMessage(str);
            createCustomDialog.setPositiveButton(R.string.f171151ok, onClickListener);
            createCustomDialog.show();
            return;
        }
        QLog.e("ForwardDialogMgr", 1, "showOtherErrorDialog null == activity || activity.isFinishing()");
    }

    protected static void d(Activity activity, Intent intent, List<ResultRecord> list, DialogInterface.OnClickListener onClickListener) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        cw cwVar = new cw(activity, R.style.qZoneInputDialog);
        cwVar.setContentView(R.layout.c7t);
        cwVar.b0(qQAppInterface, activity, list, false);
        cwVar.Z(String.format(activity.getResources().getString(R.string.vri), Integer.valueOf(list.size())));
        cwVar.R();
        cwVar.setNegativeButton(x.m(intent.getStringExtra("sdk_mult_share_app_name")), onClickListener);
        cwVar.setPositiveButton(HardCodeUtil.qqStr(R.string.hii), onClickListener);
        cwVar.findViewById(R.id.mah).setVisibility(8);
        cwVar.show();
    }

    protected static void e(Activity activity, Intent intent, String str, DialogInterface.OnClickListener onClickListener) {
        try {
            DialogUtil.createCustomDialog(activity, 232, (String) null, str, x.m(intent.getStringExtra("sdk_mult_share_app_name")), HardCodeUtil.qqStr(R.string.hii), onClickListener, onClickListener).show();
        } catch (Throwable th5) {
            QLog.e("ForwardDialogMgr", 1, "-->showShareResultDialog: failed. ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity) {
        Dialog dialog;
        if (!activity.isFinishing() && (dialog = this.f211020a) != null && dialog.isShowing()) {
            this.f211020a.dismiss();
            this.f211020a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Activity activity) {
        a(activity);
        ReportDialog reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
        this.f211020a = reportDialog;
        reportDialog.setCancelable(false);
        this.f211020a.setContentView(R.layout.f168383uh);
        ((TextView) this.f211020a.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(HardCodeUtil.qqStr(R.string.vrj));
        this.f211020a.show();
    }
}

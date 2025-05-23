package com.qzone.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f59799d;

        a(Activity activity) {
            this.f59799d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            yo.d.b(this.f59799d, new yo.g(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_REOPEN_QZONE, "https://h5.qzone.qq.com/qzone/openguide/index?_proxy=1&_wv=67108867")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f59800d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f59801e;

        b(boolean z16, Activity activity) {
            this.f59800d = z16;
            this.f59801e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f59800d) {
                this.f59801e.finish();
            }
        }
    }

    public static void a(Activity activity, boolean z16) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "OpenNewQzoneTitle", "\u4f60\u5df2\u6ce8\u9500\u4f60\u7684\u7a7a\u95f4");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "OpenNewQzoneMsg", "\u5df2\u4e3a\u4f60\u6e05\u7a7a\u7a7a\u95f4\u6240\u6709\u8d44\u6599\uff1b\u5982\u679c\u4f60\u60f3\u91cd\u8fd4\u7a7a\u95f4\uff0c\u53ef\u91cd\u65b0\u7533\u8bf7\u4e00\u4e2a\u65b0\u7a7a\u95f4\uff0c\u4f60\u7684\u65e7\u8d44\u6599\u548c\u65e7\u8bbe\u7f6e\u5747\u4e0d\u4f1a\u4fdd\u5b58");
        String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "OpenNewQzoneButton", "\u5f00\u901a\u65b0\u7a7a\u95f4");
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(config);
        qQCustomDialog.setMessage(config2);
        qQCustomDialog.setTitleMutiLine();
        qQCustomDialog.setPositiveButton(config3, new a(activity));
        qQCustomDialog.setNegativeButton(activity.getResources().getString(R.string.w5w), new b(z16, activity));
        try {
            qQCustomDialog.show();
        } catch (Exception e16) {
            QZLog.e("CanelQzoneDialogUtil", "CanelQzoneDialogUtil failed ", e16);
        }
    }
}

package com.qzone.util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f59827d;

        a(Context context) {
            this.f59827d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LocalMultiProcConfig.putInt4Uin("qzone_jinyan", 0, LoginData.getInstance().getUin());
            yo.d.d(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_DISABLE_FORBID_COMMENT, "https://kf.qq.com/touch/qzone/qzone_rm_forbit_com_app.html?platform=14&ADTAG=veda.qzone.qqapp&tj_src=qqapp"), this.f59827d, null);
        }
    }

    public static boolean a(int i3) {
        if (i3 == -4015) {
            return true;
        }
        return false;
    }

    public static boolean b(Handler handler) {
        if (LocalMultiProcConfig.getInt4Uin("qzone_jinyan", 0, LoginData.getInstance().getUin()) != 32768) {
            return false;
        }
        handler.sendEmptyMessage(-4015);
        return true;
    }

    public static void c(Context context) {
        d(context, -4015);
    }

    public static void d(Context context, int i3) {
        if (i3 == -4015) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogApplyUnban", "\u7533\u8bf7\u89e3\u7981");
            QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.custom_dialog);
            qQCustomDialog.setTitle((String) null);
            qQCustomDialog.setMessage(R.string.ggo);
            qQCustomDialog.setPositiveButton(config, new a(context));
            qQCustomDialog.setNegativeButton(l.a(R.string.j6l), new b());
            try {
                qQCustomDialog.show();
            } catch (Exception e16) {
                QZLog.e("JinYanUtils", "showJinYanDialog failed ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

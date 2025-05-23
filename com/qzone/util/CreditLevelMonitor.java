package com.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CreditLevelMonitor {

    /* renamed from: b, reason: collision with root package name */
    public static CreditLevelMonitor f59728b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Object f59729c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static String f59730d = "credit_bg_cnt";

    /* renamed from: a, reason: collision with root package name */
    private QQCustomDialog f59731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f59732d;

        a(Activity activity) {
            this.f59732d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            CreditLevelMonitor.this.a(this.f59732d, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f59734d;

        b(Activity activity) {
            this.f59734d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f59734d.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f59736d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f59737e;

        c(boolean z16, Context context) {
            this.f59736d = z16;
            this.f59737e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f59736d) {
                Context context = this.f59737e;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public static CreditLevelMonitor c() {
        if (f59728b == null) {
            synchronized (f59729c) {
                if (f59728b == null) {
                    f59728b = new CreditLevelMonitor();
                }
            }
        }
        return f59728b;
    }

    public static boolean f(String str) {
        int int4Uin = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, LoginData.getInstance().getUin());
        if (int4Uin == 7) {
            String j06 = u5.b.j0(f59730d + str, "", LoginData.getInstance().getUin());
            Calendar calendar = Calendar.getInstance();
            String str2 = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (!j06.equals(str2)) {
                u5.b.x0(f59730d + str, str2, LoginData.getInstance().getUin());
                QZLog.e("CreditLevelMonitor", "creditlevel:" + int4Uin);
                return true;
            }
        }
        return false;
    }

    public void a(Context context, boolean z16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.util.CreditLevelMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("appname", "appeal"));
                    arrayList.add(new BasicNameValuePair("subapp", "qzone"));
                    arrayList.add(new BasicNameValuePair("jubaotype", "uin"));
                    arrayList.add(new BasicNameValuePair("uin", LoginData.getInstance().getUinString()));
                    arrayList.add(new BasicNameValuePair("langcode", "chs"));
                    arrayList.add(new BasicNameValuePair("app_param", "from=m_qzone&langcode=chs&encode=utf8&uin=" + LoginData.getInstance().getUinString()));
                    to.e.f(BaseApplication.getContext(), "https://jubao.qq.com/cn/appeal/appeal_end", new UrlEncodedFormEntity(arrayList, "UTF-8"), "https://jubao.qq.com/cn/appeal/appeal");
                } catch (Exception e16) {
                    QZLog.e("CreditLevelMonitor", "", e16);
                }
            }
        });
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogComplainMessage", "\u7533\u8bc9\u5df2\u6210\u529f\u63d0\u4ea4\uff0c\u5de5\u4f5c\u4eba\u5458\u5c06\u57281-3\u4e2a\u5de5\u4f5c\u65e5\u5185\u4e3a\u4f60\u5904\u7406\uff0c\u8bf7\u4f60\u7559\u610fQQ\u90ae\u7bb1\uff0c\u8bf7\u52ff\u91cd\u590d\u7533\u8bc9");
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(config);
        qQCustomDialog.setTitleMutiLine();
        qQCustomDialog.setPositiveButton(l.a(R.string.l5a), new c(z16, context));
        try {
            qQCustomDialog.show();
        } catch (Exception e16) {
            QZLog.e("CreditLevelMonitor", "appealForLowCreditLevel show dialog failed ", e16);
        }
    }

    public void b(Handler handler) {
        int int4Uin = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, LoginData.getInstance().getUin());
        if (int4Uin == 8) {
            String string4Uin = LocalMultiProcConfig.getString4Uin("creditmessage", "", LoginData.getInstance().getUin());
            handler.obtainMessage(-88, string4Uin).sendToTarget();
            QZLog.e("CreditLevelMonitor", "creditlevel:" + int4Uin + " message:" + string4Uin);
        }
    }

    public void e(Activity activity, String str) {
        QQCustomDialog qQCustomDialog = this.f59731a;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f59731a.dismiss();
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogComplainButton", "\u6211\u8981\u7533\u8bc9");
        QQCustomDialog qQCustomDialog2 = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        this.f59731a = qQCustomDialog2;
        qQCustomDialog2.setCancelable(false);
        this.f59731a.setCanceledOnTouchOutside(false);
        this.f59731a.setContentView(R.layout.f167856jn);
        this.f59731a.setTitle(str);
        this.f59731a.setTitleMutiLine();
        this.f59731a.setPositiveButton(config, new a(activity));
        this.f59731a.setNegativeButton(l.a(R.string.j6l), new b(activity));
        try {
            this.f59731a.show();
        } catch (Exception e16) {
            QZLog.e("CreditLevelMonitor", "showAppealDialog failed ", e16);
        }
    }

    public void d() {
        this.f59731a = null;
    }
}

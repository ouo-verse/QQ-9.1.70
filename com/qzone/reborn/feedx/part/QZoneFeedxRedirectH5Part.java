package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Intent;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.lang.ref.WeakReference;

/* loaded from: classes37.dex */
public class QZoneFeedxRedirectH5Part extends g {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class IntentFactoryRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Activity> f54958d;

        /* renamed from: e, reason: collision with root package name */
        private final Intent f54959e;

        IntentFactoryRunnable(Activity activity, Intent intent) {
            this.f54958d = new WeakReference<>(activity);
            this.f54959e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f54958d.get() != null) {
                com.qzone.common.activities.base.ak.Q(this.f54958d.get(), this.f54959e, 102);
            }
        }
    }

    private void D9() {
        try {
            if (F9()) {
                G9();
            }
        } catch (Exception e16) {
            QLog.e("QZoneFeedxRedirectH5Part", 1, e16, new Object[0]);
        }
    }

    private void E9() {
        yo.d.d(yo.f.j(yo.f.j(yo.f.j(yo.f.j(yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VIP_PROFILE, "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&qua={qua}&trace_detail=%7B%22appid%22:%22MoreAN%22%7D"), "{uin}", LoginData.getInstance().getUinString()), "{from}", "ANDinqq"), "{qua}", QUA.getQUA3()), "{aid}", "jh"), "{source}", "xinxi"), getActivity(), null);
        ClickReport.e(16, "", 322, 3, 5);
    }

    private boolean F9() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra("vipReminderFlag", false);
    }

    private void G9() {
        long j3;
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel(getTAG(), 127);
        }
        String string = getActivity().getResources().getString(R.string.h_9);
        if (getActivity().getIntent().getBooleanExtra("FromNotification", false)) {
            E9();
            j3 = 3000;
        } else {
            j3 = 0;
        }
        if (getActivity() == null) {
            return;
        }
        Intent r16 = com.qzone.common.activities.base.ak.r(getActivity(), "jhan_pushcuifei", string, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip());
        if (j3 != 0) {
            getMainHandler().postDelayed(new IntentFactoryRunnable(getActivity(), r16), j3);
        } else {
            com.qzone.common.activities.base.ak.Q(getActivity(), r16, 102);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxRedirectH5Part";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        D9();
    }
}

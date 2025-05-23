package com.tencent.gamecenter.wadl.notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.notification.e;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends h {

    /* renamed from: f, reason: collision with root package name */
    private static byte[] f106947f = new byte[0];

    /* renamed from: h, reason: collision with root package name */
    private static c f106948h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f106949a;

        a(int i3) {
            this.f106949a = i3;
        }

        @Override // com.tencent.gamecenter.wadl.notification.e.b
        public void onImageLoaded(String str, Bitmap bitmap, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlNotificationV2", 2, "loadGameIcon.onImageLoaded url=" + str + ",notificationId=" + this.f106949a);
            }
            c.this.e(this.f106949a, bitmap);
        }
    }

    c() {
    }

    private PendingIntent j(String str, String str2, String str3) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_GAME_CENTER_ACTION);
        intent.putExtra("key_event_id", 4);
        intent.putExtra(WadlProxyConsts.KEY_JUMP_URL, str);
        intent.putExtra(WadlProxyConsts.KEY_MATERIAL, str2);
        intent.putExtra("appid", str3);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    public static c k() {
        if (f106948h == null) {
            synchronized (f106947f) {
                if (f106948h == null) {
                    f106948h = new c();
                }
            }
        }
        return f106948h;
    }

    private void m(NotificationCompat.Builder builder, String str, int i3, boolean z16) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlNotificationV2", 2, "loadGameIcon iconUrl=" + str + ",notificationId=" + i3);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bitmap c16 = e.b().c(str);
            if (c16 != null) {
                builder.setLargeIcon(c16);
            } else {
                if (z16) {
                    return;
                }
                e.b().d(str, new a(i3), 100, 100);
            }
        } catch (Throwable th5) {
            QLog.e("Wadl_WadlNotificationV2", 1, th5, new Object[0]);
        }
    }

    public void n(String str, String str2, String str3, String str4, String str5, String str6) {
        int c16 = c("FULLSCREEN_NOTICE_" + str);
        g b16 = b(c16, R.drawable.b8f);
        b16.setAutoCancel(true).setOngoing(false).setPriority(2);
        h(b16, str4, str3, str4);
        if (!TextUtils.isEmpty(str5)) {
            m(b16, str5, c16, false);
        } else {
            b16.setLargeIcon(com.tencent.mobileqq.util.j.g(MobileQQ.sMobileQQ.getResources(), R.drawable.qzone_icon_action_sheet_qq));
        }
        g(b16, j(str6, str, str2), false);
        i(c16, b16.build(), QQNotificationManager.CHANNEL_ID_OTHER);
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914119").setOperModule("9385").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(1, "938503").setExt(4, "20").setExt(2, str).setExt(8, GameCenterUtil.getUrlParameter(str6, Utils.KEY_BUSINESS_ID)).setExt(25, GameCenterUtil.getUrlParameter(str6, WinkDaTongReportConstant.ElementParamKey.ADID)).setAdId("1294").setGameAppId(str2).report();
    }
}

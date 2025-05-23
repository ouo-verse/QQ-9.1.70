package com.tencent.gamecenter.wadl.notification;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i extends h implements nl0.g {
    public i() {
        QLog.i("Wadl_WadlTgpaNotification", 1, "new Instance");
    }

    private PendingIntent j(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_GAME_CENTER_ACTION);
        intent.putExtra("key_event_id", 2);
        intent.putExtra("resId", str);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private void k(g gVar, WadlResult wadlResult) {
        h(gVar, com.tencent.open.adapter.a.f().e().getString(R.string.f171382nl, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.f171412no, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.notification_tickerText_download_complete));
        PendingIntent c16 = com.tencent.gamecenter.wadl.util.i.c(wadlResult.wadlParams.fromWebUrl);
        gVar.setAutoCancel(true).setPriority(2);
        g(gVar, c16, false);
    }

    private void m(g gVar, WadlResult wadlResult) {
        h(gVar, com.tencent.open.adapter.a.f().e().getString(R.string.f171392nm, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.f171412no, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.f171142my));
        PendingIntent j3 = j(wadlResult.wadlParams.getResId());
        gVar.setAutoCancel(true).setOngoing(true).setPriority(0);
        g(gVar, j3, true);
    }

    private void n(g gVar, WadlResult wadlResult) {
        h(gVar, com.tencent.open.adapter.a.f().e().getString(R.string.f171402nn, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.f171412no, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.f171362nj));
        PendingIntent j3 = j(wadlResult.wadlParams.getResId());
        gVar.setAutoCancel(false).setOngoing(true).setPriority(0);
        g(gVar, j3, true);
    }

    private void o(g gVar, WadlResult wadlResult) {
        h(gVar, com.tencent.open.adapter.a.f().e().getString(R.string.notification_tickerText_download_prefix), com.tencent.open.adapter.a.f().e().getString(R.string.f171412no, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.f13531014, wadlResult.floatProgress + "%"));
        gVar.setProgress(100, wadlResult.progress, false);
        PendingIntent c16 = com.tencent.gamecenter.wadl.util.i.c(wadlResult.wadlParams.fromWebUrl);
        gVar.setAutoCancel(false).setOngoing(true).setPriority(0);
        g(gVar, c16, false);
    }

    private void p(g gVar, WadlResult wadlResult) {
        h(gVar, com.tencent.open.adapter.a.f().e().getString(R.string.notification_tickerText_download_prefix, ""), com.tencent.open.adapter.a.f().e().getString(R.string.f171412no, wadlResult.wadlParams.appName), com.tencent.open.adapter.a.f().e().getString(R.string.f171172n1));
        gVar.setProgress(100, wadlResult.progress, false);
        PendingIntent c16 = com.tencent.gamecenter.wadl.util.i.c(wadlResult.wadlParams.fromWebUrl);
        gVar.setAutoCancel(false).setOngoing(true).setPriority(0);
        g(gVar, c16, false);
    }

    @Override // nl0.g
    public void d(WadlResult wadlResult) {
        WadlParams wadlParams;
        String str;
        if (wadlResult == null || (wadlParams = wadlResult.wadlParams) == null || wadlResult.businessId != 2 || !wadlParams.getFlagEnable(4)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlTgpaNotification", 4, "handleTaskStatusChange wadlResult=" + wadlResult);
        }
        String resId = wadlResult.wadlParams.getResId();
        int i3 = wadlResult.taskStatus;
        if (i3 == 12) {
            f(wadlResult.wadlParams.getResId());
            return;
        }
        if (i3 != 4) {
            f(wadlResult.wadlParams.getResId());
        }
        int c16 = c(resId);
        g b16 = b(c16, R.drawable.qfile_file_ufdownload);
        int i16 = wadlResult.taskStatus;
        if (i16 != 2) {
            if (i16 != 4) {
                if (i16 != 5) {
                    str = QQNotificationManager.CHANNEL_ID_OTHER;
                    if (i16 != 6) {
                        if (i16 != 7) {
                            return;
                        } else {
                            m(b16, wadlResult);
                        }
                    } else {
                        k(b16, wadlResult);
                    }
                    i(c16, b16.build(), str);
                }
                n(b16, wadlResult);
            } else {
                o(b16, wadlResult);
            }
        } else {
            p(b16, wadlResult);
        }
        str = QQNotificationManager.CHANNEL_ID_HIDE_BADGE;
        i(c16, b16.build(), str);
    }

    public void q() {
        a();
        QLog.d("Wadl_WadlTgpaNotification", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // nl0.g
    public void l(ArrayList<WadlResult> arrayList) {
    }
}

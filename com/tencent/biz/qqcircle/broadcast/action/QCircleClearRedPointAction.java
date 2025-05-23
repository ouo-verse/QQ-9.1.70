package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.utils.ci;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* loaded from: classes4.dex */
public class QCircleClearRedPointAction extends QCircleBaseBroadcastAction {
    private static void b() {
        if (!((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
            return;
        }
        AppRuntime appRunTime = QCircleServiceImpl.getAppRunTime();
        if (appRunTime == null) {
            QLog.e("QFSRedPoint_QCircleClearRedPointAction", 1, "clearTianshuRedPoint appRunTime isnull");
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appRunTime.getRuntimeService(IRedTouchManager.class, "");
        if (iRedTouchManager == null) {
            QLog.e("QFSRedPoint_QCircleClearRedPointAction", 1, "clearTianshuRedPoint redTouchManager isnull");
            return;
        }
        QLog.e("QFSRedPoint_QCircleClearRedPointAction", 1, "clearTianshuRedPoint ");
        Iterator<String> it = ci.f92747a.iterator();
        while (it.hasNext()) {
            iRedTouchManager.dismissRedTouch(c(it.next()));
        }
    }

    public static String c(String str) {
        return str + ".0";
    }

    public static void d() {
        QCircleHostRedPointHelper.setNumRedPointReaded(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        QCircleHostRedPointHelper.setOuterEntranceRedPointReaded(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE, arrayList);
        b();
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.broadcast.action.QCircleClearRedPointAction.1
            @Override // java.lang.Runnable
            public void run() {
                HostStaticInvokeHelper.redPointHandlerSendRedpointReq(true, false);
            }
        }, 1000L);
    }

    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_clear_message_red_poiont";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            QLog.d("QFSRedPoint_QCircleClearRedPointAction", 1, "ACTION_CLEAR_MESSAGE_RED_POIONT createTime:" + intent.getIntExtra(WadlProxyConsts.CREATE_TIME, 0));
            d();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}

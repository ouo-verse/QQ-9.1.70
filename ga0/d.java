package ga0;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QFSTianShuConstant;
import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f401610d;

    d() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public static void a() {
        QLog.d("QFSTianShuAdManager", 1, QCircleLpReportDc05507.KEY_CLEAR);
        c.m().l();
    }

    public static d b() {
        if (f401610d == null) {
            synchronized (d.class) {
                if (f401610d == null) {
                    f401610d = new d();
                }
            }
        }
        return f401610d;
    }

    private List<TianShuAdPosItemData> c(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 1;
            tianShuAdPosItemData.mPosId = num.intValue();
            arrayList.add(tianShuAdPosItemData);
        }
        return arrayList;
    }

    public void d(int i3, String str, String str2) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        tianShuReportData.mTraceId = String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin()) + util.base64_pad_url + currentTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mItemId = str;
        tianShuReportData.mOperTime = currentTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mTriggerInfo = str2;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
        QLog.i("QFSTianShuAdManager", 1, "report actionId :" + i3 + ", adId :" + str);
    }

    public void e(List<Integer> list, TianShuGetAdvCallback tianShuGetAdvCallback) {
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(c(list), tianShuGetAdvCallback);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AccountChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            QLog.d("QFSTianShuAdManager", 1, "onReceiveEvent AccountChangeEvent");
            a();
        }
    }
}

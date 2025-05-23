package com.tencent.mobileqq.qcircle.api.utils;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.MobileQQ;
import qqcircle.QQCircleSwitch$SetMultiCircleSwitchRsp;
import uq3.k;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleHostConfig {
    private static final String TAG = "QCircleHostConfig";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetMultiCircleSwitchRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetMultiCircleSwitchRsp qQCircleSwitch$SetMultiCircleSwitchRsp) {
            QLog.w(QCircleHostConfig.TAG, 1, "setQQCircleAllowExtractVideoMusic = " + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetMultiCircleSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f261722a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f261723b;

        b(String str, String str2) {
            this.f261722a = str;
            this.f261723b = str2;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetMultiCircleSwitchRsp qQCircleSwitch$SetMultiCircleSwitchRsp) {
            if (z16 && j3 == 0) {
                QLog.w(QCircleHostConfig.TAG, 1, "updateGuideWnsConfig" + this.f261722a + " " + this.f261723b + "  succ");
                return;
            }
            QLog.w(QCircleHostConfig.TAG, 1, "updateGuideWnsConfig" + this.f261722a + " " + this.f261723b + "  error retcode= " + j3);
        }
    }

    public static boolean checkOpmask(long j3, int i3) {
        if ((j3 & (1 << i3)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean getEnablePeriodCollect() {
        return k.a().c("qcircle_need_period_collect", false);
    }

    public static long getPushFuleCountTime() {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp == null) {
            return 0L;
        }
        return qCircleSp.getLong("qcircle_fule_count_push_time", 0L);
    }

    public static SharedPreferences getQCircleSp() {
        return MobileQQ.sMobileQQ.getSharedPreferences("sp_qqcirlce_business" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), 0);
    }

    public static boolean getQQCircleAllowExtractVideoMusic() {
        return "1".equals(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_allow_extract_video_music", "0"));
    }

    public static long getRelationGroupLoadTime() {
        return k.a().f("key_qcircle_relation_group_time_2", 0L);
    }

    public static long getRelationLoadTimeInterval() {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp == null) {
            return 0L;
        }
        return qCircleSp.getLong("key_qcircle_relation_time_interval", 0L);
    }

    public static int isNeedShowLebaQCircleEnterGuideNew() {
        SharedPreferences qCircleSp = getQCircleSp();
        int i3 = -1;
        if (qCircleSp != null) {
            i3 = qCircleSp.getInt("qcircle_show_leba_qcircle_enter_guide_new", -1);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isNeedShowMessageEntranceTips: " + i3);
        }
        return i3;
    }

    public static int isNeedShowLebaTabGuideNew() {
        SharedPreferences qCircleSp = getQCircleSp();
        int i3 = -1;
        if (qCircleSp != null) {
            i3 = qCircleSp.getInt("qcircle_show_lebatab_guide_new", -1);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isNeedShowMessageEntranceTips: " + i3);
        }
        return i3;
    }

    public static int isNeedShowMessageEntranceAnim() {
        SharedPreferences qCircleSp = getQCircleSp();
        int i3 = -1;
        if (qCircleSp != null) {
            i3 = qCircleSp.getInt("qcircle_show_message_enter_guide_anim", -1);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isNeedShowMessageEntranceTips: " + i3);
        }
        return i3;
    }

    public static void saveEnablePeriodCollect(boolean z16) {
        k.a().j("qcircle_need_period_collect", z16);
    }

    public static void savePushFuleCountTime(long j3) {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp != null) {
            qCircleSp.edit().putLong("qcircle_fule_count_push_time", j3).apply();
        }
    }

    public static void setNeedShowLebaQCircleEntranceGuideNew(boolean z16) {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp != null) {
            qCircleSp.edit().putInt("qcircle_show_leba_qcircle_enter_guide_new", z16 ? 1 : 0).apply();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setShowMessageEntranceTips: " + z16);
        }
        if (!z16) {
            updateGuideWnsConfig(QzoneConfig.SECONDARY_QQCIRCLE_NEW_GUIDE_ON_DYNAMIC_ENTRANCE, "0");
        }
    }

    public static void setNeedShowLebaTabGuideNew(boolean z16) {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp != null) {
            qCircleSp.edit().putInt("qcircle_show_lebatab_guide_new", z16 ? 1 : 0).apply();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setShowMessageEntranceTips: " + z16);
        }
        if (!z16) {
            updateGuideWnsConfig(QzoneConfig.SECONDARY_QQCIRCLE_NEW_GUIDE_ON_DYNAMIC_TAB, "0");
        }
    }

    public static void setNeedShowMessageEntranceAnim(boolean z16) {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp != null) {
            qCircleSp.edit().putInt("qcircle_show_message_enter_guide_anim", z16 ? 1 : 0).apply();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setShowMessageEntranceTips: " + z16);
        }
        if (!z16) {
            updateGuideWnsConfig(QzoneConfig.SECONDARY_QQCIRCLE_NEW_GUIDE_ON_MESSAGE_ENTRANCE, "0");
        }
    }

    public static void setQQCircleAllowExtractVideoMusic(boolean z16) {
        String str;
        QzoneConfig qzoneConfig = QzoneConfig.getInstance();
        String str2 = "1";
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        qzoneConfig.updateOneConfig("qqcircle", "qqcircle_allow_extract_video_music", str);
        HashMap hashMap = new HashMap();
        if (!z16) {
            str2 = "0";
        }
        hashMap.put("qqcircle_allow_extract_video_music", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("qqcircle", hashMap);
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetMultiCircleWnsConfigRequest(hashMap2), new a());
    }

    public static void setRelationGroupTime(long j3) {
        k.a().n("key_qcircle_relation_group_time_2", j3);
    }

    public static void setRelationGroupTimeInterval(long j3) {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp != null) {
            qCircleSp.edit().putLong("key_qcircle_relation_time_interval", j3).apply();
        }
    }

    public static void updateGuideWnsConfig(String str, String str2) {
        QzoneConfig.getInstance().updateOneConfig("qqcircle", str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("qqcircle", hashMap);
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetMultiCircleWnsConfigRequest(hashMap2), new b(str, str2));
    }
}

package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.data.RedPointHolder;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.red.request.RedRequestBusinessManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QUA;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RedpointHandler extends BusinessHandler implements BusinessInfoCheckUpdateItem {
    static IPatchRedirector $redirector_;
    private static final HashSet<String> K;
    private Runnable C;
    private final Runnable D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private final ConcurrentHashMap<Integer, Integer> J;

    /* renamed from: d, reason: collision with root package name */
    private int f194978d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f194979e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f194980f;

    /* renamed from: h, reason: collision with root package name */
    private AtomicLong f194981h;

    /* renamed from: i, reason: collision with root package name */
    private int f194982i;

    /* renamed from: m, reason: collision with root package name */
    private int f194983m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class TimingRefreshingRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        TimingRefreshingRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQAppInterface b16 = cooperation.vip.ad.i.b();
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null && guardManager.isApplicationForeground()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && b16 != null) {
                ((IRedTouchServer) b16.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(false, false, 12);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            K = new HashSet<>();
        }
    }

    protected RedpointHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194980f = 0;
        this.f194981h = new AtomicLong();
        this.f194982i = 0;
        this.f194983m = RFWConfig.getConfigValue("tianshu_red_request_max_official_count", 10);
        this.C = new Runnable() { // from class: com.tencent.mobileqq.app.RedpointHandler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RedpointHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    RedpointHandler redpointHandler = RedpointHandler.this;
                    redpointHandler.a3(-1, null, redpointHandler.f194978d, null);
                }
            }
        };
        this.D = new TimingRefreshingRunnable();
        this.I = "";
        this.J = new ConcurrentHashMap<>();
        this.f194979e = qQAppInterface;
        P2();
    }

    private void G2(BusinessInfoCheckUpdate.TimeReqBody timeReqBody) {
        com.tencent.qqnt.kernel.api.aa recentContactService;
        List<RecentContactInfo> a16;
        RecentContactInfo next;
        QQAppInterface b16 = cooperation.vip.ad.i.b();
        if (b16 != null && (recentContactService = ((IKernelService) b16.getRuntimeService(IKernelService.class, "all")).getRecentContactService()) != null && (a16 = recentContactService.a()) != null && a16.size() != 0) {
            ListIterator<RecentContactInfo> listIterator = a16.listIterator();
            int i3 = 1;
            while (listIterator.hasNext() && this.f194983m > timeReqBody.officialList.size() && (next = listIterator.next()) != null) {
                int i16 = next.chatType;
                if (i16 == 103 || i16 == 30 || i16 == 118) {
                    BusinessInfoCheckUpdate.OfficialInfo officialInfo = new BusinessInfoCheckUpdate.OfficialInfo();
                    officialInfo.puin.set(next.peerUin);
                    officialInfo.last_time.set(next.msgTime);
                    officialInfo.unread.set((int) next.unreadCnt);
                    officialInfo.serial.set(i3);
                    timeReqBody.officialList.add(officialInfo);
                }
                i3++;
            }
        }
    }

    private void H2(long j3) {
        HashSet<String> hashSet = K;
        if (hashSet == null) {
            return;
        }
        if (j3 == 1113) {
            hashSet.add("1113.100800");
            hashSet.add("1113.100801");
            hashSet.add("1113.100802");
            hashSet.add("1113.100803");
            hashSet.add("1113.100804");
            return;
        }
        if (j3 == 100001113) {
            hashSet.add("100600.100001113.100100800");
            hashSet.add("100600.100001113.100100801");
            hashSet.add("100600.100001113.100100802");
            hashSet.add("100600.100001113.100100803");
            hashSet.add("100600.100001113.100100804");
        }
    }

    private void I2(BusinessInfoCheckUpdate.TimeReqBody timeReqBody, List<RedPointHolder> list, List<BusinessInfoCheckUpdate.AppSetting> list2, List<String> list3) {
        int size;
        if (list != null) {
            if (list2 == null) {
                size = 0;
            } else {
                size = list2.size();
            }
            BusinessInfoCheckUpdate.AppSetting appSetting = null;
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3).uiResId + "";
                int i16 = list.get(i3).appid;
                int i17 = 0;
                while (i17 < size) {
                    appSetting = list2.get(i17);
                    if (appSetting != null && i16 == appSetting.appid.get()) {
                        break;
                    } else {
                        i17++;
                    }
                }
                if (i17 == size || appSetting == null) {
                    appSetting = new BusinessInfoCheckUpdate.AppSetting();
                    appSetting.appid.set(i16);
                    appSetting.setting.set(true);
                    appSetting.modify_ts.set(0L);
                }
                H2(list.get(i3).uiResId);
                timeReqBody.rptSetting.add(appSetting);
                list3.add(str);
            }
        }
    }

    private SosoLbsInfo K2() {
        return ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("vas_red_point");
    }

    private BusinessInfoCheckUpdate.LbsInfo L2(SosoLocation sosoLocation) {
        String str;
        if (sosoLocation == null) {
            return null;
        }
        BusinessInfoCheckUpdate.LbsInfo lbsInfo = new BusinessInfoCheckUpdate.LbsInfo();
        BusinessInfoCheckUpdate.LbsDetailInfo lbsDetailInfo = new BusinessInfoCheckUpdate.LbsDetailInfo();
        BusinessInfoCheckUpdate.LbsSubnation lbsSubnation = new BusinessInfoCheckUpdate.LbsSubnation();
        if (TextUtils.isEmpty(sosoLocation.cityCode)) {
            str = "";
        } else {
            str = sosoLocation.cityCode;
        }
        lbsSubnation.code.set(str);
        lbsSubnation.nation.set("unknown");
        lbsSubnation.province.set("unknown");
        lbsSubnation.city.set("unknown");
        lbsSubnation.district.set("unknown");
        lbsDetailInfo.subnation.set(lbsSubnation);
        lbsInfo.detail_info.set(lbsDetailInfo);
        BusinessInfoCheckUpdate.LbsLocationInfo lbsLocationInfo = new BusinessInfoCheckUpdate.LbsLocationInfo();
        double[] a16 = com.tencent.mobileqq.ark.util.g.a(sosoLocation.mLon02, sosoLocation.mLat02);
        lbsLocationInfo.longitude.set(Double.valueOf(a16[0] * 1000000.0d).intValue());
        lbsLocationInfo.latitude.set(Double.valueOf(a16[1] * 1000000.0d).intValue());
        lbsInfo.location.set(lbsLocationInfo);
        return lbsInfo;
    }

    public static List<RedPointHolder> M2(AppRuntime appRuntime) {
        return ((ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, "all")).getLebaPluginRedPointIds();
    }

    private void N2(ToServiceMsg toServiceMsg, Object obj) {
        BusinessInfoCheckUpdate.TimeRspBody timeRspBody;
        int i3;
        boolean z16 = true;
        if (obj == null) {
            QLog.e("RedPointLog.RedpointHandler", 1, "handleResponse data = null");
            return;
        }
        try {
            timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
            timeRspBody.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.e("RedPointLog.RedpointHandler", 1, "mergeFrom failed");
            timeRspBody = null;
        }
        if (timeRspBody == null) {
            QLog.e("RedPointLog.RedpointHandler", 1, "handleResponse prb = null");
            return;
        }
        if (timeRspBody.iResult.get() != 0) {
            QLog.d("RedPointLog.RedpointHandler", 1, "handleResponse,return fail ,TimeRspBody result:" + timeRspBody.iResult.get());
            if (timeRspBody.iResult.get() == 104005) {
                timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
            } else {
                return;
            }
        }
        QLog.i("RedPointLog.RedpointHandler", 1, "handleResponse");
        X2(timeRspBody);
        this.f194979e.getEntityManagerFactory().createEntityManager();
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f194979e.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = iRedTouchManager.getLocalTimeRspBody();
        try {
        } catch (Exception e17) {
            QLog.e("RedPointLog.RedpointHandler", 1, "handleResponse", e17);
        }
        if (!W2(timeRspBody, iRedTouchManager)) {
            return;
        }
        Y2(timeRspBody, iRedTouchManager);
        if (toServiceMsg == null || !"1".equals(toServiceMsg.getAttribute("REQUEST_KEY_IS_UPDATE", "0"))) {
            z16 = false;
        }
        if (toServiceMsg != null) {
            i3 = ((Integer) toServiceMsg.getAttribute("REQUEST_KEY_IS_REQUEST_TYPE", 0)).intValue();
        } else {
            i3 = 0;
        }
        if (z16 && localTimeRspBody != null) {
            iRedTouchManager.updateMsgAppInfo(timeRspBody, localTimeRspBody);
            iRedTouchManager.saveTimeRepBody(localTimeRspBody);
            iRedTouchManager.notifyAppInfoChangeUpdate(timeRspBody, null, i3);
        } else {
            iRedTouchManager.saveTimeRepBody(timeRspBody);
            iRedTouchManager.notifyAppInfoChangeUpdate(timeRspBody, localTimeRspBody, i3);
        }
        U2(timeRspBody, z16);
        V2(timeRspBody);
        iRedTouchManager.resetFlag();
        iRedTouchManager.redTouchsArrived(timeRspBody);
        S2(this.f194979e);
        SharedPreferences.Editor edit = this.f194979e.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0).edit();
        edit.putBoolean(BusinessInfoCheckUpdateItem.REDTOUCH_FORCE, false);
        edit.apply();
    }

    private void O2() {
        String currentAccountUin = getCurrentAccountUin();
        if (TextUtils.equals(currentAccountUin, this.I)) {
            return;
        }
        this.I = currentAccountUin;
        this.E = 43200000;
        this.F = 0;
        this.G = 0;
        this.H = 600;
    }

    private void P2() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("tianshu_red_request_aggregate", "");
        QLog.d("RedPointLog.RedpointHandler", 1, "[initIntervalTime] content: " + loadAsString);
        if (TextUtils.isEmpty(loadAsString)) {
            return;
        }
        try {
            this.f194982i = new JSONObject(loadAsString).optInt("interval_time", 0);
        } catch (JSONException e16) {
            QLog.e("RedPointLog.RedpointHandler", 1, "[initIntervalTime] exception: " + e16);
        }
    }

    private boolean Q2(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("RedPointLog.RedpointHandler", 1, "isLocationAuth  e = " + e16);
            return false;
        }
    }

    private boolean R2(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f194981h.getAndSet(currentTimeMillis) < this.f194982i) {
            d3(i3);
            RFWThreadManager.getInstance().remove(this.C);
            RFWThreadManager.getInstance().execOnSubThread(this.C, this.f194982i);
            return true;
        }
        return false;
    }

    private void T2(BusinessInfoCheckUpdate.TimeReqBody timeReqBody) {
        Object obj;
        Object obj2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("req red pathlist:");
        if (timeReqBody.rptMsgAppInfo.has()) {
            for (int i3 = 0; i3 < timeReqBody.rptMsgAppInfo.size(); i3++) {
                String str = timeReqBody.rptMsgAppInfo.get(i3).path.get();
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                    sb5.append(";");
                }
            }
        }
        QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp rptMsginfoPath:" + sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("req setting pathlist:");
        sb6.append("leba_study");
        if (timeReqBody.rptSetting.has()) {
            for (BusinessInfoCheckUpdate.AppSetting appSetting : timeReqBody.rptSetting.get()) {
                if (appSetting != null) {
                    sb6.append("appid: ");
                    Object obj3 = "null";
                    if (!appSetting.appid.has()) {
                        obj = "null";
                    } else {
                        obj = Integer.valueOf(appSetting.appid.get());
                    }
                    sb6.append(obj);
                    sb6.append("  setting:");
                    if (!appSetting.setting.has()) {
                        obj2 = "null";
                    } else {
                        obj2 = Boolean.valueOf(appSetting.setting.get());
                    }
                    sb6.append(obj2);
                    sb6.append(" modify_ts:");
                    if (appSetting.modify_ts.has()) {
                        obj3 = Long.valueOf(appSetting.modify_ts.get());
                    }
                    sb6.append(obj3);
                    sb6.append(",");
                }
            }
        }
        QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp setting:" + sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("req nored pathlist:");
        if (timeReqBody.rptNoRedPath.has()) {
            for (int i16 = 0; i16 < timeReqBody.rptNoRedPath.size(); i16++) {
                String str2 = timeReqBody.rptNoRedPath.get(i16);
                if (!TextUtils.isEmpty(str2)) {
                    sb7.append(str2);
                    sb7.append(";");
                }
            }
        }
        QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp rptNoRedPath:" + sb7.toString());
    }

    private void U2(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, boolean z16) {
        StringBuilder sb5 = new StringBuilder("isUpdate:" + z16 + " Rsp Body :");
        if (timeRspBody.rptMsgAppInfo.has()) {
            for (BusinessInfoCheckUpdate.AppInfo appInfo : timeRspBody.rptMsgAppInfo.get()) {
                if (appInfo != null) {
                    sb5.append(" path = \u3010");
                    sb5.append(appInfo.path.get());
                    sb5.append("\u3011 inewflag = ");
                    sb5.append(appInfo.iNewFlag.get());
                    sb5.append(" appset = ");
                    sb5.append(appInfo.appset.get());
                    sb5.append(" exposure_max = ");
                    sb5.append(appInfo.exposure_max.get());
                    sb5.append(" click_mx = ");
                    sb5.append(appInfo.click_max.get());
                    sb5.append(" mission_level = ");
                    sb5.append(appInfo.mission_level.get());
                    sb5.append(" missions = ");
                    sb5.append(appInfo.missions.get());
                    sb5.append(" type = ");
                    sb5.append(appInfo.type.get());
                    sb5.append(" num = ");
                    sb5.append(appInfo.num.get());
                    sb5.append(" version = ");
                    sb5.append(appInfo.version.get());
                    sb5.append(" hash = ");
                    sb5.append(appInfo.hash.get());
                    sb5.append(";\n");
                }
            }
        }
        if (timeRspBody.rptMsgNumRedInfo.has()) {
            for (BusinessInfoCheckUpdate.NumRedInfo numRedInfo : timeRspBody.rptMsgNumRedInfo.get()) {
                if (numRedInfo != null) {
                    sb5.append("numred appid = ");
                    sb5.append(numRedInfo.appid.get());
                    sb5.append(" appset = ");
                    sb5.append(numRedInfo.appset.get());
                    sb5.append(";");
                }
            }
        }
        QLog.d("RedPointLog.RedpointHandler", 1, sb5.toString());
    }

    private void V2(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        Object obj;
        Object obj2;
        if (timeRspBody.rptMsgAppInfo.has()) {
            int size = timeRspBody.rptMsgAppInfo.size();
            for (int i3 = 0; i3 < size; i3++) {
                BusinessInfoCheckUpdate.AppInfo appInfo = timeRspBody.rptMsgAppInfo.get(i3);
                if (appInfo != null) {
                    appInfo.path.get();
                    if (appInfo.uiAppId.get() == 769) {
                        this.f194979e.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0).edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.f194979e.getCurrentAccountUin(), (int) (NetConnInfoCenter.getServerTimeMillis() / 1000)).apply();
                    }
                }
            }
        }
        if (timeRspBody.rptMsgNumRedInfo.has()) {
            ArrayList arrayList = new ArrayList();
            List<BusinessInfoCheckUpdate.NumRedInfo> list = timeRspBody.rptMsgNumRedInfo.get();
            if (list == null) {
                return;
            }
            for (BusinessInfoCheckUpdate.NumRedInfo numRedInfo : list) {
                if (numRedInfo.appid.get() == 7719) {
                    arrayList.add(numRedInfo);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RedPointLog.RedpointHandler", 2, "individuation jump open");
        }
        if (timeRspBody.rptSetting.get() != null) {
            StringBuilder sb5 = new StringBuilder("switch ");
            sb5.append("leba_study");
            for (BusinessInfoCheckUpdate.AppSetting appSetting : timeRspBody.rptSetting.get()) {
                if (appSetting != null) {
                    sb5.append("appid: ");
                    Object obj3 = "null";
                    if (!appSetting.appid.has()) {
                        obj = "null";
                    } else {
                        obj = Integer.valueOf(appSetting.appid.get());
                    }
                    sb5.append(obj);
                    sb5.append("  setting:");
                    if (!appSetting.setting.has()) {
                        obj2 = "null";
                    } else {
                        obj2 = Boolean.valueOf(appSetting.setting.get());
                    }
                    sb5.append(obj2);
                    sb5.append(" modify_ts:");
                    if (appSetting.modify_ts.has()) {
                        obj3 = Long.valueOf(appSetting.modify_ts.get());
                    }
                    sb5.append(obj3);
                    sb5.append(",");
                }
            }
            QLog.i("RedPointLog.RedpointHandler", 1, sb5.toString());
            ILebaHelperService iLebaHelperService = (ILebaHelperService) this.f194979e.getRuntimeService(ILebaHelperService.class, "");
            if (iLebaHelperService != null) {
                iLebaHelperService.updateAllLebaListFlag(timeRspBody.rptSetting.get());
            } else {
                QLog.d("RedPointLog.RedpointHandler", 1, "processExtraData lebaHelperService == null");
            }
        }
    }

    private boolean W2(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, IRedTouchManager iRedTouchManager) {
        boolean z16;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath2;
        if (timeRspBody.rptMsgAppInfo.has()) {
            for (BusinessInfoCheckUpdate.AppInfo appInfo : timeRspBody.rptMsgAppInfo.get()) {
                if (appInfo != null) {
                    if (appInfo.use_cache.get() && (appInfoByPath2 = iRedTouchManager.getAppInfoByPath(appInfo.path.get())) != null) {
                        appInfo.buffer.set(appInfoByPath2.buffer.get());
                    }
                    if (appInfo.type.get() == 8 && (appInfoByPath = iRedTouchManager.getAppInfoByPath(appInfo.path.get())) != null && appInfoByPath.type.get() == 8 && appInfoByPath.version.get() == appInfo.version.get() && appInfoByPath.num.get() != appInfo.num.get()) {
                        QLog.d("RedPointLog.RedpointHandler", 1, "appInfo resetNum path:" + appInfo.path + " num:" + appInfo.num + " localNumber:" + appInfoByPath.num);
                        appInfo.num.set(appInfoByPath.num.get());
                    }
                }
            }
        }
        if (timeRspBody.rptMsgNumRedInfo.has()) {
            List<BusinessInfoCheckUpdate.NumRedInfo> list = timeRspBody.rptMsgNumRedInfo.get();
            if (list == null) {
                return false;
            }
            Iterator<BusinessInfoCheckUpdate.NumRedInfo> it = list.iterator();
            while (it.hasNext()) {
                List<BusinessInfoCheckUpdate.NumRedPath> list2 = it.next().num_red_path.get();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        list2.get(i3).uint32_push_num_red_ts.set((int) (System.currentTimeMillis() / 1000));
                    }
                }
            }
        }
        if (timeRspBody.invalidRedPaths.has()) {
            for (String str : timeRspBody.invalidRedPaths.get()) {
                BusinessInfoCheckUpdate.AppInfo appInfoByPath3 = iRedTouchManager.getAppInfoByPath(str);
                QLog.d("RedPointLog.RedpointHandler", 1, "processResponseMsg path:" + str + " is invalid, use local appInfo");
                if (appInfoByPath3 != null) {
                    Iterator<BusinessInfoCheckUpdate.AppInfo> it5 = timeRspBody.rptMsgAppInfo.get().iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            BusinessInfoCheckUpdate.AppInfo next = it5.next();
                            if (next != null && next.path.get().equals(str)) {
                                next.set(appInfoByPath3);
                                z16 = true;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        timeRspBody.rptMsgAppInfo.add(appInfoByPath3);
                    }
                }
            }
        }
        return true;
    }

    private void X2(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        int i3;
        if (timeRspBody.iInterval.has()) {
            if (timeRspBody.iInterval.get() > 0) {
                i3 = timeRspBody.iInterval.get();
            } else {
                i3 = 0;
            }
            this.H = i3;
        } else {
            this.H = 600;
        }
        this.E = timeRspBody.iLbsInterval.get();
        this.J.clear();
        if (timeRspBody.reqTypeInterval.has()) {
            for (BusinessInfoCheckUpdate.Entry entry : timeRspBody.reqTypeInterval.get()) {
                this.J.put(Integer.valueOf(entry.key.get()), Integer.valueOf(entry.value.get()));
            }
        }
        QLog.d("RedPointLog.RedpointHandler", 1, "handleResponse, iInterval = " + timeRspBody.iInterval.get() + "; lbsInterval = " + timeRspBody.iLbsInterval.get());
        this.F = (int) (System.currentTimeMillis() / 1000);
        c3();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r10 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Y2(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, IRedTouchManager iRedTouchManager) {
        boolean z16;
        List<BusinessInfoCheckUpdate.AppSetting> list = timeRspBody.rptSetting.get();
        List<BusinessInfoCheckUpdate.AppSetting> requestSettingInfoList = iRedTouchManager.requestSettingInfoList();
        ArrayList arrayList = new ArrayList();
        if (list != null && requestSettingInfoList != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                BusinessInfoCheckUpdate.AppSetting appSetting = list.get(i3);
                int i16 = 0;
                while (true) {
                    if (i16 < requestSettingInfoList.size()) {
                        if (requestSettingInfoList.get(i16).appid.get() == appSetting.appid.get()) {
                            requestSettingInfoList.set(i16, appSetting);
                            z16 = true;
                            break;
                        }
                        i16++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    arrayList.add(appSetting);
                }
            }
            requestSettingInfoList.addAll(arrayList);
        }
        list = requestSettingInfoList;
        timeRspBody.rptSetting.set(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(int i3, SosoLbsInfo sosoLbsInfo, int i16, List<String> list) {
        BusinessInfoCheckUpdate.LbsInfo L2;
        int i17;
        SosoLocation sosoLocation;
        if (R2(i16)) {
            QLog.d("RedPointLog.RedpointHandler", 1, "sendReq needFrequencyControl, request list:" + this.f194980f);
            return;
        }
        RFWThreadManager.getInstance().remove(this.D);
        QLog.d("RedPointLog.RedpointHandler", 1, "sendReq start, reqType:" + i16);
        BusinessInfoCheckUpdate.TimeReqBody timeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
        timeReqBody.uReqTypeList.set(this.f194980f);
        int i18 = 0;
        this.f194980f = 0;
        timeReqBody.iProtocolVer.set(1);
        timeReqBody.uiClientPlatID.set(109);
        timeReqBody.sClientVer.set(AppSetting.f99554n);
        String currentAccountUin = this.f194979e.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin)) {
            try {
                timeReqBody.uiUin.set(Long.parseLong(currentAccountUin));
            } catch (Exception unused) {
                QLog.e("RedPointLog.RedpointHandler", 1, "parseUin error for uin=" + currentAccountUin);
            }
        }
        timeReqBody.uReqType.set(i16);
        timeReqBody.transinfo.set(RedRequestBusinessManager.f293121a.c(i16));
        timeReqBody.uiNetType.set(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
        boolean Q2 = Q2(this.f194979e.getApplicationContext());
        if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
            L2 = L2(sosoLocation);
        } else {
            SosoLocation sosoLocation2 = new SosoLocation();
            sosoLocation2.mLon02 = 900.0d;
            sosoLocation2.mLat02 = 900.0d;
            if (Q2) {
                sosoLocation2.cityCode = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
            } else {
                sosoLocation2.cityCode = "-1";
            }
            L2 = L2(sosoLocation2);
        }
        if (L2 != null) {
            timeReqBody.lbs.set(L2);
        }
        List<RedPointHolder> M2 = M2(this.f194979e);
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f194979e.getRuntimeService(IRedTouchManager.class, "");
        List<BusinessInfoCheckUpdate.AppSetting> requestSettingInfoList = iRedTouchManager.requestSettingInfoList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        I2(timeReqBody, M2, requestSettingInfoList, arrayList);
        G2(timeReqBody);
        arrayList.addAll(K);
        for (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface dynamicRedPointPathInterface : iRedTouchManager.getRegisterInterfaces()) {
            if (dynamicRedPointPathInterface != null) {
                try {
                    if (dynamicRedPointPathInterface.getRedPointPaths(this.f194979e) != null) {
                        arrayList.addAll(dynamicRedPointPathInterface.getRedPointPaths(this.f194979e));
                    }
                } catch (Exception e16) {
                    QLog.e("RedPointLog.RedpointHandler", 1, "add exception error" + e16);
                }
            }
        }
        timeReqBody.bBackendFillRedPath.set(true);
        List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet = iRedTouchManager.requestAppInfoListByAppSet(3);
        if (requestAppInfoListByAppSet != null) {
            Iterator<BusinessInfoCheckUpdate.AppInfo> it = requestAppInfoListByAppSet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().path.get());
            }
        }
        if (iRedTouchManager.getLocalTimeRspBody() == null) {
            QLog.d("RedPointLog.RedpointHandler", 1, "BusinessInfoCheckUpdateItem pb file does not exist");
            arrayList2.addAll(arrayList);
        } else {
            F2(iRedTouchManager, arrayList, arrayList2, arrayList3);
        }
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            timeReqBody.rptNoRedPath.set(com.tencent.mobileqq.tianshu.red.request.b.f293126a.a(list));
            timeReqBody.uReqSubType.set(1);
            hashMap.put("REQUEST_KEY_IS_UPDATE", "1");
        } else {
            timeReqBody.rptMsgAppInfo.set(arrayList3);
            timeReqBody.rptNoRedPath.set(com.tencent.mobileqq.tianshu.red.request.b.f293126a.a(arrayList2));
        }
        hashMap.put("REQUEST_KEY_IS_REQUEST_TYPE", Integer.valueOf(i16));
        timeReqBody.qua.set(QUA.getQUA3());
        timeReqBody.sQimei.set(String.valueOf(com.tencent.mobileqq.statistics.o.c()));
        timeReqBody.system_notify_status.set(QQAppInterface.isNotificationEnabled() + 1);
        timeReqBody.mode.set(TianShuManager.getModeType());
        timeReqBody.sVendor.set(Build.BRAND);
        PBUInt32Field pBUInt32Field = timeReqBody.a11yMode;
        if (AppSetting.f99565y) {
            i17 = 1;
        } else {
            i17 = 2;
        }
        pBUInt32Field.set(i17);
        timeReqBody.use_red_component.set(((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn());
        if (this.f194979e.mIsShowNewLeba) {
            timeReqBody.bHebaFlag.set(true);
        } else {
            timeReqBody.bHebaFlag.set(false);
        }
        if (!((IFontManagerService) this.f194979e.getRuntimeService(IFontManagerService.class, "")).isSupportFont() && timeReqBody.rptMsgAppInfo.has()) {
            while (true) {
                if (i18 >= timeReqBody.rptMsgAppInfo.size()) {
                    break;
                }
                if ("100005.100011".equals(timeReqBody.rptMsgAppInfo.get(i18).path.get())) {
                    timeReqBody.rptMsgAppInfo.remove(i18);
                    break;
                }
                i18++;
            }
        }
        T2(timeReqBody);
        QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp local message ok");
        try {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194979e.getCurrentAccountUin(), com.tencent.mobileqq.service.message.i.D);
            toServiceMsg.putWupBuffer(timeReqBody.toByteArray());
            toServiceMsg.getAttributes().putAll(hashMap);
            sendPbReq(toServiceMsg);
        } catch (Exception e17) {
            QLog.e("RedPointLog.RedpointHandler", 1, "error send request ", e17);
        }
    }

    private void b3(int i3, SosoLbsInfo sosoLbsInfo, int i16, List<String> list) {
        if (RFWThreadManager.isMainThread()) {
            ThreadManagerV2.post(new Runnable(i3, sosoLbsInfo, i16, list) { // from class: com.tencent.mobileqq.app.RedpointHandler.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f194984d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ SosoLbsInfo f194985e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f194986f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ List f194987h;

                {
                    this.f194984d = i3;
                    this.f194985e = sosoLbsInfo;
                    this.f194986f = i16;
                    this.f194987h = list;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RedpointHandler.this, Integer.valueOf(i3), sosoLbsInfo, Integer.valueOf(i16), list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        RedpointHandler.this.a3(this.f194984d, this.f194985e, this.f194986f, this.f194987h);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 5, null, true);
        } else {
            a3(i3, sosoLbsInfo, i16, list);
        }
    }

    private void c3() {
        if (this.J.get(12) == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(this.D, r0.intValue() * 1000);
    }

    private synchronized void d3(int i3) {
        this.f194980f = (1 << i3) ^ this.f194980f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f2, code lost:
    
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void F2(IRedTouchManager iRedTouchManager, List<String> list, List<String> list2, List<BusinessInfoCheckUpdate.AppInfo> list3) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, iRedTouchManager, list, list2, list3);
            return;
        }
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = iRedTouchManager.getLocalTimeRspBody();
        if (localTimeRspBody != null && localTimeRspBody.rptMsgAppInfo.has()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3);
                if (!TextUtils.isEmpty(str)) {
                    int i16 = 0;
                    while (true) {
                        if (i16 >= localTimeRspBody.rptMsgAppInfo.size()) {
                            break;
                        }
                        BusinessInfoCheckUpdate.AppInfo appInfo = localTimeRspBody.rptMsgAppInfo.get(i16);
                        if (str.equals(appInfo.path.get())) {
                            List<String> list4 = appInfo.missions.get();
                            if (list4 != null && list4.size() != 0) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (appInfo.iNewFlag.get() != 0 || !z17) {
                                BusinessInfoCheckUpdate.AppInfo appInfo2 = new BusinessInfoCheckUpdate.AppInfo();
                                appInfo2.path.set(appInfo.path.get());
                                appInfo2.uiAppId.set(appInfo.uiAppId.get());
                                appInfo2.modify_ts.set(appInfo.modify_ts.get());
                                appInfo2.iNewFlag.set(appInfo.iNewFlag.get());
                                appInfo2.type.set(appInfo.type.get());
                                appInfo2.push_red_ts.set(appInfo.push_red_ts.get());
                                appInfo2.mission_level.set(appInfo.mission_level.get());
                                for (int i17 = 0; i17 < appInfo.missions.size(); i17++) {
                                    appInfo2.missions.add(appInfo.missions.get(i17));
                                }
                                list3.add(appInfo2);
                                z16 = false;
                            }
                        } else {
                            i16++;
                        }
                    }
                    if (z16) {
                        list2.add(str);
                    }
                }
            }
            return;
        }
        list2.addAll(list);
    }

    public void J2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        QLog.d("RedPointLog.RedpointHandler", 1, "forceSendReq fromSrc:" + i3);
        b3(-1, null, 6, null);
    }

    public void S2(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        try {
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.f.class);
            newIntent.setAction("gc_refresh_ui");
            newIntent.putExtra("gc_notify_type", 6);
            appRuntime.startServlet(newIntent);
            notifyUI(3, true, null);
        } catch (Exception e16) {
            QLog.e("RedPointLog.RedpointHandler", 1, "notifyRedTouchUpdate error!", e16);
        }
    }

    public void Z2(boolean z16, boolean z17, int i3, List<String> list) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), list);
            return;
        }
        QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp:send redInfo start");
        O2();
        SharedPreferences sharedPreferences = this.f194979e.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Integer num = this.J.get(Integer.valueOf(i3));
        if (num != null && num.intValue() > 0) {
            i16 = num.intValue();
        } else {
            i16 = this.H;
        }
        int i17 = this.E;
        int i18 = this.F;
        int i19 = this.G;
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        boolean z19 = sharedPreferences.getBoolean(BusinessInfoCheckUpdateItem.REDTOUCH_FORCE, false);
        QLog.d("RedPointLog.RedpointHandler", 1, "getNewFlagOp:sendredInfo :reqType = " + i3 + ":systemTimestamp = " + currentTimeMillis + ";lastUpdateTimestamp = " + i18 + ";updateInterval = " + i16 + ";updateLbsInterval = " + i17 + ";lastCheckLbsInfo = " + i19 + ";isDebugVersion = false");
        if (!z19 && !z16 && currentTimeMillis - i18 < i16 && currentTimeMillis >= i18) {
            QLog.d("RedPointLog.RedpointHandler", 1, "sendRedpointReq is fail, reqType:" + i3);
            return;
        }
        edit.putInt("businessinfo_last_check_update_timestamp_" + this.f194979e.getCurrentAccountUin(), currentTimeMillis);
        edit.apply();
        this.F = currentTimeMillis;
        this.f194978d = i3;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null && guardManager.isApplicationForeground()) {
            z18 = true;
        }
        if (z18 && z17 && (currentTimeMillis - i19 > i17 || currentTimeMillis < i18)) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() / 1000);
            this.G = currentTimeMillis2;
            edit.putInt("businessinfo_last_check_lbsinfo_timestamp_" + this.f194979e.getCurrentAccountUin(), currentTimeMillis2).commit();
            if (this.f194979e.getApplication().getApplicationContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                b3(-1, null, i3, list);
                return;
            } else {
                b3(-1, K2(), i3, list);
                return;
            }
        }
        b3(-1, null, i3, list);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return RedpointObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (com.tencent.mobileqq.service.message.i.D.equals(fromServiceMsg.getServiceCmd()) && z16) {
            N2(toServiceMsg, obj);
        }
    }
}

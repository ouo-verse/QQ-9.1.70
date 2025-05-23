package com.tencent.mobileqq.soso.location;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.multiscene.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.data.SosoAttribute;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.api.IO3NotifySecApi;
import com.tenpay.lcation.LocationInputFragment;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LbsManagerService {
    static IPatchRedirector $redirector_ = null;
    public static String KEY_LOCATION_PERMISSION_CHECK_SWITCH = null;
    private static final int MAX_CONTINUE_FAIL_COUNT = 5;
    private static final int REAL_TIME_REQUIREMENT_ALMOST_IMMEDIATELY = 4;
    private static final int REAL_TIME_REQUIREMENT_HIGH = 3;
    private static final int REAL_TIME_REQUIREMENT_IMMEDIATELY = 5;
    private static final int REAL_TIME_REQUIREMENT_LOW = 1;
    private static final int REAL_TIME_REQUIREMENT_MIDDLE = 2;
    private static final HashMap<String, BusinessInfo> S_BUSINESS;
    private static final String TAG = "SOSO.LBS.LbsManagerService";
    private static Map<LbsManagerServiceOnLocationChangeListener, SosoInterfaceOnLocationListener> sListenerMap;
    private static Map<SosoInterfaceOnLocationListener, LbsManagerServiceOnLocationChangeListener> sReverseListenerMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class BusinessInfo {
        static IPatchRedirector $redirector_;
        public String businessId;
        public boolean canUseGps;
        public String permissionId;
        public int realTimeRequirement;
        public boolean reqGoon;
        public boolean reqLonAndLat;
        public boolean reqRawData;
        public int requestDataLevel;

        @Deprecated
        public BusinessInfo(String str, boolean z16, int i3, int i16, boolean z17, boolean z18, boolean z19) {
            this(str, ISosoInterfaceConstant.DEFAULT_LOCATION_PERMISSION_ID, z16, i3, i16, z17, z18, z19);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
        }

        public int canUseMaxCacheInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            int i3 = this.realTimeRequirement;
            if (i3 == 5) {
                return 0;
            }
            if (i3 == 4) {
                return 60000;
            }
            if (i3 == 3) {
                return 180000;
            }
            if (i3 == 2) {
                return 600000;
            }
            return 1800000;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "businessId: " + this.businessId + ",reqLonAndLat: " + this.reqLonAndLat + ",realTimeRequirement: " + this.realTimeRequirement + ",requestDataLevel: " + this.requestDataLevel + ",reqGoon: " + this.reqGoon + ",canUseGps: " + this.canUseGps;
        }

        public BusinessInfo(String str, String str2, boolean z16, int i3, int i16, boolean z17, boolean z18, boolean z19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
                return;
            }
            this.businessId = str;
            this.permissionId = str2;
            this.reqLonAndLat = z16;
            this.realTimeRequirement = i3;
            this.requestDataLevel = i16;
            this.reqGoon = z17;
            this.canUseGps = z18;
            this.reqRawData = z19;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34603);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        KEY_LOCATION_PERMISSION_CHECK_SWITCH = "location_permission_check_switch";
        S_BUSINESS = new HashMap<>();
        sListenerMap = new ConcurrentHashMap(8, 0.75f);
        sReverseListenerMap = new ConcurrentHashMap(8, 0.75f);
        registerBusinessInfo();
    }

    public LbsManagerService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkLocationPermissionGroup(BusinessInfo businessInfo) {
        if (businessInfo == null) {
            return false;
        }
        if (ISosoInterfaceConstant.DEFAULT_LOCATION_PERMISSION_ID.equals(businessInfo.permissionId) && !isLocationPermissionCheckSwitchOpen()) {
            return true;
        }
        if (TextUtils.isEmpty(businessInfo.permissionId)) {
            QLog.i(TAG, 1, "qqPermissionId is empty");
            return false;
        }
        QLog.i(TAG, 1, "businessid: " + businessInfo.businessId);
        return a.d(BaseApplication.getContext(), a.b(businessInfo.permissionId), "android.permission-group.LOCATION");
    }

    private static BusinessInfo getBusinessInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return S_BUSINESS.get(str);
    }

    public static SosoLbsInfo getCachedLbsInfo(String str) {
        SosoLbsInfo sosoInfo;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getCachedLbsInfo business id: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BusinessInfo businessInfo = getBusinessInfo(str);
        if (businessInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "getCachedLbsInfo business info is null.");
            }
            return null;
        }
        if (!checkLocationPermissionGroup(businessInfo)) {
            QLog.i(TAG, 2, "PermissionGroup don\u2018t have permission");
            return null;
        }
        if (businessInfo.reqRawData) {
            sosoInfo = SosoInterface.getRawSosoInfo(businessInfo.reqLonAndLat);
        } else {
            sosoInfo = SosoInterface.getSosoInfo(businessInfo.requestDataLevel, businessInfo.reqLonAndLat);
        }
        notifySec(str, sosoInfo);
        return sosoInfo;
    }

    public static String getCity() {
        return getCity(ISosoInterfaceConstant.DEFAULT_LOCATION_BUSINESS_ID);
    }

    public static String getCityCode() {
        return getCityCode(ISosoInterfaceConstant.DEFAULT_LOCATION_BUSINESS_ID);
    }

    public static String getProvince() {
        return getProvince(ISosoInterfaceConstant.DEFAULT_LOCATION_BUSINESS_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SosoLbsInfo handleLbsInfo(SosoLbsInfo sosoLbsInfo, String str) {
        BusinessInfo businessInfo;
        if (TextUtils.isEmpty(str) || (businessInfo = getBusinessInfo(str)) == null || sosoLbsInfo == null) {
            return null;
        }
        if (businessInfo.reqRawData) {
            SosoLbsInfo sosoLbsInfo2 = new SosoLbsInfo();
            sosoLbsInfo2.rawData = sosoLbsInfo.rawData;
            SosoLocation sosoLocation = sosoLbsInfo.mLocation;
            if (sosoLocation != null) {
                sosoLbsInfo2.mLocation = sosoLocation.clone(0, businessInfo.reqLonAndLat);
            }
            SosoAttribute sosoAttribute = sosoLbsInfo.mAttr;
            if (sosoAttribute != null) {
                sosoLbsInfo2.mAttr = sosoAttribute.m221clone();
            }
            ArrayList<SosoCell> arrayList = new ArrayList<>();
            ArrayList<SosoCell> arrayList2 = sosoLbsInfo.mCells;
            if (arrayList2 != null) {
                arrayList.addAll(arrayList2);
            }
            sosoLbsInfo2.mCells = arrayList;
            ArrayList<SosoWifi> arrayList3 = new ArrayList<>();
            ArrayList<SosoWifi> arrayList4 = sosoLbsInfo.mWifis;
            if (arrayList4 != null) {
                arrayList3.addAll(arrayList4);
            }
            sosoLbsInfo2.mWifis = arrayList3;
            sosoLbsInfo2.mSource = sosoLbsInfo.mSource;
            sosoLbsInfo2.mVersion = sosoLbsInfo.mVersion;
            sosoLbsInfo2.provider = sosoLbsInfo.provider;
            return sosoLbsInfo2;
        }
        SosoLbsInfo sosoLbsInfo3 = new SosoLbsInfo();
        sosoLbsInfo3.mLocation = sosoLbsInfo.mLocation.clone(businessInfo.requestDataLevel, businessInfo.reqLonAndLat);
        return sosoLbsInfo3;
    }

    public static void initLocationManager() {
        SosoInterface.initLocationManager();
    }

    public static boolean isLastLocationSuccess() {
        return SosoInterface.isLastLocationSuccess();
    }

    private static boolean isLocationPermissionCheckSwitchOpen() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(KEY_LOCATION_PERMISSION_CHECK_SWITCH, false);
    }

    private static SosoInterfaceOnLocationListener makeSosoOnLocationListener(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener) {
        BusinessInfo businessInfo = getBusinessInfo(lbsManagerServiceOnLocationChangeListener.businessId);
        if (businessInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "makeSososOnLocationListener business info is null, business id: " + lbsManagerServiceOnLocationChangeListener.businessId);
            }
            return null;
        }
        if (!checkLocationPermissionGroup(businessInfo)) {
            QLog.i(TAG, 2, "PermissionGroup don\u2018t have permission");
            return null;
        }
        int canUseMaxCacheInterval = businessInfo.canUseMaxCacheInterval();
        return new SosoInterfaceOnLocationListener(businessInfo.requestDataLevel, !businessInfo.reqRawData, businessInfo.canUseGps, canUseMaxCacheInterval, lbsManagerServiceOnLocationChangeListener.observerOnUiThread, businessInfo.reqGoon, lbsManagerServiceOnLocationChangeListener.businessId, lbsManagerServiceOnLocationChangeListener) { // from class: com.tencent.mobileqq.soso.location.LbsManagerService.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LbsManagerServiceOnLocationChangeListener val$listener;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r5, r6, r7, canUseMaxCacheInterval, r10, r11, r12);
                this.val$listener = lbsManagerServiceOnLocationChangeListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(r5), Boolean.valueOf(r6), Boolean.valueOf(r7), Long.valueOf(canUseMaxCacheInterval), Boolean.valueOf(r10), Boolean.valueOf(r11), r12, lbsManagerServiceOnLocationChangeListener);
                }
            }

            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onConsecutiveFailure(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z16 = true;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    synchronized (LbsManagerService.sListenerMap) {
                        if (LbsManagerService.sReverseListenerMap.containsKey(this)) {
                            if (QLog.isColorLevel()) {
                                QLog.i(LbsManagerService.TAG, 2, "onConsecutiveFailure reverseListenerMap contains. business id: " + this.tag + " fail count: " + i16);
                            }
                            if (i16 > 5) {
                                LbsManagerService.sListenerMap.remove((LbsManagerServiceOnLocationChangeListener) LbsManagerService.sReverseListenerMap.remove(this));
                            } else {
                                LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener2 = (LbsManagerServiceOnLocationChangeListener) LbsManagerService.sReverseListenerMap.get(this);
                                if (i16 != 5) {
                                    z16 = false;
                                }
                                lbsManagerServiceOnLocationChangeListener2.onConsecutiveFailure(i3, i16, z16);
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.i(LbsManagerService.TAG, 2, "onConsecutiveFailure reverseListenerMap not contains. business id: " + this.tag + " fail count: " + i16);
                        }
                    }
                    if (i16 > 5) {
                        SosoInterface.removeOnLocationListener(this);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }

            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    LbsManagerService.notifySec(this.val$listener.businessId, sosoLbsInfo);
                    synchronized (LbsManagerService.sListenerMap) {
                        if (QLog.isColorLevel()) {
                            QLog.i(LbsManagerService.TAG, 2, "LbsManagerServiceANR onLocationFinish hold lock. business id: " + this.tag);
                        }
                        if (LbsManagerService.sReverseListenerMap.containsKey(this)) {
                            if (QLog.isColorLevel()) {
                                QLog.i(LbsManagerService.TAG, 2, "onLocationFinish reverseListenerMap contains. business id: " + this.tag);
                            }
                            if (this.goonListener) {
                                lbsManagerServiceOnLocationChangeListener2 = (LbsManagerServiceOnLocationChangeListener) LbsManagerService.sReverseListenerMap.get(this);
                            } else {
                                lbsManagerServiceOnLocationChangeListener2 = (LbsManagerServiceOnLocationChangeListener) LbsManagerService.sReverseListenerMap.remove(this);
                                LbsManagerService.sListenerMap.remove(lbsManagerServiceOnLocationChangeListener2);
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.i(LbsManagerService.TAG, 2, "onLocationFinish reverseListenerMap not contains. business id: " + this.tag + " this is: " + this);
                            }
                            lbsManagerServiceOnLocationChangeListener2 = null;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(LbsManagerService.TAG, 2, "LbsManagerServiceANR onLocationFinish free lock. business id: " + this.tag);
                    }
                    if (lbsManagerServiceOnLocationChangeListener2 != null) {
                        lbsManagerServiceOnLocationChangeListener2.onLocationFinish(i3, LbsManagerService.handleLbsInfo(sosoLbsInfo, this.val$listener.businessId));
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
            }

            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onStatusUpdate(String str, int i3, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    synchronized (LbsManagerService.sListenerMap) {
                        if (LbsManagerService.sReverseListenerMap.containsKey(this)) {
                            ((LbsManagerServiceOnLocationChangeListener) LbsManagerService.sReverseListenerMap.get(this)).onStatusUpdate(str, i3, str2);
                        }
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifySec(String str, SosoLbsInfo sosoLbsInfo) {
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getCachedLbsInfo businessId: " + str + " fake: " + sosoLbsInfo.mLocation.fakeReason + " longitude\uff1a" + sosoLbsInfo.mLocation.mLon02 + " dimensionality\uff1a" + sosoLbsInfo.mLocation.mLat02);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(sosoLbsInfo.mLocation.fakeReason));
            arrayList.add(String.valueOf(sosoLbsInfo.mLocation.mLon02));
            arrayList.add(String.valueOf(sosoLbsInfo.mLocation.mLat02));
            arrayList.add(sosoLbsInfo.mLocation.address);
            ((IO3NotifySecApi) QRoute.api(IO3NotifySecApi.class)).sendMessage(str, arrayList);
        }
    }

    public static void onDestroy() {
        synchronized (sListenerMap) {
            sListenerMap.clear();
            sReverseListenerMap.clear();
        }
    }

    private static void registerBusinessInfo() {
        BusinessInfo businessInfo = new BusinessInfo(ISosoInterfaceConstant.DEFAULT_LOCATION_BUSINESS_ID, ISosoInterfaceConstant.DEFAULT_LOCATION_PERMISSION_ID, false, 1, 0, false, false, false);
        HashMap<String, BusinessInfo> hashMap = S_BUSINESS;
        hashMap.put(businessInfo.businessId, businessInfo);
        BusinessInfo businessInfo2 = new BusinessInfo("official_location", true, 5, 0, false, false, false);
        hashMap.put(businessInfo2.businessId, businessInfo2);
        BusinessInfo businessInfo3 = new BusinessInfo(QQMapActivity.TAG, true, 5, 1, true, true, false);
        hashMap.put(businessInfo3.businessId, businessInfo3);
        BusinessInfo businessInfo4 = new BusinessInfo("readinjoy_anti_cheating", true, 2, 0, false, false, false);
        hashMap.put(businessInfo4.businessId, businessInfo4);
        BusinessInfo businessInfo5 = new BusinessInfo("vas_red_point", true, 2, 3, false, false, false);
        hashMap.put(businessInfo5.businessId, businessInfo5);
        BusinessInfo businessInfo6 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT, true, 5, 0, false, true, false);
        hashMap.put(businessInfo6.businessId, businessInfo6);
        BusinessInfo businessInfo7 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT, true, 3, 0, false, false, false);
        hashMap.put(businessInfo7.businessId, businessInfo7);
        BusinessInfo businessInfo8 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_WEATHER, true, 4, 0, false, false, false);
        hashMap.put(businessInfo8.businessId, businessInfo8);
        BusinessInfo businessInfo9 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_LIVE, true, 5, 0, false, false, false);
        hashMap.put(businessInfo9.businessId, businessInfo9);
        BusinessInfo businessInfo10 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_SAY, true, 5, 0, false, true, false);
        hashMap.put(businessInfo10.businessId, businessInfo10);
        BusinessInfo businessInfo11 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_UPLOAD_PIC_VIDEO, true, 5, 0, false, false, false);
        hashMap.put(businessInfo11.businessId, businessInfo11);
        BusinessInfo businessInfo12 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_PHOTO_RECOMMEND, true, 3, 0, false, false, false);
        hashMap.put(businessInfo12.businessId, businessInfo12);
        BusinessInfo businessInfo13 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_LITTLE_VIDEO_ENTER, true, 3, 0, false, false, false);
        hashMap.put(businessInfo13.businessId, businessInfo13);
        BusinessInfo businessInfo14 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_REQUEST_SERVER, true, 2, 0, false, false, false);
        hashMap.put(businessInfo14.businessId, businessInfo14);
        BusinessInfo businessInfo15 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_H5, false, 3, 3, false, false, false);
        hashMap.put(businessInfo15.businessId, businessInfo15);
        BusinessInfo businessInfo16 = new BusinessInfo(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER, true, 5, 0, false, false, false);
        hashMap.put(businessInfo16.businessId, businessInfo16);
        BusinessInfo businessInfo17 = new BusinessInfo("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
        hashMap.put(businessInfo17.businessId, businessInfo17);
        BusinessInfo businessInfo18 = new BusinessInfo("gdt_tangram", true, 1, 0, false, false, false);
        hashMap.put(businessInfo18.businessId, businessInfo18);
        BusinessInfo businessInfo19 = new BusinessInfo("nearby_readinjoy", true, 4, 0, false, false, false);
        hashMap.put(businessInfo19.businessId, businessInfo19);
        BusinessInfo businessInfo20 = new BusinessInfo("troop_handler", true, 2, 0, false, true, false);
        hashMap.put(businessInfo20.businessId, businessInfo20);
        BusinessInfo businessInfo21 = new BusinessInfo("troop_member_distance", true, 2, 0, false, false, false);
        hashMap.put(businessInfo21.businessId, businessInfo21);
        BusinessInfo businessInfo22 = new BusinessInfo("webview", true, 3, 4, false, false, false);
        hashMap.put(businessInfo22.businessId, businessInfo22);
        BusinessInfo businessInfo23 = new BusinessInfo("qq_weather", true, 3, 3, false, false, false);
        hashMap.put(businessInfo23.businessId, businessInfo23);
        BusinessInfo businessInfo24 = new BusinessInfo("qq_story_water_mark", true, 4, 0, false, false, false);
        hashMap.put(businessInfo24.businessId, businessInfo24);
        BusinessInfo businessInfo25 = new BusinessInfo("readinjoy_weather", false, 3, 3, false, false, false);
        hashMap.put(businessInfo25.businessId, businessInfo25);
        BusinessInfo businessInfo26 = new BusinessInfo("LBSService.Point", true, 5, 0, false, false, false);
        hashMap.put(businessInfo26.businessId, businessInfo26);
        BusinessInfo businessInfo27 = new BusinessInfo("Login.Guide", true, 2, 0, false, false, false);
        hashMap.put(businessInfo27.businessId, businessInfo27);
        BusinessInfo businessInfo28 = new BusinessInfo("recommend_troop", true, 2, 0, false, false, false);
        hashMap.put(businessInfo28.businessId, businessInfo28);
        BusinessInfo businessInfo29 = new BusinessInfo("vfuchong_bus_card", false, 3, 3, false, false, false);
        hashMap.put(businessInfo29.businessId, businessInfo29);
        BusinessInfo businessInfo30 = new BusinessInfo("readinjoy_position", false, 3, 3, false, false, false);
        hashMap.put(businessInfo30.businessId, businessInfo30);
        BusinessInfo businessInfo31 = new BusinessInfo("qqcircle", true, 4, 0, false, true, false);
        hashMap.put(businessInfo31.businessId, businessInfo31);
        BusinessInfo businessInfo32 = new BusinessInfo("extend_friend", true, 1, 0, false, true, false);
        hashMap.put(businessInfo32.businessId, businessInfo32);
        BusinessInfo businessInfo33 = new BusinessInfo("miniapp", true, 1, 0, false, true, false);
        hashMap.put(businessInfo33.businessId, businessInfo33);
        BusinessInfo businessInfo34 = new BusinessInfo("NearbyProtocolCoder.Encounter", true, 1, 0, false, true, false);
        hashMap.put(businessInfo34.businessId, businessInfo34);
        BusinessInfo businessInfo35 = new BusinessInfo("QQLive", true, 2, 3, false, true, false);
        hashMap.put(businessInfo35.businessId, businessInfo35);
        BusinessInfo businessInfo36 = new BusinessInfo(LocationInputFragment.LBS_BIZ_QWALLET_ID_VERIFY, false, 2, 3, false, true, false);
        hashMap.put(businessInfo36.businessId, businessInfo36);
        BusinessInfo businessInfo37 = new BusinessInfo("NearByPro", true, 5, 3, false, true, false);
        hashMap.put(businessInfo37.businessId, businessInfo37);
        BusinessInfo businessInfo38 = new BusinessInfo("QQSearch", true, 2, 3, false, true, false);
        hashMap.put(businessInfo38.businessId, businessInfo38);
        BusinessInfo businessInfo39 = new BusinessInfo("pathtrace", true, 5, 0, true, true, false);
        hashMap.put(businessInfo39.businessId, businessInfo39);
    }

    public static void removeListener(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener) {
        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener;
        boolean z16;
        if (lbsManagerServiceOnLocationChangeListener == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "LbsManagerServiceANR removeListener getting lock.");
        }
        synchronized (sListenerMap) {
            if (sListenerMap.containsKey(lbsManagerServiceOnLocationChangeListener)) {
                sosoInterfaceOnLocationListener = sListenerMap.remove(lbsManagerServiceOnLocationChangeListener);
                sReverseListenerMap.remove(sosoInterfaceOnLocationListener);
            } else {
                sosoInterfaceOnLocationListener = null;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("LbsManagerServiceANR removeListener business id is: ");
            sb5.append(lbsManagerServiceOnLocationChangeListener.businessId);
            sb5.append(" sosoLocationListener is null: ");
            if (sosoInterfaceOnLocationListener == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(TAG, 2, sb5.toString());
        }
        if (sosoInterfaceOnLocationListener != null) {
            SosoInterface.removeOnLocationListener(sosoInterfaceOnLocationListener);
        }
    }

    public static void startLocation(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener) {
        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener;
        boolean z16;
        if (lbsManagerServiceOnLocationChangeListener == null) {
            return;
        }
        synchronized (sListenerMap) {
            if (!sListenerMap.containsKey(lbsManagerServiceOnLocationChangeListener)) {
                sosoInterfaceOnLocationListener = makeSosoOnLocationListener(lbsManagerServiceOnLocationChangeListener);
                if (sosoInterfaceOnLocationListener != null) {
                    sListenerMap.put(lbsManagerServiceOnLocationChangeListener, sosoInterfaceOnLocationListener);
                    sReverseListenerMap.put(sosoInterfaceOnLocationListener, lbsManagerServiceOnLocationChangeListener);
                }
            } else {
                sosoInterfaceOnLocationListener = null;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startLocation sosoLocationListener is null : ");
            if (sosoInterfaceOnLocationListener == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" business id: ");
            sb5.append(lbsManagerServiceOnLocationChangeListener.businessId);
            QLog.i(TAG, 2, sb5.toString());
        }
        if (sosoInterfaceOnLocationListener != null) {
            SosoInterface.startLocation(sosoInterfaceOnLocationListener);
        }
    }

    public static String getCity(String str) {
        if (!checkLocationPermissionGroup(getBusinessInfo(str))) {
            QLog.i(TAG, 2, "PermissionGroup don\u2018t have permission");
            return "";
        }
        return SosoInterface.getCity();
    }

    public static String getCityCode(String str) {
        if (!checkLocationPermissionGroup(getBusinessInfo(str))) {
            QLog.i(TAG, 2, "PermissionGroup don\u2018t have permission");
            return "";
        }
        return SosoInterface.getCityCode();
    }

    public static String getProvince(String str) {
        if (!checkLocationPermissionGroup(getBusinessInfo(str))) {
            QLog.i(TAG, 2, "PermissionGroup don\u2018t have permission");
            return "";
        }
        return SosoInterface.getProvince();
    }

    public static SosoLbsInfo getCachedLbsInfo(boolean z16) {
        if (z16) {
            return SosoInterface.getRawSosoInfo(false);
        }
        return SosoInterface.getSosoInfo(3, false);
    }
}

package com.tencent.mobileqq.nearby.api;

import NearbyGroup.Attr;
import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.LBSInfo;
import NearbyGroup.Wifi;
import appoint.define.appoint_define$Cell;
import appoint.define.appoint_define$GPS;
import appoint.define.appoint_define$LBSInfo;
import appoint.define.appoint_define$Wifi;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoAttribute;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {
    public static appoint_define$LBSInfo b(String str) {
        SosoLocation sosoLocation;
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
        if (cachedLbsInfo == null || (sosoLocation = cachedLbsInfo.mLocation) == null || sosoLocation.mLat02 == 0.0d || sosoLocation.mLon02 == 0.0d) {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(60000L, str);
            cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
        }
        if (cachedLbsInfo != null) {
            appoint_define$LBSInfo appoint_define_lbsinfo = new appoint_define$LBSInfo();
            ArrayList<SosoWifi> arrayList = cachedLbsInfo.mWifis;
            if (arrayList != null) {
                Iterator<SosoWifi> it = arrayList.iterator();
                while (it.hasNext()) {
                    SosoWifi next = it.next();
                    if (next != null) {
                        appoint_define$Wifi appoint_define_wifi = new appoint_define$Wifi();
                        appoint_define_wifi.uint64_mac.set(next.mMac);
                        appoint_define_wifi.int32_rssi.set(next.mRssi);
                        appoint_define_lbsinfo.rpt_msg_wifis.add(appoint_define_wifi);
                    }
                }
            }
            ArrayList<SosoCell> arrayList2 = cachedLbsInfo.mCells;
            if (arrayList2 != null) {
                Iterator<SosoCell> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    SosoCell next2 = it5.next();
                    if (next2 != null) {
                        appoint_define$Cell appoint_define_cell = new appoint_define$Cell();
                        appoint_define_cell.int32_cellid.set(next2.mCellId);
                        appoint_define_cell.int32_lac.set(next2.mLac);
                        appoint_define_cell.int32_rssi.set(next2.mRss);
                        appoint_define_cell.int32_mcc.set(next2.mMcc);
                        appoint_define_cell.int32_mnc.set(next2.mMnc);
                        appoint_define_lbsinfo.rpt_msg_cells.add(appoint_define_cell);
                    }
                }
            }
            if (cachedLbsInfo.mLocation == null) {
                return appoint_define_lbsinfo;
            }
            appoint_define$GPS appoint_define_gps = new appoint_define$GPS();
            appoint_define_gps.int32_lon.set((int) (cachedLbsInfo.mLocation.mLon84 * 1000000.0d));
            appoint_define_gps.int32_lat.set((int) (cachedLbsInfo.mLocation.mLat84 * 1000000.0d));
            appoint_define_gps.int32_type.set(0);
            appoint_define_lbsinfo.msg_gps.set(appoint_define_gps);
            return appoint_define_lbsinfo;
        }
        l.b("getLbsInfo", "lbs is null");
        return null;
    }

    public static LBSInfo c() {
        return a(false, ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter"));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LBSInfo a(boolean z16, SosoLbsInfo sosoLbsInfo) {
        GPS gps;
        ArrayList<SosoWifi> arrayList;
        SosoLocation sosoLocation;
        if (sosoLbsInfo == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<SosoCell> arrayList3 = sosoLbsInfo.mCells;
        if (arrayList3 != null) {
            Iterator<SosoCell> it = arrayList3.iterator();
            while (it.hasNext()) {
                SosoCell next = it.next();
                arrayList2.add(new Cell((short) next.mMcc, (short) next.mMnc, next.mLac, next.mCellId, (short) next.mRss));
            }
        }
        try {
            sosoLocation = sosoLbsInfo.mLocation;
        } catch (Exception unused) {
        }
        if (sosoLocation != null) {
            if (z16) {
                gps = new GPS((int) (sosoLocation.mLat02 * 1000000.0d), (int) (sosoLocation.mLon02 * 1000000.0d), -1, 1);
            } else {
                gps = new GPS((int) (sosoLocation.mLat84 * 1000000.0d), (int) (sosoLocation.mLon84 * 1000000.0d), -1, 0);
            }
            ArrayList arrayList4 = new ArrayList();
            arrayList = sosoLbsInfo.mWifis;
            if (arrayList != null) {
                Iterator<SosoWifi> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    SosoWifi next2 = it5.next();
                    if (next2 != null) {
                        arrayList4.add(new Wifi(next2.mMac, (short) next2.mRssi));
                    }
                }
            }
            SosoAttribute sosoAttribute = sosoLbsInfo.mAttr;
            return new LBSInfo(gps, arrayList4, arrayList2, sosoAttribute != null ? new Attr(sosoAttribute.mImei, sosoAttribute.mImsi, sosoAttribute.mPhoneNum) : null);
        }
        gps = null;
        ArrayList arrayList42 = new ArrayList();
        arrayList = sosoLbsInfo.mWifis;
        if (arrayList != null) {
        }
        SosoAttribute sosoAttribute2 = sosoLbsInfo.mAttr;
        return new LBSInfo(gps, arrayList42, arrayList2, sosoAttribute2 != null ? new Attr(sosoAttribute2.mImei, sosoAttribute2.mImsi, sosoAttribute2.mPhoneNum) : null);
    }
}

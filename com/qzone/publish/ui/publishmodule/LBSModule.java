package com.qzone.publish.ui.publishmodule;

import NS_MOBILE_OPERATION.LbsInfo;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.business.lbsv2.business.e;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.configx.g;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LBSModule extends com.qzone.publish.ui.publishmodule.b {
    private LbsDataV2.PoiInfo C;
    private LbsDataV2.PoiList F;
    private LbsDataV2.PoiList G;

    /* renamed from: h, reason: collision with root package name */
    private String f51979h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f51980i = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f51981m = false;
    private String D = "";
    private String E = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LBSModule.this.w(2);
            LBSModule.this.b().R0.setVisibility(8);
            int parseInt = Integer.parseInt((String) view.getTag()) - 1;
            if (LBSModule.this.G != null && LBSModule.this.G.poiInfos != null) {
                LBSModule lBSModule = LBSModule.this;
                lBSModule.E(lBSModule.G.poiInfos.get(parseInt), LBSModule.this.b().T0 != null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LBSModule.this.w(3);
            LBSModule.this.C();
            LBSModule.this.b().R0.setVisibility(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalImageShootInfo B() {
        if (b().Jk() && b().W != null && b().Y != null) {
            ArrayList arrayList = new ArrayList(b().oj());
            if (arrayList.size() > 0) {
                b().f45108k1 = 0;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    LocalImageShootInfo createFrom = LocalImageShootInfo.createFrom(str);
                    LocalMediaInfo localMediaInfo = b().W.get(str);
                    if (QAlbumUtil.getMediaType(localMediaInfo) == 1 && !b().Y.containsKey(str) && localMediaInfo != null) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        b().Y.put(str, LocalImageShootInfo.getGpsInfoForVideo(mediaMetadataRetriever, str));
                        mediaMetadataRetriever.release();
                    }
                    if (b().Y.containsKey(str) && createFrom != null) {
                        createFrom.gpsInfo = b().Y.get(str);
                    }
                    if (createFrom != null && createFrom.gpsInfo != null) {
                        return createFrom;
                    }
                    b().f45108k1++;
                }
            }
        }
        return null;
    }

    private void F(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null) {
            if (unpack.getSucceed()) {
                M((j5.c) unpack.getData());
                this.f51981m = true;
                return;
            } else {
                b().Xl(2, "");
                b().L0 = null;
                this.G = null;
                return;
            }
        }
        b().L0 = null;
        this.G = null;
        b().Xl(2, "");
    }

    private void G(Message message) {
        ArrayList<LbsDataV2.PoiInfo> arrayList;
        QZoneResult unpack = QZoneResult.unpack(message);
        b().K0 = 2;
        if (unpack == null) {
            this.F = null;
            return;
        }
        if (unpack.getSucceed()) {
            LbsDataV2.PoiList poiList = (LbsDataV2.PoiList) unpack.getData();
            I(unpack.getBundle() != null ? unpack.getBundle().getString("attachinfo") : null);
            this.F = poiList;
            if (poiList == null || (arrayList = poiList.poiInfos) == null || arrayList.size() <= 0) {
                return;
            }
            b().K0 = 4;
            b().M0 = LbsDataV2.PoiInfo.clone(this.F.poiInfos.get(0));
            Intent c16 = c();
            if (c16 != null && c16.getBooleanExtra("key_need_save_draft", true)) {
                b().ol();
            }
            this.f51980i = true;
            if (b().Y0 || (b().f45084c1 && b().f45102i1 == 0)) {
                b().Y0 = false;
                b().Xl(1, b().M0.poiDefaultName);
                return;
            }
            return;
        }
        this.F = null;
        b().M0 = null;
    }

    private void L() {
        LbsDataV2.PoiList poiList;
        ArrayList<LbsDataV2.PoiInfo> arrayList;
        if (b().R0 == null || (poiList = this.G) == null || (arrayList = poiList.poiInfos) == null || arrayList.size() == 0 || b().T0 == null || b().K0 == 1) {
            return;
        }
        w(1);
        b().R0.setVisibility(0);
        if (b().f45118n2) {
            b().runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.publishmodule.LBSModule.2
                @Override // java.lang.Runnable
                public void run() {
                    LBSModule.this.b().om();
                }
            });
        }
        ArrayList<LbsDataV2.PoiInfo> arrayList2 = this.G.poiInfos;
        ArrayList arrayList3 = new ArrayList(6);
        FrameLayout frameLayout = b().R0;
        TextView textView = (TextView) frameLayout.findViewById(R.id.hqo);
        textView.setTag("1");
        arrayList3.add(textView);
        TextView textView2 = (TextView) frameLayout.findViewById(R.id.hqp);
        textView2.setTag("2");
        arrayList3.add(textView2);
        TextView textView3 = (TextView) frameLayout.findViewById(R.id.hqq);
        textView3.setTag("3");
        arrayList3.add(textView3);
        TextView textView4 = (TextView) frameLayout.findViewById(R.id.hqr);
        textView4.setTag("4");
        arrayList3.add(textView4);
        TextView textView5 = (TextView) frameLayout.findViewById(R.id.hqs);
        textView5.setTag("5");
        arrayList3.add(textView5);
        LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.hqu);
        for (int i3 = 0; i3 < 5 && i3 < arrayList2.size(); i3++) {
            TextView textView6 = (TextView) arrayList3.get(i3);
            LbsDataV2.PoiInfo poiInfo = arrayList2.get(i3);
            if (textView6 != null && poiInfo != null) {
                textView6.setText(poiInfo.poiName);
            }
            if (textView6 != null) {
                textView6.setVisibility(0);
                textView6.setOnClickListener(new a());
            }
        }
        linearLayout.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3) {
        if (b().S0 == 1) {
            LpReportInfo_pf00064.allReport(586, 26, i3);
        } else if (b().S0 == 2) {
            LpReportInfo_pf00064.allReport(602, 14, i3);
        }
    }

    public LbsDataV2.PoiInfo A() {
        LbsDataV2.PoiInfo poiInfo = null;
        if (!b().P0) {
            this.C = null;
        }
        LbsDataV2.PoiInfo poiInfo2 = this.C;
        if (poiInfo2 == null) {
            LbsDataV2.GpsInfo a16 = com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_UPLOAD_PIC_VIDEO).a();
            if (a16 != null) {
                poiInfo = new LbsDataV2.PoiInfo();
                LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
                gpsInfo.lat = a16.lat;
                gpsInfo.lon = a16.lon;
                poiInfo.show_poi = 0;
            }
            return poiInfo;
        }
        poiInfo2.show_poi = 1;
        return poiInfo2;
    }

    public void D(boolean z16) {
        b().startActivityForResult(x(z16), 1208);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(LbsDataV2.PoiInfo poiInfo, boolean z16) {
        int i3;
        int i16;
        String str;
        b().V0 = false;
        String str2 = "";
        if (poiInfo == null) {
            if (z16) {
                b().M0 = null;
                b().K0 = 2;
                return;
            } else {
                b().L0 = null;
                b().Xl(2, "");
                return;
            }
        }
        b().P0 = true;
        if (!TextUtils.isEmpty(poiInfo.poiId)) {
            if (poiInfo.poiId.equals("invalide_poi_id")) {
                b().V0 = true;
                i3 = 0;
            } else {
                if (poiInfo.poiId.equals("custom_poi_id")) {
                    i3 = 3;
                    i16 = 0;
                    str = poiInfo.poiName;
                    if (TextUtils.isEmpty(str)) {
                        str = poiInfo.poiDefaultName;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = poiInfo.address;
                    }
                    if (z16) {
                        b().M0 = poiInfo;
                    } else {
                        b().L0 = poiInfo;
                    }
                    if (!b().V0) {
                        this.C = null;
                    } else {
                        this.C = poiInfo;
                    }
                    PhotoActivity b16 = b();
                    String[] strArr = new String[2];
                    strArr[0] = str;
                    if (i16 != 0) {
                        str2 = this.E;
                    }
                    strArr[1] = str2;
                    b16.Xl(i3, strArr);
                    return;
                }
                i3 = 1;
            }
            i16 = i3;
            str = poiInfo.poiName;
            if (TextUtils.isEmpty(str)) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            if (z16) {
            }
            if (!b().V0) {
            }
            PhotoActivity b162 = b();
            String[] strArr2 = new String[2];
            strArr2[0] = str;
            if (i16 != 0) {
            }
            strArr2[1] = str2;
            b162.Xl(i3, strArr2);
            return;
        }
        b().Xl(0, new String[0]);
    }

    public void I(String str) {
        this.f51979h = str;
    }

    public void J() {
        if (!b().V0 && !this.f51981m) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.publishmodule.LBSModule.1
                @Override // java.lang.Runnable
                public void run() {
                    LocalImageShootInfo B = LBSModule.this.B();
                    ArrayList<LocalImageShootInfo> arrayList = LBSModule.this.b().U0;
                    LBSModule.this.b().T0 = B;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (B != null) {
                            e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).n(LBSModule.this.b().getHandler(), 1000053, B, LBSModule.this.b().getAppId(), 7);
                            return;
                        } else {
                            LBSModule.this.b().runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.publishmodule.LBSModule.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LBSModule.this.K();
                                }
                            });
                            return;
                        }
                    }
                    ArrayList<GpsInfo4LocalImage> arrayList2 = new ArrayList<>();
                    Iterator<LocalImageShootInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        GpsInfo4LocalImage gpsInfo4LocalImage = it.next().gpsInfo;
                        if (gpsInfo4LocalImage != null) {
                            arrayList2.add(gpsInfo4LocalImage);
                        }
                    }
                    e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).A(LBSModule.this.b().getHandler(), 1000403, arrayList2, LBSModule.this.b().getAppId());
                }
            });
        } else {
            this.C = null;
        }
    }

    public void K() {
        if (g.f53821a.b().o()) {
            QLog.d("LBSModule", 1, "setLbsValueLocal disable pre locate direct return!");
            return;
        }
        if (b().M0 == null || b().L0 != null) {
            b().Xl(0, "");
        }
        if (!TextUtils.isEmpty(this.E)) {
            this.E = "";
        }
        if (this.f51980i || b().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).y(b().getHandler(), "", 1000007, b().getAppId(), false, null);
    }

    @Override // com.qzone.publish.ui.publishmodule.b
    public void o(Message message) {
        int i3 = message.what;
        if (i3 != 1000007) {
            if (i3 == 1000053) {
                F(message);
                L();
                return;
            } else if (i3 != 1000403) {
                return;
            }
        }
        G(message);
    }

    public Intent x(boolean z16) {
        ArrayList<LbsDataV2.PoiInfo> arrayList;
        ArrayList<LbsDataV2.PoiInfo> arrayList2;
        Intent l3 = ak.l(b().getActivity(), QZoneHelper.MOOD_SELECT_LOCATION);
        LocalImageShootInfo localImageShootInfo = b().T0;
        ArrayList<LocalImageShootInfo> arrayList3 = b().U0;
        DynamicArrayList<String> dynamicArrayList = b().U;
        LbsDataV2.PoiInfo poiInfo = b().M0;
        int i3 = b().K0;
        if (localImageShootInfo != null && dynamicArrayList != null && dynamicArrayList.contains(localImageShootInfo.path)) {
            l3.putExtra("key_current_img_shoot_info", localImageShootInfo);
            LbsDataV2.PoiList poiList = this.G;
            if (poiList != null && (arrayList2 = poiList.poiInfos) != null && arrayList2.size() > 0) {
                l3.putParcelableArrayListExtra("key_current_poi_list_infos", this.G.poiInfos);
            }
            l3.putExtra("key_current_poi", b().L0);
        } else {
            LbsDataV2.PoiList poiList2 = this.F;
            if (poiList2 != null && (arrayList = poiList2.poiInfos) != null && arrayList.size() > 0) {
                l3.putParcelableArrayListExtra("key_current_poi_list_infos", this.F.poiInfos);
            }
            l3.putExtra("key_current_poi", poiInfo);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            l3.putParcelableArrayListExtra("key_current_image_shoot_infos", arrayList3);
        }
        l3.putExtra("attachinfo", this.f51979h);
        l3.putExtra("key_sync_weishi", z16);
        l3.putExtra("key_show_local_geo", false);
        l3.putExtra("key_app_id", b().getAppId());
        l3.putExtra("key_lbs_state", i3);
        return l3;
    }

    public LbsDataV2.PoiInfo y() {
        return this.C;
    }

    public Map<String, String> z() {
        String str;
        if ((b().K0 != 1 && b().K0 != 3) || b().V0 || !b().mm()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        LbsDataV2.PoiInfo poiInfo = this.C;
        if (poiInfo != null) {
            LbsInfo parceToLbsInfo = LbsDataV2.parceToLbsInfo(poiInfo);
            if (parceToLbsInfo != null) {
                hashMap.put("geo_x", parceToLbsInfo.lbs_x);
                hashMap.put("geo_y", parceToLbsInfo.lbs_y);
                hashMap.put("geo_id", String.valueOf(parceToLbsInfo.lbs_id));
                hashMap.put("geo_idname", parceToLbsInfo.lbs_idnm + " " + this.D);
                hashMap.put("geo_name", parceToLbsInfo.lbs_nm);
            }
            if (b().T0 != null && b().T0.captureTime > 0) {
                hashMap.put("capturetime", String.valueOf(b().T0.captureTime));
                str = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format((Date) new java.sql.Date(b().T0.captureTime));
            } else {
                str = "";
            }
            hashMap.put(PhotoCacheData.SHOOTTIME, str);
            hashMap.put("jump_type", "1");
            hashMap.put("jump_id", this.C.dianPingId);
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("GeoInfo", 4, "getPhotoShootParams|targetShootIndex:" + b().f45108k1);
        }
        hashMap.put("targetShootIndex", String.valueOf(b().f45108k1));
        return hashMap;
    }

    public void C() {
        D(false);
    }

    public void H(LbsDataV2.PoiInfo poiInfo) {
        E(poiInfo, false);
    }

    private void M(j5.c cVar) {
        ArrayList<LbsDataV2.PoiInfo> arrayList;
        String str;
        LbsDataV2.GpsInfo gpsInfo;
        if (cVar == null) {
            b().K0 = 2;
            return;
        }
        LbsDataV2.PoiList poiList = cVar.f409271c;
        this.G = poiList;
        if (poiList == null || (arrayList = poiList.poiInfos) == null || arrayList.size() <= 0) {
            return;
        }
        LbsDataV2.PoiInfo poiInfo = this.G.poiInfos.get(0);
        if (poiInfo != null && (gpsInfo = poiInfo.gpsInfo) != null) {
            int i3 = gpsInfo.lat;
            int i16 = LbsDataV2.GPS_DEFAULT_VALUE;
            if ((i3 == i16 || gpsInfo.lon == i16) && b().L0 != null && b().L0.gpsInfo != null) {
                poiInfo.gpsInfo = b().L0.gpsInfo;
            }
        }
        b().L0 = LbsDataV2.PoiInfo.clone(poiInfo);
        this.C = b().L0;
        b().ol();
        String str2 = "";
        if (b().L0 == null) {
            str = "";
        } else {
            str = b().L0.poiDefaultName;
            if (TextUtils.isEmpty(str)) {
                str = b().L0.poiName;
            }
            if (TextUtils.isEmpty(str)) {
                str = b().L0.address;
            }
        }
        if (!TextUtils.isEmpty(cVar.f409270b)) {
            str2 = "" + cVar.f409270b;
        }
        if (!TextUtils.isEmpty(cVar.f409269a)) {
            this.D = cVar.f409269a;
            str2 = (str2 + " ") + cVar.f409269a;
        }
        this.E = str2;
        if (!b().mm() || b().L0 == null) {
            return;
        }
        b().Xl(1, str, str2);
    }

    @Override // com.qzone.publish.ui.publishmodule.b
    public void i(int i3, int i16, Intent intent) {
        if (i3 == 1208) {
            if (b().R0 != null) {
                b().R0.setVisibility(8);
            }
            if (i16 != -1 || intent == null || intent.getExtras() == null) {
                return;
            }
            E((LbsDataV2.PoiInfo) intent.getExtras().getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI), intent.getExtras().getBoolean("key_has_shoot_info"));
        }
    }
}

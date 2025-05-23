package com.qzone.business.lbsv2.ui;

import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetGeoInfoRsp_V2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.activities.base.CustomListViewFragmentV2;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.report.QzoneLbsReporter;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneMoodSelectLocation extends CustomListViewFragmentV2 {
    private int A0;
    private boolean C0;
    private boolean D0;
    private LinearLayout F0;
    private boolean G0;
    protected EditText H0;
    private RelativeLayout I0;
    private Runnable L0;
    protected InputMethodManager M0;
    private String N0;
    private ArrayList<LbsDataV2.PoiInfo> O0;
    private GeoInfo_V2 P0;
    private LbsDataV2.PoiInfo Q0;
    private LbsDataV2.PoiInfo R0;
    private long T0;
    private boolean U0;
    private j W0;
    private String X0;
    private boolean Y0;
    private boolean Z0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f44582a1;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f44583b1;

    /* renamed from: c1, reason: collision with root package name */
    public ArrayList<String> f44584c1;

    /* renamed from: d1, reason: collision with root package name */
    private QQPermission f44585d1;

    /* renamed from: e1, reason: collision with root package name */
    private long f44586e1;

    /* renamed from: f1, reason: collision with root package name */
    private long f44587f1;

    /* renamed from: w0, reason: collision with root package name */
    private int f44589w0;

    /* renamed from: x0, reason: collision with root package name */
    private LbsDataV2.PoiInfo f44590x0;

    /* renamed from: y0, reason: collision with root package name */
    private List<LocalImageShootInfo> f44591y0;

    /* renamed from: z0, reason: collision with root package name */
    private LocalImageShootInfo f44592z0;
    private boolean B0 = true;
    private boolean E0 = false;
    private String J0 = "";
    private long K0 = 0;
    private ArrayList<PhotoPoiArea> S0 = new ArrayList<>();
    private int V0 = 1;

    /* renamed from: g1, reason: collision with root package name */
    private final k f44588g1 = new k(this, QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT, true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneMoodSelectLocation.this.simpleClassname, view);
            try {
                if (((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45067q0 != null) {
                    if (((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45067q0.getText().toString().equals(QZoneMoodSelectLocation.this.getResources().getString(R.string.f170971bd0))) {
                        QZoneMoodSelectLocation.this.mi();
                        QZoneMoodSelectLocation.this.Ii();
                        QZoneMoodSelectLocation.this.Hi(false);
                        QZoneMoodSelectLocation.this.onRefresh();
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneMoodSelectLocation.this.Y0) {
                LpReportInfo_pf00064.allReport(86, 11, 3);
            }
            QZoneMoodSelectLocation.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneMoodSelectLocation.this.simpleClassname, view);
            QZoneMoodSelectLocation.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d extends QQPermission.BasePermissionsListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> list) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QZoneMoodSelectLocation.this.Xj();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            if (QZoneMoodSelectLocation.this.f44585d1.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                QZoneMoodSelectLocation.this.Xj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneMoodSelectLocation.this.simpleClassname, view);
            QZoneMoodSelectLocation.this.H0.setText("");
            QZoneMoodSelectLocation.this.J0 = "";
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class k extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneMoodSelectLocation> f44616a;

        /* renamed from: b, reason: collision with root package name */
        private long f44617b;

        public k(QZoneMoodSelectLocation qZoneMoodSelectLocation, String str, boolean z16) {
            super(str, z16);
            this.f44616a = new WeakReference<>(qZoneMoodSelectLocation);
        }

        public void g() {
            this.f44617b = System.currentTimeMillis();
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            long currentTimeMillis = System.currentTimeMillis() - this.f44617b;
            QZLog.i("QZoneMoodSelectLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]--checkOrRefresh onLocationFinish,errorCode:" + i3 + ",timeCost:" + currentTimeMillis);
            QzoneLbsReporter.reportLocationResult(i3, this.businessId, currentTimeMillis);
            QZoneMoodSelectLocation qZoneMoodSelectLocation = this.f44616a.get();
            if (qZoneMoodSelectLocation != null) {
                qZoneMoodSelectLocation.gk(i3, sosoLbsInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ak(PhotoPoiArea photoPoiArea) {
        Intent intent = new Intent();
        if (photoPoiArea != null) {
            ParcelableWrapper.putDataToIntent(intent, "key_select_photo_list_poi", photoPoiArea);
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk(LbsDataV2.PoiInfo poiInfo) {
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI, poiInfo);
        intent.putExtra("key_select_poi_name", poiInfo.poiName);
        intent.putExtra("key_select_poi_address", poiInfo.address);
        intent.putExtra("key_select_poi_id", poiInfo.poiId);
        LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
        if (gpsInfo != null) {
            intent.putExtra("key_select_poi_latitude", gpsInfo.lat);
            intent.putExtra("key_select_poi_longitude", poiInfo.gpsInfo.lat);
        }
        intent.putExtra("key_has_shoot_info", this.f44592z0 != null);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dk() {
        if (this.W0 == null) {
            this.W0 = new j();
        }
        this.f45060j0.setAdapter((ListAdapter) this.W0);
        Ci(4);
        this.f45060j0.setSupportPullDown(false);
    }

    private void Fk() {
        if (this.L0 == null) {
            this.L0 = new Runnable() { // from class: com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation.12
                @Override // java.lang.Runnable
                public void run() {
                    QZoneMoodSelectLocation qZoneMoodSelectLocation = QZoneMoodSelectLocation.this;
                    qZoneMoodSelectLocation.zk(qZoneMoodSelectLocation.J0);
                }
            };
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).removeTask(this.L0);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(this.L0, 700L);
    }

    private boolean Vj() {
        ArrayList<LbsDataV2.PoiInfo> arrayList = this.O0;
        return (arrayList == null || arrayList.isEmpty() || TextUtils.isEmpty(this.N0) || !TextUtils.isEmpty(this.J0)) ? false : true;
    }

    private boolean Wj() {
        if (NetworkState.isNetSupport()) {
            return true;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation.13
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil.n(R.string.ghi);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xj() {
        QZLog.i("QZoneMoodSelectLocation", "checkOrRefresh.");
        long config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LOCATE_MINPOI_INTERVAL, 20) * 1000;
        this.f44586e1 = config;
        if (config > 0) {
            this.f44588g1.g();
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.f44588g1);
        } else {
            this.f45060j0.setRefreshing(false);
        }
    }

    private void Yj(final boolean z16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation.11
            @Override // java.lang.Runnable
            public void run() {
                if (z16 && QZoneMoodSelectLocation.this.f44586e1 > 0) {
                    if (System.currentTimeMillis() - QZoneMoodSelectLocation.this.f44587f1 < QZoneMoodSelectLocation.this.f44586e1) {
                        if (((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0 != null) {
                            ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0.l0();
                            return;
                        }
                        return;
                    }
                    QZoneMoodSelectLocation.this.f44587f1 = System.currentTimeMillis();
                }
                if (QZoneMoodSelectLocation.this.f44583b1) {
                    QZoneMoodSelectLocation.this.Ek(z16);
                } else {
                    QZoneMoodSelectLocation.this.uk(z16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LbsDataV2.PoiInfo Zj() {
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        LbsDataV2.GeoInfo t16 = i5.a.s().t();
        poiInfo.gpsInfo = t16.gpsInfo;
        poiInfo.poiName = t16.strDefaultName;
        poiInfo.poiId = "coarse_poi_id";
        poiInfo.address = t16.address;
        return poiInfo;
    }

    private LbsDataV2.PoiInfo ak() {
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        LbsDataV2.PoiInfo poiInfo2 = this.f44590x0;
        if (poiInfo2 != null) {
            poiInfo.poiType = poiInfo2.poiType;
            poiInfo.poiTypeName = poiInfo2.poiTypeName;
            poiInfo.districtCode = poiInfo2.districtCode;
            LbsDataV2.GpsInfo gpsInfo = poiInfo2.gpsInfo;
            poiInfo.gpsInfo = gpsInfo != null ? gpsInfo.m468clone() : null;
            LbsDataV2.PoiInfo poiInfo3 = this.f44590x0;
            poiInfo.distance = poiInfo3.distance;
            poiInfo.hotValue = poiInfo3.hotValue;
            poiInfo.phoneNumber = poiInfo3.phoneNumber;
            poiInfo.poiOrderType = poiInfo3.poiOrderType;
            poiInfo.poiNum = poiInfo3.poiNum;
        }
        poiInfo.poiName = getString(this.Z0 ? R.string.f184833my : R.string.gns);
        poiInfo.poiId = "invalide_poi_id";
        return poiInfo;
    }

    private LbsDataV2.PoiInfo bk() {
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        LbsDataV2.PoiInfo poiInfo2 = this.f44590x0;
        if (poiInfo2 != null) {
            poiInfo.poiType = poiInfo2.poiType;
            poiInfo.poiTypeName = poiInfo2.poiTypeName;
            poiInfo.districtCode = poiInfo2.districtCode;
            LbsDataV2.GpsInfo gpsInfo = poiInfo2.gpsInfo;
            poiInfo.gpsInfo = gpsInfo != null ? gpsInfo.m468clone() : null;
            LbsDataV2.PoiInfo poiInfo3 = this.f44590x0;
            poiInfo.distance = poiInfo3.distance;
            poiInfo.hotValue = poiInfo3.hotValue;
            poiInfo.phoneNumber = poiInfo3.phoneNumber;
            poiInfo.poiOrderType = poiInfo3.poiOrderType;
            poiInfo.poiNum = poiInfo3.poiNum;
        }
        poiInfo.poiName = "\u6682\u672a\u67e5\u8be2\u5230\u8be5\u4f4d\u7f6e";
        poiInfo.poiId = "empty_poi_id";
        return poiInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ck() {
        try {
            return getResources().getConfiguration().locale.getLanguage();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dk() {
        LbsDataV2.GpsInfo gpsInfo;
        LbsDataV2.PoiInfo poiInfo = this.f44590x0;
        if (poiInfo == null || (gpsInfo = poiInfo.gpsInfo) == null) {
            return 0;
        }
        return gpsInfo.lat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ek() {
        LbsDataV2.GpsInfo gpsInfo;
        LbsDataV2.PoiInfo poiInfo = this.f44590x0;
        if (poiInfo == null || (gpsInfo = poiInfo.gpsInfo) == null) {
            return 0;
        }
        return gpsInfo.lon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fk(int i3) {
        return i3 - this.f45060j0.j0().getFirstVisiblePosition();
    }

    private View getContentView() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f45060j0;
        if (qZonePullToRefreshListView != null) {
            return qZonePullToRefreshListView.getRootView();
        }
        return null;
    }

    private void hk(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        if (unpack.getSucceed()) {
            this.f45060j0.s0(getString(R.string.gm6));
            ArrayList<LbsDataV2.PoiInfo> arrayList = unpack.getData() instanceof LbsDataV2.PoiList ? ((LbsDataV2.PoiList) unpack.getData()).poiInfos : null;
            if (arrayList != null && arrayList.size() > 0) {
                if (this.O0 == null) {
                    this.O0 = new ArrayList<>();
                }
                boolean hasMore = unpack.getHasMore();
                int i3 = message.what;
                if (i3 == 1000403) {
                    Tj(arrayList);
                    hasMore = true;
                } else if (i3 == 1000404) {
                    Rj(arrayList);
                } else {
                    this.O0 = arrayList;
                }
                ((SelectLocationListAdapter) this.f45059i0).setData(this.O0);
                this.N0 = unpack.getBundle().getString("attachinfo");
                if (hasMore) {
                    Ci(5);
                } else {
                    Ci(4);
                }
            }
        } else {
            this.f45060j0.r0(getString(R.string.gm5), unpack.getMessage());
            Ci(this.f45065o0);
        }
        fi();
    }

    private void ik(Message message) {
        LbsDataV2.PoiList poiList;
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        if (unpack.getSucceed()) {
            this.f45060j0.s0(getString(R.string.gm6));
            j5.c cVar = (j5.c) unpack.getData();
            if (cVar != null && (poiList = cVar.f409271c) != null && poiList.poiInfos != null) {
                if (this.O0 == null) {
                    this.O0 = new ArrayList<>();
                }
                if (message.what == 999990) {
                    Sj(poiList.poiInfos);
                } else {
                    this.O0 = poiList.poiInfos;
                }
                ((SelectLocationListAdapter) this.f45059i0).setData(this.O0);
                this.N0 = unpack.getBundle().getString("attachinfo");
                if (unpack.getHasMore()) {
                    Ci(5);
                } else {
                    Ci(4);
                }
            }
        } else {
            this.f45060j0.r0(getString(R.string.gm5), unpack.getMessage());
            Ci(this.f45065o0);
        }
        fi();
    }

    private void initData() {
        this.X0 = u5.b.i0("LbsPreferencesName", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, null);
        Intent intent = getIntent();
        this.G0 = intent.getBooleanExtra("key_not_adapt_night_mode", false);
        sk();
        this.O0 = intent.getParcelableArrayListExtra("key_current_poi_list_infos");
        this.N0 = intent.getStringExtra("attachinfo");
        if (this.O0 == null) {
            this.O0 = new ArrayList<>();
            if (QZLog.isColorLevel()) {
                QZLog.d("QZoneMoodSelectLocation", 2, "got none poilist..");
            }
        }
        this.f44590x0 = (LbsDataV2.PoiInfo) intent.getParcelableExtra("key_current_poi");
        LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) intent.getParcelableExtra("key_current_poi");
        this.f44590x0 = poiInfo;
        if (poiInfo == null) {
            String stringExtra = intent.getStringExtra("key_current_poi_id");
            if (!TextUtils.isEmpty(stringExtra)) {
                LbsDataV2.PoiInfo poiInfo2 = new LbsDataV2.PoiInfo();
                this.f44590x0 = poiInfo2;
                poiInfo2.poiId = stringExtra;
            }
        }
        this.f44592z0 = (LocalImageShootInfo) intent.getParcelableExtra("key_current_img_shoot_info");
        this.f44591y0 = intent.getParcelableArrayListExtra("key_current_image_shoot_infos");
        this.A0 = intent.getIntExtra("key_app_id", WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FOLDER);
        this.f44589w0 = intent.getIntExtra("key_lbs_state", 0);
        this.J0 = intent.getStringExtra("key_search_keyword");
        this.Y0 = intent.getBooleanExtra("key_from_album", false);
        this.S0 = ParcelableWrapper.getArrayListFromIntent(intent, "PHOTO_POI_AREA");
        this.U0 = intent.getExtras().getBoolean("show_nearby_poi", false);
        this.T0 = intent.getExtras().getLong("photo_list_start_shoot_time", 0L);
        this.V0 = intent.getExtras().getInt("key_show_first_line", 1);
        long j3 = this.T0;
        if (j3 == 0) {
            ArrayList<PhotoPoiArea> arrayList = this.S0;
            if (arrayList != null && arrayList.size() > 0 && this.S0.get(0) != null) {
                this.T0 = this.S0.get(0).startShootTime * 1000;
            }
        } else {
            this.T0 = j3 * 1000;
        }
        if (this.T0 > com.qzone.album.business.photolist.adapter.a.f42649b0) {
            this.T0 = 1L;
        }
        this.T0 = QZoneAlbumUtil.q(this.T0);
        if (this.J0 == null) {
            this.J0 = "";
        }
        this.Z0 = intent.getBooleanExtra("key_is_from_circle", false);
        this.f44582a1 = intent.getBooleanExtra("key_is_wink_editor_style", false);
        this.f44583b1 = intent.getBooleanExtra("key_is_test_case", false);
        this.f44584c1 = intent.getStringArrayListExtra("key_is_from_circle_for_aitextlabel");
        this.Q0 = ak();
        this.R0 = bk();
    }

    private void jk(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        if (unpack.getSucceed()) {
            this.f45060j0.s0(getString(R.string.gm6));
            LbsDataV2.PoiList poiList = (LbsDataV2.PoiList) unpack.getData();
            if (poiList != null && poiList.poiInfos != null) {
                if (this.O0 == null) {
                    this.O0 = new ArrayList<>();
                }
                GetGeoInfoRsp_V2 getGeoInfoRsp_V2 = poiList.geoInfo;
                if (getGeoInfoRsp_V2 != null) {
                    this.P0 = getGeoInfoRsp_V2.stGeoInfo;
                }
                if (message.what == 999990) {
                    Sj(poiList.poiInfos);
                } else {
                    this.O0 = poiList.poiInfos;
                }
                this.N0 = unpack.getBundle().getString("attachinfo");
                boolean hasMore = unpack.getHasMore();
                ((SelectLocationListAdapter) this.f45059i0).setData(this.O0);
                if (hasMore) {
                    Ci(5);
                } else {
                    Ci(4);
                }
                if (this.U0) {
                    Ci(4);
                }
            }
        } else {
            this.f45060j0.r0(getString(R.string.gm5), unpack.getMessage());
            Ci(this.f45065o0);
        }
        fi();
    }

    private boolean kk() {
        EditText editText;
        InputMethodManager inputMethodManager = this.M0;
        return (inputMethodManager == null || (editText = this.H0) == null || !inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean rk(TextView textView, int i3, KeyEvent keyEvent) {
        kk();
        return true;
    }

    private void sk() {
        if (this.G0) {
            this.f45060j0.g0().setNotAdaptNightMode(true);
        }
    }

    private void vk() {
        if (this.Z0 && getContentView() != null) {
            VideoReport.setPageId(getContentView(), QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_PAGE_POI);
            VideoReport.setPageParams(getContentView(), new QCircleDTParamBuilder().buildPageParams("QZoneMoodSelectLocation"));
            QLog.i("QZoneMoodSelectLocation", 1, "reportDaTongRegister  subPage: QZoneMoodSelectLocation");
        } else {
            if (!this.Y0 || getContentView() == null) {
                return;
            }
            VideoReport.setPageId(getContentView(), "pg_qz_location_choose");
            VideoReport.setPageParams(getContentView(), new fo.a().d("QZoneMoodSelectLocation", null));
            QLog.i("QZoneMoodSelectLocation", 1, "reportDaTongRegister  subPage: QZoneMoodSelectLocation");
        }
    }

    private void wk() {
        EditText editText = this.H0;
        if (editText == null) {
            return;
        }
        editText.setClickable(true);
        this.H0.setFocusable(true);
        this.H0.setFocusableInTouchMode(true);
    }

    private void xk() {
        if (getIntent().getBooleanExtra("key_is_wink_editor_style", false)) {
            return;
        }
        if (this.f44585d1 == null) {
            this.f44585d1 = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_SELECT_LOCATION));
        }
        if (!vx.a.a(this.f44585d1)) {
            Xj();
        } else {
            this.f44585d1.requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yk() {
        this.f45060j0.setAdapter((ListAdapter) this.f45059i0);
        this.f45060j0.setSupportPullDown(true);
        this.U0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(String str) {
        if (Wj()) {
            boolean isEmpty = TextUtils.isEmpty(this.J0);
            this.J0 = str;
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.K0;
            this.K0 = currentTimeMillis;
            long j16 = currentTimeMillis - j3;
            if ((j16 >= 0 && j16 < 700) || isEmpty) {
                Fk();
                return;
            }
            this.f45058h0 = 10;
            List<LocalImageShootInfo> list = this.f44591y0;
            if (list != null && list.size() > 0) {
                ArrayList<GpsInfo4LocalImage> arrayList = new ArrayList<>();
                Iterator<LocalImageShootInfo> it = this.f44591y0.iterator();
                while (it.hasNext()) {
                    GpsInfo4LocalImage gpsInfo4LocalImage = it.next().gpsInfo;
                    if (gpsInfo4LocalImage != null) {
                        arrayList.add(gpsInfo4LocalImage);
                    }
                }
                com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).f(getHandler(), 1000404, arrayList, this.A0, str);
                this.f45058h0 = 1;
                return;
            }
            if (this.f44592z0 != null) {
                com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).B(getHandler(), str, null, true, this.A0, this.f44592z0);
            } else {
                com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).i(getHandler(), str, this.A0);
            }
        }
    }

    public void Ck() {
        int i3;
        Resources resources = getResources();
        if (this.Z0) {
            i3 = this.f44582a1 ? R.string.f185503or : R.string.f184843mz;
        } else {
            i3 = R.string.gnt;
        }
        setTitle(resources.getString(i3));
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    protected boolean Hh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2
    public void c0() {
        boolean z16;
        super.c0();
        if (this.B0) {
            z16 = false;
            this.B0 = false;
            if (Vj()) {
                this.f45060j0.l0();
                return;
            }
        } else {
            z16 = true;
        }
        if (!TextUtils.isEmpty(this.J0)) {
            zk(this.J0);
        } else {
            Yj(z16);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        super.finish();
        if (this.C0) {
            overridePendingTransition(R.anim.f154442w, R.anim.f154423k);
        } else {
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2
    public void ii() {
        super.ii();
        if (this.f44592z0 != null) {
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).B(getHandler(), this.J0, this.N0, false, this.A0, this.f44592z0);
        } else {
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).a(getHandler(), this.J0, this.N0, this.A0);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean isEnableNightMask() {
        return false;
    }

    protected void mk() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f169010bl3, (ViewGroup) null, false);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.bwj);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.bwm);
            if (textView != null) {
                this.f45067q0 = textView;
                if (checkNetworkConnect()) {
                    mi();
                } else {
                    Bi(R.string.f170565u8);
                }
            }
            if (progressBar != null) {
                this.f45068r0 = progressBar;
                ni();
            }
            inflate.setOnClickListener(new a());
            this.f45060j0.setEmptyView(inflate);
            this.f45060j0.setEmptyEnabled(true);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.f44588g1);
        if (this.L0 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).removeTask(this.L0);
        }
        super.onDestroy();
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2, com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        switch (message.what) {
            case 999989:
                if (QZLog.isDevelopLevel()) {
                    QZLog.d(QZLog.TO_DEVICE_TAG, 1, "QZoneMoodSelectLocation\t MSG_GET_POI_LIST_FINISH_REFRESH");
                }
                int i3 = this.f45058h0;
                if (i3 == 1 || i3 == 10) {
                    jk(message);
                    return;
                }
                return;
            case 999990:
                if (QZLog.isDevelopLevel()) {
                    QZLog.d(QZLog.TO_DEVICE_TAG, 1, "QZoneMoodSelectLocation\t MSG_GET_POI_LIST_FINISH_GETMORE");
                }
                if (this.f45058h0 != 2) {
                    return;
                }
                jk(message);
                return;
            case 1000007:
                int i16 = this.f45058h0;
                if (i16 == 1 || i16 == 10) {
                    jk(message);
                    return;
                }
                return;
            case 1000054:
                int i17 = this.f45058h0;
                if (i17 == 1 || i17 == 10) {
                    ik(message);
                    break;
                } else {
                    return;
                }
            case 1000403:
            case 1000404:
                break;
            default:
                return;
        }
        int i18 = this.f45058h0;
        if (i18 == 1 || i18 == 10) {
            hk(message);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        kk();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        xk();
        ok();
        lk();
        nk();
        initData();
        vk();
        ArrayList<PhotoPoiArea> arrayList = this.S0;
        if (arrayList != null && arrayList.size() > 0) {
            qi(true);
        } else {
            pi();
        }
        FeedDetailCommentTips feedDetailCommentTips = this.f45061k0;
        if (feedDetailCommentTips != null) {
            if (this.Z0) {
                feedDetailCommentTips.setBackgroundColor(Color.parseColor("#FFFFFF"));
            } else {
                feedDetailCommentTips.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            }
        }
        Gi(0);
        this.f45059i0 = new SelectLocationListAdapter(getActivity());
        ArrayList<PhotoPoiArea> arrayList2 = this.S0;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Dk();
        } else {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HasLoadAll", "\u5df2\u52a0\u8f7d\u5168\u90e8");
            FeedDetailCommentTips feedDetailCommentTips2 = this.f45061k0;
            if (feedDetailCommentTips2 != null) {
                feedDetailCommentTips2.setNoMoreDataVisibility(true);
                this.f45061k0.setNoMoreDataText(config);
            }
            ((SelectLocationListAdapter) this.f45059i0).setData(this.O0);
            this.f45060j0.j0().setAdapter((ListAdapter) this.f45059i0);
        }
        Ck();
        setLeftButton(R.string.gd5, new b());
        if (this.Z0) {
            this.D.setTextColor(getResources().getColor(R.color.black));
            this.C.setText("");
            this.C.setBackgroundResource(this.f44582a1 ? R.drawable.nae : R.drawable.f161679om3);
            ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            Resources resources = this.C.getContext().getResources();
            boolean z16 = this.f44582a1;
            int i3 = R.dimen.f158710mz;
            layoutParams.width = resources.getDimensionPixelSize(z16 ? R.dimen.f158710mz : R.dimen.c_8);
            ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
            Resources resources2 = this.C.getContext().getResources();
            if (!this.f44582a1) {
                i3 = R.dimen.c_8;
            }
            layoutParams2.height = resources2.getDimensionPixelSize(i3);
            if (this.f44582a1) {
                ((ViewGroup.MarginLayoutParams) this.C.getLayoutParams()).leftMargin = this.C.getContext().getResources().getDimensionPixelSize(R.dimen.c_5);
            }
            ViewGroup viewGroup = this.R;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(getResources().getColor(R.color.f158017al3));
            }
            pk();
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(BaseApplicationImpl.getApplication().getRuntime().getAccount()).setActionType(15).setSubActionType(9).setThrActionType(1));
        } else {
            this.f45060j0.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            this.I0.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            this.H0.setBackgroundResource(R.drawable.f16145k);
            this.H0.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
            this.H0.setHintTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        }
        if (!TextUtils.isEmpty(this.J0)) {
            this.H0.setText(this.J0);
            this.H0.setSelection(this.J0.length());
        }
        ArrayList<LbsDataV2.PoiInfo> arrayList3 = this.O0;
        if ((arrayList3 == null || arrayList3.size() <= 2) && this.f44582a1) {
            ti();
        } else {
            Xj();
        }
        this.M0 = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        fi();
        boolean booleanExtra = getIntent().getBooleanExtra(QZoneHelper.KEY_MODAL, false);
        this.C0 = booleanExtra;
        if (booleanExtra) {
            this.C.setVisibility(8);
            setRightButton(R.string.close, new c());
        }
        boolean booleanExtra2 = getIntent().getBooleanExtra(QZoneHelper.KEY_HIDE_QZONE_ICON, false);
        this.D0 = booleanExtra2;
        if (booleanExtra2) {
            this.f45060j0.j0().setBackgroundResource(R.drawable.bg_texture);
        }
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2
    protected boolean ri() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2
    public boolean xi() {
        if ((this.f45059i0.getCount() < 80 ? this.f45059i0.getCount() : -1) >= 0) {
            return super.xi();
        }
        Ci(4);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class SelectLocationListAdapter extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f44596d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<LbsDataV2.PoiInfo> f44597e = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        public LbsDataV2.PoiInfo f44598f;

        /* renamed from: h, reason: collision with root package name */
        private LbsDataV2.PoiInfo f44599h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes39.dex */
        public class a implements Comparator<LbsDataV2.PoiInfo> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(LbsDataV2.PoiInfo poiInfo, LbsDataV2.PoiInfo poiInfo2) {
                if (QZoneMoodSelectLocation.this.qk(poiInfo)) {
                    return -1;
                }
                return QZoneMoodSelectLocation.this.qk(poiInfo2) ? 1 : 0;
            }
        }

        public SelectLocationListAdapter(Context context) {
            this.f44596d = context;
        }

        private void b() {
            if (QZoneMoodSelectLocation.this.F0 == null) {
                QZoneMoodSelectLocation qZoneMoodSelectLocation = QZoneMoodSelectLocation.this;
                if (qZoneMoodSelectLocation.D == null || ((CustomListViewFragmentV2) qZoneMoodSelectLocation).f45060j0 == null) {
                    return;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                QZoneMoodSelectLocation.this.F0 = new LinearLayout(this.f44596d);
                QZoneMoodSelectLocation.this.F0.setOrientation(1);
                QZoneMoodSelectLocation.this.F0.setLayoutParams(layoutParams);
                ImageView imageView = new ImageView(this.f44596d);
                imageView.setImageDrawable(QZoneMoodSelectLocation.this.getResources().getDrawable(R.drawable.qvideo_skin_emptystate_img_search));
                imageView.setLayoutParams(new LinearLayout.LayoutParams(ar.e(200.0f), ar.e(150.0f)));
                TextView textView = new TextView(this.f44596d);
                textView.setText("\u6ca1\u6709\u4f60\u8981\u627e\u7684\u5730\u70b9\n\u6362\u4e2a\u5173\u952e\u8bcd\u8bd5\u8bd5\u5427");
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setTextSize(12.0f);
                textView.setLetterSpacing(0.14f);
                int e16 = ar.e(22.0f);
                if (Build.VERSION.SDK_INT >= 28) {
                    textView.setLineHeight(e16);
                } else {
                    if (e16 != textView.getPaint().getFontMetricsInt(null)) {
                        textView.setLineSpacing(e16 - r5, 1.0f);
                    }
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 1;
                layoutParams2.topMargin = ar.e(6.0f);
                textView.setLayoutParams(layoutParams2);
                QZoneMoodSelectLocation.this.F0.addView(imageView);
                QZoneMoodSelectLocation.this.F0.addView(textView);
                QZoneMoodSelectLocation.this.F0.post(new Runnable() { // from class: com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation.SelectLocationListAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) QZoneMoodSelectLocation.this.F0.getLayoutParams();
                        layoutParams3.topMargin = (int) (((((ar.k() / 2.0f) - ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0.getTop()) - ar.n(SelectLocationListAdapter.this.f44596d)) - QZoneMoodSelectLocation.this.D.getHeight()) - (QZoneMoodSelectLocation.this.F0.getHeight() / 2.0f));
                        QZoneMoodSelectLocation.this.F0.setLayoutParams(layoutParams3);
                    }
                });
            }
        }

        private void c(boolean z16) {
            LinearLayout linearLayout = (LinearLayout) ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0.getParent();
            linearLayout.setBackgroundColor(-1);
            if (z16) {
                ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0.setVisibility(4);
                if (QZoneMoodSelectLocation.this.E0) {
                    return;
                }
                b();
                linearLayout.addView(QZoneMoodSelectLocation.this.F0);
                QZoneMoodSelectLocation.this.E0 = true;
                return;
            }
            ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0.setVisibility(0);
            if (QZoneMoodSelectLocation.this.F0 != null) {
                linearLayout.removeView(QZoneMoodSelectLocation.this.F0);
                QZoneMoodSelectLocation.this.E0 = false;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<LbsDataV2.PoiInfo> arrayList = this.f44597e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            ArrayList<LbsDataV2.PoiInfo> arrayList = this.f44597e;
            if (arrayList == null || arrayList.size() <= i3) {
                return null;
            }
            return this.f44597e.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new l(this.f44596d);
            }
            View view2 = view;
            l lVar = (l) view2;
            LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) getItem(i3);
            if (poiInfo != null) {
                if (poiInfo == this.f44598f) {
                    lVar.f44621h.setImageResource(R.drawable.bvn);
                } else {
                    lVar.f44621h.setImageResource(R.drawable.bvm);
                }
                lVar.b(poiInfo);
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return lVar;
        }

        public void setData(List<LbsDataV2.PoiInfo> list) {
            if (list == null) {
                return;
            }
            this.f44597e.clear();
            if (this.f44598f == null) {
                if (QZoneMoodSelectLocation.this.Q0 != null && QZoneMoodSelectLocation.this.V0 == 1 && !QZoneMoodSelectLocation.this.Z0) {
                    this.f44597e.add(QZoneMoodSelectLocation.this.Q0);
                }
                if (list.isEmpty()) {
                    LbsDataV2.PoiInfo Zj = QZoneMoodSelectLocation.this.Zj();
                    this.f44599h = Zj;
                    if (Zj != null && !TextUtils.isEmpty(Zj.poiDefaultName)) {
                        this.f44597e.add(this.f44599h);
                    }
                } else {
                    this.f44597e.remove(this.f44599h);
                }
            } else if (list.size() > 0) {
                list.remove(0);
            }
            this.f44597e.addAll(list);
            if (QZoneMoodSelectLocation.this.Z0) {
                Collections.sort(this.f44597e, new a());
                if (TextUtils.isEmpty(QZoneMoodSelectLocation.this.J0) && !this.f44597e.contains(QZoneMoodSelectLocation.this.f44590x0) && QZoneMoodSelectLocation.this.f44590x0 != null && !"invalide_poi_id".equals(QZoneMoodSelectLocation.this.f44590x0.poiId)) {
                    this.f44597e.add(0, QZoneMoodSelectLocation.this.f44590x0);
                }
                if (this.f44598f == null && QZoneMoodSelectLocation.this.Q0 != null && QZoneMoodSelectLocation.this.V0 == 1) {
                    this.f44597e.add(0, QZoneMoodSelectLocation.this.Q0);
                }
                c(this.f44597e.isEmpty() && QZoneMoodSelectLocation.this.R0 != null);
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements View.OnFocusChangeListener {
        f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16 && QZoneMoodSelectLocation.this.Y0) {
                ClickReport.m("368", "32", "1");
                fo.c.d("em_qz_location_search", "pg_qz_location_choose", view);
            }
            if (QZoneMoodSelectLocation.this.Z0) {
                QZoneMoodSelectLocation qZoneMoodSelectLocation = QZoneMoodSelectLocation.this;
                qZoneMoodSelectLocation.tk(qZoneMoodSelectLocation.getResources().getDrawable(R.drawable.qvideo_skin_icon_general_search_secondary));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j extends BaseAdapter {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a {

            /* renamed from: a, reason: collision with root package name */
            SafeTextView f44613a;

            /* renamed from: b, reason: collision with root package name */
            SafeTextView f44614b;

            a() {
            }
        }

        j() {
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PhotoPoiArea getItem(int i3) {
            return (PhotoPoiArea) QZoneMoodSelectLocation.this.S0.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return QZoneMoodSelectLocation.this.S0.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        private String a(PhotoPoiArea photoPoiArea) {
            if (photoPoiArea != null) {
                double d16 = ((photoPoiArea.startShootTime * 1000) - QZoneMoodSelectLocation.this.T0) / 8.64E7d;
                if (d16 >= 0.0d) {
                    int ceil = (int) Math.ceil(d16);
                    if (ceil == 0) {
                        return "DAY 1";
                    }
                    return "DAY " + ceil;
                }
                return com.qzone.util.l.a(R.string.s06) + (-((int) Math.floor(d16))) + com.qzone.util.l.a(R.string.s07);
            }
            return "";
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(QZoneMoodSelectLocation.this.getActivity()).inflate(R.layout.bgp, (ViewGroup) null);
                aVar = new a();
                aVar.f44613a = (SafeTextView) view.findViewById(R.id.e6r);
                aVar.f44614b = (SafeTextView) view.findViewById(R.id.e6s);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            PhotoPoiArea item = getItem(i3);
            if (item != null) {
                if (c(i3)) {
                    aVar.f44613a.setVisibility(0);
                    aVar.f44613a.setText(a(item));
                } else {
                    aVar.f44613a.setVisibility(4);
                }
                String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UnnamedLocation", "\u5f85\u547d\u540d\u5730\u70b9");
                if (!TextUtils.isEmpty(item.sceneryName)) {
                    config = item.sceneryName;
                }
                aVar.f44614b.setText(config);
                aVar.f44614b.setVisibility(0);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        private boolean c(int i3) {
            if (i3 == 0) {
                return true;
            }
            if (i3 < 0 || QZoneMoodSelectLocation.this.S0.size() <= i3) {
                return false;
            }
            int i16 = i3 - 1;
            return (QZoneMoodSelectLocation.this.S0.get(i16) == null || QZoneMoodSelectLocation.this.S0.get(i3) == null || com.qzone.album.util.g.l(((PhotoPoiArea) QZoneMoodSelectLocation.this.S0.get(i16)).startShootTime * 1000, ((PhotoPoiArea) QZoneMoodSelectLocation.this.S0.get(i3)).startShootTime * 1000)) ? false : true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class l extends LinearLayout {
        private View C;

        /* renamed from: d, reason: collision with root package name */
        private TextView f44618d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f44619e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f44620f;

        /* renamed from: h, reason: collision with root package name */
        private ImageView f44621h;

        /* renamed from: i, reason: collision with root package name */
        private ImageView f44622i;

        /* renamed from: m, reason: collision with root package name */
        private View f44623m;

        public l(Context context) {
            super(context);
            View inflate;
            LayoutInflater from = LayoutInflater.from(context);
            if (QZoneMoodSelectLocation.this.Z0) {
                inflate = from.inflate(R.layout.g3k, this);
            } else {
                inflate = from.inflate(R.layout.bje, this);
            }
            inflate.setFocusable(true);
            this.f44618d = (TextView) inflate.findViewById(R.id.e6e);
            this.f44619e = (TextView) inflate.findViewById(R.id.yga);
            this.f44620f = (TextView) inflate.findViewById(R.id.e6a);
            this.f44621h = (ImageView) inflate.findViewById(R.id.e6q);
            this.f44622i = (ImageView) inflate.findViewById(R.id.imo);
            if (QZoneMoodSelectLocation.this.Z0) {
                this.f44618d.setTypeface(Typeface.create(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM, 0));
                this.f44618d.setTextColor(Color.parseColor("#03081A"));
                this.f44620f.setTypeface(Typeface.create(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_REGULAR, 0));
                this.f44620f.setTextColor(Color.parseColor("#999999"));
                this.f44622i.setImageDrawable(getResources().getDrawable(R.drawable.qvideo_skin_checkbox_list_selected));
                this.f44622i.getLayoutParams().width = ar.e(16.0f);
                this.f44622i.getLayoutParams().height = ar.e(16.0f);
            }
            this.f44623m = inflate.findViewById(R.id.e6b);
            this.C = inflate.findViewById(R.id.yg_);
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            this.f44622i.setVisibility(z16 ? 0 : 8);
        }

        public void b(LbsDataV2.PoiInfo poiInfo) {
            TextView textView;
            if (poiInfo == null || (textView = this.f44618d) == null) {
                return;
            }
            textView.setText(poiInfo.poiName);
            this.f44618d.setContentDescription(poiInfo.poiName);
            String str = poiInfo.poiName;
            if (poiInfo.address != null) {
                str = str + "," + poiInfo.address;
            }
            AccessibilityUtil.y(this, str, QZoneMoodSelectLocation.this.qk(poiInfo));
            if (!TextUtils.isEmpty(poiInfo.poiId) && !"invalide_poi_id".equals(poiInfo.poiId) && !TextUtils.isEmpty(poiInfo.address)) {
                this.f44620f.setVisibility(0);
                if (QZoneMoodSelectLocation.this.Z0 && TextUtils.isEmpty(QZoneMoodSelectLocation.this.J0) && "custom_poi_id".equals(poiInfo.poiId)) {
                    this.f44620f.setVisibility(8);
                } else {
                    this.f44620f.setText(poiInfo.address);
                }
                this.f44623m.getLayoutParams().height = ar.e(71.0f);
            } else {
                this.f44620f.setVisibility(8);
                this.f44623m.getLayoutParams().height = ar.e(55.0f);
            }
            setSelected(QZoneMoodSelectLocation.this.qk(poiInfo));
            if (QZoneMoodSelectLocation.this.Z0) {
                if (!TextUtils.isEmpty(poiInfo.poiId) && "custom_poi_id".equals(poiInfo.poiId)) {
                    this.f44618d.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.na_), (Drawable) null, (Drawable) null, (Drawable) null);
                    this.f44618d.setCompoundDrawablePadding(ar.d(4.0f));
                } else {
                    this.f44618d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.f44619e.setVisibility(poiInfo.isRecomm ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements AbsListView.OnScrollListener {
        h() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0 && ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0.j0().getLastVisiblePosition() >= ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45060j0.j0().getCount() - 1) {
                QZoneMoodSelectLocation.this.ti();
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ek(boolean z16) {
        if (this.Z0) {
            List<LocalImageShootInfo> list = this.f44591y0;
            if (list != null && list.size() > 0) {
                ArrayList<GpsInfo4LocalImage> arrayList = new ArrayList<>();
                Iterator<LocalImageShootInfo> it = this.f44591y0.iterator();
                while (it.hasNext()) {
                    GpsInfo4LocalImage gpsInfo4LocalImage = it.next().gpsInfo;
                    if (gpsInfo4LocalImage != null) {
                        arrayList.add(gpsInfo4LocalImage);
                    }
                }
                com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).A(getHandler(), 1000403, arrayList, this.A0);
                this.f45058h0 = 1;
                return;
            }
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).A(getHandler(), 1000403, null, this.A0);
            this.f45058h0 = 1;
            return;
        }
        if (this.f44592z0 != null) {
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).m(getHandler(), "", 1000054, this.A0, z16, this.f44592z0, this.Z0 ? this.f44584c1 : null);
        } else {
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).y(getHandler(), "", 1000007, this.A0, z16, this.Z0 ? this.f44584c1 : null);
            this.f45058h0 = 1;
        }
    }

    private void Tj(ArrayList<LbsDataV2.PoiInfo> arrayList) {
        if (arrayList == null || this.O0 == null || this.Z0) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            LbsDataV2.PoiInfo poiInfo = arrayList.get(size);
            this.O0.remove(poiInfo);
            this.O0.add(0, poiInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk(Drawable drawable) {
        drawable.setBounds(0, 0, ar.d(20.0f), ar.d(20.0f));
        this.H0.setGravity(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(boolean z16) {
        List<LocalImageShootInfo> list = this.f44591y0;
        if (list != null && list.size() > 0) {
            ArrayList<GpsInfo4LocalImage> arrayList = new ArrayList<>();
            Iterator<LocalImageShootInfo> it = this.f44591y0.iterator();
            while (it.hasNext()) {
                GpsInfo4LocalImage gpsInfo4LocalImage = it.next().gpsInfo;
                if (gpsInfo4LocalImage != null) {
                    arrayList.add(gpsInfo4LocalImage);
                }
            }
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).A(getHandler(), 1000403, arrayList, this.A0);
            this.f45058h0 = 1;
            return;
        }
        if (this.f44592z0 != null) {
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).m(getHandler(), "", 1000054, this.A0, z16, this.f44592z0, this.Z0 ? this.f44584c1 : null);
        } else {
            com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).y(getHandler(), "", 1000007, this.A0, z16, this.Z0 ? this.f44584c1 : null);
            this.f45058h0 = 1;
        }
    }

    private void Rj(ArrayList<LbsDataV2.PoiInfo> arrayList) {
        if (arrayList == null) {
            return;
        }
        ArrayList<LbsDataV2.PoiInfo> arrayList2 = this.O0;
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList.add(0, this.O0.get(0));
        }
        this.O0 = arrayList;
    }

    private void Sj(ArrayList<LbsDataV2.PoiInfo> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<LbsDataV2.PoiInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LbsDataV2.PoiInfo next = it.next();
            if (!this.O0.contains(next)) {
                this.O0.add(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uj() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.aym);
        if (imageButton == null) {
            return;
        }
        imageButton.getLayoutParams().width = ar.e(16.0f);
        imageButton.getLayoutParams().height = ar.e(16.0f);
        if (TextUtils.isEmpty(this.H0.getText().toString())) {
            return;
        }
        tk(getResources().getDrawable(R.drawable.qvideo_skin_icon_general_search_primary));
    }

    private void lk() {
        this.I0 = (RelativeLayout) findViewById(R.id.iit);
        EditText editText = (EditText) findViewById(R.id.ijl);
        this.H0 = editText;
        editText.addTextChangedListener(new e());
        this.H0.setOnFocusChangeListener(new f());
        this.H0.clearFocus();
        if (Build.VERSION.SDK_INT >= 31) {
            wk();
        }
    }

    private void nk() {
        findViewById(R.id.aym).setOnClickListener(new g());
    }

    private void ok() {
        QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) findViewById(R.id.f163826j);
        this.f45060j0 = qZonePullToRefreshListView;
        qZonePullToRefreshListView.setOnScrollListener(new h());
        this.f45060j0.setOnRefreshListener(new QZonePullToRefreshListView.c() { // from class: com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation.8
            @Override // com.qzone.widget.QZonePullToRefreshListView.c
            public void Y() {
                QZoneMoodSelectLocation.this.getHandler().post(new Runnable() { // from class: com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneMoodSelectLocation.this.Dh();
                    }
                });
            }

            @Override // com.qzone.widget.QZonePullToRefreshListView.c
            public void onPullStart() {
                QZoneMoodSelectLocation.this.si(new long[0]);
            }

            @Override // com.qzone.widget.QZonePullToRefreshListView.c
            public void onRefresh() {
                QZoneMoodSelectLocation.this.onRefresh();
            }

            @Override // com.qzone.widget.QZonePullToRefreshListView.c
            public void onPullEnd() {
            }
        });
        this.f45060j0.j0().setOnItemClickListener(new i());
        mk();
    }

    private void pk() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.aym);
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f45060j0;
        if (qZonePullToRefreshListView == null || this.H0 == null || imageButton == null) {
            return;
        }
        qZonePullToRefreshListView.setBackgroundColor(-1);
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.f184803mv));
        spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString.length(), 33);
        this.H0.setHint(new SpannedString(spannableString));
        this.H0.setImeOptions(3);
        this.H0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qzone.business.lbsv2.ui.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean rk5;
                rk5 = QZoneMoodSelectLocation.this.rk(textView, i3, keyEvent);
                return rk5;
            }
        });
        this.H0.setHintTextColor(Color.parseColor("#FF999999"));
        if (Build.VERSION.SDK_INT >= 29) {
            this.H0.setTextCursorDrawable(getResources().getDrawable(R.drawable.led));
        }
        this.H0.setBackgroundResource(R.drawable.nam);
        this.H0.getLayoutParams().height = ar.e(32.0f);
        Drawable drawable = getResources().getDrawable(R.drawable.qvideo_skin_icon_general_search_secondary);
        float measureText = ((this.H0.getPaint().measureText(getResources().getString(R.string.f184803mv)) + this.H0.getCompoundDrawablePadding()) + drawable.getIntrinsicWidth()) / 2.0f;
        drawable.setBounds(ar.d(measureText), 0, ar.d(measureText + 20.0f), ar.d(20.0f));
        imageButton.setImageDrawable(getResources().getDrawable(R.drawable.qvideo_skin_icon_general_close_solid_light));
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.bjd, viewGroup);
    }

    public boolean qk(LbsDataV2.PoiInfo poiInfo) {
        LbsDataV2.PoiInfo poiInfo2;
        int i3;
        boolean z16 = false;
        if (poiInfo == null || TextUtils.isEmpty(poiInfo.poiId)) {
            return false;
        }
        if (poiInfo.poiId.equals("invalide_poi_id") && (this.f44590x0 == null || ((i3 = this.f44589w0) != 1 && i3 != 3))) {
            z16 = true;
        }
        LbsDataV2.PoiInfo poiInfo3 = this.f44590x0;
        if (poiInfo3 != null && !TextUtils.isEmpty(poiInfo3.poiId) && poiInfo.poiId.equals(this.f44590x0.poiId) && this.f44589w0 == 1) {
            z16 = true;
        }
        if (this.Z0 && (poiInfo2 = this.f44590x0) != null && !TextUtils.isEmpty(poiInfo2.poiId) && poiInfo.poiId.equals(this.f44590x0.poiId) && this.f44589w0 == 3) {
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(int i3, SosoLbsInfo sosoLbsInfo) {
        LbsDataV2.GpsInfo gpsInfo;
        if (i3 == 0) {
            if (sosoLbsInfo == null || sosoLbsInfo.mLocation == null) {
                return;
            }
            LbsDataV2.GpsInfo gpsInfo2 = new LbsDataV2.GpsInfo();
            SosoLocation sosoLocation = sosoLbsInfo.mLocation;
            gpsInfo2.accuracy = (int) sosoLocation.accuracy;
            gpsInfo2.alt = (int) sosoLocation.altitude;
            double d16 = sosoLocation.mLon84;
            if (d16 == 0.0d && sosoLocation.mLat84 == 0.0d) {
                gpsInfo2.gpsType = 1;
                gpsInfo2.lat = (int) (sosoLocation.mLat02 * 1000000.0d);
                gpsInfo2.lon = (int) (sosoLocation.mLon02 * 1000000.0d);
            } else {
                gpsInfo2.gpsType = 0;
                gpsInfo2.lat = (int) (sosoLocation.mLat84 * 1000000.0d);
                gpsInfo2.lon = (int) (d16 * 1000000.0d);
            }
            QZLog.i("QZoneMoodSelectLocation", "[QZ_LBS_MODULE]#checkOrRefresh SosoInterface result: " + gpsInfo2);
            LbsDataV2.GeoInfo t16 = i5.a.s().t();
            if (t16 != null && (gpsInfo = t16.gpsInfo) != null && gpsInfo.isValid()) {
                if (t16.gpsInfo.gpsType == gpsInfo2.gpsType) {
                    double b16 = k5.a.b(r1.lat, r1.lon, gpsInfo2.lat, gpsInfo2.lon);
                    QZLog.i("QZoneMoodSelectLocation", "[QZ_LBS_MODULE]#checkOrRefresh move distance=" + b16);
                    int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LOCATE_MIN_DISTANCE, 10);
                    if (b16 > config) {
                        QZLog.i("QZoneMoodSelectLocation", "[QZ_LBS_MODULE]dist>" + config + ", need refresh poi cache");
                        Yj(true);
                        return;
                    }
                    QZLog.i("QZoneMoodSelectLocation", "[QZ_LBS_MODULE]dist<=" + config + ", just use local poi cache");
                    this.f45060j0.setRefreshing(false);
                    return;
                }
                QZLog.e("QZoneMoodSelectLocation", "[QZ_LBS_MODULE]#checkOrRefresh location cannot compare!!!");
                this.f45060j0.setRefreshing(false);
                return;
            }
            QZLog.e("QZoneMoodSelectLocation", "[QZ_LBS_MODULE]#checkOrRefresh last geoInfo not exist!!!");
            this.f45060j0.setRefreshing(false);
            return;
        }
        QZLog.i("QZoneMoodSelectLocation", "failed to locate..");
        this.f45060j0.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            boolean z16;
            String str;
            RDMEtraMsgCollector.getInstance().addNormalItemClickAction(QZoneMoodSelectLocation.this.simpleClassname, adapterView, view, i3, j3);
            if (adapterView != null) {
                Object itemAtPosition = adapterView.getItemAtPosition(i3);
                if (itemAtPosition != null && (itemAtPosition instanceof LbsDataV2.PoiInfo)) {
                    LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) itemAtPosition;
                    if ("empty_poi_id".equals(poiInfo.poiId)) {
                        return;
                    }
                    String str2 = "1";
                    if (!TextUtils.isEmpty(poiInfo.poiId) && poiInfo.poiId.equals("invalide_poi_id")) {
                        if (QZoneMoodSelectLocation.this.A0 == 100205) {
                            str = "1";
                        } else {
                            str = "2";
                        }
                        ClickReport.m("437", "2", str);
                    }
                    String str3 = "0";
                    if (((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45059i0 == null || ((SelectLocationListAdapter) ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45059i0).f44598f == null || poiInfo != ((SelectLocationListAdapter) ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45059i0).f44598f) {
                        z16 = false;
                    } else {
                        if (QZoneMoodSelectLocation.this.f44590x0 != null) {
                            poiInfo.address = QZoneMoodSelectLocation.this.f44590x0.address;
                        } else if (((SelectLocationListAdapter) ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45059i0).f44598f != null) {
                            poiInfo.address = ((SelectLocationListAdapter) ((CustomListViewFragmentV2) QZoneMoodSelectLocation.this).f45059i0).f44598f.poiName;
                        }
                        if (!QZoneMoodSelectLocation.this.Y0) {
                            str2 = "0";
                        }
                        z16 = true;
                        str3 = str2;
                    }
                    if (QZoneMoodSelectLocation.this.Y0) {
                        ClickReport.m("368", "32", str3);
                        fo.c.d("em_qz_location_item", "pg_qz_location_choose", view);
                    }
                    if (QZoneMoodSelectLocation.this.Z0) {
                        if (z16) {
                            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(BaseApplicationImpl.getApplication().getRuntime().getAccount()).setActionType(15).setSubActionType(9).setThrActionType(3));
                        } else {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("ext6", poiInfo.country + "|" + poiInfo.province + "|" + poiInfo.city + "|" + poiInfo.poiName);
                            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(BaseApplicationImpl.getApplication().getRuntime().getAccount()).setActionType(15).setSubActionType(9).setThrActionType(2).setExtras(hashMap));
                        }
                    }
                    QZoneMoodSelectLocation.this.Bk(poiInfo);
                    if (TextUtils.isEmpty(QZoneMoodSelectLocation.this.X0)) {
                        QZoneMoodSelectLocation.this.X0 = u5.b.i0("LbsPreferencesName", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, null);
                    }
                    if (!TextUtils.isEmpty(QZoneMoodSelectLocation.this.X0)) {
                        com.qzone.business.lbsv2.business.a.a(QZoneMoodSelectLocation.this.X0, System.currentTimeMillis(), poiInfo.poiId, QZoneMoodSelectLocation.this.fk(i3), QZoneMoodSelectLocation.this.A0, AppSetting.f99554n, QZoneMoodSelectLocation.this.dk(), QZoneMoodSelectLocation.this.ek(), DeviceInfoMonitor.getModel(), "Android", Build.VERSION.RELEASE, QZoneMoodSelectLocation.this.ck());
                    }
                } else if (itemAtPosition != null && (itemAtPosition instanceof PhotoPoiArea)) {
                    fo.c.d("em_qz_location_item", "pg_qz_location_choose", view);
                    QZoneMoodSelectLocation.this.Ak((PhotoPoiArea) itemAtPosition);
                }
                if (TextUtils.isEmpty(QZoneMoodSelectLocation.this.J0)) {
                    return;
                }
                QZoneMoodSelectLocation.this.J0 = "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = QZoneMoodSelectLocation.this.H0.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                if (QZoneMoodSelectLocation.this.S0 != null && QZoneMoodSelectLocation.this.S0.size() > 0) {
                    QZoneMoodSelectLocation.this.yk();
                }
                QZoneMoodSelectLocation.this.zk(trim);
            } else if (QZoneMoodSelectLocation.this.S0 == null || QZoneMoodSelectLocation.this.S0.size() <= 0) {
                QZoneMoodSelectLocation.this.J0 = "";
                QZoneMoodSelectLocation qZoneMoodSelectLocation = QZoneMoodSelectLocation.this;
                qZoneMoodSelectLocation.f45058h0 = 10;
                if (qZoneMoodSelectLocation.f44592z0 != null) {
                    com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).B(QZoneMoodSelectLocation.this.getHandler(), QZoneMoodSelectLocation.this.J0, null, true, QZoneMoodSelectLocation.this.A0, QZoneMoodSelectLocation.this.f44592z0);
                } else {
                    com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).i(QZoneMoodSelectLocation.this.getHandler(), QZoneMoodSelectLocation.this.J0, QZoneMoodSelectLocation.this.A0);
                }
            } else {
                QZoneMoodSelectLocation.this.Dk();
            }
            if (QZoneMoodSelectLocation.this.H0.getText() != null && !QZoneMoodSelectLocation.this.H0.getText().toString().equals("")) {
                QZoneMoodSelectLocation.this.findViewById(R.id.aym).setVisibility(0);
                if (QZoneMoodSelectLocation.this.Z0) {
                    QZoneMoodSelectLocation.this.Uj();
                    return;
                }
                return;
            }
            QZoneMoodSelectLocation.this.findViewById(R.id.aym).setVisibility(4);
            if (QZoneMoodSelectLocation.this.Z0 && TextUtils.isEmpty(QZoneMoodSelectLocation.this.H0.getText().toString())) {
                QZoneMoodSelectLocation qZoneMoodSelectLocation2 = QZoneMoodSelectLocation.this;
                qZoneMoodSelectLocation2.tk(qZoneMoodSelectLocation2.getResources().getDrawable(R.drawable.qvideo_skin_icon_general_search_secondary));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

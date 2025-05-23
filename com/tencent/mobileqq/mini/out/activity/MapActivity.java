package com.tencent.mobileqq.mini.out.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.tf;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.CommonObserver;
import com.tencent.mobileqq.mini.out.CommonServlet;
import com.tencent.mobileqq.mini.out.MapHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare$LocationReq;
import com.tencent.proto.lbsshare.LBSShare$LocationResp;
import com.tencent.proto.lbsshare.LBSShare$POI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MapActivity extends BaseActivity implements View.OnClickListener, QQMapView.b {
    public static final String KEY_TYPE = "key_type";
    public static final String TAG = "MapActivity";
    public static final int TYPE_CHOOSE_POI = 2;
    public static final int TYPE_SHOW_ADDR = 1;
    AppInterface app;
    QQCustomDialog dialog;
    LatLng fromLatLng;
    boolean isSearching;
    private int lastLatitude;
    private int lastLongitude;
    TextView leftBtnView;
    TencentMap map;
    MapHelper mapHelper;
    QQMapView mapView;
    TextView noResultView;
    ImageView pinView;
    POIAdapter poiAdapter;
    RelativeLayout poiLayout;
    XListView poiListView;
    ImageView poiLocationView;
    TextView rightBtnView;
    Button routeBtn;
    View routeLayout;
    LatLng targetLatLng;
    String targetName;
    TextView titleView;
    int type;
    private final int PAGE_SIZE = 10;
    CommonObserver commonObserver = new CommonObserver() { // from class: com.tencent.mobileqq.mini.out.activity.MapActivity.3
        @Override // com.tencent.mobileqq.mini.out.CommonObserver
        public void onGetPoiList(boolean z16, LBSShare$LocationResp lBSShare$LocationResp) {
            MapActivity mapActivity = MapActivity.this;
            mapActivity.isSearching = false;
            if (z16) {
                mapActivity.refreshPoiList(lBSShare$LocationResp.poilist.get(), lBSShare$LocationResp.next.get());
            }
        }

        @Override // com.tencent.mobileqq.mini.out.CommonObserver
        public void onGetStreetUrl(boolean z16, String str) {
            if (z16) {
                MapActivity.this.mapHelper.setStreetViewUrl(str);
            }
        }
    };
    protected AbsListView.OnScrollListener mOnSearchScrollListener = new AbsListView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.out.activity.MapActivity.5
        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (QLog.isDevelopLevel()) {
                QLog.i(MapActivity.TAG, 4, "onScrollStateChanged");
            }
            if (i3 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                MapActivity mapActivity = MapActivity.this;
                mapActivity.getPoiList(mapActivity.lastLatitude, MapActivity.this.lastLongitude);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    };

    static {
        try {
            System.loadLibrary(tf.f150434a);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e(tf.f150434a, 2, "load txmapengine.so error!" + th5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPoiList(int i3, int i16) {
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "getPoiList lat=" + i3 + ",lon=" + i16 + ",page=" + this.poiAdapter.nextBegin + ",isSearching=" + this.isSearching + ",hasMore=" + this.poiAdapter.hasMore);
        }
        if (!this.isSearching && this.poiAdapter.hasMore) {
            this.isSearching = true;
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.location");
            LBSShare$LocationReq lBSShare$LocationReq = new LBSShare$LocationReq();
            lBSShare$LocationReq.lat.set(i3);
            lBSShare$LocationReq.lng.set(i16);
            lBSShare$LocationReq.coordinate.set(0);
            String str = "";
            lBSShare$LocationReq.keyword.set("");
            lBSShare$LocationReq.page.set(this.poiAdapter.nextBegin);
            lBSShare$LocationReq.count.set(10);
            lBSShare$LocationReq.requireMyLbs.set(0);
            String z16 = ah.z();
            if (z16 != null) {
                str = z16;
            }
            lBSShare$LocationReq.imei.set(str);
            toServiceMsg.putWupBuffer(lBSShare$LocationReq.toByteArray());
            toServiceMsg.addAttribute(CommonServlet.IS_PB_PACKET, Boolean.TRUE);
            NewIntent newIntent = new NewIntent(this.app.getApplication(), CommonServlet.class);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            newIntent.setObserver(this.commonObserver);
            this.app.startServlet(newIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void location(final boolean z16) {
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new SosoInterfaceOnLocationListener(0, true, true, 5000L, true, false, "Qwallet") { // from class: com.tencent.mobileqq.mini.out.activity.MapActivity.2
            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                if (QLog.isColorLevel()) {
                    QLog.d(MapActivity.TAG, 2, "onLocationFinish errCode=" + i3);
                }
                if (i3 == 0 && sosoLbsInfo != null) {
                    SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                    MapActivity.this.fromLatLng = new LatLng(sosoLocation.mLat02, sosoLocation.mLon02);
                    if (z16) {
                        MapActivity mapActivity = MapActivity.this;
                        mapActivity.map.moveCamera(CameraUpdateFactory.newLatLng(mapActivity.fromLatLng));
                    }
                    MapActivity mapActivity2 = MapActivity.this;
                    if (mapActivity2.type == 2) {
                        mapActivity2.poiAdapter.reset();
                        MapActivity mapActivity3 = MapActivity.this;
                        mapActivity3.lastLatitude = (int) (mapActivity3.fromLatLng.getLatitude() * 1000000.0d);
                        MapActivity mapActivity4 = MapActivity.this;
                        mapActivity4.lastLongitude = (int) (mapActivity4.fromLatLng.getLongitude() * 1000000.0d);
                        MapActivity mapActivity5 = MapActivity.this;
                        mapActivity5.getPoiList(mapActivity5.lastLatitude, MapActivity.this.lastLongitude);
                        return;
                    }
                    return;
                }
                if (MapActivity.this.isFinishing()) {
                    return;
                }
                MapActivity.this.dialog.setTitle(HardCodeUtil.qqStr(R.string.nxs)).setMessage(HardCodeUtil.qqStr(R.string.nxo)).setPositiveButton(HardCodeUtil.qqStr(R.string.nxq), Color.parseColor("#000000"), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.MapActivity.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        boolean z17;
                        MapActivity mapActivity6 = MapActivity.this;
                        if (mapActivity6.type == 2) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        mapActivity6.location(z17);
                    }
                }).setNegativeButton(HardCodeUtil.qqStr(R.string.f171898lr0), Color.parseColor("#000000"), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.MapActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        MapActivity.this.finish();
                    }
                });
                MapActivity.this.dialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPoiList(final List<LBSShare$POI> list, final int i3) {
        int i16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshPoiList poiList size=");
            if (list != null) {
                i16 = list.size();
            } else {
                i16 = 0;
            }
            sb5.append(i16);
            sb5.append(",next=");
            sb5.append(i3);
            QLog.d(TAG, 2, sb5.toString());
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.out.activity.MapActivity.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                POIAdapter pOIAdapter = MapActivity.this.poiAdapter;
                List<LBSShare$POI> list2 = list;
                int i17 = 0;
                if (i3 > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                pOIAdapter.addPoiList(list2, z16);
                MapActivity mapActivity = MapActivity.this;
                TextView textView = mapActivity.noResultView;
                if (mapActivity.poiAdapter.getCount() >= 1) {
                    i17 = 8;
                }
                textView.setVisibility(i17);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Bitmap bitmap;
        super.doOnCreate(bundle);
        Bitmap bitmap2 = null;
        View inflate = LayoutInflater.from(this).inflate(R.layout.bdx, (ViewGroup) null);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        super.setContentView(inflate);
        this.app = getAppInterface();
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this, R.style.qZoneInputDialog);
        this.dialog = qQCustomDialog;
        qQCustomDialog.setContentView(R.layout.f167856jn);
        this.dialog.setCanceledOnTouchOutside(false);
        this.mapHelper = new MapHelper(this);
        Intent intent = getIntent();
        this.type = intent.getIntExtra("key_type", 0);
        this.titleView = (TextView) findViewById(R.id.ivTitleName);
        this.leftBtnView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.rightBtnView = (TextView) findViewById(R.id.f165893dt0);
        QQMapView qQMapView = (QQMapView) findViewById(R.id.emb);
        this.mapView = qQMapView;
        qQMapView.setContentDescription(getString(R.string.cxh));
        this.mapView.getMap().getUiSettings().setLogoPosition(0);
        this.mapView.getMap().getUiSettings().setScaleViewEnabled(false);
        this.mapView.setObserver(this);
        this.map = this.mapView.getMap();
        this.poiLocationView = (ImageView) findViewById(R.id.fwd);
        this.pinView = (ImageView) findViewById(R.id.fua);
        this.poiLayout = (RelativeLayout) findViewById(R.id.fw9);
        this.routeLayout = findViewById(R.id.ifk);
        Button button = (Button) findViewById(R.id.ifj);
        this.routeBtn = button;
        button.setOnClickListener(this);
        this.leftBtnView.setOnClickListener(this);
        this.rightBtnView.setOnClickListener(this);
        this.poiLocationView.setVisibility(0);
        this.poiLocationView.setOnClickListener(this);
        try {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fwq);
            try {
                bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.dgl);
            } catch (OutOfMemoryError unused) {
            }
        } catch (OutOfMemoryError unused2) {
            bitmap = null;
        }
        this.map.moveCamera(CameraUpdateFactory.zoomTo(intent.getIntExtra("scale", 18)));
        int i3 = this.type;
        if (i3 == 1) {
            this.leftBtnView.setText(HardCodeUtil.qqStr(R.string.nxu));
            this.routeLayout.setVisibility(0);
            LatLng latLng = new LatLng(intent.getDoubleExtra("latitude", 0.0d), intent.getDoubleExtra("longitude", 0.0d));
            this.targetLatLng = latLng;
            this.map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            MarkerOptions markerOptions = new MarkerOptions(this.targetLatLng);
            markerOptions.position(this.targetLatLng);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
            this.map.addMarker(markerOptions);
            this.targetName = intent.getStringExtra("name");
            String stringExtra = intent.getStringExtra("address");
            TextView textView = (TextView) this.routeLayout.findViewById(R.id.f164041i8);
            TextView textView2 = (TextView) this.routeLayout.findViewById(R.id.f164970bh2);
            textView.setText(this.targetName);
            textView2.setText(stringExtra);
            location(false);
        } else if (i3 == 2) {
            this.noResultView = (TextView) findViewById(R.id.f166412fa0);
            this.poiAdapter = new POIAdapter(this);
            XListView xListView = (XListView) findViewById(R.id.searchList);
            this.poiListView = xListView;
            xListView.setAdapter((ListAdapter) this.poiAdapter);
            this.poiListView.setOnScrollListener(this.mOnSearchScrollListener);
            this.poiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.MapActivity.1
                @Override // com.tencent.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i16, long j3) {
                    if (QLog.isColorLevel()) {
                        QLog.i(MapActivity.TAG, 2, "setOnItemClickListener" + i16);
                    }
                    if (MapActivity.this.poiAdapter.getItem(i16) != null) {
                        MapActivity.this.poiAdapter.select(i16);
                    }
                }
            });
            this.leftBtnView.setText(HardCodeUtil.qqStr(R.string.nxr));
            this.rightBtnView.setVisibility(0);
            this.rightBtnView.setText(HardCodeUtil.qqStr(R.string.ket));
            this.poiLayout.setVisibility(0);
            this.pinView.setVisibility(0);
            if (bitmap2 != null) {
                this.pinView.setImageBitmap(bitmap2);
                this.pinView.setPadding(0, 0, 0, bitmap2.getHeight());
            }
            location(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.commonObserver = null;
        QQCustomDialog qQCustomDialog = this.dialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.setOnDismissListener(null);
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        QQMapView qQMapView = this.mapView;
        if (qQMapView != null) {
            qQMapView.onResume();
        }
    }

    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ivTitleBtnLeft) {
            finish();
        } else if (view.getId() == R.id.fwd) {
            location(true);
        } else if (view.getId() == R.id.ifj) {
            this.mapHelper.showActionSheet(this.fromLatLng, this.targetLatLng, null, this.targetName);
        } else if (view.getId() == R.id.f165893dt0) {
            POIAdapter pOIAdapter = this.poiAdapter;
            LBSShare$POI item = pOIAdapter.getItem(pOIAdapter.selectPos);
            if (item == null) {
                QQToast.makeText(this, 0, HardCodeUtil.qqStr(R.string.nxt), 1).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            } else {
                Intent intent = new Intent();
                intent.putExtra("name", item.name.get());
                intent.putExtra("address", item.addr.get());
                intent.putExtra("latitude", item.lat.get());
                intent.putExtra("longitude", item.lng.get());
                setResult(-1, intent);
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void onMapScrollEnd(GeoPoint geoPoint) {
        if (this.type == 2) {
            this.poiAdapter.reset();
            this.lastLatitude = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            this.lastLongitude = longitudeE6;
            getPoiList(this.lastLatitude, longitudeE6);
        }
    }

    public void onMapScrollStart(GeoPoint geoPoint) {
    }
}

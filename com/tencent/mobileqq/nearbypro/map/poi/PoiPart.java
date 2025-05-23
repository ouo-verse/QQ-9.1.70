package com.tencent.mobileqq.nearbypro.map.poi;

import android.app.Activity;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearbypro.map.poi.b;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import cooperation.qzone.LbsDataV2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PoiPart extends Part implements TencentMap.OnCameraChangeListener, TencentMap.OnMapClickListener, TencentMap.OnMapPoiClickListener {
    com.tencent.mobileqq.nearbypro.map.poi.a G;
    com.tencent.mobileqq.nearbypro.map.poi.d H;
    com.tencent.mobileqq.nearbypro.map.poi.f I;
    XListView J;
    private View K;
    private QUSHalfScreenFloatingView L;
    private View N;
    private View P;
    private View Q;
    private View R;
    private View S;
    private View T;
    private EditText U;
    private com.tencent.mobileqq.nearbypro.map.poi.b W;

    /* renamed from: d, reason: collision with root package name */
    private final List<LbsDataV2.PoiInfo> f253528d = new ArrayList(20);

    /* renamed from: e, reason: collision with root package name */
    protected boolean f253529e = false;

    /* renamed from: f, reason: collision with root package name */
    protected LatLng f253530f = null;

    /* renamed from: h, reason: collision with root package name */
    protected String f253531h = "";

    /* renamed from: i, reason: collision with root package name */
    protected String f253532i = "";

    /* renamed from: m, reason: collision with root package name */
    protected String f253533m = "";
    protected String C = "";
    protected boolean D = false;
    protected int E = 3;
    protected int F = 4;
    protected LatLng M = null;
    private boolean V = true;
    private LatLng X = null;
    private boolean Y = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PoiPart.this.T9();
            ReportController.o(null, "CliOper", "", "", "0X800A961", "0X800A961", 0, 0, "0", "0", "0", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PoiPart.this.U.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements b.InterfaceC8152b {
        d() {
        }

        @Override // com.tencent.mobileqq.nearbypro.map.poi.b.InterfaceC8152b
        public void a() {
            PoiPart.this.W9(true);
        }

        @Override // com.tencent.mobileqq.nearbypro.map.poi.b.InterfaceC8152b
        public int b(LatLng latLng, int i3) {
            PoiPart poiPart = PoiPart.this;
            com.tencent.mobileqq.nearbypro.map.poi.a aVar = poiPart.G;
            if (aVar == null) {
                QLog.i(poiPart.getTAG(), 1, "getDistance error");
                return 0;
            }
            LatLng value = aVar.X1().getValue();
            return value != null ? (int) TencentLocationUtils.distanceBetween(value.latitude, value.longitude, latLng.latitude, latLng.longitude) : i3;
        }

        @Override // com.tencent.mobileqq.nearbypro.map.poi.b.InterfaceC8152b
        public void c(LatLng latLng, boolean z16) {
            PoiPart poiPart = PoiPart.this;
            poiPart.D = z16;
            poiPart.la(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class f implements AbsListView.OnScrollButtomListener {
        f() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollButtomListener
        public void onScrollToButtom(int i3) {
            PoiPart.this.aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class h implements QUSBaseHalfScreenFloatingView.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f253559a;

        h(View view) {
            this.f253559a = view;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.k
        public void a(float f16) {
            PoiPart.this.qa(this.f253559a.getHeight() - ((int) f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class i extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f253561d;

        i(int i3) {
            this.f253561d = i3;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            PoiPart poiPart;
            int i3;
            return ((PoiPart.this.J.getChildCount() > 0 && PoiPart.this.J.getFirstVisiblePosition() == 0 && PoiPart.this.J.getChildAt(0).getTop() >= PoiPart.this.J.getPaddingTop()) || (i3 = (poiPart = PoiPart.this).E) == 1 || i3 == 1 || i3 == 0 || poiPart.J.getChildCount() == 0) ? false : true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            PoiPart.this.J.getDrawingRect(new Rect());
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            return PoiPart.this.K;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return (this.f253561d * 74) / 100;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            return (this.f253561d * 36) / 100;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class j extends com.tencent.mobileqq.widget.qus.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f253563d;

        j(int i3) {
            this.f253563d = i3;
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
            PoiPart.this.Y = true;
            PoiPart.this.qa((this.f253563d * 36) / 100);
            PoiPart.this.pa();
            PoiPart.this.ga();
            PoiPart poiPart = PoiPart.this;
            if (poiPart.F == 5 && "".equals(poiPart.U.getText().toString().trim())) {
                PoiPart.this.T9();
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            PoiPart.this.Y = false;
            PoiPart.this.qa((this.f253563d * 74) / 100);
        }
    }

    private void S9() {
        LatLng latLng = this.X;
        if (latLng != null) {
            this.G.O1(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.14
            @Override // java.lang.Runnable
            public void run() {
                PoiPart.this.ga();
                PoiPart.this.U.setText("");
                PoiPart.this.U.clearFocus();
                PoiPart.this.L.O(0);
                PoiPart.this.U9(4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9(boolean z16) {
        com.tencent.mobileqq.nearbypro.map.poi.f fVar = this.I;
        if (fVar != null) {
            fVar.M1(z16);
        }
    }

    private void X9(LatLng latLng, String str) {
        this.f253528d.clear();
        Y9(latLng, str, 1);
    }

    private void Y9(final LatLng latLng, final String str, final int i3) {
        TencentSearch tencentSearch = new TencentSearch(BaseApplication.getContext());
        HttpResponseListener<BaseObject> httpResponseListener = new HttpResponseListener<BaseObject>() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.16
            @Override // com.tencent.map.tools.net.http.HttpResponseListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(int i16, BaseObject baseObject) {
                SuggestionResultObject suggestionResultObject;
                List<SuggestionResultObject.SuggestionData> list;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                peekAppRuntime.getAccount();
                if (baseObject instanceof Geo2AddressResultObject) {
                    PoiPart.this.f253528d.add(com.tencent.mobileqq.nearbypro.map.poi.c.f253579a.d(((Geo2AddressResultObject) baseObject).result, latLng));
                    PoiPart.this.ma(latLng, i3);
                    return;
                }
                if ((baseObject instanceof SuggestionResultObject) && (list = (suggestionResultObject = (SuggestionResultObject) baseObject).data) != null) {
                    Iterator<SuggestionResultObject.SuggestionData> it = list.iterator();
                    while (it.hasNext()) {
                        PoiPart.this.f253528d.add(com.tencent.mobileqq.nearbypro.map.poi.c.f253579a.f(it.next()));
                    }
                    PoiPart poiPart = PoiPart.this;
                    int i17 = suggestionResultObject.count;
                    com.tencent.mobileqq.nearbypro.map.poi.b unused = poiPart.W;
                    poiPart.V = poiPart.ea(i17, i3 * 20);
                }
                if (PoiPart.this.f253528d.size() == 0) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PoiPart.this.U9(2);
                        }
                    });
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.16.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PoiPart.this.W != null) {
                                com.tencent.mobileqq.nearbypro.map.poi.b bVar = PoiPart.this.W;
                                AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                                bVar.f253573m = str;
                                PoiPart.this.W.e(PoiPart.this.f253528d, PoiPart.this.V);
                                PoiPart.this.U9(3);
                                if (PoiPart.this.W.c() == 0 || PoiPart.this.W.c() == -1) {
                                    AnonymousClass16 anonymousClass162 = AnonymousClass16.this;
                                    if (i3 <= 1) {
                                        PoiPart.this.J.setSelection(0);
                                    }
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.map.tools.net.http.HttpResponseListener
            public void onFailure(int i16, String str2, Throwable th5) {
                QLog.e(PoiPart.this.getTAG(), 1, "errCode=" + i16 + ", errMsg=" + str2);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.16.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiPart.this.W != null) {
                            PoiPart.this.U9(1);
                        }
                    }
                });
            }
        };
        if (!"".equals(str)) {
            com.tencent.mobileqq.nearbypro.map.poi.a aVar = this.G;
            tencentSearch.suggestion(new SuggestionParam(str, aVar != null ? aVar.Q1(latLng) : "").location(latLng).policy(SuggestionParam.Policy.DEF).pageSize(20).pageIndex(i3), httpResponseListener);
        } else if (i3 <= 1) {
            tencentSearch.geo2address(new Geo2AddressParam(latLng).getPoi(false).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(20).setPageIndex(i3)), httpResponseListener);
        } else {
            ma(latLng, i3);
        }
    }

    private void Z9(LatLng latLng, String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.15
            @Override // java.lang.Runnable
            public void run() {
                PoiPart.this.U9(0);
            }
        });
        this.J.setSelection(0);
        if (str == "") {
            this.W.f(0);
        } else {
            this.W.f(-1);
        }
        X9(latLng, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        if (this.V) {
            Y9(ba(), ((TextView) this.K.findViewById(R.id.cas).findViewById(R.id.et_search_keyword)).getText().toString().trim(), (this.W.getCount() / 20) + 1);
        }
    }

    private LatLng ba() {
        com.tencent.mobileqq.nearbypro.map.poi.a aVar = this.G;
        if (aVar != null) {
            return aVar.R1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        if (this.Y) {
            T9();
        } else {
            this.L.O(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ea(int i3, int i16) {
        if (i3 > i16 && i16 < 200) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        EditText editText;
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.i(getTAG(), 1, "hideInputMethod rootView is null");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null || !inputMethodManager.isActive() || (editText = (EditText) partRootView.findViewById(R.id.et_search_keyword)) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void ha() {
        this.J = (XListView) this.K.findViewById(R.id.fw_);
        com.tencent.mobileqq.nearbypro.map.poi.b bVar = new com.tencent.mobileqq.nearbypro.map.poi.b(getActivity(), (com.tencent.mobileqq.nearbypro.map.poi.d) getViewModel(com.tencent.mobileqq.nearbypro.map.poi.d.class));
        this.W = bVar;
        bVar.g(new d());
        this.J.setDividerHeight(0);
        this.J.setAdapter((ListAdapter) this.W);
        this.J.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.2
            @Override // com.tencent.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, final int i3, long j3) {
                if (PoiPart.this.W.b() == null) {
                    PoiPart.this.L.O(0);
                    PoiPart.this.J.post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PoiPart.this.J.setSelection(i3);
                        }
                    });
                }
                PoiPart.this.W.a(i3);
            }
        });
        this.J.setOnScrollListener(new e());
        this.J.setOnScrollToButtomListener(new f());
        this.J.disableOverScrollTop(true);
    }

    private void ia() {
        getActivity().getWindow().setSoftInputMode(48);
        View findViewById = this.K.findViewById(R.id.cas);
        View findViewById2 = findViewById.findViewById(R.id.btn_cancel_search);
        this.T = findViewById2;
        findViewById2.setVisibility(8);
        EditText editText = (EditText) findViewById.findViewById(R.id.et_search_keyword);
        this.U = editText;
        editText.setOnKeyListener(new k());
        this.T.setOnClickListener(new a());
        this.U.setImeOptions(3);
        this.U.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (1 == motionEvent.getAction()) {
                    if (PoiPart.this.L != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PoiPart.this.U9(5);
                            }
                        });
                        PoiPart.this.L.P(0);
                    }
                    ReportController.o(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
                }
                return false;
            }
        });
        View findViewById3 = findViewById.findViewById(R.id.txm);
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(findViewById3, findViewById3.getResources().getString(R.string.ajx), Button.class.getName());
        }
        findViewById3.setOnClickListener(new b());
        this.R = findViewById.findViewById(R.id.kag);
        View findViewById4 = findViewById.findViewById(R.id.ib_clear_text);
        this.S = findViewById4;
        findViewById4.setAlpha(0.6f);
        this.U.addTextChangedListener(new c(findViewById3));
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(this.K.findViewById(R.id.f26140cq), this.U.getText().toString(), EditText.class.getName());
        }
    }

    private void initHalfScreenView() {
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.i(getTAG(), 1, "initHalfScreenView rootview is null");
            return;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) partRootView.findViewById(R.id.x5o);
        this.L = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setVisibility(0);
        this.L.setOutSideTouchEnable(false);
        this.L.r();
        this.L.getChildAt(0).setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.addView(new QUSHalfScreenDefaultHeaderView(getContext(), null, 0));
        this.L.setHeaderView(relativeLayout);
        this.L.r();
        int i3 = getPartHost().getHostActivity().getResources().getDisplayMetrics().heightPixels;
        this.L.i(new g());
        this.L.l(new h(partRootView));
        this.L.setQUSDragFloatController(new i(i3));
        this.L.j(new j(i3));
    }

    private void initViewModel() {
        com.tencent.mobileqq.nearbypro.map.poi.a aVar = (com.tencent.mobileqq.nearbypro.map.poi.a) getViewModel(com.tencent.mobileqq.nearbypro.map.poi.a.class);
        this.G = aVar;
        aVar.f2(this, this, this);
        this.H = (com.tencent.mobileqq.nearbypro.map.poi.d) getViewModel(com.tencent.mobileqq.nearbypro.map.poi.d.class);
        this.I = (com.tencent.mobileqq.nearbypro.map.poi.f) getViewModel(com.tencent.mobileqq.nearbypro.map.poi.f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(LatLng latLng) {
        com.tencent.mobileqq.nearbypro.map.poi.a aVar = this.G;
        if (aVar == null || latLng == null) {
            return;
        }
        aVar.O1(latLng);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(LatLng latLng, final int i3) {
        new OkHttpClient().newCall(new Request.Builder().url("https://apis.map.qq.com/ws/place/v1/explore?boundary=nearby(" + latLng.latitude + "," + latLng.longitude + ",1000,1)&policy=2&page_size=20&page_index=" + i3 + "&key=" + Util.getMetaKey(BaseApplication.getContext(), "TencentMapSDK")).build()).enqueue(new Callback() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.17
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiPart.this.W != null) {
                            PoiPart.this.U9(1);
                        }
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    int optInt = jSONObject.has("count") ? jSONObject.optInt("count") : -1;
                    if (jSONObject.has("data")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray.length() == 0 && PoiPart.this.f253528d.isEmpty()) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.17.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    PoiPart.this.U9(2);
                                }
                            });
                            return;
                        }
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            SearchResultObject.SearchResultData searchResultData = new SearchResultObject.SearchResultData();
                            searchResultData.parse(optJSONArray.getJSONObject(i16));
                            PoiPart.this.f253528d.add(com.tencent.mobileqq.nearbypro.map.poi.c.f253579a.e(searchResultData));
                        }
                    }
                    PoiPart poiPart = PoiPart.this;
                    com.tencent.mobileqq.nearbypro.map.poi.b unused = poiPart.W;
                    poiPart.V = poiPart.ea(optInt, i3 * 20);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                response.body().close();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.poi.PoiPart.17.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiPart.this.W != null) {
                            PoiPart.this.W.f253573m = "";
                            PoiPart.this.W.e(PoiPart.this.f253528d, PoiPart.this.V);
                            PoiPart.this.U9(3);
                            if (PoiPart.this.W.c() == 0 || PoiPart.this.W.c() == -1) {
                                AnonymousClass17 anonymousClass17 = AnonymousClass17.this;
                                if (i3 <= 1) {
                                    PoiPart.this.J.setSelection(0);
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    private void na() {
        this.X = ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(String str) {
        LatLng ba5 = ba();
        if (ba5 != null) {
            Z9(ba5, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa() {
        int c16 = this.W.c();
        if (c16 == -1 || this.W.b() == null) {
            return;
        }
        if (c16 < this.J.getFirstVisiblePosition() || c16 > this.J.getFirstVisiblePosition() + 2) {
            this.J.setSelection(c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(int i3) {
        com.tencent.mobileqq.nearbypro.map.poi.a aVar = this.G;
        if (aVar != null) {
            aVar.d2(i3);
        } else {
            QLog.i(getTAG(), 1, "setMapBottom mapViewModel null");
        }
    }

    void U9(int i3) {
        if (this.E == i3 || this.F == i3) {
            return;
        }
        if (i3 == 0) {
            this.E = 0;
            this.N.setVisibility(8);
            this.P.setVisibility(8);
            this.Q.setVisibility(0);
            this.J.setVisibility(8);
            W9(false);
            return;
        }
        if (i3 == 1) {
            this.N.setVisibility(8);
            this.P.setVisibility(0);
            this.Q.setVisibility(8);
            this.J.setVisibility(8);
            this.E = 1;
            W9(false);
            return;
        }
        if (i3 == 2) {
            this.N.setVisibility(0);
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
            this.J.setVisibility(8);
            this.E = 2;
            W9(false);
            return;
        }
        if (i3 == 3) {
            this.N.setVisibility(8);
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
            this.J.setVisibility(0);
            this.E = 3;
            return;
        }
        if (i3 == 4) {
            this.F = 4;
            this.R.setVisibility(0);
            this.T.setVisibility(8);
            this.K.findViewById(R.id.f110936jv).setVisibility(8);
            S9();
            return;
        }
        if (i3 != 5) {
            return;
        }
        this.F = 5;
        this.R.setVisibility(8);
        this.T.setVisibility(0);
        this.K.findViewById(R.id.f110936jv).setVisibility(0);
        V9();
        na();
    }

    void V9() {
        this.f253528d.clear();
        this.V = false;
        this.W.e(this.f253528d, false);
        W9(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PoiPart";
    }

    void ja() {
        this.N = this.K.findViewById(R.id.c3n);
        this.P = this.K.findViewById(R.id.f26130cp);
        this.Q = this.K.findViewById(R.id.f166531c92);
        ViewGroup viewGroup = (ViewGroup) this.K.findViewById(R.id.ytb);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f159095ck4);
        viewGroup.addView(LoadingUtil.getLoadingView(getContext(), dimensionPixelSize, dimensionPixelSize, 2));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.K = getActivity().getLayoutInflater().inflate(R.layout.f168922hc0, (ViewGroup) null);
        ja();
        ha();
        ia();
        initHalfScreenView();
        initViewModel();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        la(latLng);
        this.L.O(0);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.mobileqq.nearbypro.map.poi.a aVar = this.G;
        if (aVar != null) {
            aVar.P1();
        }
        this.f253528d.clear();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        com.tencent.mobileqq.nearbypro.map.poi.a aVar;
        if (cameraPosition == null || (aVar = this.G) == null) {
            return;
        }
        aVar.a2(cameraPosition.target);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class k implements View.OnKeyListener {
        k() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                PoiPart.this.da();
                return true;
            }
            if (i3 != 84 && i3 != 66) {
                return false;
            }
            PoiPart.this.W.a(0);
            PoiPart.this.L.O(0);
            PoiPart.this.ga();
            return true;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return;
        }
        com.tencent.mobileqq.nearbypro.map.poi.a aVar = this.G;
        if (aVar != null) {
            aVar.a2(cameraPosition.target);
        }
        LatLng latLng = this.M;
        if (latLng == null || ca(latLng, cameraPosition.target) >= 2.0d || this.W.getCount() == 0) {
            this.M = cameraPosition.target;
            boolean z16 = false;
            if (this.D) {
                this.D = false;
                return;
            }
            com.tencent.mobileqq.nearbypro.map.poi.a aVar2 = this.G;
            if (aVar2 != null && !aVar2.T1().getValue().booleanValue()) {
                z16 = true;
            }
            if (z16) {
                if (this.F != 5 || this.U.getText().toString().isEmpty()) {
                    Z9(cameraPosition.target, "");
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener
    public void onClicked(MapPoi mapPoi) {
        if (mapPoi == null) {
            return;
        }
        la(mapPoi.position);
        this.L.O(0);
    }

    public static double ca(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0d;
        }
        return TencentLocationUtils.distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f253553d;

        c(View view) {
            this.f253553d = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = editable.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                PoiPart.this.S.setVisibility(0);
                this.f253553d.setVisibility(0);
                PoiPart.this.oa(trim);
            } else {
                PoiPart.this.S.setVisibility(8);
                this.f253553d.setVisibility(8);
                PoiPart poiPart = PoiPart.this;
                if (poiPart.F != 5) {
                    poiPart.oa("");
                } else {
                    poiPart.V9();
                }
            }
            if (AppSetting.f99565y) {
                AccessibilityUtil.c(PoiPart.this.K.findViewById(R.id.f26140cq), trim, EditText.class.getName());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            PoiPart.this.ga();
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class g implements QUSBaseHalfScreenFloatingView.n {
        g() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onFinishDrag() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onStartDrag() {
        }
    }
}

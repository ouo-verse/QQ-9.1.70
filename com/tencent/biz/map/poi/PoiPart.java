package com.tencent.biz.map.poi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
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
import com.tencent.biz.map.poi.c;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
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

/* loaded from: classes2.dex */
public class PoiPart extends com.tencent.biz.map.poi.a implements TencentMap.OnCameraChangeListener, TencentMap.OnMapClickListener, TencentMap.OnMapPoiClickListener {
    com.tencent.biz.map.poi.b G;
    com.tencent.biz.map.poi.d H;
    com.tencent.biz.map.poi.f I;
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
    private com.tencent.biz.map.poi.c W;

    /* renamed from: d, reason: collision with root package name */
    private final List<LocationRoom.Venue> f78708d = new ArrayList(20);

    /* renamed from: e, reason: collision with root package name */
    protected boolean f78709e = false;

    /* renamed from: f, reason: collision with root package name */
    protected LatLng f78710f = null;

    /* renamed from: h, reason: collision with root package name */
    protected String f78711h = "";

    /* renamed from: i, reason: collision with root package name */
    protected String f78712i = "";

    /* renamed from: m, reason: collision with root package name */
    protected String f78713m = "";
    protected String C = "";
    protected boolean D = false;
    protected int E = 3;
    protected int F = 4;
    protected LatLng M = null;
    private boolean V = true;
    private LatLng X = null;
    private boolean Y = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnKeyListener {
        a() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PoiPart.this.U9();
            ReportController.o(null, "CliOper", "", "", "0X800A961", "0X800A961", 0, 0, "0", "0", "0", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PoiPart.this.U.setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements c.b {
        e() {
        }

        @Override // com.tencent.biz.map.poi.c.b
        public void a() {
            PoiPart.this.X9(true);
        }

        @Override // com.tencent.biz.map.poi.c.b
        public int b(LatLng latLng, int i3) {
            PoiPart poiPart = PoiPart.this;
            com.tencent.biz.map.poi.b bVar = poiPart.G;
            if (bVar == null) {
                QLog.i(poiPart.getTAG(), 1, "getDistance error");
                return 0;
            }
            LatLng value = bVar.X1().getValue();
            if (value != null) {
                return (int) TencentLocationUtils.distanceBetween(value.latitude, value.longitude, latLng.latitude, latLng.longitude);
            }
            return i3;
        }

        @Override // com.tencent.biz.map.poi.c.b
        public void c(LatLng latLng, boolean z16) {
            PoiPart poiPart = PoiPart.this;
            poiPart.D = z16;
            poiPart.la(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements AbsListView.OnScrollButtomListener {
        g() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollButtomListener
        public void onScrollToButtom(int i3) {
            PoiPart.this.ba();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements QUSBaseHalfScreenFloatingView.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f78740a;

        i(View view) {
            this.f78740a = view;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.k
        public void a(float f16) {
            PoiPart.this.ra(this.f78740a.getHeight() - ((int) f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f78742d;

        j(int i3) {
            this.f78742d = i3;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            PoiPart poiPart;
            int i3;
            if ((PoiPart.this.J.getChildCount() > 0 && PoiPart.this.J.getFirstVisiblePosition() == 0 && PoiPart.this.J.getChildAt(0).getTop() >= PoiPart.this.J.getPaddingTop()) || (i3 = (poiPart = PoiPart.this).E) == 1 || i3 == 2 || i3 == 0 || poiPart.J.getChildCount() == 0) {
                return false;
            }
            return true;
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
            return (this.f78742d * 74) / 100;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            return (this.f78742d * 36) / 100;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k extends com.tencent.mobileqq.widget.qus.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f78744d;

        k(int i3) {
            this.f78744d = i3;
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
            PoiPart.this.Y = true;
            PoiPart.this.ra((this.f78744d * 36) / 100);
            PoiPart.this.qa();
            PoiPart.this.ga();
            PoiPart poiPart = PoiPart.this;
            if (poiPart.F == 5 && "".equals(poiPart.U.getText().toString().trim())) {
                PoiPart.this.U9();
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            PoiPart.this.Y = false;
            PoiPart.this.ra((this.f78744d * 74) / 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements View.OnFocusChangeListener {
        l() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                PoiPart.this.U.setHint(R.string.f224666jj);
            } else {
                PoiPart.this.U.setHint("");
            }
        }
    }

    private void T9() {
        LatLng latLng = this.X;
        if (latLng != null) {
            this.G.O1(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.15
            @Override // java.lang.Runnable
            public void run() {
                PoiPart.this.ga();
                PoiPart.this.U.setText("");
                PoiPart.this.U.clearFocus();
                PoiPart.this.L.O(0);
                PoiPart.this.V9(4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(boolean z16) {
        com.tencent.biz.map.poi.f fVar = this.I;
        if (fVar != null) {
            fVar.M1(z16);
        }
    }

    private void Y9(LatLng latLng, String str) {
        this.f78708d.clear();
        Z9(latLng, str, 1);
    }

    private void Z9(final LatLng latLng, final String str, final int i3) {
        TencentSearch tencentSearch = new TencentSearch(BaseApplication.getContext());
        HttpResponseListener<BaseObject> httpResponseListener = new HttpResponseListener<BaseObject>() { // from class: com.tencent.biz.map.poi.PoiPart.17
            @Override // com.tencent.map.tools.net.http.HttpResponseListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(int i16, BaseObject baseObject) {
                SuggestionResultObject suggestionResultObject;
                List<SuggestionResultObject.SuggestionData> list;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                String account = peekAppRuntime.getAccount();
                if (baseObject instanceof Geo2AddressResultObject) {
                    PoiPart.this.f78708d.add(LocationRoom.Venue.a(account, ((Geo2AddressResultObject) baseObject).result, latLng));
                    PoiPart.this.ma(latLng, i3);
                    return;
                }
                if ((baseObject instanceof SuggestionResultObject) && (list = (suggestionResultObject = (SuggestionResultObject) baseObject).data) != null) {
                    Iterator<SuggestionResultObject.SuggestionData> it = list.iterator();
                    while (it.hasNext()) {
                        PoiPart.this.f78708d.add(LocationRoom.Venue.c(account, it.next()));
                    }
                    PoiPart poiPart = PoiPart.this;
                    int i17 = suggestionResultObject.count;
                    com.tencent.biz.map.poi.c unused = poiPart.W;
                    poiPart.V = poiPart.ea(i17, i3 * 20);
                }
                if (PoiPart.this.f78708d.size() == 0) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PoiPart.this.V9(2);
                        }
                    });
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.17.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PoiPart.this.W != null) {
                                com.tencent.biz.map.poi.c cVar = PoiPart.this.W;
                                AnonymousClass17 anonymousClass17 = AnonymousClass17.this;
                                cVar.f78755m = str;
                                PoiPart.this.W.e(PoiPart.this.f78708d, PoiPart.this.V);
                                PoiPart.this.V9(3);
                                if (PoiPart.this.W.c() == 0 || PoiPart.this.W.c() == -1) {
                                    AnonymousClass17 anonymousClass172 = AnonymousClass17.this;
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
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.17.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiPart.this.W != null) {
                            PoiPart.this.V9(1);
                        }
                    }
                });
            }
        };
        String str2 = "";
        if ("".equals(str)) {
            if (i3 <= 1) {
                tencentSearch.geo2address(new Geo2AddressParam(latLng).getPoi(false).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(20).setPageIndex(i3)), httpResponseListener);
                return;
            } else {
                ma(latLng, i3);
                return;
            }
        }
        com.tencent.biz.map.poi.b bVar = this.G;
        if (bVar != null) {
            str2 = bVar.Q1(latLng);
        }
        tencentSearch.suggestion(new SuggestionParam(str, str2).location(latLng).policy(SuggestionParam.Policy.DEF).pageSize(20).pageIndex(i3), httpResponseListener);
    }

    private void aa(LatLng latLng, String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.16
            @Override // java.lang.Runnable
            public void run() {
                PoiPart.this.V9(0);
            }
        });
        this.J.setSelection(0);
        if (str == "") {
            this.W.f(0);
        } else {
            this.W.f(-1);
        }
        Y9(latLng, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (!this.V) {
            return;
        }
        Z9(ca(), ((TextView) this.K.findViewById(R.id.cas).findViewById(R.id.et_search_keyword)).getText().toString().trim(), (this.W.getCount() / 20) + 1);
    }

    private LatLng ca() {
        com.tencent.biz.map.poi.b bVar = this.G;
        if (bVar != null) {
            return bVar.R1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        if (this.Y) {
            U9();
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
        if (inputMethodManager != null && inputMethodManager.isActive() && (editText = (EditText) partRootView.findViewById(R.id.et_search_keyword)) != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    private void ha() {
        this.J = (XListView) this.K.findViewById(R.id.fw_);
        com.tencent.biz.map.poi.c cVar = new com.tencent.biz.map.poi.c(getActivity(), (com.tencent.biz.map.poi.d) getViewModel(com.tencent.biz.map.poi.d.class));
        this.W = cVar;
        cVar.g(new e());
        this.J.setDividerHeight(0);
        this.J.setAdapter((ListAdapter) this.W);
        this.J.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.biz.map.poi.PoiPart.2
            @Override // com.tencent.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, final int i3, long j3) {
                if (PoiPart.this.W.b() == null) {
                    PoiPart.this.L.O(0);
                    PoiPart.this.J.post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PoiPart.this.J.setSelection(i3);
                        }
                    });
                }
                PoiPart.this.W.a(i3);
            }
        });
        this.J.setOnScrollListener(new f());
        this.J.setOnScrollToButtomListener(new g());
        this.J.disableOverScrollTop(true);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void ia() {
        getActivity().getWindow().setSoftInputMode(48);
        View findViewById = this.K.findViewById(R.id.cas);
        View findViewById2 = findViewById.findViewById(R.id.btn_cancel_search);
        this.T = findViewById2;
        findViewById2.setVisibility(8);
        EditText editText = (EditText) findViewById.findViewById(R.id.et_search_keyword);
        this.U = editText;
        editText.setHint("");
        this.U.setOnFocusChangeListener(new l());
        this.U.setOnKeyListener(new a());
        this.T.setOnClickListener(new b());
        this.U.setImeOptions(3);
        this.U.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.biz.map.poi.PoiPart.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                com.tencent.biz.map.poi.a.x9("em_location_search_bar", "dt_clck");
                if (1 == motionEvent.getAction()) {
                    if (PoiPart.this.L != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PoiPart.this.V9(5);
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
        findViewById3.setOnClickListener(new c());
        this.R = findViewById.findViewById(R.id.kag);
        View findViewById4 = findViewById.findViewById(R.id.ib_clear_text);
        this.S = findViewById4;
        findViewById4.setAlpha(0.6f);
        this.U.addTextChangedListener(new d(findViewById3));
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
        this.L.i(new h());
        this.L.l(new i(partRootView));
        this.L.setQUSDragFloatController(new j(i3));
        this.L.j(new k(i3));
    }

    private void initViewModel() {
        com.tencent.biz.map.poi.b bVar = (com.tencent.biz.map.poi.b) getViewModel(com.tencent.biz.map.poi.b.class);
        this.G = bVar;
        bVar.f2(this, this, this);
        this.H = (com.tencent.biz.map.poi.d) getViewModel(com.tencent.biz.map.poi.d.class);
        this.I = (com.tencent.biz.map.poi.f) getViewModel(com.tencent.biz.map.poi.f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(LatLng latLng) {
        com.tencent.biz.map.poi.b bVar = this.G;
        if (bVar != null && latLng != null) {
            bVar.O1(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(LatLng latLng, final int i3) {
        new OkHttpClient().newCall(new Request.Builder().url("https://apis.map.qq.com/ws/place/v1/explore?boundary=nearby(" + latLng.latitude + "," + latLng.longitude + ",1000,1)&policy=2&page_size=20&page_index=" + i3 + "&key=" + Util.getMetaKey(BaseApplication.getContext(), "TencentMapSDK")).build()).enqueue(new Callback() { // from class: com.tencent.biz.map.poi.PoiPart.18
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiPart.this.W != null) {
                            PoiPart.this.V9(1);
                        }
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                int i16;
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    if (jSONObject.has("count")) {
                        i16 = jSONObject.optInt("count");
                    } else {
                        i16 = -1;
                    }
                    if (jSONObject.has("data")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray.length() == 0 && PoiPart.this.f78708d.isEmpty()) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.18.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    PoiPart.this.V9(2);
                                }
                            });
                            return;
                        }
                        for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                            LocationRoom.Venue venue = new LocationRoom.Venue();
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i17);
                            JSONObject optJSONObject = jSONObject2.optJSONObject("location");
                            venue.f241271f = jSONObject2.optString("title");
                            venue.f241272h = jSONObject2.optString("address");
                            venue.f241274m = jSONObject2.optDouble("_distance");
                            venue.f241273i = new LatLng(optJSONObject.optDouble(QCircleSchemeAttr.Polymerize.LAT), optJSONObject.optDouble("lng"));
                            PoiPart.this.f78708d.add(venue);
                        }
                    }
                    PoiPart poiPart = PoiPart.this;
                    com.tencent.biz.map.poi.c unused = poiPart.W;
                    poiPart.V = poiPart.ea(i16, i3 * 20);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                response.body().close();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.map.poi.PoiPart.18.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiPart.this.W != null) {
                            PoiPart.this.W.f78755m = "";
                            PoiPart.this.W.e(PoiPart.this.f78708d, PoiPart.this.V);
                            PoiPart.this.V9(3);
                            if (PoiPart.this.W.c() == 0 || PoiPart.this.W.c() == -1) {
                                AnonymousClass18 anonymousClass18 = AnonymousClass18.this;
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
        this.X = ca();
    }

    private void oa() {
        com.tencent.biz.map.poi.a.x9("em_location_search_sheet", "dt_imp");
        com.tencent.biz.map.poi.a.x9("em_location_search_bar", "dt_imp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(String str) {
        LatLng ca5 = ca();
        if (ca5 != null) {
            aa(ca5, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        int c16 = this.W.c();
        if (c16 != -1 && this.W.b() != null) {
            if (c16 < this.J.getFirstVisiblePosition() || c16 > this.J.getFirstVisiblePosition() + 2) {
                this.J.setSelection(c16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(int i3) {
        com.tencent.biz.map.poi.b bVar = this.G;
        if (bVar != null) {
            bVar.d2(i3);
        } else {
            QLog.i(getTAG(), 1, "setMapBottom mapViewModel null");
        }
    }

    void V9(int i3) {
        int i16;
        if (this.E != i3 && (i16 = this.F) != i3) {
            if (i3 >= 0 && i3 <= 3 && i16 == 5 && this.U.getText().toString().isEmpty()) {
                W9();
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    this.F = 5;
                                    this.R.setVisibility(8);
                                    this.T.setVisibility(0);
                                    this.K.findViewById(R.id.f110936jv).setVisibility(0);
                                    W9();
                                    na();
                                    return;
                                }
                                return;
                            }
                            this.F = 4;
                            this.R.setVisibility(0);
                            this.T.setVisibility(8);
                            this.K.findViewById(R.id.f110936jv).setVisibility(8);
                            T9();
                            return;
                        }
                        this.N.setVisibility(8);
                        this.P.setVisibility(8);
                        this.Q.setVisibility(8);
                        this.J.setVisibility(0);
                        this.E = 3;
                        return;
                    }
                    this.N.setVisibility(0);
                    this.P.setVisibility(8);
                    this.Q.setVisibility(8);
                    this.J.setVisibility(8);
                    this.E = 2;
                    X9(false);
                    return;
                }
                this.N.setVisibility(8);
                this.P.setVisibility(0);
                this.Q.setVisibility(8);
                this.J.setVisibility(8);
                this.E = 1;
                X9(false);
                return;
            }
            this.E = 0;
            this.N.setVisibility(8);
            this.P.setVisibility(8);
            this.Q.setVisibility(0);
            this.J.setVisibility(8);
            X9(false);
        }
    }

    void W9() {
        this.f78708d.clear();
        this.V = false;
        this.W.e(this.f78708d, false);
        X9(false);
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

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        com.tencent.biz.map.poi.b bVar;
        if (cameraPosition != null && (bVar = this.G) != null) {
            bVar.a2(cameraPosition.target);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(CameraPosition cameraPosition) {
        boolean z16 = true;
        if (cameraPosition == null) {
            QLog.w(getTAG(), 1, "cameraPosition is null");
            return;
        }
        com.tencent.biz.map.poi.b bVar = this.G;
        if (bVar != null) {
            bVar.a2(cameraPosition.target);
        }
        LatLng latLng = this.M;
        if (latLng != null && com.tencent.biz.map.poi.b.S1(latLng, cameraPosition.target) < 2.0d && this.W.getCount() != 0) {
            return;
        }
        this.M = cameraPosition.target;
        if (this.D) {
            this.D = false;
            return;
        }
        com.tencent.biz.map.poi.b bVar2 = this.G;
        if (bVar2 == null || bVar2.T1().getValue().booleanValue()) {
            z16 = false;
        }
        if (z16 && this.F != 5) {
            aa(cameraPosition.target, "");
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

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        if (this.L != null && getContext() != null) {
            if (getContext().getResources().getConfiguration().orientation == 1) {
                this.L.O(0);
            } else {
                this.L.P(0);
            }
        }
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
        oa();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        la(latLng);
        this.L.O(0);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.map.poi.b bVar = this.G;
        if (bVar != null) {
            bVar.P1();
        }
        this.f78708d.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements QUSBaseHalfScreenFloatingView.n {
        h() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onStartDrag() {
            com.tencent.biz.map.poi.a.x9("em_location_search_sheet", "dt_clck");
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onFinishDrag() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f78734d;

        d(View view) {
            this.f78734d = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = editable.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                PoiPart.this.S.setVisibility(0);
                this.f78734d.setVisibility(0);
                PoiPart.this.pa(trim);
            } else {
                PoiPart.this.S.setVisibility(8);
                this.f78734d.setVisibility(8);
                PoiPart poiPart = PoiPart.this;
                if (poiPart.F != 5) {
                    poiPart.pa("");
                } else {
                    poiPart.W9();
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
    /* loaded from: classes2.dex */
    public class f implements AbsListView.OnScrollListener {
        f() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            PoiPart.this.ga();
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}

package com.tencent.biz;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.widgets.d;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.utils.dv;
import com.tencent.mobileqq.utils.ez;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare$DPBiz;
import com.tencent.proto.lbsshare.LBSShare$GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare$LocationResp;
import com.tencent.proto.lbsshare.LBSShare$NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare$POI;
import com.tencent.proto.lbsshare.LBSShare$Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.client.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PoiMapActivity extends QQMapActivity implements d.a {
    EditText A0;
    protected ImageButton B0;
    protected TextView C0;
    protected RelativeLayout D0;
    protected View E0;
    XListView F0;
    protected String G0;
    w M0;
    protected View N0;
    protected int O0;
    protected int P0;
    protected int Q0;
    protected int R0;
    protected int S0;
    protected int T0;
    protected int U0;
    protected String V0;
    protected ImageView Y0;
    protected PoiMapNameTask Z0;

    /* renamed from: a1, reason: collision with root package name */
    protected boolean f78159a1;

    /* renamed from: b0, reason: collision with root package name */
    protected View f78160b0;

    /* renamed from: b1, reason: collision with root package name */
    protected int f78161b1;

    /* renamed from: c0, reason: collision with root package name */
    protected View f78162c0;

    /* renamed from: c1, reason: collision with root package name */
    protected String f78163c1;

    /* renamed from: d0, reason: collision with root package name */
    private View f78164d0;

    /* renamed from: d1, reason: collision with root package name */
    protected String f78165d1;

    /* renamed from: e0, reason: collision with root package name */
    protected v[] f78166e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f78168f0;

    /* renamed from: f1, reason: collision with root package name */
    protected com.tencent.biz.widgets.d f78169f1;

    /* renamed from: g0, reason: collision with root package name */
    protected int f78170g0;

    /* renamed from: g1, reason: collision with root package name */
    protected ImageView f78171g1;

    /* renamed from: h0, reason: collision with root package name */
    protected int f78172h0;

    /* renamed from: h1, reason: collision with root package name */
    private String f78173h1;

    /* renamed from: i0, reason: collision with root package name */
    protected int f78174i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f78176j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f78178k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f78180l0;

    /* renamed from: m0, reason: collision with root package name */
    protected float f78182m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f78184n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f78186o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f78188p0;

    /* renamed from: p1, reason: collision with root package name */
    protected LinearLayout f78189p1;

    /* renamed from: q0, reason: collision with root package name */
    public int f78190q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f78191r0;

    /* renamed from: s0, reason: collision with root package name */
    protected int f78192s0;

    /* renamed from: u0, reason: collision with root package name */
    View f78194u0;

    /* renamed from: v0, reason: collision with root package name */
    LinearLayout f78195v0;

    /* renamed from: z0, reason: collision with root package name */
    protected AuthorizeConfig f78199z0;

    /* renamed from: a0, reason: collision with root package name */
    public final String f78158a0 = "PoiMapActivity";

    /* renamed from: t0, reason: collision with root package name */
    protected boolean f78193t0 = true;

    /* renamed from: w0, reason: collision with root package name */
    protected boolean f78196w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    protected final int f78197x0 = 20;

    /* renamed from: y0, reason: collision with root package name */
    protected boolean f78198y0 = false;
    protected boolean H0 = false;
    protected int I0 = 0;
    protected boolean J0 = false;
    protected boolean K0 = false;
    protected List<s> L0 = new ArrayList();
    protected boolean W0 = true;
    protected boolean X0 = false;

    /* renamed from: e1, reason: collision with root package name */
    protected boolean f78167e1 = true;

    /* renamed from: i1, reason: collision with root package name */
    View.OnTouchListener f78175i1 = new k();

    /* renamed from: j1, reason: collision with root package name */
    View.OnKeyListener f78177j1 = new b();

    /* renamed from: k1, reason: collision with root package name */
    protected AbsListView.OnScrollListener f78179k1 = new c();

    /* renamed from: l1, reason: collision with root package name */
    public View.OnClickListener f78181l1 = new d();

    /* renamed from: m1, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f78183m1 = new e();

    /* renamed from: n1, reason: collision with root package name */
    String[] f78185n1 = {HardCodeUtil.qqStr(R.string.pa8), HardCodeUtil.qqStr(R.string.pa7), HardCodeUtil.qqStr(R.string.pa9), HardCodeUtil.qqStr(R.string.pa5)};

    /* renamed from: o1, reason: collision with root package name */
    String[] f78187o1 = {"", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000"};

    /* loaded from: classes2.dex */
    protected class PoiMapNameTask extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        protected GeoPoint f78210a;

        /* renamed from: b, reason: collision with root package name */
        protected GeoPoint f78211b;

        /* renamed from: c, reason: collision with root package name */
        protected HttpClient f78212c;

        public PoiMapNameTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            String str;
            PoiMapActivity.this.mCurPoiAdr = "Unknown Address";
            for (int i3 = 0; i3 < 3 && !isCancelled() && this.f78211b.getLatitudeE6() == PoiMapActivity.this.f78184n0; i3++) {
                int longitudeE6 = this.f78211b.getLongitudeE6();
                PoiMapActivity poiMapActivity = PoiMapActivity.this;
                if (longitudeE6 != poiMapActivity.f78186o0) {
                    break;
                }
                String a16 = dv.a(poiMapActivity.getApplicationContext(), this.f78211b.getLatitudeE6() / 1000000.0d, this.f78211b.getLongitudeE6() / 1000000.0d, 3, this.f78212c);
                PoiMapActivity.this.z3("rec_locate", "call_googlestation", "", "", "", "");
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i3);
                    sb5.append(" time: ReverseGeocode.getFromLocation, address: ");
                    if (a16 == null) {
                        str = "";
                    } else {
                        str = a16;
                    }
                    sb5.append(str);
                    QLog.i("fetch_address", 2, sb5.toString());
                }
                if (a16 != null && a16.length() > 0) {
                    return a16;
                }
            }
            return "Unknown Address";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            final String str2;
            if (this.f78211b.getLatitudeE6() == PoiMapActivity.this.f78184n0 && this.f78211b.getLongitudeE6() == PoiMapActivity.this.f78186o0) {
                if (TextUtils.isEmpty(str)) {
                    str2 = "Unknown Address";
                } else {
                    str2 = str;
                }
                PoiMapActivity poiMapActivity = PoiMapActivity.this;
                poiMapActivity.mCurPoiAdr = str;
                poiMapActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.PoiMapActivity.PoiMapNameTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PoiMapActivity.this.f78166e0[0].f(str2);
                    }
                });
                if (this.f78210a != null) {
                    PoiMapNameTask poiMapNameTask = new PoiMapNameTask();
                    poiMapNameTask.c(this.f78210a);
                    PoiMapActivity.this.Z0 = poiMapNameTask;
                    poiMapNameTask.execute(new Void[0]);
                    this.f78210a = null;
                }
            }
        }

        public void c(GeoPoint geoPoint) {
            this.f78211b = geoPoint;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            GeoPoint geoPoint = this.f78210a;
            if (geoPoint != null && geoPoint.getLatitudeE6() == PoiMapActivity.this.f78184n0) {
                int longitudeE6 = this.f78210a.getLongitudeE6();
                PoiMapActivity poiMapActivity = PoiMapActivity.this;
                if (longitudeE6 == poiMapActivity.f78186o0) {
                    PoiMapNameTask poiMapNameTask = new PoiMapNameTask();
                    poiMapNameTask.c(this.f78210a);
                    PoiMapActivity.this.Z0 = poiMapNameTask;
                    poiMapNameTask.execute(new Void[0]);
                    this.f78210a = null;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class TabView extends RelativeLayout {

        /* renamed from: d, reason: collision with root package name */
        public TextView f78216d;

        /* renamed from: e, reason: collision with root package name */
        public View f78217e;

        /* renamed from: f, reason: collision with root package name */
        public View f78218f;

        /* renamed from: h, reason: collision with root package name */
        public int f78219h;

        /* renamed from: i, reason: collision with root package name */
        public String f78220i;

        public TabView(Context context, String str, int i3) {
            super(context);
            this.f78219h = i3;
            this.f78220i = str;
            TextView textView = new TextView(context);
            this.f78216d = textView;
            textView.setTextSize(16.0f);
            this.f78216d.setText(str);
            this.f78216d.setTextColor(PoiMapActivity.this.f78168f0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            addView(this.f78216d, layoutParams);
            View view = new View(context);
            this.f78217e = view;
            view.setBackgroundColor(PoiMapActivity.this.f78180l0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, (int) (PoiMapActivity.this.f78182m0 * 3.0f));
            layoutParams2.addRule(12, -1);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f159292zk);
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams2.leftMargin = dimensionPixelSize;
            this.f78217e.setVisibility(4);
            addView(this.f78217e, layoutParams2);
            View view2 = new View(context);
            this.f78218f = view2;
            view2.setBackgroundDrawable(null);
            this.f78218f.setBackgroundResource(PoiMapActivity.this.f78178k0);
            float f16 = PoiMapActivity.this.f78182m0;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (2.0f * f16), (int) (f16 * 20.0f));
            layoutParams3.addRule(15, -1);
            layoutParams3.addRule(11, -1);
            addView(this.f78218f, layoutParams3);
            setOnClickListener(PoiMapActivity.this.f78181l1);
        }

        public void a() {
            this.f78218f.setVisibility(4);
        }

        public void setSelect(boolean z16) {
            if (z16) {
                setContentDescription(this.f78220i + " " + PoiMapActivity.this.getString(R.string.cxe));
                this.f78216d.setTextColor(PoiMapActivity.this.f78170g0);
                this.f78217e.setVisibility(0);
                return;
            }
            setContentDescription(this.f78220i);
            this.f78216d.setTextColor(PoiMapActivity.this.f78168f0);
            this.f78217e.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f78222d;

        a(Dialog dialog) {
            this.f78222d = dialog;
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (QLog.isColorLevel()) {
                QLog.i("PoiMapActivity", 2, "setOnItemClickListener" + i3);
            }
            s sVar = PoiMapActivity.this.L0.get(i3);
            if (sVar != null) {
                PoiMapActivity poiMapActivity = PoiMapActivity.this;
                poiMapActivity.X0 = true;
                poiMapActivity.r3(sVar);
                PoiMapActivity.this.z3("share_locate", "click_sch_result", "", "", "", "");
            }
            this.f78222d.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (66 == i3 && keyEvent.getAction() == 0) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    PoiMapActivity.this.p3(charSequence);
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view instanceof TabView) {
                TabView tabView = (TabView) view;
                PoiMapActivity.this.B3(tabView.f78219h);
                PoiMapActivity.this.s3();
                if (QLog.isDevelopLevel()) {
                    QLog.i("PoiMapActivity", 4, "mTabClickListener" + tabView.f78219h);
                }
                if (((QQMapActivity) PoiMapActivity.this).startWithPos) {
                    PoiMapActivity.this.z3("share_locate", "click_tab" + (tabView.f78219h + 1), "", "", "", "");
                } else {
                    PoiMapActivity poiMapActivity = PoiMapActivity.this;
                    String str = "click_tab" + (tabView.f78219h + 1);
                    PoiMapActivity poiMapActivity2 = PoiMapActivity.this;
                    poiMapActivity.z3("share_locate", str, poiMapActivity2.f78165d1, poiMapActivity2.f78163c1, "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            poiMapActivity.O0 = ((QQMapActivity) poiMapActivity).mapView.getMeasuredHeight();
            PoiMapActivity poiMapActivity2 = PoiMapActivity.this;
            ((QQMapActivity) poiMapActivity2).mPinViewImageHeight = ((QQMapActivity) poiMapActivity2).pinView.getMeasuredHeight();
            PoiMapActivity poiMapActivity3 = PoiMapActivity.this;
            if (poiMapActivity3.O0 > 0 && ((QQMapActivity) poiMapActivity3).mPinViewImageHeight > 0) {
                PoiMapActivity poiMapActivity4 = PoiMapActivity.this;
                poiMapActivity4.C3(((poiMapActivity4.O0 - ((QQMapActivity) poiMapActivity4).mPinViewImageHeight) / 2) + PoiMapActivity.this.U0, false);
                ((QQMapActivity) PoiMapActivity.this).mapView.getViewTreeObserver().removeOnPreDrawListener(this);
                ((QQMapActivity) PoiMapActivity.this).pinView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements ez.f<Integer> {
        f() {
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ez<Integer> ezVar, float f16, Integer num, Transformation transformation) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PoiMapActivity.this.f78162c0.getLayoutParams();
            layoutParams.bottomMargin = PoiMapActivity.this.O0 - num.intValue();
            PoiMapActivity.this.f78162c0.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements ez.f<Integer> {
        h() {
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ez<Integer> ezVar, float f16, Integer num, Transformation transformation) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PoiMapActivity.this.f78164d0.getLayoutParams();
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            layoutParams.bottomMargin = poiMapActivity.Q0 + poiMapActivity.T0;
            poiMapActivity.f78164d0.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements TencentMap.OnMapClickListener {
        j() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
        public void onMapClick(LatLng latLng) {
            PoiMapActivity.this.v3();
        }
    }

    /* loaded from: classes2.dex */
    class k implements View.OnTouchListener {
        k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                PoiMapActivity.this.clickSearchBar();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PoiMapActivity.this.A0.setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f78240d;

        n(Dialog dialog) {
            this.f78240d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f78240d.cancel();
            String obj = PoiMapActivity.this.A0.getText().toString();
            if (obj == null) {
                obj = "";
            }
            PoiMapActivity.this.z3("share_locate", "click_sch_cancel", obj, "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o extends View.AccessibilityDelegate {
        o() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.setVisibleToUser(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f78243d;

        p(Dialog dialog) {
            this.f78243d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f78243d.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class q implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InputMethodManager f78245d;

        q(InputMethodManager inputMethodManager) {
            this.f78245d = inputMethodManager;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f78245d.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class r extends y {

        /* renamed from: i, reason: collision with root package name */
        public String f78247i;

        /* renamed from: j, reason: collision with root package name */
        public String f78248j;

        /* renamed from: k, reason: collision with root package name */
        public String f78249k;

        /* renamed from: l, reason: collision with root package name */
        public String f78250l;

        public r() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public class s {

        /* renamed from: a, reason: collision with root package name */
        public String f78252a;

        /* renamed from: b, reason: collision with root package name */
        public String f78253b;

        /* renamed from: c, reason: collision with root package name */
        public String f78254c;

        /* renamed from: d, reason: collision with root package name */
        public String f78255d;

        /* renamed from: e, reason: collision with root package name */
        public String f78256e;

        /* renamed from: f, reason: collision with root package name */
        public String f78257f;

        /* renamed from: g, reason: collision with root package name */
        public int f78258g;

        /* renamed from: h, reason: collision with root package name */
        public String f78259h;

        /* renamed from: i, reason: collision with root package name */
        public String f78260i;

        /* renamed from: j, reason: collision with root package name */
        public String f78261j;

        /* renamed from: k, reason: collision with root package name */
        public int f78262k;

        /* renamed from: l, reason: collision with root package name */
        public int f78263l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f78264m = false;

        public s() {
        }
    }

    /* loaded from: classes2.dex */
    public class t extends BaseAdapter {

        /* renamed from: i, reason: collision with root package name */
        public boolean f78270i;

        /* renamed from: m, reason: collision with root package name */
        protected TextView f78271m;

        /* renamed from: e, reason: collision with root package name */
        public boolean f78267e = false;

        /* renamed from: f, reason: collision with root package name */
        public int f78268f = -1;

        /* renamed from: h, reason: collision with root package name */
        public int f78269h = 0;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<s> f78266d = new ArrayList<>();

        public t() {
        }

        public void a(ArrayList<s> arrayList, boolean z16, int i3) {
            if (i3 == this.f78269h) {
                this.f78266d.addAll(arrayList);
                this.f78270i = z16;
                this.f78269h++;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public s getItem(int i3) {
            if (this.f78267e) {
                i3++;
            }
            if (i3 < this.f78266d.size() && i3 >= 0) {
                return this.f78266d.get(i3);
            }
            return null;
        }

        public void c(boolean z16) {
            this.f78267e = z16;
            notifyDataSetChanged();
        }

        public void d(int i3, boolean z16) {
            s item;
            if (i3 < this.f78266d.size() && i3 != this.f78268f) {
                this.f78268f = i3;
                notifyDataSetChanged();
                if (i3 == -1 || !z16 || (item = getItem(i3)) == null) {
                    return;
                }
                PoiMapActivity poiMapActivity = PoiMapActivity.this;
                poiMapActivity.mCurPoiName = item.f78252a;
                poiMapActivity.mCurPoiAdr = item.f78253b;
                ((QQMapActivity) poiMapActivity).mDianpingId = item.f78257f;
                PoiMapActivity poiMapActivity2 = PoiMapActivity.this;
                poiMapActivity2.f78191r0 = item.f78254c;
                poiMapActivity2.f78188p0 = item.f78262k;
                poiMapActivity2.f78190q0 = item.f78263l;
                ((QQMapActivity) poiMapActivity2).mapView.b();
                ((QQMapActivity) PoiMapActivity.this).tencentMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(item.f78262k / 1000000.0d, item.f78263l / 1000000.0d)));
            }
        }

        public void e(String str) {
            if (!this.f78267e && this.f78271m != null && !TextUtils.isEmpty(str)) {
                this.f78271m.setText(str);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f78267e) {
                return (this.f78266d.size() - 1) + (this.f78270i ? 1 : 0);
            }
            return this.f78266d.size() + (this.f78270i ? 1 : 0);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            u uVar;
            String str;
            View view3 = null;
            if (view == null) {
                uVar = new u();
                View inflate = LayoutInflater.from(PoiMapActivity.this).inflate(R.layout.a3x, (ViewGroup) null);
                uVar.f78275d = inflate.findViewById(R.id.iqq);
                uVar.f78276e = (ImageView) inflate.findViewById(R.id.iqp);
                uVar.f78273b = (TextView) inflate.findViewById(R.id.f5p);
                uVar.f78274c = (TextView) inflate.findViewById(R.id.f164040i7);
                uVar.f78280i = inflate.findViewById(R.id.f166843im3);
                uVar.f78281j = inflate.findViewById(R.id.f0b);
                uVar.f78272a = inflate.findViewById(R.id.bhd);
                uVar.f78277f = (ImageView) inflate.findViewById(R.id.iqo);
                uVar.f78278g = (ImageView) inflate.findViewById(R.id.k2f);
                uVar.f78279h = (ImageView) inflate.findViewById(R.id.f166662h25);
                inflate.setTag(uVar);
                view2 = inflate;
            } else {
                view2 = view;
                uVar = (u) view.getTag();
            }
            if (i3 != this.f78266d.size() && (!this.f78267e || i3 != this.f78266d.size() - 1)) {
                s item = getItem(i3);
                if (i3 == 0 && !this.f78267e) {
                    this.f78271m = uVar.f78274c;
                }
                if (item != null) {
                    uVar.f78281j.setVisibility(8);
                    uVar.f78276e.setImageDrawable(null);
                    uVar.f78275d.setVisibility(8);
                    uVar.f78272a.setVisibility(0);
                    uVar.f78272a.setBackgroundDrawable(null);
                    uVar.f78272a.setBackgroundResource(PoiMapActivity.this.f78174i0);
                    uVar.f78273b.setText(item.f78252a);
                    uVar.f78274c.setText(item.f78253b);
                    String str2 = item.f78252a + item.f78253b;
                    if (i3 == this.f78268f) {
                        uVar.f78273b.setTextColor(PoiMapActivity.this.f78180l0);
                        uVar.f78274c.setTextColor(PoiMapActivity.this.f78180l0);
                        uVar.f78280i.setVisibility(0);
                        str = str2 + PoiMapActivity.this.getString(R.string.cxe);
                    } else {
                        uVar.f78273b.setTextColor(PoiMapActivity.this.f78170g0);
                        uVar.f78274c.setTextColor(PoiMapActivity.this.f78168f0);
                        uVar.f78280i.setVisibility(4);
                        str = str2 + PoiMapActivity.this.getString(R.string.cxf);
                    }
                    view2.setContentDescription(str);
                }
                EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
                return view3;
            }
            uVar.f78281j.setVisibility(0);
            uVar.f78272a.setVisibility(8);
            view3 = view2;
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view3;
        }
    }

    /* loaded from: classes2.dex */
    public class u {

        /* renamed from: a, reason: collision with root package name */
        public View f78272a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f78273b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f78274c;

        /* renamed from: d, reason: collision with root package name */
        public View f78275d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f78276e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f78277f;

        /* renamed from: g, reason: collision with root package name */
        public ImageView f78278g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f78279h;

        /* renamed from: i, reason: collision with root package name */
        public View f78280i;

        /* renamed from: j, reason: collision with root package name */
        public View f78281j;

        public u() {
        }
    }

    /* loaded from: classes2.dex */
    public class w extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        protected LayoutInflater f78299d;

        public w(Context context) {
            this.f78299d = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            List<s> list = poiMapActivity.L0;
            if (list == null) {
                return 0;
            }
            if (poiMapActivity.H0) {
                return list.size() + 1;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<s> list = PoiMapActivity.this.L0;
            if (list == null) {
                return null;
            }
            return list.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            u uVar;
            if (view == null) {
                uVar = new u();
                View inflate = LayoutInflater.from(PoiMapActivity.this).inflate(R.layout.a3x, (ViewGroup) null);
                uVar.f78273b = (TextView) inflate.findViewById(R.id.f5p);
                uVar.f78274c = (TextView) inflate.findViewById(R.id.f164040i7);
                View findViewById = inflate.findViewById(R.id.f166843im3);
                uVar.f78280i = findViewById;
                findViewById.setVisibility(4);
                uVar.f78281j = inflate.findViewById(R.id.f0b);
                uVar.f78272a = inflate.findViewById(R.id.bhd);
                uVar.f78275d = inflate.findViewById(R.id.iqq);
                inflate.setTag(uVar);
                view2 = inflate;
            } else {
                view2 = view;
                uVar = (u) view.getTag();
            }
            uVar.f78275d.setVisibility(8);
            if (i3 == PoiMapActivity.this.L0.size()) {
                uVar.f78281j.setVisibility(0);
                uVar.f78272a.setVisibility(8);
            } else {
                uVar.f78281j.setVisibility(8);
                uVar.f78272a.setVisibility(0);
                s sVar = (s) getItem(i3);
                if (sVar != null) {
                    uVar.f78273b.setText(sVar.f78252a);
                    uVar.f78274c.setText(sVar.f78253b);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class y {

        /* renamed from: a, reason: collision with root package name */
        public int f78302a;

        /* renamed from: b, reason: collision with root package name */
        public String f78303b;

        /* renamed from: c, reason: collision with root package name */
        public String f78304c;

        /* renamed from: d, reason: collision with root package name */
        public String f78305d;

        /* renamed from: e, reason: collision with root package name */
        public String f78306e;

        /* renamed from: f, reason: collision with root package name */
        public int f78307f;

        /* renamed from: g, reason: collision with root package name */
        public int f78308g;

        public y() {
        }
    }

    /* loaded from: classes2.dex */
    public class z extends y {

        /* renamed from: i, reason: collision with root package name */
        public String f78310i;

        /* renamed from: j, reason: collision with root package name */
        public int f78311j;

        /* renamed from: k, reason: collision with root package name */
        public String f78312k;

        /* renamed from: l, reason: collision with root package name */
        public String f78313l;

        public z() {
            super();
        }
    }

    protected void A3(String str, List<s> list, boolean z16) {
        List<s> list2 = this.L0;
        if (list2 == null) {
            this.L0 = new ArrayList();
        } else {
            if (this.I0 == 0) {
                list2.clear();
            }
            if (list != null && list.size() > 0) {
                this.L0.addAll(list);
                if (this.startWithPos) {
                    z3("share_locate", "click_sch", str, "0", "", "");
                } else {
                    z3("share_locate", "click_sch", str, "0", this.f78165d1, this.f78163c1);
                }
            } else if (this.startWithPos) {
                z3("share_locate", "click_sch", str, "1", "", "");
            } else {
                z3("share_locate", "click_sch", str, "1", this.f78165d1, this.f78163c1);
            }
        }
        this.H0 = z16;
        this.K0 = false;
        if (this.L0.isEmpty()) {
            this.C0.setText(getString(R.string.h_i));
            this.C0.setVisibility(0);
        } else {
            this.C0.setVisibility(8);
            this.F0.setVisibility(0);
        }
        this.M0.notifyDataSetChanged();
    }

    public void B3(int i3) {
        v[] vVarArr = this.f78166e0;
        if (vVarArr != null && i3 < vVarArr.length) {
            this.f78192s0 = i3;
            int length = vVarArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                if (i16 == i3) {
                    this.f78166e0[i16].c(true);
                    this.f78166e0[i16].e(true);
                } else {
                    this.f78166e0[i16].c(false);
                }
            }
        }
    }

    protected void C3(int i3, boolean z16) {
        ImageView imageView = ((QQMapActivity) this).pinView;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            if (z16) {
                layoutParams.topMargin += i3;
            } else {
                layoutParams.topMargin = i3;
            }
            ((QQMapActivity) this).pinView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void backCall() {
        if (this.startWithPos) {
            z3("rec_locate", "click_rec_return", "", "", "", "");
        } else {
            z3("share_locate", "click_rec_return", this.f78165d1, this.f78163c1, "", "");
        }
    }

    void clickSearchBar() {
        this.X0 = false;
        ReportDialog reportDialog = new ReportDialog(this);
        reportDialog.setCanceledOnTouchOutside(true);
        final InputMethodManager inputMethodManager = (InputMethodManager) super.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        int height = this.f78194u0.getHeight();
        float f16 = -height;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.f78195v0.startAnimation(translateAnimation);
        reportDialog.requestWindowFeature(1);
        reportDialog.getWindow().setSoftInputMode(36);
        reportDialog.setContentView(R.layout.bxb);
        WindowManager.LayoutParams attributes = reportDialog.getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 51;
        reportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        final TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
        translateAnimation2.setDuration(300L);
        l lVar = new l(translateAnimation, reportDialog, height, translateAnimation2);
        translateAnimation.setAnimationListener(lVar);
        translateAnimation2.setAnimationListener(lVar);
        reportDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.PoiMapActivity.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ((QQMapActivity) PoiMapActivity.this).mapView.setEnabled(false);
                PoiMapActivity.this.f78195v0.getHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.PoiMapActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        PoiMapActivity poiMapActivity = PoiMapActivity.this;
                        poiMapActivity.f78196w0 = false;
                        poiMapActivity.f78195v0.startAnimation(translateAnimation2);
                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                        inputMethodManager.hideSoftInputFromWindow(PoiMapActivity.this.getWindow().peekDecorView().getWindowToken(), 0);
                    }
                }, 150L);
            }
        });
        this.E0 = reportDialog.findViewById(R.id.root);
        EditText editText = (EditText) reportDialog.findViewById(R.id.et_search_keyword);
        this.A0 = editText;
        editText.addTextChangedListener(new x());
        this.A0.setSelection(0);
        this.A0.requestFocus();
        this.A0.setOnKeyListener(this.f78177j1);
        ImageButton imageButton = (ImageButton) reportDialog.findViewById(R.id.ib_clear_text);
        this.B0 = imageButton;
        imageButton.setOnClickListener(new m());
        Button button = (Button) reportDialog.findViewById(R.id.btn_cancel_search);
        button.setVisibility(0);
        button.setOnClickListener(new n(reportDialog));
        this.C0 = (TextView) reportDialog.findViewById(R.id.f166412fa0);
        RelativeLayout relativeLayout = (RelativeLayout) reportDialog.findViewById(R.id.result_layout);
        this.D0 = relativeLayout;
        relativeLayout.setAccessibilityDelegate(new o());
        this.D0.setOnClickListener(new p(reportDialog));
        XListView xListView = (XListView) reportDialog.findViewById(R.id.searchList);
        this.F0 = xListView;
        xListView.setBackgroundDrawable(super.getResources().getDrawable(R.drawable.bg_texture));
        this.F0.setDividerHeight(0);
        this.L0.clear();
        w wVar = new w(this);
        this.M0 = wVar;
        this.F0.setAdapter((ListAdapter) wVar);
        this.F0.setOnScrollListener(this.f78179k1);
        this.F0.setOnTouchListener(new q(inputMethodManager));
        this.F0.setOnItemClickListener(new a(reportDialog));
        if (1 == HttpUtil.getNetWorkType()) {
            this.J0 = true;
        } else {
            this.J0 = false;
        }
        this.f78196w0 = true;
        com.tencent.biz.widgets.d.e("search", t3());
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity, com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQMapActivity
    public Intent getLocationData() {
        super.getLocationData();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        QQMapView qQMapView = ((QQMapActivity) this).mapView;
        if (qQMapView != null && qQMapView.getMap() != null && ((QQMapActivity) this).mapView.getMap().getCameraPosition() != null && ((QQMapActivity) this).mapView.getMap().getCameraPosition().target != null) {
            LatLng latLng = ((QQMapActivity) this).mapView.getMap().getCameraPosition().target;
            bundle.putString("latitude", String.valueOf(latLng.getLatitude()));
            bundle.putString("longitude", String.valueOf(latLng.getLongitude()));
        }
        bundle.putString("poiId", this.f78191r0);
        bundle.putBoolean("isForien", this.f78159a1);
        bundle.putInt("isArk", this.f78161b1);
        bundle.putString("description", this.location);
        bundle.putString("latSpan", String.valueOf(this.f78184n0));
        bundle.putString("lngSpan", String.valueOf(this.f78186o0));
        if (TextUtils.isEmpty(this.mCurPoiName) || this.mCurPoiName.equals(getString(R.string.cxc))) {
            this.mCurPoiName = getString(R.string.f171093c61);
        }
        if (TextUtils.isEmpty(this.mCurPoiAdr)) {
            this.mCurPoiAdr = "Unknown Address";
        }
        bundle.putString("title", this.mCurPoiName);
        bundle.putString("summary", this.mCurPoiAdr);
        bundle.putString("dianping_id", this.mDianpingId);
        intent.putExtras(bundle);
        return intent;
    }

    public void initView() {
        this.f78195v0 = (LinearLayout) super.findViewById(R.id.grq);
        this.f78160b0 = super.findViewById(R.id.iir);
        this.f78162c0 = super.findViewById(R.id.fw9);
        this.f78164d0 = super.findViewById(R.id.lru);
        ImageView imageView = (ImageView) super.findViewById(R.id.fwd);
        this.f78171g1 = imageView;
        imageView.setContentDescription(getString(R.string.cxg));
        this.f78171g1.setVisibility(0);
        this.f78171g1.setOnClickListener(this);
        if (this.startWithPos) {
            z3("rec_locate", "pageview_all", "", "", "", "");
            this.f78160b0.setVisibility(8);
            this.f78162c0.setVisibility(8);
            this.mRouteBar.setVisibility(0);
            this.mRouteBtn.setOnClickListener(this);
            if (!TextUtils.isEmpty(this.mCurPoiName)) {
                this.mAddrTxt.setText(this.mCurPoiName);
                this.mAddrTxt.setVisibility(0);
            } else {
                this.mAddrTxt.setVisibility(8);
            }
            this.mDetailAddrTxt.setText(this.loc);
            ((QQMapActivity) this).mapView.getMap().getUiSettings().setLogoPosition(2);
        } else {
            this.f78160b0.setVisibility(0);
            this.f78162c0.setVisibility(0);
            this.mRouteBar.setVisibility(8);
            w3();
            if (!QQMapActivity.REQUEST_FROM_TROOP_ACTIVITY.equals(this.f78173h1)) {
                ((QQMapActivity) this).mapView.getMap().setOnMapClickListener(new j());
                View findViewById = this.f78162c0.findViewById(R.id.fwf);
                this.N0 = findViewById;
                findViewById.setOnClickListener(this);
            }
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f78164d0.getLayoutParams();
        layoutParams.bottomMargin = this.P0 + this.Q0;
        this.f78164d0.setLayoutParams(layoutParams);
        this.f78194u0 = super.findViewById(R.id.title);
        this.Y0 = (ImageView) super.findViewById(R.id.cki);
        super.findViewById(R.id.btn_cancel_search).setVisibility(8);
        EditText editText = (EditText) this.f78160b0.findViewById(R.id.et_search_keyword);
        editText.setFocusable(false);
        editText.setOnTouchListener(this.f78175i1);
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected boolean isNeedDestroyBoradcast() {
        return this.f78167e1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void jumpToStreetViewMapReport() {
        z3("rec_locate", "click_view", "", "", "", "");
    }

    @Override // com.tencent.mobileqq.mini.out.activity.MapActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.fwd) {
            if (this.startWithPos) {
                if (this.mSelfGeoPoint != null) {
                    addSelfLay();
                    TencentMap tencentMap = this.tencentMap;
                    if (tencentMap != null) {
                        tencentMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(this.mSelfGeoPoint.getLatitudeE6() / 1000000.0d, this.mSelfGeoPoint.getLongitudeE6() / 1000000.0d)));
                    }
                } else {
                    getMyLocation(true);
                }
            } else {
                getMyLocation(true);
            }
            if (this.startWithPos) {
                z3("rec_locate", "click_locate_rec", "", "", "", "");
            } else {
                z3("share_locate", "click_locate_share", "", "", "", "");
            }
            this.f78171g1.setImageResource(R.drawable.qb_coupon_location_press);
        } else if (id5 == R.id.fwf) {
            if (!this.f78193t0) {
                s3();
            }
        } else if (id5 == R.id.ifj) {
            GeoPoint geoPoint = new GeoPoint((int) (this.latitude * 1000000.0d), (int) (this.longitude * 1000000.0d));
            if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            } else {
                this.f78169f1.m(this, this.mSelfGeoPoint, geoPoint, this.mSelfPoiName, this.mCurPoiName);
            }
            com.tencent.biz.widgets.d.d("navigation_click");
            com.tencent.biz.widgets.d.j("click_navig", "0");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity, com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = ThemeUtil.getCurrentThemeInfo().getString("themeId");
        this.f78168f0 = super.getResources().getColor(R.color.skin_gray2);
        this.f78170g0 = super.getResources().getColor(R.color.skin_black);
        this.f78174i0 = R.drawable.skin_list_item_normal;
        this.f78176j0 = R.drawable.common_list_item_background;
        this.f78178k0 = R.drawable.qb_troup_group_divide_line;
        if ("1103".equals(string)) {
            this.f78172h0 = super.getResources().getColor(R.color.f157421p1);
        } else {
            this.f78172h0 = super.getResources().getColor(R.color.f157420p0);
        }
        this.f78180l0 = Color.rgb(0, 121, 255);
        this.f78182m0 = super.getResources().getDisplayMetrics().density;
        this.f78167e1 = getIntent().getBooleanExtra("is_need_destroy_broadcast", true);
        this.f78173h1 = getIntent().getStringExtra("key_from");
        com.tencent.biz.widgets.d dVar = new com.tencent.biz.widgets.d(this);
        this.f78169f1 = dVar;
        dVar.l(this);
        x3();
        initView();
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void onFetchDataSuceeded() {
        super.onFetchDataSuceeded();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01f3  */
    @Override // com.tencent.mobileqq.activity.QQMapActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onGetLbsShareSearch(LBSShare$LocationResp lBSShare$LocationResp, Bundle bundle) {
        boolean z16;
        final ArrayList arrayList;
        final boolean z17;
        final int i3;
        int i16;
        String string;
        String str;
        String str2;
        int i17;
        int i18;
        ArrayList arrayList2;
        int i19;
        int i26;
        String str3;
        String str4;
        int i27;
        int i28;
        String str5;
        String str6;
        String str7;
        int i29;
        String str8;
        String str9;
        String str10;
        String str11;
        s sVar;
        String str12;
        ArrayList arrayList3;
        ArrayList arrayList4;
        BlockingQueue<Runnable> queue;
        if (lBSShare$LocationResp == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch null");
                return;
            }
            return;
        }
        int i36 = lBSShare$LocationResp.f342181ec.get();
        int i37 = 0;
        if (lBSShare$LocationResp.is_foreign.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f78159a1 = z16;
        this.f78161b1 = lBSShare$LocationResp.is_ark.get();
        final String string2 = bundle.getString("keyword");
        final int i38 = bundle.getInt("latitude");
        final int i39 = bundle.getInt("longitude");
        final int i46 = bundle.getInt("page");
        final String string3 = bundle.getString("category");
        this.f78163c1 = bundle.getString("imei");
        this.f78165d1 = lBSShare$LocationResp.search_id.get();
        if (i36 != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch error:" + i36);
            }
            QQToast.makeText(this, super.getString(R.string.c0y), 0).show();
        }
        if (i36 == 0) {
            ArrayList arrayList5 = new ArrayList();
            String str13 = "";
            if (this.f78159a1) {
                GeoPoint geoPoint = new GeoPoint(i38, i39);
                PoiMapNameTask poiMapNameTask = this.Z0;
                if (poiMapNameTask == null) {
                    try {
                        PoiMapNameTask poiMapNameTask2 = new PoiMapNameTask();
                        this.Z0 = poiMapNameTask2;
                        poiMapNameTask2.c(geoPoint);
                        this.Z0.execute(new Void[0]);
                    } catch (RejectedExecutionException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PoiMapActivity", 2, e16.getMessage());
                        }
                    }
                } else {
                    poiMapNameTask.f78210a = geoPoint;
                    if (PlatformUtil.version() >= 11 && (queue = ((ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR).getQueue()) != null && queue.size() > 0) {
                        queue.removeAll(queue);
                    }
                    if (this.Z0.getStatus() != AsyncTask.Status.FINISHED) {
                        if (!this.Z0.isCancelled()) {
                            this.Z0.cancel(true);
                        }
                    } else {
                        try {
                            PoiMapNameTask poiMapNameTask3 = new PoiMapNameTask();
                            poiMapNameTask3.c(geoPoint);
                            this.Z0 = poiMapNameTask3;
                            poiMapNameTask3.execute(new Void[0]);
                        } catch (RejectedExecutionException e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PoiMapActivity", 2, e17.getMessage());
                            }
                        }
                    }
                }
                s sVar2 = new s();
                sVar2.f78252a = super.getResources().getString(R.string.cxc);
                sVar2.f78253b = "";
                this.mCurPoiAdr = "";
                sVar2.f78262k = i38;
                sVar2.f78263l = i39;
                sVar2.f78255d = "";
                arrayList5.add(sVar2);
            } else if (lBSShare$LocationResp.mylbs.has()) {
                LBSShare$POI lBSShare$POI = lBSShare$LocationResp.mylbs.get();
                s sVar3 = new s();
                if (lBSShare$POI.name.has()) {
                    string = lBSShare$POI.name.get();
                } else {
                    string = super.getResources().getString(R.string.cxc);
                }
                sVar3.f78252a = string;
                if (!lBSShare$POI.shop_url.has()) {
                    str = "";
                } else {
                    str = lBSShare$POI.shop_url.get();
                }
                sVar3.f78255d = str;
                if (!lBSShare$POI.addr.has()) {
                    str2 = "";
                } else {
                    str2 = lBSShare$POI.addr.get();
                }
                sVar3.f78253b = str2;
                if (lBSShare$POI.lat.has()) {
                    i17 = lBSShare$POI.lat.get();
                } else {
                    i17 = 0;
                }
                sVar3.f78262k = i17;
                if (lBSShare$POI.lng.has()) {
                    i18 = lBSShare$POI.lng.get();
                } else {
                    i18 = 0;
                }
                sVar3.f78263l = i18;
                if (this.f78198y0 && !TextUtils.isEmpty(this.mCurPoiName)) {
                    sVar3.f78252a = this.mCurPoiName;
                    sVar3.f78255d = "";
                    sVar3.f78253b = this.mCurPoiAdr;
                    sVar3.f78262k = this.f78184n0;
                    sVar3.f78263l = this.f78186o0;
                } else {
                    sVar3.f78252a = super.getResources().getString(R.string.cxc);
                    this.mCurPoiAdr = sVar3.f78253b;
                }
                arrayList5.add(sVar3);
            } else {
                i16 = 0;
                if (!lBSShare$LocationResp.poilist.has()) {
                    List<LBSShare$POI> list = lBSShare$LocationResp.poilist.get();
                    if (list.size() > 0) {
                        i26 = 1;
                    } else {
                        i26 = 0;
                    }
                    i19 = i26;
                    for (LBSShare$POI lBSShare$POI2 : list) {
                        s sVar4 = new s();
                        if (lBSShare$POI2.name.has()) {
                            str3 = lBSShare$POI2.name.get();
                        } else {
                            str3 = str13;
                        }
                        sVar4.f78252a = str3;
                        if (lBSShare$POI2.addr.has()) {
                            str4 = lBSShare$POI2.addr.get();
                        } else {
                            str4 = str13;
                        }
                        sVar4.f78253b = str4;
                        if (lBSShare$POI2.lat.has()) {
                            i27 = lBSShare$POI2.lat.get();
                        } else {
                            i27 = 0;
                        }
                        sVar4.f78262k = i27;
                        if (lBSShare$POI2.lng.has()) {
                            i28 = lBSShare$POI2.lng.get();
                        } else {
                            i28 = 0;
                        }
                        sVar4.f78263l = i28;
                        if (lBSShare$POI2.f342183id.has()) {
                            str5 = lBSShare$POI2.f342183id.get();
                        } else {
                            str5 = str13;
                        }
                        sVar4.f78254c = str5;
                        if (QQMapActivity.REQUEST_FROM_TROOP_ACTIVITY.equals(this.f78173h1)) {
                            sVar4.f78255d = str13;
                            sVar4.f78256e = str13;
                            sVar4.f78258g = 0;
                            sVar4.f78259h = str13;
                            sVar4.f78260i = str13;
                            sVar4.f78261j = str13;
                            sVar4.f78257f = str13;
                        } else {
                            if (lBSShare$POI2.shop_url.has()) {
                                str6 = lBSShare$POI2.shop_url.get();
                            } else {
                                str6 = str13;
                            }
                            sVar4.f78255d = str6;
                            if (lBSShare$POI2.shop_url_quan.has()) {
                                str7 = lBSShare$POI2.shop_url_quan.get();
                            } else {
                                str7 = str13;
                            }
                            sVar4.f78256e = str7;
                            if (lBSShare$POI2.shop_count.has()) {
                                i29 = lBSShare$POI2.shop_count.get();
                            } else {
                                i29 = 0;
                            }
                            sVar4.f78258g = i29;
                            if (lBSShare$POI2.shangquan_url.has()) {
                                str8 = lBSShare$POI2.shangquan_url.get();
                            } else {
                                str8 = str13;
                            }
                            sVar4.f78259h = str8;
                            if (lBSShare$POI2.shangquan_wording.has()) {
                                str9 = lBSShare$POI2.shangquan_wording.get();
                            } else {
                                str9 = str13;
                            }
                            sVar4.f78260i = str9;
                            if (lBSShare$POI2.POI_preview_url.has()) {
                                str10 = lBSShare$POI2.POI_preview_url.get();
                            } else {
                                str10 = str13;
                            }
                            sVar4.f78261j = str10;
                            if (lBSShare$POI2.dpid.has()) {
                                str11 = lBSShare$POI2.dpid.get();
                            } else {
                                str11 = str13;
                            }
                            sVar4.f78257f = str11;
                        }
                        if (!TextUtils.isEmpty(sVar4.f78255d)) {
                            sVar = sVar4;
                            str12 = str13;
                            arrayList3 = arrayList5;
                            z3("share_locate", "view_share_tuan", "", "", "", "");
                        } else {
                            sVar = sVar4;
                            str12 = str13;
                            arrayList3 = arrayList5;
                        }
                        if (TextUtils.isEmpty(sVar.f78255d) && !TextUtils.isEmpty(sVar.f78256e)) {
                            z3("share_locate", "view_quan", "", "", "", "");
                        }
                        if (this.f78198y0 && !TextUtils.isEmpty(this.V0) && this.V0.equals(sVar.f78254c)) {
                            if (!arrayList3.isEmpty()) {
                                arrayList4 = arrayList3;
                                s sVar5 = (s) arrayList4.get(0);
                                if (this.mCurPoiName.equals(sVar5.f78252a) && this.mCurPoiAdr.equals(sVar5.f78253b)) {
                                    arrayList4.remove(0);
                                }
                            } else {
                                arrayList4 = arrayList3;
                            }
                            arrayList4.add(0, sVar);
                        } else {
                            arrayList4 = arrayList3;
                            arrayList4.add(sVar);
                        }
                        arrayList5 = arrayList4;
                        str13 = str12;
                    }
                    arrayList2 = arrayList5;
                    i16 = i26;
                } else {
                    arrayList2 = arrayList5;
                    i19 = 0;
                }
                if (lBSShare$LocationResp.next.has()) {
                    i37 = lBSShare$LocationResp.next.get();
                }
                arrayList = arrayList2;
                i3 = i37;
                z17 = i19;
                i37 = i16;
            }
            i16 = 1;
            if (!lBSShare$LocationResp.poilist.has()) {
            }
            if (lBSShare$LocationResp.next.has()) {
            }
            arrayList = arrayList2;
            i3 = i37;
            z17 = i19;
            i37 = i16;
        } else {
            arrayList = null;
            z17 = 0;
            i3 = 0;
        }
        final boolean z18 = i37 ^ 1;
        runOnUiThread(new Runnable() { // from class: com.tencent.biz.PoiMapActivity.13
            @Override // java.lang.Runnable
            public void run() {
                PoiMapActivity poiMapActivity = PoiMapActivity.this;
                boolean z19 = true;
                if (poiMapActivity.f78159a1) {
                    if (z17) {
                        poiMapActivity.z3("rec_locate", "call_foursquare", "", "", "", "");
                        QLog.d("PoiMapActivity", 1, "hasPoiListForFoursquareFinal: true");
                        PoiMapActivity.this.Y0.setVisibility(8);
                    } else {
                        poiMapActivity.Y0.setVisibility(8);
                    }
                    LinearLayout linearLayout = PoiMapActivity.this.f78189p1;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    if (!string3.equals(PoiMapActivity.this.f78187o1[0])) {
                        PoiMapActivity poiMapActivity2 = PoiMapActivity.this;
                        poiMapActivity2.f78192s0 = 0;
                        poiMapActivity2.f78166e0[0].e(true);
                    }
                } else {
                    poiMapActivity.Y0.setVisibility(8);
                    LinearLayout linearLayout2 = PoiMapActivity.this.f78189p1;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                }
                if (!TextUtils.isEmpty(string2)) {
                    if (string2.equals(PoiMapActivity.this.G0)) {
                        PoiMapActivity poiMapActivity3 = PoiMapActivity.this;
                        String str14 = string2;
                        ArrayList arrayList6 = arrayList;
                        if (i3 <= 0) {
                            z19 = false;
                        }
                        poiMapActivity3.A3(str14, arrayList6, z19);
                        return;
                    }
                    return;
                }
                PoiMapActivity.this.y3(arrayList, i38, i39, string3, i3, i46, z18);
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void onGetLbsShareShop(LBSShare$NearByShopsResp lBSShare$NearByShopsResp, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3;
        int i16;
        if (lBSShare$NearByShopsResp == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PoiMapActivity", 2, "onGetLbsShareShop null");
                return;
            }
            return;
        }
        int i17 = lBSShare$NearByShopsResp.f342182ec.get();
        if (i17 == 0) {
            bundle.getInt("begin", 0);
            if (lBSShare$NearByShopsResp.next_begin.has()) {
                lBSShare$NearByShopsResp.next_begin.get();
            }
            if (lBSShare$NearByShopsResp.total.has()) {
                lBSShare$NearByShopsResp.total.get();
            }
            if (lBSShare$NearByShopsResp.poilist.has()) {
                ArrayList arrayList = new ArrayList();
                for (LBSShare$Shop lBSShare$Shop : lBSShare$NearByShopsResp.poilist.get()) {
                    r rVar = new r();
                    rVar.f78302a = 1;
                    String str8 = "";
                    if (!lBSShare$Shop.f342184id.has()) {
                        str = "";
                    } else {
                        str = lBSShare$Shop.f342184id.get();
                    }
                    rVar.f78306e = str;
                    if (!lBSShare$Shop.name.has()) {
                        str2 = "";
                    } else {
                        str2 = lBSShare$Shop.name.get();
                    }
                    rVar.f78303b = str2;
                    if (!lBSShare$Shop.logo.has()) {
                        str3 = "";
                    } else {
                        str3 = lBSShare$Shop.logo.get();
                    }
                    rVar.f78304c = str3;
                    if (!lBSShare$Shop.url.has()) {
                        str4 = "";
                    } else {
                        str4 = lBSShare$Shop.url.get();
                    }
                    rVar.f78305d = str4;
                    if (!lBSShare$Shop.detail.has()) {
                        str5 = "";
                    } else {
                        str5 = lBSShare$Shop.detail.get();
                    }
                    rVar.f78247i = str5;
                    if (!lBSShare$Shop.discount.has()) {
                        str6 = "";
                    } else {
                        str6 = lBSShare$Shop.discount.get();
                    }
                    rVar.f78248j = str6;
                    if (!lBSShare$Shop.price.has()) {
                        str7 = "";
                    } else {
                        str7 = lBSShare$Shop.price.get();
                    }
                    rVar.f78249k = str7;
                    if (lBSShare$Shop.soldnum.has()) {
                        str8 = lBSShare$Shop.soldnum.get();
                    }
                    rVar.f78250l = str8;
                    if (lBSShare$Shop.has_tuan.has()) {
                        i3 = lBSShare$Shop.has_tuan.get();
                    } else {
                        i3 = 0;
                    }
                    rVar.f78307f = i3;
                    if (lBSShare$Shop.has_quan.has()) {
                        i16 = lBSShare$Shop.has_quan.get();
                    } else {
                        i16 = 0;
                    }
                    rVar.f78308g = i16;
                    arrayList.add(rVar);
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PoiMapActivity", 2, "onGetLbsShareShop error:" + i17);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void onGetShareShopDetail(LBSShare$GetShopsByIdsResp lBSShare$GetShopsByIdsResp) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i3;
        int i16;
        if (lBSShare$GetShopsByIdsResp == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PoiMapActivity", 2, "onGetShareShopDetail null");
                return;
            }
            return;
        }
        int i17 = lBSShare$GetShopsByIdsResp.f342180ec.get();
        if (i17 == 0) {
            if (lBSShare$GetShopsByIdsResp.shops.has()) {
                ArrayList arrayList = new ArrayList();
                for (LBSShare$DPBiz lBSShare$DPBiz : lBSShare$GetShopsByIdsResp.shops.get()) {
                    z zVar = new z();
                    zVar.f78302a = 1;
                    String str7 = "";
                    if (!lBSShare$DPBiz.f342179id.has()) {
                        str = "";
                    } else {
                        str = lBSShare$DPBiz.f342179id.get();
                    }
                    zVar.f78306e = str;
                    if (!lBSShare$DPBiz.name.has()) {
                        str2 = "";
                    } else {
                        str2 = lBSShare$DPBiz.name.get();
                    }
                    zVar.f78303b = str2;
                    if (!lBSShare$DPBiz.logo.has()) {
                        str3 = "";
                    } else {
                        str3 = lBSShare$DPBiz.logo.get();
                    }
                    zVar.f78304c = str3;
                    if (!lBSShare$DPBiz.url.has()) {
                        str4 = "";
                    } else {
                        str4 = lBSShare$DPBiz.url.get();
                    }
                    zVar.f78305d = str4;
                    if (!lBSShare$DPBiz.avg_price.has()) {
                        str5 = "";
                    } else {
                        str5 = lBSShare$DPBiz.avg_price.get();
                    }
                    zVar.f78312k = str5;
                    if (!lBSShare$DPBiz.biz_zone.has()) {
                        str6 = "";
                    } else {
                        str6 = lBSShare$DPBiz.biz_zone.get();
                    }
                    zVar.f78313l = str6;
                    if (lBSShare$DPBiz.category.has()) {
                        str7 = lBSShare$DPBiz.category.get();
                    }
                    zVar.f78310i = str7;
                    int i18 = 0;
                    if (lBSShare$DPBiz.has_quan.has()) {
                        i3 = lBSShare$DPBiz.has_quan.get();
                    } else {
                        i3 = 0;
                    }
                    zVar.f78308g = i3;
                    if (lBSShare$DPBiz.has_tuan.has()) {
                        i16 = lBSShare$DPBiz.has_tuan.get();
                    } else {
                        i16 = 0;
                    }
                    zVar.f78307f = i16;
                    if (lBSShare$DPBiz.rate.has()) {
                        i18 = lBSShare$DPBiz.rate.get();
                    }
                    zVar.f78311j = i18;
                    arrayList.add(zVar);
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PoiMapActivity", 2, "onGetShareShopDetail error:" + i17);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity, com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.widget.QQMapView.b
    public void onMapScrollEnd(GeoPoint geoPoint) {
        super.onMapScrollEnd(geoPoint);
        if (!this.startWithPos) {
            z3("share_locate", "drag_location", this.f78165d1, this.f78163c1, "", "");
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity, com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.widget.QQMapView.b
    public void onMapScrollStart(GeoPoint geoPoint) {
        this.f78171g1.setImageResource(R.drawable.qb_coupon_location_nor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if ("key_from_aio".equals(this.f78173h1)) {
            ee2.d.a("aio");
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if ("key_from_aio".equals(this.f78173h1)) {
            ee2.d.b("aio");
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void onTroopActivityCallback() {
        super.onTroopActivityCallback();
        String str = "{\"id\":\"" + this.f78191r0 + "\",\"title\":\"" + this.mCurPoiName + "\",\"address\":\"" + this.mCurPoiAdr + "\",\"location\":{\"lat\":\"" + ((this.f78188p0 * 1.0f) / 1000000.0d) + "\",\"lon\":\"" + ((this.f78190q0 * 1.0f) / 1000000.0d) + "\"}}";
        Intent intent = new Intent();
        intent.putExtra("result", str);
        setResult(-1, intent);
        finish();
    }

    protected void p3(String str) {
        this.F0.setVisibility(8);
        this.C0.setVisibility(0);
        this.C0.setText(getString(R.string.cx_));
        this.G0 = str;
        this.I0 = 0;
        this.H0 = false;
        this.K0 = false;
        u3(this.f78184n0, this.f78186o0, str, "", 0, 20);
        this.M0.notifyDataSetChanged();
    }

    protected void r3(s sVar) {
        this.mCurPoiAdr = sVar.f78253b;
        this.mCurPoiName = sVar.f78252a;
        String str = sVar.f78254c;
        this.V0 = str;
        int i3 = sVar.f78262k;
        this.f78184n0 = i3;
        int i16 = sVar.f78263l;
        this.f78186o0 = i16;
        this.f78188p0 = i3;
        this.f78190q0 = i16;
        this.mDianpingId = sVar.f78257f;
        this.f78191r0 = str;
        this.f78198y0 = true;
        int length = this.f78166e0.length;
        for (int i17 = 0; i17 < length; i17++) {
            if (i17 == 0) {
                this.f78166e0[0].f78290h.c(false);
                this.f78166e0[0].a(0, false);
            } else {
                this.f78166e0[i17].a(-1, false);
            }
        }
        B3(0);
        this.tencentMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(sVar.f78262k / 1000000.0d, sVar.f78263l / 1000000.0d)));
    }

    protected void s3() {
        if (!this.f78193t0 && this.P0 > 0 && this.O0 > 0) {
            ez ezVar = new ez(Integer.valueOf(this.O0 + this.P0), Integer.valueOf(this.O0), new f());
            ezVar.setDuration(200L);
            ezVar.setFillAfter(true);
            ezVar.setAnimationListener(new g());
            this.mQQMapLayout.startAnimation(ezVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void sendSuccessCall() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (((QQMapActivity) this).mapView.getMap() == null || ((QQMapActivity) this).mapView.getMap().getCameraPosition() == null || ((QQMapActivity) this).mapView.getMap().getCameraPosition().target == null) {
            str = "";
            str2 = str;
        } else {
            LatLng latLng = ((QQMapActivity) this).mapView.getMap().getCameraPosition().target;
            String valueOf = String.valueOf(latLng.getLatitude());
            str = String.valueOf(latLng.getLongitude());
            str2 = valueOf;
        }
        String str6 = str2 + "," + str + "," + this.f78165d1 + "," + this.f78163c1;
        if (TextUtils.isEmpty(this.f78191r0)) {
            str3 = "0";
        } else {
            str3 = this.f78191r0;
        }
        String str7 = str3;
        String str8 = (this.f78192s0 + 1) + "";
        if (this.f78166e0[this.f78192s0].f78290h.f78267e) {
            str4 = "2";
        } else {
            str4 = "1";
        }
        z3("share_locate", "click_send", str6, str7, str8, str4);
        if (this.f78159a1) {
            z3("rec_locate", "send_googlestation", "", "", "", "");
            z3("rec_locate", "send_foursquare", "", "", "", "");
        }
        Intent intent = getIntent();
        if (intent.getIntExtra("uintype", 0) == 1008) {
            Intent intent2 = new Intent(IPublicAccountManager.PA_ACTION_LOCATION_RESULT);
            intent2.putExtra("latitude", str2);
            intent2.putExtra("longitude", str);
            intent2.putExtra("name", this.mCurPoiAdr);
            sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
        }
        int intExtra = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 1);
        if (intExtra == 1) {
            str5 = VipFunCallConstants.KEY_GROUP;
        } else if (intExtra == 0) {
            str5 = "person";
        } else if (intExtra == 3000) {
            str5 = "disc_group";
        } else {
            str5 = "other";
        }
        com.tencent.biz.widgets.d.f("send_location", t3(), str5);
    }

    protected String t3() {
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType != 1) {
            if (netWorkType != 2) {
                if (netWorkType != 3) {
                    if (netWorkType != 4) {
                        return "others";
                    }
                    return QADNetStatus.G_4;
                }
                return QADNetStatus.G_3;
            }
            return QADNetStatus.G_2;
        }
        return com.tencent.mobileqq.msf.core.x.q.f250391w;
    }

    protected void u3(int i3, int i16, String str, String str2, int i17, int i18) {
        Intent intent = new Intent("com.tencent.mobileqq.getLbsShareSearch");
        intent.putExtra("latitude", i3);
        intent.putExtra("longitude", i16);
        intent.putExtra("keyword", str);
        intent.putExtra("category", str2);
        intent.putExtra("page", i17);
        intent.putExtra("count", i18);
        intent.putExtra("coordinate", 1);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_QQMAP, 2, "getSearchDataFromServer:lat=" + i3 + ",lon=" + i16 + ",keyword=" + str + ",category=" + str2 + ",page=" + i17 + ",count=" + i18);
        }
        if (i17 == 0 && TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                intent.putExtra("requireMyLbs", 1);
            }
        } else {
            intent.putExtra("requireMyLbs", 0);
        }
        super.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void updateLocationAddress(GeoPoint geoPoint) {
        int latitudeE6 = geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint.getLongitudeE6();
        if (this.f78184n0 == latitudeE6 && this.f78186o0 == longitudeE6) {
            return;
        }
        super.updateLocationAddress(geoPoint);
        if (QLog.isColorLevel()) {
            QLog.d("PoiMapActivity", 2, "lat=" + latitudeE6 + ", lon=" + longitudeE6);
        }
        this.mCurPoiName = "";
        this.f78184n0 = latitudeE6;
        this.f78186o0 = longitudeE6;
        this.f78188p0 = latitudeE6;
        this.f78190q0 = longitudeE6;
        this.f78198y0 = false;
        int length = this.f78166e0.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 == 0) {
                this.f78166e0[0].f78290h.c(false);
                if (this.W0) {
                    this.f78166e0[0].a(-1, false);
                } else {
                    this.f78166e0[0].a(0, false);
                }
            } else {
                this.f78166e0[i3].a(-1, true);
            }
        }
        this.f78166e0[this.f78192s0].e(true);
    }

    protected void v3() {
        if (this.f78193t0 && this.P0 > 0 && this.O0 > 0) {
            ez ezVar = new ez(Integer.valueOf(this.O0), Integer.valueOf(this.O0 + this.P0), new h());
            ezVar.setDuration(200L);
            ezVar.setFillAfter(true);
            ezVar.setAnimationListener(new i());
            this.mQQMapLayout.startAnimation(ezVar);
        }
    }

    public void w3() {
        this.P0 = super.getResources().getDimensionPixelSize(R.dimen.f159291zj);
        this.Q0 = super.getResources().getDimensionPixelSize(R.dimen.b7h);
        this.T0 = super.getResources().getDimensionPixelSize(R.dimen.f159294zm);
        this.U0 = super.getResources().getDimensionPixelSize(R.dimen.f159293zl);
        this.R0 = super.getResources().getDimensionPixelSize(R.dimen.f159286ze);
        this.S0 = super.getResources().getDimensionPixelSize(R.dimen.f159287zf);
        this.f78189p1 = (LinearLayout) super.findViewById(R.id.fwh);
        this.f78162c0.setBackgroundColor(this.f78172h0);
        this.f78189p1.setBackgroundDrawable(null);
        this.f78189p1.setBackgroundResource(this.f78174i0);
        if (this.isChangeToGoogleMap) {
            this.f78189p1.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mQQMapLayout.getLayoutParams();
            layoutParams.weight = 1.0f;
            this.mQQMapLayout.setLayoutParams(layoutParams);
        }
        FrameLayout frameLayout = (FrameLayout) super.findViewById(R.id.fwb);
        this.f78166e0 = new v[this.f78185n1.length];
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        int length = this.f78185n1.length;
        for (int i3 = 0; i3 < length; i3++) {
            v vVar = new v(this, this.f78185n1[i3], i3);
            if (i3 == 0) {
                vVar.c(true);
                vVar.f78290h.f78268f = 0;
            }
            if (i3 == length - 1) {
                vVar.f78288f.a();
            }
            this.f78166e0[i3] = vVar;
            this.f78189p1.addView(vVar.f78288f, layoutParams2);
            frameLayout.addView(vVar.f78289g, layoutParams3);
        }
        QQMapView qQMapView = ((QQMapActivity) this).mapView;
        if (qQMapView != null) {
            qQMapView.getViewTreeObserver().addOnPreDrawListener(this.f78183m1);
        }
        ImageView imageView = ((QQMapActivity) this).pinView;
        if (imageView != null) {
            imageView.getViewTreeObserver().addOnPreDrawListener(this.f78183m1);
        }
    }

    protected void x3() {
        JSONArray jSONArray;
        AuthorizeConfig y16 = AuthorizeConfig.y();
        this.f78199z0 = y16;
        String x16 = y16.x("poi_category", "");
        if (!TextUtils.isEmpty(x16)) {
            try {
                jSONArray = new JSONArray(x16);
            } catch (JSONException e16) {
                e16.printStackTrace();
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                String[] strArr = new String[length];
                String[] strArr2 = new String[length];
                boolean z16 = false;
                for (int i3 = 0; i3 < length; i3++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        String string = jSONObject.getString("name");
                        String string2 = jSONObject.getString("id");
                        strArr[i3] = string;
                        strArr2[i3] = string2;
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                        z16 = true;
                    }
                }
                if (!z16) {
                    this.f78185n1 = strArr;
                    this.f78187o1 = strArr2;
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("PoiMapActivity", 4, "mTabName:" + this.f78185n1.toString());
        }
    }

    public void y3(ArrayList<s> arrayList, int i3, int i16, String str, int i17, int i18, boolean z16) {
        boolean z17;
        if (this.f78184n0 != i3 && this.f78186o0 != i16) {
            return;
        }
        int length = this.f78166e0.length;
        for (int i19 = 0; i19 < length; i19++) {
            if (this.f78187o1[i19].equals(str)) {
                v vVar = this.f78166e0[i19];
                if (i17 != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                vVar.b(arrayList, z17, i18, z16);
                if (i19 == 0 && this.W0) {
                    if (arrayList != null && arrayList.size() > 1) {
                        this.f78166e0[0].a(0, true);
                        if (!this.startWithPos) {
                            z3("share_locate", "pageview_all", this.f78165d1, this.f78163c1, "", "");
                            return;
                        }
                        return;
                    }
                    this.f78166e0[0].a(0, true);
                    return;
                }
                return;
            }
        }
    }

    protected void z3(String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", str, str2, 0, 0, str3, str4, str5, str6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Animation.AnimationListener {
        g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PoiMapActivity.this.f78164d0.getLayoutParams();
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            layoutParams.bottomMargin = poiMapActivity.P0 + poiMapActivity.Q0;
            poiMapActivity.f78164d0.setLayoutParams(layoutParams);
            View view = PoiMapActivity.this.N0;
            if (view != null && view.getVisibility() != 8) {
                PoiMapActivity.this.N0.setVisibility(8);
            }
            ((QQMapActivity) PoiMapActivity.this).mQQMapLayout.clearAnimation();
            PoiMapActivity.this.f78193t0 = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements Animation.AnimationListener {
        i() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (((QQMapActivity) PoiMapActivity.this).mapView != null) {
                ((QQMapActivity) PoiMapActivity.this).mapView.getMap().getUiSettings().setLogoPositionWithMargin(0, 0, 0, 0, 0);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PoiMapActivity.this.f78162c0.getLayoutParams();
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            layoutParams.bottomMargin = -poiMapActivity.P0;
            poiMapActivity.f78162c0.setLayoutParams(layoutParams);
            View view = PoiMapActivity.this.N0;
            if (view != null && view.getVisibility() != 0) {
                PoiMapActivity.this.N0.setVisibility(0);
            }
            ((QQMapActivity) PoiMapActivity.this).mQQMapLayout.clearAnimation();
            PoiMapActivity.this.f78193t0 = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f78234d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Dialog f78235e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f78236f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f78237h;

        l(TranslateAnimation translateAnimation, Dialog dialog, int i3, TranslateAnimation translateAnimation2) {
            this.f78234d = translateAnimation;
            this.f78235e = dialog;
            this.f78236f = i3;
            this.f78237h = translateAnimation2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PoiMapActivity.this.f78195v0.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ((QQMapActivity) PoiMapActivity.this).mQQMapLayout.getLayoutParams();
            ViewGroup.LayoutParams layoutParams3 = ((QQMapActivity) PoiMapActivity.this).mapView.getLayoutParams();
            if (animation == this.f78234d) {
                this.f78235e.show();
                int height = PoiMapActivity.this.f78195v0.getHeight();
                int i3 = this.f78236f;
                layoutParams.height = height + i3;
                PoiMapActivity.this.C3(i3 / 2, true);
            } else if (animation == this.f78237h) {
                int height2 = PoiMapActivity.this.f78195v0.getHeight();
                int i16 = this.f78236f;
                layoutParams.height = height2 - i16;
                PoiMapActivity.this.C3((-i16) / 2, true);
            }
            layoutParams2.height = -1;
            layoutParams3.height = -1;
            ((QQMapActivity) PoiMapActivity.this).mapView.setLayoutParams(layoutParams3);
            ((QQMapActivity) PoiMapActivity.this).mQQMapLayout.setLayoutParams(layoutParams2);
            PoiMapActivity.this.f78195v0.setLayoutParams(layoutParams);
            ((QQMapActivity) PoiMapActivity.this).mapView.setEnabled(true);
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            if (poiMapActivity.X0 && animation == this.f78237h) {
                poiMapActivity.s3();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    public class v {

        /* renamed from: a, reason: collision with root package name */
        final int f78283a = 1;

        /* renamed from: b, reason: collision with root package name */
        final int f78284b = 2;

        /* renamed from: c, reason: collision with root package name */
        final int f78285c = 3;

        /* renamed from: d, reason: collision with root package name */
        final int f78286d = 4;

        /* renamed from: e, reason: collision with root package name */
        public TextView f78287e;

        /* renamed from: f, reason: collision with root package name */
        public TabView f78288f;

        /* renamed from: g, reason: collision with root package name */
        public XListView f78289g;

        /* renamed from: h, reason: collision with root package name */
        public t f78290h;

        /* renamed from: i, reason: collision with root package name */
        public int f78291i;

        /* renamed from: j, reason: collision with root package name */
        public int f78292j;

        /* renamed from: k, reason: collision with root package name */
        public int f78293k;

        /* loaded from: classes2.dex */
        class a implements AdapterView.OnItemClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PoiMapActivity f78295d;

            a(PoiMapActivity poiMapActivity) {
                this.f78295d = poiMapActivity;
            }

            @Override // com.tencent.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                v.this.a(i3, true);
                int length = PoiMapActivity.this.f78166e0.length;
                for (int i16 = 0; i16 < length; i16++) {
                    v vVar = v.this;
                    if (vVar.f78291i != i16) {
                        PoiMapActivity.this.f78166e0[i16].a(-1, false);
                    }
                }
            }
        }

        public v(Context context, String str, int i3) {
            this.f78291i = i3;
            TextView textView = (TextView) ((PoiMapActivity) context).findViewById(R.id.fwc);
            this.f78287e = textView;
            textView.setTextColor(PoiMapActivity.this.f78168f0);
            this.f78288f = new TabView(context, str, i3);
            this.f78289g = new XListView(context);
            t tVar = new t();
            this.f78290h = tVar;
            this.f78289g.setAdapter((ListAdapter) tVar);
            this.f78289g.setDivider(null);
            this.f78289g.setVisibility(4);
            this.f78289g.setOnItemClickListener(new a(PoiMapActivity.this));
            this.f78289g.setOnScrollListener(new b(PoiMapActivity.this));
        }

        public void a(int i3, boolean z16) {
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            if (poiMapActivity.f78198y0) {
                this.f78290h.d(i3, z16);
                return;
            }
            if (this.f78291i == 0 && i3 > 0 && !this.f78290h.f78267e && poiMapActivity.W0) {
                poiMapActivity.W0 = false;
            }
            this.f78290h.d(i3, z16);
        }

        public void b(ArrayList<s> arrayList, boolean z16, int i3, boolean z17) {
            if (z17) {
                d(3);
                return;
            }
            if (arrayList == null) {
                d(1);
                return;
            }
            this.f78290h.a(arrayList, z16, i3);
            if (PoiMapActivity.this.f78192s0 == this.f78291i) {
                this.f78289g.setVisibility(0);
                d(4);
            }
        }

        public void c(boolean z16) {
            if (z16) {
                if (this.f78290h.getCount() > 0) {
                    this.f78289g.setVisibility(0);
                    d(4);
                }
            } else {
                this.f78289g.setVisibility(4);
            }
            this.f78288f.setSelect(z16);
        }

        public void d(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.f78287e.setVisibility(8);
                            return;
                        }
                        return;
                    } else {
                        this.f78287e.setVisibility(0);
                        this.f78287e.setText(PoiMapActivity.this.getString(R.string.cxb));
                        return;
                    }
                }
                this.f78287e.setVisibility(0);
                this.f78287e.setText(PoiMapActivity.this.getString(R.string.cx_));
                return;
            }
            this.f78287e.setVisibility(0);
            this.f78287e.setText(PoiMapActivity.this.getString(R.string.c0y));
        }

        public void e(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("PoiMapActivity", 2, "POI list update isfirst = " + z16);
            }
            int i3 = this.f78292j;
            PoiMapActivity poiMapActivity = PoiMapActivity.this;
            if (i3 != poiMapActivity.f78184n0 || this.f78293k != poiMapActivity.f78186o0 || !z16) {
                if (z16) {
                    d(2);
                    this.f78289g.setVisibility(4);
                    this.f78290h.f78266d.clear();
                    t tVar = this.f78290h;
                    tVar.f78269h = 0;
                    tVar.f78270i = false;
                    tVar.notifyDataSetChanged();
                }
                PoiMapActivity poiMapActivity2 = PoiMapActivity.this;
                poiMapActivity2.u3(poiMapActivity2.f78184n0, poiMapActivity2.f78186o0, "", poiMapActivity2.f78187o1[this.f78288f.f78219h], this.f78290h.f78269h, 20);
                PoiMapActivity poiMapActivity3 = PoiMapActivity.this;
                this.f78292j = poiMapActivity3.f78184n0;
                this.f78293k = poiMapActivity3.f78186o0;
            }
        }

        public void f(String str) {
            this.f78290h.e(str);
        }

        /* loaded from: classes2.dex */
        class b implements AbsListView.OnScrollListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PoiMapActivity f78297d;

            b(PoiMapActivity poiMapActivity) {
                this.f78297d = poiMapActivity;
            }

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i3) {
                if (i3 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    v vVar = v.this;
                    if (vVar.f78290h.f78270i) {
                        vVar.e(false);
                        if (!((QQMapActivity) PoiMapActivity.this).startWithPos) {
                            PoiMapActivity poiMapActivity = PoiMapActivity.this;
                            poiMapActivity.z3("share_locate", "turn_page", poiMapActivity.f78165d1, poiMapActivity.f78163c1, "", "");
                        }
                    }
                }
            }

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("PoiMapActivity", 4, "onScrollStateChanged");
                }
                PoiMapActivity poiMapActivity = PoiMapActivity.this;
                if (!poiMapActivity.K0 && poiMapActivity.H0) {
                    poiMapActivity.K0 = true;
                    poiMapActivity.I0++;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("PoiMapActivity", 4, "onScrollStateChanged mSearchPage:" + PoiMapActivity.this.I0);
                    }
                    PoiMapActivity poiMapActivity2 = PoiMapActivity.this;
                    poiMapActivity2.u3(poiMapActivity2.f78184n0, poiMapActivity2.f78186o0, poiMapActivity2.G0, "", poiMapActivity2.I0, 20);
                }
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class x implements TextWatcher {
        protected x() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = PoiMapActivity.this.A0.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                PoiMapActivity.this.B0.setVisibility(8);
                PoiMapActivity.this.F0.setVisibility(8);
                PoiMapActivity.this.L0.clear();
                PoiMapActivity.this.M0.notifyDataSetChanged();
                return;
            }
            PoiMapActivity.this.B0.setVisibility(0);
            PoiMapActivity.this.p3(trim);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

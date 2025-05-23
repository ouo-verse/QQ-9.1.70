package com.tencent.biz.pubaccount.ecshopassit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.BrowserTitleBar;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.PerfTracer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ShopWebViewFragment extends WebViewFragment implements DragFrameLayout.b {
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    int G;
    public List<RecentShopParcel> H;
    EcshopCacheTool I;
    DragFrameLayout K;
    SwipListView L;
    public com.tencent.biz.pubaccount.ecshopassit.b M;
    int P;
    int Q;
    View R;
    ImageView S;
    TextView T;
    ImageView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public ImageView Y;
    public ViewGroup Z;

    /* renamed from: c0, reason: collision with root package name */
    RedTouch f79617c0;
    String[] J = new String[4];
    int N = 0;

    /* renamed from: a0, reason: collision with root package name */
    BroadcastReceiver f79615a0 = new d();

    /* renamed from: b0, reason: collision with root package name */
    SosoInterfaceOnLocationListener f79616b0 = new e(0, true, false, 600000, false, false, "ecshop");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ShopWebViewFragment shopWebViewFragment = ShopWebViewFragment.this;
            EcshopCacheTool ecshopCacheTool = shopWebViewFragment.I;
            if (ecshopCacheTool != null) {
                ecshopCacheTool.g(shopWebViewFragment.getQBaseActivity(), ShopWebViewFragment.this.J[0]);
                try {
                    ShopWebViewFragment.this.I.f79584f.H2(134248548, null, null, null, null, 0L, false);
                } catch (Exception unused) {
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f79619d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f79620e;

        b(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f79619d = jSONObject;
            this.f79620e = jSONObject2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int y16 = (int) (ShopWebViewFragment.this.P - motionEvent.getY());
                        ShopWebViewFragment.this.P = (int) motionEvent.getY();
                        if (y16 < 0) {
                            ShopWebViewFragment shopWebViewFragment = ShopWebViewFragment.this;
                            if (shopWebViewFragment.Q > 0) {
                                shopWebViewFragment.Q = 0;
                            }
                        }
                        if (y16 > 0) {
                            ShopWebViewFragment shopWebViewFragment2 = ShopWebViewFragment.this;
                            if (shopWebViewFragment2.Q < 0) {
                                shopWebViewFragment2.Q = 0;
                            }
                        }
                        ShopWebViewFragment.this.Q += y16;
                    }
                } else {
                    try {
                        this.f79619d.put("y_offset", ShopWebViewFragment.this.Q);
                        String jsScript = WebViewPlugin.toJsScript(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, this.f79619d, this.f79620e);
                        if (((WebViewFragment) ShopWebViewFragment.this).webView != null) {
                            ((WebViewFragment) ShopWebViewFragment.this).webView.callJs(jsScript);
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            } else {
                ShopWebViewFragment.this.P = (int) motionEvent.getY();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c extends com.tencent.mobileqq.webview.swift.proxy.a {
        c(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitTitleBar(Bundle bundle) {
            ImageView imageView;
            super.onInitTitleBar(bundle);
            ShopWebViewFragment shopWebViewFragment = ShopWebViewFragment.this;
            shopWebViewFragment.Z = shopWebViewFragment.getSwiftTitleUI().M;
            ShopWebViewFragment shopWebViewFragment2 = ShopWebViewFragment.this;
            shopWebViewFragment2.V = shopWebViewFragment2.getSwiftTitleUI().f314054i;
            ShopWebViewFragment shopWebViewFragment3 = ShopWebViewFragment.this;
            shopWebViewFragment3.W = shopWebViewFragment3.getSwiftTitleUI().f314059m;
            ShopWebViewFragment shopWebViewFragment4 = ShopWebViewFragment.this;
            shopWebViewFragment4.X = shopWebViewFragment4.getSwiftTitleUI().C;
            ShopWebViewFragment shopWebViewFragment5 = ShopWebViewFragment.this;
            shopWebViewFragment5.Y = shopWebViewFragment5.getSwiftTitleUI().E;
            ShopWebViewFragment.this.Ba();
            if (((WebViewFragment) ShopWebViewFragment.this).mNightMode) {
                if (((WebViewFragment) ShopWebViewFragment.this).webView != null) {
                    ((WebViewFragment) ShopWebViewFragment.this).webView.setMask(false);
                }
                ShopWebViewFragment shopWebViewFragment6 = ShopWebViewFragment.this;
                if (shopWebViewFragment6.R == null) {
                    shopWebViewFragment6.R = new View(ShopWebViewFragment.this.getActivity());
                    ShopWebViewFragment.this.R.setBackgroundColor(1996488704);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    ShopWebViewFragment shopWebViewFragment7 = ShopWebViewFragment.this;
                    shopWebViewFragment7.contentView.addView(shopWebViewFragment7.R, layoutParams);
                }
                ShopWebViewFragment.this.R.bringToFront();
            }
            ShopWebViewFragment shopWebViewFragment8 = ShopWebViewFragment.this;
            if (shopWebViewFragment8.C && (imageView = shopWebViewFragment8.U) != null && shopWebViewFragment8.Y != null) {
                imageView.refreshDrawableState();
                ShopWebViewFragment.this.Y.refreshDrawableState();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.tencent.biz.pubaccount.ecshopassit.b bVar;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("uin");
            Bitmap bitmap = (Bitmap) intent.getParcelableExtra(MimeHelper.IMAGE_SUBTYPE_BITMAP);
            if ("action_decode_finish".equals(action)) {
                if (ShopWebViewFragment.this.I != null && !TextUtils.isEmpty(stringExtra) && bitmap != null) {
                    ShopWebViewFragment.this.I.i(stringExtra, bitmap);
                }
                com.tencent.biz.pubaccount.ecshopassit.b bVar2 = ShopWebViewFragment.this.M;
                if (bVar2 != null) {
                    bVar2.c(stringExtra);
                    return;
                }
                return;
            }
            if ("action_on_shop_msg_receive".equals(action)) {
                ShopWebViewFragment.this.H = intent.getParcelableArrayListExtra("datas");
                QBaseActivity qBaseActivity = ShopWebViewFragment.this.getQBaseActivity();
                if (qBaseActivity instanceof EcshopWebActivity) {
                    ((EcshopWebActivity) qBaseActivity).f79598b0 = ShopWebViewFragment.this.H;
                }
                String stringExtra2 = intent.getStringExtra("uin");
                for (RecentShopParcel recentShopParcel : ShopWebViewFragment.this.H) {
                    if (!TextUtils.isEmpty(recentShopParcel.f79609d) && recentShopParcel.f79609d.equals(stringExtra2)) {
                        recentShopParcel.C++;
                    }
                }
                ShopWebViewFragment shopWebViewFragment = ShopWebViewFragment.this;
                if (shopWebViewFragment.N == 1 && (bVar = shopWebViewFragment.M) != null) {
                    bVar.e(shopWebViewFragment.H);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class e extends SosoInterfaceOnLocationListener {
        e(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
            super(i3, z16, z17, j3, z18, z19, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (ShopWebViewFragment.this.getAppRuntime() != null && ShopWebViewFragment.this.H != null && i3 == 0 && sosoLbsInfo != null) {
                ArrayList arrayList = new ArrayList();
                for (RecentShopParcel recentShopParcel : ShopWebViewFragment.this.H) {
                    if (recentShopParcel.D != 1) {
                        try {
                            arrayList.add(Long.valueOf(Long.valueOf(recentShopParcel.f79609d).longValue()));
                        } catch (Exception unused) {
                        }
                    }
                    while (r9.hasNext()) {
                    }
                }
                SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                double d16 = sosoLocation.mLat02;
                double d17 = sosoLocation.mLon02;
                ShopWebViewFragment shopWebViewFragment = ShopWebViewFragment.this;
                EcshopCacheTool ecshopCacheTool = shopWebViewFragment.I;
                if (ecshopCacheTool != null) {
                    ecshopCacheTool.e(shopWebViewFragment.getAppRuntime(), arrayList, d17, d16);
                }
            }
        }
    }

    void Ba() {
        this.S = new FadeIconImageView(getQBaseActivity());
        this.T = new TextView(getQBaseActivity());
        if (!this.C) {
            this.W.setText(HardCodeUtil.qqStr(R.string.tfs));
            this.V.setVisibility(8);
            this.S.setId(R.id.f165972dz1);
            this.S.setOnClickListener(this);
            this.S.setImageResource(R.drawable.b6q);
            RelativeLayout relativeLayout = (RelativeLayout) this.Z.findViewById(R.id.f166810ie2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.leftMargin = BaseAIOUtils.f(10.0f, getResources());
            relativeLayout.addView(this.S, layoutParams);
            this.T.setId(R.id.k4f);
            this.T.setOnClickListener(this);
            this.T.setTextColor(getResources().getColor(R.color.f158017al3));
            this.T.setTextSize(1, 17.0f);
            this.T.setBackgroundResource(R.drawable.c0a);
            this.T.setGravity(17);
            int f16 = BaseAIOUtils.f(3.0f, getResources());
            int f17 = BaseAIOUtils.f(4.0f, getResources());
            this.T.setPadding(f16, 0, f16, 0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(15);
            layoutParams2.addRule(1, R.id.f165972dz1);
            layoutParams2.leftMargin = f17;
            relativeLayout.addView(this.T, layoutParams2);
        } else {
            int f18 = BaseAIOUtils.f(30.0f, getResources());
            FadeIconImageView fadeIconImageView = new FadeIconImageView(getQBaseActivity());
            this.U = fadeIconImageView;
            fadeIconImageView.setId(R.id.dsr);
            this.U.setScaleType(ImageView.ScaleType.CENTER);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f18, f18);
            layoutParams3.addRule(1, R.id.ivTitleBtnRightImage);
            ((RelativeLayout) this.Y.getParent()).addView(this.U, layoutParams3);
        }
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_checked}, new int[]{android.R.attr.state_selected}, new int[0]};
        if (this.E) {
            if (!this.C) {
                this.Z.setBackgroundResource(R.drawable.gvl);
                this.W.setTextColor(getResources().getColorStateList(R.color.ads));
                this.X.setTextColor(new ColorStateList(iArr, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1}));
                SystemBarActivityModule.setStatusBarBlue(getQBaseActivity());
            }
        } else if (this.webViewSurface.n() && ImmersiveUtils.isSupporImmersive() == 1) {
            if (getWebTitleBarInterface().a3() != null) {
                if (getUIStyle() != null && getUIStyle().T != null) {
                    getWebTitleBarInterface().a3().setBackgroundColor(getUIStyle().T.f313797d);
                    SimpleUIUtil.adjustColorForQQBrowserActivity(true, getUIStyle().T.f313797d, getHostActivity().getWindow());
                } else {
                    getWebTitleBarInterface().a3().setBackgroundColor(getResources().getColor(R.color.skin_color_title_immersive_bar));
                    SimpleUIUtil.adjustColorForQQBrowserActivity(false, getResources().getColor(R.color.skin_color_title_immersive_bar), getHostActivity().getWindow());
                }
            } else {
                getWebTitleBarInterface().Ad(false);
            }
        }
        if (this.C) {
            this.Z.setBackgroundResource(0);
            this.Z.setBackgroundColor(-1);
            ImmersiveUtils.setStatusBarDarkMode(getActivity().getWindow(), true);
            if (getWebTitleBarInterface().a3() != null) {
                getWebTitleBarInterface().a3().setBackgroundResource(R.drawable.b8c);
            }
            int[] iArr2 = {HWColorFormat.COLOR_FormatVendorStartUnused, HWColorFormat.COLOR_FormatVendorStartUnused, HWColorFormat.COLOR_FormatVendorStartUnused, -16777216};
            int f19 = BaseAIOUtils.f(3.0f, getResources());
            ColorStateList colorStateList = new ColorStateList(iArr, iArr2);
            this.W.setTextColor(colorStateList);
            this.V.setTextColor(colorStateList);
            this.V.setBackgroundResource(R.drawable.glf);
            this.Y.setVisibility(0);
            this.U.setVisibility(0);
            this.Y.setPadding(f19, f19, f19, f19);
            this.U.setPadding(f19, f19, f19, f19);
            this.U.setImageDrawable(BaseImageUtil.getBtnSelector(R.drawable.fni, getQBaseActivity()));
            this.Y.setImageDrawable(BaseImageUtil.getBtnSelector(R.drawable.fnj, getQBaseActivity()));
            this.Y.setOnClickListener(this);
            this.U.setOnClickListener(this);
            ((RelativeLayout.LayoutParams) this.Y.getLayoutParams()).rightMargin = BaseAIOUtils.f(4.0f, getResources());
        } else {
            this.X.setText(HardCodeUtil.qqStr(R.string.tft));
            this.X.setVisibility(0);
            this.X.setOnClickListener(this);
        }
        xh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public boolean doOnCreate(Bundle bundle) {
        if (!this.C) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
            this.webViewSurface.x(new View(super.getActivity()));
            getWebTitleBarInterface().a3().setId(R.id.j1z);
            getWebTitleBarInterface().a3().setBackgroundResource(R.drawable.skin_header_bar_bg);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, statusBarHeight);
            layoutParams.addRule(10, -1);
            this.contentView.addView(getWebTitleBarInterface().a3(), layoutParams);
            this.contentView.addView(new BrowserTitleBar(requireContext()));
            ViewGroup viewGroup = (ViewGroup) this.contentView.findViewById(R.id.rlCommenTitle);
            this.Z = viewGroup;
            viewGroup.setBackgroundResource(R.drawable.skin_header_bar_bg);
            ((RelativeLayout.LayoutParams) this.Z.getLayoutParams()).topMargin = statusBarHeight;
            TextView textView = (TextView) this.Z.findViewById(R.id.ivTitleBtnLeft);
            this.V = textView;
            textView.setOnClickListener(this);
            this.W = (TextView) this.Z.findViewById(R.id.ivTitleName);
            this.X = (TextView) this.Z.findViewById(R.id.ivTitleBtnRightText);
            this.Y = (ImageView) this.Z.findViewById(R.id.ivTitleBtnRightImage);
            this.X.setOnClickListener(this);
            this.Y.setOnClickListener(this);
            View findViewById = this.Z.findViewById(R.id.ews);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Ba();
            return true;
        }
        return super.doOnCreate(bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new c(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        RecentShopParcel recentShopParcel;
        if (this.K.getMode() == -1 && qUIBadgeDragLayout.getDragView() != null && qUIBadgeDragLayout.getDragView().getId() == R.id.kik && (recentShopParcel = (RecentShopParcel) qUIBadgeDragLayout.getDragView().getTag(R.id.h2x)) != null) {
            recentShopParcel.C = 0;
            Intent intent = new Intent("action_shop_set_read");
            intent.putExtra("uin", recentShopParcel.f79609d);
            intent.putExtra("needDelete", false);
            getQBaseActivity().sendBroadcast(intent);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.f165972dz1 && id5 != R.id.k4f) {
            if (id5 != R.id.ivTitleBtnRightText && id5 != R.id.dsr) {
                if (id5 == R.id.ivTitleBtnRightImage) {
                    if (this.webView != null) {
                        this.webView.callJs(WebViewPlugin.toJsScript("onSearchBtnClick", new JSONObject(), new JSONObject()));
                    }
                } else {
                    super.onClick(view);
                }
            } else {
                if (this.webView != null) {
                    this.webView.callJs(WebViewPlugin.toJsScript("onEnterUserInfo", new JSONObject(), new JSONObject()));
                }
                RedTouch redTouch = this.f79617c0;
                if (redTouch != null) {
                    redTouch.clearRedTouch();
                }
                this.I.g(getQBaseActivity(), this.J[3]);
                try {
                    this.I.f79584f.H2(134248547, null, null, null, null, 0L, false);
                } catch (Exception unused) {
                }
            }
        } else if (getQBaseActivity() != null) {
            getQBaseActivity().doOnBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (getAppRuntime() == null) {
            this.mApp = getQBaseActivity().getAppRuntime();
        }
        this.I = new EcshopCacheTool((AppInterface) getAppRuntime(), this);
        int i3 = 0;
        if (this.intent.hasExtra("bundle")) {
            Bundle bundleExtra = this.intent.getBundleExtra("bundle");
            bundleExtra.setClassLoader(RecentShopParcel.class.getClassLoader());
            this.C = bundleExtra.getBoolean(TabDataHelper.SCENE_IS_TAB_SHOW, false);
            long j3 = 0;
            long j16 = bundleExtra.getLong(PerfTracer.PARAM_CLICK_TIME, 0L);
            boolean z16 = bundleExtra.getBoolean("is_tool_exist", false);
            if (j16 != 0) {
                j3 = System.currentTimeMillis() - j16;
            }
            this.J = bundleExtra.getStringArray(CoverDBCacheData.URLS);
            this.H = bundleExtra.getParcelableArrayList("datas");
            this.D = bundleExtra.getBoolean("hasUnread", false);
            this.G = bundleExtra.getInt("unReadNum", 0);
            this.E = bundleExtra.getBoolean("isDefaultTheme", true);
            this.F = bundleExtra.getBoolean("from_search", false);
            EcshopCacheTool ecshopCacheTool = this.I;
            boolean z17 = this.C;
            ecshopCacheTool.f79585g = z17;
            if (z17) {
                try {
                    ecshopCacheTool.f79584f.H2(134248544, null, null, null, null, 0L, false);
                } catch (Exception unused) {
                }
            }
            EcshopReportHandler ecshopReportHandler = this.I.f79584f;
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            ecshopReportHandler.H2(134248552, null, str, String.valueOf(j3), null, 0L, false);
        }
        DragFrameLayout e16 = DragFrameLayout.e(getQBaseActivity());
        this.K = e16;
        e16.addOnDragModeChangeListener(this, false);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_decode_finish");
        intentFilter.addAction("action_on_shop_msg_receive");
        try {
            getActivity().registerReceiver(this.f79615a0, intentFilter);
            EcshopCacheTool ecshopCacheTool2 = this.I;
            AppRuntime appRuntime = getAppRuntime();
            List<RecentShopParcel> list = this.H;
            if (list != null) {
                i3 = list.size();
            }
            ecshopCacheTool2.d(appRuntime, i3);
        } catch (Exception unused2) {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!this.C) {
            this.N = 1;
            uh(LayoutInflater.from(getQBaseActivity()));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.f166798ic2);
            this.contentView.addView(this.L, layoutParams);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            getQBaseActivity().unregisterReceiver(this.f79615a0);
        } catch (Exception unused) {
        }
        com.tencent.biz.pubaccount.ecshopassit.b bVar = this.M;
        if (bVar != null) {
            bVar.destroy();
            this.M = null;
        }
        EcshopCacheTool ecshopCacheTool = this.I;
        if (ecshopCacheTool != null) {
            ecshopCacheTool.a();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z16;
        super.onResume();
        List<RecentShopParcel> list = this.H;
        if (list != null && !list.isEmpty()) {
            if (getQBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                getQBaseActivity().requestPermissions("android.permission.ACCESS_FINE_LOCATION", 10, new String[0]);
            }
            if (z16) {
                ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(this.f79616b0);
            }
            com.tencent.biz.pubaccount.ecshopassit.b bVar = this.M;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    void uh(LayoutInflater layoutInflater) {
        this.L = (SwipListView) layoutInflater.inflate(R.layout.a49, (ViewGroup) null);
        View inflate = layoutInflater.inflate(R.layout.bbt, (ViewGroup) null);
        inflate.findViewById(R.id.agq).setOnClickListener(new a());
        if (this.C) {
            View findViewById = inflate.findViewById(R.id.jt7);
            View findViewById2 = inflate.findViewById(R.id.agq);
            if (findViewById != null) {
                findViewById.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            }
            if (findViewById2 != null) {
                findViewById2.setBackgroundResource(R.drawable.anw);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.aks);
            textView.setTextColor(Color.parseColor("#FF000000"));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.caj, 0);
            inflate.findViewById(R.id.bmt).setBackgroundColor(Color.parseColor("#FFF9F9FB"));
            this.L.setBackgroundResource(R.color.f157696x1);
        }
        this.L.addHeaderView(inflate);
        com.tencent.biz.pubaccount.ecshopassit.b bVar = new com.tencent.biz.pubaccount.ecshopassit.b(getQBaseActivity(), this.L, this.I, this.J[0]);
        this.M = bVar;
        this.L.setAdapter((ListAdapter) bVar);
        this.M.e(this.H);
        this.M.d(this.K);
        this.L.setDragEnable(true);
        if (getQBaseActivity() instanceof SwipListView.RightIconMenuListener) {
            this.L.setRightIconMenuListener((SwipListView.RightIconMenuListener) getQBaseActivity());
        }
        if (!this.C) {
            return;
        }
        this.L.setOnTouchListener(new b(new JSONObject(), new JSONObject()));
    }

    public void vh(int i3) {
        ImageView imageView = this.U;
        if (imageView == null) {
            return;
        }
        if (i3 == 1 && imageView != null) {
            imageView.setVisibility(0);
            RedTouch redTouch = new RedTouch(getQBaseActivity(), this.U);
            this.f79617c0 = redTouch;
            redTouch.setGravity(53);
            this.f79617c0.applyTo();
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            this.f79617c0.parseRedTouch(redTypeInfo);
            this.f79617c0.setVisibility(0);
            return;
        }
        this.f79617c0.setVisibility(4);
    }

    public void wh(int i3, int i16) {
        SwipListView swipListView;
        if (i3 == 0 && this.N == 1) {
            this.N = 0;
            SwipListView swipListView2 = this.L;
            if (swipListView2 != null) {
                swipListView2.setVisibility(8);
                return;
            }
            return;
        }
        if (i3 == 1 && this.N == 0) {
            this.N = 1;
            SwipListView swipListView3 = this.L;
            if (swipListView3 == null) {
                uh(LayoutInflater.from(getQBaseActivity()));
                RelativeLayout relativeLayout = (RelativeLayout) this.webView.getParent();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = i16;
                relativeLayout.addView(this.L, layoutParams);
            } else {
                ((RelativeLayout.LayoutParams) swipListView3.getLayoutParams()).topMargin = i16;
                this.L.setVisibility(0);
                this.M.e(this.H);
                this.L.requestLayout();
            }
            View view = this.R;
            if (view != null) {
                view.bringToFront();
                return;
            }
            return;
        }
        if (i3 == 1 && (swipListView = this.L) != null) {
            ((RelativeLayout.LayoutParams) swipListView.getLayoutParams()).topMargin = i16;
            this.L.requestLayout();
        }
    }

    void xh() {
        TextView textView;
        TextView textView2;
        TextView textView3 = this.V;
        if (textView3 != null && (textView = this.T) != null && textView != null) {
            if (this.E && !this.C) {
                textView3.setVisibility(8);
                this.S.setVisibility(0);
                this.T.setVisibility(0);
                textView2 = this.T;
            } else {
                textView3.setVisibility(0);
                this.S.setVisibility(8);
                this.T.setVisibility(8);
                textView2 = this.V;
            }
            if (textView2 != null) {
                String str = "" + this.G;
                if (this.E && !this.C) {
                    if (this.G > 99) {
                        str = "99+";
                    }
                } else {
                    str = getString(R.string.hvn) + "(" + this.G + ")";
                    if (this.G > 99) {
                        str = getString(R.string.hvn) + "(99+)";
                    }
                }
                if (this.G <= 0 && !this.F) {
                    str = getString(R.string.hvn);
                    if (this.E && !this.C) {
                        textView2.setVisibility(8);
                        return;
                    }
                }
                if (this.F) {
                    if (this.C) {
                        this.S.setVisibility(8);
                    } else {
                        this.S.setVisibility(0);
                        this.V.setVisibility(0);
                        this.T.setVisibility(8);
                        textView2 = this.V;
                        textView2.setBackgroundResource(0);
                    }
                    str = getResources().getString(R.string.button_back);
                }
                textView2.setText(str);
            }
        }
    }
}

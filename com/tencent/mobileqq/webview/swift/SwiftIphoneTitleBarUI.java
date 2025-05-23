package com.tencent.mobileqq.webview.swift;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ez;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.webview.view.BrowserTitleBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLDecoder;
import java.util.Set;
import kotlin.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes20.dex */
public class SwiftIphoneTitleBarUI {
    static IPatchRedirector $redirector_;
    public TextView C;
    public TextView D;
    public ImageView E;
    public ImageView F;
    public FadeIconImageView G;
    public View H;
    public ImageView I;
    public TextView J;
    public View K;
    private View L;
    public ViewGroup M;
    public ViewGroup N;
    public RelativeLayout P;
    public String Q;
    public com.tencent.mobileqq.webview.nativeapi.a R;
    public JsBridgeListener S;
    public boolean T;
    private boolean U;
    private int V;
    boolean W;
    Animation X;
    Animation Y;
    boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    int f314042a0;

    /* renamed from: b0, reason: collision with root package name */
    int f314043b0;

    /* renamed from: c0, reason: collision with root package name */
    int f314044c0;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.mobileqq.webview.swift.component.v f314045d;

    /* renamed from: d0, reason: collision with root package name */
    int f314046d0;

    /* renamed from: e, reason: collision with root package name */
    public r f314047e;

    /* renamed from: e0, reason: collision with root package name */
    int f314048e0;

    /* renamed from: f, reason: collision with root package name */
    private WebViewProvider f314049f;

    /* renamed from: f0, reason: collision with root package name */
    boolean f314050f0;

    /* renamed from: g0, reason: collision with root package name */
    String f314051g0;

    /* renamed from: h, reason: collision with root package name */
    Intent f314052h;

    /* renamed from: h0, reason: collision with root package name */
    String f314053h0;

    /* renamed from: i, reason: collision with root package name */
    public TextView f314054i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f314055i0;

    /* renamed from: j0, reason: collision with root package name */
    ez.f<Integer> f314056j0;

    /* renamed from: k0, reason: collision with root package name */
    String f314057k0;

    /* renamed from: l0, reason: collision with root package name */
    TouchWebView.OnScrollChangedListener f314058l0;

    /* renamed from: m, reason: collision with root package name */
    public TextView f314059m;

    /* renamed from: m0, reason: collision with root package name */
    public WebViewTopTabView f314060m0;

    /* renamed from: n0, reason: collision with root package name */
    public com.tencent.mobileqq.webview.ui.a f314061n0;

    /* renamed from: o0, reason: collision with root package name */
    @Nullable
    private Intent f314062o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f314063p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f314064q0;

    /* renamed from: r0, reason: collision with root package name */
    View.OnTouchListener f314065r0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ez.f<Integer> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftIphoneTitleBarUI.this);
            }
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ez<Integer> ezVar, float f16, Integer num, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, ezVar, Float.valueOf(f16), num, transformation);
            } else {
                SwiftIphoneTitleBarUI.this.R(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements TouchWebView.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftIphoneTitleBarUI.this);
            }
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
                return;
            }
            SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = SwiftIphoneTitleBarUI.this;
            swiftIphoneTitleBarUI.f314043b0 = i16;
            swiftIphoneTitleBarUI.e0(i16, swiftIphoneTitleBarUI.f314050f0);
            TouchWebView u16 = SwiftIphoneTitleBarUI.this.f314045d.u();
            if (u16 != null && !TextUtils.isEmpty(SwiftIphoneTitleBarUI.this.f314057k0)) {
                u16.callJs(SwiftIphoneTitleBarUI.this.f314057k0, String.valueOf(i3), String.valueOf(i16), String.valueOf(i17), String.valueOf(i18));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftIphoneTitleBarUI.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SwiftIphoneTitleBarUI.this.b0(false, 0, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements ez.f<Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f314072a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f314073b;

        d(View view, int i3) {
            this.f314072a = view;
            this.f314073b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SwiftIphoneTitleBarUI.this, view, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ez<Integer> ezVar, float f16, Integer num, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, ezVar, Float.valueOf(f16), num, transformation);
                return;
            }
            if (!SwiftIphoneTitleBarUI.this.f314047e.I) {
                return;
            }
            this.f314072a.getBackground().mutate().setAlpha(num.intValue());
            SwiftIphoneTitleBarUI.this.f314047e.J = num.intValue();
            r rVar = SwiftIphoneTitleBarUI.this.f314047e;
            if (rVar.J == this.f314073b) {
                rVar.I = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements TouchWebView.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f314075a;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftIphoneTitleBarUI.this);
            } else {
                this.f314075a = 0;
            }
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            int i19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "-->onScrollChanged:" + i3 + "," + i16 + "," + i17 + "," + i18);
            }
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                i19 = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
            } else {
                i19 = 0;
            }
            int c16 = 180 + com.tencent.mobileqq.util.x.c(BaseApplication.getContext(), 50.0f) + i19;
            if (Math.abs(i16 - this.f314075a) > 20) {
                if (i16 < c16 / 3) {
                    SwiftIphoneTitleBarUI.this.f314047e.G = true;
                } else if (i16 >= c16) {
                    SwiftIphoneTitleBarUI.this.f314047e.G = false;
                }
                this.f314075a = i16;
                SwiftIphoneTitleBarUI.this.f0();
                return;
            }
            if (i16 < c16 / 3) {
                SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = SwiftIphoneTitleBarUI.this;
                swiftIphoneTitleBarUI.f314047e.G = true;
                this.f314075a = i16;
                swiftIphoneTitleBarUI.f0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements RadioGroup.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftIphoneTitleBarUI.this);
            }
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            Intent intent;
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) radioGroup, i3);
            } else {
                com.tencent.mobileqq.webview.ui.a aVar = SwiftIphoneTitleBarUI.this.f314061n0;
                if (aVar != null && !TextUtils.isEmpty(aVar.f314846b)) {
                    SwiftIphoneTitleBarUI.this.f314061n0.b(i3);
                } else {
                    TouchWebView u16 = SwiftIphoneTitleBarUI.this.f314045d.u();
                    if (u16 != null) {
                        String url = u16.getUrl();
                        if (TextUtils.isEmpty(url) && (intent = SwiftIphoneTitleBarUI.this.f314052h) != null) {
                            url = intent.getStringExtra("url");
                        }
                        if (!TextUtils.isEmpty(url)) {
                            u16.loadUrl(url.replaceAll("(?<=[?&])subIndex=[^&]*", "subIndex=" + i3));
                        }
                    }
                }
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftIphoneTitleBarUI.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && (view instanceof TextView)) {
                    TextView textView = (TextView) view;
                    int currentTextColor = textView.getCurrentTextColor();
                    textView.setTextColor(Color.argb(255, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
                    return false;
                }
                return false;
            }
            if (view instanceof TextView) {
                TextView textView2 = (TextView) view;
                int currentTextColor2 = textView2.getCurrentTextColor();
                textView2.setTextColor(Color.argb(128, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f314079a;

        /* renamed from: b, reason: collision with root package name */
        public int f314080b;

        /* renamed from: c, reason: collision with root package name */
        public String f314081c;

        /* renamed from: d, reason: collision with root package name */
        public String f314082d;

        /* renamed from: e, reason: collision with root package name */
        public String[] f314083e;

        public h(int i3, int i16, String str, String str2, String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, strArr);
                return;
            }
            this.f314079a = i3;
            this.f314080b = i16;
            this.f314082d = str;
            this.f314081c = str2;
            this.f314083e = strArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int[] f314084a;

        /* renamed from: b, reason: collision with root package name */
        public int f314085b;

        /* renamed from: c, reason: collision with root package name */
        public String f314086c;

        public i(int[] iArr, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, iArr, Integer.valueOf(i3), str);
                return;
            }
            this.f314084a = iArr;
            this.f314085b = i3;
            this.f314086c = str;
        }
    }

    public SwiftIphoneTitleBarUI(com.tencent.mobileqq.webview.swift.component.v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar);
            return;
        }
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = false;
        this.U = false;
        this.W = false;
        this.Z = false;
        this.f314042a0 = -1;
        this.f314043b0 = 0;
        this.f314044c0 = 240;
        this.f314046d0 = 0;
        this.f314048e0 = 255;
        this.f314050f0 = true;
        this.f314051g0 = null;
        this.f314053h0 = null;
        this.f314055i0 = false;
        this.f314056j0 = new a();
        this.f314057k0 = null;
        this.f314058l0 = new b();
        this.f314061n0 = null;
        this.f314064q0 = false;
        this.f314065r0 = new g();
        this.f314045d = vVar;
        this.f314047e = vVar.f314512m;
        this.f314049f = vVar.P;
        this.f314061n0 = new com.tencent.mobileqq.webview.ui.a(vVar);
    }

    private void I(int i3) {
        Pair<Integer, Integer> pair = com.tencent.mobileqq.webview.swift.utils.n.f314764a.a().get(i3);
        if (pair != null) {
            com.tencent.mobileqq.webview.swift.utils.o.d(this.E, 1, pair.getFirst().intValue(), this.f314045d.F());
            this.E.setContentDescription(BaseApplication.getContext().getResources().getString(pair.getSecond().intValue()));
            return;
        }
        if (i3 != 16) {
            if (i3 != 18) {
                if (i3 != 1001) {
                    this.E.setVisibility(8);
                    return;
                }
                URLDrawable drawable = URLDrawable.getDrawable(((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).c("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png"), (URLDrawable.URLDrawableOptions) null);
                if (drawable != null) {
                    this.E.setBackgroundDrawable(drawable);
                    RelativeLayout relativeLayout = (RelativeLayout) this.M.findViewById(R.id.f166811ie3);
                    if (relativeLayout != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                        layoutParams.rightMargin = ViewUtils.dpToPx(10.0f);
                        relativeLayout.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f314045d.T(this.E, false, R.drawable.mst, R.drawable.jlr);
            this.E.setContentDescription(BaseApplication.getContext().getResources().getString(R.string.f170028dd));
            RelativeLayout relativeLayout2 = (RelativeLayout) this.M.findViewById(R.id.f166811ie3);
            if (relativeLayout2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
                layoutParams2.rightMargin = ViewUtils.dpToPx(10.0f);
                relativeLayout2.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        this.f314045d.T(this.E, false, R.drawable.nnr, R.drawable.l2z);
        this.E.setContentDescription(BaseApplication.getContext().getResources().getString(R.string.bbo));
    }

    private void J(String str, String str2, int i3, int i16, JsBridgeListener jsBridgeListener, View.OnClickListener onClickListener, com.tencent.mobileqq.webview.nativeapi.a aVar, boolean z16) {
        boolean z17;
        this.C.setVisibility(8);
        if (!this.f314047e.S && !this.f314063p0) {
            this.E.setVisibility(0);
        }
        r rVar = this.f314047e;
        if (i3 != 4) {
            z17 = true;
        } else {
            z17 = false;
        }
        rVar.f314630m = z17;
        I(i3);
        if (i16 == 0 && this.T) {
            i16 = 10000;
        }
        if (i16 != 0) {
            if (this.F == null) {
                this.F = new ImageView(BaseApplication.getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(7, R.id.ivTitleBtnRightImage);
                layoutParams.addRule(6, R.id.ivTitleBtnRightImage);
                layoutParams.setMargins(0, 0, 0, 0);
                this.F.setLayoutParams(layoutParams);
                if (this.E.getParent() instanceof RelativeLayout) {
                    ((RelativeLayout) this.E.getParent()).addView(this.F);
                }
            }
            this.F.setVisibility(0);
            if (i16 != 6) {
                if (i16 != 13 && i16 != 10000) {
                    this.F.setVisibility(8);
                } else {
                    this.F.setImageResource(R.drawable.skin_tips_dot);
                }
            } else {
                this.F.setImageResource(R.drawable.e2o);
            }
        } else {
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            this.E.setContentDescription(str2);
        }
        if (onClickListener != null) {
            this.E.setOnClickListener(onClickListener);
            return;
        }
        if (str != null && !z16) {
            this.Q = str.trim();
        } else if (aVar != null) {
            this.R = aVar;
        } else {
            this.Q = null;
            this.S = jsBridgeListener;
        }
    }

    private void L() {
        int i3;
        JSONArray jSONArray;
        String[] strArr;
        if (!TextUtils.isEmpty(this.f314047e.f314626i)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(this.f314047e.f314626i));
                if (jSONObject.has("tabNum")) {
                    i3 = jSONObject.getInt("tabNum");
                } else {
                    i3 = 2;
                }
                int i16 = i3;
                if (jSONObject.has("subTextArray")) {
                    jSONArray = jSONObject.getJSONArray("subTextArray");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                        strArr2[i17] = jSONArray.getString(i17);
                    }
                    strArr = strArr2;
                } else {
                    strArr = null;
                }
                M(new h(this.f314047e.f314627j, i16, null, null, strArr));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void Q(JSONObject jSONObject, View view) {
        view.setBackgroundColor(com.tencent.mobileqq.webview.swift.utils.o.c(jSONObject.optString("bgclr", ""), -1));
        WebViewProvider webViewProvider = this.f314049f;
        if (webViewProvider != null && webViewProvider.getWebTitleBarInterface().a3() != null) {
            boolean z16 = false;
            int c16 = com.tencent.mobileqq.webview.swift.utils.o.c(jSONObject.optString("statusclr", ""), 0);
            this.f314049f.getWebTitleBarInterface().a3().setBackgroundColor(c16);
            if (jSONObject.has("statustxtlight")) {
                if (jSONObject.optInt("statustxtlight", 0) == 1) {
                    z16 = true;
                }
            } else {
                z16 = p(c16);
            }
            SimpleUIUtil.adjustColorForQQBrowserActivity(z16, this.f314045d.E.getWindow());
        }
        int c17 = com.tencent.mobileqq.webview.swift.utils.o.c(jSONObject.optString("txtclr", ""), -1);
        this.f314054i.setTextColor(c17);
        this.C.setTextColor(c17);
        com.tencent.mobileqq.webview.swift.utils.o.f(this.f314054i, 2, c17);
        com.tencent.mobileqq.webview.swift.utils.o.f(this.G, 1, c17);
        com.tencent.mobileqq.webview.swift.utils.o.f(this.E, 1, c17);
        z(c17);
        int c18 = com.tencent.mobileqq.webview.swift.utils.o.c(jSONObject.optString("titleclr", ""), -1);
        if (TextUtils.isEmpty(this.f314059m.getText()) && !TextUtils.isEmpty(this.f314045d.f314504e0)) {
            this.f314059m.setText(this.f314045d.f314504e0);
        }
        this.f314059m.setTextColor(c18);
    }

    private void i() {
        this.f314047e.f314630m = true;
        this.C.setVisibility(8);
        this.E.setVisibility(8);
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        A(false);
    }

    private void k() {
        if (this.f314062o0 != null && this.E != null) {
            boolean webViewMenuNeedBlock = ZhuoXusManager.instance().webViewMenuNeedBlock();
            boolean z16 = false;
            boolean booleanExtra = this.f314062o0.getBooleanExtra("fromAio", false);
            if (webViewMenuNeedBlock && booleanExtra) {
                z16 = true;
            }
            this.f314063p0 = z16;
            if (QLog.isColorLevel()) {
                QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "blockRightViewImgIfNeed needBlock:" + webViewMenuNeedBlock + ", fromAio:" + booleanExtra);
            }
        }
    }

    public static boolean p(int i3) {
        if (1.0d - ((((Color.red(i3) * 0.299d) + (Color.green(i3) * 0.587d)) + (Color.blue(i3) * 0.114d)) / 255.0d) >= 0.5d) {
            return true;
        }
        return false;
    }

    private void y(Intent intent) {
        if ((this.f314047e.f314620c & 4) == 0 && intent.getBooleanExtra("hide_title_left_arrow", false)) {
            this.f314054i.setText(BaseApplication.getContext().getResources().getString(R.string.button_back));
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).enableTalkBack()) {
                AccessibilityUtil.m(this.f314054i);
            }
        }
    }

    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
            return;
        }
        WebViewProvider webViewProvider = this.f314045d.P;
        if (webViewProvider != null) {
            com.tencent.mobileqq.webview.swift.g gVar = (com.tencent.mobileqq.webview.swift.g) webViewProvider.getComponentProvider().a(256);
            if (z16 && r()) {
                gVar.d(100);
                gVar.a();
                gVar.b(true);
                return;
            }
            gVar.b(false);
        }
    }

    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.V = i3;
        }
    }

    public void C(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        } else {
            if (view == null) {
                return;
            }
            view.setLayerType(0, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:14:0x001c, B:18:0x003f, B:20:0x0045, B:22:0x0056, B:23:0x005e, B:25:0x006f, B:26:0x0077, B:28:0x0080, B:32:0x008a, B:33:0x0096, B:35:0x00a4, B:37:0x00bc, B:38:0x00d3, B:39:0x00d8, B:42:0x00de, B:44:0x00e2, B:47:0x0090), top: B:13:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(Intent intent) {
        FadeIconImageView fadeIconImageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) intent);
            return;
        }
        if (this.f314054i != null && intent != null && intent.getExtras() != null) {
            try {
                String string = intent.getExtras().getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
                int i3 = intent.getExtras().getInt("individuation_url_type");
                if (i3 >= 40300 && i3 <= 40313 && !TextUtils.isEmpty(string) && string.contains(BaseApplication.getContext().getString(R.string.f214415su))) {
                    string = BaseApplication.getContext().getString(R.string.button_back);
                }
                boolean booleanExtra = intent.getBooleanExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                boolean booleanExtra2 = intent.getBooleanExtra("fromOneCLickCLose", false);
                if (string == null) {
                    string = BaseApplication.getContext().getString(R.string.button_back);
                }
                if (com.tencent.mobileqq.webview.swift.utils.o.a(this.f314054i, 2) == null) {
                    this.f314054i.setText(string);
                }
                if (!booleanExtra && !booleanExtra2) {
                    this.f314054i.setVisibility(0);
                    if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).enableTalkBack()) {
                        String charSequence = this.f314054i.getText().toString();
                        if (!charSequence.contains(BaseApplication.getContext().getString(R.string.button_back))) {
                            charSequence = BaseApplication.getContext().getString(R.string.button_back) + charSequence;
                        }
                        this.f314054i.setContentDescription(charSequence);
                    }
                    fadeIconImageView = this.G;
                    if (fadeIconImageView == null) {
                        if (booleanExtra2) {
                            fadeIconImageView.setVisibility(0);
                            return;
                        } else {
                            fadeIconImageView.setVisibility(8);
                            return;
                        }
                    }
                    return;
                }
                this.f314054i.setVisibility(4);
                if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).enableTalkBack()) {
                }
                fadeIconImageView = this.G;
                if (fadeIconImageView == null) {
                }
            } catch (Exception e16) {
                QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setLeftViewName exception e = ", e16);
            }
        }
    }

    public void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.U = z16;
        }
    }

    public void F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        this.f314057k0 = str;
        TouchWebView u16 = this.f314045d.u();
        if (u16 != null && !this.W) {
            u16.setOnScrollChangedListenerForBiz(this.f314058l0);
            this.W = true;
        }
    }

    public void G(String str, String str2, String str3, boolean z16, int i3, int i16, JsBridgeListener jsBridgeListener, View.OnClickListener onClickListener, com.tencent.mobileqq.webview.nativeapi.a aVar) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), jsBridgeListener, onClickListener, aVar);
            return;
        }
        if (jsBridgeListener != null && jsBridgeListener.f314008c) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            i();
            return;
        }
        Intent intent = this.f314062o0;
        if (intent != null && intent.getIntExtra("reqType", -1) == 7) {
            this.C.setVisibility(8);
            this.E.setVisibility(8);
            return;
        }
        if (r()) {
            A(true);
        } else {
            A(false);
        }
        if (i3 == 0) {
            if (!TextUtils.isEmpty(str2)) {
                this.C.setText(str2);
                this.C.setVisibility(0);
                this.C.bringToFront();
                this.E.setImageResource(0);
                this.E.setBackgroundColor(0);
                this.E.setVisibility(8);
            }
            if (str3 != null) {
                this.E.setBackgroundColor(com.tencent.mobileqq.webview.swift.utils.o.c(str3, 0));
            }
            if (str != null && !z17) {
                this.Q = str.trim();
            } else if (aVar != null) {
                this.R = aVar;
            } else {
                this.S = jsBridgeListener;
                this.Q = null;
            }
        } else {
            J(str, str2, i3, i16, jsBridgeListener, onClickListener, aVar, z17);
        }
        JSONObject jSONObject = this.f314047e.K;
        if (jSONObject != null && jSONObject.has("txtclr")) {
            String optString = this.f314047e.K.optString("txtclr", "");
            if (!TextUtils.isEmpty(optString)) {
                int c16 = com.tencent.mobileqq.webview.swift.utils.o.c(optString, 0);
                com.tencent.mobileqq.webview.swift.utils.o.f(this.E, 1, c16);
                z(c16);
            }
        }
        U(this.f314047e.G);
    }

    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f314047e.f314630m = true;
            TextView textView = this.C;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.E;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.F;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.C;
        if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
            this.C.setVisibility(0);
        }
        ImageView imageView3 = this.E;
        if (imageView3 != null && !this.f314063p0) {
            imageView3.setVisibility(0);
        }
        ImageView imageView4 = this.F;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
    }

    @TargetApi(11)
    public void K(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else if (i3 == 0) {
            this.C.setEnabled(false);
            this.C.setAlpha(0.5f);
        } else {
            this.C.setEnabled(true);
            this.C.setAlpha(1.0f);
        }
    }

    public void M(h hVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) hVar);
            return;
        }
        if (hVar != null) {
            WebViewTopTabView webViewTopTabView = new WebViewTopTabView(BaseApplication.getContext());
            this.f314060m0 = webViewTopTabView;
            webViewTopTabView.setButtonNum(hVar.f314080b, hVar.f314079a);
            this.f314060m0.setButtonText(hVar.f314083e);
            this.f314060m0.setButtonBackgroundResource(R.drawable.b7w, R.drawable.b7x, R.drawable.b7y);
            this.f314060m0.setButtonTextColorStateList(R.color.aks);
            this.f314060m0.setLeftAndRightPaddingByDp(10);
            U(this.f314047e.G);
            int i3 = -1;
            try {
                this.P.removeAllViews();
                this.P.addView(this.f314060m0, new RelativeLayout.LayoutParams(-2, -1));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.f314060m0.setOnCheckedChangeListener(new f());
            com.tencent.mobileqq.webview.ui.a aVar = this.f314061n0;
            if (aVar != null) {
                aVar.a(hVar.f314082d, true);
            }
            TouchWebView u16 = this.f314045d.u();
            if (u16 != null && !TextUtils.isEmpty(hVar.f314081c)) {
                if (TextUtils.isEmpty(hVar.f314082d)) {
                    str = "the subTabCallback isEmpty";
                } else {
                    str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                    i3 = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", i3);
                    jSONObject.put("message", str);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                u16.callJs(hVar.f314081c, jSONObject.toString());
            }
        }
    }

    public void N(i iVar) {
        WebViewTopTabView webViewTopTabView;
        boolean z16;
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) iVar);
            return;
        }
        if (iVar != null && (webViewTopTabView = this.f314060m0) != null) {
            int[] iArr = iVar.f314084a;
            if (iVar.f314085b == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            webViewTopTabView.setRedHotStatus(iArr, z16);
            TouchWebView u16 = this.f314045d.u();
            if (u16 == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int[] b16 = this.f314060m0.b();
            if (b16 != null && b16.length != 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (int i16 : b16) {
                        jSONArray.put(i16);
                    }
                    jSONObject.put("tabsStatus", jSONArray);
                    if (QLog.isColorLevel()) {
                        QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "tabsStatusArray = " + jSONArray.toString());
                    }
                    str = "OK";
                    i3 = 0;
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    i3 = -3;
                    str = "construction json error";
                }
            } else {
                i3 = -2;
                str = "sub tab num is error";
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("code", i3);
                jSONObject2.put("message", str);
                jSONObject2.put("data", jSONObject);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            if (!TextUtils.isEmpty(iVar.f314086c)) {
                u16.callJs(iVar.f314086c, jSONObject2.toString());
            }
        }
    }

    public void O(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.f314059m.setText(str);
        }
    }

    public void P(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, str2, str3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f314054i.setVisibility(4);
        } else {
            this.f314054i.setVisibility(0);
            if (com.tencent.mobileqq.webview.swift.utils.o.a(this.f314054i, 2) == null) {
                this.f314054i.setText(str);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            this.C.setVisibility(8);
        } else {
            this.C.setText(str2);
            this.C.setVisibility(0);
            this.E.setVisibility(8);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        O(str3);
    }

    public void R(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        if (this.M == null || i3 == this.f314042a0) {
            return;
        }
        this.f314042a0 = i3;
        int max = Math.max(0, Math.min(i3, 255));
        this.M.getBackground().mutate().setAlpha(max);
        WebViewProvider webViewProvider = this.f314049f;
        if (webViewProvider != null && webViewProvider.getWebTitleBarInterface().a3() != null) {
            this.f314049f.getWebTitleBarInterface().a3().getBackground().mutate().setAlpha(max);
        }
        if (max == this.f314046d0) {
            U(true);
        } else if (max == this.f314048e0) {
            U(false);
        }
    }

    public void S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        TextView textView = this.f314054i;
        if (textView != null && this.C != null && this.E != null) {
            int currentTextColor = textView.getCurrentTextColor();
            if (QLog.isColorLevel()) {
                QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, String.format("setTitleBarButtonColor #%x\uff0c curTextColor: #%x", Integer.valueOf(i3), Integer.valueOf(currentTextColor)));
            }
            if (currentTextColor != i3) {
                E(true);
                B(currentTextColor);
            } else if (this.U) {
                E(false);
                B(currentTextColor);
            }
            this.f314054i.setTextColor(i3);
            this.C.setTextColor(i3);
            com.tencent.mobileqq.webview.swift.utils.o.f(this.G, 1, i3);
            com.tencent.mobileqq.webview.swift.utils.o.f(this.f314054i, 2, i3);
            com.tencent.mobileqq.webview.swift.utils.o.f(this.E, 1, i3);
            z(i3);
            this.E.setColorFilter(i3);
            return;
        }
        QLog.i("WebLog_SwiftIphoneTitleBarUI", 1, "setTitleBarButtonColor view is null.");
    }

    public void T(TouchWebView touchWebView, boolean z16, int i3, int i16, int i17, boolean z17, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, touchWebView, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17), str, str2, str3);
            return;
        }
        if (touchWebView == null) {
            return;
        }
        if (!this.W) {
            touchWebView.setOnScrollChangedListenerForBiz(this.f314058l0);
            this.W = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "setTitleBarScrollChange:" + z16 + ", @" + i3 + ", from " + i16 + " to " + i17 + ", " + z17 + ", Before: " + str + ", After: " + str2);
        }
        this.Z = z16;
        BaseApplication context = BaseApplication.getContext();
        this.f314044c0 = (int) ((i3 * context.getResources().getDisplayMetrics().density) + 0.5f);
        this.f314046d0 = i16;
        this.f314048e0 = i17;
        ez ezVar = new ez(Integer.valueOf(i16), Integer.valueOf(i17), this.f314056j0);
        this.X = ezVar;
        ezVar.setDuration(300L);
        this.X.setInterpolator(context, android.R.anim.accelerate_interpolator);
        ez ezVar2 = new ez(Integer.valueOf(i17), Integer.valueOf(i16), this.f314056j0);
        this.Y = ezVar2;
        ezVar2.setDuration(300L);
        this.Y.setInterpolator(context, android.R.anim.accelerate_interpolator);
        this.f314050f0 = z17;
        this.f314051g0 = str;
        this.f314053h0 = str2;
        this.f314042a0 = -1;
        e0(this.f314043b0, false);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", 0);
            jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        } catch (Exception unused) {
        }
        touchWebView.callJs(str3, jSONObject.toString());
    }

    public void U(boolean z16) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        this.f314047e.G = z16;
        if (z16 && (str2 = this.f314051g0) != null) {
            O(str2);
        } else if (!z16 && (str = this.f314053h0) != null) {
            O(str);
        }
    }

    public void W(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
            return;
        }
        TextView textView = this.f314059m;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public boolean X(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, z16)).booleanValue();
        }
        if (this.M == null) {
            return false;
        }
        if (z16) {
            this.f314042a0 = -1;
            e0(this.f314043b0, this.f314050f0);
            this.M.setVisibility(0);
            com.tencent.mobileqq.webview.swift.component.v vVar = this.f314045d;
            if (!vVar.f314512m.f314618a) {
                vVar.E.getWindow().clearFlags(1024);
                return true;
            }
            return true;
        }
        R(0);
        this.M.setVisibility(8);
        this.f314045d.E.getWindow().addFlags(1024);
        return true;
    }

    public void Y(int i3, Drawable drawable, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), drawable, Integer.valueOf(i16));
            return;
        }
        Drawable[] compoundDrawables = this.f314059m.getCompoundDrawables();
        Drawable drawable2 = compoundDrawables[0];
        Drawable drawable3 = compoundDrawables[1];
        Drawable drawable4 = compoundDrawables[2];
        Drawable drawable5 = compoundDrawables[3];
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (drawable != null) {
                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        }
                        drawable5 = drawable;
                    }
                } else if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    if (drawable2 == null) {
                        ColorDrawable colorDrawable = new ColorDrawable(0);
                        colorDrawable.setBounds(drawable.getBounds());
                        drawable4 = drawable;
                        drawable = colorDrawable;
                    } else {
                        if (drawable2 instanceof ColorDrawable) {
                            drawable2.setBounds(drawable.getBounds());
                        }
                        drawable4 = drawable;
                    }
                } else {
                    if (drawable2 instanceof ColorDrawable) {
                        drawable4 = drawable;
                        drawable = null;
                    }
                    drawable4 = drawable;
                }
            } else {
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
                drawable3 = drawable;
            }
            drawable = drawable2;
        } else if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (drawable4 == null) {
                ColorDrawable colorDrawable2 = new ColorDrawable(0);
                colorDrawable2.setBounds(drawable.getBounds());
                drawable4 = colorDrawable2;
            } else if (drawable4 instanceof ColorDrawable) {
                drawable4.setBounds(drawable.getBounds());
            }
        } else if (drawable4 instanceof ColorDrawable) {
            drawable4 = null;
        }
        if (drawable != compoundDrawables[0] || drawable3 != compoundDrawables[1] || drawable4 != compoundDrawables[2] || drawable5 != compoundDrawables[3]) {
            this.f314059m.setCompoundDrawables(drawable, drawable3, drawable4, drawable5);
            this.f314059m.setCompoundDrawablePadding(i16);
            this.f314059m.setGravity(17);
        }
    }

    public boolean Z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, z16)).booleanValue();
        }
        WebViewTopTabView webViewTopTabView = this.f314060m0;
        int i3 = 0;
        if (webViewTopTabView == null) {
            return false;
        }
        if (!z16) {
            i3 = 8;
        }
        webViewTopTabView.setVisibility(i3);
        return true;
    }

    @TargetApi(17)
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.M != null) {
            com.tencent.mobileqq.webview.swift.component.v vVar = this.f314045d;
            if (vVar.V != null) {
                if (!vVar.f314512m.f314619b) {
                    r rVar = this.f314047e;
                    if (!rVar.f314641x) {
                        WebViewProvider webViewProvider = this.f314049f;
                        if (webViewProvider == null) {
                            return false;
                        }
                        webViewProvider.getWebTitleBarInterface().Hf(rVar.f314643z ? 1 : 0);
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void a0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, i3);
            return;
        }
        this.f314047e.f314627j = i3;
        WebViewTopTabView webViewTopTabView = this.f314060m0;
        if (webViewTopTabView != null) {
            webViewTopTabView.setSelectedTab(i3);
        }
    }

    public void b(JSONObject jSONObject, boolean z16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, jSONObject, Boolean.valueOf(z16));
            return;
        }
        if (jSONObject != null && this.M != null) {
            try {
                if (jSONObject.length() > 0) {
                    r rVar = this.f314047e;
                    if (!rVar.H) {
                        rVar.H = a();
                        if (this.f314047e.P && (view = this.f314045d.f314500b0) != null) {
                            view.setPadding(0, (int) com.tencent.mobileqq.utils.al.a(BaseApplication.getContext(), 30.0f), 0, 0);
                        }
                    }
                }
                if (!this.f314047e.H) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "titlebar config:" + jSONObject + ", needSetTitleBg: " + z16);
                }
                if (z16) {
                    Q(jSONObject, this.M);
                }
                if (jSONObject.optInt("trans", -1) != 0) {
                    boolean optBoolean = jSONObject.optBoolean("anim", false);
                    int optInt = jSONObject.optInt("dur", 0);
                    int optInt2 = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.f123400v, 0);
                    if (optBoolean && optInt > 0) {
                        x(this.M, this.f314047e.J, optInt2, optInt);
                    } else {
                        this.M.getBackground().mutate().setAlpha(optInt2);
                        this.f314047e.J = optInt2;
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "game center,doTransparent error:" + e16.toString());
                }
            }
        }
    }

    public void b0(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = this.H;
        if (view != null) {
            if (z16) {
                this.I.setImageDrawable(this.H.getResources().getDrawable(QQToast.getIconRes(i3)));
                this.J.setText(this.H.getResources().getString(i16));
                this.H.setVisibility(0);
                return;
            }
            view.setVisibility(8);
        }
    }

    public void c(TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) touchWebView);
            return;
        }
        ViewGroup viewGroup = this.M;
        r rVar = this.f314047e;
        if (rVar.D && viewGroup != null && !rVar.H && a()) {
            r rVar2 = this.f314047e;
            rVar2.H = true;
            rVar2.E = true;
            rVar2.G = true;
            viewGroup.setBackgroundResource(R.drawable.b86);
            if (((com.tencent.mobileqq.webview.swift.injector.r) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).isNightMode()) {
                this.E.setBackgroundDrawable(null);
            }
            touchWebView.setOnScrollChangedListenerForBiz(new e());
        }
    }

    public void c0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.mobileqq.webview.view.b.g(R.string.f170202in);
            }
            textView.setText(str);
            this.C.setVisibility(0);
            this.C.bringToFront();
        }
        ImageView imageView = this.E;
        if (imageView != null) {
            imageView.setImageResource(0);
            this.E.setBackgroundColor(0);
            this.E.setVisibility(8);
        }
    }

    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (View) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return this.L;
    }

    public void d0(boolean z16) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
            return;
        }
        if (this.T && !z16 && (imageView = this.F) != null) {
            imageView.setVisibility(8);
        }
        this.T = z16;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        TextView textView = this.f314059m;
        if (textView == null) {
            return "";
        }
        return textView.getText().toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void e0(int i3, boolean z16) {
        Animation animation;
        ViewGroup viewGroup;
        if (this.Z) {
            int i16 = this.f314044c0;
            if (i3 >= i16) {
                r rVar = this.f314047e;
                if (rVar.G) {
                    rVar.G = false;
                    if (z16) {
                        animation = this.X;
                        viewGroup = this.M;
                        if (viewGroup == null && animation != null && animation != viewGroup.getAnimation()) {
                            animation.reset();
                            this.M.startAnimation(animation);
                            return;
                        }
                        return;
                    }
                    R(this.f314048e0);
                    animation = null;
                    viewGroup = this.M;
                    if (viewGroup == null) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (i3 < i16) {
                r rVar2 = this.f314047e;
                if (!rVar2.G) {
                    rVar2.G = true;
                    if (z16) {
                        animation = this.Y;
                        viewGroup = this.M;
                        if (viewGroup == null) {
                        }
                    } else {
                        R(this.f314046d0);
                    }
                }
            }
            animation = null;
            viewGroup = this.M;
            if (viewGroup == null) {
            }
        }
    }

    @TargetApi(11)
    public JSONObject f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (JSONObject) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() != 0) {
                for (String str2 : queryParameterNames) {
                    if (str2.contains("_nav_")) {
                        jSONObject.put(str2.replace("_nav_", ""), parse.getQueryParameter(str2));
                    }
                }
                return jSONObject;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "getTitlebarConfig error!", e16);
            return null;
        }
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        if (this.M == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "updateTitleBarUI needTrans:" + this.f314047e.G + ", needResetClr:" + this.f314047e.F);
        }
        r rVar = this.f314047e;
        boolean z16 = rVar.G;
        if (z16 && !rVar.F) {
            rVar.F = true;
            this.M.setBackgroundResource(R.drawable.b86);
            W(-1);
            S(-1);
            WebViewProvider webViewProvider = this.f314049f;
            if (webViewProvider != null && webViewProvider.getWebTitleBarInterface().a3() != null) {
                this.f314049f.getWebTitleBarInterface().a3().setBackgroundColor(0);
                return;
            }
            return;
        }
        if (!z16 && rVar.F) {
            rVar.F = false;
            com.tencent.mobileqq.webview.swift.utils.o.e(this.M, R.drawable.qui_bg_nav_secondary);
            w();
            WebViewProvider webViewProvider2 = this.f314049f;
            if (webViewProvider2 != null) {
                webViewProvider2.getWebTitleBarInterface().Ad(false);
            }
        }
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        if (this.f314060m0 != null) {
            for (int i3 = 0; i3 < this.f314060m0.getChildCount(); i3++) {
                if (((RadioButton) this.f314060m0.getChildAt(i3)).isChecked()) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.E;
        if (imageView != null && !this.f314063p0) {
            imageView.setVisibility(0);
        }
    }

    public final void j(Intent intent, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) onClickListener);
            return;
        }
        this.f314045d.V.addView(new BrowserTitleBar(this.f314045d.V.getContext()));
        this.f314062o0 = intent;
        ViewGroup viewGroup = (ViewGroup) this.f314045d.V.findViewById(R.id.rlCommenTitle);
        this.M = viewGroup;
        C(viewGroup);
        View findViewById = this.M.findViewById(R.id.ied);
        this.L = findViewById;
        findViewById.setVisibility(8);
        this.L.setPadding(0, -ViewUtils.dpToPx(12.0f), 0, 0);
        TextView textView = (TextView) this.M.findViewById(R.id.ivTitleBtnLeft);
        this.f314054i = textView;
        textView.setContentDescription(BaseApplication.getContext().getString(R.string.button_back));
        this.f314054i.setOnClickListener(onClickListener);
        C(this.f314054i);
        this.f314054i.setOnTouchListener(this.f314065r0);
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).enableTalkBack()) {
            AccessibilityUtil.d(this.f314054i, Button.class.getName());
        }
        if (intent.getBooleanExtra("hide_title_left_arrow", false)) {
            this.f314054i.setCompoundDrawables(null, null, null, null);
        }
        FadeIconImageView fadeIconImageView = (FadeIconImageView) this.M.findViewById(R.id.dsc);
        this.G = fadeIconImageView;
        fadeIconImageView.setOnClickListener(onClickListener);
        this.G.setContentDescription(BaseApplication.getContext().getResources().getString(R.string.f170202in));
        D(intent);
        this.f314059m = (TextView) this.M.findViewById(R.id.ivTitleName);
        this.P = (RelativeLayout) this.M.findViewById(R.id.f166812ie4);
        this.C = (TextView) this.M.findViewById(R.id.ivTitleBtnRightText);
        this.E = (ImageView) this.M.findViewById(R.id.ivTitleBtnRightImage);
        C(this.C);
        C(this.E);
        this.C.setOnTouchListener(this.f314065r0);
        this.C.setOnClickListener(onClickListener);
        this.E.setOnClickListener(onClickListener);
        View findViewById2 = this.f314045d.V.findViewById(R.id.jse);
        this.H = findViewById2;
        this.I = (ImageView) findViewById2.findViewById(R.id.toast_icon);
        this.J = (TextView) this.H.findViewById(R.id.toast_msg);
        View findViewById3 = this.H.findViewById(R.id.jsa);
        this.K = findViewById3;
        findViewById3.setOnClickListener(new c());
        this.N = (ViewGroup) this.M.findViewById(R.id.jp7);
        u();
        F(this.f314057k0);
        k();
        m();
        this.f314055i0 = true;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "initDefaultThemeTitleBar forceDefault: " + this.f314047e.R + ", inited:" + this.f314055i0);
        }
        r rVar = this.f314047e;
        if (rVar.R && this.f314055i0) {
            if (!rVar.f314619b && !rVar.f314641x) {
                int color = this.f314045d.E.getResources().getColor(R.color.f157996aj4);
                this.M.setBackgroundColor(color);
                WebViewProvider webViewProvider = this.f314049f;
                if (webViewProvider != null && webViewProvider.getWebTitleBarInterface().a3() != null) {
                    this.f314049f.getWebTitleBarInterface().a3().setBackgroundColor(color);
                }
            }
            int g16 = ie0.a.f().g(BaseApplication.getContext(), com.tencent.mobileqq.webview.swift.utils.n.token_color_navText, 1001);
            this.f314054i.setTextColor(g16);
            this.C.setTextColor(g16);
            this.f314059m.setTextColor(g16);
            com.tencent.mobileqq.webview.swift.utils.o.d(this.f314054i, 2, com.tencent.mobileqq.webview.swift.utils.n.token_icon_navLeftBack, this.f314045d.F());
            com.tencent.mobileqq.webview.swift.utils.o.d(this.G, 1, com.tencent.mobileqq.webview.swift.utils.n.token_icon_navLeftClose, this.f314045d.F());
            com.tencent.mobileqq.webview.swift.utils.o.d(this.E, 1, com.tencent.mobileqq.webview.swift.utils.n.token_icon_navMore, this.f314045d.F());
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(Intent intent, String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) str);
            return;
        }
        if (intent != null && !TextUtils.isEmpty(str) && !this.f314047e.f314618a) {
            if (!TextUtils.isEmpty(str) && str.contains("youxi.vip.qq.com/imoj")) {
                intent.putExtra("isScreenOrientationPortrait", true);
            }
            if (intent.getBooleanExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false)) {
                this.f314054i.setVisibility(4);
            }
            y(intent);
            String stringExtra = intent.getStringExtra("title");
            TextView textView = this.f314059m;
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "";
            }
            textView.setText(stringExtra);
            this.f314047e.f314638u = intent.getBooleanExtra("ishiderefresh", false);
            this.f314047e.f314639v = intent.getBooleanExtra("ishidebackforward", false);
            this.f314047e.f314640w = intent.getBooleanExtra("show_right_close_button", false);
            if (!this.f314047e.f314630m) {
                com.tencent.mobileqq.webview.swift.utils.o.d(this.E, 1, com.tencent.mobileqq.webview.swift.utils.n.token_icon_navMore, this.f314045d.F());
                if (!this.f314045d.f314512m.f314619b) {
                    r rVar = this.f314047e;
                    if (!rVar.f314641x) {
                        WebViewTitleStyle webViewTitleStyle = rVar.T;
                        if (webViewTitleStyle != null) {
                            com.tencent.mobileqq.webview.swift.utils.o.f(this.E, 1, webViewTitleStyle.f313800h);
                        }
                        this.E.setVisibility(0);
                        this.E.setContentDescription(BaseApplication.getContext().getResources().getString(R.string.bbp));
                        if (this.f314063p0) {
                            this.E.setVisibility(8);
                        }
                    }
                }
                com.tencent.mobileqq.webview.swift.utils.o.f(this.E, 1, -1);
                this.E.setVisibility(0);
                this.E.setContentDescription(BaseApplication.getContext().getResources().getString(R.string.bbp));
                if (this.f314063p0) {
                }
            } else {
                this.E.setContentDescription(BaseApplication.getContext().getResources().getString(R.string.f170641x1));
            }
            if (r()) {
                if (!this.f314045d.f314512m.f314619b) {
                    r rVar2 = this.f314047e;
                    if (!rVar2.f314641x) {
                        WebViewTitleStyle webViewTitleStyle2 = rVar2.T;
                        if (webViewTitleStyle2 != null) {
                            z(webViewTitleStyle2.f313800h);
                        }
                    }
                }
                z(-1);
            }
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                i3 = ImmersiveUtils.getStatusBarHeight(this.f314045d.E) + 0;
            } else {
                i3 = 0;
            }
            this.M.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = i3 + this.M.getMeasuredHeight();
            if (this.f314047e.A) {
                int top = this.M.getTop() - measuredHeight;
                int bottom = this.M.getBottom() - measuredHeight;
                ViewGroup viewGroup = this.M;
                viewGroup.layout(viewGroup.getLeft(), top, this.M.getRight(), bottom);
                this.M.setVisibility(8);
            } else {
                int top2 = this.M.getTop() + measuredHeight;
                int bottom2 = this.M.getBottom() + measuredHeight;
                ViewGroup viewGroup2 = this.M;
                viewGroup2.layout(viewGroup2.getLeft(), top2, this.M.getRight(), bottom2);
                this.M.setVisibility(0);
            }
            if (this.f314047e.f314640w) {
                c0(intent.getStringExtra("left_close_button_text"));
            }
            L();
            o();
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        TouchWebView u16 = this.f314045d.u();
        if (u16 != null) {
            u16.setOnScrollChangedListenerForBiz(null);
        }
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        if (d().getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        if (this.f314045d.u() == null || this.f314045d.u().getPluginEngine() == null || this.f314064q0) {
            return false;
        }
        r rVar = this.f314047e;
        if (!rVar.U && !rVar.V) {
            return false;
        }
        return true;
    }

    public void s(WebView webView, String str, boolean z16) {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, webView, str, Boolean.valueOf(z16));
            return;
        }
        if (this.M != null && !this.f314047e.f314618a && (relativeLayout = (RelativeLayout) this.N.findViewById(R.id.jp7)) != null) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.jq5);
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.joi);
            if (z16) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(textView2, textView, str) { // from class: com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TextView f314066d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ TextView f314067e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f314068f;

                    {
                        this.f314066d = textView2;
                        this.f314067e = textView;
                        this.f314068f = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, SwiftIphoneTitleBarUI.this, textView2, textView, str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (!TextUtils.isEmpty(this.f314066d.getText().toString())) {
                            this.f314067e.setText(this.f314068f);
                        } else {
                            SwiftIphoneTitleBarUI.this.O(this.f314068f);
                        }
                    }
                }, 50L);
            } else if (!TextUtils.isEmpty(textView2.getText().toString())) {
                textView.setText(str);
            } else {
                O(str);
            }
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        Animation animation = this.X;
        if (animation != null) {
            animation.setAnimationListener(null);
        }
        Animation animation2 = this.Y;
        if (animation2 != null) {
            animation2.setAnimationListener(null);
        }
        WebViewTopTabView webViewTopTabView = this.f314060m0;
        if (webViewTopTabView != null) {
            webViewTopTabView.setOnCheckedChangeListener(null);
        }
    }

    @TargetApi(11)
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else if (this.U) {
            if (QLog.isColorLevel()) {
                QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, String.format("resetTitleBarButtonColor #%x", Integer.valueOf(this.V)));
            }
            S(this.V);
            this.U = false;
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "resetTitleBarTextColor");
        }
        TextView textView = this.f314054i;
        ColorStateList colorStateList = com.tencent.mobileqq.webview.swift.utils.n.token_color_navText_values;
        textView.setTextColor(colorStateList);
        this.C.setTextColor(colorStateList);
        this.f314059m.setTextColor(colorStateList);
        com.tencent.mobileqq.webview.swift.utils.o.f(this.f314054i, 2, 0);
        com.tencent.mobileqq.webview.swift.utils.o.f(this.E, 1, 0);
        com.tencent.mobileqq.webview.swift.utils.o.f(this.G, 1, 0);
        if (q()) {
            com.tencent.mobileqq.webview.swift.utils.o.f(this.L.findViewById(R.id.ews), 0, 0);
        }
        this.E.clearColorFilter();
    }

    public void x(View view, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (i17 == 0) {
            view.getBackground().mutate().setAlpha(i16);
            return;
        }
        ez ezVar = new ez(Integer.valueOf(i3), Integer.valueOf(i16), new d(view, i16));
        ezVar.setDuration(i17);
        this.f314047e.I = true;
        view.startAnimation(ezVar);
    }

    public void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else if (r()) {
            com.tencent.mobileqq.webview.swift.utils.o.f(this.L.findViewById(R.id.ews), 0, i3);
        }
    }
}

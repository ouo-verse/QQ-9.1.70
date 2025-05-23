package com.tencent.comic.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.api.impl.QQComicRedTouchServiceImpl;
import com.tencent.comic.api.impl.QQDcReporterImpl;
import com.tencent.comic.jsp.QQComicJsPlugin;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.VasApngDownloader;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.i;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicTabBarView extends LinearLayout implements i {

    /* renamed from: g0, reason: collision with root package name */
    static final Map<String, String> f99424g0;

    /* renamed from: h0, reason: collision with root package name */
    static final Map<String, String> f99425h0;

    /* renamed from: i0, reason: collision with root package name */
    static final Map<String, String> f99426i0;
    public final Paint C;
    public final Paint D;
    final int E;
    final int F;
    final int G;
    final int H;
    final int I;
    final float J;
    final int K;
    public TabBarView.d L;
    long M;
    float N;
    int P;
    int Q;
    int R;
    int S;
    boolean T;
    boolean U;
    LinearLayout.LayoutParams V;
    RelativeLayout.LayoutParams W;

    /* renamed from: a0, reason: collision with root package name */
    RelativeLayout.LayoutParams f99427a0;

    /* renamed from: b0, reason: collision with root package name */
    Interpolator f99428b0;

    /* renamed from: c0, reason: collision with root package name */
    Handler f99429c0;

    /* renamed from: d, reason: collision with root package name */
    SparseArray<RedAppInfo> f99430d;

    /* renamed from: d0, reason: collision with root package name */
    IQQComicRedTouchService f99431d0;

    /* renamed from: e, reason: collision with root package name */
    final com.tencent.comic.utils.e<String, RedTouchUI> f99432e;

    /* renamed from: e0, reason: collision with root package name */
    QQComicRedTouchServiceImpl.PluginRedTouchObserver f99433e0;

    /* renamed from: f, reason: collision with root package name */
    final com.tencent.comic.utils.e<String, String> f99434f;

    /* renamed from: f0, reason: collision with root package name */
    com.tencent.comic.jsp.a f99435f0;

    /* renamed from: h, reason: collision with root package name */
    List<WebViewTabBarData> f99436h;

    /* renamed from: i, reason: collision with root package name */
    AppInterface f99437i;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f99438m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                QQComicTabBarView qQComicTabBarView = QQComicTabBarView.this;
                qQComicTabBarView.N = 0.0f;
                QQComicTabBarView.super.invalidate();
                super.sendMessageDelayed(QQComicTabBarView.this.f99429c0.obtainMessage(1), 16L);
                return;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                QQComicTabBarView qQComicTabBarView2 = QQComicTabBarView.this;
                qQComicTabBarView2.N = 1.0f;
                qQComicTabBarView2.t(qQComicTabBarView2.R, qQComicTabBarView2.Q);
                QQComicTabBarView qQComicTabBarView3 = QQComicTabBarView.this;
                qQComicTabBarView3.R = qQComicTabBarView3.Q;
                QQComicTabBarView.super.invalidate();
                return;
            }
            QQComicTabBarView qQComicTabBarView4 = QQComicTabBarView.this;
            float f16 = qQComicTabBarView4.N;
            if (f16 < 1.0f) {
                qQComicTabBarView4.N = f16 + 0.05f;
                QQComicTabBarView.super.invalidate();
                super.sendMessageDelayed(QQComicTabBarView.this.f99429c0.obtainMessage(1), 16L);
                return;
            }
            super.sendMessageDelayed(qQComicTabBarView4.f99429c0.obtainMessage(2), 16L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends QQComicRedTouchServiceImpl.PluginRedTouchObserver {
        b() {
        }

        @Override // com.tencent.comic.api.impl.QQComicRedTouchServiceImpl.PluginRedTouchObserver
        public void a() {
            QQComicTabBarView.this.r();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements com.tencent.comic.jsp.a {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final WeakReference<QQComicTabBarView> f99448d;

        /* renamed from: e, reason: collision with root package name */
        final int f99449e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f99450f;

        /* renamed from: h, reason: collision with root package name */
        final List<WebViewTabBarData> f99451h;

        d(QQComicTabBarView qQComicTabBarView, int i3, boolean z16, List<WebViewTabBarData> list) {
            this.f99448d = new WeakReference<>(qQComicTabBarView);
            this.f99449e = i3;
            this.f99450f = z16;
            this.f99451h = list;
        }

        void a(QQComicTabBarView qQComicTabBarView) {
            QQComicJsPlugin th5;
            if (qQComicTabBarView.getContext() instanceof QQBrowserActivity) {
                WebViewProvider webViewProvider = ((QQBrowserActivity) qQComicTabBarView.getContext()).getWebViewProvider();
                if ((webViewProvider instanceof QQComicFragment) && (th5 = ((QQComicFragment) webViewProvider).th()) != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("source", "comic");
                    } catch (JSONException e16) {
                        QLog.e("WebViewTabBarView", 1, e16, new Object[0]);
                    }
                    th5.dispatchJsEvent("qbrowserTabClick", null, jSONObject);
                }
            }
            List<WebViewTabBarData> list = this.f99451h;
            if (list != null) {
                int size = list.size();
                int i3 = this.f99449e;
                if (size > i3) {
                    QQComicTabBarView.p(qQComicTabBarView.f99437i, this.f99451h.get(i3).tag, true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QQComicTabBarView qQComicTabBarView = this.f99448d.get();
            if (qQComicTabBarView == null) {
                return;
            }
            if (this.f99449e == qQComicTabBarView.R) {
                a(qQComicTabBarView);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - qQComicTabBarView.M < 500) {
                return;
            }
            qQComicTabBarView.M = currentTimeMillis;
            qQComicTabBarView.setSelectedTab(this.f99449e, this.f99450f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public SimpleTextView f99452a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f99453b;

        /* renamed from: c, reason: collision with root package name */
        public URLDrawable f99454c;

        /* renamed from: d, reason: collision with root package name */
        RedTouchUI f99455d;

        public e() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f99424g0 = hashMap;
        hashMap.put("index", "1113.100800");
        hashMap.put(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV, "1113.100801");
        hashMap.put("category", "1113.100804");
        hashMap.put("more", "1113.100802");
        hashMap.put(VipFunCallConstants.KEY_GROUP, "1113.100803");
        HashMap hashMap2 = new HashMap(5);
        f99425h0 = hashMap2;
        HashMap hashMap3 = new HashMap(5);
        f99426i0 = hashMap3;
        hashMap2.put("index", "200458");
        hashMap2.put(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV, "200459");
        hashMap2.put("category", "200460");
        hashMap2.put("more", "200461");
        hashMap2.put(VipFunCallConstants.KEY_GROUP, "200462");
        hashMap3.put("index", "100");
        hashMap3.put(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV, "102");
        hashMap3.put("category", "101");
        hashMap3.put("more", "103");
        hashMap3.put(VipFunCallConstants.KEY_GROUP, "104");
    }

    public QQComicTabBarView(Context context) {
        super(context);
        this.f99430d = new SparseArray<>();
        this.f99432e = new com.tencent.comic.utils.e<>();
        this.f99434f = new com.tencent.comic.utils.e<>();
        this.f99437i = null;
        this.M = 0L;
        this.P = 0;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = true;
        this.U = true;
        this.f99428b0 = new AccelerateDecelerateInterpolator();
        this.f99429c0 = new a(Looper.getMainLooper());
        this.f99431d0 = null;
        this.f99433e0 = new b();
        this.f99435f0 = new c();
        Resources resources = super.getContext().getResources();
        this.F = RichStatus.ACTION_COLOR_NORMAL;
        this.E = -14629889;
        this.J = TypedValue.applyDimension(2, 17.0f, resources.getDisplayMetrics());
        this.G = -14629889;
        this.H = (int) TypedValue.applyDimension(1, 6.0f, resources.getDisplayMetrics());
        this.I = RichStatus.ACTION_COLOR_NORMAL;
        int applyDimension = (int) TypedValue.applyDimension(1, 54.0f, resources.getDisplayMetrics());
        this.K = applyDimension;
        this.f99438m = new Paint(1);
        Paint paint = new Paint();
        this.C = paint;
        paint.setColor(-14629889);
        Paint paint2 = new Paint();
        this.D = paint2;
        paint2.setColor(RichStatus.ACTION_COLOR_NORMAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        this.V = layoutParams;
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.W = layoutParams2;
        layoutParams2.addRule(13);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        this.f99427a0 = layoutParams3;
        layoutParams3.addRule(13);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.comic.ui.QQComicTabBarView.4
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawable = QQComicTabBarView.this.getResources().getDrawable(R.drawable.f159945in1);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.ui.QQComicTabBarView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQComicTabBarView.this.setBackgroundDrawable(drawable);
                    }
                });
            }
        }, 5, null, false);
        setLayerType(2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (com.tencent.comic.data.f.f99359p.optInt(com.tencent.comic.api.IQQComicConfigApi.NAV_SWITCH_ANIMATION, 1) == 1) goto L12;
     */
    @Override // com.tencent.mobileqq.webview.swift.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Intent intent, List<WebViewTabBarData> list, TabBarView.d dVar) {
        int i3;
        this.L = dVar;
        if (intent != null) {
            i3 = intent.getIntExtra("key_maintab", -1);
            intent.removeExtra("key_maintab");
        } else {
            i3 = -1;
        }
        boolean z16 = ah.k0() ? false : true;
        this.U = z16;
        this.f99436h = list;
        if (list != null) {
            Iterator<WebViewTabBarData> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().tabIcon)) {
                    this.T = false;
                }
            }
            for (WebViewTabBarData webViewTabBarData : list) {
                h(super.getChildCount(), webViewTabBarData.tag, webViewTabBarData.tabName, webViewTabBarData.tabIcon);
            }
        }
        super.setVisibility(0);
        r();
        if (i3 != -1) {
            this.P = i3;
            s(this.S, i3);
            int i16 = this.P;
            this.R = i16;
            this.S = i16;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.T) {
            k(canvas);
            return;
        }
        View childAt = super.getChildAt(this.R);
        View childAt2 = super.getChildAt(this.Q);
        if (childAt != null && childAt2 != null) {
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.N > 0.0f) {
                boolean z16 = this.R < this.Q;
                int left2 = (int) (childAt.getLeft() + (n(this.N, z16) * (childAt2.getLeft() - childAt.getLeft())));
                int right2 = (int) (childAt.getRight() + (n(this.N, !z16) * (childAt2.getRight() - childAt.getRight())));
                left = left2;
                right = right2;
            }
            canvas.drawRect(left, super.getHeight() - this.H, right, super.getHeight(), this.C);
            this.D.setAlpha((int) ((1.0f - this.N) * 96.0f));
            canvas.drawCircle((childAt2.getLeft() + childAt2.getRight()) / 2, (childAt2.getTop() + childAt2.getBottom()) / 2, ((childAt2.getRight() - childAt2.getLeft()) / 2) * 1.2f * this.N, this.D);
        }
        k(canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        if (r9 == r12.length) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String j(String str, int i3) {
        int i16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder obtainStringBuilder = QQDcReporterImpl.obtainStringBuilder();
        if (i3 != 0) {
            i16 = i3 == 1 ? -100000000 : 100000000;
            return null;
        }
        obtainStringBuilder.append(BusinessInfoCheckUpdateItem.UIAPPID_LEBA_MORE);
        obtainStringBuilder.append('.');
        boolean z16 = false;
        if (str.contains(".")) {
            String[] split = str.split("\\.");
            if (split.length > 0) {
                int i17 = 0;
                for (String str2 : split) {
                    try {
                        obtainStringBuilder.append(Integer.parseInt(str2) + i16);
                        obtainStringBuilder.append('.');
                        i17++;
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            if (z16) {
                if (obtainStringBuilder.length() > 0 && obtainStringBuilder.charAt(obtainStringBuilder.length() - 1) == '.') {
                    obtainStringBuilder.deleteCharAt(obtainStringBuilder.length() - 1);
                }
                if (i3 == 1) {
                    int indexOf = obtainStringBuilder.indexOf(".");
                    if (indexOf < 0) {
                        return null;
                    }
                    return obtainStringBuilder.substring(indexOf + 1);
                }
                return obtainStringBuilder.toString();
            }
            return null;
        }
        try {
            obtainStringBuilder.append(Integer.parseInt(str) + i16);
        } catch (NumberFormatException e17) {
            e17.printStackTrace();
        }
        z16 = true;
        if (z16) {
        }
        return null;
    }

    public void k(Canvas canvas) {
        if ("1103".equals(ThemeUtil.curThemeId) || "2920".equals(ThemeUtil.curThemeId)) {
            canvas.drawColor(Integer.MIN_VALUE);
        }
    }

    public int l() {
        return this.R;
    }

    void o() {
        for (Map.Entry<String, RedTouchUI> entry : this.f99432e.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                RedTouchUI value = entry.getValue();
                if (key != null && value != null && value.hasRedTouch() && this.f99437i != null) {
                    if ("1113.100800".equals(key)) {
                        ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(this.f99437i, "3014", "1", "30012", "", "100");
                    } else if ("1113.100801".equals(key)) {
                        ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(this.f99437i, "3014", "1", "30012", "", "102");
                    } else if ("1113.100802".equals(key)) {
                        ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(this.f99437i, "3014", "1", "30012", "", "103");
                    } else if ("1113.100803".equals(key)) {
                        ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(this.f99437i, "3014", "1", "30012", "", "104");
                    } else if ("1113.100804".equals(key)) {
                        ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(this.f99437i, "3014", "1", "30012", "", "101");
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.comic.ui.QQComicTabBarView.5
            @Override // java.lang.Runnable
            public void run() {
                QQComicTabBarView.this.f99437i = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
                QQComicTabBarView qQComicTabBarView = QQComicTabBarView.this;
                qQComicTabBarView.f99431d0 = (IQQComicRedTouchService) qQComicTabBarView.f99437i.getRuntimeService(IQQComicRedTouchService.class, "all");
                QQComicTabBarView qQComicTabBarView2 = QQComicTabBarView.this;
                IQQComicRedTouchService iQQComicRedTouchService = qQComicTabBarView2.f99431d0;
                if (iQQComicRedTouchService != null) {
                    iQQComicRedTouchService.addObserver(qQComicTabBarView2.f99433e0);
                }
                boolean z16 = QQComicPluginBridge.f99473b;
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewTabBarView", 2, "register observers");
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.comic.ui.QQComicTabBarView.6
            @Override // java.lang.Runnable
            public void run() {
                QQComicTabBarView qQComicTabBarView = QQComicTabBarView.this;
                IQQComicRedTouchService iQQComicRedTouchService = qQComicTabBarView.f99431d0;
                if (iQQComicRedTouchService != null) {
                    iQQComicRedTouchService.deleteObserver(qQComicTabBarView.f99433e0);
                }
                boolean z16 = QQComicPluginBridge.f99473b;
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewTabBarView", 2, "unregister observers");
                }
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.K, 1073741824));
        super.setMeasuredDimension(super.getMeasuredWidth(), this.K);
    }

    void r() {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.comic.ui.QQComicTabBarView.7
            @Override // java.lang.Runnable
            public void run() {
                final boolean z16;
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewTabBarView", 2, "start getRedAppInfo");
                }
                IQQComicRedTouchService iQQComicRedTouchService = (IQQComicRedTouchService) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getRuntimeService(IQQComicRedTouchService.class, "all");
                final ArrayList<String> arrayList = new ArrayList<>();
                if (iQQComicRedTouchService.isLebaItemOpen(1113)) {
                    arrayList.addAll(QQComicTabBarView.this.f99432e.keySet());
                    z16 = true;
                } else {
                    Iterator<String> it = QQComicTabBarView.this.f99432e.keySet().iterator();
                    while (it.hasNext()) {
                        arrayList.add(QQComicTabBarView.this.f99434f.get(it.next()));
                    }
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewTabBarView", 2, "isLebaItemOpen=" + z16 + ", resId=1113");
                }
                final Map<String, Object> redAppInfo = iQQComicRedTouchService.getRedAppInfo(arrayList);
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewTabBarView", 2, "end getRedAppInfo map is " + redAppInfo);
                }
                if (redAppInfo != null) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.ui.QQComicTabBarView.7.1
                        /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
                        /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
                        /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            RedTouchUI redTouchUI;
                            Iterator it5;
                            RedTouchUI redTouchUI2;
                            if (QLog.isColorLevel()) {
                                QLog.d("WebViewTabBarView", 2, "start show red touch");
                            }
                            int l3 = QQComicTabBarView.this.l();
                            if (l3 >= 0 && l3 < QQComicTabBarView.super.getChildCount()) {
                                Object tag = QQComicTabBarView.super.getChildAt(l3).getTag(-3);
                                if (tag instanceof e) {
                                    redTouchUI = ((e) tag).f99455d;
                                    it5 = arrayList.iterator();
                                    while (it5.hasNext()) {
                                        String str = (String) it5.next();
                                        if (z16) {
                                            redTouchUI2 = QQComicTabBarView.this.f99432e.get(str);
                                        } else {
                                            QQComicTabBarView qQComicTabBarView = QQComicTabBarView.this;
                                            redTouchUI2 = qQComicTabBarView.f99432e.get(qQComicTabBarView.f99434f.c(str));
                                        }
                                        if (redTouchUI2 != null && !redTouchUI2.equals(redTouchUI)) {
                                            QQComicTabBarView.this.q(redTouchUI2, (RedAppInfo) redAppInfo.get(str), false);
                                        } else if (QLog.isColorLevel()) {
                                            QLog.d("WebViewTabBarView", 2, "cannot find red touch on path: " + str);
                                        }
                                    }
                                    QQComicTabBarView.this.o();
                                    if (QLog.isColorLevel()) {
                                        return;
                                    }
                                    QLog.d("WebViewTabBarView", 2, "end show red touch");
                                    return;
                                }
                            }
                            redTouchUI = null;
                            it5 = arrayList.iterator();
                            while (it5.hasNext()) {
                            }
                            QQComicTabBarView.this.o();
                            if (QLog.isColorLevel()) {
                            }
                        }
                    });
                }
            }
        }, null, false);
    }

    void s(int i3, int i16) {
        SimpleTextView simpleTextView;
        if (QLog.isColorLevel()) {
            QLog.d("WebViewTabBarView", 2, "tab switch : old=" + i3 + ", new=" + i16);
        }
        View childAt = super.getChildAt(i3);
        if (childAt != null) {
            Object tag = childAt.getTag(-3);
            if (tag instanceof e) {
                e eVar = (e) tag;
                eVar.f99452a.setVisibility(0);
                eVar.f99453b.setVisibility(8);
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewTabBarView", 2, "tab icon hide.");
                }
            }
        }
        View childAt2 = super.getChildAt(i16);
        if (childAt2 != null) {
            Object tag2 = childAt2.getTag(-3);
            if (tag2 instanceof e) {
                e eVar2 = (e) tag2;
                if (eVar2.f99453b == null || (simpleTextView = eVar2.f99452a) == null) {
                    return;
                }
                simpleTextView.setVisibility(8);
                URLDrawable uRLDrawable = eVar2.f99454c;
                eVar2.f99453b.setVisibility(0);
                eVar2.f99453b.setImageDrawable(uRLDrawable);
                if (uRLDrawable != null && (uRLDrawable.getCurrDrawable() instanceof ApngDrawable)) {
                    ((ApngDrawable) uRLDrawable.getCurrDrawable()).repaly();
                    if (QLog.isColorLevel()) {
                        QLog.d("WebViewTabBarView", 2, "tab icon anim play.");
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewTabBarView", 2, "tab icon show.");
                }
            }
        }
    }

    void t(int i3, int i16) {
        View childAt = super.getChildAt(i3);
        if (childAt != null) {
            Object tag = childAt.getTag(-3);
            if (tag instanceof e) {
                ((e) tag).f99452a.setTextColor(this.F);
            }
        }
        View childAt2 = super.getChildAt(i16);
        if (childAt2 != null) {
            Object tag2 = childAt2.getTag(-3);
            if (tag2 instanceof e) {
                ((e) tag2).f99452a.setTextColor(this.E);
            }
        }
    }

    static void p(AppInterface appInterface, String str, boolean z16) {
        String str2;
        if (appInterface != null) {
            String str3 = f99425h0.get(str);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            IQQDcReporter iQQDcReporter = (IQQDcReporter) QRoute.api(IQQDcReporter.class);
            if (z16) {
                str2 = "1";
            } else {
                str2 = "";
            }
            iQQDcReporter.reportDC00145_3(appInterface, "3071", "2", str3, "", "", "", "", "", "", str2, new String[0]);
        }
    }

    void i(int i3) {
        RedTouchUI redTouchUI;
        if (i3 < 0 || i3 >= super.getChildCount()) {
            return;
        }
        Object tag = super.getChildAt(i3).getTag(-3);
        if ((tag instanceof e) && (redTouchUI = ((e) tag).f99455d) != null && redTouchUI.hasRedTouch()) {
            redTouchUI.clearRedTouch();
            String c16 = this.f99432e.c(redTouchUI);
            IQQComicRedTouchService iQQComicRedTouchService = this.f99431d0;
            if (iQQComicRedTouchService != null) {
                iQQComicRedTouchService.reportRedTouchClick(c16);
                this.f99431d0.reportRedTouchClick(this.f99434f.get(c16));
            }
            RedAppInfo redAppInfo = this.f99430d.get(i3);
            if ((redAppInfo == null || redTouchUI.f99464h != redAppInfo) && this.f99437i != null) {
                ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(this.f99437i, "3014", "2", "40049", "", f99426i0.get(this.f99436h.get(i3).tag));
            }
        }
    }

    void m(int i3, boolean z16) {
        RedTouchUI redTouchUI;
        if (i3 < 0 || i3 >= super.getChildCount()) {
            return;
        }
        Object tag = super.getChildAt(i3).getTag(-3);
        if ((tag instanceof e) && (redTouchUI = ((e) tag).f99455d) != null) {
            redTouchUI.clearRedTouch();
            if (z16) {
                boolean z17 = QQComicPluginBridge.f99473b;
            }
        }
    }

    void q(RedTouchUI redTouchUI, RedAppInfo redAppInfo, boolean z16) {
        if (redTouchUI == null || redAppInfo == null || redAppInfo.F() == null || redAppInfo.F().c() == null) {
            return;
        }
        if (!z16 || redTouchUI.f99464h == null) {
            ArrayList<RedTypeInfo> arrayList = new ArrayList<>(1);
            Iterator<RedTypeInfo> it = redAppInfo.F().c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RedTypeInfo next = it.next();
                if (next.getRedType() != 9) {
                    if (next.getRedType() == 3 || next.getRedType() == 4) {
                        next.setRedType(0);
                    }
                    if (next.getRedType() == 0) {
                        redTouchUI.setMargin(0, 13, 12, 0).applyTo();
                    } else {
                        redTouchUI.setMargin(0, 8, 7, 0).applyTo();
                    }
                    arrayList.add(next);
                }
            }
            redAppInfo.F().f(arrayList);
            redTouchUI.e(redAppInfo);
        }
    }

    public void setSelectedTab(int i3, boolean z16) {
        if (i3 < 0) {
            i3 = 0;
        }
        int childCount = super.getChildCount();
        if (i3 >= childCount) {
            i3 = childCount - 1;
        }
        int i16 = this.R;
        if (i16 != i3) {
            TabBarView.d dVar = this.L;
            if (dVar != null) {
                dVar.a(i16, i3);
            }
            if (this.T) {
                s(this.S, i3);
            }
            if (z16) {
                this.Q = i3;
                this.N = 0.0f;
                this.f99429c0.sendEmptyMessage(0);
            } else {
                this.Q = i3;
                this.N = 1.0f;
                this.f99429c0.sendEmptyMessage(2);
            }
            this.S = this.Q;
            p(this.f99437i, this.f99436h.get(i3).tag, false);
            i(i3);
            m(i3, i3 == VipComicJumpActivity.Y2(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV, this.f99436h));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View h(int i3, String str, String str2, String str3) {
        boolean z16;
        boolean isApngFile;
        ColorDrawable colorDrawable;
        if (i3 >= 0 && i3 <= super.getChildCount()) {
            RelativeLayout relativeLayout = new RelativeLayout(super.getContext());
            SimpleTextView simpleTextView = new SimpleTextView(super.getContext());
            simpleTextView.setText(str2);
            simpleTextView.setTextSize(0, this.J);
            simpleTextView.setTextColor(this.F);
            simpleTextView.setContentDescription(str2);
            simpleTextView.setGravity(17);
            e eVar = new e();
            eVar.f99452a = simpleTextView;
            relativeLayout.setTag(-3, eVar);
            relativeLayout.setOnClickListener(new d(this, i3, !this.T, this.f99436h));
            relativeLayout.addView(simpleTextView, this.W);
            if (this.T) {
                ImageView imageView = new ImageView(super.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                File file = new File(str3);
                ColorDrawable colorDrawable2 = new ColorDrawable(getResources().getColor(17170445));
                boolean z17 = this.U;
                if (z17) {
                    try {
                        isApngFile = ApngDrawable.isApngFile(file);
                    } catch (IOException e16) {
                        z16 = z17;
                        QLog.e("WebViewTabBarView", 1, e16, new Object[0]);
                    }
                    if (isApngFile) {
                        colorDrawable = colorDrawable2;
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt("key_loop", 1);
                        bundle.putFloat(VasApngDownloader.VasApngImage.KEY_FRAME_DELAY_FRACTION, 0.6f);
                        colorDrawable = colorDrawable2;
                        URLDrawable apngDrawable = VasApngUtil.getApngDrawable(this.f99437i, str3, "-comic-tab-bar-", colorDrawable2, new int[]{12}, "-comic-tab-bar-", bundle);
                        if (apngDrawable == null) {
                            isApngFile = false;
                        } else if (!ApngImage.canDecodeIDs.contains(12)) {
                            ApngImage.canDecodeIDs.add(12);
                        }
                        eVar.f99454c = apngDrawable;
                    }
                    if (!isApngFile) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = colorDrawable;
                        obtain.mFailedDrawable = colorDrawable;
                        eVar.f99454c = URLDrawable.getDrawable(file, obtain);
                    }
                    eVar.f99453b = imageView;
                    relativeLayout.addView(imageView, this.f99427a0);
                    imageView.setVisibility(8);
                } else {
                    z16 = z17;
                }
                isApngFile = z16;
                if (isApngFile) {
                }
                if (!isApngFile) {
                }
                eVar.f99453b = imageView;
                relativeLayout.addView(imageView, this.f99427a0);
                imageView.setVisibility(8);
            }
            super.addView(relativeLayout, i3, this.V);
            Map<String, String> map = f99424g0;
            if (map.containsKey(str)) {
                String str4 = map.get(str);
                RedTouchUI redTouchUI = (RedTouchUI) new RedTouchUI(super.getContext(), simpleTextView).setGravity(5).applyTo();
                redTouchUI.setRedpointImgResID(R.drawable.skin_tips_dot);
                redTouchUI.setTextOrNumImgRedID(R.drawable.skin_tips_newmessage);
                this.f99434f.put(str4, j(str4, 0));
                this.f99432e.put(str4, redTouchUI);
                eVar.f99455d = redTouchUI;
            }
            if (AppSetting.f99565y) {
                relativeLayout.setContentDescription(str2);
            }
            return simpleTextView;
        }
        throw new IllegalArgumentException("position is not legal, please check!");
    }

    float n(float f16, boolean z16) {
        float f17 = z16 ? f16 < 0.6f ? 0.0f : (f16 - 0.6f) / 0.4f : f16 < 0.6f ? f16 / 0.6f : 1.0f;
        Interpolator interpolator = this.f99428b0;
        return interpolator != null ? interpolator.getInterpolation(f17) : f17;
    }

    @Override // com.tencent.mobileqq.webview.swift.i
    public View b() {
        return this;
    }
}

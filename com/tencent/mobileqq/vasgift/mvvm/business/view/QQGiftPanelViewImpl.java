package com.tencent.mobileqq.vasgift.mvvm.business.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqgift.utils.QQGiftPanelUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.BalanceExplainDialogData;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.util.VasPadUtils;
import com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report;
import com.tencent.mobileqq.vasgift.business.dt.VasGiftDtReportHelper;
import com.tencent.mobileqq.vasgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.mobileqq.vasgift.view.QQLiveGiftComboSendView;
import com.tencent.mobileqq.vasgift.view.QQVasGiftComboSendView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import sh2.c;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes20.dex */
public class QQGiftPanelViewImpl extends LinearLayout implements sh2.c, View.OnClickListener, ph2.b {
    private String A0;
    private c.g B0;
    private LinearLayout C;
    private WeakReference<c.e> C0;
    private final nh2.c D;
    private final Runnable D0;
    private final AtomicBoolean E;
    private final RecyclerView.OnScrollListener E0;
    private final AtomicBoolean F;
    private Long F0;
    private int G;
    private final Observer<Long> G0;
    private com.tencent.mobileqq.qqgift.data.service.d H;
    private Long H0;
    private int I;
    private final Observer<Long> I0;
    private PagerSnapHelper J;
    private final Observer<Integer> J0;
    private StaggeredGridLayoutManager K;
    private final Observer<com.tencent.mobileqq.qqgift.data.service.d> K0;
    private com.tencent.mobileqq.vasgift.utils.f L;
    private LifecycleOwner M;
    private LinearLayout N;
    private TextView P;
    private TextView Q;
    private View R;
    private QQVasGiftComboSendView S;
    private int T;
    private LinearLayout U;
    private LinearLayout V;
    private LinearLayout W;

    /* renamed from: a0, reason: collision with root package name */
    private CustomTabLayoutCompat f311913a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f311914b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f311915c0;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f311916d;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f311917d0;

    /* renamed from: e, reason: collision with root package name */
    private QQGiftPanelViewModel f311918e;

    /* renamed from: e0, reason: collision with root package name */
    private List<com.tencent.mobileqq.qqgift.mvvm.business.data.c> f311919e0;

    /* renamed from: f, reason: collision with root package name */
    private TextView f311920f;

    /* renamed from: f0, reason: collision with root package name */
    private final List<ImageView> f311921f0;

    /* renamed from: g0, reason: collision with root package name */
    private Drawable f311922g0;

    /* renamed from: h, reason: collision with root package name */
    private TextView f311923h;

    /* renamed from: h0, reason: collision with root package name */
    private Drawable f311924h0;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f311925i;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.vasgift.business.dt.a f311926i0;

    /* renamed from: j0, reason: collision with root package name */
    private VasGift04586Report f311927j0;

    /* renamed from: k0, reason: collision with root package name */
    private d43.b f311928k0;

    /* renamed from: l0, reason: collision with root package name */
    private Queue<d43.b> f311929l0;

    /* renamed from: m, reason: collision with root package name */
    private URLImageView f311930m;

    /* renamed from: m0, reason: collision with root package name */
    private RelativeLayout f311931m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f311932n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f311933o0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f311934p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f311935q0;

    /* renamed from: r0, reason: collision with root package name */
    private View f311936r0;

    /* renamed from: s0, reason: collision with root package name */
    private ImageView f311937s0;

    /* renamed from: t0, reason: collision with root package name */
    private ImageView f311938t0;

    /* renamed from: u0, reason: collision with root package name */
    private TextView f311939u0;

    /* renamed from: v0, reason: collision with root package name */
    private TextView f311940v0;

    /* renamed from: w0, reason: collision with root package name */
    private TextView f311941w0;

    /* renamed from: x0, reason: collision with root package name */
    private TextView f311942x0;

    /* renamed from: y0, reason: collision with root package name */
    private QQLiveGiftComboSendView f311943y0;

    /* renamed from: z0, reason: collision with root package name */
    private Boolean f311944z0;

    /* loaded from: classes20.dex */
    class a implements Observer<Long> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            QQGiftPanelViewImpl.this.F0 = l3;
            QQGiftPanelViewImpl.this.f311926i0.l(QQGiftPanelViewImpl.this.V, l3);
            QQGiftPanelViewImpl.this.f311927j0.A0(l3.longValue());
        }
    }

    /* loaded from: classes20.dex */
    class b implements Observer<Long> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            QQGiftPanelViewImpl.this.H0 = l3;
        }
    }

    /* loaded from: classes20.dex */
    class c implements Observer<Integer> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num.intValue() == 1) {
                QQGiftPanelViewImpl.this.M0();
            }
        }
    }

    /* loaded from: classes20.dex */
    class d implements Observer<com.tencent.mobileqq.qqgift.data.service.d> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            QQGiftPanelViewImpl.this.J0(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f311949d;

        e(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            this.f311949d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.qqgift.webview.e.a(this.f311949d.f264882h0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class f implements View.OnLayoutChangeListener {
        f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            int i29 = i18 - i16;
            int i36 = i28 - i26;
            if (i29 != i36 && QQGiftPanelViewImpl.this.C0 != null && QQGiftPanelViewImpl.this.C0.get() != 0) {
                ((c.e) QQGiftPanelViewImpl.this.C0.get()).a(i29, i36);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            QQGiftPanelViewImpl.this.hide();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            QQGiftPanelViewImpl.this.hide();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGiftPanelViewImpl.this.C0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGiftPanelViewImpl.this.f311931m0.setVisibility(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes20.dex */
    class l extends RecyclerView.OnScrollListener {
        l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            QQGiftPanelViewImpl.this.F0(i3);
            QQGiftPanelViewImpl.this.i0(i3);
            QQGiftPanelViewImpl.this.n0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    public QQGiftPanelViewImpl(Context context, nh2.c cVar) {
        this(context, cVar, null);
    }

    private void A0() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f311918e.f();
        VasPerfReportUtils.report(VasPerfReportUtils.WHILE_ON_PANEL_SHOW, VasPerfReportUtils.WITHIN_BUSINESS, this.D.getSDKConfig().f264972a + "", "", System.currentTimeMillis() - currentTimeMillis);
        this.f311918e.C.observeForever(this.G0);
        this.f311918e.D.observeForever(this.J0);
        this.f311918e.E.observeForever(this.K0);
        this.f311918e.f311670i.observeForever(this.I0);
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        com.tencent.mobileqq.vasgift.utils.l lVar = com.tencent.mobileqq.vasgift.utils.l.f312038a;
        IVasTempApi.INSTANCE.get().showCoinExplainDialog(getContext(), new BalanceExplainDialogData(this.F0.longValue(), this.H0.longValue(), lVar.b(this.D.getAppRuntime(), "explainText"), QQGiftPanelUtil.a(this.D.getSDKConfig().f264978g), lVar.b(this.D.getAppRuntime(), WadlProxyConsts.KEY_JUMP_URL), lVar.a(this.D.getAppRuntime())));
    }

    private void D0() {
        int i3;
        boolean z16;
        O0(null);
        if (this.f311918e.G2().getValue() != null) {
            List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = this.f311918e.G2().getValue().a();
            if (a16 != null && !a16.isEmpty()) {
                List<com.tencent.mobileqq.qqgift.mvvm.business.data.c> list = this.f311919e0;
                boolean z17 = true;
                if (list != null && !list.isEmpty()) {
                    i3 = 0;
                    for (com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar : this.f311919e0) {
                        i3 = Math.max(i3, (cVar.f264969f - cVar.f264968e) + 1);
                    }
                } else {
                    i3 = 0;
                }
                if (this.T != i3) {
                    this.T = i3;
                    this.C.removeAllViews();
                    this.f311921f0.clear();
                    int i16 = 0;
                    z16 = false;
                    while (i16 < this.T) {
                        ImageView imageView = new ImageView(getContext());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.setMinimumWidth(ViewUtils.dpToPx(6.0f));
                        imageView.setMinimumHeight(ViewUtils.dpToPx(4.0f));
                        imageView.setMaxWidth(ViewUtils.dpToPx(17.0f));
                        imageView.setAdjustViewBounds(true);
                        this.f311921f0.add(imageView);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                        layoutParams.setMargins(ViewUtils.dpToPx(3.0f), 0, ViewUtils.dpToPx(3.0f), 0);
                        this.C.addView(imageView, layoutParams);
                        i16++;
                        z16 = true;
                    }
                } else {
                    z16 = false;
                }
                P0();
                int max = Math.max(this.G, 0);
                if (!this.f311918e.e3()) {
                    z17 = z16;
                }
                c0(max, z17);
                return;
            }
            this.C.setVisibility(4);
        }
    }

    private void E0() {
        try {
            MutableLiveData<Integer> R2 = this.f311918e.R2();
            if (R2 != null && R2.getValue().intValue() == 1) {
                R2.setValue(0);
            }
        } catch (Throwable th5) {
            QLog.e("QQGiftPanelViewImpl", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i3) {
        int i16;
        if (i3 == 0) {
            View findSnapView = this.J.findSnapView(this.K);
            int i17 = 0;
            if (findSnapView != null) {
                i16 = this.K.getPosition(findSnapView);
                b0(i16);
            } else {
                i16 = 0;
            }
            if (this.f311919e0 != null) {
                int i18 = 0;
                while (true) {
                    if (i18 >= this.f311919e0.size()) {
                        break;
                    }
                    com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar = this.f311919e0.get(i18);
                    if (i16 >= cVar.f264968e && i16 <= cVar.f264969f) {
                        i17 = i18;
                        break;
                    }
                    i18++;
                }
                if (this.f311913a0.y(i17) != null) {
                    this.f311913a0.y(i17).i();
                }
            }
            k0(i16);
            k0(i16 + 1);
            if (QLog.isColorLevel()) {
                QLog.i("QQGiftPanelViewImpl", 2, "[onScrollStateChanged] mCurrentPage:" + i16 + ",snapView:" + findSnapView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar) {
        int i3;
        if (this.f311918e.G2().getValue() != null) {
            List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = this.f311918e.G2().getValue().a();
            if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(BaseApplication.getContext())) {
                i3 = 10;
            } else {
                i3 = 8;
            }
            int i16 = cVar.f264967d;
            int i17 = i16 % i3;
            int i18 = cVar.f264968e + (i16 / i3);
            if (i18 < a16.size() && i17 < a16.get(i18).size()) {
                this.f311918e.H3(a16.get(i18).get(i17));
            } else {
                this.f311918e.u0(null, -1);
            }
        }
    }

    private void H0(String str) {
        CustomTabLayoutCompat customTabLayoutCompat = this.f311913a0;
        if (customTabLayoutCompat == null) {
            return;
        }
        int z16 = customTabLayoutCompat.z();
        for (int i3 = 0; i3 < z16; i3++) {
            CustomTabLayoutCompat.f y16 = this.f311913a0.y(i3);
            if (y16 != null && (y16.e() instanceof String) && str.equals((String) y16.e())) {
                this.f311913a0.I(y16);
                return;
            }
        }
    }

    private void K0() {
        if (com.tencent.mobileqq.vasgift.utils.k.f312037a.a(this.D)) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            if (from.decodeBool("batch_gift_guild_sp", false)) {
                return;
            }
            from.encodeBool("batch_gift_guild_sp", true);
            findViewById(R.id.t5e).setVisibility(0);
            View findViewById = findViewById(R.id.u8d);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQGiftPanelViewImpl.this.x0(view);
                }
            });
            postDelayed(this.D0, 5000L);
        }
    }

    private void L0(View view, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        ViewParent parent = getParent();
        if (parent != null) {
            QLog.i("QQGiftPanelViewImpl", 1, "[show] already has parent: " + parent);
            return;
        }
        this.f311926i0.b(this, this.S, this.V);
        this.f311926i0.m(k());
        this.f311926i0.f(this.W);
        this.f311926i0.q(this.f311913a0);
        this.f311927j0.v0();
        measure(0, 0);
        Context context = getContext();
        com.tencent.mobileqq.vasgift.utils.f fVar = new com.tencent.mobileqq.vasgift.utils.f(context, this, VasPadUtils.INSTANCE.getSplitRightWidth(context), -1);
        this.L = fVar;
        fVar.j(false);
        this.L.k(z16);
        a0(z16, currentTimeMillis);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed() && view != null) {
                try {
                    if (z16) {
                        this.L.m(view);
                    } else {
                        this.L.l(view);
                    }
                    return;
                } catch (WindowManager.BadTokenException unused) {
                    QLog.i("QQGiftPanelViewImpl", 1, "[show] activity is BadTokenException");
                    return;
                }
            }
            QLog.i("QQGiftPanelViewImpl", 1, "[show] activity is destroy");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        if (u0() || !e0()) {
            return;
        }
        this.f311931m0 = (RelativeLayout) findViewById(R.id.f7589407);
        this.f311932n0 = (TextView) findViewById(R.id.f110516iq);
        this.f311933o0 = (TextView) findViewById(R.id.f110526ir);
        this.f311934p0 = (ImageView) findViewById(R.id.y7t);
        com.tencent.mobileqq.vasgift.utils.l lVar = com.tencent.mobileqq.vasgift.utils.l.f312038a;
        this.f311932n0.setText(lVar.b(this.D.getAppRuntime(), "guideText"));
        this.f311933o0.setText(lVar.b(this.D.getAppRuntime(), "guideButtonText"));
        this.f311933o0.setOnClickListener(new j());
        this.f311934p0.setOnClickListener(new k());
        this.f311931m0.setVisibility(0);
    }

    private void N0(View view, View view2) {
        View view3;
        if (g0()) {
            view3 = this.f311943y0;
        } else {
            view3 = this.S;
        }
        if (view3.getMeasuredWidth() == 0) {
            view3.measure(-2, -2);
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        getLocationInWindow(iArr2);
        int width = (iArr[0] + ((view.getWidth() - view3.getMeasuredWidth()) / 2)) - iArr2[0];
        int height = ((iArr[1] + (view.getHeight() / 2)) - (view3.getMeasuredHeight() - (view2.getMeasuredHeight() / 2))) - iArr2[1];
        view3.setTranslationX(width);
        view3.setTranslationY(height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.W.setVisibility(0);
            this.Q.setText(str);
            this.f311926i0.f(this.W);
            this.f311927j0.s0();
            return;
        }
        this.Q.setText("");
    }

    private void P0() {
        List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16;
        String str;
        int i3;
        if (this.f311918e.G2().getValue() != null && (a16 = this.f311918e.G2().getValue().a()) != null && !a16.isEmpty()) {
            for (int i16 = 0; i16 < a16.size(); i16++) {
                for (com.tencent.mobileqq.qqgift.data.service.d dVar : a16.get(i16)) {
                    if (dVar.E) {
                        if (TextUtils.isEmpty(dVar.T)) {
                            str = dVar.S;
                        } else {
                            str = dVar.T;
                        }
                        if (!TextUtils.isEmpty(str) && ((i3 = this.G) < 0 || i3 == i16)) {
                            O0(str);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void a0(boolean z16, long j3) {
        addOnAttachStateChangeListener(new m(z16, j3));
    }

    private void b0(int i3) {
        if (this.f311918e.e3()) {
            c0(i3, true);
        } else {
            c0(i3, false);
        }
    }

    private void c0(int i3, boolean z16) {
        com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar;
        com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar2;
        if (z16 || this.G != i3) {
            this.G = i3;
            this.f311918e.K3(i3);
            this.C.setVisibility(4);
            Iterator<ImageView> it = this.f311921f0.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
            P0();
            if (this.f311919e0 != null) {
                int i16 = 0;
                while (true) {
                    cVar = null;
                    if (i16 < this.f311919e0.size()) {
                        cVar2 = this.f311919e0.get(i16);
                        if (i3 >= cVar2.f264968e && i3 <= cVar2.f264969f) {
                            break;
                        } else {
                            i16++;
                        }
                    } else {
                        cVar2 = null;
                        break;
                    }
                }
                if (this.f311918e.e3()) {
                    if (this.f311919e0.size() > this.f311913a0.x()) {
                        cVar = this.f311919e0.get(this.f311913a0.x());
                    }
                } else {
                    cVar = cVar2;
                }
                if (cVar != null) {
                    int i17 = cVar.f264969f;
                    int i18 = cVar.f264968e;
                    int i19 = (i17 - i18) + 1;
                    int i26 = i3 - i18;
                    if (i19 > 1 && this.f311921f0.size() >= i19 && i26 < i19) {
                        for (int i27 = 0; i27 < i19; i27++) {
                            ImageView imageView = this.f311921f0.get(i27);
                            imageView.setVisibility(0);
                            if (i27 == i26) {
                                imageView.setImageDrawable(this.f311922g0);
                            } else {
                                imageView.setImageDrawable(this.f311924h0);
                            }
                        }
                        this.C.setVisibility(0);
                    }
                }
            }
        }
    }

    private void d0() {
        com.tencent.mobileqq.vasgift.mvvm.business.c cVar = new com.tencent.mobileqq.vasgift.mvvm.business.c();
        cVar.i(this.M, this.f311918e, this);
        cVar.k(this.M, this.f311918e, this);
        cVar.h(this.M, this.f311918e, this);
        cVar.j(this.M, this.f311918e, this);
        cVar.n(this.M, this.f311918e, this);
        cVar.l(this.M, this.f311918e, this);
        cVar.m(this.M, this.f311918e, this);
    }

    private boolean e0() {
        boolean z16 = false;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("qqgift_recharge_tips_sp_name", 0);
        int i3 = sharedPreferences.getInt("qqgift_recharge_tips_sp_key", 0);
        if (i3 <= 3) {
            z16 = true;
        }
        if (z16) {
            sharedPreferences.edit().putInt("qqgift_recharge_tips_sp_key", i3 + 1).apply();
        }
        return z16;
    }

    private void f0() {
        this.f311918e.G2().removeObservers(this.M);
        this.f311918e.O2().removeObservers(this.M);
        this.f311918e.U2().removeObservers(this.M);
        if (VasToggle.BUG_105841927.isEnable(true)) {
            this.f311918e.N2().removeObservers(this.M);
            this.f311918e.E2().removeObservers(this.M);
            this.f311918e.K2().removeObservers(this.M);
            this.f311918e.R2().removeObservers(this.M);
            this.f311918e.S2().removeObservers(this.M);
        }
    }

    private boolean g0() {
        if (this.f311944z0.booleanValue() && (this.D.getSDKConfig().f264972a == 10011 || this.D.getSDKConfig().f264972a == 10008)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i3) {
        boolean z16 = false;
        if (!g0() ? this.S.getVisibility() == 0 : this.f311943y0.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            q(true);
        }
    }

    private Drawable j0(String str) {
        if (!TextUtils.isEmpty(str)) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str, new ApngOptions());
        }
        return null;
    }

    private void k0(int i3) {
        boolean z16;
        boolean z17;
        if (this.f311918e.G2().getValue() != null) {
            List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = this.f311918e.G2().getValue().a();
            if (i3 >= a16.size()) {
                return;
            }
            List<com.tencent.mobileqq.qqgift.data.service.d> list = a16.get(i3);
            if (list != null && !list.isEmpty()) {
                for (com.tencent.mobileqq.qqgift.data.service.d dVar : list) {
                    if (StringUtil.isEmpty(dVar.f264876e) && dVar.f264878f == 0) {
                        z16 = dVar.f264875d0;
                        z17 = true;
                        break;
                    }
                }
            }
            z16 = false;
            z17 = false;
            if (z17) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.tencent.mobileqq.qqgift.data.service.d> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(String.valueOf(it.next().f264874d)));
                }
                if (z16) {
                    this.f311918e.D3(arrayList);
                } else {
                    this.f311918e.A3(arrayList);
                }
            }
        }
    }

    private com.tencent.mobileqq.vasgift.business.dt.a l0() {
        return new VasGiftDtReportHelper(this.f311918e);
    }

    private void m0() {
        if (!TextUtils.isEmpty(this.A0)) {
            H0(this.A0);
        }
        this.A0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (com.tencent.mobileqq.vasgift.utils.k.f312037a.a(this.D)) {
            removeCallbacks(this.D0);
            findViewById(R.id.t5e).setVisibility(8);
            View findViewById = findViewById(R.id.u8d);
            findViewById.setVisibility(8);
            findViewById.setOnClickListener(null);
        }
    }

    private void o0() {
        findViewById(R.id.vpz).setOnTouchListener(new h());
        this.f311935q0 = findViewById(R.id.vpk);
        this.f311936r0 = findViewById(R.id.vpl);
        this.f311937s0 = (ImageView) findViewById(R.id.vpo);
        this.f311938t0 = (ImageView) findViewById(R.id.vpp);
        this.f311939u0 = (TextView) findViewById(R.id.vpq);
        this.f311940v0 = (TextView) findViewById(R.id.vpr);
        this.f311941w0 = (TextView) findViewById(R.id.vpm);
        this.f311942x0 = (TextView) findViewById(R.id.vpn);
    }

    private void p0() {
        if (this.f311943y0 == null) {
            QQLiveGiftComboSendView qQLiveGiftComboSendView = new QQLiveGiftComboSendView(getContext());
            this.f311943y0 = qQLiveGiftComboSendView;
            qQLiveGiftComboSendView.setListener(this);
            this.f311943y0.t(false);
            ((ViewGroup) findViewById(R.id.f759440b)).addView(this.f311943y0);
        }
    }

    private void q0() {
        this.K = new StaggeredGridLayoutManager(1, 0);
        this.f311916d = (RecyclerView) findViewById(R.id.f790548q);
        this.N = (LinearLayout) findViewById(R.id.f166094yo2);
        this.f311920f = (TextView) findViewById(R.id.f110506ip);
        this.f311923h = (TextView) findViewById(R.id.f109206f7);
        this.f311925i = (LinearLayout) findViewById(R.id.f166101yp2);
        this.f311930m = (URLImageView) findViewById(R.id.y5l);
        this.C = (LinearLayout) findViewById(R.id.yoo);
        this.P = (TextView) findViewById(R.id.f107716b6);
        this.U = (LinearLayout) findViewById(R.id.f166097yp0);
        this.W = (LinearLayout) findViewById(R.id.ynz);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.yqa);
        this.V = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f311916d.setHasFixedSize(true);
        this.f311916d.setLayoutManager(this.K);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.yo8);
        this.f311914b0 = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.f311915c0 = (TextView) findViewById(R.id.f108066c4);
        this.f311917d0 = (ImageView) findViewById(R.id.y3h);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.J = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.f311916d);
    }

    private void r0() {
        CustomTabLayoutCompat customTabLayoutCompat = (CustomTabLayoutCompat) findViewById(R.id.f99035op);
        this.f311913a0 = customTabLayoutCompat;
        customTabLayoutCompat.setScrollableTabMinWidth(ViewUtils.dip2px(58.0f));
        CustomTabLayoutCompat customTabLayoutCompat2 = this.f311913a0;
        customTabLayoutCompat2.g(customTabLayoutCompat2.D().l(""));
        this.f311913a0.setTabMode(0);
        this.f311913a0.y(0).i();
        this.f311913a0.setTabGravity(1);
        this.f311913a0.setSelectedTabIndicatorHeight(ViewUtils.dip2px(4.0f));
        this.f311913a0.setSelectedTabIndicatorPaddingLeft(ViewUtils.dip2px(10.0f));
        this.f311913a0.setSelectedTabIndicatorPaddingRight(ViewUtils.dip2px(10.0f));
        this.f311913a0.setTabTextSize(16.67f);
        this.f311913a0.f(new i());
    }

    private void s0(Context context) {
        View.inflate(context, R.layout.f168909h92, this);
        setOnClickListener(this);
        q0();
        r0();
        this.Q = (TextView) findViewById(R.id.f167042k73);
        this.f311922g0 = getResources().getDrawable(R.drawable.nka);
        this.f311924h0 = getResources().getDrawable(R.drawable.omj);
        View findViewById = findViewById(R.id.b9w);
        this.R = findViewById;
        if (findViewById != null) {
            findViewById.addOnLayoutChangeListener(new f());
            ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = ImmersiveUtils.getScreenWidth();
            }
            this.R.setLayoutParams(layoutParams);
        }
        QQVasGiftComboSendView qQVasGiftComboSendView = (QQVasGiftComboSendView) findViewById(R.id.u16);
        this.S = qQVasGiftComboSendView;
        qQVasGiftComboSendView.n(BannerResManager.y(this.D.b()));
        this.S.setComboListener(this);
        o0();
        findViewById(R.id.fuj).setOnTouchListener(new g());
    }

    private void t0(Context context) {
        this.M = (FragmentActivity) context;
        QQGiftPanelViewModel qQGiftPanelViewModel = new QQGiftPanelViewModel(new com.tencent.mobileqq.vasgift.mvvm.business.b());
        this.f311918e = qQGiftPanelViewModel;
        qQGiftPanelViewModel.U1((Activity) context);
        this.f311918e.Q3(this.D);
        com.tencent.mobileqq.vasgift.business.dt.a l06 = l0();
        this.f311926i0 = l06;
        this.f311918e.N3(l06);
        VasGift04586Report vasGift04586Report = new VasGift04586Report(this.f311918e);
        this.f311927j0 = vasGift04586Report;
        this.f311918e.I3(vasGift04586Report);
    }

    private boolean u0() {
        return this.f311918e.e3();
    }

    private boolean v0() {
        String str;
        CustomTabLayoutCompat.f y16;
        CustomTabLayoutCompat customTabLayoutCompat = this.f311913a0;
        if (customTabLayoutCompat != null && (y16 = customTabLayoutCompat.y(customTabLayoutCompat.x())) != null) {
            Object e16 = y16.e();
            if (e16 instanceof String) {
                str = (String) e16;
                return "PACKAGE_TAB_ID".equals(str);
            }
        }
        str = "";
        return "PACKAGE_TAB_ID".equals(str);
    }

    private boolean w0() {
        d43.b bVar;
        if ((this.D.getSDKConfig().f264972a != 10011 && this.D.getSDKConfig().f264972a != 10008) || (bVar = this.f311928k0) == null || bVar.a() == null) {
            return false;
        }
        if (this.f311928k0.a().f264883i != 1 && this.f311928k0.a().f264883i != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void y0() {
        long j3;
        if (com.tencent.mobileqq.vasgift.utils.c.a("QQGiftPanelViewImpl.freeCoinClick")) {
            return;
        }
        if (this.f311918e.E2().getValue() != null) {
            j3 = this.f311918e.E2().getValue().longValue();
        } else {
            j3 = 0;
        }
        this.f311918e.l3(j3);
        this.f311926i0.j(this.f311914b0, j3);
    }

    private void z0() {
        q(true);
        this.E.set(false);
        this.F.set(false);
        this.G = -1;
        this.f311916d.removeOnScrollListener(this.E0);
        this.f311916d.stopScroll();
        f0();
        this.f311918e.t();
        this.f311918e.C.removeObserver(this.G0);
        this.f311918e.D.removeObserver(this.J0);
        this.f311918e.E.removeObserver(this.K0);
        if (VasToggle.BUG_105841927.isEnable(true)) {
            this.f311918e.f311670i.removeObserver(this.I0);
        }
        this.f311926i0.d(this, this.S, this.V);
    }

    public void B0() {
        long j3;
        String str;
        if (com.tencent.mobileqq.vasgift.utils.c.a("QQGiftPanelViewImpl.rechargeClick")) {
            return;
        }
        this.f311918e.D();
        VideoReport.reportEvent("clck", this.V, null);
        this.f311927j0.D0();
        if (this.f311925i.getVisibility() == 0) {
            try {
                if (this.f311923h.getText() == null) {
                    str = "0";
                } else {
                    str = (String) this.f311923h.getText();
                }
                j3 = Long.parseLong(str);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                QLog.e("QQGiftPanelViewImpl", 1, e16, new Object[0]);
                j3 = 0;
            }
            this.f311927j0.F0(j3);
        }
    }

    public void I0(View view, boolean z16) {
        h(view, true, false);
    }

    public void J0(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (dVar != null && dVar.f264881h == 6) {
            this.f311935q0.setVisibility(0);
            this.f311936r0.setVisibility(0);
            e eVar = new e(dVar);
            this.f311935q0.setOnClickListener(eVar);
            this.f311936r0.setOnClickListener(eVar);
            this.f311937s0.setImageDrawable(j0(dVar.R));
            this.f311938t0.setImageDrawable(j0(dVar.R));
            this.f311939u0.setText(dVar.f264876e);
            this.f311940v0.setText(dVar.f264876e);
            this.f311941w0.setText(dVar.T);
            this.f311942x0.setText(dVar.T);
            return;
        }
        this.f311935q0.setVisibility(4);
        this.f311936r0.setVisibility(4);
    }

    @Override // sh2.c
    public Context a() {
        return getContext();
    }

    @Override // ph2.b
    public void b(int i3) {
        E0();
    }

    @Override // ph2.b
    public void c(int i3, int i16, boolean z16) {
        this.f311918e.p3(i3, i16, z16);
    }

    @Override // sh2.c
    public void d(boolean z16) {
        int i3;
        LinearLayout linearLayout = this.N;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        RecyclerView recyclerView = this.f311916d;
        if (z16) {
            i16 = 8;
        }
        recyclerView.setVisibility(i16);
        if (z16) {
            findViewById(R.id.y2q).setBackgroundResource(R.drawable.o2u);
            this.P.setText(getResources().getString(R.string.f210025h0));
        } else {
            this.f311926i0.traversePage(this);
        }
    }

    @Override // ph2.b
    public void e() {
        QQGiftPanelViewModel qQGiftPanelViewModel = this.f311918e;
        com.tencent.mobileqq.qqgift.data.service.d dVar = qQGiftPanelViewModel.f311641b0;
        if (!dVar.f264875d0) {
            qQGiftPanelViewModel.S1(false, dVar, -11008, BaseApplication.getContext().getString(R.string.f209905go));
        }
    }

    @Override // sh2.c
    public void f() {
        if (this.f311918e != null && v0()) {
            this.f311918e.C3();
        }
    }

    @Override // sh2.c
    public void g(int i3) {
        this.I = i3;
        if (i3 == 1) {
            this.H = this.f311918e.f311641b0;
        }
    }

    @Override // sh2.c
    public void h(View view, boolean z16, boolean z17) {
        boolean z18;
        if (com.tencent.mobileqq.vasgift.mvvm.business.anim.c.f311706a.l(getContext()) && QQGiftPAGAnimationViewImpl.f311895g.a()) {
            z18 = true;
        } else {
            z18 = false;
        }
        Boolean valueOf = Boolean.valueOf(z18);
        this.f311944z0 = valueOf;
        if (valueOf.booleanValue()) {
            p0();
        } else {
            QLog.e("QQGiftPanelViewImpl", 1, "isQQLiveComboRes is not ready.");
        }
        this.f311916d.addOnScrollListener(this.E0);
        d0();
        A0();
        this.D.getSDKConfig().f264982k = z17;
        if (z16) {
            L0(view, z17);
        }
        VasLogReporter.getVasGift().report("panel show", VasLogReportProxy.LEVEL.HIGHEST);
    }

    @Override // sh2.c
    public void hide() {
        com.tencent.mobileqq.vasgift.utils.f fVar = this.L;
        if (fVar != null) {
            try {
                fVar.d();
            } catch (Exception e16) {
                QLog.e("QQGiftPanelViewImpl", 1, e16, new Object[0]);
            }
        }
        VasLogReporter.getVasGift().report("panel hide", VasLogReportProxy.LEVEL.HIGHEST);
    }

    @Override // ph2.b
    public void i() {
        this.f311918e.G3();
        this.f311918e.S2().postValue(new Pair<>(-1, 0));
    }

    @Override // sh2.c
    public LinearLayout k() {
        return this.U;
    }

    @Override // sh2.c
    public c.f l(c.f fVar) {
        return this.f311918e.A2(fVar);
    }

    @Override // sh2.c
    public void m(int i3, int i16) {
        ViewGroup viewGroup;
        View childAt;
        View findViewById;
        if (g0()) {
            this.f311943y0.E();
        } else {
            this.S.L();
            this.S.w(true);
        }
        if (this.f311916d.getChildCount() < 1 || !(this.f311916d.getChildAt(0) instanceof ViewGroup) || (viewGroup = (ViewGroup) this.f311916d.getChildAt(0)) == null || (childAt = viewGroup.getChildAt(i3)) == null) {
            return;
        }
        if (g0()) {
            findViewById = this.f311943y0.findViewById(R.id.f632132x);
        } else {
            findViewById = this.S.findViewById(R.id.send_btn);
        }
        if (findViewById == null) {
            return;
        }
        N0(childAt, findViewById);
        if (g0()) {
            this.f311943y0.H(0, i16);
        } else {
            this.S.P(0, i16);
        }
        this.f311928k0 = new d43.b(this.f311918e.I2(), this.f311918e.f311641b0);
    }

    @Override // sh2.c
    public nh2.b n() {
        return this.f311927j0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.yqa) {
            B0();
        } else if (id5 == R.id.yo8) {
            y0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mobileqq.vasgift.utils.f fVar = this.L;
        if (fVar != null && fVar.h()) {
            this.L.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z0();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16 && v0()) {
            this.f311918e.C3();
        }
    }

    @Override // sh2.c
    public void p(View view) {
        I0(view, true);
    }

    @Override // sh2.c
    public void q(boolean z16) {
        int visibility;
        int s16;
        boolean z17;
        if (z16) {
            this.f311918e.G3();
        }
        if (g0()) {
            visibility = this.f311943y0.getVisibility();
        } else {
            visibility = this.S.getVisibility();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("send_combo:  AnimalHide ");
            if (visibility == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            QLog.d("QQGiftPanelViewImpl", 1, sb5.toString());
        }
        if (visibility != 4 && visibility != 8) {
            d43.b bVar = this.f311928k0;
            if (bVar != null && bVar.a() != null && this.f311928k0.a().f264875d0) {
                this.f311918e.C3();
            }
            if (g0()) {
                this.f311943y0.t(false);
                s16 = this.f311943y0.getCurComboNum();
            } else {
                this.S.w(false);
                s16 = this.S.s();
            }
            this.f311926i0.p(this.S, this.f311918e.V2(), s16);
            if (this.f311928k0 == null) {
                QLog.e("QQGiftPanelViewImpl", 1, "comboOverData is null.");
                return;
            }
            if (w0()) {
                QLog.i("QQGiftPanelViewImpl", 1, "isQQLiveEffectGift name=" + this.f311928k0.a().f264876e + ",seq=" + this.f311928k0.a().H);
                return;
            }
            QLog.i("QQGiftPanelViewImpl", 1, "readySendComboOver, comboCnt:" + s16 + ", giftData:" + this.f311928k0.a());
            this.f311928k0.d(s16);
            this.f311929l0.offer(this.f311928k0);
            ThreadManager.b(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPanelViewImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    d43.b bVar2 = (d43.b) QQGiftPanelViewImpl.this.f311929l0.poll();
                    if (bVar2 != null) {
                        QQGiftPanelViewImpl.this.f311918e.j3(bVar2.a(), bVar2.c(), bVar2.c(), bVar2.b());
                    }
                }
            }, 1500L);
            return;
        }
        QLog.i("QQGiftPanelViewImpl", 1, "visibility is not visible.");
    }

    @Override // sh2.c
    public void r(long j3) {
        URLImageView uRLImageView;
        if (j3 <= 0) {
            this.f311925i.setVisibility(8);
            return;
        }
        this.f311925i.setVisibility(0);
        this.f311927j0.G0(j3);
        this.f311923h.setText(String.valueOf(j3));
        this.f311923h.setContentDescription("\u91d1\u5e01\u4f59\u989d\u4e3a" + j3);
        String a16 = com.tencent.mobileqq.vasgift.utils.l.f312038a.a(this.D.getAppRuntime());
        if (!TextUtils.isEmpty(a16) && (uRLImageView = this.f311930m) != null) {
            uRLImageView.setBackgroundURL(a16);
        }
    }

    @Override // ph2.b
    public void s(int i3) {
        this.f311918e.m3(i3);
    }

    @Override // sh2.c
    public void setAdapter(RecyclerView.Adapter adapter) {
        this.f311916d.setAdapter(adapter);
    }

    @Override // sh2.c
    public void setCacheTabList(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
        QQGiftPanelViewModel qQGiftPanelViewModel = this.f311918e;
        if (qQGiftPanelViewModel != null) {
            qQGiftPanelViewModel.V3(list);
        }
    }

    @Override // sh2.c
    public void setComboOverListener(c.d dVar) {
        this.f311918e.J3(dVar);
    }

    @Override // sh2.c
    public void setComboSendDelayTime(int i3) {
        QQVasGiftComboSendView qQVasGiftComboSendView = this.S;
        if (qQVasGiftComboSendView != null) {
            qQVasGiftComboSendView.setSendDelayTime(i3);
        }
    }

    @Override // sh2.c
    public void setDtPageExtra(Map<String, String> map) {
        this.f311918e.L3(map);
    }

    @Override // sh2.c
    public void setDtParams(com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar) {
        this.f311918e.M3(aVar);
    }

    @Override // sh2.c
    public void setEmptyPackClickListener(@NonNull View.OnClickListener onClickListener) {
        this.f311918e.O3(onClickListener);
    }

    @Override // sh2.c
    public void setFirstShowGiftTabConfig(String str) {
        this.A0 = str;
    }

    public void setFreeCoinClickListener(c.a aVar) {
        this.f311918e.P3(aVar);
    }

    @Override // sh2.c
    public void setOnPanelContentHeightChangeListener(c.e eVar) {
        this.C0 = new WeakReference<>(eVar);
    }

    @Override // sh2.c
    public void setPanelEventListener(c.f fVar) {
        this.f311918e.R3(fVar);
    }

    @Override // sh2.c
    public void setPanelStyle(com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar) {
        findViewById(R.id.u85).setBackgroundColor(bVar.f264953a);
        this.U.setBackgroundColor(bVar.f264953a);
        this.f311913a0.setTabTextColors(bVar.f264957e, bVar.f264956d);
        this.f311913a0.setSelectedTabIndicatorColor(bVar.f264956d);
        Drawable drawable = getResources().getDrawable(R.drawable.nkh);
        drawable.setColorFilter(bVar.f264956d, PorterDuff.Mode.SRC_IN);
        this.f311913a0.setSelectedTabIndicator(drawable);
        if (bVar.f264958f) {
            findViewById(R.id.y7r).getBackground().clearColorFilter();
        } else {
            findViewById(R.id.y7r).getBackground().setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
        }
        this.f311920f.setTextColor(bVar.f264954b);
        this.f311923h.setTextColor(bVar.f264954b);
        this.P.setTextColor(bVar.f264955c);
        TextView textView = this.Q;
        if (textView != null) {
            textView.setTextColor(bVar.f264954b);
            if (bVar.f264963k) {
                this.W.setVisibility(4);
            } else {
                this.W.setVisibility(8);
            }
        }
        Drawable drawable2 = this.f311922g0;
        if (drawable2 != null) {
            drawable2.setColorFilter(bVar.f264956d, PorterDuff.Mode.SRC_IN);
        }
        this.f311924h0.setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
        float f16 = bVar.f264960h;
        if (f16 != 0.0f) {
            this.f311913a0.setTabTextSize(f16);
        }
        if (bVar.f264961i > 0) {
            k().setLayoutParams(new LinearLayout.LayoutParams(-1, bVar.f264961i));
        }
        Drawable drawable3 = bVar.f264959g;
        if (drawable3 != null) {
            setBackgroundDrawable(drawable3);
        }
        this.f311918e.S3(bVar);
        VasLogReporter.getVasGift().report("setPanelStyle:" + bVar.toString(), VasLogReportProxy.LEVEL.HIGHEST);
    }

    @Override // sh2.c
    public void setSceneData(com.tencent.mobileqq.qqgift.data.service.a aVar) {
        this.f311918e.U3(aVar);
    }

    @Override // sh2.c
    public void setTabSelectedListener(c.g gVar) {
        this.B0 = gVar;
    }

    @Override // sh2.c
    public void t(long j3) {
        String str;
        if (j3 == -1) {
            this.f311914b0.setVisibility(8);
            return;
        }
        this.f311914b0.setVisibility(0);
        this.f311915c0.setText(String.valueOf(j3));
        if (this.f311918e.F2() != null) {
            str = this.f311918e.F2().f264905c;
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.f311917d0.setImageDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null));
        }
        this.f311926i0.k(this.f311914b0, j3);
    }

    @Override // sh2.c
    public long u() {
        QQGiftPanelViewModel qQGiftPanelViewModel = this.f311918e;
        if (qQGiftPanelViewModel != null) {
            return qQGiftPanelViewModel.x2();
        }
        return 0L;
    }

    @Override // sh2.c
    public void v() {
        m0();
        D0();
        VasPerfReportUtils.report(VasPerfReportUtils.WHILE_COST_TOTAL, VasPerfReportUtils.WITHIN_SDK, this.D.getSDKConfig().f264972a + "", "", 0L);
    }

    @Override // sh2.c
    public void w(String str) {
        this.f311920f.setText(str);
        if (!str.equals(BaseApplication.getContext().getString(R.string.f209975gv))) {
            this.f311920f.setContentDescription("\u91d1\u5e01\u4f59\u989d\u4e3a" + str);
        }
    }

    @Override // sh2.c
    public void x(List<com.tencent.mobileqq.qqgift.mvvm.business.data.c> list) {
        List<com.tencent.mobileqq.qqgift.mvvm.business.data.c> list2 = this.f311919e0;
        if (list2 != null && list2.size() == list.size()) {
            this.f311919e0 = list;
            return;
        }
        this.f311913a0.F();
        for (com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar : list) {
            CustomTabLayoutCompat.f l3 = this.f311913a0.D().l(cVar.f264965b);
            l3.k(cVar.f264964a);
            this.f311913a0.g(l3);
        }
        this.f311919e0 = list;
        int x16 = this.f311913a0.x();
        if (this.B0 != null && this.f311919e0.size() > x16) {
            this.B0.a(this.f311919e0.get(x16).f264964a);
        }
    }

    @Override // sh2.c
    public int y() {
        View view = this.R;
        if (view != null) {
            return view.getHeight();
        }
        return -1;
    }

    @Override // sh2.c
    public View z() {
        return this.R;
    }

    public QQGiftPanelViewImpl(Context context, nh2.c cVar, @Nullable AttributeSet attributeSet) {
        this(context, cVar, attributeSet, 0);
    }

    public QQGiftPanelViewImpl(Context context, nh2.c cVar, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = new AtomicBoolean(false);
        this.F = new AtomicBoolean(false);
        this.G = -1;
        this.I = 0;
        this.f311921f0 = new ArrayList();
        this.f311928k0 = null;
        this.f311929l0 = new LinkedList();
        this.f311944z0 = Boolean.FALSE;
        this.D0 = new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.e
            @Override // java.lang.Runnable
            public final void run() {
                QQGiftPanelViewImpl.this.n0();
            }
        };
        this.E0 = new l();
        this.G0 = new a();
        this.I0 = new b();
        this.J0 = new c();
        this.K0 = new d();
        this.D = cVar;
        s0(context);
        t0(context);
        VasLogReporter.getVasGift().report("QQGiftPanelViewImpl created", VasLogReportProxy.LEVEL.HIGHEST);
    }

    @Override // sh2.c
    public ViewGroup getContentView() {
        return this;
    }

    @Override // ph2.b
    public void j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class i implements CustomTabLayoutCompat.c {
        i() {
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat.c
        public void c(CustomTabLayoutCompat.f fVar) {
            int i3;
            View findSnapView = QQGiftPanelViewImpl.this.J.findSnapView(QQGiftPanelViewImpl.this.K);
            if (findSnapView != null) {
                i3 = QQGiftPanelViewImpl.this.K.getPosition(findSnapView);
            } else {
                i3 = 0;
            }
            if (QQGiftPanelViewImpl.this.f311919e0 != null) {
                for (com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar : QQGiftPanelViewImpl.this.f311919e0) {
                    if (cVar.f264964a.equals((String) fVar.e())) {
                        break;
                    }
                }
            }
            cVar = null;
            if (cVar != null) {
                QQGiftPanelViewImpl.this.G0(cVar);
                if (cVar.f264964a.equals("PACKAGE_TAB_ID")) {
                    QQGiftPanelViewImpl.this.f311918e.C3();
                }
                if ("WELFARE_TAB_ID".equals(cVar.f264964a)) {
                    QQGiftPanelViewImpl.this.W.setVisibility(8);
                }
                if (QQGiftPanelViewImpl.this.B0 != null) {
                    QQGiftPanelViewImpl.this.B0.a(cVar.f264964a);
                }
                if (i3 < cVar.f264968e || i3 > cVar.f264969f) {
                    QQGiftPanelViewImpl.this.f311916d.smoothScrollToPosition(cVar.f264968e);
                    QQGiftPanelViewImpl.this.f311927j0.K0(cVar.f264964a, cVar.f264965b);
                }
                QQGiftPanelViewImpl.this.O0(cVar.f264966c);
                QQGiftPanelViewImpl.this.f311926i0.g(QQGiftPanelViewImpl.this.f311913a0, fVar.d(), cVar.f264964a, cVar.f264965b);
                QQGiftPanelViewImpl.this.f311927j0.B0(cVar.f264965b, cVar.f264964a);
                return;
            }
            QQGiftPanelViewImpl.this.O0(null);
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat.c
        public void a(CustomTabLayoutCompat.f fVar) {
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat.c
        public void b(CustomTabLayoutCompat.f fVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class m implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f311958d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f311959e;

        m(boolean z16, long j3) {
            this.f311958d = z16;
            this.f311959e = j3;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            VasPerfReportUtils.report(VasPerfReportUtils.WHILE_SHOW_POPUP_WINDOW, VasPerfReportUtils.WITHIN_SDK, QQGiftPanelViewImpl.this.D.getSDKConfig().f264977f, this.f311958d + "", System.currentTimeMillis() - this.f311959e);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    @Override // sh2.c
    public void setCacheList(List<com.tencent.mobileqq.qqgift.data.service.d> list) {
    }

    public void setPanelConfig(com.tencent.mobileqq.qqgift.data.service.b bVar) {
    }

    @Override // sh2.c
    public void o(c.b bVar, String str) {
    }
}

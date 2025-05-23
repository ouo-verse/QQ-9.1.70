package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.d;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailListHelper;
import com.tencent.mobileqq.mutualmark.widget.util.MutualMarkDialogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.annimation.invertview.QUIInvertViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.widget.banner.Banner;
import com.tencent.relation.common.widget.banner.indicator.CircleIndicator;
import com.tencent.relation.common.widget.squaredIndicator.SquaredIndicatorView;
import f61.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateElegantCardView extends IntimateContentItemBaseView {

    /* renamed from: k0, reason: collision with root package name */
    private static final LruCache<String, IntimateInfo> f179231k0 = new LruCache<>(5);

    /* renamed from: l0, reason: collision with root package name */
    public static final String f179232l0 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252186a;

    /* renamed from: m0, reason: collision with root package name */
    public static final String f179233m0 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252187b;
    private View F;
    private NtMutualMarkListView G;
    private SquaredIndicatorView H;
    private ImageView I;
    private RelativeLayout J;
    private View K;
    private Banner L;
    private com.tencent.mobileqq.activity.aio.intimate.c M;
    private List<Integer> N;
    private Integer P;
    private IntimateInfo Q;
    boolean R;
    boolean S;
    boolean T;
    private boolean U;
    private boolean V;
    private ImageView W;

    /* renamed from: a0, reason: collision with root package name */
    private MutualMarkDetailListHelper f179234a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f179235b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f179236c0;

    /* renamed from: d0, reason: collision with root package name */
    private QUIInvertViewLayout f179237d0;

    /* renamed from: e0, reason: collision with root package name */
    private float f179238e0;

    /* renamed from: f0, reason: collision with root package name */
    private float f179239f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.mobileqq.mutualmark.util.a f179240g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f179241h0;

    /* renamed from: i0, reason: collision with root package name */
    private View.OnClickListener f179242i0;

    /* renamed from: j0, reason: collision with root package name */
    private f f179243j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f179246d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f179247e;

        a(int i3, String str) {
            this.f179246d = i3;
            this.f179247e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f179246d == -1) {
                IntimateElegantCardView.this.Y(true);
            }
            IntimateElegantCardView.this.a0(this.f179247e, this.f179246d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IntimateInfo f179249d;

        b(IntimateInfo intimateInfo) {
            this.f179249d = intimateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IntimateElegantCardView.this.f179234a0 = new MutualMarkDetailListHelper(IntimateElegantCardView.this.getContext(), this.f179249d.mutualMarkList.f397925f, 0);
            IntimateElegantCardView.this.f179234a0.A(IntimateElegantCardView.this.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IntimateInfo f179251d;

        c(IntimateInfo intimateInfo) {
            this.f179251d = intimateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IntimateElegantCardView.this.f179234a0 = new MutualMarkDetailListHelper(IntimateElegantCardView.this.getContext(), this.f179251d.mutualMarkList.f397925f, 0);
            IntimateElegantCardView.this.f179234a0.A(IntimateElegantCardView.this.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements qz3.a<f61.a> {
        e() {
        }

        @Override // qz3.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f61.a aVar, int i3) {
            String str = aVar.f397890b;
            if (QLog.isColorLevel()) {
                QLog.i("IntimateElegantCardView", 2, String.format("onBannerClick, url: %s", str));
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).jumpUrl(IntimateElegantCardView.this.f179219d, str);
            IntimateElegantCardView.this.T(aVar, "dt_clck");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements com.tencent.relation.common.widget.squaredIndicator.a {

        /* renamed from: a, reason: collision with root package name */
        String f179256a = "";

        f() {
        }

        @Override // com.tencent.relation.common.widget.squaredIndicator.a
        public void a(View view) {
            if (view != null && IntimateElegantCardView.this.getContext() != null && !TextUtils.isEmpty(this.f179256a)) {
                IntimateElegantCardView intimateElegantCardView = IntimateElegantCardView.this;
                intimateElegantCardView.K = com.tencent.mobileqq.activity.aio.intimate.d.a(intimateElegantCardView.getContext(), new d.a(view, this.f179256a, 49, 3));
                if (HardCodeUtil.qqStr(R.string.zmb).equals(this.f179256a)) {
                    ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_interact_tag_wear_tips", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), null);
                } else {
                    ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_interact_tag_lighter_tips", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), null);
                }
            }
        }
    }

    public IntimateElegantCardView(Context context) {
        this(context, null);
    }

    private void B(IntimateInfo intimateInfo) {
        List<f61.a> list = intimateInfo.activityBanner;
        if (list == null) {
            Banner banner = this.L;
            if (banner != null) {
                banner.setVisibility(8);
                return;
            }
            return;
        }
        if (list.size() == 0) {
            Banner banner2 = this.L;
            if (banner2 != null) {
                banner2.setVisibility(8);
                return;
            }
            return;
        }
        Banner banner3 = this.L;
        if (banner3 != null) {
            banner3.setVisibility(0);
        }
        com.tencent.mobileqq.activity.aio.intimate.c cVar = this.M;
        if (cVar == null) {
            com.tencent.mobileqq.activity.aio.intimate.c cVar2 = new com.tencent.mobileqq.activity.aio.intimate.c(list);
            this.M = cVar2;
            Banner banner4 = this.L;
            if (banner4 == null) {
                return;
            } else {
                banner4.A(cVar2).E(new CircleIndicator(this.f179219d)).R(new e()).f(new d(list));
            }
        } else {
            cVar.setDatas(list);
        }
        VideoReport.reportEvent("dt_imp", this.L, null);
        T(list.get(0), "dt_imp");
    }

    private void C(IntimateInfo intimateInfo) {
        if (intimateInfo != null && intimateInfo.mutualMarkList != null) {
            if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isFirstTime()) {
                this.H.p();
            }
            U(intimateInfo);
            h hVar = intimateInfo.mutualMarkList;
            this.H.i(W(V(hVar.f397922c, this.T)));
            if (hVar.f397920a == hVar.f397921b) {
                return;
            }
            final int i3 = (intimateInfo.mutualMarkList.f397920a + 1) / 10;
            if (this.U) {
                this.U = false;
                this.H.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.view.IntimateElegantCardView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        IntimateElegantCardView.this.H(i3);
                    }
                });
            }
        }
    }

    private void D() {
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewerGuideMode() && this.V && this.F != null && !this.f179241h0) {
            this.V = false;
            if (!this.T) {
                if (!d0(HardCodeUtil.qqStr(R.string.zm_), 1)) {
                    a0(HardCodeUtil.qqStr(R.string.zm_), 1);
                }
            } else if (this.P == null) {
                d0("", -1);
            } else if (!d0(HardCodeUtil.qqStr(R.string.zmb), this.P.intValue())) {
                a0(HardCodeUtil.qqStr(R.string.zmb), this.P.intValue());
            }
        }
    }

    private void E(IntimateInfo intimateInfo) {
        if (intimateInfo != null && intimateInfo.mutualMarkList != null) {
            c0(intimateInfo);
            b0(intimateInfo);
        }
    }

    private void F(IntimateInfo intimateInfo) {
        if (intimateInfo != null && !TextUtils.isEmpty(intimateInfo.friendUin)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("IntimateElegantCardView", 1, "cacheIntimateInfo fail, AppRuntime is null");
                return;
            }
            String format = String.format(Locale.getDefault(), "%s_%s", peekAppRuntime.getCurrentAccountUin(), intimateInfo.friendUin);
            LruCache<String, IntimateInfo> lruCache = f179231k0;
            if (lruCache.get(format) != null) {
                lruCache.remove(format);
            }
            lruCache.put(format, intimateInfo);
            return;
        }
        QLog.e("IntimateElegantCardView", 1, "cacheIntimateInfo fail, intimateInfo invalid");
    }

    private void G() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).checkDownloadCartoonResource(peekAppRuntime, f179232l0, f179233m0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final int i3) {
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.view.IntimateElegantCardView.7
            @Override // java.lang.Runnable
            public void run() {
                IntimateElegantCardView.this.H.g(i3);
            }
        }, 500L);
    }

    private void I(IntimateInfo intimateInfo, boolean z16) {
        h hVar;
        List<MutualMarkModel> list;
        if (intimateInfo != null && (hVar = intimateInfo.mutualMarkList) != null && (list = hVar.f397922c) != null) {
            this.N.clear();
            this.P = null;
            this.T = false;
            for (int i3 = 0; i3 < list.size(); i3++) {
                MutualMarkModel mutualMarkModel = list.get(i3);
                if (mutualMarkModel.N) {
                    this.T = true;
                }
                if (this.P == null && N(mutualMarkModel)) {
                    this.P = Integer.valueOf(i3);
                }
                if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewIcon(z16, intimateInfo.friendUin, mutualMarkModel)) {
                    this.N.add(Integer.valueOf(i3));
                }
            }
        }
    }

    private IntimateInfo J(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("IntimateElegantCardView", 1, "cacheIntimateInfo fail, intimateInfo invalid");
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("IntimateElegantCardView", 1, "cacheIntimateInfo fail, AppRuntime is null");
            return null;
        }
        return f179231k0.get(String.format(Locale.getDefault(), "%s_%s", peekAppRuntime.getCurrentAccountUin(), str));
    }

    private void K() {
        Banner banner = (Banner) this.F.findViewById(R.id.zlb);
        this.L = banner;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) banner.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = (int) this.f179240g0.a();
        this.L.setLayoutParams(layoutParams);
    }

    private void L() {
        FrameLayout.LayoutParams layoutParams;
        View view = this.F;
        if (view == null) {
            return;
        }
        this.H = (SquaredIndicatorView) view.findViewById(R.id.co5);
        this.I = (ImageView) this.F.findViewById(R.id.vfe);
        SquaredIndicatorView squaredIndicatorView = this.H;
        if (squaredIndicatorView == null || (layoutParams = (FrameLayout.LayoutParams) squaredIndicatorView.getLayoutParams()) == null) {
            return;
        }
        RelativeLayout relativeLayout = this.J;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = ViewUtils.dpToPx(16.0f);
        }
        layoutParams.bottomMargin = ViewUtils.dpToPx(20.0f);
        this.H.setLayoutParams(layoutParams);
        this.H.setOnEmptyClickListener(this.f179242i0);
        this.H.setEmptyMutualIconUrl(((com.tencent.mobileqq.activity.aio.intimate.header.h) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config")).getNoElegantCardIconUrl());
    }

    private void M() {
        View view = this.F;
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.zqd);
        this.J = relativeLayout;
        this.W = (ImageView) relativeLayout.findViewById(R.id.zqf);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.topMargin = this.f179240g0.c();
        this.J.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
        layoutParams2.height = (int) this.f179240g0.b();
        this.W.setLayoutParams(layoutParams2);
    }

    private boolean N(MutualMarkModel mutualMarkModel) {
        List<MutualMarkModel.Button> list;
        if (mutualMarkModel == null || (list = mutualMarkModel.Z) == null) {
            return false;
        }
        boolean z16 = false;
        for (MutualMarkModel.Button button : list) {
            if (HardCodeUtil.qqStr(R.string.f13825092).equals(button.f252163e) && !button.f252166i) {
                z16 = true;
            }
        }
        if (!mutualMarkModel.N || mutualMarkModel.M || !z16) {
            return false;
        }
        return true;
    }

    private void O() {
        String str;
        if (this.f179219d == null) {
            return;
        }
        Intent intent = new Intent(this.f179219d, (Class<?>) QQBrowserActivity.class);
        String str2 = "&has_show_guid=" + (!((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewerGuideMode() ? 1 : 0);
        IntimateInfo intimateInfo = this.Q;
        if (intimateInfo != null) {
            str = intimateInfo.friendUin;
        } else {
            str = "";
        }
        intent.putExtra("url", "https://ti.qq.com/interactive_new/index/?_wv=3&_wwv=1&target_uin=" + str + "&source=0" + str2);
        this.f179219d.startActivity(intent);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_interact_tag_area", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), new HashMap<>());
        IntimateHeaderCardUtil.U("dt_clck", "pg_aio_swipleft", "em_bas_top_right_arrow", new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        O();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(f61.a aVar, String str) {
        if (aVar == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("interaction_active_jump_link", aVar.f397890b);
        if (aVar.f397893e.booleanValue() && "dt_imp".equals(str)) {
            return;
        }
        if ("dt_imp".equals(str)) {
            aVar.f397893e = Boolean.TRUE;
        }
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent(str, "pg_aio_swipleft", "em_tag_banner", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), hashMap);
    }

    private void U(IntimateInfo intimateInfo) {
        String valueOf = String.valueOf(intimateInfo.mutualMarkList.f397920a);
        int i3 = (intimateInfo.mutualMarkList.f397920a + 1) / 10;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("lighten_tag_acount", valueOf);
        hashMap.put("interact_tag_pagecount", String.valueOf(i3));
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).restoreInteractTagAreaData(hashMap);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_interact_tag_area", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), hashMap);
    }

    private List<MutualMarkModel> V(List<MutualMarkModel> list, boolean z16) {
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewerGuideMode() && !z16 && list.size() != 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= list.size()) {
                    break;
                }
                if (list.get(i16).D == 44) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
            MutualMarkModel mutualMarkModel = list.get(i3);
            list.remove(i3);
            list.add(1, mutualMarkModel);
        }
        return list;
    }

    private List<MutualMarkModel> W(List<MutualMarkModel> list) {
        if (list != null && list.size() != 0) {
            int i3 = 0;
            while (true) {
                if (i3 < list.size()) {
                    if (list.get(i3).D == 17) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                return list;
            }
            MutualMarkModel mutualMarkModel = list.get(i3);
            if (mutualMarkModel.N) {
                return list;
            }
            list.remove(i3);
            if (list.size() <= 14) {
                list.add(list.size(), mutualMarkModel);
                return list;
            }
            list.add(14, mutualMarkModel);
        }
        return list;
    }

    private void X(MutualMarkModel mutualMarkModel) {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setIconWithModel(this.I, mutualMarkModel, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(boolean z16) {
        RelativeLayout relativeLayout = this.J;
        if (relativeLayout == null) {
            return;
        }
        if (z16) {
            relativeLayout.setVisibility(8);
        } else {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_interact_tag_newversion_tips", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), null);
            this.J.setVisibility(0);
        }
        L();
    }

    private void Z(String str) {
        if (this.J == null) {
            return;
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            this.W.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        } catch (IllegalArgumentException e16) {
            QLog.e("IntimateElegantCardView", 1, "illegal url :", str, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(String str, int i3) {
        if (this.H == null) {
            return;
        }
        Y(true);
        this.f179243j0.f179256a = str;
        this.H.e(i3, new WeakReference<>(this.f179243j0));
    }

    private void b0(IntimateInfo intimateInfo) {
        String str;
        LinearLayout linearLayout = (LinearLayout) this.F.findViewById(R.id.vfd);
        if (intimateInfo.mutualMarkList.f397925f.size() == 0) {
            linearLayout.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.F.findViewById(R.id.liw);
        if (intimateInfo.mutualMarkList.f397925f.size() > 1) {
            str = String.format(Locale.getDefault(), "\u7b49%d\u6807\u8bc6\u5373\u5c06\u7184\u706d", Integer.valueOf(intimateInfo.mutualMarkList.f397925f.size()));
        } else {
            str = "\u5373\u5c06\u7184\u706d";
        }
        textView.setText(str);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("exting_tag_acount", Integer.valueOf(intimateInfo.mutualMarkList.f397925f.size()));
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_interact_tag_exting", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), hashMap);
        if (!this.R && linearLayout.getVisibility() == 8) {
            QUIInvertViewLayout qUIInvertViewLayout = (QUIInvertViewLayout) this.F.findViewById(R.id.vff);
            qUIInvertViewLayout.p(R.anim.f154986ut, 10);
            this.F.findViewById(R.id.vfd).setOnClickListener(new b(intimateInfo));
            X(intimateInfo.mutualMarkList.f397925f.get(0));
            qUIInvertViewLayout.q();
        } else {
            this.F.findViewById(R.id.vfd).setOnClickListener(new c(intimateInfo));
            X(intimateInfo.mutualMarkList.f397925f.get(0));
            this.F.findViewById(R.id.vfd).setVisibility(0);
        }
        this.R = true;
    }

    private void c0(IntimateInfo intimateInfo) {
        String format;
        TextView textView = this.f179235b0;
        if (textView == null) {
            return;
        }
        if (intimateInfo.mutualMarkList.f397920a == 0) {
            format = "";
        } else {
            format = String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(intimateInfo.mutualMarkList.f397920a), Integer.valueOf(intimateInfo.mutualMarkList.f397921b));
        }
        textView.setText(format);
        if (this.S && this.N.size() == 0 && !this.f179237d0.n()) {
            this.f179235b0.setVisibility(0);
            return;
        }
        this.f179237d0.removeAllViews();
        this.f179237d0.addView(this.f179235b0);
        this.f179235b0.setVisibility(8);
        if (this.N.size() > 0) {
            this.f179236c0.setText(String.format(Locale.getDefault(), "\u00b7\u65b0\u83b7\u5f97%d\u4e2a\u6807\u8bc6", Integer.valueOf(this.N.size())));
            this.f179237d0.addView(this.f179236c0);
        } else {
            this.f179236c0.setVisibility(8);
        }
        this.f179237d0.p(R.anim.f154986ut, 10);
        this.f179237d0.q();
        this.S = true;
    }

    private boolean d0(String str, int i3) {
        boolean z16;
        Z("https://downv6.qq.com/extendfriend/qq_mutualmark_newerguide_tips.png");
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getUnsafeLocalCache("Is_New_To_Version_Two") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && this.J != null) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setUnsafeLocalCache("Is_New_To_Version_Two", 1);
            Y(false);
            ((ImageView) this.J.findViewById(R.id.zqe)).setOnClickListener(new a(i3, str));
            return true;
        }
        Y(true);
        return false;
    }

    private void e0(long j3, boolean z16) {
        MutualMarkDetailListHelper mutualMarkDetailListHelper = this.f179234a0;
        if (mutualMarkDetailListHelper != null && mutualMarkDetailListHelper.m() != null) {
            ArrayList<MutualMarkModel> m3 = this.f179234a0.m();
            MutualMarkModel mutualMarkModel = null;
            for (MutualMarkModel mutualMarkModel2 : m3) {
                if (j3 == mutualMarkModel2.D) {
                    mutualMarkModel = mutualMarkModel2;
                }
            }
            if (mutualMarkModel == null) {
                return;
            }
            String str = "";
            for (MutualMarkModel.Button button : mutualMarkModel.Z) {
                if (!button.f252166i && !TextUtils.isEmpty(button.f252165h)) {
                    str = button.f252165h;
                    button.f252166i = true;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (MutualMarkModel.Button button2 : mutualMarkModel.Z) {
                if (str.equals(button2.f252162d)) {
                    button2.f252166i = false;
                }
            }
            if (z16) {
                mutualMarkModel.M = !mutualMarkModel.M;
            } else {
                mutualMarkModel.M = false;
                mutualMarkModel.N = true;
                mutualMarkModel.f252159h = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getIconUrlFormat(mutualMarkModel);
            }
            I(this.Q, false);
            this.f179234a0.r(new ArrayList<>(m3));
        }
    }

    private void f0(long j3, boolean z16) {
        h hVar;
        IntimateInfo intimateInfo = this.Q;
        if (intimateInfo != null && (hVar = intimateInfo.mutualMarkList) != null) {
            MutualMarkModel mutualMarkModel = null;
            for (MutualMarkModel mutualMarkModel2 : hVar.f397922c) {
                if (j3 == mutualMarkModel2.D) {
                    mutualMarkModel = mutualMarkModel2;
                }
            }
            if (mutualMarkModel == null) {
                return;
            }
            String str = "";
            for (MutualMarkModel.Button button : mutualMarkModel.Z) {
                if (!button.f252166i && !TextUtils.isEmpty(button.f252165h)) {
                    str = button.f252165h;
                    button.f252166i = true;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (MutualMarkModel.Button button2 : mutualMarkModel.Z) {
                if (str.equals(button2.f252162d)) {
                    button2.f252166i = false;
                }
            }
            if (this.H == null) {
                return;
            }
            if (z16) {
                mutualMarkModel.M = !mutualMarkModel.M;
            } else {
                mutualMarkModel.M = false;
                mutualMarkModel.N = true;
                mutualMarkModel.H = 0L;
                mutualMarkModel.f252159h = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getIconUrlFormat(mutualMarkModel);
            }
            I(this.Q, false);
            this.H.i(this.Q.mutualMarkList.f397922c);
        }
    }

    public boolean Q() {
        S();
        SquaredIndicatorView squaredIndicatorView = this.H;
        if (squaredIndicatorView != null) {
            return squaredIndicatorView.j();
        }
        return false;
    }

    public void R(long j3, boolean z16) {
        f0(j3, z16);
        e0(j3, z16);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            MutualMarkDialogUtil.c(true);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.view.IntimateElegantCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    MutualMarkDialogUtil.c(true);
                }
            });
        }
    }

    public void S() {
        View view = this.K;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.gz5, (ViewGroup) this, true);
        this.F = inflate;
        this.G = (NtMutualMarkListView) inflate.findViewById(R.id.vfg);
        L();
        K();
        M();
        setOnTouchListener(this);
        this.f179235b0 = (TextView) this.F.findViewById(R.id.vfa);
        this.f179236c0 = (TextView) this.F.findViewById(R.id.vfc);
        this.f179237d0 = (QUIInvertViewLayout) this.F.findViewById(R.id.vfb);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.view.IntimateElegantCardView.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.mutualmark.model.b cardResource = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getCardResource(1);
                if (cardResource != null) {
                    com.tencent.mobileqq.mutualmark.widget.util.f.b(cardResource.f252175c, "specialBackground");
                }
                IntimateHeaderCardUtil.U("dt_imp", "pg_aio_swipleft", "em_bas_top_right_arrow", new HashMap());
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void d() {
        SquaredIndicatorView squaredIndicatorView = this.H;
        if (squaredIndicatorView != null) {
            squaredIndicatorView.j();
            this.H.d();
        }
        if (this.f179234a0 != null) {
            this.f179234a0 = null;
        }
        NtMutualMarkListView ntMutualMarkListView = this.G;
        if (ntMutualMarkListView != null) {
            ntMutualMarkListView.a();
            this.G = null;
        }
        com.tencent.mobileqq.mutualmark.widget.util.b.e().f();
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void e() {
        super.e();
        S();
        Y(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void f() {
        super.f();
        this.U = true;
        this.V = true;
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).addIntimateElegantPageShowTimes();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
        h hVar;
        if (intimateInfo != null && !MutualMarkDetailListHelper.f252336n) {
            h hVar2 = intimateInfo.mutualMarkList;
            if (hVar2 == null || hVar2.f397922c == null) {
                QLog.e("IntimateElegantCardView", 1, "data = null or card is showing, friendUin = " + intimateInfo.friendUin + " updateTimeMills = " + intimateInfo.updateTimeMills);
                intimateInfo = J(intimateInfo.friendUin);
                if (intimateInfo == null || (hVar = intimateInfo.mutualMarkList) == null || hVar.f397922c == null) {
                    QLog.e("IntimateElegantCardView", 1, "doUpdateIntimateInfo fail, cache not exist");
                    return;
                }
            }
            F(intimateInfo);
            if (intimateInfo.mutualMarkList.f397922c.size() == 0) {
                QLog.e("IntimateElegantCardView", 1, "allMutualMarks.size() == 0 friendUin = " + intimateInfo.friendUin + " updateTimeMills = " + intimateInfo.updateTimeMills);
            }
            this.Q = intimateInfo;
            G();
            MutualMarkDetailListHelper.f252337o = intimateInfo.friendUin;
            I(intimateInfo, true);
            E(intimateInfo);
            C(intimateInfo);
            B(intimateInfo);
            D();
            return;
        }
        QLog.e("IntimateElegantCardView", 1, "doUpdateIntimateInfo fail, detailShowing=" + MutualMarkDetailListHelper.f252336n);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.e("IntimateElegantCardView", 1, "onConfigurationChanged");
        SquaredIndicatorView squaredIndicatorView = this.H;
        if (squaredIndicatorView == null) {
            return;
        }
        squaredIndicatorView.m();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    return true;
                }
                return false;
            }
            if (((int) Math.sqrt(Math.pow(motionEvent.getX() - this.f179238e0, 2.0d) + Math.pow(motionEvent.getY() - this.f179239f0, 2.0d))) < 20) {
                O();
            }
            return true;
        }
        this.f179238e0 = motionEvent.getX();
        this.f179239f0 = motionEvent.getY();
        return true;
    }

    public void setIsZplanMode(Boolean bool) {
        this.f179241h0 = bool.booleanValue();
    }

    public IntimateElegantCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntimateElegantCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = new ArrayList();
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f179238e0 = 0.0f;
        this.f179239f0 = 0.0f;
        this.f179241h0 = false;
        this.f179242i0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntimateElegantCardView.this.P(view);
            }
        };
        this.f179243j0 = new f();
        this.f179240g0 = new com.tencent.mobileqq.mutualmark.util.a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements qz3.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f179253d;

        d(List list) {
            this.f179253d = list;
        }

        @Override // qz3.b
        public void onPageScrolled(int i3, float f16, int i16) {
            if (i3 >= 0 && i3 < this.f179253d.size()) {
                IntimateElegantCardView.this.T((f61.a) this.f179253d.get(i3), "dt_imp");
            }
        }

        @Override // qz3.b
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // qz3.b
        public void onPageSelected(int i3) {
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
    }
}

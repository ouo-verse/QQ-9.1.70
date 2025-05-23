package com.tencent.mobileqq.troopgift;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.qzone.homepage.business.model.FunnySpaceModel;
import com.tencent.ads.data.AdParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper$Entrance;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vas.tianshu.ADInfo;
import com.tencent.mobileqq.vas.tianshu.VasAdBannerView;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.helper.bc;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import sh2.c;

/* loaded from: classes19.dex */
public class GiftPanelControllerWithGiftRepo implements c.InterfaceC11228c {
    static IPatchRedirector $redirector_;
    private View C;
    private View D;
    private bc E;
    private LinearLayout F;
    private GiftPanelHelper$Entrance G;
    private String H;
    private String I;
    private String J;
    private List<String> K;
    private long L;
    private LinearLayout M;
    private PopupWindow N;
    private com.tencent.mobileqq.vas.tianshu.c P;
    private final Runnable Q;
    private Handler R;

    /* renamed from: d, reason: collision with root package name */
    private nh2.c f302726d;

    /* renamed from: e, reason: collision with root package name */
    private sh2.c f302727e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f302728f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f302729h;

    /* renamed from: i, reason: collision with root package name */
    private View f302730i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f302731m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftPanelControllerWithGiftRepo.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (GiftPanelControllerWithGiftRepo.this.E()) {
                GiftPanelControllerWithGiftRepo.this.f302727e.hide();
                new com.tencent.mobileqq.troopgift.e(GiftPanelControllerWithGiftRepo.this.q(), GiftPanelControllerWithGiftRepo.this.J).w();
            } else {
                GiftPanelControllerWithGiftRepo.this.S();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements c.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftPanelControllerWithGiftRepo.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f302734d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f302735e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ VasAdBannerView f302736f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ADInfo f302737h;

        c(String str, QBaseActivity qBaseActivity, VasAdBannerView vasAdBannerView, ADInfo aDInfo) {
            this.f302734d = str;
            this.f302735e = qBaseActivity;
            this.f302736f = vasAdBannerView;
            this.f302737h = aDInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GiftPanelControllerWithGiftRepo.this, str, qBaseActivity, vasAdBannerView, aDInfo);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!TextUtils.isEmpty(this.f302734d)) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.f302735e, this.f302734d);
                this.f302736f.setVisibility(8);
                GiftPanelControllerWithGiftRepo.this.P.b(true, this.f302737h.getReportInfo());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class d implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftPanelControllerWithGiftRepo.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (GiftPanelControllerWithGiftRepo.this.f302727e != null && GiftPanelControllerWithGiftRepo.this.f302727e.n() != null) {
                GiftPanelControllerWithGiftRepo.this.f302727e.n().a();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f302740d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f302741e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f302742f;

        e(String str, String str2, QBaseActivity qBaseActivity) {
            this.f302740d = str;
            this.f302741e = str2;
            this.f302742f = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GiftPanelControllerWithGiftRepo.this, str, str2, qBaseActivity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (GiftPanelControllerWithGiftRepo.this.f302727e != null && GiftPanelControllerWithGiftRepo.this.f302727e.n() != null) {
                    GiftPanelControllerWithGiftRepo.this.f302727e.n().d(this.f302740d);
                }
                if (!TextUtils.isEmpty(GiftPanelControllerWithGiftRepo.this.J)) {
                    str = this.f302741e.replace("{troopUin}", GiftPanelControllerWithGiftRepo.this.J);
                } else {
                    str = this.f302741e;
                }
                if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.f302742f, str);
                } else {
                    Intent intent = new Intent(this.f302742f, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str);
                    this.f302742f.startActivity(intent);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class f implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f302744d;

        f(String str) {
            this.f302744d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftPanelControllerWithGiftRepo.this, (Object) str);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (GiftPanelControllerWithGiftRepo.this.f302727e != null && GiftPanelControllerWithGiftRepo.this.f302727e.n() != null) {
                GiftPanelControllerWithGiftRepo.this.f302727e.n().c(this.f302744d);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }
    }

    public GiftPanelControllerWithGiftRepo(bc bcVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bcVar);
            return;
        }
        this.G = null;
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = new ArrayList();
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.troopgift.GiftPanelControllerWithGiftRepo.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftPanelControllerWithGiftRepo.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (GiftPanelControllerWithGiftRepo.this.N != null && GiftPanelControllerWithGiftRepo.this.N.isShowing()) {
                    GiftPanelControllerWithGiftRepo.this.N.dismiss();
                }
            }
        };
        this.E = bcVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add("gift_pic");
        arrayList.add("background_pic");
        arrayList.add("text");
        arrayList.add(FunnySpaceModel.EXTRA_KEY_ICON_URL);
        arrayList.add(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        this.P = new com.tencent.mobileqq.vas.tianshu.c(1274, 209, arrayList);
    }

    private void A() {
        int i3;
        int parseColor;
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        View findViewById = this.D.findViewById(R.id.yq9);
        if (findViewById != null) {
            Drawable background = findViewById.getBackground();
            if (background instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (isNowThemeIsNight) {
                    parseColor = Color.parseColor("#33FFFFFF");
                } else {
                    parseColor = Color.parseColor("#14000000");
                }
                gradientDrawable.setColor(parseColor);
            }
            findViewById.setBackgroundDrawable(background);
            findViewById.addOnAttachStateChangeListener(new d());
        }
        TextView textView = (TextView) this.D.findViewById(R.id.f110476im);
        if (textView != null) {
            if (isNowThemeIsNight) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            textView.setTextColor(i3);
        }
    }

    private void B(Intent intent) {
        this.H = "";
        this.I = "";
        this.K.clear();
        if (intent == null) {
            return;
        }
        this.C.setVisibility(0);
        if (this.G == GiftPanelHelper$Entrance.TROOP_PROFILE_CARD) {
            this.C.setVisibility(8);
            this.J = intent.getStringExtra("aio_troop_uin");
            this.H = intent.getStringExtra("member_uin");
            this.I = intent.getStringExtra("member_display_name");
            return;
        }
        if (E()) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("multi_receivers");
            if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
                this.K.addAll(stringArrayListExtra);
            } else {
                this.H = intent.getStringExtra("member_uin");
            }
            this.I = intent.getStringExtra("member_display_name");
            return;
        }
        if (this.G == GiftPanelHelper$Entrance.TROOP_GIFT_ITEM_BACK) {
            this.H = intent.getStringExtra("member_uin");
            this.I = intent.getStringExtra("member_display_name");
        }
    }

    private void C(ImageView imageView, Map<String, String> map, URLDrawable.URLDrawableOptions uRLDrawableOptions, String str) {
        String str2 = map.get(str);
        QBaseActivity q16 = q();
        if (q16 != null && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String string = jSONObject.getString("icon");
                int i3 = jSONObject.getInt("show");
                String string2 = jSONObject.getString("jump");
                String string3 = jSONObject.getString("text");
                if (i3 == 0) {
                    QLog.i("GiftPanelControllerWithGiftRepo", 1, "initSingleAdItem :isCanShow: " + i3);
                    return;
                }
                VideoReport.setElementId(imageView, "em_qq_gift_panel_entrance");
                VideoReport.setElementParams(imageView, new HashMap<String, String>(str) { // from class: com.tencent.mobileqq.troopgift.GiftPanelControllerWithGiftRepo.6
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$entryName;

                    {
                        this.val$entryName = str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftPanelControllerWithGiftRepo.this, (Object) str);
                        } else {
                            put("qq_position_name", str);
                        }
                    }
                });
                imageView.setImageDrawable(URLDrawable.getDrawable(string, uRLDrawableOptions));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(40.0f), ViewUtils.dpToPx(40.0f));
                layoutParams.setMargins(0, 0, ViewUtils.dip2px(15.0f), 0);
                if (imageView.getParent() == null) {
                    this.F.addView(imageView, layoutParams);
                }
                if (TextUtils.isEmpty(string2)) {
                    QLog.e("GiftPanelControllerWithGiftRepo", 1, "initSingleAdItem error :jumpUrl is empty");
                    return;
                } else {
                    imageView.setOnClickListener(new e(string3, string2, q16));
                    imageView.addOnAttachStateChangeListener(new f(string3));
                    return;
                }
            } catch (JSONException e16) {
                QLog.e("GiftPanelControllerWithGiftRepo", 1, "initSingleAdItem error :", e16);
                return;
            }
        }
        QLog.e("GiftPanelControllerWithGiftRepo", 1, "initSingleAdItem error :activity:" + q16 + " singleItemData:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        GiftPanelHelper$Entrance giftPanelHelper$Entrance = this.G;
        if (giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_BIRTH_PICK_MEMBER && giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_BIRTH_BANNER && giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_BIRTH_ITEM) {
            return false;
        }
        return true;
    }

    public static boolean F() {
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "isCanOpenGiftPanelUseRepo :app is null");
            return false;
        }
        return ((IFeatureRuntimeService) app.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("vas_group_gift_panel", false);
    }

    private boolean G() {
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "isCanShowPackageTab :app is null");
            return false;
        }
        return ((IFeatureRuntimeService) app.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("vas_group_gift_panel_pkgtab", false);
    }

    private boolean H(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (dVar.f264875d0 || dVar.f264878f <= this.f302726d.f().s() || dVar.f264878f <= this.f302726d.f().u()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(QBaseActivity qBaseActivity, ADInfo aDInfo) {
        VasAdBannerView vasAdBannerView = new VasAdBannerView(qBaseActivity);
        vasAdBannerView.setOnClickListener(new c(aDInfo.a().get(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK), qBaseActivity, vasAdBannerView, aDInfo));
        vasAdBannerView.a(aDInfo);
        this.f302727e.k().addView(vasAdBannerView, new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(48.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(final QBaseActivity qBaseActivity, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        final ADInfo a16 = this.P.a(getAdsRsp);
        if (a16 != null && a16.a().size() != 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troopgift.b
                @Override // java.lang.Runnable
                public final void run() {
                    GiftPanelControllerWithGiftRepo.this.I(qBaseActivity, a16);
                }
            });
            this.P.b(false, a16.getReportInfo());
        } else {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "adinfo is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(String str, List list) {
        QQToast.makeText(BaseApplication.getContext(), 1, MessageFormat.format(HardCodeUtil.qqStr(R.string.f2324974p), str, Integer.valueOf(list.size())), 3000).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(final List list, TroopMemberInfo troopMemberInfo) {
        final String str;
        if (troopMemberInfo != null) {
            str = troopMemberInfo.friendnick;
        } else {
            str = this.H;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troopgift.d
            @Override // java.lang.Runnable
            public final void run() {
                GiftPanelControllerWithGiftRepo.K(str, list);
            }
        });
    }

    private boolean M() {
        if (Math.abs(System.currentTimeMillis() - this.L) < 500) {
            return true;
        }
        return false;
    }

    private boolean N() {
        GiftPanelHelper$Entrance giftPanelHelper$Entrance = this.G;
        if (giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_PLUS_PANEL && giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_GIFT_EASTER_EGG && giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_GIFT_ITEM) {
            return false;
        }
        return true;
    }

    private void P() {
        String str;
        int i3;
        bc bcVar;
        PopupWindow popupWindow = this.N;
        if (popupWindow != null && popupWindow.getContentView() != null) {
            ImageView imageView = (ImageView) this.N.getContentView().findViewById(R.id.eff);
            TextView textView = (TextView) this.N.getContentView().findViewById(R.id.efo);
            CardView cardView = (CardView) this.N.getContentView().findViewById(R.id.a4j);
            if (QQTheme.isNowThemeIsNight()) {
                str = "#3D3D3D";
            } else {
                str = "#FFFFFF";
            }
            cardView.setCardBackgroundColor(Color.parseColor(str));
            if (QQTheme.isNowThemeIsNight()) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            textView.setTextColor(i3);
            textView.setText(R.string.f2324774n);
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setRequestHeight(ViewUtils.dip2px(100.0f));
            apngOptions.setRequestWidth(ViewUtils.dip2px(100.0f));
            apngOptions.setLoop(1);
            imageView.setImageDrawable(com.tencent.mobileqq.vas.apng.api.a.a().getApngURLDrawable("GiftPanelControllerWithGiftRepo", "https://tianquan.gtimg.cn/uncategorized/vas_groupgift_success.png", apngOptions));
            this.N.setFocusable(false);
            this.N.setOutsideTouchable(true);
            if (!this.N.isShowing() && (bcVar = this.E) != null) {
                bcVar.a(this.N);
            }
            this.R.removeCallbacks(this.Q);
            this.R.postDelayed(this.Q, 3000L);
        }
    }

    private void Q(final List<String> list) {
        if (list.size() > 0) {
            ((ITroopMemberInfoService) u().getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(this.J, list.iterator().next(), "GiftPanelControllerWithGiftRepo", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troopgift.c
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    GiftPanelControllerWithGiftRepo.this.L(list, troopMemberInfo);
                }
            });
        }
    }

    private void R() {
        QQAppInterface u16 = u();
        if (u16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "saveLastReceiverForTroop app is null");
            return;
        }
        if (!TextUtils.isEmpty(this.J) && !TextUtils.isEmpty(this.H)) {
            VasMMKV.getTroopGift(u16.getCurrentUin()).encodeString("lastReceiver" + this.J + "_id", this.H);
            VasMMKV.getTroopGift(u16.getCurrentUin()).encodeString("lastReceiver" + this.J + ThemeConstants.THEME_DIY_BG_NAME_SUFFIX, this.I);
        }
    }

    private void T() {
        QQAppInterface u16 = u();
        if (u16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "resetReceiver app is null");
            V(null);
            return;
        }
        if (!TextUtils.isEmpty(this.J) && N()) {
            this.H = VasMMKV.getTroopGift(u16.getCurrentUin()).decodeString("lastReceiver" + this.J + "_id", "");
            this.I = VasMMKV.getTroopGift(u16.getCurrentUin()).decodeString("lastReceiver" + this.J + ThemeConstants.THEME_DIY_BG_NAME_SUFFIX, "");
        }
        if (TextUtils.isEmpty(this.H)) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "resetReceiver memberId:" + this.H + " memberName:" + this.I);
            V(null);
            return;
        }
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(u16, 1, this.H);
        if (faceDrawable == null) {
            V(null);
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "resetReceiver memberId:" + this.H + " drawable is null");
            return;
        }
        V(faceDrawable);
    }

    private void U() {
        if (this.K.size() < 2) {
            return;
        }
        this.f302728f.setText(MessageFormat.format("{0}\u7b49{1}\u4eba", this.I, Integer.valueOf(this.K.size())));
        this.f302731m.setVisibility(8);
        int min = Math.min(this.K.size(), 3);
        for (int i3 = 0; i3 < min; i3++) {
            ImageView imageView = new ImageView(this.f302728f.getContext());
            if (q() != null) {
                imageView.setBackground(ResourcesCompat.getDrawable(q().getResources(), R.drawable.cac, null));
            }
            QQAppInterface u16 = u();
            if (u16 != null) {
                FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(u16, 1, this.K.get(i3));
                faceDrawable.setBounds(ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(22.0f), ViewUtils.dpToPx(22.0f));
                if (i3 == min - 1 && this.K.size() > 3) {
                    try {
                        imageView.setImageDrawable(new LayerDrawable(new Drawable[]{faceDrawable, ResourcesCompat.getDrawable(q().getResources(), R.drawable.lvt, null)}));
                    } catch (Exception e16) {
                        QLog.e("GiftPanelControllerWithGiftRepo", 1, "layerDrawable error:" + e16);
                        imageView.setImageDrawable(faceDrawable);
                    }
                } else {
                    imageView.setImageDrawable(faceDrawable);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(24.0f), ViewUtils.dpToPx(24.0f));
                if (i3 > 0) {
                    layoutParams.setMargins(-ViewUtils.dpToPx(10.0f), 0, 0, 0);
                }
                imageView.setLayoutParams(layoutParams);
                imageView.setPadding(ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f));
                this.M.addView(imageView, layoutParams);
            }
        }
    }

    private void Y() {
        bc bcVar = this.E;
        if (bcVar != null) {
            bcVar.b();
        }
    }

    private String n() {
        GiftPanelHelper$Entrance giftPanelHelper$Entrance = this.G;
        if (giftPanelHelper$Entrance == GiftPanelHelper$Entrance.TROOP_PLUS_PANEL) {
            return "1";
        }
        if (giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_BIRTH_BANNER && giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_BIRTH_PICK_MEMBER) {
            if (giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_GIFT_ITEM && giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_BIRTH_ITEM && giftPanelHelper$Entrance != GiftPanelHelper$Entrance.TROOP_GIFT_ITEM_BACK) {
                if (giftPanelHelper$Entrance == GiftPanelHelper$Entrance.TROOP_PROFILE_CARD) {
                    return "4";
                }
                return "";
            }
            return "3";
        }
        return "2";
    }

    private String o(String str) {
        GroupAnonymousInfo anonymousInfo;
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && i3.getMsgService() != null && (anonymousInfo = i3.getMsgService().getAnonymousInfo(str)) != null && anonymousInfo.getIsAnonymousChat()) {
            String anonyNick = anonymousInfo.getAnonyNick();
            String valueOf = String.valueOf(anonymousInfo.getHeadPicIndex());
            String rankColor = anonymousInfo.getRankColor();
            if (anonyNick != null) {
                return "name=" + anonyNick + "&id=" + valueOf + "&color=" + rankColor;
            }
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "getAnonymousInfo error :nickname is null");
        }
        return "";
    }

    private String p(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "getAnonymousSignString error :strToTransfer is empty");
            return "";
        }
        try {
            return new String(Hex.encodeHex(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest((str + "&key=" + QVipGiftProcessor.getConfig().anonymousFlag).getBytes("utf-8"))));
        } catch (Exception e16) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "getAnonymousSignString error :", e16);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public QBaseActivity q() {
        QBaseActivity qBaseActivity = null;
        if (VasNormalToggle.VAS_GET_GIFT_BASE_ACTIVITY.isEnable(false)) {
            QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
            if (qBaseActivity2 == null) {
                return null;
            }
            return qBaseActivity2;
        }
        QBaseActivity qBaseActivity3 = QBaseActivity.sTopActivity;
        if (qBaseActivity3 != null) {
            qBaseActivity = qBaseActivity3;
        }
        if (qBaseActivity == null) {
            Iterator<WeakReference<Activity>> it = Foreground.getResumedActivity().iterator();
            while (it.hasNext()) {
                Activity activity = it.next().get();
                QLog.d("GiftPanelControllerWithGiftRepo", 1, "temp " + activity);
                if ((activity instanceof SplashActivity) && !activity.isDestroyed() && !activity.isFinishing()) {
                    qBaseActivity = (SplashActivity) activity;
                }
            }
            return qBaseActivity;
        }
        return qBaseActivity;
    }

    private com.tencent.mobileqq.qqgift.mvvm.business.data.a s() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.a();
        aVar.f264951r = this.J;
        aVar.f264947n = this.G.getString();
        return aVar;
    }

    private static QQAppInterface u() {
        if (MobileQQ.sProcessId == 1) {
            AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                return (QQAppInterface) peekAppRuntime;
            }
        }
        return null;
    }

    private void v(String str) {
        QBaseActivity q16 = q();
        if (q16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "gotoTroopAio error :activity is null");
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(q16), null);
        m3.putExtra("uin", str);
        m3.putExtra("uintype", 1);
        q16.startActivity(m3);
    }

    private void x(Intent intent) {
        QBaseActivity q16 = q();
        if (q16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "init error :activity is : null");
            return;
        }
        View inflate = View.inflate(q16, R.layout.hhk, null);
        this.D = inflate;
        this.F = (LinearLayout) inflate.findViewById(R.id.sau);
        nh2.c cVar = this.f302726d;
        if (cVar == null || cVar.isDestroyed()) {
            this.f302726d = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(10012);
            com.tencent.mobileqq.qqgift.sdk.config.a b16 = com.tencent.mobileqq.qqgift.sdk.config.a.a().d(10012).e("10012").f("1001").b();
            b16.f264981j = !E();
            this.f302726d.c(q16.getAppRuntime(), b16);
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("groupID", this.J);
        if (this.J.isEmpty()) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "init curTroopUin is null");
        }
        this.f302726d.getSDKConfig().f264980i = hashMap;
        this.f302726d.getSDKConfig().f264981j = true ^ E();
        this.f302727e = this.f302726d.d().p(q16);
        View findViewById = this.D.findViewById(R.id.vpy);
        this.C = findViewById;
        this.f302731m = (ImageView) findViewById.findViewById(R.id.y7q);
        this.f302728f = (TextView) this.C.findViewById(R.id.f110476im);
        this.M = (LinearLayout) this.C.findViewById(R.id.y5z);
        this.f302729h = (TextView) this.f302727e.getContentView().findViewById(R.id.f167042k73);
        y();
        z(q16);
        A();
        B(intent);
        View inflate2 = LayoutInflater.from(q16).inflate(R.layout.hhl, (ViewGroup) null);
        this.f302730i = inflate2;
        VideoReport.setElementId(inflate2, "em_qq_gift_panel_package");
        this.C.findViewById(R.id.vpy).setOnClickListener(new a());
        LinearLayout k3 = this.f302727e.k();
        k3.addView(this.D, new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(40.0f)));
        k3.setPadding(k3.getPaddingLeft(), 0, k3.getPaddingRight(), k3.getPaddingBottom());
        sh2.c cVar2 = this.f302727e;
        cVar2.setPanelEventListener(cVar2.l(this));
        if (G()) {
            this.f302727e.o(new b(), "10012");
        }
        T();
        U();
        this.f302726d.g().j(IQQGiftCountDownModule.CountDownStrategy.COUNT_DOWN_PANEL);
        VasPerfReportUtils.report("init", VasPerfReportUtils.WITHIN_BUSINESS, "10012", "", System.currentTimeMillis() - currentTimeMillis);
    }

    private void y() {
        if (q() == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "initAdArea error :activity is null");
            return;
        }
        QQAppInterface u16 = u();
        if (u16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "initAdArea error: app is null");
            return;
        }
        Map<String, String> isEnabledWithDataSet = ((IFeatureRuntimeService) u16.getRuntimeService(IFeatureRuntimeService.class, "all")).isEnabledWithDataSet("vas_group_gift_panel_entry", "null");
        if (isEnabledWithDataSet != null && !isEnabledWithDataSet.isEmpty()) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = ViewUtils.dip2px(this.C.getHeight());
            obtain.mRequestWidth = ViewUtils.dip2px(this.C.getHeight());
            ImageView imageView = new ImageView(this.F.getContext());
            imageView.setContentDescription(imageView.getResources().getString(R.string.f1380808l));
            ImageView imageView2 = new ImageView(this.F.getContext());
            imageView2.setContentDescription(imageView2.getResources().getString(R.string.f1380908m));
            C(imageView, isEnabledWithDataSet, obtain, "entry_activity");
            C(imageView2, isEnabledWithDataSet, obtain, "entry_ranklist");
            this.F.setVisibility(0);
            return;
        }
        QLog.i("GiftPanelControllerWithGiftRepo", 1, "initAdArea :adData:" + isEnabledWithDataSet);
    }

    private void z(final QBaseActivity qBaseActivity) {
        com.tencent.mobileqq.vas.tianshu.c cVar = this.P;
        if (cVar != null && qBaseActivity != null) {
            cVar.c(new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.troopgift.a
                @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
                public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                    GiftPanelControllerWithGiftRepo.this.J(qBaseActivity, z16, getAdsRsp);
                }
            });
        }
    }

    @Override // sh2.c.f
    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // sh2.c.InterfaceC11228c
    public boolean H0(boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), dVar, Integer.valueOf(i3), list)).booleanValue();
        }
        if (z16) {
            P();
            Q(list);
        }
        if (E()) {
            Y();
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean O(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar, i3)).booleanValue();
        }
        QBaseActivity q16 = q();
        if (q16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "onSendGiftClick error :activity is null");
            return false;
        }
        if (TextUtils.isEmpty(this.H) && this.K.isEmpty()) {
            QQToast.makeText(q16, 0, R.string.f146110ta, 4000).show();
            QLog.i("GiftPanelControllerWithGiftRepo", 2, "onSendGiftClick receiverUin nobody");
            return true;
        }
        QQAppInterface u16 = u();
        if (u16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "onSendGiftClick error, app : null");
            return false;
        }
        if (dVar == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "onSendGiftClick error : data is null");
            return false;
        }
        nh2.c cVar = this.f302726d;
        if (cVar != null && !cVar.isDestroyed()) {
            if (H(dVar)) {
                return false;
            }
            if (M()) {
                return true;
            }
            TicketManager ticketManager = (TicketManager) u16.getManager(2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(u16.getLongAccountUin());
            String str2 = "";
            sb5.append("");
            String sb6 = sb5.toString();
            String pSkey = VasSkey.getPSkey(u16, "qzone.qq.com");
            String skey = VasSkey.getSkey(ticketManager, sb6);
            String str3 = this.J;
            String o16 = o(str3);
            com.tencent.mobileqq.qqgift.data.service.c x16 = this.f302726d.a().x();
            x16.f264862c = dVar.f264874d;
            x16.f264864e = dVar.f264875d0;
            x16.f264865f = E();
            x16.f264866g = !this.K.isEmpty();
            x16.f264867h = this.K;
            x16.f264860a = u16.getLongAccountUin();
            x16.f264868i = dVar.f264878f;
            if (!x16.f264866g && !TextUtils.isEmpty(this.H)) {
                x16.f264861b = Long.parseLong(this.H);
            }
            if (this.J.isEmpty()) {
                QLog.e("GiftPanelControllerWithGiftRepo", 1, "onSendGiftClick curTroopUin is null");
            }
            x16.f264870k.put("groupID", str3);
            x16.f264870k.put("Source", n());
            ConcurrentHashMap<String, String> concurrentHashMap = x16.f264870k;
            if (skey == null) {
                skey = "";
            }
            concurrentHashMap.put("skey", skey);
            ConcurrentHashMap<String, String> concurrentHashMap2 = x16.f264870k;
            if (pSkey != null) {
                str2 = pSkey;
            }
            concurrentHashMap2.put("pskey", str2);
            x16.f264870k.put("appid", "5");
            x16.f264870k.put("auth-type", "12");
            x16.f264870k.put("anonymousInfo", o16);
            x16.f264870k.put("sign", p(o16));
            x16.f264870k.put(AdParam.PF, "android");
            this.f302726d.a().Q(x16);
            R();
            if (this.G == GiftPanelHelper$Entrance.TROOP_PROFILE_CARD) {
                v(str3);
            }
            if (E()) {
                ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(q16.getActivity()).inflate(R.layout.h5n, (ViewGroup) null);
                ImageView imageView = (ImageView) constraintLayout.findViewById(R.id.eff);
                CardView cardView = (CardView) constraintLayout.findViewById(R.id.a4j);
                if (QQTheme.isNowThemeIsNight()) {
                    str = "#3D3D3D";
                } else {
                    str = "#FFFFFF";
                }
                cardView.setCardBackgroundColor(Color.parseColor(str));
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setRequestHeight(ViewUtils.dip2px(100.0f));
                apngOptions.setRequestWidth(ViewUtils.dip2px(100.0f));
                imageView.setImageDrawable(com.tencent.mobileqq.vas.apng.api.a.a().getApngURLDrawable("GiftPanelControllerWithGiftRepo", "https://tianquan.gtimg.cn/uncategorized/vas_groupgift_loading.png", apngOptions));
                TextView textView = (TextView) constraintLayout.findViewById(R.id.efo);
                if (QQTheme.isNowThemeIsNight()) {
                    i16 = -1;
                } else {
                    i16 = -16777216;
                }
                textView.setTextColor(i16);
                textView.setText(R.string.f2324874o);
                if (this.N == null) {
                    this.N = new PopupWindow(ViewUtils.dpToPx(132.0f), ViewUtils.dpToPx(132.0f));
                }
                this.N.setContentView(constraintLayout);
                this.N.setFocusable(true);
                this.N.setOutsideTouchable(false);
                bc bcVar = this.E;
                if (bcVar != null) {
                    bcVar.a(this.N);
                }
                this.R.removeCallbacks(this.Q);
                this.R.postDelayed(this.Q, 5000);
            }
            this.L = System.currentTimeMillis();
            return false;
        }
        QLog.e("GiftPanelControllerWithGiftRepo", 1, "onSendGiftClick error : mGiftSDK:" + this.f302726d);
        return false;
    }

    protected void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        sh2.c cVar = this.f302727e;
        if (cVar != null && cVar.n() != null) {
            this.f302727e.n().b();
        }
        QBaseActivity q16 = q();
        if (q16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "selectMember error :activity is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("troop_uin", this.J);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 14);
        intent.putExtra("custom_title_name", BaseApplication.getContext().getString(R.string.f171418ev1));
        intent.putExtra("need_color_nickname", false);
        QQAppInterface u16 = u();
        if (u16 != null) {
            intent.putExtra("troop_gift_from", u16.getCurrentAccountUin());
        }
        RouteUtils.startActivityForResult(q16, intent, "/troop/memberlist/TroopMemberList", COMM.mini_app_qzone_recommend);
    }

    public void V(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            return;
        }
        if (!TextUtils.isEmpty(this.H) && drawable != null) {
            if (TextUtils.isEmpty(this.I)) {
                this.f302728f.setText(this.H);
            } else {
                this.f302728f.setText(this.I);
            }
            this.f302731m.setVisibility(0);
            this.f302731m.setImageDrawable(drawable);
            return;
        }
        QBaseActivity q16 = q();
        if (q16 != null) {
            this.f302728f.setText(q16.getText(R.string.f146100t_));
            this.f302731m.setVisibility(8);
        }
    }

    public void W(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.J = str;
        }
    }

    public void X(Intent intent, GiftPanelHelper$Entrance giftPanelHelper$Entrance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) giftPanelHelper$Entrance);
            return;
        }
        QBaseActivity q16 = q();
        if (q16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "showPanel error :activity:" + q16);
            return;
        }
        VasPerfReportUtils.saveStartTime("10012");
        this.G = giftPanelHelper$Entrance;
        x(intent);
        this.R = new Handler(Looper.getMainLooper());
        nh2.c cVar = this.f302726d;
        if (cVar != null && !cVar.isDestroyed()) {
            this.f302727e.setDtParams(s());
            List<com.tencent.mobileqq.qqgift.data.service.d> D = this.f302726d.a().D();
            if (D != null && !D.isEmpty()) {
                this.f302727e.setCacheList(D);
            }
            this.f302727e.setPanelStyle(new com.tencent.mobileqq.qqgift.mvvm.business.data.b(QQTheme.isNowThemeIsNight()));
            this.f302727e.p(q16.getWindow().getDecorView());
            this.L = 0L;
            return;
        }
        QLog.e("GiftPanelControllerWithGiftRepo", 1, "showPanel error : mGiftSDK:" + this.f302726d);
    }

    @Override // sh2.c.f
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.G == GiftPanelHelper$Entrance.TROOP_PROFILE_CARD) {
            l(true);
            return false;
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean h0(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar, i3)).booleanValue();
        }
        return false;
    }

    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        QBaseActivity q16 = q();
        if (q16 == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "dimBehind error activity is null");
            return;
        }
        if (q16.getIntent().getBooleanExtra("key_is_scale_chat", false)) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "scale aio return");
            return;
        }
        Window window = q16.getWindow();
        if (window == null) {
            QLog.e("GiftPanelControllerWithGiftRepo", 1, "dimBehind error window is null");
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z16) {
            attributes.alpha = 0.4f;
            window.addFlags(2);
        } else {
            attributes.alpha = 1.0f;
            window.clearFlags(2);
        }
        window.setAttributes(attributes);
    }

    public void m(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) intent);
            return;
        }
        if (i3 == -1 && intent != null) {
            this.H = intent.getStringExtra("member_uin");
            String stringExtra = intent.getStringExtra("member_display_name");
            this.I = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("member_nickname");
                this.I = stringExtra2;
                if (TextUtils.isEmpty(stringExtra2)) {
                    this.I = this.H;
                }
            }
            QQAppInterface u16 = u();
            if (u16 == null) {
                QLog.e("GiftPanelControllerWithGiftRepo", 1, "doOnActivityResult error app is null");
            } else {
                V(FaceDrawable.getFaceDrawable(u16, 1, this.H));
            }
        }
    }

    @Override // sh2.c.f
    public boolean n1(boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), dVar, Integer.valueOf(i3), str)).booleanValue();
        }
        if (z16) {
            QLog.d("GiftPanelControllerWithGiftRepo", 1, "onSuccess");
            if (E()) {
                P();
                Y();
            }
        } else {
            PopupWindow popupWindow = this.N;
            if (popupWindow != null && popupWindow.getContentView() != null && E()) {
                ((TextView) this.N.getContentView().findViewById(R.id.efo)).setText(R.string.f2324674m);
                QLog.e("GiftPanelControllerWithGiftRepo", 1, "sendGift onFailed :" + i3);
                QQToast.makeText(BaseApplication.getContext(), 1, MessageFormat.format(HardCodeUtil.qqStr(R.string.f2325074q), this.I), 3000).show();
            }
        }
        return false;
    }

    @Override // sh2.c.f
    public void o1(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // sh2.c.f
    public boolean r(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) dVar, i3)).booleanValue();
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        l(false);
        return false;
    }

    @Override // sh2.c.f
    public boolean u0(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        Map<String, String> map;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) dVar, i3)).booleanValue();
        }
        String str2 = "";
        if (dVar != null && (map = dVar.M) != null) {
            if (TextUtils.isEmpty(map.get("desc"))) {
                str = "";
            } else {
                str = "" + dVar.M.get("desc");
            }
            if (!TextUtils.isEmpty(dVar.M.get("charm"))) {
                try {
                    long parseLong = Long.parseLong(dVar.M.get("charm"));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    String qqStr = HardCodeUtil.qqStr(R.string.f2335877n);
                    Object[] objArr = new Object[2];
                    if (parseLong >= 0) {
                        str2 = Marker.ANY_NON_NULL_MARKER;
                    }
                    objArr[0] = str2;
                    objArr[1] = Long.valueOf(parseLong);
                    sb5.append(String.format(qqStr, objArr));
                    str = sb5.toString();
                } catch (NumberFormatException e16) {
                    QLog.e("GiftPanelControllerWithGiftRepo", 1, "onPanelItemSelected parse charm num error :data" + dVar + " e:" + e16);
                }
            }
            this.f302729h.setText(str);
            return true;
        }
        this.f302729h.setText("");
        QLog.e("GiftPanelControllerWithGiftRepo", 1, "onPanelItemSelected error :data" + dVar);
        return true;
    }

    @Override // sh2.c.f
    public boolean w(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar, i3)).booleanValue();
        }
        return false;
    }
}

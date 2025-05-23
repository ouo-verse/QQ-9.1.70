package com.tencent.mobileqq.onlinestatus.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelobby.view.OverlappingImgLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.AccountPanelFragment;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.avatar.AvatarPreviewUtil;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler;
import com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAggregationHandler;
import com.tencent.mobileqq.onlinestatus.observer.OnlineStatusCustomObserver;
import com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.onlinestatus.view.s;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profile.view.ReboundHorizontalScrollView;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$LikeItem;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$NotifyItem;
import tencent.im.onlinestatus.OnlineStatusShareInfo$ShareInfoItem;

/* compiled from: P */
/* loaded from: classes16.dex */
public class s implements AccountPanelRootLayout.a, View.OnClickListener, OnLineStatusBlurBg.b, URLColorThemeProcessor.a {
    public static final int K0 = 2131361985;
    public static final int L0 = 2131361950;
    private WeakReference<FriendBiaoTaiDialogV2> B0;
    private ReboundHorizontalScrollView C;
    private ViewGroup D;
    private TextView E;
    protected ImageView F;
    protected ImageView G;
    private View H;
    private View I;
    private boolean J;
    private long K;
    private View L;
    private ImageView M;
    private ImageView N;
    private View P;
    private OverlappingImgLayout Q;
    private TextView R;
    private TextView S;
    private View T;
    private AutoResizeAsyncImageView U;
    private View V;
    private View W;
    private ImageView X;
    private ImageView Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f256611a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f256612b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f256613c0;

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f256614d;

    /* renamed from: d0, reason: collision with root package name */
    private View f256615d0;

    /* renamed from: e, reason: collision with root package name */
    private AccountPanelRootLayout f256616e;

    /* renamed from: e0, reason: collision with root package name */
    private OnLineStatusBlurBg f256617e0;

    /* renamed from: f, reason: collision with root package name */
    private View f256618f;

    /* renamed from: f0, reason: collision with root package name */
    private URLColorThemeProcessor f256619f0;

    /* renamed from: g0, reason: collision with root package name */
    private y.b f256620g0;

    /* renamed from: h, reason: collision with root package name */
    private View f256621h;

    /* renamed from: h0, reason: collision with root package name */
    public QQProgressDialog f256622h0;

    /* renamed from: i, reason: collision with root package name */
    private OnlineStatusLyricView f256623i;

    /* renamed from: i0, reason: collision with root package name */
    private WeakReference<AccountPanelFragment> f256624i0;

    /* renamed from: j0, reason: collision with root package name */
    private QBaseActivity f256625j0;

    /* renamed from: k0, reason: collision with root package name */
    private List<OnlineStatusLikeInfo$NotifyItem> f256626k0;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f256628m;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f256631o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f256632p0;

    /* renamed from: s0, reason: collision with root package name */
    private ConstraintLayout f256635s0;

    /* renamed from: t0, reason: collision with root package name */
    private AvatarStatusView f256636t0;

    /* renamed from: z0, reason: collision with root package name */
    private CalloutPopupWindow f256642z0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f256627l0 = true;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f256629m0 = true;

    /* renamed from: n0, reason: collision with root package name */
    private k f256630n0 = null;

    /* renamed from: q0, reason: collision with root package name */
    private l f256633q0 = null;

    /* renamed from: r0, reason: collision with root package name */
    private l f256634r0 = null;

    /* renamed from: u0, reason: collision with root package name */
    private int f256637u0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    private int f256638v0 = -1;

    /* renamed from: w0, reason: collision with root package name */
    private int f256639w0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f256640x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    private String f256641y0 = null;
    private com.tencent.mobileqq.onlinestatus.model.e A0 = null;
    private final j C0 = new j();
    private h43.a D0 = null;
    private final Runnable E0 = new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.k
        @Override // java.lang.Runnable
        public final void run() {
            s.this.M1();
        }
    };
    private final View.OnClickListener F0 = new h(this);
    private final com.tencent.mobileqq.onlinestatus.observer.b G0 = new e();
    private boolean H0 = false;
    private final OnlineStatusCustomObserver I0 = new f();
    private final com.tencent.mobileqq.onlinestatus.music.a J0 = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HashMap hashMap = new HashMap();
            hashMap.put(ProfileCardDtReportUtil.STATUS_ID, Integer.valueOf(s.this.f256639w0));
            com.tencent.mobileqq.onlinestatus.utils.v.b("em_bas_state_jump_entry", hashMap);
            AccountPanelFragment p06 = s.this.p0();
            if (p06 != null) {
                p06.Mi(s.this.f256635s0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class e extends com.tencent.mobileqq.onlinestatus.observer.b {
        e() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.observer.b
        public void c(boolean z16, Map<String, Object> map) {
            int i3;
            boolean z17;
            AccountPanelFragment p06;
            boolean z18;
            boolean z19;
            if (z16 && map != null) {
                int intValue = ((Integer) map.get("unread_num")).intValue();
                s.this.f256626k0 = (List) map.get("notify_items");
                if (OnlineStatusToggleUtils.d()) {
                    if (System.currentTimeMillis() - s.this.K < 1500) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18 && com.tencent.mobileqq.utils.bl.c(s.this.f256626k0) && intValue > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19 && !s.this.J) {
                        s.this.v1();
                        if (s.this.f256629m0) {
                            intValue = 0;
                        }
                    }
                }
                s.this.R.setText(String.valueOf(intValue));
                TextView textView = s.this.R;
                int i16 = 8;
                if (intValue > 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                textView.setVisibility(i3);
                if (!s.this.f256629m0 ? !((s.this.f256626k0 == null || s.this.f256626k0.isEmpty()) && intValue <= 0) : !(s.this.f256626k0 == null || s.this.f256626k0.isEmpty() || intValue > 0)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                View view = s.this.I;
                if (z17) {
                    i16 = 0;
                }
                view.setVisibility(i16);
                if (!OnlineStatusToggleUtils.d() || !z17 || s.this.H0) {
                    s.this.H0 = false;
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_like_num", Integer.valueOf(intValue));
                    hashMap.put("online_state", s.this.f256623i.getText().toString());
                    com.tencent.mobileqq.onlinestatus.utils.v.f("em_bas_top_right_heart", hashMap);
                    s.this.H0 = true;
                }
                if (s.this.f256629m0 && (p06 = s.this.p0()) != null) {
                    p06.dj(intValue);
                    return;
                }
                return;
            }
            QLog.d("AccountPanelViewContainer", 1, "isSuccess=", Boolean.valueOf(z16), ", data=", map);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.onlinestatus.observer.b
        public void d(boolean z16, Bundle bundle) {
            super.d(z16, bundle);
            if (!OnlineStatusToggleUtils.d()) {
                return;
            }
            boolean z17 = true;
            if (z16 && bundle != null && !com.tencent.mobileqq.utils.bl.b(s.this.f256626k0)) {
                String string = bundle.getString("os_uin_key", "");
                if (TextUtils.isEmpty(string)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AccountPanelViewContainer", 2, "[updateLikeStatus] uin empty");
                        return;
                    }
                    return;
                }
                for (OnlineStatusLikeInfo$NotifyItem onlineStatusLikeInfo$NotifyItem : s.this.f256626k0) {
                    if (onlineStatusLikeInfo$NotifyItem != null && TextUtils.equals(String.valueOf(onlineStatusLikeInfo$NotifyItem.uin.get()), string)) {
                        if (onlineStatusLikeInfo$NotifyItem.self_like_items.has() && !onlineStatusLikeInfo$NotifyItem.self_like_items.get().isEmpty() && onlineStatusLikeInfo$NotifyItem.self_like_items.get().get(0).like_type.get() != 0) {
                            onlineStatusLikeInfo$NotifyItem.self_like_items.get().get(0).like_type.set(0);
                        } else {
                            List<OnlineStatusLikeInfo$LikeItem> list = onlineStatusLikeInfo$NotifyItem.self_like_items.get();
                            if (list.isEmpty()) {
                                OnlineStatusLikeInfo$LikeItem onlineStatusLikeInfo$LikeItem = new OnlineStatusLikeInfo$LikeItem();
                                onlineStatusLikeInfo$LikeItem.like_type.set(1);
                                list.add(onlineStatusLikeInfo$LikeItem);
                            } else {
                                list.get(0).like_type.set(1);
                            }
                        }
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[updateLikeStatus] ");
                sb5.append(z16);
                if (bundle != null) {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(com.tencent.mobileqq.utils.bl.b(s.this.f256626k0));
                QLog.i("AccountPanelViewContainer", 2, sb5.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<s> f256654d;

        public h(s sVar) {
            this.f256654d = new WeakReference<>(sVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            s sVar = this.f256654d.get();
            if (sVar == null) {
                QLog.e("AccountPanelViewContainer", 1, "Get container from ref null!");
            } else if ((view.getTag() instanceof i) && !((IPwdSetUtilApi) QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(sVar.f256625j0)) {
                int i3 = ((i) view.getTag()).f256661g;
                if (i3 != 1) {
                    if (i3 == 2) {
                        ISubAccountApi.f fVar = (ISubAccountApi.f) view.getTag(s.L0);
                        AccountPanelFragment p06 = sVar.p0();
                        if (p06 != null) {
                            p06.Ni(fVar);
                        }
                        sVar.C0.d(fVar);
                    }
                } else {
                    SimpleAccount simpleAccount = (SimpleAccount) view.getTag(s.L0);
                    AccountPanelFragment p07 = sVar.p0();
                    if (p07 != null) {
                        p07.Oi(simpleAccount);
                    }
                    sVar.C0.e(simpleAccount);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        View f256655a;

        /* renamed from: b, reason: collision with root package name */
        QQProAvatarView f256656b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f256657c;

        /* renamed from: d, reason: collision with root package name */
        TextView f256658d;

        /* renamed from: e, reason: collision with root package name */
        DragTextView f256659e;

        /* renamed from: f, reason: collision with root package name */
        View f256660f;

        /* renamed from: g, reason: collision with root package name */
        int f256661g;

        public i(View view) {
            this.f256655a = view;
            this.f256656b = (QQProAvatarView) view.findViewById(R.id.a38);
            this.f256657c = (ImageView) view.findViewById(R.id.j6a);
            this.f256658d = (TextView) view.findViewById(R.id.f9r);
            this.f256659e = (DragTextView) view.findViewById(R.id.kio);
            this.f256660f = view.findViewById(R.id.f164549a33);
        }

        private void g() {
            String str;
            int i3;
            if (!AppSetting.f99565y) {
                return;
            }
            TextView textView = this.f256658d;
            if (textView != null) {
                str = textView.getText().toString();
            } else {
                str = "";
            }
            DragTextView dragTextView = this.f256659e;
            boolean z16 = false;
            if (dragTextView != null && (dragTextView.getTag() instanceof Integer)) {
                i3 = ((Integer) this.f256659e.getTag()).intValue();
            } else {
                i3 = 0;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            DragTextView dragTextView2 = this.f256659e;
            if (dragTextView2 != null && (dragTextView2.getTag(R.id.kio) instanceof Boolean)) {
                z16 = ((Boolean) this.f256659e.getTag(R.id.kio)).booleanValue();
            }
            if (i3 > 0 && !z16) {
                if (i3 == 1) {
                    sb5.append(" \u4e00\u6761\u672a\u8bfb");
                } else if (i3 == 2) {
                    sb5.append(" \u4e24\u6761\u672a\u8bfb");
                } else if (i3 > 0) {
                    sb5.append(" ");
                    sb5.append(i3);
                    sb5.append("\u6761\u672a\u8bfb");
                }
            } else if (z16) {
                sb5.append(" \u6709\u6700\u65b0\u6d88\u606f");
            }
            AccessibilityUtil.c(this.f256655a, sb5.toString(), Button.class.getName());
        }

        public void a(boolean z16) {
            if (z16) {
                this.f256660f.setVisibility(0);
            } else {
                this.f256660f.setVisibility(8);
            }
        }

        public void b(String str) {
            this.f256656b.x(1, str, null);
        }

        public void c(boolean z16) {
            if (z16) {
                this.f256657c.setVisibility(0);
            } else {
                this.f256657c.setVisibility(8);
            }
        }

        public void d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f256658d.setText(charSequence);
                g();
            }
        }

        public void e(int i3) {
            this.f256661g = i3;
        }

        public void f(int i3, boolean z16) {
            int i16;
            int i17;
            if (i3 > 0) {
                if (z16) {
                    i16 = 1;
                } else {
                    i16 = 3;
                }
                int i18 = i16;
                if (this.f256661g == 2) {
                    if (z16) {
                        i17 = R.drawable.skin_tips_dot;
                    } else {
                        i17 = R.drawable.skin_tips_newmessage;
                    }
                    com.tencent.mobileqq.onlinestatus.utils.aj.a(this.f256659e, i18, i3, i17, 99, null);
                } else {
                    com.tencent.mobileqq.onlinestatus.utils.aj.a(this.f256659e, i18, i3, R.drawable.skin_tips_newmessage_dark_gray, 99, null);
                }
                this.f256659e.setVisibility(0);
                this.f256659e.setTag(Integer.valueOf(i3));
            } else {
                this.f256659e.setVisibility(8);
                this.f256659e.setTag(Integer.valueOf(i3));
            }
            this.f256659e.setTag(R.id.kio, Boolean.valueOf(z16));
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        String f256662a = "0X800C62A";

        /* renamed from: b, reason: collision with root package name */
        String f256663b = "0X800C624";

        /* renamed from: c, reason: collision with root package name */
        String f256664c = "0X800AF3C";

        /* renamed from: d, reason: collision with root package name */
        String f256665d = "0X800C62B";

        /* renamed from: e, reason: collision with root package name */
        String f256666e = "0X800C62C";

        /* renamed from: f, reason: collision with root package name */
        String f256667f = "0X800C62D";

        /* renamed from: g, reason: collision with root package name */
        private boolean f256668g = true;

        j() {
        }

        private void a(String str) {
            if (str == null) {
                str = "";
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str2 = this.f256665d;
            ReportController.o(peekAppRuntime, "dc00898", "", "", str2, str2, 0, 0, str, "", "", "");
        }

        private boolean b(String str) {
            try {
                if (Long.parseLong(str) < 0) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        void c() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentUin = peekAppRuntime.getCurrentUin();
            if (b(currentUin)) {
                String str = this.f256666e;
                ReportController.o(peekAppRuntime, "dc00898", "", "", str, str, 0, 0, currentUin, "", "", "");
            }
        }

        void d(ISubAccountApi.f fVar) {
            String str;
            if (fVar != null) {
                str = fVar.a();
            } else {
                str = "";
            }
            if (b(str)) {
                a(str);
            }
        }

        void e(SimpleAccount simpleAccount) {
            String str;
            if (simpleAccount != null) {
                str = simpleAccount.getUin();
            } else {
                str = "";
            }
            if (b(str)) {
                a(str);
            }
        }

        void f() {
            bv.a(this.f256667f);
        }

        void g() {
            bv.a(this.f256664c);
        }

        void h() {
            bv.a(this.f256663b);
        }

        void i(int i3) {
            if (this.f256668g) {
                QLog.d("AccountPanelViewContainer", 2, "reportPageShow accountSize: " + i3);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String str = this.f256662a;
                ReportController.o(peekAppRuntime, "dc00898", "", "", str, str, 0, 0, String.valueOf(i3), "", "", "");
                this.f256668g = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface k {
        void C4(int i3, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        int f256669a;

        /* renamed from: b, reason: collision with root package name */
        long f256670b;

        /* renamed from: c, reason: collision with root package name */
        long f256671c;

        /* renamed from: d, reason: collision with root package name */
        boolean f256672d = true;

        public l(int i3, long j3, long j16) {
            this.f256669a = i3;
            this.f256670b = j3;
            this.f256671c = j16;
        }
    }

    public s(QBaseActivity qBaseActivity, AccountPanelFragment accountPanelFragment) {
        this.f256624i0 = new WeakReference<>(accountPanelFragment);
        this.f256625j0 = qBaseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B0(AppInterface appInterface, SimpleAccount simpleAccount, final i iVar) {
        final String showName = ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getShowName(appInterface, simpleAccount);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.g
            @Override // java.lang.Runnable
            public final void run() {
                s.i.this.d(showName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        SpringAnimation springAnimation = new SpringAnimation(this.N, DynamicAnimation.SCALE_X, 1.0f);
        springAnimation.getSpring().setStiffness(460.0f);
        springAnimation.getSpring().setDampingRatio(0.49f);
        springAnimation.setStartValue(0.0f);
        SpringAnimation springAnimation2 = new SpringAnimation(this.N, DynamicAnimation.SCALE_Y, 1.0f);
        springAnimation2.getSpring().setStiffness(460.0f);
        springAnimation2.getSpring().setDampingRatio(0.49f);
        springAnimation2.setStartValue(0.0f);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f256625j0, R.anim.f154548b2);
        loadAnimation.setAnimationListener(new b());
        springAnimation.start();
        springAnimation2.start();
        this.N.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D0(String str, final i iVar) {
        final String buddyName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(str, false);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.h
            @Override // java.lang.Runnable
            public final void run() {
                s.i.this.d(buddyName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit E0(Boolean bool, String str) {
        if (!bool.booleanValue()) {
            QLog.e("AccountPanelViewContainer", 1, "getStatusJumpScheme fail");
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f256641y0 = str;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0() {
        Rect rect = new Rect();
        this.V.getHitRect(rect);
        rect.top -= ViewUtils.dip2px(40.0f);
        rect.bottom += ViewUtils.dip2px(10.0f);
        rect.left -= ViewUtils.dip2px(10.0f);
        rect.right += ViewUtils.dip2px(10.0f);
        ((View) this.V.getParent()).setTouchDelegate(new TouchDelegate(rect, this.V));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0() {
        this.f256623i.setMaxTextWidth(this.f256621h.getMeasuredWidth() - (ViewUtils.dpToPx(5.0f) * 2));
    }

    private void G1(int i3, int i16) {
        boolean z16;
        float f16;
        AutoResizeAsyncImageView autoResizeAsyncImageView = this.U;
        if (autoResizeAsyncImageView != null && this.T != null && this.f256616e != null) {
            int i17 = (int) (i16 * 0.35714287f);
            autoResizeAsyncImageView.setRatio(i3, i17);
            this.U.requestLayout();
            int i18 = (int) (i17 * 0.35517243f);
            ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
            layoutParams.height = i18;
            this.T.setLayoutParams(layoutParams);
            QLog.d("AccountPanelViewContainer", 1, "updateCustomImageAreaHeight(px) rootWidth: " + i3 + " rootHeight: " + i16 + " imageHeight: " + i17 + " fadingHeight: " + i18);
            View view = this.f256618f;
            if (view == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int dpToPx = ViewUtils.dpToPx(720.0f);
            if (i16 < dpToPx) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                QLog.d("AccountPanelViewContainer", 1, "updateCustomImageAreaHeight is small screen: " + z16 + " small screen def px: " + dpToPx);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (z16) {
                    f16 = 21.0f;
                } else {
                    f16 = 31.0f;
                }
                marginLayoutParams.topMargin = ViewUtils.dpToPx(f16);
                if (OnlineStatusToggleUtils.d()) {
                    marginLayoutParams.topMargin = ViewUtils.dip2px(16.0f);
                }
                this.f256618f.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit H0(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                QLog.d("AccountPanelViewContainer", 1, "showAvatarView getNormalBackgroundImage: loadBackgroundImage");
                R0(str, str, str2, true);
            } catch (Exception e16) {
                QLog.e("AccountPanelViewContainer", 1, "getNormalBackgroundImage: " + e16);
            }
            return null;
        }
        QLog.d("AccountPanelViewContainer", 1, "url: " + str + " color: " + str2);
        return null;
    }

    private void H1() {
        I1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit I0(AppRuntime appRuntime, AppRuntime.Status status, long j3, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                QLog.d("AccountPanelViewContainer", 1, "showDefaultAvatarView getNormalBackgroundImage: loadBackgroundImage");
                i1(true);
                R0(str, str, str2, true);
            } catch (Exception e16) {
                QLog.e("AccountPanelViewContainer", 1, "getNormalBackgroundImage: " + e16);
            }
            return null;
        }
        QLog.d("AccountPanelViewContainer", 1, "url: " + str + " color: " + str2);
        u1(appRuntime, status, j3);
        return null;
    }

    private void I1(boolean z16) {
        if (z16) {
            ImmersiveUtils.setStatusTextColorNew(false, this.f256625j0.getWindow());
        }
        int color = ContextCompat.getColor(this.f256625j0, R.color.cee);
        Drawable[] compoundDrawables = this.f256623i.getCompoundDrawables();
        if (compoundDrawables[2] != null) {
            Drawable drawable = ContextCompat.getDrawable(this.f256625j0, R.drawable.jhv);
            if (drawable != null) {
                int n3 = Utils.n(16.0f, this.f256625j0.getResources());
                drawable.setBounds(0, 0, n3, n3);
            }
            this.f256623i.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
        }
        this.f256623i.setTextColor(color);
        if (!OnlineStatusToggleUtils.d()) {
            this.E.setTextColor(ContextCompat.getColor(this.f256625j0, R.color.cer));
            this.f256618f.setBackgroundResource(R.drawable.jj6);
            this.E.setTextColor(color);
        }
        this.F.setImageResource(R.drawable.j1p);
        this.G.setImageResource(R.drawable.j1v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        this.f256642z0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        if ((ViewUtils.getViewWidthWithMargin(this.f256621h) - ViewUtils.getViewWidthWithMargin(this.V)) - ViewUtils.getViewWidthWithMargin(this.f256611a0) < 0) {
            this.S.setText(HardCodeUtil.qqStr(R.string.f172342q7));
        }
    }

    private void K1(boolean z16) {
        int i3;
        boolean z17;
        List<OnlineStatusLikeInfo$NotifyItem> list;
        View view = this.P;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (!z16) {
            this.X.setVisibility(8);
        }
        if (z16 && (list = this.f256626k0) != null && !list.isEmpty()) {
            z17 = true;
        } else {
            z17 = false;
        }
        View view2 = this.I;
        if (!z17) {
            i16 = 8;
        }
        view2.setVisibility(i16);
    }

    private void L1(Drawable drawable, int i3) {
        AutoResizeAsyncImageView autoResizeAsyncImageView = this.U;
        if (autoResizeAsyncImageView != null) {
            autoResizeAsyncImageView.setImageDrawable(drawable);
        }
        k1(i3);
        View view = this.W;
        if (view != null) {
            view.setBackgroundColor(ColorUtils.setAlphaComponent(i3, 255));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M0(AppInterface appInterface, SimpleAccount simpleAccount, final i iVar) {
        final String showName = ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getShowName(appInterface, simpleAccount);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.p
            @Override // java.lang.Runnable
            public final void run() {
                s.i.this.d(showName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(AppRuntime.Status status, long j3, com.tencent.mobileqq.onlinestatus.au auVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, AppRuntime appRuntime, boolean z16) {
        int i3 = com.tencent.mobileqq.onlinestatus.bs.r(status, j3).f256383a;
        int i16 = this.f256639w0;
        if (i16 == i3 && !com.tencent.mobileqq.onlinestatus.bs.a0(i16)) {
            QLog.i("AccountPanelViewContainer", 1, "[updateMyOnlineStatusContent]: return nowStatusId is " + this.f256639w0 + " extStatusId is " + i3);
            return;
        }
        this.f256639w0 = i3;
        if (z16 && ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isDeviceSupportFilament()) {
            QLog.d("AccountPanelViewContainer", 1, "extStatusId: " + i3);
            if (((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(i3)) {
                if (auVar.f255489b == 1028 && cVar != null) {
                    if (com.tencent.mobileqq.onlinestatus.utils.r.a(appRuntime, cVar.V())) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AccountPanelViewContainer", 2, "updateMyOnlineStatusContent has lyric.");
                        }
                        t1(appRuntime, status, j3, cVar);
                        return;
                    }
                }
                s1(i3, cVar, status, j3, auVar, appRuntime);
                return;
            }
            t1(appRuntime, status, j3, cVar);
            return;
        }
        t1(appRuntime, status, j3, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N1(final AppRuntime appRuntime, final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        ?? r152;
        String o16;
        String str;
        Drawable O;
        Drawable drawable;
        l lVar;
        Drawable drawable2;
        boolean z16;
        boolean z17;
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        final long M = com.tencent.mobileqq.onlinestatus.af.C().M(appRuntime);
        final com.tencent.mobileqq.onlinestatus.au I = com.tencent.mobileqq.onlinestatus.af.C().I(onlineStatus, M);
        final AppRuntime.Status i3 = com.tencent.mobileqq.onlinestatus.af.C().i(I);
        AppRuntime.Status status = AppRuntime.Status.online;
        if (onlineStatus == status) {
            com.tencent.mobileqq.onlinestatus.af C = com.tencent.mobileqq.onlinestatus.af.C();
            TextView q06 = q0();
            if (I.f255489b > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            r152 = 0;
            o16 = C.x(appRuntime, cVar, q06, 3, I, Boolean.valueOf(z17));
        } else {
            r152 = 0;
            o16 = com.tencent.mobileqq.onlinestatus.af.C().o(appRuntime, I, i3, cVar, q0(), 3);
        }
        String str2 = o16;
        if (i3 == status) {
            com.tencent.mobileqq.onlinestatus.af C2 = com.tencent.mobileqq.onlinestatus.af.C();
            if (I.f255489b > 0) {
                z16 = true;
            } else {
                z16 = r152;
            }
            if (!C2.h0(I, cVar, z16)) {
                str = str2;
                O = com.tencent.mobileqq.onlinestatus.af.C().O(0L, status, 1, cVar, 3);
                final Drawable drawable3 = O;
                if (!S0(M, I, appRuntime)) {
                    if (this.f256627l0) {
                        drawable2 = ContextCompat.getDrawable(this.f256625j0, R.drawable.jhv);
                    } else {
                        drawable2 = ContextCompat.getDrawable(this.f256625j0, R.drawable.k5g);
                    }
                    String str3 = MobileQQ.QQ_PACKAGE_NAME;
                    int n3 = Utils.n(16.0f, BaseApplication.getContext().getResources());
                    drawable = drawable2;
                    if (drawable2 != 0) {
                        drawable2.setBounds(r152, r152, n3, n3);
                        drawable = drawable2;
                    }
                } else {
                    drawable = null;
                }
                final Drawable drawable4 = drawable;
                O0(str, drawable3, drawable4);
                lVar = this.f256633q0;
                if (lVar != null && (lVar.f256669a != i3.getValue() || this.f256633q0.f256670b != M)) {
                    this.f256633q0.f256672d = r152;
                }
                com.tencent.mobileqq.onlinestatus.bs.o(new com.tencent.mobileqq.onlinestatus.u() { // from class: com.tencent.mobileqq.onlinestatus.view.a
                    @Override // com.tencent.mobileqq.onlinestatus.u
                    public final void a(boolean z18) {
                        s.this.N0(i3, M, I, cVar, appRuntime, z18);
                    }
                });
                if (!OnlineStatusToggleUtils.A() && com.tencent.mobileqq.onlinestatus.af.i0()) {
                    this.D0 = new h43.a() { // from class: com.tencent.mobileqq.onlinestatus.view.j
                        @Override // h43.a
                        public final void a(h43.f fVar) {
                            s.this.P0(cVar, I, drawable3, drawable4, fVar);
                        }
                    };
                    ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(appRuntime.getCurrentUin(), Boolean.TRUE, this.D0);
                    return;
                }
            }
        }
        str = str2;
        O = com.tencent.mobileqq.onlinestatus.af.C().O(M, onlineStatus, 1, cVar, 3);
        final Drawable drawable32 = O;
        if (!S0(M, I, appRuntime)) {
        }
        final Drawable drawable42 = drawable;
        O0(str, drawable32, drawable42);
        lVar = this.f256633q0;
        if (lVar != null) {
            this.f256633q0.f256672d = r152;
        }
        com.tencent.mobileqq.onlinestatus.bs.o(new com.tencent.mobileqq.onlinestatus.u() { // from class: com.tencent.mobileqq.onlinestatus.view.a
            @Override // com.tencent.mobileqq.onlinestatus.u
            public final void a(boolean z18) {
                s.this.N0(i3, M, I, cVar, appRuntime, z18);
            }
        });
        if (!OnlineStatusToggleUtils.A()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, com.tencent.mobileqq.onlinestatus.au auVar, final Drawable drawable, final Drawable drawable2, h43.f fVar) {
        boolean z16;
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            com.tencent.mobileqq.onlinestatus.af C = com.tencent.mobileqq.onlinestatus.af.C();
            TextView q06 = q0();
            if (auVar.f255489b > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            final String x16 = C.x(peekAppRuntime, cVar, q06, 3, auVar, Boolean.valueOf(z16));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.O0(x16, drawable, drawable2);
                }
            });
        } catch (Exception e16) {
            QLog.e("AccountPanelViewContainer", 1, "updateMyOnlineStatusContent getStepInfo " + e16);
        }
    }

    private void P1() {
        ImmersiveUtils.setStatusTextColorNew(false, this.f256625j0.getWindow());
        int color = ContextCompat.getColor(this.f256625j0, R.color.ced);
        Drawable[] compoundDrawables = this.f256623i.getCompoundDrawables();
        if (compoundDrawables[2] != null) {
            Drawable drawable = ContextCompat.getDrawable(this.f256625j0, R.drawable.k5g);
            if (drawable != null) {
                int n3 = Utils.n(16.0f, this.f256625j0.getResources());
                drawable.setBounds(0, 0, n3, n3);
            }
            this.f256623i.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
        }
        this.f256623i.setTextColor(color);
        if (!OnlineStatusToggleUtils.d()) {
            this.E.setTextColor(ContextCompat.getColor(this.f256625j0, R.color.cer));
            this.f256618f.setBackgroundResource(R.drawable.jj6);
        }
        this.F.setImageResource(R.drawable.j1p);
        this.G.setImageResource(R.drawable.j1v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(String str, String str2, String str3) {
        R0(str, str2, str3, false);
    }

    private void R0(String str, String str2, String str3, boolean z16) {
        int i3;
        int i16;
        if (this.f256619f0 == null) {
            return;
        }
        if (OnlineStatusToggleUtils.d()) {
            i3 = R.drawable.n4z;
            i16 = -1708289;
        } else {
            i3 = R.drawable.n4x;
            i16 = -2430214;
        }
        if (TextUtils.isEmpty(str3)) {
            this.f256619f0.i(str, str2, i3, i16);
            return;
        }
        try {
            this.f256619f0.m(str2, Color.parseColor(str3));
            this.f256619f0.o(z16);
            this.f256619f0.i(str, str2, i3, i16);
        } catch (Exception unused) {
            this.f256619f0.i(str, str2, i3, i16);
        }
    }

    private boolean S0(long j3, com.tencent.mobileqq.onlinestatus.au auVar, AppRuntime appRuntime) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
        if (j3 == 1030 || j3 == 1040 || y0(j3)) {
            return true;
        }
        if (OnlineStatusToggleUtils.A() && j3 == 2017) {
            return true;
        }
        if (j3 == 1080 && !TextUtils.isEmpty(auVar.f255501n)) {
            return true;
        }
        if (auVar.f255489b == 1021) {
            if (appRuntime.getCurrentUid() != null) {
                cVar = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(appRuntime.getCurrentUid(), "AccountPanelViewContainer_needShowArrow");
            } else {
                cVar = null;
            }
            if (cVar != null && !TextUtils.isEmpty(cVar.i0()) && !TextUtils.isEmpty(cVar.g0()) && !TextUtils.isEmpty(cVar.h0())) {
                return true;
            }
        }
        if (auVar.f255489b == 1028 && (H = com.tencent.mobileqq.onlinestatus.bs.H("AccountPanelViewContainer_needShowArrow")) != null && !TextUtils.isEmpty(H.V()) && u0()) {
            return true;
        }
        com.tencent.mobileqq.onlinestatus.manager.d dVar = (com.tencent.mobileqq.onlinestatus.manager.d) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.d.class);
        if (dVar != null && dVar.i(auVar)) {
            return true;
        }
        return !TextUtils.isEmpty(auVar.f255501n);
    }

    private boolean T0(long j3, com.tencent.mobileqq.onlinestatus.au auVar, AppRuntime.Status status, AppRuntime appRuntime) {
        if (auVar == null || status == null || appRuntime == null) {
            return false;
        }
        if (!S0(j3, auVar, appRuntime) && status != AppRuntime.Status.away && status != AppRuntime.Status.busy && status != AppRuntime.Status.dnd) {
            return false;
        }
        return true;
    }

    private void V0() {
        QMMKV.withAccount(MobileQQ.sMobileQQ, "common_mmkv_configurations").putLong(QMMKVFile.getKeyWithUin(IOnLineStatueHelperApi.ONLINE_STATUS_AGGREGATION_SCENE, IOnLineStatueHelperApi.ONLINE_STATUS_AGGREGATION_LAST_CLICK_TIME), NetConnInfoCenter.getServerTime(), true);
    }

    private void Z(final i iVar, final SimpleAccount simpleAccount, View view) {
        iVar.e(1);
        final AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        iVar.b(simpleAccount.getUin());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.e
            @Override // java.lang.Runnable
            public final void run() {
                s.B0(AppInterface.this, simpleAccount, iVar);
            }
        }, 32, null, false);
        iVar.f(((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getLocalThirdUnreadMsgNum(appInterface, simpleAccount.getUin()), false);
        iVar.c(false);
        iVar.a(false);
        view.setTag(K0, simpleAccount.getUin());
        view.setTag(L0, simpleAccount);
        view.setTag(iVar);
    }

    private void a0(List<Object> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            View childAt = this.f256628m.getChildAt(i3);
            i iVar = (i) childAt.getTag();
            Object obj = list.get(i3);
            if (obj instanceof ISubAccountApi.f) {
                b0(iVar, (ISubAccountApi.f) obj, childAt);
            } else if (obj instanceof SimpleAccount) {
                Z(iVar, (SimpleAccount) obj, childAt);
            }
        }
    }

    private void b0(final i iVar, ISubAccountApi.f fVar, View view) {
        iVar.e(2);
        iVar.b(fVar.a());
        final String a16 = fVar.a();
        boolean z16 = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.f
            @Override // java.lang.Runnable
            public final void run() {
                s.D0(a16, iVar);
            }
        }, 32, null, true);
        ISubAccountApi.g unreadCount = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getUnreadCount(fVar.a());
        if (unreadCount.a() > 0 && fVar.getStatus() == 1) {
            iVar.f(unreadCount.a(), unreadCount.isShowRedDot());
        } else {
            iVar.f(0, false);
        }
        iVar.c(true);
        if (fVar.getStatus() == 1) {
            z16 = false;
        }
        iVar.a(z16);
        view.setTag(K0, fVar.a());
        view.setTag(L0, fVar);
    }

    private CalloutPopupWindow d0(String str) {
        return new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.builder(this.f256625j0).setText(str).setTextSize(14.0f).setTextColor(-1).setPosition(50).setLifetime(2)).setBackgroundColor(s0()).setBackgroundRadius(4).build().build();
    }

    private void d1() {
        View view = this.f256612b0;
        if (view != null) {
            view.setOnClickListener(null);
        }
        OnlineStatusLyricView onlineStatusLyricView = this.f256623i;
        if (onlineStatusLyricView != null) {
            onlineStatusLyricView.setOnClickListener(null);
        }
        View view2 = this.I;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        View view3 = this.L;
        if (view3 != null) {
            view3.setOnClickListener(null);
        }
        AccountPanelRootLayout accountPanelRootLayout = this.f256616e;
        if (accountPanelRootLayout != null) {
            accountPanelRootLayout.setOnClickListener(null);
        }
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        View view4 = this.V;
        if (view4 != null) {
            view4.setOnClickListener(null);
        }
        View view5 = this.Z;
        if (view5 != null) {
            view5.setOnClickListener(null);
        }
        ImageView imageView2 = this.F;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
    }

    private void f1() {
        boolean z16;
        ConstraintLayout constraintLayout = this.f256635s0;
        int i3 = 0;
        if (constraintLayout != null && constraintLayout.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        CalloutPopupWindow calloutPopupWindow = this.f256642z0;
        if (calloutPopupWindow == null || !calloutPopupWindow.isShowing()) {
            i3 = 2;
        }
        com.tencent.mobileqq.onlinestatus.utils.z.v(z16, com.tencent.mobileqq.onlinestatus.af.C().M(MobileQQ.sMobileQQ.peekAppRuntime()), i3);
    }

    private void g1() {
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewContainer", 2, "resetIconView");
        }
        if (com.tencent.mobileqq.util.ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.c(this.V, HardCodeUtil.qqStr(R.string.f172422qe), Button.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(boolean z16) {
        OnlineStatusLyricView onlineStatusLyricView = this.f256623i;
        if (onlineStatusLyricView != null) {
            onlineStatusLyricView.setVisibility(0);
        }
        ConstraintLayout constraintLayout = this.f256635s0;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        r1(false, null, null, null, 0L);
        this.f256637u0 = -1;
        if (!z16 && !OnlineStatusToggleUtils.d()) {
            H1();
        } else {
            P1();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewContainer", 2, "rollbackStatusView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.STATUS_ID, Integer.valueOf(this.f256639w0));
        if (i3 != 1) {
            if (i3 == 2) {
                com.tencent.mobileqq.onlinestatus.utils.v.b("em_bas_status_preview_area", hashMap);
                return;
            }
            return;
        }
        com.tencent.mobileqq.onlinestatus.utils.v.f("em_bas_status_preview_area", hashMap);
    }

    private void j1(int i3, int i16) {
        boolean z16 = true;
        if (this.f256625j0.getAppRuntime() != null && this.f256635s0 != null) {
            n0();
            if (com.tencent.mobileqq.onlinestatus.bs.a0(i3)) {
                if (i3 == this.f256637u0 && i16 == this.f256638v0 && i16 != -1) {
                    return;
                }
            } else if (i3 == this.f256637u0) {
                QLog.d("AccountPanelViewContainer", 1, "statusId: " + i3 + " mLoadingAvatarStatusId: " + this.f256637u0);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            if (this.f256636t0 == null) {
                sb5.append("create AvatarStatusView");
                this.f256635s0.removeAllViews();
                this.f256636t0 = (AvatarStatusView) ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).createIAvatarStatusView(this.f256625j0, AvatarStatusViewScene.ONLINE_STATUS_PANEL);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -1);
                layoutParams.dimensionRatio = "h,1:1";
                layoutParams.startToStart = 0;
                layoutParams.endToEnd = 0;
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                this.f256635s0.addView(this.f256636t0, layoutParams);
                if (AppSetting.f99565y) {
                    AccessibilityUtil.n(this.f256636t0, false);
                }
            }
            this.f256635s0.setVisibility(0);
            this.f256623i.setVisibility(8);
            QLog.d("AccountPanelViewContainer", 1, "setAvatarView " + ((Object) sb5) + " mAvatarPreView.load mLoadingAvatarStatusId: " + this.f256637u0);
            AvatarStatusView avatarStatusView = this.f256636t0;
            String currentUin = this.f256625j0.getAppRuntime().getCurrentUin();
            com.tencent.mobileqq.onlinestatus.view.withAvatar.t tVar = new com.tencent.mobileqq.onlinestatus.view.withAvatar.t(this.f256625j0, false);
            if (this.f256637u0 != -1) {
                z16 = false;
            }
            avatarStatusView.b(currentUin, i3, i16, new aj.LoadOption(tVar, false, z16));
            this.f256636t0.setEventListener(new d(i3, i16));
            this.f256637u0 = i3;
            this.f256638v0 = i16;
            return;
        }
        QLog.d("AccountPanelViewContainer", 1, "mActivity.getAppRuntime(): " + this.f256625j0.getAppRuntime() + " mPreviewViewLayout: " + this.f256635s0);
    }

    private i k0(String str) {
        View view;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinearLayout linearLayout = this.f256628m;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            int childCount = this.f256628m.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                view = this.f256628m.getChildAt(i3);
                if (str.equals((String) view.getTag(K0))) {
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            return null;
        }
        return (i) view.getTag();
    }

    private void k1(int i3) {
        l1(ColorUtils.setAlphaComponent(i3, 0), ColorUtils.setAlphaComponent(i3, 255));
    }

    private void l1(int i3, int i16) {
        if (this.T == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i3, i16});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setDither(true);
        this.T.setBackground(gradientDrawable);
    }

    private String m0(com.tencent.mobileqq.onlinestatus.model.e eVar) {
        String str;
        int i3;
        String string = this.f256625j0.getResources().getString(R.string.f172342q7);
        int i16 = eVar.getCom.tencent.state.data.SquareJSConst.Params.PARAMS_NUMS java.lang.String();
        if (i16 == 0) {
            return string;
        }
        if (eVar.getDataType() == 0) {
            return this.f256625j0.getResources().getString(R.string.f172302q3, Integer.toString(i16));
        }
        if (eVar.getDataType() == 1) {
            return this.f256625j0.getResources().getString(R.string.f172282q1, Integer.toString(i16));
        }
        if (eVar.getDataType() == 3) {
            return this.f256625j0.getResources().getString(R.string.f172272q0, Integer.toString(i16));
        }
        if (eVar.getDataType() != 6 && eVar.getDataType() != 4 && eVar.getDataType() != 5) {
            if (eVar.getDataType() == 7) {
                return this.f256625j0.getResources().getString(R.string.f172432qf);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                return this.f256625j0.getResources().getString(R.string.f172312q4, Integer.toString(i16), com.tencent.mobileqq.onlinestatus.af.C().P(com.tencent.mobileqq.onlinestatus.af.C().M(peekAppRuntime), ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus()));
            }
            return string;
        }
        String str2 = eVar.getUins()[0];
        if (str2 != null) {
            str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
        } else {
            str = null;
        }
        if (str != null) {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(str, "AccountPanelViewContainer_getAggregationDisplayTitle");
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(str, "AccountPanelViewContainer_getAggregationDisplayTitle");
            if (onlineStatusSimpleInfoWithUid != null) {
                com.tencent.mobileqq.onlinestatus.au I = com.tencent.mobileqq.onlinestatus.af.C().I(com.tencent.mobileqq.onlinestatus.utils.ae.c(onlineStatusSimpleInfoWithUid), onlineStatusSimpleInfoWithUid.e0());
                if (friendsSimpleInfoWithUid != null) {
                    str2 = friendsSimpleInfoWithUid.m();
                }
                Resources resources = this.f256625j0.getResources();
                if (eVar.getDataType() == 4) {
                    i3 = R.string.f172322q5;
                } else {
                    i3 = R.string.f172332q6;
                }
                return resources.getString(i3, str2, I.f255490c);
            }
            return string;
        }
        return string;
    }

    private void m1() {
        View view = this.L;
        AccessibilityUtil.c(view, view.getResources().getString(R.string.f172382qa), Button.class.getName());
    }

    private void n0() {
        if (this.f256641y0 != null) {
            return;
        }
        try {
            AvatarPreviewUtil.f255541a.e().getStatusJumpScheme(Long.valueOf(this.f256625j0.getAppRuntime().getCurrentUin()).longValue(), 0L, new Function2() { // from class: com.tencent.mobileqq.onlinestatus.view.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit E0;
                    E0 = s.this.E0((Boolean) obj, (String) obj2);
                    return E0;
                }
            });
        } catch (Exception e16) {
            QLog.e("AccountPanelViewContainer", 1, "getStatusJumpScheme fail:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccountPanelFragment p0() {
        WeakReference<AccountPanelFragment> weakReference = this.f256624i0;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void q1(com.tencent.mobileqq.onlinestatus.model.e eVar) {
        View view;
        if (this.X != null && this.Z != null && (view = this.P) != null) {
            if (view.getVisibility() != 0) {
                this.X.setVisibility(8);
                return;
            }
            if (eVar.getDataType() != 0 && eVar.getDataType() != 8) {
                if (!com.tencent.mobileqq.onlinestatus.utils.y.b()) {
                    this.X.setVisibility(8);
                    return;
                }
                int dip2px = ViewUtils.dip2px(8.0f);
                if (this.Z.getPaddingTop() != dip2px) {
                    View view2 = this.Z;
                    view2.setPadding(view2.getPaddingLeft(), dip2px, this.Z.getPaddingRight(), this.Z.getPaddingBottom());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.P.getLayoutParams();
                if (layoutParams.topMargin == 0) {
                    layoutParams.topMargin = ViewUtils.dip2px(2.0f);
                    this.P.setLayoutParams(layoutParams);
                }
                if (eVar.getDataType() == 1 || eVar.getDataType() == 2 || (eVar.getDataType() >= 3 && eVar.getDataType() <= 7)) {
                    this.X.setVisibility(0);
                    if (OnlineStatusToggleUtils.d()) {
                        com.tencent.mobileqq.onlinestatus.utils.v.e("em_bas_friend_update");
                        return;
                    }
                    return;
                }
                return;
            }
            this.X.setVisibility(8);
        }
    }

    private void r1(boolean z16, com.tencent.mobileqq.onlinestatus.au auVar, AppRuntime appRuntime, AppRuntime.Status status, long j3) {
        View view = this.f256612b0;
        if (view == null) {
            return;
        }
        if (!z16) {
            view.setVisibility(8);
            return;
        }
        if (auVar != null && !TextUtils.isEmpty(auVar.f255501n) && !TextUtils.isEmpty(auVar.f255511x)) {
            this.f256613c0.setVisibility(0);
            this.f256615d0.setVisibility(8);
            StringBuilder sb5 = new StringBuilder();
            if (auVar.f255511x.length() > 6) {
                sb5.append(auVar.f255511x.substring(0, 6));
                sb5.append("\u2026");
            } else {
                sb5.append(auVar.f255511x);
            }
            this.f256613c0.setText(sb5.toString());
            Drawable drawable = this.f256613c0.getResources().getDrawable(R.drawable.qui_chevron_right_text_secondary, null);
            int dpToPx = ViewUtils.dpToPx(12.0f);
            drawable.setBounds(0, ViewUtils.dpToPx(1.0f), dpToPx, ViewUtils.dpToPx(1.0f) + dpToPx);
            this.f256613c0.setCompoundDrawables(null, null, drawable, null);
        } else if (T0(j3, auVar, status, appRuntime)) {
            this.f256613c0.setVisibility(8);
            this.f256615d0.setVisibility(0);
        } else {
            this.f256612b0.setVisibility(8);
            return;
        }
        this.f256612b0.setVisibility(0);
        this.f256612b0.setOnClickListener(new c());
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.STATUS_ID, Integer.valueOf(this.f256639w0));
        com.tencent.mobileqq.onlinestatus.utils.v.f("em_bas_state_jump_entry", hashMap);
    }

    private int s0() {
        return this.f256625j0.getResources().getColor(R.color.c4v);
    }

    private void s1(int i3, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, AppRuntime.Status status, long j3, com.tencent.mobileqq.onlinestatus.au auVar, AppRuntime appRuntime) {
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList;
        int t16 = com.tencent.mobileqq.onlinestatus.bs.t(cVar, i3);
        QLog.d("AccountPanelViewContainer", 1, "showAvatarView extStatusId " + i3 + "index: " + t16);
        j1(i3, t16);
        r1(true, auVar, appRuntime, status, j3);
        g1();
        if (OnlineStatusToggleUtils.d()) {
            com.tencent.mobileqq.onlinestatus.au I = com.tencent.mobileqq.onlinestatus.af.C().I(status, j3);
            if (I.f255489b == 1000 && I.f255494g == AppRuntime.Status.online && (arrayList = I.f255512y) != null && arrayList.size() > 0 && I.f255512y.size() > t16) {
                I = I.f255512y.get(t16);
            }
            if (!TextUtils.isEmpty(I.f255505r) && !TextUtils.isEmpty(I.f255506s)) {
                try {
                    QLog.d("AccountPanelViewContainer", 1, "getBiaotaiChangeSwitch showAvatarView getNormalBackgroundImage: loadBackgroundImage");
                    String str = I.f255505r;
                    R0(str, str, I.f255506s, true);
                    return;
                } catch (Exception e16) {
                    QLog.e("AccountPanelViewContainer", 1, "getBiaotaiChangeSwitch getNormalBackgroundImage: " + e16);
                    return;
                }
            }
            QLog.d("AccountPanelViewContainer", 1, "getBiaotaiChangeSwitch url: " + I.f255505r + " color: " + I.f255506s);
            return;
        }
        ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getNormalBackground(i3, new Function2() { // from class: com.tencent.mobileqq.onlinestatus.view.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit H0;
                H0 = s.this.H0((String) obj, (String) obj2);
                return H0;
            }
        }, t16);
    }

    private void t0(AppInterface appInterface, AppRuntime.Status status, long j3) {
        l lVar = this.f256634r0;
        if (lVar != null && lVar.f256669a == status.getValue() && this.f256634r0.f256670b == j3) {
            return;
        }
        this.f256634r0 = new l(status.getValue(), j3, 0L);
        ((CustomHandler) appInterface.getBusinessHandler(CustomHandler.class.getName())).F2();
    }

    private void t1(final AppRuntime appRuntime, final AppRuntime.Status status, final long j3, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList;
        this.f256637u0 = -1;
        g1();
        int i3 = com.tencent.mobileqq.onlinestatus.bs.r(status, j3).f256383a;
        if (this.f256640x0) {
            com.tencent.mobileqq.onlinestatus.utils.z.b(false, i3);
            this.f256640x0 = false;
        }
        int t16 = com.tencent.mobileqq.onlinestatus.bs.t(cVar, i3);
        QLog.d("AccountPanelViewContainer", 1, "showDefaultAvatarView: status: " + status + " extOnlineStatus: " + j3 + " index: " + t16);
        if (OnlineStatusToggleUtils.d()) {
            com.tencent.mobileqq.onlinestatus.au I = com.tencent.mobileqq.onlinestatus.af.C().I(status, j3);
            if (I.f255489b == 1000 && I.f255494g == AppRuntime.Status.online && (arrayList = I.f255512y) != null && arrayList.size() > 0 && I.f255512y.size() > t16) {
                I = I.f255512y.get(t16);
            }
            if (!TextUtils.isEmpty(I.f255505r) && !TextUtils.isEmpty(I.f255506s)) {
                try {
                    QLog.d("AccountPanelViewContainer", 1, "getBiaotaiChangeSwitch showAvatarView getNormalBackgroundImage: loadBackgroundImage");
                    i1(true);
                    String str = I.f255505r;
                    R0(str, str, I.f255506s, true);
                    return;
                } catch (Exception e16) {
                    QLog.e("AccountPanelViewContainer", 1, "getBiaotaiChangeSwitch getNormalBackgroundImage: " + e16);
                    return;
                }
            }
            QLog.d("AccountPanelViewContainer", 1, "getBiaotaiChangeSwitch url: " + I.f255505r + " color: " + I.f255506s);
            u1(appRuntime, status, j3);
            return;
        }
        ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getNormalBackground(i3, new Function2() { // from class: com.tencent.mobileqq.onlinestatus.view.q
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit I0;
                I0 = s.this.I0(appRuntime, status, j3, (String) obj, (String) obj2);
                return I0;
            }
        }, t16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u0() {
        OnlineStatusLyricView onlineStatusLyricView = this.f256623i;
        if (onlineStatusLyricView instanceof OnlineStatusLyricView) {
            return onlineStatusLyricView.p();
        }
        return true;
    }

    private void u1(AppRuntime appRuntime, AppRuntime.Status status, long j3) {
        i1(false);
        if (appRuntime instanceof AppInterface) {
            t0((AppInterface) appRuntime, status, j3);
        }
        if (OnlineStatusToggleUtils.d()) {
            L1(ContextCompat.getDrawable(this.f256625j0, R.drawable.n4z), -1708289);
        } else {
            L1(ContextCompat.getDrawable(this.f256625j0, R.drawable.n4x), -2430214);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        this.J = true;
        this.B0 = new WeakReference<>(FriendBiaoTaiDialogV2.xh(this.f256625j0, this.f256626k0));
    }

    private void w0(String[] strArr) {
        this.Q.setNeedNightMode(false);
        if (strArr.length == 0) {
            QLog.d("AccountPanelViewContainer", 1, "initAvatarView: size == 0");
            this.Q.g(20, 20, new String[0], null);
        } else {
            this.Q.f(20, 20, ViewUtils.dpToPx(8), strArr, ((IQQAvatarService) this.f256625j0.getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) this.f256625j0.getAppRuntime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z0(int i3, int i16, long j3) {
        l lVar = this.f256633q0;
        if (lVar == null || i3 != lVar.f256669a || i16 != lVar.f256670b || j3 != lVar.f256671c) {
            return true;
        }
        return lVar.f256672d;
    }

    public void A1() {
        ImageView imageView;
        View view = this.L;
        if (view != null && view.getVisibility() == 0 && (imageView = this.M) != null && imageView.getVisibility() == 0 && this.N != null) {
            if (!com.tencent.mobileqq.onlinestatus.be.k()) {
                QLog.d("AccountPanelViewContainer", 1, "showMoreMenuShareAnim, return switch close");
                return;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f256625j0, R.anim.f154550b4);
            loadAnimation.setAnimationListener(new a());
            this.M.startAnimation(loadAnimation);
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.B1();
                }
            }, 70L);
        }
    }

    public void C1() {
        if (this.f256628m.getChildCount() > 0) {
            this.E.setText(R.string.f5z);
        } else {
            this.E.setText(R.string.f171474f60);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        if (this.f256628m.getChildCount() < 7) {
            this.F.setVisibility(0);
            this.F.setOnClickListener(this);
            this.F.setOnTouchListener(new LottieHelper.e());
            layoutParams.addRule(0, this.F.getId());
        } else {
            this.F.setVisibility(8);
            layoutParams.addRule(0, this.G.getId());
        }
        this.H.setBackgroundResource(0);
    }

    public void D1(com.tencent.mobileqq.onlinestatus.model.e eVar) {
        String str;
        if (eVar == null) {
            return;
        }
        this.A0 = eVar;
        int i3 = eVar.getCom.tencent.state.data.SquareJSConst.Params.PARAMS_NUMS java.lang.String();
        int i16 = 0;
        if (i3 != 0 && eVar.getDataType() != 0 && eVar.getDataType() != 3) {
            this.Q.setVisibility(0);
            this.Y.setVisibility(8);
            w0(eVar.getUins());
        } else {
            this.Q.setVisibility(8);
            if (this.f256629m0) {
                this.Y.setVisibility(0);
            }
        }
        if (eVar.getDataType() == 3) {
            this.Y.setImageResource(R.drawable.n59);
        } else {
            this.Y.setImageResource(R.drawable.k5e);
        }
        if (this.f256629m0) {
            TextView textView = this.S;
            if (i3 == 0) {
                i16 = 8;
            }
            textView.setVisibility(i16);
        }
        String m06 = m0(eVar);
        this.S.setText(m06);
        q1(eVar);
        if (AppSetting.f99565y) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(m06);
            if (this.X.getVisibility() == 0) {
                str = HardCodeUtil.qqStr(R.string.f208165bz);
            } else {
                str = "";
            }
            sb5.append(str);
            this.S.setContentDescription(sb5.toString());
        }
        if (FontSettingManager.getFontLevel() >= 18.0f) {
            this.S.setMaxWidth(ViewUtils.dpToPx(120.0f));
        }
        this.S.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.d
            @Override // java.lang.Runnable
            public final void run() {
                s.this.K0();
            }
        });
    }

    public void E1(List<Object> list) {
        boolean z16;
        int i3;
        int size = list.size();
        this.C0.i(size);
        if (size <= 0) {
            this.f256628m.removeAllViews();
            return;
        }
        int childCount = this.f256628m.getChildCount();
        if (childCount == size) {
            a0(list);
            return;
        }
        if (childCount < size) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = childCount;
        } else {
            i3 = size;
        }
        if (!z16) {
            size = childCount;
        }
        if (z16) {
            while (i3 < size) {
                c0();
                i3++;
            }
        } else {
            this.f256628m.removeViews(i3, size - i3);
        }
        a0(list);
    }

    public void F1(String str) {
        i k06 = k0(str);
        if (k06 != null) {
            k06.b(str);
        }
    }

    public void J1(String str) {
        final i k06 = k0(str);
        final AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (k06 != null) {
            if (k06.f256661g == 2) {
                k06.d(((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(str, false));
                return;
            }
            final SimpleAccount simpleAccount = (SimpleAccount) k06.f256655a.getTag(L0);
            if (simpleAccount != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.M0(AppInterface.this, simpleAccount, k06);
                    }
                }, 32, null, false);
            }
        }
    }

    public void M1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("AccountPanelViewContainer", 1, "updateMyOnlineStatusContent null runtime");
            return;
        }
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = com.tencent.mobileqq.onlinestatus.bs.H("AccountPanelViewContainer_updateMyOnlineStatusContent");
        if (H == null) {
            return;
        }
        N1(peekAppRuntime, H);
    }

    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public void O0(String str, Drawable drawable, Drawable drawable2) {
        OnlineStatusLyricView onlineStatusLyricView = this.f256623i;
        if (onlineStatusLyricView == null) {
            return;
        }
        onlineStatusLyricView.setText(str);
        this.f256623i.setCompoundDrawablePadding(Utils.n(0.0f, this.f256625j0.getResources()));
        this.f256623i.setCompoundDrawables(drawable, null, drawable2, null);
    }

    public void Q1(String str) {
        i k06 = k0(str);
        if (k06 != null) {
            ISubAccountApi.g unreadCount = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getUnreadCount(str);
            k06.f(unreadCount.a(), unreadCount.isShowRedDot());
        }
    }

    public void R1() {
        LinearLayout linearLayout = this.f256628m;
        if (linearLayout == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f256628m.getChildAt(i3);
            String str = (String) childAt.getTag(K0);
            if (!TextUtils.isEmpty(str) && (childAt.getTag() instanceof i)) {
                i iVar = (i) childAt.getTag();
                if (iVar.f256661g == 1) {
                    iVar.f(((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getLocalThirdUnreadMsgNum((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), str), false);
                }
            }
        }
    }

    public void U0() {
        LinearLayout linearLayout = this.f256628m;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        OverlappingImgLayout overlappingImgLayout = this.Q;
        if (overlappingImgLayout != null) {
            overlappingImgLayout.removeAllViews();
        }
        this.C0.c();
    }

    public void W0(AppInterface appInterface) {
        LinearLayout linearLayout = this.f256628m;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        OverlappingImgLayout overlappingImgLayout = this.Q;
        if (overlappingImgLayout != null) {
            overlappingImgLayout.removeAllViews();
        }
        if (this.f256616e != null && OnlineStatusToggleUtils.q()) {
            try {
                this.f256616e.removeAllViews();
            } catch (Exception e16) {
                QLog.e("AccountPanelViewContainer", 1, "onDestroy mRootView.removeAllViews " + e16);
            }
        }
        if (OnlineStatusToggleUtils.e()) {
            this.f256630n0 = null;
        }
        b1(appInterface);
        e1(appInterface);
        d1();
    }

    public void X() {
        ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).registerChangeWeakListener(this.E0);
    }

    public void X0(AppInterface appInterface) {
        this.f256626k0 = null;
        if (OnlineStatusToggleUtils.d()) {
            com.tencent.mobileqq.onlinestatus.utils.v.d(this.f256616e, "pg_bas_status_panel", null);
        }
        h1();
        f0();
        e0();
        b1(appInterface);
        e1(appInterface);
        a1();
    }

    public void Y(AppInterface appInterface) {
        if (!this.f256632p0) {
            appInterface.addObserver(this.I0);
            this.f256632p0 = true;
        }
    }

    public void Y0() {
        ImmersiveUtils.setStatusTextColorNew(this.f256627l0, this.f256625j0.getWindow());
        if (AppSetting.f99565y) {
            AccessibilityUtil.m(this.V);
            this.F.setAccessibilityTraversalBefore(R.id.dv8);
            this.G.setAccessibilityTraversalAfter(R.id.xzo);
            this.G.setAccessibilityTraversalBefore(R.id.zx5);
        }
    }

    public void Z0(AppInterface appInterface) {
        if (this.L != null) {
            if (com.tencent.mobileqq.onlinestatus.be.k() && ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isDeviceSupportFilament()) {
                this.L.setVisibility(0);
            } else {
                this.L.setVisibility(8);
            }
            m1();
        }
        this.f256640x0 = true;
        this.f256616e.h();
        this.f256626k0 = null;
        boolean Z = com.tencent.mobileqq.onlinestatus.bs.Z(this.f256625j0.getAppRuntime());
        if (Z) {
            if (!this.f256631o0) {
                appInterface.addObserver(this.G0);
                this.f256631o0 = true;
            }
            ((OnlineStatusAggregationHandler) appInterface.getBusinessHandler(OnlineStatusAggregationHandler.class.getName())).d("initiative");
        }
        K1(Z);
        com.tencent.mobileqq.onlinestatus.bs.Q();
        this.K = System.currentTimeMillis();
        if (OnlineStatusToggleUtils.d()) {
            com.tencent.mobileqq.onlinestatus.utils.v.c(this.f256616e, "pg_bas_status_panel", null);
        }
    }

    public void a1() {
        l0();
        AvatarStatusView avatarStatusView = this.f256636t0;
        if (avatarStatusView == null) {
            QLog.d("AccountPanelViewContainer", 1, "releaseAvatarView mAvatarPreView == null");
            return;
        }
        avatarStatusView.release();
        this.f256636t0.setEventListener(null);
        this.f256636t0 = null;
        QLog.d("AccountPanelViewContainer", 1, "releaseAvatarView");
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout.a
    public void b() {
        AccountPanelFragment p06 = p0();
        if (p06 != null) {
            p06.l(false);
        }
    }

    public void b1(AppInterface appInterface) {
        if (appInterface != null && this.f256631o0) {
            appInterface.removeObserver(this.G0);
            this.f256631o0 = false;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor.a
    public void c(boolean z16, @NotNull String str, @Nullable Drawable drawable, int i3) {
        boolean z17;
        if ((!z16 || TextUtils.isEmpty(str)) && !OnlineStatusToggleUtils.d()) {
            z17 = true;
        } else {
            z17 = false;
        }
        L1(drawable, i3);
        if (this.f256627l0 != z17) {
            this.f256627l0 = z17;
            if (z17) {
                H1();
            } else {
                P1();
            }
        }
        k kVar = this.f256630n0;
        if (kVar != null) {
            kVar.C4(i3, this.f256627l0);
        }
        this.f256619f0.o(false);
    }

    public void c0() {
        View inflate = this.f256614d.inflate(R.layout.f167534w, (ViewGroup) null);
        inflate.setTag(new i(inflate));
        inflate.setOnClickListener(this.F0);
        inflate.setOnTouchListener(new bs.a(inflate.findViewById(R.id.t1x)));
        this.f256628m.addView(inflate, new LinearLayout.LayoutParams(Utils.n(64.0f, this.f256628m.getResources()), -2));
    }

    public void c1() {
        ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).removeChangeWeakCallBack();
    }

    public void e0() {
        FriendBiaoTaiDialogV2 friendBiaoTaiDialogV2;
        WeakReference<FriendBiaoTaiDialogV2> weakReference = this.B0;
        if (weakReference != null) {
            friendBiaoTaiDialogV2 = weakReference.get();
        } else {
            friendBiaoTaiDialogV2 = null;
        }
        if (friendBiaoTaiDialogV2 == null) {
            return;
        }
        try {
            friendBiaoTaiDialogV2.dismiss();
        } catch (Exception unused) {
            QLog.e("AccountPanelViewContainer", 1, "BiaoTaiDialog dismiss error ");
        }
        this.B0 = null;
    }

    public void e1(AppInterface appInterface) {
        if (appInterface != null && this.f256632p0) {
            appInterface.removeObserver(this.I0);
            this.f256632p0 = false;
        }
    }

    public void f0() {
        CalloutPopupWindow calloutPopupWindow = this.f256642z0;
        if (calloutPopupWindow != null && calloutPopupWindow.isShowing()) {
            this.f256642z0.dismiss();
            this.f256642z0 = null;
        }
    }

    public void g0() {
        this.f256633q0 = null;
        this.f256634r0 = null;
        a1();
    }

    public void h1() {
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.N;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    public void i0(int i3, int i16) {
        G1(i3, i16);
    }

    public void l0() {
        this.f256637u0 = -1;
        this.f256639w0 = -1;
        this.f256638v0 = -1;
    }

    public void n1(y.b bVar) {
        this.f256620g0 = bVar;
    }

    public OnLineStatusBlurBg o0() {
        return this.f256617e0;
    }

    public void o1(k kVar) {
        this.f256630n0 = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.mobileqq.onlinestatus.model.e eVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.if5 && id5 != R.id.zx5) {
            if (id5 == R.id.dv8) {
                y.b bVar = this.f256620g0;
                if (bVar != null) {
                    bVar.a();
                }
                this.C0.g();
            } else if (id5 == R.id.xzo) {
                AccountPanelFragment p06 = p0();
                if (p06 != null) {
                    p06.Ii();
                }
                this.C0.f();
            } else if (id5 != R.id.zlr && id5 != R.id.zls) {
                if (id5 != R.id.zwy && (!this.f256629m0 || ((id5 != R.id.zxh && id5 != R.id.zxj) || (eVar = this.A0) == null || eVar.getDataType() != 3))) {
                    if (id5 == R.id.f166455zx0) {
                        AccountPanelFragment p07 = p0();
                        if (p07 != null) {
                            p07.Li(this.f256625j0);
                            f1();
                            l0();
                        }
                    } else if (id5 == R.id.zxh || id5 == R.id.zxj) {
                        this.f256625j0.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.f154747r4, R.anim.f154746r3, R.anim.f154745r2, R.anim.f154748r5).replace(R.id.zxc, OnlineStatusContainerFragment.Eh(this.f256617e0), "OnlineStatusContainerFragment").addToBackStack(null).commit();
                        com.tencent.mobileqq.onlinestatus.utils.z.r();
                        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                        from.encodeInt(IOnLineStatueHelperApi.FRIENDS_UPDATE_ONLINE_STATUS_NUMS_KEY, 0);
                        from.encodeInt(IOnLineStatueHelperApi.FRIENDS_UPDATE_ONLINE_STATUS_MIN_TIME_KEY, -1);
                        V0();
                        ImageView imageView = this.X;
                        if (imageView != null && imageView.getVisibility() == 0) {
                            if (OnlineStatusToggleUtils.d()) {
                                com.tencent.mobileqq.onlinestatus.utils.v.a("em_bas_friend_update");
                            }
                            com.tencent.mobileqq.onlinestatus.utils.y.a(true);
                            this.X.setVisibility(8);
                        }
                    }
                } else {
                    Object tag = this.I.getTag();
                    if (tag == null || ((Long) tag).longValue() + 1000 < System.currentTimeMillis()) {
                        if (OnlineStatusToggleUtils.d()) {
                            v1();
                        } else {
                            FriendBiaoTaiDialog.ph(this.f256625j0, this.f256626k0);
                        }
                        com.tencent.mobileqq.onlinestatus.utils.z.n();
                        this.I.setTag(Long.valueOf(System.currentTimeMillis()));
                        this.I.setVisibility(0);
                        String charSequence = this.R.getText().toString();
                        AccountPanelFragment p08 = p0();
                        List<OnlineStatusLikeInfo$NotifyItem> list = this.f256626k0;
                        if (list != null && !list.isEmpty()) {
                            this.R.setText(String.valueOf(0));
                            this.R.setVisibility(8);
                            if (p08 != null) {
                                p08.Ki();
                            }
                        }
                        com.tencent.mobileqq.onlinestatus.model.e eVar2 = this.A0;
                        if (eVar2 != null && p08 != null && eVar2.getDataType() == 3) {
                            p08.dj(0);
                        }
                        if (OnlineStatusToggleUtils.d()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("forum_like_num", charSequence);
                            hashMap.put("online_state", this.f256623i.getText().toString());
                            com.tencent.mobileqq.onlinestatus.utils.v.b("em_bas_top_right_heart", hashMap);
                        }
                    }
                }
            } else {
                AccountPanelFragment p09 = p0();
                if (p09 != null) {
                    p09.Mi(view);
                }
            }
        } else {
            AccountPanelFragment p010 = p0();
            if (p010 != null) {
                p010.l(true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onPostThemeChanged() {
        BaseApplication context;
        if (OnlineStatusToggleUtils.d() || (context = BaseApplication.getContext()) == null || context.getResources() == null) {
            return;
        }
        SkinEngine.invalidateAll(this.f256616e);
        if (this.f256627l0) {
            L1(ContextCompat.getDrawable(this.f256625j0, R.drawable.n4x), -2430214);
            H1();
        }
    }

    public void p1(boolean z16) {
        this.f256629m0 = z16;
    }

    public TextView q0() {
        return this.f256623i;
    }

    public ViewGroup r0() {
        return this.D;
    }

    public void v0() {
        QQProgressDialog qQProgressDialog = this.f256622h0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.f256622h0.dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void w1() {
        if (this.f256622h0 == null) {
            QBaseActivity qBaseActivity = this.f256625j0;
            QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
            this.f256622h0 = qQProgressDialog;
            qQProgressDialog.setBackAndSearchFilter(true);
        }
        this.f256622h0.setMessage(R.string.cpr);
        QQProgressDialog qQProgressDialog2 = this.f256622h0;
        if (qQProgressDialog2 != null && !qQProgressDialog2.isShowing() && !this.f256625j0.isFinishing()) {
            try {
                this.f256622h0.show();
            } catch (Exception e16) {
                QLog.e("AccountPanelViewContainer", 1, "show loading failed!!!", e16);
            }
        }
    }

    public View x0(int i3) {
        this.f256627l0 = !OnlineStatusToggleUtils.d();
        this.f256614d = LayoutInflater.from(this.f256625j0);
        this.f256616e = (AccountPanelRootLayout) ty4.b.e(this.f256625j0, R.layout.account_panel_immersive, "account_panel_immersive", null);
        if (OnlineStatusToggleUtils.d()) {
            com.tencent.mobileqq.onlinestatus.utils.v.i(this.f256616e, "pg_bas_status_panel", null);
        }
        this.f256616e.setAccountPanelRootLayoutListener(this);
        this.f256618f = this.f256616e.findViewById(R.id.f163903bt);
        this.f256621h = this.f256616e.findViewById(R.id.zlr);
        View findViewById = this.f256616e.findViewById(R.id.b9j);
        com.tencent.mobileqq.qui.b.f276860a.a(this.f256618f, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        if (findViewById instanceof ScrollView) {
            findViewById.setOverScrollMode(2);
            ((ScrollView) findViewById).setClipToPadding(false);
        }
        this.U = (AutoResizeAsyncImageView) this.f256616e.findViewById(R.id.zx8);
        View findViewById2 = this.f256616e.findViewById(R.id.zx5);
        this.V = findViewById2;
        findViewById2.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.n
            @Override // java.lang.Runnable
            public final void run() {
                s.this.F0();
            }
        });
        OnlineStatusLyricView onlineStatusLyricView = (OnlineStatusLyricView) this.f256616e.findViewById(R.id.zls);
        this.f256623i = onlineStatusLyricView;
        onlineStatusLyricView.setIgnoreOffsetXWhenSimpleUI(false);
        this.f256623i.setUseDefaultTextViewWhenNoLyrics(true);
        this.f256621h.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.o
            @Override // java.lang.Runnable
            public final void run() {
                s.this.G0();
            }
        });
        this.f256623i.setOnlyLyricsAlignCenter(false);
        this.f256623i.setLyricStateListener(this.J0);
        this.f256623i.setOnClickListener(this);
        this.f256623i.setCheckLyricLegalOnMeasure(OnlineStatusToggleUtils.b());
        this.f256623i.setTypeface(Typeface.defaultFromStyle(1));
        this.f256628m = (LinearLayout) this.f256616e.findViewById(R.id.f163886b8);
        this.H = this.f256616e.findViewById(R.id.f84074l_);
        ReboundHorizontalScrollView reboundHorizontalScrollView = (ReboundHorizontalScrollView) this.f256616e.findViewById(R.id.s87);
        this.C = reboundHorizontalScrollView;
        reboundHorizontalScrollView.setOverScrollDistance(Utils.n(48.0f, this.f256625j0.getResources()));
        this.C.setHorizontalScrollBarEnabled(false);
        this.D = (ViewGroup) this.f256616e.findViewById(R.id.fda);
        this.E = (TextView) this.f256616e.findViewById(R.id.f163900bq);
        this.F = (ImageView) this.f256616e.findViewById(R.id.xzo);
        this.G = (ImageView) this.f256616e.findViewById(R.id.dv8);
        this.f256623i.setOnTouchListener(new LottieHelper.e());
        View findViewById3 = this.f256616e.findViewById(R.id.zwy);
        this.I = findViewById3;
        findViewById3.setOnClickListener(this);
        View findViewById4 = this.f256616e.findViewById(R.id.f166455zx0);
        this.L = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this);
        }
        this.M = (ImageView) this.f256616e.findViewById(R.id.f166456zx1);
        this.N = (ImageView) this.f256616e.findViewById(R.id.f166457zx2);
        this.P = this.f256616e.findViewById(R.id.zxh);
        this.Y = (ImageView) this.f256616e.findViewById(R.id.zxg);
        this.P.setOnClickListener(this);
        this.P.setOnTouchListener(new LottieHelper.e());
        this.Q = (OverlappingImgLayout) this.f256616e.findViewById(R.id.zy9);
        this.R = (TextView) this.f256616e.findViewById(R.id.zxl);
        this.S = (TextView) this.f256616e.findViewById(R.id.zxk);
        this.T = this.f256616e.findViewById(R.id.zlq);
        this.W = this.f256616e.findViewById(R.id.zxo);
        this.X = (ImageView) this.f256616e.findViewById(R.id.zxi);
        this.f256612b0 = this.f256616e.findViewById(R.id.f908453k);
        this.f256615d0 = this.f256616e.findViewById(R.id.f908353j);
        this.f256613c0 = (TextView) this.f256616e.findViewById(R.id.f908553l);
        this.f256616e.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.G.setOnTouchListener(new LottieHelper.e());
        this.C0.h();
        this.V.setOnClickListener(this);
        AccountPanelFragment p06 = p0();
        if (p06 == null) {
            return null;
        }
        p06.Ti(this.f256616e);
        if (this.f256617e0 == null) {
            this.f256617e0 = new OnLineStatusBlurBg();
        }
        if (i3 != 10 && i3 != 7) {
            this.f256618f.setVisibility(8);
        }
        if (OnlineStatusToggleUtils.d()) {
            k1(-1708289);
        } else {
            k1(-2430214);
        }
        if (this.f256619f0 == null) {
            this.f256619f0 = new URLColorThemeProcessor(this.f256616e.getContext());
        }
        this.f256619f0.n();
        this.f256619f0.p(this);
        View findViewById5 = this.f256616e.findViewById(R.id.zxj);
        this.Z = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(this);
        }
        if (OnlineStatusToggleUtils.d()) {
            L1(ContextCompat.getDrawable(this.f256625j0, R.drawable.n4z), -1708289);
            P1();
        } else {
            L1(ContextCompat.getDrawable(this.f256625j0, R.drawable.n4x), -2430214);
            I1(false);
        }
        if (OnlineStatusToggleUtils.d()) {
            this.D.setBackground(ResourcesCompat.getDrawable(this.f256625j0.getResources(), R.drawable.k5k, this.f256625j0.getTheme()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams.setMarginStart(ViewUtils.dip2px(16.0f));
            layoutParams.setMarginEnd(ViewUtils.dip2px(16.0f));
            this.D.setLayoutParams(layoutParams);
            this.f256618f.setBackgroundColor(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f256618f.getLayoutParams();
            layoutParams2.topMargin = ViewUtils.dip2px(16.0f);
            layoutParams2.leftMargin = ViewUtils.dip2px(16.0f);
            layoutParams2.rightMargin = ViewUtils.dip2px(16.0f);
            this.f256618f.setLayoutParams(layoutParams2);
            this.E.setTextColor(ie0.a.f().g(this.f256625j0.getApplicationContext(), R.color.qui_common_text_secondary, 1001));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams3.topMargin = ViewUtils.dip2px(16.0f);
            this.E.setLayoutParams(layoutParams3);
            this.f256623i.setTextSize(2, 20.0f);
            this.f256623i.setGravity(16);
        }
        this.f256635s0 = (ConstraintLayout) this.f256616e.findViewById(R.id.f908153h);
        if (FontSettingManager.getFontLevel() > 16.0f) {
            View findViewById6 = this.f256616e.findViewById(R.id.zy7);
            this.f256611a0 = findViewById6;
            if (findViewById6 != null) {
                FontSettingManager.resetViewSize2Normal(this.f256625j0, findViewById6);
            }
            FontSettingManager.resetViewSize2Normal(this.f256625j0, this.V);
        }
        g1();
        return this.f256616e;
    }

    public void x1(long j3) {
        aw.d(this.f256625j0, j3, null);
    }

    public boolean y0(long j3) {
        boolean z16;
        boolean z17;
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        com.tencent.mobileqq.onlinestatus.au I = com.tencent.mobileqq.onlinestatus.af.C().I(onlineStatus, j3);
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = com.tencent.mobileqq.onlinestatus.bs.H("AccountPanelViewContainer_isDisplayOnline");
        if (H == null) {
            return true;
        }
        com.tencent.mobileqq.onlinestatus.af C = com.tencent.mobileqq.onlinestatus.af.C();
        if (I.f255489b > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!C.h0(I, H, z16) && onlineStatus == AppRuntime.Status.online) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewContainer", 2, "isDisplayOnline ", " useFallbackOnlineText: ", Boolean.valueOf(z17));
        }
        return z17;
    }

    public void y1(String str) {
        QLog.d("AccountPanelViewContainer", 1, "showShareBubbleTips text=" + str);
        View view = this.L;
        if (view != null && view.getVisibility() == 0) {
            if (!com.tencent.mobileqq.onlinestatus.be.k()) {
                QLog.d("AccountPanelViewContainer", 1, "showShareBubbleTips, return switch close");
                return;
            }
            try {
                CalloutPopupWindow d06 = d0(str);
                if (d06 == null) {
                    QLog.d("AccountPanelViewContainer", 1, "showShareBubbleTips popupWindow = null");
                    return;
                }
                this.f256642z0 = d06;
                d06.setMarginView(8);
                d06.setMarginScreen((int) com.tencent.mobileqq.utils.al.a(this.f256625j0, 16.0f));
                d06.showAsPointer(this.L.findViewById(R.id.zyd));
                d06.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.onlinestatus.view.r
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        s.this.J0();
                    }
                });
            } catch (Exception e16) {
                QLog.e("AccountPanelViewContainer", 1, "showShareBubbleTips exception:", e16);
            }
        }
    }

    public void z1(QBaseActivity qBaseActivity) {
        int i3;
        OnLineStatusBlurBg.a aVar = new OnLineStatusBlurBg.a();
        aVar.f255313b = qBaseActivity;
        if (ThemeUtil.useNativeThemeVideoPlayer()) {
            i3 = 0;
        } else {
            i3 = R.id.b9o;
        }
        aVar.f255318g = i3;
        this.f256617e0.i(aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements aj.a {

        /* renamed from: a, reason: collision with root package name */
        final int f256646a;

        /* renamed from: b, reason: collision with root package name */
        final int f256647b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f256648c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f256649d;

        d(int i3, int i16) {
            this.f256648c = i3;
            this.f256649d = i16;
            this.f256646a = i3;
            this.f256647b = i16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unit d(Boolean bool) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelViewContainer", 2, "IAvatarPreviewService.uploadPreview : " + bool);
                return null;
            }
            return null;
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void b(@Nullable String str) {
            if (str == null) {
                QLog.i("AccountPanelViewContainer", 1, "dressKey is null");
            } else {
                if (s.this.f256625j0.getAppRuntime() == null) {
                    return;
                }
                AppRuntime appRuntime = s.this.f256625j0.getAppRuntime();
                AvatarPreviewUtil.f255541a.e().uploadPreview((BaseQQAppInterface) appRuntime, appRuntime.getCurrentUin(), this.f256648c, str, new Function1() { // from class: com.tencent.mobileqq.onlinestatus.view.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit d16;
                        d16 = s.d.d((Boolean) obj);
                        return d16;
                    }
                }, -1);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void onClick() {
            AccountPanelFragment p06 = s.this.p0();
            if (p06 != null) {
                p06.Ji(s.this.f256635s0, s.this.f256641y0);
            }
            s.this.j0(2);
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void onLoad(boolean z16) {
            if (s.this.f256635s0 != null && s.this.f256623i != null) {
                QLog.d("AccountPanelViewContainer", 1, "mAvatarPreView  onLoad: " + z16 + " finalStatusId: " + this.f256646a + " mNowStatusId: " + s.this.f256639w0 + " finalActionIndex: " + this.f256647b + " mLoadingAvatarActionIndex: " + s.this.f256638v0);
                if (this.f256646a != s.this.f256639w0) {
                    return;
                }
                if (com.tencent.mobileqq.onlinestatus.bs.a0(this.f256646a) && s.this.f256638v0 != this.f256647b) {
                    return;
                }
                if (s.this.f256640x0) {
                    com.tencent.mobileqq.onlinestatus.utils.z.b(z16, this.f256646a);
                    s.this.f256640x0 = false;
                }
                if (z16) {
                    s.this.f256623i.setVisibility(8);
                    s.this.j0(1);
                    return;
                }
                s.this.f256635s0.setVisibility(8);
                s.this.i1(true);
                AccountPanelFragment p06 = s.this.p0();
                if (p06 != null && p06.isShowing()) {
                    QQToast.makeText(s.this.f256625j0, R.string.f172542qq, 0).show();
                    return;
                }
                return;
            }
            QLog.d("AccountPanelViewContainer", 1, "mPreviewViewLayout: " + s.this.f256635s0 + " mMyStatusTextView: " + s.this.f256623i);
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class g implements com.tencent.mobileqq.onlinestatus.music.a {
        g() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.music.a
        public void b() {
            if (!s.this.u0()) {
                Drawable[] compoundDrawables = s.this.f256623i.getCompoundDrawables();
                s.this.f256623i.setCompoundDrawablePadding(Utils.n(0.0f, s.this.f256625j0.getResources()));
                s.this.f256623i.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], null, compoundDrawables[3]);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.music.a
        public void a() {
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout.a
    public void scrollToTop() {
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            s.this.M.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            s.this.M.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            s.this.N.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout.a
    public void a(boolean z16) {
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class f extends OnlineStatusCustomObserver {
        f() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.observer.OnlineStatusCustomObserver
        public void a(boolean z16, @Nullable Object obj) {
            long j3;
            com.tencent.mobileqq.onlinestatus.au N = com.tencent.mobileqq.onlinestatus.af.C().N();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                j3 = peekAppRuntime.getLongAccountUin();
            } else {
                j3 = 0;
            }
            if (!z16 || !(obj instanceof com.tencent.mobileqq.onlinestatus.observer.a)) {
                s.this.Q0("", N.f255503p, N.f255504q);
                return;
            }
            Object a16 = ((com.tencent.mobileqq.onlinestatus.observer.a) obj).a();
            if (!(a16 instanceof OnlineStatusShareInfo$ShareInfoItem)) {
                s.this.Q0("", N.f255503p, N.f255504q);
                return;
            }
            OnlineStatusShareInfo$ShareInfoItem onlineStatusShareInfo$ShareInfoItem = (OnlineStatusShareInfo$ShareInfoItem) a16;
            int i3 = onlineStatusShareInfo$ShareInfoItem.status_desc.status.get();
            int i16 = onlineStatusShareInfo$ShareInfoItem.status_desc.ex_status.get();
            long j16 = onlineStatusShareInfo$ShareInfoItem.share_time.get();
            if (i3 == N.f255494g.getValue() && onlineStatusShareInfo$ShareInfoItem.share_type.get() == 1) {
                long j17 = i16;
                if (j17 == N.f255489b && onlineStatusShareInfo$ShareInfoItem.uin.get() == j3) {
                    if (!s.this.z0(i3, i16, j16)) {
                        s.this.Q0("", N.f255503p, N.f255504q);
                        return;
                    }
                    s.this.f256633q0 = new l(i3, j17, j16);
                    s.this.Q0(onlineStatusShareInfo$ShareInfoItem.share_url.get().toStringUtf8(), N.f255503p, N.f255504q);
                    return;
                }
            }
            if (s.this.f256633q0 != null) {
                s.this.f256633q0.f256672d = false;
            }
            s.this.Q0("", N.f255503p, N.f255504q);
        }

        @Override // com.tencent.mobileqq.onlinestatus.observer.OnlineStatusCustomObserver
        public void c(boolean z16, @Nullable Object obj) {
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.b
    public void v3(boolean z16, Bitmap bitmap, int i3) {
    }
}

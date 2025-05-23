package com.tencent.mobileqq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeConstant;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.activity.qqsettingme.bo;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.bizParts.QQSettingMeChangeAccountPart;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView;
import com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dh;
import com.tencent.mobileqq.utils.fa;
import com.tencent.mobileqq.vas.flash.VipFlashNickNameView;
import com.tencent.mobileqq.vas.theme.QUIResourcesTransform;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.util.QUITokenResCompat;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@ArgusTag(tags = {"AUTO_PRELOAD"})
/* loaded from: classes9.dex */
public class QQSettingMeView extends BaseQQSettingMeView implements View.OnClickListener, View.OnTouchListener, fa {
    static IPatchRedirector $redirector_;
    private static final Pattern P0;
    private final ImageView A0;
    private final TextView B0;
    private final View C0;
    private final ImageView D0;
    private final TextView E0;
    private final LinearLayout F0;
    private boolean G;
    private final View G0;
    private int H;
    private final TextView H0;
    private final int I;
    private final TextView I0;
    private boolean J;
    private final TextView J0;
    private boolean K;
    private final URLImageView K0;
    private final View L;
    private ArrayList<View> L0;
    public final QQProAvatarView M;
    private boolean M0;
    private final View N;
    private Handler N0;
    private final com.tencent.mobileqq.vip.api.j O0;
    private final VipFlashNickNameView P;
    private final ImageView Q;
    private final ImageView R;
    private final ImageView S;
    public final View T;
    private final ImageView U;
    private final TextView V;
    private final RedTouch W;
    private final TianshuRedTouch X;
    private final View Y;
    private final View Z;

    /* renamed from: a0, reason: collision with root package name */
    private final View f154291a0;

    /* renamed from: b0, reason: collision with root package name */
    private final RedTouch f154292b0;

    /* renamed from: c0, reason: collision with root package name */
    private final TianshuRedTouch f154293c0;

    /* renamed from: d0, reason: collision with root package name */
    private final View f154294d0;

    /* renamed from: e0, reason: collision with root package name */
    private final RedTouch f154295e0;

    /* renamed from: f0, reason: collision with root package name */
    private final TianshuRedTouch f154296f0;

    /* renamed from: g0, reason: collision with root package name */
    private final ImageView f154297g0;

    /* renamed from: h0, reason: collision with root package name */
    private final ImageView f154298h0;

    /* renamed from: i0, reason: collision with root package name */
    private final RedTouch f154299i0;

    /* renamed from: j0, reason: collision with root package name */
    private final TianshuRedTouch f154300j0;

    /* renamed from: k0, reason: collision with root package name */
    private final LinearLayout f154301k0;

    /* renamed from: l0, reason: collision with root package name */
    private final RedTouch f154302l0;

    /* renamed from: m0, reason: collision with root package name */
    private final TianshuRedTouch f154303m0;

    /* renamed from: n0, reason: collision with root package name */
    private final TextView f154304n0;

    /* renamed from: o0, reason: collision with root package name */
    private final FixedBounceScrollView f154305o0;

    /* renamed from: p0, reason: collision with root package name */
    private LinearLayout f154306p0;

    /* renamed from: q0, reason: collision with root package name */
    private ViewGroup f154307q0;

    /* renamed from: r0, reason: collision with root package name */
    private TextView f154308r0;

    /* renamed from: s0, reason: collision with root package name */
    private View f154309s0;

    /* renamed from: t0, reason: collision with root package name */
    private final View f154310t0;

    /* renamed from: u0, reason: collision with root package name */
    private final TextView f154311u0;

    /* renamed from: v0, reason: collision with root package name */
    private final ImageView f154312v0;

    /* renamed from: w0, reason: collision with root package name */
    private final RedTouch f154313w0;

    /* renamed from: x0, reason: collision with root package name */
    private final TianshuRedTouch f154314x0;

    /* renamed from: y0, reason: collision with root package name */
    private final RedDotTextView f154315y0;

    /* renamed from: z0, reason: collision with root package name */
    public final View f154316z0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeView.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof com.tencent.mobileqq.activity.qqsettingme.bean.p) {
                    QQSettingMeView.this.N1((com.tencent.mobileqq.activity.qqsettingme.bean.p) obj, message.arg1);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQProAvatarView f154320d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f154321e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f154322f;

        b(QQProAvatarView qQProAvatarView, TextView textView, ImageView imageView) {
            this.f154320d = qQProAvatarView;
            this.f154321e = textView;
            this.f154322f = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQSettingMeView.this, qQProAvatarView, textView, imageView);
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
                if (action == 1 || action == 3) {
                    this.f154320d.setAlpha(1.0f);
                    this.f154321e.setAlpha(1.0f);
                    this.f154322f.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            this.f154320d.setAlpha(0.5f);
            this.f154321e.setAlpha(0.5f);
            this.f154322f.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((BaseQQSettingMeView) QQSettingMeView.this).E.N1("d_pretty_num").onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.p f154325d;

        d(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar) {
            this.f154325d = pVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeView.this, (Object) pVar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.obj = this.f154325d;
            message.arg1 = 0;
            QQSettingMeView.this.N0.sendMessage(message);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.p f154327d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f154328e;

        e(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar, int i3) {
            this.f154327d = pVar;
            this.f154328e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQSettingMeView.this, pVar, Integer.valueOf(i3));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            QQSettingMeView.this.F0.setVisibility(4);
            Message message = new Message();
            message.what = 1;
            message.obj = this.f154327d;
            message.arg1 = this.f154328e + 1;
            QQSettingMeView.this.N0.sendMessage(message);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                QQSettingMeView.this.F0.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f154330d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f154331e;

        f(String str, String str2) {
            this.f154330d = str;
            this.f154331e = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQSettingMeView.this, str, str2);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, uRLDrawable, th5);
                return;
            }
            QQSettingMeView.this.H0.setText(this.f154330d);
            QQSettingMeView.this.J0.setText(this.f154331e);
            QQSettingMeView.this.K0.setVisibility(8);
            QQSettingMeView.this.H0.setVisibility(0);
            QLog.e("QQSettingMeView", 1, "weatherIcon onLoadFailed: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<BaseQQSettingMeView> f154333d;

        /* renamed from: e, reason: collision with root package name */
        private final String f154334e;

        /* renamed from: f, reason: collision with root package name */
        private final QQSettingMeBizBean.a f154335f;

        g(String str, QQSettingMeBizBean.a aVar, BaseQQSettingMeView baseQQSettingMeView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, aVar, baseQQSettingMeView);
                return;
            }
            this.f154334e = str;
            this.f154335f = aVar;
            this.f154333d = new WeakReference<>(baseQQSettingMeView);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            QQSettingMeBizBean c16;
            TianshuRedTouch e16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                BaseQQSettingMeView baseQQSettingMeView = this.f154333d.get();
                if (baseQQSettingMeView != null && view != null && baseQQSettingMeView.f274436d) {
                    RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(this.f154334e);
                    if (g16 != null && g16.hasRedTouch()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                    int i3 = z16;
                    if (companion.j()) {
                        TianshuRedTouch e17 = com.tencent.mobileqq.qqsettingme.a.e(this.f154334e);
                        i3 = z16;
                        if (e17 != null) {
                            i3 = companion.c(e17);
                        }
                    }
                    baseQQSettingMeView.k().N1(this.f154334e).onClick(view);
                    if (companion.j() && (e16 = com.tencent.mobileqq.qqsettingme.a.e(this.f154334e)) != null) {
                        e16.x();
                    }
                    if ((QQSettingMeConstant.a(this.f154334e) || QQSettingMeConstant.b(this.f154334e)) && (c16 = com.tencent.mobileqq.qqsettingme.a.c(this.f154334e)) != null && !TextUtils.isEmpty(c16.i())) {
                        VideoReport.setElementId(view, c16.i());
                        VideoReport.setElementParam(view, "is_red_tips_em", Integer.valueOf(i3));
                        HashMap hashMap = new HashMap();
                        hashMap.put("is_red_tips_em", Integer.valueOf(i3));
                        VideoReport.reportEvent("clck", view, hashMap);
                    }
                    if (this.f154334e.equals("d_document") && (baseQQSettingMeView instanceof QQSettingMeView)) {
                        QQSettingMeView qQSettingMeView = (QQSettingMeView) baseQQSettingMeView;
                        if (qQSettingMeView.f154308r0 != null && qQSettingMeView.f154308r0.getVisibility() == 0) {
                            qQSettingMeView.f154308r0.setVisibility(8);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 46)) {
            redirector.redirect((short) 46);
        } else {
            P0 = Pattern.compile("[-+]?\\d+\\.?\\d+");
        }
    }

    public QQSettingMeView(QBaseActivity qBaseActivity, ViewGroup viewGroup) {
        super(qBaseActivity, viewGroup);
        boolean z16;
        String qqStr;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) viewGroup);
            return;
        }
        this.L0 = new ArrayList<>();
        this.M0 = false;
        this.N0 = new a();
        if (QLog.isColorLevel()) {
            QLog.e("QQSettingMeView", 2, "-->QQSettingMeView construct!");
        }
        this.J = SimpleUIUtil.getSimpleUISwitch();
        this.M0 = GlobalDisplayMetricsManager.needAdjustDensity(qBaseActivity);
        View findViewById = this.f274439h.findViewById(R.id.unq);
        this.L = findViewById;
        dh.f307632a.b(this);
        findViewById.setOnClickListener(this);
        findViewById.setOnTouchListener(this);
        if (AppSetting.f99565y) {
            findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.f172480r35));
        }
        ((ViewGroup) findViewById.findViewById(R.id.unr)).addView(((IQQSettingMeExtApi) QRoute.api(IQQSettingMeExtApi.class)).getVipView(qBaseActivity, false));
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById.findViewById(R.id.unk);
        this.M = qQProAvatarView;
        this.O0 = new av(qQProAvatarView);
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.ab
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeView.this.x1();
            }
        });
        J1();
        View findViewById2 = findViewById.findViewById(R.id.unv);
        this.N = findViewById2;
        findViewById2.setOnClickListener(this);
        int dimensionPixelSize = this.f274438f.getBaseContext().getResources().getDimensionPixelSize(R.dimen.akx);
        this.H = ((ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0f)) - dimensionPixelSize) - ScreenUtil.dip2px(45.0f);
        this.I = ((ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0f)) - dimensionPixelSize) - ScreenUtil.dip2px(20.0f);
        VipFlashNickNameView vipFlashNickNameView = (VipFlashNickNameView) findViewById.findViewById(R.id.unu);
        this.P = vipFlashNickNameView;
        vipFlashNickNameView.setMaxWidth(this.H);
        this.Q = (ImageView) findViewById.findViewById(R.id.uny);
        this.R = (ImageView) findViewById.findViewById(R.id.uo6);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.uo7);
        this.S = imageView;
        imageView.setOnClickListener(this);
        View findViewById3 = findViewById.findViewById(R.id.unz);
        this.f154291a0 = findViewById3;
        findViewById3.setOnClickListener(this);
        RedTouch rightMargin = new RedTouch(qBaseActivity, findViewById3).setGravity(8388661).setRedPointSize(12).setTopMargin(1.0f).setRightMargin(1.0f);
        this.f154292b0 = rightMargin;
        TianshuRedTouch q06 = new TianshuRedTouch(qBaseActivity, findViewById3).h0(8388661).r0(1.0f).q0(1.0f);
        this.f154293c0 = q06;
        H1(rightMargin, q06);
        TextView textView = (TextView) findViewById.findViewById(R.id.f165032uo0);
        this.V = textView;
        RedTouch rightMargin2 = new RedTouch(qBaseActivity, textView).setGravity(8388661).setRedPointSize(12).setTopMargin(0.0f).setRightMargin(1.0f);
        this.W = rightMargin2;
        TianshuRedTouch tianshuRedTouch = new TianshuRedTouch(qBaseActivity, textView);
        this.X = tianshuRedTouch;
        tianshuRedTouch.h0(8388661).r0(0.0f).q0(1.0f);
        H1(rightMargin2, tianshuRedTouch);
        textView.setText("");
        textView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById.findViewById(R.id.unn);
        this.U = imageView2;
        imageView2.setOnClickListener(this);
        View findViewById4 = findViewById.findViewById(R.id.unw);
        this.T = findViewById4;
        findViewById4.setOnClickListener(this);
        this.Y = findViewById.findViewById(R.id.uns);
        this.Z = findViewById.findViewById(R.id.unt);
        LinearLayout linearLayout = (LinearLayout) this.f274439h.findViewById(R.id.ung);
        this.f154301k0 = linearLayout;
        this.f154304n0 = (TextView) linearLayout.findViewById(R.id.unf);
        if (ImmersiveUtils.isSupporImmersive() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams.topMargin = ScreenUtil.dip2px(35.0f) - ImmersiveUtils.getStatusBarHeight(this.f274438f.getApplicationContext());
            linearLayout.setLayoutParams(marginLayoutParams);
        }
        linearLayout.setOnClickListener(this);
        linearLayout.setOnTouchListener(this);
        RedTouch gravity = new RedTouch(this.f274438f, linearLayout.findViewById(R.id.une)).setGravity(8388661);
        this.f154302l0 = gravity;
        TianshuRedTouch h06 = new TianshuRedTouch(this.f274438f, linearLayout.findViewById(R.id.une)).h0(8388661);
        this.f154303m0 = h06;
        H1(gravity, h06);
        View findViewById5 = this.f274439h.findViewById(R.id.f165035uo3);
        this.f154294d0 = findViewById5;
        RedTouch gravity2 = new RedTouch(this.f274438f, findViewById5).setLeftMargin(10).setGravity(8388627);
        this.f154295e0 = gravity2;
        gravity2.setId(R.id.uo5);
        TianshuRedTouch tianshuRedTouch2 = new TianshuRedTouch(this.f274438f, findViewById5);
        this.f154296f0 = tianshuRedTouch2;
        tianshuRedTouch2.j0(10.0f).h0(8388627);
        H1(gravity2, tianshuRedTouch2);
        findViewById5.setOnClickListener(this);
        findViewById5.setOnTouchListener(this);
        ImageView imageView3 = (ImageView) this.f274439h.findViewById(R.id.f165026um4);
        this.f154297g0 = imageView3;
        FrameLayout frameLayout = (FrameLayout) this.f274439h.findViewById(R.id.f165025um3);
        frameLayout.setOnClickListener(this);
        if (ImmersiveUtils.isSupporImmersive() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
            marginLayoutParams2.topMargin = ScreenUtil.dip2px(29.0f) - ImmersiveUtils.getStatusBarHeight(this.f274438f.getApplicationContext());
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeView", 2, "notSupportImmersive change backWrapper topMargin=" + marginLayoutParams2.topMargin);
            }
            frameLayout.setLayoutParams(marginLayoutParams2);
        }
        imageView3.setOnClickListener(this);
        imageView3.setOnTouchListener(this);
        ImageView imageView4 = (ImageView) this.f274439h.findViewById(R.id.un6);
        this.f154298h0 = imageView4;
        RedTouch rightMargin3 = new RedTouch(qBaseActivity, imageView4).setGravity(8388661).setRedPointSize(20).setTopMargin(1.0f).setRightMargin(1.0f);
        this.f154299i0 = rightMargin3;
        TianshuRedTouch q07 = new TianshuRedTouch(qBaseActivity, imageView4).h0(8388661).r0(1.0f).q0(1.0f);
        this.f154300j0 = q07;
        H1(rightMargin3, q07);
        imageView4.setOnClickListener(this);
        imageView4.setOnTouchListener(this);
        FixedBounceScrollView fixedBounceScrollView = (FixedBounceScrollView) this.f274439h.findViewById(R.id.umt);
        this.f154305o0 = fixedBounceScrollView;
        fixedBounceScrollView.setOverScrollMode(2);
        fixedBounceScrollView.setDamping(2.0f);
        fixedBounceScrollView.setBounceDelay(600L);
        fixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675f);
        Bundle currentThemeInfo = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).getCurrentThemeInfo();
        String string = currentThemeInfo.getString("themeId");
        if (!TextUtils.isEmpty(string) && !"1000".equals(string) && !"1103".equals(string)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.G = z16;
        int l16 = l1();
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeView", 2, "QQSettingMe_init, color=", Integer.valueOf(l16), ",themeId = ", string, ", enginePath=", currentThemeInfo.getString("themePath"));
        }
        LinearLayout linearLayout2 = (LinearLayout) fixedBounceScrollView.findViewById(R.id.umr);
        this.f154306p0 = linearLayout2;
        fixedBounceScrollView.setChildView(linearLayout2);
        LinearLayout linearLayout3 = this.f154306p0;
        linearLayout3.setPadding(linearLayout3.getPaddingLeft(), ScreenUtil.dip2px(14.0f), this.f154306p0.getPaddingRight(), this.f154306p0.getPaddingBottom());
        View findViewById6 = this.f274439h.findViewById(R.id.un9);
        this.f154310t0 = findViewById6;
        findViewById6.setOnClickListener(this);
        findViewById6.setOnTouchListener(this);
        AccessibilityUtil.c(findViewById6, HardCodeUtil.qqStr(R.string.r2z), Button.class.getName());
        TextView textView2 = (TextView) this.f274439h.findViewById(R.id.unb);
        this.f154311u0 = textView2;
        ImageView imageView5 = (ImageView) this.f274439h.findViewById(R.id.un_);
        this.f154312v0 = imageView5;
        DrawerUtils.k(imageView5, R.drawable.qui_setting_vas, true);
        RedDotTextView redDotTextView = (RedDotTextView) this.f274439h.findViewById(R.id.una);
        this.f154315y0 = redDotTextView;
        RedTouch redTouch = new RedTouch(this.f274438f, redDotTextView);
        this.f154313w0 = redTouch;
        TianshuRedTouch tianshuRedTouch3 = new TianshuRedTouch(this.f274438f, redDotTextView);
        this.f154314x0 = tianshuRedTouch3;
        if (TianshuRedTouch.INSTANCE.j()) {
            tianshuRedTouch3.t();
        } else {
            redTouch.applyTo();
        }
        View findViewById7 = this.f274439h.findViewById(R.id.umv);
        this.f154316z0 = findViewById7;
        findViewById7.setOnClickListener(this);
        findViewById7.setOnTouchListener(this);
        if (QQTheme.isNowThemeIsNight()) {
            qqStr = HardCodeUtil.qqStr(R.string.f213835r_);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.r2i);
        }
        AccessibilityUtil.c(findViewById7, qqStr, Button.class.getName());
        TextView textView3 = (TextView) this.f274439h.findViewById(R.id.umx);
        this.B0 = textView3;
        ImageView imageView6 = (ImageView) this.f274439h.findViewById(R.id.umw);
        this.A0 = imageView6;
        ImageView imageView7 = (ImageView) this.f274439h.findViewById(R.id.uml);
        this.D0 = imageView7;
        imageView7.setImageDrawable(cn.f(ContextCompat.getDrawable(qBaseActivity, QUITokenResCompat.getDrawableResId(R.drawable.qui_talent_vas))));
        View findViewById8 = this.f274439h.findViewById(R.id.umm);
        this.C0 = findViewById8;
        TextView textView4 = (TextView) this.f274439h.findViewById(R.id.umn);
        this.E0 = textView4;
        findViewById8.setOnClickListener(this);
        findViewById8.setOnTouchListener(this);
        LinearLayout linearLayout4 = (LinearLayout) this.f274439h.findViewById(R.id.uoa);
        this.F0 = linearLayout4;
        linearLayout4.setOnClickListener(this);
        linearLayout4.setOnTouchListener(this);
        TextView textView5 = (TextView) this.f274439h.findViewById(R.id.uob);
        this.H0 = textView5;
        this.G0 = this.f274439h.findViewById(R.id.uoc);
        TextView textView6 = (TextView) this.f274439h.findViewById(R.id.uod);
        this.I0 = textView6;
        TextView textView7 = (TextView) this.f274439h.findViewById(R.id.uo9);
        this.J0 = textView7;
        URLImageView uRLImageView = (URLImageView) this.f274439h.findViewById(R.id.uo_);
        this.K0 = uRLImageView;
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            textView5.getPaint().setFakeBoldText(true);
            textView6.getPaint().setFakeBoldText(true);
        }
        textView2.setTextColor(l16);
        textView3.setTextColor(l16);
        textView4.setTextColor(l16);
        textView6.setTextColor(l16);
        textView7.setTextColor(l16);
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.drawable.qui_day_mode_vas;
        } else {
            i3 = R.drawable.qui_night_mode_vas;
        }
        DrawerUtils.k(imageView6, i3, true);
        int k16 = k1();
        imageView7.setColorFilter(k16);
        uRLImageView.setColorFilter(k16);
        textView5.setTextColor(k16);
        E1(imageView5, R.color.qq_setting_me_nightmode_color_white, R.color.qui_common_icon_primary);
        E1(imageView6, R.color.qq_setting_me_nightmode_color_white, R.color.qui_common_icon_primary);
        if (FontSettingManager.isFontSizeLarge()) {
            FontSettingManager.resetViewSize2Normal(this.f274438f, findViewById);
        }
        e1();
        q1();
        if (!QQTheme.isNowThemeIsSuperTheme()) {
            g1();
        }
        v(((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).hasCover(MobileQQ.sMobileQQ.peekAppRuntime(), ((com.tencent.mobileqq.activity.qqsettingme.j) this.E.N1("d_head_vip")).g()));
        com.tencent.mobileqq.qui.b.f276860a.a(this.f274439h.findViewById(R.id.um5), RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.ac
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeView.this.n1();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008a, code lost:
    
        if (r6.equals(com.tencent.mobileqq.vas.theme.ThemeReporter.FROM_WEEKLOOP) == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A1(boolean z16, String str, String str2) {
        CharSequence text;
        if (!AppSetting.f99565y || this.F0 == null) {
            return;
        }
        TextView textView = this.J0;
        char c16 = 2;
        if (textView != null) {
            ViewCompat.setImportantForAccessibility(textView, 2);
        }
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append("\u5f53\u5730\u5929\u6c14 \u672a\u542f\u7528");
        } else {
            TextView textView2 = this.J0;
            CharSequence charSequence = "";
            if (textView2 == null) {
                text = "";
            } else {
                text = textView2.getText();
            }
            if (str != null) {
                if (text != null) {
                    charSequence = text;
                }
                sb5.append(charSequence);
                sb5.append("\uff0c");
                switch (str.hashCode()) {
                    case 49587:
                        if (str.equals(ThemeReporter.FROM_DIY)) {
                            c16 = 0;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 49588:
                        if (str.equals(ThemeReporter.FROM_NIGHT)) {
                            c16 = 1;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 49589:
                        break;
                    case 49590:
                        if (str.equals(ThemeReporter.FROM_AUTH)) {
                            c16 = 3;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 49591:
                        if (str.equals(ThemeReporter.FROM_ENGINE)) {
                            c16 = 4;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 49592:
                        if (str.equals(ThemeReporter.FROM_INIT_THEME)) {
                            c16 = 5;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 49593:
                        if (str.equals(ThemeReporter.FROM_SERVER_SET_THEME)) {
                            c16 = 6;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 49594:
                        if (str.equals(ThemeReporter.FROM_UPDATE)) {
                            c16 = 7;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    default:
                        c16 = '\uffff';
                        break;
                }
                switch (c16) {
                    case 0:
                        sb5.append("\u6674");
                        break;
                    case 1:
                        sb5.append("\u591a\u4e91");
                        break;
                    case 2:
                        sb5.append("\u9634");
                        break;
                    case 3:
                        sb5.append("\u96e8");
                        break;
                    case 4:
                        sb5.append("\u96ea");
                        break;
                    case 5:
                        sb5.append("\u96fe");
                        break;
                    case 6:
                        sb5.append("\u6c99\u5c18");
                        break;
                    case 7:
                        sb5.append("\u973e");
                        break;
                    default:
                        sb5.append("\u672a\u77e5");
                        break;
                }
                CharSequence text2 = this.H0.getText();
                if (!TextUtils.isEmpty(text2) && P0.matcher(text2).matches()) {
                    sb5.append("\uff0c\u6e29\u5ea6\uff1a");
                    sb5.append(text2);
                    sb5.append("\u6444\u6c0f\u5ea6");
                }
                sb5.append("\uff0c");
                sb5.append(str2);
            }
        }
        AccessibilityUtil.c(this.F0, sb5, Button.class.getName());
    }

    private int B1(com.tencent.mobileqq.activity.qqsettingme.bean.g gVar) {
        Resources resources = this.f274438f.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float dimension = resources.getDimension(R.dimen.b7w);
        float n3 = Utils.n(109.0f, resources);
        if (gVar.f184908q) {
            n3 = n3 + Utils.n(42.0f, this.f274438f.getResources()) + resources.getDimension(R.dimen.f159485d91);
        }
        if (gVar.f184907p) {
            n3 = n3 + Utils.n(47.0f, this.f274438f.getResources()) + resources.getDimension(R.dimen.f159485d91);
        }
        if (!QQTheme.isNowSimpleUI()) {
            n3 += gVar.f184903l;
        }
        float f16 = displayMetrics.widthPixels - n3;
        if (dimension <= 1.0f) {
            dimension = 1.0f;
        }
        int floor = (int) Math.floor(f16 / dimension);
        if (QLog.isColorLevel()) {
            QLog.i("QQSettingMeView", 4, "resizeQQLevelIconSize width=" + displayMetrics.widthPixels + ",iconSize=" + dimension + ",vipSize=" + gVar.f184903l + ",space=" + f16 + ",maxIconSize=" + floor);
        }
        return floor;
    }

    private void C1(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        PBStringField pBStringField;
        String str2;
        if (TianshuRedTouch.INSTANCE.j()) {
            TianshuRedTouch e16 = com.tencent.mobileqq.qqsettingme.a.e(str);
            if (e16 != null) {
                if (appInfo != null && (pBStringField = appInfo.path) != null && (str2 = pBStringField.get()) != null) {
                    e16.n0(str2);
                }
                e16.F(null);
                return;
            }
            return;
        }
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(str);
        RedTouchTextView f16 = com.tencent.mobileqq.qqsettingme.a.f(str);
        if (g16 != null && f16 != null) {
            if (appInfo == null) {
                g16.parseRedTouch((BusinessInfoCheckUpdate.AppInfo) null);
                f16.setAppInfo(null);
                return;
            }
            if (appInfo.iNewFlag.get() != 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
                BusinessInfoCheckUpdate.AppInfo appInfo2 = new BusinessInfoCheckUpdate.AppInfo();
                appInfo2.set(appInfo);
                BusinessInfoCheckUpdate.AppInfo appInfo3 = new BusinessInfoCheckUpdate.AppInfo();
                appInfo3.set(appInfo);
                ArrayList arrayList = new ArrayList(appInfo3.red_display_info.red_type_info.get());
                boolean z16 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo) arrayList.get(size);
                    int i3 = redTypeInfo.red_type.get();
                    if (i3 == 0) {
                        arrayList.remove(size);
                    } else if (i3 == 3 && RedTouchTextView.u(redTypeInfo, appInfo3)) {
                        RedTouchTextView.setImageRedNotShowRedPoint(redTypeInfo, appInfo);
                    } else {
                        if (i3 == 15 && RedTouchTextView.t(redTypeInfo, appInfo3)) {
                            RedTouchTextView.setDiffImageRedNotShowRedPoint(redTypeInfo, appInfo);
                        }
                    }
                    z16 = true;
                }
                if (arrayList.size() < 2) {
                    arrayList.clear();
                }
                appInfo3.red_display_info.red_type_info.set(arrayList);
                ArrayList arrayList2 = new ArrayList();
                if (z16) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
                    redTypeInfo2.red_type.set(0);
                    arrayList2.add(redTypeInfo2);
                }
                appInfo2.red_display_info.red_type_info.set(arrayList2);
                g16.parseRedTouch(appInfo2);
                f16.setAppInfo(appInfo3);
                return;
            }
            g16.parseRedTouch(appInfo);
            f16.setAppInfo(appInfo);
        }
    }

    private void D1() {
        int dimension;
        int dimension2 = (int) this.f274438f.getResources().getDimension(R.dimen.f158713n2);
        this.f154312v0.getLocationOnScreen(new int[2]);
        int width = this.f154310t0.getWidth();
        int width2 = this.f154312v0.getWidth();
        if (width != 0 && width2 != 0) {
            dimension = dimension2 - ((width - width2) / 2);
        } else {
            dimension = (int) this.f274438f.getResources().getDimension(R.dimen.f158716n6);
            QLog.e("QQSettingMeView", 1, "setBottomBtnMarginLeft, but getWidth return 0");
        }
        ViewGroup.LayoutParams layoutParams = this.f274439h.findViewById(R.id.um5).getLayoutParams();
        if (dimension > 0 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams).leftMargin = dimension;
            this.f274439h.findViewById(R.id.um5).setLayoutParams(layoutParams);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeView", 2, "setBottomBtnMarginLeft, diffMargin = " + dimension);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(ImageView imageView, int i3, int i16) {
        Resources resources = imageView.getResources();
        if (!QQTheme.isVasTheme()) {
            i3 = i16;
        }
        imageView.setColorFilter(resources.getColor(i3));
        if (QQTheme.isNowThemeIsSuperTheme()) {
            imageView.setColorFilter((ColorFilter) null);
        }
    }

    private void F1(ImageView imageView, QQSettingMeBizBean qQSettingMeBizBean) {
        int i3;
        Resources resources = imageView.getResources();
        if (QQTheme.isVasTheme()) {
            i3 = R.color.qq_setting_me_nightmode_color_white;
        } else {
            i3 = R.color.qui_common_icon_primary;
        }
        imageView.setColorFilter(resources.getColor(i3));
        try {
            int drawableResId = QUIResourcesTransform.getInstance().getDrawableResId(qQSettingMeBizBean.j());
            if (QQTheme.isNowThemeIsSuperTheme() && SkinEngine.getInstances().checkResExist(drawableResId)) {
                imageView.setColorFilter((ColorFilter) null);
            }
        } catch (Exception e16) {
            QLog.e("QQSettingMeView", 1, "setColorFilterForLeftIcon error:" + e16);
        }
    }

    private void G1(com.tencent.mobileqq.activity.qqsettingme.bean.i iVar) {
        if (iVar.f184914e) {
            this.Q.setColorFilter(1996488704);
        } else {
            this.Q.setColorFilter(0);
        }
        this.Q.setOnClickListener(new c());
    }

    private void H1(RedTouch redTouch, TianshuRedTouch tianshuRedTouch) {
        if (s1().booleanValue()) {
            if (tianshuRedTouch != null) {
                tianshuRedTouch.t();
            }
        } else if (redTouch != null) {
            redTouch.applyTo();
        }
    }

    private void I1(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar, int i3) {
        AlphaAnimation a16 = com.tencent.mobileqq.activity.qqsettingme.utils.c.a(0.0f, 1.0f);
        AlphaAnimation a17 = com.tencent.mobileqq.activity.qqsettingme.utils.c.a(1.0f, 0.0f);
        a17.setStartOffset(2500L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a16);
        animationSet.addAnimation(a17);
        animationSet.setAnimationListener(new e(pVar, i3));
        this.F0.startAnimation(animationSet);
    }

    private void J1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getStrokeVisible(peekAppRuntime.getCurrentAccountUin(), peekAppRuntime) == 0) {
            this.M.setEnableFrame(ScreenUtil.dip2px(2.0f), -1);
        } else {
            this.M.setEnableFrame(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1() {
        QLog.i("QQSettingMeView", 1, "updateNickNameColor: " + this.K);
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        if (this.K && !QQTheme.isVasTheme()) {
            if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.P, currentAccountUin, false)) {
                this.P.setTextColor(this.f274438f.getResources().getColorStateList(R.color.qui_common_text_allwhite_primary, null));
            }
        } else {
            if (QQTheme.isBaseDIYTheme()) {
                if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.P, currentAccountUin, false)) {
                    this.P.setTextColor(this.f274438f.getResources().getColorStateList(R.color.qq_setting_me_nightmode_color_white, null));
                    return;
                }
                return;
            }
            ColorStateList colorStateList = this.f274438f.getResources().getColorStateList(R.color.qq_setting_me_title_color, null);
            if (QQTheme.isNowSimpleUI()) {
                ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(this.P);
                this.P.setTextColor(colorStateList);
            } else if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.P, currentAccountUin, false)) {
                this.P.setTextColor(colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(boolean z16) {
        ImageView imageView = (ImageView) this.f154301k0.findViewById(R.id.und);
        if (imageView == null || (imageView.getDrawable() instanceof URLDrawable)) {
            return;
        }
        imageView.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_daka_vas));
        if ((z16 && !QQTheme.isVasTheme()) || QQTheme.isBaseDIYTheme()) {
            imageView.setColorFilter(this.f274438f.getResources().getColor(R.color.qui_common_text_allwhite_primary));
        } else if (QQTheme.isBaseDIYTheme()) {
            imageView.setColorFilter(this.f274438f.getResources().getColor(R.color.qq_setting_me_nightmode_color_white));
        } else {
            E1(imageView, R.color.qq_setting_me_title_color, R.color.qui_common_icon_primary);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void M1(Boolean bool) {
        if (ImmersiveUtils.isSupporImmersive() != 0 && this.f274436d) {
            boolean z16 = true;
            if (BaseQQSettingMeView.X()) {
                QUIImmersiveHelper.s(this.f274438f, true, BaseQQSettingMeView.W());
                return;
            }
            if (this.f274437e) {
                if (SimpleUIUtil.getSimpleUISwitch() && !QQTheme.isNowThemeIsNight() && ImmersiveUtils.isSupporImmersive() != 0) {
                    String currentThemeId = QQTheme.getCurrentThemeId();
                    if (QQTheme.isThemeSimpleDayUI(currentThemeId) && !QQTheme.isSimpleColrThemeStateBarUseWhite(currentThemeId)) {
                        z16 = false;
                    }
                    ImmersiveUtils.setStatusTextColorNew(z16, this.f274438f.getWindow());
                    return;
                }
                ImmersiveUtils.adjustThemeStatusBar(this.f274438f.getWindow());
                return;
            }
            Card g16 = ((com.tencent.mobileqq.activity.qqsettingme.j) this.E.N1("d_head_vip")).g();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (bool == null && g16 != null) {
                bool = Boolean.valueOf(((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).hasCover(peekAppRuntime, g16));
            }
            if (bool != null && QQTheme.isDefaultTheme()) {
                ImmersiveUtils.setStatusTextColorNew(!bool.booleanValue(), this.f274438f.getWindow());
                return;
            }
            if (((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(peekAppRuntime, true, null)) {
                ImmersiveUtils.setStatusTextColorNew(false, this.f274438f.getWindow());
            } else if (((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isGoldenTheme()) {
                ImmersiveUtils.setStatusTextColorNew(false, this.f274438f.getWindow());
            } else {
                ImmersiveUtils.setStatusTextColorNew(((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isDartStatusBar(this.f274438f, R.color.qq_setting_me_nightmode_color_white), this.f274438f.getWindow());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar, int i3) {
        this.K0.clearColorFilter();
        if (i3 >= pVar.f184949j.size()) {
            O1(pVar);
            this.F0.startAnimation(com.tencent.mobileqq.activity.qqsettingme.utils.c.a(0.0f, 1.0f));
        } else {
            bo boVar = pVar.f184949j.get(i3);
            i1(boVar.f184978a, pVar.f184940a, pVar.f184941b);
            this.J0.setText(boVar.f184979b);
            this.J0.setTextColor(com.tencent.mobileqq.activity.qqsettingme.utils.c.c(boVar.f184980c, l1()));
            I1(pVar, i3);
        }
    }

    private void O1(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar) {
        boolean z16;
        String str;
        int i3;
        if (pVar.f184946g == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.K0.setVisibility(8);
        this.H0.setVisibility(0);
        this.J0.setTextColor(l1());
        if (z16) {
            this.K0.setVisibility(0);
            this.H0.setVisibility(8);
            i1(pVar.f184947h, pVar.f184940a, pVar.f184941b);
            URLImageView uRLImageView = this.K0;
            Resources resources = uRLImageView.getResources();
            if (QQTheme.isVasTheme()) {
                i3 = R.color.qq_setting_me_nightmode_color_white;
            } else {
                i3 = R.color.qui_common_icon_primary;
            }
            uRLImageView.setColorFilter(resources.getColor(i3));
        }
        if (!TextUtils.isEmpty(pVar.f184948i) && !TextUtils.isEmpty(pVar.f184941b) && !TextUtils.isEmpty(pVar.f184947h)) {
            this.F0.setVisibility(0);
            this.J0.setVisibility(0);
            this.F0.setClickable(true);
            if (!z16) {
                this.H0.setText(pVar.f184947h);
            }
            this.J0.setText(pVar.f184948i);
            try {
                str = URLEncoder.encode(pVar.f184941b, "utf-8");
            } catch (Exception unused) {
                str = pVar.f184941b;
            }
            this.J0.setTag("&city=" + str + "&adcode=" + pVar.f184942c);
            r1(pVar.f184945f, pVar.f184940a, Boolean.valueOf(z16));
        }
        A1(pVar.f184945f, pVar.f184943d, com.tencent.mobileqq.activity.qqsettingme.utils.c.b(pVar.f184949j));
    }

    private void V0(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i3;
    }

    private static String W0(TextView textView, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int desiredWidth = (i3 - ((int) Layout.getDesiredWidth(MiniBoxNoticeInfo.APPNAME_SUFFIX, textView.getPaint()))) - 1;
        int codePointCount = str.codePointCount(0, str.length());
        int length = str.length();
        float desiredWidth2 = Layout.getDesiredWidth(str.subSequence(0, length), textView.getPaint());
        while (true) {
            int i16 = ((int) desiredWidth2) + 1;
            if (codePointCount <= 0 || i16 <= desiredWidth) {
                break;
            }
            codePointCount--;
            length = str.offsetByCodePoints(0, codePointCount);
            desiredWidth2 = Layout.getDesiredWidth(str.subSequence(0, length), textView.getPaint());
        }
        if (length == str.length()) {
            return str;
        }
        return str.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    private void X0() {
        boolean z16;
        float f16;
        int dimensionPixelSize;
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        boolean z17 = !QQTheme.isNowThemeIsSuperTheme();
        if (!isNowSimpleUI && !z17) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z18 = false;
        for (int i3 = 0; i3 < this.L0.size(); i3++) {
            View view = this.L0.get(i3);
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.umf);
            if (uRLImageView != null) {
                ((FrameLayout.LayoutParams) uRLImageView.getLayoutParams()).gravity = 17;
                if (z16) {
                    f16 = m1(26.0f);
                } else {
                    f16 = 32.0f;
                }
                f1(uRLImageView, f16);
                int handleDIY = QUITokenResUtil.handleDIY(R.drawable.aiq, R.drawable.qui_common_fill_light_primary_bg_selector);
                if (!z18) {
                    h1(view.getResources().getDrawable(handleDIY));
                    z18 = true;
                }
                view.setBackground(view.getResources().getDrawable(handleDIY));
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (z16) {
                    dimensionPixelSize = com.tencent.mobileqq.util.x.c(BaseApplication.getContext(), m1(45.0f));
                } else {
                    dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.akh);
                }
                layoutParams.height = dimensionPixelSize;
            }
        }
    }

    private void Y0() {
        int dimensionPixelSize = this.f274438f.getBaseContext().getResources().getDimensionPixelSize(R.dimen.akx);
        Resources resources = this.f274438f.getResources();
        int i3 = 0;
        if (this.R.getVisibility() == 0) {
            i3 = 0 + Utils.n(53.0f, resources);
        }
        if (this.Q.getVisibility() == 0) {
            i3 += Utils.n(35.0f, resources);
        }
        if (this.S.getVisibility() == 0) {
            i3 += Utils.n(17.0f, resources);
        }
        if (FontSettingManager.isFontSizeLarge()) {
            i3 = (int) FontSettingManager.revertSize2Normal(this.f274438f, i3);
        }
        int width = (((this.L.getWidth() - Utils.n(94.0f, resources)) - dimensionPixelSize) - Utils.n(45.0f, resources)) - i3;
        this.H = width;
        this.P.setMaxWidth(width);
    }

    private void Z0() {
        float f16;
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return;
        }
        X0();
        if (!QQTheme.isNowThemeIsSuperTheme()) {
            f16 = 0.0f;
        } else {
            f16 = 6.0f;
        }
        int c16 = com.tencent.mobileqq.util.x.c(context, f16);
        a1(c16);
        this.f154297g0.setPadding(c16, c16, c16, c16);
        b1(30);
        f1(this.f154297g0, m1(30.0f));
        this.H0.setTextSize(2, 20.0f);
        V0(this.f154312v0, context.getResources().getDimensionPixelSize(R.dimen.aki));
        V0(this.A0, context.getResources().getDimensionPixelSize(R.dimen.aki));
        V0((ImageView) this.f274439h.findViewById(R.id.uml), context.getResources().getDimensionPixelSize(R.dimen.aki));
        V0(this.f154301k0.findViewById(R.id.und), com.tencent.mobileqq.util.x.c(context, 28.0f));
        V0(this.K0, context.getResources().getDimensionPixelSize(R.dimen.aki));
        int c17 = com.tencent.mobileqq.util.x.c(context, 19.0f);
        LinearLayout linearLayout = this.f154301k0;
        linearLayout.setPadding(c17, linearLayout.getPaddingTop(), this.f154301k0.getPaddingRight(), this.f154301k0.getPaddingBottom());
        ((ViewGroup.MarginLayoutParams) this.f154301k0.getLayoutParams()).leftMargin = com.tencent.mobileqq.util.x.c(context, 0.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C0.getLayoutParams();
        layoutParams.gravity = 83;
        this.C0.setLayoutParams(layoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.M.getLayoutParams();
        float c18 = com.tencent.mobileqq.util.x.c(context, 91.0f);
        if (FontSettingManager.isFontSizeLarge()) {
            c18 = FontSettingManager.revertSize2Normal(this.f274438f, c18);
        }
        marginLayoutParams.topMargin = (int) c18;
        View findViewById = this.f274439h.findViewById(R.id.um5);
        int c19 = com.tencent.mobileqq.util.x.c(context, 10.0f);
        findViewById.setPadding(0, 0, 0, c19);
        com.tencent.mobileqq.qui.b.f276860a.f(findViewById, c19);
        this.f274439h.setPadding(0, 0, 0, 0);
        this.f274439h.setBackground(null);
    }

    private void a1(int i3) {
        if (FontSettingManager.isFontSizeLarge()) {
            i3 = (int) FontSettingManager.revertSize2Normal(this.f274438f, i3);
        }
        this.f154298h0.setPadding(i3, i3, i3, i3);
        ((ViewGroup.MarginLayoutParams) this.f154298h0.getLayoutParams()).bottomMargin = -i3;
    }

    private void b1(int i3) {
        int c16 = com.tencent.mobileqq.util.x.c(this.f274438f, m1(i3));
        if (FontSettingManager.isFontSizeLarge()) {
            c16 = (int) FontSettingManager.revertSize2Normal(this.f274438f, c16);
        }
        V0(this.f154298h0, c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        int width = ((this.L.getWidth() - this.f274438f.getBaseContext().getResources().getDimensionPixelSize(R.dimen.akx)) - ScreenUtil.dip2px(65.0f)) - ScreenUtil.dip2px(15.0f);
        TextView textView = this.f154304n0;
        if (textView != null) {
            textView.setMaxWidth(width);
        } else {
            QLog.e("QQSettingMeView", 1, "mSignInWord===null");
        }
    }

    private void d1(boolean z16) {
        ViewGroup viewGroup = (ViewGroup) this.L.findViewById(R.id.zm6);
        ViewGroup viewGroup2 = (ViewGroup) this.L.findViewById(R.id.zm7);
        if (z16) {
            viewGroup2 = viewGroup;
            viewGroup = viewGroup2;
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            if (viewGroup2.indexOfChild(this.R) > -1) {
                viewGroup2.removeView(this.R);
                viewGroup.addView(this.R);
            }
            if (viewGroup2.indexOfChild(this.S) > -1) {
                viewGroup2.removeView(this.S);
                viewGroup.addView(this.S);
            }
            viewGroup2.setVisibility(8);
        }
        if (z16 && !((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).canShowNamePlateInSimpleMode()) {
            viewGroup.setVisibility(8);
        } else {
            viewGroup.setVisibility(0);
        }
    }

    private void e1() {
        BaseApplication context;
        float f16;
        if (!QQTheme.isNowSimpleUI() || (context = BaseApplication.getContext()) == null) {
            return;
        }
        f1(this.f154312v0, m1(23.0f));
        f1(this.K0, m1(23.0f));
        if (!QQTheme.isNowThemeIsSuperTheme()) {
            b1(23);
            f1(this.f154297g0, m1(23.0f));
        }
        if (!QQTheme.isNowThemeIsSuperTheme()) {
            f16 = 0.0f;
        } else {
            f16 = 7.0f;
        }
        int c16 = com.tencent.mobileqq.util.x.c(context, f16);
        a1(c16);
        this.f154297g0.setPadding(c16, c16, c16, c16);
        f1(this.A0, m1(23.0f));
        f1((ImageView) this.f274439h.findViewById(R.id.uml), m1(23.0f));
        this.H0.setTextSize(2, m1(18.0f));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C0.getLayoutParams();
        layoutParams.gravity = 83;
        this.C0.setLayoutParams(layoutParams);
        ((ViewGroup.MarginLayoutParams) this.f154301k0.getLayoutParams()).leftMargin = com.tencent.mobileqq.util.x.c(context, m1(2.5f));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.M.getLayoutParams();
        float c17 = com.tencent.mobileqq.util.x.c(context, m1(80.0f));
        if (FontSettingManager.isFontSizeLarge()) {
            c17 = FontSettingManager.revertSize2Normal(this.f274438f, c17);
        }
        marginLayoutParams.topMargin = (int) c17;
        d1(true);
        View findViewById = this.f274439h.findViewById(R.id.um5);
        int c18 = com.tencent.mobileqq.util.x.c(context, m1(3.0f));
        int c19 = com.tencent.mobileqq.util.x.c(context, 10.0f);
        findViewById.setPadding(c18, 0, 0, c19);
        com.tencent.mobileqq.qui.b.f276860a.f(findViewById, c19);
        this.f274439h.setPadding(0, com.tencent.mobileqq.util.x.c(context, m1(10.0f)), 0, 0);
        if (!QUITokenResUtil.useQUIToken()) {
            this.f274439h.setBackgroundResource(R.drawable.skin_searchbar_bg_theme_version2);
        }
    }

    private void f1(View view, float f16) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Context context = view.getContext();
        layoutParams.height = com.tencent.mobileqq.util.x.c(context, f16);
        layoutParams.width = com.tencent.mobileqq.util.x.c(context, f16);
    }

    private void g1() {
        f1(this.f154312v0, m1(23.0f));
        f1(this.K0, m1(23.0f));
        if (!QQTheme.isNowThemeIsSuperTheme()) {
            b1(23);
            f1(this.f154297g0, m1(23.0f));
            a1(0);
            this.f154297g0.setPadding(0, 0, 0, 0);
            f1((ImageView) this.f154301k0.findViewById(R.id.und), m1(23.0f));
        }
        f1(this.A0, m1(23.0f));
        f1((ImageView) this.f274439h.findViewById(R.id.uml), m1(23.0f));
        this.H0.setTextSize(2, m1(18.0f));
    }

    private void h1(Drawable drawable) {
        ColorStateList color;
        try {
            if (drawable instanceof StateListDrawable) {
                Drawable[] children = ((DrawableContainer.DrawableContainerState) drawable.getConstantState()).getChildren();
                if (children != null && children.length >= 1) {
                    for (Drawable drawable2 : children) {
                        if ((drawable2 instanceof GradientDrawable) && Build.VERSION.SDK_INT >= 24) {
                            color = ((GradientDrawable) drawable2).getColor();
                            if (!(color instanceof SkinnableColorStateList)) {
                                QLog.e("QQSettingMeView", 1, "checkItemBgDrawable, item bg error! ");
                                return;
                            }
                            QLog.i("QQSettingMeView", 1, "check item bg drawable, " + ((SkinnableColorStateList) color).skinData.toString());
                        }
                    }
                    return;
                }
                QLog.i("QQSettingMeView", 1, "checkItemBgDrawable but drawableItems invalid.");
                return;
            }
            QLog.e("QQSettingMeView", 1, "checkItemBgDrawable, item bg is not a StateListDrawable.");
        } catch (Throwable th5) {
            QLog.e("QQSettingMeView", 1, "checkItemBgDrawable error, ", th5);
        }
    }

    private void i1(String str, String str2, String str3) {
        f fVar = new f(str2, str3);
        try {
            URL url = new URL(str);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = new ColorDrawable(0);
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mUseApngImage = true;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (drawable != null && drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            if (drawable != null && drawable.getStatus() == 1) {
                fVar.onLoadSuccessed(this.K0, drawable);
            } else {
                this.K0.setURLDrawableDownListener(fVar);
            }
            if (drawable != null) {
                this.K0.setImageDrawable(drawable);
            }
        } catch (MalformedURLException e16) {
            QLog.e("QQSettingMeView", 1, "QQWeather showIcon: ", e16);
        }
    }

    private void j1() {
        VideoReport.reportEvent("imp", this.f154298h0, null);
        VideoReport.reportEvent("imp", this.L, null);
        VideoReport.reportEvent("imp", this.f154310t0, null);
        VideoReport.reportEvent("imp", this.f154316z0, null);
    }

    private int k1() {
        int i3;
        if (QQTheme.isVasTheme()) {
            i3 = R.color.qq_setting_me_nightmode_color_white;
        } else {
            i3 = R.color.qui_common_icon_primary;
        }
        return ResourcesCompat.getColor(this.f274438f.getResources(), i3, null);
    }

    private int l1() {
        if (QQTheme.isVasTheme()) {
            return this.f274439h.getResources().getColor(R.color.qq_setting_me_nightmode_color_white);
        }
        return this.f274439h.getResources().getColor(R.color.qui_common_text_primary);
    }

    private float m1(float f16) {
        if (this.M0) {
            return (f16 * 2.22f) / 2.0f;
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.ad
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeView.this.w1();
            }
        });
    }

    private void o1(String str) {
        if (this.f154307q0 == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f154306p0.getLayoutParams();
            this.f154305o0.removeView(this.f154306p0);
            FrameLayout frameLayout = new FrameLayout(this.f274439h.getContext());
            this.f154305o0.addView(frameLayout, new ViewGroup.MarginLayoutParams(-1, -2));
            frameLayout.addView(this.f154306p0, marginLayoutParams);
            FrameLayout frameLayout2 = new FrameLayout(this.f274439h.getContext());
            frameLayout.addView(frameLayout2, new ViewGroup.MarginLayoutParams(marginLayoutParams));
            this.f154307q0 = frameLayout2;
            VideoReport.traversePage(this.f154305o0);
        }
        if (this.f154308r0 == null) {
            TextView textView = new TextView(this.f274439h.getContext());
            textView.setText(str);
            textView.setTextColor(-1);
            textView.setTextSize(1, 12.0f);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.ekd);
            this.f154307q0.addView(textView, new FrameLayout.LayoutParams(-2, -2));
            this.f154308r0 = textView;
            textView.setVisibility(8);
        }
    }

    private void p1() {
        CharSequence charSequence;
        if (!this.f274436d) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QQSettingMeView", 4, "init: false");
            }
            this.E.W1(this);
            this.E.d2();
            if (TianshuRedTouch.INSTANCE.j()) {
                for (QQSettingMeBizBean qQSettingMeBizBean : com.tencent.mobileqq.qqsettingme.a.C.values()) {
                    RedTouchTextView redTouchTextView = (RedTouchTextView) qQSettingMeBizBean.m().findViewById(R.id.umj);
                    String n3 = qQSettingMeBizBean.n();
                    if (qQSettingMeBizBean.r() != null) {
                        charSequence = qQSettingMeBizBean.r().f184991a;
                    } else {
                        charSequence = "";
                    }
                    redTouchTextView.setText(com.tencent.mobileqq.activity.qqsettingme.utils.b.d(n3, charSequence));
                    redTouchTextView.c();
                }
            }
            D1();
            VideoReport.addToDetectionWhitelist(this.f274438f);
            this.f274436d = true;
        }
    }

    private void q1() {
        CharSequence charSequence;
        int i3;
        this.f154306p0.removeAllViews();
        View inflate = LayoutInflater.from(this.f274438f).inflate(R.layout.qq_setting_me_item_profilebubblemsg, (ViewGroup) this.f154306p0, false);
        this.f154309s0 = inflate;
        inflate.setVisibility(8);
        this.f154306p0.addView(this.f154309s0);
        this.E.f2();
        int l16 = l1();
        int dip2px = ScreenUtil.dip2px(2.0f);
        com.tencent.mobileqq.qqsettingme.a.C.clear();
        com.tencent.mobileqq.activity.qqsettingme.config.a aVar = new com.tencent.mobileqq.activity.qqsettingme.config.a();
        this.L0.clear();
        boolean z16 = false;
        for (QQSettingMeBizBean qQSettingMeBizBean : aVar.a()) {
            com.tencent.mobileqq.activity.qqsettingme.ac acVar = new com.tencent.mobileqq.activity.qqsettingme.ac();
            View inflate2 = LayoutInflater.from(this.f274438f).inflate(R.layout.qq_setting_me_item, (ViewGroup) this.f154306p0, false);
            this.f154306p0.addView(inflate2);
            this.L0.add(inflate2);
            inflate2.setFocusable(true);
            Drawable drawable = ResourcesCompat.getDrawable(this.f274438f.getResources(), QUITokenResUtil.handleDIY(R.drawable.aiq, R.drawable.qui_common_fill_light_primary_bg_selector), null);
            if (!z16) {
                h1(drawable);
                z16 = true;
            }
            inflate2.setBackground(drawable);
            inflate2.setOnClickListener(new g(qQSettingMeBizBean.n(), qQSettingMeBizBean.h(), this));
            URLImageView uRLImageView = (URLImageView) inflate2.findViewById(R.id.umf);
            DrawerUtils.m(uRLImageView, qQSettingMeBizBean);
            F1(uRLImageView, qQSettingMeBizBean);
            RedTouchTextView redTouchTextView = (RedTouchTextView) inflate2.findViewById(R.id.umj);
            String n3 = qQSettingMeBizBean.n();
            if (qQSettingMeBizBean.r() != null) {
                charSequence = qQSettingMeBizBean.r().f184991a;
            } else {
                charSequence = "";
            }
            redTouchTextView.setText(com.tencent.mobileqq.activity.qqsettingme.utils.b.d(n3, charSequence));
            redTouchTextView.setUseRedTouchTextColorFromConfig(false);
            redTouchTextView.setTextColor(l16);
            TextView textView = (TextView) inflate2.findViewById(R.id.umh);
            ((IThemeLabelTextViewApi) QRoute.api(IThemeLabelTextViewApi.class)).setSupportMaskView(textView, true);
            textView.setVisibility(0);
            AccessibilityUtil.c(inflate2, qQSettingMeBizBean.r().f184991a, Button.class.getName());
            uRLImageView.setPadding(dip2px, dip2px, dip2px, dip2px);
            ((LinearLayout.LayoutParams) uRLImageView.getLayoutParams()).leftMargin -= dip2px;
            ((LinearLayout.LayoutParams) redTouchTextView.getLayoutParams()).leftMargin -= dip2px;
            if (com.tencent.mobileqq.activity.qqsettingme.utils.b.h(qQSettingMeBizBean)) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            inflate2.setVisibility(i3);
            acVar.h(inflate2);
            if (TianshuRedTouch.INSTANCE.j()) {
                redTouchTextView.setTextColor(l1());
                redTouchTextView.R = Boolean.TRUE;
                redTouchTextView.c();
                View findViewById = inflate2.findViewById(R.id.ume);
                findViewById.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                layoutParams.leftMargin = ViewUtils.dpToPx(10.0f);
                acVar.e(new TianshuRedTouch(this.f274438f, findViewById).h0(8388629).t().k0(layoutParams).p0(TianshuRedTouch.RedTouchAssembleType.ALL_REDTOUCH));
            }
            acVar.g(new RedTouch(this.f274438f, uRLImageView).setGravity(8388661).applyTo());
            acVar.f(redTouchTextView);
            qQSettingMeBizBean.w(acVar);
            com.tencent.mobileqq.qqsettingme.a.C.put(qQSettingMeBizBean.n(), qQSettingMeBizBean);
            this.E.e2(qQSettingMeBizBean.n());
        }
        X0();
        this.E.U1(this.f274438f, this.F);
    }

    private void r1(boolean z16, String str, Boolean bool) {
        if (this.H0 != null && this.J0 != null && this.I0 != null && this.F0 != null && this.G0 != null && !TextUtils.isEmpty(str)) {
            this.I0.setVisibility(8);
            if (!z16 && str.charAt(0) == '-' && !bool.booleanValue()) {
                String substring = str.substring(1);
                this.I0.setVisibility(0);
                this.I0.setText("-");
                this.I0.measure(0, 0);
                this.H0.setText(substring);
            }
            this.H0.measure(0, 0);
            this.J0.measure(0, 0);
            this.F0.measure(0, 0);
        }
    }

    private Boolean s1() {
        return Boolean.FALSE;
    }

    private void t1(QQSettingMeBizBean qQSettingMeBizBean) {
        TianshuRedTouch e16;
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(qQSettingMeBizBean.n());
        if (g16 == null) {
            return;
        }
        Boolean valueOf = Boolean.valueOf(g16.hasRedTouch());
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        if (companion.j() && (e16 = com.tencent.mobileqq.qqsettingme.a.e(qQSettingMeBizBean.n())) != null) {
            valueOf = Boolean.valueOf(companion.c(e16));
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h(qQSettingMeBizBean.n());
        VideoReport.setElementDynamicParams(h16, new com.tencent.mobileqq.activity.qqsettingme.m().b(valueOf.booleanValue(), com.tencent.mobileqq.activity.qqsettingme.utils.b.c(qQSettingMeBizBean.n()), qQSettingMeBizBean.n()));
        if (qQSettingMeBizBean.i() != null) {
            VideoReport.setElementId(h16, qQSettingMeBizBean.i());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_red_tips_em", Integer.valueOf(valueOf.booleanValue() ? 1 : 0));
        VideoReport.reportEvent("imp", h16, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Map u1(String str) {
        RedTouch redTouch;
        boolean z16;
        HashMap hashMap = new HashMap();
        RedDotTextView redDotTextView = this.f154315y0;
        if ((redDotTextView != null && redDotTextView.b()) || ((redTouch = this.f154313w0) != null && redTouch.hasRedTouch())) {
            z16 = true;
        } else {
            z16 = false;
        }
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        int i3 = z16;
        if (companion.j()) {
            TianshuRedTouch tianshuRedTouch = this.f154314x0;
            i3 = z16;
            if (tianshuRedTouch != null) {
                i3 = companion.c(tianshuRedTouch);
            }
        }
        hashMap.put("is_red_tips_em", Integer.valueOf(i3));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map v1(String str) {
        int i3;
        HashMap hashMap = new HashMap();
        if (this.B0.getText().equals(this.f274438f.getResources().getString(R.string.f2042052_))) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("time_state", Integer.valueOf(i3));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Type inference failed for: r3v17 */
    public /* synthetic */ void w1() {
        ?? r36;
        TianshuRedTouch l3;
        for (QQSettingMeBizBean qQSettingMeBizBean : com.tencent.mobileqq.qqsettingme.a.C.values()) {
            View h16 = com.tencent.mobileqq.qqsettingme.a.h(qQSettingMeBizBean.n());
            if (!TextUtils.isEmpty(qQSettingMeBizBean.i()) && h16 != null) {
                TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                if (companion.j() && (l3 = qQSettingMeBizBean.l()) != null) {
                    r36 = companion.c(l3);
                } else {
                    r36 = 0;
                }
                if (qQSettingMeBizBean.i() != null) {
                    VideoReport.setElementId(h16, qQSettingMeBizBean.i());
                }
                VideoReport.setElementParam(h16, "is_red_tips_em", Integer.valueOf((int) r36));
                VideoReport.setElementClickPolicy(h16, ClickPolicy.REPORT_NONE);
                VideoReport.setElementExposePolicy(h16, ExposurePolicy.REPORT_NONE);
            }
        }
        VideoReport.setElementId(this.C0, "em_drawer_talent");
        View view = this.C0;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(view, clickPolicy);
        View view2 = this.C0;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(view2, exposurePolicy);
        VideoReport.reportEvent("imp", this.C0, null);
        VideoReport.setElementId(this.F0, "em_drawer_weather");
        VideoReport.setElementClickPolicy(this.F0, clickPolicy);
        VideoReport.setElementExposePolicy(this.F0, exposurePolicy);
        VideoReport.reportEvent("imp", this.F0, null);
        VideoReport.setElementId(this.f154301k0, "em_drawer_sign_up");
        VideoReport.setElementClickPolicy(this.f154301k0, clickPolicy);
        VideoReport.setElementExposePolicy(this.f154301k0, exposurePolicy);
        VideoReport.setElementId(this.T, "em_drawer_energy_sign");
        VideoReport.setElementClickPolicy(this.T, clickPolicy);
        VideoReport.setElementExposePolicy(this.T, exposurePolicy);
        VideoReport.setElementId(this.V, "em_drawer_qqlevel_sign");
        VideoReport.setElementClickPolicy(this.V, clickPolicy);
        VideoReport.setElementExposePolicy(this.V, exposurePolicy);
        VideoReport.setElementId(this.f154291a0, "em_drawer_member_sign");
        VideoReport.setElementClickPolicy(this.f154291a0, clickPolicy);
        VideoReport.setElementExposePolicy(this.f154291a0, exposurePolicy);
        VideoReport.setElementId(this.f154298h0, "em_bas_dimensional_code");
        VideoReport.setElementClickPolicy(this.f154298h0, clickPolicy);
        VideoReport.setElementExposePolicy(this.f154298h0, exposurePolicy);
        VideoReport.setElementId(this.L, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.L, clickPolicy);
        VideoReport.setElementExposePolicy(this.L, exposurePolicy);
        VideoReport.setElementId(this.M, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.M, clickPolicy);
        VideoReport.setElementExposePolicy(this.M, exposurePolicy);
        VideoReport.setElementId(this.N, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.N, clickPolicy);
        VideoReport.setElementExposePolicy(this.N, exposurePolicy);
        VideoReport.setElementId(this.f154310t0, "em_bas_settings");
        VideoReport.setElementClickPolicy(this.f154310t0, clickPolicy);
        VideoReport.setElementExposePolicy(this.f154310t0, exposurePolicy);
        VideoReport.setEventDynamicParams(this.f154310t0, new IDynamicParams() { // from class: com.tencent.mobileqq.ae
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map u16;
                u16 = QQSettingMeView.this.u1(str);
                return u16;
            }
        });
        VideoReport.setElementId(this.f154316z0, "em_bas_time_state");
        VideoReport.setElementClickPolicy(this.f154316z0, clickPolicy);
        VideoReport.setElementExposePolicy(this.f154316z0, exposurePolicy);
        VideoReport.setEventDynamicParams(this.f154316z0, new IDynamicParams() { // from class: com.tencent.mobileqq.af
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map v16;
                v16 = QQSettingMeView.this.v1(str);
                return v16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x1() {
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setAvatarDrawable(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1() {
        VideoReport.setPageId(this.f274439h, "pg_drawer");
        d0();
        j1();
    }

    private void z1() {
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        if (VasNormalToggle.VAS_QQ_SETTING_ME_RELOAD_THEME_CHANGED.isEnable(true) && this.J != simpleUISwitch) {
            ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setAvatarDrawable(this.M);
        }
        this.J = simpleUISwitch;
        if (!QQTheme.isNowSimpleUI()) {
            Z0();
            if (!QQTheme.isNowThemeIsSuperTheme()) {
                g1();
                return;
            }
            return;
        }
        e1();
        X0();
        LinearLayout linearLayout = this.f154301k0;
        if (linearLayout != null) {
            f1(linearLayout.findViewById(R.id.und), m1(23.0f));
            int c16 = com.tencent.mobileqq.util.x.c(BaseApplication.getContext(), 16.0f);
            LinearLayout linearLayout2 = this.f154301k0;
            linearLayout2.setPadding(c16, linearLayout2.getPaddingTop(), this.f154301k0.getPaddingRight(), this.f154301k0.getPaddingBottom());
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void A(com.tencent.mobileqq.activity.qqsettingme.bean.c cVar) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) cVar);
            return;
        }
        if (com.tencent.mobileqq.qqsettingme.a.h("d_document") == null) {
            return;
        }
        boolean z16 = false;
        if (QLog.isColorLevel()) {
            QLog.i("QQSettingMeView", 2, String.format(Locale.CHINA, "updateFace2FaceGuide switch_hasShowed = %d_%b", Integer.valueOf(cVar.f184878a), Boolean.valueOf(cVar.f184880c)));
        }
        if (cVar.f184878a == 1 && !cVar.f184880c) {
            z16 = true;
        }
        if (!z16 && (textView = this.f154308r0) != null) {
            textView.setVisibility(8);
            return;
        }
        if (z16) {
            TextView textView2 = this.f154308r0;
            if (textView2 != null && textView2.getVisibility() == 0) {
                return;
            }
            o1(cVar.f184879b);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.QQSettingMeView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    long j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!com.tencent.mobileqq.qqsettingme.a.f274435m) {
                        return;
                    }
                    Rect rect = new Rect();
                    View h16 = com.tencent.mobileqq.qqsettingme.a.h("d_document");
                    if (h16 != null) {
                        QQSettingMeView.this.f154305o0.offsetDescendantRectToMyCoords(h16, rect);
                    }
                    Rect rect2 = new Rect();
                    QQSettingMeView.this.f154305o0.getDrawingRect(rect2);
                    boolean contains = rect2.contains(rect);
                    if (!contains) {
                        QQSettingMeView.this.f154305o0.scrollTo(QQSettingMeView.this.f154305o0.getScrollX(), rect.top);
                    }
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.QQSettingMeView.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            Rect rect3 = new Rect();
                            View h17 = com.tencent.mobileqq.qqsettingme.a.h("d_document");
                            if (h17 == null) {
                                return;
                            }
                            h17.getHitRect(rect3);
                            View findViewById = h17.findViewById(R.id.umj);
                            rect3.offset(findViewById.getLeft() + Utils.n(34.0f, QQSettingMeView.this.f274439h.getResources()), findViewById.getTop() - Utils.n(18.0f, QQSettingMeView.this.f274439h.getResources()));
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) QQSettingMeView.this.f154308r0.getLayoutParams();
                            layoutParams.leftMargin = rect3.left;
                            layoutParams.topMargin = rect3.top;
                            QQSettingMeView.this.f154308r0.setLayoutParams(layoutParams);
                            QQSettingMeView.this.f154308r0.setPadding(Utils.n(6.0f, QQSettingMeView.this.f274439h.getResources()), Utils.n(4.0f, QQSettingMeView.this.f274439h.getResources()), Utils.n(6.0f, QQSettingMeView.this.f274439h.getResources()), Utils.n(8.0f, QQSettingMeView.this.f274439h.getResources()));
                            QQSettingMeView.this.f154308r0.setVisibility(0);
                        }
                    };
                    if (contains) {
                        j3 = 0;
                    } else {
                        j3 = 50;
                    }
                    uIHandlerV2.postDelayed(runnable, j3);
                }
            }, 50L);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void B(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) appInfo);
            return;
        }
        RedTouch redTouch = this.W;
        if (redTouch != null) {
            redTouch.parseRedTouch(appInfo);
            VideoReport.setElementDynamicParams(this.V, new com.tencent.mobileqq.activity.qqsettingme.m().c(this.W.hasRedTouch()));
            VideoReport.reportEvent("imp", this.V, null);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void C(BusinessInfoCheckUpdate.AppInfo appInfo) {
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) appInfo);
            return;
        }
        if (this.X != null && s1().booleanValue()) {
            if (appInfo != null && (pBStringField = appInfo.path) != null) {
                this.X.n0(pBStringField.get());
                return;
            }
            return;
        }
        RedTouch redTouch = this.f154292b0;
        if (redTouch != null) {
            redTouch.parseRedTouch(appInfo);
            VideoReport.setElementDynamicParams(this.f154291a0, new com.tencent.mobileqq.activity.qqsettingme.m().c(this.f154292b0.hasRedTouch()));
            VideoReport.reportEvent("imp", this.f154291a0, null);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void D(com.tencent.mobileqq.activity.qqsettingme.bean.g gVar) {
        int B1;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) gVar);
            return;
        }
        try {
            if (gVar.f184893b != null && this.f274438f != null && this.R != null && this.S != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                Resources resources = this.f274438f.getResources();
                this.R.setVisibility(8);
                this.S.setVisibility(8);
                if (com.tencent.mobileqq.activity.qqsettingme.utils.b.e(gVar)) {
                    ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setVipExtIcon(this.f274438f, this.S, gVar.f184893b.nameplateExtId);
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (gVar.f184901j != null && gVar.f184902k != 0) {
                    ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setVipCardDrawable(this.f274438f.getResources(), this.R, gVar.f184901j, this.f274438f.getResources().getDrawable(gVar.f184902k));
                    this.R.setVisibility(0);
                    this.R.setContentDescription(HardCodeUtil.qqStr(R.string.vhq));
                    this.R.setFocusableInTouchMode(true);
                    this.R.setOnTouchListener(((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).headVipReport(peekAppRuntime, gVar.f184893b.uin));
                } else {
                    this.R.setOnTouchListener(null);
                }
                Y0();
                if (gVar.f184907p) {
                    IQQSettingMeApi iQQSettingMeApi = (IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class);
                    ImageView imageView = this.U;
                    Card card = gVar.f184893b;
                    this.U.setImageDrawable(iQQSettingMeApi.getGameCardIcon(imageView, card.namePlateOfKingGameId, card.namePlateOfKingDan, card.namePlateOfKingDanDisplatSwitch, card.gameCardId));
                } else {
                    this.U.setVisibility(8);
                }
                if (QQTheme.isNowSimpleUI() && this.R.getVisibility() == 0) {
                    this.U.setVisibility(8);
                }
                d1(QQTheme.isNowSimpleUI());
                MedalList medalList = gVar.f184894c;
                if (medalList != null && medalList.infoList.size() > 0) {
                    ((IQVipMedalViewApi) QRoute.api(IQVipMedalViewApi.class)).setData(this.f154291a0, gVar.f184894c);
                    this.f154291a0.setVisibility(0);
                    this.Z.setVisibility(0);
                    if (((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsDefault(peekAppRuntime, true, null)) {
                        this.Y.setBackgroundColor(Color.parseColor("#7bffffff"));
                    } else {
                        this.Y.setBackgroundColor(this.f274438f.getResources().getColor(R.color.qui_common_text_allwhite_primary));
                    }
                } else {
                    this.f154291a0.setVisibility(8);
                    this.Y.setVisibility(8);
                    this.Z.setVisibility(8);
                }
                if (QQTheme.isNowSimpleUI()) {
                    B1 = 3;
                } else {
                    B1 = B1(gVar);
                }
                spannableStringBuilder.append((CharSequence) ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).parseQQLevel(resources, gVar.f184904m, gVar.f184893b.iQQLevel, B1));
                ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setTextForAnimation(this.V, spannableStringBuilder, TextView.BufferType.SPANNABLE);
                this.V.setContentDescription("\u7b49\u7ea7\uff1a" + gVar.f184893b.iQQLevel);
                if (AppSetting.f99565y) {
                    StringBuilder sb5 = new StringBuilder(this.P.getText());
                    if (gVar.f184895d) {
                        str = "\u4f60\u662f\u5c0a\u8d35\u7684\u8d85\u7ea7\u4f1a\u5458";
                    } else if (gVar.f184896e) {
                        str = "\u4f60\u662f\u5c0a\u8d35\u7684\u4f1a\u5458";
                    } else {
                        str = "";
                    }
                    sb5.append(str);
                    if (gVar.f184893b.iQQLevel > 0) {
                        sb5.append(" \u7b49\u7ea7");
                        sb5.append(gVar.f184893b.iQQLevel);
                    }
                    this.L.setContentDescription(sb5.toString());
                }
                if (FontSettingManager.isFontSizeLarge()) {
                    FontSettingManager.resetViewSize2Normal(this.f274438f, this.R);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeView", 2, "updateQQLevelVipView card == null");
            }
        } catch (Throwable th5) {
            QLog.e("QQSettingMeView", 1, "updateHeadVipView exception", th5);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void E(com.tencent.mobileqq.activity.qqsettingme.bean.e eVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) eVar);
            return;
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h("d_intimate_space");
        if (h16 != null && eVar != null) {
            if (eVar.c() && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_intimate_space"))) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            h16.setVisibility(i3);
            View findViewById = h16.findViewById(R.id.umi);
            if (!(findViewById instanceof LinearLayout)) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById;
            QQProAvatarView qQProAvatarView = null;
            for (int i16 = 0; i16 < linearLayout.getChildCount(); i16++) {
                if (linearLayout.getChildAt(i16) instanceof QQProAvatarView) {
                    qQProAvatarView = (QQProAvatarView) linearLayout.getChildAt(i16);
                }
            }
            if (eVar.b()) {
                if (qQProAvatarView != null) {
                    qQProAvatarView.setVisibility(8);
                }
            } else {
                if (TextUtils.isEmpty(eVar.a())) {
                    return;
                }
                if (qQProAvatarView != null) {
                    qQProAvatarView.w(1, eVar.a());
                    qQProAvatarView.setVisibility(0);
                } else {
                    QQProAvatarView qQProAvatarView2 = new QQProAvatarView(this.f274439h.getContext(), null);
                    qQProAvatarView2.w(1, eVar.a());
                    ((ViewGroup) findViewById).addView(qQProAvatarView2, new ViewGroup.LayoutParams(ViewUtils.dip2px(32.0f), ViewUtils.dip2px(32.0f)));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void F(com.tencent.mobileqq.activity.qqsettingme.bean.f fVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) fVar);
            return;
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h("d_vip_card");
        if (h16 == null) {
            return;
        }
        if (fVar.f184887a && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_vip_card"))) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        h16.setVisibility(i3);
        if (!fVar.f184887a || !LocaleManager.isLocaleCN()) {
            return;
        }
        CharSequence d16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.d("d_vip_card", fVar.f184888b);
        if (!fVar.f184890d) {
            RedTouchTextView redTouchTextView = (RedTouchTextView) h16.findViewById(R.id.umj);
            redTouchTextView.setContentDescription(d16);
            redTouchTextView.setText(d16);
            redTouchTextView.c();
            DrawerUtils.m((URLImageView) h16.findViewById(R.id.umf), com.tencent.mobileqq.qqsettingme.a.C.get("d_vip_card"));
        }
        AccessibilityUtil.c(h16, d16, Button.class.getName());
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void G(com.tencent.mobileqq.activity.qqsettingme.bean.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) gVar);
            return;
        }
        if (gVar.f184893b != null && this.f274438f != null && this.E0 != null) {
            String qqStr = HardCodeUtil.qqStr(R.string.f2044252v);
            String qqStr2 = HardCodeUtil.qqStr(R.string.f2044252v);
            this.E0.setText(qqStr);
            AccessibilityUtil.c(this.C0, qqStr2, Button.class.getName());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeView", 2, "updateLevelView error");
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        } else {
            this.P.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void I(com.tencent.mobileqq.activity.qqsettingme.bean.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) hVar);
            return;
        }
        if (TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin())) {
            this.P.setText("");
            this.P.setCompoundDrawables(null, null, null, null);
            this.V.setText("");
            this.R.setVisibility(8);
            this.S.setVisibility(8);
            this.Q.setVisibility(8);
            return;
        }
        this.P.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.P.setMaxWidth(this.H);
        if (!Utils.p(hVar.f184909a, this.P.getText())) {
            this.P.setText(hVar.f184909a);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeView", 2, "updateLevelAndVip from updateAccountInfo");
        }
        this.E.N1("d_head_vip").e();
        if (AppSetting.f99565y) {
            this.L.setContentDescription(this.P.getText());
        }
        K1();
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void J(int i3) {
        Drawable drawable;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
            return;
        }
        Resources resources = this.f274438f.getResources();
        if (i3 == 1) {
            drawable = resources.getDrawable(QUITokenResCompat.getDrawableResId(R.drawable.qui_day_mode_vas));
            str = resources.getString(R.string.f2042052_);
        } else if (i3 == 2) {
            drawable = resources.getDrawable(QUITokenResCompat.getDrawableResId(R.drawable.qui_night_mode_vas));
            str = resources.getString(R.string.fsj);
        } else {
            drawable = null;
            str = null;
        }
        if (drawable != null) {
            this.A0.setImageDrawable(drawable);
        }
        if (str != null) {
            this.B0.setText(str);
            this.f154316z0.setOnClickListener(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqsettingme.a
    public void K(int i3) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
            return;
        }
        if (!(this.A0.getDrawable() instanceof Animatable)) {
            if (this.G) {
                drawable = this.f274438f.getResources().getDrawable(R.drawable.ait);
            } else {
                drawable = this.f274438f.getResources().getDrawable(R.drawable.aiu);
            }
            this.A0.setImageDrawable(drawable);
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
        this.B0.setText(i3 + "%");
        if (QLog.isDevelopLevel()) {
            QLog.d("QQSettingMeView", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i3);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void L(com.tencent.mobileqq.activity.qqsettingme.bean.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) iVar);
            return;
        }
        this.Q.setVisibility(8);
        if (iVar.f184913d != null) {
            this.Q.setVisibility(0);
            this.Q.setImageDrawable(iVar.f184913d);
            G1(iVar);
        } else {
            if (!iVar.f184910a || iVar.f184911b == null || iVar.f184912c == null) {
                return;
            }
            this.Q.setVisibility(0);
            this.Q.setImageDrawable(iVar.f184912c);
            G1(iVar);
            Y0();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void M(com.tencent.mobileqq.activity.qqsettingme.bean.j jVar) {
        long j3;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) jVar);
            return;
        }
        if (jVar.f184915a && jVar.f184917c != null) {
            QLog.d("QQSettingMeView", 1, "updateProfileBubbleMsgView ", Integer.valueOf(jVar.f184916b));
            if (jVar.f184917c.uint64_from_uin.has()) {
                j3 = jVar.f184917c.uint64_from_uin.get();
            } else {
                j3 = 0;
            }
            View findViewById = this.f154309s0.findViewById(R.id.f165030un3);
            QQProAvatarView qQProAvatarView = (QQProAvatarView) this.f154309s0.findViewById(R.id.f165028un1);
            TextView textView = (TextView) this.f154309s0.findViewById(R.id.f165029un2);
            ImageView imageView = (ImageView) this.f154309s0.findViewById(R.id.f165027un0);
            if (je0.a.a(this.f274438f)) {
                if (QQTheme.isNowSimpleUI()) {
                    i16 = R.drawable.kx5;
                } else {
                    i16 = R.drawable.cdn;
                }
                findViewById.setBackgroundResource(i16);
                textView.setTextColor(-1);
            } else {
                if (QQTheme.isNowSimpleUI()) {
                    i3 = R.drawable.kx6;
                } else {
                    i3 = R.drawable.f161889ro;
                }
                findViewById.setBackgroundResource(i3);
                textView.setTextColor(-16777216);
            }
            if (j3 == 111) {
                qQProAvatarView.setImageDrawable(this.f274438f.getResources().getDrawable(R.drawable.nfz));
            } else if (j3 == 112) {
                qQProAvatarView.setImageDrawable(this.f274438f.getResources().getDrawable(R.drawable.f161827ng2));
            } else {
                qQProAvatarView.w(1, Long.toString(j3));
            }
            String string = this.f274438f.getResources().getString(R.string.vvh, Integer.valueOf(jVar.f184916b));
            if (!string.equalsIgnoreCase(textView.getText().toString())) {
                textView.setText(string);
            }
            findViewById.setContentDescription(string);
            findViewById.setOnTouchListener(new b(qQProAvatarView, textView, imageView));
            findViewById.setOnClickListener(this);
            this.f154309s0.setVisibility(0);
            return;
        }
        this.f154309s0.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void N(BusinessInfoCheckUpdate.AppInfo appInfo) {
        TianshuRedTouch tianshuRedTouch;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appInfo);
            return;
        }
        if (s1().booleanValue() && (tianshuRedTouch = this.f154300j0) != null) {
            if (appInfo != null && (pBStringField = appInfo.path) != null) {
                tianshuRedTouch.n0(pBStringField.get());
                return;
            }
            return;
        }
        if (appInfo != null) {
            this.f154299i0.parseRedTouch(appInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void O(com.tencent.mobileqq.activity.qqsettingme.bean.m mVar) {
        TianshuRedTouch tianshuRedTouch;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) mVar);
            return;
        }
        boolean z16 = mVar.f184925b;
        RedDotTextView redDotTextView = this.f154315y0;
        if (redDotTextView != null) {
            redDotTextView.c(z16);
        }
        if (!z16 && (mVar.f184926c || mVar.f184927d)) {
            RedDotTextView redDotTextView2 = this.f154315y0;
            if (redDotTextView2 != null) {
                redDotTextView2.c(true);
            }
            z16 = true;
        }
        if (!z16 && TianshuRedTouch.INSTANCE.j() && (tianshuRedTouch = this.f154314x0) != null) {
            BusinessInfoCheckUpdate.AppInfo appInfo = mVar.f184924a;
            if (appInfo != null && (pBStringField = appInfo.path) != null) {
                tianshuRedTouch.n0(String.valueOf(pBStringField.get()));
            }
            this.f154314x0.F(null);
            return;
        }
        if (!z16) {
            this.f154313w0.parseRedTouchOnlyRedPoint(mVar.f184924a);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void P(BusinessInfoCheckUpdate.AppInfo appInfo) {
        TianshuRedTouch tianshuRedTouch;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) appInfo);
            return;
        }
        if (s1().booleanValue() && (tianshuRedTouch = this.f154296f0) != null) {
            if (appInfo != null && (pBStringField = appInfo.path) != null) {
                tianshuRedTouch.n0(pBStringField.get());
                return;
            }
            return;
        }
        try {
            this.f154295e0.parseRedTouch(appInfo);
        } catch (Exception e16) {
            QLog.e("QQSettingMeView", 1, "updateSignatureRedTouch exception", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void Q(com.tencent.mobileqq.activity.qqsettingme.bean.l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) lVar);
            return;
        }
        ImageView imageView = (ImageView) this.f154294d0.findViewById(R.id.f165033uo1);
        TextView textView = (TextView) this.f154294d0.findViewById(R.id.f165034uo2);
        ImageView imageView2 = (ImageView) this.f154294d0.findViewById(R.id.unp);
        imageView2.setColorFilter(textView.getCurrentTextColor());
        textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        textView.setMaxWidth(this.I);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SharedPreferences.Editor edit = peekAppRuntime.getApp().getSharedPreferences("qqsettingme_signature" + peekAppRuntime.getAccount(), 0).edit();
        StringBuilder sb5 = new StringBuilder(100);
        RichStatus richStatus = lVar.f184922a;
        if (richStatus != null && !TextUtils.isEmpty(richStatus.actionText)) {
            imageView.setImageBitmap(lVar.f184923b);
            imageView.setVisibility(0);
            sb5.append(lVar.f184922a.actionText);
            if (!TextUtils.isEmpty(lVar.f184922a.dataText)) {
                sb5.append(lVar.f184922a.dataText);
            }
            sb5.append(TokenParser.SP);
            edit.putInt("actionId", lVar.f184922a.actionId);
            edit.putString("actionText", lVar.f184922a.actionText);
            edit.putString("dataText", lVar.f184922a.dataText);
        } else {
            imageView.setBackgroundResource(0);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setImageResource(R.drawable.qq_setting_me_richstatus_icon_none);
            imageView.setVisibility(8);
        }
        RichStatus richStatus2 = lVar.f184922a;
        if (richStatus2 != null) {
            String str = null;
            if (richStatus2.hasTopic()) {
                if (lVar.f184922a.shouldShowAtHead()) {
                    String str2 = lVar.f184922a.topicToPlainText();
                    sb5.append(str2);
                    edit.putString(MessageForRichState.SIGN_MSG_TOPICS, str2);
                    ArrayList<String> arrayList = lVar.f184922a.plainText;
                    if (arrayList != null && arrayList.size() > 0) {
                        str = lVar.f184922a.plainText.get(0);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        sb5.append(str);
                    }
                    edit.putString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, str);
                }
                if (lVar.f184922a.shouldShowMixing()) {
                    String plainText = lVar.f184922a.getPlainText();
                    sb5.append(plainText);
                    edit.putString("plainMixTopic", plainText);
                }
            } else {
                ArrayList<String> arrayList2 = lVar.f184922a.plainText;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    str = lVar.f184922a.plainText.get(0);
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                }
                edit.putString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, str);
            }
        }
        edit.apply();
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            textView.setText(R.string.fru);
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(0);
            if (com.tencent.mobileqq.utils.ah.m0()) {
                textView.setText(new QQText(sb6 + " ", 1, 16));
            } else {
                textView.setText(new QQText(sb6, 1, 16));
            }
            if (Build.VERSION.SDK_INT < 29) {
                textView.setText(W0(textView, textView.getText().toString(), this.I));
            }
        }
        if (AppSetting.f99565y) {
            this.f154294d0.setContentDescription("\u4e2a\u6027\u7b7e\u540d" + sb6);
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void R(com.tencent.mobileqq.activity.qqsettingme.bean.o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) oVar);
            return;
        }
        try {
            if (!oVar.f184935a.path.has()) {
                oVar.f184935a.path.set(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP));
            }
            BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
            appInfo.set(oVar.f184935a);
            if (oVar.f184939e && RedTouchTextView.n(appInfo) != null) {
                ArrayList arrayList = new ArrayList();
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo.red_type.set(0);
                arrayList.add(redTypeInfo);
                appInfo.red_display_info.red_type_info.set(arrayList);
            }
            C1("d_vip_identity", appInfo);
        } catch (Exception e16) {
            QLog.e("QQSettingMeView", 1, "updateSuperMemberItemView: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void S(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) pVar);
        } else {
            this.N0.removeMessages(1);
            O1(pVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void T(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) pVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeView", 2, "updateWeatherView cur_temp:", pVar.f184940a, ",cur_areainfo:", pVar.f184941b, ",cur_adcode:", Integer.valueOf(pVar.f184942c), ",o_wea_code:", pVar.f184943d, ",show_flag:", Boolean.valueOf(pVar.f184944e), ",up_type:", Integer.valueOf(pVar.f184946g), ",up_text:", pVar.f184947h, ",down_text:", pVar.f184948i);
        }
        if (!pVar.f184944e) {
            this.F0.setVisibility(8);
            this.F0.setClickable(false);
            this.J0.setVisibility(4);
            this.K0.setVisibility(8);
            return;
        }
        if (pVar.f184949j.size() > 0) {
            O1(pVar);
            AlphaAnimation a16 = com.tencent.mobileqq.activity.qqsettingme.utils.c.a(1.0f, 0.0f);
            a16.setStartOffset(2000L);
            a16.setAnimationListener(new d(pVar));
            this.F0.startAnimation(a16);
            return;
        }
        O1(pVar);
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void U(com.tencent.mobileqq.activity.qqsettingme.bean.q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) qVar);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    @Nullable
    public List<com.tencent.mobileqq.part.a> V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (List) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QQSettingMeChangeAccountPart(false));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.Y();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && this.O0 != null) {
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).unRegisterVipDataChangedCallback(peekAppRuntime.getCurrentAccountUin(), this.O0);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.Z();
        TextView textView = this.f154308r0;
        if (textView != null && textView.getVisibility() == 0) {
            this.f154308r0.setVisibility(8);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, peekAppRuntime.getCurrentAccountUin() + AppConstants.Preferences.QQSETTINGME_F2F_GUIDE, 0).edit().putBoolean(AppConstants.Preferences.QQSETTINGME_F2F_GUIDE_FLAG, true).apply();
        }
        M1(null);
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (!z16) {
            return;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            this.f154311u0.setTextSize(1, 16.0f);
            this.B0.setTextSize(1, 16.0f);
            this.E0.setTextSize(1, 16.0f);
            this.J0.setTextSize(1, 16.0f);
            return;
        }
        this.f154311u0.setTextSize(1, 12.0f);
        this.B0.setTextSize(1, 12.0f);
        this.E0.setTextSize(1, 12.0f);
        this.J0.setTextSize(1, 12.0f);
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.a0();
            M1(null);
        }
    }

    @Override // com.tencent.mobileqq.utils.fa
    public void b0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
            return;
        }
        QLog.i("QQSettingMeView", 1, "padding change to " + i3);
        View view = this.N;
        if (view != null) {
            if (i3 < 0) {
                i3 = 0;
            }
            view.setPadding(0, 0, i3, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    public void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.c0();
            p1();
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f154316z0;
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView, com.tencent.mobileqq.qqsettingme.a
    public QQSettingMeViewModel k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQSettingMeViewModel) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.E;
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        LinearLayout linearLayout = this.F0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.J0;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void o(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) configuration);
        } else {
            this.E.X1();
        }
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"NonConstantResourceId"})
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else if (view != null && this.f274436d && !FastClickUtils.isFastDoubleClick("QQSettingMeView")) {
            int id5 = view.getId();
            if (id5 != R.id.f165026um4 && id5 != R.id.f165025um3) {
                int i3 = 1;
                int i16 = 1;
                boolean z16 = true;
                int i17 = 1;
                if (id5 == R.id.ung) {
                    RedTouch redTouch = this.f154302l0;
                    if (redTouch == null || !redTouch.hasRedTouch()) {
                        i16 = 0;
                    }
                    this.E.N1("d_daily").onClick(view);
                    VideoReport.setElementParam(view, "is_red_tips_em", Integer.valueOf(i16));
                    VideoReport.reportEvent("clck", view, null);
                } else if (id5 == R.id.unv) {
                    this.E.N1("d_nickname").onClick(view);
                } else if (id5 == R.id.unq) {
                    this.E.N1("d_avatar").onClick(view);
                } else if (id5 == R.id.un6) {
                    this.E.N1("d_qrcode").onClick(view);
                } else if (id5 == R.id.un9) {
                    this.E.N1("d_setting").onClick(view);
                } else if (id5 == R.id.umv) {
                    this.E.N1("d_night_mode").onClick(view);
                } else if (id5 == R.id.uoa) {
                    this.E.N1("d_weather").onClick(view);
                    VideoReport.setElementParam(view, "is_red_tips_em", 0);
                    VideoReport.reportEvent("clck", view, null);
                } else if (id5 == R.id.f165035uo3) {
                    View view2 = this.f154294d0;
                    if (view2 != null && this.f274438f != null) {
                        TextView textView = (TextView) view2.findViewById(R.id.f165034uo2);
                        if (textView == null || textView.getText() == null) {
                            z16 = false;
                        }
                        view.setTag(Boolean.valueOf(z16));
                    }
                    this.E.N1("d_signature").onClick(view);
                    this.f154314x0.y(null);
                } else if (id5 == R.id.unz) {
                    RedTouch redTouch2 = this.f154292b0;
                    if (redTouch2 == null || !redTouch2.hasRedTouch()) {
                        i17 = 0;
                    }
                    this.E.N1("d_head_vip").onClick(view);
                    VideoReport.setElementParam(view, "is_red_tips_em", Integer.valueOf(i17));
                    VideoReport.reportEvent("clck", view, null);
                    this.f154293c0.y(null);
                } else if (id5 == R.id.f165032uo0) {
                    RedTouch redTouch3 = this.W;
                    if (redTouch3 == null || !redTouch3.hasRedTouch()) {
                        i3 = 0;
                    }
                    this.E.N1("d_head_vip").onClick(view);
                    VideoReport.setElementParam(view, "is_red_tips_em", Integer.valueOf(i3));
                    VideoReport.reportEvent("clck", view, null);
                    this.X.y(null);
                } else if (id5 == R.id.unn) {
                    this.E.N1("d_head_vip").onClick(view);
                } else if (id5 == R.id.unw) {
                    this.E.N1("d_head_vip").onClick(view);
                    VideoReport.setElementParam(view, "is_red_tips_em", 0);
                    VideoReport.reportEvent("clck", view, null);
                } else if (id5 == R.id.f165030un3) {
                    this.E.N1("d_profile_bubble").onClick(view);
                } else if (id5 == R.id.uo7) {
                    this.E.N1("d_head_vip").onClick(view);
                } else if (id5 == R.id.umm) {
                    this.E.N1("d_head_vip").onClick(view);
                    VideoReport.setElementParam(view, "is_red_tips_em", 0);
                    VideoReport.reportEvent("clck", view, null);
                }
            } else {
                this.E.N1("d_common").onClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView
    @RequiresApi(api = 23)
    public void onPostThemeChanged() {
        boolean z16;
        int i3;
        String qqStr;
        int i16;
        CharSequence charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        z1();
        Bundle currentThemeInfo = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).getCurrentThemeInfo();
        String string = currentThemeInfo.getString("themeId");
        if (!TextUtils.isEmpty(string) && !"1000".equals(string) && !"1103".equals(string)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.G = z16;
        M1(null);
        int l16 = l1();
        v(((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).hasCover(MobileQQ.sMobileQQ.peekAppRuntime(), ((com.tencent.mobileqq.activity.qqsettingme.j) this.E.N1("d_head_vip")).g()));
        ViewGroup viewGroup = (ViewGroup) this.f154309s0.findViewById(R.id.f165030un3);
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(R.drawable.kx7);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeView", 2, "onPostThemeChanged, color=", Integer.valueOf(l16), ",themeid = ", string, ", enginePath=", currentThemeInfo.getString("themePath"));
        }
        this.f154311u0.setTextColor(l16);
        this.B0.setTextColor(l16);
        this.E0.setTextColor(l16);
        int k16 = k1();
        this.H0.setTextColor(k16);
        this.I0.setTextColor(k16);
        this.E.N1("d_weather").e();
        this.J0.setTextColor(l16);
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.drawable.qui_day_mode_vas;
        } else {
            i3 = R.drawable.qui_night_mode_vas;
        }
        DrawerUtils.k(this.A0, i3, true);
        DrawerUtils.k(this.f154312v0, R.drawable.qui_setting_vas, true);
        ImageView imageView = this.f154312v0;
        int i17 = R.color.qq_setting_me_nightmode_color_white;
        E1(imageView, R.color.qq_setting_me_nightmode_color_white, R.color.qui_common_icon_primary);
        E1(this.A0, R.color.qq_setting_me_nightmode_color_white, R.color.qui_common_icon_primary);
        ImageView imageView2 = this.D0;
        Resources resources = imageView2.getResources();
        if (!QQTheme.isVasTheme()) {
            i17 = R.color.qui_common_icon_primary;
        }
        imageView2.setColorFilter(resources.getColor(i17));
        this.E.N1("d_weather").e();
        for (QQSettingMeBizBean qQSettingMeBizBean : com.tencent.mobileqq.qqsettingme.a.C.values()) {
            if (qQSettingMeBizBean.m() != null) {
                View m3 = qQSettingMeBizBean.m();
                if (!com.tencent.mobileqq.activity.qqsettingme.utils.b.h(qQSettingMeBizBean) && !this.E.N1(qQSettingMeBizBean.n()).f()) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                m3.setVisibility(i16);
                URLImageView uRLImageView = (URLImageView) qQSettingMeBizBean.m().findViewById(R.id.umf);
                m3.setBackground(m3.getResources().getDrawable(QUITokenResUtil.handleDIY(R.drawable.aiq, R.drawable.qui_common_fill_light_primary_bg_selector)));
                DrawerUtils.m(uRLImageView, qQSettingMeBizBean);
                F1(uRLImageView, qQSettingMeBizBean);
                RedTouchTextView redTouchTextView = (RedTouchTextView) qQSettingMeBizBean.m().findViewById(R.id.umj);
                redTouchTextView.setTextColor(l16);
                String n3 = qQSettingMeBizBean.n();
                if (qQSettingMeBizBean.r() != null) {
                    charSequence = qQSettingMeBizBean.r().f184991a;
                } else {
                    charSequence = "";
                }
                redTouchTextView.setText(com.tencent.mobileqq.activity.qqsettingme.utils.b.d(n3, charSequence));
                redTouchTextView.c();
            }
        }
        d1(QQTheme.isNowSimpleUI());
        View view = this.f154316z0;
        if (QQTheme.isNowThemeIsNight()) {
            qqStr = HardCodeUtil.qqStr(R.string.f213835r_);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.r2i);
        }
        AccessibilityUtil.c(view, qqStr, Button.class.getName());
        J1();
        d0();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"NonConstantResourceId"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (view == null) {
            return false;
        }
        int id5 = view.getId();
        if (id5 == R.id.ung || id5 == R.id.f165026um4 || id5 == R.id.un6 || id5 == R.id.unq || id5 == R.id.un9 || id5 == R.id.umv || id5 == R.id.umm || id5 == R.id.uoa || id5 == R.id.f165035uo3) {
            this.E.c2(view, motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView, com.tencent.mobileqq.qqsettingme.a
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.p();
            VideoReport.pageLogicDestroy(this.f274439h);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.BaseQQSettingMeView, com.tencent.mobileqq.qqsettingme.a
    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.q();
        p1();
        Card g16 = ((com.tencent.mobileqq.activity.qqsettingme.j) this.E.N1("d_head_vip")).g();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).reportCoverBg(peekAppRuntime, g16);
        if (peekAppRuntime != null && this.O0 != null) {
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).registerVipDataChangedCallback(peekAppRuntime.getCurrentAccountUin(), this.O0);
        }
        this.f274439h.post(new Runnable() { // from class: com.tencent.mobileqq.y
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeView.this.y1();
            }
        });
        ViewGroup viewGroup = this.f274439h;
        QQSettingMeViewModel qQSettingMeViewModel = this.E;
        Objects.requireNonNull(qQSettingMeViewModel);
        viewGroup.post(new z(qQSettingMeViewModel));
        ViewGroup viewGroup2 = this.f274439h;
        com.tencent.mobileqq.part.b bVar = this.D;
        Objects.requireNonNull(bVar);
        viewGroup2.post(new aa(bVar));
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void s(com.tencent.mobileqq.activity.qqsettingme.bean.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) nVar);
            return;
        }
        ImageView imageView = (ImageView) this.f154294d0.findViewById(R.id.f165033uo1);
        TextView textView = (TextView) this.f154294d0.findViewById(R.id.f165034uo2);
        ImageView imageView2 = (ImageView) this.f154294d0.findViewById(R.id.unp);
        imageView2.setColorFilter(textView.getCurrentTextColor());
        StringBuilder sb5 = new StringBuilder(100);
        textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        textView.setMaxWidth(this.I);
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeView", 2, "preLoadSignature, actionText = ", nVar.f184929b, " actionId = ", Integer.valueOf(nVar.f184928a), " dataText = ", nVar.f184930c, " plainText = " + nVar.f184932e);
        }
        if (!TextUtils.isEmpty(nVar.f184929b)) {
            imageView.setImageBitmap(nVar.f184934g);
            imageView.setVisibility(0);
            sb5.append(nVar.f184929b);
            if (!TextUtils.isEmpty(nVar.f184930c)) {
                sb5.append(nVar.f184930c);
            }
            sb5.append(TokenParser.SP);
        } else {
            imageView.setBackgroundResource(0);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setImageResource(R.drawable.qq_setting_me_richstatus_icon_none);
            imageView.setVisibility(8);
        }
        if (TextUtils.isEmpty(nVar.f184933f)) {
            if (!TextUtils.isEmpty(nVar.f184931d)) {
                sb5.append(nVar.f184931d);
            }
            if (!TextUtils.isEmpty(nVar.f184932e)) {
                sb5.append(nVar.f184932e);
            }
        } else {
            sb5.append(nVar.f184933f);
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            textView.setText(R.string.fru);
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(0);
            if (com.tencent.mobileqq.utils.ah.m0()) {
                textView.setText(new QQText(sb6 + " ", 1, 16));
            } else {
                textView.setText(new QQText(sb6, 1, 16));
            }
            if (Build.VERSION.SDK_INT < 29) {
                textView.setText(W0(textView, textView.getText().toString(), this.I));
            }
        }
        if (AppSetting.f99565y) {
            this.f154294d0.setContentDescription("\u4e2a\u6027\u7b7e\u540d" + sb6);
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.f274438f.runOnUiThread(new Runnable(z16) { // from class: com.tencent.mobileqq.QQSettingMeView.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f154317d;

                {
                    this.f154317d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQSettingMeView.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQSettingMeView.this.L1(this.f154317d);
                        QLog.i("QQSettingMeView", 2, "updateAllHeadView hasCover: " + this.f154317d);
                        TextView textView = (TextView) QQSettingMeView.this.f274439h.findViewById(R.id.f10657693);
                        ImageView imageView = (ImageView) QQSettingMeView.this.f274439h.findViewById(R.id.y1b);
                        if (this.f154317d && !QQTheme.isVasTheme()) {
                            QQSettingMeView.this.M1(Boolean.TRUE);
                            QQSettingMeView.this.f154297g0.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_close_vas_icon_navigation_01));
                            QQSettingMeView.this.f154298h0.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_qrcode_vas_icon_navigation_01));
                            QQSettingMeView.this.f154297g0.setColorFilter(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qui_common_icon_white));
                            QQSettingMeView.this.f154298h0.setColorFilter(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qui_common_icon_white));
                            if (QQSettingMeView.this.f154304n0 != null) {
                                QQSettingMeView.this.f154304n0.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qui_common_text_allwhite_primary));
                            }
                            TextView textView2 = (TextView) QQSettingMeView.this.f154294d0.findViewById(R.id.f165034uo2);
                            textView2.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qui_common_text_allwhite_primary));
                            ImageView imageView2 = (ImageView) QQSettingMeView.this.f154294d0.findViewById(R.id.unp);
                            if (textView != null) {
                                textView.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qui_common_text_allwhite_primary));
                            }
                            if (imageView != null) {
                                imageView.setColorFilter(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qui_common_icon_white));
                            }
                            imageView2.setColorFilter(textView2.getCurrentTextColor());
                        } else if (QQTheme.isBaseDIYTheme()) {
                            QQSettingMeView.this.M1(Boolean.TRUE);
                            QQSettingMeView.this.f154297g0.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_close_vas));
                            QQSettingMeView.this.f154298h0.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_qrcode_vas));
                            QQSettingMeView.this.f154297g0.setColorFilter(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_nightmode_color_white));
                            QQSettingMeView.this.f154298h0.setColorFilter(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_nightmode_color_white));
                            if (QQSettingMeView.this.f154304n0 != null) {
                                QQSettingMeView.this.f154304n0.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_nightmode_color_white));
                            }
                            if (textView != null) {
                                textView.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_nightmode_color_white));
                            }
                            if (imageView != null) {
                                imageView.setColorFilter(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_nightmode_color_white));
                            }
                            TextView textView3 = (TextView) QQSettingMeView.this.f154294d0.findViewById(R.id.f165034uo2);
                            textView3.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_nightmode_color_white));
                            ((ImageView) QQSettingMeView.this.f154294d0.findViewById(R.id.unp)).setColorFilter(textView3.getCurrentTextColor());
                        } else {
                            QQSettingMeView.this.M1(Boolean.FALSE);
                            QQSettingMeView.this.f154297g0.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_close_vas));
                            QQSettingMeView.this.f154298h0.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_qrcode_vas));
                            int color = ((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_title_color);
                            if (QQSettingMeView.this.f154304n0 != null) {
                                QQSettingMeView.this.f154304n0.setTextColor(color);
                            }
                            QQSettingMeView qQSettingMeView = QQSettingMeView.this;
                            qQSettingMeView.E1(qQSettingMeView.f154297g0, R.color.qq_setting_me_title_color, R.color.qui_common_icon_primary);
                            QQSettingMeView qQSettingMeView2 = QQSettingMeView.this;
                            qQSettingMeView2.E1(qQSettingMeView2.f154298h0, R.color.qq_setting_me_title_color, R.color.qui_common_icon_primary);
                            TextView textView4 = (TextView) QQSettingMeView.this.f154294d0.findViewById(R.id.f165034uo2);
                            textView4.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qq_setting_me_sig_color));
                            ((ImageView) QQSettingMeView.this.f154294d0.findViewById(R.id.unp)).setColorFilter(textView4.getCurrentTextColor());
                            if (textView != null) {
                                textView.setTextColor(((com.tencent.mobileqq.qqsettingme.a) QQSettingMeView.this).f274438f.getResources().getColor(R.color.qui_common_text_primary));
                            }
                            if (imageView != null) {
                                imageView.setColorFilter(imageView.getResources().getColor(R.color.qui_common_icon_primary));
                            }
                        }
                        QQSettingMeView.this.K = this.f154317d;
                        QQSettingMeView.this.K1();
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void w(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h("d_smallworld");
        if (h16 == null) {
            return;
        }
        if (z16 && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_smallworld"))) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        h16.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void x(com.tencent.mobileqq.activity.qqsettingme.bean.a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
            return;
        }
        this.f154301k0.setVisibility(0);
        Drawable drawable = this.f274438f.getResources().getDrawable(QUITokenResCompat.getDrawableResId(R.drawable.qui_daka_vas));
        URLImageView uRLImageView = (URLImageView) this.f154301k0.findViewById(R.id.und);
        if (!QQTheme.isNowSimpleUI() && QQTheme.isNowThemeIsSuperTheme()) {
            if (!TextUtils.isEmpty(aVar.f184871c) && !TextUtils.isEmpty(aVar.f184872d)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mRequestHeight = 56;
                obtain.mRequestWidth = 56;
                if (((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).hasCover(MobileQQ.sMobileQQ.peekAppRuntime(), ((com.tencent.mobileqq.activity.qqsettingme.j) this.E.N1("d_head_vip")).g())) {
                    drawable = URLDrawable.getDrawable(aVar.f184872d, obtain);
                } else {
                    drawable = URLDrawable.getDrawable(aVar.f184871c, obtain);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(DailySignInWebviewPlugin.TAG, 2, "use custom icon=" + aVar.f184871c);
                }
            }
            uRLImageView.setImageDrawable(drawable);
        } else {
            f1(uRLImageView, m1(22.0f));
            if (uRLImageView.getDrawable() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                uRLImageView.setImageDrawable(drawable);
            }
        }
        TextView textView = this.f154304n0;
        if (textView != null) {
            textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.f154304n0.setText(aVar.f184873e);
        }
        this.L.post(new Runnable() { // from class: com.tencent.mobileqq.QQSettingMeView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeView.this.c1();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        this.f154302l0.clearRedTouch();
        this.f154303m0.w();
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void y(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) appInfo);
            return;
        }
        QQSettingMeBizBean qQSettingMeBizBean = com.tencent.mobileqq.qqsettingme.a.C.get(str);
        if (qQSettingMeBizBean != null && qQSettingMeBizBean.m().getVisibility() == 0) {
            try {
                C1(str, appInfo);
                t1(qQSettingMeBizBean);
            } catch (Exception e16) {
                QLog.e("QQSettingMeView", 1, "updateDrawerRedTouch error: ", str, ", ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqsettingme.a
    public void z(com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
        QQSettingMeBizBean qQSettingMeBizBean;
        View m3;
        CharSequence charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null || (qQSettingMeBizBean = com.tencent.mobileqq.qqsettingme.a.C.get(bVar.f184875a)) == null || (m3 = qQSettingMeBizBean.m()) == null) {
            return;
        }
        RedTouchTextView redTouchTextView = (RedTouchTextView) m3.findViewById(R.id.umj);
        if (qQSettingMeBizBean.r() != null) {
            charSequence = qQSettingMeBizBean.r().f184991a;
        } else {
            charSequence = "";
        }
        String str = bVar.f184875a;
        if (!TextUtils.isEmpty(bVar.f184876b)) {
            charSequence = bVar.f184876b;
        }
        CharSequence d16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.d(str, charSequence);
        if (!TextUtils.isEmpty(d16)) {
            redTouchTextView.setText(d16);
            redTouchTextView.c();
        }
        AccessibilityUtil.c(m3, redTouchTextView.getText(), Button.class.getName());
        URLImageView uRLImageView = (URLImageView) m3.findViewById(R.id.umf);
        if (bVar.f184877c != null && !QQTheme.isNowThemeIsSuperTheme()) {
            if (!QQTheme.isNowSimpleUI()) {
                uRLImageView.setImageDrawable(bVar.f184877c);
                E1(uRLImageView, R.color.qq_setting_me_nightmode_color_white, R.color.qui_common_icon_primary);
                return;
            }
            return;
        }
        DrawerUtils.m(uRLImageView, qQSettingMeBizBean);
    }
}

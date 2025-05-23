package com.tencent.mobileqq.activity.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statustitle.OnTitleAreaHeadClick;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.upgrade.n;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002'\u0018B\u0013\b\u0016\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bI\u0010JB\u001d\b\u0016\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u00a2\u0006\u0004\bI\u0010MB%\b\u0016\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\u0006\u0010N\u001a\u00020\b\u00a2\u0006\u0004\bI\u0010OJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\fJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\nJ\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\bH\u0017J$\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010'\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0006J\u0012\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u00100\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u00020.J\u0006\u00101\u001a\u00020\fJ\u000e\u00103\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0006J\u0006\u00104\u001a\u00020\fJ\u0006\u00105\u001a\u00020\fJ\u0006\u00106\u001a\u00020\fJ\u0006\u00107\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u00108R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010BR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010<R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/activity/home/view/TitleAreaHeadLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "Landroid/view/View$OnClickListener;", "", h.F, "", "d", "", "g", "Landroid/view/View;", "leftLayout", "", "setLeftLayout", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/activity/home/view/TitleAreaHeadLayout$a;", "callback", "i", "destroy", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "c", "e", "f", "b", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "isConversation", "l", "", "progress", "J", "visibility", "setVisibility", "scene", "extraLog", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "a", "currentTabName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "tabRedTypeInfo", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "redTouchManager", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "uin", "k", "setEnableFrame", "o", DomainData.DOMAIN_NAME, "j", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/activity/home/view/TitleAreaHeadLayout$a;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "qqProAvatarView", "Landroid/view/View;", "headHitHot", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "headRedTouch", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "headRedBadge", BdhLogUtil.LogTag.Tag_Conn, "D", "Z", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TitleAreaHeadLayout extends RelativeLayout implements IGuildLayoutApi.d, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View leftLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isConversation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QBaseActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProAvatarView qqProAvatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View headHitHot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RedTouch headRedTouch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TianshuRedTouch headRedBadge;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/activity/home/view/TitleAreaHeadLayout$a;", "", "", "H", "", "G", "", "I", "Lmqq/app/AppRuntime;", "getApp", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
        int G();

        void H();

        @NotNull
        String I();

        @NotNull
        AppRuntime getApp();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/activity/home/view/TitleAreaHeadLayout$b;", "", "", "AVATAR_BORDER_SIZE", UserInfo.SEX_FEMALE, "", "SCENE_CHATS_PULL_ANIM", "Ljava/lang/String;", "SCENE_INIT_UI", "SCENE_LOGIN_ANIM", "SCENE_QCIRCLE", "SCENE_SPRING_HB", "SCENE_TAB_CHANGED", "SCENE_TAB_CHANGED_NOT_LEBA", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout$b, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/home/view/TitleAreaHeadLayout$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f183167d;

        c(View view) {
            this.f183167d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimationSet animationSet = new AnimationSet(true);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.2f, 1.3f, 1.2f, 1, 0.5f, 1, 0.5f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.6f, 0.5f);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(30L);
            animationSet.setFillAfter(true);
            this.f183167d.startAnimation(animationSet);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TitleAreaHeadLayout(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.isConversation = true;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final String d() {
        a aVar = this.callback;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            aVar = null;
        }
        return "currentTabName:" + aVar.I();
    }

    private final boolean h() {
        if (this.headRedTouch == null && this.headRedBadge == null) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void setVisibility$default(TitleAreaHeadLayout titleAreaHeadLayout, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = null;
        }
        titleAreaHeadLayout.setVisibility(i3, str, str2);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.d
    public void J(float progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(progress));
            return;
        }
        if (this.isConversation) {
            float f16 = progress / 100.0f;
            setTranslationX((-(g() + getWidth())) * f16);
            setAlpha(1 - f16);
            if (getAlpha() == 0.0f) {
                z16 = true;
            }
            if (z16) {
                QLog.i("TitleAreaHeadLayout", 1, "onProgressUpdated  mHeadRoot is not visible, translationX:" + getTranslationX());
                return;
            }
            return;
        }
        setTranslationX(0.0f);
        setAlpha(1.0f);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        h();
        if (getAnimation() == null) {
            return;
        }
        getAnimation().cancel();
        clearAnimation();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (TianshuRedTouch.INSTANCE.j()) {
            TianshuRedTouch tianshuRedTouch = this.headRedBadge;
            if (tianshuRedTouch != null && tianshuRedTouch.Q()) {
                return true;
            }
        } else {
            RedTouch redTouch = this.headRedTouch;
            if (redTouch != null && redTouch.hasRedTouch()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final QQProAvatarView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QQProAvatarView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.qqProAvatarView;
    }

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        View view = this.headHitHot;
        if (view != null) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
        }
    }

    @Nullable
    public final View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.headHitHot;
    }

    @Nullable
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (TianshuRedTouch.INSTANCE.j()) {
            return this.headRedBadge;
        }
        return this.headRedTouch;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        View view = this.leftLayout;
        if (view == null) {
            return 0;
        }
        Intrinsics.checkNotNull(view);
        return view.getWidth();
    }

    public final void i(@NotNull QBaseActivity activity, @NotNull a callback) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.activity = activity;
        this.callback = callback;
        this.qqProAvatarView = (QQProAvatarView) activity.findViewById(R.id.conversation_head);
        View findViewById = activity.findViewById(R.id.f164912ba1);
        this.headHitHot = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        if (j()) {
            setVisibility(8, "init_ui", d());
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, MainResourceConfig.INSTANCE.e().n(activity), 0, 0);
                setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        a aVar = this.callback;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            aVar = null;
        }
        String I = aVar.I();
        if (!Intrinsics.areEqual(QzoneFrame.class.getName(), I) && !Intrinsics.areEqual(QCircleFrame.class.getName(), I)) {
            Class<? extends Frame> metaDreamFrameClass = ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass();
            Intrinsics.checkNotNull(metaDreamFrameClass);
            if (!Intrinsics.areEqual(metaDreamFrameClass.getName(), I)) {
                return false;
            }
        }
        return true;
    }

    public final void k(@NotNull String uin) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QQProAvatarView qQProAvatarView = this.qqProAvatarView;
        if (qQProAvatarView != null) {
            if (MainResourceConfig.INSTANCE.i()) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            qQProAvatarView.setEnableFrame(ViewUtils.dpToPx(f16), getResources().getColor(R.color.qui_common_border_superlight, null));
            qQProAvatarView.x(1, uin, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(uin)).h(true).a());
            qQProAvatarView.setAsyncUpdate(true);
        }
    }

    public final void l(boolean isConversation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, isConversation);
        } else {
            this.isConversation = isConversation;
            J(GuildSlideCoordinator.n());
        }
    }

    public final void m(@NotNull String currentTabName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) currentTabName);
            return;
        }
        Intrinsics.checkNotNullParameter(currentTabName, "currentTabName");
        QLog.i("TitleAreaHeadLayout", 1, "onResume  mHeadRoot visibility:" + getVisibility() + ", alpha:" + getAlpha() + ", translationX:" + getTranslationX() + ", translationY:" + getTranslationY() + ", currentTabName:" + currentTabName);
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        View f16 = f();
        if ((f16 == null && (f16 = this.qqProAvatarView) == null) || f16.getAnimation() == null) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(100L);
        animationSet.setFillAfter(false);
        f16.startAnimation(animationSet);
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        View f16 = f();
        if (f16 == null && (f16 = this.qqProAvatarView) == null) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.6f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(120L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new c(f16));
        f16.startAnimation(animationSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onAttachedToWindow();
            GuildSlideCoordinator.k(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        int i3;
        int i16;
        int i17;
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) v3);
        } else {
            a aVar2 = this.callback;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                aVar2 = null;
            }
            AppRuntime app = aVar2.getApp();
            Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) app;
            a aVar3 = this.callback;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                aVar3 = null;
            }
            aVar3.H();
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).checkZPlanAvatarUpdate();
            a aVar4 = this.callback;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                aVar4 = null;
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "Setting_tab", "My_settab", aVar4.G(), 0, "", "", "", "");
            RedTouch redTouch = this.headRedTouch;
            if (redTouch != null && redTouch.hasRedTouch()) {
                if (n.i()) {
                    a aVar5 = this.callback;
                    if (aVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                        aVar5 = null;
                    }
                    i3 = 1;
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004DAF", "0X8004DAF", aVar5.G(), 0, "", "", k.g(), "");
                } else {
                    i3 = 1;
                }
                i16 = i3;
            } else {
                i3 = 1;
                i16 = 0;
            }
            TianshuRedTouch tianshuRedTouch = this.headRedBadge;
            if (tianshuRedTouch != null && tianshuRedTouch.Q()) {
                if (n.i()) {
                    a aVar6 = this.callback;
                    if (aVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                        aVar = null;
                    } else {
                        aVar = aVar6;
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004DAF", "0X8004DAF", aVar.G(), 0, "", "", k.g(), "");
                }
                tianshuRedTouch.x();
                i16 = i3;
            }
            boolean z16 = i16;
            if (z16 != 0) {
                i17 = i3;
            } else {
                i17 = 2;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A980", "0X800A980", i17, 0, "0", "0", "", "");
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800ABB0", "0X800ABB0", VipInfoHandler.J2(qQAppInterface, qQAppInterface.getCurrentUin(), z16), 0, "0", "0", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X80072D5", "0X80072D5", 0, 0, "", "", "", "");
            if (z16 != 0) {
                ((IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "")).reportLevelZeroRedInfo(i3, 31);
            }
            SimpleEventBus.getInstance().dispatchEvent(new OnTitleAreaHeadClick(z16));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onDetachedFromWindow();
            GuildSlideCoordinator.v(this);
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (j()) {
            setVisibility(8, "tab_change", d());
            return;
        }
        ILebaFrameApi iLebaFrameApi = (ILebaFrameApi) QRoute.api(ILebaFrameApi.class);
        a aVar = this.callback;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            aVar = null;
        }
        if (!iLebaFrameApi.isLeba(aVar.I())) {
            setVisibility(0, "tab_change_not_leba", d());
        }
    }

    public final void q(@Nullable BusinessInfoCheckUpdate.RedTypeInfo tabRedTypeInfo, @NotNull IRedTouchManager redTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) tabRedTypeInfo, (Object) redTouchManager);
            return;
        }
        Intrinsics.checkNotNullParameter(redTouchManager, "redTouchManager");
        QBaseActivity qBaseActivity = null;
        a aVar = null;
        boolean z16 = true;
        if (TianshuRedTouch.INSTANCE.j()) {
            if (this.headRedBadge == null && this.qqProAvatarView != null) {
                QBaseActivity qBaseActivity2 = this.activity;
                if (qBaseActivity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    qBaseActivity2 = null;
                }
                QQProAvatarView qQProAvatarView = this.qqProAvatarView;
                Intrinsics.checkNotNull(qQProAvatarView);
                this.headRedBadge = new TianshuRedTouch(qBaseActivity2, qQProAvatarView).h0(53).t();
            }
            a aVar2 = this.callback;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                aVar = aVar2;
            }
            AppRuntime app = aVar.getApp();
            Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) app;
            if (tabRedTypeInfo != null) {
                IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IR\u2026nt.MAIN\n                )");
                ((IRedTouchManager) runtimeService).reportLevelZeroRedInfo(1, 30);
            }
            TianshuRedTouch tianshuRedTouch = this.headRedBadge;
            if (tianshuRedTouch != null) {
                tianshuRedTouch.B0(tabRedTypeInfo);
            }
        } else {
            if (this.headRedTouch == null && this.qqProAvatarView != null) {
                QBaseActivity qBaseActivity3 = this.activity;
                if (qBaseActivity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                } else {
                    qBaseActivity = qBaseActivity3;
                }
                this.headRedTouch = new RedTouch(qBaseActivity, this.qqProAvatarView).setGravity(53).applyTo();
            }
            RedTouch redTouch = this.headRedTouch;
            if (redTouch != null) {
                redTouch.parseRedTouch(tabRedTypeInfo);
            }
            redTouchManager.reportLevelZeroRedInfo(1, 30);
        }
        RedTouch redTouch2 = this.headRedTouch;
        if (redTouch2 == null || !redTouch2.hasRedTouch()) {
            z16 = false;
        }
        if (z16) {
            View view = this.headHitHot;
            if (view != null) {
                view.setContentDescription(HardCodeUtil.qqStr(R.string.f1642625c));
                return;
            }
            return;
        }
        View view2 = this.headHitHot;
        if (view2 != null) {
            view2.setContentDescription(HardCodeUtil.qqStr(R.string.f1642525b));
        }
    }

    public final void setEnableFrame() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        QQProAvatarView qQProAvatarView = this.qqProAvatarView;
        if (qQProAvatarView != null) {
            if (MainResourceConfig.INSTANCE.i()) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            qQProAvatarView.setEnableFrame(ViewUtils.dpToPx(f16), getResources().getColor(R.color.qui_common_border_superlight, null));
        }
    }

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams params) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) params);
            return;
        }
        super.setLayoutParams(params);
        if (params instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) params;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null && (i3 = marginLayoutParams.topMargin) > 0) {
            QLog.i("TitleAreaHeadLayout", 1, "setLayoutParams  params margin top=" + i3);
        }
    }

    public final void setLeftLayout(@NotNull View leftLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) leftLayout);
        } else {
            Intrinsics.checkNotNullParameter(leftLayout, "leftLayout");
            this.leftLayout = leftLayout;
        }
    }

    @JvmOverloads
    public final void setVisibility(int i3, @NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3, (Object) scene);
        } else {
            Intrinsics.checkNotNullParameter(scene, "scene");
            setVisibility$default(this, i3, scene, null, 4, null);
        }
    }

    @Override // android.view.View
    @Deprecated(message = "\u4f7f\u7528\u4e0b\u9762\u4e24\u4e2a\u53c2\u6570\u7684\u65b9\u6cd5\uff0c\u6dfb\u52a0\u4f7f\u7528\u573a\u666f\u63cf\u8ff0")
    public void setVisibility(int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, visibility);
            return;
        }
        super.setVisibility(visibility);
        QLog.i("TitleAreaHeadLayout", 1, "illegal setVisibility:" + visibility + " \n" + Log.getStackTraceString(new Throwable()));
    }

    public TitleAreaHeadLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.isConversation = true;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    @JvmOverloads
    public final void setVisibility(int visibility, @NotNull String scene, @Nullable String extraLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(visibility), scene, extraLog);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        super.setVisibility(visibility);
        QLog.i("TitleAreaHeadLayout", 1, "setVisibility:" + visibility + ", scene:" + scene + ", extraLog->" + extraLog);
    }

    public TitleAreaHeadLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.isConversation = true;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}

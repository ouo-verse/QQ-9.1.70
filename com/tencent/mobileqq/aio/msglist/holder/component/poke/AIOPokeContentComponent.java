package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.PokeMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOMsgPokeProcessor;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.SixCombolEffectView;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.ar;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.api.IPokeApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOHapticApi;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.BitmapUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002VWB\u000f\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\u0003H\u0002J\b\u0010%\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020\u0003H\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020\u0003H\u0002J\b\u0010)\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020\u0003H\u0002J\b\u0010-\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0002J\b\u00101\u001a\u00020\bH\u0002J&\u00106\u001a\u00020\u00032\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u00108\u001a\u000207H\u0016J\u0010\u0010;\u001a\u0002072\u0006\u0010:\u001a\u000209H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>H\u0016J\b\u0010A\u001a\u00020\u0003H\u0016J\n\u0010B\u001a\u0004\u0018\u000107H\u0016R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/PokeMsgItem;", "", "u2", "", "", "payloads", "", ICustomDataEditor.STRING_PARAM_2, "p2", "t2", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/SixCombolEffectView;", "sixCombolEffectView", ICustomDataEditor.STRING_ARRAY_PARAM_2, "j2", "v2", "q2", "w2", "i2", "isClick", Constants.BASE_IN_PLUGIN_VERSION, "f2", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/CustomFrameAnimationDrawable;", "drawable", "g2", "e2", "K2", "pointToLeft", "isEgg", "P2", "H2", "z2", "U1", "X1", "Y1", "k2", "I2", ICustomDataEditor.NUMBER_PARAM_2, "m2", "M2", "x2", "y2", "r2", "Landroid/graphics/drawable/Drawable;", "d2", "", "curMsgSeq", "B2", "C2", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "Landroid/view/View;", "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/w;", "Z1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e1", "Lp81/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "c2", "()Lp81/j;", "binding", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "animationStrength", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/SixCombolEffectView$p;", "D", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/SixCombolEffectView$p;", "sixAnimationListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "b", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOPokeContentComponent extends BaseContentComponent<PokeMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float animationStrength;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final SixCombolEffectView.p sixAnimationListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeContentComponent$a;", "", "", "EFFECT_NAME_BIXIN_LIGHT", "Ljava/lang/String;", "EFFECT_NAME_HEART_BROKEN", "EFFECT_NAME_HI_TOGHTER", "EFFECT_NAME_LIKE_NEW", "EFFECT_NAME_POKE_NEW", "", "FEE_TYPE_SVIP", "I", "FEE_TYPE_VIP", "", "MARGIN_DIFF", UserInfo.SEX_FEMALE, "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeContentComponent$b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", WadlProxyConsts.PARAM_FILENAME, "", "b", "I", "()I", "setNum", "(I)V", WidgetCacheConstellationData.NUM, "<init>", "(Ljava/lang/String;I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String fileName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int num;

        public b(@NotNull String fileName, int i3) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fileName, i3);
            } else {
                this.fileName = fileName;
                this.num = i3;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.fileName;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.num;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeContentComponent$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeContentComponent.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            AIOPokeContentComponent.this.c2().f425761d.setVisibility(8);
            AIOPokeContentComponent.this.c2().f425762e.setVisibility(0);
            AIOPokeContentComponent.this.c2().f425767j.clearAnimation();
            AIOPokeContentComponent.this.c2().f425767j.setVisibility(8);
            if (!AIOPokeContentComponent.T1(AIOPokeContentComponent.this).isSelf() && AIOPokeContentComponent.T1(AIOPokeContentComponent.this).q2()) {
                AIOPokeContentComponent.this.c2().f425765h.setVisibility(0);
            }
            AIOPokeContentComponent.T1(AIOPokeContentComponent.this).x2();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            super.onAnimationStart(animation);
            a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
            if (((IAIOPokeApi) companion.a(IAIOPokeApi.class)).isVasPokeShockSupport()) {
                ((IAIOHapticApi) companion.a(IAIOHapticApi.class)).playEffect(String.valueOf(AIOPokeContentComponent.T1(AIOPokeContentComponent.this).p2()), 2);
            }
            AIOPokeContentComponent aIOPokeContentComponent = AIOPokeContentComponent.this;
            aIOPokeContentComponent.sendIntent(new d.ax(AIOPokeContentComponent.T1(aIOPokeContentComponent).p2(), AIOPokeContentComponent.T1(AIOPokeContentComponent.this).isSelf()));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOPokeContentComponent(@NotNull final Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<p81.j>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeContentComponent$binding$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final p81.j invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (p81.j) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    p81.j g16 = p81.j.g(LayoutInflater.from(this.$context), null, false);
                    Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
                    return g16;
                }
            });
            this.binding = lazy;
            this.animationStrength = 1.0f;
            this.sixAnimationListener = new SixCombolEffectView.p() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.o
                @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.SixCombolEffectView.p
                public final void end() {
                    AIOPokeContentComponent.J2(AIOPokeContentComponent.this);
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(AIOPokeContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c2().f425761d.clearAnimation();
        this$0.c2().f425761d.setVisibility(8);
        this$0.c2().f425761d.setImageDrawable(null);
        this$0.c2().f425762e.setVisibility(0);
        if (this$0.q1().q2() && !this$0.q1().isSelf()) {
            this$0.c2().f425765h.setVisibility(0);
        } else {
            this$0.c2().f425765h.setVisibility(8);
        }
        this$0.c2().f425767j.clearAnimation();
        this$0.c2().f425767j.setVisibility(8);
    }

    private final boolean B2(long curMsgSeq) {
        d.j jVar = new d.j(0L, 1, null);
        sendIntent(jVar);
        if (curMsgSeq >= jVar.a()) {
            return true;
        }
        return false;
    }

    private final boolean C2() {
        if (!q1().s2() && (q1().isSelf() || B2(q1().getMsgSeq()))) {
            return true;
        }
        return false;
    }

    private final boolean D2(boolean isClick) {
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        if (((IAIOPokeApi) companion.a(IAIOPokeApi.class)).isBigResReady()) {
            return false;
        }
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425762e.setVisibility(0);
        if (isClick) {
            QQToast.makeText(getMContext(), 0, R.string.ysk, 0).show();
        } else {
            c2().f425767j.clearAnimation();
            c2().f425767j.setVisibility(8);
        }
        ((IAIOPokeApi) companion.a(IAIOPokeApi.class)).considerGetPokeBigRes(MobileQQ.sMobileQQ.peekAppRuntime());
        q1().x2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(AIOPokeContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C1();
        this$0.H2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(AIOPokeContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOElementType.b bVar = new AIOElementType.b(0, 0, null, 0, null, null, 0, 0, null, null, 0, 0, null, 0, 0, null, null, 0, 0, 0, null, 0, 0, 8388607, null);
        Integer num = this$0.q1().k2().pokeType;
        Intrinsics.checkNotNullExpressionValue(num, "mCurrentMsgItem.faceElement.pokeType");
        bVar.F(num.intValue());
        String string = this$0.getMContext().getString(R.string.ysl);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026aio_poke_old_version_str)");
        bVar.C(string);
        if (bVar.p() == 126) {
            String str = this$0.q1().k2().vaspokeName;
            Intrinsics.checkNotNullExpressionValue(str, "mCurrentMsgItem.faceElement.vaspokeName");
            bVar.c0(str);
            Integer num2 = this$0.q1().k2().vaspokeId;
            Intrinsics.checkNotNullExpressionValue(num2, "mCurrentMsgItem.faceElement.vaspokeId");
            bVar.a0(num2.intValue());
            String str2 = this$0.q1().k2().vaspokeMinver;
            Intrinsics.checkNotNullExpressionValue(str2, "mCurrentMsgItem.faceElement.vaspokeMinver");
            bVar.b0(str2);
            String str3 = this$0.q1().k2().spokeSummary;
            Intrinsics.checkNotNullExpressionValue(str3, "mCurrentMsgItem.faceElement.spokeSummary");
            bVar.N(str3);
        }
        this$0.sendIntent(new d.aq(bVar));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H2() {
        CustomFrameAnimationDrawable p16;
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "poke onClick() is called, type:" + q1().o2());
        }
        if (w2() || D2(true)) {
            return;
        }
        ae aeVar = ae.f191631a;
        b q16 = aeVar.q(q1().o2(), q1().isSelf());
        String a16 = q16.a();
        int b16 = q16.b();
        String v3 = aeVar.v(q1().o2());
        if (q1().o2() != 1 && q1().o2() > 0 && q1().o2() <= 6) {
            Resources resources = getMContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "mContext.resources");
            p16 = aeVar.o(resources, q1(), a16, b16, v3);
        } else {
            Resources resources2 = getMContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "mContext.resources");
            p16 = aeVar.p(resources2, q1(), v3);
        }
        z2(p16);
        if (q1().o2() != 6) {
            X1(p16);
        } else {
            U1();
        }
    }

    private final void I2() {
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425762e.setVisibility(0);
        if (q1().q2() && !q1().isSelf()) {
            c2().f425765h.setVisibility(0);
        } else {
            c2().f425765h.setVisibility(8);
        }
        c2().f425767j.clearAnimation();
        if (c2().f425767j.x()) {
            c2().f425767j.setParams(!q1().isSelf());
        }
        c2().f425767j.setVisibility(8);
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[showed]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(AIOPokeContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c2().f425762e.setVisibility(0);
        this$0.c2().f425767j.setVisibility(8);
        if (this$0.q1().q2() && !this$0.q1().isSelf()) {
            this$0.c2().f425765h.setVisibility(0);
        } else {
            this$0.c2().f425765h.setVisibility(8);
        }
        this$0.c2().f425763f.setVisibility(8);
        this$0.q1().x2();
    }

    private final void K2(CustomFrameAnimationDrawable drawable) {
        c2().f425761d.setVisibility(0);
        c2().f425762e.setVisibility(8);
        c2().f425765h.setVisibility(8);
        c2().f425767j.clearAnimation();
        c2().f425767j.setVisibility(8);
        drawable.x(new CustomFrameAnimationDrawable.a() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.p
            @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.a
            public final void onEnd() {
                AIOPokeContentComponent.L2(AIOPokeContentComponent.this);
            }
        });
        c2().f425761d.setImageDrawable(drawable);
        drawable.y();
        if (q1().r2()) {
            int o26 = q1().o2();
            if (o26 != 2) {
                if (o26 != 3) {
                    if (o26 == 4) {
                        sendIntent(d.av.f192328d);
                    }
                } else {
                    sendIntent(d.ay.f192332d);
                }
            } else {
                sendIntent(new d.aw(q1().isSelf()));
            }
        }
        if (q1().o2() == 1 || q1().o2() == 0) {
            P2(q1().isSelf(), q1().r2());
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[status]start to play");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L2(AIOPokeContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c2().f425761d.clearAnimation();
        this$0.c2().f425761d.setVisibility(8);
        this$0.c2().f425761d.setImageDrawable(null);
        this$0.c2().f425762e.setVisibility(0);
        if (this$0.q1().q2() && !this$0.q1().isSelf()) {
            this$0.c2().f425765h.setVisibility(0);
        } else {
            this$0.c2().f425765h.setVisibility(8);
        }
        this$0.c2().f425767j.clearAnimation();
        this$0.c2().f425767j.setVisibility(8);
        this$0.q1().x2();
    }

    private final void M2() {
        c2().f425767j.setVisibility(0);
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425762e.setVisibility(8);
        c2().f425765h.setVisibility(8);
        c2().f425762e.clearAnimation();
        c2().f425767j.setEndListener(new AIOPokeGreatMoveView.g() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.s
            @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView.g
            public final void end() {
                AIOPokeContentComponent.N2(AIOPokeContentComponent.this);
            }
        });
        if (QLog.isColorLevel()) {
            QLog.i("fangdazhao", 2, "[start]");
        }
        c2().f425767j.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N2(AIOPokeContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("AIOPokeContentComponent", 2, "HIDE_PLACEHOLDER Unlimited 2");
        }
        this$0.c2().f425761d.clearAnimation();
        this$0.c2().f425761d.setVisibility(8);
        this$0.c2().f425761d.setImageDrawable(null);
        this$0.c2().f425762e.setVisibility(0);
        if (this$0.q1().q2() && !this$0.q1().isSelf()) {
            this$0.c2().f425765h.setVisibility(0);
        } else {
            this$0.c2().f425765h.setVisibility(8);
        }
        this$0.c2().f425767j.clearAnimation();
        this$0.c2().f425767j.setVisibility(8);
        this$0.q1().x2();
    }

    private final void P2(final boolean pointToLeft, final boolean isEgg) {
        if (QLog.isColorLevel()) {
            QLog.d("PokeItemBuilder", 2, "startPokeWindowAnim " + pointToLeft);
        }
        if (!(getMContext() instanceof Activity)) {
            return;
        }
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        final Activity activity = (Activity) mContext;
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.t
            @Override // java.lang.Runnable
            public final void run() {
                AIOPokeContentComponent.Q2(activity, isEgg, pointToLeft);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q2(Activity act, boolean z16, boolean z17) {
        AnimationSet s16;
        Intrinsics.checkNotNullParameter(act, "$act");
        if (!act.isDestroyed() && !act.isFinishing()) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeContentComponent", 2, "start to shake");
            }
            if (z16) {
                s16 = ae.f191631a.t(z17);
            } else {
                s16 = ae.f191631a.s(z17);
            }
            ae.f191631a.A(act, s16);
        }
    }

    public static final /* synthetic */ PokeMsgItem T1(AIOPokeContentComponent aIOPokeContentComponent) {
        return aIOPokeContentComponent.q1();
    }

    private final void U1() {
        if (((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).isBigResReady() && !c2().f425767j.x()) {
            c2().f425767j.v(getMContext(), !q1().isSelf(), ae.f191631a.w(), new AIOPokeGreatMoveView.f() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.u
                @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView.f
                public final void a(long j3, boolean z16, Runnable runnable) {
                    AIOPokeContentComponent.W1(AIOPokeContentComponent.this, j3, z16, runnable);
                }
            });
        }
        c2().f425767j.setParams(!q1().isSelf());
        c2().f425767j.setMirror(!q1().isSelf());
        c2().f425767j.setVisibility(0);
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425762e.setVisibility(8);
        c2().f425765h.setVisibility(8);
        c2().f425762e.clearAnimation();
        c2().f425767j.setEndListener(new AIOPokeGreatMoveView.g() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.v
            @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView.g
            public final void end() {
                AIOPokeContentComponent.V1(AIOPokeContentComponent.this);
            }
        });
        if (!q1().unlimitedState.f191471d) {
            if (QLog.isColorLevel()) {
                QLog.i("fangdazhao", 2, "[click]start to play");
            }
            c2().f425767j.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V1(AIOPokeContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("AIOPokeContentComponent", 2, "HIDE_PLACEHOLDER Unlimited 3");
        }
        this$0.c2().f425761d.clearAnimation();
        this$0.c2().f425761d.setVisibility(8);
        this$0.c2().f425761d.setImageDrawable(null);
        this$0.c2().f425762e.setVisibility(0);
        if (this$0.q1().q2() && !this$0.q1().isSelf()) {
            this$0.c2().f425765h.setVisibility(0);
        } else {
            this$0.c2().f425765h.setVisibility(8);
        }
        this$0.c2().f425767j.clearAnimation();
        this$0.c2().f425767j.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(AIOPokeContentComponent this$0, long j3, boolean z16, Runnable listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.c2().f425763f;
        Intrinsics.checkNotNullExpressionValue(listener, "listener");
        this$0.sendIntent(new d.au(j3, view, z16, listener));
    }

    private final void X1(CustomFrameAnimationDrawable drawable) {
        if (Y1()) {
            return;
        }
        c2().f425761d.setImageDrawable(drawable);
        c2().f425761d.setVisibility(0);
        c2().f425762e.setVisibility(8);
        c2().f425762e.clearAnimation();
        c2().f425765h.setVisibility(8);
        c2().f425767j.clearAnimation();
        c2().f425767j.setVisibility(8);
        if (q1().frameState.f191488d) {
            drawable.p();
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeContentComponent", 2, "[click] resume to play");
                return;
            }
            return;
        }
        drawable.y();
        if (q1().r2()) {
            int o26 = q1().o2();
            if (o26 != 2) {
                if (o26 != 3) {
                    if (o26 == 4) {
                        sendIntent(d.av.f192328d);
                    }
                } else {
                    sendIntent(d.ay.f192332d);
                }
            } else {
                sendIntent(new d.aw(q1().isSelf()));
            }
        }
        if (q1().o2() == 1 || q1().o2() == 0) {
            P2(q1().isSelf(), q1().r2());
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[click] start to play");
        }
    }

    private final boolean Y1() {
        if (q1().o2() != 5 || !q1().r2()) {
            return false;
        }
        c2().f425762e.setVisibility(8);
        c2().f425765h.setVisibility(8);
        d.C7328d c7328d = new d.C7328d(null);
        sendIntent(c7328d);
        SixCombolEffectView sixCombolEffectView = (SixCombolEffectView) c7328d.a();
        c2().f425763f.setVisibility(0);
        if (sixCombolEffectView != null) {
            sixCombolEffectView.setListener(this.sixAnimationListener);
        }
        if (sixCombolEffectView != null) {
            sixCombolEffectView.p(q1(), c2().f425763f);
            return true;
        }
        return true;
    }

    private final void a2(SixCombolEffectView sixCombolEffectView) {
        PokeMsgItem pokeMsgItem;
        PokeMsgItem q16 = q1();
        if (sixCombolEffectView != null) {
            pokeMsgItem = sixCombolEffectView.j();
        } else {
            pokeMsgItem = null;
        }
        if (Intrinsics.areEqual(q16, pokeMsgItem)) {
            int i3 = SixCombolEffectView.f191551l0;
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    this.sixAnimationListener.end();
                    return;
                } else {
                    this.sixAnimationListener.end();
                    return;
                }
            }
            c2().f425762e.setVisibility(8);
            c2().f425765h.setVisibility(8);
            c2().f425763f.setVisibility(0);
            return;
        }
        this.sixAnimationListener.end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p81.j c2() {
        return (p81.j) this.binding.getValue();
    }

    private final Drawable d2() {
        String pokeEffectRootPath = ((IPokeApi) QRoute.api(IPokeApi.class)).getPokeEffectRootPath(q1().p2());
        File file = new File(pokeEffectRootPath + "/pressed.png");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = getMContext().getResources().getDrawable(R.drawable.fsn);
        obtain.mLoadingDrawable = new ColorDrawable();
        obtain.mFailedDrawable = drawable;
        a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        FastDynamicDrawable a17 = a16.d(absolutePath).h(AIOPokeContentComponent$getVasStaticDrawable$pressed$1.INSTANCE).a();
        File file2 = new File(pokeEffectRootPath + IAIOPokeApi.VAS_POKE_RES_NORMAL);
        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
        obtain2.mLoadingDrawable = drawable;
        obtain2.mFailedDrawable = drawable;
        obtain2.mUseApngImage = true;
        a.C1005a a18 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath2 = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "file.absolutePath");
        FastDynamicDrawable a19 = a18.d(absolutePath2).h(AIOPokeContentComponent$getVasStaticDrawable$normal$1.INSTANCE).a();
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, a17);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, a19);
        stateListDrawable.addState(new int[0], a19);
        c2().f425766i.setImageDrawable(stateListDrawable);
        c2().f425766i.setContentDescription(ar.b(ar.f194115a, q1().k2(), false, 2, null));
        return a19;
    }

    private final void e2() {
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425762e.setVisibility(0);
        if (q1().q2() && !q1().isSelf()) {
            c2().f425765h.setVisibility(0);
        } else {
            c2().f425765h.setVisibility(8);
        }
        c2().f425767j.clearAnimation();
        c2().f425767j.setVisibility(8);
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[status] played");
        }
        q1().x2();
    }

    private final void f2() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[status]has already played");
        }
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425762e.setVisibility(0);
        if (q1().q2() && !q1().isSelf() && q1().o2() != 126) {
            c2().f425765h.setVisibility(0);
        } else {
            c2().f425765h.setVisibility(8);
        }
        c2().f425767j.clearAnimation();
        c2().f425767j.setVisibility(8);
    }

    private final void g2(CustomFrameAnimationDrawable drawable) {
        c2().f425761d.setVisibility(0);
        c2().f425762e.setVisibility(8);
        c2().f425765h.setVisibility(8);
        c2().f425762e.clearAnimation();
        c2().f425767j.clearAnimation();
        c2().f425767j.setVisibility(8);
        c2().f425761d.setImageDrawable(drawable);
        drawable.x(new CustomFrameAnimationDrawable.a() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.q
            @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.a
            public final void onEnd() {
                AIOPokeContentComponent.h2(AIOPokeContentComponent.this);
            }
        });
        drawable.p();
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[status]playing");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(AIOPokeContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c2().f425761d.clearAnimation();
        this$0.c2().f425761d.setVisibility(8);
        this$0.c2().f425761d.setImageDrawable(null);
        this$0.c2().f425762e.setVisibility(0);
        if (this$0.q1().q2() && !this$0.q1().isSelf()) {
            this$0.c2().f425765h.setVisibility(0);
        } else {
            this$0.c2().f425765h.setVisibility(8);
        }
        this$0.c2().f425767j.clearAnimation();
        this$0.c2().f425767j.setVisibility(8);
    }

    private final boolean i2() {
        boolean z16;
        if (c2().f425760c.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            IAIOPokeApi.Companion companion = IAIOPokeApi.INSTANCE;
            if (!companion.d().contains(Integer.valueOf(q1().p2()))) {
                companion.d().add(Integer.valueOf(q1().p2()));
            }
            if (!companion.c().contains(Integer.valueOf(q1().p2()))) {
                companion.c().add(Integer.valueOf(q1().p2()));
            }
            if (!companion.b().contains(Integer.valueOf(q1().p2()))) {
                companion.b().add(Integer.valueOf(q1().p2()));
            }
            c2().f425764g.setVisibility(0);
            c2().f425760c.setVisibility(8);
            q1().o2();
            ((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).downloadVasItem(q1().p2());
            return true;
        }
        if (((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).vasPokeResExist("bubble", q1().p2())) {
            return false;
        }
        QQToast.makeText(getMContext(), 0, R.string.yt6, 0).show();
        return true;
    }

    private final void j2() {
        if (SixCombolEffectView.f191551l0 > 0) {
            d.C7328d c7328d = new d.C7328d(null);
            sendIntent(c7328d);
            a2((SixCombolEffectView) c7328d.a());
            return;
        }
        this.sixAnimationListener.end();
    }

    private final void k2() {
        if (!C2() && !q1().unlimitedState.f191471d) {
            I2();
            return;
        }
        if (((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).isBigResReady()) {
            c2().f425767j.v(getMContext(), !q1().isSelf(), ae.f191631a.w(), new AIOPokeGreatMoveView.f() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.r
                @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView.f
                public final void a(long j3, boolean z16, Runnable runnable) {
                    AIOPokeContentComponent.l2(AIOPokeContentComponent.this, j3, z16, runnable);
                }
            });
        }
        if (q1().unlimitedState.f191471d) {
            n2();
        } else if (q1().unlimitedState.f191472e) {
            m2();
        } else {
            M2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(AIOPokeContentComponent this$0, long j3, boolean z16, Runnable listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.c2().f425763f;
        Intrinsics.checkNotNullExpressionValue(listener, "listener");
        this$0.sendIntent(new d.au(j3, view, z16, listener));
    }

    private final void m2() {
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425762e.setVisibility(0);
        if (q1().q2() && !q1().isSelf()) {
            c2().f425765h.setVisibility(0);
        } else {
            c2().f425765h.setVisibility(8);
        }
        c2().f425767j.clearAnimation();
        c2().f425767j.setVisibility(8);
        q1().x2();
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[show end]");
        }
    }

    private final void n2() {
        c2().f425767j.setVisibility(0);
        c2().f425761d.clearAnimation();
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425762e.setVisibility(8);
        c2().f425765h.setVisibility(8);
        c2().f425762e.clearAnimation();
        c2().f425767j.setMirror(!q1().isSelf());
        c2().f425767j.setEndListener(new AIOPokeGreatMoveView.g() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.m
            @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView.g
            public final void end() {
                AIOPokeContentComponent.o2(AIOPokeContentComponent.this);
            }
        });
        c2().f425767j.C(q1(), !q1().isSelf());
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeContentComponent", 2, "[resume]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(AIOPokeContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("AIOPokeContentComponent", 2, "HIDE_PLACEHOLDER Unlimited 1");
        }
        this$0.c2().f425761d.clearAnimation();
        this$0.c2().f425761d.setVisibility(8);
        this$0.c2().f425761d.setImageMatrix(null);
        this$0.c2().f425762e.setVisibility(0);
        if (this$0.q1().q2() && !this$0.q1().isSelf()) {
            this$0.c2().f425765h.setVisibility(0);
        } else {
            this$0.c2().f425765h.setVisibility(8);
        }
        this$0.c2().f425767j.clearAnimation();
        this$0.c2().f425767j.setVisibility(8);
    }

    private final void p2() {
        if (v2() || D2(false) || t2()) {
            return;
        }
        if (q1().o2() == 6) {
            k2();
        } else {
            q2();
        }
    }

    private final void q2() {
        CustomFrameAnimationDrawable p16;
        c2().f425767j.setVisibility(8);
        if (!C2() && !q1().frameState.f191488d) {
            f2();
            return;
        }
        ae aeVar = ae.f191631a;
        String v3 = aeVar.v(q1().o2());
        b q16 = aeVar.q(q1().o2(), q1().isSelf());
        String a16 = q16.a();
        int b16 = q16.b();
        if (q1().o2() != 1 && q1().o2() != 0 && q1().o2() <= 6) {
            Resources resources = getMContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "mContext.resources");
            p16 = aeVar.n(resources, q1(), v3, a16, b16);
        } else {
            Resources resources2 = getMContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "mContext.resources");
            p16 = aeVar.p(resources2, q1(), v3);
        }
        p16.t(1);
        if (!q1().isSelf()) {
            if (q1().o2() != 5) {
                p16.A();
            } else {
                p16.t(2);
            }
        }
        p16.w();
        if (q1().frameState.f191488d) {
            g2(p16);
        } else if (q1().frameState.f191492h) {
            e2();
        } else {
            K2(p16);
        }
    }

    private final void r2() {
        int dip2px = ScreenUtil.dip2px(this.animationStrength * 10.0f);
        ViewGroup.LayoutParams layoutParams = c2().f425761d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = ScreenUtil.dip2px(this.animationStrength * 90.0f);
        ae aeVar = ae.f191631a;
        marginLayoutParams.width = aeVar.r(q1().o2(), this.animationStrength);
        marginLayoutParams.topMargin = 0;
        marginLayoutParams.bottomMargin = 0;
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        c2().f425761d.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams2 = c2().f425767j.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.height = ScreenUtil.dip2px(this.animationStrength * 90.0f);
        c2().f425767j.setLayoutParams(marginLayoutParams2);
        ViewGroup.LayoutParams layoutParams3 = c2().f425763f.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
        marginLayoutParams3.width = ScreenUtil.dip2px(this.animationStrength * 90.0f);
        marginLayoutParams3.height = ScreenUtil.dip2px(this.animationStrength * 90.0f);
        c2().f425763f.setLayoutParams(marginLayoutParams3);
        ViewGroup.LayoutParams layoutParams4 = c2().f425766i.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
        marginLayoutParams4.width = ScreenUtil.dip2px(this.animationStrength * 80.0f);
        marginLayoutParams4.height = ScreenUtil.dip2px(this.animationStrength * 70.0f);
        marginLayoutParams4.topMargin = dip2px;
        marginLayoutParams4.bottomMargin = dip2px;
        marginLayoutParams4.leftMargin = 0;
        marginLayoutParams4.rightMargin = 0;
        c2().f425766i.setLayoutParams(marginLayoutParams4);
        ViewGroup.LayoutParams layoutParams5 = c2().f425762e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams5;
        if (q1().isSelf()) {
            marginLayoutParams5.leftMargin = 0;
            marginLayoutParams5.rightMargin = ScreenUtil.dip2px(this.animationStrength * 10.0f);
        } else {
            marginLayoutParams5.leftMargin = ScreenUtil.dip2px(this.animationStrength * 10.0f);
            marginLayoutParams5.rightMargin = 0;
        }
        c2().f425762e.setLayoutParams(marginLayoutParams5);
        if (q1().o2() != 3 && q1().o2() != 2) {
            float f16 = -dip2px;
            c2().f425762e.setTranslationY(f16);
            c2().f425761d.setTranslationY(f16);
            c2().f425767j.setTranslationY(f16);
            c2().f425765h.setTranslationY(f16);
        } else {
            c2().f425762e.setTranslationY(0.0f);
            c2().f425761d.setTranslationY(0.0f);
            c2().f425767j.setTranslationY(0.0f);
            c2().f425765h.setTranslationY(0.0f);
        }
        c2().f425766i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        c2().f425761d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        c2().f425766i.setScaleX(1.0f);
        c2().f425761d.setScaleX(1.0f);
        Bitmap decodeResourceStream = BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.c2x);
        Intrinsics.checkNotNullExpressionValue(decodeResourceStream, "decodeResourceStream(mCo\u2026ble.aio_quickback_normal)");
        Bitmap decodeResourceStream2 = BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.c2y);
        Intrinsics.checkNotNullExpressionValue(decodeResourceStream2, "decodeResourceStream(mCo\u2026le.aio_quickback_pressed)");
        StateListDrawable clickStateHalfAlpha = BitmapUtil.setClickStateHalfAlpha(getMContext().getResources(), decodeResourceStream, decodeResourceStream2);
        Intrinsics.checkNotNullExpressionValue(clickStateHalfAlpha, "setClickStateHalfAlpha(m\u2026sources, normal, pressed)");
        c2().f425765h.setImageDrawable(clickStateHalfAlpha);
        if (!q1().isSelf()) {
            if (q1().q2() && !q1().isSelf()) {
                c2().f425765h.setVisibility(0);
            } else {
                c2().f425765h.setVisibility(8);
            }
        }
        c2().f425766i.setImageDrawable(aeVar.u(q1().o2(), q1().isSelf(), getMContext().getResources()));
        c2().f425766i.setContentDescription(ar.b(ar.f194115a, q1().k2(), false, 2, null));
        c2().f425767j.w(q1(), this.animationStrength);
    }

    private final boolean s2(List<Object> payloads) {
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.POKE_TOGGLE_QUICK_BACK_PAYLOAD) != null) {
                    int i3 = 8;
                    if (c2().f425762e.getVisibility() == 8) {
                        return false;
                    }
                    ImageView imageView = c2().f425765h;
                    if (q1().q2()) {
                        i3 = 0;
                    }
                    imageView.setVisibility(i3);
                    return false;
                }
                if (map.get(AIOMsgItemPayloadType.POKE_VAS_PAYLOAD) != null) {
                    return true;
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final boolean t2() {
        if (q1().o2() != 5 || !q1().r2()) {
            return false;
        }
        c2().f425761d.setVisibility(8);
        c2().f425761d.setImageDrawable(null);
        c2().f425767j.setVisibility(8);
        if (C2()) {
            d.C7328d c7328d = new d.C7328d(null);
            sendIntent(c7328d);
            SixCombolEffectView sixCombolEffectView = (SixCombolEffectView) c7328d.a();
            if (SixCombolEffectView.f191551l0 == 0) {
                if (!AIOPokeAnimationVB.INSTANCE.a()) {
                    c2().f425762e.setVisibility(8);
                    c2().f425765h.setVisibility(8);
                    c2().f425763f.setVisibility(0);
                    if (sixCombolEffectView != null) {
                        sixCombolEffectView.setListener(this.sixAnimationListener);
                    }
                    if (sixCombolEffectView != null) {
                        sixCombolEffectView.p(q1(), c2().f425763f);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            a2(sixCombolEffectView);
            return true;
        }
        j2();
        return true;
    }

    private final void u2() {
        c2().f425764g.setVisibility(8);
        c2().f425765h.setVisibility(8);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(c2().getRoot());
        if (q1().isSelf()) {
            constraintSet.clear(R.id.f26190cv, 1);
            constraintSet.connect(R.id.f26190cv, 2, 0, 2);
            constraintSet.clear(R.id.f26180cu, 1);
            constraintSet.connect(R.id.f26180cu, 2, 0, 2);
        } else {
            constraintSet.clear(R.id.f26190cv, 2);
            constraintSet.connect(R.id.f26190cv, 1, 0, 1);
            constraintSet.clear(R.id.f26180cu, 2);
            constraintSet.connect(R.id.f26180cu, 1, 0, 1);
        }
        constraintSet.applyTo(c2().getRoot());
        if (q1().o2() == 126) {
            x2();
        } else {
            r2();
        }
    }

    private final boolean v2() {
        if (q1().o2() != 126) {
            return false;
        }
        c2().f425761d.setImageDrawable(null);
        c2().f425761d.setVisibility(8);
        c2().f425762e.setVisibility(0);
        c2().f425767j.clearAnimation();
        c2().f425767j.setVisibility(8);
        if (!q1().isSelf() && q1().q2() && !C2()) {
            c2().f425765h.setVisibility(0);
        }
        if (!q1().s2() && !c2().f425761d.isAnimating()) {
            ae aeVar = ae.f191631a;
            LottieAnimationView lottieAnimationView = c2().f425761d;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.pokeLottieAnimationView");
            aeVar.f(lottieAnimationView, c2(), q1().p2(), "bubble");
            return true;
        }
        return true;
    }

    private final boolean w2() {
        if (q1().o2() == 126) {
            if (i2()) {
                return true;
            }
            ae aeVar = ae.f191631a;
            LottieAnimationView lottieAnimationView = c2().f425761d;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.pokeLottieAnimationView");
            aeVar.f(lottieAnimationView, c2(), q1().p2(), "bubble");
            return true;
        }
        return false;
    }

    private final void x2() {
        int i3;
        StateListDrawable clickStateHalfAlpha;
        int dip2px = ScreenUtil.dip2px(this.animationStrength * 10.0f);
        ViewGroup.LayoutParams layoutParams = c2().f425761d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = ScreenUtil.dip2px(70.0f);
        marginLayoutParams.topMargin = ScreenUtil.dip2px(10.0f);
        marginLayoutParams.bottomMargin = ScreenUtil.dip2px(10.0f);
        if (q1().isSelf()) {
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.rightMargin = dip2px;
        } else {
            marginLayoutParams.leftMargin = dip2px;
            marginLayoutParams.rightMargin = 0;
        }
        c2().f425761d.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams2 = c2().f425766i.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.width = ScreenUtil.dip2px(70.0f);
        marginLayoutParams2.height = ScreenUtil.dip2px(70.0f);
        marginLayoutParams2.topMargin = ScreenUtil.dip2px(10.0f);
        marginLayoutParams2.bottomMargin = ScreenUtil.dip2px(10.0f);
        c2().f425766i.setLayoutParams(marginLayoutParams2);
        ViewGroup.LayoutParams layoutParams3 = c2().f425762e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (q1().isSelf()) {
            marginLayoutParams3.leftMargin = 0;
            marginLayoutParams3.rightMargin = dip2px;
        } else {
            marginLayoutParams3.leftMargin = dip2px;
            marginLayoutParams3.rightMargin = 0;
        }
        c2().f425762e.setLayoutParams(marginLayoutParams3);
        c2().f425762e.setTranslationY(0.0f);
        c2().f425761d.setTranslationY(0.0f);
        c2().f425767j.setTranslationY(0.0f);
        c2().f425765h.setTranslationY(0.0f);
        c2().f425761d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        c2().f425766i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        AIOMsgPokeProcessor.Companion companion = AIOMsgPokeProcessor.INSTANCE;
        if (companion.a().containsKey(Integer.valueOf(q1().p2()))) {
            Integer num = companion.a().get(Integer.valueOf(q1().p2()));
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            if (i3 != 4 && i3 != 5) {
                clickStateHalfAlpha = BitmapUtil.setClickStateHalfAlpha(getMContext().getResources(), BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.c2x), BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.c2y));
            } else {
                clickStateHalfAlpha = BitmapUtil.setClickStateHalfAlpha(getMContext().getResources(), BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.c2z), BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.f160205c30));
            }
            c2().f425765h.setImageDrawable(clickStateHalfAlpha);
        }
        if (q1().isSelf()) {
            c2().f425766i.setScaleX(1.0f);
            c2().f425761d.setScaleX(1.0f);
        } else {
            c2().f425766i.setScaleX(-1.0f);
            c2().f425761d.setScaleX(-1.0f);
        }
        Drawable d26 = d2();
        a.Companion companion2 = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        boolean z16 = !((IAIOPokeApi) companion2.a(IAIOPokeApi.class)).vasPokeResExist("bubble", q1().p2());
        boolean z17 = !((IAIOPokeApi) companion2.a(IAIOPokeApi.class)).vasPokeResExist(IAIOPokeApi.VAS_POKE_RES_NORMAL, q1().p2());
        if (z16 && z17) {
            y2();
        } else if (z16 || z17) {
            IAIOPokeApi.Companion companion3 = IAIOPokeApi.INSTANCE;
            if (!companion3.d().contains(Integer.valueOf(q1().p2())) && !companion3.c().contains(Integer.valueOf(q1().p2()))) {
                c2().f425760c.setVisibility(0);
            } else {
                c2().f425764g.setVisibility(0);
            }
        }
        c2().f425761d.setImageDrawable(d26);
    }

    private final void y2() {
        IAIOPokeApi.Companion companion = IAIOPokeApi.INSTANCE;
        if (companion.a().contains(Integer.valueOf(q1().p2()))) {
            if (!companion.d().contains(Integer.valueOf(q1().p2())) && !companion.c().contains(Integer.valueOf(q1().p2()))) {
                c2().f425760c.setVisibility(0);
                return;
            } else {
                c2().f425764g.setVisibility(0);
                return;
            }
        }
        companion.a().add(Integer.valueOf(q1().p2()));
        companion.d().add(Integer.valueOf(q1().p2()));
        companion.c().add(Integer.valueOf(q1().p2()));
        c2().f425764g.setVisibility(0);
        ((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).downloadVasItem(q1().p2());
    }

    private final void z2(CustomFrameAnimationDrawable drawable) {
        drawable.t(1);
        if (!q1().isSelf()) {
            if (q1().o2() != 5) {
                drawable.A();
            } else {
                drawable.t(2);
            }
        }
        drawable.w();
        drawable.x(new CustomFrameAnimationDrawable.a() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.l
            @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.a
            public final void onEnd() {
                AIOPokeContentComponent.A2(AIOPokeContentComponent.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public w createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (w) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new w();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!s2(payloads)) {
            return;
        }
        this.animationStrength = ae.f191631a.m(q1().n2());
        u2();
        p2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ConstraintLayout root = c2().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return c1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        c2().f425759b.setReferencedIds(new int[]{c2().f425761d.getId(), c2().f425762e.getId()});
        Bitmap decodeResourceStream = BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.c2x);
        Intrinsics.checkNotNullExpressionValue(decodeResourceStream, "decodeResourceStream(mCo\u2026ble.aio_quickback_normal)");
        Bitmap decodeResourceStream2 = BaseImageUtil.decodeResourceStream(getMContext().getResources(), R.drawable.c2y);
        Intrinsics.checkNotNullExpressionValue(decodeResourceStream2, "decodeResourceStream(mCo\u2026le.aio_quickback_pressed)");
        StateListDrawable clickStateHalfAlpha = BitmapUtil.setClickStateHalfAlpha(getMContext().getResources(), decodeResourceStream, decodeResourceStream2);
        Intrinsics.checkNotNullExpressionValue(clickStateHalfAlpha, "setClickStateHalfAlpha(m\u2026sources, normal, pressed)");
        c2().f425765h.setImageDrawable(clickStateHalfAlpha);
        c2().f425765h.setContentDescription(getMContext().getString(R.string.ysm));
        c2().f425761d.addAnimatorListener(new c());
        c2().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOPokeContentComponent.F2(AIOPokeContentComponent.this, view);
            }
        });
        c2().f425765h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOPokeContentComponent.G2(AIOPokeContentComponent.this, view);
            }
        });
        return super.onCreateView(createViewParams);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new com.tencent.qqnt.aio.menu.ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this)});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }
}

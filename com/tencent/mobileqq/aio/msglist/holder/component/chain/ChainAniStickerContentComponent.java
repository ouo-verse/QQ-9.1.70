package com.tencent.mobileqq.aio.msglist.holder.component.chain;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.anisticker.b;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.ag;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.aio.adapter.api.IAIOChainAniStickerApi;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import com.tencent.qqnt.aio.anisticker.view.e;
import com.tencent.qqnt.aio.exception.OperateViewOnSubThreadException;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.devices.api.IDevicesApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u000f\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020'H\u0016J&\u0010+\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020*2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/chain/ChainAniStickerContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/e;", "", "T1", "V1", "msgItem", "", "", "payloads", "", "S1", "X1", UIJsPlugin.EVENT_SHOW_LOADING, "W1", "Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem;", "Lcom/tencent/qqnt/aio/anisticker/view/e$a;", "Q1", "", "R1", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "lottieView", "Y1", "O1", "", "resultId", "d2", "P1", "path", "isSelf", "serverId", "L1", "Z1", "c2", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "randomLottieResultId", "D", "Landroid/view/View;", "fullscreenLottieAnimationView", "E", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", UserInfo.SEX_FEMALE, "I", "rootViewMargin", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChainAniStickerContentComponent extends BaseContentComponent<com.tencent.mobileqq.aio.msg.e> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String randomLottieResultId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View fullscreenLottieAnimationView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final AniStickerLottieView lottieView;

    /* renamed from: F, reason: from kotlin metadata */
    private final int rootViewMargin;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout rootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/chain/ChainAniStickerContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.chain.ChainAniStickerContentComponent$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/chain/ChainAniStickerContentComponent$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f190724d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChainAniStickerContentComponent f190725e;

        b(LottieAnimationView lottieAnimationView, ChainAniStickerContentComponent chainAniStickerContentComponent) {
            this.f190724d = lottieAnimationView;
            this.f190725e = chainAniStickerContentComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lottieAnimationView, (Object) chainAniStickerContentComponent);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            this.f190724d.setImageDrawable(null);
            this.f190725e.Z1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/chain/ChainAniStickerContentComponent$c", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "", "localId", "", "resultId", "", "onAnimationStart", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.qqnt.aio.anisticker.view.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationEnd(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, localId, (Object) resultId);
            } else {
                q.a("ChainAniStickerContentComponent", "random emo prepare-anim finish");
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationStart(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, localId, (Object) resultId);
            } else {
                q.a("ChainAniStickerContentComponent", "random emo prepare-anim start");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/chain/ChainAniStickerContentComponent$d", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "", "localId", "", "resultId", "", "onAnimationStart", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.qqnt.aio.anisticker.view.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f190726a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.msg.e f190727b;

        d(Ref.IntRef intRef, com.tencent.mobileqq.aio.msg.e eVar) {
            this.f190726a = intRef;
            this.f190727b = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) intRef, (Object) eVar);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationEnd(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, localId, (Object) resultId);
            } else {
                q.a("ChainAniStickerContentComponent", "random emo result-anim finish.");
                this.f190727b.B2(true, 2);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationStart(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, localId, (Object) resultId);
                return;
            }
            q.a("ChainAniStickerContentComponent", "random emo result-anim start. chainStickerPlayCount=" + this.f190726a.element);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChainAniStickerContentComponent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.randomLottieResultId = "";
        AniStickerLottieView aniStickerLottieView = new AniStickerLottieView(context);
        aniStickerLottieView.setId(R.id.spv);
        this.lottieView = aniStickerLottieView;
        int dpToPx = ViewUtils.dpToPx(10.0f);
        this.rootViewMargin = dpToPx;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
        relativeLayout.setLayoutParams(layoutParams);
        this.rootView = relativeLayout;
    }

    private final void L1(String path, boolean isSelf, final int serverId) {
        Function0<Unit> function0;
        QLog.i("ChainAniStickerContentComponent", 1, "addFullScreenViewAndPlayLottie  path:" + path + ", isSelf:" + isSelf + ", serverId:" + serverId);
        if (isSelf) {
            ((IAIOChainAniStickerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChainAniStickerApi.class)).preDownloadPic(serverId);
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.rootView.getContext());
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        lottieAnimationView.addAnimatorListener(new b(lottieAnimationView, this));
        lottieAnimationView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fullscreenLottieAnimationView = lottieAnimationView;
        sendIntent(new d.a(6, lottieAnimationView));
        if (isSelf) {
            function0 = new Function0<Unit>(serverId, this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.chain.ChainAniStickerContentComponent$addFullScreenViewAndPlayLottie$onAnimationEnd$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $serverId;
                final /* synthetic */ ChainAniStickerContentComponent this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$serverId = serverId;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, serverId, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("ChainAniStickerContentComponent", 1, "showShareActionSheet  serverId:" + this.$serverId);
                    this.this$0.sendIntent(new b.a(this.$serverId));
                }
            };
        } else {
            function0 = null;
        }
        ag.f194106a.b(lottieAnimationView, path, function0);
        q1().D2();
        if (q1().isSelf()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.chain.b
                @Override // java.lang.Runnable
                public final void run() {
                    ChainAniStickerContentComponent.M1(ChainAniStickerContentComponent.this);
                }
            }, 16, null, true);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.chain.c
            @Override // java.lang.Runnable
            public final void run() {
                ChainAniStickerContentComponent.N1(ChainAniStickerContentComponent.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(ChainAniStickerContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.temp.report.a.a(null, "dc00898", "", "", "0X800C5DB", "0X800C5DB", 0, 0, com.tencent.qqnt.emotion.utils.q.f356700a.a(this$0.q1().p0()), String.valueOf(this$0.q1().r2()), "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(ChainAniStickerContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.temp.report.a.a(null, "dc00898", "", "", "0X800C5DC", "0X800C5DC", 0, 0, com.tencent.qqnt.emotion.utils.q.f356700a.a(this$0.q1().p0()), String.valueOf(this$0.q1().r2()), "", "");
    }

    private final void O1(com.tencent.mobileqq.aio.msg.e msgItem) {
        com.tencent.mobileqq.emoticon.rare.a.f204862a.a(msgItem.isSelf(), msgItem.r2(), msgItem.q2());
    }

    private final void P1(com.tencent.mobileqq.aio.msg.e msgItem) {
        FreesiaWrapperImpl.Companion companion = FreesiaWrapperImpl.INSTANCE;
        boolean z16 = true;
        boolean isSwitchOn = companion.b().isSwitchOn("101797", true);
        if (!isSwitchOn) {
            QLog.i("ChainAniStickerContentComponent", 1, "considerPlaySurpriseAnimation  msgId:" + q1().getMsgId() + ", chainEmojiSwitch:" + isSwitchOn);
            return;
        }
        boolean isSwitchOn2 = companion.b().isSwitchOn("chain_emoji_surprise_9015_115331429", true);
        if (!isSwitchOn2) {
            QLog.i("ChainAniStickerContentComponent", 1, "considerPlaySurpriseAnimation  msgId:" + q1().getMsgId() + ", chainEmojiSurpriseSwitch:" + isSwitchOn2);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ChainAniStickerContentComponent", 4, "considerPlaySurpriseAnimation  msgId:" + q1().getMsgId() + ", surpriseId:" + msgItem.t2() + ", canPlaySurprise:" + msgItem.G2() + ", msgPlayedSurprise:" + msgItem.p2());
        }
        if (!TextUtils.isEmpty(msgItem.t2()) && msgItem.G2() && !msgItem.p2()) {
            if (q1().s2() == null) {
                q1().z2();
                Unit unit = Unit.INSTANCE;
            }
            AniStickerInfo s26 = q1().s2();
            if (s26 == null) {
                QLog.i("ChainAniStickerContentComponent", 1, "considerPlaySurpriseAnimation mCurrentMsgItem.stickerInfo:" + q1().s2() + " msgId is " + q1().getMsgId());
                return;
            }
            if (!((IDevicesApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IDevicesApi.class)).isPadDevice() || com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT) {
                z16 = false;
            }
            String aniStickerSurpriseFullResPath = QQSysAndEmojiResMgr.getInstance().getAniStickerSurpriseFullResPath(s26.sevrId, s26.aniStickerPackId, s26.aniStickerId, s26.surpriseId, z16);
            Intrinsics.checkNotNullExpressionValue(aniStickerSurpriseFullResPath, "getInstance().getAniStic\u2026 isPadLandScape\n        )");
            L1(aniStickerSurpriseFullResPath, q1().isSelf(), msgItem.r2());
        }
    }

    private final e.a Q1(AniStickerMsgItem msgItem) {
        Pair<Integer, Integer> J2 = q1().J2();
        double b16 = j.f190747a.b();
        return new e.a(this.lottieView).r(msgItem.n2()).w(msgItem.q2()).z(msgItem.s2()).B((int) (J2.getFirst().doubleValue() * b16)).p((int) (J2.getSecond().doubleValue() * b16)).s(R1()).a();
    }

    private final int R1() {
        return R.drawable.mk9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean S1(com.tencent.mobileqq.aio.msg.e msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        Iterator<T> it = payloads.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next instanceof HashMap) {
                Map map = (Map) next;
                if (map.get(AIOMsgItemPayloadType.RANDOM_LOTTIE_RESULT) != null) {
                    d2(msgItem.q2());
                    return false;
                }
                if (map.get(AIOMsgItemPayloadType.LOTTIE_RES_UPDATE_PAYLOAD) != null) {
                    QLog.i("ChainAniStickerContentComponent", 1, "[handlePayLoads]: update lottie res msgId is" + msgItem.getMsgId());
                    d2(msgItem.q2());
                    break;
                }
            }
        }
    }

    private final void T1() {
        String str;
        FaceElement faceElement;
        AniStickerLottieView aniStickerLottieView = this.lottieView;
        if (aniStickerLottieView.getParent() == null) {
            int intValue = q1().J2().getFirst().intValue();
            int intValue2 = q1().J2().getSecond().intValue();
            RelativeLayout relativeLayout = this.rootView;
            AniStickerLottieView aniStickerLottieView2 = this.lottieView;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(intValue, intValue2);
            layoutParams.addRule(13);
            Unit unit = Unit.INSTANCE;
            relativeLayout.addView(aniStickerLottieView2, layoutParams);
        }
        aniStickerLottieView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.chain.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChainAniStickerContentComponent.U1(ChainAniStickerContentComponent.this, view);
            }
        });
        String qqStr = HardCodeUtil.qqStr(R.string.f170197yp0);
        MsgElement firstTypeElement = q1().getFirstTypeElement(6);
        if (firstTypeElement != null && (faceElement = firstTypeElement.faceElement) != null) {
            str = faceElement.faceText;
        } else {
            str = null;
        }
        aniStickerLottieView.setContentDescription(qqStr + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(ChainAniStickerContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V1() {
        if (!TextUtils.isEmpty(q1().q2())) {
            sendIntent(new d.w(q1()));
        }
    }

    private final void W1(boolean showLoading) {
        if (!q1().y2()) {
            q1().z2();
        }
        e.a q16 = Q1(q1()).y(showLoading).q(new c());
        q1().B2(true, 1);
        com.tencent.qqnt.aio.anisticker.view.e.f348849a.n(q16);
    }

    private final void X1() {
        String str;
        if (q1().x2() && TextUtils.isEmpty(q1().q2())) {
            q.e("ChainAniStickerContentComponent", q1().getMsgRecord().msgId + " isRead but resultId isEmpty");
        }
        int r26 = q1().r2();
        AniStickerInfo s26 = q1().s2();
        if (s26 != null) {
            str = s26.aniStickerId;
        } else {
            str = null;
        }
        q.c("ChainAniStickerContentComponent", "[playRandomAniSticker] serverId=" + r26 + ", aniStickerId=" + str);
        this.randomLottieResultId = q1().q2();
        if (TextUtils.isEmpty(q1().q2())) {
            W1(true);
        } else {
            W1(false);
            Y1(q1(), this.lottieView);
        }
    }

    private final void Y1(com.tencent.mobileqq.aio.msg.e msgItem, AniStickerLottieView lottieView) {
        if (lottieView != null && msgItem.u2() && !TextUtils.isEmpty(msgItem.q2())) {
            if (!q1().y2()) {
                q1().z2();
            }
            Ref.IntRef intRef = new Ref.IntRef();
            int a16 = j.f190747a.a();
            intRef.element = a16;
            if (a16 <= 0) {
                intRef.element = -1;
            }
            com.tencent.qqnt.aio.anisticker.view.e.f348849a.d(Q1(q1()).v(intRef.element).q(new d(intRef, msgItem)));
            P1(msgItem);
            O1(msgItem);
            return;
        }
        q.e("ChainAniStickerContentComponent", "[playResultAniSticker] invalid arguments");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            c2();
        } else {
            if (com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.chain.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChainAniStickerContentComponent.a2(ChainAniStickerContentComponent.this);
                    }
                });
                return;
            }
            throw new OperateViewOnSubThreadException("AIOGestureLayout removeView on sub thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(ChainAniStickerContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c2();
    }

    private final void c2() {
        ViewGroup viewGroup;
        View view = this.fullscreenLottieAnimationView;
        if (view != null) {
            QLog.i("ChainAniStickerContentComponent", 1, "removeFullScreenViewInternal msgId:" + q1().getMsgId());
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            this.fullscreenLottieAnimationView = null;
        }
    }

    private final void d2(String resultId) {
        QLog.i("ChainAniStickerContentComponent", 1, "[updateRandomLottieResult]: resultId:" + resultId + " msgId is " + q1().getMsgId());
        this.randomLottieResultId = resultId;
        if (!TextUtils.isEmpty(resultId)) {
            Y1(q1(), this.lottieView);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!S1(q1(), payloads)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.rootView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (q1().isSelf()) {
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.rightMargin = this.rootViewMargin;
        } else {
            marginLayoutParams.leftMargin = this.rootViewMargin;
            marginLayoutParams.rightMargin = 0;
        }
        T1();
        X1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rootView;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            this.lottieView.S();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.component.anisticker.b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new af(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new aj(getMContext(), q1(), this)});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}

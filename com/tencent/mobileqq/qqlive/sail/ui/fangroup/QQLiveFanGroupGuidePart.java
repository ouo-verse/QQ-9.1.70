package com.tencent.mobileqq.qqlive.sail.ui.fangroup;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.utils.o;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mt3.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001SB\u0007\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J*\u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0016\u0010@\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010L\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/fangroup/QQLiveFanGroupGuidePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "", "delay", "", "Ia", "xa", "Ga", "Ha", "", "getInitRelyViewStubId", "", "isPartEnable", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "U9", "V9", "v", NodeProps.ON_CLICK, "Lfp4/c;", "msgInfo", "onPush", "uid", "followedId", "isFollowed", "", "roomId", "onFollowStateChange", "e", "Landroid/view/View;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "avatarImageView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "titleTextView", "i", "joinBtn", "Ltrpc/qlive/trpc_room_global_config/TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltrpc/qlive/trpc_room_global_config/TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;", DownloadInfo.spKey_Config, BdhLogUtil.LogTag.Tag_Conn, "Z", QCircleDaTongConstant.ElementParamValue.FOLLOWED, "D", "guideShown", "E", "notJoinedGroup", UserInfo.SEX_FEMALE, "J", "showDelay", "Lcom/tencent/mobileqq/qqlive/sail/ui/fangroup/FanGroupViewModel;", "G", "Lkotlin/Lazy;", "Ba", "()Lcom/tencent/mobileqq/qqlive/sail/ui/fangroup/FanGroupViewModel;", "fanGroupViewModel", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "guideAnimationRunnable", "Aa", "()Z", "configEnable", "za", "canShowGuide", "<init>", "()V", "I", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveFanGroupGuidePart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, g, IQQLiveFollowApi.IQQLiveFollowStateListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean followed;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean guideShown;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean notJoinedGroup;

    /* renamed from: F, reason: from kotlin metadata */
    private long showDelay;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy fanGroupViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable guideAnimationRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView avatarImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView joinBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp config;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/fangroup/QQLiveFanGroupGuidePart$a;", "", "", "DEFAULT_PENDING_SHOW_DELAY", "J", "", "TAG", "Ljava/lang/String;", "TRIGGERED_PENDING_SHOW_DELAY", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.fangroup.QQLiveFanGroupGuidePart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/fangroup/QQLiveFanGroupGuidePart$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveFanGroupGuidePart.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|QQLiveFanGroupGuidePart", "onAnimationCancel");
            }
            View view = QQLiveFanGroupGuidePart.this.container;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|QQLiveFanGroupGuidePart", "onAnimationEnd");
            }
            View view = QQLiveFanGroupGuidePart.this.container;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                AegisLogger.INSTANCE.i("Audience|QQLiveFanGroupGuidePart", "onAnimationStart");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51836);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveFanGroupGuidePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.showDelay = 60000L;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FanGroupViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.QQLiveFanGroupGuidePart$fanGroupViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFanGroupGuidePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FanGroupViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (FanGroupViewModel) QQLiveFanGroupGuidePart.this.getViewModel(FanGroupViewModel.class) : (FanGroupViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.fanGroupViewModel = lazy;
        this.guideAnimationRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.d
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveFanGroupGuidePart.Ca(QQLiveFanGroupGuidePart.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Aa() {
        boolean z16;
        boolean z17;
        PBBoolField pBBoolField;
        PBBoolField pBBoolField2;
        TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp = this.config;
        if (trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp != null && (pBBoolField2 = trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.visible) != null && pBBoolField2.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp2 = this.config;
            if (trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp2 != null && (pBBoolField = trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp2.fans_switch) != null && pBBoolField.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FanGroupViewModel Ba() {
        Object value = this.fanGroupViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-fanGroupViewModel>(...)");
        return (FanGroupViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(QQLiveFanGroupGuidePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.container;
        if (view != null) {
            view.setVisibility(0);
            this$0.Ha();
            float f16 = -wi2.c.d(232);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f16, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(400L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f16);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.setDuration(400L);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
            ofInt.setDuration(3000L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat, ofInt, ofFloat2);
            animatorSet.addListener(new b());
            animatorSet.start();
            this$0.Ba().U1(this$0.C9());
            this$0.guideShown = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga() {
        f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        TGLiveFollowManager.f377684a.w(this);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.guideAnimationRunnable);
    }

    private final void Ha() {
        int i3;
        String str;
        Resources resources;
        Configuration configuration;
        View view = this.container;
        if (view != null) {
            Context context = getContext();
            boolean z16 = true;
            if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
                i3 = configuration.orientation;
            } else {
                i3 = 1;
            }
            if (i3 != 2) {
                z16 = false;
            }
            QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            qQLiveDaTongParams.B(str);
            qQLiveDaTongParams.R("em_qqlive_joinfantuan_lead");
            com.tencent.mobileqq.qqlive.sail.report.a.f272382a.b(view, true, "", "em_qqlive_joinfantuan_lead", qQLiveDaTongParams.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia(long delay) {
        Resources resources;
        PBStringField pBStringField;
        String str;
        String str2;
        Resources resources2;
        PBStringField pBStringField2;
        AegisLogger.INSTANCE.i("Audience|QQLiveFanGroupGuidePart", "tryShowGuide", "canShowGuide=" + za());
        if (!za()) {
            return;
        }
        startInit();
        View view = this.container;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.container;
        if (view2 != null) {
            view2.clearAnimation();
        }
        if (this.showDelay > delay) {
            this.showDelay = delay;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.guideAnimationRunnable);
        TextView textView = this.titleTextView;
        String str3 = "";
        String str4 = null;
        if (textView != null) {
            TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp = this.config;
            if (trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp == null || (pBStringField2 = trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.text) == null || (str2 = pBStringField2.get()) == null) {
                Context context = getContext();
                if (context != null && (resources2 = context.getResources()) != null) {
                    str2 = resources2.getString(R.string.f210565ig);
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                }
            }
            textView.setText(str2);
        }
        TextView textView2 = this.joinBtn;
        if (textView2 != null) {
            TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp2 = this.config;
            if (trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp2 != null && (pBStringField = trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp2.btn_text) != null && (str = pBStringField.get()) != null) {
                str3 = str;
            } else {
                Context context2 = getContext();
                if (context2 != null && (resources = context2.getResources()) != null) {
                    str4 = resources.getString(R.string.f210555if);
                }
                if (str4 != null) {
                    str3 = str4;
                }
            }
            textView2.setText(str3);
        }
        ImageView imageView = this.avatarImageView;
        if (imageView != null) {
            Option targetView = Option.obtain().setUrl(A9()).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setSupportRecycler(true).setRequestWidth(imageView.getWidth()).setRequestWidth(imageView.getHeight()).setTargetView(imageView);
            targetView.setFailedDrawableId(R.drawable.msa);
            targetView.setLoadingDrawableId(R.drawable.msa);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.guideAnimationRunnable, this.showDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa() {
        f F9 = F9();
        if (F9 != null) {
            F9.p(167, this);
            F9.p(235, this);
        }
        TGLiveFollowManager.f377684a.u(this);
    }

    private final boolean za() {
        if (Aa() && this.followed && !this.guideShown && this.notJoinedGroup && R9()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.U9();
        if (F9() != null) {
            if (Aa()) {
                Ga();
                xa();
            }
            Ba().O1(J9(), C9());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveFanGroupGuidePart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.V9();
            Ga();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f60632vy;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else if (!o.a()) {
            kj4.a.e(getContext(), C9(), M9(), 2, 1);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener
    public void onFollowStateChange(long uid, long followedId, int isFollowed, @Nullable String roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(uid), Long.valueOf(followedId), Integer.valueOf(isFollowed), roomId);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("Audience|QQLiveFanGroupGuidePart", "onFollowStateChange", "roomId=" + roomId + ", uid=" + uid + ", followedId=" + followedId + ", isFollowed=" + isFollowed);
        }
        if (uid == M9() && followedId == C9() && isFollowed == 1 && Intrinsics.areEqual(String.valueOf(H9()), roomId)) {
            this.followed = true;
            Ia(5000L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        ImageView imageView;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        TextView textView2 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f60632vy);
        } else {
            view = null;
        }
        this.container = view;
        if (view != null) {
            view.setOnClickListener(this);
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.ya8);
        } else {
            imageView = null;
        }
        this.avatarImageView = imageView;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.ya_);
        } else {
            textView = null;
        }
        this.titleTextView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.yad);
        }
        this.joinBtn = textView2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> R1 = Ba().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp, Unit> function1 = new Function1<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.QQLiveFanGroupGuidePart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFanGroupGuidePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp) {
                invoke2(trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp) {
                boolean Aa;
                boolean Aa2;
                FanGroupViewModel Ba;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp);
                    return;
                }
                QQLiveFanGroupGuidePart.this.config = trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                Aa = QQLiveFanGroupGuidePart.this.Aa();
                companion.i("Audience|QQLiveFanGroupGuidePart", "configChanged", "configEnable=" + Aa);
                Aa2 = QQLiveFanGroupGuidePart.this.Aa();
                if (Aa2) {
                    if (QQLiveFanGroupGuidePart.this.R9()) {
                        QQLiveFanGroupGuidePart.this.Ga();
                        QQLiveFanGroupGuidePart.this.xa();
                    }
                    Ba = QQLiveFanGroupGuidePart.this.Ba();
                    Ba.Q1(QQLiveFanGroupGuidePart.this.C9());
                }
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveFanGroupGuidePart.Da(Function1.this, obj);
            }
        });
        LiveData<Boolean> T1 = Ba().T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.QQLiveFanGroupGuidePart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFanGroupGuidePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                boolean z16;
                FanGroupViewModel Ba;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveFanGroupGuidePart qQLiveFanGroupGuidePart = QQLiveFanGroupGuidePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveFanGroupGuidePart.followed = it.booleanValue();
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                z16 = QQLiveFanGroupGuidePart.this.followed;
                companion.i("Audience|QQLiveFanGroupGuidePart", "followChanged", "followed=" + z16);
                Ba = QQLiveFanGroupGuidePart.this.Ba();
                Ba.P1(QQLiveFanGroupGuidePart.this.C9());
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveFanGroupGuidePart.Ea(Function1.this, obj);
            }
        });
        LiveData<nr4.d> S1 = Ba().S1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<nr4.d, Unit> function13 = new Function1<nr4.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.QQLiveFanGroupGuidePart$onPartCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFanGroupGuidePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(nr4.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable nr4.d dVar) {
                boolean z16;
                nr4.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar);
                    return;
                }
                QQLiveFanGroupGuidePart qQLiveFanGroupGuidePart = QQLiveFanGroupGuidePart.this;
                boolean z17 = false;
                if (dVar != null && (bVar = dVar.f421217d) != null && bVar.f421205a == 2) {
                    z17 = true;
                }
                qQLiveFanGroupGuidePart.notJoinedGroup = z17;
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                z16 = QQLiveFanGroupGuidePart.this.notJoinedGroup;
                companion.i("Audience|QQLiveFanGroupGuidePart", "infoChanged", "notJoinedGroup=" + z16);
                QQLiveFanGroupGuidePart.this.Ia(60000L);
            }
        };
        S1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveFanGroupGuidePart.Fa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            Ga();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        e m3 = com.tencent.mobileqq.qqlive.sail.push.a.m(msgInfo);
        if (m3 != null) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|QQLiveFanGroupGuidePart", "onPush", "roomId=" + H9() + ", receiver=" + m3.f417565p + ", sender=" + m3.f417554e);
            }
            if (m3.f417554e == M9() && m3.f417565p == C9()) {
                Ia(5000L);
            }
        }
    }
}

package com.tencent.mobileqq.qqlive.sail.ui.player;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.room.s;
import com.tencent.mobileqq.qqlive.utils.k;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0004\u0018\u0001098BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/QQLivePlayerPreloadPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lmi2/g;", "", "ra", "Landroid/view/View;", "videoContainer", "za", "qa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "onVideoPrepared", "V9", "", "e", "I", "position", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "playerContainerView", tl.h.F, "Landroid/view/View;", "playerView", "i", "playerContainerGuideLine", "Lcom/tencent/mobileqq/qqlive/sail/ui/player/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/sail/ui/player/a;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, BdhLogUtil.LogTag.Tag_Conn, "orientation", "Landroid/util/Size;", "D", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "E", "Lkotlin/Lazy;", "ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", UserInfo.SEX_FEMALE, "sa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "definitionViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "(I)V", "G", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePlayerPreloadPart extends com.tencent.mobileqq.qqlive.sail.base.c implements mi2.g {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int orientation;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Size videoSize;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy definitionViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout playerContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View playerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View playerContainerGuideLine;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a strategy;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/QQLivePlayerPreloadPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerPreloadPart$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePlayerPreloadPart(int i3) {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.position = i3;
        this.orientation = 1;
        this.videoSize = new Size(0, 0);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerPreloadPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerPreloadPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLivePlayerPreloadPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.definition.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerPreloadPart$definitionViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerPreloadPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.definition.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.definition.a) QQLivePlayerPreloadPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.definition.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.definition.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.definitionViewModel = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        com.tencent.mobileqq.qqlive.sail.room.e ta5;
        View videoView;
        ViewGroup viewGroup;
        FrameLayout frameLayout = this.playerContainerView;
        if (frameLayout != null && (ta5 = ta()) != null && (videoView = ta5.getVideoView()) != null && !wi2.d.b(frameLayout, videoView)) {
            frameLayout.removeView(this.playerView);
            this.playerView = videoView;
            ViewParent parent = videoView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(videoView);
            }
            frameLayout.addView(videoView, 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra() {
        if (this.videoSize.getWidth() > this.videoSize.getHeight()) {
            com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
            if (ta5 != null) {
                ta5.setXYAxis(IQQLivePlayer.XYAxis.ORIGINAL_RATIO);
            }
        } else {
            com.tencent.mobileqq.qqlive.sail.room.e ta6 = ta();
            if (ta6 != null) {
                ta6.setXYAxis(IQQLivePlayer.XYAxis.ORIGINAL_FULLSCREEN);
            }
        }
        if (com.tencent.timi.game.liveroom.impl.room.util.a.a(getContext())) {
            s.f273162a.a(this.playerContainerView, this.videoSize.getWidth(), this.videoSize.getHeight());
        } else {
            s.f273162a.b(this.playerContainerView, this.orientation, this.videoSize.getWidth(), this.videoSize.getHeight());
        }
        za(this.playerContainerView);
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.definition.a sa() {
        Object value = this.definitionViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-definitionViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.definition.a) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e ta() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    private final RoomViewModel ua() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(QQLivePlayerPreloadPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ua().e2().postValue(Boolean.TRUE);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void za(View videoContainer) {
        boolean z16;
        int e16;
        int d16;
        int i3;
        View view;
        int roundToInt;
        if (this.videoSize.getWidth() > this.videoSize.getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (videoContainer != null) {
                ViewGroup.LayoutParams layoutParams = videoContainer.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                int i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                roundToInt = MathKt__MathJVMKt.roundToInt(ViewUtils.getStatusBarHeight(BaseApplication.context));
                e16 = i16 - roundToInt;
                d16 = com.tencent.timi.game.liveroom.impl.room.message.stack.b.f378084a.f();
            } else {
                i3 = com.tencent.timi.game.liveroom.impl.room.message.stack.b.f378084a.c();
                AegisLogger.INSTANCE.i("Audience|QQLivePlayerPreloadPart", "updateGuideLinePosition", "videoLandscape:" + z16 + ", guideMargin:" + i3);
                view = this.playerContainerGuideLine;
                if (view == null) {
                    ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                    if (z16) {
                        layoutParams4.topToTop = 0;
                        layoutParams4.bottomToTop = -1;
                        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = i3;
                        view.setLayoutParams(layoutParams4);
                        return;
                    }
                    layoutParams4.topToTop = -1;
                    layoutParams4.bottomToTop = R.id.f59762tl;
                    ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = i3;
                    view.setLayoutParams(layoutParams4);
                    return;
                }
                return;
            }
        } else {
            com.tencent.timi.game.liveroom.impl.room.message.stack.b bVar = com.tencent.timi.game.liveroom.impl.room.message.stack.b.f378084a;
            e16 = bVar.e() + bVar.a();
            d16 = bVar.d();
        }
        i3 = e16 + d16;
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerPreloadPart", "updateGuideLinePosition", "videoLandscape:" + z16 + ", guideMargin:" + i3);
        view = this.playerContainerGuideLine;
        if (view == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f8, code lost:
    
        if ((!r8) == true) goto L57;
     */
    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V9() {
        boolean z16;
        boolean z17;
        AudienceRoomInfo b16;
        String str;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.V9();
        Activity activity = getActivity();
        boolean z18 = true;
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AegisLogger.INSTANCE.i("Audience|QQLivePlayerPreloadPart", "onExitRoom", "roomId=" + H9() + ", exit activity, do not preload");
            return;
        }
        a aVar = this.strategy;
        if (aVar != null) {
            aVar.init();
        }
        Object obj = null;
        if (ua().S1()) {
            com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
            if (ta5 != null) {
                ta5.n(null);
            }
            FrameLayout frameLayout = this.playerContainerView;
            if (frameLayout != null) {
                frameLayout.removeView(this.playerView);
            }
            ua().g2(false);
            com.tencent.mobileqq.qqlive.sail.room.e ta6 = ta();
            if (ta6 != null) {
                ta6.registerVideoPreparedListener(this);
            }
            broadcastMessage("onChangeVideoPlayer", null);
        }
        com.tencent.mobileqq.qqlive.sail.model.g b26 = ua().b2();
        if (b26 != null) {
            a aVar2 = this.strategy;
            if (aVar2 != null && aVar2.b(b26.b().b(), b26.b().a())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isColorLevel()) {
                    companion.i("Audience|QQLivePlayerPreloadPart", "roomSelectChange", "roomId=" + H9() + ", do preload");
                }
                com.tencent.mobileqq.qqlive.sail.room.e ta7 = ta();
                if (ta7 != null) {
                    ta7.pauseVideo();
                }
                com.tencent.mobileqq.qqlive.sail.model.audience.a T1 = ua().T1();
                if (T1 != null) {
                    str = T1.e();
                } else {
                    str = null;
                }
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                }
                z18 = false;
                if (z18) {
                    com.tencent.mobileqq.qqlive.sail.room.e ta8 = ta();
                    if (ta8 != null) {
                        ta8.prepare(str);
                    }
                } else {
                    companion.w("Audience|QQLivePlayerPreloadPart", "onExitRoom", "roomId=" + H9() + ", no found play url");
                }
                broadcastMessage("onPreloadRoom", null);
            } else {
                com.tencent.mobileqq.qqlive.sail.room.e ta9 = ta();
                if (ta9 != null && (b16 = ta9.b()) != null) {
                    obj = b16.v();
                }
                if (obj == WindowMode.NORMAL) {
                    FrameLayout frameLayout2 = this.playerContainerView;
                    if (frameLayout2 != null) {
                        frameLayout2.removeView(this.playerView);
                    }
                    com.tencent.mobileqq.qqlive.sail.room.e ta10 = ta();
                    if (ta10 != null) {
                        ta10.a();
                    }
                }
                com.tencent.mobileqq.qqlive.sail.c.f272176a.m().I(H9());
            }
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            com.tencent.mobileqq.qqlive.sail.c.f272176a.m().I(H9());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            i3 = configuration.orientation;
        } else {
            i3 = 1;
        }
        this.orientation = i3;
        ra();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view = null;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f61692yt);
        } else {
            frameLayout = null;
        }
        this.playerContainerView = frameLayout;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQLivePlayerPreloadPart.va(QQLivePlayerPreloadPart.this, view2);
                }
            });
        }
        if (rootView != null) {
            view = rootView.findViewById(R.id.f61672yr);
        }
        this.playerContainerGuideLine = view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        j jVar = new j(H9(), this.position);
        this.strategy = jVar;
        jVar.a(sa().O1());
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null) {
            ta5.registerVideoPreparedListener(this);
        }
        LiveData<StreamDefinition> R1 = sa().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<StreamDefinition, Unit> function1 = new Function1<StreamDefinition, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerPreloadPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerPreloadPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StreamDefinition streamDefinition) {
                invoke2(streamDefinition);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StreamDefinition it) {
                a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                aVar = QQLivePlayerPreloadPart.this.strategy;
                if (aVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    aVar.a(it);
                }
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePlayerPreloadPart.wa(Function1.this, obj);
            }
        });
        MutableLiveData<Size> d26 = ua().d2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Size, Unit> function12 = new Function1<Size, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerPreloadPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePlayerPreloadPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                invoke2(size);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Size size) {
                Size size2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) size);
                    return;
                }
                QQLivePlayerPreloadPart.this.videoSize = new Size(size.getWidth(), size.getHeight());
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                long H9 = QQLivePlayerPreloadPart.this.H9();
                size2 = QQLivePlayerPreloadPart.this.videoSize;
                companion.i("Audience|QQLivePlayerPreloadPart", "videoSizeChanged", "roomId=" + H9 + ", videoSize=" + size2);
                QQLivePlayerPreloadPart.this.ra();
            }
        };
        d26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePlayerPreloadPart.xa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        this.playerContainerView = null;
        this.playerView = null;
        a aVar = this.strategy;
        if (aVar != null) {
            aVar.clear();
        }
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null) {
            ta5.z(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        qa();
        com.tencent.mobileqq.qqlive.sail.room.e ta5 = ta();
        if (ta5 != null) {
            k.f273458a.c("Audience|QQLivePlayerPreloadPart", ta5, false);
        }
    }

    @Override // mi2.g
    public void onVideoPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLivePlayerPreloadPart", "onVideoPrepared", "videoSize=" + this.videoSize);
        LifecycleCoroutineScope P9 = P9();
        if (P9 != null) {
            BuildersKt__Builders_commonKt.launch$default(P9, null, null, new QQLivePlayerPreloadPart$onVideoPrepared$1(this, null), 3, null);
        }
    }
}

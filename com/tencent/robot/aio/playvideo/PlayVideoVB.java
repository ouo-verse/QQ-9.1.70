package com.tencent.robot.aio.playvideo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.aio.playvideo.PlayVideoUIState;
import com.tencent.robot.aio.playvideo.a;
import com.tencent.robot.aio.playvideo.r;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.util.LoadingUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\u001a\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0003H\u0016J4\u0010-\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016R#\u00104\u001a\n /*\u0004\u0018\u00010.0.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00101\u001a\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u00101\u001a\u0004\bF\u0010GR\u001b\u0010L\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u00101\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u00101\u001a\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/robot/aio/playvideo/a;", "Lcom/tencent/robot/aio/playvideo/PlayVideoUIState;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "", "F1", "", "imageUrl", "", "O1", "url", "P1", "v1", "videoStatus", "w1", "Y1", "N1", "L1", Constants.APK_CERTIFICATE, "J1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "state", "E1", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "", "what", "", "arg1", "arg2", "", "extra", "onInfo", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "B1", "()Lcom/tencent/superplayer/view/ISPlayerVideoView;", "mVideoPlayerView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mFirstFramePage", "f", "Z", "isSetCover", "Lss/b;", tl.h.F, Constants.BASE_IN_PLUGIN_ID, "()Lss/b;", "scaleInterpolator", "i", "Lcom/tencent/superplayer/api/ISuperPlayer;", "mVideoPlayer", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "A1", "()Landroid/widget/TextView;", "mSkipBtn", BdhLogUtil.LogTag.Tag_Conn, "C1", "()Landroid/widget/ImageView;", "mVoiceBtn", "Landroid/widget/FrameLayout;", "D", "z1", "()Landroid/widget/FrameLayout;", "mContainerView", "Landroid/app/Dialog;", "E", "Landroid/app/Dialog;", "mLoadingDialog", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PlayVideoVB extends com.tencent.aio.base.mvvm.a<a, PlayVideoUIState> implements ISuperPlayer.OnInfoListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mVoiceBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Dialog mLoadingDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mVideoPlayerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mFirstFramePage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isSetCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scaleInterpolator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISuperPlayer mVideoPlayer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mSkipBtn;

    public PlayVideoVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ISPlayerVideoView>() { // from class: com.tencent.robot.aio.playvideo.PlayVideoVB$mVideoPlayerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final ISPlayerVideoView invoke() {
                ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(PlayVideoVB.this.getMContext());
                View view = createPlayerVideoView instanceof View ? (View) createPlayerVideoView : null;
                if (view != null) {
                    view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                }
                createPlayerVideoView.setXYaxis(2);
                return createPlayerVideoView;
            }
        });
        this.mVideoPlayerView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ss.b>() { // from class: com.tencent.robot.aio.playvideo.PlayVideoVB$scaleInterpolator$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ss.b invoke() {
                return new ss.b(0.39f, 0.0f, 0.23f, 1.0f);
            }
        });
        this.scaleInterpolator = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new PlayVideoVB$mSkipBtn$2(this));
        this.mSkipBtn = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new PlayVideoVB$mVoiceBtn$2(this));
        this.mVoiceBtn = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.robot.aio.playvideo.PlayVideoVB$mContainerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                FrameLayout frameLayout = new FrameLayout(PlayVideoVB.this.getMContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(-16777216);
                frameLayout.setVisibility(8);
                return frameLayout;
            }
        });
        this.mContainerView = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView A1() {
        return (TextView) this.mSkipBtn.getValue();
    }

    private final ISPlayerVideoView B1() {
        return (ISPlayerVideoView) this.mVideoPlayerView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView C1() {
        return (ImageView) this.mVoiceBtn.getValue();
    }

    private final ss.b D1() {
        return (ss.b) this.scaleInterpolator.getValue();
    }

    private final boolean F1() {
        View view;
        Object B1 = B1();
        if (B1 instanceof View) {
            view = (View) B1;
        } else {
            view = null;
        }
        if (view == null || z1().indexOfChild(view) == -1 || view.getParent() == null) {
            return true;
        }
        return false;
    }

    private final void G1() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.robot.aio.playvideo.d
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.H1(PlayVideoVB.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (!NetworkUtil.isNetSupport(this$0.getMContext())) {
                this$0.w1("fail");
                Dialog dialog = this$0.mLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                QLog.i("PlayVideoVB", 1, "net fail");
            }
        } catch (Exception e16) {
            QLog.e("PlayVideoVB", 1, "post " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mFirstFramePage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFirstFramePage");
            imageView = null;
        }
        imageView.setVisibility(8);
        QLog.i("PlayVideoVB", 1, "real start video");
    }

    private final void J1() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.aio.playvideo.i
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.K1(PlayVideoVB.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mLoadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        QLog.i("PlayVideoVB", 1, "mLoadingDialog.dismiss()");
    }

    private final void L1() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.aio.playvideo.j
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.M1(PlayVideoVB.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G1();
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this$0.getMContext(), "\u52a0\u8f7d\u4e2d", false);
        this$0.mLoadingDialog = showLoadingDialog;
        if (showLoadingDialog != null) {
            showLoadingDialog.show();
        }
        QLog.i("PlayVideoVB", 1, "mLoadingDialog.show()");
    }

    private final void N1() {
        if (AppSetting.o(getMContext())) {
            B1().setXYaxis(0);
        } else {
            B1().setXYaxis(2);
        }
    }

    private final void O1(String imageUrl) {
        if (TextUtils.isEmpty(imageUrl)) {
            return;
        }
        z1().setVisibility(0);
        ImageView imageView = this.mFirstFramePage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFirstFramePage");
            imageView = null;
        }
        CommonExKt.h(imageView, imageUrl, null, null, null, 14, null);
    }

    private final void P1(String url) {
        z1().setVisibility(0);
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(url, 101, "", u64.a.f438505a.a());
        Context mContext = getMContext();
        ISPlayerVideoView B1 = B1();
        Intrinsics.checkNotNull(B1, "null cannot be cast to non-null type com.tencent.superplayer.view.ISPlayerVideoView");
        final ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(mContext, 170, B1);
        createMediaPlayer.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: com.tencent.robot.aio.playvideo.k
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
            public final void onCompletion(ISuperPlayer iSuperPlayer) {
                PlayVideoVB.S1(PlayVideoVB.this, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.robot.aio.playvideo.l
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
                boolean U1;
                U1 = PlayVideoVB.U1(ISuperPlayer.this, this, iSuperPlayer, i3, i16, i17, str);
                return U1;
            }
        });
        createMediaPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.robot.aio.playvideo.m
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                PlayVideoVB.Q1(PlayVideoVB.this, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnInfoListener(this);
        this.mVideoPlayer = createMediaPlayer;
        createMediaPlayer.setOutputMute(false);
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.updatePlayerVideoView(B1());
        }
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.preloadPacketDurationMs = 3000L;
        ISuperPlayer iSuperPlayer2 = this.mVideoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.openMediaPlayer(getMContext(), createVideoInfoForUrl, 0L, obtain);
        }
        N1();
        Object B12 = B1();
        Intrinsics.checkNotNull(B12, "null cannot be cast to non-null type android.view.View");
        ((View) B12).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.playvideo.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayVideoVB.W1(view);
            }
        });
        z1().post(new Runnable() { // from class: com.tencent.robot.aio.playvideo.o
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.X1(PlayVideoVB.this);
            }
        });
        QLog.i("PlayVideoVB", 1, "startPlayVideo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(final PlayVideoVB this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.aio.playvideo.c
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.R1(PlayVideoVB.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISuperPlayer iSuperPlayer = this$0.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
        com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
        HashMap hashMap = new HashMap();
        hashMap.put("action", "start");
        hashMap.put("spend", 0);
        Unit unit = Unit.INSTANCE;
        bVar.o("ev_bas_agent_novice_guide_video", hashMap);
        QLog.i("PlayVideoVB", 1, "mVideoPlayer?.start()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(final PlayVideoVB this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.aio.playvideo.e
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.T1(PlayVideoVB.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w1("end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U1(final ISuperPlayer iSuperPlayer, final PlayVideoVB this$0, ISuperPlayer iSuperPlayer2, int i3, int i16, int i17, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("PlayVideoVB", 1, "onError, player:" + iSuperPlayer2 + ", module:" + i3 + ", errorType:" + i16 + ", errorCode" + i17 + ", extraInfo:" + str);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.aio.playvideo.f
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.V1(ISuperPlayer.this, this$0);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V1(ISuperPlayer iSuperPlayer, PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        iSuperPlayer.stop();
        this$0.w1("fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(PlayVideoVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.d.f367297d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1() {
        View view;
        z1().setVisibility(8);
        Object B1 = B1();
        if (B1 instanceof View) {
            view = (View) B1;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        ISuperPlayer iSuperPlayer2 = this.mVideoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.release();
        }
        this.mVideoPlayer = null;
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mLoadingDialog = null;
        sendIntent(a.c.f367296d);
    }

    private final boolean v1() {
        View view;
        boolean z16;
        if (this.mVideoPlayer == null || z1().getVisibility() != 0) {
            return false;
        }
        Object B1 = B1();
        if (B1 instanceof View) {
            view = (View) B1;
        } else {
            view = null;
        }
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(String videoStatus) {
        long j3;
        if (!v1()) {
            QLog.i("PlayVideoVB", 1, "checkVideoIsActive false");
            return;
        }
        com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
        HashMap hashMap = new HashMap();
        hashMap.put("action", videoStatus);
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            j3 = iSuperPlayer.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        hashMap.put("spend", Long.valueOf(j3 / 1000));
        Unit unit = Unit.INSTANCE;
        bVar.o("ev_bas_agent_novice_guide_video", hashMap);
        a.GetVideoMsgViewInfo getVideoMsgViewInfo = new a.GetVideoMsgViewInfo(0, 0, 0, 0, 15, null);
        sendIntent(getVideoMsgViewInfo);
        int left = getVideoMsgViewInfo.getLeft();
        int top = getVideoMsgViewInfo.getTop();
        int width = getVideoMsgViewInfo.getWidth();
        int height = getVideoMsgViewInfo.getHeight();
        QLog.i("PlayVideoVB", 1, "targetWith " + width + " targetHeight " + height + " left = " + getVideoMsgViewInfo.getLeft() + " top = " + getVideoMsgViewInfo.getTop() + " videoStatus " + videoStatus);
        if (height != 0 && width != 0 && left > 0 && top > 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(z1(), HippyTKDListViewAdapter.X, left));
            animatorSet.play(ObjectAnimator.ofFloat(z1(), "y", top));
            ValueAnimator ofInt = ValueAnimator.ofInt(z1().getWidth(), width);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.aio.playvideo.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PlayVideoVB.x1(PlayVideoVB.this, valueAnimator);
                }
            });
            animatorSet.play(ofInt);
            ValueAnimator ofInt2 = ValueAnimator.ofInt(z1().getHeight(), height);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.aio.playvideo.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PlayVideoVB.y1(PlayVideoVB.this, valueAnimator);
                }
            });
            animatorSet.play(ofInt2);
            animatorSet.setInterpolator(D1());
            animatorSet.setDuration(300L);
            animatorSet.addListener(new b());
            animatorSet.start();
            return;
        }
        Y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(PlayVideoVB this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.z1().getLayoutParams();
        layoutParams.width = intValue;
        this$0.z1().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(PlayVideoVB this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.z1().getLayoutParams();
        layoutParams.height = intValue;
        this$0.z1().setLayoutParams(layoutParams);
    }

    private final FrameLayout z1() {
        return (FrameLayout) this.mContainerView.getValue();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PlayVideoUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof PlayVideoUIState.DismissVideoView) {
            w1("skip");
        } else {
            boolean z16 = true;
            if (state instanceof PlayVideoUIState.Pause) {
                StringBuilder sb5 = new StringBuilder("video pause ");
                ISuperPlayer iSuperPlayer = this.mVideoPlayer;
                if (iSuperPlayer != null) {
                    sb5.append("player not null ");
                    if (iSuperPlayer.isPlaying()) {
                        sb5.append("real pause");
                        iSuperPlayer.pause();
                    }
                }
                QLog.i("PlayVideoVB", 1, sb5.toString());
            } else if (state instanceof PlayVideoUIState.Resume) {
                StringBuilder sb6 = new StringBuilder("video start ");
                ISuperPlayer iSuperPlayer2 = this.mVideoPlayer;
                if (iSuperPlayer2 != null) {
                    sb6.append("player not null ");
                    if (iSuperPlayer2.isPausing()) {
                        iSuperPlayer2.start();
                        sb6.append("real start");
                    }
                }
                QLog.i("PlayVideoVB", 1, sb6.toString());
            } else if (state instanceof PlayVideoUIState.ConfigChange) {
                ISuperPlayer iSuperPlayer3 = this.mVideoPlayer;
                if (iSuperPlayer3 == null || !iSuperPlayer3.isPlaying()) {
                    z16 = false;
                }
                if (z16) {
                    N1();
                }
            }
        }
        super.handleUIState(state);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        ImageView imageView = null;
        a.GetVideoInfoIntent getVideoInfoIntent = new a.GetVideoInfoIntent(null, null, 3, null);
        sendIntent(getVideoInfoIntent);
        QLog.i("PlayVideoVB", 1, "videoUrl " + getVideoInfoIntent.getVideoUrl() + " imageUrl " + getVideoInfoIntent.getImageUrl() + " isSetCover " + this.isSetCover);
        String videoUrl = getVideoInfoIntent.getVideoUrl();
        String imageUrl = getVideoInfoIntent.getImageUrl();
        if (!TextUtils.isEmpty(videoUrl) && !F1()) {
            if (!this.isSetCover) {
                Bitmap b16 = AIOUtil.f366629a.b();
                if (b16 != null) {
                    ImageView imageView2 = this.mFirstFramePage;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFirstFramePage");
                    } else {
                        imageView = imageView2;
                    }
                    imageView.setImageBitmap(b16);
                } else {
                    O1(imageUrl);
                }
                this.isSetCover = true;
            }
            try {
                Intrinsics.checkNotNull(videoUrl);
                P1(videoUrl);
            } catch (Exception e16) {
                QLog.e("PlayVideoVB", 1, "startPlayVideo " + e16);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<a, PlayVideoUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new PlayVideoVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        boolean z16;
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof r.a) {
            Bundle bundle = new Bundle();
            boolean z17 = false;
            if (z1().getVisibility() == 0) {
                ISuperPlayer iSuperPlayer = this.mVideoPlayer;
                if (iSuperPlayer != null) {
                    z16 = iSuperPlayer.isPlaying();
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            bundle.putBoolean("is_palying", z17);
            return bundle;
        }
        return super.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        View view;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        AIOUtil aIOUtil = AIOUtil.f366629a;
        if (!aIOUtil.c()) {
            return z1();
        }
        try {
            Object B1 = B1();
            ImageView imageView = null;
            if (B1 instanceof View) {
                view = (View) B1;
            } else {
                view = null;
            }
            if (view != null) {
                z1().addView(view);
            }
            ImageView imageView2 = new ImageView(getMContext());
            imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setVisibility(0);
            Bitmap b16 = aIOUtil.b();
            if (b16 != null) {
                imageView2.setImageBitmap(b16);
                this.isSetCover = true;
            }
            this.mFirstFramePage = imageView2;
            FrameLayout z16 = z1();
            ImageView imageView3 = this.mFirstFramePage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFirstFramePage");
            } else {
                imageView = imageView3;
            }
            z16.addView(imageView);
            z1().addView(A1());
            z1().addView(C1());
        } catch (Exception e16) {
            QLog.e("PlayVideoVB", 1, "onCreateView " + e16);
            z1().removeAllViews();
        }
        return z1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        AIOUtil.f366629a.g(null);
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
        this.mVideoPlayer = null;
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mLoadingDialog = null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(@Nullable ISuperPlayer player, int what, long arg1, long arg2, @Nullable Object extra) {
        if (what != 105) {
            if (what != 112) {
                if (what == 113) {
                    J1();
                    return false;
                }
                return false;
            }
            L1();
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.aio.playvideo.b
            @Override // java.lang.Runnable
            public final void run() {
                PlayVideoVB.I1(PlayVideoVB.this);
            }
        });
        return false;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/aio/playvideo/PlayVideoVB$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            PlayVideoVB.this.Y1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            PlayVideoVB.this.Y1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            PlayVideoVB.this.A1().setVisibility(8);
            PlayVideoVB.this.C1().setVisibility(8);
            ISuperPlayer iSuperPlayer = PlayVideoVB.this.mVideoPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.pause();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}

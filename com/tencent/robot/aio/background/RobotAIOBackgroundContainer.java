package com.tencent.robot.aio.background;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.aio.background.api.IRobotBackgroundService;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002cdB\u001b\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J6\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u0006J\"\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000bJ\b\u0010$\u001a\u0004\u0018\u00010#J\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020\tJ\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0014J\b\u0010*\u001a\u00020\u0006H\u0014J\b\u0010+\u001a\u00020\u0006H\u0014J\u0006\u0010,\u001a\u00020\u0006J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0016J2\u00106\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020'2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\b\u00105\u001a\u0004\u0018\u000104H\u0016J2\u0010:\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-2\u0006\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0016R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010@R\u0016\u0010C\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010@R\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010@R\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010@R\u0016\u0010S\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010@R\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010=R\u0018\u0010X\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006e"}, d2 = {"Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "backgroundUrl", "", "p", "j", "g", "f", "B", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "l", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer$a;", "listener", "setBackgroundListener", "curFriendUin", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "enableDynamicBg", "isStoryAIO", "isProfile", "setInfo", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "r", "Landroid/graphics/drawable/Drawable;", "i", "o", h.F, "", "visibility", "onWindowVisibilityChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "t", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "onVideoPrepared", "what", "", "arg1", "arg2", "", "extra", "onInfo", "model", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "onError", "onCompletion", "d", "Ljava/lang/String;", "mCurRobotUin", "e", "Z", "mEnableDynamicBg", "mIsStoryAIO", "mIsProfile", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBackgroundImageView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/superplayer/api/ISuperPlayer;", "mVideoPlayer", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "mVideoView", "D", "mVideoPrepared", "E", "mVideoAutoDeInit", UserInfo.SEX_FEMALE, "mEnterAnimEnd", "G", "mDynamicUrl", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "mRobotCoreInfo", "I", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer$a;", "mListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "J", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAIOBackgroundContainer extends RelativeLayout implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnCompletionListener {

    /* renamed from: C */
    @Nullable
    private ISPlayerVideoView mVideoView;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mVideoPrepared;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mVideoAutoDeInit;

    /* renamed from: F */
    private boolean mEnterAnimEnd;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mDynamicUrl;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RobotCoreInfo mRobotCoreInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private a mListener;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private String mCurRobotUin;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean mEnableDynamicBg;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean mIsStoryAIO;

    /* renamed from: h */
    private boolean mIsProfile;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private ImageView mBackgroundImageView;

    /* renamed from: m */
    @Nullable
    private ISuperPlayer mVideoPlayer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer$a;", "", "", "success", "", "errMsg", "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a(boolean success, @NotNull String errMsg);

        void b(boolean success, @NotNull String errMsg);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotAIOBackgroundContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurRobotUin = "";
        this.mEnableDynamicBg = true;
        this.mDynamicUrl = "";
    }

    private final void A() {
        boolean z16;
        ArrayList arrayListOf;
        if (this.mEnableDynamicBg) {
            if (this.mDynamicUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || l()) {
                return;
            }
            QLog.d("RobotAIOBackgroundContainer", 1, "updateBackgroundVideo");
            if (this.mVideoView == null) {
                this.mVideoView = SuperPlayerFactory.createPlayerVideoView(getContext());
                int indexOfChild = indexOfChild(this.mBackgroundImageView) + 1;
                Object obj = this.mVideoView;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                addView((View) obj, indexOfChild, new RelativeLayout.LayoutParams(-1, -1));
            }
            ISuperPlayer iSuperPlayer = this.mVideoPlayer;
            if (iSuperPlayer == null) {
                ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(getContext(), 168, this.mVideoView);
                createMediaPlayer.setXYaxis(2);
                createMediaPlayer.setOutputMute(true);
                createMediaPlayer.setOnErrorListener(this);
                createMediaPlayer.setOnInfoListener(this);
                createMediaPlayer.setOnVideoPreparedListener(this);
                createMediaPlayer.setOnCompletionListener(this);
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_AUDIO_RENDERER_TYPE, new int[]{-1}));
                createMediaPlayer.setPlayerOptionalParamList(arrayListOf);
                createMediaPlayer.setBusinessDownloadStrategy(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
                this.mVideoPlayer = createMediaPlayer;
            } else if (iSuperPlayer != null) {
                iSuperPlayer.reset();
            }
            ISuperPlayer iSuperPlayer2 = this.mVideoPlayer;
            if (iSuperPlayer2 != null) {
                iSuperPlayer2.updatePlayerVideoView(this.mVideoView);
            }
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.mDynamicUrl, 101, (String) null);
            ISuperPlayer iSuperPlayer3 = this.mVideoPlayer;
            if (iSuperPlayer3 != null) {
                iSuperPlayer3.openMediaPlayer(getContext(), createVideoInfoForUrl, 0L);
            }
        }
    }

    private final void B() {
        Activity activity;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            QUIImmersiveHelper.u(activity.getWindow(), true, true);
        }
    }

    private final void f() {
        Integer num;
        String str = this.mCurRobotUin;
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            num = Integer.valueOf(iSuperPlayer.getCurrentPlayerState());
        } else {
            num = null;
        }
        QLog.i("RobotAIOBackgroundContainer", 1, "backgroundPause uin=" + str + " state=" + num);
        ISuperPlayer iSuperPlayer2 = this.mVideoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.pause();
        }
    }

    private final void g() {
        Integer num;
        String str = this.mCurRobotUin;
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            num = Integer.valueOf(iSuperPlayer.getCurrentPlayerState());
        } else {
            num = null;
        }
        boolean z16 = true;
        QLog.i("RobotAIOBackgroundContainer", 1, "backgroundResume uin=" + str + " state=" + num);
        if (!this.mVideoAutoDeInit) {
            ISuperPlayer iSuperPlayer2 = this.mVideoPlayer;
            if (iSuperPlayer2 == null || iSuperPlayer2.getCurrentPlayerState() != 6) {
                z16 = false;
            }
            if (z16) {
                x();
            }
        }
    }

    private final String j() {
        String stringExtra;
        boolean z16;
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Intent intent = ((Activity) context).getIntent();
        if (intent == null) {
            return "";
        }
        if (QQTheme.isNowThemeIsNight()) {
            stringExtra = intent.getStringExtra("key_night_dynamic_bg");
        } else {
            stringExtra = intent.getStringExtra("key_day_dynamic_bg");
        }
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && !this.mIsStoryAIO) {
            if (QQTheme.isNowThemeIsNight()) {
                RobotCoreInfo robotCoreInfo = this.mRobotCoreInfo;
                if (robotCoreInfo != null) {
                    stringExtra = com.tencent.robot.profile.utils.a.u(robotCoreInfo, this.mIsProfile);
                }
                stringExtra = null;
            } else {
                RobotCoreInfo robotCoreInfo2 = this.mRobotCoreInfo;
                if (robotCoreInfo2 != null) {
                    stringExtra = com.tencent.robot.profile.utils.a.n(robotCoreInfo2, this.mIsProfile);
                }
                stringExtra = null;
            }
        }
        if (stringExtra == null) {
            return "";
        }
        return stringExtra;
    }

    private final void k() {
        if (this.mBackgroundImageView != null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mBackgroundImageView = imageView;
        addView(imageView, 0);
    }

    private final boolean l() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(getContext(), new SDKInitListener() { // from class: com.tencent.robot.aio.background.d
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    RobotAIOBackgroundContainer.m(RobotAIOBackgroundContainer.this, z16);
                }
            });
            return true;
        }
        return false;
    }

    public static final void m(RobotAIOBackgroundContainer this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.post(new Runnable() { // from class: com.tencent.robot.aio.background.e
                @Override // java.lang.Runnable
                public final void run() {
                    RobotAIOBackgroundContainer.n(RobotAIOBackgroundContainer.this);
                }
            });
        } else {
            QLog.e("RobotAIOBackgroundContainer", 1, "initVideoSDK failed");
        }
    }

    public static final void n(RobotAIOBackgroundContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    private final boolean p(String backgroundUrl) {
        Drawable drawable;
        Object obj;
        String str;
        URL url;
        ImageView imageView = this.mBackgroundImageView;
        URLDrawable uRLDrawable = null;
        if (imageView != null) {
            drawable = imageView.getDrawable();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return true;
        }
        ImageView imageView2 = this.mBackgroundImageView;
        if (imageView2 != null) {
            obj = imageView2.getDrawable();
        } else {
            obj = null;
        }
        if (obj instanceof URLDrawable) {
            uRLDrawable = (URLDrawable) obj;
        }
        if (uRLDrawable == null || (url = uRLDrawable.getURL()) == null || (str = url.toString()) == null) {
            str = "";
        }
        boolean z16 = !Intrinsics.areEqual(str, backgroundUrl);
        QLog.d("RobotAIOBackgroundContainer", 1, "oldUrl=" + str + " newUrl=" + backgroundUrl);
        return z16;
    }

    private final void q() {
        String h16 = h();
        this.mDynamicUrl = j();
        if (p(h16)) {
            QLog.i("RobotAIOBackgroundContainer", 1, "loadBackgroundFromCache uin = " + this.mCurRobotUin + " update background");
            y(h16);
        }
        A();
        B();
    }

    public static /* synthetic */ void s(RobotAIOBackgroundContainer robotAIOBackgroundContainer, GroupRobotProfile groupRobotProfile, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        robotAIOBackgroundContainer.r(groupRobotProfile, z16, z17);
    }

    public static /* synthetic */ void setInfo$default(RobotAIOBackgroundContainer robotAIOBackgroundContainer, String str, RobotCoreInfo robotCoreInfo, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        boolean z19;
        boolean z26;
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        boolean z27 = z16;
        if ((i3 & 8) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        if ((i3 & 16) != 0) {
            z26 = false;
        } else {
            z26 = z18;
        }
        robotAIOBackgroundContainer.setInfo(str, robotCoreInfo, z27, z19, z26);
    }

    public static final void v(RobotAIOBackgroundContainer this$0, String str) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = this$0.mVideoView;
        if (obj instanceof View) {
            view = (View) obj;
        } else {
            view = null;
        }
        this$0.removeView(view);
        this$0.mVideoView = null;
        a aVar = this$0.mListener;
        if (aVar != null) {
            if (str == null) {
                str = "";
            }
            aVar.a(false, str);
        }
    }

    public static final void w(RobotAIOBackgroundContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.mListener;
        if (aVar != null) {
            aVar.a(true, "");
        }
    }

    private final void x() {
        if (this.mEnableDynamicBg && this.mVideoPrepared && this.mEnterAnimEnd) {
            QLog.d("RobotAIOBackgroundContainer", 1, "startPlay");
            ISuperPlayer iSuperPlayer = this.mVideoPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.start();
            }
        }
    }

    private final void y(final String backgroundUrl) {
        boolean z16;
        k();
        ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(getContext(), R.color.qui_common_bg_aio_01));
        QLog.d("RobotAIOBackgroundContainer", 1, "updateBackgroundDrawable url=" + backgroundUrl);
        if (backgroundUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView imageView = this.mBackgroundImageView;
            if (imageView != null) {
                imageView.setImageDrawable(colorDrawable);
            }
            a aVar = this.mListener;
            if (aVar != null) {
                aVar.b(true, "");
                return;
            }
            return;
        }
        Option url = Option.obtain().setTargetView(this.mBackgroundImageView).setUrl(backgroundUrl);
        url.setLoadingDrawable(colorDrawable);
        url.setFailedDrawable(colorDrawable);
        QQPicLoader.f201806a.d().loadImage(url, new IPicLoadStateListener() { // from class: com.tencent.robot.aio.background.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                RobotAIOBackgroundContainer.z(RobotAIOBackgroundContainer.this, backgroundUrl, loadState, option);
            }
        });
    }

    public static final void z(RobotAIOBackgroundContainer this$0, String backgroundUrl, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(backgroundUrl, "$backgroundUrl");
        if (loadState.isFinishSuccess()) {
            if (this$0.isAttachedToWindow()) {
                this$0.B();
            }
            a aVar = this$0.mListener;
            if (aVar != null) {
                aVar.b(true, "");
                return;
            }
            return;
        }
        if (loadState.isFinishError()) {
            QLog.i("RobotAIOBackgroundContainer", 1, "load failed url = " + backgroundUrl);
            a aVar2 = this$0.mListener;
            if (aVar2 != null) {
                aVar2.b(false, "error");
            }
        }
    }

    @NotNull
    public final String h() {
        IRuntimeService iRuntimeService;
        String backgroundUrlFromCache;
        String stringExtra;
        boolean z16;
        if (!this.mIsProfile) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Intent intent = ((Activity) context).getIntent();
            if (intent == null) {
                return "";
            }
            if (QQTheme.isNowThemeIsNight()) {
                stringExtra = intent.getStringExtra("key_night_bg");
            } else {
                stringExtra = intent.getStringExtra("key_day_bg");
            }
            if (stringExtra != null && stringExtra.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return stringExtra;
            }
        }
        if (this.mIsStoryAIO) {
            return "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotBackgroundService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotBackgroundService iRobotBackgroundService = (IRobotBackgroundService) iRuntimeService;
        if (iRobotBackgroundService == null || (backgroundUrlFromCache = iRobotBackgroundService.getBackgroundUrlFromCache(this.mCurRobotUin, this.mRobotCoreInfo, this.mIsProfile)) == null) {
            return "";
        }
        return backgroundUrlFromCache;
    }

    @Nullable
    public final Drawable i() {
        ImageView imageView = this.mBackgroundImageView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public final boolean o() {
        boolean z16;
        Drawable i3 = i();
        if (i3 != null && !(i3 instanceof ColorDrawable)) {
            return false;
        }
        if (this.mDynamicUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        QLog.i("RobotAIOBackgroundContainer", 1, "onAttachedToWindow uin = " + this.mCurRobotUin);
        super.onAttachedToWindow();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(@NotNull ISuperPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        QLog.d("RobotAIOBackgroundContainer", 1, "video onCompletion");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QLog.i("RobotAIOBackgroundContainer", 1, "onDetachedFromWindow uin = " + this.mCurRobotUin);
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(@NotNull ISuperPlayer player, int model, int r46, int errorCode, @Nullable final String extra) {
        Intrinsics.checkNotNullParameter(player, "player");
        QLog.e("RobotAIOBackgroundContainer", 1, "video onError: " + model + " " + r46 + " " + errorCode + " " + extra);
        post(new Runnable() { // from class: com.tencent.robot.aio.background.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotAIOBackgroundContainer.v(RobotAIOBackgroundContainer.this, extra);
            }
        });
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(@NotNull ISuperPlayer player, int what, long arg1, long arg2, @Nullable Object extra) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (QLog.isDevelopLevel()) {
            QLog.d("RobotAIOBackgroundContainer", 4, "video onInfo: " + what + " " + arg1 + " " + arg2 + " " + extra);
        }
        if (what == 253) {
            this.mVideoAutoDeInit = true;
            return false;
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(@NotNull ISuperPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        QLog.d("RobotAIOBackgroundContainer", 1, "video onPrepared");
        this.mVideoPrepared = true;
        x();
        post(new Runnable() { // from class: com.tencent.robot.aio.background.b
            @Override // java.lang.Runnable
            public final void run() {
                RobotAIOBackgroundContainer.w(RobotAIOBackgroundContainer.this);
            }
        });
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        QLog.i("RobotAIOBackgroundContainer", 1, "onWindowVisibilityChanged uin = " + this.mCurRobotUin + " visibility = " + visibility);
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            g();
        } else {
            f();
        }
    }

    public final void r(@NotNull GroupRobotProfile robotProfile, boolean isStoryAIO, boolean isProfile) {
        String i3;
        String m3;
        boolean z16;
        String dayBackground;
        String dayDynamicPic;
        Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
        if (QQTheme.isNowThemeIsNight()) {
            i3 = com.tencent.robot.profile.utils.a.p(robotProfile, isProfile);
            m3 = com.tencent.robot.profile.utils.a.t(robotProfile, isProfile);
        } else {
            i3 = com.tencent.robot.profile.utils.a.i(robotProfile, isProfile);
            m3 = com.tencent.robot.profile.utils.a.m(robotProfile, isProfile);
        }
        this.mIsStoryAIO = isStoryAIO;
        boolean z17 = true;
        if (isStoryAIO) {
            StoryUtils storyUtils = StoryUtils.f366640a;
            String robotUid = robotProfile.robotData.getRobotUid();
            Intrinsics.checkNotNullExpressionValue(robotUid, "robotProfile.robotData.getRobotUid()");
            StoryBaseInfo q16 = storyUtils.q(robotUid);
            QLog.i("RobotAIOBackgroundContainer", 1, "onBackgroundInfoUpdate " + q16);
            if (q16 != null) {
                if (QQTheme.isNowThemeIsNight()) {
                    dayBackground = q16.nightBackground;
                    Intrinsics.checkNotNullExpressionValue(dayBackground, "nightBackground");
                    dayDynamicPic = q16.nightDynamicPic;
                    Intrinsics.checkNotNullExpressionValue(dayDynamicPic, "nightDynamicPic");
                } else {
                    dayBackground = q16.dayBackground;
                    Intrinsics.checkNotNullExpressionValue(dayBackground, "dayBackground");
                    dayDynamicPic = q16.dayDynamicPic;
                    Intrinsics.checkNotNullExpressionValue(dayDynamicPic, "dayDynamicPic");
                }
                m3 = dayDynamicPic;
                i3 = dayBackground;
            }
        }
        if (i3 != null && i3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && p(i3)) {
            y(i3);
        }
        if (m3 != null && m3.length() != 0) {
            z17 = false;
        }
        if (!z17 && !Intrinsics.areEqual(m3, this.mDynamicUrl)) {
            this.mDynamicUrl = m3;
            A();
        }
    }

    public final void setBackgroundListener(@Nullable a listener) {
        this.mListener = listener;
    }

    public final void setInfo(@NotNull String curFriendUin, @Nullable RobotCoreInfo robotCoreInfo, boolean enableDynamicBg, boolean isStoryAIO, boolean isProfile) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        this.mCurRobotUin = curFriendUin;
        this.mRobotCoreInfo = robotCoreInfo;
        this.mEnableDynamicBg = enableDynamicBg;
        this.mIsStoryAIO = isStoryAIO;
        this.mIsProfile = isProfile;
        QLog.i("RobotAIOBackgroundContainer", 1, "setInfo mCurRobotUin = " + curFriendUin);
        q();
    }

    public final void t() {
        QLog.i("RobotAIOBackgroundContainer", 1, "onDestroy uin = " + this.mCurRobotUin);
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
        this.mVideoPlayer = null;
        this.mVideoPrepared = false;
        this.mVideoAutoDeInit = false;
        this.mEnterAnimEnd = false;
        this.mCurRobotUin = "";
        this.mDynamicUrl = "";
        this.mIsStoryAIO = false;
        ImageView imageView = this.mBackgroundImageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
    }

    public final void u() {
        if (this.mEnterAnimEnd) {
            return;
        }
        QLog.d("RobotAIOBackgroundContainer", 1, "onEnterAnimationEnd");
        this.mEnterAnimEnd = true;
        x();
    }

    public /* synthetic */ RobotAIOBackgroundContainer(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}

package com.tencent.mobileqq.zplan.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0002MNB'\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\n\u001a\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002R\u0014\u0010#\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView;", "Landroid/widget/FrameLayout;", "", "k", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "callback", "p", "o", "", "url", "Landroid/graphics/drawable/Drawable;", "l", "B", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", ReportConstant.COSTREPORT_PREFIX, "drawable", "setDefaultLoadingDrawable", "setImageDrawable", "Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView$b;", "params", HippyTKDListViewAdapter.X, "w", "v", "u", "d", "Landroid/widget/FrameLayout;", "videoContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "picture", "Lcom/tencent/superplayer/api/ISuperPlayer;", "f", "Lcom/tencent/superplayer/api/ISuperPlayer;", "videoPlayer", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", tl.h.F, "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "i", "Z", "isPlaySDKReady", "Landroid/graphics/drawable/Drawable;", "defaultLoadingDrawable", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView$b;", "mCurrentParam", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "D", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "superPlayerOnErrorListener", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "E", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "superPlayerOnVideoPreparedListener", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", UserInfo.SEX_FEMALE, "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "superPlayerOnInfoListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSuperBackgroundView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private SuperParam mCurrentParam;

    /* renamed from: D, reason: from kotlin metadata */
    private ISuperPlayer.OnErrorListener superPlayerOnErrorListener;

    /* renamed from: E, reason: from kotlin metadata */
    private ISuperPlayer.OnVideoPreparedListener superPlayerOnVideoPreparedListener;

    /* renamed from: F, reason: from kotlin metadata */
    private ISuperPlayer.OnInfoListener superPlayerOnInfoListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout videoContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView picture;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ISuperPlayer videoPlayer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ISPlayerVideoView videoView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPlaySDKReady;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Drawable defaultLoadingDrawable;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/ZPlanSuperBackgroundView$b;", "", "", "c", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "picUrl", "b", AppConstants.Key.KEY_QZONE_VIDEO_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.view.ZPlanSuperBackgroundView$b, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class SuperParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String picUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String videoUrl;

        public SuperParam() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final String getPicUrl() {
            return this.picUrl;
        }

        /* renamed from: b, reason: from getter */
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public final boolean c() {
            String str = this.picUrl;
            return !(str == null || str.length() == 0);
        }

        public int hashCode() {
            String str = this.picUrl;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.videoUrl;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SuperParam(picUrl=" + this.picUrl + ", videoUrl=" + this.videoUrl + ")";
        }

        public SuperParam(String str, String str2) {
            this.picUrl = str;
            this.videoUrl = str2;
        }

        public /* synthetic */ SuperParam(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuperParam)) {
                return false;
            }
            SuperParam superParam = (SuperParam) other;
            return Intrinsics.areEqual(this.picUrl, superParam.picUrl) && Intrinsics.areEqual(this.videoUrl, superParam.videoUrl);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanSuperBackgroundView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        this.picture.setVisibility(0);
    }

    private final void B() {
        this.videoContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(final ZPlanSuperBackgroundView this$0, ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("ZPlanSuperBackgroundView", 1, "onError module=" + i3 + ", errorType=" + i16 + ", errorCode=" + i17 + ", errorMsg=" + str);
        this$0.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.view.i
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSuperBackgroundView.D(ZPlanSuperBackgroundView.this);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(ZPlanSuperBackgroundView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(final ZPlanSuperBackgroundView this$0, ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanSuperBackgroundView", 1, "onInfo what=" + i3 + ", arg1=" + j3 + ", arg2=" + j16 + ", extra=" + obj);
        if (i3 != 105) {
            return false;
        }
        this$0.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.view.j
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSuperBackgroundView.F(ZPlanSuperBackgroundView.this);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(ZPlanSuperBackgroundView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final ZPlanSuperBackgroundView this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanSuperBackgroundView", 1, "onVideoPrepared");
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
        this$0.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.view.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSuperBackgroundView.H(ZPlanSuperBackgroundView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ZPlanSuperBackgroundView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k() {
        if (this.videoView != null) {
            return;
        }
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(getContext());
        this.videoView = createPlayerVideoView;
        this.videoContainer.addView((View) createPlayerVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void m() {
        this.picture.setVisibility(8);
    }

    private final void n() {
        this.videoContainer.setVisibility(8);
    }

    private final void o() {
        if (this.videoPlayer != null) {
            return;
        }
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(getContext(), 140, this.videoView);
        createMediaPlayer.setXYaxis(2);
        createMediaPlayer.setOutputMute(true);
        createMediaPlayer.setLoopback(true);
        ISuperPlayer.OnErrorListener onErrorListener = this.superPlayerOnErrorListener;
        if (onErrorListener != null) {
            createMediaPlayer.setOnErrorListener(onErrorListener);
        }
        ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener = this.superPlayerOnVideoPreparedListener;
        if (onVideoPreparedListener != null) {
            createMediaPlayer.setOnVideoPreparedListener(onVideoPreparedListener);
        }
        ISuperPlayer.OnInfoListener onInfoListener = this.superPlayerOnInfoListener;
        if (onInfoListener != null) {
            createMediaPlayer.setOnInfoListener(onInfoListener);
        }
        this.videoPlayer = createMediaPlayer;
    }

    private final void p(final Function1<? super Boolean, Unit> callback) {
        if (this.isPlaySDKReady) {
            callback.invoke(Boolean.TRUE);
            return;
        }
        boolean isSDKReady = QQVideoPlaySDKManager.isSDKReady();
        this.isPlaySDKReady = isSDKReady;
        if (!isSDKReady) {
            QQVideoPlaySDKManager.initSDKAsync(getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.zplan.view.k
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    ZPlanSuperBackgroundView.q(ZPlanSuperBackgroundView.this, callback, z16);
                }
            });
            return;
        }
        k();
        o();
        callback.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final ZPlanSuperBackgroundView this$0, final Function1 callback, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("ZPlanSuperBackgroundView", 1, "initSDKAsync isSucceed=" + z16);
        this$0.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.view.l
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSuperBackgroundView.r(ZPlanSuperBackgroundView.this, z16, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ZPlanSuperBackgroundView this$0, boolean z16, Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.isPlaySDKReady = z16;
        if (z16) {
            this$0.k();
            this$0.o();
            callback.invoke(Boolean.TRUE);
        } else {
            callback.invoke(Boolean.FALSE);
            QLog.e("ZPlanSuperBackgroundView", 1, "initSDKAsync error");
        }
    }

    private final boolean s() {
        return this.isPlaySDKReady && this.videoPlayer != null && this.picture.getVisibility() == 8;
    }

    private final void t(String url) {
        QLog.i("ZPlanSuperBackgroundView", 1, "loadStaticPic, url=" + url);
        A();
        this.picture.setImageDrawable(l(url));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String url) {
        QLog.i("ZPlanSuperBackgroundView", 1, "showVideo, url=" + url);
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(url, 101, "");
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.isPrePlay = true;
        z();
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        ISuperPlayer iSuperPlayer2 = this.videoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.reset();
        }
        ISuperPlayer iSuperPlayer3 = this.videoPlayer;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setLoopback(true);
        }
        ISuperPlayer iSuperPlayer4 = this.videoPlayer;
        if (iSuperPlayer4 != null) {
            iSuperPlayer4.openMediaPlayer(getContext(), createVideoInfoForUrl, 0L, obtain);
        }
    }

    private final void z() {
        ArrayList arrayList = new ArrayList();
        TPOptionalParam<int[]> buildQueueInt = TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_AUDIO_RENDERER_TYPE, new int[]{-1});
        Intrinsics.checkNotNullExpressionValue(buildQueueInt, "buildQueueInt(\n         \u2026_TYPE_NONE)\n            )");
        arrayList.add(buildQueueInt);
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlayerOptionalParamList(arrayList);
        }
    }

    public final void setDefaultLoadingDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.defaultLoadingDrawable = drawable;
    }

    public final void setImageDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.picture.setImageDrawable(drawable);
    }

    public final void u() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        ISuperPlayer iSuperPlayer2 = this.videoPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.release();
        }
        ISuperPlayer iSuperPlayer3 = this.videoPlayer;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setOnErrorListener(null);
        }
        ISuperPlayer iSuperPlayer4 = this.videoPlayer;
        if (iSuperPlayer4 != null) {
            iSuperPlayer4.setOnVideoPreparedListener(null);
        }
        ISuperPlayer iSuperPlayer5 = this.videoPlayer;
        if (iSuperPlayer5 != null) {
            iSuperPlayer5.setOnInfoListener(null);
        }
        this.videoPlayer = null;
        Object obj = this.videoView;
        if (obj != null) {
            this.videoContainer.removeView((View) obj);
        }
        this.videoView = null;
        this.defaultLoadingDrawable = null;
        this.superPlayerOnErrorListener = null;
        this.superPlayerOnVideoPreparedListener = null;
        this.superPlayerOnInfoListener = null;
    }

    public final void v() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
    }

    public final void w() {
        ISuperPlayer iSuperPlayer;
        if (!s() || (iSuperPlayer = this.videoPlayer) == null) {
            return;
        }
        iSuperPlayer.start();
    }

    public final void x(final SuperParam params) {
        Intrinsics.checkNotNullParameter(params, "params");
        SuperParam superParam = this.mCurrentParam;
        boolean z16 = true;
        if (superParam != null && superParam.equals(params)) {
            return;
        }
        n();
        t(params.getPicUrl());
        String videoUrl = params.getVideoUrl();
        if (videoUrl != null && videoUrl.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            n();
            p(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.view.ZPlanSuperBackgroundView$play$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    if (z17) {
                        ZPlanSuperBackgroundView.this.y(params.getVideoUrl());
                    } else {
                        ZPlanSuperBackgroundView.this.A();
                    }
                }
            });
        } else {
            ISuperPlayer iSuperPlayer = this.videoPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.pause();
            }
        }
        this.mCurrentParam = params;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanSuperBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanSuperBackgroundView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanSuperBackgroundView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.superPlayerOnErrorListener = new ISuperPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.zplan.view.e
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i16, int i17, int i18, String str) {
                boolean C;
                C = ZPlanSuperBackgroundView.C(ZPlanSuperBackgroundView.this, iSuperPlayer, i16, i17, i18, str);
                return C;
            }
        };
        this.superPlayerOnVideoPreparedListener = new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.mobileqq.zplan.view.f
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                ZPlanSuperBackgroundView.G(ZPlanSuperBackgroundView.this, iSuperPlayer);
            }
        };
        this.superPlayerOnInfoListener = new ISuperPlayer.OnInfoListener() { // from class: com.tencent.mobileqq.zplan.view.g
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
            public final boolean onInfo(ISuperPlayer iSuperPlayer, int i16, long j3, long j16, Object obj) {
                boolean E;
                E = ZPlanSuperBackgroundView.E(ZPlanSuperBackgroundView.this, iSuperPlayer, i16, j3, j16, obj);
                return E;
            }
        };
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackground(new ColorDrawable(0));
        this.videoContainer = frameLayout;
        addView(frameLayout);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.picture = imageView;
        addView(imageView);
    }

    private final Drawable l(String url) {
        URLDrawable uRLDrawable;
        if (url == null || url.length() == 0) {
            return this.defaultLoadingDrawable;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = this.defaultLoadingDrawable;
        try {
            uRLDrawable = URLDrawable.getDrawable(url, obtain);
        } catch (Throwable th5) {
            th = th5;
            uRLDrawable = null;
        }
        try {
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
        } catch (Throwable th6) {
            th = th6;
            QLog.e("ZPlanSuperBackgroundView", 1, "getDrawable: " + url, th);
            return uRLDrawable;
        }
        return uRLDrawable;
    }
}

package com.tencent.sqshow.zootopia.player;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.b;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.VideoUtils;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 k2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001AB)\b\u0007\u0012\b\u0010e\u001a\u0004\u0018\u00010d\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010f\u0012\b\b\u0002\u0010h\u001a\u00020\u0015\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015J\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 J\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0015J@\u0010,\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020\u00072\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010*J6\u0010-\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00152\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010*J\u0010\u0010.\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010/\u001a\u00020\u0005J\u001a\u00101\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u0007J\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0005J\b\u00105\u001a\u0004\u0018\u000104J\b\u00106\u001a\u0004\u0018\u00010\u001eJ\u000e\u00107\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001eJ\u0012\u00109\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010:\u001a\u00020\u0005J\b\u0010;\u001a\u00020\u0005H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0014J\b\u0010?\u001a\u00020\u0005H\u0014J\b\u0010@\u001a\u00020\u0005H\u0016J\b\u0010A\u001a\u00020\u0005H\u0016J\b\u0010B\u001a\u00020\u0005H\u0016J\u001a\u0010E\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00152\b\u0010D\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010H\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010I\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010J\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010FH\u0016R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR$\u00108\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010c\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b\u00a8\u0006l"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/ZootopiaPlayerView;", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "Lcom/tencent/sqshow/zootopia/player/a;", "Lcom/tencent/sqshow/zootopia/player/b;", "Lcom/tencent/superplayer/view/ISPlayerVideoView$IVideoViewCallBack;", "", "u", "", "isBanner", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "currentVideoView", "i", "k", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setScaleType", "adjust", "setAdjustViewBounds", "Lcom/tencent/sqshow/zootopia/player/c;", "r", "", "radius", "setBackgroundRadius", "Landroid/widget/ImageView;", DomainData.DOMAIN_NAME, "containerHeight", "videoWidth", "videoHeight", "j", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "setMediaLoadingDrawable", "setDefaultBackground", "xYaxis", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "url", "requestWidth", "requestHeight", "needUrlTag", "Lkotlin/Function0;", "loadCallback", "setApngBackgroundUrl", "setCoverUrl", "setVideoUrl", "l", "isOutputMute", "y", "B", "v", "Lcom/tencent/sqshow/zootopia/player/PlayStatus;", "o", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "player", "w", "g", "onRecycle", "c", "onFirstFrameCome", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "b", "a", "onRelease", "errorCode", "msg", "onError", "", "p0", "onSurfaceCreated", "onSurfaceDestroy", "onSurfaceChanged", "Lcom/tencent/image/URLImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/image/URLImageView;", "coverImage", "D", "Ljava/lang/String;", "coverUrl", "E", AppConstants.Key.KEY_QZONE_VIDEO_URL, UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/player/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/sqshow/zootopia/player/c;", HippyTKDListViewAdapter.X, "(Lcom/tencent/sqshow/zootopia/player/c;)V", "G", "Z", "H", "Landroid/graphics/drawable/Drawable;", "I", "t", "()I", "setVideoXYaxis", "(I)V", "videoXYaxis", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ZootopiaPlayerView extends RoundRelativeLayout implements a, com.tencent.sqshow.zootopia.player.b, ISPlayerVideoView.IVideoViewCallBack {

    /* renamed from: C */
    private URLImageView coverImage;

    /* renamed from: D, reason: from kotlin metadata */
    private String coverUrl;

    /* renamed from: E, reason: from kotlin metadata */
    private String com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String;

    /* renamed from: F */
    private com.tencent.sqshow.zootopia.player.c player;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isBanner;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable defaultDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private int videoXYaxis;

    public ZootopiaPlayerView(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(ISPlayerVideoView iSPlayerVideoView, ViewParent viewParent, ZootopiaPlayerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(iSPlayerVideoView, "null cannot be cast to non-null type com.tencent.superplayer.view.ISPlayerVideoView");
        iSPlayerVideoView.disableViewCallback();
        Intrinsics.checkNotNull(viewParent, "null cannot be cast to non-null type android.view.ViewGroup");
        View view = (View) iSPlayerVideoView;
        ((ViewGroup) viewParent).removeView(view);
        this$0.i(view);
        QLog.d("ZootopiaPlayerView", 1, "post [addVideoView] player  ready");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i(View currentVideoView) {
        Intrinsics.checkNotNull(currentVideoView, "null cannot be cast to non-null type com.tencent.superplayer.view.ISPlayerVideoView");
        ((ISPlayerVideoView) currentVideoView).enableViewCallback();
        addView(currentVideoView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private final void m(boolean z16) {
        com.tencent.sqshow.zootopia.player.c c16;
        if (z16) {
            h hVar = h.f372229a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            c16 = hVar.b(context);
        } else {
            h hVar2 = h.f372229a;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            c16 = hVar2.c(context2);
        }
        this.player = c16;
        if (c16 != null) {
            c16.recycle();
        }
        w(this.player);
    }

    private final void u() {
        URLImageView uRLImageView = new URLImageView(getContext());
        this.coverImage = uRLImageView;
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        URLImageView uRLImageView2 = this.coverImage;
        if (uRLImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverImage");
            uRLImageView2 = null;
        }
        addView(uRLImageView2, -1, -1);
    }

    public final void A(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ApngImage.pauseByTag(url.hashCode());
    }

    public final void B() {
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar != null) {
            cVar.pause();
        }
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void a() {
        QLog.i("ZootopiaPlayerView", 1, this + " onReset");
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void b() {
        QLog.i("ZootopiaPlayerView", 1, this + " onPlayCompleted");
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void c(String url) {
        QLog.i("ZootopiaPlayerView", 1, "onPreparing " + url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.tencent.superplayer.view.ISPlayerVideoView, java.lang.Object] */
    public final void g() {
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar == null) {
            return;
        }
        boolean z16 = false;
        if (cVar != null && cVar.isReady()) {
            z16 = true;
        }
        if (!z16) {
            QLog.w("ZootopiaPlayerView", 1, "[addVideoView] player not ready");
            return;
        }
        k();
        com.tencent.sqshow.zootopia.player.c cVar2 = this.player;
        final View superPlayerView = cVar2 != null ? cVar2.getSuperPlayerView() : 0;
        Intrinsics.checkNotNull(superPlayerView, "null cannot be cast to non-null type android.view.View");
        final ViewParent parent = superPlayerView.getParent();
        if (parent != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.player.i
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaPlayerView.h(ISPlayerVideoView.this, parent, this);
                }
            });
            return;
        }
        superPlayerView.disableViewCallback();
        i(superPlayerView);
        QLog.d("ZootopiaPlayerView", 1, "[addVideoView] player  ready");
    }

    public final void j(int containerHeight, int videoWidth, int videoHeight) {
        VideoUtils.f373236a.q(containerHeight, n(), videoWidth, videoHeight);
        ImageView n3 = n();
        if (n3 != null) {
            n3.requestLayout();
        }
    }

    public final void l() {
        QLog.i("ZootopiaPlayerView", 1, this + " clear " + this.com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String);
        this.com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String = null;
        this.coverUrl = null;
        URLImageView uRLImageView = this.coverImage;
        if (uRLImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverImage");
            uRLImageView = null;
        }
        uRLImageView.setImageDrawable(null);
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar != null) {
            cVar.pause();
        }
    }

    public final ImageView n() {
        URLImageView uRLImageView = this.coverImage;
        if (uRLImageView != null) {
            return uRLImageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coverImage");
        return null;
    }

    public final PlayStatus o() {
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar != null) {
            return cVar.getCurrStatus();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        com.tencent.sqshow.zootopia.player.c cVar;
        ISPlayerVideoView superPlayerView;
        ISPlayerVideoView superPlayerView2;
        super.onAttachedToWindow();
        if (this.isBanner) {
            com.tencent.sqshow.zootopia.player.c cVar2 = this.player;
            if (cVar2 != null && (superPlayerView2 = cVar2.getSuperPlayerView()) != null) {
                superPlayerView2.enableViewCallback();
            }
            com.tencent.sqshow.zootopia.player.c cVar3 = this.player;
            if (cVar3 != null && (superPlayerView = cVar3.getSuperPlayerView()) != null) {
                superPlayerView.disableViewCallback();
            }
            String str = this.com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String;
            if (str != null && (cVar = this.player) != null) {
                cVar.startPlay(str);
            }
        }
        QLog.i("ZootopiaPlayerView", 1, this + " onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.tencent.sqshow.zootopia.player.c cVar;
        super.onDetachedFromWindow();
        if (this.isBanner && (cVar = this.player) != null) {
            cVar.pause();
        }
        QLog.i("ZootopiaPlayerView", 1, this + " onDetachedFromWindow");
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void onError(int errorCode, String msg2) {
        QLog.i("ZootopiaPlayerView", 1, this + " onError " + errorCode + ", " + msg2);
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void onPause() {
        b.a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void onPlay() {
        b.a.b(this);
    }

    @Override // com.tencent.sqshow.zootopia.player.a
    public void onRecycle() {
        ISPlayerVideoView superPlayerView;
        QLog.i("ZootopiaPlayerView", 1, this + " onRecycle");
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar != null) {
            cVar.c(this);
        }
        com.tencent.sqshow.zootopia.player.c cVar2 = this.player;
        if (cVar2 != null) {
            cVar2.e(this);
        }
        com.tencent.sqshow.zootopia.player.c cVar3 = this.player;
        if (cVar3 != null && (superPlayerView = cVar3.getSuperPlayerView()) != null) {
            superPlayerView.removeViewCallBack(this);
        }
        this.player = null;
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void onRelease() {
        QLog.i("ZootopiaPlayerView", 1, this + " onRelease");
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceChanged(Object p06) {
        QLog.i("ZootopiaPlayerView", 1, this + " onSurfaceChanged");
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceCreated(Object p06) {
        com.tencent.sqshow.zootopia.player.c cVar;
        ISPlayerVideoView superPlayerView;
        if (this.isBanner && (cVar = this.player) != null && (superPlayerView = cVar.getSuperPlayerView()) != null) {
            superPlayerView.disableViewCallback();
        }
        QLog.i("ZootopiaPlayerView", 1, this + " onSurfaceCreated");
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceDestroy(Object p06) {
        QLog.i("ZootopiaPlayerView", 1, this + " onSurfaceDestroy");
    }

    public final String p() {
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar != null) {
            return cVar.getCurrentUrl();
        }
        return null;
    }

    /* renamed from: q, reason: from getter */
    public final com.tencent.sqshow.zootopia.player.c getPlayer() {
        return this.player;
    }

    public final com.tencent.sqshow.zootopia.player.c r() {
        return this.player;
    }

    /* renamed from: s, reason: from getter */
    public final String getCom.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String() {
        return this.com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String;
    }

    public final void setAdjustViewBounds(boolean adjust) {
        URLImageView uRLImageView = this.coverImage;
        if (uRLImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverImage");
            uRLImageView = null;
        }
        uRLImageView.setAdjustViewBounds(adjust);
    }

    public final void setApngBackgroundUrl(String url, int requestWidth, int requestHeight, boolean needUrlTag, Function0<Unit> loadCallback) {
        QLog.i("ZootopiaPlayerView", 1, this + " setApngBackgroundUrl");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestWidth(requestWidth);
        apngOptions.setRequestHeight(requestHeight);
        Drawable drawable = this.defaultDrawable;
        if (drawable == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        apngOptions.setLoadingDrawable(drawable);
        if (needUrlTag) {
            int[] iArr = new int[1];
            iArr[0] = url != null ? url.hashCode() : 0;
            apngOptions.setTagId(iArr);
        } else {
            apngOptions.setTagId(new int[]{30000});
        }
        if (loadCallback != null) {
            apngOptions.setLoadListener(new b(loadCallback));
        }
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        Intrinsics.checkNotNull(url);
        URLDrawable apngURLDrawable = iVasApngFactory.getApngURLDrawable("ZootopiaPlayerView", url, apngOptions);
        if (apngURLDrawable != null) {
            URLImageView uRLImageView = this.coverImage;
            if (uRLImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                uRLImageView = null;
            }
            uRLImageView.setImageDrawable(apngURLDrawable);
            return;
        }
        QLog.e("ZootopiaPlayerView", 4, "get apngURLDrawable is null");
        if (loadCallback != null) {
            loadCallback.invoke();
        }
    }

    public final void setCoverUrl(String url, int requestWidth, int requestHeight, Function0<Unit> loadCallback) {
        QLog.i("ZootopiaPlayerView", 1, this + " setCover " + url);
        if (TextUtils.isEmpty(url)) {
            if (loadCallback != null) {
                loadCallback.invoke();
                return;
            }
            return;
        }
        try {
            this.coverUrl = url;
            URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
            options.mRequestWidth = requestWidth;
            options.mRequestHeight = requestHeight;
            Drawable drawable = this.defaultDrawable;
            if (drawable == null) {
                drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            }
            options.mFailedDrawable = drawable;
            options.mLoadingDrawable = drawable;
            URLImageView uRLImageView = this.coverImage;
            c cVar = null;
            if (uRLImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                uRLImageView = null;
            }
            if (url == null) {
                url = "";
            }
            Intrinsics.checkNotNullExpressionValue(options, "options");
            if (loadCallback != null) {
                cVar = new c(loadCallback);
            }
            CommonExKt.u(uRLImageView, url, options, cVar);
        } catch (Exception e16) {
            QLog.e("ZootopiaPlayerView", 1, "setCoverUrl + " + e16);
            if (loadCallback != null) {
                loadCallback.invoke();
            }
        }
    }

    public final void setDefaultBackground() {
        QLog.i("ZootopiaPlayerView", 1, this + " setDefaultBackground");
        URLImageView uRLImageView = this.coverImage;
        if (uRLImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverImage");
            uRLImageView = null;
        }
        uRLImageView.setImageResource(R.drawable.ik9);
    }

    public final void setMediaLoadingDrawable(Drawable defaultDrawable) {
        this.defaultDrawable = defaultDrawable;
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        URLImageView uRLImageView = this.coverImage;
        if (uRLImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverImage");
            uRLImageView = null;
        }
        uRLImageView.setScaleType(scaleType);
    }

    public final void setVideoUrl(String url) {
        QLog.i("ZootopiaPlayerView", 1, "setVideoUrl " + url);
        this.com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String = url;
    }

    public final void setXYaxis(int i3) {
        this.videoXYaxis = i3;
    }

    /* renamed from: t, reason: from getter */
    public final int getVideoXYaxis() {
        return this.videoXYaxis;
    }

    public final void v() {
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar != null) {
            cVar.recycle();
        }
        com.tencent.sqshow.zootopia.player.c cVar2 = this.player;
        if (cVar2 != null) {
            cVar2.reset();
        }
        com.tencent.sqshow.zootopia.player.c cVar3 = this.player;
        if (cVar3 != null) {
            cVar3.destroy();
        }
        this.player = null;
    }

    public final void x(com.tencent.sqshow.zootopia.player.c cVar) {
        this.player = cVar;
    }

    public final void y(boolean isBanner, boolean isOutputMute) {
        if (TextUtils.isEmpty(this.com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String)) {
            QLog.e("ZootopiaPlayerView", 4, "get player url is null");
            return;
        }
        if (this.player == null) {
            m(isBanner);
        }
        com.tencent.sqshow.zootopia.player.c cVar = this.player;
        if (cVar != null) {
            cVar.setXYaxis(this.videoXYaxis);
        }
        com.tencent.sqshow.zootopia.player.c cVar2 = this.player;
        if (cVar2 != null) {
            cVar2.a(this.com.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String, isOutputMute);
        }
    }

    public ZootopiaPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void k() {
        View childAt = getChildAt(1);
        if (childAt instanceof ISPlayerVideoView) {
            removeView(childAt);
            QLog.d("ZootopiaPlayerView", 1, "remove is player");
        }
    }

    @Override // com.tencent.sqshow.zootopia.player.b
    public void onFirstFrameCome() {
        QLog.i("ZootopiaPlayerView", 1, "onFirstFrameCome");
    }

    public /* synthetic */ ZootopiaPlayerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void setBackgroundRadius(int radius) {
        this.f316197h = 15;
        this.f316195e = radius;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w(com.tencent.sqshow.zootopia.player.c player) {
        if (player != null) {
            player.d(this);
        }
        if (player != null) {
            player.b(this);
        }
        ISPlayerVideoView superPlayerView = player != null ? player.getSuperPlayerView() : 0;
        if (superPlayerView != 0) {
            superPlayerView.addViewCallBack(this);
        }
        QLog.i("ZootopiaPlayerView", 1, "startPlay reset " + superPlayerView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (superPlayerView != 0) {
            addView((View) superPlayerView, layoutParams);
        }
    }

    public ZootopiaPlayerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.defaultDrawable = com.tencent.sqshow.zootopia.utils.q.b(R.drawable.gyn);
        this.videoXYaxis = 2;
        u();
    }

    public static /* synthetic */ void z(ZootopiaPlayerView zootopiaPlayerView, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                z17 = true;
            }
            zootopiaPlayerView.y(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPlay");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setCoverUrl$default(ZootopiaPlayerView zootopiaPlayerView, String str, int i3, int i16, Function0 function0, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i3 = 0;
            }
            if ((i17 & 4) != 0) {
                i16 = 0;
            }
            if ((i17 & 8) != 0) {
                function0 = null;
            }
            zootopiaPlayerView.setCoverUrl(str, i3, i16, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCoverUrl");
    }

    public static /* synthetic */ void setApngBackgroundUrl$default(ZootopiaPlayerView zootopiaPlayerView, String str, int i3, int i16, boolean z16, Function0 function0, int i17, Object obj) {
        if (obj == null) {
            int i18 = (i17 & 2) != 0 ? 0 : i3;
            int i19 = (i17 & 4) != 0 ? 0 : i16;
            boolean z17 = (i17 & 8) != 0 ? false : z16;
            if ((i17 & 16) != 0) {
                function0 = null;
            }
            zootopiaPlayerView.setApngBackgroundUrl(str, i18, i19, z17, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setApngBackgroundUrl");
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/player/ZootopiaPlayerView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d */
        final /* synthetic */ Function0<Unit> f372206d;

        b(Function0<Unit> function0) {
            this.f372206d = function0;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
            this.f372206d.invoke();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            this.f372206d.invoke();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            this.f372206d.invoke();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/player/ZootopiaPlayerView$c", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "p0", "Lcom/tencent/image/URLDrawable;", "p1", "", "onLoadSuccessed", "", "p2", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "onLoadInterrupted", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements URLDrawableDownListener {

        /* renamed from: d */
        final /* synthetic */ Function0<Unit> f372207d;

        c(Function0<Unit> function0) {
            this.f372207d = function0;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View p06, URLDrawable p16) {
            this.f372207d.invoke();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View p06, URLDrawable p16, Throwable p26) {
            this.f372207d.invoke();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View p06, URLDrawable p16, InterruptedException p26) {
            this.f372207d.invoke();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View p06, URLDrawable p16) {
            this.f372207d.invoke();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View p06, URLDrawable p16, int p26) {
        }
    }
}

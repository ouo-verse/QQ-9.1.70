package com.tencent.mobileqq.guild.feed.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001CB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010&\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0012H\u0016J\u000e\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020/R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/share/x;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoOuterStatusListener;", "", "u0", "r0", "s0", "Landroid/content/Context;", "context", "B", "Landroid/view/View;", "customView", "initWidgetWrapper", "updateFloatingView", "view", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "", "j", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "quitWindowFloat", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoInnerStatusListener;", "listener", "M", "initStatusReceiver", "duration", "onVideoStart", "onVideoStop", "onVideoBuffering", "videoWidth", "videoHeight", "onVideoSize", "", "isHorizontal", "onOrientationChange", "Landroid/graphics/Bitmap;", "coverBitmap", "onSetVideoCover", "Landroid/graphics/drawable/Drawable;", "coverDrawable", "showCover", "onVideoComplete", "errCode", "onVideoError", "currentPosition", "onVideoProgressUpdate", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "t0", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mVideoCoverContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mVideoCoverImageView", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "mGalleryInitBean", "i", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoInnerStatusListener;", "mVideoInnerListener", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class x extends com.tencent.mobileqq.qqfloatingwindow.a implements IVideoOuterStatusListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "Guild_Feed_GAL_GuildGalleryFloatingVideoWrapper";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mVideoCoverContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mVideoCoverImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean mGalleryInitBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IVideoInnerStatusListener mVideoInnerListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/share/x$a;", "", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.share.x$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            String name = x.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildGalleryFloatingVideoWrapper::class.java.name");
            return name;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/share/x$b", "Lgh2/f;", "", "c", "a", "", "canPlay", "d", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements gh2.f {
        b() {
        }

        @Override // gh2.f
        public void a() {
            QLog.i(x.TAG, 1, "[onWindowHide] ");
            IVideoInnerStatusListener iVideoInnerStatusListener = x.this.mVideoInnerListener;
            if (iVideoInnerStatusListener != null) {
                iVideoInnerStatusListener.notifyVideoStop();
            }
            x.this.U(false);
        }

        @Override // gh2.f
        public void b() {
            QLog.i(x.TAG, 1, "[onWindowDismiss] ");
            x.this.quitWindowFloat(5);
        }

        @Override // gh2.f
        public void c() {
            QLog.i(x.TAG, 1, "[onWindowPause] ");
            IVideoInnerStatusListener iVideoInnerStatusListener = x.this.mVideoInnerListener;
            if (iVideoInnerStatusListener != null) {
                iVideoInnerStatusListener.notifyVideoStop();
            }
        }

        @Override // gh2.f
        public void d(boolean canPlay) {
            QLog.i(x.TAG, 1, "[onWindowShow] canPlay: " + canPlay + ", containerVisible: " + x.this.u());
            if (!x.this.t() && x.this.u() != 0) {
                x.this.U(true);
                IVideoInnerStatusListener iVideoInnerStatusListener = x.this.mVideoInnerListener;
                if (iVideoInnerStatusListener != null) {
                    iVideoInnerStatusListener.notifyVideoStart();
                }
            }
        }

        @Override // gh2.f
        public /* synthetic */ void e() {
            gh2.e.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void r0() {
        int i3;
        GuildFeedRichMediaData guildFeedRichMediaData;
        List<GuildFeedRichMediaData> richMediaDataList;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean != null) {
            i3 = guildFeedGalleryInitBean.getEnterPos();
        } else {
            i3 = 0;
        }
        QLog.i(TAG, 1, "[onContainerClicked] start. enterPos: " + i3);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean2 == null) {
            QLog.w(TAG, 1, "[onContainerClicked] failed. initBean is null");
            return;
        }
        if (guildFeedGalleryInitBean2 != null && (richMediaDataList = guildFeedGalleryInitBean2.getRichMediaDataList()) != null) {
            guildFeedRichMediaData = richMediaDataList.get(i3);
        } else {
            guildFeedRichMediaData = null;
        }
        if (guildFeedRichMediaData != null) {
            jk1.b a16 = jk1.b.INSTANCE.a();
            GProStVideo video = guildFeedRichMediaData.getVideo();
            Intrinsics.checkNotNullExpressionValue(video, "mediaData.video");
            guildFeedRichMediaData.setCurrentPlayPosition(a16.e(video));
        }
        GuildFeedLauncher.y(BaseApplication.getContext(), this.mGalleryInitBean);
        s0();
    }

    private final void s0() {
        QLog.i(TAG, 1, "[quit] start");
        quitWindowFloat(4);
    }

    private final void u0() {
        d0();
        Z(1.0f);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.B(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.mVideoCoverContainer = frameLayout;
        frameLayout.setId(R.id.m2z);
        ImageView imageView = new ImageView(context);
        this.mVideoCoverImageView = imageView;
        imageView.setId(R.id.m2l);
        ImageView imageView2 = this.mVideoCoverImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverImageView");
            imageView2 = null;
        }
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    @NotNull
    public IVideoOuterStatusListener M(@Nullable IVideoInnerStatusListener listener) {
        this.mVideoInnerListener = listener;
        return this;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        g(0, new b());
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void initWidgetWrapper(@NotNull View customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        FrameLayout frameLayout = this.mVideoCoverContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        E(customView);
        customView.setId(R.id.f166638m32);
        FrameLayout frameLayout3 = this.mVideoCoverContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverContainer");
            frameLayout3 = null;
        }
        frameLayout3.addView(customView, -1, -1);
        ImageView imageView = this.mVideoCoverImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverImageView");
            imageView = null;
        }
        E(imageView);
        FrameLayout frameLayout4 = this.mVideoCoverContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverContainer");
            frameLayout4 = null;
        }
        ImageView imageView2 = this.mVideoCoverImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverImageView");
            imageView2 = null;
        }
        frameLayout4.addView(imageView2, -1, -1);
        D();
        FrameLayout frameLayout5 = this.mVideoCoverContainer;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverContainer");
            frameLayout5 = null;
        }
        E(frameLayout5);
        FrameLayout frameLayout6 = this.mVideoCoverContainer;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverContainer");
            frameLayout6 = null;
        }
        h(frameLayout6, new FrameLayout.LayoutParams(-1, -1));
        F();
        f(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout7 = this.mVideoCoverContainer;
        if (frameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCoverContainer");
        } else {
            frameLayout2 = frameLayout7;
        }
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.share.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.q0(x.this, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(@Nullable FloatingScreenParams floatParams, @Nullable View customView) {
        IVideoInnerStatusListener iVideoInnerStatusListener = this.mVideoInnerListener;
        if (iVideoInnerStatusListener != null) {
            iVideoInnerStatusListener.notifyVideoClose(6);
        }
        this.mVideoInnerListener = null;
        return super.j(floatParams, customView);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.m2t) {
            r0();
        } else if (num != null && num.intValue() == R.id.m2n) {
            QLog.i(TAG, 1, "[onClick] close");
            jk1.b.INSTANCE.a().c();
            quitWindowFloat(1);
        } else {
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onSetVideoCover(@Nullable Bitmap coverBitmap) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int closeReason) {
        IVideoInnerStatusListener iVideoInnerStatusListener = this.mVideoInnerListener;
        if (iVideoInnerStatusListener != null) {
            iVideoInnerStatusListener.notifyVideoClose(closeReason);
        }
        this.mVideoInnerListener = null;
        super.quitWindowFloat(closeReason);
    }

    public final void t0(@NotNull GuildFeedGalleryInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.mGalleryInitBean = initBean;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        U(true);
        N(true);
        u0();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onSetVideoCover(@Nullable Drawable coverDrawable) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoBuffering() {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoStop() {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onOrientationChange(boolean isHorizontal) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoComplete(boolean showCover) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoError(int errCode) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoProgressUpdate(int currentPosition) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoStart(int duration) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoSize(int videoWidth, int videoHeight) {
    }
}

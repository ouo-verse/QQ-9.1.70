package com.tencent.mobileqq.wink.magicstudio.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/WinkMagicStudioResultPreview;", "Landroid/widget/FrameLayout;", "", "c", "", "path", "d", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayParam;", "b", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setImageScaleType", "setImagePath", "setGifPath", "setVideoPath", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "imageView", "e", "Landroid/widget/FrameLayout;", "videoPreview", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "f", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "videoView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMagicStudioResultPreview extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView imageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout videoPreview;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseVideoView videoView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkMagicStudioResultPreview(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final VideoPlayParam b(String path) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mVideoPath = path;
        videoPlayParam.mVideoFormat = 101;
        videoPlayParam.mIsLocal = true;
        videoPlayParam.mIsLoop = true;
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mSceneId = 163;
        return videoPlayParam;
    }

    private final void c() {
        IBaseVideoView createBaseVideoViewFS = QQVideoViewFactory.createBaseVideoViewFS(getContext(), 153L, null, null);
        if (createBaseVideoViewFS instanceof BaseVideoView) {
            this.videoView = (BaseVideoView) createBaseVideoViewFS;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = this.videoPreview;
            if (frameLayout != null) {
                frameLayout.addView(this.videoView, layoutParams);
            }
        }
    }

    private final void d(String path) {
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option obtain = Option.obtain();
        obtain.setTargetView(this.imageView);
        obtain.setLocalPath(path);
        obtain.setLoadingDrawable(new ColorDrawable(0));
        obtain.setFailedDrawable(new ColorDrawable(0));
        obtain.setRotationDegree(com.tencent.mobileqq.wink.utils.f.k(path));
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026ureRotate(path)\n        }");
        qQPicLoader.e(obtain, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.q
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                WinkMagicStudioResultPreview.e(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LoadState loadState, Option option) {
        Animatable animatable;
        boolean z16 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        }
        if (z16) {
            if (option != null) {
                animatable = option.getAnimatable();
            } else {
                animatable = null;
            }
            if (animatable instanceof r01.c) {
                r01.c cVar = (r01.c) animatable;
                cVar.setLoopCount(65535);
                cVar.start();
            }
        }
    }

    public final void setGifPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout = this.videoPreview;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.pause();
        }
        d(path);
    }

    public final void setImagePath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout = this.videoPreview;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.pause();
        }
        d(path);
    }

    public final void setImageScaleType(@NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    public final void setVideoPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        FrameLayout frameLayout = this.videoPreview;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setVideoParam(b(path));
        }
        BaseVideoView baseVideoView2 = this.videoView;
        if (baseVideoView2 != null) {
            baseVideoView2.play();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkMagicStudioResultPreview(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ WinkMagicStudioResultPreview(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkMagicStudioResultPreview(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.f169189i60, this);
        this.imageView = (ImageView) findViewById(R.id.xip);
        this.videoPreview = (FrameLayout) findViewById(R.id.f1178472j);
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FrameLayout frameLayout = this.videoPreview;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        c();
    }
}

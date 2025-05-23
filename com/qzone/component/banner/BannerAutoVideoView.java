package com.qzone.component.banner;

import android.content.Context;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BannerAutoVideoView extends BaseVideo {

    /* renamed from: d, reason: collision with root package name */
    Matrix f46299d;

    public BannerAutoVideoView(Context context) {
        super(context);
        this.f46299d = new Matrix();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        BannerAutoVideoCover bannerAutoVideoCover = new BannerAutoVideoCover(context, this);
        this.mVideoCover = bannerAutoVideoCover;
        addView(bannerAutoVideoCover);
        this.mVideoCover.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void reLayoutSurfaceView(BaseVideo.VideoSize videoSize) {
        int videoCoverWidth = getVideoCoverWidth();
        int videoCoverHeight = getVideoCoverHeight();
        this.f46299d.reset();
        if (videoSize.videoNatureWidth > videoSize.videoNatureHeight) {
            BaseVideo.VideoSize videoSize2 = new BaseVideo.VideoSize(videoCoverWidth, videoCoverHeight);
            this.mVideoSize = videoSize2;
            super.reLayoutSurfaceView(videoSize2);
            initMatrix(videoCoverWidth, videoCoverHeight, videoSize.videoNatureWidth, videoSize.videoNatureHeight);
            View view = this.mVideoView;
            if (view instanceof TextureView) {
                ((TextureView) view).setTransform(this.f46299d);
                return;
            }
            return;
        }
        if (Math.abs((videoCoverWidth / videoCoverHeight) - (r2 / r3)) > 0.1d) {
            BaseVideo.VideoSize videoSize3 = new BaseVideo.VideoSize(videoCoverWidth, videoCoverHeight);
            this.mVideoSize = videoSize3;
            super.reLayoutSurfaceView(videoSize3);
            this.f46299d.postScale(1.0f, ((videoCoverWidth * videoSize.videoNatureHeight) * 1.0f) / (videoSize.videoNatureWidth * videoCoverHeight), 0.0f, videoCoverHeight / 2);
            View view2 = this.mVideoView;
            if (view2 instanceof TextureView) {
                ((TextureView) view2).setTransform(this.f46299d);
                return;
            }
            return;
        }
        View view3 = this.mVideoView;
        if (view3 instanceof TextureView) {
            ((TextureView) view3).setTransform(this.f46299d);
        }
        super.reLayoutSurfaceView(videoSize);
    }

    private void initMatrix(int i3, int i16, int i17, int i18) {
        if (i3 <= 0 || i16 <= 0 || i17 <= 0 || i18 <= 0) {
            return;
        }
        float f16 = i3;
        float f17 = i17;
        float f18 = i16;
        float f19 = i18;
        float max = Math.max(f16 / f17, f18 / f19);
        Matrix matrix = this.f46299d;
        if (matrix == null) {
            this.f46299d = new Matrix();
        } else {
            matrix.reset();
        }
        if (i17 >= i18) {
            this.f46299d.preTranslate((i3 - i17) / 2.0f, (i16 - i18) / 2.0f);
        } else {
            float f26 = (i3 - i17) / 2.0f;
            this.f46299d.preTranslate(f26, ((i17 - i18) / 3.0f) + f26);
        }
        this.f46299d.preScale(f17 / f16, f19 / f18);
        this.f46299d.postScale(max, max, f16 / 2.0f, f18 / 2.0f);
    }
}

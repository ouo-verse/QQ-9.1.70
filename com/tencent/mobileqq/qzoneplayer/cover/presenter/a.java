package com.tencent.mobileqq.qzoneplayer.cover.presenter;

import android.view.View;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.vas.theme.ThemeReporter;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends BaseVideoPresenter {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzoneplayer.cover.presenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    static /* synthetic */ class C8490a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f279330a;

        static {
            int[] iArr = new int[VideoClickElement.values().length];
            f279330a = iArr;
            try {
                iArr[VideoClickElement.BASE_COVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f279330a[VideoClickElement.VIDEO_PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f279330a[VideoClickElement.VIDEO_FREE_TRAFFIC_PLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f279330a[VideoClickElement.VIDEO_OPEN_FREE_TRAFFIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(BaseVideo baseVideo, BaseVideoCoverUIWrapper baseVideoCoverUIWrapper) {
        super(baseVideo, baseVideoCoverUIWrapper);
        this.mPresentType = 1;
    }

    private void a() {
        BaseVideo baseVideo = this.mBaseVideo;
        if (baseVideo == null) {
            return;
        }
        if (baseVideo.getState() == 5) {
            ((FeedAutoVideoFull) this.mBaseVideo).r();
        } else {
            ((FeedAutoVideoFull) this.mBaseVideo).C();
        }
    }

    private void b() {
        BaseVideo baseVideo = this.mBaseVideo;
        if (baseVideo == null || !(baseVideo instanceof FeedAutoVideoFull)) {
            return;
        }
        ((FeedAutoVideoFull) baseVideo).F();
        FeedVideoEnv.externalFunc.reportClick("8", ThemeReporter.FROM_CLEANER, "3");
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter
    public boolean isFullScreenMode() {
        return this.mIsFullScreenMode;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter
    public boolean isLandscapeMode() {
        BaseVideo baseVideo = this.mBaseVideo;
        return baseVideo != null && (baseVideo instanceof FeedAutoVideoFull) && ((FeedAutoVideoFull) baseVideo).z();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter, com.tencent.mobileqq.qzoneplayer.cover.presenter.OnBaseVideoClickListener
    public void onClick(View view, boolean z16, VideoClickElement videoClickElement, int i3, Object[] objArr) {
        super.onClick(view, z16, videoClickElement, i3, objArr);
        int i16 = C8490a.f279330a[videoClickElement.ordinal()];
        if (i16 == 1 || i16 == 2) {
            a();
        } else if (i16 == 3) {
            a();
        } else {
            if (i16 != 4) {
                return;
            }
            b();
        }
    }
}

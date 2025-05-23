package com.tencent.aelight.camera.ae.util;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/g;", "", "", "videoPath", "", "fromPercentage", "", "durationMillis", "Lcom/tencent/aelight/camera/ae/util/g$a;", "callback", "", "b", "<init>", "()V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f65767a = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/g$a;", "", "", "gifPath", "", "onSuccess", "onFail", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface a {
        void onFail();

        void onSuccess(String gifPath);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aelight/camera/ae/util/g$b", "Lcom/tencent/aelight/camera/ae/gif/video/VideoGIFCreator$b;", "", "onGifCreateFail", "", "path", "onGifCreateSuccess", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements VideoGIFCreator.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f65768a;

        b(a aVar) {
            this.f65768a = aVar;
        }

        @Override // com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.b
        public void onGifCreateFail() {
            this.f65768a.onFail();
        }

        @Override // com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.b
        public void onGifCreateSuccess(String path) {
            if (!TextUtils.isEmpty(path)) {
                a aVar = this.f65768a;
                Intrinsics.checkNotNull(path);
                aVar.onSuccess(path);
                return;
            }
            this.f65768a.onFail();
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String videoPath, float f16, long j3, a callback) {
        Intrinsics.checkNotNullParameter(videoPath, "$videoPath");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        VideoGIFCreator videoGIFCreator = new VideoGIFCreator(videoPath, f16, j3);
        videoGIFCreator.B(false);
        videoGIFCreator.D(new b(callback));
    }

    public final void b(final String videoPath, final float fromPercentage, final long durationMillis, final a callback) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.util.f
            @Override // java.lang.Runnable
            public final void run() {
                g.c(videoPath, fromPercentage, durationMillis, callback);
            }
        });
    }
}

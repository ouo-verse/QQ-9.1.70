package it1;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.trtc.TRTCCloudDef;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \n2\u00020\u0001:\u0001\tB\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001b\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lit1/j;", "", "", "b", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "videoFrame", "e", "", "millsTimeOut", "a", "c", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "d", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "setFrame", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;)V", AIInput.KEY_FRAME, "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: it1.j, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class VideoFrameRenderObj {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private TRTCCloudDef.TRTCVideoFrame frame;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch countDownLatch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lit1/j$a;", "", "Lit1/j;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: it1.j$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VideoFrameRenderObj a() {
            return new VideoFrameRenderObj(null);
        }

        Companion() {
        }
    }

    public VideoFrameRenderObj(@Nullable TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        this.frame = tRTCVideoFrame;
    }

    public final void a(long millsTimeOut) {
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.await(millsTimeOut, TimeUnit.MILLISECONDS);
        }
    }

    public final void b() {
        this.frame = null;
        this.countDownLatch = null;
    }

    public final void c() {
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final TRTCCloudDef.TRTCVideoFrame getFrame() {
        return this.frame;
    }

    public final void e(@Nullable TRTCCloudDef.TRTCVideoFrame videoFrame) {
        this.frame = videoFrame;
        this.countDownLatch = new CountDownLatch(1);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof VideoFrameRenderObj) && Intrinsics.areEqual(this.frame, ((VideoFrameRenderObj) other).frame)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = this.frame;
        if (tRTCVideoFrame == null) {
            return 0;
        }
        return tRTCVideoFrame.hashCode();
    }

    @NotNull
    public String toString() {
        return "VideoFrameRenderObj(frame=" + this.frame + ")";
    }
}

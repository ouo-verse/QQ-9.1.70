package f12;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\"\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u0006\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013\u00a8\u0006'"}, d2 = {"Lf12/e;", "", "", "f", "", "toString", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "scene", "", "b", "J", "d", "()J", "i", "(J)V", "frameCount", "c", tl.h.F, "firstFrameTime", "g", "finalFrameTime", "", "[J", "()[J", "setDropTimes", "([J)V", "dropTimes", "getScrollDurationMs", "k", "scrollDurationMs", "", "rangeCount", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: f12.e, reason: from toString */
/* loaded from: classes14.dex */
public final class GuildDropFrameData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long frameCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long firstFrameTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long finalFrameTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private long[] dropTimes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long scrollDurationMs;

    public GuildDropFrameData(int i3) {
        this.dropTimes = new long[i3];
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final long[] getDropTimes() {
        return this.dropTimes;
    }

    /* renamed from: b, reason: from getter */
    public final long getFinalFrameTime() {
        return this.finalFrameTime;
    }

    /* renamed from: c, reason: from getter */
    public final long getFirstFrameTime() {
        return this.firstFrameTime;
    }

    /* renamed from: d, reason: from getter */
    public final long getFrameCount() {
        return this.frameCount;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    public final void f() {
        this.scene = null;
        this.frameCount = 0L;
        this.firstFrameTime = 0L;
        int length = this.dropTimes.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.dropTimes[i3] = 0;
        }
        this.finalFrameTime = 0L;
        this.scrollDurationMs = 0L;
    }

    public final void g(long j3) {
        this.finalFrameTime = j3;
    }

    public final void h(long j3) {
        this.firstFrameTime = j3;
    }

    public final void i(long j3) {
        this.frameCount = j3;
    }

    public final void j(@Nullable String str) {
        this.scene = str;
    }

    public final void k(long j3) {
        this.scrollDurationMs = j3;
    }

    @NotNull
    public String toString() {
        String str = this.scene;
        long j3 = this.frameCount;
        long j16 = this.firstFrameTime;
        long j17 = this.finalFrameTime;
        String arrays = Arrays.toString(this.dropTimes);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return "GuildDropFrameData(scene=" + str + ", frameCount=" + j3 + ", firstFrameTime=" + j16 + ", finalFrameTime=" + j17 + ", dropTimes=" + arrays + ", scrollDurationMs=" + this.scrollDurationMs + ")";
    }
}

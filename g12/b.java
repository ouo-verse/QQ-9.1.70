package g12;

import com.tencent.mobileqq.guild.util.report.SampleReporter;
import com.tencent.mobileqq.guild.util.report.c;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\bR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u0015\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001f\u00a8\u0006$"}, d2 = {"Lg12/b;", "", "Lcom/tencent/mobileqq/guild/util/report/c;", "callback", "", "isPublicVersion", "isGrayVersion", "isDebugVersion", "", "e", "", "d", "c", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "tag", "", "subTag", h.F, "a", "f", "Lcom/tencent/mobileqq/guild/util/report/SampleReporter;", "b", "Lcom/tencent/mobileqq/guild/util/report/SampleReporter;", "getReporter", "()Lcom/tencent/mobileqq/guild/util/report/SampleReporter;", "reporter", "Z", "()Z", "g", "(Z)V", "firstViewRendered", "I", "loadFirstPageCookie", "loadDbMsgCookie", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f401087a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SampleReporter reporter = new SampleReporter();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean firstViewRendered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int loadFirstPageCookie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int loadDbMsgCookie;

    b() {
    }

    public final void a(@NotNull GuildHistogramScene tag, @NotNull String subTag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        reporter.c(tag, subTag);
    }

    public final boolean b() {
        return firstViewRendered;
    }

    public final int c() {
        int i3 = loadDbMsgCookie;
        loadDbMsgCookie = i3 + 1;
        return i3;
    }

    public final int d() {
        int i3 = loadFirstPageCookie;
        loadFirstPageCookie = i3 + 1;
        return i3;
    }

    public final void e(@NotNull c callback, boolean isPublicVersion, boolean isGrayVersion, boolean isDebugVersion) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        firstViewRendered = false;
        loadFirstPageCookie = 0;
        loadDbMsgCookie = 0;
        reporter.e(callback, isPublicVersion, isGrayVersion, isDebugVersion);
    }

    public final void f() {
        reporter.g();
    }

    public final void g(boolean z16) {
        firstViewRendered = z16;
    }

    public final void h(@NotNull GuildHistogramScene tag, @NotNull String subTag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        reporter.h(tag, subTag);
    }
}

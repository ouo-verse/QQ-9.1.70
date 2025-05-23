package hz;

import UserGrowth.stSimpleMetaFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J@\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007H\u0007J4\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0007J4\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0007JD\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0002\u00a8\u0006\u0013"}, d2 = {"Lhz/b;", "", "", "from", "playScene", "LUserGrowth/stSimpleMetaFeed;", "feed", "", "extMap", "", "c", "d", "b", "positionId", "", "actionId", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f406940a = new b();

    b() {
    }

    private final void a(String from, String playScene, String positionId, stSimpleMetaFeed feed, int actionId, Map<String, String> extMap) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.t(from, playScene, positionId, feed, actionId, "", extMap);
    }

    @JvmStatic
    public static final void b(String from, String playScene, stSimpleMetaFeed feed, Map<String, String> extMap) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(extMap, "extMap");
        f406940a.a(from, playScene, "mini_videoplay_agree", feed, 1000001, extMap);
    }

    @JvmStatic
    public static final void c(String from, String playScene, stSimpleMetaFeed feed, Map<String, String> extMap) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.E(from, playScene, "mini_videoplay_sure", feed, "", extMap);
    }

    @JvmStatic
    public static final void d(String from, String playScene, stSimpleMetaFeed feed, Map<String, String> extMap) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(extMap, "extMap");
        f406940a.a(from, playScene, "mini_videoplay_disagree", feed, 1000001, extMap);
    }
}

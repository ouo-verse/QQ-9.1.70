package lo;

import com.qzone.report.QZonePerfReporter;
import java.util.LinkedHashSet;
import java.util.Set;
import jo.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u0007B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Llo/f;", "Ljo/g;", "Ljo/g$b;", "", "y", "Ljo/a;", "streamResult", "a", "", "k", "Ljava/lang/String;", "pageName", "streamName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "l", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends g implements g.b {

    /* renamed from: m, reason: collision with root package name */
    private static Set<String> f415063m = new LinkedHashSet();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String streamName, String pageName) {
        super(streamName);
        Intrinsics.checkNotNullParameter(streamName, "streamName");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        this.pageName = pageName;
        y();
        h(new jo.b());
        h(this);
    }

    private final void y() {
        g.g(g.g(g.g(g.g(g.g(g.d(w(), "LAUNCH_CLICK", null, 2, null), "ACTIVITY_ON_CREATE", null, 2, null), "FRAGMENT_INFLATE", null, 2, null), "FRAGMENT_ON_VIEW_CREATED", null, 2, null), "PART_INIT", null, 2, null), "FRAGMENT_ON_RESUME", null, 2, null).b("WINDOW_FOCUS", "\u9875\u9762Window Focus").b("FEED_SHOW", "Feeds\u53ef\u89c1").j("WINDOW_FOCUS", "FEED_SHOW").k(1);
    }

    @Override // jo.g.b
    public void a(jo.a streamResult) {
        Long l3;
        Long l16;
        Intrinsics.checkNotNullParameter(streamResult, "streamResult");
        long j3 = 0;
        long longValue = (!streamResult.a().containsKey("WINDOW_FOCUS") || (l16 = streamResult.a().get("WINDOW_FOCUS")) == null) ? 0L : l16.longValue();
        if (streamResult.a().containsKey("FEED_SHOW") && (l3 = streamResult.a().get("FEED_SHOW")) != null) {
            j3 = l3.longValue();
        }
        long j16 = j3;
        QZonePerfReporter.f59697a.q(this.pageName, longValue > j16 ? j16 : longValue, j16, f415063m.contains(this.pageName), streamResult.getSessionId(), (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0);
        f415063m.add(this.pageName);
    }
}

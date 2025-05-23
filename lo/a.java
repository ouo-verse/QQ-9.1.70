package lo;

import java.util.Map;
import jo.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Llo/a;", "Ljo/g;", "Ljo/g$b;", "", "y", "Ljo/a;", "streamResult", "a", "", "k", "Ljava/lang/String;", "getStreamName", "()Ljava/lang/String;", "setStreamName", "(Ljava/lang/String;)V", "streamName", "<init>", "l", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends g implements g.b {

    /* renamed from: m, reason: collision with root package name */
    private static boolean f415059m;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String streamName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String streamName) {
        super(streamName);
        Intrinsics.checkNotNullParameter(streamName, "streamName");
        this.streamName = streamName;
        y();
        h(new jo.b());
        h(this);
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
        if (longValue > j3) {
            longValue = j3;
        }
        Map<String, Object> paramsMap = new fo.a().b();
        Intrinsics.checkNotNullExpressionValue(paramsMap, "paramsMap");
        paramsMap.put("page_launch_name", this.streamName);
        paramsMap.put("page_show_cost", Long.valueOf(longValue));
        paramsMap.put("feed_show_cost", Long.valueOf(j3));
        paramsMap.put("is_warm_launch", Boolean.valueOf(f415059m));
        paramsMap.put("result_session_id", streamResult.getSessionId());
        fo.c.c("qzm_page_launch_cost", paramsMap);
        f415059m = true;
    }

    public final void y() {
        g.g(g.g(g.g(g.g(g.g(g.d(w(), "LAUNCH_CLICK", null, 2, null), "ACTIVITY_ON_CREATE", null, 2, null), "FRAGMENT_INFLATE", null, 2, null), "FRAGMENT_ON_VIEW_CREATED", null, 2, null), "PART_INIT", null, 2, null), "FRAGMENT_ON_RESUME", null, 2, null).b("WINDOW_FOCUS", "\u9875\u9762Window Focus").b("FEED_SHOW", "Feeds\u53ef\u89c1").j("WINDOW_FOCUS").k(1);
    }
}

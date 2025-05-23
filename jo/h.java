package jo;

import android.os.Trace;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u000bR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Ljo/h;", "", "", "e", "f", "", "streamName", "Ljo/g;", tl.h.F, "c", "stream", "", "a", "monitorName", "Ljo/d;", "g", "sectionName", "b", "d", "Ljava/lang/Boolean;", "mIsArtHookEnable", "mIsSystemTraceEnable", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mStreamMap", "", "Ljava/util/Map;", "mMonitorMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f410717a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Boolean mIsArtHookEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Boolean mIsSystemTraceEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentHashMap<String, g> mStreamMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Map<String, d> mMonitorMap;

    static {
        h hVar = new h();
        f410717a = hVar;
        mStreamMap = new ConcurrentHashMap<>();
        mMonitorMap = new LinkedHashMap();
        hVar.a(new lo.e("qzone_init"));
        hVar.a(new lo.f("page_launch_friend_feed", "qzone_friend_feed"));
        hVar.a(new lo.f("page_launch_user_home", "qzone_user_home"));
        hVar.a(new lo.f("page_launch_feed_detail", "qzone_feed_detail"));
        hVar.a(new lo.f("page_launch_mood_list", "qzone_mood_list"));
        hVar.a(new lo.f("page_launch_passive_message", "qzone_passive_message"));
        hVar.a(new lo.d("friend_feedx_refresh"));
        hVar.a(new lo.c("friend_feedx_load_more"));
        hVar.a(new lo.a("qzm_page_launch_folder"));
        hVar.a(new lo.a("qzm_page_launch_feed_detail"));
        hVar.a(new lo.a("qzm_page_launch_message"));
        hVar.a(new lo.a("qzm_page_launch_my_moment"));
        hVar.a(new lo.a("qzm_page_launch_publish"));
        if (hVar.e()) {
            ko.a.f412730a.d();
        }
    }

    h() {
    }

    private final boolean e() {
        if (mIsArtHookEnable == null) {
            gd.a aVar = gd.a.f401926a;
            mIsArtHookEnable = Boolean.valueOf(aVar.b() && aVar.c("KEY_ART_HOOK_ENABLE", false));
        }
        Boolean bool = mIsArtHookEnable;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean f() {
        if (mIsSystemTraceEnable == null) {
            gd.a aVar = gd.a.f401926a;
            mIsSystemTraceEnable = Boolean.valueOf(aVar.b() && aVar.c("KEY_SYSTEM_TRACE_ENABLE", false));
        }
        Boolean bool = mIsSystemTraceEnable;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void a(g stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        mStreamMap.put(stream.getMStreamName(), stream);
    }

    public final void b(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        if (f()) {
            Trace.beginSection(sectionName);
        }
    }

    public final g c() {
        Collection<g> values = mStreamMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mStreamMap.values");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            g gVar = (g) next;
            if (gVar.getMStreamType() == 1 && gVar.r()) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 1) {
            return (g) arrayList.get(0);
        }
        if (arrayList.isEmpty()) {
            RFWLog.d("QZoneTracer", 4, "no stream is running");
            return null;
        }
        if (arrayList.size() <= 1) {
            return null;
        }
        RFWLog.e("QZoneTracer", 1, "more than one stream is running");
        return null;
    }

    public final void d() {
        if (f()) {
            Trace.endSection();
        }
    }

    public final d g(String monitorName) {
        Intrinsics.checkNotNullParameter(monitorName, "monitorName");
        d dVar = mMonitorMap.get(monitorName);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(monitorName);
        mMonitorMap.put(monitorName, dVar2);
        return dVar2;
    }

    public final g h(String streamName) {
        Intrinsics.checkNotNullParameter(streamName, "streamName");
        if (mStreamMap.get(streamName) != null) {
            g gVar = mStreamMap.get(streamName);
            Intrinsics.checkNotNull(gVar);
            return gVar;
        }
        RFWLog.fatal("QZoneTracer", 1, new RuntimeException("have no stream in name: " + streamName));
        return new lo.b(streamName);
    }
}

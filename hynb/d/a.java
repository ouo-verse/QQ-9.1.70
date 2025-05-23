package hynb.d;

import com.huya.huyasdk.api.HuyaLiveBeginLive;
import com.huya.huyasdk.api.LiveRoomEventCallback;
import com.huya.huyasdk.jce.AttendeeCountNotice;
import com.huya.huyasdk.jce.OpenBeginLiveNotice;
import com.huya.huyasdk.jce.OpenEndLiveNotice;
import com.huya.huyasdk.jce.OpenLiveChangeNotice;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import hynb.p.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, Class<?>> f406687a;

    /* renamed from: b, reason: collision with root package name */
    public static LiveRoomEventCallback f406688b;

    /* renamed from: c, reason: collision with root package name */
    public static long f406689c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f406690d;

    /* renamed from: e, reason: collision with root package name */
    public static final hynb.g.a f406691e;

    static {
        HashMap hashMap = new HashMap();
        f406687a = hashMap;
        hashMap.put(8104, OpenBeginLiveNotice.class);
        f406687a.put(8106, OpenEndLiveNotice.class);
        f406687a.put(Integer.valueOf(MessageHandlerConstants.NOTIFY_TYPE_SAME_STATE_MSG_SEND_ERROR_RSP), AttendeeCountNotice.class);
        f406687a.put(8105, OpenLiveChangeNotice.class);
        f406689c = 0L;
        f406690d = false;
        f406691e = new hynb.g.a() { // from class: q15.a
            @Override // hynb.g.a
            public final void a(int i3, Object obj) {
                hynb.d.a.a(i3, obj);
            }
        };
    }

    public static /* synthetic */ void a(int i3, Object obj) {
        if (f406687a.containsKey(Integer.valueOf(i3))) {
            if (i3 != 8006) {
                switch (i3) {
                    case 8104:
                        a((OpenBeginLiveNotice) obj);
                        return;
                    case 8105:
                        a((OpenLiveChangeNotice) obj);
                        return;
                    case 8106:
                        a((OpenEndLiveNotice) obj);
                        return;
                    default:
                        g.f406799a.error("HuyaLiveRoomEvent", "onEvent: unknown data type");
                        return;
                }
            }
            a((AttendeeCountNotice) obj);
        }
    }

    public static void b() {
        g.f406799a.info("HuyaLiveRoomEvent", "onQuitLive");
        Iterator<Map.Entry<Integer, Class<?>>> it = f406687a.entrySet().iterator();
        while (it.hasNext()) {
            hynb.g.b.f406712m.a(it.next().getKey().intValue());
        }
        hynb.g.b.f406712m.b(f406691e);
        hynb.g.b.f406712m.a("HuyaLiveRoomEvent");
    }

    public static void a(LiveRoomEventCallback liveRoomEventCallback) {
        f406688b = liveRoomEventCallback;
    }

    public static void a(OpenBeginLiveNotice openBeginLiveNotice) {
        if (openBeginLiveNotice == null) {
            g.f406799a.error("HuyaLiveRoomEvent", "callbackLiveBegin: notice is null");
            return;
        }
        HuyaLiveBeginLive huyaLiveBeginLive = new HuyaLiveBeginLive();
        huyaLiveBeginLive.presenterUid = openBeginLiveNotice.lPresenterUid;
        huyaLiveBeginLive.title = openBeginLiveNotice.sLiveDesc;
        g.f406799a.a("HuyaLiveRoomEvent", "onLiveBegin callback " + huyaLiveBeginLive);
        LiveRoomEventCallback liveRoomEventCallback = f406688b;
        if (liveRoomEventCallback != null) {
            liveRoomEventCallback.onLiveBegin(huyaLiveBeginLive);
        }
    }

    public static void a(OpenLiveChangeNotice openLiveChangeNotice) {
        if (openLiveChangeNotice == null) {
            g.f406799a.error("HuyaLiveRoomEvent", "callbackLiveInfoChange: notice is null");
            return;
        }
        HuyaLiveBeginLive huyaLiveBeginLive = new HuyaLiveBeginLive();
        huyaLiveBeginLive.presenterUid = openLiveChangeNotice.lPresenterUid;
        huyaLiveBeginLive.title = openLiveChangeNotice.sTitle;
        g.f406799a.a("HuyaLiveRoomEvent", "onLiveInfoChange callback " + huyaLiveBeginLive);
        LiveRoomEventCallback liveRoomEventCallback = f406688b;
        if (liveRoomEventCallback != null) {
            liveRoomEventCallback.onLiveInfoChange(huyaLiveBeginLive);
        }
    }

    public static void a(OpenEndLiveNotice openEndLiveNotice) {
        g.f406799a.a("HuyaLiveRoomEvent", "onLiveEnd: " + openEndLiveNotice);
        b();
        LiveRoomEventCallback liveRoomEventCallback = f406688b;
        if (liveRoomEventCallback != null) {
            liveRoomEventCallback.onLiveEnd(openEndLiveNotice != null ? openEndLiveNotice.lPresenterUid : f406689c);
        }
    }

    public static void a(AttendeeCountNotice attendeeCountNotice) {
        if (attendeeCountNotice == null) {
            g.f406799a.error("HuyaLiveRoomEvent", "onAttendeeCountChange: notice is null");
            return;
        }
        g.f406799a.a("HuyaLiveRoomEvent", "onAttendeeCountChange: " + attendeeCountNotice.iAttendeeCount);
        LiveRoomEventCallback liveRoomEventCallback = f406688b;
        if (liveRoomEventCallback != null) {
            liveRoomEventCallback.onAttendeeCountChange(attendeeCountNotice.iAttendeeCount);
        }
    }

    public static void a() {
        g.f406799a.info("HuyaLiveRoomEvent", "onJoinLive");
        for (Map.Entry<Integer, Class<?>> entry : f406687a.entrySet()) {
            hynb.g.b.f406712m.a(entry.getKey().intValue(), entry.getValue());
        }
        hynb.g.b.f406712m.a(f406691e);
        hynb.g.b.f406712m.b("HuyaLiveRoomEvent");
    }
}

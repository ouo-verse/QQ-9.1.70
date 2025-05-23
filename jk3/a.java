package jk3;

import com.tencent.mobileqq.zplan.room.impl.constant.ZPlanJoinRoomType;
import com.tencent.mobileqq.zplan.room.impl.constant.ZPlanRoomInitData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Ljk3/a;", "", "", "b", "", "msg", "f", "e", "roomId", "Ljk3/c;", "d", "c", "from", "a", "Lcom/tencent/mobileqq/zplan/room/impl/constant/ZPlanJoinRoomType;", "joinRoomType", "Lkv4/a;", "selfUserInfo", "Lcom/tencent/mobileqq/zplan/room/impl/constant/a;", "roomInitData", h.F, "g", "", "Ljava/util/Map;", "roomManagerMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f410333a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, c> roomManagerMap = new LinkedHashMap();

    a() {
    }

    private final void b() {
        f("doWhenRoomListEmpty");
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).destroy();
    }

    private final void e(String msg2) {
        QLog.e("ZPlanRoom_List", 1, msg2);
    }

    private final void f(String msg2) {
        QLog.i("ZPlanRoom_List", 1, msg2);
    }

    public final void a(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Map<String, c> map = roomManagerMap;
        e("doWhenQQLogout, from " + from + ", exitAllRooms - " + map);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(map.keySet());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f410333a.g((String) it.next());
        }
    }

    public final String c() {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(roomManagerMap.keySet());
        return (String) firstOrNull;
    }

    public final c d(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return roomManagerMap.get(roomId);
    }

    public final void g(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        f("onExitRoom - " + roomId);
        Map<String, c> map = roomManagerMap;
        c remove = map.remove(roomId);
        if (remove != null) {
            remove.k();
        }
        if (map.isEmpty()) {
            b();
        }
    }

    public final void h(ZPlanJoinRoomType joinRoomType, kv4.a selfUserInfo, ZPlanRoomInitData roomInitData) {
        Intrinsics.checkNotNullParameter(joinRoomType, "joinRoomType");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        Intrinsics.checkNotNullParameter(roomInitData, "roomInitData");
        String roomId = roomInitData.getRoomId();
        Map<String, c> map = roomManagerMap;
        c cVar = map.get(roomId);
        f("onJoinNewRoom - " + roomId + ", type= " + joinRoomType + ", cacheRoomManager= " + cVar);
        if (cVar == null) {
            cVar = new c(roomId);
            map.put(roomId, cVar);
        }
        cVar.r(joinRoomType, selfUserInfo, roomInitData);
    }
}

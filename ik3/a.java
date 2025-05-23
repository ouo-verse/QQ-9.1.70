package ik3;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.room.impl.core.handler.ZPlanRoomListenerHandler;
import com.tencent.mobileqq.zplan.room.impl.entry.ZPlanRoomEntryUtil;
import gk3.c;
import hk3.a;
import hk3.b;
import iv4.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lv4.d;
import lv4.h;
import lv4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0007*\u0002\u001c \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J2\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007H\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007H\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lik3/a;", "Lgk3/a;", "", "openId", "componentId", "", "roomType", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/b;", "callback", "", "P0", "uniqueRoomId", "Llv4/h;", "e", "roomId", "Llv4/l;", "K0", "Llv4/d;", "O", "N0", "Lhk3/b;", "g", "Lgk3/c;", "listener", BdhLogUtil.LogTag.Tag_Conn, "from", "L0", "ik3/a$b", "b", "Lik3/a$b;", "defaultGetDataImpl", "ik3/a$a", "c", "Lik3/a$a;", "defaultDoOperationImpl", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements gk3.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b defaultGetDataImpl = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final C10537a defaultDoOperationImpl = new C10537a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"ik3/a$a", "Lhk3/b;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ik3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10537a implements hk3.b {
        C10537a() {
        }

        @Override // hk3.b
        public void a(int i3) {
            b.a.b(this, i3);
        }

        @Override // hk3.b
        public void b(boolean z16, e<Boolean> eVar) {
            b.a.d(this, z16, eVar);
        }

        @Override // hk3.b
        public void c(int i3, e<Boolean> eVar) {
            b.a.e(this, i3, eVar);
        }

        @Override // hk3.b
        public void d(int i3) {
            b.a.c(this, i3);
        }

        @Override // hk3.b
        public void e(boolean z16) {
            b.a.a(this, z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"ik3/a$b", "Lhk3/a;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements hk3.a {
        b() {
        }

        @Override // hk3.a
        public boolean a() {
            return a.C10446a.d(this);
        }

        @Override // hk3.a
        /* renamed from: b */
        public String getRoomId() {
            return a.C10446a.b(this);
        }

        @Override // hk3.a
        /* renamed from: c */
        public f getRoomDetail() {
            return a.C10446a.a(this);
        }

        @Override // hk3.a
        public kv4.a getSelfUserInfo() {
            return a.C10446a.c(this);
        }
    }

    @Override // gk3.a
    public void C(String roomId, c listener) {
        ZPlanRoomListenerHandler listenerHandler;
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        jk3.c d16 = jk3.a.f410333a.d(roomId);
        if (d16 == null || (listenerHandler = d16.getListenerHandler()) == null) {
            return;
        }
        listenerHandler.g(listener);
    }

    @Override // gk3.a
    public void K0(String roomId, e<l> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        ZPlanRoomEntryUtil.f335187a.n(roomId, callback);
    }

    @Override // gk3.a
    public void L0(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        jk3.a.f410333a.a(from);
    }

    @Override // gk3.a
    public String N0() {
        String c16 = jk3.a.f410333a.c();
        return c16 == null ? "" : c16;
    }

    @Override // gk3.a
    public void O(String roomId, e<d> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        ZPlanRoomEntryUtil.f335187a.j(roomId, callback);
    }

    @Override // gk3.a
    public void P0(String openId, String componentId, int roomType, e<lv4.b> callback) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        ZPlanRoomEntryUtil.f335187a.i(openId, componentId, roomType, callback);
    }

    @Override // gk3.a
    public void e(String uniqueRoomId, String openId, String componentId, e<h> callback) {
        Intrinsics.checkNotNullParameter(uniqueRoomId, "uniqueRoomId");
        Intrinsics.checkNotNullParameter(openId, "openId");
        ZPlanRoomEntryUtil.f335187a.m(null, uniqueRoomId, componentId, openId, callback);
    }

    @Override // gk3.a
    public hk3.b g(String roomId) {
        hk3.b n3;
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        jk3.c d16 = jk3.a.f410333a.d(roomId);
        return (d16 == null || (n3 = d16.n()) == null) ? this.defaultDoOperationImpl : n3;
    }
}

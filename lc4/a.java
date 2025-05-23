package lc4;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mc4.ZPlanUserFollowStatusInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import su4.c;
import su4.d;
import su4.g;
import su4.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ0\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J$\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012J\u001c\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0004R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010 R&\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\"0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 \u00a8\u0006&"}, d2 = {"Llc4/a;", "", "", "uin", "", "relation", "", "isRequesting", "", "g", "Lmc4/a;", "listener", "b", h.F, "", "tabType", "", "lastPageInfo", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/d;", "callback", "d", "uid", "currentRelation", "Lsu4/h;", "i", "Lsu4/b;", "f", "type", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Lmc4/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "userFollowStatusMap", "Ljava/util/concurrent/CopyOnWriteArraySet;", "userFollowListenerMap", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414373a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ZPlanUserFollowStatusInfo> userFollowStatusMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArraySet<mc4.a>> userFollowListenerMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"lc4/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lc4.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10717a implements e<su4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e<su4.b> f414376d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f414377e;

        C10717a(e<su4.b> eVar, long j3) {
            this.f414376d = eVar;
            this.f414377e = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(su4.b result) {
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(result, "result");
            i[] iVarArr = result.f434771a;
            if (iVarArr != null) {
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(iVarArr);
                i iVar = (i) firstOrNull;
                if (iVar != null) {
                    long j3 = this.f414377e;
                    if (iVar.f434792a == j3) {
                        a.f414373a.g(String.valueOf(j3), iVar.f434796e, false);
                    }
                }
            }
            this.f414376d.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f414376d.onResultFailure(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"lc4/a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements e<su4.h> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f414378d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f414379e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e<su4.h> f414380f;

        b(long j3, int i3, e<su4.h> eVar) {
            this.f414378d = j3;
            this.f414379e = i3;
            this.f414380f = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(su4.h result) {
            int i3;
            Intrinsics.checkNotNullParameter(result, "result");
            a aVar = a.f414373a;
            String valueOf = String.valueOf(this.f414378d);
            su4.e eVar = result.f434790a;
            if (eVar != null) {
                i3 = eVar.f434783b;
            } else {
                i3 = this.f414379e;
            }
            aVar.g(valueOf, i3, false);
            this.f414380f.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            a.f414373a.g(String.valueOf(this.f414378d), this.f414379e, false);
            this.f414380f.onResultFailure(error, message);
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String uin, int relation, boolean isRequesting) {
        QLog.i("ZPlanFriendDataHelper", 1, "notifyFollowStatusChange - " + uin + " - " + relation + " - " + isRequesting);
        ZPlanUserFollowStatusInfo zPlanUserFollowStatusInfo = new ZPlanUserFollowStatusInfo(uin, relation, isRequesting);
        userFollowStatusMap.put(uin, zPlanUserFollowStatusInfo);
        CopyOnWriteArraySet<mc4.a> copyOnWriteArraySet = userFollowListenerMap.get(uin);
        if (copyOnWriteArraySet != null) {
            Iterator<T> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                ((mc4.a) it.next()).a(zPlanUserFollowStatusInfo);
            }
        }
    }

    public final void b(String uin, mc4.a listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ConcurrentHashMap<String, CopyOnWriteArraySet<mc4.a>> concurrentHashMap = userFollowListenerMap;
        CopyOnWriteArraySet<mc4.a> copyOnWriteArraySet = concurrentHashMap.get(uin);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            concurrentHashMap.put(uin, copyOnWriteArraySet);
        }
        copyOnWriteArraySet.add(listener);
    }

    public final int c(long uin, int type) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Long valueOf = peekAppRuntime != null ? Long.valueOf(peekAppRuntime.getLongAccountUin()) : null;
        if (valueOf == null) {
            QLog.e("ZPlanFriendDataHelper", 1, "uin is null");
            return R.string.xwt;
        }
        boolean z16 = valueOf.longValue() == uin;
        return type != 1 ? type != 2 ? type != 3 ? R.string.xwt : R.string.xwx : z16 ? R.string.xwt : R.string.xwu : z16 ? R.string.xwv : R.string.xww;
    }

    public final void d(long uin, int tabType, byte[] lastPageInfo, e<d> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = new c();
        cVar.f434772a = tabType;
        cVar.f434773b = uin;
        if (lastPageInfo != null) {
            cVar.f434775d = lastPageInfo;
        }
        QLog.i("ZPlanFriendDataHelper", 1, "getAllFriendList start :: queryUin == " + uin);
        jc4.i.d(jc4.i.f409815a, cVar, callback, 0, 4, null);
    }

    public final void f(long uin, e<su4.b> callback) {
        List listOf;
        long[] longArray;
        Intrinsics.checkNotNullParameter(callback, "callback");
        su4.a aVar = new su4.a();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(uin));
        longArray = CollectionsKt___CollectionsKt.toLongArray(listOf);
        aVar.f434770a = longArray;
        QLog.i("ZPlanFriendDataHelper", 1, "getUserInfo start :: uid == " + uin + " ");
        jc4.i.b(jc4.i.f409815a, aVar, new C10717a(callback, uin), 0, 4, null);
    }

    public final void h(mc4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        for (Map.Entry<String, CopyOnWriteArraySet<mc4.a>> entry : userFollowListenerMap.entrySet()) {
            if (entry.getValue().contains(listener)) {
                entry.getValue().remove(listener);
            }
        }
    }

    public final void i(long uid, int currentRelation, e<su4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        g gVar = new g();
        su4.e eVar = new su4.e();
        eVar.f434782a = uid;
        eVar.f434783b = currentRelation;
        gVar.f434789a = eVar;
        g(String.valueOf(uid), currentRelation, true);
        QLog.i("ZPlanFriendDataHelper", 1, "updateRelation start :: uid == " + eVar.f434782a + " , relation == " + currentRelation);
        jc4.i.f(jc4.i.f409815a, gVar, new b(uid, currentRelation, callback), 0, 4, null);
    }

    public static /* synthetic */ void e(a aVar, long j3, int i3, byte[] bArr, e eVar, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            bArr = null;
        }
        aVar.d(j3, i3, bArr, eVar);
    }
}

package com.tencent.sqshow.zootopia.widget.reddot;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uv4.h;
import uv4.i;
import uv4.j;
import uv4.s;
import uv4.t;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J%\u0010\n\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001d\u0010\u0010\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/reddot/d;", "Lcom/tencent/sqshow/zootopia/widget/reddot/a;", "", "e", "g", "", "", "redDotIds", "", "isAppend", "a", "([Ljava/lang/Integer;Z)V", "redDotId", "Lgv4/e;", "b", "Luv4/h;", "d", "([Luv4/h;)V", "Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "f", "()Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "listener", "", "Ljava/util/List;", "reddotIdCache", "Lcom/tencent/sqshow/zootopia/data/q;", "c", "Lcom/tencent/sqshow/zootopia/data/q;", "reddotStatusCache", "<init>", "(Lcom/tencent/sqshow/zootopia/widget/reddot/b;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.widget.reddot.b listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<Integer> reddotIdCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private q reddotStatusCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/d$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/j;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<j> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f373449d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f373450e;

        b(i iVar, d dVar) {
            this.f373449d = iVar;
            this.f373450e = dVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(j result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZPlanAvatarRepo", 1, "req: " + this.f373449d + ", clearRedDot onResultSuccess , result: " + result);
            this.f373450e.g();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZPlanAvatarRepo", 1, "req: " + this.f373449d + ", clearRedDot onResultFailure, error: " + error + " , message: " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/d$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/t;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<t> {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0029, code lost:
        
            r4 = kotlin.collections.ArraysKt___ArraysKt.toList(r4);
         */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(t result) {
            List<gv4.e> arrayList;
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZPlanAvatarRepo", 1, "onResultSuccess , result: " + result);
            q qVar = new q(null, 1, null);
            gv4.e[] eVarArr = result.f440442a;
            if (eVarArr == null || arrayList == null) {
                arrayList = new ArrayList<>();
            }
            qVar.b(arrayList);
            d.this.reddotStatusCache = qVar;
            d.this.getListener().a(qVar);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZPlanAvatarRepo", 1, "onResultFailure, error: " + error + " , message: " + message);
        }
    }

    public d(com.tencent.sqshow.zootopia.widget.reddot.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.reddotIdCache = new ArrayList();
    }

    private final void e() {
        int[] intArray;
        s sVar = new s();
        intArray = CollectionsKt___CollectionsKt.toIntArray(this.reddotIdCache);
        sVar.f440440a = intArray;
        sVar.f440441b = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
        va4.b.d(va4.b.f441282a, sVar, new c(), 0, 4, null);
    }

    @Override // com.tencent.sqshow.zootopia.widget.reddot.a
    public void a(Integer[] redDotIds, boolean isAppend) {
        Intrinsics.checkNotNullParameter(redDotIds, "redDotIds");
        if (!isAppend) {
            this.reddotIdCache.clear();
        }
        for (Integer num : redDotIds) {
            this.reddotIdCache.add(Integer.valueOf(num.intValue()));
        }
        e();
    }

    @Override // com.tencent.sqshow.zootopia.widget.reddot.a
    public gv4.e b(int redDotId) {
        List<gv4.e> a16;
        q qVar = this.reddotStatusCache;
        Object obj = null;
        if (qVar == null || (a16 = qVar.a()) == null) {
            return null;
        }
        Iterator<T> it = a16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((gv4.e) next).f403425a == redDotId) {
                obj = next;
                break;
            }
        }
        return (gv4.e) obj;
    }

    public void d(h[] redDotIds) {
        Intrinsics.checkNotNullParameter(redDotIds, "redDotIds");
        i iVar = new i();
        iVar.f440426a = redDotIds;
        iVar.f440427b = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
        va4.b.b(va4.b.f441282a, iVar, new b(iVar, this), 0, 4, null);
    }

    /* renamed from: f, reason: from getter */
    public final com.tencent.sqshow.zootopia.widget.reddot.b getListener() {
        return this.listener;
    }

    public void g() {
        e();
    }
}

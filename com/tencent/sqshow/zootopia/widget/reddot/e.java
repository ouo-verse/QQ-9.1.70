package com.tencent.sqshow.zootopia.widget.reddot;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaMainRecommendListData;
import com.tencent.sqshow.zootopia.data.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;
import qv4.bq;
import tl.h;
import yb4.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J%\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tR\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/reddot/e;", "Lcom/tencent/sqshow/zootopia/widget/reddot/a;", "", h.F, "Lcom/tencent/sqshow/zootopia/data/k;", "zootopiaPortalRedDotData", "e", "k", "", "", "redDotIds", "", "isAppend", "a", "([Ljava/lang/Integer;Z)V", "j", "redDotId", "Lgv4/e;", "b", "", "templateTab", "f", "dataType", "g", "Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "i", "()Lcom/tencent/sqshow/zootopia/widget/reddot/b;", "listener", "Lyb4/i;", "Lyb4/i;", "reddotService", "", "c", "Ljava/util/List;", "reddotIdCache", "Lcom/tencent/sqshow/zootopia/data/q;", "d", "Lcom/tencent/sqshow/zootopia/data/q;", "reddotStatusCache", "<init>", "(Lcom/tencent/sqshow/zootopia/widget/reddot/b;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.widget.reddot.b listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private i reddotService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<Integer> reddotIdCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private q reddotStatusCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/e$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<Boolean> {
        c() {
        }

        public void a(boolean result) {
            e.this.k();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanPortalRepo", 1, "clear user center Red Dot failed " + error + " , " + message);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/e$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/q;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<q> {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(q result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZPlanPortalRepo", 1, "request redditId: " + e.this.reddotIdCache);
            QLog.d("ZPlanPortalRepo", 1, "onResultSuccess:" + result);
            e.this.reddotStatusCache = result;
            e.this.getListener().a(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZPlanPortalRepo", 1, "onResultFailure, error:" + error + ", message:" + message);
        }
    }

    public e(com.tencent.sqshow.zootopia.widget.reddot.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.reddotService = new i();
        this.reddotIdCache = new ArrayList();
    }

    private final void e(ZootopiaMainRecommendListData zootopiaPortalRedDotData) {
        int collectionSizeOrDefault;
        this.reddotIdCache.clear();
        this.reddotIdCache.add(Integer.valueOf(zootopiaPortalRedDotData.getMailReddotId()));
        this.reddotIdCache.add(Integer.valueOf(zootopiaPortalRedDotData.getBagReddotId()));
        bq ugcEnterInfo = zootopiaPortalRedDotData.getUgcEnterInfo();
        if (ugcEnterInfo != null) {
            this.reddotIdCache.add(Integer.valueOf(ugcEnterInfo.f430104c));
        }
        Iterator<T> it = zootopiaPortalRedDotData.b().iterator();
        while (it.hasNext()) {
            List<s> c16 = ((ZootopiaCardData) it.next()).c();
            if (c16 != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : c16) {
                    if (((s) obj).f427688i > 0) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(Integer.valueOf(((s) it5.next()).f427688i));
                }
                this.reddotIdCache.addAll(arrayList2);
            }
        }
    }

    private final void h() {
        if (this.reddotIdCache.size() == 0) {
            QLog.d("ZPlanPortalRepo", 1, "doRequestRedDot, reddotIdCache is empty");
        } else {
            this.reddotService.g(this.reddotIdCache, new d());
        }
    }

    @Override // com.tencent.sqshow.zootopia.widget.reddot.a
    public void a(Integer[] redDotIds, boolean isAppend) {
        Intrinsics.checkNotNullParameter(redDotIds, "redDotIds");
        String arrays = Arrays.toString(redDotIds);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.d("ZPlanPortalRepo", 1, "requestRedDot:" + arrays + ", isAppend:" + isAppend);
        if (!isAppend) {
            this.reddotIdCache.clear();
        }
        for (Integer num : redDotIds) {
            this.reddotIdCache.add(Integer.valueOf(num.intValue()));
        }
        h();
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

    public final void f(long templateTab) {
        this.reddotService.b(templateTab, new b());
    }

    public final void g(int dataType) {
        this.reddotService.c(dataType, new c());
    }

    /* renamed from: i, reason: from getter */
    public final com.tencent.sqshow.zootopia.widget.reddot.b getListener() {
        return this.listener;
    }

    public void k() {
        QLog.d("ZPlanPortalRepo", 1, "requestRedDot, for refresh old redDot id: " + this.reddotIdCache);
        a(new Integer[0], true);
    }

    public final void j(ZootopiaMainRecommendListData zootopiaPortalRedDotData) {
        if (zootopiaPortalRedDotData == null) {
            return;
        }
        e(zootopiaPortalRedDotData);
        k();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/widget/reddot/e$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lvu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<vu4.b> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(vu4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            e.this.k();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }
}

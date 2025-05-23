package com.qzone.reborn.groupalbum.selectmedia.util;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0099\u0001\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042,\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\u0002\b\u000b2A\u0010\u0010\u001a=\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\u0002\b\u000bH\u0000\u001aE\u0010\u001b\u001a\u00020\n*\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0016\u001a\u00020\u00152!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00120\u0017H\u0000\u001a;\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004*\b\u0012\u0004\u0012\u00020\u00130\u00042!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00120\u0017H\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000\u001a(\u0010%\u001a\u00020\n*\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0!H\u0000\"\u0014\u0010(\u001a\u00020\u001d8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006)"}, d2 = {"T", "Lxi/c;", "Lwi/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "Lkotlin/ExtensionFunctionType;", "newBind", "Lkotlin/Function3;", "Lcom/qzone/reborn/groupalbum/selectmedia/util/f;", "payLoadMap", "updateBind", "a", "Lzi/a;", "Lzi/b;", "moreDatas", "Lxi/b;", "adapter", "Lkotlin/Function1;", "", "msgTime", "groupCreator", "c", "b", "", "spanCount", "d", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/Function0;", "", "enableLoadMore", "preLoad", "f", "e", "()I", "requestNextPageCount", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/groupalbum/selectmedia/util/b$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Boolean> f56954d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f56955e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f56956f;

        a(Function0<Boolean> function0, RecyclerView recyclerView, Function0<Unit> function02) {
            this.f56954d = function0;
            this.f56955e = recyclerView;
            this.f56956f = function02;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (dy5 > 0 && this.f56954d.invoke().booleanValue()) {
                int computeHorizontalScrollRange = this.f56955e.computeHorizontalScrollRange();
                int computeVerticalScrollExtent = this.f56955e.computeVerticalScrollExtent();
                int i3 = computeHorizontalScrollRange - computeVerticalScrollExtent;
                c.f56957a.a("preLoad", " bottomOffset " + i3 + "  computeVerticalScrollExtent " + computeVerticalScrollExtent + " ");
                if (i3 < computeVerticalScrollExtent * 2) {
                    this.f56956f.invoke();
                }
            }
        }
    }

    public static final <T> void a(xi.c cVar, wi.b item, List<? extends Object> payloads, Function2<? super xi.c, ? super T, Unit> newBind, Function3<? super xi.c, ? super T, ? super f, Unit> updateBind) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Intrinsics.checkNotNullParameter(newBind, "newBind");
        Intrinsics.checkNotNullParameter(updateBind, "updateBind");
        if (payloads.isEmpty()) {
            newBind.invoke(cVar, item);
            return;
        }
        Object obj = payloads.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.selectmedia.util.PayLoadMap");
        updateBind.invoke(cVar, item, (f) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v13, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Object] */
    public static final List<zi.a> b(List<? extends zi.b> list, Function1<? super Long, ? extends zi.a> groupCreator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(groupCreator, "groupCreator");
        ArrayList arrayList = new ArrayList();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        for (zi.b bVar : list) {
            if (yi.f.d(bVar)) {
                if (objectRef.element == 0) {
                    ?? invoke = groupCreator.invoke(Long.valueOf(bVar.getMsgTime()));
                    arrayList.add((zi.a) invoke);
                    objectRef.element = invoke;
                }
                T t16 = objectRef.element;
                if (t16 != 0) {
                    ((zi.a) t16).f(bVar);
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                if (objectRef2.element == 0) {
                    ?? invoke2 = groupCreator.invoke(Long.valueOf(bVar.getMsgTime()));
                    objectRef2.element = invoke2;
                    Intrinsics.checkNotNull(invoke2);
                    arrayList.add(invoke2);
                }
                T t17 = objectRef2.element;
                if (t17 != 0) {
                    zi.a aVar = (zi.a) t17;
                    if (yi.f.c(aVar) == yi.f.c(bVar) && yi.f.b(aVar) == yi.f.b(bVar)) {
                        aVar.f(bVar);
                    } else {
                        ?? invoke3 = groupCreator.invoke(Long.valueOf(bVar.getMsgTime()));
                        zi.a aVar2 = (zi.a) invoke3;
                        arrayList.add(aVar2);
                        aVar2.f(bVar);
                        objectRef2.element = invoke3;
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        }
        return arrayList;
    }

    public static final int d(int i3) {
        int i16;
        g gVar = g.f56961a;
        int b16 = gVar.b();
        int c16 = gVar.c();
        if (b16 > c16) {
            i16 = c16 / 4;
        } else {
            i16 = b16 / 4;
        }
        return ((int) (((b16 > c16 ? b16 : c16) * 1.5d) / i16)) * 4;
    }

    public static final int e() {
        return 20;
    }

    public static final void f(RecyclerView recyclerView, Function0<Boolean> enableLoadMore, Function0<Unit> preLoad) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(enableLoadMore, "enableLoadMore");
        Intrinsics.checkNotNullParameter(preLoad, "preLoad");
        recyclerView.addOnScrollListener(new a(enableLoadMore, recyclerView, preLoad));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd A[LOOP:1: B:20:0x0085->B:25:0x00fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0100 A[EDGE_INSN: B:26:0x0100->B:31:0x0100 BREAK  A[LOOP:1: B:20:0x0085->B:25:0x00fd], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(zi.a aVar, List<? extends zi.b> moreDatas, xi.b adapter, Function1<? super Long, ? extends zi.a> groupCreator) {
        int lastIndex;
        zi.a invoke;
        boolean e16;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(moreDatas, "moreDatas");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(groupCreator, "groupCreator");
        c.f56957a.a("HistoryExt", "lastParentNode " + aVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : moreDatas) {
            zi.b bVar = (zi.b) obj;
            if (yi.f.d(bVar)) {
                bVar.e(aVar);
                e16 = true;
            } else {
                e16 = yi.f.e(aVar, yi.f.c(bVar), yi.f.b(bVar));
                if (e16) {
                    bVar.e(aVar);
                }
            }
            if (e16) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(moreDatas);
        if (size <= lastIndex) {
            zi.a aVar2 = null;
            while (true) {
                zi.b bVar2 = moreDatas.get(size);
                c.f56957a.a("HistoryExt", "index " + size + " childNode " + yi.f.c(bVar2) + "- " + yi.f.b(bVar2));
                if (aVar2 == null) {
                    invoke = groupCreator.invoke(Long.valueOf(bVar2.getMsgTime()));
                    invoke.f(bVar2);
                    arrayList2.add(invoke);
                } else if (yi.f.e(aVar2, yi.f.c(bVar2), yi.f.b(bVar2))) {
                    aVar2.f(bVar2);
                    if (size != lastIndex) {
                        break;
                    } else {
                        size++;
                    }
                } else {
                    invoke = groupCreator.invoke(Long.valueOf(bVar2.getMsgTime()));
                    invoke.f(bVar2);
                    arrayList2.add(invoke);
                }
                aVar2 = invoke;
                if (size != lastIndex) {
                }
            }
        }
        if (!arrayList.isEmpty()) {
            adapter.L0(aVar, aVar.b().size(), arrayList);
            c.f56957a.a("HistoryExt", " dealLoadMore \u62fc\u63a5\u5728\u4e0a\u4e00\u4e2a\u7236\u8282\u70b9  " + arrayList.size());
        }
        if (!arrayList2.isEmpty()) {
            adapter.j0(arrayList2);
            c.f56957a.a("HistoryExt", " dealLoadMore  \u65b0\u52a0\u8282\u70b9 " + arrayList2 + " ");
        }
    }
}

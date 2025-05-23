package com.tencent.mobileqq.wink.editor.aielimination.model;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B/\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\f\u001a\u00020\u0000R'\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/model/a;", "", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", h.F, "g", "", "e", "f", "d", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "eliminationList", "", "Ljava/util/List;", "getMRedoItemStack", "()Ljava/util/List;", "mRedoItemStack", "<init>", "(Ljava/util/ArrayList;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> eliminationList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> mRedoItemStack;

    public a(@NotNull ArrayList<b> eliminationList, @NotNull List<b> mRedoItemStack) {
        Intrinsics.checkNotNullParameter(eliminationList, "eliminationList");
        Intrinsics.checkNotNullParameter(mRedoItemStack, "mRedoItemStack");
        this.eliminationList = eliminationList;
        this.mRedoItemStack = mRedoItemStack;
    }

    public final void a(@NotNull b item) {
        Intrinsics.checkNotNullParameter(item, "item");
        w53.b.a("AIEliminationData", "add item, size: " + this.eliminationList.size());
        this.mRedoItemStack.clear();
        this.eliminationList.add(item);
    }

    @NotNull
    public final a b() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.eliminationList.iterator();
        while (it.hasNext()) {
            arrayList.add((b) it.next());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it5 = this.mRedoItemStack.iterator();
        while (it5.hasNext()) {
            arrayList2.add((b) it5.next());
        }
        return new a(arrayList, arrayList2);
    }

    @NotNull
    public final ArrayList<b> c() {
        return this.eliminationList;
    }

    @Nullable
    public final b d() {
        if (this.eliminationList.size() > 0) {
            return this.eliminationList.get(r0.size() - 1);
        }
        return null;
    }

    public final boolean e() {
        return this.mRedoItemStack.isEmpty();
    }

    public final boolean f() {
        if (this.eliminationList.size() <= 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public final b g() {
        w53.b.a("AIEliminationData", "redo, size: " + this.eliminationList.size() + ", redo size: " + this.mRedoItemStack.size());
        if (this.mRedoItemStack.isEmpty()) {
            return null;
        }
        b remove = this.mRedoItemStack.remove(0);
        this.eliminationList.add(remove);
        return remove;
    }

    @Nullable
    public final b h() {
        w53.b.a("AIEliminationData", "undo, size: " + this.eliminationList.size());
        ArrayList<b> arrayList = this.eliminationList;
        if (!arrayList.isEmpty()) {
            b bVar = this.eliminationList.get(arrayList.size() - 1);
            Intrinsics.checkNotNullExpressionValue(bVar, "eliminationList[items.size - 1]");
            b bVar2 = bVar;
            this.eliminationList.remove(bVar2);
            this.mRedoItemStack.add(0, bVar2);
        }
        if (this.eliminationList.size() > 0) {
            return this.eliminationList.get(r0.size() - 1);
        }
        return null;
    }

    public /* synthetic */ a(ArrayList arrayList, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i3 & 2) != 0 ? new ArrayList() : list);
    }
}

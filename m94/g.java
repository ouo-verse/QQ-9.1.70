package m94;

import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0010B+\u0012\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\u0015H\u0016J\t\u0010\u0017\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001f\u00a8\u0006#"}, d2 = {"Lm94/g;", "Lm94/j;", "", "d", "", "f", tl.h.F, "e", "Lm94/a;", "info", "", "c", "i", "targetIndex", "g", "b", "a", "targetCursor", "j", IZplanHandleApi.BUSINESS_DRESS_INFO, "k", "", "toString", "hashCode", "", "other", "equals", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "historyList", "I", "historyCursor", "<init>", "(Ljava/util/ArrayList;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final /* data */ class g implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<a> historyList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int historyCursor;

    public g() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    private final void d() {
        if (this.historyList.size() <= 30) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<a> arrayList2 = this.historyList;
        arrayList.addAll(arrayList2.subList(arrayList2.size() - 30, this.historyList.size()));
        this.historyList.clear();
        this.historyList.addAll(arrayList);
    }

    @Override // m94.j
    public boolean a() {
        return this.historyCursor < this.historyList.size() - 1;
    }

    @Override // m94.j
    public boolean b() {
        return this.historyCursor > 0;
    }

    public final boolean c(a info) {
        Object orNull;
        Intrinsics.checkNotNullParameter(info, "info");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.historyList, this.historyCursor);
        if (((a) orNull) == null) {
            return true;
        }
        return !r94.a.c(r0.getAvatarCharacter(), info.getAvatarCharacter());
    }

    /* renamed from: f, reason: from getter */
    public final int getHistoryCursor() {
        return this.historyCursor;
    }

    public final a g(int targetIndex) {
        a aVar = this.historyList.get(targetIndex);
        Intrinsics.checkNotNullExpressionValue(aVar, "historyList[targetIndex]");
        return aVar;
    }

    public final int h() {
        return this.historyList.size();
    }

    public int hashCode() {
        return (this.historyList.hashCode() * 31) + this.historyCursor;
    }

    public final void i() {
        if (this.historyList.size() <= 1) {
            return;
        }
        this.historyCursor = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.historyList.get(0));
        this.historyList.clear();
        this.historyList.addAll(arrayList);
    }

    public final void j(int targetCursor) {
        QLog.i("DressHistoryData_", 1, "updateCursor targetCursor:" + targetCursor + ", historySize:" + this.historyList.size());
        if (targetCursor >= 0 && targetCursor < this.historyList.size()) {
            this.historyCursor = targetCursor;
        }
    }

    public final void k(int targetIndex, a dressInfo) {
        Intrinsics.checkNotNullParameter(dressInfo, "dressInfo");
        if (targetIndex < 0) {
            return;
        }
        if (targetIndex == 0) {
            this.historyList.clear();
            this.historyList.add(dressInfo);
        } else if (!this.historyList.isEmpty() && targetIndex != this.historyList.size()) {
            ArrayList<a> arrayList = this.historyList;
            ArrayList arrayList2 = new ArrayList(arrayList.subList(0, RangesKt.coerceAtMost(targetIndex, arrayList.size())));
            this.historyList.clear();
            this.historyList.addAll(arrayList2);
            this.historyList.add(dressInfo);
        } else {
            this.historyList.add(dressInfo);
        }
        d();
        this.historyCursor = this.historyList.size() - 1;
    }

    public String toString() {
        return "{historyCursor:" + this.historyCursor + ", historyList:" + this.historyList.size() + "}";
    }

    public g(ArrayList<a> historyList, int i3) {
        Intrinsics.checkNotNullParameter(historyList, "historyList");
        this.historyList = historyList;
        this.historyCursor = i3;
    }

    public final void e() {
        this.historyCursor = -1;
        this.historyList.clear();
    }

    public /* synthetic */ g(ArrayList arrayList, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new ArrayList() : arrayList, (i16 & 2) != 0 ? -1 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        return Intrinsics.areEqual(this.historyList, gVar.historyList) && this.historyCursor == gVar.historyCursor;
    }
}

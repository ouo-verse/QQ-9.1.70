package com.tencent.mobileqq.wink.editor.draft;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "duration", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "winkEditDataList", "Z", "()Z", "needTransition", "<init>", "(JLjava/util/ArrayList;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.draft.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkEditDataListResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long duration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<WinkEditData> winkEditDataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needTransition;

    public WinkEditDataListResult(long j3, @NotNull ArrayList<WinkEditData> winkEditDataList, boolean z16) {
        Intrinsics.checkNotNullParameter(winkEditDataList, "winkEditDataList");
        this.duration = j3;
        this.winkEditDataList = winkEditDataList;
        this.needTransition = z16;
    }

    /* renamed from: a, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedTransition() {
        return this.needTransition;
    }

    @NotNull
    public final ArrayList<WinkEditData> c() {
        return this.winkEditDataList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkEditDataListResult)) {
            return false;
        }
        WinkEditDataListResult winkEditDataListResult = (WinkEditDataListResult) other;
        if (this.duration == winkEditDataListResult.duration && Intrinsics.areEqual(this.winkEditDataList, winkEditDataListResult.winkEditDataList) && this.needTransition == winkEditDataListResult.needTransition) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((androidx.fragment.app.a.a(this.duration) * 31) + this.winkEditDataList.hashCode()) * 31;
        boolean z16 = this.needTransition;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "WinkEditDataListResult(duration=" + this.duration + ", winkEditDataList=" + this.winkEditDataList + ", needTransition=" + this.needTransition + ")";
    }

    public /* synthetic */ WinkEditDataListResult(long j3, ArrayList arrayList, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, arrayList, (i3 & 4) != 0 ? false : z16);
    }
}

package com.tencent.mobileqq.guild.aisearch.history;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR2\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/a;", "Lcom/tencent/mobileqq/guild/aisearch/history/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "groupTitle", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/aisearch/history/f;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "c", "(Ljava/util/ArrayList;)V", "queryItemList", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.history.a, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class AIChatHistoryGroupItem extends g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupTitle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<AIChatHistorySessionItem> queryItemList;

    public /* synthetic */ AIChatHistoryGroupItem(String str, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? new ArrayList() : arrayList);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGroupTitle() {
        return this.groupTitle;
    }

    @NotNull
    public final ArrayList<AIChatHistorySessionItem> b() {
        return this.queryItemList;
    }

    public final void c(@NotNull ArrayList<AIChatHistorySessionItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.queryItemList = arrayList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIChatHistoryGroupItem)) {
            return false;
        }
        AIChatHistoryGroupItem aIChatHistoryGroupItem = (AIChatHistoryGroupItem) other;
        if (Intrinsics.areEqual(this.groupTitle, aIChatHistoryGroupItem.groupTitle) && Intrinsics.areEqual(this.queryItemList, aIChatHistoryGroupItem.queryItemList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.groupTitle.hashCode() * 31) + this.queryItemList.hashCode();
    }

    @NotNull
    public String toString() {
        return "AIChatHistoryGroupItem(groupTitle=" + this.groupTitle + ", queryItemList=" + this.queryItemList + ")";
    }

    public AIChatHistoryGroupItem(@NotNull String groupTitle, @NotNull ArrayList<AIChatHistorySessionItem> queryItemList) {
        Intrinsics.checkNotNullParameter(groupTitle, "groupTitle");
        Intrinsics.checkNotNullParameter(queryItemList, "queryItemList");
        this.groupTitle = groupTitle;
        this.queryItemList = queryItemList;
    }
}

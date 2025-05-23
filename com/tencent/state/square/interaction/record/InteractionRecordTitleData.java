package com.tencent.state.square.interaction.record;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordTitleData;", "", "icon", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionRecordTitleData {
    private final String icon;
    private final String title;

    public InteractionRecordTitleData(String icon, String title) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        this.icon = icon;
        this.title = title;
    }

    /* renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final InteractionRecordTitleData copy(String icon, String title) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        return new InteractionRecordTitleData(icon, title);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.icon;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InteractionRecordTitleData(icon=" + this.icon + ", title=" + this.title + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionRecordTitleData)) {
            return false;
        }
        InteractionRecordTitleData interactionRecordTitleData = (InteractionRecordTitleData) other;
        return Intrinsics.areEqual(this.icon, interactionRecordTitleData.icon) && Intrinsics.areEqual(this.title, interactionRecordTitleData.title);
    }

    public static /* synthetic */ InteractionRecordTitleData copy$default(InteractionRecordTitleData interactionRecordTitleData, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = interactionRecordTitleData.icon;
        }
        if ((i3 & 2) != 0) {
            str2 = interactionRecordTitleData.title;
        }
        return interactionRecordTitleData.copy(str, str2);
    }
}

package com.tencent.state.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/view/TitleData;", "", "id", "", "text", "hasRed", "", "statusIdList", "isSelect", "activityData", "Lcom/tencent/state/view/ActivityData;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/tencent/state/view/ActivityData;)V", "getActivityData", "()Lcom/tencent/state/view/ActivityData;", "getHasRed", "()Z", "setHasRed", "(Z)V", "getId", "()Ljava/lang/String;", "setSelect", "getStatusIdList", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class TitleData {
    private final ActivityData activityData;
    private boolean hasRed;
    private final String id;
    private boolean isSelect;
    private final String statusIdList;
    private final String text;

    public TitleData(String id5, String text, boolean z16, String statusIdList, boolean z17, ActivityData activityData) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(statusIdList, "statusIdList");
        Intrinsics.checkNotNullParameter(activityData, "activityData");
        this.id = id5;
        this.text = text;
        this.hasRed = z16;
        this.statusIdList = statusIdList;
        this.isSelect = z17;
        this.activityData = activityData;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasRed() {
        return this.hasRed;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatusIdList() {
        return this.statusIdList;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* renamed from: component6, reason: from getter */
    public final ActivityData getActivityData() {
        return this.activityData;
    }

    public final TitleData copy(String id5, String text, boolean hasRed, String statusIdList, boolean isSelect, ActivityData activityData) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(statusIdList, "statusIdList");
        Intrinsics.checkNotNullParameter(activityData, "activityData");
        return new TitleData(id5, text, hasRed, statusIdList, isSelect, activityData);
    }

    public final ActivityData getActivityData() {
        return this.activityData;
    }

    public final boolean getHasRed() {
        return this.hasRed;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStatusIdList() {
        return this.statusIdList;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.hasRed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        String str3 = this.statusIdList;
        int hashCode3 = (i16 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z17 = this.isSelect;
        int i17 = (hashCode3 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        ActivityData activityData = this.activityData;
        return i17 + (activityData != null ? activityData.hashCode() : 0);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setHasRed(boolean z16) {
        this.hasRed = z16;
    }

    public final void setSelect(boolean z16) {
        this.isSelect = z16;
    }

    public String toString() {
        return "TitleData(id=" + this.id + ", text=" + this.text + ", hasRed=" + this.hasRed + ", statusIdList=" + this.statusIdList + ", isSelect=" + this.isSelect + ", activityData=" + this.activityData + ")";
    }

    public /* synthetic */ TitleData(String str, String str2, boolean z16, String str3, boolean z17, ActivityData activityData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z16, str3, z17, (i3 & 32) != 0 ? new ActivityData("") : activityData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleData)) {
            return false;
        }
        TitleData titleData = (TitleData) other;
        return Intrinsics.areEqual(this.id, titleData.id) && Intrinsics.areEqual(this.text, titleData.text) && this.hasRed == titleData.hasRed && Intrinsics.areEqual(this.statusIdList, titleData.statusIdList) && this.isSelect == titleData.isSelect && Intrinsics.areEqual(this.activityData, titleData.activityData);
    }

    public static /* synthetic */ TitleData copy$default(TitleData titleData, String str, String str2, boolean z16, String str3, boolean z17, ActivityData activityData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = titleData.id;
        }
        if ((i3 & 2) != 0) {
            str2 = titleData.text;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            z16 = titleData.hasRed;
        }
        boolean z18 = z16;
        if ((i3 & 8) != 0) {
            str3 = titleData.statusIdList;
        }
        String str5 = str3;
        if ((i3 & 16) != 0) {
            z17 = titleData.isSelect;
        }
        boolean z19 = z17;
        if ((i3 & 32) != 0) {
            activityData = titleData.activityData;
        }
        return titleData.copy(str, str4, z18, str5, z19, activityData);
    }
}

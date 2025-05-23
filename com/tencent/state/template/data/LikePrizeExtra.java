package com.tencent.state.template.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/template/data/LikePrizeExtra;", "Lcom/tencent/state/template/data/BasePrizeExtra;", "tagId", "", "tagText", "type", "Lcom/tencent/state/template/data/LikePrizeType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/template/data/LikePrizeType;)V", "getTagId", "()Ljava/lang/String;", "getTagText", "getType", "()Lcom/tencent/state/template/data/LikePrizeType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class LikePrizeExtra extends BasePrizeExtra {
    private final String tagId;
    private final String tagText;
    private final LikePrizeType type;

    public LikePrizeExtra(String tagId, String tagText, LikePrizeType type) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(tagText, "tagText");
        Intrinsics.checkNotNullParameter(type, "type");
        this.tagId = tagId;
        this.tagText = tagText;
        this.type = type;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTagId() {
        return this.tagId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTagText() {
        return this.tagText;
    }

    /* renamed from: component3, reason: from getter */
    public final LikePrizeType getType() {
        return this.type;
    }

    public final LikePrizeExtra copy(String tagId, String tagText, LikePrizeType type) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(tagText, "tagText");
        Intrinsics.checkNotNullParameter(type, "type");
        return new LikePrizeExtra(tagId, tagText, type);
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final LikePrizeType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.tagId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tagText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        LikePrizeType likePrizeType = this.type;
        return hashCode2 + (likePrizeType != null ? likePrizeType.hashCode() : 0);
    }

    public String toString() {
        return "LikePrizeExtra(tagId=" + this.tagId + ", tagText=" + this.tagText + ", type=" + this.type + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikePrizeExtra)) {
            return false;
        }
        LikePrizeExtra likePrizeExtra = (LikePrizeExtra) other;
        return Intrinsics.areEqual(this.tagId, likePrizeExtra.tagId) && Intrinsics.areEqual(this.tagText, likePrizeExtra.tagText) && Intrinsics.areEqual(this.type, likePrizeExtra.type);
    }

    public static /* synthetic */ LikePrizeExtra copy$default(LikePrizeExtra likePrizeExtra, String str, String str2, LikePrizeType likePrizeType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = likePrizeExtra.tagId;
        }
        if ((i3 & 2) != 0) {
            str2 = likePrizeExtra.tagText;
        }
        if ((i3 & 4) != 0) {
            likePrizeType = likePrizeExtra.type;
        }
        return likePrizeExtra.copy(str, str2, likePrizeType);
    }
}

package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/data/Tag;", "", "id", "", "text", "", "type", "colorString", "(ILjava/lang/String;ILjava/lang/String;)V", "getColorString", "()Ljava/lang/String;", "getId", "()I", "getText", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Tag {
    private final String colorString;
    private final int id;
    private final String text;
    private final int type;

    public Tag(int i3, String text, int i16, String colorString) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(colorString, "colorString");
        this.id = i3;
        this.text = text;
        this.type = i16;
        this.colorString = colorString;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getColorString() {
        return this.colorString;
    }

    public final Tag copy(int id5, String text, int type, String colorString) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(colorString, "colorString");
        return new Tag(id5, text, type, colorString);
    }

    public final String getColorString() {
        return this.colorString;
    }

    public final int getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i3 = this.id * 31;
        String str = this.text;
        int hashCode = (((i3 + (str != null ? str.hashCode() : 0)) * 31) + this.type) * 31;
        String str2 = this.colorString;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Tag(id=" + this.id + ", text=" + this.text + ", type=" + this.type + ", colorString=" + this.colorString + ")";
    }

    public /* synthetic */ Tag(int i3, String str, int i16, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? "#E6CECA" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) other;
        return this.id == tag.id && Intrinsics.areEqual(this.text, tag.text) && this.type == tag.type && Intrinsics.areEqual(this.colorString, tag.colorString);
    }

    public static /* synthetic */ Tag copy$default(Tag tag, int i3, String str, int i16, String str2, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = tag.id;
        }
        if ((i17 & 2) != 0) {
            str = tag.text;
        }
        if ((i17 & 4) != 0) {
            i16 = tag.type;
        }
        if ((i17 & 8) != 0) {
            str2 = tag.colorString;
        }
        return tag.copy(i3, str, i16, str2);
    }
}

package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "get_zplan_my_nameplate_click_jump_to", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "get_zplan_guest_nameplate_click_jump_to", "a", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.f, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class NameplateClickJumpTo {

    @SerializedName("get_zplan_guest_nameplate_click_jump_to")
    private final String get_zplan_guest_nameplate_click_jump_to;

    @SerializedName("get_zplan_my_nameplate_click_jump_to")
    private final String get_zplan_my_nameplate_click_jump_to;

    public NameplateClickJumpTo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final String getGet_zplan_guest_nameplate_click_jump_to() {
        return this.get_zplan_guest_nameplate_click_jump_to;
    }

    /* renamed from: b, reason: from getter */
    public final String getGet_zplan_my_nameplate_click_jump_to() {
        return this.get_zplan_my_nameplate_click_jump_to;
    }

    public int hashCode() {
        return (this.get_zplan_my_nameplate_click_jump_to.hashCode() * 31) + this.get_zplan_guest_nameplate_click_jump_to.hashCode();
    }

    public String toString() {
        return "NameplateClickJumpTo(get_zplan_my_nameplate_click_jump_to=" + this.get_zplan_my_nameplate_click_jump_to + ", get_zplan_guest_nameplate_click_jump_to=" + this.get_zplan_guest_nameplate_click_jump_to + ')';
    }

    public NameplateClickJumpTo(String get_zplan_my_nameplate_click_jump_to, String get_zplan_guest_nameplate_click_jump_to) {
        Intrinsics.checkNotNullParameter(get_zplan_my_nameplate_click_jump_to, "get_zplan_my_nameplate_click_jump_to");
        Intrinsics.checkNotNullParameter(get_zplan_guest_nameplate_click_jump_to, "get_zplan_guest_nameplate_click_jump_to");
        this.get_zplan_my_nameplate_click_jump_to = get_zplan_my_nameplate_click_jump_to;
        this.get_zplan_guest_nameplate_click_jump_to = get_zplan_guest_nameplate_click_jump_to;
    }

    public /* synthetic */ NameplateClickJumpTo(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NameplateClickJumpTo)) {
            return false;
        }
        NameplateClickJumpTo nameplateClickJumpTo = (NameplateClickJumpTo) other;
        return Intrinsics.areEqual(this.get_zplan_my_nameplate_click_jump_to, nameplateClickJumpTo.get_zplan_my_nameplate_click_jump_to) && Intrinsics.areEqual(this.get_zplan_guest_nameplate_click_jump_to, nameplateClickJumpTo.get_zplan_guest_nameplate_click_jump_to);
    }
}

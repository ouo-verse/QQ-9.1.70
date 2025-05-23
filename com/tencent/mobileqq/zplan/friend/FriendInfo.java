package com.tencent.mobileqq.zplan.friend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\f\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b%\u0010&J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u0015R$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b\u000e\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/c;", "", "other", "", "equals", "", "toString", "", "hashCode", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "uin", "b", "c", "head", "f", "profileUrl", "d", "i", "(Ljava/lang/String;)V", "name", "e", "j", "namePinyin", "", "Ljava/lang/Character;", "()Ljava/lang/Character;", tl.h.F, "(Ljava/lang/Character;)V", "firstChar", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setGender", "(Ljava/lang/Integer;)V", "gender", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Character;Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.friend.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class FriendInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String head;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String profileUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String namePinyin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private Character firstChar;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private Integer gender;

    public FriendInfo(String uin, String str, String str2, String str3, String str4, Character ch5, Integer num) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.head = str;
        this.profileUrl = str2;
        this.name = str3;
        this.namePinyin = str4;
        this.firstChar = ch5;
        this.gender = num;
    }

    /* renamed from: a, reason: from getter */
    public final Character getFirstChar() {
        return this.firstChar;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getGender() {
        return this.gender;
    }

    /* renamed from: c, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final String getNamePinyin() {
        return this.namePinyin;
    }

    /* renamed from: f, reason: from getter */
    public final String getProfileUrl() {
        return this.profileUrl;
    }

    /* renamed from: g, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void h(Character ch5) {
        this.firstChar = ch5;
    }

    public int hashCode() {
        int hashCode = this.uin.hashCode() * 31;
        String str = this.head;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.profileUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.namePinyin;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Character ch5 = this.firstChar;
        int hashCode6 = (hashCode5 + (ch5 == null ? 0 : ch5.hashCode())) * 31;
        Integer num = this.gender;
        return hashCode6 + (num != null ? num.hashCode() : 0);
    }

    public final void i(String str) {
        this.name = str;
    }

    public final void j(String str) {
        this.namePinyin = str;
    }

    public String toString() {
        return "FriendInfo(uin=" + this.uin + ", head=" + this.head + ", profileUrl=" + this.profileUrl + ", name=" + this.name + ", namePinyin=" + this.namePinyin + ", firstChar=" + this.firstChar + ", gender=" + this.gender + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(FriendInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.friend.FriendInfo");
        FriendInfo friendInfo = (FriendInfo) other;
        return Intrinsics.areEqual(this.uin, friendInfo.uin) && Intrinsics.areEqual(this.head, friendInfo.head) && Intrinsics.areEqual(this.profileUrl, friendInfo.profileUrl) && Intrinsics.areEqual(this.name, friendInfo.name) && Intrinsics.areEqual(this.namePinyin, friendInfo.namePinyin) && Intrinsics.areEqual(this.firstChar, friendInfo.firstChar) && Intrinsics.areEqual(this.gender, friendInfo.gender);
    }

    public /* synthetic */ FriendInfo(String str, String str2, String str3, String str4, String str5, Character ch5, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) == 0 ? ch5 : null, (i3 & 64) != 0 ? -1 : num);
    }
}

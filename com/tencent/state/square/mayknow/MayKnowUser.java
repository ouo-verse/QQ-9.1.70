package com.tencent.state.square.mayknow;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\b\u0010&\u001a\u00020\u0005H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/square/mayknow/MayKnowUser;", "", "uin", "", "nick", "", "gender", "", "age", "country", "province", "city", "mayKnowReason", "avatar", "labels", "", "Lcom/tencent/state/square/mayknow/MayKnowLabel;", "isAdd", "", "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "getCity", "getCountry", "getGender", "()Z", "setAdd", "(Z)V", "getLabels", "()Ljava/util/List;", "getMayKnowReason", "getNick", "getProvince", "getUin", "()J", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MayKnowUser {
    private final Integer age;
    private final String avatar;
    private final String city;
    private final String country;
    private final Integer gender;
    private boolean isAdd;
    private final List<MayKnowLabel> labels;
    private final String mayKnowReason;
    private final String nick;
    private final String province;
    private final long uin;

    public MayKnowUser(long j3, String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, List<MayKnowLabel> labels, boolean z16) {
        Intrinsics.checkNotNullParameter(labels, "labels");
        this.uin = j3;
        this.nick = str;
        this.gender = num;
        this.age = num2;
        this.country = str2;
        this.province = str3;
        this.city = str4;
        this.mayKnowReason = str5;
        this.avatar = str6;
        this.labels = labels;
        this.isAdd = z16;
    }

    public final Integer getAge() {
        return this.age;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final Integer getGender() {
        return this.gender;
    }

    public final List<MayKnowLabel> getLabels() {
        return this.labels;
    }

    public final String getMayKnowReason() {
        return this.mayKnowReason;
    }

    public final String getNick() {
        return this.nick;
    }

    public final String getProvince() {
        return this.province;
    }

    public final long getUin() {
        return this.uin;
    }

    /* renamed from: isAdd, reason: from getter */
    public final boolean getIsAdd() {
        return this.isAdd;
    }

    public final void setAdd(boolean z16) {
        this.isAdd = z16;
    }

    public String toString() {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MayKnowUser(");
        sb5.append("uin:");
        sb5.append(this.uin);
        sb5.append(", ");
        sb5.append("nick:");
        sb5.append(this.nick);
        sb5.append(',');
        sb5.append("gender:");
        sb5.append(this.gender);
        sb5.append(',');
        sb5.append("age:");
        sb5.append(this.age);
        sb5.append(',');
        sb5.append("mayKnowReason:");
        sb5.append(this.mayKnowReason);
        sb5.append(',');
        sb5.append("labels:");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.labels, null, null, null, 0, null, new Function1<MayKnowLabel, CharSequence>() { // from class: com.tencent.state.square.mayknow.MayKnowUser$toString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MayKnowLabel it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it);
            }
        }, 31, null);
        sb5.append(joinToString$default);
        sb5.append(')');
        return sb5.toString();
    }

    public /* synthetic */ MayKnowUser(long j3, String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, List list, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, num, num2, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : str4, str5, str6, list, (i3 & 1024) != 0 ? false : z16);
    }
}

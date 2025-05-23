package com.tencent.state.publicchat.data;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.data.Gender;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import zr4.g;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\u0014\u001a\u00020\r\u00a2\u0006\u0004\b-\u0010.B\u0013\b\u0016\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b-\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\rH\u00c6\u0003JQ\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\rH\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b#\u0010 R\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&R#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0014\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/state/publicchat/data/UserInfo;", "", "Lzr4/g;", "toPB", "", "component1", "", "component2", "component3", "Lcom/tencent/state/data/Gender;", "component4", "", "component5", "", "component6", "uin", "nick", "head", "gender", "labels", "relationType", "copy", "toString", "hashCode", "other", "", "equals", "J", "getUin", "()J", "Ljava/lang/String;", "getNick", "()Ljava/lang/String;", "setNick", "(Ljava/lang/String;)V", "getHead", "Lcom/tencent/state/data/Gender;", "getGender", "()Lcom/tencent/state/data/Gender;", "Ljava/util/Map;", "getLabels", "()Ljava/util/Map;", "I", "getRelationType", "()I", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/state/data/Gender;Ljava/util/Map;I)V", "pb", "(Lzr4/g;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class UserInfo {
    private final Gender gender;
    private final String head;
    private final Map<String, String> labels;
    private String nick;
    private final int relationType;
    private final long uin;

    public UserInfo(long j3, String nick, String head, Gender gender, Map<String, String> labels, int i3) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(labels, "labels");
        this.uin = j3;
        this.nick = nick;
        this.head = head;
        this.gender = gender;
        this.labels = labels;
        this.relationType = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    /* renamed from: component4, reason: from getter */
    public final Gender getGender() {
        return this.gender;
    }

    public final Map<String, String> component5() {
        return this.labels;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRelationType() {
        return this.relationType;
    }

    public final UserInfo copy(long uin, String nick, String head, Gender gender, Map<String, String> labels, int relationType) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(labels, "labels");
        return new UserInfo(uin, nick, head, gender, labels, relationType);
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final String getHead() {
        return this.head;
    }

    public final Map<String, String> getLabels() {
        return this.labels;
    }

    public final String getNick() {
        return this.nick;
    }

    public final int getRelationType() {
        return this.relationType;
    }

    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        int a16 = c.a(this.uin) * 31;
        String str = this.nick;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.head;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Gender gender = this.gender;
        int hashCode3 = (hashCode2 + (gender != null ? gender.hashCode() : 0)) * 31;
        Map<String, String> map = this.labels;
        return ((hashCode3 + (map != null ? map.hashCode() : 0)) * 31) + this.relationType;
    }

    public final void setNick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    public final g toPB() {
        g gVar = new g();
        gVar.f453108a = this.uin;
        String str = this.nick;
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            gVar.f453109b = bytes;
            gVar.f453110c = this.head;
            gVar.f453111d = this.labels;
            gVar.f453112e = CommonKt.toPB(this.gender);
            gVar.f453113f = this.relationType;
            return gVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public String toString() {
        return "UserInfo(uin=" + this.uin + ", nick=" + this.nick + ", head=" + this.head + ", gender=" + this.gender + ", labels=" + this.labels + ", relationType=" + this.relationType + ")";
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        r1 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r1);
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserInfo(g gVar) {
        this(r3, r5, (gVar == null || (r1 = gVar.f453110c) == null) ? "" : r1, CommonKt.parseGender(gVar != null ? Integer.valueOf(gVar.f453112e) : null), (gVar == null || (r0 = gVar.f453111d) == null) ? MapsKt__MapsKt.emptyMap() : r0, gVar != null ? gVar.f453113f : 2);
        Map<String, String> map;
        String str;
        String decodeToString;
        long j3 = gVar != null ? gVar.f453108a : 0L;
        String str2 = (gVar == null || (r1 = gVar.f453109b) == null || decodeToString == null) ? "" : decodeToString;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return this.uin == userInfo.uin && Intrinsics.areEqual(this.nick, userInfo.nick) && Intrinsics.areEqual(this.head, userInfo.head) && Intrinsics.areEqual(this.gender, userInfo.gender) && Intrinsics.areEqual(this.labels, userInfo.labels) && this.relationType == userInfo.relationType;
    }
}

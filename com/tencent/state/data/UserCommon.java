package com.tencent.state.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00c6\u0003J3\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010!\u001a\u00020\u0005J\t\u0010\"\u001a\u00020\u000bH\u00d6\u0001J\b\u0010#\u001a\u00020\u0005H\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/data/UserCommon;", "", "uin", "", "nick", "", "head", "gender", "Lcom/tencent/state/data/Gender;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/state/data/Gender;)V", "defaultResourceId", "", "getDefaultResourceId", "()I", "getGender", "()Lcom/tencent/state/data/Gender;", "setGender", "(Lcom/tencent/state/data/Gender;)V", "getHead", "()Ljava/lang/String;", "isMe", "", "()Z", "getNick", "getUin", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "getFriendRemarkName", "hashCode", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final /* data */ class UserCommon {
    private static final String TAG = "UserCommon";
    private final int defaultResourceId;
    private Gender gender;
    private final String head;
    private final String nick;
    private final long uin;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes33.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Gender.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Gender.MALE.ordinal()] = 1;
            iArr[Gender.FEMALE.ordinal()] = 2;
        }
    }

    public UserCommon(long j3, String nick, String str, Gender gender) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(gender, "gender");
        this.uin = j3;
        this.nick = nick;
        this.head = str;
        this.gender = gender;
        int i3 = WhenMappings.$EnumSwitchMapping$0[gender.ordinal()];
        this.defaultResourceId = i3 != 1 ? i3 != 2 ? 0 : R.drawable.i_n : R.drawable.i_o;
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

    public final UserCommon copy(long uin, String nick, String head, Gender gender) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(gender, "gender");
        return new UserCommon(uin, nick, head, gender);
    }

    public final int getDefaultResourceId() {
        return this.defaultResourceId;
    }

    public final String getFriendRemarkName() {
        return SquareBaseKt.getSquareCommon().getFriendRemarkName(String.valueOf(this.uin), this.nick);
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final String getHead() {
        return this.head;
    }

    public final String getNick() {
        return this.nick;
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
        return hashCode2 + (gender != null ? gender.hashCode() : 0);
    }

    public final boolean isMe() {
        boolean isBlank;
        String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
        isBlank = StringsKt__StringsJVMKt.isBlank(currentAccountUin);
        if (isBlank) {
            SquareBaseKt.getSquareLog().i(TAG, "current uin is: " + currentAccountUin);
        }
        return Intrinsics.areEqual(currentAccountUin, String.valueOf(this.uin));
    }

    public final void setGender(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "<set-?>");
        this.gender = gender;
    }

    public String toString() {
        return "UserCommon(uin=" + this.uin + ", nick='" + this.nick + "', gender=" + this.gender + ", isMe=" + isMe() + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCommon)) {
            return false;
        }
        UserCommon userCommon = (UserCommon) other;
        return this.uin == userCommon.uin && Intrinsics.areEqual(this.nick, userCommon.nick) && Intrinsics.areEqual(this.head, userCommon.head) && Intrinsics.areEqual(this.gender, userCommon.gender);
    }

    public static /* synthetic */ UserCommon copy$default(UserCommon userCommon, long j3, String str, String str2, Gender gender, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = userCommon.uin;
        }
        long j16 = j3;
        if ((i3 & 2) != 0) {
            str = userCommon.nick;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = userCommon.head;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            gender = userCommon.gender;
        }
        return userCommon.copy(j16, str3, str4, gender);
    }
}

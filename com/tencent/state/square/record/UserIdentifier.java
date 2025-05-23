package com.tencent.state.square.record;

import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u000e\u0010\b\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0003J\u001a\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0018J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/record/UserIdentifier;", "", "uin", "", "gender", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "dressKey", "forceDressKey", "getGender", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUin", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/state/square/record/UserIdentifier;", "equals", "", "other", "", "getDressKey", "callback", "Lkotlin/Function1;", "hashCode", "toString", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class UserIdentifier {
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    private static final String TAG = "UserIdentifier";
    private String dressKey;
    private String forceDressKey;

    @Nullable
    private final Integer gender;

    @NotNull
    private final String uin;

    public UserIdentifier(@NotNull String uin, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.gender = num;
        if (Intrinsics.areEqual(SquareBase.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin(), uin)) {
            this.dressKey = SquareRecordManager.INSTANCE.getDressKey();
        } else {
            SquareRecordManager.INSTANCE.loadLatestDressKey(uin, new Function1<String, Unit>() { // from class: com.tencent.state.square.record.UserIdentifier.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    UserIdentifier.this.dressKey = it;
                }
            });
        }
    }

    public static /* synthetic */ UserIdentifier copy$default(UserIdentifier userIdentifier, String str, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = userIdentifier.uin;
        }
        if ((i3 & 2) != 0) {
            num = userIdentifier.gender;
        }
        return userIdentifier.copy(str, num);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getGender() {
        return this.gender;
    }

    @NotNull
    public final UserIdentifier copy(@NotNull String uin, @Nullable Integer gender) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new UserIdentifier(uin, gender);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof UserIdentifier) {
                UserIdentifier userIdentifier = (UserIdentifier) other;
                if (!Intrinsics.areEqual(this.uin, userIdentifier.uin) || !Intrinsics.areEqual(this.gender, userIdentifier.gender)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final void forceDressKey(@NotNull String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.forceDressKey = dressKey;
        SquareBaseKt.getSquareLog().d(TAG, "forceDressKey uin:" + this.uin + ", forceDressKey:" + dressKey);
    }

    public final void getDressKey(@NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.forceDressKey;
        if (str != null) {
            callback.invoke(str);
            return;
        }
        String str2 = this.dressKey;
        if (str2 != null) {
            callback.invoke(str2);
        } else {
            SquareRecordManager.INSTANCE.loadLatestDressKey(this.uin, new Function1<String, Unit>() { // from class: com.tencent.state.square.record.UserIdentifier$getDressKey$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                    invoke2(str3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    UserIdentifier.this.dressKey = it;
                    callback.invoke(it);
                }
            });
        }
    }

    @Nullable
    public final Integer getGender() {
        return this.gender;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int i3;
        String str = this.uin;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Integer num = this.gender;
        if (num != null) {
            i16 = num.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "UserIdentifier(uin=" + this.uin + ", dressKey=" + this.dressKey + ")";
    }

    public /* synthetic */ UserIdentifier(String str, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : num);
    }
}

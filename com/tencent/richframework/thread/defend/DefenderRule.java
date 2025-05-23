package com.tencent.richframework.thread.defend;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/richframework/thread/defend/DefenderRule;", "", "threadName", "", "exceptionClassName", "exceptionMessage", "majorStackClassName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExceptionClassName", "()Ljava/lang/String;", "getExceptionMessage", "getMajorStackClassName", "getThreadName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class DefenderRule {

    @NotNull
    private final String exceptionClassName;

    @NotNull
    private final String exceptionMessage;

    @NotNull
    private final String majorStackClassName;

    @NotNull
    private final String threadName;

    public DefenderRule() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DefenderRule copy$default(DefenderRule defenderRule, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = defenderRule.threadName;
        }
        if ((i3 & 2) != 0) {
            str2 = defenderRule.exceptionClassName;
        }
        if ((i3 & 4) != 0) {
            str3 = defenderRule.exceptionMessage;
        }
        if ((i3 & 8) != 0) {
            str4 = defenderRule.majorStackClassName;
        }
        return defenderRule.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getThreadName() {
        return this.threadName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getExceptionClassName() {
        return this.exceptionClassName;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getExceptionMessage() {
        return this.exceptionMessage;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getMajorStackClassName() {
        return this.majorStackClassName;
    }

    @NotNull
    public final DefenderRule copy(@NotNull String threadName, @NotNull String exceptionClassName, @NotNull String exceptionMessage, @NotNull String majorStackClassName) {
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(exceptionClassName, "exceptionClassName");
        Intrinsics.checkNotNullParameter(exceptionMessage, "exceptionMessage");
        Intrinsics.checkNotNullParameter(majorStackClassName, "majorStackClassName");
        return new DefenderRule(threadName, exceptionClassName, exceptionMessage, majorStackClassName);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof DefenderRule) {
                DefenderRule defenderRule = (DefenderRule) other;
                if (!Intrinsics.areEqual(this.threadName, defenderRule.threadName) || !Intrinsics.areEqual(this.exceptionClassName, defenderRule.exceptionClassName) || !Intrinsics.areEqual(this.exceptionMessage, defenderRule.exceptionMessage) || !Intrinsics.areEqual(this.majorStackClassName, defenderRule.majorStackClassName)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getExceptionClassName() {
        return this.exceptionClassName;
    }

    @NotNull
    public final String getExceptionMessage() {
        return this.exceptionMessage;
    }

    @NotNull
    public final String getMajorStackClassName() {
        return this.majorStackClassName;
    }

    @NotNull
    public final String getThreadName() {
        return this.threadName;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.threadName;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.exceptionClassName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.exceptionMessage;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.majorStackClassName;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "DefenderRule(threadName=" + this.threadName + ", exceptionClassName=" + this.exceptionClassName + ", exceptionMessage=" + this.exceptionMessage + ", majorStackClassName=" + this.majorStackClassName + ")";
    }

    public DefenderRule(@NotNull String threadName, @NotNull String exceptionClassName, @NotNull String exceptionMessage, @NotNull String majorStackClassName) {
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(exceptionClassName, "exceptionClassName");
        Intrinsics.checkNotNullParameter(exceptionMessage, "exceptionMessage");
        Intrinsics.checkNotNullParameter(majorStackClassName, "majorStackClassName");
        this.threadName = threadName;
        this.exceptionClassName = exceptionClassName;
        this.exceptionMessage = exceptionMessage;
        this.majorStackClassName = majorStackClassName;
    }

    public /* synthetic */ DefenderRule(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
    }
}

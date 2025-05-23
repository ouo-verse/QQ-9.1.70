package com.tencent.richframework.thread.defend;

import androidx.annotation.Keep;
import androidx.fragment.app.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/richframework/thread/defend/ExceptionDefenderConfig;", "", "delegateDefault", "", "delegateDefaultPostTime", "", "defenderRule", "", "Lcom/tencent/richframework/thread/defend/DefenderRule;", "(ZJLjava/util/List;)V", "getDefenderRule", "()Ljava/util/List;", "getDelegateDefault", "()Z", "getDelegateDefaultPostTime", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class ExceptionDefenderConfig {

    @NotNull
    private final List<DefenderRule> defenderRule;
    private final boolean delegateDefault;
    private final long delegateDefaultPostTime;

    public ExceptionDefenderConfig(boolean z16, long j3, @NotNull List<DefenderRule> defenderRule) {
        Intrinsics.checkNotNullParameter(defenderRule, "defenderRule");
        this.delegateDefault = z16;
        this.delegateDefaultPostTime = j3;
        this.defenderRule = defenderRule;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExceptionDefenderConfig copy$default(ExceptionDefenderConfig exceptionDefenderConfig, boolean z16, long j3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = exceptionDefenderConfig.delegateDefault;
        }
        if ((i3 & 2) != 0) {
            j3 = exceptionDefenderConfig.delegateDefaultPostTime;
        }
        if ((i3 & 4) != 0) {
            list = exceptionDefenderConfig.defenderRule;
        }
        return exceptionDefenderConfig.copy(z16, j3, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDelegateDefault() {
        return this.delegateDefault;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDelegateDefaultPostTime() {
        return this.delegateDefaultPostTime;
    }

    @NotNull
    public final List<DefenderRule> component3() {
        return this.defenderRule;
    }

    @NotNull
    public final ExceptionDefenderConfig copy(boolean delegateDefault, long delegateDefaultPostTime, @NotNull List<DefenderRule> defenderRule) {
        Intrinsics.checkNotNullParameter(defenderRule, "defenderRule");
        return new ExceptionDefenderConfig(delegateDefault, delegateDefaultPostTime, defenderRule);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ExceptionDefenderConfig) {
                ExceptionDefenderConfig exceptionDefenderConfig = (ExceptionDefenderConfig) other;
                if (this.delegateDefault != exceptionDefenderConfig.delegateDefault || this.delegateDefaultPostTime != exceptionDefenderConfig.delegateDefaultPostTime || !Intrinsics.areEqual(this.defenderRule, exceptionDefenderConfig.defenderRule)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<DefenderRule> getDefenderRule() {
        return this.defenderRule;
    }

    public final boolean getDelegateDefault() {
        return this.delegateDefault;
    }

    public final long getDelegateDefaultPostTime() {
        return this.delegateDefaultPostTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int i3;
        boolean z16 = this.delegateDefault;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + a.a(this.delegateDefaultPostTime)) * 31;
        List<DefenderRule> list = this.defenderRule;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "ExceptionDefenderConfig(delegateDefault=" + this.delegateDefault + ", delegateDefaultPostTime=" + this.delegateDefaultPostTime + ", defenderRule=" + this.defenderRule + ")";
    }

    public /* synthetic */ ExceptionDefenderConfig(boolean z16, long j3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? 2000L : j3, list);
    }
}

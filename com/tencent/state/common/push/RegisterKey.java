package com.tencent.state.common.push;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/common/push/RegisterKey;", "", "messageTypes", "", "", "(Ljava/util/Set;)V", "getMessageTypes", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class RegisterKey {
    private final Set<Integer> messageTypes;

    public RegisterKey(Set<Integer> messageTypes) {
        Intrinsics.checkNotNullParameter(messageTypes, "messageTypes");
        this.messageTypes = messageTypes;
    }

    public final Set<Integer> component1() {
        return this.messageTypes;
    }

    public final RegisterKey copy(Set<Integer> messageTypes) {
        Intrinsics.checkNotNullParameter(messageTypes, "messageTypes");
        return new RegisterKey(messageTypes);
    }

    public final Set<Integer> getMessageTypes() {
        return this.messageTypes;
    }

    public int hashCode() {
        Set<Integer> set = this.messageTypes;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RegisterKey(messageTypes=" + this.messageTypes + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RegisterKey) && Intrinsics.areEqual(this.messageTypes, ((RegisterKey) other).messageTypes);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisterKey copy$default(RegisterKey registerKey, Set set, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            set = registerKey.messageTypes;
        }
        return registerKey.copy(set);
    }
}

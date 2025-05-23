package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ActionOnlyNavDirections implements NavDirections {
    private final int mActionId;

    public ActionOnlyNavDirections(int i3) {
        this.mActionId = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActionOnlyNavDirections.class == obj.getClass() && getActionId() == ((ActionOnlyNavDirections) obj).getActionId()) {
            return true;
        }
        return false;
    }

    @Override // androidx.navigation.NavDirections
    public int getActionId() {
        return this.mActionId;
    }

    @Override // androidx.navigation.NavDirections
    @NonNull
    public Bundle getArguments() {
        return new Bundle();
    }

    public int hashCode() {
        return 31 + getActionId();
    }

    public String toString() {
        return "ActionOnlyNavDirections(actionId=" + getActionId() + ")";
    }
}

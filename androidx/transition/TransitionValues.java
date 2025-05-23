package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.view == transitionValues.view && this.values.equals(transitionValues.values)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        for (String str2 : this.values.keySet()) {
            str = str + "    " + str2 + MsgSummary.STR_COLON + this.values.get(str2) + "\n";
        }
        return str;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}

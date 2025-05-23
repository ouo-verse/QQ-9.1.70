package com.tencent.state.data;

import com.tencent.mobileqq.profilecard.widget.TabContainer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/data/Gender;", "", "(Ljava/lang/String;I)V", "toThirdPersonText", "", "UNKNOWN", TabContainer.Tab.MALE, TabContainer.Tab.FEMALE, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public enum Gender {
    UNKNOWN,
    MALE,
    FEMALE;

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

    public final String toThirdPersonText() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            return "\u4ed6";
        }
        if (i3 != 2) {
            return "TA";
        }
        return "\u5979";
    }
}

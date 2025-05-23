package com.tencent.state.publicchat.data;

import com.tencent.state.data.Gender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"parseGender", "Lcom/tencent/state/data/Gender;", "value", "", "(Ljava/lang/Integer;)Lcom/tencent/state/data/Gender;", "toPB", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CommonKt {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Gender.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Gender.MALE.ordinal()] = 1;
            iArr[Gender.FEMALE.ordinal()] = 2;
        }
    }

    public static final int toPB(Gender toPB) {
        Intrinsics.checkNotNullParameter(toPB, "$this$toPB");
        int i3 = WhenMappings.$EnumSwitchMapping$0[toPB.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? 0 : 2;
        }
        return 1;
    }

    public static final Gender parseGender(Integer num) {
        if (num != null && num.intValue() == 1) {
            return Gender.MALE;
        }
        if (num != null && num.intValue() == 2) {
            return Gender.FEMALE;
        }
        return Gender.UNKNOWN;
    }
}

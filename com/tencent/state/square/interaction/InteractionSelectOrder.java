package com.tencent.state.square.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "", "(Ljava/lang/String;I)V", "toPB", "", "RANDOM", "SEQUENCE", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum InteractionSelectOrder {
    RANDOM,
    SEQUENCE;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSelectOrder$Companion;", "", "()V", "parsePB", "Lcom/tencent/state/square/interaction/InteractionSelectOrder;", "pbVal", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InteractionSelectOrder parsePB(int pbVal) {
            if (pbVal == 0) {
                return InteractionSelectOrder.RANDOM;
            }
            if (pbVal != 1) {
                return InteractionSelectOrder.RANDOM;
            }
            return InteractionSelectOrder.SEQUENCE;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InteractionSelectOrder.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[InteractionSelectOrder.RANDOM.ordinal()] = 1;
            iArr[InteractionSelectOrder.SEQUENCE.ordinal()] = 2;
        }
    }

    public final int toPB() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return (i3 == 1 || i3 != 2) ? 0 : 1;
    }
}

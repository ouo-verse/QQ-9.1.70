package com.tencent.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/PageType;", "", "(Ljava/lang/String;I)V", "Square", "Library", "SingleFragment", "ChatLand", "ChatLand_Fixed", "Relax_Fixed", "NearbyPro", "ChatLand_Wuji_1", "ChatLand_Wuji_2", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum PageType {
    Square,
    Library,
    SingleFragment,
    ChatLand,
    ChatLand_Fixed,
    Relax_Fixed,
    NearbyPro,
    ChatLand_Wuji_1,
    ChatLand_Wuji_2;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/PageType$Companion;", "", "()V", "parse", "Lcom/tencent/state/PageType;", "value", "", "(Ljava/lang/Integer;)Lcom/tencent/state/PageType;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final PageType parse(Integer value) {
            if (value != null && new IntRange(10001, 19999).contains(value.intValue())) {
                return PageType.NearbyPro;
            }
            if (value != null && value.intValue() == 1001) {
                return PageType.ChatLand;
            }
            if (value != null && value.intValue() == 1002) {
                return PageType.ChatLand_Fixed;
            }
            if (value != null && value.intValue() == 1003) {
                return PageType.Relax_Fixed;
            }
            if (value != null && value.intValue() == 1004) {
                return PageType.ChatLand_Wuji_1;
            }
            if (value != null && value.intValue() == 1005) {
                return PageType.ChatLand_Wuji_2;
            }
            return PageType.Library;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

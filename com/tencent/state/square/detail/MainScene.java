package com.tencent.state.square.detail;

import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/detail/MainScene;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "SQUARE", "LIBRARY", "REAL_MAP", "POSTER", "MYSTERY_BOX", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "H5", "HIPPY", "COLLECT_CARD", "SQUARE_CHAT_BLOCK", "SQUARE_CHAT_BLOCK_FIXED", "SQUARE_RELAX_BLOCK_FIXED", "SQUARE_CHAT_WUJI_BLOCK_1", "SQUARE_CHAT_WUJI_BLOCK_2", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum MainScene {
    UNKNOWN,
    SQUARE,
    LIBRARY,
    REAL_MAP,
    POSTER,
    MYSTERY_BOX,
    AIO,
    H5,
    HIPPY,
    COLLECT_CARD,
    SQUARE_CHAT_BLOCK,
    SQUARE_CHAT_BLOCK_FIXED,
    SQUARE_RELAX_BLOCK_FIXED,
    SQUARE_CHAT_WUJI_BLOCK_1,
    SQUARE_CHAT_WUJI_BLOCK_2;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/detail/MainScene$Companion;", "", "()V", "parse", "Lcom/tencent/state/square/detail/MainScene;", "value", "", "(Ljava/lang/Integer;)Lcom/tencent/state/square/detail/MainScene;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainScene parse(Integer value) {
            if (value != null && value.intValue() == 0) {
                return MainScene.SQUARE;
            }
            if (value != null && value.intValue() == 1) {
                return MainScene.LIBRARY;
            }
            if (value != null && value.intValue() == 2) {
                return MainScene.H5;
            }
            if (value != null && value.intValue() == 4) {
                return MainScene.COLLECT_CARD;
            }
            if (value != null && value.intValue() == 1001) {
                return MainScene.SQUARE_CHAT_BLOCK;
            }
            if (value != null && value.intValue() == 1002) {
                return MainScene.SQUARE_CHAT_BLOCK_FIXED;
            }
            if (value != null && value.intValue() == 1003) {
                return MainScene.SQUARE_RELAX_BLOCK_FIXED;
            }
            if (value != null && value.intValue() == 1004) {
                return MainScene.SQUARE_CHAT_WUJI_BLOCK_1;
            }
            if (value != null && value.intValue() == 1005) {
                return MainScene.SQUARE_CHAT_WUJI_BLOCK_2;
            }
            return MainScene.UNKNOWN;
        }
    }
}

package com.tencent.state.publicchat.data;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.state.square.Square;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/publicchat/data/Scene;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "SQUARE", "LIB", "H5_SHARE", "COLLECT_CARD", "OTHER", "SQUARE_CHAT_BLOCK", "SQUARE_CHAT_BLOCK_FIXED", "SQUARE_RELAX_BLOCK_FIXED", "SQUARE_CHAT_WUJI_BLOCK_1", "SQUARE_CHAT_WUJI_BLOCK_2", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum Scene {
    SQUARE(0),
    LIB(1),
    H5_SHARE(2),
    COLLECT_CARD(4),
    OTHER(999),
    SQUARE_CHAT_BLOCK(1001),
    SQUARE_CHAT_BLOCK_FIXED(1002),
    SQUARE_RELAX_BLOCK_FIXED(1003),
    SQUARE_CHAT_WUJI_BLOCK_1(1004),
    SQUARE_CHAT_WUJI_BLOCK_2(1005);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/publicchat/data/Scene$Companion;", "", "()V", "parse", "Lcom/tencent/state/publicchat/data/Scene;", "value", "", "(Ljava/lang/Integer;)Lcom/tencent/state/publicchat/data/Scene;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final Scene parse(Integer value) {
            Scene scene;
            Scene[] values = Scene.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    scene = null;
                    break;
                }
                scene = values[i3];
                if (value != null && scene.getValue() == value.intValue()) {
                    break;
                }
                i3++;
            }
            if (scene == null) {
                scene = Scene.OTHER;
            }
            if (scene == Scene.OTHER && Square.INSTANCE.getConfig().isDebug()) {
                throw new RuntimeException("Scene is OTHER,  RuntimeException!");
            }
            return scene;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Scene(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

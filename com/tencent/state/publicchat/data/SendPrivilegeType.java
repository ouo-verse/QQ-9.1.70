package com.tencent.state.publicchat.data;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/publicchat/data/SendPrivilegeType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PT_NIL", "PT_BLOCK", "PT_NOPRIVILEGE", "PT_NORMAL", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum SendPrivilegeType {
    PT_NIL(0),
    PT_BLOCK(1),
    PT_NOPRIVILEGE(2),
    PT_NORMAL(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/publicchat/data/SendPrivilegeType$Companion;", "", "()V", "parse", "Lcom/tencent/state/publicchat/data/SendPrivilegeType;", "value", "", "(Ljava/lang/Integer;)Lcom/tencent/state/publicchat/data/SendPrivilegeType;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final SendPrivilegeType parse(Integer value) {
            SendPrivilegeType sendPrivilegeType;
            SendPrivilegeType[] values = SendPrivilegeType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    sendPrivilegeType = null;
                    break;
                }
                sendPrivilegeType = values[i3];
                if (value != null && sendPrivilegeType.getValue() == value.intValue()) {
                    break;
                }
                i3++;
            }
            return sendPrivilegeType != null ? sendPrivilegeType : SendPrivilegeType.PT_NIL;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    SendPrivilegeType(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

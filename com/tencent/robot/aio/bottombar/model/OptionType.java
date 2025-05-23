package com.tencent.robot.aio.bottombar.model;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqnt.kernel.nativeinterface.OptType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/OptionType;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "OPTION_UNKNOWN", "OPTION_OPEN_HALF_SCREEN_VIEW", "OPTION_OPEN_URL_PAGE", "OPTION_SEND_MESSAGE", "OPTION_CHECK", "OPTION_SUB_MENU", "OPTION_MORE", "OPTION_PROMPT_FUNCTION", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public enum OptionType {
    OPTION_UNKNOWN(0),
    OPTION_OPEN_HALF_SCREEN_VIEW(1),
    OPTION_OPEN_URL_PAGE(2),
    OPTION_SEND_MESSAGE(3),
    OPTION_CHECK(4),
    OPTION_SUB_MENU(5),
    OPTION_MORE(6),
    OPTION_PROMPT_FUNCTION(7);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/OptionType$a;", "", "", "value", "Lcom/tencent/robot/aio/bottombar/model/OptionType;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/OptType;", "optType", "a", "<init>", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.bottombar.model.OptionType$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OptionType a(@NotNull OptType optType) {
            OptionType optionType;
            boolean z16;
            Intrinsics.checkNotNullParameter(optType, "optType");
            OptionType[] values = OptionType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    optionType = values[i3];
                    if (optionType.getValue() == optType.ordinal()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    optionType = null;
                    break;
                }
            }
            if (optionType == null) {
                return OptionType.OPTION_UNKNOWN;
            }
            return optionType;
        }

        @NotNull
        public final OptionType b(int value) {
            OptionType optionType;
            boolean z16;
            OptionType[] values = OptionType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    optionType = values[i3];
                    if (optionType.getValue() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    optionType = null;
                    break;
                }
            }
            if (optionType == null) {
                return OptionType.OPTION_UNKNOWN;
            }
            return optionType;
        }

        Companion() {
        }
    }

    OptionType(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

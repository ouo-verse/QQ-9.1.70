package com.tencent.robot.aio.bottombar.model;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/HalfScreenOptID;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "OPT_ID_UNKNOWN", "OPT_ID_SWITCH_PLOT", "OPT_ID_AI_SEARCH", "OPT_ID_AI_DRAW", "OPT_ID_AI_WRITE", "OPT_ID_SIMPLE_FUNCTION", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public enum HalfScreenOptID {
    OPT_ID_UNKNOWN(0),
    OPT_ID_SWITCH_PLOT(1),
    OPT_ID_AI_SEARCH(2),
    OPT_ID_AI_DRAW(3),
    OPT_ID_AI_WRITE(4),
    OPT_ID_SIMPLE_FUNCTION(5);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/HalfScreenOptID$a;", "", "", "value", "Lcom/tencent/robot/aio/bottombar/model/HalfScreenOptID;", "a", "<init>", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.bottombar.model.HalfScreenOptID$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HalfScreenOptID a(int value) {
            HalfScreenOptID halfScreenOptID;
            boolean z16;
            HalfScreenOptID[] values = HalfScreenOptID.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    halfScreenOptID = values[i3];
                    if (halfScreenOptID.getValue() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    halfScreenOptID = null;
                    break;
                }
            }
            if (halfScreenOptID == null) {
                return HalfScreenOptID.OPT_ID_UNKNOWN;
            }
            return halfScreenOptID;
        }

        Companion() {
        }
    }

    HalfScreenOptID(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

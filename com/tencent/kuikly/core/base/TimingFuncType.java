package com.tencent.kuikly.core.base;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/base/TimingFuncType;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "LINEAR", "EASEIN", "EASEOUT", "EASEINOUT", "UNKNOWN0", "UNKNOWN1", "UNKNOWN2", "UNKNOWN3", "UNKNOWN4", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public enum TimingFuncType {
    LINEAR(0),
    EASEIN(1),
    EASEOUT(2),
    EASEINOUT(3),
    UNKNOWN0(4),
    UNKNOWN1(5),
    UNKNOWN2(6),
    UNKNOWN3(7),
    UNKNOWN4(8);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/base/TimingFuncType$a;", "", "", "value", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.TimingFuncType$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimingFuncType a(int value) {
            TimingFuncType timingFuncType;
            TimingFuncType[] values = TimingFuncType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    timingFuncType = null;
                    break;
                }
                timingFuncType = values[i3];
                if (timingFuncType.getValue() == value) {
                    break;
                }
                i3++;
            }
            return timingFuncType == null ? TimingFuncType.LINEAR : timingFuncType;
        }

        Companion() {
        }
    }

    TimingFuncType(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

package com.tencent.rdelivery.net;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"com/tencent/rdelivery/net/BaseProto$ValueType", "", "Lcom/tencent/rdelivery/net/BaseProto$ValueType;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "STRING", "JSON", "INT", "BOOL", "FLOAT", "LIST", "MAP", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public enum BaseProto$ValueType {
    STRING(0),
    JSON(1),
    INT(2),
    BOOL(3),
    FLOAT(4),
    LIST(5),
    MAP(6);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/rdelivery/net/BaseProto$ValueType$a;", "", "", "configValueType", "Lcom/tencent/rdelivery/net/BaseProto$ValueType;", "a", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.BaseProto$ValueType$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final BaseProto$ValueType a(int configValueType) {
            boolean z16;
            for (BaseProto$ValueType baseProto$ValueType : BaseProto$ValueType.values()) {
                if (baseProto$ValueType.getValue() == configValueType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return baseProto$ValueType;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    BaseProto$ValueType(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

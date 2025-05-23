package com.tencent.filament.zplanservice.verify;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "CRC64ECMA", "SIZE", "STAT_SIZE", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum ResourceCheckAlgorithmSelect {
    CRC64ECMA(0),
    SIZE(1),
    STAT_SIZE(2);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect$a;", "", "", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "a", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ResourceCheckAlgorithmSelect a(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return ResourceCheckAlgorithmSelect.CRC64ECMA;
                    }
                    return ResourceCheckAlgorithmSelect.STAT_SIZE;
                }
                return ResourceCheckAlgorithmSelect.SIZE;
            }
            return ResourceCheckAlgorithmSelect.CRC64ECMA;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ResourceCheckAlgorithmSelect(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

package com.tencent.filament.zplanservice.verify;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplanservice/verify/ResourceCheckCode;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "COMPLETED", "DIR_ERROR", "MANIFEST_NOT_EXIST", "MANIFEST_NAME_ERROR", "MANIFEST_ALGORITHM_SELECT_MISMATCHED", "MANIFEST_FILE_VERSION_MISMATCHED", "MANIFEST_CONTENT_ERROR", "MANIFEST_CONTENT_VERSION_MISMATCHED", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum ResourceCheckCode {
    COMPLETED(0),
    DIR_ERROR(1),
    MANIFEST_NOT_EXIST(2),
    MANIFEST_NAME_ERROR(3),
    MANIFEST_ALGORITHM_SELECT_MISMATCHED(4),
    MANIFEST_FILE_VERSION_MISMATCHED(5),
    MANIFEST_CONTENT_ERROR(6),
    MANIFEST_CONTENT_VERSION_MISMATCHED(7);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplanservice/verify/ResourceCheckCode$a;", "", "", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckCode;", "a", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplanservice.verify.ResourceCheckCode$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ResourceCheckCode a(int i3) {
            switch (i3) {
                case 0:
                    return ResourceCheckCode.COMPLETED;
                case 1:
                    return ResourceCheckCode.DIR_ERROR;
                case 2:
                    return ResourceCheckCode.MANIFEST_NOT_EXIST;
                case 3:
                    return ResourceCheckCode.MANIFEST_NAME_ERROR;
                case 4:
                    return ResourceCheckCode.MANIFEST_ALGORITHM_SELECT_MISMATCHED;
                case 5:
                    return ResourceCheckCode.MANIFEST_FILE_VERSION_MISMATCHED;
                case 6:
                    return ResourceCheckCode.MANIFEST_CONTENT_ERROR;
                case 7:
                    return ResourceCheckCode.MANIFEST_CONTENT_VERSION_MISMATCHED;
                default:
                    return ResourceCheckCode.COMPLETED;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ResourceCheckCode(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

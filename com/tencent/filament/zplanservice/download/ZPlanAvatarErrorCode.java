package com.tencent.filament.zplanservice.download;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarErrorCode;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "DEFAULT", "DOWNLOAD_FAILED", "DOWNLOAD_304", "GLTF_NOT_EXIST", "FILE_NOT_EXIST", "RENAME_FAILED", "UNZIP_FAILED", "URL_EMPTY", "NATIVE_DOWNLOADER_NOT_INJECTED", "DOWNLOAD_404", "URL_REPLACE_ERROR", "RESOURCE_ERROR", "CHECK_ERROR", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum ZPlanAvatarErrorCode {
    DEFAULT(0),
    DOWNLOAD_FAILED(1),
    DOWNLOAD_304(2),
    GLTF_NOT_EXIST(3),
    FILE_NOT_EXIST(4),
    RENAME_FAILED(5),
    UNZIP_FAILED(6),
    URL_EMPTY(7),
    NATIVE_DOWNLOADER_NOT_INJECTED(8),
    DOWNLOAD_404(9),
    URL_REPLACE_ERROR(10),
    RESOURCE_ERROR(11),
    CHECK_ERROR(12);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarErrorCode$a;", "", "", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarErrorCode;", "a", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplanservice.download.ZPlanAvatarErrorCode$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ZPlanAvatarErrorCode a(int i3) {
            switch (i3) {
                case 0:
                    return ZPlanAvatarErrorCode.DEFAULT;
                case 1:
                    return ZPlanAvatarErrorCode.DOWNLOAD_FAILED;
                case 2:
                    return ZPlanAvatarErrorCode.DOWNLOAD_304;
                case 3:
                    return ZPlanAvatarErrorCode.GLTF_NOT_EXIST;
                case 4:
                    return ZPlanAvatarErrorCode.FILE_NOT_EXIST;
                case 5:
                    return ZPlanAvatarErrorCode.RENAME_FAILED;
                case 6:
                    return ZPlanAvatarErrorCode.UNZIP_FAILED;
                case 7:
                    return ZPlanAvatarErrorCode.URL_EMPTY;
                case 8:
                    return ZPlanAvatarErrorCode.NATIVE_DOWNLOADER_NOT_INJECTED;
                case 9:
                    return ZPlanAvatarErrorCode.DOWNLOAD_404;
                case 10:
                    return ZPlanAvatarErrorCode.URL_REPLACE_ERROR;
                case 11:
                    return ZPlanAvatarErrorCode.RESOURCE_ERROR;
                case 12:
                    return ZPlanAvatarErrorCode.CHECK_ERROR;
                default:
                    return ZPlanAvatarErrorCode.DEFAULT;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ZPlanAvatarErrorCode(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}

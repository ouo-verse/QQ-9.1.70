package com.tencent.filament.zplan.avatar;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/filament/zplan/avatar/FaceVerificationCode;", "", "", "isPassed", "", "code", "I", "getCode", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "SUCCESS", "NO_CONFIG", "NO_URL_CONFIG", "NOT_DIRECTORY", "NOT_FOUND_FILE", "NOT_DIRECTORY_FOR_FILE", "SIZE_MISMATCHED", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum FaceVerificationCode {
    SUCCESS(0),
    NO_CONFIG(1),
    NO_URL_CONFIG(2),
    NOT_DIRECTORY(3),
    NOT_FOUND_FILE(4),
    NOT_DIRECTORY_FOR_FILE(5),
    SIZE_MISMATCHED(6);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplan/avatar/FaceVerificationCode$a;", "", "", "Lcom/tencent/filament/zplan/avatar/FaceVerificationCode;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.avatar.FaceVerificationCode$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final FaceVerificationCode a(int i3) {
            FaceVerificationCode faceVerificationCode = FaceVerificationCode.SUCCESS;
            if (i3 != faceVerificationCode.getCode()) {
                FaceVerificationCode faceVerificationCode2 = FaceVerificationCode.NO_CONFIG;
                if (i3 != faceVerificationCode2.getCode()) {
                    faceVerificationCode2 = FaceVerificationCode.NO_URL_CONFIG;
                    if (i3 != faceVerificationCode2.getCode()) {
                        faceVerificationCode2 = FaceVerificationCode.NOT_DIRECTORY;
                        if (i3 != faceVerificationCode2.getCode()) {
                            faceVerificationCode2 = FaceVerificationCode.NOT_FOUND_FILE;
                            if (i3 != faceVerificationCode2.getCode()) {
                                faceVerificationCode2 = FaceVerificationCode.NOT_DIRECTORY_FOR_FILE;
                                if (i3 != faceVerificationCode2.getCode()) {
                                    faceVerificationCode2 = FaceVerificationCode.SIZE_MISMATCHED;
                                    if (i3 != faceVerificationCode2.getCode()) {
                                        return faceVerificationCode;
                                    }
                                }
                            }
                        }
                    }
                }
                return faceVerificationCode2;
            }
            return faceVerificationCode;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    FaceVerificationCode(int i3) {
        this.code = i3;
    }

    public final int getCode() {
        return this.code;
    }

    public final boolean isPassed() {
        int i3 = c.f105676a[ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }
}

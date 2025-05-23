package com.tenpay.idverify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/idverify/EnumIdVerifyState;", "", "(Ljava/lang/String;I)V", "NONE", "GUARDIAN_ENSURING", "GUARDIAN_ENSURED", "HAS_REAL_NAME", "INVALID", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public enum EnumIdVerifyState {
    NONE,
    GUARDIAN_ENSURING,
    GUARDIAN_ENSURED,
    HAS_REAL_NAME,
    INVALID;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/idverify/EnumIdVerifyState$Companion;", "", "()V", "findByValue", "Lcom/tenpay/idverify/EnumIdVerifyState;", "value", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EnumIdVerifyState findByValue(int value) {
            EnumIdVerifyState enumIdVerifyState;
            boolean z16;
            EnumIdVerifyState[] values = EnumIdVerifyState.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    enumIdVerifyState = values[i3];
                    if (enumIdVerifyState.ordinal() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    enumIdVerifyState = null;
                    break;
                }
            }
            if (enumIdVerifyState == null) {
                return EnumIdVerifyState.NONE;
            }
            return enumIdVerifyState;
        }

        Companion() {
        }
    }
}

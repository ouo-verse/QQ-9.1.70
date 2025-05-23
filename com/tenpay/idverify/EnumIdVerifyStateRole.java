package com.tenpay.idverify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/idverify/EnumIdVerifyStateRole;", "", "(Ljava/lang/String;I)V", "INVITER", "INVITEES", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public enum EnumIdVerifyStateRole {
    INVITER,
    INVITEES;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/idverify/EnumIdVerifyStateRole$Companion;", "", "()V", "findByValue", "Lcom/tenpay/idverify/EnumIdVerifyStateRole;", "value", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EnumIdVerifyStateRole findByValue(int value) {
            EnumIdVerifyStateRole enumIdVerifyStateRole;
            boolean z16;
            EnumIdVerifyStateRole[] values = EnumIdVerifyStateRole.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    enumIdVerifyStateRole = values[i3];
                    if (enumIdVerifyStateRole.ordinal() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    enumIdVerifyStateRole = null;
                    break;
                }
            }
            if (enumIdVerifyStateRole == null) {
                return EnumIdVerifyStateRole.INVITER;
            }
            return enumIdVerifyStateRole;
        }

        Companion() {
        }
    }
}

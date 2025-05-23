package com.tenpay.idverify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/idverify/EnumIdVerifySex;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "INVALID", "MAN", "WOMAN", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public enum EnumIdVerifySex {
    INVALID("\u65e0\u6548"),
    MAN("\u7537"),
    WOMAN("\u5973");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/idverify/EnumIdVerifySex$Companion;", "", "()V", "findByValue", "Lcom/tenpay/idverify/EnumIdVerifySex;", "value", "", "(Ljava/lang/Integer;)Lcom/tenpay/idverify/EnumIdVerifySex;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EnumIdVerifySex findByValue(@Nullable Integer value) {
            EnumIdVerifySex enumIdVerifySex;
            boolean z16;
            EnumIdVerifySex[] values = EnumIdVerifySex.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    enumIdVerifySex = values[i3];
                    int ordinal = enumIdVerifySex.ordinal();
                    if (value != null && ordinal == value.intValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    enumIdVerifySex = null;
                    break;
                }
            }
            if (enumIdVerifySex == null) {
                return EnumIdVerifySex.INVALID;
            }
            return enumIdVerifySex;
        }

        Companion() {
        }
    }

    EnumIdVerifySex(String str) {
        this.desc = str;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }
}

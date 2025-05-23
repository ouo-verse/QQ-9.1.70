package com.tenpay.idverify;

import com.tencent.mobileqq.zootopia.ue.PayPluginScene;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/idverify/EnumGuardRelation;", "", "value", "", "desc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "()I", "FATHER", "MOTHER", PayPluginScene.OTHERS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public enum EnumGuardRelation {
    FATHER(1, "\u7236\u4eb2"),
    MOTHER(2, "\u6bcd\u4eb2"),
    OTHERS(3, "\u5176\u4ed6");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String desc;
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/idverify/EnumGuardRelation$Companion;", "", "()V", "findByDesc", "Lcom/tenpay/idverify/EnumGuardRelation;", "desc", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EnumGuardRelation findByDesc(@Nullable String desc) {
            EnumGuardRelation enumGuardRelation;
            EnumGuardRelation[] values = EnumGuardRelation.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    enumGuardRelation = values[i3];
                    if (Intrinsics.areEqual(enumGuardRelation.getDesc(), desc)) {
                        break;
                    }
                    i3++;
                } else {
                    enumGuardRelation = null;
                    break;
                }
            }
            if (enumGuardRelation == null) {
                return EnumGuardRelation.OTHERS;
            }
            return enumGuardRelation;
        }

        Companion() {
        }
    }

    EnumGuardRelation(int i3, String str) {
        this.value = i3;
        this.desc = str;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }
}

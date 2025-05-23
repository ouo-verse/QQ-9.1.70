package com.tenpay.idverify;

import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/idverify/EnumIdType;", "", "value", "", "descResId", "(Ljava/lang/String;III)V", "getDescResId", "()I", HippyTextInputController.COMMAND_getValue, "UNKNOWN", "MAINLAND_ID_CARD", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public enum EnumIdType {
    UNKNOWN(0, R.string.f2187664l),
    MAINLAND_ID_CARD(1, R.string.f2187664l);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int descResId;
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/idverify/EnumIdType$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tenpay/idverify/EnumIdType;", "incomeValue", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EnumIdType create(int incomeValue) {
            EnumIdType enumIdType = EnumIdType.MAINLAND_ID_CARD;
            if (incomeValue != enumIdType.getValue()) {
                return EnumIdType.UNKNOWN;
            }
            return enumIdType;
        }

        Companion() {
        }
    }

    EnumIdType(int i3, int i16) {
        this.value = i3;
        this.descResId = i16;
    }

    public final int getDescResId() {
        return this.descResId;
    }

    public final int getValue() {
        return this.value;
    }
}

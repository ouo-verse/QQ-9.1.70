package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "", "Lcom/squareup/wire/WireEnum;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "b", "ORIGINAL", "R16_9", "R9_16", "R1_1", "R3_4", "R4_3", "R1_2", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public enum RatioType implements WireEnum {
    ORIGINAL(0),
    R16_9(1),
    R9_16(2),
    R1_1(3),
    R3_4(4),
    R4_3(5),
    R1_2(6);

    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ProtoAdapter<RatioType> ADAPTER = new EnumAdapter<RatioType>(Reflection.getOrCreateKotlinClass(RatioType.class)) { // from class: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RatioType.a
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatioType fromValue(int value) {
            return RatioType.INSTANCE.a(value);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType$b;", "", "", "value", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "a", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RatioType$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final RatioType a(int value) {
            switch (value) {
                case 0:
                    return RatioType.ORIGINAL;
                case 1:
                    return RatioType.R16_9;
                case 2:
                    return RatioType.R9_16;
                case 3:
                    return RatioType.R1_1;
                case 4:
                    return RatioType.R3_4;
                case 5:
                    return RatioType.R4_3;
                case 6:
                    return RatioType.R1_2;
                default:
                    return null;
            }
        }

        Companion() {
        }
    }

    RatioType(int i3) {
        this.value = i3;
    }

    @JvmStatic
    @Nullable
    public static final RatioType fromValue(int i3) {
        return INSTANCE.a(i3);
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}

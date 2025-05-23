package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NONE", "SCALE", "REPEAT", "REPEAT_INVERTED", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public enum TimeStretchMode implements WireEnum {
    NONE(0),
    SCALE(1),
    REPEAT(2),
    REPEAT_INVERTED(3);


    @JvmField
    @NotNull
    public static final ProtoAdapter<TimeStretchMode> ADAPTER;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TimeStretchMode$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "fromValue", "value", "", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @Nullable
        public final TimeStretchMode fromValue(int value) {
            if (value != 0) {
                if (value != 1) {
                    if (value != 2) {
                        if (value != 3) {
                            return null;
                        }
                        return TimeStretchMode.REPEAT_INVERTED;
                    }
                    return TimeStretchMode.REPEAT;
                }
                return TimeStretchMode.SCALE;
            }
            return TimeStretchMode.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TimeStretchMode.class);
        ADAPTER = new EnumAdapter<TimeStretchMode>(orCreateKotlinClass) { // from class: com.tencent.tavcut.composition.model.component.TimeStretchMode$Companion$ADAPTER$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.squareup.wire.EnumAdapter
            @Nullable
            public TimeStretchMode fromValue(int value) {
                return TimeStretchMode.INSTANCE.fromValue(value);
            }
        };
    }

    TimeStretchMode(int i3) {
        this.value = i3;
    }

    @JvmStatic
    @Nullable
    public static final TimeStretchMode fromValue(int i3) {
        return INSTANCE.fromValue(i3);
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}

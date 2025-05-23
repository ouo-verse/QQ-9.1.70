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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "", "Lcom/squareup/wire/WireEnum;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "b", "LOOP", "FREEZE", "SCALE_UP", "SCALE_BOTH", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public enum AnimationMode implements WireEnum {
    LOOP(0),
    FREEZE(1),
    SCALE_UP(2),
    SCALE_BOTH(3);

    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ProtoAdapter<AnimationMode> ADAPTER = new EnumAdapter<AnimationMode>(Reflection.getOrCreateKotlinClass(AnimationMode.class)) { // from class: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AnimationMode.a
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimationMode fromValue(int value) {
            return AnimationMode.INSTANCE.a(value);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode$b;", "", "", "value", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "a", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AnimationMode$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final AnimationMode a(int value) {
            if (value != 0) {
                if (value != 1) {
                    if (value != 2) {
                        if (value != 3) {
                            return null;
                        }
                        return AnimationMode.SCALE_BOTH;
                    }
                    return AnimationMode.SCALE_UP;
                }
                return AnimationMode.FREEZE;
            }
            return AnimationMode.LOOP;
        }

        Companion() {
        }
    }

    AnimationMode(int i3) {
        this.value = i3;
    }

    @JvmStatic
    @Nullable
    public static final AnimationMode fromValue(int i3) {
        return INSTANCE.a(i3);
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}

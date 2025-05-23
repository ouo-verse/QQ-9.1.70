package com.tencent.videocut.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/videocut/model/RatioType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "ORIGINAL", "R16_9", "R9_16", "R1_1", "R3_4", "R4_3", "R1_2", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class RatioType implements WireEnum {
    private static final /* synthetic */ RatioType[] $VALUES;
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<RatioType> ADAPTER;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final RatioType ORIGINAL;
    public static final RatioType R16_9;
    public static final RatioType R1_1;
    public static final RatioType R1_2;
    public static final RatioType R3_4;
    public static final RatioType R4_3;
    public static final RatioType R9_16;
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/RatioType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/RatioType;", "fromValue", "value", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @Nullable
        public final RatioType fromValue(int value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RatioType) iPatchRedirector.redirect((short) 2, (Object) this, value);
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ RatioType[] $values() {
        return new RatioType[]{ORIGINAL, R16_9, R9_16, R1_1, R3_4, R4_3, R1_2};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58840);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ORIGINAL = new RatioType("ORIGINAL", 0, 0);
        R16_9 = new RatioType("R16_9", 1, 1);
        R9_16 = new RatioType("R9_16", 2, 2);
        R1_1 = new RatioType("R1_1", 3, 3);
        R3_4 = new RatioType("R3_4", 4, 4);
        R4_3 = new RatioType("R4_3", 5, 5);
        R1_2 = new RatioType("R1_2", 6, 6);
        $VALUES = $values();
        INSTANCE = new Companion(null);
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RatioType.class);
        ADAPTER = new EnumAdapter<RatioType>(orCreateKotlinClass) { // from class: com.tencent.videocut.model.RatioType$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(orCreateKotlinClass);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) orCreateKotlinClass);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.squareup.wire.EnumAdapter
            @Nullable
            public RatioType fromValue(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? RatioType.INSTANCE.fromValue(value) : (RatioType) iPatchRedirector.redirect((short) 2, (Object) this, value);
            }
        };
    }

    RatioType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    @JvmStatic
    @Nullable
    public static final RatioType fromValue(int i3) {
        return INSTANCE.fromValue(i3);
    }

    public static RatioType valueOf(String str) {
        return (RatioType) Enum.valueOf(RatioType.class, str);
    }

    public static RatioType[] values() {
        return (RatioType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}

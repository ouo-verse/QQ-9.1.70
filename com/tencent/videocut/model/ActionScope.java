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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/videocut/model/ActionScope;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "ON_VIDEO", "ON_CANVAS", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ActionScope implements WireEnum {
    private static final /* synthetic */ ActionScope[] $VALUES;
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<ActionScope> ADAPTER;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final ActionScope ON_CANVAS;
    public static final ActionScope ON_VIDEO;
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/ActionScope$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/ActionScope;", "fromValue", "value", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        public final ActionScope fromValue(int value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ActionScope) iPatchRedirector.redirect((short) 2, (Object) this, value);
            }
            if (value != 0) {
                if (value != 1) {
                    return null;
                }
                return ActionScope.ON_CANVAS;
            }
            return ActionScope.ON_VIDEO;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ ActionScope[] $values() {
        return new ActionScope[]{ON_VIDEO, ON_CANVAS};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ON_VIDEO = new ActionScope("ON_VIDEO", 0, 0);
        ON_CANVAS = new ActionScope("ON_CANVAS", 1, 1);
        $VALUES = $values();
        INSTANCE = new Companion(null);
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ActionScope.class);
        ADAPTER = new EnumAdapter<ActionScope>(orCreateKotlinClass) { // from class: com.tencent.videocut.model.ActionScope$Companion$ADAPTER$1
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
            public ActionScope fromValue(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? ActionScope.INSTANCE.fromValue(value) : (ActionScope) iPatchRedirector.redirect((short) 2, (Object) this, value);
            }
        };
    }

    ActionScope(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    @JvmStatic
    @Nullable
    public static final ActionScope fromValue(int i3) {
        return INSTANCE.fromValue(i3);
    }

    public static ActionScope valueOf(String str) {
        return (ActionScope) Enum.valueOf(ActionScope.class, str);
    }

    public static ActionScope[] values() {
        return (ActionScope[]) $VALUES.clone();
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

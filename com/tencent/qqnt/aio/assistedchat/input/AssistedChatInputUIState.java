package com.tencent.qqnt.aio.assistedchat.input;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "ChangeSelectedState", "ChangeVisibilityState", "SetAIOContextState", "ShakeIconState", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$ChangeSelectedState;", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$ChangeVisibilityState;", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$SetAIOContextState;", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$ShakeIconState;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public abstract class AssistedChatInputUIState implements InputUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$ChangeSelectedState;", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState;", "", "d", "Z", "a", "()Z", "selected", "<init>", "(Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class ChangeSelectedState extends AssistedChatInputUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean selected;

        public ChangeSelectedState(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.selected = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.selected;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$ChangeVisibilityState;", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState;", "", "d", "Z", "b", "()Z", NodeProps.VISIBLE, "e", "a", "showBubbleTip", "<init>", "(ZZ)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class ChangeVisibilityState extends AssistedChatInputUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean showBubbleTip;

        public ChangeVisibilityState(boolean z16, boolean z17) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.visible = z16;
                this.showBubbleTip = z17;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.showBubbleTip;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.visible;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$SetAIOContextState;", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState;", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "a", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class SetAIOContextState extends AssistedChatInputUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.api.runtime.a aioContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetAIOContextState(@NotNull com.tencent.aio.api.runtime.a aioContext) {
            super(null);
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
            } else {
                this.aioContext = aioContext;
            }
        }

        @NotNull
        public final com.tencent.aio.api.runtime.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.aioContext;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState$ShakeIconState;", "Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputUIState;", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class ShakeIconState extends AssistedChatInputUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShakeIconState f349092d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58679);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349092d = new ShakeIconState();
            }
        }

        ShakeIconState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ AssistedChatInputUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    AssistedChatInputUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

package com.tencent.qqnt.aio.menu;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuMsgEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "DelCheckEvent", "RevokeCheck", "Lcom/tencent/qqnt/aio/menu/MenuMsgEvent$DelCheckEvent;", "Lcom/tencent/qqnt/aio/menu/MenuMsgEvent$RevokeCheck;", "aio_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public abstract class MenuMsgEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuMsgEvent$DelCheckEvent;", "Lcom/tencent/qqnt/aio/menu/MenuMsgEvent;", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "a", "()Ljava/lang/Runnable;", "callback", "<init>", "(Ljava/lang/Runnable;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class DelCheckEvent extends MenuMsgEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Runnable callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DelCheckEvent(@NotNull Runnable callback) {
            super(null);
            Intrinsics.checkNotNullParameter(callback, "callback");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
            } else {
                this.callback = callback;
            }
        }

        @NotNull
        public final Runnable a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Runnable) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.callback;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.menu.MenuMsgEvent.DelCheckEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuMsgEvent$RevokeCheck;", "Lcom/tencent/qqnt/aio/menu/MenuMsgEvent;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "e", "Z", "b", "()Z", "c", "(Z)V", "needHandle", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Z)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class RevokeCheck extends MenuMsgEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean needHandle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RevokeCheck(@NotNull AIOMsgItem msgItem, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, msgItem, Boolean.valueOf(z16));
            } else {
                this.msgItem = msgItem;
                this.needHandle = z16;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.needHandle;
        }

        public final void c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.needHandle = z16;
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "com.tencent.qqnt.aio.menu.MenuMsgEvent.RevokeCheck";
        }

        public /* synthetic */ RevokeCheck(AIOMsgItem aIOMsgItem, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIOMsgItem, (i3 & 2) != 0 ? true : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIOMsgItem, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    public /* synthetic */ MenuMsgEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    MenuMsgEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

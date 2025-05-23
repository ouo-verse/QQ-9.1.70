package com.tencent.mobileqq.aio.msglist.holder.component.markdown;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownMsgItemEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "DispatchOnBindEvent", "DispatchOnRemoveEvent", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownMsgItemEvent$DispatchOnBindEvent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownMsgItemEvent$DispatchOnRemoveEvent;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class AIOMarkdownMsgItemEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownMsgItemEvent$DispatchOnBindEvent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownMsgItemEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "businessId", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "c", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/markdown/c;", "f", "Lcom/tencent/qqnt/aio/markdown/c;", "b", "()Lcom/tencent/qqnt/aio/markdown/c;", "listener", "<init>", "(ILcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;Lcom/tencent/qqnt/aio/markdown/c;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class DispatchOnBindEvent extends AIOMarkdownMsgItemEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int businessId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarkdownMsgItem msgItem;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.markdown.c listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DispatchOnBindEvent(int i3, @NotNull MarkdownMsgItem msgItem, @NotNull com.tencent.qqnt.aio.markdown.c listener) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), msgItem, listener);
                return;
            }
            this.businessId = i3;
            this.msgItem = msgItem;
            this.listener = listener;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.businessId;
        }

        @NotNull
        public final com.tencent.qqnt.aio.markdown.c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.aio.markdown.c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.listener;
        }

        @NotNull
        public final MarkdownMsgItem c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MarkdownMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof DispatchOnBindEvent)) {
                return false;
            }
            DispatchOnBindEvent dispatchOnBindEvent = (DispatchOnBindEvent) other;
            if (this.businessId == dispatchOnBindEvent.businessId && Intrinsics.areEqual(this.msgItem, dispatchOnBindEvent.msgItem) && Intrinsics.areEqual(this.listener, dispatchOnBindEvent.listener)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.businessId * 31) + this.msgItem.hashCode()) * 31) + this.listener.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "DispatchOnBindEvent(businessId=" + this.businessId + ", msgItem=" + this.msgItem + ", listener=" + this.listener + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownMsgItemEvent$DispatchOnRemoveEvent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownMsgItemEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/aio/markdown/c;", "d", "Lcom/tencent/qqnt/aio/markdown/c;", "a", "()Lcom/tencent/qqnt/aio/markdown/c;", "listener", "<init>", "(Lcom/tencent/qqnt/aio/markdown/c;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class DispatchOnRemoveEvent extends AIOMarkdownMsgItemEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.markdown.c listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DispatchOnRemoveEvent(@NotNull com.tencent.qqnt.aio.markdown.c listener) {
            super(null);
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) listener);
            } else {
                this.listener = listener;
            }
        }

        @NotNull
        public final com.tencent.qqnt.aio.markdown.c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.aio.markdown.c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.listener;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof DispatchOnRemoveEvent) && Intrinsics.areEqual(this.listener, ((DispatchOnRemoveEvent) other).listener)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.listener.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "DispatchOnRemoveEvent(listener=" + this.listener + ")";
        }
    }

    public /* synthetic */ AIOMarkdownMsgItemEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    AIOMarkdownMsgItemEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

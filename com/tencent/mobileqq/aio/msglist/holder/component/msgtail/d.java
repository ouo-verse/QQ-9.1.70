package com.tencent.mobileqq.aio.msglist.holder.component.msgtail;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.emoreply.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d;", "Lcom/tencent/qqnt/aio/holder/a;", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$d;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class d implements com.tencent.qqnt.aio.holder.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d;", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "b", "()Lcom/tencent/aio/data/msglist/a;", "setMsgItem", "(Lcom/tencent/aio/data/msglist/a;)V", "msgItem", "Lcom/tencent/qqnt/aio/emoreply/h;", "e", "Lcom/tencent/qqnt/aio/emoreply/h;", "a", "()Lcom/tencent/qqnt/aio/emoreply/h;", "setEmoReplyAnimationInfo", "(Lcom/tencent/qqnt/aio/emoreply/h;)V", "emoReplyAnimationInfo", "<init>", "(Lcom/tencent/aio/data/msglist/a;Lcom/tencent/qqnt/aio/emoreply/h;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.aio.data.msglist.a msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private h emoReplyAnimationInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull h emoReplyAnimationInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            Intrinsics.checkNotNullParameter(emoReplyAnimationInfo, "emoReplyAnimationInfo");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem, (Object) emoReplyAnimationInfo);
            } else {
                this.msgItem = msgItem;
                this.emoReplyAnimationInfo = emoReplyAnimationInfo;
            }
        }

        @NotNull
        public final h a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (h) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.emoReplyAnimationInfo;
        }

        @NotNull
        public final com.tencent.aio.data.msglist.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d;", "", "d", "Z", "a", "()Z", "b", "(Z)V", "isFromForwardPreviewAIO", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isFromForwardPreviewAIO;

        public b() {
            this(false, 1, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isFromForwardPreviewAIO;
        }

        public final void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.isFromForwardPreviewAIO = z16;
            }
        }

        public b(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.isFromForwardPreviewAIO = z16;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            }
        }

        public /* synthetic */ b(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d;", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "setMsgItem", "(Lcom/tencent/aio/data/msglist/a;)V", "msgItem", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.aio.data.msglist.a msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull com.tencent.aio.data.msglist.a msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            } else {
                this.msgItem = msgItem;
            }
        }

        @NotNull
        public final com.tencent.aio.data.msglist.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d$d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/d;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "source", "", "e", "I", "b", "()I", "type", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.d$d, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7313d extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int type;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.source;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.type;
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

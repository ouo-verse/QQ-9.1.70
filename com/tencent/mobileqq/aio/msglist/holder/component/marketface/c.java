package com.tencent.mobileqq.aio.msglist.holder.component.marketface;

import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/d;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class c extends com.tencent.mobileqq.aio.msglist.holder.d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "clickedView", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "<init>", "(Landroid/view/View;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View clickedView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MarketFaceElement marketFaceElement;

        public a(@NotNull View clickedView, @NotNull MsgRecord msgRecord, @Nullable MarketFaceElement marketFaceElement) {
            Intrinsics.checkNotNullParameter(clickedView, "clickedView");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, clickedView, msgRecord, marketFaceElement);
                return;
            }
            this.clickedView = clickedView;
            this.msgRecord = msgRecord;
            this.marketFaceElement = marketFaceElement;
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.clickedView;
        }

        @Nullable
        public final MarketFaceElement b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (MarketFaceElement) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.marketFaceElement;
        }

        @NotNull
        public final MsgRecord c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MsgRecord) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarketFaceElement marketFaceElement;

        public b(@NotNull MarketFaceElement marketFaceElement) {
            Intrinsics.checkNotNullParameter(marketFaceElement, "marketFaceElement");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) marketFaceElement);
            } else {
                this.marketFaceElement = marketFaceElement;
            }
        }

        @NotNull
        public final MarketFaceElement a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MarketFaceElement) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.marketFaceElement;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.marketface.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7309c extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        public C7309c(@NotNull AIOMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            } else {
                this.msgItem = msgItem;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        public d(@NotNull AIOMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            } else {
                this.msgItem = msgItem;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c;", "Lcom/tencent/mobileqq/data/Emoticon;", "d", "Lcom/tencent/mobileqq/data/Emoticon;", "a", "()Lcom/tencent/mobileqq/data/Emoticon;", "emoticon", "", "e", "I", "b", "()I", "resTaskType", "<init>", "(Lcom/tencent/mobileqq/data/Emoticon;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Emoticon emoticon;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int resTaskType;

        public e(@NotNull Emoticon emoticon, int i3) {
            Intrinsics.checkNotNullParameter(emoticon, "emoticon");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticon, i3);
            } else {
                this.emoticon = emoticon;
                this.resTaskType = i3;
            }
        }

        @NotNull
        public final Emoticon a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Emoticon) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.emoticon;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.resTaskType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$f;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "", "e", "I", "a", "()I", "index", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarketFaceElement marketFaceElement;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int index;

        public f(@NotNull MarketFaceElement marketFaceElement, int i3) {
            Intrinsics.checkNotNullParameter(marketFaceElement, "marketFaceElement");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) marketFaceElement, i3);
            } else {
                this.marketFaceElement = marketFaceElement;
                this.index = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.index;
        }

        @NotNull
        public final MarketFaceElement b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MarketFaceElement) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.marketFaceElement;
        }

        public /* synthetic */ f(MarketFaceElement marketFaceElement, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(marketFaceElement, (i16 & 2) != 0 ? 0 : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, marketFaceElement, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

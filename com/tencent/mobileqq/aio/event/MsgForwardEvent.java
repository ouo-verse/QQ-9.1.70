package com.tencent.mobileqq.aio.event;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgForwardEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ExitMultiForward", "MultiFavClickEvent", "MultiForwardSelectResult", "MultiMoreClickEvent", "MultiReportEvent", "SingleForwardSelectResult", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$ExitMultiForward;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiFavClickEvent;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiForwardSelectResult;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiMoreClickEvent;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiReportEvent;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$SingleForwardSelectResult;", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public abstract class MsgForwardEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$ExitMultiForward;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class ExitMultiForward extends MsgForwardEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ExitMultiForward f188621d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46124);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f188621d = new ExitMultiForward();
            }
        }

        ExitMultiForward() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgForwardEvent.ExitMultiForward";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiFavClickEvent;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent;", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class MultiFavClickEvent extends MsgForwardEvent {
        static IPatchRedirector $redirector_;

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgForwardEvent.MultiFavClickEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR+\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R4\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00108\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiForwardSelectResult;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "()Z", "forward", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "dstContacts", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "f", "getComments", "getComments$annotations", "()V", "comments", tl.h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "commentStr", "i", "c", "exitSelect", "<init>", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class MultiForwardSelectResult extends MsgForwardEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean forward;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<Contact> dstContacts;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<MsgElement> comments;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String commentStr;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean exitSelect;

        public /* synthetic */ MultiForwardSelectResult(boolean z16, ArrayList arrayList, ArrayList arrayList2, String str, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, arrayList, (i3 & 4) != 0 ? null : arrayList2, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? false : z17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList, arrayList2, str, Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.commentStr;
        }

        @Nullable
        public final ArrayList<Contact> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.dstContacts;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.exitSelect;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.forward;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiForwardSelectResult)) {
                return false;
            }
            MultiForwardSelectResult multiForwardSelectResult = (MultiForwardSelectResult) other;
            if (this.forward == multiForwardSelectResult.forward && Intrinsics.areEqual(this.dstContacts, multiForwardSelectResult.dstContacts) && Intrinsics.areEqual(this.comments, multiForwardSelectResult.comments) && Intrinsics.areEqual(this.commentStr, multiForwardSelectResult.commentStr) && this.exitSelect == multiForwardSelectResult.exitSelect) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgForwardEvent.MultiForwardSelectResult";
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            boolean z16 = this.forward;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            ArrayList<Contact> arrayList = this.dstContacts;
            int i17 = 0;
            if (arrayList == null) {
                hashCode = 0;
            } else {
                hashCode = arrayList.hashCode();
            }
            int i18 = (i16 + hashCode) * 31;
            ArrayList<MsgElement> arrayList2 = this.comments;
            if (arrayList2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = arrayList2.hashCode();
            }
            int i19 = (i18 + hashCode2) * 31;
            String str = this.commentStr;
            if (str != null) {
                i17 = str.hashCode();
            }
            int i26 = (i19 + i17) * 31;
            boolean z17 = this.exitSelect;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i26 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "MultiForwardSelectResult(forward=" + this.forward + ", dstContacts=" + this.dstContacts + ", comments=" + this.comments + ", commentStr=" + this.commentStr + ", exitSelect=" + this.exitSelect + ")";
        }

        public MultiForwardSelectResult(boolean z16, @Nullable ArrayList<Contact> arrayList, @Nullable ArrayList<MsgElement> arrayList2, @Nullable String str, boolean z17) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), arrayList, arrayList2, str, Boolean.valueOf(z17));
                return;
            }
            this.forward = z16;
            this.dstContacts = arrayList;
            this.comments = arrayList2;
            this.commentStr = str;
            this.exitSelect = z17;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiMoreClickEvent;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "msgItemList", "<init>", "(Ljava/util/List;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class MultiMoreClickEvent extends MsgForwardEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<AIOMsgItem> msgItemList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MultiMoreClickEvent(@NotNull List<? extends AIOMsgItem> msgItemList) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItemList);
            } else {
                this.msgItemList = msgItemList;
            }
        }

        @NotNull
        public final List<AIOMsgItem> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItemList;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgForwardEvent.MultiMoreClickEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiReportEvent;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "msgItemList", "<init>", "(Ljava/util/List;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class MultiReportEvent extends MsgForwardEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<AIOMsgItem> msgItemList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MultiReportEvent(@NotNull List<? extends AIOMsgItem> msgItemList) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItemList);
            } else {
                this.msgItemList = msgItemList;
            }
        }

        @NotNull
        public final List<AIOMsgItem> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItemList;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof MultiReportEvent) && Intrinsics.areEqual(this.msgItemList, ((MultiReportEvent) other).msgItemList)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgForwardEvent.MultiReportEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.msgItemList.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "MultiReportEvent(msgItemList=" + this.msgItemList + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR+\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R+\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$SingleForwardSelectResult;", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "c", "()Z", "forward", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "dstContacts", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "f", "a", "comments", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SingleForwardSelectResult extends MsgForwardEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean forward;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<Contact> dstContacts;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<MsgElement> comments;

        @Nullable
        public final ArrayList<MsgElement> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.comments;
        }

        @Nullable
        public final ArrayList<Contact> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.dstContacts;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.forward;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SingleForwardSelectResult)) {
                return false;
            }
            SingleForwardSelectResult singleForwardSelectResult = (SingleForwardSelectResult) other;
            if (this.forward == singleForwardSelectResult.forward && Intrinsics.areEqual(this.dstContacts, singleForwardSelectResult.dstContacts) && Intrinsics.areEqual(this.comments, singleForwardSelectResult.comments)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.MsgForwardEvent.SingleForwardSelectResult";
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            boolean z16 = this.forward;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            ArrayList<Contact> arrayList = this.dstContacts;
            int i16 = 0;
            if (arrayList == null) {
                hashCode = 0;
            } else {
                hashCode = arrayList.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            ArrayList<MsgElement> arrayList2 = this.comments;
            if (arrayList2 != null) {
                i16 = arrayList2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "SingleForwardSelectResult(forward=" + this.forward + ", dstContacts=" + this.dstContacts + ", comments=" + this.comments + ")";
        }
    }

    public /* synthetic */ MsgForwardEvent(DefaultConstructorMarker defaultConstructorMarker) {
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

    MsgForwardEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

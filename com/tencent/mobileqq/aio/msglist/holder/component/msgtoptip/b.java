package com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtoptip/b;", "", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "", "firstUnreadSeq", "enterLastSeq", "Lcom/tencent/aio/data/AIOContact;", "contact", "", "b", "", "a", "", "Z", "mHasSetFlag", "mNeedNewMsgTip", "<init>", "()V", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mHasSetFlag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedNewMsgTip;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtoptip/b$a;", "", "", "SHOW_TIP_THRESHOLD", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mNeedNewMsgTip = true;
        }
    }

    public final void a(long firstUnreadSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, firstUnreadSeq);
        } else if (firstUnreadSeq <= 0) {
            this.mNeedNewMsgTip = false;
        }
    }

    public final int b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, long firstUnreadSeq, long enterLastSeq, @NotNull AIOContact contact) {
        Object first;
        Object last;
        Object first2;
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, displayList, Long.valueOf(firstUnreadSeq), Long.valueOf(enterLastSeq), contact)).intValue();
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (contact.e() == 2 && firstUnreadSeq > 0 && enterLastSeq > 0 && !displayList.isEmpty() && this.mNeedNewMsgTip) {
            if ((enterLastSeq - firstUnreadSeq) + 1 >= 15) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
                if (((com.tencent.aio.data.msglist.a) first).getMsgSeq() <= firstUnreadSeq) {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
                    if (((com.tencent.aio.data.msglist.a) last).getMsgSeq() >= firstUnreadSeq) {
                        if (!this.mHasSetFlag) {
                            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
                            int msgSeq = (int) (firstUnreadSeq - ((com.tencent.aio.data.msglist.a) first2).getMsgSeq());
                            if (msgSeq >= 0) {
                                if (msgSeq >= displayList.size()) {
                                    i3 = displayList.size() - 1;
                                } else {
                                    i3 = msgSeq;
                                }
                            }
                            if (displayList.get(i3).getMsgSeq() != firstUnreadSeq) {
                                if (displayList.get(i3).getMsgSeq() >= firstUnreadSeq) {
                                    while (true) {
                                        int i16 = i3 - 1;
                                        if (i16 < 0 || displayList.get(i16).getMsgSeq() < firstUnreadSeq) {
                                            break;
                                        }
                                        i3--;
                                    }
                                } else {
                                    while (i3 < displayList.size() && displayList.get(i3).getMsgSeq() < firstUnreadSeq) {
                                        i3++;
                                    }
                                }
                            } else {
                                while (true) {
                                    int i17 = i3 - 1;
                                    if (i17 < 0 || displayList.get(i17).getMsgSeq() != firstUnreadSeq) {
                                        break;
                                    }
                                    i3--;
                                }
                            }
                            if (i3 < 0 || i3 >= displayList.size()) {
                                return -1;
                            }
                            com.tencent.aio.data.msglist.a aVar = displayList.get(i3);
                            if (aVar instanceof AIOMsgItem) {
                                aIOMsgItem = (AIOMsgItem) aVar;
                            } else {
                                aIOMsgItem = null;
                            }
                            if (aIOMsgItem != null) {
                                aIOMsgItem.V1(true);
                                aIOMsgItem.X1(true);
                            }
                            this.mHasSetFlag = true;
                            return i3;
                        }
                        return -1;
                    }
                }
                this.mHasSetFlag = false;
            } else {
                this.mNeedNewMsgTip = false;
                return -1;
            }
        }
        return -1;
    }
}

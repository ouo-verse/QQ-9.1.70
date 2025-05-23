package com.tencent.mobileqq.aio.msglist.msgprocessor;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016R\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/b;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "list", "", "f", "", "theLastMessagePosition", "theLastMessage", "previousMessagePosition", "previousMessage", "g", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "d", "I", "lastFlowMessagePosition", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "e", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int lastFlowMessagePosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/b$a;", "", "", "MSG_FOLLOW_COLLECT_ERROR_COUNT_LIMIT", "I", "MSG_FOLLOW_MIDDLE_SKIP_SPECIAL_MSG_COUNT_LIMIT", "MSG_FOLLOW_SKIP_SPECIAL_MSG_COUNT_LIMIT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgprocessor.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64075);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        } else {
            this.lastFlowMessagePosition = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(List<? extends AIOMsgItem> list) {
        Object last;
        boolean z16;
        boolean z17;
        int size;
        if (!list.isEmpty() && !AIOUtil.f194084a.p(list)) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            AIOMsgItem aIOMsgItem = (AIOMsgItem) last;
            if (aIOMsgItem.G0()) {
                return;
            }
            int i3 = this.lastFlowMessagePosition;
            AIOMsgItem aIOMsgItem2 = null;
            boolean z18 = false;
            if (i3 >= 0) {
                if (i3 < list.size() && list.get(this.lastFlowMessagePosition).G0()) {
                    list.get(this.lastFlowMessagePosition).j1(false);
                    b().e().h(new AIOMsgListEvent.MsgContentChangeEvent(this.lastFlowMessagePosition, null, 2, null));
                    this.lastFlowMessagePosition = -1;
                } else {
                    int i16 = 1;
                    while (true) {
                        if (i16 >= 11 || (size = list.size() - i16) < 0) {
                            break;
                        }
                        if (list.get(size).G0()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AIOMsgFollowProcessor", 2, "handleMessageFollow collect error. index=" + size + ", lastFlowMessagePosition=" + this.lastFlowMessagePosition + ", list.size=" + list.size());
                            }
                            list.get(size).j1(false);
                            b().e().h(new AIOMsgListEvent.MsgContentChangeEvent(size, null, 2, null));
                            this.lastFlowMessagePosition = -1;
                        } else {
                            i16++;
                        }
                    }
                }
            }
            int i17 = 1;
            while (aIOMsgItem.getMsgRecord().msgType == 5) {
                i17++;
                if (list.size() - i17 >= 0 && i17 <= 4) {
                    aIOMsgItem = list.get(list.size() - i17);
                } else {
                    z16 = false;
                    break;
                }
            }
            z16 = true;
            int i18 = i17 + 1;
            if (list.size() - i18 >= 0) {
                aIOMsgItem2 = list.get(list.size() - i18);
                while (true) {
                    if (aIOMsgItem2 != null) {
                        MsgRecord msgRecord = aIOMsgItem2.getMsgRecord();
                        if (msgRecord != null && msgRecord.msgType == 5) {
                            z17 = true;
                            if (!z17) {
                                i18++;
                                if (list.size() - i18 < 0 || (i18 - 1) - i17 > 3) {
                                    break;
                                } else {
                                    aIOMsgItem2 = list.get(list.size() - i18);
                                }
                            } else {
                                z18 = z16;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
            }
            if (z18 && aIOMsgItem2 != null) {
                g(list.size() - i17, aIOMsgItem, list.size() - i18, aIOMsgItem2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void g(int theLastMessagePosition, AIOMsgItem theLastMessage, int previousMessagePosition, AIOMsgItem previousMessage) {
        boolean equals;
        MarketFaceElement marketFaceElement;
        MarketFaceElement marketFaceElement2;
        if (theLastMessage.v().chatType == 2 || theLastMessage.v().chatType == 3) {
            if (theLastMessage.getMsgRecord().msgType == 17 && previousMessage.getMsgRecord().msgType == 17) {
                MsgElement firstTypeElement = theLastMessage.getFirstTypeElement(11);
                if (firstTypeElement != null) {
                    marketFaceElement = firstTypeElement.marketFaceElement;
                } else {
                    marketFaceElement = null;
                }
                MsgElement firstTypeElement2 = previousMessage.getFirstTypeElement(11);
                if (firstTypeElement2 != null) {
                    marketFaceElement2 = firstTypeElement2.marketFaceElement;
                } else {
                    marketFaceElement2 = null;
                }
                if (marketFaceElement != null && marketFaceElement2 != null && marketFaceElement.emojiPackageId == marketFaceElement2.emojiPackageId && Intrinsics.areEqual(marketFaceElement.emojiId, marketFaceElement2.emojiId)) {
                    equals = true;
                }
            } else if (com.tencent.mobileqq.aio.utils.d.a0(theLastMessage.getMsgRecord()) && com.tencent.mobileqq.aio.utils.d.a0(previousMessage.getMsgRecord()) && !com.tencent.mobileqq.aio.utils.d.q(theLastMessage)) {
                ArrayList<MsgElement> theLastMessageElements = theLastMessage.getMsgRecord().elements;
                ArrayList<MsgElement> previousMessageElements = previousMessage.getMsgRecord().elements;
                if (theLastMessageElements.size() == previousMessageElements.size()) {
                    com.tencent.mobileqq.aio.msglist.holder.component.text.c cVar = com.tencent.mobileqq.aio.msglist.holder.component.text.c.f191997a;
                    Intrinsics.checkNotNullExpressionValue(theLastMessageElements, "theLastMessageElements");
                    CharSequence a16 = cVar.a(theLastMessageElements);
                    Intrinsics.checkNotNullExpressionValue(previousMessageElements, "previousMessageElements");
                    equals = TextUtils.equals(a16, cVar.a(previousMessageElements));
                }
            }
            if (theLastMessage.G0() != equals) {
                theLastMessage.j1(equals);
                b().e().h(new AIOMsgListEvent.MsgContentChangeEvent(theLastMessagePosition, null, 2, null));
                if (!equals) {
                    theLastMessagePosition = -1;
                }
                this.lastFlowMessagePosition = theLastMessagePosition;
            }
            if (!previousMessage.G0()) {
                previousMessage.j1(false);
                b().e().h(new AIOMsgListEvent.MsgContentChangeEvent(previousMessagePosition, null, 2, null));
                return;
            }
            return;
        }
        equals = false;
        if (theLastMessage.G0() != equals) {
        }
        if (!previousMessage.G0()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        f(displayList);
        return displayList;
    }
}

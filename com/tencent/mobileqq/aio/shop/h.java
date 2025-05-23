package com.tencent.mobileqq.aio.shop;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.shop.api.IShopAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\fH\u0002J\f\u0010\u000f\u001a\u00020\u0004*\u00020\u000eH\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/h;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "Lcom/tencent/aio/data/msglist/a;", "iMsgItem", "", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", DTConstants.TAG.ELEMENT, "Lorg/json/JSONObject;", "g", tl.h.F, "f", "", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "j", "", "displayList", "a", "", "d", "J", "lastMsgId", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "e", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastMsgId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.shop.h$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        } else {
            this.lastMsgId = -1L;
        }
    }

    private final JSONObject f(ArkElement element) {
        JSONObject k3 = k(element.bytesData);
        if (k3 != null) {
            return k3.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        }
        return null;
    }

    private final JSONObject g(ArkElement element) {
        JSONObject k3 = k(element.bytesData);
        if (k3 != null) {
            return k3.optJSONObject("sourceAd");
        }
        return null;
    }

    private final boolean h(ArkElement element) {
        JSONObject optJSONObject;
        JSONObject f16 = f(element);
        if (f16 != null && (optJSONObject = f16.optJSONObject("gdt")) != null) {
            return optJSONObject.has("isShowArk");
        }
        return false;
    }

    private final boolean i(com.tencent.aio.data.msglist.a iMsgItem) {
        MsgElement msgElement;
        int i3;
        boolean z16;
        boolean z17;
        MsgElement msgElement2;
        boolean z18;
        if (!(iMsgItem instanceof AIOMsgItem)) {
            return false;
        }
        AIOMsgItem aIOMsgItem = (AIOMsgItem) iMsgItem;
        if (!j(aIOMsgItem.getMsgRecord())) {
            return false;
        }
        ArkElement arkElement = null;
        if (iMsgItem instanceof g) {
            ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "iMsgItem.msgRecord.elements");
            ListIterator<MsgElement> listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    msgElement2 = listIterator.previous();
                    if (msgElement2.elementType == 10) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        break;
                    }
                } else {
                    msgElement2 = null;
                    break;
                }
            }
            MsgElement msgElement3 = msgElement2;
            if (msgElement3 != null) {
                arkElement = msgElement3.arkElement;
            }
            if (arkElement == null) {
                return false;
            }
            if (!h(arkElement) || ((IShopAIOApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IShopAIOApi.class)).getQQShopIs2Tab()) {
                return true;
            }
            b().g().l();
            return false;
        }
        ArrayList<MsgElement> arrayList2 = aIOMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "iMsgItem.msgRecord.elements");
        ListIterator<MsgElement> listIterator2 = arrayList2.listIterator(arrayList2.size());
        while (true) {
            if (listIterator2.hasPrevious()) {
                msgElement = listIterator2.previous();
                if (msgElement.elementType == 10) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                msgElement = null;
                break;
            }
        }
        MsgElement msgElement4 = msgElement;
        if (msgElement4 != null) {
            arkElement = msgElement4.arkElement;
        }
        if (arkElement == null) {
            return false;
        }
        JSONObject g16 = g(arkElement);
        if (g16 != null) {
            i3 = g16.optInt("action_type");
        } else {
            i3 = 0;
        }
        if (100 <= i3 && i3 < 200) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && i3 != 202) {
            return false;
        }
        return true;
    }

    private final boolean j(MsgRecord msgRecord) {
        if (msgRecord.msgType == 11 && msgRecord.chatType == 103 && !MsgExtKt.S(msgRecord) && Intrinsics.areEqual(msgRecord.peerUid, "u_2ZRcriDgt2a46svnxKPPMw")) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0013 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: JSONException -> 0x000e, TRY_LEAVE, TryCatch #0 {JSONException -> 0x000e, blocks: (B:15:0x0005, B:7:0x0014), top: B:14:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject k(String str) {
        boolean z16;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        return null;
                    }
                    return new JSONObject(str);
                }
            } catch (JSONException e16) {
                QLog.e("ShopMsgProcessor", 1, e16, new Object[0]);
                return null;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) displayList);
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
        if (aVar != null) {
            if (this.lastMsgId == -1) {
                this.lastMsgId = aVar.getMsgId();
            }
            if (this.lastMsgId == aVar.getMsgId() && (aVar instanceof g)) {
                ((g) aVar).x2(true);
            }
        }
        QLog.d("ShopMsgProcessor", 1, "beforeMsgToScreen lastMsgId = " + this.lastMsgId);
        ArrayList arrayList = new ArrayList();
        for (Object obj : displayList) {
            if (!i((com.tencent.aio.data.msglist.a) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}

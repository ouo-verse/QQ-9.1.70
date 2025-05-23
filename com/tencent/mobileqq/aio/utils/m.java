package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IBubbleTokenApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/m;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "b", "a", "", "c", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f194167a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f194167a = new m();
        }
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull AIOMsgItem msgItem) {
        VASMsgElement vASMsgElement;
        VASMsgBubble vASMsgBubble;
        Integer num;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null && (vASMsgBubble = vASMsgElement.bubbleInfo) != null && (num = vASMsgBubble.bubbleDiyTextId) != null && (intValue = num.intValue()) > 0) {
            return String.valueOf(intValue);
        }
        return "0";
    }

    @NotNull
    public final String b(@NotNull AIOMsgItem msgItem) {
        VASMsgElement vASMsgElement;
        VASMsgBubble vASMsgBubble;
        Integer num;
        int intValue;
        VASMsgElement vASMsgElement2;
        VASMsgBubble vASMsgBubble2;
        Integer num2;
        int intValue2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASMsgElement2 = msgAttributeInfo.vasMsgInfo) != null && (vASMsgBubble2 = vASMsgElement2.bubbleInfo) != null && (num2 = vASMsgBubble2.subBubbleId) != null && (intValue2 = num2.intValue()) > 0) {
            return String.valueOf(intValue2);
        }
        MsgAttributeInfo msgAttributeInfo2 = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo2 != null && (vASMsgElement = msgAttributeInfo2.vasMsgInfo) != null && (vASMsgBubble = vASMsgElement.bubbleInfo) != null && (num = vASMsgBubble.bubbleId) != null && (intValue = num.intValue()) > 0) {
            return String.valueOf(intValue);
        }
        return "";
    }

    public final boolean c(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return ((IBubbleTokenApi) QRoute.api(IBubbleTokenApi.class)).useTokenForBubble(msgItem);
    }
}

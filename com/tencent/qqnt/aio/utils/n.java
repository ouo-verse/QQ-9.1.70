package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/utils/n;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "a", "b", "c", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f352308a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352308a = new n();
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(@NotNull AIOMsgItem msgItem) {
        VASMsgElement vASMsgElement;
        VASMsgFont vASMsgFont;
        Integer num;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null && (vASMsgFont = vASMsgElement.vasFont) != null && (num = vASMsgFont.fontId) != null && (intValue = num.intValue()) > 0) {
            long j3 = intValue;
            return (int) (((j3 & 255) << 8) + ((j3 >> 8) & 255));
        }
        return 0;
    }

    public final int b(@NotNull AIOMsgItem msgItem) {
        VASMsgElement vASMsgElement;
        VASMsgFont vASMsgFont;
        Integer num;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null && (vASMsgFont = vASMsgElement.vasFont) != null && (num = vASMsgFont.fontId) != null && (intValue = num.intValue()) > 0) {
            return (intValue >> 16) & 15;
        }
        return 0;
    }

    public final int c(@NotNull AIOMsgItem msgItem) {
        MsgAttributeInfo msgAttributeInfo;
        VASMsgElement vASMsgElement;
        VASMsgFont vASMsgFont;
        int intValue;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.p0() == 104 || (msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1)) == null || (vASMsgElement = msgAttributeInfo.vasMsgInfo) == null || (vASMsgFont = vASMsgElement.vasFont) == null) {
            return 0;
        }
        Integer num = vASMsgFont.fontId;
        if (num == null) {
            intValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(num, "it.fontId?: 0");
            intValue = num.intValue();
        }
        if (intValue > 0) {
            i3 = 1 & (intValue >> 24);
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            return i3;
        }
        Integer num2 = vASMsgFont.magicFontType;
        if (num2 == null) {
            return 0;
        }
        Intrinsics.checkNotNullExpressionValue(num2, "it.magicFontType?: 0");
        return num2.intValue();
    }
}

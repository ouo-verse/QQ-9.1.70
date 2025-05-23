package com.tencent.qqnt.aio.utils;

import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u0004*\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/utils/s;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "", "b", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f352317a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47942);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f352317a = new s();
        }
    }

    s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull MsgElement msgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgElement);
        }
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        int i3 = msgElement.elementType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 6) {
                        return GuildMsgElementApiImpl.MSG_ELEMENT_UN_SUPPORT_PROMPT;
                    }
                    String str = msgElement.faceElement.faceText;
                    if (str == null) {
                        return GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI;
                    }
                    return str;
                }
                return GuildMsgElementApiImpl.DESC_ELEMENT_FILE;
            }
            return GuildMsgElementApiImpl.DESC_ELEMENT_PIC;
        }
        String a16 = ac.a(msgElement.textElement.content, false, null);
        Intrinsics.checkNotNullExpressionValue(a16, "{\n                encode\u2026alse, null)\n            }");
        return a16;
    }

    @NotNull
    public final String b(@NotNull MsgElement element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        return a(element);
    }
}

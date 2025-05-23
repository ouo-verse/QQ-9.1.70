package com.tencent.mobileqq.aio.msglist.holder.component.text;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.utils.TextContentBuildUtilKt;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.emotion.utils.s;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/text/c;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "", "b", "a", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "getTextApi", "()Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "textApi", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f191997a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IQQTextApi textApi;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f191997a = new c();
            textApi = (IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class);
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final CharSequence a(@NotNull List<MsgElement> msgElements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgElements);
        }
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        return TextContentBuildUtilKt.c(msgElements, null, 2, null);
    }

    @NotNull
    public final CharSequence b(@NotNull List<MsgElement> msgElements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgElements);
        }
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        String str = "";
        for (MsgElement msgElement : msgElements) {
            int i3 = msgElement.elementType;
            if (i3 != 1 && i3 != 9) {
                if (i3 == 6) {
                    String faceDescription = ((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).getFaceDescription(msgElement.faceElement.faceIndex, 1);
                    str = str + HardCodeUtil.qqStr(R.string.f170197yp0) + faceDescription;
                }
            } else {
                str = str + s.b(com.tencent.qqnt.aio.utils.s.f352317a.b(msgElement));
            }
        }
        return str;
    }
}

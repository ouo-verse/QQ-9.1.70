package com.tencent.mobileqq.aio.sendmsg;

import com.tencent.aio.msgservice.k;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/sendmsg/SendMsgInterceptUtil;", "", "Lcom/tencent/aio/msgservice/k;", "sendMsgsReq", "Lkotlin/Lazy;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class SendMsgInterceptUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SendMsgInterceptUtil f193678a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64933);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f193678a = new SendMsgInterceptUtil();
        }
    }

    SendMsgInterceptUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Lazy<ArrayList<MsgElement>> a(@NotNull final k sendMsgsReq) {
        Lazy<ArrayList<MsgElement>> lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Lazy) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sendMsgsReq);
        }
        Intrinsics.checkNotNullParameter(sendMsgsReq, "sendMsgsReq");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<MsgElement>>() { // from class: com.tencent.mobileqq.aio.sendmsg.SendMsgInterceptUtil$msgElementSupplier$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) k.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<MsgElement> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOObjectTransform aIOObjectTransform = AIOObjectTransform.f194080a;
                List<Object> b16 = k.this.b();
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.data.AIOMsgElement>");
                return AIOObjectTransform.m(aIOObjectTransform, b16, 0, 2, null);
            }
        });
        return lazy;
    }
}

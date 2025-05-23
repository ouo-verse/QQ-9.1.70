package com.tencent.mobileqq.guild.message.msgsend;

import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import st1.l;
import st1.m;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/message/msgsend/a;", "Lst1/m;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "", "a", "Lst1/l;", "Lst1/l;", "getSubOnInterceptResult", "()Lst1/l;", "setSubOnInterceptResult", "(Lst1/l;)V", "subOnInterceptResult", "Lcom/tencent/aio/api/runtime/a;", "b", "Lcom/tencent/aio/api/runtime/a;", "context", "<init>", "(Lst1/l;Lcom/tencent/aio/api/runtime/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l subOnInterceptResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a context;

    public a(@NotNull l subOnInterceptResult, @NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(subOnInterceptResult, "subOnInterceptResult");
        Intrinsics.checkNotNullParameter(context, "context");
        this.subOnInterceptResult = subOnInterceptResult;
        this.context = context;
    }

    @Override // st1.m
    public void a(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        if (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptHongbao(com.tencent.guild.aio.util.ex.a.f(this.context), peer.peerUid)) {
            if (!(msgElements instanceof Collection) || !msgElements.isEmpty()) {
                Iterator<T> it = msgElements.iterator();
                while (it.hasNext()) {
                    if (((MsgElement) it.next()).elementType == 9) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17) {
                ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptRedEnvelopeSendToast();
                this.subOnInterceptResult.a(this, true);
                return;
            }
        }
        this.subOnInterceptResult.a(this, false);
    }
}

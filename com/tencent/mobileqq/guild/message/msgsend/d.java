package com.tencent.mobileqq.guild.message.msgsend;

import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import st1.l;
import st1.m;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/message/msgsend/d;", "Lst1/m;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "", "a", "Lst1/l;", "Lst1/l;", "getSubOnInterceptResult", "()Lst1/l;", "setSubOnInterceptResult", "(Lst1/l;)V", "subOnInterceptResult", "Lcom/tencent/aio/api/runtime/a;", "b", "Lcom/tencent/aio/api/runtime/a;", "getContext", "()Lcom/tencent/aio/api/runtime/a;", "context", "<init>", "(Lst1/l;Lcom/tencent/aio/api/runtime/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l subOnInterceptResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a context;

    public d(@NotNull l subOnInterceptResult, @NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(subOnInterceptResult, "subOnInterceptResult");
        Intrinsics.checkNotNullParameter(context, "context");
        this.subOnInterceptResult = subOnInterceptResult;
        this.context = context;
    }

    @Override // st1.m
    public void a(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (MsgElement msgElement : msgElements) {
            TextElement textElement = msgElement.textElement;
            if (textElement != null && !TextUtils.isEmpty(textElement.content)) {
                int i18 = msgElement.textElement.atType;
                if (i18 == 1) {
                    i3++;
                } else if (i18 == 64) {
                    i16++;
                } else if (i18 == 8) {
                    i17++;
                }
            }
        }
        if (i3 <= 0 && i16 <= 0 && i17 <= 0) {
            this.subOnInterceptResult.a(this, false);
            return;
        }
        IGuildSpeechApi iGuildSpeechApi = (IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class);
        AIOParam g16 = this.context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        this.subOnInterceptResult.a(this, iGuildSpeechApi.isNeedInterceptOfAt(com.tencent.guild.aio.util.a.g(g16), i3, i16, i17));
    }
}

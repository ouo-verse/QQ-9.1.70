package com.tencent.mobileqq.guild.message.msgsend;

import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.util.ex.FromScene;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/message/msgsend/e;", "Lst1/m;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "", "a", "Lst1/l;", "Lst1/l;", "subOnInterceptResult", "Lcom/tencent/aio/api/runtime/a;", "b", "Lcom/tencent/aio/api/runtime/a;", "getContext", "()Lcom/tencent/aio/api/runtime/a;", "context", "<init>", "(Lst1/l;Lcom/tencent/aio/api/runtime/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l subOnInterceptResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a context;

    public e(@NotNull l subOnInterceptResult, @NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(subOnInterceptResult, "subOnInterceptResult");
        Intrinsics.checkNotNullParameter(context, "context");
        this.subOnInterceptResult = subOnInterceptResult;
        this.context = context;
    }

    @Override // st1.m
    public void a(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements) {
        int i3;
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        if (com.tencent.guild.aio.util.ex.a.d(this.context) == FromScene.DIRECT.ordinal()) {
            this.subOnInterceptResult.a(this, false);
            return;
        }
        boolean z16 = false;
        for (MsgElement msgElement : msgElements) {
            TextElement textElement = msgElement.textElement;
            if (textElement != null && !TextUtils.isEmpty(textElement.content) && (i3 = msgElement.textElement.atType) != 2 && i3 != 4 && i3 != 16 && i3 != 64 && i3 != 8) {
                IGuildSpeechApi iGuildSpeechApi = (IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class);
                AIOParam g16 = this.context.g();
                Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
                if (iGuildSpeechApi.isNeedInterceptKeyword(com.tencent.guild.aio.util.a.g(g16), peer.peerUid, msgElement.textElement.content)) {
                    z16 = true;
                }
            }
        }
        if (z16) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptKeywordSendToast();
            this.subOnInterceptResult.a(this, true);
        } else {
            this.subOnInterceptResult.a(this, false);
        }
    }
}

package com.tencent.mobileqq.guild.message.msgsend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import st1.l;
import st1.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0002j\b\u0012\u0004\u0012\u00020\n`\u0004H\u0016R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/message/msgsend/h;", "Lst1/m;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "textInfos", "", "d", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "a", "Lst1/l;", "Lst1/l;", "getSubOnInterceptResult", "()Lst1/l;", "setSubOnInterceptResult", "(Lst1/l;)V", "subOnInterceptResult", "Lcom/tencent/aio/api/runtime/a;", "b", "Lcom/tencent/aio/api/runtime/a;", "getContext", "()Lcom/tencent/aio/api/runtime/a;", "context", "<init>", "(Lst1/l;Lcom/tencent/aio/api/runtime/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l subOnInterceptResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a context;

    public h(@NotNull l subOnInterceptResult, @NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(subOnInterceptResult, "subOnInterceptResult");
        Intrinsics.checkNotNullParameter(context, "context");
        this.subOnInterceptResult = subOnInterceptResult;
        this.context = context;
    }

    private final void d(final ArrayList<String> textInfos) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.msgsend.f
            @Override // java.lang.Runnable
            public final void run() {
                h.e(textInfos, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ArrayList textInfos, final h this$0) {
        Intrinsics.checkNotNullParameter(textInfos, "$textInfos");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Iterator it = textInfos.iterator();
        while (it.hasNext()) {
            if (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).containLink((String) it.next())) {
                booleanRef.element = true;
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.msgsend.g
            @Override // java.lang.Runnable
            public final void run() {
                h.f(Ref.BooleanRef.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Ref.BooleanRef isIntercept, h this$0) {
        Intrinsics.checkNotNullParameter(isIntercept, "$isIntercept");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isIntercept.element) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptLinkSendToast();
            this$0.subOnInterceptResult.a(this$0, true);
        } else {
            this$0.subOnInterceptResult.a(this$0, false);
        }
    }

    @Override // st1.m
    public void a(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements) {
        TextElement textElement;
        int i3;
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        ArrayList<String> arrayList = new ArrayList<>();
        if (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptLink(com.tencent.guild.aio.util.ex.a.f(this.context), peer.peerUid)) {
            for (MsgElement msgElement : msgElements) {
                TextElement textElement2 = msgElement.textElement;
                if (textElement2 != null && !TextUtils.isEmpty(textElement2.content) && (i3 = (textElement = msgElement.textElement).atType) != 2 && i3 != 4) {
                    arrayList.add(textElement.content);
                }
            }
        }
        if (arrayList.size() > 0) {
            d(arrayList);
        } else {
            this.subOnInterceptResult.a(this, false);
        }
    }
}

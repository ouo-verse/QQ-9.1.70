package com.tencent.mobileqq.guild.share.llmchat;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.az;
import com.tencent.mobileqq.qqguildsdk.data.genc.e;
import com.tencent.mobileqq.qqguildsdk.data.genc.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bl;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0003\u0019\u0010\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\b\u001a\u00060\u0007R\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareHelper;", "", "", "sessionId", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/f;", "msgIds", "Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareHelper$UrlResp;", "c", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "", "d", "Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet;", "a", "Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareActionSheet;", "mainShareSheet", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "b", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "task", "<init>", "()V", "BeBannedError", "UrlResp", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLLMChatShareHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildLLMChatShareActionSheet mainShareSheet = new GuildLLMChatShareActionSheet();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b task;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareHelper$BeBannedError;", "", "msg", "", "(Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareHelper;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public final class BeBannedError extends Throwable {

        @NotNull
        private final String msg;
        final /* synthetic */ GuildLLMChatShareHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BeBannedError(@NotNull GuildLLMChatShareHelper guildLLMChatShareHelper, String msg2) {
            super(msg2);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.this$0 = guildLLMChatShareHelper;
            this.msg = msg2;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\u0011\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\u0011\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\u0011\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\u0011\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\u0011\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\u0011\u0010\r\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareHelper$UrlResp;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetAISearchShareURLRsp;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "(Lcom/tencent/mobileqq/guild/share/llmchat/GuildLLMChatShareHelper;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetAISearchShareURLRsp;)V", "getAnwserDescription", "", "kotlin.jvm.PlatformType", "getBrandDescription", "getShareIcon", "getShareModelDescription", "getShareTitle", "getShareUrl", "getTailDescription", "getTailIcon", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public final class UrlResp implements IGProGetAISearchShareURLRsp {

        @NotNull
        private final IGProGetAISearchShareURLRsp instance;
        final /* synthetic */ GuildLLMChatShareHelper this$0;

        public UrlResp(@NotNull GuildLLMChatShareHelper guildLLMChatShareHelper, IGProGetAISearchShareURLRsp instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            this.this$0 = guildLLMChatShareHelper;
            this.instance = instance;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getAnwserDescription() {
            return this.instance.getAnwserDescription();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getBrandDescription() {
            return this.instance.getBrandDescription();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getShareIcon() {
            return this.instance.getShareIcon();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getShareModelDescription() {
            return this.instance.getShareModelDescription();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getShareTitle() {
            return this.instance.getShareTitle();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getShareUrl() {
            return this.instance.getShareUrl();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getTailDescription() {
            return this.instance.getTailDescription();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        public String getTailIcon() {
            return this.instance.getTailIcon();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
        @NotNull
        public String toString() {
            return String.valueOf(this.instance);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "msg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetAISearchShareURLRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetAISearchShareURLRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements bl {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<UrlResp> f235037a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildLLMChatShareHelper f235038b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super UrlResp> cancellableContinuation, GuildLLMChatShareHelper guildLLMChatShareHelper) {
            this.f235037a = cancellableContinuation;
            this.f235038b = guildLLMChatShareHelper;
        }

        @Override // wh2.bl
        public final void a(int i3, String msg2, IGProGetAISearchShareURLRsp rsp) {
            Logger.f235387a.d().d("GuildLLMChatShareHelper", 1, "[fetchShareUrl] result " + i3 + ", msg " + msg2 + ", rsp " + rsp);
            if (i3 == 0) {
                if (this.f235037a.isActive()) {
                    CancellableContinuation<UrlResp> cancellableContinuation = this.f235037a;
                    Result.Companion companion = Result.INSTANCE;
                    GuildLLMChatShareHelper guildLLMChatShareHelper = this.f235038b;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new UrlResp(guildLLMChatShareHelper, rsp)));
                    return;
                }
                Logger.b bVar = new Logger.b();
                bVar.a().add("continuation is canceled");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildLLMChatShareHelper", 1, (String) it.next(), null);
                }
                return;
            }
            Logger.b bVar2 = new Logger.b();
            String str = "error " + msg2;
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildLLMChatShareHelper", 1, (String) it5.next(), null);
            }
            if (this.f235037a.isActive()) {
                if (i3 == 20001) {
                    CancellableContinuation<UrlResp> cancellableContinuation2 = this.f235037a;
                    Result.Companion companion2 = Result.INSTANCE;
                    GuildLLMChatShareHelper guildLLMChatShareHelper2 = this.f235038b;
                    Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new BeBannedError(guildLLMChatShareHelper2, msg2))));
                    return;
                }
                CancellableContinuation<UrlResp> cancellableContinuation3 = this.f235037a;
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Throwable("fetch ai share url failed"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(String str, List<? extends f> list, Continuation<? super UrlResp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        az azVar = new az();
        e eVar = new e();
        eVar.d(str);
        eVar.c(new ArrayList<>(list));
        azVar.b(eVar);
        ((IGPSService) ch.R0(IGPSService.class)).getAISearchShareURL(azVar, new b(cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void d(@NotNull GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter) {
        String str;
        ArrayList arrayList;
        Job f16;
        List<com.tencent.mobileqq.guild.aisearch.models.a> g16;
        f fVar;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        AiChatSession m06 = adapter.m0();
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
        if (m06 != null) {
            str = m06.getSessionId();
        } else {
            str = null;
        }
        AiChatSession m07 = adapter.m0();
        if (m07 != null && (g16 = m07.g()) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.mobileqq.guild.aisearch.models.a aVar : g16) {
                if (aVar instanceof a.QuestionItem) {
                    fVar = new f();
                    fVar.d(((a.QuestionItem) aVar).getMessageId());
                    String msgId = fVar.b();
                    Intrinsics.checkNotNullExpressionValue(msgId, "msgId");
                    fVar.c(!adapter.n0(msgId));
                } else if (aVar instanceof a.AnswerItem) {
                    fVar = new f();
                    fVar.d(((a.AnswerItem) aVar).getMessageId());
                    String msgId2 = fVar.b();
                    Intrinsics.checkNotNullExpressionValue(msgId2, "msgId");
                    fVar.c(!adapter.n0(msgId2));
                } else {
                    fVar = null;
                }
                if (fVar != null) {
                    arrayList2.add(fVar);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (str != null && arrayList != null) {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = this.task;
            if (bVar2 != null && (f16 = bVar2.f()) != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
                Logger logger = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                bVar3.a().add("cancel the previous request");
                Iterator<T> it = bVar3.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildLLMChatShareHelper", 1, (String) it.next(), null);
                }
            }
            CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
            if (f17 != null) {
                bVar = CorountineFunKt.e(f17, "GuildLLMChatShareHelper GuildLLMChatShareHelper", null, null, Boolean.TRUE, new GuildLLMChatShareHelper$startShareMultiPlatform$3(this, adapter, str, arrayList, null), 6, null);
            }
            this.task = bVar;
            this.mainShareSheet.I(adapter.getHostActivity(), new ShareReqData(str, arrayList));
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar4 = new Logger.b();
        bVar4.a().add("can't share empty value");
        Iterator<T> it5 = bVar4.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("GuildLLMChatShareHelper", 1, (String) it5.next(), null);
        }
    }
}

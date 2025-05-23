package com.tencent.mobileqq.guild.share.llmchat;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.guild.share.ArkTemplateStr;
import com.tencent.mobileqq.guild.share.GuildArkBusiId;
import com.tencent.mobileqq.guild.share.a;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.qqnt.kernel.api.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u00a2\u0006\u0004\b)\u0010*J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\r\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R$\u0010(\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010$\u001a\u0004\b\b\u0010%\"\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/share/llmchat/FetchLLMShareArkInfo;", "Lcom/tencent/mobileqq/guild/share/a;", "Lcom/tencent/mobileqq/guild/share/b;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "", "a", "Ljava/util/Map;", "c", "()Ljava/util/Map;", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "b", "Lcom/tencent/mobileqq/guild/share/b;", "fetchedArkInfo", "Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "()Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "setBusiId", "(Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;)V", "busiId", "Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "d", "Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "()Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "setArkTemplateStr", "(Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;)V", "arkTemplateStr", "Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "e", "Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "()Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "setServiceType", "(Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;)V", "serviceType", "Ljava/lang/String;", "()Ljava/lang/String;", "setResourceId", "(Ljava/lang/String;)V", "resourceId", "<init>", "(Ljava/util/Map;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FetchLLMShareArkInfo implements com.tencent.mobileqq.guild.share.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> busiData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.share.b fetchedArkInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildArkBusiId busiId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArkTemplateStr arkTemplateStr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ShareServiceType serviceType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String resourceId;

    public FetchLLMShareArkInfo(@NotNull Map<String, ? extends Object> busiData) {
        Intrinsics.checkNotNullParameter(busiData, "busiData");
        this.busiData = busiData;
        this.busiId = GuildArkBusiId.LLM_CONVERSATION;
        this.arkTemplateStr = ArkTemplateStr.TuWen;
        this.serviceType = ShareServiceType.AI_SHARE;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @Nullable
    /* renamed from: a, reason: from getter */
    public String getResourceId() {
        return this.resourceId;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    /* renamed from: b, reason: from getter */
    public GuildArkBusiId getBusiId() {
        return this.busiId;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    public Map<String, Object> c() {
        return this.busiData;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public ArkTemplateStr getArkTemplateStr() {
        return this.arkTemplateStr;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public ShareServiceType getServiceType() {
        return this.serviceType;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object f(@NotNull Continuation<? super com.tencent.mobileqq.guild.share.b> continuation) {
        FetchLLMShareArkInfo$fetchArk$1 fetchLLMShareArkInfo$fetchArk$1;
        Object coroutine_suspended;
        int i3;
        FetchLLMShareArkInfo fetchLLMShareArkInfo;
        FetchLLMShareArkInfo fetchLLMShareArkInfo2;
        if (continuation instanceof FetchLLMShareArkInfo$fetchArk$1) {
            fetchLLMShareArkInfo$fetchArk$1 = (FetchLLMShareArkInfo$fetchArk$1) continuation;
            int i16 = fetchLLMShareArkInfo$fetchArk$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                fetchLLMShareArkInfo$fetchArk$1.label = i16 - Integer.MIN_VALUE;
                Object obj = fetchLLMShareArkInfo$fetchArk$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = fetchLLMShareArkInfo$fetchArk$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        fetchLLMShareArkInfo2 = (FetchLLMShareArkInfo) fetchLLMShareArkInfo$fetchArk$1.L$1;
                        fetchLLMShareArkInfo = (FetchLLMShareArkInfo) fetchLLMShareArkInfo$fetchArk$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (this.fetchedArkInfo == null) {
                        fetchLLMShareArkInfo$fetchArk$1.L$0 = this;
                        fetchLLMShareArkInfo$fetchArk$1.L$1 = this;
                        fetchLLMShareArkInfo$fetchArk$1.label = 1;
                        obj = a.C7906a.a(this, fetchLLMShareArkInfo$fetchArk$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fetchLLMShareArkInfo = this;
                        fetchLLMShareArkInfo2 = fetchLLMShareArkInfo;
                    } else {
                        fetchLLMShareArkInfo = this;
                        com.tencent.mobileqq.guild.share.b bVar = fetchLLMShareArkInfo.fetchedArkInfo;
                        Intrinsics.checkNotNull(bVar);
                        return bVar;
                    }
                }
                fetchLLMShareArkInfo2.fetchedArkInfo = (com.tencent.mobileqq.guild.share.b) obj;
                com.tencent.mobileqq.guild.share.b bVar2 = fetchLLMShareArkInfo.fetchedArkInfo;
                Intrinsics.checkNotNull(bVar2);
                return bVar2;
            }
        }
        fetchLLMShareArkInfo$fetchArk$1 = new FetchLLMShareArkInfo$fetchArk$1(this, continuation);
        Object obj2 = fetchLLMShareArkInfo$fetchArk$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = fetchLLMShareArkInfo$fetchArk$1.label;
        if (i3 == 0) {
        }
        fetchLLMShareArkInfo2.fetchedArkInfo = (com.tencent.mobileqq.guild.share.b) obj2;
        com.tencent.mobileqq.guild.share.b bVar22 = fetchLLMShareArkInfo.fetchedArkInfo;
        Intrinsics.checkNotNull(bVar22);
        return bVar22;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @Nullable
    public o getFeedService() {
        return a.C7906a.c(this);
    }
}

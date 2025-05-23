package com.tencent.mobileqq.guild.share.llmchat;

import com.tencent.mobileqq.qqguildsdk.data.genc.f;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/share/llmchat/d;", "", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "sessionId", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/f;", "b", "Ljava/util/List;", "getMsgIds", "()Ljava/util/List;", "msgIds", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.share.llmchat.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ShareReqData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<f> msgIds;

    /* JADX WARN: Multi-variable type inference failed */
    public ShareReqData(@NotNull String sessionId, @NotNull List<? extends f> msgIds) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        this.sessionId = sessionId;
        this.msgIds = msgIds;
    }

    @NotNull
    public final Map<String, Object> a() {
        int collectionSizeOrDefault;
        Map mapOf;
        Map<String, Object> mapOf2;
        Map mapOf3;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(ServiceConst.PARA_SESSION_ID, this.sessionId);
        List<f> list = this.msgIds;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (f fVar : list) {
            mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("msg_id", fVar.b()), TuplesKt.to("is_fold", Boolean.valueOf(fVar.a())));
            arrayList.add(mapOf3);
        }
        pairArr[1] = TuplesKt.to("msg_list", arrayList);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msg_share_data", mapOf));
        return mapOf2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareReqData)) {
            return false;
        }
        ShareReqData shareReqData = (ShareReqData) other;
        if (Intrinsics.areEqual(this.sessionId, shareReqData.sessionId) && Intrinsics.areEqual(this.msgIds, shareReqData.msgIds)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.sessionId.hashCode() * 31) + this.msgIds.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShareReqData(sessionId=" + this.sessionId + ", msgIds=" + this.msgIds + ")";
    }
}

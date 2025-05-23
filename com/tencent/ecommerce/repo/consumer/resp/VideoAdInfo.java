package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/VideoAdInfo;", "", "()V", "playInfos", "", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "getPlayInfos", "()Ljava/util/List;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class VideoAdInfo {

    @SerializedName("play_infos")
    private final List<PlayInfo> playInfos;

    public VideoAdInfo() {
        List<PlayInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.playInfos = emptyList;
    }

    public final List<PlayInfo> getPlayInfos() {
        return this.playInfos;
    }
}

package com.tencent.ecommerce.base;

import com.tencent.mobileqq.soload.api.SoLoad;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/base/QQECChannel;", "", "channelName", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getChannelName", "()Ljava/lang/String;", "getId", "()I", "CHANNEL_UNKNOWN", "CHANNEL_QQ_KAN_DIAN", "CHANNEL_QQ_LITTLE_WORLD", "CHANNEL_QQ_CHANNEL", "CHANNEL_QQ_SHOW", "CHANNEL_QQ_ECOMMERCE_BASE", "CHANNEL_QQ_GROUP", "CHANNEL_QQ_ZONE", "CHANNEL_QQ_LIVE", "CHANNEL_QQ_ECOMMERCE_SERVICE_NOTIFY", "CHANNEL_AMS_ADVERTISEMENT", "CHANNEL_QQ_VIP", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public enum QQECChannel {
    CHANNEL_UNKNOWN("\u672a\u77e5\u6e20\u9053", 0),
    CHANNEL_QQ_KAN_DIAN("QQ\u770b\u70b9", 1),
    CHANNEL_QQ_LITTLE_WORLD("QQ\u77ed\u89c6\u9891", 2),
    CHANNEL_QQ_CHANNEL(SoLoad.BIZ_TRTC_QQCHANNEL, 3),
    CHANNEL_QQ_SHOW("\u8d85\u7ea7QQ\u79c0", 4),
    CHANNEL_QQ_ECOMMERCE_BASE("QQ\u7535\u5546\u57fa\u7840\u5165\u53e3", 5),
    CHANNEL_QQ_GROUP("QQ\u7fa4", 6),
    CHANNEL_QQ_ZONE("QQ\u7a7a\u95f4", 7),
    CHANNEL_QQ_LIVE("QQ\u76f4\u64ad", 8),
    CHANNEL_QQ_ECOMMERCE_SERVICE_NOTIFY("\u7535\u5546\u670d\u52a1\u901a\u77e5\u5165\u53e3", 9),
    CHANNEL_AMS_ADVERTISEMENT("AMS\u7adf\u4ef7\u5e7f\u544a", 101),
    CHANNEL_QQ_VIP("QQ\u4f1a\u5458", 1001);


    @NotNull
    private final String channelName;
    private final int id;

    QQECChannel(String str, int i3) {
        this.channelName = str;
        this.id = i3;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    public final int getId() {
        return this.id;
    }
}

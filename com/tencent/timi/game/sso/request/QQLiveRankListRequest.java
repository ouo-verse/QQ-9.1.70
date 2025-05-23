package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import d55.i;
import d55.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0016B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveRankListRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "roomID", "J", "anchorID", "", "requestListSize", "I", "<init>", "(JJI)V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveRankListRequest<T> extends LiveBaseRequest<T> {
    public static final int DEFAULT = 0;
    public static final int ONLINE = 1;

    @NotNull
    public static final String TAG = "VSRequest|QQLiveRankListRequest";
    private final long anchorID;
    private final int requestListSize;
    private final long roomID;

    public QQLiveRankListRequest(long j3, long j16, int i3) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        this.roomID = j3;
        this.anchorID = j16;
        this.requestListSize = i3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) j.c(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e(TAG, "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.rank_list_svr.RankListSvr";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        i iVar = new i();
        iVar.f393082a = this.roomID;
        iVar.f393083b = this.anchorID;
        iVar.f393085d = this.requestListSize;
        iVar.f393084c = 1;
        iVar.f393086e = true;
        return iVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "RankListForNative";
    }
}

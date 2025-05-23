package com.tencent.icgame.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import ty0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/icgame/game/sso/request/QQLiveReportRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "roomId", "", "reporterUid", "reporteeUid", "reason", "", "(JJJLjava/lang/String;)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getMainCmd", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getSubCmd", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class QQLiveReportRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    private final String reason;
    private final long reporteeUid;
    private final long reporterUid;
    private final long roomId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveReportRequest(long j3, long j16, long j17, @NotNull String reason) {
        super("1078");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.roomId = j3;
        this.reporterUid = j16;
        this.reporteeUid = j17;
        this.reason = reason;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) b.c(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            a.INSTANCE.i("ICGameVSRequest|QQLiveReportRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.qlive_report.Report";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        ty0.a aVar = new ty0.a();
        long j3 = this.roomId;
        aVar.f437895e = j3;
        aVar.f437891a = this.reporterUid;
        aVar.f437893c = this.reporteeUid;
        aVar.f437896f = j3;
        aVar.f437897g = d32.a.INSTANCE.a("1078").a().getClientType();
        aVar.f437898h = this.reason;
        return aVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "Report";
    }
}

package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository;

import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "()Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "c", "I", "getResultCode", "()I", QzoneIPCModule.RESULT_CODE, "d", "Ljava/lang/String;", "getResultMsg", "()Ljava/lang/String;", "resultMsg", "<init>", "(ZLcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;ILjava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.b, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerSignalPublishResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final SignalPlazaSvrPB$SignalInfo signalInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resultCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String resultMsg;

    public QQStrangerSignalPublishResult(boolean z16, SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, int i3, String resultMsg) {
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        this.isSuccess = z16;
        this.signalInfo = signalPlazaSvrPB$SignalInfo;
        this.resultCode = i3;
        this.resultMsg = resultMsg;
    }

    /* renamed from: a, reason: from getter */
    public final SignalPlazaSvrPB$SignalInfo getSignalInfo() {
        return this.signalInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo = this.signalInfo;
        return ((((i3 + (signalPlazaSvrPB$SignalInfo == null ? 0 : signalPlazaSvrPB$SignalInfo.hashCode())) * 31) + this.resultCode) * 31) + this.resultMsg.hashCode();
    }

    public String toString() {
        return "QQStrangerSignalPublishResult(isSuccess=" + this.isSuccess + ", signalInfo=" + this.signalInfo + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerSignalPublishResult)) {
            return false;
        }
        QQStrangerSignalPublishResult qQStrangerSignalPublishResult = (QQStrangerSignalPublishResult) other;
        return this.isSuccess == qQStrangerSignalPublishResult.isSuccess && Intrinsics.areEqual(this.signalInfo, qQStrangerSignalPublishResult.signalInfo) && this.resultCode == qQStrangerSignalPublishResult.resultCode && Intrinsics.areEqual(this.resultMsg, qQStrangerSignalPublishResult.resultMsg);
    }

    public /* synthetic */ QQStrangerSignalPublishResult(boolean z16, SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i16 & 2) != 0 ? null : signalPlazaSvrPB$SignalInfo, (i16 & 4) != 0 ? -1 : i3, (i16 & 8) != 0 ? "" : str);
    }
}

package pl2;

import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lpl2/d;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Rsp", "Lpl2/o;", "rsp", "", "onSuccess", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "", "errCode", "", "errMsg", "onFail", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d<Rsp extends MessageMicro<Rsp>> implements o<Rsp> {
    @Override // pl2.k
    public void onFail(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
    }

    @Override // pl2.k
    public void onSuccess(@NotNull Rsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
    }
}

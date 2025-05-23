package pl2;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lpl2/o;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Rsp", "Lpl2/k;", "rsp", "", "onSuccess", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
@MainThread
/* loaded from: classes16.dex */
public interface o<Rsp extends MessageMicro<Rsp>> extends k<Rsp> {
    void onSuccess(@NotNull Rsp rsp);
}

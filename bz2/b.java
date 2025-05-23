package bz2;

import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u0010"}, d2 = {"Lbz2/b;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "", "returnCode", "rsp", "", "b", "(ILcom/tencent/mobileqq/pb/MessageMicro;)V", "code", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface b<T extends MessageMicro<T>> {
    void a(int code, @NotNull String errMsg, @Nullable Throwable e16);

    void b(int returnCode, @NotNull T rsp);
}

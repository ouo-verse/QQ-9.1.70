package gq0;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lgq0/a;", "Lgq0/d;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsg", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msg;

    public a(@NotNull MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2;
    }

    @Override // gq0.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public MsgRecord getMsg() {
        return this.msg;
    }

    @Override // gq0.d
    public int b() {
        return 3;
    }
}

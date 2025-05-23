package nq0;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lnq0/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "I", "()I", "downloadType", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int downloadType;

    public a(@NotNull MsgRecord msgRecord, int i3) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        this.msgRecord = msgRecord;
        this.downloadType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getDownloadType() {
        return this.downloadType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MsgRecord getMsgRecord() {
        return this.msgRecord;
    }
}

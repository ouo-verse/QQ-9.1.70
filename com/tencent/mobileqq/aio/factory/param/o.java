package com.tencent.mobileqq.aio.factory.param;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/o;", "", "", "e", "Lcom/tencent/mobileqq/aio/factory/param/o$a;", "listener", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/o$a;", "", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "", "needContinueGetMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "remainMsgList", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
        void a(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, boolean needContinueGetMsg, @NotNull List<MsgRecord> remainMsgList);
    }

    void a(@NotNull a listener);

    boolean e();
}

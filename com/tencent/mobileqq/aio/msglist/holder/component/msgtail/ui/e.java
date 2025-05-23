package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui;

import com.tencent.qqnt.aio.emoreply.h;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "", "", "emojiId", "emojiType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lcom/tencent/qqnt/aio/emoreply/h;", "emoReplyAnimationInfo", "", "V", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/b;", "emojiItem", "Lkotlin/Function0;", "", "updateUI", "e0", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface e {
    boolean V(int emojiId, int emojiType, @NotNull MsgRecord msg2, @Nullable h emoReplyAnimationInfo);

    boolean e0(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b emojiItem, @Nullable h emoReplyAnimationInfo, @NotNull Function0<Unit> updateUI);
}

package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "from", "", "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e {
    public static final void a(@NotNull c cVar, @NotNull MsgList msgList, @NotNull String from) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(from, "from");
        MsgListRepo G = cVar.d().G();
        if (G instanceof AIOMsgRepo) {
            BaseMsgRepo.o0((BaseMsgRepo) G, msgList, from, null, null, 12, null);
        } else {
            G.d(IMsgListRepository.MsgListRepoOpType.OtherOperation, msgList, null);
        }
    }
}

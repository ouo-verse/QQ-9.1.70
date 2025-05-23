package com.tencent.guild.aio.component.combinestyle;

import androidx.annotation.CallSuper;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0017\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/r;", "Lcom/tencent/aio/api/list/b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "", "position", "", "", "payloads", "", "j", "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class r extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {
    private final boolean m(com.tencent.aio.data.msglist.a msgItem) {
        int viewType = msgItem.getViewType();
        com.tencent.mobileqq.guild.message.a aVar = com.tencent.mobileqq.guild.message.a.f230108a;
        if (viewType != aVar.c() && msgItem.getViewType() != aVar.b()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.list.b
    @CallSuper
    public void j(@NotNull com.tencent.aio.data.msglist.a data, int position, @NotNull List<Object> payloads) {
        boolean z16;
        List mutableList;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (m(data)) {
            z16 = UIUtil.f112434a.y((com.tencent.aio.api.runtime.a) getMContext());
        } else {
            z16 = false;
        }
        GuildMultiMsgManager.MultiSelectMode multiSelectMode = new GuildMultiMsgManager.MultiSelectMode(z16);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) new ArrayList(payloads));
        mutableList.add(multiSelectMode);
        updateUI(new MsgListItemState(data, position, mutableList));
    }
}

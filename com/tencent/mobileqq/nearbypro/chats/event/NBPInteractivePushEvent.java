package com.tencent.mobileqq.nearbypro.chats.event;

import ca2.ChatsListInteractiveEntryModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/event/NBPInteractivePushEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lca2/a;", "model", "Lca2/a;", "getModel", "()Lca2/a;", "", "unreadNum", "I", "getUnreadNum", "()I", "<init>", "(Lca2/a;I)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPInteractivePushEvent extends SimpleBaseEvent {

    @NotNull
    private final ChatsListInteractiveEntryModel model;
    private final int unreadNum;

    public NBPInteractivePushEvent(@NotNull ChatsListInteractiveEntryModel model, int i3) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        this.unreadNum = i3;
    }

    @NotNull
    public final ChatsListInteractiveEntryModel getModel() {
        return this.model;
    }

    public final int getUnreadNum() {
        return this.unreadNum;
    }
}

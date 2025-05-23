package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\u0002\u0010\u0006R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerInteractiveMarkUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tinyIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getTinyIdList", "()Ljava/util/ArrayList;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerInteractiveMarkUpdateEvent extends SimpleBaseEvent {
    private final ArrayList<String> tinyIdList;

    public QQStrangerInteractiveMarkUpdateEvent(ArrayList<String> tinyIdList) {
        Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
        this.tinyIdList = tinyIdList;
    }

    public final ArrayList<String> getTinyIdList() {
        return this.tinyIdList;
    }
}

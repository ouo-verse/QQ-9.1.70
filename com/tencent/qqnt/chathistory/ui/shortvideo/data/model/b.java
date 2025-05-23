package com.tencent.qqnt.chathistory.ui.shortvideo.data.model;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/b;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "", "d", "J", "a", "()J", "msgTime", "<init>", "(J)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends com.tencent.qqnt.chathistory.ui.base.item.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long msgTime;

    public b(long j3) {
        this.msgTime = j3;
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.i
    /* renamed from: a, reason: from getter */
    public long getMsgTime() {
        return this.msgTime;
    }
}

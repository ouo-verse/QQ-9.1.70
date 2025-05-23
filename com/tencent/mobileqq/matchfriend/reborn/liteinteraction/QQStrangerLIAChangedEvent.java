package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/QQStrangerLIAChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "contactList", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "(Ljava/util/List;)V", "getContactList", "()Ljava/util/List;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerLIAChangedEvent extends SimpleBaseEvent {
    private final List<Contact> contactList;

    public QQStrangerLIAChangedEvent(List<Contact> contactList) {
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        this.contactList = contactList;
    }

    public final List<Contact> getContactList() {
        return this.contactList;
    }
}

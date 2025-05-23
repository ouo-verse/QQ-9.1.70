package com.tencent.mobileqq.friend.contact.api.impl;

import com.tencent.mobileqq.friend.contact.ContactDragRefreshViewWrap;
import com.tencent.mobileqq.friend.contact.ContactRefreshViewWrap;
import com.tencent.mobileqq.friend.contact.api.IContactApi;
import kotlin.Metadata;
import wc1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/friend/contact/api/impl/ContactApiImpl;", "Lcom/tencent/mobileqq/friend/contact/api/IContactApi;", "Ljava/lang/Class;", "Lwc1/a;", "getContactRefreshViewWrapClass", "getContactDragRefreshViewWrapClass", "<init>", "()V", "Companion", "a", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ContactApiImpl implements IContactApi {
    public static final String TAG = "ContactApiImpl";

    @Override // com.tencent.mobileqq.friend.contact.api.IContactApi
    public Class<? extends a> getContactDragRefreshViewWrapClass() {
        return ContactDragRefreshViewWrap.class;
    }

    @Override // com.tencent.mobileqq.friend.contact.api.IContactApi
    public Class<? extends a> getContactRefreshViewWrapClass() {
        return ContactRefreshViewWrap.class;
    }
}

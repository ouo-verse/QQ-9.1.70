package com.tencent.aio.stranger.api.impl;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerAssistantAdapterApiImpl;", "Lcom/tencent/aio/stranger/api/IStrangerAssistantAdapterApi;", "()V", "getMiniCardAppId", "", "isLittleAssistant", "", "contact", "Lcom/tencent/aio/data/AIOContact;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class StrangerAssistantAdapterApiImpl implements IStrangerAssistantAdapterApi {
    @Override // com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi
    public String getMiniCardAppId() {
        return "com.tencent.mobileqq.qqstranger.minicard";
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi
    public boolean isLittleAssistant(AIOContact contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        return (contact.e() == 104 && Intrinsics.areEqual(contact.j(), "144115227025205148")) || (contact.e() == 119 && Intrinsics.areEqual(contact.j(), "144115219935613893"));
    }
}

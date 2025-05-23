package com.tencent.mobileqq.aio.utils;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOSession;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/data/AIOContact;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "b", "Lcom/tencent/aio/data/AIOSession;", "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class o {
    @NotNull
    public static final Contact a(@NotNull AIOSession aIOSession) {
        Intrinsics.checkNotNullParameter(aIOSession, "<this>");
        return b(aIOSession.c());
    }

    @NotNull
    public static final Contact b(@NotNull AIOContact aIOContact) {
        Intrinsics.checkNotNullParameter(aIOContact, "<this>");
        return new Contact(aIOContact.e(), aIOContact.j(), aIOContact.f());
    }
}

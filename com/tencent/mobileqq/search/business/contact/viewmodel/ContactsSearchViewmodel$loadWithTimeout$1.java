package com.tencent.mobileqq.search.business.contact.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel", f = "ContactsSearchViewmodel.kt", i = {0, 0}, l = {218}, m = "loadWithTimeout", n = {"keyword", "logTag"}, s = {"L$0", "L$1"})
/* loaded from: classes18.dex */
public final class ContactsSearchViewmodel$loadWithTimeout$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContactsSearchViewmodel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsSearchViewmodel$loadWithTimeout$1(ContactsSearchViewmodel contactsSearchViewmodel, Continuation<? super ContactsSearchViewmodel$loadWithTimeout$1> continuation) {
        super(continuation);
        this.this$0 = contactsSearchViewmodel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object i26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i26 = this.this$0.i2(null, null, null, null, null, this);
        return i26;
    }
}

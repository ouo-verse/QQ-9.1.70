package com.tencent.mobileqq.search.business.contact.viewmodel;

import com.tencent.mobileqq.search.business.contact.entity.ContactsSearchItemData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredPhoneContact$1", f = "ContactsSearchViewmodel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredPhoneContact$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ContactsSearchItemData>>, Object> {
    final /* synthetic */ String $keyword;
    int label;
    final /* synthetic */ ContactsSearchViewmodel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredPhoneContact$1(ContactsSearchViewmodel contactsSearchViewmodel, String str, Continuation<? super ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredPhoneContact$1> continuation) {
        super(2, continuation);
        this.this$0 = contactsSearchViewmodel;
        this.$keyword = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredPhoneContact$1(this.this$0, this.$keyword, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ContactsSearchItemData>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<ContactsSearchItemData>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List h26;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            h26 = this.this$0.h2(this.$keyword);
            return h26;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<ContactsSearchItemData>> continuation) {
        return ((ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredPhoneContact$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

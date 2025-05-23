package com.tencent.mobileqq.search.business.contact.viewmodel;

import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.search.business.contact.entity.ContactsSearchItemData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1", f = "ContactsSearchViewmodel.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ContactsSearchItemData>>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ IPerformanceReportTask $reportLoadContactsTask;
    int label;
    final /* synthetic */ ContactsSearchViewmodel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        AnonymousClass1(Object obj) {
            super(0, obj, ContactsSearchViewmodel.class, "shouldRequestContacts", "shouldRequestContacts()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            boolean m26;
            m26 = ((ContactsSearchViewmodel) this.receiver).m2();
            return Boolean.valueOf(m26);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3<String, IPerformanceReportTask, Continuation<? super List<? extends ContactsSearchItemData>>, Object>, SuspendFunction {
        AnonymousClass2(Object obj) {
            super(3, obj, ContactsSearchRepo.class, "loadContacts", "loadContacts(Ljava/lang/String;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(String str, IPerformanceReportTask iPerformanceReportTask, Continuation<? super List<? extends ContactsSearchItemData>> continuation) {
            return invoke2(str, iPerformanceReportTask, (Continuation<? super List<ContactsSearchItemData>>) continuation);
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull String str, @NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull Continuation<? super List<ContactsSearchItemData>> continuation) {
            return ((ContactsSearchRepo) this.receiver).e(str, iPerformanceReportTask, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1(ContactsSearchViewmodel contactsSearchViewmodel, String str, IPerformanceReportTask iPerformanceReportTask, Continuation<? super ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1> continuation) {
        super(2, continuation);
        this.this$0 = contactsSearchViewmodel;
        this.$keyword = str;
        this.$reportLoadContactsTask = iPerformanceReportTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1(this.this$0, this.$keyword, this.$reportLoadContactsTask, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ContactsSearchItemData>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<ContactsSearchItemData>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ContactsSearchRepo d26;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ContactsSearchViewmodel contactsSearchViewmodel = this.this$0;
            String str = this.$keyword;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            IPerformanceReportTask iPerformanceReportTask = this.$reportLoadContactsTask;
            d26 = this.this$0.d2();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(d26);
            this.label = 1;
            obj = contactsSearchViewmodel.i2(str, anonymousClass1, iPerformanceReportTask, anonymousClass2, "contacts", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<ContactsSearchItemData>> continuation) {
        return ((ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

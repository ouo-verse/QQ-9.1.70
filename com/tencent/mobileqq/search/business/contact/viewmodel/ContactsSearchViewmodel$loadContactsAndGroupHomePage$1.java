package com.tencent.mobileqq.search.business.contact.viewmodel;

import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.search.business.contact.entity.ContactsSearchItemData;
import com.tencent.mobileqq.search.business.contact.i;
import com.tencent.mobileqq.search.business.contact.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel$loadContactsAndGroupHomePage$1", f = "ContactsSearchViewmodel.kt", i = {0, 1, 1, 2}, l = {73, 91, 95, 97, 104}, m = "invokeSuspend", n = {"$this$qLaunch", "deferredTroop", "deferredPhoneContact", "deferredTroop"}, s = {"L$0", "L$0", "L$1", "L$0"})
/* loaded from: classes18.dex */
public final class ContactsSearchViewmodel$loadContactsAndGroupHomePage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    final /* synthetic */ String $keyword;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ContactsSearchViewmodel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsSearchViewmodel$loadContactsAndGroupHomePage$1(long j3, ContactsSearchViewmodel contactsSearchViewmodel, String str, Continuation<? super ContactsSearchViewmodel$loadContactsAndGroupHomePage$1> continuation) {
        super(2, continuation);
        this.$delayTime = j3;
        this.this$0 = contactsSearchViewmodel;
        this.$keyword = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ContactsSearchViewmodel$loadContactsAndGroupHomePage$1 contactsSearchViewmodel$loadContactsAndGroupHomePage$1 = new ContactsSearchViewmodel$loadContactsAndGroupHomePage$1(this.$delayTime, this.this$0, this.$keyword, continuation);
        contactsSearchViewmodel$loadContactsAndGroupHomePage$1.L$0 = obj;
        return contactsSearchViewmodel$loadContactsAndGroupHomePage$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0138 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0120 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        Object await;
        Deferred deferred;
        Deferred deferred2;
        List list;
        List list2;
        Object await2;
        List list3;
        Object await3;
        List list4;
        List list5;
        List list6;
        List list7;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        await3 = obj;
                        list4 = this.this$0.troopsResult;
                        list4.clear();
                        list5 = this.this$0.troopsResult;
                        ContactsSearchViewmodel contactsSearchViewmodel = this.this$0;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : (List) await3) {
                            if (i.c(contactsSearchViewmodel, (ContactsSearchItemData) obj2)) {
                                arrayList.add(obj2);
                            }
                        }
                        list5.addAll(arrayList);
                        list6 = this.this$0.troopsResult;
                        int size = list6.size();
                        list7 = this.this$0.buddiesResult;
                        j.a(size + list7.size());
                        j.b(true);
                        this.this$0.Z1().setValue(Boxing.boxBoolean(true));
                        this.this$0.j2(true);
                        this.label = 5;
                        if (DelayKt.delay(200L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    deferred2 = (Deferred) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    await2 = obj;
                    list3 = this.this$0.buddiesResult;
                    list3.addAll((List) await2);
                    this.L$0 = null;
                    this.label = 4;
                    await3 = deferred2.await(this);
                    if (await3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list4 = this.this$0.troopsResult;
                    list4.clear();
                    list5 = this.this$0.troopsResult;
                    ContactsSearchViewmodel contactsSearchViewmodel2 = this.this$0;
                    ArrayList arrayList2 = new ArrayList();
                    while (r2.hasNext()) {
                    }
                    list5.addAll(arrayList2);
                    list6 = this.this$0.troopsResult;
                    int size2 = list6.size();
                    list7 = this.this$0.buddiesResult;
                    j.a(size2 + list7.size());
                    j.b(true);
                    this.this$0.Z1().setValue(Boxing.boxBoolean(true));
                    this.this$0.j2(true);
                    this.label = 5;
                    if (DelayKt.delay(200L, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                Deferred deferred3 = (Deferred) this.L$1;
                Deferred deferred4 = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
                deferred = deferred3;
                deferred2 = deferred4;
                await = obj;
                list = this.this$0.buddiesResult;
                list.clear();
                list2 = this.this$0.buddiesResult;
                ContactsSearchViewmodel contactsSearchViewmodel3 = this.this$0;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : (List) await) {
                    if (i.b(contactsSearchViewmodel3, (ContactsSearchItemData) obj3)) {
                        arrayList3.add(obj3);
                    }
                }
                list2.addAll(arrayList3);
                this.L$0 = deferred2;
                this.L$1 = null;
                this.label = 3;
                await2 = deferred.await(this);
                if (await2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list3 = this.this$0.buddiesResult;
                list3.addAll((List) await2);
                this.L$0 = null;
                this.label = 4;
                await3 = deferred2.await(this);
                if (await3 == coroutine_suspended) {
                }
                list4 = this.this$0.troopsResult;
                list4.clear();
                list5 = this.this$0.troopsResult;
                ContactsSearchViewmodel contactsSearchViewmodel22 = this.this$0;
                ArrayList arrayList22 = new ArrayList();
                while (r2.hasNext()) {
                }
                list5.addAll(arrayList22);
                list6 = this.this$0.troopsResult;
                int size22 = list6.size();
                list7 = this.this$0.buddiesResult;
                j.a(size22 + list7.size());
                j.b(true);
                this.this$0.Z1().setValue(Boxing.boxBoolean(true));
                this.this$0.j2(true);
                this.label = 5;
                if (DelayKt.delay(200L, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            long j3 = this.$delayTime;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.o2();
        this.this$0.q2();
        IPerformanceReportTask stageCode = Reporters.f231995a.c().a("search_friend_selector_request_quality").setStageCode("search_local_buddy_cost");
        IPerformanceReportTask stageCode2 = stageCode.duplicate(new String[0]).setStageCode("search_local_group_cost");
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredContact$1(this.this$0, this.$keyword, stageCode, null), 3, null);
        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredTroop$1(this.this$0, this.$keyword, stageCode2, null), 3, null);
        async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new ContactsSearchViewmodel$loadContactsAndGroupHomePage$1$deferredPhoneContact$1(this.this$0, this.$keyword, null), 2, null);
        this.L$0 = async$default2;
        this.L$1 = async$default3;
        this.label = 2;
        await = async$default.await(this);
        if (await == coroutine_suspended) {
            return coroutine_suspended;
        }
        deferred = async$default3;
        deferred2 = async$default2;
        list = this.this$0.buddiesResult;
        list.clear();
        list2 = this.this$0.buddiesResult;
        ContactsSearchViewmodel contactsSearchViewmodel32 = this.this$0;
        ArrayList arrayList32 = new ArrayList();
        while (r6.hasNext()) {
        }
        list2.addAll(arrayList32);
        this.L$0 = deferred2;
        this.L$1 = null;
        this.label = 3;
        await2 = deferred.await(this);
        if (await2 == coroutine_suspended) {
        }
        list3 = this.this$0.buddiesResult;
        list3.addAll((List) await2);
        this.L$0 = null;
        this.label = 4;
        await3 = deferred2.await(this);
        if (await3 == coroutine_suspended) {
        }
        list4 = this.this$0.troopsResult;
        list4.clear();
        list5 = this.this$0.troopsResult;
        ContactsSearchViewmodel contactsSearchViewmodel222 = this.this$0;
        ArrayList arrayList222 = new ArrayList();
        while (r2.hasNext()) {
        }
        list5.addAll(arrayList222);
        list6 = this.this$0.troopsResult;
        int size222 = list6.size();
        list7 = this.this$0.buddiesResult;
        j.a(size222 + list7.size());
        j.b(true);
        this.this$0.Z1().setValue(Boxing.boxBoolean(true));
        this.this$0.j2(true);
        this.label = 5;
        if (DelayKt.delay(200L, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ContactsSearchViewmodel$loadContactsAndGroupHomePage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

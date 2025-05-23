package com.tencent.ecommerce.biz.aftersale.viewmodel;

import cg0.a;
import com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import com.tencent.ecommerce.biz.comment.UploadFailedException;
import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyRepo;
import com.tencent.ecommerce.repo.aftersale.apply.PageType;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.e;
import ih0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel$submitApplyPageData$1", f = "ECAfterSaleApplyViewModel.kt", i = {0, 1, 2}, l = {126, 128, 141}, m = "invokeSuspend", n = {"extraItem", "extraItem", "extraItem"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECAfterSaleApplyViewModel$submitApplyPageData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $afterSalesId;
    final /* synthetic */ String $orderId;
    final /* synthetic */ PageType $pageType;
    final /* synthetic */ String $processId;
    final /* synthetic */ String $skuId;
    Object L$0;
    int label;
    final /* synthetic */ ECAfterSaleApplyViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAfterSaleApplyViewModel$submitApplyPageData$1(ECAfterSaleApplyViewModel eCAfterSaleApplyViewModel, PageType pageType, String str, String str2, String str3, String str4, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAfterSaleApplyViewModel;
        this.$pageType = pageType;
        this.$orderId = str;
        this.$afterSalesId = str2;
        this.$processId = str3;
        this.$skuId = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAfterSaleApplyViewModel$submitApplyPageData$1(this.this$0, this.$pageType, this.$orderId, this.$afterSalesId, this.$processId, this.$skuId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAfterSaleApplyViewModel$submitApplyPageData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0166 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0167  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        List list;
        MutableStateFlow mutableStateFlow2;
        ArrayList arrayList;
        Object firstOrNull;
        ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem;
        List list2;
        List list3;
        ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem2;
        BatchUploader batchUploader;
        Object t16;
        ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem3;
        MutableStateFlow mutableStateFlow3;
        ArrayList arrayList2;
        Iterator it;
        Object obj2;
        MutableStateFlow mutableStateFlow4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            eCAfterSaleApplyExtraItem3 = (ECAfterSaleApplyExtraItem) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                mutableStateFlow4 = this.this$0._uiState;
                                mutableStateFlow4.setValue(ECAfterSaleApplyViewModel.c.h.f101326a);
                            } else {
                                mutableStateFlow3 = this.this$0._uiState;
                                mutableStateFlow3.setValue(new ECAfterSaleApplyViewModel.c.f(ECAfterSaleApplyViewModel.b.C1038b.f101318a));
                            }
                            arrayList2 = this.this$0._liveApplyItemList;
                            ArrayList arrayList3 = new ArrayList();
                            for (Object obj3 : arrayList2) {
                                if (obj3 instanceof e) {
                                    arrayList3.add(obj3);
                                }
                            }
                            it = arrayList3.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it.next();
                                if (Boxing.boxBoolean(((e) obj2).getOptionInfo().getKey() == 1).booleanValue()) {
                                    break;
                                }
                            }
                            b.f407641a.d(this.$pageType, this.$orderId, (e) obj2, eCAfterSaleApplyExtraItem3);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    eCAfterSaleApplyExtraItem2 = (ECAfterSaleApplyExtraItem) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    List<String> list4 = (List) obj;
                    a.b("ECAfterSaleApplyViewModel", "submitApplyPageData uploadImages finish, imageUrls:" + list4);
                    if (eCAfterSaleApplyExtraItem2 != null) {
                        eCAfterSaleApplyExtraItem2.f(list4);
                    }
                    eCAfterSaleApplyExtraItem = eCAfterSaleApplyExtraItem2;
                    ECAfterSaleApplyRepo eCAfterSaleApplyRepo = ECAfterSaleApplyRepo.f104899h;
                    PageType pageType = this.$pageType;
                    String str = this.$orderId;
                    String str2 = this.$skuId;
                    String str3 = this.$afterSalesId;
                    String str4 = this.$processId;
                    this.L$0 = eCAfterSaleApplyExtraItem;
                    this.label = 3;
                    t16 = eCAfterSaleApplyRepo.t(pageType, str, str2, str3, str4, eCAfterSaleApplyExtraItem, this);
                    if (t16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCAfterSaleApplyExtraItem3 = eCAfterSaleApplyExtraItem;
                    obj = t16;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    arrayList2 = this.this$0._liveApplyItemList;
                    ArrayList arrayList32 = new ArrayList();
                    while (r15.hasNext()) {
                    }
                    it = arrayList32.iterator();
                    while (true) {
                        if (it.hasNext()) {
                        }
                    }
                    b.f407641a.d(this.$pageType, this.$orderId, (e) obj2, eCAfterSaleApplyExtraItem3);
                    return Unit.INSTANCE;
                }
                eCAfterSaleApplyExtraItem2 = (ECAfterSaleApplyExtraItem) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("submitApplyPageData pageType:");
                sb5.append(this.$pageType);
                sb5.append(", orderId:");
                sb5.append(this.$orderId);
                sb5.append(',');
                sb5.append(" afterSalesId:");
                sb5.append(this.$afterSalesId);
                sb5.append(", processId:");
                sb5.append(this.$processId);
                sb5.append(", mediaList:");
                list = this.this$0.mediaInfos;
                sb5.append(list);
                a.b("ECAfterSaleApplyViewModel", sb5.toString());
                mutableStateFlow2 = this.this$0._uiState;
                mutableStateFlow2.setValue(ECAfterSaleApplyViewModel.c.g.f101325a);
                arrayList = this.this$0._liveApplyItemList;
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : arrayList) {
                    if (obj4 instanceof ECAfterSaleApplyExtraItem) {
                        arrayList4.add(obj4);
                    }
                }
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList4);
                eCAfterSaleApplyExtraItem = (ECAfterSaleApplyExtraItem) firstOrNull;
                list2 = this.this$0.mediaInfos;
                if (!list2.isEmpty()) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("submitApplyPageData start uploadImages, source mediaList:");
                    list3 = this.this$0.mediaInfos;
                    sb6.append(list3);
                    a.b("ECAfterSaleApplyViewModel", sb6.toString());
                    ECAfterSaleApplyViewModel eCAfterSaleApplyViewModel = this.this$0;
                    this.L$0 = eCAfterSaleApplyExtraItem;
                    this.label = 1;
                    if (eCAfterSaleApplyViewModel.b2(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCAfterSaleApplyExtraItem2 = eCAfterSaleApplyExtraItem;
                }
                ECAfterSaleApplyRepo eCAfterSaleApplyRepo2 = ECAfterSaleApplyRepo.f104899h;
                PageType pageType2 = this.$pageType;
                String str5 = this.$orderId;
                String str22 = this.$skuId;
                String str32 = this.$afterSalesId;
                String str42 = this.$processId;
                this.L$0 = eCAfterSaleApplyExtraItem;
                this.label = 3;
                t16 = eCAfterSaleApplyRepo2.t(pageType2, str5, str22, str32, str42, eCAfterSaleApplyExtraItem, this);
                if (t16 == coroutine_suspended) {
                }
            }
            batchUploader = this.this$0.batchUploader;
            this.L$0 = eCAfterSaleApplyExtraItem2;
            this.label = 2;
            obj = batchUploader.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            List<String> list42 = (List) obj;
            a.b("ECAfterSaleApplyViewModel", "submitApplyPageData uploadImages finish, imageUrls:" + list42);
            if (eCAfterSaleApplyExtraItem2 != null) {
            }
            eCAfterSaleApplyExtraItem = eCAfterSaleApplyExtraItem2;
            ECAfterSaleApplyRepo eCAfterSaleApplyRepo22 = ECAfterSaleApplyRepo.f104899h;
            PageType pageType22 = this.$pageType;
            String str52 = this.$orderId;
            String str222 = this.$skuId;
            String str322 = this.$afterSalesId;
            String str422 = this.$processId;
            this.L$0 = eCAfterSaleApplyExtraItem;
            this.label = 3;
            t16 = eCAfterSaleApplyRepo22.t(pageType22, str52, str222, str322, str422, eCAfterSaleApplyExtraItem, this);
            if (t16 == coroutine_suspended) {
            }
        } catch (UploadFailedException e16) {
            mutableStateFlow = this.this$0._uiState;
            mutableStateFlow.setValue(new ECAfterSaleApplyViewModel.c.f(ECAfterSaleApplyViewModel.b.a.f101317a));
            a.a("ECAfterSaleApplyViewModel", "submitApplyPageData", "UploadFailedException e:" + e16);
            return Unit.INSTANCE;
        }
    }
}

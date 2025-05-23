package com.tencent.mobileqq.troop.troopsquare.topic.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.topic.vm.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GetTopicPageRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareBannerItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareGroupInfoItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel$loadData$2$1", f = "TroopSquareTopicViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopSquareTopicViewModel$loadData$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $errCode;
    final /* synthetic */ String $errMsg;
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ GetTopicPageRsp $result;
    int label;
    final /* synthetic */ TroopSquareTopicViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSquareTopicViewModel$loadData$2$1(TroopSquareTopicViewModel troopSquareTopicViewModel, int i3, boolean z16, GetTopicPageRsp getTopicPageRsp, String str, Continuation<? super TroopSquareTopicViewModel$loadData$2$1> continuation) {
        super(2, continuation);
        this.this$0 = troopSquareTopicViewModel;
        this.$errCode = i3;
        this.$isLoadMore = z16;
        this.$result = getTopicPageRsp;
        this.$errMsg = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopSquareTopicViewModel, Integer.valueOf(i3), Boolean.valueOf(z16), getTopicPageRsp, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopSquareTopicViewModel$loadData$2$1(this.this$0, this.$errCode, this.$isLoadMore, this.$result, this.$errMsg, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        ArrayList arrayList;
        MutableLiveData mUiState;
        ArrayList arrayList2;
        int collectionSizeOrDefault;
        MutableLiveData mUiState2;
        MutableLiveData mUiState3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.isRequesting = false;
                TroopSquareTopicViewModel troopSquareTopicViewModel = this.this$0;
                boolean z16 = this.$isLoadMore;
                int i3 = this.$errCode;
                String str2 = this.$errMsg;
                GetTopicPageRsp getTopicPageRsp = this.$result;
                long Z1 = troopSquareTopicViewModel.Z1();
                long S1 = troopSquareTopicViewModel.S1();
                str = troopSquareTopicViewModel.requestCookies;
                QLog.i("TroopSquare.Topic.TroopSquareTopicViewModel", 1, "loadData getTopicPage " + Z1 + "-" + S1 + "-" + str + ", isLoadMore:" + z16 + ", result:" + i3 + "-" + str2 + ", size:" + getTopicPageRsp.groupList.size() + " isEnd:" + getTopicPageRsp.isEnd);
                if (this.$errCode != 0) {
                    mUiState3 = this.this$0.getMUiState();
                    mUiState3.setValue(new a.C8831a(this.$isLoadMore));
                    return Unit.INSTANCE;
                }
                TroopSquareTopicViewModel troopSquareTopicViewModel2 = this.this$0;
                String str3 = this.$result.cookies;
                Intrinsics.checkNotNullExpressionValue(str3, "result.cookies");
                troopSquareTopicViewModel2.requestCookies = str3;
                if (!this.$isLoadMore) {
                    mUiState2 = this.this$0.getMUiState();
                    GroupSquareBannerItem groupSquareBannerItem = this.$result.bannerInfo;
                    Intrinsics.checkNotNullExpressionValue(groupSquareBannerItem, "result.bannerInfo");
                    mUiState2.setValue(new a.c(groupSquareBannerItem));
                }
                arrayList = this.this$0.groupList;
                arrayList.addAll(this.$result.groupList);
                mUiState = this.this$0.getMUiState();
                arrayList2 = this.this$0.groupList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(new com.tencent.mobileqq.troop.troopsquare.data.a((GroupSquareGroupInfoItem) it.next()));
                }
                mUiState.setValue(new a.b(arrayList3, !this.$result.isEnd));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopSquareTopicViewModel$loadData$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

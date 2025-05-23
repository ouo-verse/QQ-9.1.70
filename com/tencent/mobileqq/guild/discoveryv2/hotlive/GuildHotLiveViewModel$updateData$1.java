package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.utils.NetworkUtil;
import gi1.EmptyPageData;
import gi1.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveViewModel$updateData$1", f = "GuildHotLiveViewModel.kt", i = {}, l = {62, 77}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHotLiveViewModel$updateData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildHotLiveViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveViewModel$updateData$1$1", f = "GuildHotLiveViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveViewModel$updateData$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $fetchResult;
        int label;
        final /* synthetic */ GuildHotLiveViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GuildHotLiveViewModel guildHotLiveViewModel, g gVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = guildHotLiveViewModel;
            this.$fetchResult = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$fetchResult, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            MutableLiveData mutableLiveData;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                mutableLiveData = this.this$0._pageDataLiveData;
                List<gi1.a> e16 = j.e(this.$fetchResult.c(), this.$fetchResult.getTraceId());
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : e16) {
                    if (hashSet.add(Boxing.boxLong(((gi1.a) obj2).getChannelId()))) {
                        arrayList.add(obj2);
                    }
                }
                mutableLiveData.postValue(arrayList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHotLiveViewModel$updateData$1(GuildHotLiveViewModel guildHotLiveViewModel, Continuation<? super GuildHotLiveViewModel$updateData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildHotLiveViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildHotLiveViewModel$updateData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        cn cnVar;
        MutableLiveData mutableLiveData;
        List listOf;
        cn cnVar2;
        MutableLiveData mutableLiveData2;
        List listOf2;
        MutableLiveData mutableLiveData3;
        List listOf3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0.isLoading = true;
            GuildHotLiveViewModel guildHotLiveViewModel = this.this$0;
            this.label = 1;
            obj = guildHotLiveViewModel.Z1(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        g gVar = (g) obj;
        cnVar = this.this$0._finishRefreshEvent;
        cnVar.setValue(Boxing.boxBoolean(true));
        this.this$0.isLoading = false;
        if (gVar.getErrorCode() != 0) {
            cnVar2 = this.this$0._toastEvent;
            cnVar2.setValue(new cf1.b(gVar.getErrorCode(), gVar.getErrMsg()));
            if (NetworkUtil.isNetSupport(null)) {
                mutableLiveData3 = this.this$0._pageDataLiveData;
                listOf3 = CollectionsKt__CollectionsJVMKt.listOf(new EmptyPageData(5, "\u5f53\u524d\u670d\u52a1\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", true));
                mutableLiveData3.setValue(listOf3);
            } else {
                mutableLiveData2 = this.this$0._pageDataLiveData;
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new EmptyPageData(8, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u70b9\u51fb\u91cd\u8bd5\u3002", true));
                mutableLiveData2.setValue(listOf2);
            }
        } else if (gVar.c().isEmpty()) {
            mutableLiveData = this.this$0._pageDataLiveData;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new EmptyPageData(8, "\u6d3b\u52a8\u90fd\u5df2\u7ed3\u675f\u4e86", false));
            mutableLiveData.setValue(listOf);
        } else {
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, gVar, null);
            this.label = 2;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHotLiveViewModel$updateData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

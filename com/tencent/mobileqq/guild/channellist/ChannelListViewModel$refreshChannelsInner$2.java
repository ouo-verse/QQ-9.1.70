package com.tencent.mobileqq.guild.channellist;

import com.tencent.mobileqq.guild.channellist.process.Processors;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channellist.ChannelListViewModel$refreshChannelsInner$2", f = "ChannelListViewModel.kt", i = {}, l = {162, 163, 174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class ChannelListViewModel$refreshChannelsInner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChannelListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListViewModel$refreshChannelsInner$2(ChannelListViewModel channelListViewModel, Continuation<? super ChannelListViewModel$refreshChannelsInner$2> continuation) {
        super(2, continuation);
        this.this$0 = channelListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChannelListViewModel$refreshChannelsInner$2(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Processors processors;
        Job job;
        ArrayList<Integer> arrayListOf;
        ArrayList<IGProCategoryChannelInfoList> categoryChannelInfoListByCategoryType;
        Map b16;
        Processors processors2;
        List<? extends c> list;
        boolean z16;
        Object obj2;
        List mutableList;
        boolean z17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.firstTimeUpdate = false;
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IGPSService igpsService = this.this$0.getIgpsService();
                long longOrDefault = Util.toLongOrDefault(this.this$0.getGuildId(), 0L);
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxInt(2));
                categoryChannelInfoListByCategoryType = igpsService.getCategoryChannelInfoListByCategoryType(longOrDefault, arrayListOf);
                if (categoryChannelInfoListByCategoryType != null) {
                    Iterator<T> it = categoryChannelInfoListByCategoryType.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            if (((IGProCategoryChannelInfoList) obj2).getCategoryType() == 2) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    IGProCategoryChannelInfoList iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) obj2;
                    if (iGProCategoryChannelInfoList != null) {
                        ChannelListViewModel channelListViewModel = this.this$0;
                        channelListViewModel.channelCategoryId = Boxing.boxLong(iGProCategoryChannelInfoList.getCategoryId());
                        String categoryName = iGProCategoryChannelInfoList.getCategoryName();
                        Intrinsics.checkNotNullExpressionValue(categoryName, "it.name");
                        channelListViewModel.chatTitle = categoryName;
                        e eVar = e.f215292a;
                        ArrayList<IGProChannel> channelInfoList = iGProCategoryChannelInfoList.getChannelInfoList();
                        Intrinsics.checkNotNullExpressionValue(channelInfoList, "it.channelInfoList");
                        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) eVar.b(channelInfoList));
                        channelListViewModel.channelList = mutableList;
                    }
                }
                ChannelListViewModel channelListViewModel2 = this.this$0;
                b16 = ChannelListViewModel.INSTANCE.b(channelListViewModel2.channelList);
                channelListViewModel2.channelMap = b16;
                this.this$0.h2();
                processors2 = this.this$0.processors;
                list = this.this$0.channelList;
                z16 = this.this$0.firstTimeUpdate;
                this.label = 3;
                if (processors2.e(list, z16, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.this$0.firstTimeUpdate = false;
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            processors = this.this$0.processors;
            this.label = 1;
            if (processors.h(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        job = this.this$0.collectJob;
        if (job != null) {
            this.label = 2;
            if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        IGPSService igpsService2 = this.this$0.getIgpsService();
        long longOrDefault2 = Util.toLongOrDefault(this.this$0.getGuildId(), 0L);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxInt(2));
        categoryChannelInfoListByCategoryType = igpsService2.getCategoryChannelInfoListByCategoryType(longOrDefault2, arrayListOf);
        if (categoryChannelInfoListByCategoryType != null) {
        }
        ChannelListViewModel channelListViewModel22 = this.this$0;
        b16 = ChannelListViewModel.INSTANCE.b(channelListViewModel22.channelList);
        channelListViewModel22.channelMap = b16;
        this.this$0.h2();
        processors2 = this.this$0.processors;
        list = this.this$0.channelList;
        z16 = this.this$0.firstTimeUpdate;
        this.label = 3;
        if (processors2.e(list, z16, this) == coroutine_suspended) {
        }
        this.this$0.firstTimeUpdate = false;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelListViewModel$refreshChannelsInner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

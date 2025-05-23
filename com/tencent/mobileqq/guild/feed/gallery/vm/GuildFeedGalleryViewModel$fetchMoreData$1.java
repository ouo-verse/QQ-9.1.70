package com.tencent.mobileqq.guild.feed.gallery.vm;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.feed.gallery.vm.GuildFeedGalleryViewModel;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.report.c;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetImmersiveFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.gallery.vm.GuildFeedGalleryViewModel$fetchMoreData$1", f = "GuildFeedGalleryViewModel.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryViewModel$fetchMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildFeedGalleryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryViewModel$fetchMoreData$1(GuildFeedGalleryViewModel guildFeedGalleryViewModel, Continuation<? super GuildFeedGalleryViewModel$fetchMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFeedGalleryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedGalleryViewModel$fetchMoreData$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        MutableLiveData mutableLiveData;
        String str;
        int collectionSizeOrDefault;
        boolean z17;
        boolean z18;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        boolean z19;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        MutableLiveData mutableLiveData6;
        MutableLiveData mutableLiveData7;
        MutableLiveData mutableLiveData8;
        MutableLiveData mutableLiveData9;
        MutableLiveData mutableLiveData10;
        MutableLiveData mutableLiveData11;
        GuildFeedGalleryInitBean t26;
        IPerformanceReportTask iPerformanceReportTask;
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
            GuildFeedGalleryViewModel guildFeedGalleryViewModel = this.this$0;
            this.label = 1;
            obj = guildFeedGalleryViewModel.g2(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildFeedGalleryViewModel.SuspendRsp suspendRsp = (GuildFeedGalleryViewModel.SuspendRsp) obj;
        z16 = this.this$0.hasLoadMoreReported;
        if (!z16) {
            c cVar = c.f223280a;
            iPerformanceReportTask = this.this$0.perfStageReportTask;
            cVar.b(iPerformanceReportTask, "stage_load_more_finish", suspendRsp.getCode(), suspendRsp.getMsg());
            this.this$0.hasLoadMoreReported = true;
        }
        if (!suspendRsp.d() || suspendRsp.c() == null) {
            mutableLiveData = this.this$0.mFeedsData;
            mutableLiveData.setValue(UIStateData.obtainError(suspendRsp.getMsg()).setRetCode(suspendRsp.getCode()));
            return Unit.INSTANCE;
        }
        GuildFeedGalleryViewModel guildFeedGalleryViewModel2 = this.this$0;
        String str2 = ((GProGetImmersiveFeedsRsp) suspendRsp.c()).sessionId;
        Intrinsics.checkNotNullExpressionValue(str2, "suspendRsp.rsp.sessionId");
        guildFeedGalleryViewModel2.mSessionId = str2;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.this$0.mFeedInitBean;
        if (guildFeedGalleryInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean = null;
        }
        str = this.this$0.mSessionId;
        guildFeedGalleryInitBean.setSessionId(str);
        String str3 = ((GProGetImmersiveFeedsRsp) suspendRsp.c()).traceId;
        ArrayList<GProStFeed> arrayList = ((GProGetImmersiveFeedsRsp) suspendRsp.c()).feeds;
        Intrinsics.checkNotNullExpressionValue(arrayList, "suspendRsp.rsp.feeds");
        GuildFeedGalleryViewModel guildFeedGalleryViewModel3 = this.this$0;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (true) {
            int i16 = 0;
            if (!it.hasNext()) {
                break;
            }
            GProStFeed stFeed = (GProStFeed) it.next();
            mutableLiveData11 = guildFeedGalleryViewModel3.mFeedRecommendLoadState;
            Integer num = (Integer) mutableLiveData11.getValue();
            if (num == null || num.intValue() != 0) {
                i16 = 1;
            }
            Intrinsics.checkNotNullExpressionValue(stFeed, "stFeed");
            t26 = guildFeedGalleryViewModel3.t2(stFeed);
            jk1.a aVar = new jk1.a(t26, i16);
            if (!TextUtils.isEmpty(str3)) {
                aVar.e(str3);
            }
            arrayList2.add(aVar);
        }
        if (((GProGetImmersiveFeedsRsp) suspendRsp.c()).isFinish == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (this.this$0.getIsNeedLoadRecommend() && z17) {
            if (((GProGetImmersiveFeedsRsp) suspendRsp.c()).isRecommendFinish == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            booleanRef.element = z19;
            if (z19) {
                mutableLiveData8 = this.this$0.mFeedRecommendLoadState;
                Integer num2 = (Integer) mutableLiveData8.getValue();
                if (num2 != null && num2.intValue() == 1 && (!arrayList2.isEmpty())) {
                    mutableLiveData10 = this.this$0.mFeedRecommendLoadState;
                    mutableLiveData10.setValue(Boxing.boxInt(2));
                } else {
                    mutableLiveData9 = this.this$0.mFeedRecommendLoadState;
                    mutableLiveData9.setValue(Boxing.boxInt(4));
                }
            } else {
                mutableLiveData4 = this.this$0.mFeedRecommendLoadState;
                Integer num3 = (Integer) mutableLiveData4.getValue();
                if (num3 != null && num3.intValue() == 0) {
                    mutableLiveData7 = this.this$0.mFeedRecommendLoadState;
                    mutableLiveData7.setValue(Boxing.boxInt(1));
                } else {
                    mutableLiveData5 = this.this$0.mFeedRecommendLoadState;
                    Integer num4 = (Integer) mutableLiveData5.getValue();
                    if (num4 != null && num4.intValue() == 1) {
                        mutableLiveData6 = this.this$0.mFeedRecommendLoadState;
                        mutableLiveData6.setValue(Boxing.boxInt(2));
                    }
                }
            }
        }
        MutableLiveData mutableLiveData12 = this.this$0.mFeedLoadMoreFinish;
        if (z17 && booleanRef.element) {
            z18 = true;
        } else {
            z18 = false;
        }
        mutableLiveData12.setValue(Boxing.boxBoolean(z18));
        mutableLiveData2 = this.this$0.mFeedsData;
        mutableLiveData2.setValue(UIStateData.obtainSuccess(false).setDataList(arrayList2));
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "channelFinish = " + z17 + ", recommendFinish = " + booleanRef.element + ", traceId = " + str3);
        this.this$0.loadMoreAttachInfo = ((GProGetImmersiveFeedsRsp) suspendRsp.c()).attachInfo;
        mutableLiveData3 = this.this$0.mFeedRecommendLoadState;
        Integer num5 = (Integer) mutableLiveData3.getValue();
        if (num5 != null && num5.intValue() == 1) {
            this.this$0.n2();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedGalleryViewModel$fetchMoreData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

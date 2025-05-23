package com.tencent.mobileqq.guild.feed.gallery.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.gallery.b;
import com.tencent.mobileqq.guild.feed.gallery.vm.GuildFeedGalleryViewModel;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.report.c;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.gallery.vm.GuildFeedGalleryViewModel$fetchInitStFeedData$1", f = "GuildFeedGalleryViewModel.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryViewModel$fetchInitStFeedData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildFeedGalleryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryViewModel$fetchInitStFeedData$1(GuildFeedGalleryViewModel guildFeedGalleryViewModel, Continuation<? super GuildFeedGalleryViewModel$fetchInitStFeedData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFeedGalleryViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedGalleryViewModel guildFeedGalleryViewModel, GProStFeed gProStFeed) {
        guildFeedGalleryViewModel.o2(gProStFeed);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedGalleryViewModel$fetchInitStFeedData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPerformanceReportTask iPerformanceReportTask;
        MutableLiveData mutableLiveData;
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
            obj = guildFeedGalleryViewModel.i2(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildFeedGalleryViewModel.SuspendRsp suspendRsp = (GuildFeedGalleryViewModel.SuspendRsp) obj;
        final GProStFeed gProStFeed = (GProStFeed) suspendRsp.c();
        c cVar = c.f223280a;
        iPerformanceReportTask = this.this$0.perfStageReportTask;
        cVar.b(iPerformanceReportTask, "stage_init_data_finish", suspendRsp.getCode(), suspendRsp.getMsg());
        if (suspendRsp.d() && gProStFeed != null) {
            if (b.l(gProStFeed)) {
                Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[fetchInitStFeedData] update stFeed for initBean and first data!");
                GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.this$0.mFeedInitBean;
                if (guildFeedGalleryInitBean == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
                    guildFeedGalleryInitBean = null;
                }
                guildFeedGalleryInitBean.setFeed(gProStFeed);
                GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.this$0.mFeedInitBean;
                if (guildFeedGalleryInitBean2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
                    guildFeedGalleryInitBean2 = null;
                }
                guildFeedGalleryInitBean2.setRichMediaDataList(b.d(gProStFeed));
                mutableLiveData = this.this$0.mFeedsInitData;
                GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.this$0.mFeedInitBean;
                if (guildFeedGalleryInitBean3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
                    guildFeedGalleryInitBean3 = null;
                }
                mutableLiveData.setValue(new jk1.a(guildFeedGalleryInitBean3, 0, 2, null));
                final GuildFeedGalleryViewModel guildFeedGalleryViewModel2 = this.this$0;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.vm.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedGalleryViewModel$fetchInitStFeedData$1.b(GuildFeedGalleryViewModel.this, gProStFeed);
                    }
                }, 128, null, false);
            } else {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("[fetchInitStFeedData] invalid stFeed");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, (String) it.next(), null);
                }
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedGalleryViewModel$fetchInitStFeedData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

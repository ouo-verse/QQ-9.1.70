package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelKt;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b*\u0001\u001d\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0014J\u001c\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailGuildInfoViewModel;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/AbsDetailViewModel;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "loadDataArgs", "", "i2", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "j2", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "args", "k2", "g2", "from", "l2", "getLogTag", "y1", "t0", "e1", "onCleared", "action", "", "c", "E", "J", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "originLoadDataArgs", "com/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailGuildInfoViewModel$b", "K", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailGuildInfoViewModel$b;", "serviceObserver", "L", "Z", "loadFeedMainFinish", "M", "loadFeedMainSuccess", "N", "loadDataFinish", "P", "Ljava/lang/String;", "traceId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/ArrayList;", "recommendFeeds", "", "getIdentifier", "()I", IECDtReport.ACTION_IDENTIFIER, "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DetailGuildInfoViewModel extends AbsDetailViewModel {

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private LoadDataArgs originLoadDataArgs;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b serviceObserver;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean loadFeedMainFinish;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean loadFeedMainSuccess;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean loadDataFinish;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String traceId;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private ArrayList<GProStFeed> recommendFeeds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailGuildInfoViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onDestoryGuild", "onDeleteGuild", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            String str;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            IGProGuildInfo iGProGuildInfo = DetailGuildInfoViewModel.this.guildInfo;
            if (iGProGuildInfo != null) {
                str = iGProGuildInfo.getGuildID();
            } else {
                str = null;
            }
            if (TextUtils.equals(guildId, str)) {
                DetailGuildInfoViewModel.this.U1(new a());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            String str;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            IGProGuildInfo iGProGuildInfo = DetailGuildInfoViewModel.this.guildInfo;
            if (iGProGuildInfo != null) {
                str = iGProGuildInfo.getGuildID();
            } else {
                str = null;
            }
            if (TextUtils.equals(guildId, str)) {
                DetailGuildInfoViewModel.this.U1(new a());
            }
        }
    }

    public DetailGuildInfoViewModel() {
        AppInterface appInterface;
        b bVar = new b();
        this.serviceObserver = bVar;
        this.traceId = "";
        this.recommendFeeds = new ArrayList<>();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(bVar);
        }
    }

    private final void g2() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.o
            @Override // java.lang.Runnable
            public final void run() {
                DetailGuildInfoViewModel.h2(DetailGuildInfoViewModel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(DetailGuildInfoViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.xaction.log.b.a(this$0.getTAG(), 1, "clearContentDataList");
        if (this$0.M1().isEmpty()) {
            return;
        }
        this$0.M1().clear();
        this$0.O1(12);
    }

    private final void i2(LoadDataArgs loadDataArgs) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DetailGuildInfoViewModel$fetchData$1(this, loadDataArgs, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j2(String str, Continuation<? super IGProGuildInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        GuildMainFrameUtils.k(str, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailGuildInfoViewModel$fetchGuildInfo$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                com.tencent.xaction.log.b.a(DetailGuildInfoViewModel.this.getTAG(), 1, "fetchGuildInfo isMember=" + (iGProGuildInfo != null ? Boolean.valueOf(iGProGuildInfo.isMember()) : null));
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(iGProGuildInfo));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void k2(Object args) {
        g.OnLoadMainCompletedMessage onLoadMainCompletedMessage;
        if (args instanceof g.OnLoadMainCompletedMessage) {
            onLoadMainCompletedMessage = (g.OnLoadMainCompletedMessage) args;
        } else {
            onLoadMainCompletedMessage = null;
        }
        if (onLoadMainCompletedMessage == null) {
            return;
        }
        com.tencent.xaction.log.b.a(getTAG(), 1, "handleLoadMainDataCompleted, isDB=" + onLoadMainCompletedMessage.getIsDbCache() + ", isSuc=" + onLoadMainCompletedMessage.getIsSuccess());
        if (!onLoadMainCompletedMessage.getIsDbCache()) {
            this.loadFeedMainFinish = true;
            this.loadFeedMainSuccess = onLoadMainCompletedMessage.getIsSuccess();
        }
        if (this.loadFeedMainFinish && this.loadDataFinish) {
            if (this.loadFeedMainSuccess) {
                g2();
            } else {
                l2("message");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(final String from) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.n
            @Override // java.lang.Runnable
            public final void run() {
                DetailGuildInfoViewModel.m2(DetailGuildInfoViewModel.this, from);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(DetailGuildInfoViewModel this$0, String from) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(from, "$from");
        com.tencent.xaction.log.b.a(this$0.getTAG(), 1, "notifyDataChange from " + from);
        IGProGuildInfo iGProGuildInfo = this$0.guildInfo;
        if (iGProGuildInfo != null) {
            this$0.M1().clear();
            this$0.M1().add(new ql1.a(iGProGuildInfo, this$0.recommendFeeds, this$0.loadFeedMainSuccess, this$0.traceId));
            this$0.O1(12);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public boolean E() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public boolean c(@Nullable String action, @Nullable Object args) {
        boolean areEqual;
        if (Intrinsics.areEqual(action, "message_on_main_reload_complete")) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(action, "message_on_load_main_completed");
        }
        if (areEqual) {
            k2(args);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void e1(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        this.originLoadDataArgs = loadDataArgs;
        com.tencent.xaction.log.b.a(getTAG(), 1, "onLoad ");
        i2(loadDataArgs);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public int getIdentifier() {
        return 3;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "DetailGuildInfoViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        AppInterface appInterface;
        super.onCleared();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.serviceObserver);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void t0(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        com.tencent.xaction.log.b.a(getTAG(), 1, "reload ");
        i2(loadDataArgs);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void y1(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
    }
}

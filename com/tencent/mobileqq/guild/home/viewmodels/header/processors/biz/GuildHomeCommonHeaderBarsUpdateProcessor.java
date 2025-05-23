package com.tencent.mobileqq.guild.home.viewmodels.header.processors.biz;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.home.viewmodels.header.f;
import com.tencent.mobileqq.guild.home.viewmodels.header.processors.ProcessResult;
import com.tencent.mobileqq.guild.home.viewmodels.header.processors.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh2.ax;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0003\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b8\u00109J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001d\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J9\u0010\u001b\u001a\u00020\u001a\"\b\b\u0000\u0010\u0015*\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00028\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\u001e\u0010#R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R \u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020)048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/biz/GuildHomeCommonHeaderBarsUpdateProcessor;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "com/tencent/mobileqq/guild/home/viewmodels/header/processors/biz/GuildHomeCommonHeaderBarsUpdateProcessor$b", "u", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/biz/GuildHomeCommonHeaderBarsUpdateProcessor$b;", "", "guildId", "", "y", "", "fromServer", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", h.F, "i", "k", "j", "", "T", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "data", "", VideoTemplateParser.ITEM_LIST, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult;", "l", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;Ljava/lang/Object;Ljava/util/List;)Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/f;", "f", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/f;", "guildHeaderBarsDataStoreAndConvertor", "Ljava/lang/String;", "v", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "activeGuildId", "name", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_eventSource", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/biz/GuildHomeCommonHeaderBarsUpdateProcessor$b;", "gProObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "w", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Lkotlinx/coroutines/flow/Flow;", "e", "()Lkotlinx/coroutines/flow/Flow;", "eventSource", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/home/viewmodels/header/f;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeCommonHeaderBarsUpdateProcessor extends a<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b gProObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f guildHeaderBarsDataStoreAndConvertor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String activeGuildId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>> _eventSource;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0014J \u0010\f\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/processors/biz/GuildHomeCommonHeaderBarsUpdateProcessor$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "", "guildIdList", "", "onGuildMainFrameHeaderUpdated", "guildId", "onGuildInfoUpdated", "guildIds", "", "fromServer", "onPollingGuildRefresh", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, GuildHomeCommonHeaderBarsUpdateProcessor.this.getActiveGuildId())) {
                GuildHomeCommonHeaderBarsUpdateProcessor.this.y(guildId);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildMainFrameHeaderUpdated(@Nullable List<String> guildIdList) {
            boolean z16 = false;
            if (guildIdList != null && guildIdList.contains(GuildHomeCommonHeaderBarsUpdateProcessor.this.getActiveGuildId())) {
                z16 = true;
            }
            if (z16) {
                GuildHomeCommonHeaderBarsUpdateProcessor guildHomeCommonHeaderBarsUpdateProcessor = GuildHomeCommonHeaderBarsUpdateProcessor.this;
                guildHomeCommonHeaderBarsUpdateProcessor.y(guildHomeCommonHeaderBarsUpdateProcessor.getActiveGuildId());
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPollingGuildRefresh(@Nullable List<String> guildIds, boolean fromServer) {
            boolean z16 = false;
            if (guildIds != null && guildIds.contains(GuildHomeCommonHeaderBarsUpdateProcessor.this.getActiveGuildId())) {
                z16 = true;
            }
            if (z16) {
                GuildHomeCommonHeaderBarsUpdateProcessor.this.x(fromServer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "", "gId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;", "headerInfo", "", "a", "(ILjava/lang/String;JLcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ax {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<IGProGuildMainFrameHeaderInfo> f225440b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super IGProGuildMainFrameHeaderInfo> cancellableContinuation) {
            this.f225440b = cancellableContinuation;
        }

        @Override // vh2.ax
        public final void a(int i3, String str, long j3, IGProGuildMainFrameHeaderInfo iGProGuildMainFrameHeaderInfo) {
            Logger logger = Logger.f235387a;
            GuildHomeCommonHeaderBarsUpdateProcessor guildHomeCommonHeaderBarsUpdateProcessor = GuildHomeCommonHeaderBarsUpdateProcessor.this;
            logger.d().d("Guild.NewHome.GuildHomeCommonHeaderBarsUpdateProcessor", 1, "loadHeaderBarsList result:" + i3 + " msg:" + str + " gId:" + j3 + " curGId:" + guildHomeCommonHeaderBarsUpdateProcessor.getActiveGuildId());
            if (!Intrinsics.areEqual(String.valueOf(j3), GuildHomeCommonHeaderBarsUpdateProcessor.this.getActiveGuildId())) {
                logger.d().w("Guild.NewHome.GuildHomeCommonHeaderBarsUpdateProcessor", 1, "loadHeaderBarsList gId notMatch activeGuildId");
                this.f225440b.resumeWith(Result.m476constructorimpl(null));
            } else {
                GuildHomeCommonHeaderBarsUpdateProcessor.this.guildHeaderBarsDataStoreAndConvertor.h(GuildHomeCommonHeaderBarsUpdateProcessor.this.getActiveGuildId(), iGProGuildMainFrameHeaderInfo, "Guild.NewHome.GuildHomeCommonHeaderBarsUpdateProcessor");
                this.f225440b.resumeWith(Result.m476constructorimpl(iGProGuildMainFrameHeaderInfo));
            }
        }
    }

    public GuildHomeCommonHeaderBarsUpdateProcessor(@NotNull String guildId, @NotNull f guildHeaderBarsDataStoreAndConvertor) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildHeaderBarsDataStoreAndConvertor, "guildHeaderBarsDataStoreAndConvertor");
        this.guildHeaderBarsDataStoreAndConvertor = guildHeaderBarsDataStoreAndConvertor;
        this.activeGuildId = guildId;
        this.name = "GuildHomeCommonHeaderBarsUpdateProcessor";
        this._eventSource = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.gProObserver = u();
    }

    private final b u() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService w() {
        RuntimeServiceHolder g16;
        g16 = g();
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...";
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return (IGPSService) g16.b("", IGPSService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(boolean fromServer) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarRefresh$1(this, fromServer, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String guildId) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarsList$1(this, guildId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z(String str, Continuation<? super IGProGuildMainFrameHeaderInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        w().getGuildMainFrameHeaderInfo(MiscKt.l(str), new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    @NotNull
    public Flow<com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>> e() {
        return this._eventSource;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    public void h() {
        w().addObserver(this.gProObserver);
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    public void i() {
        w().deleteObserver(this.gProObserver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    @NotNull
    public <T> ProcessResult l(@Nullable com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b item, @NotNull T data, @NotNull List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> itemList) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        if ((data instanceof com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) && item != null) {
            com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar = (com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) data;
            bVar.g(item.getTintColors());
            return new ProcessResult(bVar);
        }
        return ProcessResult.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    public void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activeGuildId = str;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public String getActiveGuildId() {
        return this.activeGuildId;
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    public void j() {
    }

    @Override // com.tencent.mobileqq.guild.home.viewmodels.header.processors.a
    public void k() {
    }
}

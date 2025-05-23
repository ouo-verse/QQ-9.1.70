package com.tencent.mobileqq.guild.channellist.process;

import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.channellist.AppChannelData;
import com.tencent.mobileqq.guild.channellist.TextChannelData;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService;
import com.tencent.mobileqq.guild.summary.d;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0003\u0006\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0017J\b\u0010\u000e\u001a\u00020\u000bH\u0017J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0013\u0010\u0012\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u001a\u001a\u00020\u0019\"\b\b\u0000\u0010\u0015*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0000H\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u000f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0014\u0010)\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001dR\u0014\u0010.\u001a\u00020+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R \u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/GuildSummaryProcessor;", "Lcom/tencent/mobileqq/guild/channellist/process/a;", "Lcom/tencent/mobileqq/guild/summary/a;", "com/tencent/mobileqq/guild/channellist/process/GuildSummaryProcessor$c", "y", "()Lcom/tencent/mobileqq/guild/channellist/process/GuildSummaryProcessor$c;", "com/tencent/mobileqq/guild/channellist/process/GuildSummaryProcessor$b", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/guild/channellist/process/GuildSummaryProcessor$b;", "", "summaries", "", "w", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "guildId", "c", "o", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "T", "Lcom/tencent/mobileqq/guild/channellist/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "data", "Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/guild/channellist/c;Ljava/lang/Object;)Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", h.F, "Ljava/lang/String;", "()Ljava/lang/String;", "name", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/guild/channellist/process/b;", "i", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_summaryFlow", "Lcom/tencent/mobileqq/guild/summary/d;", "Lcom/tencent/mobileqq/guild/summary/d;", "summaryUpdateCallback", BdhLogUtil.LogTag.Tag_Conn, "guestSummaryUpdateCallback", "D", "Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryUnreadLimitService;", "v", "()Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryUnreadLimitService;", "summaryService", "Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryApi;", "u", "()Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryApi;", "guestSummaryService", "Lkotlinx/coroutines/flow/Flow;", "g", "()Lkotlinx/coroutines/flow/Flow;", "eventSource", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildSummaryProcessor extends a<GuildSummaryData> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name = "GuildSummaryProcessor";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<ItemsProcessEvent<GuildSummaryData>> _summaryFlow = SharedFlowKt.MutableSharedFlow$default(5, 0, null, 6, null);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d summaryUpdateCallback = y();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d guestSummaryUpdateCallback = x();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/channellist/process/GuildSummaryProcessor$b", "Lcom/tencent/mobileqq/guild/summary/d;", "", "Lcom/tencent/mobileqq/guild/summary/a;", "summaries", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.summary.d
        public void a(@NotNull List<GuildSummaryData> summaries) {
            Intrinsics.checkNotNullParameter(summaries, "summaries");
            if (ch.j0(GuildSummaryProcessor.this.guildId)) {
                GuildSummaryProcessor.this.w(summaries);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/channellist/process/GuildSummaryProcessor$c", "Lcom/tencent/mobileqq/guild/summary/d;", "", "Lcom/tencent/mobileqq/guild/summary/a;", "summaries", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements d {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.summary.d
        public void a(@NotNull List<GuildSummaryData> summaries) {
            Intrinsics.checkNotNullParameter(summaries, "summaries");
            if (!ch.j0(GuildSummaryProcessor.this.guildId)) {
                GuildSummaryProcessor.this.w(summaries);
            }
        }
    }

    private final IGuildSummaryApi u() {
        RuntimeServiceHolder i3;
        i3 = i();
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IGuildSummaryApi.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IGuildSummaryApi.class.getSimpleName() + ") calling...";
                for (int i16 = 0; i16 < str.length(); i16++) {
                    char charAt = str.charAt(i16);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return (IGuildSummaryApi) i3.b("", IGuildSummaryApi.class);
    }

    private final IGuildSummaryUnreadLimitService v() {
        RuntimeServiceHolder i3;
        i3 = i();
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IGuildSummaryUnreadLimitService.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IGuildSummaryUnreadLimitService.class.getSimpleName() + ") calling...";
                for (int i16 = 0; i16 < str.length(); i16++) {
                    char charAt = str.charAt(i16);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return (IGuildSummaryUnreadLimitService) i3.b("", IGuildSummaryUnreadLimitService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(List<GuildSummaryData> summaries) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new GuildSummaryProcessor$handleSummaryUpdate$1(summaries, this, null), 3, null);
    }

    private final b x() {
        return new b();
    }

    private final c y() {
        return new c();
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    public void c(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (!Intrinsics.areEqual(this.guildId, guildId)) {
            this._summaryFlow.resetReplayCache();
            this.guildId = guildId;
        }
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @NotNull
    public Flow<ItemsProcessEvent<GuildSummaryData>> g() {
        return this._summaryFlow;
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @UiThread
    public void l() {
        v().registerSummaryUpdateCallback(this.summaryUpdateCallback);
        u().registerGuestSummaryUpdateCallback(this.guestSummaryUpdateCallback);
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @UiThread
    public void m() {
        v().unregisterSummaryUpdateCallback(this.summaryUpdateCallback);
        u().unregisterGuestSummaryUpdateCallback(this.guestSummaryUpdateCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @UiThread
    @NotNull
    public <T> ReplaceResult n(@NotNull com.tencent.mobileqq.guild.channellist.c item, @NotNull T data) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof GuildSummaryData)) {
            return ReplaceResult.INSTANCE.a();
        }
        if (item instanceof TextChannelData) {
            TextChannelData e16 = ((TextChannelData) item).e();
            e16.o((GuildSummaryData) data);
            return ReplaceResult.INSTANCE.b(e16);
        }
        if (item instanceof AppChannelData) {
            AppChannelData e17 = ((AppChannelData) item).e();
            e17.q((GuildSummaryData) data);
            return ReplaceResult.INSTANCE.b(e17);
        }
        return ReplaceResult.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.guild.channellist.process.a
    @Nullable
    public Object o(@NotNull Continuation<? super Unit> continuation) {
        this._summaryFlow.resetReplayCache();
        return Unit.INSTANCE;
    }
}

package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.share.a;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\f\u0018\u0000 \f2\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010+\u001a\u00020$\u00a2\u0006\u0004\b@\u0010AJ8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001c\u0010\u0015\u001a\u00020\u000b2\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u000b0\u0012J\u0013\u0010\u0016\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b\u001f\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u00101\u001a\u0004\b,\u00102\"\u0004\b3\u00104R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00107R$\u0010\n\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00109\u001a\u0004\b\u0019\u0010:\"\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010=R\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010?\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/share/FetchGuildArkInfo;", "Lcom/tencent/mobileqq/guild/share/a;", "Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "busiId", "Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "templateStr", "", "", "", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "resourceId", "", "i", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "source", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "shareInfo", tl.h.F, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/share/b;", "cb", "g", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "c", "Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "e", "()Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "setServiceType", "(Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;)V", "serviceType", "d", "Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "()Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "k", "(Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;)V", "Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "()Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "j", "(Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;)V", "arkTemplateStr", "", "Ljava/util/Map;", "customBusiData", "Ljava/lang/String;", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/guild/share/b;", "fetchedArkInfo", "()Ljava/util/Map;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FetchGuildArkInfo implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProGuildInfo guildInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IGProChannelInfo channelInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ShareServiceType serviceType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildArkBusiId busiId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArkTemplateStr arkTemplateStr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Object> customBusiData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String resourceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b fetchedArkInfo;

    public FetchGuildArkInfo(@NotNull IGProGuildInfo guildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NotNull ShareServiceType serviceType) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.guildInfo = guildInfo;
        this.channelInfo = iGProChannelInfo;
        this.serviceType = serviceType;
        this.busiId = GuildArkBusiId.HOME;
        this.arkTemplateStr = ArkTemplateStr.Contact;
        this.customBusiData = new LinkedHashMap();
    }

    private final void i(GuildArkBusiId busiId, ArkTemplateStr templateStr, Map<String, ? extends Object> busiData, String resourceId) {
        k(busiId);
        j(templateStr);
        if (busiData == null) {
            busiData = MapsKt__MapsKt.emptyMap();
        }
        this.customBusiData = new HashMap(busiData);
        l(resourceId);
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @Nullable
    /* renamed from: a, reason: from getter */
    public String getResourceId() {
        return this.resourceId;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    /* renamed from: b, reason: from getter */
    public GuildArkBusiId getBusiId() {
        return this.busiId;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    public Map<String, Object> c() {
        Pair[] pairArr;
        Map<String, Object> mutableMapOf;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        String guildID = this.guildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
        spreadBuilder.add(TuplesKt.to("guild_id", Long.valueOf(MiscKt.l(guildID))));
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        if (iGProChannelInfo != null) {
            String channelUin = iGProChannelInfo.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
            pairArr = new Pair[]{TuplesKt.to("channel_id", Long.valueOf(MiscKt.l(channelUin)))};
        } else {
            pairArr = new Pair[0];
        }
        spreadBuilder.addSpread(pairArr);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf((Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
        mutableMapOf.putAll(this.customBusiData);
        return mutableMapOf;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public ArkTemplateStr getArkTemplateStr() {
        return this.arkTemplateStr;
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public ShareServiceType getServiceType() {
        return this.serviceType;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object f(@NotNull Continuation<? super b> continuation) {
        FetchGuildArkInfo$fetchArk$1 fetchGuildArkInfo$fetchArk$1;
        Object coroutine_suspended;
        int i3;
        FetchGuildArkInfo fetchGuildArkInfo;
        if (continuation instanceof FetchGuildArkInfo$fetchArk$1) {
            fetchGuildArkInfo$fetchArk$1 = (FetchGuildArkInfo$fetchArk$1) continuation;
            int i16 = fetchGuildArkInfo$fetchArk$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                fetchGuildArkInfo$fetchArk$1.label = i16 - Integer.MIN_VALUE;
                Object obj = fetchGuildArkInfo$fetchArk$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = fetchGuildArkInfo$fetchArk$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        fetchGuildArkInfo = (FetchGuildArkInfo) fetchGuildArkInfo$fetchArk$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (this.fetchedArkInfo == null) {
                        fetchGuildArkInfo$fetchArk$1.L$0 = this;
                        fetchGuildArkInfo$fetchArk$1.label = 1;
                        obj = a.C7906a.a(this, fetchGuildArkInfo$fetchArk$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fetchGuildArkInfo = this;
                    } else {
                        fetchGuildArkInfo = this;
                        b bVar = fetchGuildArkInfo.fetchedArkInfo;
                        Intrinsics.checkNotNull(bVar);
                        return bVar;
                    }
                }
                fetchGuildArkInfo.fetchedArkInfo = (b) obj;
                b bVar2 = fetchGuildArkInfo.fetchedArkInfo;
                Intrinsics.checkNotNull(bVar2);
                return bVar2;
            }
        }
        fetchGuildArkInfo$fetchArk$1 = new FetchGuildArkInfo$fetchArk$1(this, continuation);
        Object obj2 = fetchGuildArkInfo$fetchArk$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = fetchGuildArkInfo$fetchArk$1.label;
        if (i3 == 0) {
        }
        fetchGuildArkInfo.fetchedArkInfo = (b) obj2;
        b bVar22 = fetchGuildArkInfo.fetchedArkInfo;
        Intrinsics.checkNotNull(bVar22);
        return bVar22;
    }

    public final void g(@NotNull Function1<? super b, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        b bVar = this.fetchedArkInfo;
        if (bVar != null) {
            cb5.invoke(bVar);
            return;
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "FetchGuildArkInfoshare panel", null, null, Boolean.TRUE, new FetchGuildArkInfo$fetchArkForJava$1(this, cb5, null), 6, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.share.a
    @Nullable
    public com.tencent.qqnt.kernel.api.o getFeedService() {
        return a.C7906a.c(this);
    }

    public final void h(@NotNull GuildSharePageSource source, @NotNull b.c shareInfo) {
        Map<String, ? extends Object> emptyMap;
        Map<String, ? extends Object> emptyMap2;
        Map<String, ? extends Object> emptyMap3;
        Map<String, ? extends Object> mapOf;
        Map<String, ? extends Object> emptyMap4;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        if (iGProChannelInfo != null) {
            int type = iGProChannelInfo.getType();
            if (type != 2) {
                if (type != 5) {
                    if (type != 11) {
                        GuildArkBusiId guildArkBusiId = GuildArkBusiId.HOME;
                        ArkTemplateStr arkTemplateStr = ArkTemplateStr.Contact;
                        emptyMap4 = MapsKt__MapsKt.emptyMap();
                        i(guildArkBusiId, arkTemplateStr, emptyMap4, "");
                        return;
                    }
                    GuildArkBusiId guildArkBusiId2 = GuildArkBusiId.SCHEDULE;
                    ArkTemplateStr arkTemplateStr2 = ArkTemplateStr.TuWen;
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("from", "181074"));
                    i(guildArkBusiId2, arkTemplateStr2, mapOf, shareInfo.f235324f);
                    return;
                }
                GuildArkBusiId guildArkBusiId3 = GuildArkBusiId.LIVE;
                ArkTemplateStr arkTemplateStr3 = ArkTemplateStr.TuWen;
                emptyMap3 = MapsKt__MapsKt.emptyMap();
                i(guildArkBusiId3, arkTemplateStr3, emptyMap3, "");
                return;
            }
            GuildArkBusiId guildArkBusiId4 = GuildArkBusiId.AV;
            ArkTemplateStr arkTemplateStr4 = ArkTemplateStr.TuWen;
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            i(guildArkBusiId4, arkTemplateStr4, emptyMap2, "");
            return;
        }
        GuildArkBusiId guildArkBusiId5 = GuildArkBusiId.HOME;
        ArkTemplateStr arkTemplateStr5 = ArkTemplateStr.Contact;
        emptyMap = MapsKt__MapsKt.emptyMap();
        i(guildArkBusiId5, arkTemplateStr5, emptyMap, "");
    }

    public void j(@NotNull ArkTemplateStr arkTemplateStr) {
        Intrinsics.checkNotNullParameter(arkTemplateStr, "<set-?>");
        this.arkTemplateStr = arkTemplateStr;
    }

    public void k(@NotNull GuildArkBusiId guildArkBusiId) {
        Intrinsics.checkNotNullParameter(guildArkBusiId, "<set-?>");
        this.busiId = guildArkBusiId;
    }

    public void l(@Nullable String str) {
        this.resourceId = str;
    }
}

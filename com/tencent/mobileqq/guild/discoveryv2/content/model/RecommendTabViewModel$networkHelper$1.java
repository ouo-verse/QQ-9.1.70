package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.guild.discoveryv2.net.NetworkCacheManager;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.bv;
import com.tencent.mobileqq.qqguildsdk.data.genc.eu;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cx;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007J\u001c\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\bJ\u0006\u0010\u0010\u001a\u00020\u000eR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R(\u0010\u0019\u001a\u0016\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendTabViewModel$networkHelper$1", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bv;", "req", "", "useCache", "updateCache", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/e;", "b", "g", "d", "transaction", "", "f", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/net/a;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/net/a;", "()Lcom/tencent/mobileqq/guild/discoveryv2/net/a;", "adDecorator", "Lcom/tencent/mobileqq/guild/discoveryv2/net/d;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/guild/discoveryv2/net/d;", "networkContext", "Lcom/tencent/mobileqq/guild/discoveryv2/net/NetworkCacheManager;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/net/NetworkCacheManager;", "networkManager", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendTabViewModel$networkHelper$1 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.net.a adDecorator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.net.d<bv, e> networkContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NetworkCacheManager<bv, e> networkManager;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ RecommendTabViewModel f216988d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "code", "", "kotlin.jvm.PlatformType", "msg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;", "data", "", "buf", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;[B)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    static final class a implements cx {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<e, Unit> f216989a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super e, Unit> function1) {
            this.f216989a = function1;
        }

        @Override // wh2.cx
        public final void a(int i3, String str, IGProGetRecommendTabContentRsp iGProGetRecommendTabContentRsp, byte[] bArr) {
            Function1<e, Unit> function1 = this.f216989a;
            if (str == null) {
                str = "";
            }
            ri1.a b16 = ri1.a.b(i3, str);
            Intrinsics.checkNotNullExpressionValue(b16, "error(code, msg ?: \"\")");
            if (bArr == null) {
                bArr = new byte[0];
            }
            function1.invoke(new e(b16, iGProGetRecommendTabContentRsp, bArr));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendTabViewModel$networkHelper$1$b", "Lcom/tencent/mobileqq/guild/discoveryv2/net/b;", "key", "value", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;)V", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.discoveryv2.net.b<bv, e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MMKVOptionEntity f216990a;

        public b(MMKVOptionEntity mMKVOptionEntity) {
            this.f216990a = mMKVOptionEntity;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.net.b
        @Nullable
        public e a(bv key) {
            boolean z16;
            byte[] decodeBytes = this.f216990a.decodeBytes(ch.g() + "_GWGProGetRecommendTabContentReq", null);
            if (decodeBytes == null) {
                return null;
            }
            if (decodeBytes.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!(!z16)) {
                decodeBytes = null;
            }
            if (decodeBytes == null) {
                return null;
            }
            ri1.a f16 = ri1.a.f();
            Intrinsics.checkNotNullExpressionValue(f16, "ok()");
            return new e(f16, IGProDataApi.INSTANCE.a().decodeGProGetRecommendTabContentRsp(decodeBytes), null, 4, null);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.net.b
        public void b(bv key, e value) {
            e eVar = value;
            ri1.a result = eVar.getResult();
            byte[] buffer = eVar.getBuffer();
            if (!result.d()) {
                buffer = null;
            }
            if (buffer != null) {
                this.f216990a.encodeBytes(ch.g() + "_GWGProGetRecommendTabContentReq", buffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecommendTabViewModel$networkHelper$1(RecommendTabViewModel recommendTabViewModel) {
        this.f216988d = recommendTabViewModel;
        com.tencent.mobileqq.guild.discoveryv2.net.a aVar = new com.tencent.mobileqq.guild.discoveryv2.net.a(81);
        this.adDecorator = aVar;
        this.networkContext = new com.tencent.mobileqq.guild.discoveryv2.net.d<>(new Function1<bv, eu>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel$networkHelper$1$networkContext$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final eu invoke(@NotNull bv GProTabNetContext) {
                Intrinsics.checkNotNullParameter(GProTabNetContext, "$this$GProTabNetContext");
                eu commonReq = GProTabNetContext.a();
                Intrinsics.checkNotNullExpressionValue(commonReq, "commonReq");
                return commonReq;
            }
        }, new Function1<e, IGProTabContentCommonRsp>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel$networkHelper$1$networkContext$2
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final IGProTabContentCommonRsp invoke(@NotNull e GProTabNetContext) {
                Intrinsics.checkNotNullParameter(GProTabNetContext, "$this$GProTabNetContext");
                IGProGetRecommendTabContentRsp raw = GProTabNetContext.getRaw();
                if (raw != null) {
                    return raw.getCommonRsp();
                }
                return null;
            }
        }, new Function0<bv>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel$networkHelper$1$special$$inlined$GProTabNetContext$1
            /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.qqguildsdk.data.genc.bv, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final bv invoke() {
                return bv.class.newInstance();
            }
        }, (com.tencent.mobileqq.guild.discoveryv2.net.f[]) Arrays.copyOf(new com.tencent.mobileqq.guild.discoveryv2.net.f[]{new com.tencent.mobileqq.guild.discoveryv2.net.c("GWGProGetRecommendTabContentReq"), aVar}, 2));
        MMKVOptionEntityV2 value = TabsSnapshot.f217705a.b().getValue();
        Intrinsics.checkNotNullExpressionValue(value, "TabsSnapshot.mmkv.value");
        this.networkManager = new NetworkCacheManager<>(new b(value), new RecommendTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1(18000L, null, recommendTabViewModel));
    }

    private final Flow<NetTransaction<bv, ? extends e>> b(bv req, boolean useCache, boolean updateCache) {
        return FlowKt.onEach(FlowKt.onEach(this.networkManager.c(req, useCache, updateCache), new RecommendTabViewModel$networkHelper$1$innerFetch$1(this.f216988d, null)), new RecommendTabViewModel$networkHelper$1$innerFetch$2(this, null));
    }

    static /* synthetic */ Flow c(RecommendTabViewModel$networkHelper$1 recommendTabViewModel$networkHelper$1, bv bvVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return recommendTabViewModel$networkHelper$1.b(bvVar, z16, z17);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.guild.discoveryv2.net.a getAdDecorator() {
        return this.adDecorator;
    }

    @NotNull
    public final Flow<NetTransaction<bv, ? extends e>> d() {
        bv a16 = this.networkContext.a();
        Intrinsics.checkNotNullExpressionValue(a16, "networkContext.constructMore()");
        return c(this, a16, false, false, 6, null);
    }

    public final void e() {
        this.networkContext.c();
    }

    public final void f(@NotNull NetTransaction<bv, ? extends e> transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        bv a16 = transaction.a();
        e b16 = transaction.b();
        if (transaction.getFrom() == DataType.NET && b16.e().d() && b16.getRaw() != null) {
            this.networkContext.d(a16, b16);
            RecommendTabViewModel recommendTabViewModel = this.f216988d;
            byte[] c16 = b16.c();
            ArrayList<IGProNavigationTab> tabList = b16.getRaw().getCommonRsp().getTabList();
            Intrinsics.checkNotNullExpressionValue(tabList, "rsp.raw.commonRsp.tabList");
            recommendTabViewModel.g2(1, c16, tabList);
        }
    }

    @NotNull
    public final Flow<NetTransaction<bv, ? extends e>> g(boolean useCache) {
        bv b16 = this.networkContext.b();
        Intrinsics.checkNotNullExpressionValue(b16, "networkContext.constructRefresh()");
        return b(b16, useCache, true);
    }
}

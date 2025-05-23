package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.guild.discoveryv2.net.NetworkCacheManager;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.bj;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.au;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel$networkHelper$1", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bj;", "req", "", "useCache", "updateCache", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/d;", "a", "d", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/net/NetworkCacheManager;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/NetworkCacheManager;", "networkManager", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendViewModel$networkHelper$1 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NetworkCacheManager<bj, d> networkManager;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RecommendViewModel f217006b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "code", "", "kotlin.jvm.PlatformType", "msg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetContentRecommendRsp;", "data", "", "buf", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetContentRecommendRsp;[B)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    static final class a implements au {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<d, Unit> f217007a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super d, Unit> function1) {
            this.f217007a = function1;
        }

        @Override // wh2.au
        public final void a(int i3, String str, IGProGetContentRecommendRsp iGProGetContentRecommendRsp, byte[] bArr) {
            Function1<d, Unit> function1 = this.f217007a;
            if (str == null) {
                str = "";
            }
            ri1.a b16 = ri1.a.b(i3, str);
            Intrinsics.checkNotNullExpressionValue(b16, "error(code, msg ?: \"\")");
            if (bArr == null) {
                bArr = new byte[0];
            }
            function1.invoke(new d(b16, iGProGetContentRecommendRsp, bArr));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/RecommendViewModel$networkHelper$1$b", "Lcom/tencent/mobileqq/guild/discoveryv2/net/b;", "key", "value", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;)V", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.discoveryv2.net.b<bj, d> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MMKVOptionEntity f217008a;

        public b(MMKVOptionEntity mMKVOptionEntity) {
            this.f217008a = mMKVOptionEntity;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.net.b
        @Nullable
        public d a(bj key) {
            boolean z16;
            byte[] decodeBytes = this.f217008a.decodeBytes(ch.g() + "_GWGProGetContentRecommendReq", null);
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
            return new d(f16, IGProDataApi.INSTANCE.a().fastDecodeMVPFeedsRspPb(decodeBytes), null, 4, null);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.net.b
        public void b(bj key, d value) {
            d dVar = value;
            byte[] buffer = dVar.getBuffer();
            if (!dVar.getResult().d()) {
                buffer = null;
            }
            if (buffer != null) {
                this.f217008a.encodeBytes(ch.g() + "_GWGProGetContentRecommendReq", buffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecommendViewModel$networkHelper$1(RecommendViewModel recommendViewModel) {
        this.f217006b = recommendViewModel;
        MMKVOptionEntityV2 value = TabsSnapshot.f217705a.b().getValue();
        Intrinsics.checkNotNullExpressionValue(value, "TabsSnapshot.mmkv.value");
        this.networkManager = new NetworkCacheManager<>(new b(value), new RecommendViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1(18000L, null, recommendViewModel));
    }

    private final Flow<NetTransaction<bj, ? extends d>> a(bj req, boolean useCache, boolean updateCache) {
        return FlowKt.onEach(FlowKt.onEach(this.networkManager.c(req, useCache, updateCache), new RecommendViewModel$networkHelper$1$innerFetch$1(this.f217006b, null)), new RecommendViewModel$networkHelper$1$innerFetch$2(this.f217006b, null));
    }

    static /* synthetic */ Flow b(RecommendViewModel$networkHelper$1 recommendViewModel$networkHelper$1, bj bjVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return recommendViewModel$networkHelper$1.a(bjVar, z16, z17);
    }

    @NotNull
    public final Flow<NetTransaction<bj, ? extends d>> c() {
        RecommendViewModel.b bVar;
        bVar = this.f217006b.networkContext;
        return b(this, bVar.a(), false, false, 6, null);
    }

    @NotNull
    public final Flow<NetTransaction<bj, ? extends d>> d(boolean useCache) {
        RecommendViewModel.b bVar;
        bVar = this.f217006b.networkContext;
        return a(bVar.b(), useCache, true);
    }
}

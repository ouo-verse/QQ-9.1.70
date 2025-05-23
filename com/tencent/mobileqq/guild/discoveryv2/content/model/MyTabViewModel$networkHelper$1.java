package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.guild.discoveryv2.net.NetworkCacheManager;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetMyTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.br;
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
import wh2.cp;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J$\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007J\u001c\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\t0\bJ\u0006\u0010\u0010\u001a\u00020\u000eR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R(\u0010\u0019\u001a\u0016\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/MyTabViewModel$networkHelper$1", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/br;", "req", "", "useCache", "updateCache", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/c;", "b", "g", "d", "transaction", "", "f", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/net/a;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/net/a;", "()Lcom/tencent/mobileqq/guild/discoveryv2/net/a;", "adDecorator", "Lcom/tencent/mobileqq/guild/discoveryv2/net/d;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/guild/discoveryv2/net/d;", "networkContext", "Lcom/tencent/mobileqq/guild/discoveryv2/net/NetworkCacheManager;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/net/NetworkCacheManager;", "networkManager", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyTabViewModel$networkHelper$1 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.net.a adDecorator = new com.tencent.mobileqq.guild.discoveryv2.net.a(81);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.net.d<br, c> networkContext = new com.tencent.mobileqq.guild.discoveryv2.net.d<>(new Function1<br, eu>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$networkContext$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final eu invoke(@NotNull br GProTabNetContext) {
            Intrinsics.checkNotNullParameter(GProTabNetContext, "$this$GProTabNetContext");
            eu commonReq = GProTabNetContext.a();
            Intrinsics.checkNotNullExpressionValue(commonReq, "commonReq");
            return commonReq;
        }
    }, new Function1<c, IGProTabContentCommonRsp>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$networkContext$2
        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final IGProTabContentCommonRsp invoke(@NotNull c GProTabNetContext) {
            Intrinsics.checkNotNullParameter(GProTabNetContext, "$this$GProTabNetContext");
            IGProGetMyTabContentRsp raw = GProTabNetContext.getRaw();
            if (raw != null) {
                return raw.getCommonRsp();
            }
            return null;
        }
    }, new Function0<br>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$special$$inlined$GProTabNetContext$1
        /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.qqguildsdk.data.genc.br, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public final br invoke() {
            return br.class.newInstance();
        }
    }, (com.tencent.mobileqq.guild.discoveryv2.net.f[]) Arrays.copyOf(new com.tencent.mobileqq.guild.discoveryv2.net.f[]{new com.tencent.mobileqq.guild.discoveryv2.net.c("GWGProGetMyTabContentReq"), new com.tencent.mobileqq.guild.discoveryv2.net.a(81)}, 2));

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NetworkCacheManager<br, c> networkManager;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MyTabViewModel f216977d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/MyTabViewModel$networkHelper$1$a", "Lwh2/cp;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetMyTabContentRsp;", "rsp", "", "rspBuf", "", "hasJoinedGuild", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements cp {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<c, Unit> f216978a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super c, Unit> function1) {
            this.f216978a = function1;
        }

        @Override // wh2.cp
        public void a(int result, @Nullable String errMsg, @Nullable IGProGetMyTabContentRsp rsp, @Nullable byte[] rspBuf, boolean hasJoinedGuild) {
            Function1<c, Unit> function1 = this.f216978a;
            if (errMsg == null) {
                errMsg = "";
            }
            ri1.a b16 = ri1.a.b(result, errMsg);
            Intrinsics.checkNotNullExpressionValue(b16, "error(result, errMsg ?: \"\")");
            boolean z16 = !hasJoinedGuild;
            if (rspBuf == null) {
                rspBuf = new byte[0];
            }
            function1.invoke(new c(b16, rsp, z16, rspBuf));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/model/MyTabViewModel$networkHelper$1$b", "Lcom/tencent/mobileqq/guild/discoveryv2/net/b;", "key", "value", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;)V", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.discoveryv2.net.b<br, c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MMKVOptionEntity f216979a;

        public b(MMKVOptionEntity mMKVOptionEntity) {
            this.f216979a = mMKVOptionEntity;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.net.b
        @Nullable
        public c a(br key) {
            boolean z16;
            byte[] decodeBytes = this.f216979a.decodeBytes(ch.g() + "_GWGProGetMyTabContentRsp", null);
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
            return new c(f16, IGProDataApi.INSTANCE.a().decodeGProGetMyTabContentRsp(decodeBytes), false, null, 12, null);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.net.b
        public void b(br key, c value) {
            c cVar = value;
            byte[] buffer = cVar.getBuffer();
            if (!cVar.getResult().d()) {
                buffer = null;
            }
            if (buffer != null) {
                this.f216979a.encodeBytes(ch.g() + "_GWGProGetMyTabContentRsp", buffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyTabViewModel$networkHelper$1(MyTabViewModel myTabViewModel) {
        this.f216977d = myTabViewModel;
        MMKVOptionEntityV2 value = TabsSnapshot.f217705a.b().getValue();
        Intrinsics.checkNotNullExpressionValue(value, "TabsSnapshot.mmkv.value");
        this.networkManager = new NetworkCacheManager<>(new b(value), new MyTabViewModel$networkHelper$1$special$$inlined$NetworkCacheManager$1(18000L, null, myTabViewModel));
    }

    private final Flow<NetTransaction<br, ? extends c>> b(br req, boolean useCache, boolean updateCache) {
        return FlowKt.onEach(FlowKt.onEach(this.networkManager.c(req, useCache, updateCache), new MyTabViewModel$networkHelper$1$innerFetch$1(this.f216977d, null)), new MyTabViewModel$networkHelper$1$innerFetch$2(this, null));
    }

    static /* synthetic */ Flow c(MyTabViewModel$networkHelper$1 myTabViewModel$networkHelper$1, br brVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return myTabViewModel$networkHelper$1.b(brVar, z16, z17);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.guild.discoveryv2.net.a getAdDecorator() {
        return this.adDecorator;
    }

    @NotNull
    public final Flow<NetTransaction<br, ? extends c>> d() {
        br a16 = this.networkContext.a();
        Intrinsics.checkNotNullExpressionValue(a16, "networkContext.constructMore()");
        return c(this, a16, false, false, 6, null);
    }

    public final void e() {
        this.networkContext.c();
    }

    public final void f(@NotNull NetTransaction<br, ? extends c> transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        br a16 = transaction.a();
        c b16 = transaction.b();
        if (transaction.getFrom() == DataType.NET && b16.getResult().d() && b16.getRaw() != null) {
            this.networkContext.d(a16, b16);
            MyTabViewModel myTabViewModel = this.f216977d;
            byte[] buffer = b16.getBuffer();
            ArrayList<IGProNavigationTab> tabList = b16.getRaw().getCommonRsp().getTabList();
            Intrinsics.checkNotNullExpressionValue(tabList, "rsp.raw.commonRsp.tabList");
            myTabViewModel.g2(1, buffer, tabList);
        }
    }

    @NotNull
    public final Flow<NetTransaction<br, ? extends c>> g(boolean useCache) {
        br b16 = this.networkContext.b();
        Intrinsics.checkNotNullExpressionValue(b16, "networkContext.constructRefresh()");
        return b(b16, useCache, true);
    }
}

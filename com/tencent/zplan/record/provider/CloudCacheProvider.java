package com.tencent.zplan.record.provider;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.model.AbsRecordRequestParams;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import com.tencent.zplan.record.provider.helper.SPQSCloudCacheHelper;
import com.tencent.zplan.record.provider.helper.SPQSResourceUploader;
import com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper;
import com.tencent.zplan.record.provider.helper.Z1ResourceUploader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yx4.c;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\rB\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b!\u0010\u001fJ\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J%\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00172\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0016H\u0016J!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0004\u0018\u00010\u00018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/zplan/record/provider/CloudCacheProvider;", "Lcom/tencent/zplan/record/provider/a;", "", "Lcom/tencent/zplan/record/model/a;", ForwardMiniChooseFriendOption.RESULT_LIST, "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "params", "Lcom/tencent/zplan/record/provider/helper/a;", "i", "", "key", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "a", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "", "timeout", "j", "(Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;Lcom/tencent/zplan/record/model/SingleRecordRequestParams;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchKey", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "Lkotlinx/coroutines/flow/Flow;", "c", "l", "(Lcom/tencent/zplan/record/model/AbsRecordRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/zplan/record/provider/a;", h.F, "()Lcom/tencent/zplan/record/provider/a;", "b", "(Lcom/tencent/zplan/record/provider/a;)V", "nextProvider", "<init>", "e", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class CloudCacheProvider implements a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f386095b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy f386096c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy f386097d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a nextProvider;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/zplan/record/provider/CloudCacheProvider$a;", "", "Lby4/a;", "Lcom/tencent/zplan/record/model/a;", "cacheResult", "", "e", "Lyx4/c;", "proxy$delegate", "Lkotlin/Lazy;", "d", "()Lyx4/c;", "proxy", "", "CLOUD_CACHE_TIMEOUT$delegate", "b", "()J", "CLOUD_CACHE_TIMEOUT", "Lyx4/c$b;", "cloudCommonConfig$delegate", "c", "()Lyx4/c$b;", "cloudCommonConfig", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.provider.CloudCacheProvider$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(ZPlanRecordResourceStatistic zPlanRecordResourceStatistic, CloudRecordResult cloudRecordResult) {
            String str;
            boolean g16 = cloudRecordResult.g();
            zPlanRecordResourceStatistic.o(g16);
            zPlanRecordResourceStatistic.l(Integer.valueOf(cloudRecordResult.getErrorCode()));
            zPlanRecordResourceStatistic.m(cloudRecordResult.getErrorMessage());
            zPlanRecordResourceStatistic.n(cloudRecordResult.getTimeCost());
            if (g16) {
                zPlanRecordResourceStatistic.u(g16);
                ZPlanRecordResource resource = cloudRecordResult.getResource();
                if (resource != null) {
                    str = resource.getRemoteUrl();
                } else {
                    str = null;
                }
                zPlanRecordResourceStatistic.p(str);
            }
        }

        public final long b() {
            return ((Number) CloudCacheProvider.f386096c.getValue()).longValue();
        }

        @NotNull
        public final c.CloudCommonConfig c() {
            return (c.CloudCommonConfig) CloudCacheProvider.f386097d.getValue();
        }

        @NotNull
        public final c d() {
            return (c) CloudCacheProvider.f386095b.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.zplan.record.provider.CloudCacheProvider$Companion$proxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                Object a16 = mx4.a.f417748a.a(c.class);
                Intrinsics.checkNotNull(a16);
                return (c) a16;
            }
        });
        f386095b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.zplan.record.provider.CloudCacheProvider$Companion$CLOUD_CACHE_TIMEOUT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2() {
                long m3 = CloudCacheProvider.INSTANCE.d().m();
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "[ZPlanRRC]CloudCacheProvider", 1, "CLOUD_CACHE_TIMEOUT:" + m3, null, 8, null);
                }
                return m3;
            }
        });
        f386096c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<c.CloudCommonConfig>() { // from class: com.tencent.zplan.record.provider.CloudCacheProvider$Companion$cloudCommonConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c.CloudCommonConfig invoke() {
                c.CloudCommonConfig a16 = CloudCacheProvider.INSTANCE.d().a();
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.c(a17, "[ZPlanRRC]CloudCacheProvider", 1, "CLOUD_COMMON_CONFIG:" + a16, null, 8, null);
                }
                return a16;
            }
        });
        f386097d = lazy3;
    }

    public CloudCacheProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.zplan.record.provider.helper.a i(List<CloudRecordResult> results, AbsRecordRequestParams params) {
        boolean z16;
        int collectionSizeOrDefault;
        boolean z17;
        List<CloudRecordResult> list = results;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (INSTANCE.c().getEnableSuperQQShowBackend()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : results) {
                CloudRecordResult cloudRecordResult = (CloudRecordResult) obj;
                if (!cloudRecordResult.g() && (cloudRecordResult.getRawData() instanceof fv4.d) && ((fv4.d) cloudRecordResult.getRawData()).f400868b == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object rawData = ((CloudRecordResult) it.next()).getRawData();
                if (rawData != null) {
                    arrayList2.add((fv4.d) rawData);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.record_manage.record_manage.nano.RecordResult");
                }
            }
            if (!(!arrayList2.isEmpty())) {
                return null;
            }
            return SPQSResourceUploader.INSTANCE.a(params, arrayList2);
        }
        return Z1ResourceUploader.INSTANCE.c(params);
    }

    static /* synthetic */ Object k(CloudCacheProvider cloudCacheProvider, MemeZPlanBaseAction memeZPlanBaseAction, SingleRecordRequestParams singleRecordRequestParams, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = INSTANCE.b();
        }
        return cloudCacheProvider.j(memeZPlanBaseAction, singleRecordRequestParams, j3, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    @Override // com.tencent.zplan.record.provider.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull String str, @NotNull SingleRecordRequestParams singleRecordRequestParams, @NotNull Continuation<? super ZPlanRecordResource> continuation) {
        CloudCacheProvider$recordSingle$1 cloudCacheProvider$recordSingle$1;
        Object coroutine_suspended;
        int i3;
        String str2;
        String str3;
        CloudCacheProvider cloudCacheProvider;
        SingleRecordRequestParams singleRecordRequestParams2;
        ZPlanRecordResourceStatistic zPlanRecordResourceStatistic;
        CloudRecordResult cloudRecordResult;
        List<CloudRecordResult> listOf;
        Object obj;
        CloudCacheProvider$recordSingle$1 cloudCacheProvider$recordSingle$12;
        Object h16;
        ZPlanRecordResource zPlanRecordResource;
        if (continuation instanceof CloudCacheProvider$recordSingle$1) {
            cloudCacheProvider$recordSingle$1 = (CloudCacheProvider$recordSingle$1) continuation;
            int i16 = cloudCacheProvider$recordSingle$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                cloudCacheProvider$recordSingle$1.label = i16 - Integer.MIN_VALUE;
                CloudCacheProvider$recordSingle$1 cloudCacheProvider$recordSingle$13 = cloudCacheProvider$recordSingle$1;
                Object obj2 = cloudCacheProvider$recordSingle$13.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = cloudCacheProvider$recordSingle$13.label;
                String str4 = "recordSingle key:";
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        ResultKt.throwOnFailure(obj2);
                                        return (ZPlanRecordResource) obj2;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                                return (ZPlanRecordResource) obj2;
                            }
                            zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) cloudCacheProvider$recordSingle$13.L$3;
                            singleRecordRequestParams2 = (SingleRecordRequestParams) cloudCacheProvider$recordSingle$13.L$2;
                            str3 = (String) cloudCacheProvider$recordSingle$13.L$1;
                            cloudCacheProvider = (CloudCacheProvider) cloudCacheProvider$recordSingle$13.L$0;
                            ResultKt.throwOnFailure(obj2);
                            h16 = obj2;
                            obj = coroutine_suspended;
                            cloudCacheProvider$recordSingle$12 = cloudCacheProvider$recordSingle$13;
                            zPlanRecordResource = (ZPlanRecordResource) h16;
                            if (zPlanRecordResource != null) {
                                zPlanRecordResource.s(zPlanRecordResourceStatistic);
                            } else {
                                zPlanRecordResource = null;
                            }
                            if (zPlanRecordResource == null) {
                                d a16 = LogUtil.f385285b.a();
                                if (a16 != null) {
                                    d.a.b(a16, "[ZPlanRRC]CloudCacheProvider", 1, str4 + str3 + ", cloud cache download fail. try nextProvider:" + cloudCacheProvider.getNextProvider(), null, 8, null);
                                }
                                a nextProvider = cloudCacheProvider.getNextProvider();
                                if (nextProvider == null) {
                                    return null;
                                }
                                cloudCacheProvider$recordSingle$12.L$0 = null;
                                cloudCacheProvider$recordSingle$12.L$1 = null;
                                cloudCacheProvider$recordSingle$12.L$2 = null;
                                cloudCacheProvider$recordSingle$12.L$3 = null;
                                cloudCacheProvider$recordSingle$12.label = 4;
                                obj2 = nextProvider.a(str3, singleRecordRequestParams2, cloudCacheProvider$recordSingle$12);
                                if (obj2 == obj) {
                                    return obj;
                                }
                                return (ZPlanRecordResource) obj2;
                            }
                            return zPlanRecordResource;
                        }
                        zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) cloudCacheProvider$recordSingle$13.L$3;
                        singleRecordRequestParams2 = (SingleRecordRequestParams) cloudCacheProvider$recordSingle$13.L$2;
                        str3 = (String) cloudCacheProvider$recordSingle$13.L$1;
                        cloudCacheProvider = (CloudCacheProvider) cloudCacheProvider$recordSingle$13.L$0;
                        ResultKt.throwOnFailure(obj2);
                        str2 = "recordSingle key:";
                        ZPlanResourceManager zPlanResourceManager = ZPlanResourceManager.f386013d;
                        boolean downloadFromNetIfLocalAbsent = singleRecordRequestParams2.getDownloadFromNetIfLocalAbsent();
                        cloudCacheProvider$recordSingle$13.L$0 = cloudCacheProvider;
                        cloudCacheProvider$recordSingle$13.L$1 = str3;
                        cloudCacheProvider$recordSingle$13.L$2 = singleRecordRequestParams2;
                        cloudCacheProvider$recordSingle$13.L$3 = zPlanRecordResourceStatistic;
                        cloudCacheProvider$recordSingle$13.label = 3;
                        str4 = str2;
                        obj = coroutine_suspended;
                        cloudCacheProvider$recordSingle$12 = cloudCacheProvider$recordSingle$13;
                        h16 = ZPlanResourceManager.h(zPlanResourceManager, str3, null, null, downloadFromNetIfLocalAbsent, cloudCacheProvider$recordSingle$13, 6, null);
                        if (h16 == obj) {
                            return obj;
                        }
                        zPlanRecordResource = (ZPlanRecordResource) h16;
                        if (zPlanRecordResource != null) {
                        }
                        if (zPlanRecordResource == null) {
                        }
                    } else {
                        zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) cloudCacheProvider$recordSingle$13.L$3;
                        singleRecordRequestParams2 = (SingleRecordRequestParams) cloudCacheProvider$recordSingle$13.L$2;
                        str3 = (String) cloudCacheProvider$recordSingle$13.L$1;
                        cloudCacheProvider = (CloudCacheProvider) cloudCacheProvider$recordSingle$13.L$0;
                        ResultKt.throwOnFailure(obj2);
                        str2 = "recordSingle key:";
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    ZPlanRecordResourceStatistic b16 = ZPlanRecordResourceStatistic.INSTANCE.b(Source.CLOUD_CACHE, singleRecordRequestParams.getResourceId(), singleRecordRequestParams);
                    MemeZPlanAction a17 = singleRecordRequestParams.a();
                    cloudCacheProvider$recordSingle$13.L$0 = this;
                    cloudCacheProvider$recordSingle$13.L$1 = str;
                    cloudCacheProvider$recordSingle$13.L$2 = singleRecordRequestParams;
                    cloudCacheProvider$recordSingle$13.L$3 = b16;
                    cloudCacheProvider$recordSingle$13.label = 1;
                    str2 = "recordSingle key:";
                    obj2 = k(this, a17, singleRecordRequestParams, 0L, cloudCacheProvider$recordSingle$13, 4, null);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str3 = str;
                    cloudCacheProvider = this;
                    singleRecordRequestParams2 = singleRecordRequestParams;
                    zPlanRecordResourceStatistic = b16;
                }
                cloudRecordResult = (CloudRecordResult) obj2;
                INSTANCE.e(zPlanRecordResourceStatistic, cloudRecordResult);
                zPlanRecordResourceStatistic.k();
                if (!cloudRecordResult.g()) {
                    d a18 = LogUtil.f385285b.a();
                    if (a18 != null) {
                        d.a.c(a18, "[ZPlanRRC]CloudCacheProvider", 1, str2 + str3 + ", end by cloud cache, result:" + cloudRecordResult, null, 8, null);
                    }
                    ZPlanRecordResource resource = cloudRecordResult.getResource();
                    if (resource != null) {
                        resource.s(zPlanRecordResourceStatistic);
                    }
                    ZPlanResourceManager zPlanResourceManager2 = ZPlanResourceManager.f386013d;
                    ZPlanRecordResource resource2 = cloudRecordResult.getResource();
                    Intrinsics.checkNotNull(resource2);
                    boolean downloadFromNetIfLocalAbsent2 = singleRecordRequestParams2.getDownloadFromNetIfLocalAbsent();
                    cloudCacheProvider$recordSingle$13.L$0 = cloudCacheProvider;
                    cloudCacheProvider$recordSingle$13.L$1 = str3;
                    cloudCacheProvider$recordSingle$13.L$2 = singleRecordRequestParams2;
                    cloudCacheProvider$recordSingle$13.L$3 = zPlanRecordResourceStatistic;
                    cloudCacheProvider$recordSingle$13.label = 2;
                    if (zPlanResourceManager2.b(str3, resource2, downloadFromNetIfLocalAbsent2, cloudCacheProvider$recordSingle$13) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ZPlanResourceManager zPlanResourceManager3 = ZPlanResourceManager.f386013d;
                    boolean downloadFromNetIfLocalAbsent3 = singleRecordRequestParams2.getDownloadFromNetIfLocalAbsent();
                    cloudCacheProvider$recordSingle$13.L$0 = cloudCacheProvider;
                    cloudCacheProvider$recordSingle$13.L$1 = str3;
                    cloudCacheProvider$recordSingle$13.L$2 = singleRecordRequestParams2;
                    cloudCacheProvider$recordSingle$13.L$3 = zPlanRecordResourceStatistic;
                    cloudCacheProvider$recordSingle$13.label = 3;
                    str4 = str2;
                    obj = coroutine_suspended;
                    cloudCacheProvider$recordSingle$12 = cloudCacheProvider$recordSingle$13;
                    h16 = ZPlanResourceManager.h(zPlanResourceManager3, str3, null, null, downloadFromNetIfLocalAbsent3, cloudCacheProvider$recordSingle$13, 6, null);
                    if (h16 == obj) {
                    }
                    zPlanRecordResource = (ZPlanRecordResource) h16;
                    if (zPlanRecordResource != null) {
                    }
                    if (zPlanRecordResource == null) {
                    }
                } else {
                    String str5 = str2;
                    d a19 = LogUtil.f385285b.a();
                    if (a19 != null) {
                        d.a.c(a19, "[ZPlanRRC]CloudCacheProvider", 1, str5 + str3 + ", cloud cache fail. try nextProvider:" + cloudCacheProvider.getNextProvider(), null, 8, null);
                    }
                    a nextProvider2 = cloudCacheProvider.getNextProvider();
                    if (!(nextProvider2 instanceof LocalRecordProvider)) {
                        nextProvider2 = null;
                    }
                    LocalRecordProvider localRecordProvider = (LocalRecordProvider) nextProvider2;
                    if (localRecordProvider != null) {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(cloudRecordResult);
                        localRecordProvider.i(cloudCacheProvider.i(listOf, singleRecordRequestParams2));
                    }
                    a nextProvider3 = cloudCacheProvider.getNextProvider();
                    if (nextProvider3 == null) {
                        return null;
                    }
                    cloudCacheProvider$recordSingle$13.L$0 = null;
                    cloudCacheProvider$recordSingle$13.L$1 = null;
                    cloudCacheProvider$recordSingle$13.L$2 = null;
                    cloudCacheProvider$recordSingle$13.L$3 = null;
                    cloudCacheProvider$recordSingle$13.label = 5;
                    obj2 = nextProvider3.a(str3, singleRecordRequestParams2, cloudCacheProvider$recordSingle$13);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (ZPlanRecordResource) obj2;
                }
            }
        }
        cloudCacheProvider$recordSingle$1 = new CloudCacheProvider$recordSingle$1(this, continuation);
        CloudCacheProvider$recordSingle$1 cloudCacheProvider$recordSingle$132 = cloudCacheProvider$recordSingle$1;
        Object obj22 = cloudCacheProvider$recordSingle$132.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = cloudCacheProvider$recordSingle$132.label;
        String str42 = "recordSingle key:";
        if (i3 == 0) {
        }
        cloudRecordResult = (CloudRecordResult) obj22;
        INSTANCE.e(zPlanRecordResourceStatistic, cloudRecordResult);
        zPlanRecordResourceStatistic.k();
        if (!cloudRecordResult.g()) {
        }
    }

    @Override // com.tencent.zplan.record.provider.a
    public void b(@Nullable a aVar) {
        this.nextProvider = aVar;
    }

    @Override // com.tencent.zplan.record.provider.a
    @NotNull
    public Flow<ZPlanRecordResource> c(@NotNull String batchKey, @NotNull BatchRecordRequestParams params) {
        Intrinsics.checkNotNullParameter(batchKey, "batchKey");
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.callbackFlow(new CloudCacheProvider$recordBatch$1(this, params, batchKey, null));
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public a getNextProvider() {
        return this.nextProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object j(MemeZPlanBaseAction memeZPlanBaseAction, SingleRecordRequestParams singleRecordRequestParams, long j3, Continuation<? super CloudRecordResult> continuation) {
        CloudCacheProvider$recordSingleByCloudCacheWithTimeout$1 cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1;
        Object coroutine_suspended;
        int i3;
        try {
            if (continuation instanceof CloudCacheProvider$recordSingleByCloudCacheWithTimeout$1) {
                cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1 = (CloudCacheProvider$recordSingleByCloudCacheWithTimeout$1) continuation;
                int i16 = cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            memeZPlanBaseAction = (MemeZPlanBaseAction) cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2 cloudCacheProvider$recordSingleByCloudCacheWithTimeout$2 = new CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2(this, singleRecordRequestParams, memeZPlanBaseAction, null);
                        cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.L$0 = memeZPlanBaseAction;
                        cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.label = 1;
                        obj = TimeoutKt.withTimeout(j3, cloudCacheProvider$recordSingleByCloudCacheWithTimeout$2, cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return (CloudRecordResult) obj;
                }
            }
            if (i3 == 0) {
            }
            return (CloudRecordResult) obj;
        } catch (TimeoutCancellationException unused) {
            return Z1CloudCacheHelper.f386141d.g(memeZPlanBaseAction.getActionId(), INSTANCE.b());
        }
        cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1 = new CloudCacheProvider$recordSingleByCloudCacheWithTimeout$1(this, continuation);
        Object obj2 = cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = cloudCacheProvider$recordSingleByCloudCacheWithTimeout$1.label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object l(AbsRecordRequestParams absRecordRequestParams, Continuation<? super Flow<CloudRecordResult>> continuation) {
        CloudCacheProvider$requestResourceByCloudCache$1 cloudCacheProvider$requestResourceByCloudCache$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof CloudCacheProvider$requestResourceByCloudCache$1) {
            cloudCacheProvider$requestResourceByCloudCache$1 = (CloudCacheProvider$requestResourceByCloudCache$1) continuation;
            int i16 = cloudCacheProvider$requestResourceByCloudCache$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                cloudCacheProvider$requestResourceByCloudCache$1.label = i16 - Integer.MIN_VALUE;
                Object obj = cloudCacheProvider$requestResourceByCloudCache$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = cloudCacheProvider$requestResourceByCloudCache$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (INSTANCE.c().getEnableSuperQQShowBackend()) {
                        SPQSCloudCacheHelper sPQSCloudCacheHelper = SPQSCloudCacheHelper.f386123d;
                        cloudCacheProvider$requestResourceByCloudCache$1.label = 1;
                        obj = sPQSCloudCacheHelper.h(absRecordRequestParams, cloudCacheProvider$requestResourceByCloudCache$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Z1CloudCacheHelper.f386141d.k(absRecordRequestParams);
                    }
                }
                return (Flow) obj;
            }
        }
        cloudCacheProvider$requestResourceByCloudCache$1 = new CloudCacheProvider$requestResourceByCloudCache$1(this, continuation);
        Object obj2 = cloudCacheProvider$requestResourceByCloudCache$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = cloudCacheProvider$requestResourceByCloudCache$1.label;
        if (i3 == 0) {
        }
        return (Flow) obj2;
    }

    public CloudCacheProvider(@Nullable a aVar) {
        this.nextProvider = aVar;
    }

    public /* synthetic */ CloudCacheProvider(a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar);
    }
}

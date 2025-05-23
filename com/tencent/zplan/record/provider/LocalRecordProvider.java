package com.tencent.zplan.record.provider;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.common.utils.c;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.a;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wx4.d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001\u0007B\u0013\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b \u0010\u001eJ%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0016J/\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001a\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/zplan/record/provider/LocalRecordProvider;", "Lcom/tencent/zplan/record/provider/a;", "", "key", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "a", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchKey", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "Lkotlinx/coroutines/flow/Flow;", "c", "Lcom/tencent/zplan/record/provider/helper/a;", "uploader", "e", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Lcom/tencent/zplan/record/provider/helper/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Pair;", "", "Lcom/tencent/zplan/meme/model/MemeResult;", h.F, "Lcom/tencent/zplan/record/provider/helper/a;", "g", "()Lcom/tencent/zplan/record/provider/helper/a;", "i", "(Lcom/tencent/zplan/record/provider/helper/a;)V", "b", "Lcom/tencent/zplan/record/provider/a;", "f", "()Lcom/tencent/zplan/record/provider/a;", "(Lcom/tencent/zplan/record/provider/a;)V", "nextProvider", "<init>", "d", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class LocalRecordProvider implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.zplan.record.provider.helper.a uploader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a nextProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, com.tencent.zplan.meme.a> f386113c = new LinkedHashMap();

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001e\u0010\u0013\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u0010\u0015\u001a\u00020\u0003*\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/zplan/record/provider/LocalRecordProvider$a;", "", "Lby4/a;", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "localResult", "", "timeCost", "", "localPath", "", "d", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "", "resourceId", "Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "c", "other", "e", "TAG", "Ljava/lang/String;", "", "Lcom/tencent/zplan/meme/a;", "listenerMap", "Ljava/util/Map;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.provider.LocalRecordProvider$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SingleRecordRequestParams c(BatchRecordRequestParams batchRecordRequestParams, int i3, BusinessConfig businessConfig) {
            BusinessConfig businessConfig2;
            String str;
            BusinessConfig a16;
            EngineType engineType = null;
            if (businessConfig != null) {
                BusinessConfig businessConfig3 = batchRecordRequestParams.q().get(Integer.valueOf(i3));
                if (businessConfig3 != null) {
                    str = businessConfig3.getStickerData();
                } else {
                    str = null;
                }
                a16 = businessConfig.a((r35 & 1) != 0 ? businessConfig.backgroundColor : 0, (r35 & 2) != 0 ? businessConfig.flipVertical : false, (r35 & 4) != 0 ? businessConfig.saveEachFrame2File : false, (r35 & 8) != 0 ? businessConfig.callbackEachFrameData : false, (r35 & 16) != 0 ? businessConfig.frameType : null, (r35 & 32) != 0 ? businessConfig.maxFrameCount : 0, (r35 & 64) != 0 ? businessConfig.optimization : null, (r35 & 128) != 0 ? businessConfig.camera : null, (r35 & 256) != 0 ? businessConfig.aaType : null, (r35 & 512) != 0 ? businessConfig.aaLevel : null, (r35 & 1024) != 0 ? businessConfig.mp4Config : null, (r35 & 2048) != 0 ? businessConfig.skipHotPatch : null, (r35 & 4096) != 0 ? businessConfig.stickerData : String.valueOf(str), (r35 & 8192) != 0 ? businessConfig.useRecordV2 : false, (r35 & 16384) != 0 ? businessConfig.enableUserData : null, (r35 & 32768) != 0 ? businessConfig.actionStyle : 0, (r35 & 65536) != 0 ? businessConfig.disableGlassesMetallic : null);
                businessConfig2 = a16;
            } else {
                businessConfig2 = null;
            }
            if (businessConfig2 != null) {
                if (businessConfig != null) {
                    engineType = businessConfig.getTargetEngine();
                }
                businessConfig2.G(engineType);
            }
            return new SingleRecordRequestParams(i3, batchRecordRequestParams.getSender(), batchRecordRequestParams.getReceiver(), batchRecordRequestParams.getWidth(), batchRecordRequestParams.getHeight(), batchRecordRequestParams.getMode(), businessConfig2, batchRecordRequestParams.getScene(), batchRecordRequestParams.getTheme(), batchRecordRequestParams.getPriority(), batchRecordRequestParams.getUploadConfig(), batchRecordRequestParams.getExpireConfig(), 0, false, batchRecordRequestParams.getCom.tencent.mobileqq.activity.QQBrowserActivity.APP_PARAM java.lang.String(), null, 45056, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(ZPlanRecordResourceStatistic zPlanRecordResourceStatistic, boolean z16, MemeResult memeResult, long j3, String str) {
            boolean z17;
            zPlanRecordResourceStatistic.u(z16);
            d i3 = memeResult.i();
            int i16 = 0;
            if (i3 != null) {
                z17 = i3.getHitCache();
            } else {
                z17 = false;
            }
            zPlanRecordResourceStatistic.o(z17);
            if (zPlanRecordResourceStatistic.getHitCache()) {
                d i17 = memeResult.i();
                if (i17 != null) {
                    i16 = i17.getErrCode();
                }
                zPlanRecordResourceStatistic.l(Integer.valueOf(i16));
                zPlanRecordResourceStatistic.n(j3);
            } else {
                d i18 = memeResult.i();
                if (i18 != null) {
                    i16 = i18.getErrCode();
                }
                zPlanRecordResourceStatistic.r(Integer.valueOf(i16));
                zPlanRecordResourceStatistic.t(j3);
            }
            zPlanRecordResourceStatistic.s(memeResult.e());
            zPlanRecordResourceStatistic.p(str);
            zPlanRecordResourceStatistic.q(memeResult.i());
        }

        public final boolean e(@Nullable String str, @Nullable String str2) {
            boolean startsWith$default;
            if (str == null || str2 == null) {
                return false;
            }
            if (!Intrinsics.areEqual(str, str2)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null);
                if (!startsWith$default) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/record/provider/LocalRecordProvider$b", "Lcom/tencent/zplan/meme/a;", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "", "l9", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements com.tencent.zplan.meme.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f386117d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f386118e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Continuation f386119f;

        b(AtomicBoolean atomicBoolean, String str, Continuation continuation) {
            this.f386117d = atomicBoolean;
            this.f386118e = str;
            this.f386119f = continuation;
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(@NotNull MemeAction action, float f16) {
            Intrinsics.checkNotNullParameter(action, "action");
            a.C10066a.a(this, action, f16);
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean success, @NotNull MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            a.C10066a.b(this, success, result);
            if (this.f386117d.get()) {
                return;
            }
            this.f386117d.set(true);
            LocalRecordProvider.f386113c.remove(this.f386118e);
            this.f386119f.resumeWith(Result.m476constructorimpl(new Pair(Boolean.valueOf(success), result)));
        }
    }

    public LocalRecordProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.zplan.record.provider.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull String str, @NotNull SingleRecordRequestParams singleRecordRequestParams, @NotNull Continuation<? super ZPlanRecordResource> continuation) {
        LocalRecordProvider$recordSingle$1 localRecordProvider$recordSingle$1;
        Object coroutine_suspended;
        int i3;
        LocalRecordProvider localRecordProvider;
        ZPlanRecordResource zPlanRecordResource;
        if (continuation instanceof LocalRecordProvider$recordSingle$1) {
            localRecordProvider$recordSingle$1 = (LocalRecordProvider$recordSingle$1) continuation;
            int i16 = localRecordProvider$recordSingle$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                localRecordProvider$recordSingle$1.label = i16 - Integer.MIN_VALUE;
                Object obj = localRecordProvider$recordSingle$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = localRecordProvider$recordSingle$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return (ZPlanRecordResource) obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    singleRecordRequestParams = (SingleRecordRequestParams) localRecordProvider$recordSingle$1.L$2;
                    str = (String) localRecordProvider$recordSingle$1.L$1;
                    localRecordProvider = (LocalRecordProvider) localRecordProvider$recordSingle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.zplan.record.provider.helper.a aVar = this.uploader;
                    localRecordProvider$recordSingle$1.L$0 = this;
                    localRecordProvider$recordSingle$1.L$1 = str;
                    localRecordProvider$recordSingle$1.L$2 = singleRecordRequestParams;
                    localRecordProvider$recordSingle$1.label = 1;
                    obj = e(str, singleRecordRequestParams, aVar, localRecordProvider$recordSingle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    localRecordProvider = this;
                }
                zPlanRecordResource = (ZPlanRecordResource) obj;
                if (zPlanRecordResource != null) {
                    a nextProvider = localRecordProvider.getNextProvider();
                    if (nextProvider == null) {
                        return null;
                    }
                    localRecordProvider$recordSingle$1.L$0 = null;
                    localRecordProvider$recordSingle$1.L$1 = null;
                    localRecordProvider$recordSingle$1.L$2 = null;
                    localRecordProvider$recordSingle$1.label = 2;
                    obj = nextProvider.a(str, singleRecordRequestParams, localRecordProvider$recordSingle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (ZPlanRecordResource) obj;
                }
                return zPlanRecordResource;
            }
        }
        localRecordProvider$recordSingle$1 = new LocalRecordProvider$recordSingle$1(this, continuation);
        Object obj2 = localRecordProvider$recordSingle$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = localRecordProvider$recordSingle$1.label;
        if (i3 == 0) {
        }
        zPlanRecordResource = (ZPlanRecordResource) obj2;
        if (zPlanRecordResource != null) {
        }
    }

    @Override // com.tencent.zplan.record.provider.a
    public void b(@Nullable a aVar) {
        this.nextProvider = aVar;
    }

    @Override // com.tencent.zplan.record.provider.a
    @NotNull
    public Flow<ZPlanRecordResource> c(@NotNull String batchKey, @NotNull BatchRecordRequestParams params) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(batchKey, "batchKey");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = "batchKey:" + batchKey + ", ids:" + params.x() + ", mode:" + params.getMode() + ", theme:" + params.getTheme();
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[ZPlanRRC]LocalRecordProvider", 1, "recordBatch start, " + str + ", uploader:" + this.uploader, null, 8, null);
        }
        List<Integer> x16 = params.x();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(x16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = x16.iterator();
        while (it.hasNext()) {
            arrayList.add(FlowKt.flow(new LocalRecordProvider$recordBatch$$inlined$map$lambda$1(((Number) it.next()).intValue(), null, this, params, str)));
        }
        return FlowKt.merge(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object e(String str, SingleRecordRequestParams singleRecordRequestParams, com.tencent.zplan.record.provider.helper.a aVar, Continuation<? super ZPlanRecordResource> continuation) {
        LocalRecordProvider$doRecordAndUpload$1 localRecordProvider$doRecordAndUpload$1;
        Object coroutine_suspended;
        int i3;
        String d16;
        ZPlanRecordResourceStatistic b16;
        String str2;
        SingleRecordRequestParams singleRecordRequestParams2;
        com.tencent.zplan.record.provider.helper.a aVar2;
        long j3;
        MemeAction action;
        String str3;
        boolean z16;
        Object obj;
        ZPlanRecordResourceStatistic zPlanRecordResourceStatistic;
        SingleRecordRequestParams singleRecordRequestParams3;
        String str4;
        lx4.d a16;
        ZPlanRecordResource zPlanRecordResource;
        if (continuation instanceof LocalRecordProvider$doRecordAndUpload$1) {
            localRecordProvider$doRecordAndUpload$1 = (LocalRecordProvider$doRecordAndUpload$1) continuation;
            int i16 = localRecordProvider$doRecordAndUpload$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                localRecordProvider$doRecordAndUpload$1.label = i16 - Integer.MIN_VALUE;
                LocalRecordProvider$doRecordAndUpload$1 localRecordProvider$doRecordAndUpload$12 = localRecordProvider$doRecordAndUpload$1;
                Object obj2 = localRecordProvider$doRecordAndUpload$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = localRecordProvider$doRecordAndUpload$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) localRecordProvider$doRecordAndUpload$12.L$0;
                                ResultKt.throwOnFailure(obj2);
                                obj = null;
                                zPlanRecordResource = (ZPlanRecordResource) obj2;
                                if (zPlanRecordResource != null) {
                                    zPlanRecordResource.s(zPlanRecordResourceStatistic);
                                    return zPlanRecordResource;
                                }
                                return obj;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) localRecordProvider$doRecordAndUpload$12.L$2;
                        singleRecordRequestParams3 = (SingleRecordRequestParams) localRecordProvider$doRecordAndUpload$12.L$1;
                        String str5 = (String) localRecordProvider$doRecordAndUpload$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        str4 = str5;
                        ZPlanResourceManager zPlanResourceManager = ZPlanResourceManager.f386013d;
                        boolean downloadFromNetIfLocalAbsent = singleRecordRequestParams3.getDownloadFromNetIfLocalAbsent();
                        localRecordProvider$doRecordAndUpload$12.L$0 = zPlanRecordResourceStatistic;
                        obj = null;
                        localRecordProvider$doRecordAndUpload$12.L$1 = null;
                        localRecordProvider$doRecordAndUpload$12.L$2 = null;
                        localRecordProvider$doRecordAndUpload$12.label = 3;
                        obj2 = ZPlanResourceManager.h(zPlanResourceManager, str4, null, null, downloadFromNetIfLocalAbsent, localRecordProvider$doRecordAndUpload$12, 6, null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanRecordResource = (ZPlanRecordResource) obj2;
                        if (zPlanRecordResource != null) {
                        }
                        return obj;
                    }
                    j3 = localRecordProvider$doRecordAndUpload$12.J$0;
                    b16 = (ZPlanRecordResourceStatistic) localRecordProvider$doRecordAndUpload$12.L$4;
                    d16 = (String) localRecordProvider$doRecordAndUpload$12.L$3;
                    aVar2 = (com.tencent.zplan.record.provider.helper.a) localRecordProvider$doRecordAndUpload$12.L$2;
                    singleRecordRequestParams2 = (SingleRecordRequestParams) localRecordProvider$doRecordAndUpload$12.L$1;
                    str2 = (String) localRecordProvider$doRecordAndUpload$12.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    ResultKt.throwOnFailure(obj2);
                    long i17 = Meme.f385754h.i();
                    d16 = singleRecordRequestParams.a().getSenderInfo().d();
                    b16 = ZPlanRecordResourceStatistic.INSTANCE.b(Source.LOCAL_RECORD, singleRecordRequestParams.getResourceId(), singleRecordRequestParams);
                    localRecordProvider$doRecordAndUpload$12.L$0 = str;
                    localRecordProvider$doRecordAndUpload$12.L$1 = singleRecordRequestParams;
                    localRecordProvider$doRecordAndUpload$12.L$2 = aVar;
                    localRecordProvider$doRecordAndUpload$12.L$3 = d16;
                    localRecordProvider$doRecordAndUpload$12.L$4 = b16;
                    localRecordProvider$doRecordAndUpload$12.J$0 = i17;
                    localRecordProvider$doRecordAndUpload$12.label = 1;
                    Object h16 = h(str, singleRecordRequestParams, localRecordProvider$doRecordAndUpload$12);
                    if (h16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = str;
                    singleRecordRequestParams2 = singleRecordRequestParams;
                    aVar2 = aVar;
                    j3 = i17;
                    obj2 = h16;
                }
                Pair pair = (Pair) obj2;
                boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
                MemeResult memeResult = (MemeResult) pair.component2();
                action = memeResult.getAction();
                if (action == null) {
                    String d17 = ((MemeZPlanBaseAction) action).getSenderInfo().d();
                    Companion companion = INSTANCE;
                    boolean e16 = companion.e(d17, d16);
                    if (!e16 && (a16 = LogUtil.f385285b.a()) != null) {
                        d.a.d(a16, "[ZPlanRRC]LocalRecordProvider", 1, "doRecordAndUpload checkAppearance fail, begin:" + d16 + ", after:" + d17, null, 8, null);
                    }
                    if (booleanValue && c.f385288a.h(memeResult.getRecordPath()) && e16) {
                        str3 = memeResult.getRecordPath();
                    } else {
                        str3 = null;
                    }
                    if (str3 != null && str3.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    boolean z17 = !z16;
                    companion.d(b16, z17, memeResult, Meme.f385754h.i() - j3, str3);
                    if (z17) {
                        ZPlanRecordResource zPlanRecordResource2 = new ZPlanRecordResource(str2, str3, null, ZPlanRecordResource.INSTANCE.a(), 1, singleRecordRequestParams2.getResourceId(), d17, 4, null);
                        zPlanRecordResource2.s(b16);
                        if (aVar2 != null) {
                            aVar2.a(zPlanRecordResource2, memeResult);
                        }
                        ZPlanResourceManager zPlanResourceManager2 = ZPlanResourceManager.f386013d;
                        boolean downloadFromNetIfLocalAbsent2 = singleRecordRequestParams2.getDownloadFromNetIfLocalAbsent();
                        localRecordProvider$doRecordAndUpload$12.L$0 = str2;
                        localRecordProvider$doRecordAndUpload$12.L$1 = singleRecordRequestParams2;
                        localRecordProvider$doRecordAndUpload$12.L$2 = b16;
                        localRecordProvider$doRecordAndUpload$12.L$3 = null;
                        localRecordProvider$doRecordAndUpload$12.L$4 = null;
                        localRecordProvider$doRecordAndUpload$12.label = 2;
                        if (zPlanResourceManager2.b(str2, zPlanRecordResource2, downloadFromNetIfLocalAbsent2, localRecordProvider$doRecordAndUpload$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanRecordResourceStatistic = b16;
                        singleRecordRequestParams3 = singleRecordRequestParams2;
                        str4 = str2;
                        ZPlanResourceManager zPlanResourceManager3 = ZPlanResourceManager.f386013d;
                        boolean downloadFromNetIfLocalAbsent3 = singleRecordRequestParams3.getDownloadFromNetIfLocalAbsent();
                        localRecordProvider$doRecordAndUpload$12.L$0 = zPlanRecordResourceStatistic;
                        obj = null;
                        localRecordProvider$doRecordAndUpload$12.L$1 = null;
                        localRecordProvider$doRecordAndUpload$12.L$2 = null;
                        localRecordProvider$doRecordAndUpload$12.label = 3;
                        obj2 = ZPlanResourceManager.h(zPlanResourceManager3, str4, null, null, downloadFromNetIfLocalAbsent3, localRecordProvider$doRecordAndUpload$12, 6, null);
                        if (obj2 == coroutine_suspended) {
                        }
                        zPlanRecordResource = (ZPlanRecordResource) obj2;
                        if (zPlanRecordResource != null) {
                        }
                        return obj;
                    }
                    obj = null;
                    return obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.zplan.meme.action.MemeZPlanBaseAction");
            }
        }
        localRecordProvider$doRecordAndUpload$1 = new LocalRecordProvider$doRecordAndUpload$1(this, continuation);
        LocalRecordProvider$doRecordAndUpload$1 localRecordProvider$doRecordAndUpload$122 = localRecordProvider$doRecordAndUpload$1;
        Object obj22 = localRecordProvider$doRecordAndUpload$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = localRecordProvider$doRecordAndUpload$122.label;
        if (i3 == 0) {
        }
        Pair pair2 = (Pair) obj22;
        boolean booleanValue2 = ((Boolean) pair2.component1()).booleanValue();
        MemeResult memeResult2 = (MemeResult) pair2.component2();
        action = memeResult2.getAction();
        if (action == null) {
        }
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public a getNextProvider() {
        return this.nextProvider;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final com.tencent.zplan.record.provider.helper.a getUploader() {
        return this.uploader;
    }

    final /* synthetic */ Object h(String str, SingleRecordRequestParams singleRecordRequestParams, Continuation<? super Pair<Boolean, MemeResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        MemeZPlanAction a16 = singleRecordRequestParams.a();
        String str2 = a16.getKey() + util.base64_pad_url + System.nanoTime();
        b bVar = new b(new AtomicBoolean(false), str2, safeContinuation);
        f386113c.put(str2, bVar);
        Meme.f385754h.A(a16, singleRecordRequestParams.getPriority(), bVar);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void i(@Nullable com.tencent.zplan.record.provider.helper.a aVar) {
        this.uploader = aVar;
    }

    public LocalRecordProvider(@Nullable a aVar) {
        this.nextProvider = aVar;
    }

    public /* synthetic */ LocalRecordProvider(a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar);
    }
}

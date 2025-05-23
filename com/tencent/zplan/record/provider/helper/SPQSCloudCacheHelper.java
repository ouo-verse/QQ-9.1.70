package com.tencent.zplan.record.provider.helper;

import android.webkit.URLUtil;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.model.AbsRecordRequestParams;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import fv4.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lx4.d;
import lx4.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yx4.c;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J.\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\f\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002J\f\u0010\u0010\u001a\u00020\u000f*\u00020\u0007H\u0002J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\u0011H\u0002J\f\u0010\u0017\u001a\u00020\u0003*\u00020\u0016H\u0002J\f\u0010\u0019\u001a\u00020\u0003*\u00020\u0018H\u0002J\f\u0010\u001b\u001a\u00020\u0003*\u00020\u001aH\u0002J!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ#\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u001eJ7\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00050\"2\u0006\u0010\b\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u00103\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/tencent/zplan/record/provider/helper/SPQSCloudCacheHelper;", "", "Lfv4/d;", "", "errorCode", "", "errorMessage", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "param", "", "timeCost", "Lcom/tencent/zplan/record/model/a;", "p", "Lfv4/a;", "j", "Lfv4/c;", "o", "", "Lfv4/b;", "k", "Lfv4/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/zplan/meme/action/MODE;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/zplan/common/model/AppTheme;", "l", "Lcom/tencent/zplan/meme/model/BusinessConfig$FrameType;", DomainData.DOMAIN_NAME, "Lkotlinx/coroutines/flow/Flow;", h.F, "(Lcom/tencent/zplan/record/model/AbsRecordRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "f", "uploadResultList", "Lkotlin/Pair;", "i", "(Lcom/tencent/zplan/record/model/AbsRecordRequestParams;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Llx4/e;", "a", "Lkotlin/Lazy;", "g", "()Llx4/e;", "ssoProxy", "Llx4/a;", "b", "d", "()Llx4/a;", "commonProxy", "Lyx4/c;", "c", "e", "()Lyx4/c;", "memeProxy", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class SPQSCloudCacheHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy ssoProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy commonProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy memeProxy;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final SPQSCloudCacheHelper f386123d = new SPQSCloudCacheHelper();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/zplan/record/provider/helper/SPQSCloudCacheHelper$getRecordFromServer$2$1", "Llx4/e$c;", "", "data", "", "onReceive", "", "retCode", "", "retMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f386124a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation f386125b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbsRecordRequestParams f386126c;

        a(long j3, Continuation continuation, AbsRecordRequestParams absRecordRequestParams) {
            this.f386124a = j3;
            this.f386125b = continuation;
            this.f386126c = absRecordRequestParams;
        }

        @Override // lx4.e.c
        public void a(@Nullable Integer retCode, @Nullable String retMsg) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_SPQSCloudCacheHelper", 1, "requestCloudCacheResource onError, retCode:" + retCode + ", retMsg:" + retMsg, null, 8, null);
            }
            Continuation continuation = this.f386125b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException("getRecordFromServer error, retCode:" + retCode + ", retMsg:" + retMsg))));
        }

        @Override // lx4.e.c
        public void onReceive(@Nullable byte[] data) {
            fv4.b k3;
            ArrayList arrayList;
            if (data != null && (k3 = SPQSCloudCacheHelper.f386123d.k(data)) != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f386124a;
                fv4.d[] dVarArr = k3.f400852a;
                if (dVarArr != null) {
                    arrayList = new ArrayList();
                    for (fv4.d record : dVarArr) {
                        SPQSCloudCacheHelper sPQSCloudCacheHelper = SPQSCloudCacheHelper.f386123d;
                        Intrinsics.checkNotNullExpressionValue(record, "record");
                        CloudRecordResult p16 = sPQSCloudCacheHelper.p(record, (int) k3.f400853b, k3.f400854c, this.f386126c, currentTimeMillis);
                        if (p16 != null) {
                            arrayList.add(p16);
                        }
                    }
                } else {
                    arrayList = null;
                }
                this.f386125b.resumeWith(Result.m476constructorimpl(arrayList));
                return;
            }
            a(-1, "parse rsp fail, null!");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/zplan/record/provider/helper/SPQSCloudCacheHelper$b", "Llx4/e$c;", "", "data", "", "onReceive", "", "retCode", "", "retMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f386127a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation f386128b;

        b(List list, Continuation continuation) {
            this.f386127a = list;
            this.f386128b = continuation;
        }

        @Override // lx4.e.c
        public void a(@Nullable Integer retCode, @Nullable String retMsg) {
            long j3;
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_SPQSCloudCacheHelper", 1, "requestSetUploadResult onError, retCode:" + retCode + ", retMsg:" + retMsg + ", uploadIdList:" + this.f386127a, null, 8, null);
            }
            Continuation continuation = this.f386128b;
            if (retCode != null) {
                j3 = retCode.intValue();
            } else {
                j3 = -1;
            }
            continuation.resumeWith(Result.m476constructorimpl(new Pair(Long.valueOf(j3), retMsg)));
        }

        @Override // lx4.e.c
        public void onReceive(@Nullable byte[] data) {
            f q16;
            if (data != null && (q16 = SPQSCloudCacheHelper.f386123d.q(data)) != null) {
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "[ZPlanRRC]_SPQSCloudCacheHelper", 1, "requestSetUploadResult onReceive, retCode:" + q16.f400875a + ", retMsg:" + q16.f400876b + ", uploadIdList:" + this.f386127a, null, 8, null);
                }
                this.f386128b.resumeWith(Result.m476constructorimpl(new Pair(Long.valueOf(q16.f400875a), q16.f400876b)));
                return;
            }
            a(-1, "parse rsp fail, null!");
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.zplan.record.provider.helper.SPQSCloudCacheHelper$ssoProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                Object a16 = mx4.a.f417748a.a(e.class);
                Intrinsics.checkNotNull(a16);
                return (e) a16;
            }
        });
        ssoProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<lx4.a>() { // from class: com.tencent.zplan.record.provider.helper.SPQSCloudCacheHelper$commonProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final lx4.a invoke() {
                Object a16 = mx4.a.f417748a.a(lx4.a.class);
                Intrinsics.checkNotNull(a16);
                return (lx4.a) a16;
            }
        });
        commonProxy = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.zplan.record.provider.helper.SPQSCloudCacheHelper$memeProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                Object a16 = mx4.a.f417748a.a(c.class);
                Intrinsics.checkNotNull(a16);
                return (c) a16;
            }
        });
        memeProxy = lazy3;
    }

    SPQSCloudCacheHelper() {
    }

    private final lx4.a d() {
        return (lx4.a) commonProxy.getValue();
    }

    private final c e() {
        return (c) memeProxy.getValue();
    }

    private final e g() {
        return (e) ssoProxy.getValue();
    }

    private final fv4.a j(AbsRecordRequestParams absRecordRequestParams) {
        int collectionSizeOrDefault;
        long[] longArray;
        long[] longArray2;
        fv4.a aVar = new fv4.a();
        MemeZPlanBaseAction a16 = absRecordRequestParams.a();
        if (a16 instanceof MemeZPlanAction) {
            longArray2 = ArraysKt___ArraysKt.toLongArray(new Long[]{Long.valueOf(a16.getActionId())});
            aVar.f400851b = longArray2;
        } else if (a16 instanceof MemeZPlanBatchAction) {
            List<Integer> realNeedRecordIds = ((MemeZPlanBatchAction) a16).getRealNeedRecordIds();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(realNeedRecordIds, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = realNeedRecordIds.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
            }
            longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
            aVar.f400851b = longArray;
        }
        aVar.f400850a = o(absRecordRequestParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final fv4.b k(byte[] bArr) {
        try {
            return fv4.b.c(bArr);
        } catch (Throwable th5) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e("[ZPlanRRC]_SPQSCloudCacheHelper", 1, "convert to GetRecordRsp exception", th5);
            }
            return null;
        }
    }

    private final int l(AppTheme appTheme) {
        int i3 = com.tencent.zplan.record.provider.helper.b.f386160b[appTheme.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i16;
    }

    private final int m(MODE mode) {
        int i3 = com.tencent.zplan.record.provider.helper.b.f386159a[mode.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 != 4) {
            if (i3 == 5) {
                return 7;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 6;
    }

    private final int n(BusinessConfig.FrameType frameType) {
        int i3 = com.tencent.zplan.record.provider.helper.b.f386161c[frameType.ordinal()];
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final fv4.c o(AbsRecordRequestParams absRecordRequestParams) {
        Long longOrNull;
        long j3;
        String str;
        fv4.c cVar = new fv4.c();
        cVar.f400855a = absRecordRequestParams.getScene();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(absRecordRequestParams.getSender());
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        cVar.f400856b = j3;
        AvatarCharacterInfo senderAvatarCharacterInfo = absRecordRequestParams.getSenderAvatarCharacterInfo();
        if (senderAvatarCharacterInfo == null || (str = senderAvatarCharacterInfo.getDressKey()) == null) {
            str = "";
        }
        cVar.f400857c = str;
        cVar.f400858d = absRecordRequestParams.getWidth();
        cVar.f400859e = absRecordRequestParams.getHeight();
        SPQSCloudCacheHelper sPQSCloudCacheHelper = f386123d;
        cVar.f400860f = sPQSCloudCacheHelper.m(absRecordRequestParams.getMode());
        cVar.f400861g = sPQSCloudCacheHelper.l(absRecordRequestParams.getTheme());
        cVar.f400862h = sPQSCloudCacheHelper.n(absRecordRequestParams.a().getConfig().getFrameType());
        cVar.f400863i = sPQSCloudCacheHelper.d().a();
        cVar.f400864j = 109;
        cVar.f400865k = sPQSCloudCacheHelper.e().getZPlanVersion();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CloudRecordResult p(fv4.d dVar, int i3, String str, AbsRecordRequestParams absRecordRequestParams, long j3) {
        String str2;
        String str3;
        boolean z16;
        String d16;
        int i16;
        boolean z17;
        ZPlanRecordResource zPlanRecordResource = null;
        if (URLUtil.isNetworkUrl(dVar.f400872f)) {
            str3 = dVar.f400872f;
        } else if (URLUtil.isNetworkUrl(dVar.f400869c)) {
            str3 = dVar.f400869c;
        } else {
            str2 = null;
            int i17 = 0;
            if (i3 == 0 && dVar.f400867a > 0 && ((i16 = dVar.f400868b) == 1 || i16 == 2)) {
                if (str2 == null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    z16 = true;
                    if (z16) {
                        String singleActionKey = absRecordRequestParams.a().getSingleActionKey((int) dVar.f400867a);
                        long a16 = ZPlanRecordResource.INSTANCE.a();
                        int i18 = (int) dVar.f400867a;
                        AvatarCharacterInfo senderAvatarCharacterInfo = absRecordRequestParams.getSenderAvatarCharacterInfo();
                        if (senderAvatarCharacterInfo == null || (d16 = senderAvatarCharacterInfo.getDressKey()) == null) {
                            d16 = absRecordRequestParams.a().getSenderInfo().d();
                        }
                        zPlanRecordResource = new ZPlanRecordResource(singleActionKey, null, str2, a16, 2, i18, d16, 2, null);
                    }
                    ZPlanRecordResource zPlanRecordResource2 = zPlanRecordResource;
                    int i19 = (int) dVar.f400867a;
                    if (!z16) {
                        i17 = -10001;
                    }
                    return new CloudRecordResult(i19, i17, str + "_id:" + dVar.f400867a + "_state:" + dVar.f400868b + "_url:" + dVar.f400869c, z16, zPlanRecordResource2, dVar, j3);
                }
            }
            z16 = false;
            if (z16) {
            }
            ZPlanRecordResource zPlanRecordResource22 = zPlanRecordResource;
            int i192 = (int) dVar.f400867a;
            if (!z16) {
            }
            return new CloudRecordResult(i192, i17, str + "_id:" + dVar.f400867a + "_state:" + dVar.f400868b + "_url:" + dVar.f400869c, z16, zPlanRecordResource22, dVar, j3);
        }
        str2 = str3;
        int i172 = 0;
        if (i3 == 0) {
            if (str2 == null) {
            }
            z17 = true;
            if (!z17) {
            }
        }
        z16 = false;
        if (z16) {
        }
        ZPlanRecordResource zPlanRecordResource222 = zPlanRecordResource;
        int i1922 = (int) dVar.f400867a;
        if (!z16) {
        }
        return new CloudRecordResult(i1922, i172, str + "_id:" + dVar.f400867a + "_state:" + dVar.f400868b + "_url:" + dVar.f400869c, z16, zPlanRecordResource222, dVar, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f q(byte[] bArr) {
        try {
            return f.c(bArr);
        } catch (Throwable th5) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e("[ZPlanRRC]_SPQSCloudCacheHelper", 1, "convert to UploadRecordRsp exception", th5);
            }
            return null;
        }
    }

    final /* synthetic */ Object f(AbsRecordRequestParams absRecordRequestParams, Continuation<? super List<CloudRecordResult>> continuation) {
        Continuation intercepted;
        Map emptyMap;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        long currentTimeMillis = System.currentTimeMillis();
        SPQSCloudCacheHelper sPQSCloudCacheHelper = f386123d;
        fv4.a j3 = sPQSCloudCacheHelper.j(absRecordRequestParams);
        e g16 = sPQSCloudCacheHelper.g();
        byte[] byteArray = MessageNano.toByteArray(j3);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        e.b.b(g16, "trpc.zplan.record_manage.RecoredManage", "SsoGetRecord", byteArray, emptyMap, new a(currentTimeMillis, safeContinuation, absRecordRequestParams), 0, 32, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(6:5|6|7|(1:(1:10)(2:20|21))(3:22|23|(1:25))|11|(2:17|18)(1:15)))|31|6|7|(0)(0)|11|(1:13)|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0029, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        r6 = com.tencent.zplan.common.utils.LogUtil.f385285b.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
    
        if (r6 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        r6.e("[ZPlanRRC]_SPQSCloudCacheHelper", 1, "requestCloudCacheResource exception", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        r6 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(@NotNull AbsRecordRequestParams absRecordRequestParams, @NotNull Continuation<? super Flow<CloudRecordResult>> continuation) {
        SPQSCloudCacheHelper$requestCloudCacheResource$1 sPQSCloudCacheHelper$requestCloudCacheResource$1;
        Object coroutine_suspended;
        int i3;
        List emptyList;
        Flow asFlow;
        if (continuation instanceof SPQSCloudCacheHelper$requestCloudCacheResource$1) {
            sPQSCloudCacheHelper$requestCloudCacheResource$1 = (SPQSCloudCacheHelper$requestCloudCacheResource$1) continuation;
            int i16 = sPQSCloudCacheHelper$requestCloudCacheResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                sPQSCloudCacheHelper$requestCloudCacheResource$1.label = i16 - Integer.MIN_VALUE;
                Object obj = sPQSCloudCacheHelper$requestCloudCacheResource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = sPQSCloudCacheHelper$requestCloudCacheResource$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    sPQSCloudCacheHelper$requestCloudCacheResource$1.label = 1;
                    obj = f(absRecordRequestParams, sPQSCloudCacheHelper$requestCloudCacheResource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                emptyList = (List) obj;
                if (emptyList != null || (asFlow = FlowKt.asFlow(emptyList)) == null) {
                    return FlowKt.emptyFlow();
                }
                return asFlow;
            }
        }
        sPQSCloudCacheHelper$requestCloudCacheResource$1 = new SPQSCloudCacheHelper$requestCloudCacheResource$1(this, continuation);
        Object obj2 = sPQSCloudCacheHelper$requestCloudCacheResource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = sPQSCloudCacheHelper$requestCloudCacheResource$1.label;
        if (i3 == 0) {
        }
        emptyList = (List) obj2;
        if (emptyList != null) {
        }
        return FlowKt.emptyFlow();
    }

    @Nullable
    public final Object i(@NotNull AbsRecordRequestParams absRecordRequestParams, @NotNull List<fv4.d> list, @NotNull Continuation<? super Pair<Long, String>> continuation) {
        Continuation intercepted;
        int collectionSizeOrDefault;
        Map emptyMap;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        fv4.e eVar = new fv4.e();
        fv4.c o16 = f386123d.o(absRecordRequestParams);
        o16.f400856b = 0L;
        Unit unit = Unit.INSTANCE;
        eVar.f400873a = o16;
        Object[] array = list.toArray(new fv4.d[0]);
        if (array != null) {
            eVar.f400874b = (fv4.d[]) array;
            List<fv4.d> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Boxing.boxLong(((fv4.d) it.next()).f400867a));
            }
            e g16 = f386123d.g();
            byte[] byteArray = MessageNano.toByteArray(eVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            e.b.b(g16, "trpc.zplan.record_manage.RecoredManage", "SsoUploadRecord", byteArray, emptyMap, new b(arrayList, safeContinuation), 0, 32, null);
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}

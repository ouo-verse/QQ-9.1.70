package com.tencent.zplan.record.provider.helper;

import com.tencent.zplan.cloud.impl.CloudRecordApiImpl;
import com.tencent.zplan.cloud.record.api.b;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.record.model.AbsRecordRequestParams;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import dx4.CloudActionResult;
import dx4.CloudFailedResult;
import dx4.CloudForecastResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yx4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002J\u0016\u0010\u000f\u001a\u00020\u000b*\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0011\u001a\u00020\u0010J-\u0010\u0016\u001a\u00020\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u001a8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u001f8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/zplan/record/provider/helper/Z1CloudCacheHelper;", "", "", "resourceId", "", "timeCost", "Lcom/tencent/zplan/record/model/a;", "e", "d", "f", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "", "b", "", "remoteAppearanceKey", "c", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "params", "Lkotlinx/coroutines/flow/Flow;", "k", "id", "action", "a", "(Lcom/tencent/zplan/record/model/a;ILcom/tencent/zplan/meme/action/MemeZPlanBaseAction;J)Lcom/tencent/zplan/record/model/a;", "g", "(IJ)Lcom/tencent/zplan/record/model/a;", "Lcom/tencent/zplan/cloud/impl/CloudRecordApiImpl;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/zplan/cloud/impl/CloudRecordApiImpl;", "cloudApi", "Lyx4/c;", "j", "()Lyx4/c;", "memeProxy", h.F, "()Z", "CHECK_CLOUD_CACHE_RESULT_APPEARANCE_KEY", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class Z1CloudCacheHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy cloudApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy memeProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy CHECK_CLOUD_CACHE_RESULT_APPEARANCE_KEY;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Z1CloudCacheHelper f386141d = new Z1CloudCacheHelper();

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CloudRecordApiImpl>() { // from class: com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$cloudApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CloudRecordApiImpl invoke() {
                return new CloudRecordApiImpl();
            }
        });
        cloudApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$memeProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                Object a16 = mx4.a.f417748a.a(c.class);
                Intrinsics.checkNotNull(a16);
                return (c) a16;
            }
        });
        memeProxy = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$CHECK_CLOUD_CACHE_RESULT_APPEARANCE_KEY$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                boolean e16 = Z1CloudCacheHelper.f386141d.j().e();
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "[ZPlanRRC]CloudProviderHelper", 1, "CHECK_CLOUD_CACHE_RESULT_APPEARANCE_KEY:" + e16, null, 8, null);
                }
                return e16;
            }
        });
        CHECK_CLOUD_CACHE_RESULT_APPEARANCE_KEY = lazy3;
    }

    Z1CloudCacheHelper() {
    }

    private final boolean b(MemeZPlanBaseAction memeZPlanBaseAction) {
        boolean z16;
        boolean z17;
        String f16;
        String f17;
        String senderUin = memeZPlanBaseAction.getSenderUin();
        if (senderUin != null && (f17 = j().f(senderUin)) != null) {
            z16 = memeZPlanBaseAction.isAppearanceKeyMatch(senderUin, f17);
        } else {
            z16 = true;
        }
        String receiverUin = memeZPlanBaseAction.getReceiverUin();
        if (receiverUin != null && (f16 = j().f(receiverUin)) != null) {
            z17 = memeZPlanBaseAction.isAppearanceKeyMatch(receiverUin, f16);
        } else {
            z17 = true;
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    private final boolean c(MemeZPlanBaseAction memeZPlanBaseAction, String str) {
        boolean z16;
        String senderUin;
        d a16;
        if (h()) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && (senderUin = memeZPlanBaseAction.getSenderUin()) != null) {
                boolean isAppearanceKeyMatch = memeZPlanBaseAction.isAppearanceKeyMatch(senderUin, str);
                if (!isAppearanceKeyMatch && (a16 = LogUtil.f385285b.a()) != null) {
                    d.a.c(a16, "[ZPlanRRC]CloudProviderHelper", 1, "checkRemoteAppearanceKey mismatch, key:" + memeZPlanBaseAction.getKey() + ", local appearance:" + memeZPlanBaseAction.getSenderInfo().d() + ", remote appearance:" + str, null, 8, null);
                }
                return isAppearanceKeyMatch;
            }
        }
        return true;
    }

    private final CloudRecordResult d(int resourceId, long timeCost) {
        return new CloudRecordResult(resourceId, -10003, "appearance key change", false, null, null, timeCost, 56, null);
    }

    private final CloudRecordResult e(int resourceId, long timeCost) {
        return new CloudRecordResult(resourceId, -10001, "no item", false, null, null, timeCost, 56, null);
    }

    private final CloudRecordResult f(int resourceId, long timeCost) {
        return new CloudRecordResult(resourceId, -10005, "local and remote appearanceKey mismatch", false, null, null, timeCost, 56, null);
    }

    private final boolean h() {
        return ((Boolean) CHECK_CLOUD_CACHE_RESULT_APPEARANCE_KEY.getValue()).booleanValue();
    }

    @NotNull
    public final CloudRecordResult a(@Nullable CloudRecordResult cloudRecordResult, int i3, @NotNull MemeZPlanBaseAction action, long j3) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (cloudRecordResult == null) {
            return e(i3, j3);
        }
        if (!b(action)) {
            return d(i3, j3);
        }
        if ((cloudRecordResult.getRawData() instanceof CloudActionResult) && !c(action, ((CloudActionResult) cloudRecordResult.getRawData()).getAppearanceKeySaved())) {
            return f(i3, j3);
        }
        return cloudRecordResult;
    }

    @NotNull
    public final CloudRecordResult g(int resourceId, long timeCost) {
        return new CloudRecordResult(resourceId, -10002, "timeout", false, null, null, timeCost, 56, null);
    }

    @NotNull
    public final CloudRecordApiImpl i() {
        return (CloudRecordApiImpl) cloudApi.getValue();
    }

    @NotNull
    public final c j() {
        return (c) memeProxy.getValue();
    }

    @NotNull
    public final Flow<CloudRecordResult> k(@NotNull AbsRecordRequestParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.callbackFlow(new Z1CloudCacheHelper$requestCloudCacheResource$1(params, null));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00040&\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040.\u0012\b\b\u0002\u00106\u001a\u00020\u000b\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000e\u001a\u00020\r*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0010\u001a\u00020\r*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016J&\u0010\u001a\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0016\u0010\u001d\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013H\u0016R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010!R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010%R2\u0010-\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00040&8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040.8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u00101R\u0017\u00106\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/zplan/record/provider/helper/Z1CloudCacheHelper$a;", "Lcom/tencent/zplan/cloud/record/api/b;", "", "count", "", "e", "Ldx4/a;", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "params", "", "hitCache", "", "timeCost", "Lcom/tencent/zplan/record/model/a;", "f", "Ldx4/b;", "g", "d", "isCloudCache", "", "userRecordTaskList", "c", "cloudFailedResultList", "errorCode", "", "errorMessage", "a", "Ldx4/c;", "cloudForecastResultList", "b", "I", "waitingCount", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCanceled", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "getParams", "()Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resource", "Lkotlin/jvm/functions/Function1;", "getOnEmit", "()Lkotlin/jvm/functions/Function1;", "onEmit", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnFinish", "()Lkotlin/jvm/functions/Function0;", "onFinish", "J", "getTimeStart", "()J", "timeStart", "<init>", "(Lcom/tencent/zplan/record/model/AbsRecordRequestParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;J)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements com.tencent.zplan.cloud.record.api.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int waitingCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final AtomicBoolean isCanceled;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AbsRecordRequestParams params;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<CloudRecordResult, Unit> onEmit;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> onFinish;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long timeStart;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull AbsRecordRequestParams params, @NotNull Function1<? super CloudRecordResult, Unit> onEmit, @NotNull Function0<Unit> onFinish, long j3) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(onEmit, "onEmit");
            Intrinsics.checkNotNullParameter(onFinish, "onFinish");
            this.params = params;
            this.onEmit = onEmit;
            this.onFinish = onFinish;
            this.timeStart = j3;
            this.waitingCount = params.a().batchCount();
            this.isCanceled = new AtomicBoolean(false);
        }

        private final void e(int count) {
            int i3 = this.waitingCount - count;
            this.waitingCount = i3;
            if (i3 <= 0) {
                this.onFinish.invoke();
            }
        }

        private final CloudRecordResult f(CloudActionResult cloudActionResult, AbsRecordRequestParams absRecordRequestParams, boolean z16, long j3) {
            String str;
            int actionId = cloudActionResult.getActionId();
            String singleActionKey = absRecordRequestParams.a().getSingleActionKey(cloudActionResult.getActionId());
            String url = cloudActionResult.getUrl();
            long a16 = ZPlanRecordResource.INSTANCE.a();
            int actionId2 = cloudActionResult.getActionId();
            AvatarCharacterInfo senderAvatarCharacterInfo = absRecordRequestParams.getSenderAvatarCharacterInfo();
            if (senderAvatarCharacterInfo != null) {
                str = senderAvatarCharacterInfo.getDressKey();
            } else {
                str = null;
            }
            return new CloudRecordResult(actionId, 0, null, z16, new ZPlanRecordResource(singleActionKey, null, url, a16, 2, actionId2, str, 2, null), cloudActionResult, j3, 4, null);
        }

        private final CloudRecordResult g(CloudFailedResult cloudFailedResult, long j3) {
            return new CloudRecordResult(cloudFailedResult.getActionId(), cloudFailedResult.getErrorCode(), cloudFailedResult.getErrorMessage(), false, null, null, j3, 56, null);
        }

        @Override // com.tencent.zplan.cloud.record.api.b
        public void a(@NotNull List<CloudFailedResult> cloudFailedResultList, int errorCode, @NotNull String errorMessage) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(cloudFailedResultList, "cloudFailedResultList");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            boolean z16 = this.isCanceled.get();
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onActionFailed, isCanceled:");
                sb5.append(z16);
                sb5.append(", errorCode:");
                sb5.append(errorCode);
                sb5.append(", ");
                sb5.append("errorMessage:");
                sb5.append(errorMessage);
                sb5.append(", cloudFailedResultList:");
                List<CloudFailedResult> list = cloudFailedResultList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((CloudFailedResult) it.next()).getActionId()));
                }
                sb5.append(arrayList);
                d.a.d(a16, "[ZPlanRRC]CloudProviderHelper", 2, sb5.toString(), null, 8, null);
            }
            if (z16) {
                return;
            }
            Iterator<CloudFailedResult> it5 = cloudFailedResultList.iterator();
            while (it5.hasNext()) {
                this.onEmit.invoke(g(it5.next(), System.currentTimeMillis() - this.timeStart));
            }
            e(cloudFailedResultList.size());
        }

        @Override // com.tencent.zplan.cloud.record.api.b
        public void b(@NotNull List<CloudForecastResult> cloudForecastResultList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(cloudForecastResultList, "cloudForecastResultList");
            b.a.a(this, cloudForecastResultList);
            List<CloudForecastResult> list = cloudForecastResultList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new CloudFailedResult(((CloudForecastResult) it.next()).getActionId(), "", -10006, "Cloud_Recording_Waiting"));
            }
            a(arrayList, -10006, "Cloud_Recording_Waiting");
        }

        @Override // com.tencent.zplan.cloud.record.api.b
        public void c(boolean isCloudCache, @NotNull List<CloudActionResult> userRecordTaskList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(userRecordTaskList, "userRecordTaskList");
            boolean z16 = this.isCanceled.get();
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onActionSuccess, isCanceled:");
                sb5.append(z16);
                sb5.append(", isCloudCache:");
                sb5.append(isCloudCache);
                sb5.append(", ");
                sb5.append("userRecordTaskList(count:");
                sb5.append(userRecordTaskList.size());
                sb5.append("):");
                List<CloudActionResult> list = userRecordTaskList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((CloudActionResult) it.next()).getActionId()));
                }
                sb5.append(arrayList);
                d.a.c(a16, "[ZPlanRRC]CloudProviderHelper", 2, sb5.toString(), null, 8, null);
            }
            if (z16) {
                return;
            }
            Iterator<CloudActionResult> it5 = userRecordTaskList.iterator();
            while (it5.hasNext()) {
                this.onEmit.invoke(f(it5.next(), this.params, isCloudCache, System.currentTimeMillis() - this.timeStart));
            }
            e(userRecordTaskList.size());
        }

        public final void d() {
            this.isCanceled.set(true);
        }

        public /* synthetic */ a(AbsRecordRequestParams absRecordRequestParams, Function1 function1, Function0 function0, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(absRecordRequestParams, function1, function0, (i3 & 8) != 0 ? System.currentTimeMillis() : j3);
        }
    }
}

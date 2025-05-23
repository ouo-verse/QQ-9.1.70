package com.qzone.reborn.repair.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper;
import com.tencent.mobileqq.opr.helper.repair.model.ImageInfo;
import com.tencent.mobileqq.opr.helper.repair.model.OprStatus;
import com.tencent.mobileqq.opr.model.TaskErrorCode;
import com.tencent.mobileqq.opr.model.TaskExtendResult;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qne.api.IQneApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qne.model.DependencyLibrary;
import com.tencent.qne.model.QneInterpreter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import wn.QZonePhotoOprConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u00c5\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0099\u0001\b\u0002\u0010\u001a\u001a\u0092\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bj\u0004\u0018\u0001`\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0004JB\u0010'\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\u0002J\n\u0010(\u001a\u00020\u0017*\u00020\u0007R\u0014\u0010+\u001a\u00020\u00178\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00178\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010/\u001a\u00020\u00178\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b.\u0010*R$\u00106\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R'\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010<\u001a\u0004\b=\u0010>\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/repair/utils/QZonePhotoRepairQNESingletonVM;", "", "", "j", "", DomainData.DOMAIN_NAME, "i", "Lcom/tencent/mobileqq/opr/helper/repair/model/ImageInfo;", "inputImageInfo", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lkotlin/Function6;", "Lcom/tencent/mobileqq/opr/model/TaskErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/mobileqq/opr/model/TaskExtendResult;", "taskExtendResult", "", "data", "", "width", "height", "", "repairTaskId", "Lcom/tencent/mobileqq/opr/helper/repair/BeforeUploadResultCallback;", "beforeUploadResultCallback", "Lcom/tencent/mobileqq/opr/helper/repair/model/a;", "e", "(Lcom/tencent/mobileqq/opr/helper/repair/model/ImageInfo;Landroid/graphics/Bitmap;Lkotlin/jvm/functions/Function6;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "oprResult", "hasModelLoaded", "", "bitmapCostTime", "oprHandleCostTime", "totalCostTime", "isOprRepair", "o", "l", "b", "Ljava/lang/String;", "KEY_DEVICE_NET_TYPE", "c", "KEY_TIMESTAMP_MS", "d", "KEY_USER_ID", "Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;", "Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;", "g", "()Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;", "setOldPhotoRepairHelper", "(Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;)V", "oldPhotoRepairHelper", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentRepairingCount", "Lkotlin/Pair;", "Lkotlin/Lazy;", tl.h.F, "()Lkotlin/Pair;", "supportConfig", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairQNESingletonVM {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static OldPhotoRepairHelper oldPhotoRepairHelper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Lazy supportConfig;

    /* renamed from: a, reason: collision with root package name */
    public static final QZonePhotoRepairQNESingletonVM f59266a = new QZonePhotoRepairQNESingletonVM();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String KEY_DEVICE_NET_TYPE = "device_net_type";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String KEY_TIMESTAMP_MS = "params_timestamp";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String KEY_USER_ID = "params_uin";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final AtomicInteger currentRepairingCount = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/repair/utils/QZonePhotoRepairQNESingletonVM$a;", "", "", "c", "b", "", "a", "J", "statTime", "endTime", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long statTime = System.currentTimeMillis();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long endTime;

        public final long a() {
            return this.endTime - this.statTime;
        }

        public final void b() {
            this.endTime = System.currentTimeMillis();
        }

        public final void c() {
            this.statTime = System.currentTimeMillis();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Pair<? extends Boolean, ? extends Boolean>>() { // from class: com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM$supportConfig$2
            @Override // kotlin.jvm.functions.Function0
            public final Pair<? extends Boolean, ? extends Boolean> invoke() {
                boolean j3;
                QZonePhotoOprConfig f16 = com.qzone.reborn.configx.g.f53821a.b().f1();
                QneInterpreter qneInterpreter = QneInterpreter.f344344a;
                boolean d16 = f16.d(qneInterpreter);
                com.tencent.qne.model.f c16 = qneInterpreter.c();
                QLog.i("QZonePhotoRepairQNESingletonVM", 1, f16 + " support npu:" + (c16 != null ? c16.b() : null) + MsgSummary.STR_COLON + d16);
                if (f16.getOnlyDownloadOnWifi() && !NetworkState.isWifiConn()) {
                    j3 = QZonePhotoRepairQNESingletonVM.f59266a.j();
                    if (!j3) {
                        d16 = false;
                    }
                }
                return new Pair<>(Boolean.valueOf(d16), Boolean.valueOf(f16.getOnlyDownloadOnWifi()));
            }
        });
        supportConfig = lazy;
    }

    QZonePhotoRepairQNESingletonVM() {
    }

    private final Pair<Boolean, Boolean> h() {
        return (Pair) supportConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        List<DependencyLibrary> c16;
        com.tencent.qne.model.f c17 = QneInterpreter.f344344a.c();
        if (c17 != null && (c16 = c17.c()) != null) {
            for (DependencyLibrary dependencyLibrary : c16) {
                if (!((IQneApi) QRoute.api(IQneApi.class)).isShiplyResourceDownloaded(dependencyLibrary.getShiplyResourceId(), dependencyLibrary.getSpecificTaskId())) {
                    QLog.w("QZonePhotoRepairQNESingletonVM", 1, "so not downloaded preferredSoId=" + dependencyLibrary.getShiplyResourceId() + ", specificTaskId=" + dependencyLibrary.getSpecificTaskId());
                    return false;
                }
            }
        }
        com.tencent.qne.model.f c18 = QneInterpreter.f344344a.c();
        String e16 = c18 != null ? c18.e("realesrganx2") : null;
        QRouteApi api = QRoute.api(IQneApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQneApi::class.java)");
        if (IQneApi.a.a((IQneApi) api, e16, 0L, 2, null)) {
            return true;
        }
        QLog.w("QZonePhotoRepairQNESingletonVM", 1, "model not downloaded preferredModelId=" + e16);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        boolean mIsRepairLayerFragmentShowing = QZonePhotoRepairTaskQueueManger.INSTANCE.a().getMIsRepairLayerFragmentShowing();
        AtomicInteger atomicInteger = currentRepairingCount;
        if (atomicInteger.get() == 0 && !mIsRepairLayerFragmentShowing) {
            m();
        }
        QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] releasePhotoRepairHelperIfNeed count=" + atomicInteger.get() + ", isRepairLayerFragmentShowing=" + mIsRepairLayerFragmentShowing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(boolean z16, ImageInfo inputImageInfo, com.tencent.mobileqq.opr.helper.repair.model.a aVar, boolean z17, long j3, long j16, long j17, String appKey, String eventCode) {
        Object obj;
        Object obj2;
        Object obj3;
        com.tencent.mobileqq.opr.helper.sr.model.a a16;
        com.tencent.mobileqq.opr.helper.sr.model.a a17;
        com.tencent.mobileqq.opr.helper.sr.model.b b16;
        com.tencent.mobileqq.opr.helper.sr.model.b b17;
        com.tencent.mobileqq.opr.helper.sr.model.c a18;
        com.tencent.qne.util.d a19;
        Intrinsics.checkNotNullParameter(inputImageInfo, "$inputImageInfo");
        Intrinsics.checkNotNullParameter(appKey, "$appKey");
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(KEY_DEVICE_NET_TYPE, String.valueOf(HttpUtil.getNetWorkTypeContain5G()));
        linkedHashMap.put(KEY_TIMESTAMP_MS, String.valueOf(System.currentTimeMillis()));
        String str = KEY_USER_ID;
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        linkedHashMap.put(str, currentUin);
        String str2 = "1";
        if (z16) {
            obj = "1";
        } else {
            obj = "0";
        }
        linkedHashMap.put("params_is_opr", obj);
        linkedHashMap.put("params_url", inputImageInfo.getUrl());
        linkedHashMap.put("params_error_code", String.valueOf(aVar.e().getErrorCode()));
        linkedHashMap.put("params_error_msg", String.valueOf(aVar.e().getErrorMessage()));
        if (z17) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        linkedHashMap.put("params_model_loaded", obj2);
        linkedHashMap.put("params_get_bitmap_cost", String.valueOf(j3));
        linkedHashMap.put("params_opr_cost", String.valueOf(j16));
        linkedHashMap.put("params_total_cost", String.valueOf(j17));
        com.tencent.mobileqq.opr.helper.sr.model.e d16 = aVar.d();
        boolean z18 = false;
        if (d16 != null && (b17 = d16.b()) != null && (a18 = b17.a()) != null && (a19 = a18.a()) != null && a19.a()) {
            z18 = true;
        }
        if (!z18) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        linkedHashMap.put("params_so_downloaded", obj3);
        com.tencent.mobileqq.opr.helper.sr.model.e d17 = aVar.d();
        Integer num = null;
        linkedHashMap.put("params_create_instance_cost", String.valueOf((d17 == null || (b16 = d17.b()) == null) ? null : Long.valueOf(b16.b())));
        com.tencent.mobileqq.opr.helper.sr.model.e d18 = aVar.d();
        linkedHashMap.put("params_wait_cost", String.valueOf((d18 == null || (a17 = d18.a()) == null) ? null : Integer.valueOf(a17.b())));
        com.tencent.mobileqq.opr.helper.sr.model.e d19 = aVar.d();
        if (d19 != null && (a16 = d19.a()) != null) {
            num = Integer.valueOf(a16.a());
        }
        linkedHashMap.put("params_execute_cost", String.valueOf(num));
        if (!QZonePhotoRepairTaskQueueManger.INSTANCE.a().getMIsRepairLayerFragmentShowing()) {
            str2 = "0";
        }
        linkedHashMap.put("params_is_in_repair_page", str2);
        EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(appKey).withCode(eventCode).withParams(linkedHashMap).build());
        if (QLog.isColorLevel()) {
            QLog.i("QZonePhotoRepairQNESingletonVM", 2, "report EventResult{ eventID:" + report.eventID + ", errorCode:" + report.errorCode + ", errorMsg:" + report.errMsg + "}, appKey:" + appKey + ", eventCode:" + eventCode + ", params:" + linkedHashMap);
        }
    }

    public final OldPhotoRepairHelper g() {
        return oldPhotoRepairHelper;
    }

    public final synchronized void i() {
        if (h().getFirst().booleanValue()) {
            if (oldPhotoRepairHelper != null) {
                return;
            }
            IQneApi iQneApi = (IQneApi) QRoute.api(IQneApi.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            OldPhotoRepairHelper createOldPhotoRepairHelper = iQneApi.createOldPhotoRepairHelper(context, h().getSecond().booleanValue());
            createOldPhotoRepairHelper.s();
            oldPhotoRepairHelper = createOldPhotoRepairHelper;
        }
    }

    public final boolean k() {
        return h().getFirst().booleanValue();
    }

    public final String l(ImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(imageInfo, "<this>");
        return imageInfo.getAlbumId() + "_" + imageInfo.getLloc() + "_" + imageInfo.getUrl();
    }

    public final synchronized void m() {
        AtomicInteger atomicInteger = currentRepairingCount;
        if (atomicInteger.get() == 0) {
            OldPhotoRepairHelper oldPhotoRepairHelper2 = oldPhotoRepairHelper;
            if (oldPhotoRepairHelper2 != null) {
                oldPhotoRepairHelper2.m();
            }
            oldPhotoRepairHelper = null;
        }
        QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] releasePhotoRepairHelper, currentRepairingCount=" + atomicInteger.get());
    }

    public final void o(final ImageInfo inputImageInfo, final com.tencent.mobileqq.opr.helper.repair.model.a oprResult, final boolean hasModelLoaded, final long bitmapCostTime, final long oprHandleCostTime, final long totalCostTime, final boolean isOprRepair) {
        Intrinsics.checkNotNullParameter(inputImageInfo, "inputImageInfo");
        if (oprResult == null) {
            return;
        }
        final String str = "0AND0YAG6R40RLM6";
        final String str2 = "qne_qzone_old_photo_repair";
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.repair.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                QZonePhotoRepairQNESingletonVM.q(isOprRepair, inputImageInfo, oprResult, hasModelLoaded, bitmapCostTime, oprHandleCostTime, totalCostTime, str, str2);
            }
        }, 128, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM$a, T] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM$a, T] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM$a, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(final ImageInfo imageInfo, Bitmap bitmap, final Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> function6, Continuation<? super com.tencent.mobileqq.opr.helper.repair.model.a> continuation) {
        QZonePhotoRepairQNESingletonVM$doPhotoRepair$1 qZonePhotoRepairQNESingletonVM$doPhotoRepair$1;
        Object coroutine_suspended;
        int i3;
        int i16;
        final Ref.ObjectRef objectRef;
        final Ref.ObjectRef objectRef2;
        final Ref.ObjectRef objectRef3;
        Continuation intercepted;
        Object coroutine_suspended2;
        com.tencent.mobileqq.opr.helper.repair.model.a aVar;
        ImageInfo imageInfo2;
        ImageInfo imageInfo3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        int i17;
        Ref.ObjectRef objectRef6;
        if (continuation instanceof QZonePhotoRepairQNESingletonVM$doPhotoRepair$1) {
            qZonePhotoRepairQNESingletonVM$doPhotoRepair$1 = (QZonePhotoRepairQNESingletonVM$doPhotoRepair$1) continuation;
            int i18 = qZonePhotoRepairQNESingletonVM$doPhotoRepair$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                qZonePhotoRepairQNESingletonVM$doPhotoRepair$1.label = i18 - Integer.MIN_VALUE;
                QZonePhotoRepairQNESingletonVM$doPhotoRepair$1 qZonePhotoRepairQNESingletonVM$doPhotoRepair$12 = qZonePhotoRepairQNESingletonVM$doPhotoRepair$1;
                Object obj = qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i16 = oldPhotoRepairHelper != null ? 1 : 0;
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = new a();
                    objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = new a();
                    objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = new a();
                    if (oldPhotoRepairHelper == null) {
                        i();
                    }
                    if (oldPhotoRepairHelper == null) {
                        return new com.tencent.mobileqq.opr.helper.repair.model.a(OprStatus.UnsupportImage, null, null, null, 0, 30, null);
                    }
                    currentRepairingCount.incrementAndGet();
                    if (bitmap != null) {
                        ((a) objectRef.element).b();
                        ((a) objectRef2.element).c();
                        QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] start opr with bitmap");
                        OldPhotoRepairHelper oldPhotoRepairHelper2 = oldPhotoRepairHelper;
                        if (oldPhotoRepairHelper2 != null) {
                            String l3 = l(imageInfo);
                            qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$0 = imageInfo;
                            qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$1 = objectRef;
                            qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$2 = objectRef2;
                            qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$3 = objectRef3;
                            qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.I$0 = i16;
                            qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.label = 1;
                            obj = OldPhotoRepairHelper.u(oldPhotoRepairHelper2, l3, imageInfo, bitmap, null, qZonePhotoRepairQNESingletonVM$doPhotoRepair$12, 8, null);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            imageInfo3 = imageInfo;
                            objectRef4 = objectRef2;
                            objectRef5 = objectRef3;
                            i17 = i16;
                            objectRef6 = objectRef;
                            aVar = (com.tencent.mobileqq.opr.helper.repair.model.a) obj;
                            i16 = i17;
                            objectRef2 = objectRef4;
                            objectRef = objectRef6;
                            imageInfo2 = imageInfo3;
                            objectRef3 = objectRef5;
                        } else {
                            aVar = null;
                            imageInfo2 = imageInfo;
                        }
                    } else {
                        qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$0 = imageInfo;
                        qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$1 = function6;
                        qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$2 = objectRef;
                        qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$3 = objectRef2;
                        qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$4 = objectRef3;
                        qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.I$0 = i16;
                        qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.label = 2;
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(qZonePhotoRepairQNESingletonVM$doPhotoRepair$12);
                        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                        cancellableContinuationImpl.initCancellability();
                        QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] start load pic , imageInfo=" + imageInfo);
                        ((a) objectRef.element).c();
                        Option url = Option.obtain().setUrl(imageInfo.getUrl());
                        com.tencent.mobileqq.qzone.picload.c.a().n(url);
                        if (!TextUtils.isEmpty(url.getLocalPath())) {
                            url.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(url.getLocalPath())).setRequestWith(Integer.MAX_VALUE).setRequestHeight(Integer.MAX_VALUE).build());
                        }
                        final boolean z16 = i16;
                        com.tencent.mobileqq.qzone.picload.c.a().i(url, new IPicLoadStateListener() { // from class: com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM$doPhotoRepair$3$1

                            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                            @DebugMetadata(c = "com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM$doPhotoRepair$3$1$1", f = "QZonePhotoRepairQNESingletonVM.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM$doPhotoRepair$3$1$1, reason: invalid class name */
                            /* loaded from: classes37.dex */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ Function6<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, String, Unit> $beforeUploadResultCallback;
                                final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.opr.helper.repair.model.a> $continuation;
                                final /* synthetic */ ImageInfo $inputImageInfo;
                                final /* synthetic */ ImageInfo $newImageInfo;
                                final /* synthetic */ Option $option;
                                final /* synthetic */ Ref.ObjectRef<QZonePhotoRepairQNESingletonVM.a> $reportLoadBitmapCostTime;
                                final /* synthetic */ boolean $reportModelLoaded;
                                final /* synthetic */ Ref.ObjectRef<QZonePhotoRepairQNESingletonVM.a> $reportOprHandleCostTime;
                                final /* synthetic */ Ref.ObjectRef<QZonePhotoRepairQNESingletonVM.a> $reportTotalCostTime;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                AnonymousClass1(Ref.ObjectRef<QZonePhotoRepairQNESingletonVM.a> objectRef, ImageInfo imageInfo, Option option, Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> function6, CancellableContinuation<? super com.tencent.mobileqq.opr.helper.repair.model.a> cancellableContinuation, Ref.ObjectRef<QZonePhotoRepairQNESingletonVM.a> objectRef2, ImageInfo imageInfo2, boolean z16, Ref.ObjectRef<QZonePhotoRepairQNESingletonVM.a> objectRef3, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$reportOprHandleCostTime = objectRef;
                                    this.$newImageInfo = imageInfo;
                                    this.$option = option;
                                    this.$beforeUploadResultCallback = function6;
                                    this.$continuation = cancellableContinuation;
                                    this.$reportTotalCostTime = objectRef2;
                                    this.$inputImageInfo = imageInfo2;
                                    this.$reportModelLoaded = z16;
                                    this.$reportLoadBitmapCostTime = objectRef3;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$reportOprHandleCostTime, this.$newImageInfo, this.$option, this.$beforeUploadResultCallback, this.$continuation, this.$reportTotalCostTime, this.$inputImageInfo, this.$reportModelLoaded, this.$reportLoadBitmapCostTime, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended;
                                    com.tencent.mobileqq.opr.helper.repair.model.a aVar;
                                    Object t16;
                                    AtomicInteger atomicInteger;
                                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i3 = this.label;
                                    if (i3 == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] start opr");
                                        this.$reportOprHandleCostTime.element.c();
                                        QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM = QZonePhotoRepairQNESingletonVM.f59266a;
                                        OldPhotoRepairHelper g16 = qZonePhotoRepairQNESingletonVM.g();
                                        if (g16 != null) {
                                            String l3 = qZonePhotoRepairQNESingletonVM.l(this.$newImageInfo);
                                            ImageInfo imageInfo = this.$newImageInfo;
                                            Bitmap resultBitMap = this.$option.getResultBitMap();
                                            Function6<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, String, Unit> function6 = this.$beforeUploadResultCallback;
                                            this.label = 1;
                                            t16 = g16.t(l3, imageInfo, resultBitMap, function6, this);
                                            if (t16 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            aVar = null;
                                            this.$continuation.resumeWith(Result.m476constructorimpl(aVar));
                                            this.$reportOprHandleCostTime.element.b();
                                            this.$reportTotalCostTime.element.b();
                                            QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM2 = QZonePhotoRepairQNESingletonVM.f59266a;
                                            QZonePhotoRepairQNESingletonVM.p(qZonePhotoRepairQNESingletonVM2, this.$inputImageInfo, aVar, this.$reportModelLoaded, this.$reportLoadBitmapCostTime.element.a(), this.$reportOprHandleCostTime.element.a(), this.$reportTotalCostTime.element.a(), false, 64, null);
                                            atomicInteger = QZonePhotoRepairQNESingletonVM.currentRepairingCount;
                                            atomicInteger.decrementAndGet();
                                            qZonePhotoRepairQNESingletonVM2.n();
                                            QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] end opr, oprResult=" + aVar + ", cost=" + this.$reportOprHandleCostTime.element.a());
                                            return Unit.INSTANCE;
                                        }
                                    } else if (i3 == 1) {
                                        ResultKt.throwOnFailure(obj);
                                        t16 = obj;
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    aVar = (com.tencent.mobileqq.opr.helper.repair.model.a) t16;
                                    this.$continuation.resumeWith(Result.m476constructorimpl(aVar));
                                    this.$reportOprHandleCostTime.element.b();
                                    this.$reportTotalCostTime.element.b();
                                    QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM22 = QZonePhotoRepairQNESingletonVM.f59266a;
                                    QZonePhotoRepairQNESingletonVM.p(qZonePhotoRepairQNESingletonVM22, this.$inputImageInfo, aVar, this.$reportModelLoaded, this.$reportLoadBitmapCostTime.element.a(), this.$reportOprHandleCostTime.element.a(), this.$reportTotalCostTime.element.a(), false, 64, null);
                                    atomicInteger = QZonePhotoRepairQNESingletonVM.currentRepairingCount;
                                    atomicInteger.decrementAndGet();
                                    qZonePhotoRepairQNESingletonVM22.n();
                                    QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] end opr, oprResult=" + aVar + ", cost=" + this.$reportOprHandleCostTime.element.a());
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // com.tencent.libra.listener.IPicLoadStateListener
                            public final void onStateChange(LoadState loadState, Option option) {
                                AtomicInteger atomicInteger;
                                ImageInfo imageInfo4 = new ImageInfo(ImageInfo.this.getAlbumId(), ImageInfo.this.getLloc(), ImageInfo.this.getUrl(), option.getLocalPath(), ImageInfo.this.getTaskId());
                                if (loadState.isFinishSuccess()) {
                                    objectRef.element.b();
                                    ImageInfo imageInfo5 = ImageInfo.this;
                                    FileType fileType = RFWFileUtils.getFileType(option.getLocalPath());
                                    Bitmap resultBitMap = option.getResultBitMap();
                                    Integer valueOf = resultBitMap != null ? Integer.valueOf(resultBitMap.getWidth()) : null;
                                    Bitmap resultBitMap2 = option.getResultBitMap();
                                    QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] end load pic, imageInfo=" + imageInfo5 + ", fileType=" + fileType + ", width=" + valueOf + ", height=" + (resultBitMap2 != null ? Integer.valueOf(resultBitMap2.getHeight()) : null));
                                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
                                    if (f16 != null) {
                                        BuildersKt__Builders_commonKt.launch$default(f16, Dispatchers.getIO(), null, new AnonymousClass1(objectRef2, imageInfo4, option, function6, cancellableContinuationImpl, objectRef3, ImageInfo.this, z16, objectRef, null), 2, null);
                                        return;
                                    }
                                    return;
                                }
                                if (loadState.isFinishError()) {
                                    com.tencent.mobileqq.opr.helper.repair.model.a aVar2 = new com.tencent.mobileqq.opr.helper.repair.model.a(OprStatus.GetInputBitmapFail, null, null, null, 0, 30, null);
                                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(aVar2));
                                    QZonePhotoRepairQNESingletonVM.p(QZonePhotoRepairQNESingletonVM.f59266a, ImageInfo.this, aVar2, z16, objectRef.element.a(), objectRef2.element.a(), objectRef3.element.a(), false, 64, null);
                                    atomicInteger = QZonePhotoRepairQNESingletonVM.currentRepairingCount;
                                    atomicInteger.decrementAndGet();
                                    QLog.e("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] end load pic error, imageInfo=" + imageInfo4);
                                }
                            }
                        });
                        obj = cancellableContinuationImpl.getResult();
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(qZonePhotoRepairQNESingletonVM$doPhotoRepair$12);
                        }
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i17 = qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.I$0;
                    objectRef5 = (Ref.ObjectRef) qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$3;
                    objectRef4 = (Ref.ObjectRef) qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$2;
                    objectRef6 = (Ref.ObjectRef) qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$1;
                    imageInfo3 = (ImageInfo) qZonePhotoRepairQNESingletonVM$doPhotoRepair$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    aVar = (com.tencent.mobileqq.opr.helper.repair.model.a) obj;
                    i16 = i17;
                    objectRef2 = objectRef4;
                    objectRef = objectRef6;
                    imageInfo2 = imageInfo3;
                    objectRef3 = objectRef5;
                }
                QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] end opr with bitmap");
                ((a) objectRef2.element).b();
                ((a) objectRef3.element).b();
                if (aVar != null) {
                    p(f59266a, imageInfo2, aVar, i16 != 0, ((a) objectRef.element).a(), ((a) objectRef2.element).a(), ((a) objectRef3.element).a(), false, 64, null);
                }
                currentRepairingCount.decrementAndGet();
                return aVar;
            }
        }
        qZonePhotoRepairQNESingletonVM$doPhotoRepair$1 = new QZonePhotoRepairQNESingletonVM$doPhotoRepair$1(this, continuation);
        QZonePhotoRepairQNESingletonVM$doPhotoRepair$1 qZonePhotoRepairQNESingletonVM$doPhotoRepair$122 = qZonePhotoRepairQNESingletonVM$doPhotoRepair$1;
        Object obj2 = qZonePhotoRepairQNESingletonVM$doPhotoRepair$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qZonePhotoRepairQNESingletonVM$doPhotoRepair$122.label;
        if (i3 != 0) {
        }
        QLog.i("QZonePhotoRepairQNESingletonVM", 1, "[doRepairByOpr] end opr with bitmap");
        ((a) objectRef2.element).b();
        ((a) objectRef3.element).b();
        if (aVar != null) {
        }
        currentRepairingCount.decrementAndGet();
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object f(QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM, ImageInfo imageInfo, Bitmap bitmap, Function6 function6, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bitmap = null;
        }
        if ((i3 & 4) != 0) {
            function6 = null;
        }
        return qZonePhotoRepairQNESingletonVM.e(imageInfo, bitmap, function6, continuation);
    }

    public static /* synthetic */ void p(QZonePhotoRepairQNESingletonVM qZonePhotoRepairQNESingletonVM, ImageInfo imageInfo, com.tencent.mobileqq.opr.helper.repair.model.a aVar, boolean z16, long j3, long j16, long j17, boolean z17, int i3, Object obj) {
        qZonePhotoRepairQNESingletonVM.o(imageInfo, aVar, z16, j3, j16, j17, (i3 & 64) != 0 ? true : z17);
    }
}

package com.qzone.reborn.repair.utils;

import android.text.TextUtils;
import com.qzone.reborn.repair.bean.QZonePhotoRepairSyncStatusEvent;
import com.qzone.reborn.repair.request.QZoneRepairUploadRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$UploadRsp;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ?\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/repair/utils/QZonePhotoRepairUploadManger;", "", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "albumId", "", "batchId", "content", "srUrl", "", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairUploadManger {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy<QZonePhotoRepairUploadManger> f59292b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/repair/utils/QZonePhotoRepairUploadManger$a;", "", "Lcom/qzone/reborn/repair/utils/QZonePhotoRepairUploadManger;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/qzone/reborn/repair/utils/QZonePhotoRepairUploadManger;", "sInstance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.repair.utils.QZonePhotoRepairUploadManger$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final QZonePhotoRepairUploadManger b() {
            return (QZonePhotoRepairUploadManger) QZonePhotoRepairUploadManger.f59292b.getValue();
        }

        @JvmStatic
        public final QZonePhotoRepairUploadManger a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<QZonePhotoRepairUploadManger> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<QZonePhotoRepairUploadManger>() { // from class: com.qzone.reborn.repair.utils.QZonePhotoRepairUploadManger$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QZonePhotoRepairUploadManger invoke() {
                return new QZonePhotoRepairUploadManger();
            }
        });
        f59292b = lazy;
    }

    @JvmStatic
    public static final QZonePhotoRepairUploadManger e() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String str, Long l3, BaseRequest baseRequest, boolean z16, long j3, String str2, SuperResolution$UploadRsp superResolution$UploadRsp) {
        QLog.i("QZonePhotoRepairUploadManger", 1, "uploadSrPicRequest | traceId=" + baseRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j3 + " | errMsg=" + str2 + " | rsp=" + superResolution$UploadRsp);
        if (z16 && j3 == 0 && superResolution$UploadRsp != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.x
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePhotoRepairUploadManger.i();
                }
            });
            SimpleEventBus.getInstance().dispatchEvent(new QZonePhotoRepairSyncStatusEvent(str, 2, l3), true);
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.utils.w
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePhotoRepairUploadManger.h();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        QQToastUtil.showQQToast(1, com.qzone.util.l.a(NetworkUtil.isNetworkAvailable() ? R.string.wam : R.string.wan));
    }

    public final void f(final String taskId, String albumId, final Long batchId, String content, String srUrl) {
        if (com.qzone.reborn.util.e.a("QZonePhotoRepairUploadManger")) {
            return;
        }
        if (!TextUtils.isEmpty(taskId) && !TextUtils.isEmpty(albumId) && !TextUtils.isEmpty(srUrl) && batchId != null && content != null) {
            Intrinsics.checkNotNull(taskId);
            Intrinsics.checkNotNull(albumId);
            Intrinsics.checkNotNull(srUrl);
            VSNetworkHelper.getInstance().sendRequest(new QZoneRepairUploadRequest(taskId, albumId, srUrl, batchId.longValue(), content), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.utils.v
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QZonePhotoRepairUploadManger.g(taskId, batchId, baseRequest, z16, j3, str, (SuperResolution$UploadRsp) obj);
                }
            });
            return;
        }
        QLog.e("QZonePhotoRepairUploadManger", 1, "[uploadSrPicRequest] taskId:" + taskId + " albumId:" + albumId + ", srUrl:" + srUrl + " batchId:" + batchId + ", content:" + content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        QQToastUtil.showQQToast(2, com.qzone.util.l.a(R.string.wao));
    }
}

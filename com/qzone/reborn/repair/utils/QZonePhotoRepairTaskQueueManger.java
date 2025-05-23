package com.qzone.reborn.repair.utils;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.event.EventCenter;
import com.qzone.reborn.repair.bean.QZonePhotoRepairSyncStatusEvent;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.event.QZonePhotoRepairQueryStatusEvent;
import com.qzone.reborn.repair.event.QZonePhotoRepairTaskStateChangeEvent;
import com.qzone.reborn.repair.request.QZoneRepairDoSRRequest;
import com.qzone.reborn.repair.request.QZoneRepairLeavePageRequest;
import com.qzone.reborn.repair.request.QZoneRepairQueryStatusRequest;
import com.qzone.reborn.repair.request.QZoneRepairUpdateResultRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.opr.helper.repair.model.ImageInfo;
import com.tencent.mobileqq.opr.helper.repair.model.OprStatus;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import qzone.SuperResolution$DoSRRsp;
import qzone.SuperResolution$LeavePageRsp;
import qzone.SuperResolution$QueryStatusRsp;
import qzone.SuperResolution$UpdateResultRsp;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TB\t\b\u0016\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0012\u001a\u00020\u0005J$\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0014`\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJG\u0010&\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072-\b\u0002\u0010#\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dj\u0004\u0018\u0001`\"2\b\b\u0002\u0010%\u001a\u00020$J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020'H\u0002J<\u0010,\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032*\b\u0002\u0010#\u001a$\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020\u0005\u0018\u00010)j\u0004\u0018\u0001`+H\u0002J\u001b\u0010-\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.J+\u00102\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J\u001a\u00106\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u0010\u00107\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010:\u001a\u00020\u00052\u0006\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010<\u001a\u00020\u00052\u0006\u0010!\u001a\u00020;2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0002J\"\u0010=\u001a\u00020\u00052\u0006\u00108\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020$H\u0002J\"\u0010>\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020$H\u0002J \u0010A\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020$H\u0002R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR0\u0010J\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030Fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006U"}, d2 = {"Lcom/qzone/reborn/repair/utils/QZonePhotoRepairTaskQueueManger;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "", "l", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "J", "", "D", ReportConstant.COSTREPORT_PREFIX, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lxn/d;", "listener", "I", "P", "E", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", "O", "showing", "N", "r", "Lkotlin/Function1;", "Lqzone/SuperResolution$QueryStatusRsp;", "Lkotlin/ParameterName;", "name", "rsp", "Lcom/qzone/reborn/repair/utils/QueryStatusCallback;", "callback", "", "startTime", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/repair/bean/QZonePhotoRepairSyncStatusEvent;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Function3;", "Lcom/tencent/mobileqq/opr/helper/sr/model/d;", "Lcom/qzone/reborn/repair/request/EnhanceFaceCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "photoSize", "status", "M", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/opr/helper/repair/model/a;", "result", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "retCode", "errMsg", "t", "Lqzone/SuperResolution$DoSRRsp;", "u", "w", "y", "isSuccess", "costTime", "K", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mTaskStateListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "mTaskStateMap", "f", "Ljava/lang/Long;", "mUploadBatchId", tl.h.F, "Z", "mIsRepairLayerFragmentShowing", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairTaskQueueManger implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final Lazy<QZonePhotoRepairTaskQueueManger> f59282m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<xn.d> mTaskStateListener = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, QZoneRepairTaskStateBean> mTaskStateMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Long mUploadBatchId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRepairLayerFragmentShowing;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/repair/utils/QZonePhotoRepairTaskQueueManger$a;", "", "Lcom/qzone/reborn/repair/utils/QZonePhotoRepairTaskQueueManger;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/qzone/reborn/repair/utils/QZonePhotoRepairTaskQueueManger;", "sInstance", "", "QUERY_STATUS_DELAY_TIME", "J", "QZ_PHOTO_ALREADY_CLEAR", "QZ_SCHEDULE_TO_ASYNC_QUEUE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final QZonePhotoRepairTaskQueueManger b() {
            return (QZonePhotoRepairTaskQueueManger) QZonePhotoRepairTaskQueueManger.f59282m.getValue();
        }

        @JvmStatic
        public final QZonePhotoRepairTaskQueueManger a() {
            return b();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/SuperResolution$LeavePageRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lqzone/SuperResolution$LeavePageRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f59287a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f59288b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Boolean> cancellableContinuation, String str) {
            this.f59287a = cancellableContinuation;
            this.f59288b = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, SuperResolution$LeavePageRsp superResolution$LeavePageRsp) {
            this.f59287a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            QLog.i("QZonePhotoRepairTaskQueueManger", 1, "leavePageRequest taskId=" + this.f59288b + ", retCode=" + j3 + ", errMsg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/SuperResolution$UpdateResultRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lqzone/SuperResolution$UpdateResultRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f59289a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f59290b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Boolean> cancellableContinuation, String str) {
            this.f59289a = cancellableContinuation;
            this.f59290b = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, SuperResolution$UpdateResultRsp superResolution$UpdateResultRsp) {
            this.f59289a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            QLog.i("QZonePhotoRepairTaskQueueManger", 1, "updateResultRequest taskId=" + this.f59290b + ", retCode=" + j3 + ", errMsg=" + str);
        }
    }

    static {
        Lazy<QZonePhotoRepairTaskQueueManger> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<QZonePhotoRepairTaskQueueManger>() { // from class: com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QZonePhotoRepairTaskQueueManger invoke() {
                return new QZonePhotoRepairTaskQueueManger();
            }
        });
        f59282m = lazy;
    }

    public QZonePhotoRepairTaskQueueManger() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(com.tencent.mobileqq.opr.helper.repair.model.a oprResult, QZonePhotoRepairTaskQueueManger this$0, QZoneRepairTaskStateBean taskBean) {
        Intrinsics.checkNotNullParameter(oprResult, "$oprResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskBean, "$taskBean");
        if (oprResult.e().getSuccess() && oprResult.c() != null) {
            String b16 = oprResult.b();
            if (b16 == null) {
                b16 = "";
            }
            taskBean.setTaskId(b16);
            taskBean.setSrStatus(1);
            String c16 = oprResult.c();
            Intrinsics.checkNotNull(c16);
            taskBean.setSrUrl(c16);
            this$0.Q(taskBean);
            QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[handleRepairOprResult] success, mIsRepairLayerFragmentShowing=" + this$0.mIsRepairLayerFragmentShowing + ", taskBean=" + taskBean + ", result=" + oprResult);
            return;
        }
        QLog.e("QZonePhotoRepairTaskQueueManger", 1, "[handleRepairOprResult] fail, oprResult.status=" + oprResult.e() + ", taskBean=" + taskBean);
        if (oprResult.e() != OprStatus.UnsupportImage && oprResult.e() != OprStatus.GetOprInstanceFail) {
            taskBean.setSrStatus(3);
            this$0.Q(taskBean);
        } else {
            this$0.o(taskBean);
        }
    }

    private final void C(QZonePhotoRepairSyncStatusEvent event) {
        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[handleRepairTaskSyncResult] srStatus:" + event.getSrStatus());
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(event.getTaskId());
        qZoneRepairTaskStateBean.setSrStatus(event.getSrStatus());
        Q(qZoneRepairTaskStateBean);
        J(event.getTaskId());
        Integer srStatus = event.getSrStatus();
        if (srStatus == null || srStatus.intValue() != 2 || Intrinsics.areEqual(this.mUploadBatchId, event.getBatchId())) {
            return;
        }
        this.mUploadBatchId = event.getBatchId();
        EventCenter.getInstance().post("Feed", 37);
    }

    private final void K(QZoneRepairTaskStateBean taskBean, boolean isSuccess, long costTime) {
        OprStatus oprStatus;
        ImageInfo imageInfo = new ImageInfo(taskBean.getAlbumId(), taskBean.getLloc(), taskBean.getSrOriginUrl(), "", taskBean.getTaskId());
        if (isSuccess) {
            oprStatus = OprStatus.Success;
        } else {
            oprStatus = OprStatus.DoOprFail;
        }
        QZonePhotoRepairQNESingletonVM.f59266a.o(imageInfo, new com.tencent.mobileqq.opr.helper.repair.model.a(oprStatus, null, null, null, 0, 30, null), false, 0L, 0L, costTime, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L(String str, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        VSNetworkHelper.getInstance().sendRequest(new QZoneRepairLeavePageRequest(str), new b(cancellableContinuationImpl, str));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M(String str, int i3, int i16, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        VSNetworkHelper.getInstance().sendRequest(new QZoneRepairUpdateResultRequest(str, i3, i16), new c(cancellableContinuationImpl, str));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void m(QZoneRepairTaskStateBean taskBean, Function3<? super Boolean, ? super String, ? super com.tencent.mobileqq.opr.helper.sr.model.d, Unit> callback) {
        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[doRepairByOpr] taskBean=" + taskBean);
        if (!TextUtils.isEmpty(taskBean.getAlbumId()) && !TextUtils.isEmpty(taskBean.getLloc()) && !TextUtils.isEmpty(taskBean.getSrOriginUrl())) {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
            if (f16 != null) {
                BuildersKt__Builders_commonKt.launch$default(f16, Dispatchers.getIO(), null, new QZonePhotoRepairTaskQueueManger$doRepairByOpr$1(taskBean, this, null), 2, null);
                return;
            }
            return;
        }
        QLog.e("QZonePhotoRepairTaskQueueManger", 1, "[doRepairByOpr] illegal param");
    }

    private final void o(final QZoneRepairTaskStateBean taskBean) {
        if (!TextUtils.isEmpty(taskBean.getAlbumId()) && !TextUtils.isEmpty(taskBean.getLloc()) && !TextUtils.isEmpty(taskBean.getSrOriginUrl())) {
            final long currentTimeMillis = System.currentTimeMillis();
            VSNetworkHelper.getInstance().sendRequest(new QZoneRepairDoSRRequest(taskBean.getTaskId(), taskBean.getAlbumId(), taskBean.getLloc(), taskBean.getSrOriginUrl()), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.utils.p
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QZonePhotoRepairTaskQueueManger.p(currentTimeMillis, this, taskBean, baseRequest, z16, j3, str, (SuperResolution$DoSRRsp) obj);
                }
            });
            return;
        }
        QLog.e("QZonePhotoRepairTaskQueueManger", 1, "[doSrRequest] albumId:" + taskBean.getAlbumId() + ", lloc:" + taskBean.getLloc() + ", srOriginUrl:" + taskBean.getSrOriginUrl());
    }

    @JvmStatic
    public static final QZonePhotoRepairTaskQueueManger q() {
        return INSTANCE.a();
    }

    private final void t(long retCode, String errMsg, QZoneRepairTaskStateBean taskBean) {
        QLog.d("QZonePhotoRepairTaskQueueManger", 1, "[repair_photo] doSr fail:" + retCode + ", errMsg:" + errMsg + ", taskBean:" + taskBean);
        if (errMsg.length() > 0) {
            QQToastUtil.showQQToastInUiThread(0, errMsg);
        }
        if (retCode == 10089) {
            taskBean.setSrStatus(null);
            Q(taskBean);
        } else {
            taskBean.setSrStatus(3);
            Q(taskBean);
        }
    }

    private final void u(SuperResolution$DoSRRsp rsp, final QZoneRepairTaskStateBean taskBean, final long startTime) {
        QLog.d("QZonePhotoRepairTaskQueueManger", 1, "[repair_photo] expected_time = " + rsp.expected_time.get());
        String str = rsp.task_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "rsp.task_id.get()");
        taskBean.setTaskId(str);
        taskBean.setSrStatus(0);
        Q(taskBean);
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.q
            @Override // java.lang.Runnable
            public final void run() {
                QZonePhotoRepairTaskQueueManger.v(QZonePhotoRepairTaskQueueManger.this, taskBean, startTime);
            }
        }, rsp.expected_time.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QZonePhotoRepairTaskQueueManger this$0, QZoneRepairTaskStateBean taskBean, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskBean, "$taskBean");
        G(this$0, taskBean.getTaskId(), null, j3, 2, null);
    }

    private final void w(long retCode, final String taskId, final long startTime) {
        QZoneRepairTaskStateBean s16;
        QLog.d("QZonePhotoRepairTaskQueueManger", 1, "[repair_photo] query status fail = " + retCode);
        if (retCode == 10088) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.t
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePhotoRepairTaskQueueManger.x(QZonePhotoRepairTaskQueueManger.this, taskId, startTime);
                }
            }, 10000L);
        } else {
            if (startTime <= 0 || (s16 = s(taskId)) == null) {
                return;
            }
            K(s16, false, System.currentTimeMillis() - startTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QZonePhotoRepairTaskQueueManger this$0, String taskId, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskId, "$taskId");
        G(this$0, taskId, null, j3, 2, null);
    }

    private final void y(SuperResolution$QueryStatusRsp rsp, final String taskId, final long startTime) {
        QLog.d("QZonePhotoRepairTaskQueueManger", 1, "[repair_photo] next_retry_time = " + rsp.next_retry.get());
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(taskId);
        String str = rsp.sr_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "rsp.sr_url.get()");
        qZoneRepairTaskStateBean.setSrUrl(str);
        qZoneRepairTaskStateBean.setSrStatus(Integer.valueOf(rsp.status.get()));
        Q(qZoneRepairTaskStateBean);
        if (rsp.status.get() == 0) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.u
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePhotoRepairTaskQueueManger.z(QZonePhotoRepairTaskQueueManger.this, taskId, startTime);
                }
            }, rsp.next_retry.get());
            return;
        }
        if ((rsp.status.get() == 1 || rsp.status.get() == 3) && startTime > 0) {
            boolean z16 = rsp.status.get() == 1;
            QZoneRepairTaskStateBean s16 = s(taskId);
            if (s16 != null) {
                K(s16, z16, System.currentTimeMillis() - startTime);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QZonePhotoRepairTaskQueueManger this$0, String taskId, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskId, "$taskId");
        G(this$0, taskId, null, j3, 2, null);
    }

    public final boolean D() {
        Collection<QZoneRepairTaskStateBean> values = this.mTaskStateMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mTaskStateMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Integer srStatus = ((QZoneRepairTaskStateBean) it.next()).getSrStatus();
            if (srStatus != null && srStatus.intValue() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void E() {
        this.mTaskStateMap.clear();
        this.mTaskStateListener.clear();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public final void F(final String taskId, final Function1<? super SuperResolution$QueryStatusRsp, Unit> callback, final long startTime) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        if (TextUtils.isEmpty(taskId)) {
            QLog.e("QZonePhotoRepairTaskQueueManger", 1, "[queryStatusRequest] taskId:" + taskId);
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QZoneRepairQueryStatusRequest(taskId), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.repair.utils.s
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QZonePhotoRepairTaskQueueManger.H(QZonePhotoRepairTaskQueueManger.this, taskId, startTime, callback, baseRequest, z16, j3, str, (SuperResolution$QueryStatusRsp) obj);
            }
        });
    }

    public final void J(String taskId) {
        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[removeRepairTask] taskId is " + taskId);
        if (TextUtils.isEmpty(taskId) || this.mTaskStateMap.get(taskId) == null) {
            return;
        }
        TypeIntrinsics.asMutableMap(this.mTaskStateMap).remove(taskId);
    }

    public final void N(boolean showing) {
        this.mIsRepairLayerFragmentShowing = showing;
    }

    public final void O(QZoneRepairTaskStateBean taskBean) {
        Intrinsics.checkNotNullParameter(taskBean, "taskBean");
        if (QZonePhotoRepairQNESingletonVM.f59266a.k()) {
            QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[startDoRepairRequest] doRepairByOpr");
            n(this, taskBean, null, 2, null);
        } else {
            QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[startDoRepairRequest] doRepairByServer");
            o(taskBean);
        }
    }

    public final void Q(QZoneRepairTaskStateBean taskBean) {
        Integer srStatus;
        if (taskBean == null) {
            QLog.e("QZonePhotoRepairTaskQueueManger", 1, "[updateTaskEntry] taskBean is null");
            return;
        }
        QZoneRepairTaskStateBean s16 = s(taskBean.getTaskId());
        if (s16 == null) {
            l(taskBean);
            return;
        }
        HashMap<String, QZoneRepairTaskStateBean> hashMap = this.mTaskStateMap;
        String taskId = taskBean.getTaskId();
        s16.setTaskId(taskBean.getTaskId());
        if (!TextUtils.isEmpty(taskBean.getSrUrl())) {
            s16.setSrUrl(taskBean.getSrUrl());
        }
        if (taskBean.getSrStatus() != null && !Intrinsics.areEqual(s16.getSrStatus(), taskBean.getSrStatus())) {
            s16.setSrStatus(taskBean.getSrStatus());
        }
        hashMap.put(taskId, s16);
        Iterator<T> it = this.mTaskStateListener.iterator();
        while (it.hasNext()) {
            ((xn.d) it.next()).B3(s16);
        }
        QLog.d("QZonePhotoRepairTaskQueueManger", 1, "[updateTaskEntry] update taskBean is " + s16);
        Integer srStatus2 = s16.getSrStatus();
        if ((srStatus2 != null && srStatus2.intValue() == 1) || ((srStatus = s16.getSrStatus()) != null && srStatus.intValue() == 3)) {
            SimpleEventBus.getInstance().dispatchEvent(new QZonePhotoRepairTaskStateChangeEvent(D()), true);
        }
    }

    public final void l(QZoneRepairTaskStateBean taskBean) {
        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "[addRepairTask] taskBean is " + taskBean);
        if (taskBean == null) {
            return;
        }
        Iterator<T> it = this.mTaskStateListener.iterator();
        while (it.hasNext()) {
            ((xn.d) it.next()).B3(taskBean);
        }
        if (!TextUtils.isEmpty(taskBean.getTaskId())) {
            this.mTaskStateMap.put(taskBean.getTaskId(), taskBean);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QZonePhotoRepairTaskStateChangeEvent(true), true);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZonePhotoRepairSyncStatusEvent) {
            C((QZonePhotoRepairSyncStatusEvent) event);
            return;
        }
        if (event instanceof QZonePhotoRepairQueryStatusEvent) {
            RFWLog.d("QZonePhotoRepairTaskQueueManger", RFWLog.USR, "onReceiveEvent, QZonePhotoRepairQueryStatusEvent: " + D());
            if (D()) {
                SimpleEventBus.getInstance().dispatchEvent(new QZonePhotoRepairTaskStateChangeEvent(true), true);
            }
        }
    }

    /* renamed from: r, reason: from getter */
    public final boolean getMIsRepairLayerFragmentShowing() {
        return this.mIsRepairLayerFragmentShowing;
    }

    public final QZoneRepairTaskStateBean s(String taskId) {
        if (TextUtils.isEmpty(taskId)) {
            QLog.e("QZonePhotoRepairTaskQueueManger", 1, "[getRepairTask] taskId is null");
            return null;
        }
        return this.mTaskStateMap.get(taskId);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZonePhotoRepairSyncStatusEvent.class, QZonePhotoRepairQueryStatusEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(final QZoneRepairTaskStateBean taskBean, final com.tencent.mobileqq.opr.helper.repair.model.a result) {
        if (result == null) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.utils.r
            @Override // java.lang.Runnable
            public final void run() {
                QZonePhotoRepairTaskQueueManger.B(com.tencent.mobileqq.opr.helper.repair.model.a.this, this, taskBean);
            }
        });
    }

    public final void I(xn.d listener) {
        if (listener == null || this.mTaskStateListener.contains(listener)) {
            return;
        }
        this.mTaskStateListener.add(listener);
    }

    public final void P(xn.d listener) {
        if (listener == null) {
            return;
        }
        if (this.mTaskStateListener.contains(listener)) {
            this.mTaskStateListener.remove(listener);
        }
        if (bl.b(this.mTaskStateListener)) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void n(QZonePhotoRepairTaskQueueManger qZonePhotoRepairTaskQueueManger, QZoneRepairTaskStateBean qZoneRepairTaskStateBean, Function3 function3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function3 = null;
        }
        qZonePhotoRepairTaskQueueManger.m(qZoneRepairTaskStateBean, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(QZonePhotoRepairTaskQueueManger this$0, String taskId, long j3, Function1 function1, BaseRequest baseRequest, boolean z16, long j16, String str, SuperResolution$QueryStatusRsp superResolution$QueryStatusRsp) {
        PBInt64Field pBInt64Field;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskId, "$taskId");
        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "queryStatusRequest | traceId=" + baseRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j16 + " | errMsg=" + str + " | rsp=" + superResolution$QueryStatusRsp + " | next_retry=" + ((superResolution$QueryStatusRsp == null || (pBInt64Field = superResolution$QueryStatusRsp.next_retry) == null) ? null : Long.valueOf(pBInt64Field.get())));
        if (z16 && j16 == 0 && superResolution$QueryStatusRsp != null) {
            this$0.y(superResolution$QueryStatusRsp, taskId, j3);
            if (function1 != null) {
                function1.invoke(superResolution$QueryStatusRsp);
                return;
            }
            return;
        }
        this$0.w(j16, taskId, j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void G(QZonePhotoRepairTaskQueueManger qZonePhotoRepairTaskQueueManger, String str, Function1 function1, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        qZonePhotoRepairTaskQueueManger.F(str, function1, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(long j3, QZonePhotoRepairTaskQueueManger this$0, QZoneRepairTaskStateBean taskBean, BaseRequest baseRequest, boolean z16, long j16, String errMsg, SuperResolution$DoSRRsp superResolution$DoSRRsp) {
        PBInt64Field pBInt64Field;
        PBStringField pBStringField;
        PBInt64Field pBInt64Field2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskBean, "$taskBean");
        long currentTimeMillis = System.currentTimeMillis() - j3;
        long j17 = ((superResolution$DoSRRsp == null || (pBInt64Field2 = superResolution$DoSRRsp.expected_time) == null) ? 0L : pBInt64Field2.get()) + currentTimeMillis;
        String traceId = baseRequest.getTraceId();
        Long l3 = null;
        String str = (superResolution$DoSRRsp == null || (pBStringField = superResolution$DoSRRsp.task_id) == null) ? null : pBStringField.get();
        if (superResolution$DoSRRsp != null && (pBInt64Field = superResolution$DoSRRsp.expected_time) != null) {
            l3 = Long.valueOf(pBInt64Field.get());
        }
        QLog.i("QZonePhotoRepairTaskQueueManger", 1, "doSrRequest | traceId=" + traceId + " | isSuccess=" + z16 + " | retCode=" + j16 + " | errMsg=" + errMsg + " | rsp=" + superResolution$DoSRRsp + " | task_id=" + str + " | diffTime=" + currentTimeMillis + " | totalTime=" + j17 + " | expected_time=" + l3);
        if (z16 && j16 == 0 && superResolution$DoSRRsp != null) {
            this$0.u(superResolution$DoSRRsp, taskBean, j3);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.t(j16, errMsg, taskBean);
        this$0.K(taskBean, false, currentTimeMillis);
    }
}

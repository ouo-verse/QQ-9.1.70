package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSJumpPublishEvent;
import com.tencent.biz.qqcircle.immersive.request.QFSActivityLotteryDetailReq;
import com.tencent.biz.qqcircle.immersive.request.QFSActivityTriggerLotteryReq;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleActivityLottery$LotteryResultRsp;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 B2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001CB#\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160*\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0*\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002JD\u0010\u0015\u001a\u00020\u00142:\u0010\u0013\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002JD\u0010\u0019\u001a\u00020\u00142:\u0010\u0013\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'`(H\u0016R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0*8\u0006\u00a2\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R\u0016\u00105\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSActivityDialogPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSJumpPublishEvent;", "", "S9", "Lqqcircle/QQCircleActivityLottery$LotteryResultRsp;", "rsp", "U9", "Landroid/view/View;", "root", "M9", "da", "T9", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "t", "callback", "Lcom/tencent/biz/qqcircle/immersive/part/a;", "ba", "", "count", "P9", "Q9", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "p0", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/core/util/Supplier;", "d", "Landroidx/core/util/Supplier;", "O9", "()Landroidx/core/util/Supplier;", "curPageIdSupplier", "e", "getCurDTPageIdSupplier", "curDTPageIdSupplier", "f", "Ljava/lang/String;", "lastFeedId", tl.h.F, "Landroid/view/View;", "dialogRoot", "Lcom/tencent/biz/qqcircle/widgets/a;", "i", "Lcom/tencent/biz/qqcircle/widgets/a;", "publishCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/part/a;", "reqDisposable", "<init>", "(Landroidx/core/util/Supplier;Landroidx/core/util/Supplier;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSActivityDialogPart extends u implements SimpleEventReceiver<QFSJumpPublishEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final HashMap<Integer, Integer> D = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<Integer> curPageIdSupplier;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<String> curDTPageIdSupplier;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lastFeedId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View dialogRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.widgets.a publishCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Disposable reqDisposable;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSActivityDialogPart$a;", "", "Lcom/tencent/biz/qqcircle/immersive/part/QFSActivityDialogPart;", "part", "", "a", "", "DIALOG_BG", "Ljava/lang/String;", "DIALOG_BG_LIMITED", "", "FUDAI_MATE_ACTIVITY_TYPE", "I", "PART_STATUS_ACTIVE", "PART_STATUS_INACTIVE", "RETRY_WHAT", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "partInstanceStateRecord", "Ljava/util/HashMap;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSActivityDialogPart$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull QFSActivityDialogPart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            Integer num = (Integer) QFSActivityDialogPart.D.get(Integer.valueOf(part.hashCode()));
            if (num != null && num.intValue() == 1) {
                return true;
            }
            if (QFSActivityDialogPart.D.containsKey(Integer.valueOf(part.hashCode())) && QFSActivityDialogPart.D.size() == 1) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/QFSActivityDialogPart$b", "Lcom/tencent/biz/qqcircle/widgets/a;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskStateChanged", "onProgressChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.biz.qqcircle.widgets.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Bundle transParams = taskInfo.getTransParams();
            if (transParams != null) {
                QLog.i(QFSActivityDialogPart.this.getLogTag(), 1, QFSActivityDialogPart.this.O9().get() + " mate activity type:" + transParams.get(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE));
                if (taskInfo.isSuccess() && taskInfo.isFinish() && Intrinsics.areEqual(transParams.get(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE), (Object) 1)) {
                    QFSActivityDialogPart.this.lastFeedId = taskInfo.getFeedId();
                    if (QFSActivityDialogPart.INSTANCE.a(QFSActivityDialogPart.this)) {
                        QFSActivityDialogPart.this.T9();
                    }
                }
            }
        }
    }

    public QFSActivityDialogPart(@NotNull Supplier<Integer> curPageIdSupplier, @NotNull Supplier<String> curDTPageIdSupplier) {
        Intrinsics.checkNotNullParameter(curPageIdSupplier, "curPageIdSupplier");
        Intrinsics.checkNotNullParameter(curDTPageIdSupplier, "curDTPageIdSupplier");
        this.curPageIdSupplier = curPageIdSupplier;
        this.curDTPageIdSupplier = curDTPageIdSupplier;
        this.lastFeedId = "";
    }

    private final void M9(View root) {
        View view = this.dialogRoot;
        ViewGroup viewGroup = null;
        this.dialogRoot = null;
        if (root != null) {
            ViewGroup viewGroup2 = (ViewGroup) root.getParent();
            if (viewGroup2 == null) {
                QLog.e(getLogTag(), 1, "null dialog root parent");
                return;
            } else {
                viewGroup2.removeView(root);
                return;
            }
        }
        View partRootView = getPartRootView();
        if (partRootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) partRootView;
        }
        if (view != null && viewGroup != null) {
            viewGroup.removeView(view);
            return;
        }
        QLog.e(getLogTag(), 1, "null dialogRoot " + view + " or null dialogViewContainer " + viewGroup + " when dismiss");
    }

    static /* synthetic */ void N9(QFSActivityDialogPart qFSActivityDialogPart, View view, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = null;
        }
        qFSActivityDialogPart.M9(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Disposable P9(int count) {
        if (count <= 0) {
            return new Disposable(null, new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSActivityDialogPart$queryLottery$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, 1, null);
        }
        return Q9(new QFSActivityDialogPart$queryLottery$2(this, count));
    }

    private final Disposable Q9(final Function2<? super QQCircleActivityLottery$LotteryResultRsp, ? super Throwable, Unit> callback) {
        final VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
        final int sendRequest = vSNetworkHelper.sendRequest(RFWApplication.getApplication(), new QFSActivityLotteryDetailReq(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.part.i
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSActivityDialogPart.R9(QFSActivityDialogPart.this, callback, baseRequest, z16, j3, str, obj);
            }
        });
        return new Disposable(null, new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSActivityDialogPart$queryLottery$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VSNetworkHelper.this.cancelRequest(RFWApplication.getApplication(), sendRequest);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QFSActivityDialogPart this$0, Function2 callback, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d(this$0.getLogTag(), 1, "queryLottery onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        if ((obj instanceof QQCircleActivityLottery$LotteryResultRsp) && j3 == 0 && z16) {
            callback.invoke(obj, null);
            return;
        }
        callback.invoke(null, new IllegalStateException("rsp invalid " + obj + " " + j3 + " " + z16));
    }

    private final void S9() {
        if (this.publishCallback == null) {
            this.publishCallback = new b();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.publishCallback, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        Disposable disposable = this.reqDisposable;
        if (disposable != null) {
            disposable.b();
        }
        this.reqDisposable = ba(new QFSActivityDialogPart$requestLottery$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(final QQCircleActivityLottery$LotteryResultRsp rsp) {
        boolean contains;
        ViewGroup viewGroup;
        contains = ArraysKt___ArraysKt.contains(new Integer[]{501, 503, 504}, this.curPageIdSupplier.get());
        if (!contains) {
            QLog.i(getLogTag(), 1, "in another tab ignore");
            return;
        }
        if (this.dialogRoot != null) {
            QLog.i(getLogTag(), 1, "dialog showing");
            return;
        }
        View partRootView = getPartRootView();
        if (partRootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) partRootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        View findViewById = LayoutInflater.from(getContext()).inflate(R.layout.gok, viewGroup).findViewById(R.id.bja);
        this.dialogRoot = findViewById;
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.uhb);
        ImageView imageView2 = (ImageView) findViewById.findViewById(R.id.uhd);
        View findViewById2 = findViewById.findViewById(R.id.ygm);
        View findViewById3 = findViewById.findViewById(R.id.f74363w2);
        View findViewById4 = findViewById.findViewById(R.id.f164759tq4);
        View findViewById5 = findViewById.findViewById(R.id.abu);
        ImageView imageView3 = (ImageView) findViewById.findViewById(R.id.vow);
        TextView textView = (TextView) findViewById.findViewById(R.id.vo6);
        VideoReport.setPageId(findViewById, this.curDTPageIdSupplier.get());
        VideoReport.setPageId(findViewById2, this.curDTPageIdSupplier.get());
        VideoReport.setPageId(findViewById3, this.curDTPageIdSupplier.get());
        VideoReport.setPageId(findViewById4, this.curDTPageIdSupplier.get());
        VideoReport.setPageId(findViewById5, this.curDTPageIdSupplier.get());
        VideoReport.setPageId(imageView2, this.curDTPageIdSupplier.get());
        VideoReport.setElementId(findViewById, QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_REWARD_POP);
        VideoReport.setElementId(findViewById2, QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_REWARD_POP_OPERATION);
        VideoReport.setElementId(findViewById3, QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_REWARD_POP_OPERATION);
        VideoReport.setElementId(findViewById4, QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_REWARD_POP_OPERATION);
        VideoReport.setElementId(findViewById5, QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_REWARD_POP_OPERATION);
        VideoReport.setElementId(imageView2, QCircleDaTongConstant.ElementId.EM_XSJ_SPRING_REWARD_POP_CLOSE);
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_ALL);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView2, clickPolicy);
        VideoReport.setElementClickPolicy(findViewById2, clickPolicy);
        VideoReport.setElementParam(findViewById2, "xsj_item_name", "\u524d\u5f80\u67e5\u770b");
        VideoReport.setElementClickPolicy(findViewById3, clickPolicy);
        VideoReport.setElementParam(findViewById3, "xsj_item_name", "\u5956\u54c1\u8bb0\u5f55");
        VideoReport.setElementClickPolicy(findViewById4, clickPolicy);
        VideoReport.setElementParam(findViewById4, "xsj_item_name", "\u5956\u54c1\u8bb0\u5f55");
        VideoReport.setElementClickPolicy(findViewById5, clickPolicy);
        if (rsp.lottery_result.get() == 1) {
            VideoReport.setElementParam(findViewById5, "xsj_item_name", "\u66f4\u591a\u73a9\u6cd5");
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(0);
            textView.setVisibility(8);
            textView.setVisibility(8);
            findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSActivityDialogPart.V9(QFSActivityDialogPart.this, rsp, view);
                }
            });
            imageView.setImageDrawable(URLDrawable.getDrawable("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/luckybag/qvideo_luckybag_limit.png", URLDrawable.URLDrawableOptions.obtain()));
        } else {
            VideoReport.setElementParam(findViewById5, "xsj_item_name", "\u66f4\u591a\u73a9\u6cd5\u5f97\u798f\u888b");
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(0);
            findViewById4.setVisibility(8);
            textView.setVisibility(0);
            textView.setVisibility(0);
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSActivityDialogPart.W9(QFSActivityDialogPart.this, rsp, view);
                }
            });
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSActivityDialogPart.X9(QFSActivityDialogPart.this, rsp, view);
                }
            });
            imageView.setImageDrawable(URLDrawable.getDrawable("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/luckybag/qvideo_luckybag_get.png", URLDrawable.URLDrawableOptions.obtain()));
            textView.setText(rsp.lottery_detail.name.get());
            imageView3.setImageDrawable(URLDrawable.getDrawable(rsp.lottery_detail.award_image_url.get(), URLDrawable.URLDrawableOptions.obtain()));
        }
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSActivityDialogPart.Y9(QFSActivityDialogPart.this, rsp, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSActivityDialogPart.Z9(QFSActivityDialogPart.this, view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSActivityDialogPart.aa(QFSActivityDialogPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QFSActivityDialogPart this$0, QQCircleActivityLottery$LotteryResultRsp rsp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        N9(this$0, null, 1, null);
        QLog.i(this$0.getLogTag(), 1, "goto award list " + rsp.award_list_schema.get());
        com.tencent.biz.qqcircle.launcher.c.g(this$0.getContext(), rsp.award_list_schema.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QFSActivityDialogPart this$0, QQCircleActivityLottery$LotteryResultRsp rsp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        N9(this$0, null, 1, null);
        QLog.i(this$0.getLogTag(), 1, "goto award use " + rsp.lottery_detail.award_use_schema.get());
        com.tencent.biz.qqcircle.launcher.c.g(this$0.getContext(), rsp.lottery_detail.award_use_schema.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QFSActivityDialogPart this$0, QQCircleActivityLottery$LotteryResultRsp rsp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        N9(this$0, null, 1, null);
        QLog.i(this$0.getLogTag(), 1, "goto award list " + rsp.award_list_schema.get());
        com.tencent.biz.qqcircle.launcher.c.g(this$0.getContext(), rsp.award_list_schema.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QFSActivityDialogPart this$0, QQCircleActivityLottery$LotteryResultRsp rsp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        N9(this$0, null, 1, null);
        QLog.i(this$0.getLogTag(), 1, "goto more " + rsp.more_activity_schema.get());
        com.tencent.biz.qqcircle.launcher.c.g(this$0.getContext(), rsp.more_activity_schema.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QFSActivityDialogPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        N9(this$0, null, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(QFSActivityDialogPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Disposable ba(final Function2<? super QQCircleActivityLottery$LotteryResultRsp, ? super Throwable, Unit> callback) {
        final VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
        final int sendRequest = vSNetworkHelper.sendRequest(RFWApplication.getApplication(), new QFSActivityTriggerLotteryReq(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.part.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSActivityDialogPart.ca(QFSActivityDialogPart.this, callback, baseRequest, z16, j3, str, obj);
            }
        });
        return new Disposable(null, new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSActivityDialogPart$triggerLottery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VSNetworkHelper.this.cancelRequest(RFWApplication.getApplication(), sendRequest);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(QFSActivityDialogPart this$0, Function2 callback, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d(this$0.getLogTag(), 1, "triggerLottery onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        if ((obj instanceof QQCircleActivityLottery$LotteryResultRsp) && j3 == 0 && z16) {
            callback.invoke(obj, null);
            return;
        }
        callback.invoke(null, new IllegalStateException("rsp invalid " + obj + " " + j3 + " " + z16));
    }

    private final void da() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.publishCallback;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    @NotNull
    public final Supplier<Integer> O9() {
        return this.curPageIdSupplier;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QFSJumpPublishEvent>> getEventClass() {
        ArrayList<Class<QFSJumpPublishEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSJumpPublishEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "QFSActivityDialogPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        S9();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Disposable disposable = this.reqDisposable;
        if (disposable != null) {
            disposable.b();
        }
        RFWThreadManager.getUIHandler().removeMessages(234112);
        da();
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        D.put(Integer.valueOf(hashCode()), 2);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        D.put(Integer.valueOf(hashCode()), 1);
        URLDrawable.getDrawable("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/luckybag/qvideo_luckybag_get.png", URLDrawable.URLDrawableOptions.obtain());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent p06) {
        if (p06 instanceof QFSJumpPublishEvent) {
            N9(this, null, 1, null);
        }
    }
}

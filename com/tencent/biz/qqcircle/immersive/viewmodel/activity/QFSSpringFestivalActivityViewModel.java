package com.tencent.biz.qqcircle.immersive.viewmodel.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.immersive.part.QFSSpringFestivalActivityDialogPart;
import com.tencent.biz.qqcircle.immersive.request.QFSGetPrizePopupReq;
import com.tencent.biz.qqcircle.immersive.request.QFSTurnOffPrizePopupReq;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StShare;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSpringPrizePopup$SpringMaterial;
import qqcircle.QQCircleSpringPrizePopup$StGetPrizePopupRsp;
import qqcircle.QQCircleSpringPrizePopup$StPrizeInfo;
import qqcircle.QQCircleSpringPrizePopup$StPrizePopupInfo;
import qqcircle.QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00029:B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u000eR8\u0010%\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00100\u0010 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\"0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001f\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/QFSSpringFestivalActivityViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/d;", "T1", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "feedId", "", "retryTimes", "", "d2", "Lqqcircle/QQCircleSpringPrizePopup$StPrizePopupInfo;", "popupInfo", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/QFSSpringFestivalActivityViewModel$b;", "task", "g2", "queryTask", "c2", "getLogTag", "b2", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "X1", "", "info", "Z1", "popupId", "U1", "S1", "", "kotlin.jvm.PlatformType", "", "i", "Ljava/util/List;", "queryTasks", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_activityInfo", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "activityInfo", "D", "Lkotlin/Lazy;", "R1", "()Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/d;", DownloadInfo.spKey_Config, "<init>", "()V", "E", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSpringFestivalActivityViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<a> activityInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<QueryTask> queryTasks = Collections.synchronizedList(new ArrayList());

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<a> _activityInfo;

    public QFSSpringFestivalActivityViewModel() {
        Lazy lazy;
        MutableLiveData<a> mutableLiveData = new MutableLiveData<>();
        this._activityInfo = mutableLiveData;
        this.activityInfo = mutableLiveData;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.activity.QFSSpringFestivalActivityViewModel$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                d T1;
                T1 = QFSSpringFestivalActivityViewModel.this.T1();
                return T1;
            }
        });
        this.config = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d R1() {
        return (d) this.config.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d T1() {
        d dVar;
        try {
            d lazyInitConfig$lambda$4 = (d) new Gson().fromJson(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("101962", ""), d.class);
            Intrinsics.checkNotNullExpressionValue(lazyInitConfig$lambda$4, "lazyInitConfig$lambda$4");
            dVar = d.b(lazyInitConfig$lambda$4, null, lazyInitConfig$lambda$4.getFetchIntervalMs() * 1000, 0, null, 13, null);
        } catch (Exception unused) {
            dVar = new d(null, 0L, 0, null, 15, null);
        }
        QLog.i("QFSSpringFestivalActivityViewModel", 1, "[lazyInitConfig] config=" + dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(String popupId, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp qQCircleSpringPrizePopup$StTurnOffPrizePopupRsp) {
        Intrinsics.checkNotNullParameter(popupId, "$popupId");
        QLog.i("QFSSpringFestivalActivityViewModel", 1, "[onActivityConsumed] traceId=" + baseRequest.getTraceId() + ", isSuccess=" + z16 + ", retCode=" + j3 + ", errMsg=" + str + ", popupId=" + popupId);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean a2(QQCircleSpringPrizePopup$StPrizePopupInfo popupInfo) {
        PBRepeatMessageField<QQCircleSpringPrizePopup$StPrizeInfo> pBRepeatMessageField;
        Boolean bool;
        Boolean bool2;
        Integer num;
        boolean z16;
        boolean z17;
        PopupType popupType;
        PopupType popupType2;
        QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial;
        Object first;
        PBInt32Field pBInt32Field;
        FeedCloudMeta$StShare feedCloudMeta$StShare = null;
        if (popupInfo != null) {
            pBRepeatMessageField = popupInfo.prize_info;
        } else {
            pBRepeatMessageField = null;
        }
        if (popupInfo != null) {
            bool = Boolean.valueOf(popupInfo.has());
        } else {
            bool = null;
        }
        if (pBRepeatMessageField != null) {
            bool2 = Boolean.valueOf(pBRepeatMessageField.has());
        } else {
            bool2 = null;
        }
        if (popupInfo != null && (pBInt32Field = popupInfo.popup_type) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        QLog.i("QFSSpringFestivalActivityViewModel", 1, "[postActivityInfo] hasPopupInfo=" + bool + ", hasPrizeInfo=" + bool2 + ", popupType=" + num);
        if (popupInfo != null && popupInfo.has()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (pBRepeatMessageField != null && pBRepeatMessageField.has()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                int i3 = popupInfo.popup_type.get();
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            popupType2 = null;
                            if (popupType2 != null) {
                                String str = popupInfo.popup_id.get();
                                Intrinsics.checkNotNullExpressionValue(str, "popupInfo.popup_id.get()");
                                String str2 = popupInfo.reason.get();
                                Intrinsics.checkNotNullExpressionValue(str2, "popupInfo.reason.get()");
                                QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial2 = popupInfo.material;
                                if (qQCircleSpringPrizePopup$SpringMaterial2 != null) {
                                    qQCircleSpringPrizePopup$SpringMaterial = qQCircleSpringPrizePopup$SpringMaterial2.get();
                                } else {
                                    qQCircleSpringPrizePopup$SpringMaterial = null;
                                }
                                FeedCloudMeta$StShare feedCloudMeta$StShare2 = popupInfo.share_info;
                                if (feedCloudMeta$StShare2 != null) {
                                    feedCloudMeta$StShare = feedCloudMeta$StShare2.get();
                                }
                                List<QQCircleSpringPrizePopup$StPrizeInfo> list = pBRepeatMessageField.get();
                                Intrinsics.checkNotNullExpressionValue(list, "prizeInfo.get()");
                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                                Intrinsics.checkNotNullExpressionValue(first, "prizeInfo.get().first()");
                                a aVar = new a(popupType2, str, str2, qQCircleSpringPrizePopup$SpringMaterial, feedCloudMeta$StShare, (QQCircleSpringPrizePopup$StPrizeInfo) first);
                                this._activityInfo.postValue(aVar);
                                QLog.i("QFSSpringFestivalActivityViewModel", 1, "[postActivityInfo] " + aVar);
                                return true;
                            }
                        } else {
                            popupType = PopupType.THANKS;
                        }
                    } else {
                        popupType = PopupType.LIMIT;
                    }
                } else {
                    popupType = PopupType.NORMAL;
                }
                popupType2 = popupType;
                if (popupType2 != null) {
                }
            }
        }
        return false;
    }

    private final void c2(QueryTask queryTask) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSSpringFestivalActivityViewModel$queryOnTime$1(this, queryTask, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(final long taskId, final String feedId, final int retryTimes) {
        sendRequest(new QFSGetPrizePopupReq(R1().getActivityId(), taskId, feedId), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.activity.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSSpringFestivalActivityViewModel.f2(taskId, feedId, retryTimes, this, baseRequest, z16, j3, str, (QQCircleSpringPrizePopup$StGetPrizePopupRsp) obj);
            }
        });
    }

    static /* synthetic */ void e2(QFSSpringFestivalActivityViewModel qFSSpringFestivalActivityViewModel, long j3, String str, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        qFSSpringFestivalActivityViewModel.d2(j3, str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(long j3, String feedId, int i3, QFSSpringFestivalActivityViewModel this$0, BaseRequest baseRequest, boolean z16, long j16, String str, QQCircleSpringPrizePopup$StGetPrizePopupRsp qQCircleSpringPrizePopup$StGetPrizePopupRsp) {
        QQCircleSpringPrizePopup$StPrizePopupInfo qQCircleSpringPrizePopup$StPrizePopupInfo;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QFSSpringFestivalActivityViewModel", 1, "[queryPrizeResult] traceId=" + baseRequest.getTraceId() + ", isSuccess=" + z16 + ", retCode=" + j16 + ", errMsg=" + str + ", taskId=" + j3 + ", feedId=" + feedId + ", retryTimes=" + i3);
        List<QueryTask> queryTasks = this$0.queryTasks;
        Intrinsics.checkNotNullExpressionValue(queryTasks, "queryTasks");
        Iterator<T> it = queryTasks.iterator();
        while (true) {
            qQCircleSpringPrizePopup$StPrizePopupInfo = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((QueryTask) obj).getFeedId(), feedId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QueryTask queryTask = (QueryTask) obj;
        if (queryTask != null) {
            queryTask.e(queryTask.getRetryCount() + 1);
        } else {
            queryTask = null;
        }
        if (j16 == 0 && z16) {
            if (qQCircleSpringPrizePopup$StGetPrizePopupRsp != null) {
                qQCircleSpringPrizePopup$StPrizePopupInfo = qQCircleSpringPrizePopup$StGetPrizePopupRsp.popup_info;
            }
            z17 = this$0.a2(qQCircleSpringPrizePopup$StPrizePopupInfo);
        } else {
            z17 = false;
        }
        if (!z17) {
            this$0.g2(queryTask, j3, feedId);
        }
    }

    private final void g2(QueryTask task, long taskId, String feedId) {
        if (task == null) {
            QueryTask queryTask = new QueryTask(taskId, feedId, R1().getFetchRetryCount(), 0, 8, null);
            this.queryTasks.add(queryTask);
            c2(queryTask);
        } else if (task.getRetryCount() == task.getRetryCountLimit()) {
            this.queryTasks.remove(task);
        } else {
            c2(task);
        }
    }

    @NotNull
    public final LiveData<a> Q1() {
        return this.activityInfo;
    }

    public final boolean S1() {
        boolean a16 = QFSSpringFestivalActivityDialogPart.INSTANCE.a();
        QLog.i("QFSSpringFestivalActivityViewModel", 1, "[isEnable] " + a16 + ", instance=" + hashCode());
        return a16;
    }

    public final void U1(@NotNull final String popupId) {
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        this._activityInfo.setValue(null);
        sendRequest(new QFSTurnOffPrizePopupReq(popupId), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.activity.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSSpringFestivalActivityViewModel.W1(popupId, baseRequest, z16, j3, str, (QQCircleSpringPrizePopup$StTurnOffPrizePopupRsp) obj);
            }
        });
    }

    public final void X1(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        if (taskInfo.isSuccess() && S1()) {
            QLog.i("QFSSpringFestivalActivityViewModel", 1, "onTaskStateChanged: taskid=" + taskInfo.getTaskId() + ", missionID=" + taskInfo.getMissionId() + ", state=" + taskInfo.getState());
            e2(this, taskInfo.getTaskId(), taskInfo.getFeedId(), 0, 4, null);
        }
    }

    public final void Z1(@NotNull byte[] info) {
        Intrinsics.checkNotNullParameter(info, "info");
        try {
            if (S1()) {
                QLog.i("QFSSpringFestivalActivityViewModel", 1, "[onPushActivityInfo]");
                a2(new QQCircleSpringPrizePopup$StPrizePopupInfo().mergeFrom(info));
            }
        } catch (Exception e16) {
            QLog.e("QFSSpringFestivalActivityViewModel", 1, "[onPushActivityInfo]", e16);
        }
    }

    public final void b2() {
        if (S1()) {
            QLog.i("QFSSpringFestivalActivityViewModel", 1, "[preloadImageRes] instance=" + hashCode());
            List<String> f16 = R1().f();
            if (f16 != null) {
                Iterator<T> it = f16.iterator();
                while (it.hasNext()) {
                    QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl((String) it.next()).setFromPreLoad(true));
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSpringFestivalActivityViewModel";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/QFSSpringFestivalActivityViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "Ljava/lang/String;", "()Ljava/lang/String;", "feedId", "c", "I", "()I", "retryCountLimit", "e", "(I)V", "retryCount", "<init>", "(JLjava/lang/String;II)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.viewmodel.activity.QFSSpringFestivalActivityViewModel$b, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class QueryTask {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long taskId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int retryCountLimit;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int retryCount;

        public QueryTask(long j3, @NotNull String feedId, int i3, int i16) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.taskId = j3;
            this.feedId = feedId;
            this.retryCountLimit = i3;
            this.retryCount = i16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: b, reason: from getter */
        public final int getRetryCount() {
            return this.retryCount;
        }

        /* renamed from: c, reason: from getter */
        public final int getRetryCountLimit() {
            return this.retryCountLimit;
        }

        /* renamed from: d, reason: from getter */
        public final long getTaskId() {
            return this.taskId;
        }

        public final void e(int i3) {
            this.retryCount = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QueryTask)) {
                return false;
            }
            QueryTask queryTask = (QueryTask) other;
            if (this.taskId == queryTask.taskId && Intrinsics.areEqual(this.feedId, queryTask.feedId) && this.retryCountLimit == queryTask.retryCountLimit && this.retryCount == queryTask.retryCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((androidx.fragment.app.a.a(this.taskId) * 31) + this.feedId.hashCode()) * 31) + this.retryCountLimit) * 31) + this.retryCount;
        }

        @NotNull
        public String toString() {
            return "QueryTask(taskId=" + this.taskId + ", feedId=" + this.feedId + ", retryCountLimit=" + this.retryCountLimit + ", retryCount=" + this.retryCount + ")";
        }

        public /* synthetic */ QueryTask(long j3, String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, str, i3, (i17 & 8) != 0 ? 1 : i16);
        }
    }
}

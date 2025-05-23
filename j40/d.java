package j40;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.requests.QFSGetFeedDetailRequest;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.qqcircle.widgets.p;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import h40.QFSPersonalCoverFeedInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\t*\u0001+\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR#\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c0 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0 8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lj40/d;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "T1", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "X1", "Z1", "U1", "W1", "b2", "", "getLogTag", "", "", "Lh40/a;", "i", "Ljava/util/Map;", "publishMap", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "publishingList", BdhLogUtil.LogTag.Tag_Conn, "publishFailedList", "D", "publishSucceedList", "Landroidx/lifecycle/MutableLiveData;", "", "E", "Landroidx/lifecycle/MutableLiveData;", "_coverPublishData", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "coverPublishData", "G", "_publishingData", "H", "S1", "publishingData", "j40/d$b", "I", "Lj40/d$b;", "publishCallback", "<init>", "()V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends BaseViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<QFSPersonalCoverFeedInfo>> _coverPublishData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<QFSPersonalCoverFeedInfo>> coverPublishData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QFSPersonalCoverFeedInfo> _publishingData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<QFSPersonalCoverFeedInfo> publishingData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final b publishCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, QFSPersonalCoverFeedInfo> publishMap = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSPersonalCoverFeedInfo> publishingList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<QFSPersonalCoverFeedInfo> publishFailedList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<QFSPersonalCoverFeedInfo> publishSucceedList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"j40/d$b", "Lcom/tencent/biz/qqcircle/widgets/a;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskStateChanged", "onProgressChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.biz.qqcircle.widgets.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NotNull TaskInfo taskInfo) {
            QFSPersonalCoverFeedInfo qFSPersonalCoverFeedInfo;
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            if (!taskInfo.isImageTask() && (qFSPersonalCoverFeedInfo = (QFSPersonalCoverFeedInfo) d.this.publishMap.get(Long.valueOf(taskInfo.getTaskId()))) != null) {
                d dVar = d.this;
                qFSPersonalCoverFeedInfo.g(taskInfo.getUploadProgress());
                dVar._publishingData.setValue(qFSPersonalCoverFeedInfo);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            if (taskInfo.isImageTask()) {
                return;
            }
            if (taskInfo.isSuccess()) {
                d.this.X1(taskInfo);
            } else if (taskInfo.isActive()) {
                d.this.W1(taskInfo);
            } else if (p.d(taskInfo)) {
                d.this.U1(taskInfo);
            }
        }
    }

    public d() {
        MutableLiveData<List<QFSPersonalCoverFeedInfo>> mutableLiveData = new MutableLiveData<>();
        this._coverPublishData = mutableLiveData;
        this.coverPublishData = mutableLiveData;
        MutableLiveData<QFSPersonalCoverFeedInfo> mutableLiveData2 = new MutableLiveData<>();
        this._publishingData = mutableLiveData2;
        this.publishingData = mutableLiveData2;
        b bVar = new b();
        this.publishCallback = bVar;
        QCirclePublishCallbackHelper.f93064a.i(bVar, true);
    }

    private final void T1() {
        List plus;
        List<QFSPersonalCoverFeedInfo> plus2;
        MutableLiveData<List<QFSPersonalCoverFeedInfo>> mutableLiveData = this._coverPublishData;
        plus = CollectionsKt___CollectionsKt.plus((Collection) this.publishingList, (Iterable) this.publishFailedList);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) this.publishSucceedList);
        mutableLiveData.setValue(plus2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(TaskInfo taskInfo) {
        QFSPersonalCoverFeedInfo qFSPersonalCoverFeedInfo = this.publishMap.get(Long.valueOf(taskInfo.getTaskId()));
        if (qFSPersonalCoverFeedInfo != null) {
            QLog.d("QFSPersonalCoverPublishViewModel", 1, "onPublishFailed, taskId: " + taskInfo.getTaskId());
            this.publishingList.remove(qFSPersonalCoverFeedInfo);
            QFSPersonalCoverFeedInfo d16 = QFSPersonalCoverFeedInfo.INSTANCE.d(taskInfo);
            this.publishMap.put(Long.valueOf(taskInfo.getTaskId()), d16);
            this.publishFailedList.add(0, d16);
            T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(TaskInfo taskInfo) {
        QFSPersonalCoverFeedInfo qFSPersonalCoverFeedInfo = this.publishMap.get(Long.valueOf(taskInfo.getTaskId()));
        if (qFSPersonalCoverFeedInfo == null) {
            QLog.d("QFSPersonalCoverPublishViewModel", 1, "onPublishStart, new task, taskId: " + taskInfo.getTaskId());
            b2(taskInfo);
            return;
        }
        if (this.publishFailedList.contains(qFSPersonalCoverFeedInfo)) {
            QLog.d("QFSPersonalCoverPublishViewModel", 1, "onPublishStart, retry task, taskId: " + taskInfo.getTaskId());
            this.publishFailedList.remove(qFSPersonalCoverFeedInfo);
            b2(taskInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(TaskInfo taskInfo) {
        if (this.publishMap.get(Long.valueOf(taskInfo.getTaskId())) != null) {
            QLog.d("QFSPersonalCoverPublishViewModel", 1, "onPublishSucceed, taskId: " + taskInfo.getTaskId());
            Z1(taskInfo);
        }
    }

    private final void Z1(final TaskInfo taskInfo) {
        VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
        QFSGetFeedDetailRequest qFSGetFeedDetailRequest = new QFSGetFeedDetailRequest(taskInfo.getFeedId(), true);
        VSDispatchObserver.OnVSRspCallBack onVSRspCallBack = new VSDispatchObserver.OnVSRspCallBack() { // from class: j40.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                d.a2(d.this, taskInfo, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedDetailRsp) obj);
            }
        };
        Intrinsics.checkNotNull(onVSRspCallBack, "null cannot be cast to non-null type com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack<feedcloud.FeedCloudRead.StGetFeedDetailRsp?>");
        vSNetworkHelper.sendRequest(qFSGetFeedDetailRequest, onVSRspCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(d this$0, TaskInfo taskInfo, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSPersonalCoverFeedInfo qFSPersonalCoverFeedInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskInfo, "$taskInfo");
        QLog.d("QFSPersonalCoverPublishViewModel", 1, "requestFeedDetail, isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str);
        if (z16 && j3 == 0) {
            if (feedCloudRead$StGetFeedDetailRsp != null) {
                feedCloudMeta$StFeed = feedCloudRead$StGetFeedDetailRsp.feed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            if (feedCloudMeta$StFeed != null && (qFSPersonalCoverFeedInfo = this$0.publishMap.get(Long.valueOf(taskInfo.getTaskId()))) != null) {
                this$0.publishingList.remove(qFSPersonalCoverFeedInfo);
                QFSPersonalCoverFeedInfo.Companion companion = QFSPersonalCoverFeedInfo.INSTANCE;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = feedCloudRead$StGetFeedDetailRsp.feed;
                Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed2, "rsp.feed");
                QFSPersonalCoverFeedInfo b16 = companion.b(feedCloudMeta$StFeed2);
                this$0.publishMap.put(Long.valueOf(taskInfo.getTaskId()), b16);
                this$0.publishSucceedList.add(0, b16);
                this$0.T1();
            }
        }
    }

    private final void b2(TaskInfo taskInfo) {
        QFSPersonalCoverFeedInfo e16 = QFSPersonalCoverFeedInfo.INSTANCE.e(taskInfo);
        this.publishMap.put(Long.valueOf(taskInfo.getTaskId()), e16);
        this.publishingList.add(0, e16);
        T1();
    }

    @NotNull
    public final LiveData<List<QFSPersonalCoverFeedInfo>> R1() {
        return this.coverPublishData;
    }

    @NotNull
    public final LiveData<QFSPersonalCoverFeedInfo> S1() {
        return this.publishingData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverPublishViewModel";
    }
}

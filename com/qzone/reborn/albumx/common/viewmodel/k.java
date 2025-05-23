package com.qzone.reborn.albumx.common.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.albumx.common.bean.CommonTransmitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R#\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001f0#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010!R#\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001f0#8\u0006\u00a2\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010!R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b0\u0010'R\u001a\u00104\u001a\b\u0012\u0004\u0012\u0002020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010!R\u001d\u00107\u001a\b\u0012\u0004\u0012\u0002020#8\u0006\u00a2\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b6\u0010'\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/k;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/publish/business/publishqueue/b;", "", "Z1", "", "caseId", "Lcom/qzone/publish/business/publishqueue/common/CommonPublishQueue;", "T1", "Lcom/qzone/publish/business/task/IQueueTask;", "queueTask", "albumId", "", "U1", "S1", "task", "W1", "M1", "onQueueChanged", "H", "onCleared", "i", "Ljava/lang/String;", "N1", "()Ljava/lang/String;", "X1", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/publish/business/publishqueue/common/CommonPublishQueue;", "publishQueue", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_taskList", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "taskList", "E", "_failedTaskList", UserInfo.SEX_FEMALE, "O1", "failedTaskList", "G", "_progressChangeTask", "P1", "progressChangeTask", "Lcom/qzone/reborn/albumx/common/bean/j;", "I", "_transmitData", "J", "R1", "transmitData", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class k extends com.qzone.reborn.base.n implements com.qzone.publish.business.publishqueue.b {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<IQueueTask>> _taskList;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<IQueueTask>> taskList;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<List<IQueueTask>> _failedTaskList;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<List<IQueueTask>> failedTaskList;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<IQueueTask> _progressChangeTask;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<IQueueTask> progressChangeTask;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<CommonTransmitBean> _transmitData;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<CommonTransmitBean> transmitData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CommonPublishQueue publishQueue;

    public k() {
        MutableLiveData<List<IQueueTask>> mutableLiveData = new MutableLiveData<>();
        this._taskList = mutableLiveData;
        this.taskList = mutableLiveData;
        MutableLiveData<List<IQueueTask>> mutableLiveData2 = new MutableLiveData<>();
        this._failedTaskList = mutableLiveData2;
        this.failedTaskList = mutableLiveData2;
        MutableLiveData<IQueueTask> mutableLiveData3 = new MutableLiveData<>();
        this._progressChangeTask = mutableLiveData3;
        this.progressChangeTask = mutableLiveData3;
        MutableLiveData<CommonTransmitBean> mutableLiveData4 = new MutableLiveData<>();
        this._transmitData = mutableLiveData4;
        this.transmitData = mutableLiveData4;
    }

    public final void M1(IQueueTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        CommonPublishQueue commonPublishQueue = this.publishQueue;
        if (commonPublishQueue == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishQueue");
            commonPublishQueue = null;
        }
        commonPublishQueue.f(task);
    }

    /* renamed from: N1, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    public final LiveData<List<IQueueTask>> O1() {
        return this.failedTaskList;
    }

    public final LiveData<IQueueTask> P1() {
        return this.progressChangeTask;
    }

    public final LiveData<List<IQueueTask>> Q1() {
        return this.taskList;
    }

    public final LiveData<CommonTransmitBean> R1() {
        return this.transmitData;
    }

    public final void S1(String caseId, String albumId) {
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        RFWLog.i(getLogTag(), RFWLog.USR, "initData, caseId:" + caseId + ", albumId:" + albumId);
        this.albumId = albumId;
        CommonPublishQueue T1 = T1(caseId);
        this.publishQueue = T1;
        T1.i(this);
        Z1();
    }

    public abstract CommonPublishQueue T1(String caseId);

    public abstract boolean U1(IQueueTask queueTask, String albumId);

    public final void W1(IQueueTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        task.increaseManualRetryNum();
        task.getPublishQueue().j(task);
    }

    public final void X1(String str) {
        this.albumId = str;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CommonPublishQueue commonPublishQueue = this.publishQueue;
        if (commonPublishQueue == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishQueue");
            commonPublishQueue = null;
        }
        commonPublishQueue.M(this);
    }

    @Override // com.qzone.publish.business.publishqueue.b
    public void onQueueChanged() {
        Z1();
    }

    private final void Z1() {
        List a16;
        List e16;
        boolean z16;
        boolean z17;
        if (!TextUtils.isEmpty(this.albumId)) {
            CommonPublishQueue commonPublishQueue = this.publishQueue;
            if (commonPublishQueue == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishQueue");
                commonPublishQueue = null;
            }
            CopyOnWriteArrayList<IQueueTask> a17 = commonPublishQueue.a();
            a16 = new ArrayList();
            for (Object obj : a17) {
                IQueueTask it = (IQueueTask) obj;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String str = this.albumId;
                Intrinsics.checkNotNull(str);
                if (U1(it, str)) {
                    a16.add(obj);
                }
            }
        } else {
            CommonPublishQueue commonPublishQueue2 = this.publishQueue;
            if (commonPublishQueue2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishQueue");
                commonPublishQueue2 = null;
            }
            a16 = commonPublishQueue2.a();
        }
        this._taskList.setValue(a16);
        LiveData liveData = this._failedTaskList;
        if (!TextUtils.isEmpty(this.albumId)) {
            CommonPublishQueue commonPublishQueue3 = this.publishQueue;
            if (commonPublishQueue3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishQueue");
                commonPublishQueue3 = null;
            }
            CopyOnWriteArrayList<IQueueTask> e17 = commonPublishQueue3.e();
            e16 = new ArrayList();
            for (Object obj2 : e17) {
                IQueueTask it5 = (IQueueTask) obj2;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                String str2 = this.albumId;
                Intrinsics.checkNotNull(str2);
                if (U1(it5, str2)) {
                    e16.add(obj2);
                }
            }
        } else {
            CommonPublishQueue commonPublishQueue4 = this.publishQueue;
            if (commonPublishQueue4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishQueue");
                commonPublishQueue4 = null;
            }
            e16 = commonPublishQueue4.e();
        }
        liveData.setValue(e16);
        MutableLiveData<CommonTransmitBean> mutableLiveData = this._transmitData;
        List list = a16;
        boolean z18 = list instanceof Collection;
        if (!z18 || !list.isEmpty()) {
            Iterator it6 = list.iterator();
            while (it6.hasNext()) {
                if (((IQueueTask) it6.next()).getState() == 1) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z18 || !list.isEmpty()) {
            Iterator it7 = list.iterator();
            while (it7.hasNext()) {
                if (((IQueueTask) it7.next()).getState() == 6) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        CommonPublishQueue commonPublishQueue5 = this.publishQueue;
        if (commonPublishQueue5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishQueue");
            commonPublishQueue5 = null;
        }
        mutableLiveData.setValue(new CommonTransmitBean(z16, z17, commonPublishQueue5.v(this.albumId), a16.size()));
        String logTag = getLogTag();
        List<IQueueTask> value = this._taskList.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        List<IQueueTask> value2 = this._failedTaskList.getValue();
        QLog.i(logTag, 1, "updateTaskList  allTask=" + valueOf + "  | failTask=" + (value2 != null ? Integer.valueOf(value2.size()) : null));
    }

    @Override // com.qzone.publish.business.publishqueue.b
    public void H(IQueueTask task) {
        if (task == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.albumId)) {
            String str = this.albumId;
            Intrinsics.checkNotNull(str);
            if (U1(task, str)) {
                this._progressChangeTask.setValue(task);
                return;
            }
            return;
        }
        this._progressChangeTask.setValue(task);
    }
}

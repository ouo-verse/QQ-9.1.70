package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bd extends g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    private ITaskListener.Stub f55039d;

    private void E9() {
        this.f55039d = new a();
        try {
            WinkPublishHelper2.INSTANCE.bindService(1, new WinkPublishHelper2.Callback() { // from class: com.qzone.reborn.feedx.part.bc
                @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
                public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                    bd.this.F9(winkPublishServiceProxy2);
                }
            });
        } catch (Exception e16) {
            QLog.e("QZoneFeedxQCirclePublishResultPart", 1, "[addWinkPublishTaskListener] bindService", e16);
        }
    }

    private void G9() {
        WinkPublishServiceProxy2 qfsService;
        try {
            if (this.f55039d == null || (qfsService = WinkPublishHelper2.INSTANCE.getQfsService()) == null) {
                return;
            }
            qfsService.removeTaskListener(this.f55039d);
        } catch (Exception e16) {
            QLog.e("QZoneFeedxQCirclePublishResultPart", 1, "[removeWinkPublishTaskListener]", e16);
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (event.what == 3) {
            E9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        EventCenter.getInstance().addUIObserver(this, "FeedX", 3);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        G9();
        EventCenter.getInstance().removeObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends ITaskListener.Stub {
        a() {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(TaskInfo taskInfo) {
            Bundle transParams;
            if (taskInfo == null || !taskInfo.isTrueUpload()) {
                return;
            }
            if ((taskInfo.isFinish() || taskInfo.isCancelled()) && (transParams = taskInfo.getTransParams()) != null) {
                if (String.valueOf(311).equals(transParams.getString("publish_trans_tag", ""))) {
                    if (taskInfo.isSuccess()) {
                        ToastUtil.s(com.dataline.util.j.d("\u53d1\u8868\u6210\u529f\uff0c\u53ef\u5230\u5c0f\u4e16\u754c\u67e5\u770b"), 2);
                    } else {
                        ToastUtil.s("\u53d1\u8868\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 1);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        if (winkPublishServiceProxy2 == null) {
            QLog.i("QZoneFeedxQCirclePublishResultPart", 1, "[addWinkPublishTaskListener] service is null");
        } else {
            winkPublishServiceProxy2.addTaskListener2(this.f55039d);
        }
    }
}

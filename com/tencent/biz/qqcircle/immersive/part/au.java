package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class au extends u {
    private Activity C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private at f87726d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f87727e;

    /* renamed from: f, reason: collision with root package name */
    private Context f87728f;

    /* renamed from: h, reason: collision with root package name */
    private View f87729h;

    /* renamed from: i, reason: collision with root package name */
    private ViewStub f87730i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.widgets.a f87731m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.biz.qqcircle.widgets.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NotNull TaskInfo taskInfo) {
            QLog.d("WinkPublish-Progress-QFSBoxProgressPartV2", 2, "onProgressChanged: taskid:" + taskInfo.getTaskId() + " missionID:" + taskInfo.getMissionId() + " state:" + taskInfo.getState() + " progress:" + taskInfo.getUploadProgress() + " exportprogress:" + taskInfo.getExportProgress());
            if (au.this.D == 1) {
                if (taskInfo.isVideoComment()) {
                    if (!QFSCommentHelper.L().e0(taskInfo.getTaskId() + "")) {
                        return;
                    }
                } else {
                    return;
                }
            }
            au auVar = au.this;
            auVar.E9(auVar.f87729h);
            if (au.this.f87726d != null) {
                au.this.f87726d.j(taskInfo);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            QLog.d("WinkPublish-Progress-QFSBoxProgressPartV2", 1, "onTaskStateChanged: taskid:" + taskInfo.getTaskId() + " missionID:" + taskInfo.getMissionId() + " state:" + taskInfo.getState() + " progress:" + taskInfo.getUploadProgress() + " exportprogress:" + taskInfo.getExportProgress());
            if (au.this.D == 1) {
                if (taskInfo.isVideoComment()) {
                    if (!QFSCommentHelper.L().e0(taskInfo.getTaskId() + "")) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (taskInfo.getTransParams() != null && TextUtils.equals(QQWinkConstants.WinkPublishTaskID.XSJ_COMMENT_PIC, taskInfo.getTransParams().getString(QQWinkConstants.WINK_PUBLISH_TASK_ID))) {
                return;
            }
            au auVar = au.this;
            auVar.E9(auVar.f87729h);
            if (au.this.f87726d != null) {
                au.this.f87726d.k(taskInfo);
            }
        }
    }

    public au() {
        this.D = 0;
    }

    public static void C9(View view, String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("WinkPublish-Progress-QFSBoxProgressPartV2", 1, "dtReport eventId: null");
            return;
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str2);
        VideoReport.reportEvent(str, view, buildElementParams);
    }

    private void D9() {
        if (this.f87731m == null) {
            this.f87731m = new a();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.f87731m, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(View view) {
        View findViewById;
        if (this.f87730i != null) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.part.publishprogress.q qVar = com.tencent.biz.qqcircle.immersive.part.publishprogress.q.f88294a;
        if (qVar.c(this.D)) {
            return;
        }
        qVar.b();
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f34710zw);
        this.f87730i = viewStub;
        if (viewStub == null) {
            return;
        }
        if (this.D == 0) {
            findViewById = getPartRootView().findViewById(R.id.f165302vg2);
        } else {
            findViewById = getPartRootView().findViewById(R.id.f98925oe);
        }
        this.f87727e = (ViewGroup) this.f87730i.inflate().findViewById(R.id.f496823c);
        this.f87726d = new at(this.C, this.f87728f, this, this.f87727e, findViewById);
    }

    private void F9() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.f87731m;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkPublish-Progress-QFSBoxProgressPartV2";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        QLog.d("WinkPublish-Progress-QFSBoxProgressPartV2", 1, "onInitView ");
        this.f87729h = view;
        this.f87728f = view.getContext();
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.C = activity;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        F9();
        at atVar = this.f87726d;
        if (atVar != null) {
            atVar.f();
        }
    }

    public au(int i3) {
        this.D = i3;
    }
}

package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u00103\u001a\u00020/\u00a2\u0006\u0004\b4\u00105J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/r;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "C9", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "", "getLogTag", "onPartDestroy", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mParentFrameLayout", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/m;", "e", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/m;", "mBoxProgressManager", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "mContainerView", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "mContext", "i", "Landroid/view/View;", "mRootView", "Landroid/view/ViewStub;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewStub;", "mViewStub", "Lcom/tencent/biz/qqcircle/widgets/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/widgets/a;", "mPublishCallback", "D", "Landroid/app/Activity;", "mActivity", "", "E", "I", HttpMsg.MTYPE, "type", "<init>", "(I)V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class r extends u {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.widgets.a mPublishCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: E, reason: from kotlin metadata */
    private int mType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mParentFrameLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private m mBoxProgressManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub mViewStub;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J<\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/r$a;", "", "Landroid/view/View;", "view", "", "eventId", "elementId", "", "extParams", "", "a", "TAG", "Ljava/lang/String;", "", "TYPE_LAYERPAGE", "I", "TYPE_MAINPAGE", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.publishprogress.r$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable View view, @Nullable String eventId, @Nullable String elementId, @Nullable Map<String, ? extends Object> extParams) {
            if (TextUtils.isEmpty(eventId)) {
                QLog.i("WinkPublish-Progress-QFSRectBoxPublishPart", 1, "dtReport eventId: null");
                return;
            }
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            if (extParams != null) {
                buildElementParams.putAll(extParams);
            }
            VideoReport.setElementId(view, elementId);
            VideoReport.reportEvent(eventId, view, buildElementParams);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/publishprogress/r$b", "Lcom/tencent/biz/qqcircle/widgets/a;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskStateChanged", "onProgressChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.biz.qqcircle.widgets.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            QLog.d("WinkPublish-Progress-QFSRectBoxPublishPart", 2, "onProgressChanged: taskId:" + taskInfo.getTaskId() + ", missionID:" + taskInfo.getMissionId() + ", state:" + taskInfo.getState() + ", progress:" + taskInfo.getUploadProgress() + ", exportProgress:" + taskInfo.getExportProgress());
            if (r.this.mType == 1) {
                if (taskInfo.isVideoComment()) {
                    QFSCommentHelper L = QFSCommentHelper.L();
                    long taskId = taskInfo.getTaskId();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(taskId);
                    if (!L.e0(sb5.toString())) {
                        return;
                    }
                } else {
                    return;
                }
            }
            r rVar = r.this;
            rVar.D9(rVar.mRootView);
            m mVar = r.this.mBoxProgressManager;
            if (mVar != null) {
                mVar.m(taskInfo);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            QLog.d("WinkPublish-Progress-QFSRectBoxPublishPart", 1, "onTaskStateChanged: taskId:" + taskInfo.getTaskId() + ", missionID:" + taskInfo.getMissionId() + ", state:" + taskInfo.getState() + ", progress:" + taskInfo.getUploadProgress() + ", exportProgress:" + taskInfo.getExportProgress());
            if (r.this.mType == 1) {
                if (taskInfo.isVideoComment()) {
                    QFSCommentHelper L = QFSCommentHelper.L();
                    long taskId = taskInfo.getTaskId();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(taskId);
                    if (!L.e0(sb5.toString())) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (taskInfo.getTransParams() != null) {
                Bundle transParams = taskInfo.getTransParams();
                Intrinsics.checkNotNull(transParams);
                if (TextUtils.equals(QQWinkConstants.WinkPublishTaskID.XSJ_COMMENT_PIC, transParams.getString(QQWinkConstants.WINK_PUBLISH_TASK_ID))) {
                    return;
                }
            }
            r rVar = r.this;
            rVar.D9(rVar.mRootView);
            m mVar = r.this.mBoxProgressManager;
            if (mVar != null) {
                mVar.o(taskInfo);
            }
        }
    }

    public r(int i3) {
        this.mType = i3;
    }

    private final void C9() {
        if (this.mPublishCallback == null) {
            this.mPublishCallback = new b();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.mPublishCallback, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9(View rootView) {
        FrameLayout frameLayout;
        View inflate;
        if (this.mViewStub != null) {
            return;
        }
        q qVar = q.f88294a;
        if (!qVar.c(this.mType)) {
            return;
        }
        qVar.b();
        this.mViewStub = (ViewStub) getPartRootView().findViewById(R.id.f5037258);
        View partRootView = getPartRootView();
        ViewGroup viewGroup = null;
        if (partRootView != null) {
            frameLayout = (FrameLayout) partRootView.findViewById(R.id.f5035256);
        } else {
            frameLayout = null;
        }
        this.mParentFrameLayout = frameLayout;
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = com.tencent.biz.qqcircle.immersive.utils.r.K(getContext()) + ViewUtils.dip2px(45.0f);
            frameLayout.setLayoutParams(layoutParams2);
        }
        ViewStub viewStub = this.mViewStub;
        if (viewStub == null) {
            return;
        }
        if (viewStub != null && (inflate = viewStub.inflate()) != null) {
            viewGroup = (ViewGroup) inflate.findViewById(R.id.f5181294);
        }
        this.mContainerView = viewGroup;
        this.mBoxProgressManager = new m(this.mContext, this, this.mContainerView);
    }

    private final void E9() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.mPublishCallback;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkPublish-Progress-QFSRectBoxPublishPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        QLog.d("WinkPublish-Progress-QFSRectBoxPublishPart", 1, "onInitView ");
        this.mRootView = rootView;
        this.mContext = rootView.getContext();
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        this.mActivity = activity;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        E9();
        m mVar = this.mBoxProgressManager;
        if (mVar != null) {
            mVar.i();
        }
    }
}

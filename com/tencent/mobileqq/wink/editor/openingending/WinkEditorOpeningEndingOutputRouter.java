package com.tencent.mobileqq.wink.editor.openingending;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import b93.OutputData;
import b93.a;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.boodo.CommonVideoViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.export.model.ExportCompletedParam;
import com.tencent.mobileqq.wink.export.model.ExportErrorParam;
import com.tencent.mobileqq.wink.export.model.ExportStartParam;
import com.tencent.mobileqq.wink.export.model.ExportWaitingParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.wink.view.ai;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u4e16\u754c\u53d1\u5e03\u5668\u7247\u5934\u7247\u5c3e\u8c03\u7528wink\u7684\u8f93\u51fa\u8def\u7531", path = WinkEditorOpeningEndingOutputRouter.ROUTE_PATH)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u001d\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010 \u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010!R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingOutputRouter;", "Lb93/a;", "Lx73/a;", "", CommonVideoViewController.PropName.SHOW_ERROR_TOAST, "", "show", "showLoadingDialog", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "onBack", "Lb93/b;", "outputData", "onOutput", "", "missionID", "Lcom/tencent/mobileqq/wink/export/model/ExportStartParam;", "exportStartParam", "onExportStart", "Lcom/tencent/mobileqq/wink/export/model/ExportingParam;", "exportingParam", "onExporting", "Lcom/tencent/mobileqq/wink/export/model/ExportCompletedParam;", "exportCompletedParam", "onCompleted", "Lcom/tencent/mobileqq/wink/export/model/ExportErrorParam;", "exportErrorParam", "onExportError", "Lcom/tencent/mobileqq/wink/export/model/ExportWaitingParam;", "exportWaitingParam", "onExportWaiting", "Ljava/lang/String;", "Lcom/tencent/mobileqq/wink/view/ai;", "loadingDialog", "Lcom/tencent/mobileqq/wink/view/ai;", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "activityWeakReference", "Lmqq/util/WeakReference;", "isOpeningVideo", "Z", "isFromClipping", "templateId", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "aigcData", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingOutputRouter implements b93.a, x73.a {

    @NotNull
    public static final String ROUTE_PATH = "/wink/output/opening_ending_template";

    @NotNull
    private static final String TAG = "WinkEditorOpeningEndingOutputRouter";

    @Nullable
    private WeakReference<Activity> activityWeakReference;

    @Nullable
    private OpeningEndingAigcData aigcData;
    private boolean isFromClipping;

    @Nullable
    private com.tencent.mobileqq.wink.view.ai loadingDialog;

    @Nullable
    private String missionID;
    private boolean isOpeningVideo = true;

    @NotNull
    private String templateId = "";

    private final void showErrorToast() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.ak
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingOutputRouter.showErrorToast$lambda$4(WinkEditorOpeningEndingOutputRouter.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorToast$lambda$4(WinkEditorOpeningEndingOutputRouter this$0) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<Activity> weakReference = this$0.activityWeakReference;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        QQToast.makeText(activity, R.string.ymq, 0).show();
    }

    private final void showLoadingDialog(final boolean show) {
        Activity activity;
        CompatPublicFragment fragment;
        final View view;
        WeakReference<Activity> weakReference = this.activityWeakReference;
        if (weakReference != null && (activity = weakReference.get()) != null && (fragment = ((CompatPublicActivity) activity).getFragment()) != null && (view = fragment.getView()) != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.aj
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorOpeningEndingOutputRouter.showLoadingDialog$lambda$5(show, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoadingDialog$lambda$5(boolean z16, WinkEditorOpeningEndingOutputRouter this$0, View fragmentView) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragmentView, "$fragmentView");
        if (z16) {
            WeakReference<Activity> weakReference = this$0.activityWeakReference;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            com.tencent.mobileqq.wink.view.ai a16 = new ai.b(activity).i(HardCodeUtil.qqStr(R.string.ymp)).b(true).f(fragmentView).a();
            this$0.loadingDialog = a16;
            if (a16 != null) {
                a16.setCancelable(false);
            }
            com.tencent.mobileqq.wink.view.ai aiVar = this$0.loadingDialog;
            if (aiVar != null) {
                aiVar.show();
                return;
            }
            return;
        }
        com.tencent.mobileqq.wink.view.ai aiVar2 = this$0.loadingDialog;
        if (aiVar2 != null) {
            aiVar2.dismiss();
        }
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // x73.a
    public void onCompleted(@Nullable String missionID, @Nullable ExportCompletedParam exportCompletedParam) {
        String str;
        Activity activity;
        LocalMediaInfo localMediaInfo;
        w53.b.f(TAG, "onCompleted: missionID=" + missionID);
        if (missionID != null && Intrinsics.areEqual(missionID, this.missionID)) {
            if (exportCompletedParam != null && (localMediaInfo = exportCompletedParam.f322835e) != null) {
                str = localMediaInfo.path;
            } else {
                str = null;
            }
            String str2 = str;
            w53.b.f(TAG, "onCompleted: exported video path: " + str2);
            if (str2 == null) {
                showLoadingDialog(false);
                showErrorToast();
                return;
            }
            showLoadingDialog(false);
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null && (activity = weakReference.get()) != null) {
                activity.finish();
            }
            SimpleEventBus.getInstance().dispatchEvent(new WinkEditorOpeningEndingUpdateEvent(str2, this.isOpeningVideo, missionID, this.templateId, this.isFromClipping, this.aigcData));
            return;
        }
        w53.b.f(TAG, "onCompleted: different missionID. " + this.missionID + ", " + missionID);
    }

    @Override // x73.a
    public void onExportError(@Nullable String missionID, @Nullable ExportErrorParam exportErrorParam) {
        w53.b.c(TAG, "onExportError: missionID=" + missionID);
        if (!Intrinsics.areEqual(missionID, this.missionID)) {
            w53.b.f(TAG, "onExportError: different missionID. " + this.missionID + ", " + missionID);
            return;
        }
        showErrorToast();
        showLoadingDialog(false);
    }

    @Override // x73.a
    public void onExportStart(@Nullable String missionID, @Nullable ExportStartParam exportStartParam) {
        w53.b.f(TAG, "onExportStart: missionID=" + missionID);
    }

    @Override // x73.a
    public void onExportWaiting(@Nullable String missionID, @Nullable ExportWaitingParam exportWaitingParam) {
        w53.b.f(TAG, "onExportWaiting: missionID=" + missionID);
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        Boolean bool;
        String str;
        boolean z16;
        Serializable serializable;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        boolean z17 = context instanceof Activity;
        if (!z17) {
            w53.b.c(TAG, "context is not activity");
            showErrorToast();
            return;
        }
        this.activityWeakReference = new WeakReference<>(context);
        this.missionID = outputData.getMissionId();
        Bundle bundle = outputData.getBundle();
        if (bundle != null && (string2 = bundle.getString(QQWinkConstants.OPENING_ENDING_TEMPLATE_ID, "")) != null) {
            this.templateId = string2;
        }
        Bundle bundle2 = outputData.getBundle();
        if (bundle2 != null && (string = bundle2.getString(QQWinkConstants.OPENING_ENDING_TEMPLATE_CATEGORY_ID, "")) != null) {
            this.isOpeningVideo = Intrinsics.areEqual(string, "opening");
        }
        Bundle bundle3 = outputData.getBundle();
        boolean z18 = false;
        if (bundle3 != null) {
            this.isFromClipping = bundle3.getBoolean(QQWinkConstants.OPENING_ENDING_IS_FROM_CLIPPING_PAGE, false);
        }
        Bundle bundle4 = outputData.getBundle();
        if (bundle4 != null && (serializable = bundle4.getSerializable(QQWinkConstants.OPENING_ENDING_AIGC_DATA)) != null) {
            this.aigcData = (OpeningEndingAigcData) serializable;
        }
        Bundle bundle5 = outputData.getBundle();
        Activity activity = null;
        if (bundle5 != null) {
            bool = Boolean.valueOf(bundle5.getBoolean(QQWinkConstants.IS_OPENING_ENDING_VIDEO_CHANGED, true));
        } else {
            bool = null;
        }
        Bundle bundle6 = outputData.getBundle();
        if (bundle6 != null) {
            str = bundle6.getString(QQWinkConstants.OPENING_ENDING_VIDEO_PATH);
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            if (str != null) {
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z18 = true;
                }
            }
            if (z18 && this.missionID != null) {
                if (z17) {
                    activity = (Activity) context;
                }
                if (activity != null) {
                    activity.finish();
                }
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                boolean z19 = this.isOpeningVideo;
                String str2 = this.missionID;
                Intrinsics.checkNotNull(str2);
                simpleEventBus.dispatchEvent(new WinkEditorOpeningEndingUpdateEvent(str, z19, str2, this.templateId, this.isFromClipping, this.aigcData));
                return;
            }
        }
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).addTask(new WinkExportTask(outputData.getMissionId(), "QCIRCLE", new WinkExportParams("QCIRCLE", outputData.getMissionId(), ""), false, 0), this);
        showLoadingDialog(true);
    }

    @Override // x73.a
    public void onExporting(@Nullable String missionID, @Nullable ExportingParam exportingParam) {
    }
}

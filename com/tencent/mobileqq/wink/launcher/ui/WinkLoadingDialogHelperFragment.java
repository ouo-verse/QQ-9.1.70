package com.tencent.mobileqq.wink.launcher.ui;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.event.WinkDialogHelpCloseEvent;
import com.tencent.mobileqq.wink.launcher.ui.WinkLoadingDialogHelperFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LoadingUtil;
import h83.TargetTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f\u0018\u00010\u001eH\u0016R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/launcher/ui/WinkLoadingDialogHelperFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/os/Bundle;", "b", "", "th", "", "needStatusTrans", "needImmersive", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "rh", "onResume", "onActivityCreated", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "overrideFinish", "beforeFinish", "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "p0", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", BdhLogUtil.LogTag.Tag_Conn, "Z", "taskHandleFlag", "Lh83/b;", "D", "Lh83/b;", "mTask", "Landroid/app/Dialog;", "E", "Landroid/app/Dialog;", "loadingDialog", "<init>", "()V", "G", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLoadingDialogHelperFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final HashMap<String, TargetTask> H = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    private boolean taskHandleFlag;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TargetTask mTask;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    @NotNull
    public Map<Integer, View> F = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/launcher/ui/WinkLoadingDialogHelperFragment$a;", "", "", "id", "Lh83/b;", "d", "task", "", "a", "f", "loadingTip", "e", "exitId", "b", "c", "KEY_LOADING_TIP", "Ljava/lang/String;", "KEY_TASK_ID", "TAG", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskPool", "Ljava/util/HashMap;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.launcher.ui.WinkLoadingDialogHelperFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized void a(@NotNull String id5, @NotNull TargetTask task) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(task, "task");
            WinkLoadingDialogHelperFragment.H.put(id5, task);
        }

        public final void b(@NotNull String exitId) {
            Intrinsics.checkNotNullParameter(exitId, "exitId");
            f(exitId);
            SimpleEventBus.getInstance().dispatchEvent(new WinkDialogHelpCloseEvent(exitId));
        }

        @NotNull
        public final String c() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            return uuid;
        }

        @Nullable
        public final synchronized TargetTask d(@NotNull String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
            return (TargetTask) WinkLoadingDialogHelperFragment.H.get(id5);
        }

        public final void e(@NotNull TargetTask task, @NotNull String loadingTip) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(loadingTip, "loadingTip");
            a(task.getTaskId(), task);
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("KEY_TASK_ID", task.getTaskId());
            isBlank = StringsKt__StringsJVMKt.isBlank(loadingTip);
            if (!isBlank) {
                intent.putExtra("KEY_LOADING_TIP", loadingTip);
            }
            BaseApplication context = BaseApplication.getContext();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, WinkLoadingDialogHelperFragment.class);
        }

        @Nullable
        public final synchronized TargetTask f(@NotNull String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
            return (TargetTask) WinkLoadingDialogHelperFragment.H.remove(id5);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(WinkLoadingDialogHelperFragment this$0, DialogInterface dialogInterface) {
        String taskId;
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mTask == null && (activity = this$0.getActivity()) != null) {
            activity.finish();
        }
        TargetTask targetTask = this$0.mTask;
        if (targetTask != null && (taskId = targetTask.getTaskId()) != null) {
            INSTANCE.b(taskId);
        }
    }

    private final void th(Bundle b16) {
        Runnable task;
        String string = b16.getString("KEY_TASK_ID");
        if (string == null) {
            string = "";
        }
        TargetTask d16 = INSTANCE.d(string);
        this.mTask = d16;
        QLog.i("WinkLoadingDialogHelperFragment", 1, "parseIntent taskId:" + string + ", task:" + d16);
        if (this.mTask == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.show();
        }
        TargetTask targetTask = this.mTask;
        if (targetTask != null && (task = targetTask.getTask()) != null) {
            task.run();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.F.clear();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(WinkDialogHelpCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        if (activity != null) {
            activity.setTheme(R.style.Theme.Translucent.NoTitleBar);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Window window;
        Window window2;
        View decorView;
        super.onActivityCreated(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        FragmentActivity activity = getActivity();
        if (activity != null && (window2 = activity.getWindow()) != null && (decorView = window2.getDecorView()) != null) {
            decorView.setBackgroundColor(0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (window = activity2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window window;
        Window window2;
        View decorView;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (container != null) {
            container.setBackgroundColor(0);
        }
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        rh();
        frameLayout.setBackgroundColor(0);
        FragmentActivity activity = getActivity();
        if (activity != null && (window2 = activity.getWindow()) != null && (decorView = window2.getDecorView()) != null) {
            decorView.setBackgroundColor(0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (window = activity2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isShowing() == true) goto L8;
     */
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFinish() {
        boolean z16;
        Dialog dialog;
        Dialog dialog2 = this.loadingDialog;
        if (dialog2 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 && (dialog = this.loadingDialog) != null) {
            dialog.dismiss();
        }
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent p06) {
        String str;
        String str2;
        Runnable task;
        Dialog dialog;
        if (p06 instanceof WinkDialogHelpCloseEvent) {
            WinkDialogHelpCloseEvent winkDialogHelpCloseEvent = (WinkDialogHelpCloseEvent) p06;
            String targetTaskId = winkDialogHelpCloseEvent.getTargetTaskId();
            TargetTask targetTask = this.mTask;
            String str3 = null;
            if (targetTask != null) {
                str = targetTask.getTaskId();
            } else {
                str = null;
            }
            TargetTask targetTask2 = this.mTask;
            if (targetTask2 != null) {
                str2 = targetTask2.getTaskId();
            } else {
                str2 = null;
            }
            boolean areEqual = Intrinsics.areEqual(str2, winkDialogHelpCloseEvent.getTargetTaskId());
            boolean z16 = true;
            QLog.i("WinkLoadingDialogHelperFragment", 1, "event targetTask:" + targetTaskId + ", self id:" + str + ", is equals:" + areEqual);
            String targetTaskId2 = winkDialogHelpCloseEvent.getTargetTaskId();
            TargetTask targetTask3 = this.mTask;
            if (targetTask3 != null) {
                str3 = targetTask3.getTaskId();
            }
            if (Intrinsics.areEqual(targetTaskId2, str3) || this.mTask == null) {
                Dialog dialog2 = this.loadingDialog;
                if (dialog2 == null || !dialog2.isShowing()) {
                    z16 = false;
                }
                if (z16 && (dialog = this.loadingDialog) != null) {
                    dialog.dismiss();
                }
                TargetTask targetTask4 = this.mTask;
                if (targetTask4 != null && (task = targetTask4.getTask()) != null) {
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(task);
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("WinkLoadingDialogHelperFragment", 4, "onResume taskHandleFlag:" + this.taskHandleFlag);
        if (!this.taskHandleFlag) {
            this.taskHandleFlag = true;
            Bundle arguments = getArguments();
            if (arguments != null) {
                th(arguments);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        return super.overrideFinish();
    }

    public final void rh() {
        String str;
        Resources resources;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("KEY_LOADING_TIP")) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (resources = activity.getResources()) != null) {
                str = resources.getString(com.tencent.mobileqq.R.string.f240967ql);
            } else {
                str = null;
            }
        }
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getActivity(), str, false);
        this.loadingDialog = showLoadingDialog;
        if (showLoadingDialog != null) {
            showLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: h83.c
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    WinkLoadingDialogHelperFragment.sh(WinkLoadingDialogHelperFragment.this, dialogInterface);
                }
            });
        }
    }
}

package com.tencent.mobileqq.zootopia.minors.util;

import android.R;
import android.app.Activity;
import android.content.Intent;
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
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.minors.util.LoadingDialogHelperFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import rc3.TargetTask;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u001f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e\u0018\u00010\u001dH\u0016R\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/minors/util/LoadingDialogHelperFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/os/Bundle;", "b", "", "sh", "", "needStatusTrans", "needImmersive", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "onActivityCreated", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "overrideFinish", "beforeFinish", "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "p0", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", BdhLogUtil.LogTag.Tag_Conn, "Z", "taskHandleFlag", "Lrc3/c;", "D", "Lrc3/c;", "mTask", "<init>", "()V", "E", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class LoadingDialogHelperFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, TargetTask> F = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    private boolean taskHandleFlag;

    /* renamed from: D, reason: from kotlin metadata */
    private TargetTask mTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/minors/util/LoadingDialogHelperFragment$a;", "", "", "id", "Lrc3/c;", "task", "", "a", "f", "", "delayDuration", "d", "exitId", "b", "c", "KEY_TASK_DELAY", "Ljava/lang/String;", "KEY_TASK_ID", "TAG", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskPool", "Ljava/util/HashMap;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.minors.util.LoadingDialogHelperFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized void a(String id5, TargetTask task) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(task, "task");
            LoadingDialogHelperFragment.F.put(id5, task);
        }

        public final void b(String exitId) {
            Intrinsics.checkNotNullParameter(exitId, "exitId");
            SimpleEventBus.getInstance().dispatchEvent(new MinorsDialogHelpCloseEvent(exitId));
        }

        public final String c() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            return uuid;
        }

        public final void d(TargetTask task, long delayDuration) {
            Intrinsics.checkNotNullParameter(task, "task");
            a(task.getTaskId(), task);
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("KEY_TASK_ID", task.getTaskId());
            if (delayDuration > 0) {
                intent.putExtra("KEY_TASK_DELAY", delayDuration);
            }
            BaseApplication context = BaseApplication.getContext();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, LoadingDialogHelperFragment.class);
        }

        public final synchronized TargetTask f(String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
            return (TargetTask) LoadingDialogHelperFragment.F.remove(id5);
        }

        Companion() {
        }

        public static /* synthetic */ void e(Companion companion, TargetTask targetTask, long j3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            companion.d(targetTask, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(LoadingDialogHelperFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void sh(Bundle b16) {
        Runnable task;
        Runnable task2;
        String string = b16.getString("KEY_TASK_ID");
        if (string == null) {
            string = "";
        }
        long j3 = b16.getLong("KEY_TASK_DELAY");
        TargetTask f16 = INSTANCE.f(string);
        this.mTask = f16;
        QLog.i("MinorsDialogHelperFragment_", 1, "parseIntent taskId:" + string + ", task:" + f16);
        TargetTask targetTask = this.mTask;
        if (targetTask == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (j3 > 0) {
            if (targetTask == null || (task2 = targetTask.getTask()) == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(task2, j3);
            return;
        }
        if (targetTask == null || (task = targetTask.getTask()) == null) {
            return;
        }
        task.run();
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
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(MinorsDialogHelpCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
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
    public void onActivityCreated(Bundle savedInstanceState) {
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
        if (activity2 == null || (window = activity2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Window window2;
        View decorView;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (container != null) {
            container.setBackgroundColor(0);
        }
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: rc3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadingDialogHelperFragment.rh(LoadingDialogHelperFragment.this, view);
            }
        });
        frameLayout.setBackgroundColor(0);
        FragmentActivity activity = getActivity();
        if (activity != null && (window2 = activity.getWindow()) != null && (decorView = window2.getDecorView()) != null) {
            decorView.setBackgroundColor(0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (window = activity2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent p06) {
        Runnable task;
        if (p06 instanceof MinorsDialogHelpCloseEvent) {
            MinorsDialogHelpCloseEvent minorsDialogHelpCloseEvent = (MinorsDialogHelpCloseEvent) p06;
            String targetTaskId = minorsDialogHelpCloseEvent.getTargetTaskId();
            TargetTask targetTask = this.mTask;
            String taskId = targetTask != null ? targetTask.getTaskId() : null;
            TargetTask targetTask2 = this.mTask;
            QLog.i("MinorsDialogHelperFragment_", 1, "event targetTask:" + targetTaskId + ", self id:" + taskId + ", is equals:" + Intrinsics.areEqual(targetTask2 != null ? targetTask2.getTaskId() : null, minorsDialogHelpCloseEvent.getTargetTaskId()));
            String targetTaskId2 = minorsDialogHelpCloseEvent.getTargetTaskId();
            TargetTask targetTask3 = this.mTask;
            if (Intrinsics.areEqual(targetTaskId2, targetTask3 != null ? targetTask3.getTaskId() : null) || this.mTask == null) {
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
        QLog.i("MinorsDialogHelperFragment_", 4, "onResume taskHandleFlag:" + this.taskHandleFlag);
        if (this.taskHandleFlag) {
            return;
        }
        this.taskHandleFlag = true;
        Bundle arguments = getArguments();
        if (arguments != null) {
            sh(arguments);
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
}

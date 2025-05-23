package dc4;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskDailyRewardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskItemData;
import com.tencent.sqshow.zootopia.taskcenter.header.DailyTitleBarHeaderView;
import com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListAdapter;
import com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListController;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001'B)\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Ldc4/g;", "Lcom/tencent/mobileqq/mvvm/b;", "Landroidx/recyclerview/widget/RecyclerView;", "panelRecyclerView", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController;", "taskListController", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter;", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/taskcenter/header/DailyTitleBarHeaderView;", "headerView", "", "k", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ldc4/h;", "f", "Ldc4/h;", "getViewModel", "()Ldc4/h;", "viewModel", "Ldb4/a;", tl.h.F, "Ldb4/a;", "getVmHandler", "()Ldb4/a;", "vmHandler", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroid/content/Context;Ldc4/h;Ldb4/a;)V", "i", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends com.tencent.mobileqq.mvvm.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final h viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final db4.a vmHandler;

    public g(LifecycleOwner owner, Context context, h hVar, db4.a vmHandler) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vmHandler, "vmHandler");
        this.owner = owner;
        this.context = context;
        this.viewModel = hVar;
        this.vmHandler = vmHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DailyTitleBarHeaderView dailyTitleBarHeaderView, ZootopiaTaskDailyRewardData zootopiaTaskDailyRewardData) {
        QLog.d("ZplanTaskSystemViewBinder", 1, "dailyRewardData:" + zootopiaTaskDailyRewardData);
        if (dailyTitleBarHeaderView != null) {
            dailyTitleBarHeaderView.s(zootopiaTaskDailyRewardData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DailyTitleBarHeaderView dailyTitleBarHeaderView, ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData) {
        QLog.d("ZplanTaskSystemViewBinder", 1, "blindBoxData:" + zootopiaTaskBlindBoxData);
        if (dailyTitleBarHeaderView != null) {
            dailyTitleBarHeaderView.o(zootopiaTaskBlindBoxData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(g this$0, TaskListAdapter adapter, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            QLog.d("ZplanTaskSystemViewBinder", 1, "taskList is empty");
            this$0.vmHandler.I4(3);
            return;
        }
        QLog.d("ZplanTaskSystemViewBinder", 1, "taskList:" + list);
        this$0.vmHandler.I4(4);
        adapter.k0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g this$0, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ZplanTaskSystemViewBinder", 1, "show errorMessage");
        this$0.vmHandler.I4(2);
    }

    public final void k(final DailyTitleBarHeaderView headerView) {
        MutableLiveData<ZootopiaTaskBlindBoxData> L1;
        MutableLiveData<ZootopiaTaskDailyRewardData> M1;
        h hVar = this.viewModel;
        if (hVar != null && (M1 = hVar.M1()) != null) {
            M1.observe(this.owner, new Observer() { // from class: dc4.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.l(DailyTitleBarHeaderView.this, (ZootopiaTaskDailyRewardData) obj);
                }
            });
        }
        h hVar2 = this.viewModel;
        if (hVar2 == null || (L1 = hVar2.L1()) == null) {
            return;
        }
        L1.observe(this.owner, new Observer() { // from class: dc4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.m(DailyTitleBarHeaderView.this, (ZootopiaTaskBlindBoxData) obj);
            }
        });
    }

    public final TaskListAdapter n(RecyclerView panelRecyclerView, TaskListController taskListController) {
        MutableLiveData<ErrorMessage> N1;
        MutableLiveData<List<ZootopiaTaskItemData>> O1;
        Intrinsics.checkNotNullParameter(taskListController, "taskListController");
        final TaskListAdapter taskListAdapter = new TaskListAdapter(this.context, taskListController);
        if (panelRecyclerView != null) {
            panelRecyclerView.setAdapter(taskListAdapter);
        }
        h hVar = this.viewModel;
        if (hVar != null && (O1 = hVar.O1()) != null) {
            O1.observe(this.owner, new Observer() { // from class: dc4.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.o(g.this, taskListAdapter, (List) obj);
                }
            });
        }
        h hVar2 = this.viewModel;
        if (hVar2 != null && (N1 = hVar2.N1()) != null) {
            N1.observe(this.owner, new Observer() { // from class: dc4.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.p(g.this, (ErrorMessage) obj);
                }
            });
        }
        return taskListAdapter;
    }
}

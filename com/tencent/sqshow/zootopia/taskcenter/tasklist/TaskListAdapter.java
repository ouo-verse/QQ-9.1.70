package com.tencent.sqshow.zootopia.taskcenter.tasklist;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskItemData;
import com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListController;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.widget.AlphaClickableTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter$ContentViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "", "Lcom/tencent/sqshow/zootopia/data/v;", "listData", "k0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController;", "taskListController", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "D", "Landroid/view/LayoutInflater;", "inflater", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController;)V", "E", "a", "ContentViewHolder", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TaskListAdapter extends RecyclerView.Adapter<ContentViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final TaskListController taskListController;

    /* renamed from: D, reason: from kotlin metadata */
    private LayoutInflater inflater;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter$ContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Lkotlin/Lazy;", "getTaskTitle", "()Landroid/widget/TextView;", "taskTitle", UserInfo.SEX_FEMALE, "getTaskDesc", "taskDesc", "Lcom/tencent/widget/AlphaClickableTextView;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/widget/AlphaClickableTextView;", "taskBtn", "Landroidx/recyclerview/widget/RecyclerView;", "H", "l", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class ContentViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final Lazy taskTitle;

        /* renamed from: F, reason: from kotlin metadata */
        private final Lazy taskDesc;

        /* renamed from: G, reason: from kotlin metadata */
        private final Lazy taskBtn;

        /* renamed from: H, reason: from kotlin metadata */
        private final Lazy recyclerView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentViewHolder(final View itemView) {
            super(itemView);
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            Lazy lazy4;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListAdapter$ContentViewHolder$taskTitle$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) itemView.findViewById(R.id.qq6);
                }
            });
            this.taskTitle = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListAdapter$ContentViewHolder$taskDesc$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) itemView.findViewById(R.id.qpu);
                }
            });
            this.taskDesc = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<AlphaClickableTextView>() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListAdapter$ContentViewHolder$taskBtn$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final AlphaClickableTextView invoke() {
                    return (AlphaClickableTextView) itemView.findViewById(R.id.qpm);
                }
            });
            this.taskBtn = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListAdapter$ContentViewHolder$recyclerView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final RecyclerView invoke() {
                    return (RecyclerView) itemView.findViewById(R.id.qhl);
                }
            });
            this.recyclerView = lazy4;
        }

        public final TextView getTaskDesc() {
            Object value = this.taskDesc.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-taskDesc>(...)");
            return (TextView) value;
        }

        public final TextView getTaskTitle() {
            Object value = this.taskTitle.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-taskTitle>(...)");
            return (TextView) value;
        }

        public final RecyclerView l() {
            Object value = this.recyclerView.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-recyclerView>(...)");
            return (RecyclerView) value;
        }

        public final AlphaClickableTextView m() {
            Object value = this.taskBtn.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-taskBtn>(...)");
            return (AlphaClickableTextView) value;
        }
    }

    public TaskListAdapter(Context context, TaskListController taskListController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskListController, "taskListController");
        this.context = context;
        this.taskListController = taskListController;
        this.inflater = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.taskListController.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.taskListController.g(holder.m(), position);
        TaskListController.TaskParams j3 = this.taskListController.j(position);
        TaskListController.TaskViewParams taskViewParams = j3.getTaskViewParams();
        if (taskViewParams != null) {
            holder.m().setBackgroundDrawable(taskViewParams.getBackgroundDrawable());
            aa.f(holder.m(), taskViewParams.getClickListener(), 1000L, "TaskListAdapter");
            holder.getTaskTitle().setAlpha(taskViewParams.getAlpha());
            holder.getTaskDesc().setAlpha(taskViewParams.getAlpha());
        }
        ZootopiaTaskItemData itemData = j3.getItemData();
        holder.l().setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        holder.l().setAdapter(new DailyTaskItemAdapter(this.context, itemData.k()));
        TextView taskTitle = holder.getTaskTitle();
        Resources resources = this.context.getResources();
        taskTitle.setText(resources != null ? resources.getString(R.string.xvz, itemData.getQuestTitle(), Integer.valueOf(itemData.getQuestCurrentCnt()), Integer.valueOf(itemData.getQuestAmount())) : null);
        holder.getTaskDesc().setText(itemData.getQuestDesc());
        holder.m().setText(itemData.getQuestJumpTitle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = this.inflater.inflate(R.layout.dgq, parent, false);
        TaskListController taskListController = this.taskListController;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        taskListController.h(view);
        return new ContentViewHolder(view);
    }

    public final void k0(List<ZootopiaTaskItemData> listData) {
        Intrinsics.checkNotNullParameter(listData, "listData");
        this.taskListController.q(listData);
        QLog.i("TaskListAdapter", 1, "updateDataList, listData:");
        Iterator<T> it = listData.iterator();
        while (it.hasNext()) {
            QLog.i("TaskListAdapter", 1, ((ZootopiaTaskItemData) it.next()).toString());
        }
        notifyDataSetChanged();
    }
}

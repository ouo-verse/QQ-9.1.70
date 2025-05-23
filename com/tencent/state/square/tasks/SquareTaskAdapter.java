package com.tencent.state.square.tasks;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ZTPSquareRewardService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareTaskServiceKt;
import com.tencent.state.square.api.ResultCallback;
import com.tencent.state.square.api.TaskItem;
import com.tencent.state.square.api.TaskRewardItem;
import com.tencent.state.square.api.TaskState;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.chatland.setting.ChatLandSettingDialog;
import com.tencent.state.square.databinding.ZtpSquareGiftItemBinding;
import com.tencent.state.square.databinding.ZtpSquareGiftTitleItemBinding;
import com.tencent.state.square.databinding.ZtpSquareTaskItemBinding;
import com.tencent.state.square.databinding.ZtpSquareTaskTitleItemBinding;
import com.tencent.state.square.event.UpdateBubbleSkinEvent;
import com.tencent.state.square.tasks.SquareTaskAdapter;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mt4.j;
import mt4.k;
import yt4.h;
import yt4.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006VWXYZ[B\u001d\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L\u0012\u0006\u0010R\u001a\u00020\n\u00a2\u0006\u0004\bT\u0010UJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016RT\u0010*\u001a4\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\b\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00101\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R6\u00109\u001a\b\u0012\u0004\u0012\u00020\u0004072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R6\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100?2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100?8\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R*\u0010C\u001a\u00020\n2\u0006\u00108\u001a\u00020\n8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010R\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\bR\u0010D\u001a\u0004\bS\u0010F\u00a8\u0006\\"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/state/square/api/TaskItem;", "task", "Lcom/tencent/state/square/tasks/SquareTaskAdapter$TaskViewHolder;", "viewHolder", "", "setTaskButtonState", "", "index", "handleFetchQuestReward", "", "questId", "fetchQuestReward", "Lyt4/i;", "reward", "handleRedeemReward", "dressSkin", "handleChangeSkin", "Lcom/tencent/state/square/api/TaskRewardItem;", "result", "showRewardDialog", "Lyt4/h;", "redeemReward", "showUnlockActionDialog", "position", "getItemViewType", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "onItemClickListener", "Lkotlin/jvm/functions/Function2;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function0;", "onHandleQuestFinished", "Lkotlin/jvm/functions/Function0;", "getOnHandleQuestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnHandleQuestFinished", "(Lkotlin/jvm/functions/Function0;)V", "", "value", Constants.Raft.TASKS, "Ljava/util/List;", "getTasks", "()Ljava/util/List;", "setTasks", "(Ljava/util/List;)V", "", "rewards", "getRewards", "setRewards", "point", "I", "getPoint", "()I", "setPoint", "(I)V", "Lcom/tencent/state/utils/FastClickUtils;", "fastClickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "context", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "source", "getSource", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "Companion", "GiftTitleViewHolder", "GiftViewHolder", "TaskTitleViewHolder", "TaskViewHolder", "ViewHolderType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareTaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "SquareTaskAdapter";
    private final WeakReference<Context> context;
    private final FastClickUtils fastClickUtils;
    private Function0<Unit> onHandleQuestFinished;
    private Function2<? super View, ? super Integer, Unit> onItemClickListener;
    private int point;
    private List<i> rewards;
    private final int source;
    private List<TaskItem> tasks;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskAdapter$GiftTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareGiftTitleItemBinding;", "(Lcom/tencent/state/square/databinding/ZtpSquareGiftTitleItemBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/ZtpSquareGiftTitleItemBinding;", "coinLabel", "Landroid/widget/TextView;", "getCoinLabel", "()Landroid/widget/TextView;", "taskTitle", "getTaskTitle", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    private static final class GiftTitleViewHolder extends RecyclerView.ViewHolder {
        private final ZtpSquareGiftTitleItemBinding binding;
        private final TextView coinLabel;
        private final TextView taskTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftTitleViewHolder(ZtpSquareGiftTitleItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            TextView textView = binding.giftTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.giftTitle");
            this.taskTitle = textView;
            TextView textView2 = binding.myCoin;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.myCoin");
            this.coinLabel = textView2;
        }

        public final ZtpSquareGiftTitleItemBinding getBinding() {
            return this.binding;
        }

        public final TextView getCoinLabel() {
            return this.coinLabel;
        }

        public final TextView getTaskTitle() {
            return this.taskTitle;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskAdapter$GiftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareGiftItemBinding;", "(Lcom/tencent/state/square/databinding/ZtpSquareGiftItemBinding;)V", "giftButton", "Landroid/widget/LinearLayout;", "getGiftButton", "()Landroid/widget/LinearLayout;", "giftButtonTitle", "Landroid/widget/TextView;", "getGiftButtonTitle", "()Landroid/widget/TextView;", "imageView", "Lcom/tencent/state/view/SquareImageView;", "getImageView", "()Lcom/tencent/state/view/SquareImageView;", "lockButton", "getLockButton", "nameLabel", "getNameLabel", "validTimeLabel", "getValidTimeLabel", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    private static final class GiftViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout giftButton;
        private final TextView giftButtonTitle;
        private final SquareImageView imageView;
        private final SquareImageView lockButton;
        private final TextView nameLabel;
        private final TextView validTimeLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftViewHolder(ZtpSquareGiftItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            SquareImageView squareImageView = binding.imageView;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.imageView");
            this.imageView = squareImageView;
            TextView textView = binding.nameLabel;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.nameLabel");
            this.nameLabel = textView;
            LinearLayout linearLayout = binding.giftButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.giftButton");
            this.giftButton = linearLayout;
            SquareImageView squareImageView2 = binding.lockIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.lockIcon");
            this.lockButton = squareImageView2;
            TextView textView2 = binding.giftButtonTitle;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.giftButtonTitle");
            this.giftButtonTitle = textView2;
            TextView textView3 = binding.validTimeLabel;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.validTimeLabel");
            this.validTimeLabel = textView3;
        }

        public final LinearLayout getGiftButton() {
            return this.giftButton;
        }

        public final TextView getGiftButtonTitle() {
            return this.giftButtonTitle;
        }

        public final SquareImageView getImageView() {
            return this.imageView;
        }

        public final SquareImageView getLockButton() {
            return this.lockButton;
        }

        public final TextView getNameLabel() {
            return this.nameLabel;
        }

        public final TextView getValidTimeLabel() {
            return this.validTimeLabel;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskAdapter$TaskTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareTaskTitleItemBinding;", "(Lcom/tencent/state/square/databinding/ZtpSquareTaskTitleItemBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/ZtpSquareTaskTitleItemBinding;", "taskDesc", "Landroid/widget/TextView;", "getTaskDesc", "()Landroid/widget/TextView;", "taskTitle", "getTaskTitle", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    private static final class TaskTitleViewHolder extends RecyclerView.ViewHolder {
        private final ZtpSquareTaskTitleItemBinding binding;
        private final TextView taskDesc;
        private final TextView taskTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskTitleViewHolder(ZtpSquareTaskTitleItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            TextView textView = binding.taskTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.taskTitle");
            this.taskTitle = textView;
            TextView textView2 = binding.descLabel;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.descLabel");
            this.taskDesc = textView2;
        }

        public final ZtpSquareTaskTitleItemBinding getBinding() {
            return this.binding;
        }

        public final TextView getTaskDesc() {
            return this.taskDesc;
        }

        public final TextView getTaskTitle() {
            return this.taskTitle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskAdapter$TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareTaskItemBinding;", "(Lcom/tencent/state/square/databinding/ZtpSquareTaskItemBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/ZtpSquareTaskItemBinding;", "coinLabel", "Landroid/widget/TextView;", "getCoinLabel", "()Landroid/widget/TextView;", "itemIcon", "Lcom/tencent/state/view/SquareImageView;", "getItemIcon", "()Lcom/tencent/state/view/SquareImageView;", "taskButton", "getTaskButton", "taskIcon", "getTaskIcon", "taskLabel", "getTaskLabel", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class TaskViewHolder extends RecyclerView.ViewHolder {
        private final ZtpSquareTaskItemBinding binding;
        private final TextView coinLabel;
        private final SquareImageView itemIcon;
        private final TextView taskButton;
        private final SquareImageView taskIcon;
        private final TextView taskLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskViewHolder(ZtpSquareTaskItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            SquareImageView squareImageView = binding.taskIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.taskIcon");
            this.taskIcon = squareImageView;
            SquareImageView squareImageView2 = binding.taskItemIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.taskItemIcon");
            this.itemIcon = squareImageView2;
            TextView textView = binding.taskNameLabel;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.taskNameLabel");
            this.taskLabel = textView;
            TextView textView2 = binding.coinLabel;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.coinLabel");
            this.coinLabel = textView2;
            TextView textView3 = binding.taskButton;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.taskButton");
            this.taskButton = textView3;
        }

        public final ZtpSquareTaskItemBinding getBinding() {
            return this.binding;
        }

        public final TextView getCoinLabel() {
            return this.coinLabel;
        }

        public final SquareImageView getItemIcon() {
            return this.itemIcon;
        }

        public final TextView getTaskButton() {
            return this.taskButton;
        }

        public final SquareImageView getTaskIcon() {
            return this.taskIcon;
        }

        public final TextView getTaskLabel() {
            return this.taskLabel;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskAdapter$ViewHolderType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "TASK_TITLE", "TASK_ITEM", "GIFT_TITLE", "GIFT_ITEM", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public enum ViewHolderType {
        TASK_TITLE(1),
        TASK_ITEM(2),
        GIFT_TITLE(3),
        GIFT_ITEM(4);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int type;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskAdapter$ViewHolderType$Companion;", "", "()V", "fromInt", "Lcom/tencent/state/square/tasks/SquareTaskAdapter$ViewHolderType;", "value", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public static final class Companion {
            Companion() {
            }

            public final ViewHolderType fromInt(int value) {
                for (ViewHolderType viewHolderType : ViewHolderType.values()) {
                    if (viewHolderType.getType() == value) {
                        return viewHolderType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        ViewHolderType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[ViewHolderType.values().length];
            $EnumSwitchMapping$0 = iArr;
            ViewHolderType viewHolderType = ViewHolderType.TASK_TITLE;
            iArr[viewHolderType.ordinal()] = 1;
            ViewHolderType viewHolderType2 = ViewHolderType.TASK_ITEM;
            iArr[viewHolderType2.ordinal()] = 2;
            ViewHolderType viewHolderType3 = ViewHolderType.GIFT_TITLE;
            iArr[viewHolderType3.ordinal()] = 3;
            int[] iArr2 = new int[ViewHolderType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[viewHolderType.ordinal()] = 1;
            iArr2[viewHolderType2.ordinal()] = 2;
            iArr2[viewHolderType3.ordinal()] = 3;
            iArr2[ViewHolderType.GIFT_ITEM.ordinal()] = 4;
            int[] iArr3 = new int[TaskState.values().length];
            $EnumSwitchMapping$2 = iArr3;
            TaskState taskState = TaskState.TO_COMPLETE;
            iArr3[taskState.ordinal()] = 1;
            TaskState taskState2 = TaskState.TO_RECEIVE;
            iArr3[taskState2.ordinal()] = 2;
            iArr3[TaskState.RECEIVED.ordinal()] = 3;
            int[] iArr4 = new int[TaskState.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[taskState.ordinal()] = 1;
            iArr4[taskState2.ordinal()] = 2;
        }
    }

    public SquareTaskAdapter(WeakReference<Context> context, int i3) {
        List<i> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.source = i3;
        this.tasks = new ArrayList();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.rewards = emptyList;
        this.fastClickUtils = new FastClickUtils(800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dressSkin(final i reward) {
        ZTPSquareRewardService.INSTANCE.dressSkin(reward.f451211b, reward.f451212c, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskAdapter$dressSkin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    SquareTaskAdapter.this.handleChangeSkin(reward);
                    SquareBaseKt.getSquareCommon().showToastSafely(Square.INSTANCE.getApplication(), "\u88c5\u626e\u6210\u529f", 2);
                }
            }
        });
    }

    private final void fetchQuestReward(long questId, final int index) {
        Square.INSTANCE.getConfig().getObtainInstanceHelper().getSquareTaskService().fetchQuestReward(questId, new ResultCallback<TaskRewardItem>() { // from class: com.tencent.state.square.tasks.SquareTaskAdapter$fetchQuestReward$1
            @Override // com.tencent.state.square.api.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareTaskAdapter", "fetchQuestReward failed:" + error + ", message:" + message, null, 4, null);
                SquareBaseKt.getSquareCommon().showToastSafely(SquareTaskAdapter.this.getContext().get(), "\u9886\u53d6\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 1);
            }

            @Override // com.tencent.state.square.api.ResultCallback
            public void onResultSuccess(TaskRewardItem result) {
                Object orNull;
                Intrinsics.checkNotNullParameter(result, "result");
                orNull = CollectionsKt___CollectionsKt.getOrNull(SquareTaskAdapter.this.getTasks(), index);
                TaskItem taskItem = (TaskItem) orNull;
                if (taskItem != null) {
                    taskItem.setCurrentCnt(result.getQuestCurrentCnt());
                    taskItem.setAmount(result.getTargetAmount());
                    taskItem.setState(TaskState.RECEIVED);
                    taskItem.setQuestJumpTitle("\u5df2\u9886\u53d6");
                    SquareTaskAdapter.this.getTasks().remove(index);
                    SquareTaskAdapter.this.getTasks().add(taskItem);
                    SquareTaskAdapter squareTaskAdapter = SquareTaskAdapter.this;
                    squareTaskAdapter.notifyItemMoved(index + 1, squareTaskAdapter.getTasks().size());
                    SquareTaskAdapter squareTaskAdapter2 = SquareTaskAdapter.this;
                    squareTaskAdapter2.notifyItemRangeChanged(1, squareTaskAdapter2.getTasks().size());
                    SquareTaskAdapter.this.showRewardDialog(taskItem, result);
                    Function0<Unit> onHandleQuestFinished = SquareTaskAdapter.this.getOnHandleQuestFinished();
                    if (onHandleQuestFinished != null) {
                        onHandleQuestFinished.invoke();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChangeSkin(final i reward) {
        if (reward.f451211b != 3) {
            return;
        }
        ZTPSquareRewardService.INSTANCE.getSkins(new int[]{3}, new Function1<mt4.i, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskAdapter$handleChangeSkin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(mt4.i iVar) {
                invoke2(iVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(mt4.i iVar) {
                k kVar;
                j[] jVarArr;
                k[] kVarArr;
                Object orNull;
                SquareBubbleInfo squareBubbleInfo = null;
                if (iVar == null || (kVarArr = iVar.f417587a) == null) {
                    kVar = null;
                } else {
                    orNull = ArraysKt___ArraysKt.getOrNull(kVarArr, 0);
                    kVar = (k) orNull;
                }
                if (kVar != null && (jVarArr = kVar.f417598c) != null) {
                    for (j it : jVarArr) {
                        if (i.this.f451212c == it.f417589a.f400550a) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            squareBubbleInfo = SquareBubbleSkinKt.parse(it).getBubbleInfo();
                        }
                    }
                }
                if (squareBubbleInfo != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new UpdateBubbleSkinEvent(Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin(), squareBubbleInfo));
                }
            }
        });
    }

    private final void handleFetchQuestReward(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.tasks, index);
        TaskItem taskItem = (TaskItem) orNull;
        if (taskItem != null) {
            fetchQuestReward(taskItem.getQuestId(), index);
        }
    }

    private final void handleRedeemReward(final i reward, final int index) {
        ZTPSquareRewardService.INSTANCE.redeemReward(reward.f451210a, new Function1<h, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskAdapter$handleRedeemReward$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(h hVar) {
                if (hVar == null) {
                    SquareBaseKt.getSquareCommon().showToastSafely(Square.INSTANCE.getApplication(), "\u79ef\u5206\u4e0d\u8db3", 0);
                    return;
                }
                reward.f451217h = true;
                SquareTaskAdapter.this.notifyItemChanged(index);
                SquareTaskAdapter.this.showUnlockActionDialog(reward, hVar);
                Function0<Unit> onHandleQuestFinished = SquareTaskAdapter.this.getOnHandleQuestFinished();
                if (onHandleQuestFinished != null) {
                    onHandleQuestFinished.invoke();
                }
            }
        });
    }

    private final void setTaskButtonState(TaskItem task, final TaskViewHolder viewHolder) {
        String str;
        final Map<String, Object> mutableMapOf;
        viewHolder.getTaskButton().setText(task.getQuestJumpTitle());
        int i3 = WhenMappings.$EnumSwitchMapping$2[task.getState().ordinal()];
        if (i3 == 1) {
            viewHolder.getTaskButton().setTextColor(-1);
            viewHolder.getTaskButton().setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.i7f));
            str = SquareReportConst.ElementId.ELEMENT_ID_FINISH_TASK;
        } else if (i3 != 2) {
            if (i3 == 3) {
                viewHolder.getTaskButton().setTextColor(-1);
                viewHolder.getTaskButton().setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.i7e));
            }
            str = "";
        } else {
            viewHolder.getTaskButton().setTextColor(-16777216);
            viewHolder.getTaskButton().setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.i7g));
            str = SquareReportConst.ElementId.ELEMENT_ID_CLAIM_REWARD;
        }
        String str2 = str;
        if (str2.length() > 0) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TASK_ID, String.valueOf(task.getQuestId())));
            SquareBaseKt.getSquareReporter().setElementInfo(viewHolder.getTaskButton(), str2, mutableMapOf, false, false);
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskAdapter$setTaskButtonState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SquareBaseKt.getSquareReporter().reportEvent("imp", SquareTaskAdapter.TaskViewHolder.this.getTaskButton(), mutableMapOf);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRewardDialog(TaskItem task, TaskRewardItem result) {
        Context it = this.context.get();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ChatLandSettingDialog chatLandSettingDialog = new ChatLandSettingDialog(it);
            chatLandSettingDialog.setRewardContent(task, result);
            chatLandSettingDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showUnlockActionDialog(final i reward, final h redeemReward) {
        final WeakReference weakReference = new WeakReference(this);
        Context it = this.context.get();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ChatLandSettingDialog chatLandSettingDialog = new ChatLandSettingDialog(it);
            chatLandSettingDialog.setUnlockActionContent(reward, redeemReward);
            chatLandSettingDialog.setOnConfirmFinished(new Function0<Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskAdapter$showUnlockActionDialog$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SquareTaskAdapter squareTaskAdapter = (SquareTaskAdapter) weakReference.get();
                    if (squareTaskAdapter != null) {
                        squareTaskAdapter.dressSkin(i.this);
                    }
                }
            });
            chatLandSettingDialog.show();
        }
    }

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tasks.size() + 2 + this.rewards.size();
    }

    public final Function0<Unit> getOnHandleQuestFinished() {
        return this.onHandleQuestFinished;
    }

    public final Function2<View, Integer, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final int getPoint() {
        return this.point;
    }

    public final List<i> getRewards() {
        return this.rewards;
    }

    public final int getSource() {
        return this.source;
    }

    public final List<TaskItem> getTasks() {
        return this.tasks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object orNull;
        String name;
        StringBuilder sb5;
        String str;
        Object orNull2;
        String sb6;
        Intrinsics.checkNotNullParameter(holder, "holder");
        int i3 = WhenMappings.$EnumSwitchMapping$1[ViewHolderType.INSTANCE.fromInt(holder.getItemViewType()).ordinal()];
        final Integer num = null;
        if (i3 == 2) {
            TaskViewHolder taskViewHolder = (TaskViewHolder) holder;
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.tasks, position - 1);
            TaskItem taskItem = (TaskItem) orNull;
            ViewExtensionsKt.setUri(taskViewHolder.getTaskIcon(), taskItem != null ? taskItem.getIcon() : null);
            ViewExtensionsKt.setUri(taskViewHolder.getItemIcon(), taskItem != null ? taskItem.getItemIcon() : null);
            taskViewHolder.getTaskButton().setTag(Integer.valueOf(position));
            taskViewHolder.getTaskButton().setOnClickListener(this);
            if (taskItem != null) {
                TextView taskLabel = taskViewHolder.getTaskLabel();
                if (taskItem.getAmount() > 0) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(taskItem.getName());
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append('(');
                    sb8.append(taskItem.getCurrentCnt());
                    sb8.append('/');
                    sb8.append(taskItem.getAmount());
                    sb8.append(')');
                    sb7.append(sb8.toString());
                    Unit unit = Unit.INSTANCE;
                    name = sb7.toString();
                    Intrinsics.checkNotNullExpressionValue(name, "StringBuilder().apply(builderAction).toString()");
                } else {
                    name = taskItem.getName();
                }
                taskLabel.setText(name);
                TextView coinLabel = taskViewHolder.getCoinLabel();
                if (taskItem.getItemId() == ISquareTaskServiceKt.REWARD_ITEM_ID_POINT) {
                    sb5 = new StringBuilder();
                    str = "\u79ef\u5206+";
                } else {
                    sb5 = new StringBuilder();
                    str = "\u94f6\u5e01+";
                }
                sb5.append(str);
                sb5.append(taskItem.getRewardItemCnt());
                coinLabel.setText(sb5.toString());
                setTaskButtonState(taskItem, taskViewHolder);
                return;
            }
            return;
        }
        if (i3 == 3) {
            TextView coinLabel2 = ((GiftTitleViewHolder) holder).getCoinLabel();
            Unit unit2 = Unit.INSTANCE;
            String str2 = "\u6211\u7684\u79ef\u5206\uff1a" + String.valueOf(this.point);
            Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder().apply(builderAction).toString()");
            coinLabel2.setText(str2);
            return;
        }
        if (i3 != 4) {
            return;
        }
        GiftViewHolder giftViewHolder = (GiftViewHolder) holder;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.rewards, (position - 2) - this.tasks.size());
        i iVar = (i) orNull2;
        ViewExtensionsKt.setUri(giftViewHolder.getImageView(), iVar != null ? iVar.f451213d : null);
        giftViewHolder.getNameLabel().setText(iVar != null ? iVar.f451214e : null);
        giftViewHolder.getValidTimeLabel().setText(iVar != null ? iVar.f451219j : null);
        TextView giftButtonTitle = giftViewHolder.getGiftButtonTitle();
        if (iVar != null && iVar.f451217h) {
            sb6 = "\u7acb\u5373\u8bbe\u7f6e";
        } else {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(iVar != null ? Integer.valueOf(iVar.f451215f) : null);
            sb9.append("\u79ef\u5206");
            sb6 = sb9.toString();
        }
        giftButtonTitle.setText(sb6);
        Drawable drawable = (iVar == null || iVar.f451217h) ? null : DrawableUtil.INSTANCE.getDrawable(R.drawable.ijn);
        if (iVar != null && iVar.f451217h) {
            Context context = this.context.get();
            if (context != null) {
                num = Integer.valueOf(com.tencent.state.square.common.ViewExtensionsKt.dip(context, 2));
            }
        } else {
            num = 0;
        }
        ViewExtensionsKt.updateLayoutParams(giftViewHolder.getGiftButtonTitle(), new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskAdapter$onBindViewHolder$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                Integer num2 = num;
                if (num2 != null) {
                    receiver.setMarginStart(num2.intValue());
                }
            }
        });
        giftViewHolder.getLockButton().setImageDrawable(drawable);
        ViewExtensionsKt.setVisibility(giftViewHolder.getLockButton(), drawable != null);
        giftViewHolder.getGiftButton().setTag(Integer.valueOf(position));
        giftViewHolder.getGiftButton().setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object orNull;
        Object orNull2;
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        Object tag = view.getTag();
        if (!(tag instanceof Integer)) {
            tag = null;
        }
        Integer num = (Integer) tag;
        if (num != null) {
            int intValue = num.intValue();
            int id5 = view.getId();
            if (id5 != R.id.qpn) {
                if (id5 == R.id.pwu) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(this.rewards, (intValue - 2) - this.tasks.size());
                    i iVar = (i) orNull;
                    if (iVar != null) {
                        if (iVar.f451217h) {
                            dressSkin(iVar);
                            return;
                        } else {
                            handleRedeemReward(iVar, intValue);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            int i3 = intValue - 1;
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.tasks, i3);
            TaskItem taskItem = (TaskItem) orNull2;
            if (taskItem != null) {
                int i16 = WhenMappings.$EnumSwitchMapping$3[taskItem.getState().ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        return;
                    }
                    handleFetchQuestReward(i3);
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TASK_ID, String.valueOf(taskItem.getQuestId())));
                    squareReporter.reportEvent("clck", view, mutableMapOf2);
                    return;
                }
                Function2<? super View, ? super Integer, Unit> function2 = this.onItemClickListener;
                if (function2 != null) {
                    function2.invoke(view, Integer.valueOf(i3));
                }
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TASK_ID, String.valueOf(taskItem.getQuestId())));
                squareReporter2.reportEvent("clck", view, mutableMapOf);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder taskTitleViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        int i3 = WhenMappings.$EnumSwitchMapping$0[ViewHolderType.INSTANCE.fromInt(viewType).ordinal()];
        if (i3 == 1) {
            ZtpSquareTaskTitleItemBinding inflate = ZtpSquareTaskTitleItemBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate, "ZtpSquareTaskTitleItemBi\u2026ter.from(parent.context))");
            RelativeLayout root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewExtensionsKt.dip((View) parent, 60)));
            taskTitleViewHolder = new TaskTitleViewHolder(inflate);
        } else if (i3 == 2) {
            ZtpSquareTaskItemBinding inflate2 = ZtpSquareTaskItemBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate2, "ZtpSquareTaskItemBinding\u2026ter.from(parent.context))");
            RelativeLayout root2 = inflate2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewExtensionsKt.dip((View) parent, 70)));
            taskTitleViewHolder = new TaskViewHolder(inflate2);
        } else {
            if (i3 != 3) {
                ZtpSquareGiftItemBinding inflate3 = ZtpSquareGiftItemBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(inflate3, "ZtpSquareGiftItemBinding\u2026ter.from(parent.context))");
                return new GiftViewHolder(inflate3);
            }
            ZtpSquareGiftTitleItemBinding inflate4 = ZtpSquareGiftTitleItemBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate4, "ZtpSquareGiftTitleItemBi\u2026ter.from(parent.context))");
            RelativeLayout root3 = inflate4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            root3.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewExtensionsKt.dip((View) parent, 40)));
            taskTitleViewHolder = new GiftTitleViewHolder(inflate4);
        }
        return taskTitleViewHolder;
    }

    public final void setOnHandleQuestFinished(Function0<Unit> function0) {
        this.onHandleQuestFinished = function0;
    }

    public final void setOnItemClickListener(Function2<? super View, ? super Integer, Unit> function2) {
        this.onItemClickListener = function2;
    }

    public final void setPoint(int i3) {
        this.point = i3;
        notifyItemChanged(this.tasks.size() + 1);
    }

    public final void setRewards(List<i> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.rewards = value;
        notifyDataSetChanged();
    }

    public final void setTasks(List<TaskItem> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.tasks = value;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return ViewHolderType.TASK_TITLE.getType();
        }
        int size = this.tasks.size();
        if (1 <= position && size >= position) {
            return ViewHolderType.TASK_ITEM.getType();
        }
        if (position == this.tasks.size() + 1) {
            return ViewHolderType.GIFT_TITLE.getType();
        }
        return ViewHolderType.GIFT_ITEM.getType();
    }
}

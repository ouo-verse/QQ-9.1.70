package com.tencent.state.square.tasks;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ZTPSquareRewardService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.ResultCallback;
import com.tencent.state.square.api.TaskItem;
import com.tencent.state.square.databinding.ZtpSquareTaskSheetBinding;
import com.tencent.state.square.event.OpenTaskEvent;
import com.tencent.state.square.tasks.SquareTaskAdapter;
import com.tencent.state.square.tasks.SquareTaskSheet;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import yt4.i;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/tasks/SquareTaskSheet;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "source", "", "(Landroid/content/Context;I)V", "adapter", "Lcom/tencent/state/square/tasks/SquareTaskAdapter;", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareTaskSheetBinding;", "getSource", "()I", "dismiss", "", "fetchRewardList", "fetchTaskInfo", "fetchUserRewardPoints", "handleCompleteTask", "index", "setContentView", "setupTaskListView", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareTaskSheet extends Dialog {
    private static final float MAX_HEIGHT_RATIO = 0.84f;
    private static final String TAG = "SquareTaskSheet";
    private static final String TASK_LOGO_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_task_logo.webp";
    private static final String TASK_QQ_SHOW_LOGO_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_task_qqshow_logo.webp";
    public static final int TASK_SOURCE_CHAT_LAND = 1;
    public static final int TASK_SOURCE_SQUARE = 0;
    private static final String TASK_STAR_ICON_URL = "https://cdn.meta.qq.com/chat_land/ztp_square_task_star_icon.webp";
    private final SquareTaskAdapter adapter;
    private ZtpSquareTaskSheetBinding binding;
    private final int source;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SquareTaskAdapter.ViewHolderType.values().length];
            $EnumSwitchMapping$0 = iArr;
            SquareTaskAdapter.ViewHolderType viewHolderType = SquareTaskAdapter.ViewHolderType.GIFT_ITEM;
            iArr[viewHolderType.ordinal()] = 1;
            int[] iArr2 = new int[SquareTaskAdapter.ViewHolderType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[viewHolderType.ordinal()] = 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareTaskSheet(Context context, int i3) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        this.source = i3;
        ZtpSquareTaskSheetBinding inflate = ZtpSquareTaskSheetBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "ZtpSquareTaskSheetBinding.inflate(layoutInflater)");
        this.binding = inflate;
        this.adapter = new SquareTaskAdapter(new WeakReference(context), i3);
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "this.context");
        commonUtils.setStandardFont(context2);
        setContentView(this.binding.getMContainer());
        setContentView();
        setupTaskListView();
        fetchTaskInfo();
        fetchRewardList();
        fetchUserRewardPoints();
    }

    private final void fetchRewardList() {
        ZTPSquareRewardService.INSTANCE.getRewardList(new Function1<ArrayList<i>, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$fetchRewardList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<i> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<i> arrayList) {
                SquareTaskAdapter squareTaskAdapter;
                if (arrayList != null) {
                    squareTaskAdapter = SquareTaskSheet.this.adapter;
                    squareTaskAdapter.setRewards(arrayList);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void fetchTaskInfo() {
        Square.INSTANCE.getConfig().getObtainInstanceHelper().getSquareTaskService().loadLeYuanTask(new ResultCallback<List<? extends TaskItem>>() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$fetchTaskInfo$1
            @Override // com.tencent.state.square.api.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareTaskSheet", "fetch task info failed:" + error + ", message:" + message, null, 4, null);
            }

            @Override // com.tencent.state.square.api.ResultCallback
            public /* bridge */ /* synthetic */ void onResultSuccess(List<? extends TaskItem> list) {
                onResultSuccess2((List<TaskItem>) list);
            }

            /* renamed from: onResultSuccess, reason: avoid collision after fix types in other method */
            public void onResultSuccess2(List<TaskItem> result) {
                SquareTaskAdapter squareTaskAdapter;
                List<TaskItem> mutableList;
                Intrinsics.checkNotNullParameter(result, "result");
                squareTaskAdapter = SquareTaskSheet.this.adapter;
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) result);
                squareTaskAdapter.setTasks(mutableList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchUserRewardPoints() {
        ZTPSquareRewardService.INSTANCE.getUserRewardPoints(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$fetchUserRewardPoints$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                SquareTaskAdapter squareTaskAdapter;
                if (num != null) {
                    int intValue = num.intValue();
                    squareTaskAdapter = SquareTaskSheet.this.adapter;
                    squareTaskAdapter.setPoint(intValue);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCompleteTask(int index) {
        Object orNull;
        boolean contains$default;
        boolean contains$default2;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.adapter.getTasks(), index);
        TaskItem taskItem = (TaskItem) orNull;
        if (taskItem != null) {
            int i3 = 1;
            if (!(taskItem.getScheme().length() > 0)) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) taskItem.getName(), (CharSequence) "\u5730\u5757", false, 2, (Object) null);
                if (contains$default) {
                    i3 = 2;
                } else {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) taskItem.getName(), (CharSequence) "\u5206\u4eab", false, 2, (Object) null);
                    if (!contains$default2) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    SimpleEventBus.getInstance().dispatchEvent(new OpenTaskEvent(i3));
                }
            } else {
                IRouter squareRouter = SquareBaseKt.getSquareRouter();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                squareRouter.routeLink(context, new EntranceLink(taskItem.getScheme(), 2));
            }
        }
        dismiss();
    }

    private final void setContentView() {
        Map<String, Object> mutableMapOf;
        this.binding.closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setContentView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareTaskSheet.this.dismiss();
            }
        });
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null), (int) (SquareUtil.getScreenHeight$default(r3, 0.0f, 1, null) * MAX_HEIGHT_RATIO));
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.f243260b);
        }
        SquareImageView squareImageView = this.binding.taskLogo;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.taskLogo");
        ViewExtensionsKt.setUri(squareImageView, TASK_LOGO_URL);
        SquareImageView squareImageView2 = this.binding.taskStarLogo;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.taskStarLogo");
        ViewExtensionsKt.setUri(squareImageView2, TASK_STAR_ICON_URL);
        SquareImageView squareImageView3 = this.binding.taskQqShowLogo;
        Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.taskQqShowLogo");
        ViewExtensionsKt.setUri(squareImageView3, TASK_QQ_SHOW_LOGO_URL);
        TextView textView = this.binding.taskTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.taskTitle");
        textView.setAlpha(0.0f);
        final WeakReference weakReference = new WeakReference(this.binding);
        this.binding.taskView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setContentView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(final RecyclerView recyclerView, int dx5, int dy5) {
                RecyclerView recyclerView2;
                View view;
                View view2;
                SquareImageView squareImageView4;
                SquareImageView squareImageView5;
                SquareImageView squareImageView6;
                TextView textView2;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx5, dy5);
                final int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                float min = Math.min((computeVerticalScrollOffset * 1.0f) / ViewExtensionsKt.dip((View) recyclerView, 120), 1.0f);
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding = (ZtpSquareTaskSheetBinding) weakReference.get();
                if (ztpSquareTaskSheetBinding != null && (textView2 = ztpSquareTaskSheetBinding.taskTitle) != null) {
                    textView2.setAlpha(min);
                }
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding2 = (ZtpSquareTaskSheetBinding) weakReference.get();
                if (ztpSquareTaskSheetBinding2 != null && (squareImageView6 = ztpSquareTaskSheetBinding2.taskLogo) != null) {
                    squareImageView6.setAlpha(1.0f - min);
                }
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding3 = (ZtpSquareTaskSheetBinding) weakReference.get();
                if (ztpSquareTaskSheetBinding3 != null && (squareImageView5 = ztpSquareTaskSheetBinding3.taskStarLogo) != null) {
                    squareImageView5.setAlpha(1.0f - min);
                }
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding4 = (ZtpSquareTaskSheetBinding) weakReference.get();
                if (ztpSquareTaskSheetBinding4 != null && (squareImageView4 = ztpSquareTaskSheetBinding4.taskQqShowLogo) != null) {
                    squareImageView4.setAlpha(1.0f - min);
                }
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding5 = (ZtpSquareTaskSheetBinding) weakReference.get();
                if (ztpSquareTaskSheetBinding5 != null && (view2 = ztpSquareTaskSheetBinding5.topLeftBg) != null) {
                    view2.setAlpha(1.0f - min);
                }
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding6 = (ZtpSquareTaskSheetBinding) weakReference.get();
                if (ztpSquareTaskSheetBinding6 != null && (view = ztpSquareTaskSheetBinding6.topRightBg) != null) {
                    view.setAlpha(1.0f - min);
                }
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding7 = (ZtpSquareTaskSheetBinding) weakReference.get();
                if (ztpSquareTaskSheetBinding7 == null || (recyclerView2 = ztpSquareTaskSheetBinding7.taskView) == null) {
                    return;
                }
                ViewExtensionsKt.updateLayoutParams(recyclerView2, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setContentView$2$onScrolled$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(RelativeLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.topMargin = Math.min(0, (-ViewExtensionsKt.dip((View) RecyclerView.this, 25)) + computeVerticalScrollOffset);
                    }
                });
            }
        });
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        RelativeLayout mContainer2 = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, Integer.valueOf(this.source)));
        squareReporter.setPageInfo(mContainer, mContainer2, SquareReportConst.PageId.PAGE_ID_SQUARE_TASK, mutableMapOf);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setContentView$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ZtpSquareTaskSheetBinding ztpSquareTaskSheetBinding;
                Map<String, Object> mutableMapOf2;
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                ztpSquareTaskSheetBinding = SquareTaskSheet.this.binding;
                RelativeLayout mContainer3 = ztpSquareTaskSheetBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer3, "binding.root");
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, Integer.valueOf(SquareTaskSheet.this.getSource())));
                squareReporter2.reportEvent("dt_pgin", mContainer3, mutableMapOf2);
            }
        });
    }

    private final void setupTaskListView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setupTaskListView$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                SquareTaskAdapter squareTaskAdapter;
                SquareTaskAdapter.ViewHolderType.Companion companion = SquareTaskAdapter.ViewHolderType.INSTANCE;
                squareTaskAdapter = SquareTaskSheet.this.adapter;
                return SquareTaskSheet.WhenMappings.$EnumSwitchMapping$0[companion.fromInt(squareTaskAdapter.getItemViewType(position)).ordinal()] != 1 ? 3 : 1;
            }
        });
        RecyclerView recyclerView = this.binding.taskView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.taskView");
        recyclerView.setLayoutManager(gridLayoutManager);
        this.binding.taskView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setupTaskListView$2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                SquareTaskAdapter squareTaskAdapter;
                SquareTaskAdapter squareTaskAdapter2;
                SquareTaskAdapter squareTaskAdapter3;
                int size;
                int dip;
                SquareTaskAdapter squareTaskAdapter4;
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                SquareTaskAdapter.ViewHolderType.Companion companion = SquareTaskAdapter.ViewHolderType.INSTANCE;
                RecyclerView.Adapter adapter = parent.getAdapter();
                if (SquareTaskSheet.WhenMappings.$EnumSwitchMapping$1[companion.fromInt(adapter != null ? adapter.getItemViewType(childAdapterPosition) : 0).ordinal()] == 1) {
                    squareTaskAdapter = SquareTaskSheet.this.adapter;
                    int size2 = (childAdapterPosition - 2) - squareTaskAdapter.getTasks().size();
                    int i3 = size2 % 3;
                    if (i3 == 0) {
                        outRect.left = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 15);
                        outRect.right = 0;
                    } else if (i3 == 1) {
                        outRect.left = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 10);
                        outRect.right = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 10);
                    } else if (i3 == 2) {
                        outRect.left = 0;
                        outRect.right = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 15);
                    }
                    outRect.top = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 5);
                    squareTaskAdapter2 = SquareTaskSheet.this.adapter;
                    if (squareTaskAdapter2.getRewards().size() % 3 == 0) {
                        squareTaskAdapter4 = SquareTaskSheet.this.adapter;
                        size = squareTaskAdapter4.getRewards().size() / 3;
                    } else {
                        squareTaskAdapter3 = SquareTaskSheet.this.adapter;
                        size = (squareTaskAdapter3.getRewards().size() / 3) + 1;
                    }
                    int i16 = size2 + 1;
                    int i17 = i16 % 3;
                    int i18 = i16 / 3;
                    if (i17 != 0) {
                        i18++;
                    }
                    if (i18 == size) {
                        dip = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 40);
                    } else {
                        dip = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 5);
                    }
                    outRect.bottom = dip;
                    return;
                }
                outRect.left = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 15);
                outRect.right = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 15);
                outRect.top = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 5);
                outRect.bottom = com.tencent.state.square.common.ViewExtensionsKt.dip(parent.getContext(), 5);
            }
        });
        RecyclerView recyclerView2 = this.binding.taskView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.taskView");
        recyclerView2.setAdapter(this.adapter);
        final WeakReference weakReference = new WeakReference(this);
        this.adapter.setOnItemClickListener(new Function2<View, Integer, Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setupTaskListView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i3) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareTaskSheet squareTaskSheet = (SquareTaskSheet) weakReference.get();
                if (squareTaskSheet != null) {
                    squareTaskSheet.handleCompleteTask(i3);
                }
            }
        });
        this.adapter.setOnHandleQuestFinished(new Function0<Unit>() { // from class: com.tencent.state.square.tasks.SquareTaskSheet$setupTaskListView$4
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
                SquareTaskSheet squareTaskSheet = (SquareTaskSheet) weakReference.get();
                if (squareTaskSheet != null) {
                    squareTaskSheet.fetchUserRewardPoints();
                }
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Map<String, Object> mutableMapOf;
        super.dismiss();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, Integer.valueOf(this.source)));
        squareReporter.reportEvent("dt_pgout", mContainer, mutableMapOf);
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        commonUtils.unSetStandardFont(context);
    }

    public final int getSource() {
        return this.source;
    }
}

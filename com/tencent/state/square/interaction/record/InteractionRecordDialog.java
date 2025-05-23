package com.tencent.state.square.interaction.record;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.state.event.ChatCheckUinInSquare;
import com.tencent.state.event.DownSlideCloseListener;
import com.tencent.state.event.LoadMoreListener;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareInteractionRecordBinding;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.interaction.InteractionRecordInfo;
import com.tencent.state.view.SquareImageView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0003J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0 H\u0002J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0#2\u0006\u0010&\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "onActionClick", "Lkotlin/Function2;", "", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "adapter", "Lcom/tencent/state/square/interaction/record/InteractionRecordAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareInteractionRecordBinding;", "currentCursor", "", "isLoading", "reporter", "Lcom/tencent/state/square/IReporter;", "actionClick", "uin", "isInSquare", "hideQuestionFloat", "initData", "initListener", "initView", "initWindow", FeedManager.LOAD_MORE, "transformData", "data", "Lcom/tencent/state/square/interaction/InteractionRecordInfo;", "onDone", "Lkotlin/Function1;", "Lcom/tencent/state/square/interaction/record/InteractionRecordData;", "transformList", "", "", "list", "isFinish", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionRecordDialog extends Dialog {
    private static final String TAG = "InteractionRecordDialog";
    private final InteractionRecordAdapter adapter;
    private final VasSquareInteractionRecordBinding binding;
    private String currentCursor;
    private boolean isLoading;
    private final Function2<Long, Boolean, Unit> onActionClick;
    private final IReporter reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InteractionRecordDialog(Context context, Function2<? super Long, ? super Boolean, Unit> onActionClick) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onActionClick, "onActionClick");
        this.onActionClick = onActionClick;
        VasSquareInteractionRecordBinding inflate = VasSquareInteractionRecordBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareInteractionReco\u2026utInflater.from(context))");
        this.binding = inflate;
        this.adapter = new InteractionRecordAdapter();
        this.currentCursor = "";
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        setContentView(inflate.getMRv());
        initWindow();
        initListener();
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void actionClick(long uin, boolean isInSquare) {
        this.onActionClick.invoke(Long.valueOf(uin), Boolean.valueOf(isInSquare));
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideQuestionFloat() {
        LinearLayout linearLayout = this.binding.vasSquareInteractionRecordQuestionFloat;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.vasSquareInteractionRecordQuestionFloat");
        linearLayout.setVisibility(8);
    }

    private final void initData() {
        RecyclerView recyclerView = this.binding.vasSquareInteractionRecordList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareInteractionRecordList");
        recyclerView.setAdapter(this.adapter);
        loadMore();
    }

    private final void initListener() {
        SquareImageView squareImageView = this.binding.vasSquareInteractionRecordDragIcon;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LinearLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        squareImageView.setOnTouchListener(new DownSlideCloseListener(context, mRv, new Function0<Unit>() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$initListener$1
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
                InteractionRecordDialog.this.dismiss();
            }
        }));
        this.binding.vasSquareInteractionRecordTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$initListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareInteractionRecordBinding vasSquareInteractionRecordBinding;
                VasSquareInteractionRecordBinding vasSquareInteractionRecordBinding2;
                vasSquareInteractionRecordBinding = InteractionRecordDialog.this.binding;
                LinearLayout linearLayout = vasSquareInteractionRecordBinding.vasSquareInteractionRecordQuestionFloat;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.vasSquareInteractionRecordQuestionFloat");
                if (linearLayout.getVisibility() == 0) {
                    InteractionRecordDialog.this.hideQuestionFloat();
                    return;
                }
                vasSquareInteractionRecordBinding2 = InteractionRecordDialog.this.binding;
                LinearLayout linearLayout2 = vasSquareInteractionRecordBinding2.vasSquareInteractionRecordQuestionFloat;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.vasSquareInteractionRecordQuestionFloat");
                linearLayout2.setVisibility(0);
            }
        });
        this.binding.vasSquareInteractionRecordQuestionFloat.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$initListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InteractionRecordDialog.this.hideQuestionFloat();
            }
        });
        this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$initListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InteractionRecordDialog.this.hideQuestionFloat();
            }
        });
    }

    private final void initView() {
        RecyclerView recyclerView = this.binding.vasSquareInteractionRecordList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareInteractionRecordList");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.binding.vasSquareInteractionRecordList.addOnScrollListener(new LoadMoreListener(0, new Function0<Unit>() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$initView$1
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
                InteractionRecordDialog.this.loadMore();
            }
        }, 1, null));
        IReporter iReporter = this.reporter;
        LinearLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        iReporter.setPageInfo(this, mRv, SquareReportConst.PageId.PAGE_ID_HOST_DETAIL, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore() {
        if (Intrinsics.areEqual(this.currentCursor, "0") || this.isLoading) {
            return;
        }
        this.isLoading = true;
        InteractionManager.INSTANCE.getInteractionRecord(this.currentCursor, new InteractionRecordDialog$loadMore$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void transformData(final InteractionRecordInfo data, final Function1<? super InteractionRecordData, Unit> onDone) {
        SimpleEventBus.getInstance().dispatchEvent(new ChatCheckUinInSquare(String.valueOf(data.getUin()), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$transformData$1
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

            public final void invoke(final boolean z16) {
                String string;
                SquareBaseKt.getSquareLog().i("InteractionRecordDialog", String.valueOf(z16));
                Function1 function1 = onDone;
                InteractionRecordInfo interactionRecordInfo = data;
                if (z16) {
                    string = InteractionRecordDialog.this.getContext().getString(R.string.xff);
                } else {
                    string = InteractionRecordDialog.this.getContext().getString(R.string.xfd);
                }
                String str = string;
                Intrinsics.checkNotNullExpressionValue(str, "if (isInSquare) {\n      \u2026dd)\n                    }");
                function1.invoke(new InteractionRecordData(interactionRecordInfo, str, z16 ? R.drawable.ia8 : R.drawable.ia7, new Function0<Unit>() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$transformData$1.1
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
                        InteractionRecordDialog$transformData$1 interactionRecordDialog$transformData$1 = InteractionRecordDialog$transformData$1.this;
                        InteractionRecordDialog.this.actionClick(data.getUin(), z16);
                    }
                }, z16));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Object> transformList(List<InteractionRecordData> list, boolean isFinish) {
        InteractionRecordData interactionRecordData;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            InteractionRecordData interactionRecordData2 = (InteractionRecordData) obj;
            if (i3 == 0) {
                Object lastData = this.adapter.lastData();
                if (!(lastData instanceof InteractionRecordData)) {
                    lastData = null;
                }
                interactionRecordData = (InteractionRecordData) lastData;
            } else {
                interactionRecordData = list.get(i3 - 1);
            }
            if (interactionRecordData == null || interactionRecordData.getStatus() != interactionRecordData2.getStatus() || interactionRecordData.getRichStatus() != interactionRecordData2.getRichStatus()) {
                arrayList.add(new InteractionRecordTitleData(interactionRecordData2.getStatusIcon(), interactionRecordData2.getStatusTitle()));
            }
            arrayList.add(interactionRecordData2);
            i3 = i16;
        }
        if (isFinish) {
            String string = getContext().getString(R.string.xfe);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026teraction_record_end_tip)");
            arrayList.add(new InteractionRecordTipData(string));
        }
        return arrayList;
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            window2.setLayout(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null) - ViewExtensionsKt.dip(getContext(), 100.0f));
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.f243260b);
        }
    }
}

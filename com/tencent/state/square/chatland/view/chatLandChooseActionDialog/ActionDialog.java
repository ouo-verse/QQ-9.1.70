package com.tencent.state.square.chatland.view.chatLandChooseActionDialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareChatLandChooseActionDialogBinding;
import com.tencent.state.template.data.ActionType;
import com.tencent.state.template.data.InteractionMotionAction;
import com.tencent.state.template.data.InteractionMotionInfo;
import com.tencent.state.view.SquareImageView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBt\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012B\u0010\u0004\u001a>\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0005\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000RJ\u0010\u0004\u001a>\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/chatland/view/chatLandChooseActionDialog/ActionDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "getMotionListCallback", "Lkotlin/Function2;", "Lcom/tencent/state/template/data/ActionType;", "Lkotlin/ParameterName;", "name", "actionType", "Lcom/tencent/state/service/ResultCallback;", "", "Lcom/tencent/state/template/data/InteractionMotionInfo;", "callback", "", "chooseCallBack", "Lkotlin/Function1;", "Lcom/tencent/state/template/data/InteractionMotionAction;", "interMotion", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/tencent/state/square/chatland/view/chatLandChooseActionDialog/ListAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandChooseActionDialogBinding;", "initData", "initListener", "initReport", "initView", "initWindow", "showImp", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ActionDialog extends Dialog {
    private static final String TAG = "ChatLandChooseActionDialog";
    private final ListAdapter adapter;
    private final VasSquareChatLandChooseActionDialogBinding binding;
    private final Function1<InteractionMotionAction, Unit> chooseCallBack;
    private final Function2<ActionType, ResultCallback<List<InteractionMotionInfo>>, Unit> getMotionListCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ActionDialog(Context context, Function2<? super ActionType, ? super ResultCallback<List<InteractionMotionInfo>>, Unit> getMotionListCallback, Function1<? super InteractionMotionAction, Unit> chooseCallBack) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(getMotionListCallback, "getMotionListCallback");
        Intrinsics.checkNotNullParameter(chooseCallBack, "chooseCallBack");
        this.getMotionListCallback = getMotionListCallback;
        this.chooseCallBack = chooseCallBack;
        VasSquareChatLandChooseActionDialogBinding inflate = VasSquareChatLandChooseActionDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandChooseA\u2026utInflater.from(context))");
        this.binding = inflate;
        this.adapter = new ListAdapter();
        setContentView(inflate.getMRv());
        initWindow();
        initView();
        initData();
        initListener();
        initReport();
    }

    private final void initData() {
        this.getMotionListCallback.invoke(ActionType.ACTION_MULTI, new ActionDialog$initData$1(this));
    }

    private final void initListener() {
        this.binding.closeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.chatLandChooseActionDialog.ActionDialog$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
                ActionDialog.this.dismiss();
            }
        });
    }

    private final void initView() {
        RecyclerView recyclerView = this.binding.vasSquareChooseActionList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareChooseActionList");
        recyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView2 = this.binding.vasSquareChooseActionList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.vasSquareChooseActionList");
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 4, 1, false));
        this.binding.vasSquareChooseActionList.addItemDecoration(new ItemGridDivider());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showImp() {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout = this.binding.container;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.container");
        squareReporter.reportEvent("imp", frameLayout, new LinkedHashMap());
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView = this.binding.closeBtn;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.closeBtn");
        squareReporter2.reportEvent("imp", squareImageView, new LinkedHashMap());
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null), ViewExtensionsKt.dip(window.getContext(), 379));
            window.setWindowAnimations(R.style.f243260b);
        }
    }

    private final void initReport() {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        LinearLayout mRv2 = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv2, "binding.root");
        squareReporter.setPageInfo(mRv, mRv2, SquareReportConst.PageId.INSTANCE.checkNearby(), new LinkedHashMap());
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout = this.binding.container;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.container");
        squareReporter2.setElementInfo(frameLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_ZPLAN_FIT_POP, new LinkedHashMap(), false, false);
        IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView = this.binding.closeBtn;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.closeBtn");
        squareReporter3.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_ZPLAN_FIT_POP_CLOSE, new LinkedHashMap(), false, false);
    }
}

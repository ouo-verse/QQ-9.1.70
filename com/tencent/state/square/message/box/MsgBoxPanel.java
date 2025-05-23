package com.tencent.state.square.message.box;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareMsgBoxPanelBinding;
import com.tencent.state.view.FloatPanelDragListener;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxPanel;", "Landroid/app/Dialog;", "Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "Lcom/tencent/state/square/message/box/IMsgBoxLifeCycle;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;)V", "adapter", "Lcom/tencent/state/square/message/box/MsgBoxAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareMsgBoxPanelBinding;", "destroyed", "", "checkAndShowEmptyViewIfNeeded", "", "destroy", "getRootView", "Landroid/view/View;", "initData", "initListener", "initView", "initWindow", "isDestroy", "onDataInsert", "data", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "index", "", "onDataRemove", "onDataSetChange", "onDataUpdate", "onNewMessageCome", "onTotalUnreadNumChange", "unreadNum", "show", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxPanel extends Dialog implements IMsgBoxDataObserver, IMsgBoxLifeCycle {
    private final MsgBoxAdapter adapter;
    private final VasSquareMsgBoxPanelBinding binding;
    private boolean destroyed;
    private final MsgBoxContext msgBoxContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxPanel(MsgBoxContext msgBoxContext) {
        super(msgBoxContext.getActivity(), R.style.f243270c);
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        this.msgBoxContext = msgBoxContext;
        VasSquareMsgBoxPanelBinding inflate = VasSquareMsgBoxPanelBinding.inflate(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMsgBoxPanelBind\u2026utInflater.from(context))");
        this.binding = inflate;
        this.adapter = new MsgBoxAdapter(msgBoxContext, this, msgBoxContext.getMsgBoxManager().getMsgRecords());
        setContentView(inflate.getRoot());
        initView();
        initListener();
        initWindow();
        initData();
    }

    private final void checkAndShowEmptyViewIfNeeded() {
        if (this.adapter.isEmpty()) {
            RelativeLayout relativeLayout = this.binding.vasSquareMsgBoxContent;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.vasSquareMsgBoxContent");
            relativeLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = this.binding.vasSquareMsgBoxEmptyContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.vasSquareMsgBoxEmptyContainer");
            relativeLayout2.setVisibility(0);
            return;
        }
        RelativeLayout relativeLayout3 = this.binding.vasSquareMsgBoxContent;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.vasSquareMsgBoxContent");
        relativeLayout3.setVisibility(0);
        RelativeLayout relativeLayout4 = this.binding.vasSquareMsgBoxEmptyContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.vasSquareMsgBoxEmptyContainer");
        relativeLayout4.setVisibility(8);
    }

    private final void initData() {
        RecyclerView recyclerView = this.binding.vasSquareMsgBoxList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareMsgBoxList");
        recyclerView.setAdapter(this.adapter);
        onDataSetChange();
        this.msgBoxContext.getMsgBoxManager().addMsgBoxDataObserver(this);
    }

    private final void initListener() {
        this.binding.vasSquareMsgBoxDragIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.message.box.MsgBoxPanel$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        SquareImageView squareImageView = this.binding.vasSquareMsgBoxDragIcon;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        squareImageView.setOnTouchListener(new FloatPanelDragListener(context, root, new Function1<Float, Unit>() { // from class: com.tencent.state.square.message.box.MsgBoxPanel$initListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke(f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f16) {
                MsgBoxContext msgBoxContext;
                msgBoxContext = MsgBoxPanel.this.msgBoxContext;
                msgBoxContext.getMsgBoxManager().hideMsgListPanel(MsgBoxOperateFlag.CLICK_PANEL_DRAG_ICON);
            }
        }));
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.message.box.MsgBoxPanel$initListener$3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MsgBoxContext msgBoxContext;
                msgBoxContext = MsgBoxPanel.this.msgBoxContext;
                msgBoxContext.getMsgBoxManager().enableNewMsgBubble(true, MsgBoxOperateFlag.HIDE_PANEL);
            }
        });
    }

    private final void initView() {
        RecyclerView recyclerView = this.binding.vasSquareMsgBoxList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.vasSquareMsgBoxList");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        Unit unit = Unit.INSTANCE;
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public final View getRootView() {
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    /* renamed from: isDestroy, reason: from getter */
    public boolean getDestroyed() {
        return this.destroyed;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataInsert(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (getDestroyed()) {
            return;
        }
        this.adapter.onDataInsert(data, index);
        checkAndShowEmptyViewIfNeeded();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataRemove(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (getDestroyed()) {
            return;
        }
        this.adapter.onDataRemove(data, index);
        checkAndShowEmptyViewIfNeeded();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataSetChange() {
        if (getDestroyed()) {
            return;
        }
        this.adapter.onDataSetChange();
        checkAndShowEmptyViewIfNeeded();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataUpdate(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (getDestroyed()) {
            return;
        }
        this.adapter.onDataUpdate(data, index);
        checkAndShowEmptyViewIfNeeded();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onNewMessageCome(SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (getDestroyed()) {
            return;
        }
        this.adapter.onNewMessageCome(data);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onTotalUnreadNumChange(int unreadNum) {
        if (getDestroyed()) {
            return;
        }
        this.adapter.onTotalUnreadNumChange(unreadNum);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setTranslationY(0.0f);
        IMsgBoxManager msgBoxManager = this.msgBoxContext.getMsgBoxManager();
        MsgBoxOperateFlag msgBoxOperateFlag = MsgBoxOperateFlag.SHOW_PANEL;
        msgBoxManager.hideNewMsgBubble(msgBoxOperateFlag);
        this.msgBoxContext.getMsgBoxManager().enableNewMsgBubble(false, msgBoxOperateFlag);
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

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    public void destroy() {
        this.destroyed = true;
        this.msgBoxContext.getMsgBoxManager().removeMsgBoxDataObserver(this);
        if (isShowing()) {
            dismiss();
        }
    }
}

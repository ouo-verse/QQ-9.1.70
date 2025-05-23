package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.state.SquareRuntime;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.event.ChatCheckUinInSquare;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.databinding.VasSquareChatLandMsgPanelViewBinding;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.TableType;
import com.tencent.state.template.data.User;
import com.tencent.state.utils.FaceUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J*\u0010\"\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandAvatarPanelWindow;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandMsgPanelViewBinding;", "clickListener", "Lkotlin/Function1;", "Lcom/tencent/state/square/chatland/view/PanelClickType;", "Lkotlin/ParameterName;", "name", "type", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "bindMergePanel", "info", "Lcom/tencent/state/template/data/InterResourceInfo;", "initListener", "initReport", "receiveInSquareResult", "inSquare", "", "updateItem", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "meItem", ParseCommon.CONTAINER, "Landroid/widget/FrameLayout;", "rectF", "Landroid/graphics/RectF;", "updateLocation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandAvatarPanelWindow extends PopupWindow {
    private static final String TAG = "ChatLandAvatarPanelWindow";
    private final VasSquareChatLandMsgPanelViewBinding binding;
    private Function1<? super PanelClickType, Unit> clickListener;
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandAvatarPanelWindow(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        VasSquareChatLandMsgPanelViewBinding inflate = VasSquareChatLandMsgPanelViewBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandMsgPane\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getMContainer());
        setOutsideTouchable(true);
        setFocusable(true);
        setClippingEnabled(false);
        setBackgroundDrawable(null);
        initReport();
        initListener();
    }

    private final void initListener() {
        this.binding.itemViewMerge.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding;
                Map<String, Object> mutableMapOf;
                Function1<PanelClickType, Unit> clickListener = ChatLandAvatarPanelWindow.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(PanelClickType.Merge);
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquareChatLandMsgPanelViewBinding = ChatLandAvatarPanelWindow.this.binding;
                RelativeLayout relativeLayout = vasSquareChatLandMsgPanelViewBinding.singlePanel;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.singlePanel");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, 0));
                squareReporter.reportEvent("clck", relativeLayout, mutableMapOf);
            }
        });
        this.binding.itemViewSayHi.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$initListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1<PanelClickType, Unit> clickListener = ChatLandAvatarPanelWindow.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(PanelClickType.SayHi);
                }
            }
        });
        this.binding.itemViewProfile.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$initListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding;
                Map<String, Object> mutableMapOf;
                Function1<PanelClickType, Unit> clickListener = ChatLandAvatarPanelWindow.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(PanelClickType.ViewProfile);
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquareChatLandMsgPanelViewBinding = ChatLandAvatarPanelWindow.this.binding;
                RelativeLayout relativeLayout = vasSquareChatLandMsgPanelViewBinding.singlePanel;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.singlePanel");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, 1));
                squareReporter.reportEvent("clck", relativeLayout, mutableMapOf);
            }
        });
        this.binding.itemAddSquare.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$initListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding;
                Map<String, Object> mutableMapOf;
                Function1<PanelClickType, Unit> clickListener = ChatLandAvatarPanelWindow.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(PanelClickType.AddSquare);
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquareChatLandMsgPanelViewBinding = ChatLandAvatarPanelWindow.this.binding;
                RelativeLayout relativeLayout = vasSquareChatLandMsgPanelViewBinding.singlePanel;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.singlePanel");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, 2));
                squareReporter.reportEvent("clck", relativeLayout, mutableMapOf);
            }
        });
        this.binding.senderContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$initListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1<PanelClickType, Unit> clickListener = ChatLandAvatarPanelWindow.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(PanelClickType.SenderProfile);
                }
            }
        });
        this.binding.receiverContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$initListener$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1<PanelClickType, Unit> clickListener = ChatLandAvatarPanelWindow.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(PanelClickType.ReceiverProfile);
                }
            }
        });
    }

    private final void initReport() {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        FrameLayout mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        FrameLayout mContainer2 = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.root");
        squareReporter.setPageInfo(mContainer, mContainer2, SquareReportConst.PageId.INSTANCE.checkNearby(), new LinkedHashMap());
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = this.binding.singlePanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.singlePanel");
        squareReporter2.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_ZPLAN_AVATAR_POP, new LinkedHashMap(), false, false);
    }

    private final void receiveInSquareResult(boolean inSquare) {
        LinearLayout linearLayout = this.binding.itemAddSquare;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemAddSquare");
        ViewExtensionsKt.setVisibility(linearLayout, !inSquare);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLocation(ChatLandAvatarItem item, ChatLandAvatarItem meItem, boolean inSquare, final RectF rectF) {
        Table table;
        User user;
        SitDownInfo sitDown;
        Table table2;
        receiveInSquareResult(inSquare);
        TableType tableType = null;
        TableType tableType2 = (meItem == null || (user = meItem.getUser()) == null || (sitDown = user.getSitDown()) == null || (table2 = sitDown.getTable()) == null) ? null : table2.getTableType();
        TableType tableType3 = TableType.TABLE_TYPE_FIXED;
        if (tableType2 != tableType3) {
            SitDownInfo sitDown2 = item.getUser().getSitDown();
            if (sitDown2 != null && (table = sitDown2.getTable()) != null) {
                tableType = table.getTableType();
            }
            if (tableType != tableType3) {
                LinearLayout linearLayout = this.binding.itemViewMerge;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemViewMerge");
                ViewExtensionsKt.setVisibility(linearLayout, meItem != null);
                boolean studyMode = Square.INSTANCE.getConfig().getCommonUtils().getStudyMode();
                LinearLayout linearLayout2 = this.binding.itemViewSayHi;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.itemViewSayHi");
                ViewExtensionsKt.setVisibility(linearLayout2, !studyMode);
                RelativeLayout relativeLayout = this.binding.singlePanel;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.singlePanel");
                ViewExtensionsKt.setVisibility(relativeLayout, true);
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$updateLocation$1
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
                        VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding;
                        VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding2;
                        Context context;
                        ChatLandAvatarPanelWindow chatLandAvatarPanelWindow = ChatLandAvatarPanelWindow.this;
                        float f16 = rectF.left;
                        vasSquareChatLandMsgPanelViewBinding = chatLandAvatarPanelWindow.binding;
                        Intrinsics.checkNotNullExpressionValue(vasSquareChatLandMsgPanelViewBinding.singlePanel, "binding.singlePanel");
                        int width = (int) ((f16 - (r2.getWidth() / 2)) + (rectF.width() / 2));
                        float f17 = rectF.top;
                        vasSquareChatLandMsgPanelViewBinding2 = ChatLandAvatarPanelWindow.this.binding;
                        Intrinsics.checkNotNullExpressionValue(vasSquareChatLandMsgPanelViewBinding2.singlePanel, "binding.singlePanel");
                        context = ChatLandAvatarPanelWindow.this.context;
                        chatLandAvatarPanelWindow.update(width, (int) ((f17 - r4.getHeight()) + com.tencent.state.square.common.ViewExtensionsKt.dip(context, 5)), ChatLandAvatarPanelWindow.this.getWidth(), ChatLandAvatarPanelWindow.this.getHeight());
                    }
                });
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                RelativeLayout relativeLayout2 = this.binding.singlePanel;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.singlePanel");
                squareReporter.reportEvent("imp", relativeLayout2, new LinkedHashMap());
            }
        }
        LinearLayout linearLayout3 = this.binding.itemViewMerge;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.itemViewMerge");
        ViewExtensionsKt.setVisibility(linearLayout3, false);
        boolean studyMode2 = Square.INSTANCE.getConfig().getCommonUtils().getStudyMode();
        LinearLayout linearLayout22 = this.binding.itemViewSayHi;
        Intrinsics.checkNotNullExpressionValue(linearLayout22, "binding.itemViewSayHi");
        ViewExtensionsKt.setVisibility(linearLayout22, !studyMode2);
        RelativeLayout relativeLayout3 = this.binding.singlePanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.singlePanel");
        ViewExtensionsKt.setVisibility(relativeLayout3, true);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$updateLocation$1
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
                VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding;
                VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding2;
                Context context;
                ChatLandAvatarPanelWindow chatLandAvatarPanelWindow = ChatLandAvatarPanelWindow.this;
                float f16 = rectF.left;
                vasSquareChatLandMsgPanelViewBinding = chatLandAvatarPanelWindow.binding;
                Intrinsics.checkNotNullExpressionValue(vasSquareChatLandMsgPanelViewBinding.singlePanel, "binding.singlePanel");
                int width = (int) ((f16 - (r2.getWidth() / 2)) + (rectF.width() / 2));
                float f17 = rectF.top;
                vasSquareChatLandMsgPanelViewBinding2 = ChatLandAvatarPanelWindow.this.binding;
                Intrinsics.checkNotNullExpressionValue(vasSquareChatLandMsgPanelViewBinding2.singlePanel, "binding.singlePanel");
                context = ChatLandAvatarPanelWindow.this.context;
                chatLandAvatarPanelWindow.update(width, (int) ((f17 - r4.getHeight()) + com.tencent.state.square.common.ViewExtensionsKt.dip(context, 5)), ChatLandAvatarPanelWindow.this.getWidth(), ChatLandAvatarPanelWindow.this.getHeight());
            }
        });
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout22 = this.binding.singlePanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout22, "binding.singlePanel");
        squareReporter2.reportEvent("imp", relativeLayout22, new LinkedHashMap());
    }

    public final Function1<PanelClickType, Unit> getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(Function1<? super PanelClickType, Unit> function1) {
        this.clickListener = function1;
    }

    public final void updateItem(final ChatLandAvatarItem item, final ChatLandAvatarItem meItem, FrameLayout container, final RectF rectF) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        showAtLocation(container, 0, -99999, -99999);
        if (!item.ingInteraction()) {
            LinearLayout linearLayout = this.binding.mergePanel;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mergePanel");
            ViewExtensionsKt.setVisibility(linearLayout, false);
            RelativeLayout relativeLayout = this.binding.singlePanel;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.singlePanel");
            relativeLayout.setVisibility(4);
            if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                updateLocation(item, meItem, true, rectF);
                return;
            } else {
                SimpleEventBus.getInstance().dispatchEvent(new ChatCheckUinInSquare(item.getUin(), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$updateItem$1
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
                        ChatLandAvatarPanelWindow.this.updateLocation(item, meItem, z16, rectF);
                    }
                }));
                return;
            }
        }
        RelativeLayout relativeLayout2 = this.binding.singlePanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.singlePanel");
        ViewExtensionsKt.setVisibility(relativeLayout2, false);
        LinearLayout linearLayout2 = this.binding.mergePanel;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.mergePanel");
        ViewExtensionsKt.setVisibility(linearLayout2, true);
        bindMergePanel(item.getUser().getInteraction());
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$updateItem$2
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
                Context context;
                VasSquareChatLandMsgPanelViewBinding vasSquareChatLandMsgPanelViewBinding;
                ChatLandAvatarPanelWindow chatLandAvatarPanelWindow = ChatLandAvatarPanelWindow.this;
                RectF rectF2 = rectF;
                float width = rectF2.left + rectF2.width();
                context = ChatLandAvatarPanelWindow.this.context;
                int dip = (int) (width - com.tencent.state.square.common.ViewExtensionsKt.dip(context, 40));
                RectF rectF3 = rectF;
                float height = rectF3.top + (rectF3.height() / 2);
                vasSquareChatLandMsgPanelViewBinding = ChatLandAvatarPanelWindow.this.binding;
                Intrinsics.checkNotNullExpressionValue(vasSquareChatLandMsgPanelViewBinding.mergePanel, "binding.mergePanel");
                chatLandAvatarPanelWindow.update(dip, (int) (height - (r2.getHeight() / 2)), ChatLandAvatarPanelWindow.this.getWidth(), ChatLandAvatarPanelWindow.this.getHeight());
            }
        });
    }

    private final void bindMergePanel(InterResourceInfo info) {
        if (info == null) {
            return;
        }
        final String valueOf = String.valueOf(info.getSenderInfo().getUin());
        final String valueOf2 = String.valueOf(info.getReceiverInfo().getUin());
        FaceUtils faceUtils = FaceUtils.INSTANCE;
        Square square = Square.INSTANCE;
        faceUtils.loadHeadIcon(square.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.senderHeader, valueOf, false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$bindMergePanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                return Boolean.valueOf(invoke2(str));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(String str) {
                return TextUtils.equals(str, valueOf);
            }
        });
        faceUtils.loadHeadIcon(square.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.receiverHeader, valueOf2, false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelWindow$bindMergePanel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                return Boolean.valueOf(invoke2(str));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(String str) {
                return TextUtils.equals(str, valueOf2);
            }
        });
        TextView textView = this.binding.senderName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.senderName");
        textView.setText(info.getSenderInfo().getProfile().getNick());
        TextView textView2 = this.binding.receiverName;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.receiverName");
        textView2.setText(info.getReceiverInfo().getProfile().getNick());
    }
}

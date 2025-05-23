package com.tencent.state.square.chatland.viewholder;

import android.view.View;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.square.chatland.view.ChatLandTableView;
import com.tencent.state.square.databinding.VasSquareItemChatLandTableBinding;
import com.tencent.state.utils.FastClickUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0017H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/chatland/viewholder/ChatLandTableViewHolder;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/square/chatland/data/ChatLandTableItem;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemChatLandTableBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemChatLandTableBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemChatLandTableBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "bindListeners", "", "calculateElevation", "", "location", "Lcom/tencent/state/map/Location;", "doBind", "data", "index", "", "getChatLandAvatarCount", "initReport", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "onRecycled", "onScaleToDetail", "", "transform", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandTableViewHolder extends MapViewHolder<ChatLandTableItem> {
    private static final String TAG = "ChatLandTableViewHolder";
    private final VasSquareItemChatLandTableBinding binding;
    private final FastClickUtils clickUtils;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatLandTableViewHolder(VasSquareItemChatLandTableBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        ChatLandTableView mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        this.binding = binding;
        this.clickUtils = new FastClickUtils(800L);
    }

    private final void bindListeners() {
        this.binding.tableView.setClickListener(new Function2<View, Integer, Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandTableViewHolder$bindListeners$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i3) {
                FastClickUtils fastClickUtils;
                MapItemController controller;
                int chatLandAvatarCount;
                Map<String, Object> mutableMapOf;
                IMapViewListener listener;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                fastClickUtils = ChatLandTableViewHolder.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick()) {
                    return;
                }
                if (i3 == 0 || i3 == 1) {
                    controller = ChatLandTableViewHolder.this.getController();
                    if (controller != null && (listener = controller.getListener()) != null) {
                        ChatLandTableViewHolder chatLandTableViewHolder = ChatLandTableViewHolder.this;
                        IMapViewListener.DefaultImpls.onItemClicked$default(listener, chatLandTableViewHolder, chatLandTableViewHolder.getIndex(), ChatLandTableViewHolder.this.getData(), 17, null, 16, null);
                    }
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    ChatLandTableView chatLandTableView = ChatLandTableViewHolder.this.getBinding().tableView;
                    Intrinsics.checkNotNullExpressionValue(chatLandTableView, "binding.tableView");
                    chatLandAvatarCount = ChatLandTableViewHolder.this.getChatLandAvatarCount();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_REMAINING_USER_COUNT, Integer.valueOf(chatLandAvatarCount)));
                    squareReporter.reportEvent("clck", chatLandTableView, mutableMapOf);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getChatLandAvatarCount() {
        IMapItemViewManager viewManager;
        MapItemController controller = getController();
        if (controller == null || (viewManager = controller.getViewManager()) == null) {
            return 0;
        }
        return viewManager.getTypeItemCount(10);
    }

    private final void initReport(ChatLandTableItem data) {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        ChatLandTableView chatLandTableView = this.binding.tableView;
        Intrinsics.checkNotNullExpressionValue(chatLandTableView, "binding.tableView");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_TABLE_ID, Long.valueOf(data.getTable().getId())), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(data.getAppId())));
        squareReporter.setElementInfo(chatLandTableView, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_EMPTY_BTN, mutableMapOf, false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.viewholder.ChatLandTableViewHolder$initReport$1
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
                int chatLandAvatarCount;
                Map<String, Object> mutableMapOf2;
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                ChatLandTableView chatLandTableView2 = ChatLandTableViewHolder.this.getBinding().tableView;
                Intrinsics.checkNotNullExpressionValue(chatLandTableView2, "binding.tableView");
                chatLandAvatarCount = ChatLandTableViewHolder.this.getChatLandAvatarCount();
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_REMAINING_USER_COUNT, Integer.valueOf(chatLandAvatarCount)));
                squareReporter2.reportEvent("imp", chatLandTableView2, mutableMapOf2);
            }
        });
    }

    @Override // com.tencent.state.map.MapViewHolder
    public float calculateElevation(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return location.getCenterY() * 2;
    }

    public final VasSquareItemChatLandTableBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        this.binding.tableView.getTable().setImageDrawable(null);
        super.onRecycled();
    }

    @Override // com.tencent.state.map.MapViewHolder
    public boolean onScaleToDetail() {
        MapItemController controller;
        boolean onScaleToDetail = super.onScaleToDetail();
        if (onScaleToDetail && (controller = getController()) != null) {
            controller.setItemAlpha(0.0f);
        }
        return onScaleToDetail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(ChatLandTableItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareBaseKt.getSquareLog().i(TAG, "onBindViewHolder: index=" + index + ", data=" + data.getUin() + "- tableId=" + data.getTable().getId() + " - " + data.getLocation());
        bindListeners();
        this.binding.tableView.bindTableImage(data.getTable().getImage().getUrl(), data.getTable().getImage().getSize());
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        MapItemController controller = getController();
        itemView.setAlpha(controller != null ? controller.getItemAlpha() : 1.0f);
        initReport(data);
        this.binding.tableView.getTable().setIgnoreTransparentTouchEvent(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public ChatLandTableItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof ChatLandTableItem)) {
            data = null;
        }
        return (ChatLandTableItem) data;
    }
}

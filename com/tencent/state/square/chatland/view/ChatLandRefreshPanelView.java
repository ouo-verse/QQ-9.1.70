package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.chatland.utils.RefreshPanelUtils;
import com.tencent.state.square.databinding.VasSquareFragmentChatLandRefreshPanelBinding;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.SquareImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u001b\u001a\u00020\u0011J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0002J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandRefreshPanelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "getReportParams", "Lkotlin/Function0;", "", "", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/jvm/functions/Function0;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentChatLandRefreshPanelBinding;", "clickListener", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "fastClickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "getGetReportParams", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "hide", "initPAGViewIfNeeded", "update", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandRefreshPanelView extends FrameLayout {
    private static final String TAG = "ChatLandRefreshPanelView";
    private final VasSquareFragmentChatLandRefreshPanelBinding binding;
    private Function0<Unit> clickListener;
    private final FastClickUtils fastClickUtils;
    private final Function0<Map<String, Object>> getReportParams;
    private ISquarePagView pagView;

    public ChatLandRefreshPanelView(Context context, AttributeSet attributeSet, Function0<? extends Map<String, Object>> function0) {
        this(context, attributeSet, 0, function0, 4, null);
    }

    private final ISquarePagView initPAGViewIfNeeded() {
        ISquarePagView iSquarePagView = this.pagView;
        if (iSquarePagView != null) {
            return iSquarePagView;
        }
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        this.pagView = pagView;
        addView(pagView != null ? pagView.getView() : null, new FrameLayout.LayoutParams(-1, -1));
        return this.pagView;
    }

    public final Function0<Unit> getClickListener() {
        return this.clickListener;
    }

    public final Function0<Map<String, Object>> getGetReportParams() {
        return this.getReportParams;
    }

    public final void setClickListener(Function0<Unit> function0) {
        this.clickListener = function0;
    }

    public final void update(RoomThemeData themeData) {
        Intrinsics.checkNotNullParameter(themeData, "themeData");
        final Location location = themeData.getLocation();
        if (location != null) {
            ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandRefreshPanelView$update$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = Location.this.getWidth();
                    receiver.height = Location.this.getHeight();
                    receiver.topMargin = Location.this.getY();
                    receiver.leftMargin = Location.this.getX();
                }
            });
        }
        SquareImageView squareImageView = this.binding.panelImage;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.panelImage");
        ViewExtensionsKt.setUri(squareImageView, themeData.getSignBoard());
        initPAGViewIfNeeded();
        ISquarePagView iSquarePagView = this.pagView;
        if (iSquarePagView != null) {
            RefreshPanelUtils.INSTANCE.bindInfo(iSquarePagView, themeData.getTextResource(), themeData.getText());
        }
    }

    public ChatLandRefreshPanelView(Context context, Function0<? extends Map<String, Object>> function0) {
        this(context, null, 0, function0, 6, null);
    }

    public /* synthetic */ ChatLandRefreshPanelView(Context context, AttributeSet attributeSet, int i3, Function0 function0, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, function0);
    }

    public final void hide() {
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatLandRefreshPanelView(Context context, AttributeSet attributeSet, int i3, Function0<? extends Map<String, Object>> getReportParams) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(getReportParams, "getReportParams");
        this.getReportParams = getReportParams;
        VasSquareFragmentChatLandRefreshPanelBinding inflate = VasSquareFragmentChatLandRefreshPanelBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentChatLan\u2026ater.from(context), this)");
        this.binding = inflate;
        this.fastClickUtils = new FastClickUtils(800L);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout = inflate.clickHit;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.clickHit");
        squareReporter.setElementInfo(frameLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_SWITCH_ROOM_BTN, (Map) getReportParams.invoke(), false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(50L, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandRefreshPanelView.1
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
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                FrameLayout frameLayout2 = ChatLandRefreshPanelView.this.binding.clickHit;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.clickHit");
                squareReporter2.reportEvent("imp", frameLayout2, ChatLandRefreshPanelView.this.getGetReportParams().invoke());
            }
        });
        setElevation(2.0f);
        inflate.clickHit.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandRefreshPanelView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ChatLandRefreshPanelView.this.fastClickUtils.isFastDoubleClick()) {
                    return;
                }
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                FrameLayout frameLayout2 = ChatLandRefreshPanelView.this.binding.clickHit;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.clickHit");
                squareReporter2.reportEvent("clck", frameLayout2, ChatLandRefreshPanelView.this.getGetReportParams().invoke());
                Function0<Unit> clickListener = ChatLandRefreshPanelView.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke();
                }
            }
        });
    }
}

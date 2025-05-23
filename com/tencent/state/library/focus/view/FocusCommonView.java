package com.tencent.state.library.focus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.library.focus.FocusBaseListener;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import com.tencent.state.template.data.SitDownInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0016\u0010 \u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/library/focus/view/FocusCommonView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryCommonViewBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareLibraryCommonViewBinding;", "clickListener", "Lkotlin/Function1;", "Lcom/tencent/state/library/focus/view/ClickType;", "Lkotlin/ParameterName;", "name", "type", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/library/focus/view/ICommonViewConfig;", "data", "Lcom/tencent/state/library/focus/data/FocusBaseItem;", "focusCommonListener", "Lcom/tencent/state/library/focus/FocusBaseListener;", "getCommonConfig", "initClickListener", "initView", "listener", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "setConfig", "updateBubble", "updateLikeView", "userFocus", "Lcom/tencent/state/template/data/SitDownInfo;", "updateTitleButtonsVisibility", "isVisible", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusCommonView extends RelativeLayout {
    private final VasSquareLibraryCommonViewBinding binding;
    private Function1<? super ClickType, Unit> clickListener;
    private ICommonViewConfig config;
    private FocusBaseItem data;
    private FocusBaseListener focusCommonListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClickType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ClickType.BACK.ordinal()] = 1;
            iArr[ClickType.END_FOCUS.ordinal()] = 2;
        }
    }

    public FocusCommonView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void initClickListener() {
        this.binding.titleContainer.setClickListener(new Function1<ClickType, Unit>() { // from class: com.tencent.state.library.focus.view.FocusCommonView$initClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClickType clickType) {
                invoke2(clickType);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
            
                r0 = r2.this$0.focusCommonListener;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(ClickType type) {
                FocusBaseListener focusBaseListener;
                FocusBaseListener focusBaseListener2;
                Intrinsics.checkNotNullParameter(type, "type");
                int i3 = FocusCommonView.WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i3 == 1) {
                    focusBaseListener = FocusCommonView.this.focusCommonListener;
                    if (focusBaseListener != null) {
                        focusBaseListener.onBackClick();
                    }
                } else if (i3 == 2 && focusBaseListener2 != null) {
                    String meFocusTimeText = FocusCommonView.this.getBinding().focusTimeBubble.getMeFocusTimeText();
                    if (meFocusTimeText == null) {
                        meFocusTimeText = "";
                    }
                    focusBaseListener2.onEndFocusClick(meFocusTimeText);
                }
                Function1<ClickType, Unit> clickListener = FocusCommonView.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(type);
                }
            }
        });
    }

    private final void updateTitleButtonsVisibility(boolean isVisible) {
        this.binding.titleContainer.updateTypeView(ClickType.END_FOCUS, isVisible);
        this.binding.titleContainer.updateTypeView(ClickType.MSG_BOX, isVisible);
    }

    public final VasSquareLibraryCommonViewBinding getBinding() {
        return this.binding;
    }

    public final Function1<ClickType, Unit> getClickListener() {
        return this.clickListener;
    }

    /* renamed from: getCommonConfig, reason: from getter */
    public ICommonViewConfig getConfig() {
        return this.config;
    }

    public final void initView(FocusBaseItem data, FocusBaseListener listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LibraryTitleContainer libraryTitleContainer = this.binding.titleContainer;
        ICommonViewConfig config = getConfig();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        libraryTitleContainer.setTitle(config.getCommonTitle(context));
        this.data = data;
        this.focusCommonListener = listener;
        updateBubble(data);
    }

    public final void onDestroy() {
        this.binding.focusTimeBubble.onDestroy();
    }

    public final void setClickListener(Function1<? super ClickType, Unit> function1) {
        this.clickListener = function1;
    }

    public final void setConfig(ICommonViewConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final void updateBubble(FocusBaseItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.binding.focusTimeBubble.updateBubble(data);
        updateTitleButtonsVisibility(FocusDataKt.hasMe(data));
        TextView textView = this.binding.focusTimeBubble.getBinding().singleTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.focusTimeBubble.binding.singleTitle");
        ICommonViewConfig config = getConfig();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(config.getBubbleSingleTitle(context));
        TextView textView2 = this.binding.focusTimeBubble.getBinding().groupTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.focusTimeBubble.binding.groupTitle");
        ICommonViewConfig config2 = getConfig();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView2.setText(config2.getBubbleGroupTitle(context2));
    }

    public final void updateLikeView(SitDownInfo userFocus) {
        Intrinsics.checkNotNullParameter(userFocus, "userFocus");
        this.binding.focusTimeBubble.updateLikeView(userFocus);
    }

    public FocusCommonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FocusCommonView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusCommonView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareLibraryCommonViewBinding inflate = VasSquareLibraryCommonViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryCommonVi\u2026ater.from(context), this)");
        this.binding = inflate;
        this.config = new FocusCommonViewConfig();
        LibraryTitleContainer libraryTitleContainer = inflate.titleContainer;
        Intrinsics.checkNotNullExpressionValue(libraryTitleContainer, "binding.titleContainer");
        ViewGroup.LayoutParams layoutParams = libraryTitleContainer.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(SquareUtil.INSTANCE.getStatusBarHeight(context), ViewExtensionsKt.dip(context, 20.0f));
            layoutParams2.topMargin = coerceAtLeast;
        }
        initClickListener();
    }
}

package com.tencent.state.square.friendsetting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareFloatSettingItemBinding;
import com.tencent.state.square.databinding.VasSquareFriendSetWindowBinding;
import com.tencent.state.square.friendsetting.SquareSettingWindow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u0003012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\rH\u0002J*\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0019\u0010\u001f\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0013\u00a2\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020\r2\u0006\u0010$\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tJ\u0016\u0010)\u001a\u00020\r2\u0006\u0010$\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tJ\u0016\u0010+\u001a\u00020\r2\u0006\u0010$\u001a\u00020\t2\u0006\u0010,\u001a\u00020-J\u001b\u0010.\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0013H\u0002\u00a2\u0006\u0002\u0010\"J\u001b\u0010/\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0013H\u0002\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/state/square/friendsetting/SquareSettingWindow;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFriendSetWindowBinding;", "clickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "itemContainers", "", "Lcom/tencent/state/square/databinding/VasSquareFloatSettingItemBinding;", "[Lcom/tencent/state/square/databinding/VasSquareFloatSettingItemBinding;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "", "resetItems", "showAtLocation", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", LayoutAttrDefine.Gravity.Gravity, HippyTKDListViewAdapter.X, "y", "updateItem", "itemArray", "Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemConfig;", "([Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemConfig;)V", "updateItemAlpha", "itemType", c.f123400v, "", "updateItemBackground", "bgResId", "updateItemIcon", "iconResId", "updateItemText", "text", "", "updateItems", "updateItemsRule", "Companion", "FloatItemConfig", "FloatItemTextStyle", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareSettingWindow extends PopupWindow {
    private static final int DEFAULT_TOP_MARGIN = 39;
    private static final int FOUR_WIDTH = 189;
    private static final int ICON_SIZE = 58;
    private static final int INTERVAL_FOUR_CENTER_ICON = 10;
    private static final int THREE_WIDTH = 160;
    public static final int TYPE_CLOSE_TO_ME = 1;
    public static final int TYPE_FIXED = 2;
    public static final int TYPE_HIDE = 3;
    public static final int TYPE_INTERACTION = 5;
    public static final int TYPE_INTERACTION_SETTINGS = 6;
    public static final int TYPE_MESSAGE = 4;
    private final VasSquareFriendSetWindowBinding binding;
    private Function1<? super Integer, Unit> clickListener;
    private final Context context;
    private final VasSquareFloatSettingItemBinding[] itemContainers;
    private long showTime;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemTextStyle;", "", "textContent", "", "textSize", "", "textColor", "", "(Ljava/lang/String;FI)V", "getTextColor", "()I", "getTextContent", "()Ljava/lang/String;", "getTextSize", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class FloatItemTextStyle {
        private final int textColor;
        private final String textContent;
        private final float textSize;

        public FloatItemTextStyle(String textContent, float f16, int i3) {
            Intrinsics.checkNotNullParameter(textContent, "textContent");
            this.textContent = textContent;
            this.textSize = f16;
            this.textColor = i3;
        }

        /* renamed from: component1, reason: from getter */
        public final String getTextContent() {
            return this.textContent;
        }

        /* renamed from: component2, reason: from getter */
        public final float getTextSize() {
            return this.textSize;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public final FloatItemTextStyle copy(String textContent, float textSize, int textColor) {
            Intrinsics.checkNotNullParameter(textContent, "textContent");
            return new FloatItemTextStyle(textContent, textSize, textColor);
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final String getTextContent() {
            return this.textContent;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        public int hashCode() {
            String str = this.textContent;
            return ((((str != null ? str.hashCode() : 0) * 31) + Float.floatToIntBits(this.textSize)) * 31) + this.textColor;
        }

        public String toString() {
            return "FloatItemTextStyle(textContent=" + this.textContent + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ")";
        }

        public /* synthetic */ FloatItemTextStyle(String str, float f16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i16 & 2) != 0 ? 9.0f : f16, (i16 & 4) != 0 ? -1 : i3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FloatItemTextStyle)) {
                return false;
            }
            FloatItemTextStyle floatItemTextStyle = (FloatItemTextStyle) other;
            return Intrinsics.areEqual(this.textContent, floatItemTextStyle.textContent) && Float.compare(this.textSize, floatItemTextStyle.textSize) == 0 && this.textColor == floatItemTextStyle.textColor;
        }

        public static /* synthetic */ FloatItemTextStyle copy$default(FloatItemTextStyle floatItemTextStyle, String str, float f16, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = floatItemTextStyle.textContent;
            }
            if ((i16 & 2) != 0) {
                f16 = floatItemTextStyle.textSize;
            }
            if ((i16 & 4) != 0) {
                i3 = floatItemTextStyle.textColor;
            }
            return floatItemTextStyle.copy(str, f16, i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareSettingWindow(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.showTime = System.currentTimeMillis();
        VasSquareFriendSetWindowBinding inflate = VasSquareFriendSetWindowBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFriendSetWindow\u2026utInflater.from(context))");
        this.binding = inflate;
        this.itemContainers = new VasSquareFloatSettingItemBinding[]{inflate.settingFirstItem, inflate.settingSecondItem, inflate.settingThirdItem, inflate.settingForthItem};
        setContentView(inflate.getRoot());
        setOutsideTouchable(true);
        setFocusable(true);
        setClippingEnabled(false);
        setBackgroundDrawable(null);
    }

    private final void resetItems() {
        for (VasSquareFloatSettingItemBinding it : this.itemContainers) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.getRoot().setOnClickListener(null);
            LinearLayout root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            root.setTag(null);
            LinearLayout root2 = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "it.root");
            root2.setVisibility(8);
            LinearLayout root3 = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "it.root");
            root3.setAlpha(1.0f);
            LinearLayout root4 = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root4, "it.root");
            ViewExtensionsKt.updateLayoutParams(root4, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$resetItems$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RelativeLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.topMargin = 0;
                    receiver.setMarginStart(0);
                    receiver.removeRule(14);
                    receiver.removeRule(21);
                    receiver.removeRule(17);
                }
            });
        }
    }

    private final void updateItems(FloatItemConfig[] itemArray) {
        int length = itemArray.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            final FloatItemConfig floatItemConfig = itemArray[i3];
            int i17 = i16 + 1;
            VasSquareFloatSettingItemBinding[] vasSquareFloatSettingItemBindingArr = this.itemContainers;
            if (i16 >= vasSquareFloatSettingItemBindingArr.length) {
                return;
            }
            vasSquareFloatSettingItemBindingArr[i16].squareSettingIcon.setImageResource(floatItemConfig.getIconResId());
            TextView textView = this.itemContainers[i16].squareSettingText;
            textView.setText(floatItemConfig.getText().getTextContent());
            textView.setTextSize(floatItemConfig.getText().getTextSize());
            textView.setTextColor(floatItemConfig.getText().getTextColor());
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding = this.itemContainers[i16];
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding, "itemContainers[index]");
            vasSquareFloatSettingItemBinding.getRoot().setBackgroundResource(floatItemConfig.getBackgroundResId());
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding2 = this.itemContainers[i16];
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding2, "itemContainers[index]");
            vasSquareFloatSettingItemBinding2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItems$$inlined$forEachIndexed$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long j3;
                    Function1<Integer, Unit> clickListener;
                    long currentTimeMillis = System.currentTimeMillis();
                    j3 = this.showTime;
                    if (currentTimeMillis - j3 >= 300 && (clickListener = this.getClickListener()) != null) {
                        clickListener.invoke(Integer.valueOf(SquareSettingWindow.FloatItemConfig.this.getItemType()));
                    }
                }
            });
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding3 = this.itemContainers[i16];
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding3, "itemContainers[index]");
            LinearLayout root = vasSquareFloatSettingItemBinding3.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "itemContainers[index].root");
            root.setTag(Integer.valueOf(floatItemConfig.getItemType()));
            i3++;
            i16 = i17;
        }
    }

    private final void updateItemsRule(FloatItemConfig[] itemArray) {
        int length = itemArray.length;
        if (length == 1) {
            setWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(this.context, 58));
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding = this.binding.settingFirstItem;
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding, "binding.settingFirstItem");
            LinearLayout root = vasSquareFloatSettingItemBinding.getRoot();
            ViewExtensionsKt.updateLayoutParams(root, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RelativeLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.addRule(14);
                    receiver.topMargin = 0;
                }
            });
            root.setVisibility(0);
            return;
        }
        if (length == 2) {
            setWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(this.context, 160));
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding2 = this.binding.settingFirstItem;
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding2, "binding.settingFirstItem");
            final LinearLayout root2 = vasSquareFloatSettingItemBinding2.getRoot();
            ViewExtensionsKt.updateLayoutParams(root2, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$2$1
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
                    receiver.topMargin = 0;
                    receiver.setMarginStart(com.tencent.state.square.common.ViewExtensionsKt.dip(root2.getContext(), 12));
                }
            });
            root2.setVisibility(0);
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding3 = this.binding.settingSecondItem;
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding3, "binding.settingSecondItem");
            final LinearLayout root3 = vasSquareFloatSettingItemBinding3.getRoot();
            ViewExtensionsKt.updateLayoutParams(root3, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$3$1
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
                    receiver.addRule(21);
                    receiver.topMargin = 0;
                    receiver.setMarginEnd(com.tencent.state.square.common.ViewExtensionsKt.dip(root3.getContext(), 12));
                }
            });
            root3.setVisibility(0);
            return;
        }
        if (length == 3) {
            setWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(this.context, 160));
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding4 = this.binding.settingFirstItem;
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding4, "binding.settingFirstItem");
            final LinearLayout root4 = vasSquareFloatSettingItemBinding4.getRoot();
            ViewExtensionsKt.updateLayoutParams(root4, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$4$1
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
                    receiver.topMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(root4.getContext(), 39);
                    receiver.setMarginStart(0);
                }
            });
            root4.setVisibility(0);
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding5 = this.binding.settingSecondItem;
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding5, "binding.settingSecondItem");
            LinearLayout root5 = vasSquareFloatSettingItemBinding5.getRoot();
            ViewExtensionsKt.updateLayoutParams(root5, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$5$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RelativeLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.addRule(14);
                    receiver.topMargin = 0;
                }
            });
            root5.setVisibility(0);
            VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding6 = this.binding.settingThirdItem;
            Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding6, "binding.settingThirdItem");
            final LinearLayout root6 = vasSquareFloatSettingItemBinding6.getRoot();
            ViewExtensionsKt.updateLayoutParams(root6, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$6$1
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
                    receiver.addRule(21);
                    receiver.topMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(root6.getContext(), 39);
                }
            });
            root6.setVisibility(0);
            return;
        }
        if (length != 4) {
            return;
        }
        setWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(this.context, 189));
        VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding7 = this.binding.settingFirstItem;
        Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding7, "binding.settingFirstItem");
        final LinearLayout root7 = vasSquareFloatSettingItemBinding7.getRoot();
        ViewExtensionsKt.updateLayoutParams(root7, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$7$1
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
                receiver.topMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(root7.getContext(), 58);
            }
        });
        root7.setVisibility(0);
        VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding8 = this.binding.settingSecondItem;
        Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding8, "binding.settingSecondItem");
        final LinearLayout root8 = vasSquareFloatSettingItemBinding8.getRoot();
        ViewExtensionsKt.updateLayoutParams(root8, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$8$1
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
                receiver.setMarginStart(com.tencent.state.square.common.ViewExtensionsKt.dip(root8.getContext(), 29));
            }
        });
        root8.setVisibility(0);
        VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding9 = this.binding.settingThirdItem;
        Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding9, "binding.settingThirdItem");
        final LinearLayout root9 = vasSquareFloatSettingItemBinding9.getRoot();
        ViewExtensionsKt.updateLayoutParams(root9, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$$inlined$apply$lambda$1
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
                VasSquareFriendSetWindowBinding vasSquareFriendSetWindowBinding;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                vasSquareFriendSetWindowBinding = this.binding;
                VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding10 = vasSquareFriendSetWindowBinding.settingSecondItem;
                Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding10, "binding.settingSecondItem");
                LinearLayout root10 = vasSquareFloatSettingItemBinding10.getRoot();
                Intrinsics.checkNotNullExpressionValue(root10, "binding.settingSecondItem.root");
                receiver.addRule(17, root10.getId());
                receiver.setMarginStart(com.tencent.state.square.common.ViewExtensionsKt.dip(root9.getContext(), 10));
            }
        });
        root9.setVisibility(0);
        VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding10 = this.binding.settingForthItem;
        Intrinsics.checkNotNullExpressionValue(vasSquareFloatSettingItemBinding10, "binding.settingForthItem");
        final LinearLayout root10 = vasSquareFloatSettingItemBinding10.getRoot();
        ViewExtensionsKt.updateLayoutParams(root10, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.friendsetting.SquareSettingWindow$updateItemsRule$10$1
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
                receiver.addRule(21);
                receiver.topMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(root10.getContext(), 58);
            }
        });
        root10.setVisibility(0);
    }

    public final Function1<Integer, Unit> getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(Function1<? super Integer, Unit> function1) {
        this.clickListener = function1;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View parent, int gravity, int x16, int y16) {
        super.showAtLocation(parent, gravity, x16, y16);
        this.showTime = System.currentTimeMillis();
    }

    public final void updateItem(FloatItemConfig[] itemArray) {
        Intrinsics.checkNotNullParameter(itemArray, "itemArray");
        resetItems();
        updateItems(itemArray);
        updateItemsRule(itemArray);
    }

    public final void updateItemAlpha(int itemType, float alpha) {
        VasSquareFloatSettingItemBinding it;
        VasSquareFloatSettingItemBinding[] vasSquareFloatSettingItemBindingArr = this.itemContainers;
        int length = vasSquareFloatSettingItemBindingArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                it = null;
                break;
            }
            it = vasSquareFloatSettingItemBindingArr[i3];
            Intrinsics.checkNotNullExpressionValue(it, "it");
            LinearLayout root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            if (Intrinsics.areEqual(root.getTag(), Integer.valueOf(itemType))) {
                break;
            } else {
                i3++;
            }
        }
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "itemContainers.find { it\u2026g == itemType } ?: return");
            LinearLayout root2 = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "item.root");
            root2.setAlpha(alpha);
        }
    }

    public final void updateItemBackground(int itemType, int bgResId) {
        VasSquareFloatSettingItemBinding it;
        VasSquareFloatSettingItemBinding[] vasSquareFloatSettingItemBindingArr = this.itemContainers;
        int length = vasSquareFloatSettingItemBindingArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                it = null;
                break;
            }
            it = vasSquareFloatSettingItemBindingArr[i3];
            Intrinsics.checkNotNullExpressionValue(it, "it");
            LinearLayout root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            if (Intrinsics.areEqual(root.getTag(), Integer.valueOf(itemType))) {
                break;
            } else {
                i3++;
            }
        }
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "itemContainers.find { it\u2026g == itemType } ?: return");
            it.getRoot().setBackgroundResource(bgResId);
        }
    }

    public final void updateItemIcon(int itemType, int iconResId) {
        VasSquareFloatSettingItemBinding it;
        VasSquareFloatSettingItemBinding[] vasSquareFloatSettingItemBindingArr = this.itemContainers;
        int length = vasSquareFloatSettingItemBindingArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                it = null;
                break;
            }
            it = vasSquareFloatSettingItemBindingArr[i3];
            Intrinsics.checkNotNullExpressionValue(it, "it");
            LinearLayout root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            if (Intrinsics.areEqual(root.getTag(), Integer.valueOf(itemType))) {
                break;
            } else {
                i3++;
            }
        }
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "itemContainers.find { it\u2026g == itemType } ?: return");
            it.squareSettingIcon.setImageResource(iconResId);
        }
    }

    public final void updateItemText(int itemType, String text) {
        VasSquareFloatSettingItemBinding it;
        Intrinsics.checkNotNullParameter(text, "text");
        VasSquareFloatSettingItemBinding[] vasSquareFloatSettingItemBindingArr = this.itemContainers;
        int length = vasSquareFloatSettingItemBindingArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                it = null;
                break;
            }
            it = vasSquareFloatSettingItemBindingArr[i3];
            Intrinsics.checkNotNullExpressionValue(it, "it");
            LinearLayout root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            if (Intrinsics.areEqual(root.getTag(), Integer.valueOf(itemType))) {
                break;
            } else {
                i3++;
            }
        }
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "itemContainers.find { it\u2026g == itemType } ?: return");
            TextView textView = it.squareSettingText;
            Intrinsics.checkNotNullExpressionValue(textView, "item.squareSettingText");
            textView.setText(text);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemConfig;", "", "iconResId", "", "text", "Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemTextStyle;", "backgroundResId", "itemType", "(ILcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemTextStyle;II)V", "getBackgroundResId", "()I", "getIconResId", "getItemType", "getText", "()Lcom/tencent/state/square/friendsetting/SquareSettingWindow$FloatItemTextStyle;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class FloatItemConfig {
        private final int backgroundResId;
        private final int iconResId;
        private final int itemType;
        private final FloatItemTextStyle text;

        public FloatItemConfig(int i3, FloatItemTextStyle text, int i16, int i17) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.iconResId = i3;
            this.text = text;
            this.backgroundResId = i16;
            this.itemType = i17;
        }

        /* renamed from: component1, reason: from getter */
        public final int getIconResId() {
            return this.iconResId;
        }

        /* renamed from: component2, reason: from getter */
        public final FloatItemTextStyle getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final int getBackgroundResId() {
            return this.backgroundResId;
        }

        /* renamed from: component4, reason: from getter */
        public final int getItemType() {
            return this.itemType;
        }

        public final FloatItemConfig copy(int iconResId, FloatItemTextStyle text, int backgroundResId, int itemType) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new FloatItemConfig(iconResId, text, backgroundResId, itemType);
        }

        public final int getBackgroundResId() {
            return this.backgroundResId;
        }

        public final int getIconResId() {
            return this.iconResId;
        }

        public final int getItemType() {
            return this.itemType;
        }

        public final FloatItemTextStyle getText() {
            return this.text;
        }

        public int hashCode() {
            int i3 = this.iconResId * 31;
            FloatItemTextStyle floatItemTextStyle = this.text;
            return ((((i3 + (floatItemTextStyle != null ? floatItemTextStyle.hashCode() : 0)) * 31) + this.backgroundResId) * 31) + this.itemType;
        }

        public String toString() {
            return "FloatItemConfig(iconResId=" + this.iconResId + ", text=" + this.text + ", backgroundResId=" + this.backgroundResId + ", itemType=" + this.itemType + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FloatItemConfig)) {
                return false;
            }
            FloatItemConfig floatItemConfig = (FloatItemConfig) other;
            return this.iconResId == floatItemConfig.iconResId && Intrinsics.areEqual(this.text, floatItemConfig.text) && this.backgroundResId == floatItemConfig.backgroundResId && this.itemType == floatItemConfig.itemType;
        }

        public static /* synthetic */ FloatItemConfig copy$default(FloatItemConfig floatItemConfig, int i3, FloatItemTextStyle floatItemTextStyle, int i16, int i17, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i3 = floatItemConfig.iconResId;
            }
            if ((i18 & 2) != 0) {
                floatItemTextStyle = floatItemConfig.text;
            }
            if ((i18 & 4) != 0) {
                i16 = floatItemConfig.backgroundResId;
            }
            if ((i18 & 8) != 0) {
                i17 = floatItemConfig.itemType;
            }
            return floatItemConfig.copy(i3, floatItemTextStyle, i16, i17);
        }
    }
}

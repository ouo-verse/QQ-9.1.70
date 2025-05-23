package com.tencent.state.library.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareToastPopupWindowBinding;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0010J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0017\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/library/view/ToastPopupWindow;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "position", "Lcom/tencent/state/library/view/ToastPopupPosition;", "text", "", "textColor", "", "bgColor", "radius", "lifeTime", "", "reportElementId", "reportPageId", "(Landroid/content/Context;Lcom/tencent/state/library/view/ToastPopupPosition;Ljava/lang/String;IIIJLjava/lang/String;Ljava/lang/String;)V", "arrowSize", "binding", "Lcom/tencent/state/square/databinding/VasSquareToastPopupWindowBinding;", "showAsDropDown", "", "anchor", "Landroid/view/View;", "updateBubbleBg", "offset", "(Ljava/lang/Integer;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class ToastPopupWindow extends PopupWindow {
    private final int arrowSize;
    private final int bgColor;
    private final VasSquareToastPopupWindowBinding binding;
    private final long lifeTime;
    private final ToastPopupPosition position;
    private final int radius;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ToastPopupPosition.values().length];
            $EnumSwitchMapping$0 = iArr;
            ToastPopupPosition toastPopupPosition = ToastPopupPosition.Above;
            iArr[toastPopupPosition.ordinal()] = 1;
            ToastPopupPosition toastPopupPosition2 = ToastPopupPosition.Below;
            iArr[toastPopupPosition2.ordinal()] = 2;
            int[] iArr2 = new int[ToastPopupPosition.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[toastPopupPosition.ordinal()] = 1;
            iArr2[toastPopupPosition2.ordinal()] = 2;
        }
    }

    public /* synthetic */ ToastPopupWindow(Context context, ToastPopupPosition toastPopupPosition, String str, int i3, int i16, int i17, long j3, String str2, String str3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, toastPopupPosition, str, i3, i16, i17, j3, (i18 & 128) != 0 ? null : str2, (i18 & 256) != 0 ? null : str3);
    }

    private final void updateBubbleBg(Integer offset) {
        this.binding.textView.setBackground(new ToastPopupBgDrawable(this.bgColor, this.radius, this.position, offset));
    }

    public ToastPopupWindow(Context context, ToastPopupPosition position, String text, int i3, int i16, int i17, long j3, String str, String str2) {
        int i18;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(text, "text");
        this.position = position;
        this.bgColor = i16;
        this.radius = i17;
        this.lifeTime = j3;
        VasSquareToastPopupWindowBinding inflate = VasSquareToastPopupWindowBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareToastPopupWindo\u2026utInflater.from(context))");
        this.binding = inflate;
        int dip = ViewExtensionsKt.dip(context, 6);
        this.arrowSize = dip;
        setOutsideTouchable(true);
        setFocusable(true);
        TextView textView = inflate.textView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i19 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        if (i19 == 1) {
            i18 = 48;
        } else {
            if (i19 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i18 = 80;
        }
        layoutParams.gravity = i18;
        Unit unit = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(i3);
        textView.setText(text);
        TextView textView2 = inflate.textView;
        SquareUtil squareUtil = SquareUtil.INSTANCE;
        textView2.measure(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null));
        TextView textView3 = inflate.textView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.textView");
        setWidth(textView3.getMeasuredWidth());
        TextView textView4 = inflate.textView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.textView");
        setHeight(textView4.getMeasuredHeight() + dip);
        setContentView(inflate.getRoot());
        if (str2 != null) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            FrameLayout root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            FrameLayout root2 = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            squareReporter.setPageInfo(root, root2, str2, new LinkedHashMap());
        }
        if (str != null) {
            IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
            TextView textView5 = inflate.textView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.textView");
            squareReporter2.setElementInfo(textView5, str, new LinkedHashMap(), false, false);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(final View anchor) {
        int dip;
        if (anchor != null) {
            int[] iArr = new int[2];
            anchor.getLocationInWindow(iArr);
            View contentView = getContentView();
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            Integer num = null;
            contentView.measure(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null));
            int measuredWidth = (anchor.getMeasuredWidth() - getWidth()) / 2;
            if ((iArr[0] + anchor.getMeasuredWidth()) - measuredWidth > SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null)) {
                int screenWidth$default = SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null) - getWidth();
                View contentView2 = getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView2, "contentView");
                measuredWidth = (screenWidth$default - com.tencent.state.ViewExtensionsKt.dip(contentView2, 10)) - iArr[0];
                num = Integer.valueOf((-measuredWidth) + (anchor.getMeasuredWidth() / 2));
            }
            int i3 = WhenMappings.$EnumSwitchMapping$1[this.position.ordinal()];
            if (i3 == 1) {
                int height = (-anchor.getMeasuredHeight()) - getHeight();
                View contentView3 = getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView3, "contentView");
                dip = height - com.tencent.state.ViewExtensionsKt.dip(contentView3, 10);
            } else if (i3 == 2) {
                View contentView4 = getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView4, "contentView");
                dip = com.tencent.state.ViewExtensionsKt.dip(contentView4, 10);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            updateBubbleBg(num);
            showAsDropDown(anchor, measuredWidth, dip);
            if (this.lifeTime > 0) {
                SquareBaseKt.getSquareThread().postOnUiDelayed(this.lifeTime, new Function0<Unit>() { // from class: com.tencent.state.library.view.ToastPopupWindow$showAsDropDown$$inlined$let$lambda$1
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
                        ToastPopupWindow.this.dismiss();
                    }
                });
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            squareReporter.reportEvent("imp", textView, new LinkedHashMap());
        }
    }
}

package com.tencent.state.library.focus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareLibraryTitleContainerBinding;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/library/focus/view/LibraryTitleContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryTitleContainerBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareLibraryTitleContainerBinding;", "clickListener", "Lkotlin/Function1;", "Lcom/tencent/state/library/focus/view/ClickType;", "Lkotlin/ParameterName;", "name", "type", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "setTitle", "title", "", "updateTypeView", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "isVisible", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryTitleContainer extends FrameLayout {
    private final VasSquareLibraryTitleContainerBinding binding;
    private Function1<? super ClickType, Unit> clickListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClickType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ClickType.CALENDAR.ordinal()] = 1;
            iArr[ClickType.MSG_BOX.ordinal()] = 2;
            iArr[ClickType.END_FOCUS.ordinal()] = 3;
        }
    }

    public LibraryTitleContainer(Context context) {
        this(context, null, 0, 6, null);
    }

    public final VasSquareLibraryTitleContainerBinding getBinding() {
        return this.binding;
    }

    public final Function1<ClickType, Unit> getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(Function1<? super ClickType, Unit> function1) {
        this.clickListener = function1;
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(title);
    }

    public final void updateTypeView(ClickType clickType, boolean isVisible) {
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        int i3 = WhenMappings.$EnumSwitchMapping$0[clickType.ordinal()];
        if (i3 == 1) {
            RelativeLayout relativeLayout = this.binding.calendar;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.calendar");
            relativeLayout.setVisibility(isVisible ? 0 : 8);
        } else if (i3 == 2) {
            FrameLayout frameLayout = this.binding.btnMsgBox;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.btnMsgBox");
            frameLayout.setVisibility(isVisible ? 0 : 8);
        } else {
            if (i3 != 3) {
                return;
            }
            SquareImageView squareImageView = this.binding.endFocus;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.endFocus");
            squareImageView.setVisibility(isVisible ? 0 : 8);
        }
    }

    public LibraryTitleContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LibraryTitleContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryTitleContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareLibraryTitleContainerBinding inflate = VasSquareLibraryTitleContainerBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryTitleCon\u2026ater.from(context), this)");
        this.binding = inflate;
        inflate.calendar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryTitleContainer.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1<ClickType, Unit> clickListener = LibraryTitleContainer.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(ClickType.CALENDAR);
                }
            }
        });
        inflate.back.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryTitleContainer.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1<ClickType, Unit> clickListener = LibraryTitleContainer.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(ClickType.BACK);
                }
            }
        });
        inflate.endFocus.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryTitleContainer.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareBaseKt.getSquareLog().d("LibraryTitleContainer", "on end focus button clicked");
                Function1<ClickType, Unit> clickListener = LibraryTitleContainer.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(ClickType.END_FOCUS);
                }
            }
        });
        inflate.title.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.LibraryTitleContainer.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1<ClickType, Unit> clickListener = LibraryTitleContainer.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(ClickType.TITLE);
                }
            }
        });
    }
}

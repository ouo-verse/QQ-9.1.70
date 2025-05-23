package com.tencent.state.square.interaction.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.interaction.InteractionSettingOption;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.utils.ViewUtils;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020\u000fH\u0002J-\u0010!\u001a\u00020\u000f2%\u0010\"\u001a!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u0010J-\u0010#\u001a\u00020\u000f2%\u0010\"\u001a!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u0010J-\u0010$\u001a\u00020\u000f2%\u0010\"\u001a!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u0010J\u0006\u0010%\u001a\u00020\u000fJ\u0016\u0010&\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0(H\u0002J\"\u0010)\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R1\u0010\t\u001a%\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\u0016\u001a%\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/square/interaction/widget/InteractionOptionItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "changeBtnView", "Landroid/widget/ImageView;", "changeOptionCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "Lcom/tencent/state/square/interaction/widget/CallbackFunc;", "clickOptionCallback", "closeBtnView", "coverView", "data", "Lcom/tencent/state/square/interaction/InteractionSettingOption;", "deleteOptionCallback", "emptyView", "Landroid/view/ViewGroup;", "isHideDelete", "", "preView", "Landroid/widget/TextView;", "selectedView", "selectedViewContainer", "titleView", "initReport", "onChangeOption", "cb", "onClickOption", "onDeleteOption", "reportDestroy", "showReportDelay", "callback", "Lkotlin/Function0;", "updateData", "option", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionOptionItem extends LinearLayout {
    private static final int CLOSE_BTN_EXPAND_CLICK_SIZE = 16;
    private final ImageView changeBtnView;
    private Function1<? super Integer, Unit> changeOptionCallback;
    private Function1<? super Integer, Unit> clickOptionCallback;
    private final ImageView closeBtnView;
    private final ImageView coverView;
    private InteractionSettingOption data;
    private Function1<? super Integer, Unit> deleteOptionCallback;
    private final ViewGroup emptyView;
    private int index;
    private boolean isHideDelete;
    private final TextView preView;
    private final ViewGroup selectedView;
    private final ViewGroup selectedViewContainer;
    private final TextView titleView;

    public /* synthetic */ InteractionOptionItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final void initReport() {
        SquareBaseKt.getSquareReporter().setElementInfo(this, SquareReportConst.ElementId.ELEMENT_ID_HUDONG_PROPS_EDIT, new LinkedHashMap(), false, false);
        SquareBaseKt.getSquareReporter().setElementInfo(this.closeBtnView, SquareReportConst.ElementId.ELEMENT_ID_HUDONG_PROPS_DELETE, new LinkedHashMap(), false, false);
        showReportDelay(new Function0<Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionItem$initReport$1
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
                SquareBaseKt.getSquareReporter().reportEvent("imp", InteractionOptionItem.this, new LinkedHashMap());
            }
        });
    }

    private final void showReportDelay(final Function0<Unit> callback) {
        SquareBaseKt.getSquareThread().postOnUiDelayed(0L, new Function0<Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionItem$showReportDelay$1
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
                Function0.this.invoke();
            }
        });
    }

    public final void onChangeOption(Function1<? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.changeOptionCallback = cb5;
    }

    public final void onClickOption(Function1<? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.clickOptionCallback = cb5;
    }

    public final void onDeleteOption(Function1<? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.deleteOptionCallback = cb5;
    }

    public final void reportDestroy() {
        if (!this.isHideDelete && this.closeBtnView.getVisibility() == 0) {
            SquareBaseKt.getSquareReporter().reportEvent("imp_end", this.closeBtnView, new LinkedHashMap());
        }
        SquareBaseKt.getSquareReporter().reportEvent("imp_end", this, new LinkedHashMap());
    }

    public final void updateData(int index, InteractionSettingOption option, boolean isHideDelete) {
        this.index = index;
        this.data = option;
        this.isHideDelete = isHideDelete;
        if (option == null) {
            this.selectedViewContainer.setVisibility(8);
            return;
        }
        this.selectedViewContainer.setVisibility(0);
        if (isHideDelete && this.closeBtnView.getVisibility() == 0) {
            this.closeBtnView.setVisibility(8);
            SquareBaseKt.getSquareReporter().reportEvent("imp_end", this.closeBtnView, new LinkedHashMap());
        }
        if (!isHideDelete && this.closeBtnView.getVisibility() == 8) {
            this.closeBtnView.setVisibility(0);
            showReportDelay(new Function0<Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionItem$updateData$1
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
                    ImageView imageView;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    imageView = InteractionOptionItem.this.closeBtnView;
                    squareReporter.reportEvent("imp", imageView, new LinkedHashMap());
                }
            });
        }
        this.changeBtnView.setVisibility(index != 0 ? 0 : 8);
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, option.getOptionIcon(), false, 2, null)) {
            this.coverView.setImageDrawable(URLDrawable.getDrawable(option.getOptionIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
        }
        this.preView.setText(String.valueOf(index + 1));
        this.titleView.setText(option.getFixedText() + option.getCustomText());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionOptionItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.f167405d50, this);
        View findViewById = findViewById(R.id.qk5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.selectedViewContainer)");
        this.selectedViewContainer = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.prg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.emptyView)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.emptyView = viewGroup;
        View findViewById3 = findViewById(R.id.f163521qk4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.selectedView)");
        ViewGroup viewGroup2 = (ViewGroup) findViewById3;
        this.selectedView = viewGroup2;
        View findViewById4 = findViewById(R.id.qdg);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.preView)");
        this.preView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.qrk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.titleView)");
        this.titleView = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.pmu);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.coverView)");
        this.coverView = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.pk5);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.closeBtnView)");
        ImageView imageView = (ImageView) findViewById7;
        this.closeBtnView = imageView;
        View findViewById8 = findViewById(R.id.pix);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.changeBtnView)");
        ImageView imageView2 = (ImageView) findViewById8;
        this.changeBtnView = imageView2;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int i3 = (int) (16 * resources.getDisplayMetrics().density);
        ViewUtils.INSTANCE.expendTouchArea(imageView, i3, (r12 & 4) != 0 ? i3 : i3, (r12 & 8) != 0 ? i3 : 0, (r12 & 16) != 0 ? i3 : 0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionItem.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                if (InteractionOptionItem.this.deleteOptionCallback == null) {
                    return;
                }
                Function1 function1 = InteractionOptionItem.this.deleteOptionCallback;
                if (function1 != null) {
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionItem.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1 function1;
                if (InteractionOptionItem.this.changeOptionCallback == null || (function1 = InteractionOptionItem.this.changeOptionCallback) == null) {
                    return;
                }
            }
        });
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionItem.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                if (InteractionOptionItem.this.clickOptionCallback == null) {
                    return;
                }
                Function1 function1 = InteractionOptionItem.this.clickOptionCallback;
                if (function1 != null) {
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
            }
        });
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionItem.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                if (InteractionOptionItem.this.clickOptionCallback == null) {
                    return;
                }
                Function1 function1 = InteractionOptionItem.this.clickOptionCallback;
                if (function1 != null) {
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
            }
        });
        initReport();
    }
}

package com.tencent.state.library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareLibraryCalendarGuideContentBinding;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/library/view/LibraryCalendarGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "focusRect", "Landroid/graphics/Rect;", "onConfirm", "Lkotlin/Function1;", "", "onCancel", "(Landroid/content/Context;Landroid/graphics/Rect;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryCalendarGuideContentBinding;", "paint", "Landroid/graphics/Paint;", "dispatchDraw", PM.CANVAS, "Landroid/graphics/Canvas;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryCalendarGuideView extends RelativeLayout {
    public static final String ARROW_URL = "https://vat-zplan-1251316161.file.myqcloud.com/library/focus_calendar_guide_arrow.png";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String MOTION_URL = "https://vat-zplan-1251316161.file.myqcloud.com/library/focus_calendar_guide_action.png";
    public static final String TAG = "LibraryCalendarGuideView";
    private VasSquareLibraryCalendarGuideContentBinding binding;
    private Rect focusRect;
    private Paint paint;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/library/view/LibraryCalendarGuideView$Companion;", "", "()V", "ARROW_URL", "", "MOTION_URL", "TAG", "showAtView", "", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", "focusRect", "Landroid/graphics/Rect;", "onConfirm", "Lkotlin/Function0;", "onCancel", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        public final void showAtView(final ViewGroup container, Rect focusRect, final Function0<Unit> onConfirm, final Function0<Unit> onCancel) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(focusRect, "focusRect");
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
            Context context = container.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "container.context");
            LibraryCalendarGuideView libraryCalendarGuideView = new LibraryCalendarGuideView(context, focusRect, new Function1<LibraryCalendarGuideView, Unit>() { // from class: com.tencent.state.library.view.LibraryCalendarGuideView$Companion$showAtView$guideView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LibraryCalendarGuideView libraryCalendarGuideView2) {
                    invoke2(libraryCalendarGuideView2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LibraryCalendarGuideView it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    container.removeView(it);
                    onConfirm.invoke();
                }
            }, new Function1<LibraryCalendarGuideView, Unit>() { // from class: com.tencent.state.library.view.LibraryCalendarGuideView$Companion$showAtView$guideView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LibraryCalendarGuideView libraryCalendarGuideView2) {
                    invoke2(libraryCalendarGuideView2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LibraryCalendarGuideView it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    container.removeView(it);
                    onCancel.invoke();
                }
            });
            container.addView(libraryCalendarGuideView, -1, -1);
            libraryCalendarGuideView.setTag(LibraryCalendarGuideView.TAG);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryCalendarGuideView(Context context, Rect focusRect, final Function1<? super LibraryCalendarGuideView, Unit> onConfirm, final Function1<? super LibraryCalendarGuideView, Unit> onCancel) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(focusRect, "focusRect");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        VasSquareLibraryCalendarGuideContentBinding inflate = VasSquareLibraryCalendarGuideContentBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryCalendar\u2026 this,\n        true\n    )");
        this.binding = inflate;
        SquareImageView squareImageView = inflate.calendarGuideMotionImage;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.calendarGuideMotionImage");
        ViewExtensionsKt.setUri(squareImageView, MOTION_URL);
        SquareImageView squareImageView2 = this.binding.calendarGuideArrowImage;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.calendarGuideArrowImage");
        ViewExtensionsKt.setUri(squareImageView2, ARROW_URL);
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.view.LibraryCalendarGuideView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onCancel.invoke(LibraryCalendarGuideView.this);
            }
        });
        this.binding.calendarGuideFocusView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.view.LibraryCalendarGuideView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onConfirm.invoke(LibraryCalendarGuideView.this);
            }
        });
        this.focusRect = new Rect(focusRect.centerX() - com.tencent.state.square.common.ViewExtensionsKt.dip(context, 36), focusRect.centerY() - com.tencent.state.square.common.ViewExtensionsKt.dip(context, 36), focusRect.centerX() + com.tencent.state.square.common.ViewExtensionsKt.dip(context, 36), focusRect.centerY() + com.tencent.state.square.common.ViewExtensionsKt.dip(context, 36));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.focusRect.width(), this.focusRect.height());
        Rect rect = this.focusRect;
        layoutParams.topMargin = rect.top;
        layoutParams.leftMargin = rect.left;
        View view = this.binding.calendarGuideFocusView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.calendarGuideFocusView");
        view.setLayoutParams(layoutParams);
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (canvas != null) {
            int color = ContextCompat.getColor(getContext(), R.color.f81163);
            canvas.drawColor(color);
            if (this.paint == null) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setShader(new RadialGradient(this.focusRect.centerX(), this.focusRect.centerY(), this.focusRect.width() / 2, new int[]{0, 0, color}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.MIRROR));
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                Unit unit = Unit.INSTANCE;
                this.paint = paint;
            }
            Paint paint2 = this.paint;
            if (paint2 != null) {
                canvas.drawCircle(this.focusRect.centerX(), this.focusRect.centerY(), this.focusRect.width() / 2, paint2);
            }
        }
        super.dispatchDraw(canvas);
    }
}

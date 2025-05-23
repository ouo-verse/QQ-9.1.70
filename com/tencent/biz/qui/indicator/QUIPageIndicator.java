package com.tencent.biz.qui.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xd0.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002Z[B'\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u00020\u0002\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010*\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010.R\u0016\u00101\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u001e\u00104\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00188\u0002@BX\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0019R$\u00106\u001a\u00020-2\u0006\u00105\u001a\u00020-8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R$\u0010B\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R$\u0010E\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>R$\u0010H\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR$\u0010Q\u001a\u00020-2\u0006\u0010P\u001a\u00020-8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bQ\u00107\"\u0004\bR\u00109\u00a8\u0006\\"}, d2 = {"Lcom/tencent/biz/qui/indicator/QUIPageIndicator;", "Landroid/view/View;", "", "measureSpec", "f", "g", "padding", "", "setCirclePadding", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroidx/recyclerview/widget/RecyclerView;", "view", "d", "recyclerView", "e", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "onSaveInstanceState", "", UserInfo.SEX_FEMALE, "mRadius", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaintPageFill", "mPaintStroke", h.F, "mPaintFill", "i", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mCurrentPage", BdhLogUtil.LogTag.Tag_Conn, "mSnapPage", "D", "mPageOffset", "E", "mOrientation", "", "Z", "mCentered", "G", "mSnap", "<set-?>", "H", "circlePadding", "centered", "isCentered", "()Z", "setCentered", "(Z)V", "pageColor", "getPageColor", "()I", "setPageColor", "(I)V", "fillColor", "getFillColor", "setFillColor", "orientation", "getOrientation", "setOrientation", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "radius", "getRadius", "setRadius", "snap", "isSnap", "setSnap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "SavedState", "QUIPageIndicator_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUIPageIndicator extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private int mSnapPage;

    /* renamed from: D, reason: from kotlin metadata */
    private final float mPageOffset;

    /* renamed from: E, reason: from kotlin metadata */
    private int mOrientation;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mCentered;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mSnap;

    /* renamed from: H, reason: from kotlin metadata */
    private float circlePadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Paint mPaintPageFill;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Paint mPaintStroke;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Paint mPaintFill;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCurrentPage;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\rB\u0013\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qui/indicator/QUIPageIndicator$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "dest", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "I", "a", "()I", "b", "(I)V", "currentPage", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "in", "(Landroid/os/Parcel;)V", "e", "QUIPageIndicator_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class SavedState extends View.BaseSavedState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int currentPage;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qui/indicator/QUIPageIndicator$SavedState$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/qui/indicator/QUIPageIndicator$SavedState;", "Landroid/os/Parcel;", "in", "a", "", "size", "", "b", "(I)[Lcom/tencent/biz/qui/indicator/QUIPageIndicator$SavedState;", "QUIPageIndicator_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes5.dex */
        public static final class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NotNull Parcel in5) {
                Intrinsics.checkNotNullParameter(in5, "in");
                return new SavedState(in5, null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        /* renamed from: a, reason: from getter */
        public final int getCurrentPage() {
            return this.currentPage;
        }

        public final void b(int i3) {
            this.currentPage = i3;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPage);
        }

        public SavedState(@Nullable Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.currentPage = parcel.readInt();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qui/indicator/QUIPageIndicator$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "QUIPageIndicator_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (QUIPageIndicator.this.mSnap || newState == 0) {
                int e16 = QUIPageIndicator.this.e(recyclerView);
                QUIPageIndicator.this.mCurrentPage = e16;
                QUIPageIndicator.this.mSnapPage = e16;
                QUIPageIndicator.this.postInvalidate();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
        }
    }

    @JvmOverloads
    public QUIPageIndicator(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    private final int f(int measureSpec) {
        RecyclerView recyclerView;
        int i3;
        int coerceAtMost;
        RecyclerView.Adapter adapter;
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode != 1073741824 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float f16 = this.mRadius;
            int i16 = (int) (paddingLeft + (i3 * 2 * f16) + ((i3 - 1) * f16) + 1);
            if (mode == Integer.MIN_VALUE) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i16, size);
                return coerceAtMost;
            }
            return i16;
        }
        return size;
    }

    private final int g(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode != 1073741824) {
            int paddingTop = (int) ((2 * this.mRadius) + getPaddingTop() + getPaddingBottom() + 1);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(paddingTop, size);
            }
            return paddingTop;
        }
        return size;
    }

    public final void d(@NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mRecyclerView == view && e(view) == this.mCurrentPage) {
            return;
        }
        this.mRecyclerView = view;
        if (view.getAdapter() != null) {
            view.addOnScrollListener(new b());
            invalidate();
        }
    }

    public final int e(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition > 0) {
                return findFirstCompletelyVisibleItemPosition;
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            return findFirstVisibleItemPosition + ((linearLayoutManager.findLastVisibleItemPosition() - findFirstVisibleItemPosition) / 2);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        int i3;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        int i16;
        float f16;
        float f17;
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 == 0 || this.mCurrentPage >= i3) {
            return;
        }
        if (this.mOrientation == 0) {
            height = getWidth();
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
            paddingLeft = getPaddingTop();
        } else {
            height = getHeight();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            paddingLeft = getPaddingLeft();
        }
        float f18 = this.mRadius;
        float f19 = 2 * f18;
        float f26 = this.circlePadding;
        if (f26 == 0.0f) {
            f26 = f18;
        }
        float f27 = f19 + f26;
        float f28 = paddingLeft + f18;
        float f29 = paddingTop + f18;
        if (this.mCentered) {
            f29 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((i3 * f27) / 2.0f);
        }
        if (this.mPaintStroke.getStrokeWidth() > 0) {
            f18 -= this.mPaintStroke.getStrokeWidth() / 2.0f;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            float f36 = (i17 * f27) + f29;
            if (this.mOrientation == 0) {
                f17 = f28;
            } else {
                f17 = f36;
                f36 = f28;
            }
            if (this.mPaintPageFill.getAlpha() > 0) {
                canvas.drawCircle(f36, f17, f18, this.mPaintPageFill);
            }
            float f37 = this.mRadius;
            if (f18 != f37) {
                canvas.drawCircle(f36, f17, f37, this.mPaintStroke);
            }
        }
        boolean z16 = this.mSnap;
        if (z16) {
            i16 = this.mSnapPage;
        } else {
            i16 = this.mCurrentPage;
        }
        float f38 = i16 * f27;
        if (!z16) {
            f38 += this.mPageOffset * f27;
        }
        if (this.mOrientation == 0) {
            float f39 = f29 + f38;
            f16 = f28;
            f28 = f39;
        } else {
            f16 = f29 + f38;
        }
        canvas.drawCircle(f28, f16, this.mRadius, this.mPaintFill);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mOrientation == 0) {
            setMeasuredDimension(f(widthMeasureSpec), g(heightMeasureSpec));
        } else {
            setMeasuredDimension(g(widthMeasureSpec), f(heightMeasureSpec));
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@NotNull Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentPage = savedState.getCurrentPage();
        this.mSnapPage = savedState.getCurrentPage();
        requestLayout();
    }

    @Override // android.view.View
    @NotNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.b(this.mCurrentPage);
        return savedState;
    }

    public final void setCentered(boolean z16) {
        this.mCentered = z16;
        invalidate();
    }

    public final void setCirclePadding(int padding) {
        this.circlePadding = padding;
    }

    public final void setFillColor(int i3) {
        this.mPaintFill.setColor(i3);
        invalidate();
    }

    public final void setOrientation(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.mOrientation = i3;
        requestLayout();
    }

    public final void setPageColor(int i3) {
        this.mPaintPageFill.setColor(i3);
        invalidate();
    }

    public final void setRadius(float f16) {
        this.mRadius = f16;
        invalidate();
    }

    public final void setSnap(boolean z16) {
        this.mSnap = z16;
        invalidate();
    }

    public final void setStrokeColor(int i3) {
        this.mPaintStroke.setColor(i3);
        invalidate();
    }

    public final void setStrokeWidth(float f16) {
        this.mPaintStroke.setStrokeWidth(f16);
        invalidate();
    }

    @JvmOverloads
    public QUIPageIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ QUIPageIndicator(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? R.attr.f155281b : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIPageIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        this.mPaintPageFill = paint;
        Paint paint2 = new Paint(1);
        this.mPaintStroke = paint2;
        Paint paint3 = new Paint(1);
        this.mPaintFill = paint3;
        int color = ResourcesCompat.getColor(getResources(), R.color.qui_common_fill_standard_primary, null);
        int color2 = ResourcesCompat.getColor(getResources(), R.color.qui_common_brand_standard, null);
        int color3 = ResourcesCompat.getColor(getResources(), R.color.qui_common_fill_standard_primary, null);
        float dimension = getResources().getDimension(R.dimen.f158651ll);
        float dimension2 = getResources().getDimension(R.dimen.f158650lk);
        float dimension3 = getResources().getDimension(R.dimen.c7w);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f447808q, i3, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026geIndicator, defStyle, 0)");
        this.mCentered = obtainStyledAttributes.getBoolean(a.f447811t, true);
        this.mOrientation = obtainStyledAttributes.getInt(a.f447809r, 0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(obtainStyledAttributes.getColor(a.f447815x, color));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(obtainStyledAttributes.getColor(a.f447817z, color3));
        paint2.setStrokeWidth(obtainStyledAttributes.getDimension(a.A, dimension));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(obtainStyledAttributes.getColor(a.f447814w, color2));
        this.mRadius = obtainStyledAttributes.getDimension(a.f447813v, dimension2);
        this.mSnap = obtainStyledAttributes.getBoolean(a.f447816y, false);
        this.circlePadding = obtainStyledAttributes.getDimension(a.f447812u, dimension3);
        Drawable drawable = obtainStyledAttributes.getDrawable(a.f447810s);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
    }
}

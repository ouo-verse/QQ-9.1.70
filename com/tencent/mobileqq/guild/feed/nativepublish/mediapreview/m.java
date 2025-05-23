package com.tencent.mobileqq.guild.feed.nativepublish.mediapreview;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.util.Property;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0002\r\fB\u0019\u0012\u0006\u0010,\u001a\u00020*\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bE\u0010FJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00020\u0006\"\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J@\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0018\u0010$\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\u0012\u0010(\u001a\u00020\t2\n\u0010'\u001a\u00020\u0006\"\u00020\u0007J\u0010\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010)\u001a\u00020\u0007R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010-R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010/R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00103R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010>\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/m;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroid/view/View;", "view", "", "duration", "", "", "from", "", "e", "", "b", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "target", "onMove", "direction", "onSwiped", "animationType", "animateDx", "animateDy", "getAnimationDuration", "actionState", "onSelectedChanged", "Landroid/graphics/Canvas;", "c", "dX", "dY", "isCurrentlyActive", "onChildDraw", "clearView", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "scale", "d", com.tencent.luggage.wxa.c8.c.f123400v, "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "mAdapter", "Landroid/view/View;", "mDelArea", "Z", "mIsInDelArea", "I", "mDelPos", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mTempHolder", "f", "[F", "mScales", "g", UserInfo.SEX_FEMALE, "mAlpha", tl.h.F, "mInsideScale", "i", "mInsideAlpha", "j", "mMoveScale", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/m$b;", "k", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/m$b;", "mScaleProperty", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;Landroid/view/View;)V", "l", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedPostMediaPreviewAdapter mAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View mDelArea;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInDelArea;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mDelPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.ViewHolder mTempHolder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] mScales;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mAlpha;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float mInsideScale;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float mInsideAlpha;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float mMoveScale;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mScaleProperty;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/m$b;", "Landroid/util/Property;", "Landroid/view/View;", "", "object", "a", "(Landroid/view/View;)Ljava/lang/Float;", "value", "", "b", "", "name", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends Property<View, Float> {
        public b(@Nullable String str) {
            super(Float.TYPE, str);
        }

        @Override // android.util.Property
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NotNull View object) {
            Intrinsics.checkNotNullParameter(object, "object");
            return Float.valueOf(object.getScaleX());
        }

        public void b(@NotNull View object, float value) {
            Intrinsics.checkNotNullParameter(object, "object");
            object.setScaleX(value);
            object.setScaleY(value);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f16) {
            b(view, f16.floatValue());
        }
    }

    public m(@NotNull FeedPostMediaPreviewAdapter mAdapter, @Nullable View view) {
        Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        this.mAdapter = mAdapter;
        this.mDelArea = view;
        this.mDelPos = -1;
        this.mScales = new float[]{1.0f, 0.8f, 1.22f, 1.12f};
        this.mAlpha = 1.0f;
        this.mInsideScale = 0.86f;
        this.mInsideAlpha = 0.3f;
        this.mMoveScale = 1.2f;
        this.mScaleProperty = new b("scale");
    }

    private final void a(View view) {
        Object tag = view.getTag();
        if (tag instanceof ObjectAnimator) {
            ((ObjectAnimator) tag).cancel();
            view.setTag(null);
        }
    }

    private final boolean b(View view) {
        Object tag = view.getTag();
        if ((tag instanceof ObjectAnimator) && ((ObjectAnimator) tag).isRunning()) {
            return true;
        }
        return false;
    }

    private final void e(View view, long duration, float... from) {
        if (view.getTag() instanceof ObjectAnimator) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.mScaleProperty, Arrays.copyOf(from, from.length));
        ofFloat.setDuration(duration);
        ofFloat.start();
        view.setTag(ofFloat);
    }

    public final void c(@FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        this.mAlpha = alpha;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        a(view);
        float[] fArr = this.mScales;
        float f16 = fArr[fArr.length - 1];
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
        e(view2, 200L, f16, 1.0f);
        viewHolder.itemView.setAlpha(1.0f);
        super.clearView(recyclerView, viewHolder);
    }

    public final void d(@NotNull float... scale) {
        boolean z16;
        Intrinsics.checkNotNullParameter(scale, "scale");
        if (scale.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int length = scale.length;
            this.mScales = new float[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.mScales[i3] = scale[i3];
                if (i3 == length - 1) {
                    this.mMoveScale = scale[i3];
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(@NotNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.mIsInDelArea) {
            return 0L;
        }
        return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        int i3;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.mAdapter.e1(viewHolder)) {
            i3 = 12;
        } else {
            i3 = 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i3, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(@NotNull Canvas c16, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        boolean z16;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.mDelArea != null) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            if (!b(view)) {
                int width = this.mDelArea.getWidth();
                int height = this.mDelArea.getHeight();
                int[] iArr = new int[2];
                this.mDelArea.getLocationInWindow(iArr);
                int i3 = iArr[0];
                int i16 = iArr[1];
                int width2 = viewHolder.itemView.getWidth();
                int height2 = viewHolder.itemView.getHeight();
                int[] iArr2 = new int[2];
                viewHolder.itemView.getLocationInWindow(iArr2);
                int i17 = iArr2[0];
                int i18 = iArr2[1];
                float f16 = this.mMoveScale;
                int i19 = i17 + (((int) (width2 * f16)) / 2);
                int i26 = i18 + (((int) (height2 * f16)) / 2);
                if (i26 > i16 && i26 < i16 + height && i19 > i3 && i19 < i3 + width) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 != this.mIsInDelArea && this.mTempHolder != null) {
                    if (z16) {
                        this.mMoveScale = this.mInsideScale;
                        View view2 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
                        a(view2);
                        View view3 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view3, "viewHolder.itemView");
                        float[] fArr = this.mScales;
                        e(view3, 600L, Arrays.copyOf(fArr, fArr.length));
                        viewHolder.itemView.setAlpha(this.mInsideAlpha);
                    } else {
                        float[] fArr2 = this.mScales;
                        this.mMoveScale = fArr2[fArr2.length - 1];
                        View view4 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view4, "viewHolder.itemView");
                        a(view4);
                        View view5 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view5, "viewHolder.itemView");
                        float[] fArr3 = this.mScales;
                        e(view5, 600L, Arrays.copyOf(fArr3, fArr3.length));
                        viewHolder.itemView.setAlpha(this.mAlpha);
                    }
                }
                this.mIsInDelArea = z16;
                super.onChildDraw(c16, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                return;
            }
        }
        super.onChildDraw(c16, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        if (viewHolder.getItemViewType() == target.getItemViewType() && this.mAdapter.e1(target)) {
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            this.mDelPos = adapterPosition2;
            this.mAdapter.j1(adapterPosition, adapterPosition2);
            this.mAdapter.notifyItemMoved(adapterPosition, adapterPosition2);
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        RecyclerView.ViewHolder viewHolder2;
        if (actionState != 0) {
            Intrinsics.checkNotNull(viewHolder);
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder!!.itemView");
            a(view);
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
            float[] fArr = this.mScales;
            e(view2, 400L, Arrays.copyOf(fArr, fArr.length));
            viewHolder.itemView.setAlpha(this.mAlpha);
            this.mDelPos = viewHolder.getAdapterPosition();
            this.mTempHolder = viewHolder;
        } else {
            if (this.mIsInDelArea && this.mDelPos >= 0 && (viewHolder2 = this.mTempHolder) != null) {
                Intrinsics.checkNotNull(viewHolder2);
                viewHolder2.itemView.setVisibility(4);
                this.mAdapter.t1(this.mDelPos);
                this.mIsInDelArea = false;
            }
            this.mDelPos = -1;
            this.mTempHolder = null;
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }
}

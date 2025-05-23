package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0003+,-B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0018\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010 \u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Path;", "e", "Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout$PivotPosition;", "pivotPos", "Lkotlin/Pair;", "", "d", "", "k", "Landroid/view/View;", "hollowOutView", "Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout$b;", "c", "data", "g", "f", "Landroid/graphics/Canvas;", PM.CANVAS, "", "dispatchDraw", "setHollowOutArea", "", "from", tl.h.F, "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "hollowOutPaint", "Landroid/view/View;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout$PivotPosition;", "hollowOutPivotPosition", "Landroid/graphics/Path;", "hollowOutPath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "b", "PivotPosition", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHollowOutFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint hollowOutPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View hollowOutView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PivotPosition hollowOutPivotPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Path hollowOutPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout$PivotPosition;", "", "(Ljava/lang/String;I)V", "RIGHT_TOP", "RIGHT_BOTTOM", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum PivotPosition {
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0016\u001a\u00020\n\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R.\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Pair;", "", "a", "Lkotlin/Pair;", "()Lkotlin/Pair;", "setHollowOutOffset", "(Lkotlin/Pair;)V", "hollowOutOffset", "b", UserInfo.SEX_FEMALE, "()F", "setHollowOutRadius", "(F)V", "hollowOutRadius", "<init>", "(Lkotlin/Pair;F)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Pair<Float, Float> hollowOutOffset;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float hollowOutRadius;

        public b(@NotNull Pair<Float, Float> hollowOutOffset, float f16) {
            Intrinsics.checkNotNullParameter(hollowOutOffset, "hollowOutOffset");
            this.hollowOutOffset = hollowOutOffset;
            this.hollowOutRadius = f16;
        }

        @NotNull
        public final Pair<Float, Float> a() {
            return this.hollowOutOffset;
        }

        /* renamed from: b, reason: from getter */
        public final float getHollowOutRadius() {
            return this.hollowOutRadius;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.hollowOutOffset, bVar.hollowOutOffset) && Float.compare(this.hollowOutRadius, bVar.hollowOutRadius) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.hollowOutOffset.hashCode() * 31) + Float.floatToIntBits(this.hollowOutRadius);
        }

        @NotNull
        public String toString() {
            return "offset:(" + this.hollowOutOffset.getFirst() + "," + this.hollowOutOffset.getSecond() + "),radius:(" + this.hollowOutRadius + ")";
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f224245a;

        static {
            int[] iArr = new int[PivotPosition.values().length];
            try {
                iArr[PivotPosition.RIGHT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PivotPosition.RIGHT_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f224245a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHollowOutFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final b c(View hollowOutView, PivotPosition pivotPos) {
        Pair<Float, Float> k3 = k(com.tencent.mobileqq.qwallet.k.a(hollowOutView));
        Pair<Float, Float> d16 = d(pivotPos);
        b bVar = new b(new Pair(Float.valueOf(k3.getFirst().floatValue() - d16.getFirst().floatValue()), Float.valueOf(k3.getSecond().floatValue() - d16.getSecond().floatValue())), hollowOutView.getWidth() / 2);
        QLog.d("GuildHollowOutFrameLayout", 2, "hollowCenter:(" + k3 + "),containerPivot:(" + d16 + "),hollowData:" + bVar);
        return bVar;
    }

    private final Pair<Float, Float> d(PivotPosition pivotPos) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Pair<Float, Float> k3 = k(iArr);
        int i3 = c.f224245a[pivotPos.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return new Pair<>(Float.valueOf(k3.getFirst().floatValue() + getWidth()), Float.valueOf(k3.getSecond().floatValue() + getHeight()));
            }
            throw new NoWhenBranchMatchedException();
        }
        return new Pair<>(Float.valueOf(k3.getFirst().floatValue() + getWidth()), k3.getSecond());
    }

    private final Path e() {
        View view;
        if (this.hollowOutPath == null && (view = this.hollowOutView) != null) {
            Path f16 = f(this.hollowOutPivotPosition, c(view, this.hollowOutPivotPosition));
            if (f16 != null) {
                this.hollowOutPath = f16;
            }
        }
        return this.hollowOutPath;
    }

    private final Path f(PivotPosition pivotPos, b data) {
        if (data.getHollowOutRadius() <= 0.0f) {
            return null;
        }
        Pair<Float, Float> g16 = g(pivotPos, data);
        float floatValue = g16.component1().floatValue();
        float floatValue2 = g16.component2().floatValue();
        float hollowOutRadius = data.getHollowOutRadius();
        Path path = new Path();
        path.addCircle(floatValue, floatValue2, hollowOutRadius, Path.Direction.CCW);
        return path;
    }

    private final Pair<Float, Float> g(PivotPosition pivotPos, b data) {
        int i3 = c.f224245a[pivotPos.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return new Pair<>(Float.valueOf(getWidth() + data.a().getFirst().floatValue()), Float.valueOf(getHeight() + data.a().getSecond().floatValue()));
            }
            throw new NoWhenBranchMatchedException();
        }
        return new Pair<>(Float.valueOf(getWidth() + data.a().getFirst().floatValue()), data.a().getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildHollowOutFrameLayout this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h("container layout change");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildHollowOutFrameLayout this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h("hollowOutView layout change");
    }

    private final Pair<Float, Float> k(int[] iArr) {
        int length = iArr.length;
        return new Pair<>(Float.valueOf(iArr[0]), Float.valueOf(iArr[1]));
    }

    public static /* synthetic */ void setHollowOutArea$default(GuildHollowOutFrameLayout guildHollowOutFrameLayout, PivotPosition pivotPosition, View view, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            pivotPosition = PivotPosition.RIGHT_TOP;
        }
        guildHollowOutFrameLayout.setHollowOutArea(pivotPosition, view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.hollowOutView != null) {
            canvas.clipRect(0, 0, getWidth(), getHeight());
            super.dispatchDraw(canvas);
            QLog.d("GuildHollowOutFrameLayout", 2, "onDraw hollowOut");
            Path e16 = e();
            if (e16 != null) {
                canvas.drawPath(e16, this.hollowOutPaint);
                return;
            }
            return;
        }
        super.dispatchDraw(canvas);
    }

    public final void h(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.d("GuildHollowOutFrameLayout", 4, "updateHollowPath--from:" + from);
        this.hollowOutPath = null;
    }

    public final void setHollowOutArea(@NotNull PivotPosition pivotPos, @NotNull View hollowOutView) {
        Intrinsics.checkNotNullParameter(pivotPos, "pivotPos");
        Intrinsics.checkNotNullParameter(hollowOutView, "hollowOutView");
        this.hollowOutPivotPosition = pivotPos;
        this.hollowOutView = hollowOutView;
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.widget.o
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildHollowOutFrameLayout.i(GuildHollowOutFrameLayout.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        View view = this.hollowOutView;
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.widget.p
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    GuildHollowOutFrameLayout.j(GuildHollowOutFrameLayout.this, view2, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
        }
        QLog.d("GuildHollowOutFrameLayout", 1, "[setHollowOutArea]--view:" + hollowOutView.hashCode() + ",pivotPos:" + pivotPos);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHollowOutFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHollowOutFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHollowOutFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        this.hollowOutPaint = paint;
        this.hollowOutPivotPosition = PivotPosition.RIGHT_TOP;
        paint.setColor(context.getColor(R.color.qui_common_bg_bottom_light));
        paint.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
    }
}

package com.tencent.timi.game.team.impl.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.customview.widget.ViewDragHelper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.av.utils.ba;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import nr2.aa;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001aB\u0011\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u00a2\u0006\u0004\bY\u0010ZB\u001b\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u00a2\u0006\u0004\bY\u0010]B#\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\u0006\u0010^\u001a\u00020\u0002\u00a2\u0006\u0004\bY\u0010_J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0002H\u0002J\f\u0010 \u001a\u00020\u0002*\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\bH\u0002J&\u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"J\u001e\u0010)\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002J.\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002J\u0016\u0010,\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002J\u0014\u0010/\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0-J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0014J\u0010\u00105\u001a\u00020\u00172\u0006\u00104\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u00172\u0006\u00106\u001a\u000203H\u0016J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\"0-R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010FR\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010FR\u0016\u0010L\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010FR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010N\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\fR\u0014\u0010O\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\fR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010FR\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010FR\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010FR\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010FR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006b"}, d2 = {"Lcom/tencent/timi/game/team/impl/main/LevelSegmentSelectView;", "Landroid/widget/FrameLayout;", "", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "view", "targetPos", "", "D", "releasedChild", "E", UserInfo.SEX_FEMALE, "", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "p", "r", "u", "targetTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "t", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "startPosition", "endPosition", "w", "selectorImg", "position", "G", "o", "H", "", "mainColor", "backColor", "textColor", "subTextColor", "v", "limitMode", "setRankMode", "userStartPosition", "userEndPosition", "setMatchMode", "", "levelList", "y", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, DomainData.DOMAIN_NAME, "Landroidx/customview/widget/ViewDragHelper;", "d", "Landroidx/customview/widget/ViewDragHelper;", "dragHelper", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "textItemLinear", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "paint", h.F, "I", "itemSelectColor", "i", "itemNormalColor", "backLinePadding", "backLineGrayColor", "backLineYellowColor", "lineStart", "lineEnd", "buttonSize", "mode", "J", "K", "Lnr2/aa;", "L", "Lnr2/aa;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LevelSegmentSelectView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int backLineGrayColor;

    /* renamed from: D, reason: from kotlin metadata */
    private int backLineYellowColor;

    /* renamed from: E, reason: from kotlin metadata */
    private float lineStart;

    /* renamed from: F, reason: from kotlin metadata */
    private float lineEnd;

    /* renamed from: G, reason: from kotlin metadata */
    private final float buttonSize;

    /* renamed from: H, reason: from kotlin metadata */
    private int mode;

    /* renamed from: I, reason: from kotlin metadata */
    private int limitMode;

    /* renamed from: J, reason: from kotlin metadata */
    private int startPosition;

    /* renamed from: K, reason: from kotlin metadata */
    private int endPosition;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final aa binding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewDragHelper dragHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout textItemLinear;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int itemSelectColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int itemNormalColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int backLinePadding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/team/impl/main/LevelSegmentSelectView$a", "Landroidx/customview/widget/ViewDragHelper$Callback;", "Landroid/view/View;", "child", "", "pointerId", "", "tryCaptureView", "left", "dx", "clampViewPositionHorizontal", "releasedChild", "", "xvel", "yvel", "", "onViewReleased", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NotNull View child, int left, int dx5) {
            int o16;
            int o17;
            int width;
            int coerceAtLeast;
            int coerceAtMost;
            Intrinsics.checkNotNullParameter(child, "child");
            LevelSegmentSelectView.this.invalidate();
            if (LevelSegmentSelectView.this.mode == 0) {
                o16 = LevelSegmentSelectView.this.getPaddingLeft();
                o17 = LevelSegmentSelectView.this.getWidth() - child.getWidth();
                width = LevelSegmentSelectView.this.getPaddingRight();
            } else {
                LevelSegmentSelectView levelSegmentSelectView = LevelSegmentSelectView.this;
                int m3 = levelSegmentSelectView.m(levelSegmentSelectView.startPosition);
                LevelSegmentSelectView levelSegmentSelectView2 = LevelSegmentSelectView.this;
                int m16 = levelSegmentSelectView2.m(levelSegmentSelectView2.endPosition);
                LevelSegmentSelectView levelSegmentSelectView3 = LevelSegmentSelectView.this;
                View childAt = levelSegmentSelectView3.textItemLinear.getChildAt(m3);
                Intrinsics.checkNotNullExpressionValue(childAt, "textItemLinear.getChildAt(releaseLowPos)");
                o16 = levelSegmentSelectView3.o(childAt) - (child.getWidth() / 2);
                LevelSegmentSelectView levelSegmentSelectView4 = LevelSegmentSelectView.this;
                View childAt2 = levelSegmentSelectView4.textItemLinear.getChildAt(m16);
                Intrinsics.checkNotNullExpressionValue(childAt2, "textItemLinear.getChildAt(releaseHighPos)");
                o17 = levelSegmentSelectView4.o(childAt2);
                width = child.getWidth() / 2;
            }
            int i3 = o17 - width;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(left, o16);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, i3);
            LevelSegmentSelectView.this.H();
            return coerceAtMost;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NotNull View releasedChild, float xvel, float yvel) {
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            super.onViewReleased(releasedChild, xvel, yvel);
            LevelSegmentSelectView.this.F(releasedChild);
            LevelSegmentSelectView.this.E(releasedChild);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NotNull View child, int pointerId) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (child.getId() != R.id.zws && child.getId() != R.id.f215901f) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/team/impl/main/LevelSegmentSelectView$b", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 0) {
                LevelSegmentSelectView.this.C(event.getX());
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelSegmentSelectView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.paint = paint;
        this.itemSelectColor = -16777216;
        this.itemNormalColor = -3355444;
        this.backLineGrayColor = Color.parseColor("#F7F7F7");
        this.backLineYellowColor = Color.parseColor("#F5A300");
        this.buttonSize = 24.0f;
        aa f16 = aa.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setWillNotDraw(false);
        this.backLinePadding = (int) ba.dp2px(getContext(), 12.0f);
        View findViewById = findViewById(R.id.f94825db);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.textItemLinear)");
        this.textItemLinear = (LinearLayout) findViewById;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new a());
        Intrinsics.checkNotNullExpressionValue(create, "create(this, 1.0f, objec\u2026\n            }\n        })");
        this.dragHelper = create;
        paint.setColor(Color.parseColor("#FFDD33"));
        f16.f420754b.setOnTouchListener(new b());
        this.lineStart = (ba.dp2px(getContext(), 24.0f) - ba.dp2px(getContext(), 4.0f)) / 2;
        this.lineEnd = ba.dp2px(getContext(), 24.0f) - this.lineStart;
    }

    private final boolean A(float x16) {
        ImageView imageView = this.binding.f420755c;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.oneButton");
        if (!B(x16, imageView)) {
            ImageView imageView2 = this.binding.f420756d;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.otherButton");
            if (!B(x16, imageView2)) {
                return false;
            }
        }
        return true;
    }

    private final boolean B(float x16, View view) {
        if (x16 >= view.getLeft() && x16 <= view.getRight()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(float x16) {
        View p16 = p(x16);
        if (p16 != null) {
            E(p16);
        }
    }

    private final void D(View view, int targetPos) {
        View childAt = this.textItemLinear.getChildAt(targetPos);
        Intrinsics.checkNotNullExpressionValue(childAt, "textItemLinear.getChildAt(targetPos)");
        view.offsetLeftAndRight(o(childAt) - o(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(View releasedChild) {
        int m3;
        if (this.mode == 1) {
            int s16 = s(o(releasedChild));
            int m16 = m(this.startPosition);
            int m17 = m(this.endPosition);
            if (s16 < m16) {
                D(releasedChild, m16);
            }
            if (s16 > m17) {
                D(releasedChild, m17);
            }
            if (this.limitMode == 1) {
                ImageView imageView = this.binding.f420755c;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.oneButton");
                if (Intrinsics.areEqual(releasedChild, this.binding.f420755c)) {
                    imageView = this.binding.f420756d;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.otherButton");
                }
                int s17 = s(o(releasedChild));
                int s18 = s(o(imageView));
                if (releasedChild.getLeft() < imageView.getLeft()) {
                    int m18 = m(s17 + 1);
                    if (s18 > m18) {
                        D(imageView, m18);
                    }
                } else if (releasedChild.getLeft() > imageView.getLeft() && s18 < (m3 = m(s17 - 1))) {
                    D(imageView, m3);
                }
            }
            invalidate();
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(View releasedChild) {
        View t16 = t(o(releasedChild));
        if (t16 != null) {
            releasedChild.offsetLeftAndRight(o(t16) - o(releasedChild));
        }
        invalidate();
        H();
    }

    private final void G(View selectorImg, int position) {
        if (this.textItemLinear.getChildCount() > 1 && position >= 0 && position < this.textItemLinear.getChildCount()) {
            ViewGroup.LayoutParams layoutParams = selectorImg.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                View childAt = this.textItemLinear.getChildAt(position);
                Intrinsics.checkNotNullExpressionValue(childAt, "textItemLinear.getChildAt(position)");
                ((FrameLayout.LayoutParams) layoutParams).setMarginStart(o(childAt) - (selectorImg.getWidth() / 2));
                selectorImg.setLayoutParams(layoutParams);
                selectorImg.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        if (this.textItemLinear.getChildCount() > 1) {
            int o16 = o(u());
            int o17 = o(r());
            float width = ((getWidth() * 1.0f) / (this.textItemLinear.getChildCount() - 1)) / 2;
            int childCount = this.textItemLinear.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.textItemLinear.getChildAt(i3);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) childAt;
                int o18 = o(textView);
                if (o16 - o18 <= width && o18 - o17 <= width) {
                    Spanned fromHtml = Html.fromHtml("<strong>" + ((Object) textView.getText()) + "</strong>");
                    Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(\"<strong>\" + textView.text + \"</strong>\")");
                    textView.setText(fromHtml);
                    textView.setTextColor(this.itemSelectColor);
                } else {
                    textView.setTextColor(this.itemNormalColor);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(int pos) {
        if (pos < 0) {
            return 0;
        }
        if (pos > this.textItemLinear.getChildCount() - 1) {
            return this.textItemLinear.getChildCount() - 1;
        }
        return pos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int o(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private final View p(float x16) {
        if (!A(x16)) {
            return q(x16, t(x16));
        }
        return null;
    }

    private final View q(float x16, View targetTextView) {
        if (targetTextView != null) {
            View r16 = r();
            if (x16 > r16.getRight()) {
                r16.offsetLeftAndRight(o(targetTextView) - o(r16));
            } else {
                r16 = u();
                r16.offsetLeftAndRight(o(targetTextView) - o(r16));
            }
            H();
            invalidate();
            return r16;
        }
        return null;
    }

    private final View r() {
        if (this.binding.f420755c.getLeft() > this.binding.f420756d.getLeft()) {
            ImageView imageView = this.binding.f420755c;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.oneButton");
            return imageView;
        }
        ImageView imageView2 = this.binding.f420756d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.otherButton");
        return imageView2;
    }

    private final int s(float x16) {
        int childCount = this.textItemLinear.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.textItemLinear.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "textItemLinear.getChildAt(index)");
            if (B(x16, childAt)) {
                return i3;
            }
        }
        return 0;
    }

    private final View t(float x16) {
        int childCount = this.textItemLinear.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.textItemLinear.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "textItemLinear.getChildAt(index)");
            if (B(x16, childAt)) {
                return this.textItemLinear.getChildAt(i3);
            }
        }
        return null;
    }

    private final View u() {
        if (this.binding.f420755c.getLeft() < this.binding.f420756d.getLeft()) {
            ImageView imageView = this.binding.f420755c;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.oneButton");
            return imageView;
        }
        ImageView imageView2 = this.binding.f420756d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.otherButton");
        return imageView2;
    }

    private final void w(int startPosition, int endPosition) {
        ImageView imageView = this.binding.f420755c;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.oneButton");
        G(imageView, startPosition);
        ImageView imageView2 = this.binding.f420756d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.otherButton");
        G(imageView2, endPosition);
        this.textItemLinear.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.main.b
            @Override // java.lang.Runnable
            public final void run() {
                LevelSegmentSelectView.x(LevelSegmentSelectView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(LevelSegmentSelectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(LevelSegmentSelectView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.C(this$0.o(it));
        EventCollector.getInstance().onViewClicked(it);
    }

    @NotNull
    public final List<String> n() {
        CharSequence text;
        String obj;
        ArrayList arrayList = new ArrayList();
        int childCount = this.textItemLinear.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.textItemLinear.getChildAt(i3);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt;
            if (textView.getCurrentTextColor() == this.itemSelectColor && (text = textView.getText()) != null && (obj = text.toString()) != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getWidth() > this.backLinePadding) {
            this.paint.setColor(this.backLineGrayColor);
            canvas.drawRect(this.backLinePadding, this.lineStart, getWidth() - this.backLinePadding, this.lineEnd, this.paint);
        }
        this.paint.setColor(this.backLineYellowColor);
        canvas.drawRect(o(u()), this.lineStart, o(r()), this.lineEnd, this.paint);
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        return this.dragHelper.shouldInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.dragHelper.processTouchEvent(event);
        return true;
    }

    public final void setMatchMode(int startPosition, int endPosition) {
        this.mode = 0;
        w(startPosition, endPosition);
    }

    public final void setRankMode(int startPosition, int endPosition, int limitMode) {
        this.mode = 1;
        this.limitMode = limitMode;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        if (limitMode == 1) {
            w(startPosition + 1, endPosition);
        } else {
            w(startPosition, endPosition);
        }
    }

    public final void v(@NotNull String mainColor, @NotNull String backColor, @NotNull String textColor, @NotNull String subTextColor) {
        Intrinsics.checkNotNullParameter(mainColor, "mainColor");
        Intrinsics.checkNotNullParameter(backColor, "backColor");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(subTextColor, "subTextColor");
        this.paint.setColor(Color.parseColor(mainColor));
        this.backLineGrayColor = Color.parseColor(backColor);
        this.backLineYellowColor = Color.parseColor(mainColor);
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor(mainColor), PorterDuff.Mode.SRC);
        this.binding.f420755c.setColorFilter(porterDuffColorFilter);
        this.binding.f420756d.setColorFilter(porterDuffColorFilter);
        this.itemSelectColor = Color.parseColor(textColor);
        this.itemNormalColor = Color.parseColor(subTextColor);
    }

    public final void y(@NotNull List<String> levelList) {
        Intrinsics.checkNotNullParameter(levelList, "levelList");
        if (this.textItemLinear.getChildCount() != 0) {
            return;
        }
        this.textItemLinear.removeAllViews();
        float dp2px = ba.dp2px(getContext(), 6.0f);
        for (String str : levelList) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setGravity(17);
            textView.setTextSize(1, 12.0f);
            textView.setPadding(0, (int) dp2px, 0, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.textItemLinear.addView(textView, layoutParams);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.team.impl.main.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelSegmentSelectView.z(LevelSegmentSelectView.this, view);
                }
            });
        }
    }

    public final void setRankMode(int userStartPosition, int userEndPosition, int startPosition, int endPosition, int limitMode) {
        this.mode = 1;
        this.limitMode = limitMode;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        w(userStartPosition, userEndPosition);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelSegmentSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.paint = paint;
        this.itemSelectColor = -16777216;
        this.itemNormalColor = -3355444;
        this.backLineGrayColor = Color.parseColor("#F7F7F7");
        this.backLineYellowColor = Color.parseColor("#F5A300");
        this.buttonSize = 24.0f;
        aa f16 = aa.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setWillNotDraw(false);
        this.backLinePadding = (int) ba.dp2px(getContext(), 12.0f);
        View findViewById = findViewById(R.id.f94825db);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.textItemLinear)");
        this.textItemLinear = (LinearLayout) findViewById;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new a());
        Intrinsics.checkNotNullExpressionValue(create, "create(this, 1.0f, objec\u2026\n            }\n        })");
        this.dragHelper = create;
        paint.setColor(Color.parseColor("#FFDD33"));
        f16.f420754b.setOnTouchListener(new b());
        this.lineStart = (ba.dp2px(getContext(), 24.0f) - ba.dp2px(getContext(), 4.0f)) / 2;
        this.lineEnd = ba.dp2px(getContext(), 24.0f) - this.lineStart;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelSegmentSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.paint = paint;
        this.itemSelectColor = -16777216;
        this.itemNormalColor = -3355444;
        this.backLineGrayColor = Color.parseColor("#F7F7F7");
        this.backLineYellowColor = Color.parseColor("#F5A300");
        this.buttonSize = 24.0f;
        aa f16 = aa.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setWillNotDraw(false);
        this.backLinePadding = (int) ba.dp2px(getContext(), 12.0f);
        View findViewById = findViewById(R.id.f94825db);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.textItemLinear)");
        this.textItemLinear = (LinearLayout) findViewById;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new a());
        Intrinsics.checkNotNullExpressionValue(create, "create(this, 1.0f, objec\u2026\n            }\n        })");
        this.dragHelper = create;
        paint.setColor(Color.parseColor("#FFDD33"));
        f16.f420754b.setOnTouchListener(new b());
        this.lineStart = (ba.dp2px(getContext(), 24.0f) - ba.dp2px(getContext(), 4.0f)) / 2;
        this.lineEnd = ba.dp2px(getContext(), 24.0f) - this.lineStart;
    }
}

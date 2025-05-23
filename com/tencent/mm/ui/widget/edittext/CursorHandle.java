package com.tencent.mm.ui.widget.edittext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0015\n\u0002\b\u000f\u0018\u0000 G2\u00020\u0001:\u0001GB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010D\u001a\u00020\b\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\"\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010+\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0014\u0010-\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010&R\"\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u0016\u00102\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010&R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010&R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010&R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010&R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0011\u0010A\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010C\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010@\u00a8\u0006H"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/CursorHandle;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "dismiss", "", HippyTKDListViewAdapter.X, "y", "update", "show", "a", "b", "offset", "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "selectableEditTextHelper", "Z", "isLeft", "()Z", "setLeft", "(Z)V", "Landroid/widget/PopupWindow;", "c", "Landroid/widget/PopupWindow;", "mPopupWindow", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "e", "I", "mCircleRadius", "f", "mWidth", "g", "mHeight", tl.h.F, "mPadding", "i", "isMoving", "setMoving", "j", "mAdjustX", "k", "mAdjustY", "l", "mBeforeDragStart", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mBeforeDragEnd", "", BdhLogUtil.LogTag.Tag_Conn, "[I", "loc", "D", "mTempCoors", "getExtraX", "()I", "extraX", "getExtraY", "extraY", "left", "<init>", "(Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;Z)V", "Companion", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class CursorHandle extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    public final int[] loc;

    /* renamed from: D, reason: from kotlin metadata */
    public final int[] mTempCoors;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SelectableEditTextHelper selectableEditTextHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean isLeft;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final PopupWindow mPopupWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int mCircleRadius;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int mWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int mHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int mPadding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean isMoving;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int mAdjustX;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int mAdjustY;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int mBeforeDragStart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public int mBeforeDragEnd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/CursorHandle$Companion;", "", "()V", ViewStickEventHelper.IS_SHOW, "", "handle", "Lcom/tencent/mm/ui/widget/edittext/CursorHandle;", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isShow(@Nullable CursorHandle handle) {
            if (handle == null) {
                return false;
            }
            return handle.mPopupWindow.isShowing();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CursorHandle(@NotNull SelectableEditTextHelper selectableEditTextHelper, boolean z16) {
        super(selectableEditTextHelper.getMContext());
        Intrinsics.checkNotNullParameter(selectableEditTextHelper, "selectableEditTextHelper");
        this.selectableEditTextHelper = selectableEditTextHelper;
        this.mPadding = 25;
        this.loc = new int[2];
        this.mTempCoors = new int[2];
        this.isLeft = z16;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(selectableEditTextHelper.getMCursorHandleColor());
        int mCursorHandleSize = selectableEditTextHelper.getMCursorHandleSize() / 2;
        this.mCircleRadius = mCursorHandleSize;
        int i3 = mCursorHandleSize * 2;
        this.mWidth = i3;
        this.mHeight = i3;
        PopupWindow popupWindow = new PopupWindow(this);
        this.mPopupWindow = popupWindow;
        popupWindow.setClippingEnabled(false);
        popupWindow.setWidth(i3 + 50);
        popupWindow.setHeight(i3 + 12);
        invalidate();
    }

    @JvmStatic
    public static final boolean isShow(@Nullable CursorHandle cursorHandle) {
        return INSTANCE.isShow(cursorHandle);
    }

    public final void a() {
        this.isLeft = !this.isLeft;
        invalidate();
    }

    public final void b() {
        this.selectableEditTextHelper.getMTextView().getLocationInWindow(this.mTempCoors);
        Layout layout = this.selectableEditTextHelper.getMTextView().getLayout();
        if (this.isLeft) {
            int mStart = this.selectableEditTextHelper.getMSelectionInfo().getMStart();
            Intrinsics.checkNotNullExpressionValue(layout, "layout");
            a((((int) layout.getPrimaryHorizontal(this.selectableEditTextHelper.getMSelectionInfo().getMStart())) - this.mWidth) + getExtraX(), a(mStart, layout));
            return;
        }
        int mEnd = this.selectableEditTextHelper.getMSelectionInfo().getMEnd();
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        a(((int) layout.getPrimaryHorizontal(this.selectableEditTextHelper.getMSelectionInfo().getMEnd())) + getExtraX(), a(mEnd, layout));
    }

    public final void dismiss() {
        this.mPopupWindow.dismiss();
    }

    public final int getExtraX() {
        return (this.mTempCoors[0] - this.mPadding) + this.selectableEditTextHelper.getMTextView().getPaddingLeft();
    }

    public final int getExtraY() {
        return (this.mTempCoors[1] + this.selectableEditTextHelper.getMTextView().getPaddingTop()) - this.selectableEditTextHelper.getCurScrollY();
    }

    /* renamed from: isLeft, reason: from getter */
    public final boolean getIsLeft() {
        return this.isLeft;
    }

    /* renamed from: isMoving, reason: from getter */
    public final boolean getIsMoving() {
        return this.isMoving;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i3 = this.mCircleRadius;
        float f16 = this.mPadding + i3;
        float f17 = i3;
        canvas.drawCircle(f16, f17, f17, this.mPaint);
        if (this.isLeft) {
            int i16 = this.mCircleRadius;
            int i17 = this.mPadding;
            canvas.drawRect(i16 + i17, 0.0f, (i16 * 2) + i17, i16, this.mPaint);
        } else {
            canvas.drawRect(this.mPadding, 0.0f, r0 + r1, this.mCircleRadius, this.mPaint);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r0 != 3) goto L16;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.isMoving = true;
                    SelectableEditTextHelper selectableEditTextHelper = this.selectableEditTextHelper;
                    selectableEditTextHelper.dismissOperWindow(selectableEditTextHelper.getOperWindow());
                    update(((int) event.getRawX()) - this.loc[0], (((((int) event.getRawY()) + this.mAdjustY) - this.mHeight) - this.selectableEditTextHelper.getMTextLineHeight()) + this.selectableEditTextHelper.getCurScrollY());
                    CursorHandle cursorHandle = this.selectableEditTextHelper.getCursorHandle(!this.isLeft);
                    if (cursorHandle != null) {
                        cursorHandle.b();
                    }
                }
            }
            this.isMoving = false;
            SelectableEditTextHelper selectableEditTextHelper2 = this.selectableEditTextHelper;
            selectableEditTextHelper2.showOperWindow(selectableEditTextHelper2.getOperWindow());
        } else {
            this.mBeforeDragStart = this.selectableEditTextHelper.getMSelectionInfo().getMStart();
            this.mBeforeDragEnd = this.selectableEditTextHelper.getMSelectionInfo().getMEnd();
            this.mAdjustX = (int) event.getX();
            this.mAdjustY = (int) event.getY();
            this.selectableEditTextHelper.getMTextView().getLocationOnScreen(this.loc);
        }
        return true;
    }

    public final void setLeft(boolean z16) {
        this.isLeft = z16;
    }

    public final void setMoving(boolean z16) {
        this.isMoving = z16;
    }

    public final void show(int x16, int y16) {
        int i3;
        this.selectableEditTextHelper.getMTextView().getLocationInWindow(this.mTempCoors);
        if (this.isLeft) {
            i3 = this.mWidth;
        } else {
            i3 = 0;
        }
        int extraX = (x16 - i3) + getExtraX();
        int extraY = y16 + getExtraY();
        int i16 = this.mTempCoors[1];
        if (extraY < i16 || extraY > ((i16 + this.selectableEditTextHelper.getMTextView().getHeight()) - this.selectableEditTextHelper.getMTextView().getPaddingBottom()) + o.a(this.selectableEditTextHelper.getMContext(), 5)) {
            return;
        }
        a(extraX, extraY);
    }

    public final void update(int x16, int y16) {
        int mEnd;
        this.selectableEditTextHelper.getMTextView().getLocationInWindow(this.mTempCoors);
        if (this.isLeft) {
            mEnd = this.selectableEditTextHelper.getMSelectionInfo().getMStart();
        } else {
            mEnd = this.selectableEditTextHelper.getMSelectionInfo().getMEnd();
        }
        int hysteresisOffset = TextLayoutUtil.getHysteresisOffset(this.selectableEditTextHelper.getMTextView(), x16, y16 - this.mTempCoors[1], mEnd);
        if (hysteresisOffset != mEnd) {
            this.selectableEditTextHelper.resetSelectionInfo();
            if (this.isLeft) {
                if (hysteresisOffset > this.mBeforeDragEnd) {
                    CursorHandle cursorHandle = this.selectableEditTextHelper.getCursorHandle(false);
                    a();
                    if (cursorHandle != null) {
                        cursorHandle.a();
                    }
                    int i3 = this.mBeforeDragEnd;
                    this.mBeforeDragStart = i3;
                    this.selectableEditTextHelper.selectText(i3, hysteresisOffset);
                    if (cursorHandle != null) {
                        cursorHandle.b();
                    }
                } else {
                    this.selectableEditTextHelper.selectText(hysteresisOffset, -1);
                }
                b();
                return;
            }
            int i16 = this.mBeforeDragStart;
            if (hysteresisOffset < i16) {
                CursorHandle cursorHandle2 = this.selectableEditTextHelper.getCursorHandle(true);
                if (cursorHandle2 != null) {
                    cursorHandle2.a();
                }
                a();
                int i17 = this.mBeforeDragStart;
                this.mBeforeDragEnd = i17;
                this.selectableEditTextHelper.selectText(hysteresisOffset, i17);
                if (cursorHandle2 != null) {
                    cursorHandle2.b();
                }
            } else {
                this.selectableEditTextHelper.selectText(i16, hysteresisOffset);
            }
            b();
        }
    }

    public final int a(int offset, Layout layout) {
        int lineBottom = layout.getLineBottom(layout.getLineForOffset(offset)) + getExtraY();
        int height = (this.mTempCoors[1] + this.selectableEditTextHelper.getMTextView().getHeight()) - this.selectableEditTextHelper.getMTextView().getPaddingBottom();
        if (lineBottom > height) {
            lineBottom = height;
        }
        int i3 = this.mTempCoors[1];
        return lineBottom < i3 ? i3 : lineBottom;
    }

    public final void a(int x16, int y16) {
        try {
            if (this.mPopupWindow.isShowing()) {
                this.mPopupWindow.update(x16, y16, -1, -1);
            } else {
                this.mPopupWindow.showAtLocation(this.selectableEditTextHelper.getMTextView(), 0, x16, y16);
            }
        } catch (Exception e16) {
            n.b(SelectableEditTextHelper.TAG, "cursor error!: %s.", e16.getMessage());
        }
    }
}

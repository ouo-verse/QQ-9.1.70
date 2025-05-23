package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0082\u0001B\u001b\u0012\u0006\u0010$\u001a\u00020\"\u0012\b\u0010\u007f\u001a\u0004\u0018\u00010~\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0003J\b\u0010\u000e\u001a\u00020\u0005H\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0003J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0006\u0010\u001b\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0005J\b\u0010\u001e\u001a\u00020\u0005H\u0005J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002J\u0016\u0010!\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010#R\u0017\u0010(\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010*R\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010,R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010F\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\"\u0010J\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010=\u001a\u0004\bH\u0010?\"\u0004\bI\u0010AR\"\u0010N\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010=\u001a\u0004\bL\u0010?\"\u0004\bM\u0010AR\"\u0010Q\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010,R\u0016\u0010X\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010,R\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010_R\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010,R\u0016\u0010e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010,R\u0016\u0010g\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010,R\u0016\u0010i\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010,R\u0016\u0010k\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010,R\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010,R\u001a\u0010q\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bn\u0010,\u001a\u0004\bo\u0010pR\u001a\u0010t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\br\u0010,\u001a\u0004\bs\u0010pR\u001a\u0010w\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bu\u0010,\u001a\u0004\bv\u0010pR\u0011\u0010y\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bx\u0010pR\u0011\u0010{\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bz\u0010pR\u0014\u0010}\u001a\u00020\u00028DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b|\u0010p\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/InsertHandle;", "Landroid/view/View;", "", HippyTKDListViewAdapter.X, "y", "", "a", "", NodeProps.VISIBLE, "setVisible", "Landroid/view/MotionEvent;", "event", "Landroid/graphics/PointF;", "showPosInView", "e", "Landroid/widget/PopupWindow;", "handle", "Landroid/graphics/Rect;", "magnifierRect", "c", "d", "offset", "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "dismiss", "show", "onTouchEvent", "b", "", "getHorizontal", "update", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "helper", "Landroid/widget/PopupWindow;", "getMWindow", "()Landroid/widget/PopupWindow;", "mWindow", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "I", "mCircleRadius", "mWidth", "f", "mHeight", "g", "mPadding", "Landroid/graphics/Path;", tl.h.F, "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPath", "Landroid/graphics/Point;", "i", "Landroid/graphics/Point;", "getMPointT1", "()Landroid/graphics/Point;", "setMPointT1", "(Landroid/graphics/Point;)V", "mPointT1", "j", "getMPointT2", "setMPointT2", "mPointT2", "k", "getMPointT3", "setMPointT3", "mPointT3", "l", "getMPointR", "setMPointR", "mPointR", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isMoving", "()Z", "setMoving", "(Z)V", BdhLogUtil.LogTag.Tag_Conn, "mLastShowPosX", "D", "mLastShowPosY", "Landroid/view/View$OnClickListener;", "E", "Landroid/view/View$OnClickListener;", "onClickListener", "", UserInfo.SEX_FEMALE, "[I", "mTempCoors", "G", "loc", "H", "mAdjustX", "mAdjustY", "J", "mBeforeDragStart", "K", "mBeforeDragEnd", "L", "mLastOffsetX", "M", "mLastOffsetY", "N", "getINSERTION", "()I", "INSERTION", "O", "getSELECTION_START", "SELECTION_START", "P", "getSELECTION_END", "SELECTION_END", "getExtraX", "extraX", "getExtraY", "extraY", "getMagnifierHandleTrigger", "magnifierHandleTrigger", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;Landroid/content/Context;)V", "Companion", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class InsertHandle extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "EditHelper.InsertHandle";

    /* renamed from: C, reason: from kotlin metadata */
    public int mLastShowPosX;

    /* renamed from: D, reason: from kotlin metadata */
    public int mLastShowPosY;

    /* renamed from: E, reason: from kotlin metadata */
    public final View.OnClickListener onClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    public final int[] mTempCoors;

    /* renamed from: G, reason: from kotlin metadata */
    public final int[] loc;

    /* renamed from: H, reason: from kotlin metadata */
    public int mAdjustX;

    /* renamed from: I, reason: from kotlin metadata */
    public int mAdjustY;

    /* renamed from: J, reason: from kotlin metadata */
    public int mBeforeDragStart;

    /* renamed from: K, reason: from kotlin metadata */
    public int mBeforeDragEnd;

    /* renamed from: L, reason: from kotlin metadata */
    public int mLastOffsetX;

    /* renamed from: M, reason: from kotlin metadata */
    public int mLastOffsetY;

    /* renamed from: N, reason: from kotlin metadata */
    public final int INSERTION;

    /* renamed from: O, reason: from kotlin metadata */
    public final int SELECTION_START;

    /* renamed from: P, reason: from kotlin metadata */
    public final int SELECTION_END;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SelectableEditTextHelper helper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final PopupWindow mWindow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Paint mPaint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int mCircleRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int mWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int mHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int mPadding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Path mPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public Point mPointT1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public Point mPointT2;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public Point mPointT3;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public Point mPointR;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public boolean isMoving;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/InsertHandle$Companion;", "", "()V", "TAG", "", ViewStickEventHelper.IS_SHOW, "", "handle", "Lcom/tencent/mm/ui/widget/edittext/InsertHandle;", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isShow(@Nullable InsertHandle handle) {
            if (handle == null) {
                return false;
            }
            return handle.getMWindow().isShowing();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsertHandle(@NotNull SelectableEditTextHelper helper, @Nullable Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(helper, "helper");
        this.helper = helper;
        int mCursorHandleSize = helper.getMCursorHandleSize() / 2;
        this.mCircleRadius = mCursorHandleSize;
        int i3 = mCursorHandleSize * 2;
        this.mWidth = i3;
        this.mHeight = i3;
        int a16 = o.a(helper.getMContext(), 9);
        this.mPadding = a16;
        this.mPath = new Path();
        this.mPointT1 = new Point(mCursorHandleSize, 0);
        double d16 = 1;
        double d17 = 2;
        double d18 = mCursorHandleSize;
        this.mPointT2 = new Point((int) ((d16 - (Math.sqrt(2.0d) / d17)) * d18), (int) ((Math.sqrt(2.0d) / d17) * d18));
        this.mPointT3 = new Point((int) ((d16 + (Math.sqrt(2.0d) / d17)) * d18), (int) ((Math.sqrt(2.0d) / d17) * d18));
        this.mPointR = new Point(mCursorHandleSize, (int) (Math.sqrt(2.0d) * d18));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.edittext.InsertHandle$onClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectableEditTextHelper selectableEditTextHelper;
                selectableEditTextHelper = InsertHandle.this.helper;
                OperateWindow operWindow = selectableEditTextHelper.getOperWindow();
                if (operWindow.isShowing()) {
                    operWindow.dismiss();
                } else {
                    operWindow.show();
                }
            }
        };
        this.onClickListener = onClickListener;
        this.mTempCoors = new int[2];
        this.loc = new int[2];
        this.SELECTION_START = 1;
        this.SELECTION_END = 2;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(helper.getMCursorHandleColor());
        PopupWindow popupWindow = new PopupWindow(this);
        this.mWindow = popupWindow;
        popupWindow.setClippingEnabled(false);
        popupWindow.setWidth(i3 + (a16 * 2));
        popupWindow.setHeight(i3 + (a16 / 2));
        invalidate();
        setOnClickListener(onClickListener);
    }

    @JvmStatic
    public static final boolean isShow(@Nullable InsertHandle insertHandle) {
        return INSTANCE.isShow(insertHandle);
    }

    private final void setVisible(boolean visible) {
        int i3;
        View contentView = this.mWindow.getContentView();
        if (visible) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        contentView.setVisibility(i3);
    }

    public final void a(int x16, int y16) {
        this.mLastShowPosX = x16;
        this.mLastShowPosY = y16;
        n.a(TAG, "showOrUpdate() called with: x = " + x16 + ", y = " + y16, new Object[0]);
        if (this.mWindow.isShowing()) {
            this.mWindow.update(x16, y16, -1, -1);
        } else {
            this.mWindow.showAtLocation(this.helper.getMTextView(), 0, x16, y16);
        }
    }

    public final void b() {
        if (this.helper.getMMagnifierAnimator() != null) {
            MagnifierMotionAnimator mMagnifierAnimator = this.helper.getMMagnifierAnimator();
            if (mMagnifierAnimator != null) {
                mMagnifierAnimator.dismiss();
            }
            setVisible(true);
        }
    }

    public final boolean c() {
        int i3;
        float f16;
        Magnifier mMagnifier;
        Magnifier mMagnifier2;
        MagnifierMotionAnimator mMagnifierAnimator = this.helper.getMMagnifierAnimator();
        if (mMagnifierAnimator != null && (mMagnifier2 = mMagnifierAnimator.getMMagnifier()) != null) {
            i3 = mMagnifier2.getHeight();
        } else {
            i3 = 0;
        }
        float f17 = i3;
        MagnifierMotionAnimator mMagnifierAnimator2 = this.helper.getMMagnifierAnimator();
        if (mMagnifierAnimator2 != null && (mMagnifier = mMagnifierAnimator2.getMMagnifier()) != null) {
            f16 = mMagnifier.getZoom();
        } else {
            f16 = 1.0f;
        }
        float round = Math.round(f17 / f16);
        Paint.FontMetrics fontMetrics = this.helper.getMTextView().getPaint().getFontMetrics();
        Intrinsics.checkNotNullExpressionValue(fontMetrics, "helper.mTextView.getPaint().getFontMetrics()");
        if ((fontMetrics.descent - fontMetrics.ascent) * this.helper.getMTextViewScaleY() <= round) {
            return false;
        }
        return true;
    }

    public final void d() {
        this.helper.getMTextView().getLocationInWindow(this.mTempCoors);
        Layout layout = this.helper.getMTextView().getLayout();
        Intrinsics.checkNotNullExpressionValue(layout, "helper.mTextView.getLayout()");
        int selectionStart = this.helper.getMTextView().getSelectionStart();
        a(((int) layout.getPrimaryHorizontal(selectionStart)) + getExtraX(), a(selectionStart, layout));
    }

    public final void dismiss() {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void e() {
        int i3;
        Magnifier mMagnifier;
        Magnifier mMagnifier2;
        Magnifier mMagnifier3;
        int i16 = Build.VERSION.SDK_INT;
        int i17 = 0;
        Point point = null;
        point = null;
        point = null;
        Magnifier magnifier = null;
        if (i16 >= 29) {
            MagnifierMotionAnimator mMagnifierAnimator = this.helper.getMMagnifierAnimator();
            if (mMagnifierAnimator != null && (mMagnifier3 = mMagnifierAnimator.getMMagnifier()) != null) {
                point = mMagnifier3.getPosition();
            }
        } else if (i16 == 28) {
            MagnifierMotionAnimator mMagnifierAnimator2 = this.helper.getMMagnifierAnimator();
            if (mMagnifierAnimator2 != null) {
                magnifier = mMagnifierAnimator2.getMMagnifier();
            }
            point = (Point) new MB(magnifier, "getWindowCoords", (Class<?>[]) new Class[0]).invoke(new Object[0]);
        }
        if (point == null) {
            return;
        }
        int i18 = point.x;
        int i19 = point.y;
        MagnifierMotionAnimator mMagnifierAnimator3 = this.helper.getMMagnifierAnimator();
        if (mMagnifierAnimator3 != null && (mMagnifier2 = mMagnifierAnimator3.getMMagnifier()) != null) {
            i3 = mMagnifier2.getWidth();
        } else {
            i3 = 0;
        }
        int i26 = i3 + i18;
        int i27 = point.y;
        MagnifierMotionAnimator mMagnifierAnimator4 = this.helper.getMMagnifierAnimator();
        if (mMagnifierAnimator4 != null && (mMagnifier = mMagnifierAnimator4.getMMagnifier()) != null) {
            i17 = mMagnifier.getHeight();
        }
        setVisible(!a(this.mWindow, new Rect(i18, i19, i26, i27 + i17)));
    }

    public final int getExtraX() {
        return (this.mTempCoors[0] - this.mPadding) + this.helper.getMTextView().getPaddingLeft() + 2;
    }

    public final int getExtraY() {
        return (this.mTempCoors[1] + this.helper.getMTextView().getPaddingTop()) - this.helper.getMTextView().getScrollY();
    }

    public final float getHorizontal(@NotNull Layout layout, int offset) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        return layout.getPrimaryHorizontal(offset);
    }

    public final int getINSERTION() {
        return this.INSERTION;
    }

    @NotNull
    public final Path getMPath() {
        return this.mPath;
    }

    @NotNull
    public final Point getMPointR() {
        return this.mPointR;
    }

    @NotNull
    public final Point getMPointT1() {
        return this.mPointT1;
    }

    @NotNull
    public final Point getMPointT2() {
        return this.mPointT2;
    }

    @NotNull
    public final Point getMPointT3() {
        return this.mPointT3;
    }

    @NotNull
    public final PopupWindow getMWindow() {
        return this.mWindow;
    }

    public final int getMagnifierHandleTrigger() {
        return this.INSERTION;
    }

    public final int getSELECTION_END() {
        return this.SELECTION_END;
    }

    public final int getSELECTION_START() {
        return this.SELECTION_START;
    }

    /* renamed from: isMoving, reason: from getter */
    public final boolean getIsMoving() {
        return this.isMoving;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.mPath.reset();
        Path path = this.mPath;
        Point point = this.mPointT1;
        path.moveTo(point.x, point.y);
        Path path2 = this.mPath;
        Point point2 = this.mPointT2;
        path2.lineTo(point2.x, point2.y);
        Path path3 = this.mPath;
        Point point3 = this.mPointT3;
        path3.lineTo(point3.x, point3.y);
        Path path4 = this.mPath;
        Point point4 = this.mPointT1;
        path4.lineTo(point4.x, point4.y);
        canvas.drawPath(this.mPath, this.mPaint);
        Point point5 = this.mPointR;
        canvas.drawCircle(point5.x, point5.y, this.mCircleRadius, this.mPaint);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r0 != 3) goto L40;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        boolean z16;
        OperateWindow mOperateWindow;
        Intrinsics.checkNotNullParameter(event, "event");
        super.onTouchEvent(event);
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.isMoving = true;
                    if (this.helper.getMOperateWindow() != null) {
                        OperateWindow mOperateWindow2 = this.helper.getMOperateWindow();
                        if (mOperateWindow2 != null && mOperateWindow2.isShowing()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && (mOperateWindow = this.helper.getMOperateWindow()) != null) {
                            mOperateWindow.dismiss();
                        }
                    }
                    int rawX = (int) event.getRawX();
                    int rawY = (int) event.getRawY();
                    this.mLastOffsetX = rawX - this.loc[0];
                    this.mLastOffsetY = ((this.mAdjustY + rawY) - this.mHeight) - this.helper.getMTextLineHeight();
                    update(rawX - this.loc[0], (((rawY + this.mAdjustY) - this.mHeight) - this.helper.getMTextLineHeight()) + this.helper.getCurScrollY());
                    if (this.helper.getFLAG_USE_MAGNIFIER() && Build.VERSION.SDK_INT >= 28) {
                        a(event);
                    }
                }
            }
            this.isMoving = false;
            int rawX2 = (int) event.getRawX();
            int rawY2 = (int) event.getRawY();
            this.mLastOffsetX = rawX2 - this.loc[0];
            this.mLastOffsetY = ((rawY2 + this.mAdjustY) - this.mHeight) - this.helper.getMTextLineHeight();
            if (this.helper.getFLAG_USE_MAGNIFIER() && Build.VERSION.SDK_INT >= 28) {
                b();
            }
            this.helper.dismissInsertionDelay();
        } else {
            this.mBeforeDragStart = this.helper.getMSelectionInfo().getMStart();
            this.mBeforeDragEnd = this.helper.getMSelectionInfo().getMEnd();
            this.mAdjustX = (int) event.getX();
            this.mAdjustY = (int) event.getY();
            System.out.println((Object) ("soontest mAdjustX:" + this.mAdjustX + ",mAdjustY:" + this.mAdjustY + ",mHeight:" + this.mHeight));
            this.helper.getMTextView().getLocationInWindow(this.loc);
            if (this.helper.getFLAG_USE_MAGNIFIER() && Build.VERSION.SDK_INT >= 28) {
                a(event);
            }
            this.helper.getMTextView().removeCallbacks(this.helper.getInsertionHandleDelayDismissTask());
        }
        return true;
    }

    public final void setMPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<set-?>");
        this.mPath = path;
    }

    public final void setMPointR(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.mPointR = point;
    }

    public final void setMPointT1(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.mPointT1 = point;
    }

    public final void setMPointT2(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.mPointT2 = point;
    }

    public final void setMPointT3(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.mPointT3 = point;
    }

    public final void setMoving(boolean z16) {
        this.isMoving = z16;
    }

    public final void show(int x16, int y16) {
        this.helper.getMTextView().getLocationInWindow(this.mTempCoors);
        int extraX = x16 + 0 + getExtraX();
        int extraY = y16 + getExtraY();
        int i3 = this.mTempCoors[1];
        if (extraY < i3 || extraY > ((i3 + this.helper.getMTextView().getHeight()) - this.helper.getMTextView().getPaddingBottom()) + o.a(getContext(), 5)) {
            return;
        }
        a(extraX, extraY);
    }

    public final void update(int x16, int y16) {
        this.helper.getMTextView().getLocationInWindow(this.mTempCoors);
        int mStart = this.helper.getMSelectionInfo().getMStart();
        int hysteresisOffset = TextLayoutUtil.getHysteresisOffset(this.helper.getMTextView(), x16, y16 - this.mTempCoors[1], mStart);
        if (hysteresisOffset != mStart) {
            this.helper.selectText(hysteresisOffset, hysteresisOffset);
            d();
        }
    }

    public final void a(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.helper.getMagnifierAnimator() == null) {
            return;
        }
        PointF pointF = new PointF();
        if (a() && !c() && a(event, pointF)) {
            MagnifierMotionAnimator mMagnifierAnimator = this.helper.getMMagnifierAnimator();
            if (mMagnifierAnimator != null) {
                mMagnifierAnimator.show(pointF.x, pointF.y);
            }
            e();
            return;
        }
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(MotionEvent event, PointF showPosInView) {
        int i3;
        int i16;
        boolean z16;
        float rawX;
        float lineLeft;
        float lineRight;
        float mTextViewScaleX;
        float round;
        Magnifier mMagnifier;
        Magnifier mMagnifier2;
        int magnifierHandleTrigger = getMagnifierHandleTrigger();
        if (magnifierHandleTrigger == this.INSERTION) {
            i3 = this.helper.getMTextView().getSelectionStart();
            i16 = -1;
        } else if (magnifierHandleTrigger == this.SELECTION_START) {
            i3 = this.helper.getMTextView().getSelectionStart();
            i16 = this.helper.getMTextView().getSelectionEnd();
        } else if (magnifierHandleTrigger == this.SELECTION_END) {
            i3 = this.helper.getMTextView().getSelectionEnd();
            i16 = this.helper.getMTextView().getSelectionStart();
        } else {
            i3 = -1;
            i16 = -1;
        }
        if (i3 == -1) {
            return false;
        }
        if (event.getActionMasked() == 0) {
            this.helper.setMCurrentDragInitialTouchRawX(event.getRawX());
        } else if (event.getActionMasked() == 1) {
            this.helper.setMCurrentDragInitialTouchRawX(r7.getUNSET_X_VALUE());
        }
        Layout layout = this.helper.getMTextView().getLayout();
        Intrinsics.checkNotNullExpressionValue(layout, "helper.mTextView.getLayout()");
        int lineForOffset = layout.getLineForOffset(i3);
        boolean z17 = i16 != -1 && lineForOffset == layout.getLineForOffset(i16);
        if (z17) {
            boolean z18 = i3 < i16;
            Layout layout2 = this.helper.getMTextView().getLayout();
            Intrinsics.checkNotNullExpressionValue(layout2, "helper.mTextView.getLayout()");
            float horizontal = getHorizontal(layout2, i3);
            Layout layout3 = this.helper.getMTextView().getLayout();
            Intrinsics.checkNotNullExpressionValue(layout3, "helper.mTextView.getLayout()");
            if (z18 != (horizontal < getHorizontal(layout3, i16))) {
                z16 = true;
                this.helper.getMTextView().getLocationOnScreen(new int[2]);
                rawX = event.getRawX() - r11[0];
                float totalPaddingLeft = this.helper.getMTextView().getTotalPaddingLeft() - this.helper.getMTextView().getScrollX();
                float totalPaddingLeft2 = this.helper.getMTextView().getTotalPaddingLeft() - this.helper.getMTextView().getScrollX();
                if (z17) {
                    if ((magnifierHandleTrigger == this.SELECTION_END) ^ z16) {
                        Layout layout4 = this.helper.getMTextView().getLayout();
                        Intrinsics.checkNotNullExpressionValue(layout4, "helper.mTextView.getLayout()");
                        lineLeft = getHorizontal(layout4, i16);
                        float f16 = totalPaddingLeft + lineLeft;
                        if (z17) {
                            if ((magnifierHandleTrigger == this.SELECTION_START) ^ z16) {
                                Layout layout5 = this.helper.getMTextView().getLayout();
                                Intrinsics.checkNotNullExpressionValue(layout5, "helper.mTextView.getLayout()");
                                lineRight = getHorizontal(layout5, i16);
                                mTextViewScaleX = f16 * this.helper.getMTextViewScaleX();
                                float mTextViewScaleX2 = (totalPaddingLeft2 + lineRight) * this.helper.getMTextViewScaleX();
                                MagnifierMotionAnimator mMagnifierAnimator = this.helper.getMMagnifierAnimator();
                                float width = (mMagnifierAnimator != null || (mMagnifier2 = mMagnifierAnimator.getMMagnifier()) == null) ? 0 : mMagnifier2.getWidth();
                                MagnifierMotionAnimator mMagnifierAnimator2 = this.helper.getMMagnifierAnimator();
                                round = Math.round(width / ((mMagnifierAnimator2 != null || (mMagnifier = mMagnifierAnimator2.getMMagnifier()) == null) ? 1.0f : mMagnifier.getZoom())) / 2;
                                if (rawX >= mTextViewScaleX - round || rawX > round + mTextViewScaleX2) {
                                    return false;
                                }
                                if (!(this.helper.getMTextViewScaleX() == 1.0f)) {
                                    rawX = (((event.getRawX() - this.helper.getMCurrentDragInitialTouchRawX()) * this.helper.getMTextViewScaleX()) + this.helper.getMCurrentDragInitialTouchRawX()) - r11[0];
                                }
                                showPosInView.x = Math.max(mTextViewScaleX, Math.min(mTextViewScaleX2, rawX));
                                showPosInView.y = ((((this.helper.getMTextView().getLayout().getLineTop(lineForOffset) + this.helper.getMTextView().getLayout().getLineBottom(lineForOffset)) / 2.0f) + this.helper.getMTextView().getTotalPaddingTop()) - this.helper.getMTextView().getScrollY()) * this.helper.getMTextViewScaleY();
                                return true;
                            }
                        }
                        lineRight = this.helper.getMTextView().getLayout().getLineRight(lineForOffset);
                        mTextViewScaleX = f16 * this.helper.getMTextViewScaleX();
                        float mTextViewScaleX22 = (totalPaddingLeft2 + lineRight) * this.helper.getMTextViewScaleX();
                        MagnifierMotionAnimator mMagnifierAnimator3 = this.helper.getMMagnifierAnimator();
                        float width2 = (mMagnifierAnimator3 != null || (mMagnifier2 = mMagnifierAnimator3.getMMagnifier()) == null) ? 0 : mMagnifier2.getWidth();
                        MagnifierMotionAnimator mMagnifierAnimator22 = this.helper.getMMagnifierAnimator();
                        round = Math.round(width2 / ((mMagnifierAnimator22 != null || (mMagnifier = mMagnifierAnimator22.getMMagnifier()) == null) ? 1.0f : mMagnifier.getZoom())) / 2;
                        if (rawX >= mTextViewScaleX - round) {
                        }
                        return false;
                    }
                }
                lineLeft = this.helper.getMTextView().getLayout().getLineLeft(lineForOffset);
                float f162 = totalPaddingLeft + lineLeft;
                if (z17) {
                }
                lineRight = this.helper.getMTextView().getLayout().getLineRight(lineForOffset);
                mTextViewScaleX = f162 * this.helper.getMTextViewScaleX();
                float mTextViewScaleX222 = (totalPaddingLeft2 + lineRight) * this.helper.getMTextViewScaleX();
                MagnifierMotionAnimator mMagnifierAnimator32 = this.helper.getMMagnifierAnimator();
                float width22 = (mMagnifierAnimator32 != null || (mMagnifier2 = mMagnifierAnimator32.getMMagnifier()) == null) ? 0 : mMagnifier2.getWidth();
                MagnifierMotionAnimator mMagnifierAnimator222 = this.helper.getMMagnifierAnimator();
                round = Math.round(width22 / ((mMagnifierAnimator222 != null || (mMagnifier = mMagnifierAnimator222.getMMagnifier()) == null) ? 1.0f : mMagnifier.getZoom())) / 2;
                if (rawX >= mTextViewScaleX - round) {
                }
                return false;
            }
        }
        z16 = false;
        this.helper.getMTextView().getLocationOnScreen(new int[2]);
        rawX = event.getRawX() - r11[0];
        float totalPaddingLeft3 = this.helper.getMTextView().getTotalPaddingLeft() - this.helper.getMTextView().getScrollX();
        float totalPaddingLeft22 = this.helper.getMTextView().getTotalPaddingLeft() - this.helper.getMTextView().getScrollX();
        if (z17) {
        }
        lineLeft = this.helper.getMTextView().getLayout().getLineLeft(lineForOffset);
        float f1622 = totalPaddingLeft3 + lineLeft;
        if (z17) {
        }
        lineRight = this.helper.getMTextView().getLayout().getLineRight(lineForOffset);
        mTextViewScaleX = f1622 * this.helper.getMTextViewScaleX();
        float mTextViewScaleX2222 = (totalPaddingLeft22 + lineRight) * this.helper.getMTextViewScaleX();
        MagnifierMotionAnimator mMagnifierAnimator322 = this.helper.getMMagnifierAnimator();
        float width222 = (mMagnifierAnimator322 != null || (mMagnifier2 = mMagnifierAnimator322.getMMagnifier()) == null) ? 0 : mMagnifier2.getWidth();
        MagnifierMotionAnimator mMagnifierAnimator2222 = this.helper.getMMagnifierAnimator();
        round = Math.round(width222 / ((mMagnifierAnimator2222 != null || (mMagnifier = mMagnifierAnimator2222.getMMagnifier()) == null) ? 1.0f : mMagnifier.getZoom())) / 2;
        if (rawX >= mTextViewScaleX - round) {
        }
        return false;
    }

    public final boolean a(PopupWindow handle, Rect magnifierRect) {
        int i3 = this.mLastShowPosX;
        return Rect.intersects(new Rect(i3, this.mLastShowPosY, handle.getContentView().getWidth() + i3, this.mLastShowPosY + handle.getContentView().getHeight()), magnifierRect);
    }

    public final boolean a() {
        MagnifierMotionAnimator mMagnifierAnimator = this.helper.getMMagnifierAnimator();
        if (mMagnifierAnimator != null && mMagnifierAnimator.getMMagnifierIsShowing()) {
            return true;
        }
        if (this.helper.getMTextView().getRotation() == 0.0f) {
            if (this.helper.getMTextView().getRotationX() == 0.0f) {
                if (this.helper.getMTextView().getRotationY() == 0.0f) {
                    SelectableEditTextHelper selectableEditTextHelper = this.helper;
                    selectableEditTextHelper.setMTextViewScaleX(selectableEditTextHelper.getMTextView().getScaleX());
                    SelectableEditTextHelper selectableEditTextHelper2 = this.helper;
                    selectableEditTextHelper2.setMTextViewScaleY(selectableEditTextHelper2.getMTextView().getScaleY());
                    for (ViewParent parent = this.helper.getMTextView().getParent(); parent != null; parent = parent.getParent()) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getRotation() == 0.0f) {
                                if (view.getRotationX() == 0.0f) {
                                    if (view.getRotationY() == 0.0f) {
                                        SelectableEditTextHelper selectableEditTextHelper3 = this.helper;
                                        selectableEditTextHelper3.setMTextViewScaleX(selectableEditTextHelper3.getMTextViewScaleX() * view.getScaleX());
                                        SelectableEditTextHelper selectableEditTextHelper4 = this.helper;
                                        selectableEditTextHelper4.setMTextViewScaleY(selectableEditTextHelper4.getMTextViewScaleY() * view.getScaleY());
                                    }
                                }
                            }
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int a(int offset, Layout layout) {
        int lineBottom = layout.getLineBottom(layout.getLineForOffset(offset)) + getExtraY();
        int height = (this.mTempCoors[1] + this.helper.getMTextView().getHeight()) - this.helper.getMTextView().getPaddingBottom();
        if (lineBottom > height) {
            lineBottom = height;
        }
        int i3 = this.mTempCoors[1];
        return lineBottom < i3 ? i3 : lineBottom;
    }
}

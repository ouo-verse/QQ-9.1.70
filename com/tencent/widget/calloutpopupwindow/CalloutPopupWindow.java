package com.tencent.widget.calloutpopupwindow;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* loaded from: classes27.dex */
public class CalloutPopupWindow extends PopupWindow {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_HEIGHT_DP = 120;
    private static final int MAX_WIDTH_DP = 300;
    private static final int MSG_DISMISS = 1;
    private static final String TAG = "CalloutPopupWindow";
    private Handler handler;
    private Drawable leftPointerDrawable;
    private int leftPointerRes;
    private int lifeTime;
    private int mAlignMode;
    private ImageView mAnchorImage;
    private LinearLayout mContainer;
    private FrameLayout mContent;
    private int mMarginScreen;
    private int mMarginView;
    private int position;
    private ShadowParams shadowParams;
    private Drawable upPointerDrawable;
    private int upPointerRes;

    /* loaded from: classes27.dex */
    public interface AlignMode {
        public static final int AUTO_OFFSET = 83;
        public static final int CENTER_FIX = 82;
        public static final int DEFAULT = 81;
    }

    /* loaded from: classes27.dex */
    public static class DrawableBuilder {
        static IPatchRedirector $redirector_;
        private int color;
        private int pointerHeight;
        private int pointerWidth;
        private int radius;
        private Builder windowBuilder;

        public DrawableBuilder(Builder builder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
                return;
            }
            this.pointerWidth = 12;
            this.pointerHeight = 8;
            this.windowBuilder = builder;
        }

        private static Drawable createRoundedRectDrawable(float f16, int i3) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null));
            shapeDrawable.getPaint().setColor(i3);
            return shapeDrawable;
        }

        private static Drawable createTriangleDrawable(int i3, int i16, int i17, int i18) {
            TriangleShape triangleShape = new TriangleShape(getDirection(i17));
            triangleShape.resize(i3, i16);
            ShapeDrawable shapeDrawable = new ShapeDrawable(triangleShape);
            shapeDrawable.setIntrinsicWidth(i3);
            shapeDrawable.setIntrinsicHeight(i16);
            shapeDrawable.getPaint().setColor(i18);
            return shapeDrawable;
        }

        private int dp2px(float f16) {
            return x.c(this.windowBuilder.context, f16);
        }

        private static int getDirection(int i3) {
            switch (i3) {
                case 49:
                    return 33;
                case 50:
                    return 34;
                case 51:
                    return 36;
                case 52:
                    return 35;
                default:
                    return 32;
            }
        }

        public Builder build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            this.windowBuilder.setBackgroundDrawable(createRoundedRectDrawable(dp2px(this.radius), this.color));
            Drawable createTriangleDrawable = createTriangleDrawable(dp2px(this.pointerWidth), dp2px(this.pointerHeight), 49, this.color);
            this.windowBuilder.setLeftPointerDrawable(createTriangleDrawable(dp2px(this.pointerHeight), dp2px(this.pointerWidth), 51, this.color));
            this.windowBuilder.setUpPointerDrawable(createTriangleDrawable);
            return this.windowBuilder;
        }

        public DrawableBuilder setBackgroundColor(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DrawableBuilder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.color = i3;
            return this;
        }

        public DrawableBuilder setBackgroundRadius(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DrawableBuilder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.radius = i3;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static class InnerHandler extends Handler {
        static IPatchRedirector $redirector_;

        public InnerHandler() {
            super(Looper.getMainLooper());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Object obj2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1 && (obj = message.obj) != null && (obj2 = ((WeakReference) obj).get()) != null && (obj2 instanceof CalloutPopupWindow)) {
                ((CalloutPopupWindow) obj2).dismiss();
            }
        }
    }

    /* loaded from: classes27.dex */
    public interface Position {
        public static final int ABOVE = 49;
        public static final int BELOW = 50;
        public static final int LEFT = 51;
        public static final int RIGHT = 52;
    }

    /* loaded from: classes27.dex */
    public class ShadowLinearLayout extends LinearLayout {
        static IPatchRedirector $redirector_;
        private final Paint mShadowPaint;

        public ShadowLinearLayout(Context context, ShadowParams shadowParams) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CalloutPopupWindow.this, context, shadowParams);
                return;
            }
            this.mShadowPaint = new Paint(1);
            setLayerType(1, null);
            setWillNotDraw(false);
            initShadowPaint(context, shadowParams);
            int c16 = x.c(context, shadowParams.mShadowReservePaddingDp);
            setPadding(c16, c16, c16, c16);
        }

        private void drawAnchorShadow(Canvas canvas) {
            Path path = new Path();
            float paddingLeft = CalloutPopupWindow.this.mAnchorImage.getPaddingLeft();
            float paddingTop = CalloutPopupWindow.this.mAnchorImage.getPaddingTop();
            float width = CalloutPopupWindow.this.mAnchorImage.getWidth() - CalloutPopupWindow.this.mAnchorImage.getPaddingRight();
            float height = CalloutPopupWindow.this.mAnchorImage.getHeight() - CalloutPopupWindow.this.mAnchorImage.getPaddingBottom();
            float x16 = paddingLeft + CalloutPopupWindow.this.mAnchorImage.getX();
            float x17 = width + CalloutPopupWindow.this.mAnchorImage.getX();
            float y16 = paddingTop + CalloutPopupWindow.this.mAnchorImage.getY();
            float y17 = height + CalloutPopupWindow.this.mAnchorImage.getY();
            if (CalloutPopupWindow.this.position == 49) {
                path.moveTo(x16, y16);
                path.lineTo((x16 + x17) / 2.0f, y17);
                path.lineTo(x17, y16);
                path.close();
            } else if (CalloutPopupWindow.this.position == 50) {
                path.moveTo(x16, y17);
                path.lineTo((x16 + x17) / 2.0f, y16);
                path.lineTo(x17, y17);
                path.close();
            } else if (CalloutPopupWindow.this.position == 51) {
                path.moveTo(x16, y16);
                path.lineTo(x17, (y16 + y17) / 2.0f);
                path.lineTo(x16, y17);
                path.close();
            } else {
                path.moveTo(x17, y16);
                path.lineTo(x16, (y16 + y17) / 2.0f);
                path.lineTo(x17, y17);
                path.close();
            }
            canvas.drawPath(path, this.mShadowPaint);
        }

        private void drawContentShadow(Canvas canvas) {
            RectF rectF = new RectF();
            float width = CalloutPopupWindow.this.mContent.getWidth();
            float height = CalloutPopupWindow.this.mContent.getHeight();
            float x16 = CalloutPopupWindow.this.mContent.getX() + 0.0f;
            float x17 = width + CalloutPopupWindow.this.mContent.getX();
            float y16 = CalloutPopupWindow.this.mContent.getY() + 0.0f;
            float y17 = height + CalloutPopupWindow.this.mContent.getY();
            rectF.left = x16;
            rectF.top = y16;
            rectF.right = x17;
            rectF.bottom = y17;
            canvas.drawRect(rectF, this.mShadowPaint);
        }

        private void initShadowPaint(Context context, ShadowParams shadowParams) {
            this.mShadowPaint.setColor(0);
            if (shadowParams != null) {
                this.mShadowPaint.setShadowLayer(x.c(context, shadowParams.mShadowRadiusDp), x.c(context, shadowParams.mShadowOffsetXDp), x.c(context, shadowParams.mShadowOffsetYDp), shadowParams.mShadowColor);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            drawContentShadow(canvas);
            drawAnchorShadow(canvas);
            super.onDraw(canvas);
        }
    }

    /* loaded from: classes27.dex */
    public static class ShadowParams {
        static IPatchRedirector $redirector_;
        int mShadowColor;
        float mShadowOffsetXDp;
        float mShadowOffsetYDp;
        float mShadowRadiusDp;
        float mShadowReservePaddingDp;

        public ShadowParams(float f16, float f17, float f18, float f19, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3));
                return;
            }
            this.mShadowOffsetXDp = f16;
            this.mShadowOffsetYDp = f17;
            this.mShadowRadiusDp = f18;
            this.mShadowReservePaddingDp = f19;
            this.mShadowColor = i3;
        }
    }

    public CalloutPopupWindow(Context context, int i3, int i16, ShadowParams shadowParams) {
        this(context, i3, -2, i16, shadowParams);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), shadowParams);
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    private void computePointerLocation(View view, int i3, int i16) {
        Drawable drawable = this.mAnchorImage.getDrawable();
        int i17 = this.position;
        if (i17 != 51 && i17 != 52) {
            this.mAnchorImage.setPadding(((view.getWidth() - drawable.getIntrinsicWidth()) / 2) - i3, 0, 0, 0);
        } else {
            this.mAnchorImage.setPadding(0, ((this.mContent.getMeasuredHeight() - drawable.getIntrinsicHeight()) / 2) - i16, 0, 0);
        }
    }

    private void flipImageView(ImageView imageView) {
        Rect rect = new Rect(0, 0, imageView.getDrawable().getIntrinsicWidth(), imageView.getDrawable().getIntrinsicHeight());
        Matrix matrix = new Matrix();
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        matrix.postRotate(180.0f, rect.width() / 2, rect.height() / 2);
        imageView.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0160 A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:3:0x0007, B:6:0x0058, B:10:0x0067, B:12:0x0077, B:13:0x0095, B:15:0x0099, B:16:0x013e, B:21:0x015a, B:23:0x0160, B:24:0x016a, B:26:0x0172, B:28:0x018c, B:30:0x0195, B:31:0x01bc, B:33:0x01c4, B:38:0x0179, B:40:0x017f, B:41:0x0183, B:43:0x0189, B:47:0x00bd, B:51:0x0090, B:53:0x00cd, B:55:0x00e3, B:56:0x00ff, B:58:0x0103, B:61:0x012d, B:65:0x00f4, B:67:0x004c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0172 A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:3:0x0007, B:6:0x0058, B:10:0x0067, B:12:0x0077, B:13:0x0095, B:15:0x0099, B:16:0x013e, B:21:0x015a, B:23:0x0160, B:24:0x016a, B:26:0x0172, B:28:0x018c, B:30:0x0195, B:31:0x01bc, B:33:0x01c4, B:38:0x0179, B:40:0x017f, B:41:0x0183, B:43:0x0189, B:47:0x00bd, B:51:0x0090, B:53:0x00cd, B:55:0x00e3, B:56:0x00ff, B:58:0x0103, B:61:0x012d, B:65:0x00f4, B:67:0x004c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0195 A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:3:0x0007, B:6:0x0058, B:10:0x0067, B:12:0x0077, B:13:0x0095, B:15:0x0099, B:16:0x013e, B:21:0x015a, B:23:0x0160, B:24:0x016a, B:26:0x0172, B:28:0x018c, B:30:0x0195, B:31:0x01bc, B:33:0x01c4, B:38:0x0179, B:40:0x017f, B:41:0x0183, B:43:0x0189, B:47:0x00bd, B:51:0x0090, B:53:0x00cd, B:55:0x00e3, B:56:0x00ff, B:58:0x0103, B:61:0x012d, B:65:0x00f4, B:67:0x004c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c4 A[Catch: Exception -> 0x01d9, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d9, blocks: (B:3:0x0007, B:6:0x0058, B:10:0x0067, B:12:0x0077, B:13:0x0095, B:15:0x0099, B:16:0x013e, B:21:0x015a, B:23:0x0160, B:24:0x016a, B:26:0x0172, B:28:0x018c, B:30:0x0195, B:31:0x01bc, B:33:0x01c4, B:38:0x0179, B:40:0x017f, B:41:0x0183, B:43:0x0189, B:47:0x00bd, B:51:0x0090, B:53:0x00cd, B:55:0x00e3, B:56:0x00ff, B:58:0x0103, B:61:0x012d, B:65:0x00f4, B:67:0x004c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017f A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:3:0x0007, B:6:0x0058, B:10:0x0067, B:12:0x0077, B:13:0x0095, B:15:0x0099, B:16:0x013e, B:21:0x015a, B:23:0x0160, B:24:0x016a, B:26:0x0172, B:28:0x018c, B:30:0x0195, B:31:0x01bc, B:33:0x01c4, B:38:0x0179, B:40:0x017f, B:41:0x0183, B:43:0x0189, B:47:0x00bd, B:51:0x0090, B:53:0x00cd, B:55:0x00e3, B:56:0x00ff, B:58:0x0103, B:61:0x012d, B:65:0x00f4, B:67:0x004c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0189 A[Catch: Exception -> 0x01d9, TryCatch #0 {Exception -> 0x01d9, blocks: (B:3:0x0007, B:6:0x0058, B:10:0x0067, B:12:0x0077, B:13:0x0095, B:15:0x0099, B:16:0x013e, B:21:0x015a, B:23:0x0160, B:24:0x016a, B:26:0x0172, B:28:0x018c, B:30:0x0195, B:31:0x01bc, B:33:0x01c4, B:38:0x0179, B:40:0x017f, B:41:0x0183, B:43:0x0189, B:47:0x00bd, B:51:0x0090, B:53:0x00cd, B:55:0x00e3, B:56:0x00ff, B:58:0x0103, B:61:0x012d, B:65:0x00f4, B:67:0x004c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showInternal(View view, int i3, int i16) {
        int c16;
        int i17;
        int i18;
        int i19;
        int width;
        int i26;
        int measuredHeight;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        try {
            this.mContent.measure(x.c(view.getContext(), 300.0f), x.c(view.getContext(), 120.0f));
            this.mMarginView = x.c(view.getContext(), this.mMarginView);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int i46 = rect.right - rect.left;
            int i47 = rect.bottom - rect.top;
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (this.shadowParams == null) {
                c16 = 0;
            } else {
                c16 = x.c(view.getContext(), this.shadowParams.mShadowReservePaddingDp);
            }
            int i48 = this.position;
            if (i48 != 51 && i48 != 52) {
                int intrinsicHeight = this.mAnchorImage.getDrawable().getIntrinsicHeight();
                int i49 = this.position;
                if (i49 == 49) {
                    i18 = ((((this.mContent.getMeasuredHeight() + view.getHeight()) + intrinsicHeight) + (c16 * 2)) * (-1)) - this.mMarginView;
                } else if (i49 == 50) {
                    i18 = this.mMarginView;
                } else {
                    i18 = i16;
                }
                int i56 = this.mAlignMode;
                if (i56 == 83) {
                    i17 = (int) (((view.getWidth() - getWidth()) / 2) + ((((rect.centerX() - iArr[0]) / i46) * getWidth()) / 2.0f));
                } else if (i56 == 82) {
                    i17 = (view.getWidth() - getWidth()) / 2;
                } else {
                    i17 = i3;
                }
                i19 = iArr[0] + i17;
                width = getWidth() + i19;
                i26 = iArr[1] + i18;
                measuredHeight = this.mContent.getMeasuredHeight() + i26;
                i27 = this.position;
                if (i27 != 51 && i27 != 52) {
                    i37 = this.mMarginScreen;
                    if (width > i46 - i37) {
                        i17 = ((i46 - i37) - getWidth()) - iArr[0];
                    }
                    i38 = rect.left;
                    i39 = this.mMarginScreen;
                    if (i19 < i38 + i39) {
                        i17 = (i38 + i39) - iArr[0];
                    }
                    i29 = 0;
                    computePointerLocation(view, i17, i29);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, ".VASH", "show tips xoff=%d, yAnchorOff=%d, yoff=%d", Integer.valueOf(i17), Integer.valueOf(i29), Integer.valueOf(i18));
                    }
                    super.showAsDropDown(view, i17, i18 + i29);
                    if (this.lifeTime <= 0) {
                        Handler handler = this.handler;
                        handler.sendMessageDelayed(handler.obtainMessage(1, new WeakReference(this)), this.lifeTime * 1000);
                        return;
                    }
                    return;
                }
                i28 = this.mMarginScreen;
                if (measuredHeight <= i47 - i28) {
                    i29 = measuredHeight - (i47 - i28);
                } else {
                    i29 = 0;
                }
                i36 = rect.top;
                if (i26 < i36 + i28) {
                    i29 = (i36 + i28) - i26;
                }
                computePointerLocation(view, i17, i29);
                if (QLog.isColorLevel()) {
                }
                super.showAsDropDown(view, i17, i18 + i29);
                if (this.lifeTime <= 0) {
                }
            }
            int intrinsicWidth = this.mAnchorImage.getDrawable().getIntrinsicWidth();
            setWidth(getWidth() + intrinsicWidth);
            int i57 = this.position;
            if (i57 == 51) {
                i17 = ((this.mContent.getMeasuredWidth() + intrinsicWidth) * (-1)) - this.mMarginView;
            } else if (i57 == 52) {
                i17 = view.getWidth() + intrinsicWidth + this.mMarginView;
            } else {
                i17 = i3;
            }
            int i58 = this.mAlignMode;
            if (i58 == 83) {
                i18 = ((int) (((view.getHeight() + this.mContent.getMeasuredHeight()) / 2) - ((((rect.centerY() - iArr[1]) / i47) * this.mContent.getMeasuredWidth()) / 2.0f))) * (-1);
            } else if (i58 == 82) {
                i18 = ((view.getHeight() + this.mContent.getMeasuredHeight()) * (-1)) / 2;
            } else {
                i18 = i16;
            }
            i19 = iArr[0] + i17;
            width = getWidth() + i19;
            i26 = iArr[1] + i18;
            measuredHeight = this.mContent.getMeasuredHeight() + i26;
            i27 = this.position;
            if (i27 != 51) {
                i37 = this.mMarginScreen;
                if (width > i46 - i37) {
                }
                i38 = rect.left;
                i39 = this.mMarginScreen;
                if (i19 < i38 + i39) {
                }
                i29 = 0;
                computePointerLocation(view, i17, i29);
                if (QLog.isColorLevel()) {
                }
                super.showAsDropDown(view, i17, i18 + i29);
                if (this.lifeTime <= 0) {
                }
            }
            i28 = this.mMarginScreen;
            if (measuredHeight <= i47 - i28) {
            }
            i36 = rect.top;
            if (i26 < i36 + i28) {
            }
            computePointerLocation(view, i17, i29);
            if (QLog.isColorLevel()) {
            }
            super.showAsDropDown(view, i17, i18 + i29);
            if (this.lifeTime <= 0) {
            }
        } catch (Exception e16) {
            Log.e(TAG, "[showInternal] failed to show window", e16);
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.handler.removeMessages(1);
        try {
            super.dismiss();
        } catch (IllegalArgumentException unused) {
        }
    }

    public void setAlignMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mAlignMode = i3;
        }
    }

    @Override // android.widget.PopupWindow
    public void setBackgroundDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
        } else {
            this.mContent.setBackgroundDrawable(drawable);
            super.setBackgroundDrawable(new ColorDrawable());
        }
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            this.mContainer.removeAllViews();
            switch (this.position) {
                case 49:
                    this.mContainer.addView(this.mContent, -2, -2);
                    this.mContainer.addView(this.mAnchorImage, -2, -2);
                    Drawable drawable = this.upPointerDrawable;
                    if (drawable != null) {
                        this.mAnchorImage.setImageDrawable(drawable);
                    } else {
                        this.mAnchorImage.setImageResource(this.upPointerRes);
                    }
                    flipImageView(this.mAnchorImage);
                    break;
                case 50:
                    this.mContainer.addView(this.mAnchorImage, -2, -2);
                    this.mContainer.addView(this.mContent, -2, -2);
                    Drawable drawable2 = this.upPointerDrawable;
                    if (drawable2 != null) {
                        this.mAnchorImage.setImageDrawable(drawable2);
                        break;
                    } else {
                        this.mAnchorImage.setImageResource(this.upPointerRes);
                        break;
                    }
                case 51:
                    this.mContainer.setOrientation(0);
                    this.mContainer.addView(this.mContent, -2, -2);
                    this.mContainer.addView(this.mAnchorImage, -2, -2);
                    Drawable drawable3 = this.leftPointerDrawable;
                    if (drawable3 != null) {
                        this.mAnchorImage.setImageDrawable(drawable3);
                    } else {
                        this.mAnchorImage.setImageResource(this.leftPointerRes);
                    }
                    flipImageView(this.mAnchorImage);
                    break;
                case 52:
                    this.mContainer.setOrientation(0);
                    this.mContainer.addView(this.mAnchorImage, -2, -2);
                    this.mContainer.addView(this.mContent, -2, -2);
                    Drawable drawable4 = this.leftPointerDrawable;
                    if (drawable4 != null) {
                        this.mAnchorImage.setImageDrawable(drawable4);
                        break;
                    } else {
                        this.mAnchorImage.setImageResource(this.leftPointerRes);
                        break;
                    }
            }
            this.mContent.addView(view, -2, -2);
            super.setContentView(this.mContainer);
        }
    }

    public void setLeftPointerImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
        } else {
            this.leftPointerDrawable = drawable;
        }
    }

    public void setLeftPointerImageRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.leftPointerRes = i3;
        }
    }

    public void setMarginScreen(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mMarginScreen = i3;
        }
    }

    public void setMarginView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mMarginView = i3;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onClickListener);
        } else {
            this.mContainer.setOnClickListener(onClickListener);
        }
    }

    public void setPointerImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
        } else {
            this.upPointerDrawable = drawable;
        }
    }

    public void setPointerImageRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.upPointerRes = i3;
        }
    }

    public void showAsPointer(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            showAsPointer(view, 0, 0);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0169 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a4, B:18:0x00a8, B:19:0x0149, B:23:0x0163, B:25:0x0169, B:26:0x0173, B:28:0x017b, B:29:0x0193, B:31:0x01a7, B:35:0x0181, B:37:0x0187, B:38:0x018a, B:40:0x0190, B:42:0x00ca, B:46:0x009f, B:48:0x00db, B:50:0x00f1, B:51:0x010b, B:53:0x010f, B:56:0x0137, B:59:0x0100), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x017b A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a4, B:18:0x00a8, B:19:0x0149, B:23:0x0163, B:25:0x0169, B:26:0x0173, B:28:0x017b, B:29:0x0193, B:31:0x01a7, B:35:0x0181, B:37:0x0187, B:38:0x018a, B:40:0x0190, B:42:0x00ca, B:46:0x009f, B:48:0x00db, B:50:0x00f1, B:51:0x010b, B:53:0x010f, B:56:0x0137, B:59:0x0100), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a7 A[Catch: Exception -> 0x01bc, TRY_LEAVE, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a4, B:18:0x00a8, B:19:0x0149, B:23:0x0163, B:25:0x0169, B:26:0x0173, B:28:0x017b, B:29:0x0193, B:31:0x01a7, B:35:0x0181, B:37:0x0187, B:38:0x018a, B:40:0x0190, B:42:0x00ca, B:46:0x009f, B:48:0x00db, B:50:0x00f1, B:51:0x010b, B:53:0x010f, B:56:0x0137, B:59:0x0100), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0187 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a4, B:18:0x00a8, B:19:0x0149, B:23:0x0163, B:25:0x0169, B:26:0x0173, B:28:0x017b, B:29:0x0193, B:31:0x01a7, B:35:0x0181, B:37:0x0187, B:38:0x018a, B:40:0x0190, B:42:0x00ca, B:46:0x009f, B:48:0x00db, B:50:0x00f1, B:51:0x010b, B:53:0x010f, B:56:0x0137, B:59:0x0100), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0190 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a4, B:18:0x00a8, B:19:0x0149, B:23:0x0163, B:25:0x0169, B:26:0x0173, B:28:0x017b, B:29:0x0193, B:31:0x01a7, B:35:0x0181, B:37:0x0187, B:38:0x018a, B:40:0x0190, B:42:0x00ca, B:46:0x009f, B:48:0x00db, B:50:0x00f1, B:51:0x010b, B:53:0x010f, B:56:0x0137, B:59:0x0100), top: B:8:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showAsPointerAtLocation(View view, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int width;
        int i27;
        int measuredHeight;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i46 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            this.mContent.measure(x.c(view.getContext(), 300.0f), x.c(view.getContext(), 120.0f));
            this.mMarginView = x.c(view.getContext(), this.mMarginView);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int i47 = rect.right - rect.left;
            int i48 = rect.bottom - rect.top;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i49 = this.position;
            if (i49 != 51 && i49 != 52) {
                int intrinsicHeight = this.mAnchorImage.getDrawable().getIntrinsicHeight();
                int i56 = this.position;
                if (i56 == 49) {
                    i18 = (((this.mContent.getMeasuredHeight() + view.getHeight()) + intrinsicHeight) * (-1)) - this.mMarginView;
                } else if (i56 == 50) {
                    i18 = this.mMarginView;
                } else {
                    i18 = i16;
                }
                int i57 = this.mAlignMode;
                if (i57 == 83) {
                    i19 = (int) (((view.getWidth() - getWidth()) / 2) + ((((rect.centerX() - iArr[0]) / i47) * getWidth()) / 2.0f));
                } else if (i57 == 82) {
                    i19 = (view.getWidth() - getWidth()) / 2;
                } else {
                    i19 = i3;
                }
                i26 = iArr[0] + i19;
                width = getWidth() + i26;
                i27 = iArr[1] + i18;
                measuredHeight = this.mContent.getMeasuredHeight() + i27;
                i28 = this.position;
                if (i28 != 51 && i28 != 52) {
                    i37 = this.mMarginScreen;
                    if (width > i47 - i37) {
                        i19 = ((i47 - i37) - getWidth()) - iArr[0];
                    }
                    i38 = rect.left;
                    i39 = this.mMarginScreen;
                    if (i26 < i38 + i39) {
                        i19 = (i38 + i39) - iArr[0];
                    }
                    computePointerLocation(view, i19, i46);
                    super.showAtLocation(view, 51, i26, iArr[1] + i18 + i46 + view.getHeight());
                    if (this.lifeTime <= 0) {
                        Handler handler = this.handler;
                        handler.sendMessageDelayed(handler.obtainMessage(1, new WeakReference(this)), this.lifeTime * 1000);
                        return;
                    }
                    return;
                }
                i29 = this.mMarginScreen;
                if (measuredHeight > i48 - i29) {
                    i46 = measuredHeight - (i48 - i29);
                }
                i36 = rect.top;
                if (i27 < i36 + i29) {
                    i46 = (i36 + i29) - i27;
                }
                computePointerLocation(view, i19, i46);
                super.showAtLocation(view, 51, i26, iArr[1] + i18 + i46 + view.getHeight());
                if (this.lifeTime <= 0) {
                }
            }
            int intrinsicWidth = this.mAnchorImage.getDrawable().getIntrinsicWidth();
            setWidth(getWidth() + intrinsicWidth);
            int i58 = this.position;
            if (i58 == 51) {
                i17 = ((this.mContent.getMeasuredWidth() + intrinsicWidth) * (-1)) - this.mMarginView;
            } else if (i58 == 52) {
                i17 = view.getWidth() + intrinsicWidth + this.mMarginView;
            } else {
                i17 = i3;
            }
            int i59 = this.mAlignMode;
            if (i59 == 83) {
                i18 = ((int) (((view.getHeight() + this.mContent.getMeasuredHeight()) / 2) - ((((rect.centerY() - iArr[1]) / i48) * this.mContent.getMeasuredWidth()) / 2.0f))) * (-1);
            } else if (i59 == 82) {
                i18 = ((view.getHeight() + this.mContent.getMeasuredHeight()) * (-1)) / 2;
            } else {
                i18 = i16;
            }
            i19 = i17;
            i26 = iArr[0] + i19;
            width = getWidth() + i26;
            i27 = iArr[1] + i18;
            measuredHeight = this.mContent.getMeasuredHeight() + i27;
            i28 = this.position;
            if (i28 != 51) {
                i37 = this.mMarginScreen;
                if (width > i47 - i37) {
                }
                i38 = rect.left;
                i39 = this.mMarginScreen;
                if (i26 < i38 + i39) {
                }
                computePointerLocation(view, i19, i46);
                super.showAtLocation(view, 51, i26, iArr[1] + i18 + i46 + view.getHeight());
                if (this.lifeTime <= 0) {
                }
            }
            i29 = this.mMarginScreen;
            if (measuredHeight > i48 - i29) {
            }
            i36 = rect.top;
            if (i27 < i36 + i29) {
            }
            computePointerLocation(view, i19, i46);
            super.showAtLocation(view, 51, i26, iArr[1] + i18 + i46 + view.getHeight());
            if (this.lifeTime <= 0) {
            }
        } catch (Exception e16) {
            Log.e(TAG, "[showInternal] failed to show window", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0165 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a3, B:18:0x00a7, B:19:0x0145, B:23:0x015f, B:25:0x0165, B:26:0x016f, B:28:0x0177, B:29:0x018f, B:31:0x01a7, B:35:0x017d, B:37:0x0183, B:38:0x0186, B:40:0x018c, B:42:0x00c9, B:46:0x009f, B:48:0x00d9, B:50:0x00ef, B:51:0x0108, B:53:0x010c, B:56:0x0134, B:59:0x00fe), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0177 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a3, B:18:0x00a7, B:19:0x0145, B:23:0x015f, B:25:0x0165, B:26:0x016f, B:28:0x0177, B:29:0x018f, B:31:0x01a7, B:35:0x017d, B:37:0x0183, B:38:0x0186, B:40:0x018c, B:42:0x00c9, B:46:0x009f, B:48:0x00d9, B:50:0x00ef, B:51:0x0108, B:53:0x010c, B:56:0x0134, B:59:0x00fe), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a7 A[Catch: Exception -> 0x01bc, TRY_LEAVE, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a3, B:18:0x00a7, B:19:0x0145, B:23:0x015f, B:25:0x0165, B:26:0x016f, B:28:0x0177, B:29:0x018f, B:31:0x01a7, B:35:0x017d, B:37:0x0183, B:38:0x0186, B:40:0x018c, B:42:0x00c9, B:46:0x009f, B:48:0x00d9, B:50:0x00ef, B:51:0x0108, B:53:0x010c, B:56:0x0134, B:59:0x00fe), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0183 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a3, B:18:0x00a7, B:19:0x0145, B:23:0x015f, B:25:0x0165, B:26:0x016f, B:28:0x0177, B:29:0x018f, B:31:0x01a7, B:35:0x017d, B:37:0x0183, B:38:0x0186, B:40:0x018c, B:42:0x00c9, B:46:0x009f, B:48:0x00d9, B:50:0x00ef, B:51:0x0108, B:53:0x010c, B:56:0x0134, B:59:0x00fe), top: B:8:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018c A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:9:0x002b, B:13:0x0079, B:15:0x0089, B:16:0x00a3, B:18:0x00a7, B:19:0x0145, B:23:0x015f, B:25:0x0165, B:26:0x016f, B:28:0x0177, B:29:0x018f, B:31:0x01a7, B:35:0x017d, B:37:0x0183, B:38:0x0186, B:40:0x018c, B:42:0x00c9, B:46:0x009f, B:48:0x00d9, B:50:0x00ef, B:51:0x0108, B:53:0x010c, B:56:0x0134, B:59:0x00fe), top: B:8:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showAsPointerAtLocationWithOffset(View view, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int width;
        int i27;
        int measuredHeight;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i46 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            this.mContent.measure(x.c(view.getContext(), 300.0f), x.c(view.getContext(), 120.0f));
            this.mMarginView = x.c(view.getContext(), this.mMarginView);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int i47 = rect.right - rect.left;
            int i48 = rect.bottom - rect.top;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i49 = this.position;
            if (i49 != 51 && i49 != 52) {
                int intrinsicHeight = this.mAnchorImage.getDrawable().getIntrinsicHeight();
                int i56 = this.position;
                if (i56 == 49) {
                    i18 = (((this.mContent.getMeasuredHeight() + view.getHeight()) + intrinsicHeight) * (-1)) - this.mMarginView;
                } else if (i56 == 50) {
                    i18 = this.mMarginView;
                } else {
                    i18 = 0;
                }
                int i57 = this.mAlignMode;
                if (i57 == 83) {
                    i19 = (int) (((view.getWidth() - getWidth()) / 2) + ((((rect.centerX() - iArr[0]) / i47) * getWidth()) / 2.0f));
                } else if (i57 == 82) {
                    i19 = (view.getWidth() - getWidth()) / 2;
                } else {
                    i19 = 0;
                }
                i26 = iArr[0] + i19;
                width = getWidth() + i26;
                i27 = iArr[1] + i18;
                measuredHeight = this.mContent.getMeasuredHeight() + i27;
                i28 = this.position;
                if (i28 != 51 && i28 != 52) {
                    i37 = this.mMarginScreen;
                    if (width > i47 - i37) {
                        i19 = ((i47 - i37) - getWidth()) - iArr[0];
                    }
                    i38 = rect.left;
                    i39 = this.mMarginScreen;
                    if (i26 < i38 + i39) {
                        i19 = (i38 + i39) - iArr[0];
                    }
                    computePointerLocation(view, i19, i46);
                    super.showAtLocation(view, 51, i19 + i3, iArr[1] + i18 + i46 + view.getHeight() + i16);
                    if (this.lifeTime <= 0) {
                        Handler handler = this.handler;
                        handler.sendMessageDelayed(handler.obtainMessage(1, new WeakReference(this)), this.lifeTime * 1000);
                        return;
                    }
                    return;
                }
                i29 = this.mMarginScreen;
                if (measuredHeight > i48 - i29) {
                    i46 = measuredHeight - (i48 - i29);
                }
                i36 = rect.top;
                if (i27 < i36 + i29) {
                    i46 = (i36 + i29) - i27;
                }
                computePointerLocation(view, i19, i46);
                super.showAtLocation(view, 51, i19 + i3, iArr[1] + i18 + i46 + view.getHeight() + i16);
                if (this.lifeTime <= 0) {
                }
            }
            int intrinsicWidth = this.mAnchorImage.getDrawable().getIntrinsicWidth();
            setWidth(getWidth() + intrinsicWidth);
            int i58 = this.position;
            if (i58 == 51) {
                i17 = ((this.mContent.getMeasuredWidth() + intrinsicWidth) * (-1)) - this.mMarginView;
            } else if (i58 == 52) {
                i17 = view.getWidth() + intrinsicWidth + this.mMarginView;
            } else {
                i17 = 0;
            }
            int i59 = this.mAlignMode;
            if (i59 == 83) {
                i18 = ((int) (((view.getHeight() + this.mContent.getMeasuredHeight()) / 2) - ((((rect.centerY() - iArr[1]) / i48) * this.mContent.getMeasuredWidth()) / 2.0f))) * (-1);
            } else if (i59 == 82) {
                i18 = ((view.getHeight() + this.mContent.getMeasuredHeight()) * (-1)) / 2;
            } else {
                i18 = 0;
            }
            i19 = i17;
            i26 = iArr[0] + i19;
            width = getWidth() + i26;
            i27 = iArr[1] + i18;
            measuredHeight = this.mContent.getMeasuredHeight() + i27;
            i28 = this.position;
            if (i28 != 51) {
                i37 = this.mMarginScreen;
                if (width > i47 - i37) {
                }
                i38 = rect.left;
                i39 = this.mMarginScreen;
                if (i26 < i38 + i39) {
                }
                computePointerLocation(view, i19, i46);
                super.showAtLocation(view, 51, i19 + i3, iArr[1] + i18 + i46 + view.getHeight() + i16);
                if (this.lifeTime <= 0) {
                }
            }
            i29 = this.mMarginScreen;
            if (measuredHeight > i48 - i29) {
            }
            i36 = rect.top;
            if (i27 < i36 + i29) {
            }
            computePointerLocation(view, i19, i46);
            super.showAtLocation(view, 51, i19 + i3, iArr[1] + i18 + i46 + view.getHeight() + i16);
            if (this.lifeTime <= 0) {
            }
        } catch (Exception e16) {
            Log.e(TAG, "[showInternal] failed to show window", e16);
        }
    }

    public CalloutPopupWindow(Context context, int i3, int i16, int i17, ShadowParams shadowParams) {
        super(i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), shadowParams);
            return;
        }
        this.mMarginView = 0;
        this.mAlignMode = 81;
        this.lifeTime = 0;
        this.handler = new InnerHandler();
        if (i3 >= 0) {
            this.position = i17;
            this.shadowParams = shadowParams;
            LinearLayout linearLayout = shadowParams == null ? new LinearLayout(context) : new ShadowLinearLayout(context, shadowParams);
            this.mContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mAnchorImage = new ImageView(context);
            this.mContent = new FrameLayout(context);
            setBackgroundDrawable(new ColorDrawable());
            setOutsideTouchable(true);
            setFocusable(false);
            return;
        }
        throw new RuntimeException("You must specify the window width explicitly(do not use WRAP_CONTENT or MATCH_PARENT)!!!");
    }

    public void showAsPointer(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (view.getWidth() == 0 && view.getVisibility() == 0) {
            this.handler.post(new Runnable(view, i3, i16) { // from class: com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f384738d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f384739e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f384740f;

                {
                    this.f384738d = view;
                    this.f384739e = i3;
                    this.f384740f = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, CalloutPopupWindow.this, view, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        CalloutPopupWindow.this.showInternal(this.f384738d, this.f384739e, this.f384740f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            showInternal(view, i3, i16);
        }
    }

    /* loaded from: classes27.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private boolean autoDismiss;
        private Drawable backgroundDrawable;
        private Context context;
        private int horizontalPaddingDp;
        private Drawable iconDrawable;
        private boolean isSingleLine;
        private Drawable leftPointerDrawable;
        private int leftPointerResource;
        private int lifeTime;
        private boolean lineBreakCompatible;
        private TextView mTextView;
        private int maxWidth;
        private int position;
        private ShadowParams shadowParams;
        private String text;
        private int textColor;
        private float textSize;
        private Drawable upPointerDrawable;
        private int upPointerResource;
        private int verticalPaddingDp;

        Builder(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            this.textSize = 12.0f;
            this.textColor = -1;
            this.upPointerResource = 17170445;
            this.leftPointerResource = 17170445;
            this.autoDismiss = true;
            this.lifeTime = 5;
            this.position = 49;
            this.maxWidth = 0;
            this.isSingleLine = false;
            this.verticalPaddingDp = 8;
            this.horizontalPaddingDp = 10;
            this.shadowParams = null;
            this.context = context;
        }

        private int getMaxWidth() {
            int i3 = this.maxWidth;
            if (i3 <= 0) {
                return x.c(this.context, 300.0f);
            }
            return Math.min(i3, x.c(this.context, 300.0f));
        }

        private int getShadowWidth(ShadowParams shadowParams) {
            Context context = this.context;
            if (context != null && shadowParams != null) {
                return x.c(context, shadowParams.mShadowReservePaddingDp) * 2;
            }
            return 0;
        }

        public CalloutPopupWindow build() {
            TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (CalloutPopupWindow) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            try {
                int maxWidth = getMaxWidth();
                int c16 = x.c(this.context, 120.0f);
                LinearLayout linearLayout = new LinearLayout(this.context);
                linearLayout.setOrientation(0);
                linearLayout.setPadding(x.c(this.context, this.horizontalPaddingDp), x.c(this.context, this.verticalPaddingDp), x.c(this.context, this.horizontalPaddingDp), x.c(this.context, this.verticalPaddingDp));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                linearLayout.setLayoutParams(layoutParams);
                if (this.iconDrawable != null) {
                    ImageView imageView = new ImageView(this.context);
                    int c17 = x.c(this.context, 32.0f);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c17, c17);
                    layoutParams2.rightMargin = x.c(this.context, 2.0f);
                    layoutParams2.gravity = 16;
                    imageView.setImageDrawable(this.iconDrawable);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout.addView(imageView, layoutParams2);
                }
                if (!this.lineBreakCompatible || (textView = this.mTextView) == null) {
                    textView = new TextView(this.context);
                }
                if (this.isSingleLine) {
                    textView.setSingleLine();
                }
                textView.setTextColor(this.context.getResources().getColor(R.color.white));
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                linearLayout.addView(textView);
                if (this.backgroundDrawable != null) {
                    int paddingLeft = linearLayout.getPaddingLeft();
                    int paddingTop = linearLayout.getPaddingTop();
                    int paddingRight = linearLayout.getPaddingRight();
                    int paddingBottom = linearLayout.getPaddingBottom();
                    linearLayout.setBackgroundDrawable(this.backgroundDrawable);
                    linearLayout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
                textView.setMaxWidth(maxWidth);
                textView.setMaxHeight(c16);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setText(this.text);
                textView.setTextSize(this.textSize);
                textView.setTextColor(this.textColor);
                linearLayout.measure(maxWidth, c16);
                CalloutPopupWindow calloutPopupWindow = new CalloutPopupWindow(this.context, linearLayout.getMeasuredWidth() + getShadowWidth(this.shadowParams), this.position, this.shadowParams);
                calloutPopupWindow.setPointerImageRes(this.upPointerResource);
                calloutPopupWindow.setPointerImageDrawable(this.upPointerDrawable);
                calloutPopupWindow.setLeftPointerImageDrawable(this.leftPointerDrawable);
                calloutPopupWindow.setLeftPointerImageRes(this.leftPointerResource);
                calloutPopupWindow.setContentView(linearLayout);
                calloutPopupWindow.setAlignMode(83);
                if (!this.autoDismiss) {
                    calloutPopupWindow.setOutsideTouchable(false);
                }
                calloutPopupWindow.setMarginScreen(x.c(this.context, 6.0f));
                calloutPopupWindow.lifeTime = this.lifeTime;
                return calloutPopupWindow;
            } catch (Throwable th5) {
                Log.e(CalloutPopupWindow.TAG, "[build] failed to build window", th5);
                return null;
            }
        }

        public Builder setBackgroundDrawable(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) drawable);
            }
            this.backgroundDrawable = drawable;
            return this;
        }

        public Builder setHorizontalPaddingDp(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.horizontalPaddingDp = i3;
            return this;
        }

        public Builder setIconDrawable(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
            }
            this.iconDrawable = drawable;
            return this;
        }

        public Builder setLeftPointerDrawable(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
            }
            this.leftPointerDrawable = drawable;
            return this;
        }

        public Builder setLifetime(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.lifeTime = i3;
            return this;
        }

        public Builder setLineBreakCompatible(boolean z16, TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), textView);
            }
            this.lineBreakCompatible = z16;
            this.mTextView = textView;
            return this;
        }

        public Builder setMaxWidth(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, i3);
            }
            this.maxWidth = i3;
            return this;
        }

        public Builder setPosition(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.position = i3;
            return this;
        }

        public Builder setShadowParams(ShadowParams shadowParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) shadowParams);
            }
            this.shadowParams = shadowParams;
            return this;
        }

        public Builder setText(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.text = str;
            return this;
        }

        public Builder setTextColor(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.textColor = i3;
            return this;
        }

        public Builder setTextSingleLine(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.isSingleLine = z16;
            return this;
        }

        public Builder setTextSize(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            }
            this.textSize = f16;
            return this;
        }

        public Builder setUpPointerDrawable(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            }
            this.upPointerDrawable = drawable;
            return this;
        }

        public Builder setVerticalPaddingDp(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.verticalPaddingDp = i3;
            return this;
        }

        public CalloutPopupWindow build(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (CalloutPopupWindow) iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
            }
            int maxWidth = getMaxWidth();
            int c16 = x.c(this.context, 120.0f);
            if (this.backgroundDrawable != null) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                view.setBackgroundDrawable(this.backgroundDrawable);
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            view.measure(maxWidth, c16);
            CalloutPopupWindow calloutPopupWindow = new CalloutPopupWindow(this.context, view.getMeasuredWidth() + getShadowWidth(this.shadowParams), this.position, this.shadowParams);
            calloutPopupWindow.setPointerImageRes(this.upPointerResource);
            calloutPopupWindow.setPointerImageDrawable(this.upPointerDrawable);
            calloutPopupWindow.setLeftPointerImageDrawable(this.leftPointerDrawable);
            calloutPopupWindow.setLeftPointerImageRes(this.leftPointerResource);
            calloutPopupWindow.setContentView(view);
            calloutPopupWindow.setAlignMode(83);
            if (!this.autoDismiss) {
                calloutPopupWindow.setOutsideTouchable(false);
            }
            calloutPopupWindow.setMarginScreen(x.c(this.context, 6.0f));
            calloutPopupWindow.lifeTime = this.lifeTime;
            return calloutPopupWindow;
        }
    }
}

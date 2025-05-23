package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class EditTextPreView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private DynamicTextItem f66909d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f66910e;

    /* renamed from: f, reason: collision with root package name */
    private b f66911f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClickable(false);
            accessibilityNodeInfoCompat.setClassName(TextView.class.getName());
            try {
                accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            } catch (Exception e16) {
                QLog.d("EditTextPreView", 1, "removeAction exception", e16);
            }
        }
    }

    /* loaded from: classes32.dex */
    public interface b {
        void a(View view, DynamicTextItem dynamicTextItem, int i3);
    }

    public EditTextPreView(Context context) {
        super(context);
        this.f66909d = null;
        a();
    }

    public void a() {
        Paint paint = new Paint();
        this.f66910e = paint;
        paint.setAntiAlias(true);
        this.f66910e.setDither(true);
        this.f66910e.setFilterBitmap(true);
        setScaleType(ImageView.ScaleType.CENTER);
        setClickable(true);
        if (AppSetting.f99565y) {
            ViewCompat.setAccessibilityDelegate(this, new a());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        DynamicTextItem dynamicTextItem = this.f66909d;
        if (dynamicTextItem != null) {
            dynamicTextItem.g(canvas);
        }
        canvas.restore();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 != 2) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        DynamicTextItem dynamicTextItem;
        if (isEnabled() && isClickable()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.f66911f != null && (dynamicTextItem = this.f66909d) != null) {
                        int u16 = dynamicTextItem.u(motionEvent, getWidth(), getHeight(), null, null);
                        if (u16 > -1) {
                            setText(u16, this.f66909d.p(u16));
                            this.f66909d.O(u16, true);
                            DynamicTextItem dynamicTextItem2 = this.f66909d;
                            dynamicTextItem2.M(u16, dynamicTextItem2.p(u16));
                            this.f66909d.c(u16);
                        }
                        this.f66911f.a(this, this.f66909d, u16);
                    }
                }
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @Deprecated
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new UnsupportedOperationException("unSupport normal click listener, use EditTextPreView.OnClickListener instead");
    }

    public void setPreViewDrawer(DynamicTextItem dynamicTextItem) {
        this.f66909d = dynamicTextItem;
        invalidate();
    }

    public void setText(int i3, String str) {
        DynamicTextItem dynamicTextItem = this.f66909d;
        if (dynamicTextItem != null && !str.equals(dynamicTextItem.p(i3))) {
            this.f66909d.M(i3, str);
            this.f66909d.L(false);
            AccessibilityUtil.s(this, str);
        }
        invalidate();
    }

    public void setOnClickListener(b bVar) {
        this.f66911f = bVar;
    }

    public EditTextPreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f66909d = null;
        a();
    }

    public EditTextPreView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f66909d = null;
        a();
    }
}

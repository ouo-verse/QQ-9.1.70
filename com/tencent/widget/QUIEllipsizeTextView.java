package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.DynamicLayout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QUIEllipsizeTextView extends TextView {
    static IPatchRedirector $redirector_ = null;
    private static final String FIELD_M_MAXIMUM_VISIBLE_LINE_COUNT = "mMaximumVisibleLineCount";
    private static final String FIELD_S_STATIC_LAYOUT = "sStaticLayout";
    private static final String TAG = "QUIForbidBreakTextView";
    private com.tencent.qqnt.classadapter.c flashNickName;

    public QUIEllipsizeTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        com.tencent.qqnt.classadapter.c cVar = this.flashNickName;
        if (cVar != null && !cVar.k()) {
            int height = getHeight();
            float j3 = this.flashNickName.j();
            if (height == 0) {
                height = this.flashNickName.i();
            }
            canvas.saveLayerAlpha(0.0f, 0.0f, j3, height, 255);
            super.onDraw(canvas);
            this.flashNickName.h(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        StaticLayout staticLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Field field = null;
        try {
            Field declaredField = DynamicLayout.class.getDeclaredField(FIELD_S_STATIC_LAYOUT);
            declaredField.setAccessible(true);
            staticLayout = (StaticLayout) declaredField.get(DynamicLayout.class);
        } catch (IllegalAccessException | NoSuchFieldException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            staticLayout = null;
        }
        if (staticLayout == null) {
            super.onMeasure(i3, i16);
            return;
        }
        try {
            field = StaticLayout.class.getDeclaredField(FIELD_M_MAXIMUM_VISIBLE_LINE_COUNT);
            field.setAccessible(true);
            field.setInt(staticLayout, getMaxLines());
        } catch (IllegalAccessException | NoSuchFieldException e17) {
            QLog.e(TAG, 1, e17, new Object[0]);
        }
        super.onMeasure(i3, i16);
        if (field == null) {
            return;
        }
        try {
            field.setInt(staticLayout, Integer.MAX_VALUE);
        } catch (IllegalAccessException e18) {
            QLog.e(TAG, 1, e18, new Object[0]);
        }
    }

    public void startScanning(int i3, int i16, String str, boolean z16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        com.tencent.qqnt.classadapter.c cVar = new com.tencent.qqnt.classadapter.c(i3, i16, str, z16, this);
        this.flashNickName = cVar;
        cVar.l(i17);
    }

    public void stopScanning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.qqnt.classadapter.c cVar = this.flashNickName;
        if (cVar != null) {
            cVar.n();
        }
    }

    public QUIEllipsizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIEllipsizeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}

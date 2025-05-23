package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class OCRBottomTabView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f315887d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f315888e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315889f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (OCRBottomTabView.this.f315889f) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        OCRBottomTabView.this.f315887d.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                }
                OCRBottomTabView.this.f315887d.setAlpha(0.5f);
                return false;
            }
            return false;
        }
    }

    public OCRBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315889f = true;
        d(context, attributeSet);
    }

    private void d(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.cbg, (ViewGroup) this, true);
        this.f315888e = (TextView) findViewById(R.id.k4a);
        this.f315887d = (ImageView) findViewById(R.id.drs);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ej2.a.N2);
        String string = obtainStyledAttributes.getString(ej2.a.P2);
        Drawable drawable = obtainStyledAttributes.getDrawable(ej2.a.O2);
        obtainStyledAttributes.recycle();
        if (!TextUtils.isEmpty(string)) {
            this.f315888e.setText(string);
        }
        if (drawable != null) {
            this.f315887d.setImageDrawable(drawable);
        }
        setOnTouchListener(new a());
    }

    public CharSequence c() {
        return this.f315888e.getText();
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        this.f315887d.setEnabled(z16);
        this.f315888e.setEnabled(z16);
    }

    public void setTabImage(Drawable drawable) {
        if (drawable != null) {
            this.f315887d.setImageDrawable(drawable);
        }
    }

    public void setTabText(String str) {
        if (str != null) {
            this.f315888e.setText(str);
        }
    }

    public void setTabTextColor(int i3) {
        this.f315888e.setTextColor(ColorStateList.valueOf(i3));
    }

    public OCRBottomTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315889f = true;
        d(context, attributeSet);
    }
}

package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class PAHighLightImageView extends PAImageView {
    private a S;
    private Context T;

    /* loaded from: classes20.dex */
    public static class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        PAHighLightImageView f315942d;

        /* renamed from: e, reason: collision with root package name */
        Context f315943e;

        public a(PAHighLightImageView pAHighLightImageView, Context context) {
            this.f315942d = pAHighLightImageView;
            this.f315943e = context;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z16;
            if (QLog.isColorLevel()) {
                QLog.d("PAHighLightImageView", 2, "onTouch is called,action is:" + motionEvent.getAction());
            }
            Object tag = this.f315942d.getTag(R.id.g4h);
            if (tag == null) {
                return false;
            }
            if (tag.equals(1)) {
                z16 = true;
            } else {
                if (tag.equals(2)) {
                    z16 = false;
                }
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.f315942d.d(this.f315943e, z16);
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.f315942d.e();
            }
            return false;
        }
    }

    public PAHighLightImageView(Context context) {
        super(context);
        this.T = context;
        a aVar = new a(this, context);
        this.S = aVar;
        setOnTouchListener(aVar);
    }

    public void d(Context context, boolean z16) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.findViewById(R.id.g4i) == null) {
            View view = new View(context);
            view.setId(R.id.g4i);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.argb(77, 0, 0, 0));
            if (z16) {
                gradientDrawable.setCornerRadius(BaseAIOUtils.f(5.0f, context.getResources()));
            }
            view.setBackgroundDrawable(gradientDrawable);
            viewGroup.addView(view, new ViewGroup.LayoutParams(getLayoutParams()));
        }
    }

    public void e() {
        View findViewById;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && (findViewById = viewGroup.findViewById(R.id.g4i)) != null) {
            viewGroup.removeView(findViewById);
        }
    }

    public PAHighLightImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T = context;
        a aVar = new a(this, context);
        this.S = aVar;
        setOnTouchListener(aVar);
    }

    public PAHighLightImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.T = context;
        a aVar = new a(this, context);
        this.S = aVar;
        setOnTouchListener(aVar);
    }
}

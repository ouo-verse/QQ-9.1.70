package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SimpleHeader extends RelativeLayout implements q {
    public SimpleHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.widget.p
    public View b() {
        return null;
    }

    @Override // com.tencent.mobileqq.widget.q
    public Object f(int i3, Object obj) {
        boolean z16;
        if (i3 == 6) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f72273qe);
            if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.widget.q
    public void j(int i3, Object obj) {
        if (i3 == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f72273qe);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.addRule(12);
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.skin_refresh_background));
            return;
        }
        if (i3 == 2) {
            View view = (View) obj;
            view.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.getScreenHeight()));
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.lts);
            if (indexOfChild(view) < 0) {
                viewGroup.addView(view);
            }
            viewGroup.setVisibility(0);
            return;
        }
        if (i3 == 23) {
            ((RelativeLayout) findViewById(R.id.lts)).setAlpha(((Float) obj).floatValue());
            return;
        }
        if (i3 == 4) {
            ((RelativeLayout) findViewById(R.id.f72273qe)).setVisibility(((Integer) obj).intValue());
        } else if (i3 == 22) {
            ((RelativeLayout.LayoutParams) ((RelativeLayout) findViewById(R.id.lts)).getLayoutParams()).bottomMargin = ((Integer) obj).intValue();
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public long k() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void g() {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void d(long j3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void h(long j3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void i(long j3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void l(int i3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgColor(int i3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgDrawable(Drawable drawable) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgRes(int i3) {
    }

    public void setPullType(int i3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void c(int i3, String str) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setTextColor(int i3, int i16, int i17, int i18, int i19) {
    }
}

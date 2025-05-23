package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.BaseImageUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VoteViewElegant extends VoteViewV2 {
    public VoteViewElegant(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void d(int i3) {
        this.C = i3;
        s();
        com.tencent.mobileqq.profile.like.b bVar = this.E;
        if (bVar == null) {
            return;
        }
        if (this.C == 1) {
            Drawable drawable = bVar.f260220i;
            if (drawable != null) {
                bVar.f260220i = BaseImageUtil.maskDrawableByColor(drawable, -7894119);
                return;
            }
            return;
        }
        Drawable drawable2 = bVar.f260220i;
        if (drawable2 != null) {
            bVar.f260220i = BaseImageUtil.maskDrawableByColor(drawable2, -1);
        }
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    protected int f() {
        return R.layout.h17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void i() {
        super.i();
        TextView textView = this.f316535h;
        if (textView == null) {
            return;
        }
        textView.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void k(boolean z16, int i3) {
        ViewGroup viewGroup;
        super.k(z16, i3);
        TextView textView = this.J;
        if (textView != null && (viewGroup = this.I) != null) {
            boolean z17 = this.N;
            int i16 = 8;
            if (z17 && this.f316534f > 0) {
                if (!z16) {
                    i16 = 0;
                }
                textView.setVisibility(i16);
            } else if (!z17 || !this.P) {
                viewGroup.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void n(boolean z16) {
        int i3;
        super.n(z16);
        ViewGroup viewGroup = this.I;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        ViewGroup viewGroup2 = this.I;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup2.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void r(boolean z16, boolean z17, int i3, int i16, com.tencent.mobileqq.dating.j jVar, boolean z18, int i17, Boolean bool, String str) {
        super.r(z16, z17, i3, i16, jVar, z18, i17, bool, str);
        if (!this.N) {
            k(false, 8);
        }
        q(i17, this.R, bool);
        q(i17, this.S, bool);
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void setRedDotPos(int i3, int i16) {
        ViewGroup viewGroup = this.I;
        if (viewGroup == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = i16;
        layoutParams.leftMargin = i3;
        this.I.setLayoutParams(layoutParams);
    }

    public VoteViewElegant(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VoteViewElegant(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TextTipsBar extends TipsBar {
    public TextTipsBar(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.banner.TipsBar
    public void b() {
        super.b();
        Button button = this.W;
        if (button != null) {
            button.setId(R.id.iyc);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = ViewUtils.dip2px(28.0f);
            this.W.setLayoutParams(layoutParams);
        }
        TextView textView = this.S;
        if (textView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.addRule(0, R.id.iyc);
            this.S.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.banner.TipsBar
    public void c() {
        super.c();
        ImageView imageView = this.V;
        if (imageView != null) {
            imageView.setId(R.id.iyx);
        }
    }

    @Override // com.tencent.mobileqq.banner.TipsBar
    public Drawable k(Resources resources) {
        return new ColorDrawable(getResources().getColor(R.color.ajr));
    }

    @Override // com.tencent.mobileqq.banner.TipsBar
    protected ColorStateList l(Resources resources, int i3) {
        return AppCompatResources.getColorStateList(getContext(), R.color.qui_common_text_link);
    }

    @Override // com.tencent.mobileqq.banner.TipsBar
    public void z(boolean z16) {
        super.z(z16);
        b();
    }

    public TextTipsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEnabled(false);
        this.P.setEnabled(false);
    }
}

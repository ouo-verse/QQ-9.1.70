package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AdvancedTipsBar extends TipsBar {
    public AdvancedTipsBar(Context context) {
        super(context);
    }

    public void D() {
        int parseColor;
        if (!QQTheme.isNowThemeIsNight()) {
            parseColor = Color.parseColor("#03081A");
        } else {
            parseColor = Color.parseColor("#FFFFFF");
        }
        this.S.setTextColor(parseColor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.banner.TipsBar
    public void b() {
        int parseColor;
        super.b();
        Button button = this.W;
        if (button != null) {
            button.setId(R.id.iyc);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = ViewUtils.dip2px(44.0f);
            if (!QQTheme.isNowThemeIsNight()) {
                parseColor = Color.parseColor("#4D94FF");
            } else {
                parseColor = Color.parseColor("#0071FF");
            }
            this.W.setTextColor(parseColor);
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
            layoutParams.rightMargin = ViewUtils.dip2px(13.0f);
            this.V.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.banner.TipsBar
    public void z(boolean z16) {
        super.z(z16);
        b();
    }

    public AdvancedTipsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.banner.TipsBar
    public void A() {
    }
}

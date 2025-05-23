package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountNavBar extends NavBarCommon {
    private TextView mTitleTv;

    public MiniGamePublicAccountNavBar(Context context) {
        super(context);
    }

    public TextView getTitleTextView() {
        if (this.mTitleTv == null) {
            this.mTitleTv = (TextView) findViewById(R.id.ivTitleName);
        }
        if (this.mTitleTv == null) {
            this.mTitleTv = new TextView(getContext());
        }
        return this.mTitleTv;
    }

    public MiniGamePublicAccountNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MiniGamePublicAccountNavBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setTitleBarTransparent() {
        setBackgroundResource(R.color.ajr);
    }
}

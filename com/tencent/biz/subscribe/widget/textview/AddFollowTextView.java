package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AddFollowTextView extends FollowTextView {
    public AddFollowTextView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView
    protected void j() {
        setBackgroundResource(R.drawable.f160405cc0);
        setGravity(17);
        setOnClickListener(this);
    }

    @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView
    protected void l() {
        setBackgroundResource(R.drawable.f160406cc1);
        postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.widget.textview.AddFollowTextView.1
            @Override // java.lang.Runnable
            public void run() {
                AddFollowTextView.this.setVisibility(8);
            }
        }, 2000L);
    }

    @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView
    protected void m() {
        setBackgroundResource(R.drawable.f160405cc0);
        setVisibility(0);
    }

    public AddFollowTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddFollowTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

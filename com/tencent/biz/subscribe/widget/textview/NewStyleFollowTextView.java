package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NewStyleFollowTextView extends FollowTextView {
    public NewStyleFollowTextView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView
    protected void l() {
        int i3;
        int parseColor;
        if (this.f96570d) {
            i3 = R.drawable.a_7;
        } else {
            i3 = R.drawable.a_0;
        }
        setBackgroundResource(i3);
        if (this.f96570d) {
            parseColor = -9211021;
        } else {
            parseColor = Color.parseColor("#9A9A9A");
        }
        setTextColor(parseColor);
        setText(R.string.f170707zh);
    }

    @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView
    protected void m() {
        int i3;
        int i16;
        if (this.f96570d) {
            i3 = R.drawable.arg;
        } else {
            i3 = R.drawable.f160427an4;
        }
        setBackgroundResource(i3);
        if (this.f96570d) {
            i16 = -1493172225;
        } else {
            i16 = -1;
        }
        setTextColor(i16);
        setText(R.string.f170708zi);
    }

    public NewStyleFollowTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

package com.tencent.biz.now;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.mini.util.DisplayUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NowVideoLayout extends RelativeLayout {
    public NowVideoLayout(Context context) {
        super(context);
        TextView textView = new TextView(getContext());
        textView.setText("\u5f53\u524d\u4e0d\u652f\u6301\u7684\u6d88\u606f\u7c7b\u578b(type=18)");
        textView.setTextColor(Color.parseColor("#777777"));
        textView.setTextSize(DisplayUtil.sp2px(getContext(), 12.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(textView, layoutParams);
    }
}

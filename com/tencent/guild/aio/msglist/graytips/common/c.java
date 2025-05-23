package com.tencent.guild.aio.msglist.graytips.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111335a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f111336b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        a(context);
    }

    public View a(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f111335a = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        TextView textView = new TextView(context, null);
        this.f111336b = textView;
        textView.setId(R.id.vse);
        this.f111336b.setTextSize(2, 13.0f);
        this.f111336b.setTextColor(context.getColorStateList(R.color.qui_common_text_secondary));
        this.f111336b.setLayoutParams(layoutParams);
        frameLayout.addView(this.f111336b);
        return frameLayout;
    }

    public ViewGroup b() {
        return this.f111335a;
    }
}

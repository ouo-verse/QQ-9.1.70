package com.tencent.guild.aio.msglist.holder.component.newmsgline;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        a(context);
    }

    public View a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f111566a = linearLayout;
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding((int) TypedValue.applyDimension(1, 16.0f, displayMetrics), (int) TypedValue.applyDimension(1, 8.0f, displayMetrics), (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), (int) TypedValue.applyDimension(1, 26.0f, displayMetrics));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) TypedValue.applyDimension(1, 0.0f, displayMetrics);
        layoutParams.height = (int) TypedValue.applyDimension(0, 1.0f, displayMetrics);
        layoutParams.weight = 1.0f;
        View view = new View(context, null);
        view.setBackgroundResource(R.drawable.guild_new_msg_split);
        linearLayout.addView(view, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = (int) TypedValue.applyDimension(1, 12.0f, displayMetrics);
        layoutParams2.rightMargin = (int) TypedValue.applyDimension(1, 12.0f, displayMetrics);
        TextView textView = new TextView(context, null);
        textView.setText(R.string.ygi);
        textView.setTextSize(0, (int) TypedValue.applyDimension(2, 12.0f, displayMetrics));
        textView.setSingleLine(true);
        textView.setTextColor(context.getColorStateList(R.color.qui_common_text_link));
        linearLayout.addView(textView, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) TypedValue.applyDimension(1, 0.0f, displayMetrics);
        layoutParams3.height = (int) TypedValue.applyDimension(0, 1.0f, displayMetrics);
        layoutParams3.weight = 1.0f;
        View view2 = new View(context, null);
        view2.setBackgroundResource(R.drawable.guild_new_msg_split);
        linearLayout.addView(view2, layoutParams3);
        return linearLayout;
    }

    public ViewGroup b() {
        return this.f111566a;
    }
}

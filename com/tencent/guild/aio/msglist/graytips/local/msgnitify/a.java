package com.tencent.guild.aio.msglist.graytips.local.msgnitify;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111356a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f111357b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f111358c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f111359d;

    public a(Context context) {
        a(context);
    }

    public View a(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f111357b = linearLayout;
        this.f111356a = linearLayout;
        linearLayout.setId(R.id.zg9);
        this.f111357b.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        layoutParams.height = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams.gravity = 16;
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 17.0f, resources.getDisplayMetrics());
        ImageView imageView = new ImageView(context, null);
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_aio_msg_notify_setting_icon, Integer.valueOf(R.color.qui_common_icon_secondary)));
        imageView.setLayoutParams(layoutParams);
        this.f111357b.addView(imageView);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.gravity = 16;
        TextView textView = new TextView(context, null);
        this.f111358c = textView;
        textView.setId(R.id.f26760ee);
        this.f111358c.setTextSize(2, 13.0f);
        this.f111358c.setText(R.string.f15048154);
        this.f111358c.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f111358c.setSingleLine(true);
        this.f111358c.setMaxWidth((int) TypedValue.applyDimension(1, 250.0f, resources.getDisplayMetrics()));
        this.f111358c.setTextColor(context.getColorStateList(R.color.qui_common_text_secondary));
        this.f111358c.setLayoutParams(layoutParams2);
        this.f111357b.addView(this.f111358c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.gravity = 16;
        TextView textView2 = new TextView(context, null);
        this.f111359d = textView2;
        textView2.setId(R.id.tzo);
        this.f111359d.setTextSize(2, 13.0f);
        this.f111359d.setText(R.string.f15049155);
        this.f111359d.setTextColor(context.getColorStateList(R.color.qui_common_text_secondary));
        this.f111359d.setPadding((int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()), 0, 0, 0);
        this.f111359d.setLayoutParams(layoutParams3);
        this.f111357b.addView(this.f111359d);
        return this.f111357b;
    }

    public ViewGroup b() {
        return this.f111356a;
    }
}

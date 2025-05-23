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
public class b {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111360a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f111361b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f111362c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f111363d;

    public b(Context context) {
        a(context);
    }

    public View a(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f111361b = linearLayout;
        this.f111360a = linearLayout;
        linearLayout.setId(R.id.zg9);
        this.f111361b.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        layoutParams.height = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams.gravity = 16;
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 17.0f, resources.getDisplayMetrics());
        ImageView imageView = new ImageView(context, null);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        GuildUIUtils.d(imageView, R.drawable.guild_aio_icon_grey_remind, Integer.valueOf(R.color.qui_common_icon_secondary));
        imageView.setLayoutParams(layoutParams);
        this.f111361b.addView(imageView);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.gravity = 16;
        TextView textView = new TextView(context, null);
        this.f111362c = textView;
        textView.setId(R.id.f26760ee);
        this.f111362c.setTextSize(2, 13.0f);
        this.f111362c.setText(R.string.f1505515a);
        this.f111362c.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f111362c.setSingleLine(true);
        this.f111362c.setMaxWidth((int) TypedValue.applyDimension(1, 250.0f, resources.getDisplayMetrics()));
        this.f111362c.setTextColor(context.getColorStateList(R.color.qui_common_text_secondary));
        this.f111362c.setLayoutParams(layoutParams2);
        this.f111361b.addView(this.f111362c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.gravity = 16;
        TextView textView2 = new TextView(context, null);
        this.f111363d = textView2;
        textView2.setId(R.id.tzo);
        this.f111363d.setTextSize(2, 13.0f);
        this.f111363d.setText(R.string.f1505415_);
        this.f111363d.setTextColor(context.getColorStateList(R.color.qui_common_text_secondary));
        this.f111363d.setPadding((int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()), 0, 0, 0);
        this.f111363d.setLayoutParams(layoutParams3);
        this.f111361b.addView(this.f111363d);
        return this.f111361b;
    }

    public ViewGroup b() {
        return this.f111360a;
    }
}

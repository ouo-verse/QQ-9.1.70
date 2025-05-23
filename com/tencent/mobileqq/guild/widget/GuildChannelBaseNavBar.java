package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildChannelBaseNavBar extends RelativeLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f235817d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f235818e;

    /* renamed from: f, reason: collision with root package name */
    private a f235819f;

    /* renamed from: h, reason: collision with root package name */
    private GuildChannelBaseNavBarStyle f235820h;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void S9(View view);
    }

    public GuildChannelBaseNavBar(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.ehx, this);
        ImageView imageView = (ImageView) findViewById(R.id.w1y);
        this.f235817d = imageView;
        imageView.setOnClickListener(this);
        this.f235818e = (TextView) findViewById(R.id.w1o);
        if (AppSetting.f99565y) {
            AccessibilityUtil.d(this.f235817d, Button.class.getName());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.w1y && (aVar = this.f235819f) != null) {
            aVar.S9(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setBarStyle(@NonNull GuildChannelBaseNavBarStyle guildChannelBaseNavBarStyle) {
        this.f235820h = guildChannelBaseNavBarStyle;
        guildChannelBaseNavBarStyle.setLeftIcon(getContext(), this.f235817d);
    }

    public void setNavBarClickListener(a aVar) {
        this.f235819f = aVar;
    }

    public void setTitle(CharSequence charSequence, int i3) {
        Drawable drawable;
        TextView textView = this.f235818e;
        if (textView != null) {
            textView.setText(charSequence);
            this.f235818e.setVisibility(0);
            GuildChannelBaseNavBarStyle guildChannelBaseNavBarStyle = this.f235820h;
            if (guildChannelBaseNavBarStyle != null) {
                TextView textView2 = this.f235818e;
                textView2.setTextColor(guildChannelBaseNavBarStyle.getTextColor(textView2.getContext()));
            }
            if (i3 > 0) {
                GuildChannelBaseNavBarStyle guildChannelBaseNavBarStyle2 = this.f235820h;
                if (guildChannelBaseNavBarStyle2 != null) {
                    drawable = guildChannelBaseNavBarStyle2.getCenterIconDrawable(getContext(), i3);
                } else {
                    drawable = ResourcesCompat.getDrawable(getResources(), i3, null);
                }
            } else {
                drawable = null;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, ViewUtils.dpToPx(17.0f), ViewUtils.dpToPx(17.0f));
            }
            this.f235818e.setCompoundDrawables(null, null, drawable, null);
            this.f235818e.setCompoundDrawablePadding(ViewUtils.dpToPx(3.0f));
        }
    }

    public GuildChannelBaseNavBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildChannelBaseNavBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}

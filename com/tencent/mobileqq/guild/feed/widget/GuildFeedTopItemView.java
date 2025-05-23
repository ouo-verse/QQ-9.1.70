package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.aw;
import com.tencent.mobileqq.guild.util.GuildUIUtils;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedTopItemView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f224223d;

    /* renamed from: e, reason: collision with root package name */
    private GuildFeedTopThumbView f224224e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f224225f;

    /* renamed from: h, reason: collision with root package name */
    private ij1.h f224226h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f224227i;

    public GuildFeedTopItemView(Context context) {
        this(context, null);
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.erp, (ViewGroup) this, true);
        this.f224227i = (TextView) findViewById(R.id.v3y);
        this.f224223d = (TextView) findViewById(R.id.f165192v41);
        this.f224224e = (GuildFeedTopThumbView) findViewById(R.id.f165191v40);
        ImageView imageView = (ImageView) findViewById(R.id.v3v);
        this.f224225f = imageView;
        GuildUIUtils.d(imageView, R.drawable.myt, Integer.valueOf(R.color.qui_common_icon_tertiary));
        setBackgroundResource(R.drawable.guild_feed_top_item_selector);
    }

    public void a(ij1.h hVar) {
        int color;
        this.f224226h = hVar;
        int i3 = hVar.N;
        if (i3 != 0) {
            color = i3 | (-16777216);
        } else {
            color = getResources().getColor(R.color.qui_common_feedback_normal);
        }
        this.f224227i.setBackgroundDrawable(aw.a(color, 3.0f));
        if (!TextUtils.isEmpty(hVar.P)) {
            this.f224227i.setText(hVar.P);
        }
        this.f224223d.setText(hVar.C);
        if (TextUtils.isEmpty(hVar.D)) {
            this.f224224e.setVisibility(4);
        } else {
            this.f224224e.setThumbData(hVar.D, hVar.E);
            this.f224224e.setVisibility(0);
        }
    }

    public ij1.h b() {
        return this.f224226h;
    }

    public GuildFeedTopItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedTopItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}

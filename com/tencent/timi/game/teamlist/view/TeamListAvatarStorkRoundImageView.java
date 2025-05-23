package com.tencent.timi.game.teamlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamListAvatarStorkRoundImageView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f379840d;

    /* renamed from: e, reason: collision with root package name */
    private TimiRoundImageView f379841e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f379842f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f379843h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f379844i;

    public TeamListAvatarStorkRoundImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f379840d = LayoutInflater.from(getContext()).inflate(R.layout.hwy, (ViewGroup) this, true);
        this.f379841e = (TimiRoundImageView) findViewById(R.id.a2o);
        this.f379842f = (ImageView) findViewById(R.id.enc);
        this.f379843h = (ImageView) findViewById(R.id.icon);
        this.f379844i = (TextView) findViewById(R.id.ycv);
    }

    public void setBlueBg() {
        this.f379842f.setVisibility(0);
        this.f379842f.setImageResource(R.drawable.o_0);
    }

    public void setDrawable(Drawable drawable) {
        this.f379841e.setImageDrawable(drawable);
    }

    public void setIconDrawable(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f379843h.setVisibility(4);
        } else {
            this.f379843h.setVisibility(0);
            this.f379843h.setImageDrawable(gn4.c.a(str, 21.0f, 16.0f));
        }
    }

    public void setLaneStr(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f379844i.setVisibility(4);
        } else {
            this.f379844i.setVisibility(0);
            this.f379844i.setText(str);
        }
    }

    public void setNormal() {
        this.f379842f.setVisibility(4);
    }

    public void setPinkBg() {
        this.f379842f.setVisibility(0);
        this.f379842f.setImageResource(R.drawable.o_1);
    }

    public TeamListAvatarStorkRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TeamListAvatarStorkRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}

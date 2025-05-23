package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends e {

    /* renamed from: g, reason: collision with root package name */
    private ImageView f74597g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f74598h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f74599i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f74600j = false;

    public d(Context context) {
        this.f74601a = "SmallScreenAudio";
        Resources resources = context.getResources();
        this.f74604d = R.layout.di7;
        this.f74605e = resources.getDimensionPixelSize(R.dimen.a97);
        this.f74606f = resources.getDimensionPixelSize(R.dimen.f159367a91);
    }

    private void g(int i3) {
        Drawable drawable = this.f74597g.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        this.f74597g.setImageResource(i3);
        Drawable drawable2 = this.f74597g.getDrawable();
        if (drawable2 instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable2).start();
        }
    }

    @Override // com.tencent.av.smallscreen.e
    public void a(Context context, LayoutInflater layoutInflater, SmallScreenRelativeLayout.a aVar) {
        super.a(context, layoutInflater, aVar);
        this.f74602b.setTitleHeight((context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) * 5) / 2);
        this.f74598h = (ImageView) this.f74602b.findViewById(R.id.rbm);
        this.f74599i = (TextView) this.f74602b.findViewById(R.id.rbx);
        ImageView imageView = (ImageView) this.f74602b.findViewById(R.id.rbn);
        this.f74597g = imageView;
        imageView.setImageResource(R.drawable.k9p);
        Drawable drawable = this.f74597g.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // com.tencent.av.smallscreen.e
    public void f(BaseSmallScreenService baseSmallScreenService) {
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (this.f74600j != isNowThemeIsNight) {
            this.f74602b.setBackgroundResource(isNowThemeIsNight ? R.drawable.inu : R.drawable.f1719int);
            this.f74598h.setColorFilter(isNowThemeIsNight ? -16750849 : -16737793);
            this.f74599i.setTextColor(isNowThemeIsNight ? -16750849 : -16737793);
            g(isNowThemeIsNight ? R.drawable.k9q : R.drawable.k9p);
        }
        this.f74600j = isNowThemeIsNight;
        this.f74602b.o();
    }
}

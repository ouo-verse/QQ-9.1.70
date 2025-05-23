package com.tencent.mobileqq.guild.main.topchannel.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.topchannel.widget.FeedTopCardThumbView;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.util.x;
import com.tencent.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class FeedTopCardThumbView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private RoundRectImageView f227185d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f227186e;

    /* renamed from: f, reason: collision with root package name */
    private String f227187f;

    /* renamed from: h, reason: collision with root package name */
    private int f227188h;

    public FeedTopCardThumbView(Context context) {
        this(context, null);
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.erl, (ViewGroup) this, true);
        this.f227185d = (RoundRectImageView) findViewById(R.id.f70653m1);
        this.f227186e = (ImageView) findViewById(R.id.kro);
        postDelayed(new Runnable() { // from class: mr1.a
            @Override // java.lang.Runnable
            public final void run() {
                FeedTopCardThumbView.this.c();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f227185d.setCornerRadiusAndMode(x.c(getContext(), 3.0f), 1);
    }

    private void d() {
        if (!TextUtils.isEmpty(this.f227187f)) {
            if (this.f227185d.getTag() == null || !TextUtils.equals(this.f227185d.getTag().toString(), this.f227187f)) {
                this.f227185d.setTag(this.f227187f);
                v.k(this.f227187f, this.f227185d, b.f306350a);
                if (this.f227188h == 2) {
                    this.f227186e.setVisibility(0);
                } else {
                    this.f227186e.setVisibility(8);
                }
            }
        }
    }

    public void setThumbData(String str, int i3) {
        this.f227187f = str;
        this.f227188h = i3;
        d();
    }

    public FeedTopCardThumbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedTopCardThumbView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f227187f = "";
        this.f227188h = -1;
        b();
    }
}

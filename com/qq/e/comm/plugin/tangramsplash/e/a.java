package com.qq.e.comm.plugin.tangramsplash.e;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;
import com.qq.e.comm.util.RoundRectUtil;
import com.qq.e.comm.util.StringUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    Context f39884a;

    /* renamed from: b, reason: collision with root package name */
    String f39885b;

    /* renamed from: c, reason: collision with root package name */
    TextView f39886c;

    public a(Context context) {
        super(context);
        this.f39885b = "\u70b9\u51fb\u4e86\u89e3";
        this.f39884a = context;
        setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(64.0f, Color.parseColor("#80000000"), 100));
        b();
    }

    private void b() {
        int a16 = ak.a(this.f39884a, 6);
        int a17 = ak.a(this.f39884a, 6);
        TextView textView = new TextView(this.f39884a);
        this.f39886c = textView;
        textView.setText(this.f39885b);
        this.f39886c.setMaxLines(1);
        this.f39886c.setTextSize(2, 14.0f);
        this.f39886c.setMaxEms(6);
        this.f39886c.setEllipsize(TextUtils.TruncateAt.END);
        this.f39886c.setTextColor(-1);
        this.f39886c.setGravity(17);
        this.f39886c.setId(10001);
        this.f39886c.setIncludeFontPadding(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.setMargins(ak.a(this.f39884a, 20), a16, 0, a17);
        addView(this.f39886c, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(this.f39884a, 6), ak.a(this.f39884a, 11));
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.f39886c.getId());
        layoutParams2.setMargins(ak.a(this.f39884a, 6), a16, ak.a(this.f39884a, 20), a17);
        ImageView imageView = new ImageView(this.f39884a);
        imageView.setImageBitmap(am.a("iVBORw0KGgoAAAANSUhEUgAAAA0AAAAWCAYAAAAb+hYkAAAAbElEQVR42p3UwQmAMBBE0RxtTLxYjPVYgD1YgB0FPK77Dzmbv4EZApsHItEWEUvmyVzst2NvfxmoZ1j3DKSAa+adhZSGlIaUhpSGlIaUhgw1ZGDhWUX+8TQov3INiAX1C6tB/SPkgAGk9GP5AMu4MNixHZ3vAAAAAElFTkSuQmCC"));
        addView(imageView, layoutParams2);
    }

    public void a(String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.f39885b = str;
        this.f39886c.setText(str);
    }

    public void a() {
        setVisibility(4);
        int integer = GDTADManager.getInstance().getSM().getInteger("SplashGuideButtonStartDelay", 1000);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.setVisibility(0);
                a.this.setAnimation(alphaAnimation);
            }
        }, integer);
    }
}

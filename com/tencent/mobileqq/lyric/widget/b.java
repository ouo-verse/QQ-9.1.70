package com.tencent.mobileqq.lyric.widget;

import android.content.res.TypedArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f243252a;

    /* renamed from: b, reason: collision with root package name */
    public int f243253b;

    /* renamed from: c, reason: collision with root package name */
    public int f243254c;

    /* renamed from: d, reason: collision with root package name */
    public int f243255d;

    /* renamed from: e, reason: collision with root package name */
    public int f243256e;

    /* renamed from: f, reason: collision with root package name */
    public int f243257f;

    /* renamed from: g, reason: collision with root package name */
    public int f243258g;

    /* renamed from: h, reason: collision with root package name */
    public int f243259h;

    /* renamed from: i, reason: collision with root package name */
    public int f243260i;

    /* renamed from: j, reason: collision with root package name */
    public int f243261j;

    /* renamed from: k, reason: collision with root package name */
    public int f243262k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f243263l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f243264m;

    /* renamed from: n, reason: collision with root package name */
    public int f243265n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f243266o;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(TypedArray typedArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) typedArray);
            return;
        }
        this.f243252a = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricTextSize, 16);
        this.f243253b = typedArray.getInt(R.styleable.ModuleLyricView_lyricTextColor, 255);
        this.f243254c = typedArray.getInt(R.styleable.ModuleLyricView_lyricTextThinColor, 255);
        this.f243255d = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricLineHeight, 20);
        this.f243260i = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricLineMargin, 20);
        this.f243261j = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricFoldLineMargin, 15);
        this.f243256e = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricHilightSize, 20);
        this.f243257f = typedArray.getInt(R.styleable.ModuleLyricView_lyricHilightColor, 255);
        this.f243258g = typedArray.getInt(R.styleable.ModuleLyricView_lyricHilightThinColor, 255);
        this.f243259h = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricHilightHeight, 20);
        this.f243262k = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricPadding, 20);
        this.f243263l = typedArray.getBoolean(R.styleable.ModuleLyricView_lyricLiteratim, false);
        this.f243265n = typedArray.getDimensionPixelSize(R.styleable.ModuleLyricView_lyricLeftAttachPadding, 10);
        this.f243266o = typedArray.getBoolean(R.styleable.ModuleLyricView_lyricLeftAlign, false);
        this.f243264m = typedArray.getBoolean(R.styleable.ModuleLyricView_lyricHiLightLyricBold, true);
    }
}

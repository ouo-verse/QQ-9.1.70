package com.tencent.qq.effect.engine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QEffectData {
    static IPatchRedirector $redirector_;
    public float aspectRatio;
    public String effect;
    public int effectId;
    public String fragment;
    public boolean gesture;
    public boolean gravity;
    public float gravitySpeed;

    /* renamed from: h, reason: collision with root package name */
    public float f344465h;
    public String images;
    public int layoutType;
    public int offsetX;
    public int offsetY;
    public int repeat;
    public int resId;
    public int resType;
    public int scaleType;
    public String src;
    public int support;
    public int type;
    public String vertex;

    /* renamed from: w, reason: collision with root package name */
    public float f344466w;

    /* renamed from: x, reason: collision with root package name */
    public float f344467x;

    /* renamed from: y, reason: collision with root package name */
    public float f344468y;

    public QEffectData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.repeat = 1;
            this.gravitySpeed = 1.0f;
        }
    }
}

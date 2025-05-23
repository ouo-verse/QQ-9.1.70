package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    int f67008a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f67009b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f67010c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f67011d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f67012e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f67013f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f67014g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f67015h = 0;

    /* renamed from: i, reason: collision with root package name */
    public Bitmap f67016i = null;

    /* renamed from: j, reason: collision with root package name */
    public Typeface f67017j = null;

    /* renamed from: k, reason: collision with root package name */
    public int f67018k = 2;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f67019a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f67020b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f67021c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f67022d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f67023e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f67024f = 0;

        /* renamed from: g, reason: collision with root package name */
        public Bitmap f67025g = null;

        /* renamed from: h, reason: collision with root package name */
        public Typeface f67026h = null;

        /* renamed from: i, reason: collision with root package name */
        public int f67027i = 2;

        void a(f fVar) {
            fVar.f67016i = this.f67025g;
            fVar.f67012e = this.f67023e;
            fVar.f67013f = this.f67024f;
            fVar.f67010c = this.f67021c;
            fVar.f67011d = this.f67022d;
            int i3 = this.f67019a;
            fVar.f67008a = i3;
            fVar.f67009b = this.f67020b;
            fVar.f67017j = this.f67026h;
            fVar.f67014g = fVar.a(i3);
            fVar.f67015h = fVar.a(fVar.f67009b);
            fVar.f67018k = this.f67027i;
        }

        public f b() {
            f fVar = new f();
            a(fVar);
            return fVar;
        }

        public int c(float f16) {
            return BaseAIOUtils.f(f16, BaseApplicationImpl.getApplication().getResources());
        }

        public a d(Bitmap bitmap) {
            this.f67025g = bitmap;
            return this;
        }

        public a e(float f16, float f17) {
            this.f67023e = c(f16);
            this.f67024f = c(f17);
            return this;
        }

        public a f(float f16, float f17, int i3, int i16) {
            this.f67021c = c(f16);
            this.f67022d = c(f17);
            this.f67019a = i3;
            this.f67020b = i16;
            return this;
        }

        public a g(Typeface typeface) {
            this.f67026h = typeface;
            return this;
        }
    }

    public int a(int i3) {
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append("\u6211");
        }
        TextPaint textPaint = new TextPaint();
        Typeface typeface = this.f67017j;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        textPaint.setShadowLayer(b(3.0f), b(5.0f), b(5.0f), -1);
        int f16 = BaseAIOUtils.f(100.0f, BaseApplicationImpl.getApplication().getResources());
        while (true) {
            textPaint.setTextSize(f16);
            StaticLayout a16 = ag.a(sb5, 0, sb5.length(), textPaint, this.f67010c, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, 1);
            if (textPaint.measureText(sb5.toString()) <= this.f67010c && a16.getHeight() <= this.f67011d) {
                return f16;
            }
            f16--;
        }
    }

    public int b(float f16) {
        return BaseAIOUtils.f(f16, BaseApplicationImpl.getApplication().getResources());
    }
}

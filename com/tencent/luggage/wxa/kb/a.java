package com.tencent.luggage.wxa.kb;

import android.graphics.Point;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static int f131894b;

    /* renamed from: c, reason: collision with root package name */
    public static int f131895c;

    /* renamed from: d, reason: collision with root package name */
    public static int f131896d;

    /* renamed from: f, reason: collision with root package name */
    public static int f131898f;

    /* renamed from: g, reason: collision with root package name */
    public static int f131899g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f131900h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f131901i;

    /* renamed from: a, reason: collision with root package name */
    public static final a f131893a = new a();

    /* renamed from: e, reason: collision with root package name */
    public static int f131897e = -1;

    public final void a(int i3) {
        f131894b = i3;
    }

    public final void b(int i3) {
        f131895c = i3;
    }

    public final void c(int i3) {
        f131896d = i3;
    }

    public final boolean d() {
        return f131900h;
    }

    public String toString() {
        return "previewHeight: " + f131894b + " ,previewWidth:" + f131895c + " ,rotateDegree: " + f131896d + " , systemRotate:" + f131897e + ", isFrontCamera:" + f131900h + "  encodeVideoBestSizeWidth : " + f131898f + " , encodeVideoBestSizeHeight : " + f131899g + ", isCpuCrop: " + f131901i + TokenParser.SP;
    }

    public final void a(boolean z16) {
        f131900h = z16;
    }

    public final int b() {
        return f131896d;
    }

    public final int c() {
        return f131897e;
    }

    public final Point a() {
        return new Point(f131895c, f131894b);
    }
}

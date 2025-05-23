package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.image.SafeBitmapFactory;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private aq f306589a;

    /* renamed from: c, reason: collision with root package name */
    private Context f306591c;

    /* renamed from: e, reason: collision with root package name */
    protected int f306593e;

    /* renamed from: f, reason: collision with root package name */
    protected int f306594f;

    /* renamed from: b, reason: collision with root package name */
    private boolean f306590b = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f306592d = false;

    /* renamed from: g, reason: collision with root package name */
    private BitmapDrawable f306595g = new BitmapDrawable();

    /* renamed from: h, reason: collision with root package name */
    private Map<View, Object> f306596h = new WeakHashMap();

    public ar(Context context) {
        this.f306591c = context;
        this.f306589a = new aq(ca.a(context) / 8);
    }

    public static int a(BitmapFactory.Options options, int i3, int i16) {
        int round;
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i17 <= i16 && i18 <= i3) {
            return 1;
        }
        if (i18 > i17) {
            round = Math.round(i17 / i16);
        } else {
            round = Math.round(i18 / i3);
        }
        while ((i18 * i17) / (round * round) > i3 * i16 * 2) {
            round++;
        }
        return round;
    }

    public static synchronized Bitmap b(String str, int i3, int i16) {
        Bitmap d16;
        synchronized (ar.class) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(str, options);
            if (i3 <= 0) {
                i3 = options.outWidth;
            }
            if (i16 <= 0) {
                i16 = options.outHeight;
            }
            options.inSampleSize = a(options, i3, i16);
            options.inJustDecodeBounds = false;
            d16 = j.d(str, options);
        }
        return d16;
    }

    public void c(int i3, int i16) {
        this.f306593e = i3;
        this.f306594f = i16;
    }
}

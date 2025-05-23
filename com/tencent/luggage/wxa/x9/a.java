package com.tencent.luggage.wxa.x9;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.graphics.MMBitmapFactory;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a extends BitmapFactory {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f144647a = false;

    public static Bitmap decodeStream(InputStream inputStream) {
        if (f144647a) {
            return BitmapFactory.decodeStream(inputStream);
        }
        try {
            return MMBitmapFactory.a(inputStream);
        } catch (ExceptionInInitializerError | RuntimeException | UnsatisfiedLinkError e16) {
            w.b("MicroMsg.SDK.CBitmapFactory", "decodeStream, captured UnsatisfiedLinkError %s", Log.getStackTraceString(e16));
            f144647a = true;
            return BitmapFactory.decodeStream(inputStream);
        }
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (f144647a) {
            return BitmapFactory.decodeStream(inputStream, rect, options);
        }
        try {
            return MMBitmapFactory.a(inputStream, rect, options);
        } catch (ExceptionInInitializerError | RuntimeException | UnsatisfiedLinkError e16) {
            w.b("MicroMsg.SDK.CBitmapFactory", "decodeStream, captured UnsatisfiedLinkError %s", Log.getStackTraceString(e16));
            f144647a = true;
            return BitmapFactory.decodeStream(inputStream, rect, options);
        }
    }
}

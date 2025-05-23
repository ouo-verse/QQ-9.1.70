package com.tencent.luggage.wxa.p004if;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.luggage.wxa.eo.c;
import com.tencent.luggage.wxa.eo.g;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface s extends c {

    /* renamed from: p, reason: collision with root package name */
    public static final s f130226p = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements s {
        @Override // com.tencent.luggage.wxa.p004if.s
        public Bitmap a(String str, BitmapFactory.Options options) {
            return BitmapFactory.decodeFile(str, options);
        }

        @Override // com.tencent.luggage.wxa.p004if.s
        public Bitmap a(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(inputStream, rect, options);
        }

        @Override // com.tencent.luggage.wxa.p004if.s
        public Bitmap a(InputStream inputStream) {
            return BitmapFactory.decodeStream(inputStream);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {
        public static s a() {
            s sVar = (s) g.a(s.class);
            if (sVar == null) {
                return s.f130226p;
            }
            return sVar;
        }
    }

    Bitmap a(InputStream inputStream);

    Bitmap a(InputStream inputStream, Rect rect, BitmapFactory.Options options);

    Bitmap a(String str, BitmapFactory.Options options);
}

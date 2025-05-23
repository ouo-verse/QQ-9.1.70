package com.tencent.luggage.wxa.x0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.image_picker.imagepicker.features.TencentImagePickerActivity;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public c f144451a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public Activity f144452b;

        public a(Activity activity) {
            this.f144452b = activity;
            c();
        }
    }

    public static a a(Activity activity) {
        return new a(activity);
    }

    public b b(boolean z16) {
        this.f144451a.c(z16);
        return this;
    }

    public void c() {
        this.f144451a = d.b();
    }

    public static com.tencent.luggage.wxa.z0.b a() {
        return new com.tencent.luggage.wxa.z0.b();
    }

    public c b() {
        com.tencent.luggage.wxa.d1.e.a(this.f144451a.i());
        return this.f144451a;
    }

    public b c(boolean z16) {
        this.f144451a.d(z16);
        return this;
    }

    public b a(int i3) {
        this.f144451a.a(i3);
        return this;
    }

    public b a(boolean z16) {
        this.f144451a.b(z16);
        return this;
    }

    public Intent a(Context context) {
        c a16 = com.tencent.luggage.wxa.d1.a.a(b());
        Intent intent = new Intent(context, (Class<?>) TencentImagePickerActivity.class);
        intent.putExtra(c.class.getSimpleName(), a16);
        return intent;
    }

    public static List a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getParcelableArrayListExtra("selectedImages");
    }
}

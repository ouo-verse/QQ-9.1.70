package com.tencent.luggage.wxa.z0;

import android.content.Context;
import android.content.Intent;
import com.tencent.image_picker.imagepicker.features.TencentImagePickerActivity;
import com.tencent.luggage.wxa.x0.d;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public a f146174a = d.a();

    public Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) TencentImagePickerActivity.class);
        intent.putExtra(a.class.getSimpleName(), this.f146174a);
        return intent;
    }
}

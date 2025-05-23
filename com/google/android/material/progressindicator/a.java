package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    public float a(@NonNull ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}

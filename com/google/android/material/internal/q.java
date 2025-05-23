package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: P */
@RequiresApi(18)
/* loaded from: classes2.dex */
class q implements r {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f33886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(@NonNull View view) {
        this.f33886a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.r
    public void add(@NonNull Drawable drawable) {
        this.f33886a.add(drawable);
    }

    @Override // com.google.android.material.internal.r
    public void remove(@NonNull Drawable drawable) {
        this.f33886a.remove(drawable);
    }
}

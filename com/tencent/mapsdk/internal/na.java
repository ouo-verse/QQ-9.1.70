package com.tencent.mapsdk.internal;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class na extends Paint {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<TencentMapContext> f149375a;

    public na(TencentMapContext tencentMapContext) {
        this.f149375a = new WeakReference<>(tencentMapContext);
    }

    @Override // android.graphics.Paint
    public final Typeface setTypeface(Typeface typeface) {
        TencentMapContext tencentMapContext;
        WeakReference<TencentMapContext> weakReference = this.f149375a;
        if (weakReference != null && (tencentMapContext = weakReference.get()) != null) {
            Typeface typeface2 = tencentMapContext.getTypeface();
            if (typeface2 != null && (Typeface.DEFAULT == typeface || Typeface.DEFAULT_BOLD == typeface)) {
                return super.setTypeface(typeface2);
            }
            return super.setTypeface(typeface);
        }
        return super.setTypeface(typeface);
    }
}

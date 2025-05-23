package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nb extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f149376a;

    public nb(Context context, TencentMapContext tencentMapContext) {
        super(context);
        if (!this.f149376a && tencentMapContext != null) {
            this.f149376a = true;
            Typeface typeface = tencentMapContext.getTypeface();
            if (typeface != null) {
                setTypeface(typeface);
            }
        }
    }

    private void a(TencentMapContext tencentMapContext) {
        if (!this.f149376a && tencentMapContext != null) {
            this.f149376a = true;
            Typeface typeface = tencentMapContext.getTypeface();
            if (typeface != null) {
                setTypeface(typeface);
            }
        }
    }
}

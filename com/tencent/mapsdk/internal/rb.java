package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.mapsdk.internal.ll;

/* compiled from: P */
/* loaded from: classes9.dex */
public class rb extends ki {

    /* renamed from: h, reason: collision with root package name */
    private static ll.a f150008h = new ll.a(Bitmap.Config.ARGB_8888);

    public rb() {
        ki.a(f150008h);
    }

    @Override // com.tencent.mapsdk.internal.ki
    public final boolean f() {
        Bitmap bitmap = this.f148976c;
        if (bitmap != null && !bitmap.isRecycled() && this.f148975b.get() <= 0) {
            synchronized (this.f148980g) {
                this.f148976c.recycle();
            }
            lc.a(ky.f149113s).a("tileBitmap recycle out");
        }
        this.f148977d = null;
        Bitmap bitmap2 = this.f148976c;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            return false;
        }
        return true;
    }

    public rb(byte[] bArr) {
        super(bArr);
        ki.a(f150008h);
    }
}

package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mapsdk.internal.ew;
import com.tencent.mapsdk.internal.qa;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pz extends eu {

    /* renamed from: a, reason: collision with root package name */
    TextView f149725a;

    /* renamed from: b, reason: collision with root package name */
    public qa.a f149726b;

    /* renamed from: c, reason: collision with root package name */
    private Context f149727c;

    public pz(Context context, TencentMapContext tencentMapContext) {
        this.f149727c = context;
        this.f149725a = new nb(this.f149727c, tencentMapContext);
    }

    private Bitmap e() {
        this.f149725a.setTextSize(18.0f);
        this.f149725a.setTextColor(-16777216);
        this.f149725a.setText("\u9274\u6743\u5931\u8d25,\u8bf7\u68c0\u67e5\u4f60\u7684key");
        return hn.a(this.f149725a);
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void a(ew.b bVar) {
    }

    @Override // com.tencent.mapsdk.internal.fp
    public final void b(int i3, int i16) {
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final ew.b d() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.eu
    public final View[] b() {
        return new View[0];
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final boolean a(final ViewGroup viewGroup, Bundle bundle) {
        if (viewGroup == null || this.f149725a == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f149725a.setLayoutParams(layoutParams);
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        this.f149725a.setTextSize(18.0f);
        this.f149725a.setTextColor(-16777216);
        this.f149725a.setText("\u9274\u6743\u5931\u8d25,\u8bf7\u68c0\u67e5\u4f60\u7684key");
        Bitmap a16 = hn.a(this.f149725a);
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.pz.1
            @Override // java.lang.Runnable
            public final void run() {
                viewGroup.addView(pz.this.f149725a);
            }
        });
        qa.a aVar = this.f149726b;
        if (aVar == null) {
            return true;
        }
        aVar.a(a16, measuredWidth, measuredHeight);
        return true;
    }

    private void a(qa.a aVar) {
        this.f149726b = aVar;
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void c() {
    }
}

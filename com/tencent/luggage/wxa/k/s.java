package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s extends o {

    /* renamed from: d, reason: collision with root package name */
    public final SurfaceView f131360d;

    public s(Context context, ViewGroup viewGroup) {
        SurfaceView surfaceView = (SurfaceView) View.inflate(context, R.layout.hrl, viewGroup).findViewById(R.id.j8i);
        this.f131360d = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new a());
    }

    @Override // com.tencent.luggage.wxa.k.o
    public Class c() {
        return SurfaceHolder.class;
    }

    @Override // com.tencent.luggage.wxa.k.o
    public Surface d() {
        return e().getSurface();
    }

    @Override // com.tencent.luggage.wxa.k.o
    public SurfaceHolder e() {
        return this.f131360d.getHolder();
    }

    @Override // com.tencent.luggage.wxa.k.o
    public View g() {
        return this.f131360d;
    }

    @Override // com.tencent.luggage.wxa.k.o
    public boolean i() {
        if (h() != 0 && b() != 0) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            s.this.b(i16, i17);
            if (!ViewCompat.isInLayout(s.this.f131360d)) {
                s.this.a();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            s.this.b(0, 0);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }
    }

    @Override // com.tencent.luggage.wxa.k.o
    public void a(int i3) {
    }
}

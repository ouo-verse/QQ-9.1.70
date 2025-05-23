package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.k.i;
import com.tencent.luggage.wxa.k.l;
import com.tencent.luggage.wxa.k.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends FrameLayout implements p.a {
    public static final /* synthetic */ boolean D = true;
    public final k C;

    /* renamed from: a, reason: collision with root package name */
    public i f131301a;

    /* renamed from: b, reason: collision with root package name */
    public final e f131302b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f131303c;

    /* renamed from: d, reason: collision with root package name */
    public Context f131304d;

    /* renamed from: e, reason: collision with root package name */
    public int f131305e;

    /* renamed from: f, reason: collision with root package name */
    public int f131306f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f131307g;

    /* renamed from: h, reason: collision with root package name */
    public volatile byte[] f131308h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f131309i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f131310j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f131311k;

    /* renamed from: l, reason: collision with root package name */
    public o f131312l;

    /* renamed from: m, reason: collision with root package name */
    public p f131313m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends k {
        public a(Context context) {
            super(context);
        }

        @Override // com.tencent.luggage.wxa.k.k
        public void b(int i3) {
            com.tencent.luggage.wxa.k.f.b("WMPF.CameraView", "onDisplayOrientationChanged, degree = %d", Integer.valueOf(i3));
            h.this.f131301a.a(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends k {
        public b(Context context) {
            super(context);
        }

        @Override // com.tencent.luggage.wxa.k.k
        public void b(int i3) {
            com.tencent.luggage.wxa.k.f.b("WMPF.CameraView", "onDisplayOrientationChanged, degree = %d", Integer.valueOf(i3));
            h.this.f131301a.a(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements l.a {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceTexture f131317a;

            public a(SurfaceTexture surfaceTexture) {
                this.f131317a = surfaceTexture;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.i();
                h.this.f131301a.a(this.f131317a);
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.k.l.a
        public void a(SurfaceTexture surfaceTexture) {
            h.this.post(new a(surfaceTexture));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class d {
        public void a(h hVar) {
        }

        public void a(h hVar, String str) {
        }

        public void a(h hVar, byte[] bArr) {
        }

        public void a(h hVar, byte[] bArr, int i3, int i16, int i17) {
        }

        public void b(h hVar) {
        }

        public void c(h hVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f131319a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f131320b;

        public e() {
        }

        public void a(d dVar) {
            this.f131319a.add(dVar);
        }

        @Override // com.tencent.luggage.wxa.k.i.a
        public void b() {
            if (this.f131320b) {
                this.f131320b = false;
                h.this.requestLayout();
            }
            Iterator it = this.f131319a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).b(h.this);
            }
        }

        @Override // com.tencent.luggage.wxa.k.i.a
        public void c() {
            Iterator it = this.f131319a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).c(h.this);
            }
        }

        public void d() {
            this.f131320b = true;
        }

        @Override // com.tencent.luggage.wxa.k.i.a
        public void a() {
            Iterator it = this.f131319a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(h.this);
            }
        }

        @Override // com.tencent.luggage.wxa.k.i.a
        public void a(byte[] bArr) {
            Iterator it = this.f131319a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(h.this, bArr);
            }
        }

        @Override // com.tencent.luggage.wxa.k.i.a
        public void a(String str) {
            Iterator it = this.f131319a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(h.this, str);
            }
        }

        @Override // com.tencent.luggage.wxa.k.i.a
        public void a(byte[] bArr, int i3, int i16, int i17) {
            if (h.this.f131309i) {
                return;
            }
            h.this.f131308h = bArr;
            Iterator it = this.f131319a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(h.this, bArr, i3, i16, i17);
            }
        }
    }

    public h(Context context, boolean z16) {
        this(context, null, z16);
    }

    @Override // com.tencent.luggage.wxa.k.p.a
    public void b() {
    }

    @Override // com.tencent.luggage.wxa.k.p.a
    public void c() {
        i iVar = this.f131301a;
        if (iVar != null && iVar.z() && this.f131310j) {
            a(true, false, 1);
        }
    }

    public final void d() {
        if (this.f131313m == null) {
            p pVar = new p();
            this.f131313m = pVar;
            pVar.a(this);
        }
        i iVar = this.f131301a;
        if (iVar != null) {
            iVar.v().setOnTouchListener(this.f131313m);
        }
    }

    public boolean e() {
        return this.f131301a.y();
    }

    public void f() {
        this.f131301a.B();
    }

    public boolean g() {
        com.tencent.luggage.wxa.k.f.c("WMPF.CameraView", "start camera begin");
        if (this.f131312l instanceof l) {
            return h();
        }
        return i();
    }

    public boolean getAdjustViewBounds() {
        return this.f131303c;
    }

    @Nullable
    public com.tencent.luggage.wxa.k.a getAspectRatio() {
        return this.f131301a.b();
    }

    public boolean getAutoFocus() {
        return this.f131301a.c();
    }

    public int getCameraId() {
        return this.f131301a.d();
    }

    public int getCameraOrientation() {
        return this.f131301a.e();
    }

    public byte[] getCurrentFrameData() {
        if (this.f131308h != null) {
            this.f131309i = true;
            byte[] bArr = new byte[this.f131308h.length];
            System.arraycopy(this.f131308h, 0, bArr, 0, this.f131308h.length);
            this.f131309i = false;
            return bArr;
        }
        return null;
    }

    public float getDisplayRatio() {
        return this.f131301a.f();
    }

    public EGLContext getEglContext() {
        o oVar = this.f131312l;
        if (oVar instanceof l) {
            return ((l) oVar).j();
        }
        return null;
    }

    public int getFacing() {
        return this.f131301a.g();
    }

    public int getFlash() {
        return this.f131301a.h();
    }

    public float getFocusDepth() {
        return this.f131301a.j();
    }

    public q getPictureSize() {
        return this.f131301a.m();
    }

    public q getPreviewSize() {
        return this.f131301a.o();
    }

    public int getPreviewSizeLimit() {
        return this.f131301a.p();
    }

    public boolean getScanning() {
        return this.f131301a.r();
    }

    public float[] getSupportZoomRatios() {
        i iVar = this.f131301a;
        if (iVar == null) {
            return new float[0];
        }
        return iVar.s();
    }

    public Set<com.tencent.luggage.wxa.k.a> getSupportedAspectRatios() {
        return this.f131301a.t();
    }

    public Point getVideoSize() {
        return this.f131301a.u();
    }

    public View getView() {
        i iVar = this.f131301a;
        if (iVar != null) {
            return iVar.v();
        }
        return null;
    }

    public int getWhiteBalance() {
        return this.f131301a.w();
    }

    public float getZoom() {
        return this.f131301a.x();
    }

    public final boolean h() {
        ((l) this.f131312l).a(new c());
        return true;
    }

    public final boolean i() {
        boolean C = this.f131301a.C();
        if (C) {
            com.tencent.luggage.wxa.k.f.c("WMPF.CameraView", "start camera success");
        } else {
            com.tencent.luggage.wxa.k.f.c("WMPF.CameraView", "start camera fail, try Camera1");
            Parcelable onSaveInstanceState = onSaveInstanceState();
            o oVar = this.f131312l;
            if (oVar == null || oVar.g() == null) {
                this.f131312l = a(getContext());
            }
            this.f131301a = new com.tencent.luggage.wxa.k.b(this.f131302b, this.f131312l, getContext());
            onRestoreInstanceState(onSaveInstanceState);
            C = this.f131301a.C();
            if (C) {
                com.tencent.luggage.wxa.k.f.c("WMPF.CameraView", "start camera with Camera1 success, set to use Camera1 in the future");
                com.tencent.luggage.wxa.k.e.b().c();
            } else {
                com.tencent.luggage.wxa.k.f.c("WMPF.CameraView", "start camera with Camera1 fail");
            }
        }
        d();
        return C;
    }

    public void j() {
        o oVar = this.f131312l;
        if (oVar instanceof l) {
            l lVar = (l) oVar;
            lVar.m();
            lVar.l();
        }
        this.f131301a.D();
        this.f131308h = null;
    }

    public void k() {
        this.f131301a.E();
    }

    public void l() {
        this.f131301a.F();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.C.a(ViewCompat.getDisplay(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.C.a();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (isInEditMode()) {
            super.onMeasure(i3, i16);
            return;
        }
        if (this.f131303c) {
            if (!e()) {
                this.f131302b.d();
                super.onMeasure(i3, i16);
                return;
            }
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            if (mode == 1073741824 && mode2 != 1073741824) {
                com.tencent.luggage.wxa.k.a aspectRatio = getAspectRatio();
                if (!D && aspectRatio == null) {
                    throw new AssertionError();
                }
                int size = (int) (View.MeasureSpec.getSize(i3) * aspectRatio.d());
                if (mode2 == Integer.MIN_VALUE) {
                    size = Math.min(size, View.MeasureSpec.getSize(i16));
                }
                super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            } else if (mode != 1073741824 && mode2 == 1073741824) {
                com.tencent.luggage.wxa.k.a aspectRatio2 = getAspectRatio();
                if (!D && aspectRatio2 == null) {
                    throw new AssertionError();
                }
                int size2 = (int) (View.MeasureSpec.getSize(i16) * aspectRatio2.d());
                if (mode == Integer.MIN_VALUE) {
                    size2 = Math.min(size2, View.MeasureSpec.getSize(i3));
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), i16);
            } else {
                super.onMeasure(i3, i16);
            }
        } else {
            super.onMeasure(i3, i16);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        com.tencent.luggage.wxa.k.a aspectRatio3 = getAspectRatio();
        if (this.C.b() % 180 == 0) {
            aspectRatio3 = aspectRatio3.c();
        }
        if (!D && aspectRatio3 == null) {
            throw new AssertionError();
        }
        if (measuredHeight < (aspectRatio3.b() * measuredWidth) / aspectRatio3.a()) {
            this.f131301a.v().measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((measuredWidth * aspectRatio3.b()) / aspectRatio3.a(), 1073741824));
        } else {
            this.f131301a.v().measure(View.MeasureSpec.makeMeasureSpec((aspectRatio3.a() * measuredHeight) / aspectRatio3.b(), 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        setFacing(fVar.f131322a);
        setAspectRatio(fVar.f131323b);
        setAutoFocus(fVar.f131324c);
        setFlash(fVar.f131325d);
        setFocusDepth(fVar.f131326e);
        setZoom(fVar.f131327f);
        setWhiteBalance(fVar.f131328g);
        setScanning(fVar.f131329h);
        setPictureSize(fVar.f131330i);
        setPreviewSizeLimit(fVar.f131331j);
        setDisplayRatio(fVar.f131332k);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        fVar.f131322a = getFacing();
        fVar.f131323b = getAspectRatio();
        fVar.f131324c = getAutoFocus();
        fVar.f131325d = getFlash();
        fVar.f131326e = getFocusDepth();
        fVar.f131327f = getZoom();
        fVar.f131328g = getWhiteBalance();
        fVar.f131329h = getScanning();
        fVar.f131330i = getPictureSize();
        fVar.f131331j = getPreviewSizeLimit();
        fVar.f131332k = getDisplayRatio();
        return fVar;
    }

    public void setAdjustViewBounds(boolean z16) {
        if (this.f131303c != z16) {
            this.f131303c = z16;
            requestLayout();
        }
    }

    public void setAspectRatio(@NonNull com.tencent.luggage.wxa.k.a aVar) {
        if (this.f131301a.a(aVar)) {
            requestLayout();
        }
    }

    public void setAutoFocus(boolean z16) {
        this.f131301a.a(z16);
    }

    public void setClipVideoSize(boolean z16) {
        this.f131301a.b(z16);
    }

    public void setDisplayRatio(float f16) {
        com.tencent.luggage.wxa.k.f.a("WMPF.CameraView", "setDisplayRatio: %s, screenRotation: %s", Float.valueOf(f16), Integer.valueOf(com.tencent.luggage.wxa.l.b.b(this.f131304d)));
        this.f131301a.a(f16);
    }

    public void setDisplayScreenSize(Size size) {
        this.f131301a.a(size);
    }

    public void setEnableDragZoom(boolean z16) {
        this.f131310j = z16;
    }

    public void setEnableTouchFocus(boolean z16) {
        this.f131311k = z16;
    }

    public void setFacing(int i3) {
        this.f131301a.b(i3);
    }

    public void setFlash(int i3) {
        this.f131301a.c(i3);
    }

    public void setFocusDepth(float f16) {
        this.f131301a.b(f16);
    }

    public void setForceZoomTargetRatio(float f16) {
        i iVar = this.f131301a;
        if (iVar == null) {
            return;
        }
        iVar.a(Float.valueOf(f16));
    }

    public void setPictureSize(@NonNull q qVar) {
        this.f131301a.a(qVar);
    }

    public void setPreviewSizeLimit(int i3) {
        this.f131301a.d(i3);
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.f131301a.a(surfaceTexture);
    }

    public void setScanning(boolean z16) {
        this.f131301a.c(z16);
    }

    public void setUsingCamera2Api(boolean z16) {
        boolean e16 = e();
        Parcelable onSaveInstanceState = onSaveInstanceState();
        if (z16) {
            if (e16) {
                j();
            }
            this.f131301a = new com.tencent.luggage.wxa.k.d(this.f131302b, this.f131301a.f131334b, this.f131304d);
        } else {
            if (this.f131301a instanceof com.tencent.luggage.wxa.k.b) {
                return;
            }
            if (e16) {
                j();
            }
            this.f131301a = new com.tencent.luggage.wxa.k.b(this.f131302b, this.f131301a.f131334b, this.f131304d);
        }
        onRestoreInstanceState(onSaveInstanceState);
        if (e16) {
            g();
        }
    }

    public void setWhiteBalance(int i3) {
        this.f131301a.e(i3);
    }

    public void setZoom(float f16) {
        this.f131301a.c(f16);
    }

    public h(Context context, AttributeSet attributeSet, boolean z16) {
        this(context, attributeSet, 0, z16);
    }

    public h(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3);
        this.f131305e = -1;
        this.f131306f = -1;
        this.f131308h = null;
        this.f131309i = false;
        this.f131310j = true;
        this.f131311k = true;
        if (isInEditMode()) {
            this.f131302b = null;
            this.C = null;
            return;
        }
        this.f131303c = true;
        this.f131304d = context;
        this.f131312l = a(context);
        e eVar = new e();
        this.f131302b = eVar;
        this.f131301a = a(context, this.f131312l, eVar);
        this.C = new a(context);
    }

    public final o a(Context context) {
        return new t(context, this);
    }

    public final i a(Context context, o oVar, e eVar) {
        if (com.tencent.luggage.wxa.k.e.b().d()) {
            com.tencent.luggage.wxa.k.f.b("WMPF.CameraView", "createCameraViewImpl, sdk version = %d, create Camera1 (for previous experience)", Integer.valueOf(Build.VERSION.SDK_INT));
            return new com.tencent.luggage.wxa.k.b(eVar, oVar, context);
        }
        com.tencent.luggage.wxa.k.f.b("WMPF.CameraView", "createCameraViewImpl, sdk version = %d, create Camera2Api23", Integer.valueOf(Build.VERSION.SDK_INT));
        return new com.tencent.luggage.wxa.k.d(eVar, oVar, context);
    }

    public void a(d dVar) {
        this.f131302b.a(dVar);
    }

    public boolean a(String str, int i3, int i16, boolean z16, CamcorderProfile camcorderProfile, boolean z17) {
        return this.f131301a.a(str, i3, i16, z16, camcorderProfile, z17);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = ParcelableCompat.newCreator(new a());

        /* renamed from: a, reason: collision with root package name */
        public int f131322a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.luggage.wxa.k.a f131323b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f131324c;

        /* renamed from: d, reason: collision with root package name */
        public int f131325d;

        /* renamed from: e, reason: collision with root package name */
        public float f131326e;

        /* renamed from: f, reason: collision with root package name */
        public float f131327f;

        /* renamed from: g, reason: collision with root package name */
        public int f131328g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f131329h;

        /* renamed from: i, reason: collision with root package name */
        public q f131330i;

        /* renamed from: j, reason: collision with root package name */
        public int f131331j;

        /* renamed from: k, reason: collision with root package name */
        public float f131332k;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements ParcelableCompatCreatorCallbacks {
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i3) {
                return new f[i3];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f131322a = parcel.readInt();
            this.f131323b = (com.tencent.luggage.wxa.k.a) parcel.readParcelable(classLoader);
            this.f131324c = parcel.readByte() != 0;
            this.f131325d = parcel.readInt();
            this.f131326e = parcel.readFloat();
            this.f131327f = parcel.readFloat();
            this.f131328g = parcel.readInt();
            this.f131329h = parcel.readByte() != 0;
            this.f131330i = (q) parcel.readParcelable(classLoader);
            this.f131331j = parcel.readInt();
            this.f131332k = parcel.readFloat();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f131322a);
            parcel.writeParcelable(this.f131323b, 0);
            parcel.writeByte(this.f131324c ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f131325d);
            parcel.writeFloat(this.f131326e);
            parcel.writeFloat(this.f131327f);
            parcel.writeInt(this.f131328g);
            parcel.writeByte(this.f131329h ? (byte) 1 : (byte) 0);
            parcel.writeParcelable(this.f131330i, i3);
            parcel.writeInt(this.f131331j);
            parcel.writeFloat(this.f131332k);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void a(MotionEvent motionEvent) {
        p pVar = this.f131313m;
        if (pVar != null) {
            pVar.onTouch(this, motionEvent);
        }
    }

    @Override // com.tencent.luggage.wxa.k.p.a
    public void a(float f16, float f17) {
        i iVar = this.f131301a;
        if (iVar != null && iVar.z() && this.f131311k) {
            this.f131301a.a(f16, f17);
        }
    }

    @Override // com.tencent.luggage.wxa.k.p.a
    public void a() {
        i iVar = this.f131301a;
        if (iVar != null && iVar.z() && this.f131310j) {
            a(false, false, 1);
        }
    }

    public final void a(boolean z16, boolean z17, int i3) {
        int i16;
        float f16;
        i iVar = this.f131301a;
        if (iVar == null || !iVar.z()) {
            return;
        }
        try {
            try {
                com.tencent.luggage.wxa.k.f.a("WMPF.CameraView", "triggerSmallZoom, zoom: " + z16);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.k.f.b("WMPF.CameraView", "triggerSmallZoom error: " + e16.getMessage());
            }
            if (this.f131307g) {
                com.tencent.luggage.wxa.k.f.a("WMPF.CameraView", "triggerSmallZoom, zooming, ignore");
                return;
            }
            if (this.f131301a.A()) {
                this.f131307g = true;
                float l3 = this.f131301a.l();
                float x16 = this.f131301a.x() * l3;
                if (!z17) {
                    if (this.f131305e <= 0) {
                        int round = Math.round(l3 / 15.0f);
                        this.f131305e = round;
                        if (round > 5) {
                            this.f131305e = 5;
                        }
                    }
                    i16 = this.f131305e;
                } else {
                    i16 = this.f131306f;
                    if (i16 <= 0) {
                        com.tencent.luggage.wxa.k.f.b("WMPF.CameraView", "scroll zoom error, scrollSmallZoomStep: " + this.f131306f);
                        return;
                    }
                }
                com.tencent.luggage.wxa.k.f.a("WMPF.CameraView", "triggerSmallZoom, currentZoom: " + x16 + " maxZoom: " + l3 + " smallZoomStep: " + this.f131305e + " scrollSmallZoomStep: " + this.f131306f + " factor: " + i3);
                if (i3 >= 1) {
                    i16 *= i3;
                }
                if (z16) {
                    if (x16 >= l3) {
                        return;
                    }
                    f16 = x16 + i16;
                    if (f16 >= l3) {
                        f16 = l3;
                    }
                } else {
                    if (x16 == 0.0f) {
                        return;
                    }
                    f16 = x16 - i16;
                    if (f16 <= 0.0f) {
                        f16 = 0.0f;
                    }
                }
                com.tencent.luggage.wxa.k.f.a("WMPF.CameraView", "triggerSmallZoom, nextZoom: " + f16);
                this.f131301a.c(f16 / l3);
            }
        } finally {
            this.f131307g = false;
        }
    }

    public h(Context context, Surface surface, int i3, int i16) {
        super(context, null, 0);
        this.f131305e = -1;
        this.f131306f = -1;
        this.f131308h = null;
        this.f131309i = false;
        this.f131310j = true;
        this.f131311k = true;
        if (isInEditMode()) {
            this.f131302b = null;
            this.C = null;
            return;
        }
        this.f131303c = true;
        this.f131304d = context;
        this.f131312l = new m(context, this, surface, i3, i16);
        e eVar = new e();
        this.f131302b = eVar;
        this.f131301a = a(context, this.f131312l, eVar);
        this.C = new b(context);
    }
}

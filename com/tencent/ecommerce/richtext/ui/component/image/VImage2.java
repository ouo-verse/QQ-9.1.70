package com.tencent.ecommerce.richtext.ui.component.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.ecommerce.richtext.ui.dom.style.g;
import com.tencent.ecommerce.richtext.ui.view.image.VImageView2;
import com.tencent.ecommerce.richtext.utils.e;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import ik0.c;
import ik0.d;
import java.lang.ref.WeakReference;
import lk0.h;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VImage2 extends c<VImageView2> implements com.tencent.ecommerce.richtext.ui.component.image.a {

    /* renamed from: k, reason: collision with root package name */
    private String f105320k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f105321l;

    /* renamed from: m, reason: collision with root package name */
    private b f105322m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f105329d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f105330e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f105331f;

        a(View view, boolean z16, String str) {
            this.f105329d = view;
            this.f105330e = z16;
            this.f105331f = str;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewGroup.LayoutParams layoutParams;
            this.f105329d.getViewTreeObserver().removeOnPreDrawListener(this);
            int width = this.f105329d.getWidth();
            int height = this.f105329d.getHeight();
            if ((width == 0 || height == 0) && (layoutParams = this.f105329d.getLayoutParams()) != null) {
                width = layoutParams.width;
                height = layoutParams.height;
            }
            VImage2.this.j0(width, height, this.f105330e, this.f105331f);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<VImage2> f105333a;

        public b(VImage2 vImage2) {
            this.f105333a = new WeakReference<>(vImage2);
        }

        private void a() {
            VImageView2 n3;
            VImage2 vImage2 = this.f105333a.get();
            if (vImage2 != null && (n3 = vImage2.n()) != null && n3.getDrawable() == null && !TextUtils.isEmpty(vImage2.f105320k)) {
                vImage2.l0(false, vImage2.f105320k);
            }
        }

        public void b() {
            removeMessages(1);
        }

        public void c() {
            if (!hasMessages(1)) {
                sendEmptyMessageDelayed(1, 3500L);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a();
            }
        }
    }

    public VImage2(fk0.c cVar, lk0.b bVar, d dVar) {
        super(cVar, bVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int V(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            int i18 = options.outHeight;
            int i19 = options.outWidth;
            while (i18 > i16 && i19 > i3) {
                int round = Math.round(i18 / i16);
                int round2 = Math.round(i19 / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                i19 >>= 1;
                i18 >>= 1;
                i17 <<= 1;
            }
        }
        return i17;
    }

    private void W(boolean z16, String str) {
        VImageView2 n3 = n();
        if (n3 == null) {
            return;
        }
        n3.getViewTreeObserver().addOnPreDrawListener(new a(n3, z16, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(final Bitmap bitmap, final String str, final Bundle bundle) {
        fk0.d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.component.image.VImage2.3
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    VImage2.this.a(bitmap2, str, bundle);
                } else {
                    VImage2.this.onError();
                }
            }
        });
    }

    public static ImageView.ScaleType Z(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (TextUtils.isEmpty(str)) {
            return scaleType;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c16 = 0;
                    break;
                }
                break;
            case 94852023:
                if (str.equals("cover")) {
                    c16 = 1;
                    break;
                }
                break;
            case 951526612:
                if (str.equals(HVideoConstants.ResizeType.RESIZE_CONTAIN)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return ImageView.ScaleType.FIT_XY;
            case 1:
                return ImageView.ScaleType.CENTER_CROP;
            case 2:
                return ImageView.ScaleType.FIT_CENTER;
            default:
                return scaleType;
        }
    }

    private boolean d0() {
        if (this.f407893d == null) {
            return false;
        }
        lk0.a Z = this.f407893d.Z();
        if (!Z.containsKey("autosize") || "none".equals(Z.get("autosize").toString())) {
            return false;
        }
        h g06 = this.f407893d.g0();
        if (g06.containsKey("width") && g06.containsKey("height")) {
            return false;
        }
        if (!g06.containsKey("width") && !g06.containsKey("height")) {
            return false;
        }
        return true;
    }

    public static boolean e0(String str) {
        if (!str.startsWith("data:image/jpg;base64,") && !str.startsWith("data:image/png;base64,") && !str.startsWith("data:image/jpeg;base64,")) {
            return false;
        }
        return true;
    }

    private boolean g0() {
        if (!b0() && !d0()) {
            return false;
        }
        return true;
    }

    private boolean h0() {
        boolean z16;
        boolean z17;
        VImageView2 n3 = n();
        if (n3 == null) {
            return false;
        }
        if (this.f407893d != null) {
            h g06 = this.f407893d.g0();
            if (g06.Z(this.f407893d.i0()) != 0.0f && g06.w(this.f407893d.i0()) != 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.f407893d.j() != 0.0f && this.f407893d.i() != 0.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z16 && !z17) {
                return false;
            }
            return true;
        }
        if (n3.getHeight() == 0 || n3.getWidth() == 0) {
            return false;
        }
        return true;
    }

    private void i0(final String str, final int i3, final int i16, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fk0.d.c().d(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.component.image.VImage2.2
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                int i17;
                byte[] decode = Base64.decode(str.split(",")[1], 0);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                try {
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inJustDecodeBounds = false;
                    int i18 = i3;
                    if (i18 != 0 && (i17 = i16) != 0) {
                        try {
                            options.inSampleSize = VImage2.V(options, i18, i17);
                        } catch (ArithmeticException unused) {
                        }
                    }
                    bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                } catch (OutOfMemoryError unused2) {
                    bitmap = null;
                }
                VImage2.this.X(bitmap, str, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(int i3, int i16, boolean z16, String str) {
        VImageView2 n3 = n();
        dk0.d a16 = fk0.d.c().a();
        if (n3 != null && a16 != null) {
            if (!z16) {
                n3.setImageDrawable(null);
            }
            boolean g06 = g0();
            if (e0(str)) {
                if (!z16) {
                    n3.setImageStartTs(System.currentTimeMillis());
                }
                i0(str, i3, i16, g06);
            } else {
                if (!z16) {
                    n3.setImageStartTs(System.currentTimeMillis());
                }
                a16.a(str, i3, i16, g06, this, f0(), n3.getScaleType());
            }
        }
    }

    private void k0() {
        b bVar = this.f105322m;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(boolean z16, String str) {
        if (h0()) {
            if (this.f407893d != null) {
                h g06 = this.f407893d.g0();
                int Z = (int) g06.Z(this.f407893d.i0());
                int w3 = (int) g06.w(this.f407893d.i0());
                float j3 = this.f407893d.j();
                float i3 = this.f407893d.i();
                if (Z != 0 && w3 != 0) {
                    j0(Z, w3, z16, str);
                    return;
                } else if (j3 != 0.0f && i3 != 0.0f) {
                    j0((int) j3, (int) i3, z16, str);
                    return;
                } else {
                    j0(n().getWidth(), n().getHeight(), z16, str);
                    return;
                }
            }
            return;
        }
        W(z16, str);
    }

    private void m0(Object obj) {
        VImageView2 n3 = n();
        if (n3 == null) {
            return;
        }
        if (obj instanceof Bitmap) {
            n3.setImageBitmap((Bitmap) obj);
        } else if (obj instanceof Drawable) {
            n3.setImageDrawable((Drawable) obj);
        }
    }

    private void n0(String str) {
        if (n() != null) {
            n().setScaleType(Z(str));
        }
    }

    private void p0(Object obj, String str, boolean z16) {
        if (obj != null && n() != null) {
            VImageView2 n3 = n();
            if (z16) {
                if (n3.getDrawable() == null && !this.f105321l) {
                    n3.setNeedFading(false);
                    m0(obj);
                    this.f105321l = true;
                    return;
                }
                return;
            }
            this.f105321l = true;
            n3.setNeedFading(true);
            n3.setUrl(str);
            m0(obj);
        }
    }

    @Override // ik0.c
    public void A(float f16) {
        super.A(f16);
        if (n() != null) {
            n().setBottomRightBorderRadius(f16);
        }
    }

    @Override // ik0.c
    public void B(float f16) {
        super.B(f16);
        if (n() != null) {
            n().setTopLeftBorderRadius(f16);
        }
    }

    @Override // ik0.c
    public void C(float f16) {
        super.C(f16);
        if (n() != null) {
            n().setTopRightBorderRadius(f16);
        }
    }

    @Override // ik0.c
    public void E(int i3, float f16) {
        super.E(i3, f16);
        if (n() != null) {
            n().setBorderRadius(f16);
        }
    }

    @Override // ik0.c
    public void G(int i3, float f16) {
        super.G(i3, f16);
        if (n() != null) {
            n().setBorderWidth(f16);
        }
    }

    @Override // ik0.c
    protected boolean M(String str, Object obj) {
        str.hashCode();
        if (!str.equals("resize")) {
            if (str.equals("src")) {
                q0(e.p(obj, ""));
            }
            return super.M(str, obj);
        }
        o0(e.p(obj, "cover"));
        return true;
    }

    public int Y() {
        if (this.f407893d == null) {
            return 0;
        }
        return (int) (((int) g.b(this.f407893d.Z().get("blurRadius"), 750)) * 2.3d);
    }

    @Override // com.tencent.ecommerce.richtext.ui.component.image.a
    public void a(Object obj, String str, Bundle bundle) {
        k0();
        if (n() != null && str != null && str.equals(this.f105320k)) {
            p0(obj, str, false);
        }
    }

    public int a0() {
        if (this.f407893d == null) {
            return 7;
        }
        return e.n(this.f407893d.g0().get("scaleRadio"), 7);
    }

    protected boolean b0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ik0.c
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public VImageView2 q(@NonNull Context context) {
        VImageView2 vImageView2 = new VImageView2(context);
        vImageView2.f(this);
        vImageView2.m(this.f407893d);
        vImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        vImageView2.setCropToPadding(true);
        this.f105322m = new b(this);
        return vImageView2;
    }

    public boolean f0() {
        return false;
    }

    @Override // com.tencent.ecommerce.richtext.ui.component.image.a
    public ImageView getTarget() {
        return n();
    }

    public void o0(String str) {
        if (str != null) {
            n0(str);
        }
    }

    @Override // com.tencent.ecommerce.richtext.ui.component.image.a
    public void onCancel() {
        this.f105320k = null;
        k0();
    }

    @Override // com.tencent.ecommerce.richtext.ui.component.image.a
    public void onError() {
        this.f105320k = null;
        k0();
    }

    public void q0(String str) {
        b bVar;
        VImageView2 n3 = n();
        if (n3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.equals(this.f105320k)) {
            this.f105320k = str;
            l0(false, str);
            k0();
        } else if (n3.getDrawable() == null && (bVar = this.f105322m) != null) {
            bVar.c();
        }
    }

    @Override // ik0.c
    public void z(float f16) {
        super.z(f16);
        if (n() != null) {
            n().setBottomLeftBorderRadius(f16);
        }
    }
}

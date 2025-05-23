package lk0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.ecommerce.richtext.ui.component.image.VImage2;
import com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import dk0.d;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i extends ImageSpan {
    private float[] C;
    private float D;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<f> f414944d;

    /* renamed from: e, reason: collision with root package name */
    private final b f414945e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f414946f;

    /* renamed from: h, reason: collision with root package name */
    private int f414947h;

    /* renamed from: i, reason: collision with root package name */
    private int f414948i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView.ScaleType f414949m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ImageDrawable.a {
        a() {
        }

        @Override // com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.a
        public void a(Drawable drawable, String str) {
            ImageDrawable imageDrawable = (ImageDrawable) drawable;
            if (!i.this.h()) {
                imageDrawable.setCornerRadii(i.this.C);
            } else if (i.this.D != 0.0f) {
                imageDrawable.setCornerRadius(i.this.D);
            }
            i.this.l(imageDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<i> f414951a;

        public b(i iVar) {
            this.f414951a = new WeakReference<>(iVar);
        }

        @Override // dk0.d.a
        public void a(String str, Drawable drawable, boolean z16, Bundle bundle) {
            if (this.f414951a.get() != null) {
                this.f414951a.get().k(str, drawable, z16, bundle);
            }
        }
    }

    public i(int i3, int i16, int i17, String str, h hVar, f fVar) {
        this(null, i3);
        if (fVar != null) {
            this.f414944d = new WeakReference<>(fVar);
        }
        this.f414947h = i16;
        this.f414948i = i17;
        this.f414949m = VImage2.Z(str);
        g(hVar);
    }

    private void e() {
        if (this.C == null) {
            this.C = new float[8];
        }
    }

    private boolean f() {
        if (this.D == 0.0f && h()) {
            return false;
        }
        return true;
    }

    private void g(h hVar) {
        if (hVar.containsKey(NodeProps.BORDER_TOP_LEFT_RADIUS)) {
            float j3 = com.tencent.ecommerce.richtext.ui.dom.style.g.j(hVar.get(NodeProps.BORDER_TOP_LEFT_RADIUS), 750);
            e();
            float[] fArr = this.C;
            fArr[0] = j3;
            fArr[1] = j3;
        }
        if (hVar.containsKey(NodeProps.BORDER_TOP_RIGHT_RADIUS)) {
            float j16 = com.tencent.ecommerce.richtext.ui.dom.style.g.j(hVar.get(NodeProps.BORDER_TOP_RIGHT_RADIUS), 750);
            e();
            float[] fArr2 = this.C;
            fArr2[2] = j16;
            fArr2[3] = j16;
        }
        if (hVar.containsKey(NodeProps.BORDER_BOTTOM_LEFT_RADIUS)) {
            float j17 = com.tencent.ecommerce.richtext.ui.dom.style.g.j(hVar.get(NodeProps.BORDER_BOTTOM_LEFT_RADIUS), 750);
            e();
            float[] fArr3 = this.C;
            fArr3[4] = j17;
            fArr3[5] = j17;
        }
        if (hVar.containsKey(NodeProps.BORDER_BOTTOM_RIGHT_RADIUS)) {
            float j18 = com.tencent.ecommerce.richtext.ui.dom.style.g.j(hVar.get(NodeProps.BORDER_BOTTOM_RIGHT_RADIUS), 750);
            e();
            float[] fArr4 = this.C;
            fArr4[6] = j18;
            fArr4[7] = j18;
        }
        if (hVar.containsKey(NodeProps.BORDER_RADIUS)) {
            this.D = com.tencent.ecommerce.richtext.ui.dom.style.g.j(hVar.get(NodeProps.BORDER_RADIUS), 750);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        float[] fArr = this.C;
        if (fArr == null) {
            return true;
        }
        for (float f16 : fArr) {
            if (f16 != 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Drawable drawable) {
        this.f414946f = drawable;
        drawable.setBounds(0, 0, this.f414947h, this.f414948i);
        WeakReference<f> weakReference = this.f414944d;
        if (weakReference != null && weakReference.get() != null) {
            this.f414944d.get().onLoadFinish(true);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        canvas.save();
        canvas.translate(f16, (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = this.f414946f;
        if (drawable != null) {
            return drawable;
        }
        return super.getDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 0;
        }
        Rect bounds = drawable.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return bounds.right;
    }

    public void i(String str) {
        byte[] decode = Base64.decode(str.split(",")[1], 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = false;
            this.f414945e.a(str, new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length, options)), true, null);
        } catch (OutOfMemoryError unused) {
        }
    }

    public void j(String str) {
        if (VImage2.e0(str)) {
            i(str);
            return;
        }
        dk0.d a16 = fk0.d.c().a();
        if (a16 != null) {
            a16.g(str, this.f414947h, this.f414948i, this.f414945e);
        }
    }

    public void k(String str, Drawable drawable, boolean z16, Bundle bundle) {
        if (z16) {
            if (f()) {
                ImageDrawable.g(drawable, this.f414949m, this.f414947h, this.f414948i, str, new a(), true);
            } else {
                l(ImageDrawable.f(drawable, this.f414949m, this.f414947h, this.f414948i, true));
            }
        }
    }

    public void m(f fVar) {
        this.f414944d = new WeakReference<>(fVar);
    }

    public i(Drawable drawable, int i3) {
        super(drawable, i3);
        this.f414945e = new b(this);
    }
}

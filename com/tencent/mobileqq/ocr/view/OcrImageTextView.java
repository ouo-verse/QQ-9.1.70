package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.OCRImageBean;
import com.tencent.mobileqq.utils.bx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import xy2.d;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OcrImageTextView extends ImageView {
    static IPatchRedirector $redirector_;
    private bx C;
    private float D;
    private float E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private TextPaint f254876d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f254877e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f254878f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f254879h;

    /* renamed from: i, reason: collision with root package name */
    private List<c> f254880i;

    /* renamed from: m, reason: collision with root package name */
    private List<b> f254881m;

    public OcrImageTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        if (bx.INSTANCE.a()) {
            QLog.i("OcrImageTextView", 1, "handleAccessibility disabled.");
            return false;
        }
        if (this.C == null) {
            bx bxVar = new bx(this);
            this.C = bxVar;
            ViewCompat.setAccessibilityDelegate(this, bxVar);
        }
        this.C.b(x());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(c cVar) {
        Bitmap bitmap = cVar.f254948h;
        if (bitmap == null) {
            return;
        }
        boolean z16 = false;
        xy2.d dVar = null;
        try {
            dVar = xy2.d.b(bitmap).b();
            if (dVar.j() != null) {
                z16 = true;
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.ocr.d.q(0, "ocr_palette_suc", th5.getMessage());
        }
        if (z16) {
            d.C11578d j3 = dVar.j();
            cVar.f254962v = j3.e() | (-16777216);
            cVar.f254963w = j3.b() | (-16777216);
            cVar.f254964x = true;
            com.tencent.mobileqq.ocr.d.q(1, "ocr_palette_suc", "");
            return;
        }
        cVar.f254953m = H(cVar.f254948h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(b bVar) {
        xy2.d dVar = null;
        boolean z16 = false;
        try {
            dVar = xy2.d.b(bVar.f254947w).b();
            if (dVar.j() != null) {
                z16 = true;
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.ocr.d.q(0, "ocr_palette_suc", th5.getMessage());
        }
        if (z16) {
            d.C11578d j3 = dVar.j();
            bVar.f254939o = j3.e() | (-16777216);
            bVar.f254940p = j3.b() | (-16777216);
            bVar.f254945u = true;
            com.tencent.mobileqq.ocr.d.q(1, "ocr_palette_suc", "");
            return;
        }
        bVar.f254944t = H(bVar.f254947w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.gallery.picocr.c D(com.tencent.mobileqq.gallery.picocr.c cVar, int i3) {
        Iterator<com.tencent.mobileqq.gallery.picocr.b> it = cVar.f211819f.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.gallery.picocr.b next = it.next();
            int i16 = cVar.f211815b;
            if (i3 != i16) {
                float f16 = i3;
                float f17 = f16 / i16;
                int i17 = cVar.f211826m;
                if (i17 == 90 || i17 == 270) {
                    f17 = f16 / cVar.f211816c;
                }
                next.h(f17);
            }
        }
        return cVar;
    }

    private boolean F() {
        List<c> list = this.f254880i;
        if (list != null && !list.isEmpty()) {
            Iterator<c> it = this.f254880i.iterator();
            while (it.hasNext()) {
                if (it.next().f254926b) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean G() {
        List<b> list = this.f254881m;
        if (list != null && !list.isEmpty()) {
            Iterator<b> it = this.f254881m.iterator();
            while (it.hasNext()) {
                if (it.next().f254926b) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean H(Bitmap bitmap) {
        int height = bitmap.getHeight() / 20;
        int i3 = 5;
        if (height <= 0) {
            height = 5;
        }
        int width = bitmap.getWidth() / 20;
        if (width > 0) {
            i3 = width;
        }
        long j3 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        for (int i16 = 0; i16 < bitmap.getHeight(); i16 += height) {
            int i17 = 0;
            while (i17 < bitmap.getWidth()) {
                int pixel = bitmap.getPixel(i17, i16);
                j3 += Color.red(pixel);
                j17 += Color.green(pixel);
                j18 += Color.blue(pixel);
                i17 += i3;
                j16++;
            }
        }
        if ((((float) (j3 / j16)) * 0.299d) + (((float) (j17 / j16)) * 0.578d) + (((float) (j18 / j16)) * 0.114d) >= 90.0d) {
            return false;
        }
        return true;
    }

    private void J(Canvas canvas) {
        List<c> list = this.f254880i;
        if (list != null && !list.isEmpty()) {
            for (c cVar : this.f254880i) {
                Bitmap bitmap = cVar.f254948h;
                if (bitmap != null && !bitmap.isRecycled()) {
                    q(cVar, cVar.f254950j, cVar.f254951k);
                    cVar.f254957q.set(0, 0, cVar.f254950j, cVar.f254951k);
                    Paint.FontMetricsInt fontMetricsInt = this.f254879h.getFontMetricsInt();
                    int i3 = cVar.f254951k / 2;
                    int i16 = fontMetricsInt.bottom;
                    cVar.f254956p = (i3 + ((i16 - fontMetricsInt.top) / 2)) - i16;
                    Point a16 = cVar.a();
                    canvas.save();
                    canvas.translate(a16.x, a16.y);
                    canvas.rotate(cVar.f254927c);
                    if (cVar.f254964x) {
                        w(canvas, cVar);
                    } else {
                        v(canvas, cVar);
                    }
                    canvas.restore();
                }
            }
        }
    }

    private void K(Canvas canvas) {
        List<b> list = this.f254881m;
        if (list != null && !list.isEmpty()) {
            for (b bVar : this.f254881m) {
                Bitmap bitmap = bVar.f254947w;
                if (bitmap != null && !bitmap.isRecycled() && !TextUtils.isEmpty(bVar.f254932h) && !bVar.d()) {
                    Rect g16 = bVar.g();
                    Point h16 = bVar.h();
                    if (QLog.isColorLevel()) {
                        QLog.i("OcrImageTextView", 2, "rect:" + g16.toShortString() + ", point:" + h16.toString());
                    }
                    canvas.save();
                    canvas.translate(h16.x, h16.y);
                    canvas.rotate(bVar.f254927c);
                    int i3 = -15550475;
                    if (bVar.f254945u) {
                        Paint paint = this.f254879h;
                        if (!bVar.f254926b) {
                            i3 = bVar.f254939o;
                        }
                        paint.setColor(i3);
                        canvas.drawRect(g16, this.f254879h);
                    } else if (bVar.f254926b) {
                        this.f254879h.setColor(-15550475);
                        canvas.drawRect(g16, this.f254879h);
                    } else {
                        canvas.drawBitmap(bVar.f254947w, g16, g16, this.f254879h);
                    }
                    if (TextUtils.isEmpty(bVar.f254932h)) {
                        canvas.restore();
                    } else {
                        int round = Math.round(bVar.f254935k);
                        int width = g16.width() - (bVar.f254942r * 2);
                        int height = g16.height() - (bVar.f254941q * 2);
                        this.f254876d.setTextSize(round);
                        this.f254876d.setColor(bVar.f254940p);
                        StaticLayout r16 = r(bVar.f254932h, this.f254876d, width);
                        if (r16 == null) {
                            canvas.restore();
                        } else {
                            while (r16.getHeight() < height && (round = round + 1) <= 30) {
                                this.f254876d.setTextSize(round);
                                StaticLayout r17 = r(bVar.f254932h, this.f254876d, width);
                                if (r17 == null || r17.getHeight() <= 0) {
                                    break;
                                } else {
                                    r16 = r17;
                                }
                            }
                            while (r16.getHeight() > height && round - 1 >= 5) {
                                this.f254876d.setTextSize(round);
                                StaticLayout r18 = r(bVar.f254932h, this.f254876d, width);
                                if (r18 == null || r18.getHeight() <= 0) {
                                    break;
                                } else {
                                    r16 = r18;
                                }
                            }
                            canvas.translate(bVar.f254942r, (g16.height() / 2) - (r16.getHeight() / 2));
                            r16.draw(canvas);
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap N(Bitmap bitmap) {
        StackBlurManager stackBlurManager = new StackBlurManager(bitmap);
        stackBlurManager.setDbg(false);
        return stackBlurManager.process(64);
    }

    private void O(Bitmap bitmap) {
        super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(ScreenUtil.getRealWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (bitmap.getHeight() * (ScreenUtil.getRealWidth(getContext()) / bitmap.getWidth())), 1073741824));
    }

    private float P(List<com.tencent.mobileqq.gallery.picocr.b> list) {
        int i3 = 0;
        float f16 = 0.0f;
        for (com.tencent.mobileqq.gallery.picocr.b bVar : list) {
            float i16 = com.tencent.mobileqq.ocr.e.i(bVar.f(this.D), bVar.e(this.E), bVar.f211807a, this.f254879h);
            if (i16 > 0.0f) {
                f16 += i16;
                i3++;
            }
        }
        return (f16 * 1.0f) / i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Q(com.tencent.mobileqq.gallery.picocr.b bVar, boolean z16, int i3, String str, int i16, int i17) {
        Point d16;
        if (z16) {
            d16 = bVar.a();
        } else {
            d16 = bVar.d();
        }
        Bitmap u16 = u(this.f254878f, d16, bVar.g(), bVar.c(), i3, this.D, this.E, str);
        if (u16 == null) {
            return null;
        }
        com.tencent.mobileqq.ocr.d.p(1, str, "", "ocr_crop_back_img", "");
        Bitmap N = N(u16);
        if (u16.getHeight() == i17) {
            u16.getWidth();
        }
        return N;
    }

    private CharSequence S() {
        List<c> list = this.f254880i;
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = -2;
            for (c cVar : this.f254880i) {
                if (cVar.f254926b) {
                    if (i3 < 0) {
                        sb5.append(cVar.f254949i.trim());
                        i3 = cVar.f254954n;
                    } else if (cVar.f254954n == i3) {
                        sb5.append(cVar.f254949i.trim());
                    } else {
                        sb5.append("\n\n");
                        sb5.append(cVar.f254949i.trim());
                        i3 = cVar.f254954n;
                    }
                }
            }
            return sb5.toString();
        }
        return "";
    }

    private CharSequence T() {
        List<b> list = this.f254881m;
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (b bVar : this.f254881m) {
                if (bVar.f254926b) {
                    sb5.append(bVar.f254932h);
                    sb5.append("\n\n");
                }
            }
            return sb5.toString();
        }
        return "";
    }

    private b U(List<com.tencent.mobileqq.gallery.picocr.b> list, String str) {
        b bVar = null;
        if (list != null && !list.isEmpty()) {
            for (com.tencent.mobileqq.gallery.picocr.b bVar2 : list) {
                if (bVar == null) {
                    bVar = new b(bVar2);
                } else {
                    bVar.b(bVar2);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                bVar.f254932h = str;
            }
            bVar.f254936l = P(list);
            bVar.f254937m = list.size();
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<b> V(List<com.tencent.mobileqq.gallery.picocr.b> list, TranslateResult translateResult) {
        if (translateResult.f254724h == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (com.tencent.mobileqq.gallery.picocr.b bVar : list) {
            int i3 = bVar.f211810d;
            if (i3 != -1) {
                if (hashMap.containsKey(Integer.valueOf(i3))) {
                    ((List) hashMap.get(Integer.valueOf(bVar.f211810d))).add(bVar);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    hashMap.put(Integer.valueOf(bVar.f211810d), arrayList);
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        for (TranslateResult.Record record : translateResult.f254724h) {
            hashMap2.put(record.f254727d.replace(" ", ""), record.f254728e);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) hashMap2.get(com.tencent.mobileqq.ocr.e.j((List) entry.getValue()));
            if (!TextUtils.isEmpty(str)) {
                b U = U((List) entry.getValue(), str);
                if (U != null) {
                    arrayList2.add(U);
                }
            } else {
                for (com.tencent.mobileqq.gallery.picocr.b bVar2 : (List) entry.getValue()) {
                    b U2 = U(Collections.singletonList(bVar2), (String) hashMap2.get(bVar2.f211807a.replace(" ", "")));
                    if (U2 != null) {
                        arrayList2.add(U2);
                    }
                }
            }
        }
        return arrayList2;
    }

    private void q(c cVar, int i3, int i16) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f254949i) && i3 > 0) {
            float f16 = cVar.f254952l;
            if (f16 > 0.0f) {
                this.f254879h.setTextSize(f16);
                return;
            }
            cVar.f254952l = com.tencent.mobileqq.ocr.e.i(i3, i16, cVar.f254949i, this.f254879h);
            Rect rect = new Rect();
            Paint paint = this.f254879h;
            String str = cVar.f254949i;
            paint.getTextBounds(str, 0, str.length(), rect);
            cVar.f254958r = (i3 - rect.width()) / 2;
            cVar.f254959s = (i16 - rect.height()) / 2;
            this.f254879h.setTextSize(cVar.f254952l);
            return;
        }
        this.f254879h.setTextSize(30.0f);
    }

    private StaticLayout r(CharSequence charSequence, TextPaint textPaint, int i3) {
        if (TextUtils.isEmpty(charSequence) || textPaint == null || i3 <= 0) {
            return null;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i3);
        obtain.setAlignment(Layout.Alignment.ALIGN_NORMAL);
        obtain.setLineSpacing(0.0f, 1.0f);
        obtain.setIncludePad(false);
        obtain.setEllipsize(null);
        return obtain.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap u(Bitmap bitmap, Point point, int i3, int i16, int i17, float f16, float f17, String str) {
        int i18;
        int i19;
        if (bitmap != null && !bitmap.isRecycled()) {
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f17);
            try {
                if (point.x + i3 > bitmap.getWidth()) {
                    i18 = bitmap.getWidth() - point.x;
                } else {
                    i18 = i3;
                }
                if (point.y + i16 > bitmap.getHeight()) {
                    i19 = bitmap.getHeight() - point.y;
                } else {
                    i19 = i16;
                }
                return Bitmap.createBitmap(bitmap, point.x, point.y, i18, i19, matrix, false);
            } catch (Throwable th5) {
                QLog.e("OcrImageTextView", 2, "cropBitmap error=" + th5.getMessage());
                com.tencent.mobileqq.ocr.d.p(0, str, "", "ocr_crop_back_img", th5.getMessage());
            }
        }
        return null;
    }

    private void v(Canvas canvas, c cVar) {
        int i3;
        if (cVar.f254926b) {
            this.f254879h.setColor(-15550475);
            canvas.drawRect(cVar.f254957q, this.f254879h);
        } else {
            Bitmap bitmap = cVar.f254948h;
            Rect rect = cVar.f254957q;
            canvas.drawBitmap(bitmap, rect, rect, this.f254879h);
        }
        Paint paint = this.f254879h;
        if (cVar.f254953m) {
            i3 = -1;
        } else {
            i3 = -16777216;
        }
        paint.setColor(i3);
        canvas.drawText(cVar.f254949i, 0.0f, cVar.f254956p, this.f254879h);
    }

    private void w(Canvas canvas, c cVar) {
        int i3;
        Paint paint = this.f254879h;
        if (cVar.f254926b) {
            i3 = -15550475;
        } else {
            i3 = cVar.f254962v;
        }
        paint.setColor(i3);
        canvas.drawRect(cVar.f254957q, this.f254879h);
        this.f254879h.setColor(cVar.f254963w);
        canvas.drawText(cVar.f254949i, 0.0f, cVar.f254956p, this.f254879h);
    }

    private List<OCRImageBean> x() {
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mobileqq.ocr.d.f254704a) {
            for (int i3 = 0; i3 < this.f254881m.size(); i3++) {
                b bVar = this.f254881m.get(i3);
                Rect g16 = bVar.g();
                Point h16 = bVar.h();
                int i16 = g16.left;
                int i17 = h16.x;
                int i18 = g16.top;
                int i19 = h16.y;
                Rect rect = new Rect(i16 + i17, i18 + i19, g16.right + i17, g16.bottom + i19);
                if (!TextUtils.isEmpty(bVar.f254932h) && !rect.isEmpty()) {
                    arrayList.add(new OCRImageBean(rect, bVar.f254932h.trim(), bVar.f254926b));
                }
            }
        } else {
            for (int i26 = 0; i26 < this.f254880i.size(); i26++) {
                c cVar = this.f254880i.get(i26);
                if (!TextUtils.isEmpty(cVar.f254949i) && cVar.f254925a.size() > 0) {
                    Point point = cVar.f254925a.get(0);
                    int i27 = point.x;
                    int i28 = point.y;
                    Rect rect2 = new Rect(i27, i28, cVar.f254950j + i27, cVar.f254951k + i28);
                    if (!rect2.isEmpty()) {
                        arrayList.add(new OCRImageBean(rect2, cVar.f254949i.trim(), cVar.f254926b));
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (com.tencent.mobileqq.ocr.d.f254704a) {
            return G();
        }
        return F();
    }

    public boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.G;
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (A()) {
            this.C.a();
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (this.f254878f != null) {
            this.f254878f = null;
        }
    }

    public CharSequence R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (CharSequence) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (com.tencent.mobileqq.ocr.d.f254704a) {
            return T();
        }
        return S();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        bx bxVar = this.C;
        if (bxVar != null) {
            z16 = bxVar.dispatchHoverEvent(motionEvent);
        } else {
            z16 = false;
        }
        if (!z16 && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (I() && this.f254878f != null) {
            canvas.save();
            canvas.translate(0.0f, 0.0f);
            canvas.restore();
            if (com.tencent.mobileqq.ocr.d.f254704a) {
                K(canvas);
            } else {
                J(canvas);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (getDrawable() != null && ((BitmapDrawable) getDrawable()).getBitmap() != null) {
            Bitmap d16 = com.tencent.mobileqq.ocr.d.d(getDrawable());
            if (d16 == null) {
                super.setMeasuredDimension(i3, i16);
                return;
            } else {
                O(d16);
                return;
            }
        }
        super.setMeasuredDimension(i3, i16);
    }

    public boolean s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        if (this.f254878f == null) {
            this.f254878f = com.tencent.mobileqq.ocr.d.d(getDrawable());
        }
        if (this.f254878f.getHeight() * this.E <= i3) {
            return true;
        }
        return false;
    }

    public synchronized void setResultNormal(com.tencent.mobileqq.gallery.picocr.c cVar) {
        ArrayList<com.tencent.mobileqq.gallery.picocr.b> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar);
            return;
        }
        if (cVar != null && (arrayList = cVar.f211819f) != null && !arrayList.isEmpty()) {
            if (!(getDrawable() instanceof BitmapDrawable)) {
                return;
            }
            t();
            if (this.f254878f == null) {
                this.f254878f = com.tencent.mobileqq.ocr.d.d(getDrawable());
                float realWidth = ScreenUtil.getRealWidth(getContext()) / this.f254878f.getWidth();
                this.D = realWidth;
                this.E = realWidth;
            }
            this.F = this.f254878f.getWidth();
            ThreadManager.getSubThreadHandler().post(new Runnable(cVar) { // from class: com.tencent.mobileqq.ocr.view.OcrImageTextView.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.gallery.picocr.c f254882d;

                {
                    this.f254882d = cVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OcrImageTextView.this, (Object) cVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    OcrImageTextView ocrImageTextView = OcrImageTextView.this;
                    com.tencent.mobileqq.gallery.picocr.c D = ocrImageTextView.D(this.f254882d, ocrImageTextView.F);
                    Iterator<com.tencent.mobileqq.gallery.picocr.b> it = D.f211819f.iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.gallery.picocr.b next = it.next();
                        c cVar2 = new c(next);
                        cVar2.f254950j = next.f(OcrImageTextView.this.D);
                        cVar2.f254951k = next.e(OcrImageTextView.this.E);
                        Bitmap Q = OcrImageTextView.this.Q(next, cVar2.f254961u, cVar2.f254927c, D.f211814a, D.f211815b, D.f211816c);
                        if (Q != null) {
                            cVar2.f254948h = Q;
                            cVar2.b(OcrImageTextView.this.D, OcrImageTextView.this.E);
                            OcrImageTextView.this.B(cVar2);
                            OcrImageTextView.this.f254880i.add(cVar2);
                        }
                    }
                    ThreadManager.getUIHandler().postDelayed(OcrImageTextView.this.f254877e, 300L);
                }
            });
        }
    }

    public synchronized void setResultSection(TranslateResult translateResult) {
        List<TranslateResult.Record> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) translateResult);
            return;
        }
        if (translateResult != null && (list = translateResult.f254724h) != null && !list.isEmpty()) {
            com.tencent.mobileqq.gallery.picocr.c cVar = com.tencent.mobileqq.ocr.d.f254710g;
            if (cVar != null && !cVar.f211819f.isEmpty()) {
                if (!(getDrawable() instanceof BitmapDrawable)) {
                    return;
                }
                t();
                if (this.f254878f == null) {
                    this.f254878f = com.tencent.mobileqq.ocr.d.d(getDrawable());
                    float realWidth = ScreenUtil.getRealWidth(getContext()) / this.f254878f.getWidth();
                    this.D = realWidth;
                    this.E = realWidth;
                }
                this.F = this.f254878f.getWidth();
                ThreadManager.getSubThreadHandler().post(new Runnable(cVar, translateResult) { // from class: com.tencent.mobileqq.ocr.view.OcrImageTextView.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.gallery.picocr.c f254883d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ TranslateResult f254884e;

                    {
                        this.f254883d = cVar;
                        this.f254884e = translateResult;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, OcrImageTextView.this, cVar, translateResult);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        OcrImageTextView ocrImageTextView = OcrImageTextView.this;
                        List V = OcrImageTextView.this.V(ocrImageTextView.D(this.f254883d, ocrImageTextView.F).f211819f, this.f254884e);
                        if (V != null && !V.isEmpty()) {
                            OcrImageTextView.this.f254881m.addAll(V);
                        }
                        for (b bVar : OcrImageTextView.this.f254881m) {
                            Point h16 = bVar.h();
                            Rect g16 = bVar.g();
                            OcrImageTextView ocrImageTextView2 = OcrImageTextView.this;
                            Bitmap u16 = ocrImageTextView2.u(ocrImageTextView2.f254878f, h16, g16.width(), g16.height(), bVar.f254927c, OcrImageTextView.this.D, OcrImageTextView.this.E, "");
                            if (u16 != null) {
                                com.tencent.mobileqq.ocr.d.p(1, "", "", "ocr_crop_back_img", "");
                                bVar.f254947w = OcrImageTextView.this.N(u16);
                                bVar.e(OcrImageTextView.this.D, OcrImageTextView.this.E);
                                bVar.a(OcrImageTextView.this.f254876d);
                                OcrImageTextView.this.C(bVar);
                            }
                        }
                        ThreadManager.getUIHandler().postDelayed(OcrImageTextView.this.f254877e, 300L);
                    }
                });
            }
        }
    }

    public void setShowTextMask(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.G = z16;
            invalidate();
        }
    }

    public synchronized void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        ThreadManager.getUIHandler().removeCallbacks(this.f254877e);
        for (c cVar : this.f254880i) {
            if (cVar != null && cVar.f254948h != null) {
                cVar.f254948h = null;
            }
        }
        this.f254880i.clear();
        for (b bVar : this.f254881m) {
            if (bVar != null && bVar.f254947w != null) {
                bVar.f254947w = null;
            }
        }
        this.f254881m.clear();
        if (this.f254878f != null) {
            this.f254878f = null;
        }
    }

    public List<c> y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f254880i;
    }

    public List<b> z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f254881m;
    }

    public OcrImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public OcrImageTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f254880i = new CopyOnWriteArrayList();
        this.f254881m = new CopyOnWriteArrayList();
        this.G = false;
        this.f254877e = new Runnable() { // from class: com.tencent.mobileqq.ocr.view.OcrImageTextView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OcrImageTextView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                OcrImageTextView.this.setShowTextMask(true);
                OcrImageTextView.this.requestLayout();
                OcrImageTextView.this.invalidate();
                OcrImageTextView.this.A();
            }
        };
        Paint paint = new Paint();
        this.f254879h = paint;
        paint.setAntiAlias(true);
        this.f254879h.setColor(-38294);
        this.f254879h.setTextSize(30.0f);
        TextPaint textPaint = new TextPaint();
        this.f254876d = textPaint;
        textPaint.setAntiAlias(true);
        this.f254876d.setStyle(Paint.Style.FILL);
        this.f254876d.setColor(-38294);
        this.f254876d.setTextSize(30.0f);
    }
}

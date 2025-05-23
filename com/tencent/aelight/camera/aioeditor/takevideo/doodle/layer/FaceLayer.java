package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import ir.i;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import zr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FaceLayer extends tr.a {

    /* renamed from: d0, reason: collision with root package name */
    public static final String f67956d0 = "FaceLayer";
    public List<b> K;
    public b L;
    public Paint M;
    public TextPaint N;
    public Paint P;
    public Paint Q;
    public Paint R;
    public Paint S;
    public Paint T;
    public Paint U;
    public Drawable V;
    public zr.c W;
    public int X;
    public boolean Y;
    public c Z;

    /* renamed from: a0, reason: collision with root package name */
    public Map<String, List<String>> f67957a0;

    /* renamed from: b0, reason: collision with root package name */
    public List<b> f67958b0;

    /* renamed from: c0, reason: collision with root package name */
    public Map<String, List<String>> f67959c0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public final class a extends b {
        public final String M;
        public int N;
        public int O;
        public String P;
        public String Q;
        public StaticLayout R;
        public int S;
        public Path T;
        public int U;
        public boolean V;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0607a implements ValueAnimator.AnimatorUpdateListener {
            C0607a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.U = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FaceLayer.this.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class b extends com.tencent.mobileqq.widget.f {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                a.this.V = false;
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.V = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                a.this.V = true;
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.V = true;
            }
        }

        public a(Drawable drawable, d dVar, String str, String str2, String str3, int i3) {
            super(drawable, dVar, str, str2, str3, i3);
            this.M = MiniBoxNoticeInfo.APPNAME_SUFFIX;
            this.T = new Path();
            this.N = dVar.f67977j;
            this.O = dVar.f67976i;
            j(dVar.f67975h);
            this.E = true;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.b, zr.c.a
        public void a(Canvas canvas) {
            canvas.save();
            canvas.concat(FaceLayer.this.W.n(this));
            zr.a.d();
            canvas.translate((-this.f453051g) / 2.0f, (-this.f453052h) / 2.0f);
            if (this.R.getLineCount() == 1) {
                canvas.translate(0.0f, this.S);
            }
            this.f67963x.draw(canvas);
            canvas.translate(0.0f, this.f67964y.height());
            canvas.save();
            canvas.translate(6.0f, 16.0f);
            FaceLayer.this.N.setTextSize(this.N);
            FaceLayer.this.N.setColor(this.O);
            this.R.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.translate(0.0f, 10.0f);
            if (this.V) {
                FaceLayer.this.R.setAlpha(this.U);
                canvas.drawPath(this.T, FaceLayer.this.R);
            }
            canvas.restore();
            canvas.translate(0.0f, this.R.getHeight() + 32);
            FaceLayer.this.V.setBounds(0, 0, (int) this.f453051g, 6);
            FaceLayer.this.V.draw(canvas);
            canvas.restore();
            if (this.f453057m) {
                canvas.save();
                int i3 = this.f453059o == 0 ? R.drawable.eib : R.drawable.eia;
                if (!this.f453065u.isDataLocked()) {
                    i3 = this.f453059o == 0 ? R.drawable.eij : R.drawable.eih;
                }
                int i16 = i3;
                int i17 = this.f453059o;
                zr.a.b(canvas, FaceLayer.this.W, this, i16, i17 == 1 ? R.drawable.ei_ : R.drawable.ei9, i17 == 2 ? R.drawable.eig : R.drawable.eif);
                canvas.restore();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.b
        public void e(Canvas canvas, boolean z16) {
            canvas.save();
            canvas.translate((-this.f453051g) / 2.0f, (-this.f453052h) / 2.0f);
            if (this.R.getLineCount() == 1) {
                canvas.translate(0.0f, this.S);
            }
            this.f67963x.draw(canvas);
            canvas.translate(0.0f, this.f67964y.height());
            canvas.save();
            canvas.translate(6.0f, 16.0f);
            FaceLayer.this.N.setTextSize(this.N);
            FaceLayer.this.N.setColor(this.O);
            this.R.draw(canvas);
            canvas.restore();
            if (z16) {
                canvas.save();
                canvas.translate(0.0f, 10.0f);
                if (this.V) {
                    FaceLayer.this.R.setAlpha(this.U);
                    canvas.drawPath(this.T, FaceLayer.this.R);
                }
                canvas.restore();
            }
            canvas.translate(0.0f, this.R.getHeight() + 32);
            FaceLayer.this.V.setBounds(0, 0, (int) this.f453051g, 6);
            FaceLayer.this.V.draw(canvas);
            canvas.restore();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.b
        public void i(TroopBarPOI troopBarPOI) {
            this.G = troopBarPOI;
            if (troopBarPOI != null) {
                j(troopBarPOI.a());
                this.H = System.currentTimeMillis();
            } else {
                j(null);
                this.H = -1L;
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.b
        public void j(String str) {
            if (TextUtils.isEmpty(str)) {
                hd0.c.g(FaceLayer.f67956d0, "text is empty.");
                str = "";
            }
            String str2 = FaceLayer.f67956d0;
            hd0.c.a(str2, "text:" + str);
            this.Q = str;
            this.P = str;
            int i3 = (int) (this.f453051g - 12.0f);
            if (i3 < 0) {
                QLog.d(str2, 2, "faceItem setText width < 0");
                i3 = 0;
            }
            FaceLayer.this.N.setTextSize(this.N);
            StaticLayout staticLayout = new StaticLayout(this.Q, FaceLayer.this.N, i3, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            this.R = staticLayout;
            if (staticLayout.getLineCount() > 2) {
                String substring = this.Q.substring(0, this.R.getLineEnd(1));
                hd0.c.a(str2, "subString : " + this.Q + " -> " + substring);
                this.Q = substring;
                int length = substring.length() - 1;
                this.Q += MiniBoxNoticeInfo.APPNAME_SUFFIX;
                this.R = new StaticLayout(this.Q, FaceLayer.this.N, i3, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                while (length > 0 && this.R.getLineCount() > 2) {
                    String str3 = this.Q.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    length--;
                    hd0.c.a(FaceLayer.f67956d0, "delete last char : " + this.Q + " -> " + str3);
                    this.Q = str3;
                    this.R = new StaticLayout(this.Q, FaceLayer.this.N, i3, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                }
                if (length == 0) {
                    hd0.c.g(FaceLayer.f67956d0, "text size is too large :" + this.N);
                }
            }
            hd0.c.a(FaceLayer.f67956d0, "final text : " + this.Q + " , original text : " + this.P);
            Rect rect = new Rect();
            this.R.getLineBounds(0, rect);
            this.S = rect.height();
            this.T.reset();
            this.T.addRoundRect(new RectF(0.0f, 0.0f, this.f453051g, (float) (this.R.getHeight() + 12)), 4.0f, 4.0f, Path.Direction.CCW);
        }

        public void l() {
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
            ofInt.setDuration(1000L);
            ofInt.setRepeatCount(2);
            ofInt.setRepeatMode(2);
            ofInt.addUpdateListener(new C0607a());
            ofInt.addListener(new b());
            ofInt.start();
        }

        public a(FaceLayer faceLayer, Drawable drawable, d dVar, String str, String str2, String str3, int i3, int i16) {
            this(drawable, dVar, str, str2, str3, i3);
            this.D = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26);

        void b(int i3);

        boolean c(b bVar);
    }

    public FaceLayer(DoodleView doodleView) {
        super(doodleView);
        this.K = new CopyOnWriteArrayList();
        this.f67957a0 = new HashMap();
        this.f67958b0 = new ArrayList();
        this.f67959c0 = new HashMap();
        l();
    }

    private void L() {
        b bVar = this.L;
        if (bVar != null) {
            bVar.d();
        }
    }

    private void M() {
        this.f437143e.F(false, 0.0f, 0.0f, 0.0f, null, false, 1);
    }

    private void N() {
        b bVar;
        c cVar = this.Z;
        if (cVar == null || (bVar = this.L) == null || !cVar.c(bVar)) {
            return;
        }
        this.K.remove(this.L);
    }

    private boolean U(float f16, float f17) {
        for (int size = this.K.size() - 1; size >= 0; size--) {
            b bVar = this.K.get(size);
            if (this.W.s(bVar, f16, f17, false)) {
                this.L = bVar;
                return true;
            }
        }
        return false;
    }

    private void b0(b bVar, Map<String, List<String>> map) {
        List<String> list = map.get(bVar.f67965z);
        if (list == null) {
            list = new ArrayList<>();
            map.put(bVar.f67965z, list);
        }
        list.add(bVar.A);
    }

    private void h0(b bVar, Map<String, List<String>> map) {
        List<String> list = map.get(bVar.f67965z);
        if (list != null) {
            list.remove(bVar.A);
            if (list.isEmpty()) {
                map.remove(bVar.f67965z);
            }
        }
    }

    private void l() {
        this.M = new Paint();
        this.V = this.f437142d.getResources().getDrawable(R.drawable.fgz);
        TextPaint textPaint = new TextPaint();
        this.N = textPaint;
        textPaint.setAntiAlias(true);
        this.N.setTextAlign(Paint.Align.LEFT);
        this.N.setStyle(Paint.Style.FILL);
        this.N.setTypeface(Typeface.DEFAULT);
        Paint paint = new Paint();
        this.P = paint;
        paint.setAntiAlias(true);
        this.P.setStyle(Paint.Style.STROKE);
        this.P.setColor(SupportMenu.CATEGORY_MASK);
        this.P.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.Q = paint2;
        paint2.setAntiAlias(true);
        this.Q.setStyle(Paint.Style.STROKE);
        this.Q.setColor(-16711936);
        this.Q.setStrokeWidth(2.0f);
        this.f437146i.setStrokeWidth(2.0f);
        Paint paint3 = new Paint();
        this.R = paint3;
        paint3.setStrokeWidth(1.0f);
        this.R.setColor(-1);
        this.R.setStyle(Paint.Style.STROKE);
        this.R.setPathEffect(new DashPathEffect(new float[]{8.0f, 6.0f}, 0.0f));
        zr.c cVar = new zr.c();
        this.W = cVar;
        cVar.A(true);
        this.W.y(18.0f);
        this.W.z(0.2f);
        Paint paint4 = new Paint();
        this.S = paint4;
        paint4.setAntiAlias(true);
        this.S.setStyle(Paint.Style.STROKE);
        this.S.setColor(-1);
        this.S.setStrokeWidth(2.0f);
        Paint paint5 = new Paint();
        this.U = paint5;
        paint5.setAntiAlias(true);
        this.U.setColor(-1);
        this.U.setStyle(Paint.Style.FILL);
        Paint paint6 = new Paint();
        this.T = paint6;
        paint6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.T.setStyle(Paint.Style.FILL);
    }

    @Override // tr.a
    public void A(int i3, int i16) {
        super.A(i3, i16);
        List<b> list = this.K;
        if (list != null && list.size() > 0) {
            for (b bVar : this.K) {
                float f16 = bVar.f453051g;
                float f17 = bVar.f453046b;
                int i17 = (int) (f16 * f17);
                int i18 = (int) (bVar.f453052h * f17);
                PointF pointF = bVar.f453045a;
                float f18 = pointF.x;
                Rect rect = this.f437145h;
                pointF.x = Z(f18, i17, rect.left, rect.right);
                PointF pointF2 = bVar.f453045a;
                float f19 = pointF2.y;
                Rect rect2 = this.f437145h;
                pointF2.y = Z(f19, i18, rect2.top, rect2.bottom);
            }
            return;
        }
        hd0.c.a(f67956d0, "mFaceItems = null or size<=0");
    }

    public boolean K(String str, String str2, Drawable drawable, d dVar, String str3, boolean z16, String str4, int i3, String str5, int i16, int i17) {
        b bVar;
        if (drawable == null) {
            hd0.c.g(f67956d0, "Face drawable is null.");
            return false;
        }
        if (dVar == null) {
            hd0.c.g(f67956d0, "ItemParams is null.");
            return false;
        }
        if (a0()) {
            hd0.c.g(f67956d0, "has max face count. add face failed.");
            c cVar = this.Z;
            if (cVar != null) {
                cVar.b(40);
            }
            return false;
        }
        if (i3 == 1 || i3 == 3) {
            drawable.setCallback(this.f437143e);
        }
        String str6 = f67956d0;
        hd0.c.d(str6, "addFace before, category : %s , name : %s , LayerParams : %s", str, str2, dVar);
        d a16 = d.a(dVar);
        float f16 = a16.f67973f;
        float f17 = a16.f67969b;
        int i18 = (int) (f16 * f17);
        int i19 = (int) (a16.f67974g * f17);
        if (this.f437145h.height() < i19) {
            a16.f67969b *= this.f437145h.height() / i19;
            i19 = this.f437145h.height();
        }
        PointF pointF = a16.f67968a;
        float f18 = pointF.x;
        float f19 = pointF.y;
        Rect rect = this.f437145h;
        pointF.x = Z(f18, i18, rect.left, rect.right);
        PointF pointF2 = a16.f67968a;
        Rect rect2 = this.f437145h;
        pointF2.y = Z(f19, i19, rect2.top, rect2.bottom);
        hd0.c.a(str6, "addFace after drawRect:" + this.f437145h);
        hd0.c.d(str6, "addFace after, category : %s , name : %s , LayerParams : %s", str, str2, dVar);
        int i26 = -1;
        if (TextUtils.isEmpty(a16.f67975h)) {
            hd0.c.a(str6, "Create Normal FaceItem.");
            b bVar2 = new b(this, drawable, a16, str, str2, str3, i3, i17);
            bVar2.I = str5;
            bVar2.h(z16);
            if (!TextUtils.isEmpty(str4)) {
                bVar2.G = new TroopBarPOI("-1", "", str4, 0, "", 0, "");
                bVar2.H = System.currentTimeMillis();
            }
            if (drawable instanceof i) {
                i26 = ((i) drawable).i();
                bVar2.g(hr.c.d(i26));
                bVar = bVar2;
            } else {
                bVar = bVar2;
                if (!TextUtils.isEmpty(str5)) {
                    try {
                        i26 = Integer.valueOf(str5.substring(str5.indexOf(":") + 1, str5.indexOf(","))).intValue();
                    } catch (Exception unused) {
                    }
                    bVar2.g(hr.c.d(i26));
                    bVar = bVar2;
                }
            }
        } else {
            hd0.c.a(str6, "Create FaceAndTextItem with text:" + a16.f67975h);
            a aVar = new a(drawable, a16, str, str2, str3, i3);
            aVar.l();
            bVar = aVar;
        }
        if ((drawable instanceof ir.g) || 12 == i26) {
            bVar.f453047c = 90.0f;
        }
        bVar.J = i16;
        bVar.f453050f.set(this.J);
        this.K.add(bVar);
        super.n();
        if (bVar.E) {
            this.f67958b0.add(bVar);
        } else {
            b0(bVar, this.f67957a0);
        }
        b0(bVar, this.f67959c0);
        return true;
    }

    public void O(b bVar) {
        Drawable drawable = bVar.f67963x;
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap bitmap = ((BitmapDrawable) bVar.f67963x).getBitmap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[width * 2];
        for (int i3 = 0; i3 < width; i3++) {
            int i16 = 0;
            while (true) {
                if (i16 >= height) {
                    break;
                }
                if (((iArr[(i16 * width) + i3] >> 24) & 255) > 0) {
                    iArr2[i3 * 2] = i16;
                    break;
                }
                i16++;
            }
            int i17 = height - 1;
            while (true) {
                if (i17 < 0) {
                    break;
                }
                if (((iArr[(i17 * width) + i3] >> 24) & 255) > 0) {
                    iArr2[(i3 * 2) + 1] = i17;
                    break;
                }
                i17--;
            }
        }
        float f16 = bVar.f453051g;
        int i18 = (int) f16;
        bVar.f453060p = new int[i18 * 2];
        float f17 = width / f16;
        float f18 = bVar.f453052h / height;
        for (int i19 = 0; i19 < i18; i19++) {
            int[] iArr3 = bVar.f453060p;
            int i26 = i19 * 2;
            iArr3[i26] = (int) (iArr2[r10] * f18);
            int i27 = (((int) (i19 * f17)) * 2) + 1;
            iArr3[i26 + 1] = (int) (iArr2[i27] * f18);
            if (iArr2[i27] > 0) {
                if (bVar.f453061q == -1) {
                    bVar.f453061q = i19;
                }
                bVar.f453062r = Math.max(i19, bVar.f453062r);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(f67956d0, 2, "computePixelScope cost: ", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        }
    }

    public c.a P(c.a aVar, String str, String str2, Drawable drawable, d dVar, String str3, int i3, boolean z16, String str4, String str5, int i16) {
        b aVar2;
        int i17;
        if (drawable == null) {
            hd0.c.g(f67956d0, "Face drawable is null.");
            return null;
        }
        if (dVar == null) {
            hd0.c.g(f67956d0, "ItemParams is null.");
            return null;
        }
        d b16 = d.b(aVar, dVar);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.E) {
                this.f67958b0.remove(bVar);
            } else {
                h0(bVar, this.f67957a0);
            }
            h0(bVar, this.f67959c0);
        }
        if (TextUtils.isEmpty(dVar.f67975h)) {
            hd0.c.a(f67956d0, "Create Normal FaceItem.");
            aVar2 = new b(this, drawable, b16, str, str2, str3, i3, i16);
            aVar2.h(z16);
            if (drawable instanceof i) {
                aVar2.g(hr.c.d(((i) drawable).i()));
            }
            if (!TextUtils.isEmpty(str5)) {
                try {
                    i17 = Integer.valueOf(str5.substring(str5.indexOf(":") + 1, str5.indexOf(","))).intValue();
                } catch (Exception unused) {
                    i17 = -1;
                }
                aVar2.g(hr.c.d(i17));
            }
            if (!TextUtils.isEmpty(str4)) {
                aVar2.G = new TroopBarPOI("-1", "", str4, 0, "", 0, "");
                aVar2.H = System.currentTimeMillis();
            }
        } else {
            hd0.c.a(f67956d0, "Create FaceAndTextItem with text:" + b16.f67975h);
            aVar2 = new a(this, drawable, b16, str, str2, str3, i3, i16);
        }
        aVar2.E = z16;
        if (!TextUtils.isEmpty(str5)) {
            aVar2.I = str5;
        }
        if (aVar2.E) {
            this.f67958b0.add(aVar2);
        } else {
            h0(aVar2, this.f67957a0);
        }
        h0(aVar2, this.f67959c0);
        return aVar2;
    }

    public Rect V(Rect rect) {
        rect.setEmpty();
        b bVar = this.L;
        if (bVar != null) {
            int i3 = (int) (bVar.f453051g * bVar.f453046b);
            rect.set(0, 0, i3, i3);
        }
        return rect;
    }

    public int W() {
        List<b> list = this.K;
        int size = list == null ? 0 : list.size();
        hd0.c.a(f67956d0, "FaceLayer, DoodleCount:" + size);
        return size;
    }

    public Map<String, List<String>> Y() {
        return this.f67959c0;
    }

    @Override // tr.d
    public boolean a(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        for (int size = this.K.size() - 1; size >= 0; size--) {
            if (this.W.s(this.K.get(size), x16, y16, false)) {
                if (QLog.isColorLevel()) {
                    QLog.d(f67956d0, 2, "accept inside x:" + motionEvent.getX() + " y:" + motionEvent.getY());
                }
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f67956d0, 2, "accept outside x:" + motionEvent.getX() + " y:" + motionEvent.getY());
        }
        return false;
    }

    protected boolean a0() {
        return W() >= 40;
    }

    @Override // tr.d
    public void b(Canvas canvas) {
        w(canvas, this.H, false);
    }

    @Override // tr.d
    public void clear() {
        this.K.clear();
        this.L = null;
        this.W.w();
        hd0.c.a(f67956d0, "clear over.");
    }

    public void d0() {
        List<b> list = this.K;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.K.clear();
        this.f67958b0.clear();
        this.f67957a0.clear();
        this.f67959c0.clear();
    }

    public void e0() {
        List<b> list = this.K;
        if (list == null || list.isEmpty()) {
            return;
        }
        f0(this.K.get(r0.size() - 1));
    }

    public void f0(b bVar) {
        List<b> list = this.K;
        if (list == null || list.isEmpty() || !this.K.remove(bVar)) {
            return;
        }
        if (bVar.E) {
            DoodleLayout.P1("delete_poi");
            id0.b.i("0X80076D2");
            id0.b.f("0X80075E7");
            this.f67958b0.remove(bVar);
        } else {
            DoodleLayout.P1("delete_oneface");
            id0.b.i("0X80076CB");
            id0.b.f("0X80075E0");
            h0(bVar, this.f67957a0);
        }
        h0(bVar, this.f67959c0);
    }

    public void g0(String str, String str2) {
        List<b> list = this.K;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (b bVar : this.K) {
            if (T(bVar.f67965z, str) && T(bVar.A, str2)) {
                f0(bVar);
                return;
            }
        }
    }

    @Override // tr.a
    public String h() {
        return f67956d0;
    }

    @Override // tr.d
    public boolean isEmpty() {
        List<b> list = this.K;
        return list == null || list.isEmpty();
    }

    public void k0(c cVar) {
        this.Z = cVar;
    }

    @Override // tr.a
    public boolean m(long j3) {
        Iterator<b> it = this.K.iterator();
        while (it.hasNext()) {
            if (it.next().f453065u.isSegmentChanged(j3)) {
                return false;
            }
        }
        return true;
    }

    @Override // tr.a
    protected void p(Canvas canvas) {
        Iterator<b> it = this.K.iterator();
        while (it.hasNext()) {
            S(it.next(), canvas);
        }
    }

    @Override // tr.a
    public boolean q(MotionEvent motionEvent) {
        int y16 = (int) motionEvent.getY();
        int abs = Math.abs(y16 - this.X);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.X = y16;
            this.Y = false;
            Q(motionEvent);
            b bVar = this.L;
            if (bVar != null) {
                this.W.x(bVar);
            }
            b bVar2 = this.L;
            if (bVar2 != null) {
                bVar2.k();
            }
        } else if (action == 1) {
            L();
            if (!this.Y) {
                N();
            }
            R(motionEvent);
        } else if (action != 2) {
            if (action == 5) {
                L();
            }
        } else if (abs > 5) {
            this.Y = true;
            L();
        }
        this.W.e(motionEvent, false);
        b bVar3 = this.L;
        if (bVar3 != null) {
            c0(bVar3);
        } else {
            M();
        }
        return true;
    }

    @Override // tr.a
    public void w(Canvas canvas, float f16, boolean z16) {
        canvas.save();
        canvas.scale(f16, f16);
        for (b bVar : this.K) {
            if (bVar.K == 0) {
                canvas.save();
                canvas.concat(this.W.o(bVar, false));
                bVar.e(canvas, false);
                canvas.restore();
            }
        }
        canvas.restore();
    }

    @Override // tr.a
    public void x(Matrix matrix) {
        super.x(matrix);
        Iterator<b> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().f453050f.set(matrix);
        }
    }

    private void Q(MotionEvent motionEvent) {
        if (U(motionEvent.getX(0), motionEvent.getY(0))) {
            this.K.remove(this.L);
            this.K.add(this.L);
        }
    }

    private void R(MotionEvent motionEvent) {
        this.L = null;
        this.W.w();
        super.n();
        super.t(false);
    }

    public int[] X() {
        int[] iArr = {0, 0};
        Iterator<b> it = this.K.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof a) {
                iArr[1] = iArr[1] + 1;
            } else {
                iArr[0] = iArr[0] + 1;
            }
        }
        return iArr;
    }

    public void i0(final ArrayList<PasterParcelData> arrayList, boolean z16, JSONArray jSONArray) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
            /* JADX WARN: Type inference failed for: r0v41, types: [com.tencent.image.URLDrawable, android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r15v4, types: [com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer$b] */
            /* JADX WARN: Type inference failed for: r9v4, types: [android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r9v5 */
            /* JADX WARN: Type inference failed for: r9v7 */
            /* JADX WARN: Type inference failed for: r9v8 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Throwable th5;
                BufferedInputStream bufferedInputStream;
                ?? r95;
                String str;
                int i3;
                a aVar;
                String str2 = "createFromPath error";
                int i16 = 0;
                int i17 = 0;
                while (i17 < arrayList.size()) {
                    PasterParcelData pasterParcelData = (PasterParcelData) arrayList.get(i17);
                    if (!TextUtils.isEmpty(pasterParcelData.H)) {
                        BufferedInputStream bufferedInputStream2 = null;
                        if (pasterParcelData.J == 1) {
                            int[] iArr = new int[1];
                            iArr[i16] = 13;
                            ?? apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), pasterParcelData.H, "-Dynamic-", com.tencent.mobileqq.urldrawable.b.f306350a, iArr, "-Dynamic-", null);
                            if (apngDrawable != 0) {
                                if (apngDrawable.getStatus() != 1) {
                                    apngDrawable.restartDownload();
                                }
                                apngDrawable.setCallback(((tr.a) FaceLayer.this).f437143e);
                                bufferedInputStream2 = apngDrawable;
                            }
                        } else {
                            try {
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(pasterParcelData.H));
                            } catch (IOException e16) {
                                e = e16;
                                bufferedInputStream = null;
                            } catch (OutOfMemoryError e17) {
                                e = e17;
                                bufferedInputStream = null;
                            } catch (Throwable th6) {
                                th5 = th6;
                            }
                            try {
                                try {
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, BitmapFactory.decodeStream(bufferedInputStream, null, null));
                                    try {
                                        bufferedInputStream.close();
                                        r95 = bitmapDrawable;
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                        r95 = bitmapDrawable;
                                    }
                                } catch (IOException e19) {
                                    e = e19;
                                    hd0.c.h(FaceLayer.f67956d0, str2, e);
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e26) {
                                            e26.printStackTrace();
                                        }
                                    }
                                    r95 = bufferedInputStream2;
                                    if (r95 != 0) {
                                    }
                                    str = str2;
                                    i3 = i16;
                                    i17++;
                                    i16 = i3;
                                    str2 = str;
                                } catch (OutOfMemoryError e27) {
                                    e = e27;
                                    hd0.c.h(FaceLayer.f67956d0, str2, e);
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e28) {
                                            e28.printStackTrace();
                                        }
                                    }
                                    r95 = bufferedInputStream2;
                                    if (r95 != 0) {
                                    }
                                    str = str2;
                                    i3 = i16;
                                    i17++;
                                    i16 = i3;
                                    str2 = str;
                                }
                                if (r95 != 0) {
                                    RectF rectF = pasterParcelData.E;
                                    r95.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                                    if (TextUtils.isEmpty(pasterParcelData.P)) {
                                        hd0.c.a(FaceLayer.f67956d0, "Create Normal FaceItem.");
                                        PointF pointF = pasterParcelData.f66833e;
                                        str = str2;
                                        i3 = i16;
                                        aVar = new b(r95, new d(pointF.x, pointF.y, pasterParcelData.f66834f, pasterParcelData.f66835h, pasterParcelData.f66836i, pasterParcelData.f66837m, (int) pasterParcelData.C, (int) pasterParcelData.D), pasterParcelData.F, pasterParcelData.G, pasterParcelData.H, pasterParcelData.J);
                                    } else {
                                        hd0.c.a(FaceLayer.f67956d0, "Create FaceAndTextItem with text:" + pasterParcelData.P);
                                        PointF pointF2 = pasterParcelData.f66833e;
                                        str = str2;
                                        a aVar2 = new a(r95, new d(pointF2.x, pointF2.y, pasterParcelData.f66834f, pasterParcelData.f66835h, pasterParcelData.f66836i, pasterParcelData.f66837m, (int) pasterParcelData.C, (int) pasterParcelData.D, pasterParcelData.P, pasterParcelData.N, pasterParcelData.M), pasterParcelData.F, pasterParcelData.G, pasterParcelData.H, pasterParcelData.J);
                                        aVar2.l();
                                        i3 = 0;
                                        aVar = aVar2;
                                    }
                                    aVar.C = i3;
                                    aVar.D = 1;
                                    aVar.f453050f.set(((tr.a) FaceLayer.this).J);
                                    FaceLayer.this.K.add(aVar);
                                    i17++;
                                    i16 = i3;
                                    str2 = str;
                                }
                            } catch (Throwable th7) {
                                th5 = th7;
                                bufferedInputStream2 = bufferedInputStream;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e29) {
                                        e29.printStackTrace();
                                    }
                                    throw th5;
                                }
                                throw th5;
                            }
                        }
                        r95 = bufferedInputStream2;
                        if (r95 != 0) {
                        }
                    }
                    str = str2;
                    i3 = i16;
                    i17++;
                    i16 = i3;
                    str2 = str;
                }
                ((tr.a) FaceLayer.this).f437143e.postInvalidate();
            }
        }, 8, null, false);
    }

    public void j0(b bVar, TroopBarPOI troopBarPOI) {
        if (bVar != null) {
            bVar.i(troopBarPOI);
            bVar.f67963x.setCallback(this.f437143e.K.f68172u0);
            n();
        }
    }

    private void S(b bVar, Canvas canvas) {
        if (bVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(this.W.n(bVar));
        bVar.e(canvas, true);
        canvas.restore();
    }

    @Override // tr.a
    public void u(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        super.u(bundle);
        i0(bundle.getParcelableArrayList("StickerParcelDataList"), bundle.getBoolean("edit_type_photo"), null);
    }

    private int Z(float f16, int i3, int i16, int i17) {
        int i18 = (int) f16;
        if (i17 == 0) {
            return i18;
        }
        int i19 = i3 / 2;
        float f17 = i19;
        if (f16 - f17 < i16) {
            f16 = i16 + i19;
        }
        if (f17 + f16 > i17) {
            f16 = i17 - i19;
        }
        return (int) f16;
    }

    public static boolean T(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null) {
            return str.equals(str2);
        }
        return false;
    }

    private void c0(b bVar) {
        if (bVar == null) {
            hd0.c.t(f67956d0, "refreshLimitRegion currItem==null return");
            return;
        }
        boolean q16 = this.W.q(bVar, StoryGuideLineView.E, true);
        boolean q17 = this.W.q(bVar, StoryGuideLineView.F, false);
        boolean r16 = this.W.r(bVar, StoryGuideLineView.H, false);
        c cVar = this.Z;
        if (cVar != null) {
            cVar.a(q16, q17, false, r16, bVar.f453063s);
        }
        if (bVar.f453057m) {
            this.f437143e.F(bVar.f453063s, bVar.f453047c, bVar.f453048d, bVar.f453049e, bVar.f453045a, bVar.f453064t, 2);
        } else {
            this.f437143e.F(bVar.f453063s, bVar.f453047c, bVar.f453048d, bVar.f453049e, bVar.f453045a, bVar.f453064t, 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final PointF f67968a;

        /* renamed from: b, reason: collision with root package name */
        public float f67969b;

        /* renamed from: c, reason: collision with root package name */
        public final float f67970c;

        /* renamed from: d, reason: collision with root package name */
        public final float f67971d;

        /* renamed from: e, reason: collision with root package name */
        public final float f67972e;

        /* renamed from: f, reason: collision with root package name */
        public final int f67973f;

        /* renamed from: g, reason: collision with root package name */
        public final int f67974g;

        /* renamed from: h, reason: collision with root package name */
        public final String f67975h;

        /* renamed from: i, reason: collision with root package name */
        public final int f67976i;

        /* renamed from: j, reason: collision with root package name */
        public final int f67977j;

        public d(float f16, float f17, float f18, float f19, float f26, float f27, int i3, int i16) {
            this.f67968a = new PointF(f16, f17);
            this.f67969b = f18;
            this.f67970c = f19;
            this.f67971d = f26;
            this.f67972e = f27;
            this.f67973f = i3;
            this.f67974g = i16;
            this.f67975h = "";
            this.f67976i = -1;
            this.f67977j = 0;
        }

        public static d a(d dVar) {
            PointF pointF = dVar.f67968a;
            return new d(pointF.x, pointF.y, dVar.f67969b, dVar.f67970c, dVar.f67971d, dVar.f67972e, dVar.f67973f, dVar.f67974g, dVar.f67975h, dVar.f67976i, dVar.f67977j);
        }

        public static d b(c.a aVar, d dVar) {
            PointF pointF = aVar.f453045a;
            return new d(pointF.x, pointF.y, dVar.f67969b, aVar.f453047c, aVar.f453048d, aVar.f453049e, dVar.f67973f, dVar.f67974g, dVar.f67975h, dVar.f67976i, dVar.f67977j);
        }

        public String toString() {
            return "LayerParams{centerP=" + this.f67968a + ", scale=" + this.f67969b + ", rotate=" + this.f67970c + ", translateXValue=" + this.f67971d + ", translateYValue=" + this.f67972e + ", width=" + this.f67973f + ", height=" + this.f67974g + ", text='" + this.f67975h + "', textColor=" + this.f67976i + ", textSize=" + this.f67977j + '}';
        }

        public d(float f16, float f17, float f18, float f19, float f26, float f27, int i3, int i16, String str, int i17, int i18) {
            this.f67968a = new PointF(f16, f17);
            this.f67969b = f18;
            this.f67970c = f19;
            this.f67971d = f26;
            this.f67972e = f27;
            this.f67973f = i3;
            this.f67974g = i16;
            this.f67975h = str;
            this.f67976i = i17;
            this.f67977j = i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends c.a {
        public final String A;
        public final String B;
        public int C;
        public int D;
        public boolean E;
        public boolean F;
        public TroopBarPOI G;
        public long H;
        public String I;
        public int J;
        public int K;

        /* renamed from: x, reason: collision with root package name */
        public Drawable f67963x;

        /* renamed from: y, reason: collision with root package name */
        public RectF f67964y;

        /* renamed from: z, reason: collision with root package name */
        public final String f67965z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.f453055k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FaceLayer.this.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer$b$b, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0608b extends AnimatorListenerAdapter {
            C0608b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                hd0.c.a(FaceLayer.f67956d0, "scaleAnimator cancel!");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                hd0.c.a(FaceLayer.f67956d0, "scaleAnimator end!");
                b bVar = b.this;
                bVar.f453055k = 1.0f;
                bVar.f453054j = false;
                FaceLayer.this.n();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                hd0.c.a(FaceLayer.f67956d0, "scaleAnimator start!");
                b.this.f453054j = true;
            }
        }

        public b(Drawable drawable, d dVar, String str, String str2, String str3, int i3) {
            super(dVar.f67968a, dVar.f67969b, dVar.f67970c, dVar.f67971d, dVar.f67972e, dVar.f67973f, dVar.f67974g, true);
            this.C = 1;
            this.D = 0;
            this.H = -1L;
            this.f67963x = drawable;
            this.f67965z = str;
            this.A = str2;
            this.B = str3;
            this.f67964y = new RectF(drawable.getBounds());
            this.E = false;
            this.K = i3;
        }

        private void f(Canvas canvas) {
            int i3;
            int i16;
            canvas.save();
            int i17 = this.f453059o == 0 ? R.drawable.eib : R.drawable.eia;
            if (!this.f453065u.isDataLocked()) {
                i17 = this.f453059o == 0 ? R.drawable.eij : R.drawable.eih;
            }
            int i18 = this.f453059o;
            int i19 = i18 == 1 ? R.drawable.ei_ : R.drawable.ei9;
            int i26 = i18 == 2 ? R.drawable.eig : R.drawable.eif;
            if (this.f453066v) {
                i17 = -1;
            }
            if (((tr.a) FaceLayer.this).f437143e.K.c1()) {
                i3 = -1;
                i16 = -1;
            } else {
                i3 = i17;
                i16 = i26;
            }
            zr.a.b(canvas, FaceLayer.this.W, this, i3, i19, i16);
            canvas.restore();
        }

        @Override // zr.c.a
        public void a(Canvas canvas) {
            if (this.f453065u.isInSegment(((tr.a) FaceLayer.this).f437143e.u()) || this.f453057m) {
                canvas.save();
                canvas.concat(FaceLayer.this.W.n(this));
                canvas.translate((-this.f453051g) / 2.0f, (-this.f453052h) / 2.0f);
                this.f67963x.draw(canvas);
                canvas.restore();
                if (this.f453057m) {
                    f(canvas);
                }
            }
        }

        public void d() {
            ValueAnimator valueAnimator = this.f453056l;
            if (valueAnimator == null || !this.f453054j) {
                return;
            }
            valueAnimator.cancel();
        }

        public void e(Canvas canvas, boolean z16) {
            if (this.f453065u.isInSegment(((tr.a) FaceLayer.this).f437143e.u()) || this.f453057m) {
                canvas.save();
                canvas.translate((-this.f453051g) / 2.0f, (-this.f453052h) / 2.0f);
                this.f67963x.draw(canvas);
                canvas.restore();
            }
        }

        public void g(boolean z16) {
            this.F = z16;
        }

        public void h(boolean z16) {
            this.E = z16;
        }

        public void i(TroopBarPOI troopBarPOI) {
            this.G = troopBarPOI;
            if (troopBarPOI != null) {
                j(troopBarPOI.a());
                this.H = System.currentTimeMillis();
            } else {
                j(null);
                this.H = -1L;
            }
        }

        public void j(String str) {
            Drawable drawable = this.f67963x;
            if (drawable != null) {
                if (drawable instanceof i) {
                    i f16 = hr.c.f((i) drawable, FaceLayer.this.f437142d, str);
                    this.f67963x = f16;
                    if (f16 != null) {
                        this.I = f16.g();
                    }
                } else if (drawable instanceof BitmapDrawable) {
                    this.f67963x = hr.c.g(this.I, FaceLayer.this.f437142d, str);
                }
                Drawable drawable2 = this.f67963x;
                if (drawable2 == null) {
                    return;
                }
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f67963x.getIntrinsicHeight());
                float intrinsicWidth = (this.f453045a.x - ((this.f453046b * this.f67963x.getIntrinsicWidth()) / 2.0f)) + this.f453048d;
                if (intrinsicWidth < ScreenUtil.dip2px(23.0f)) {
                    PointF pointF = this.f453045a;
                    pointF.x = (pointF.x - intrinsicWidth) + ScreenUtil.dip2px(23.0f);
                }
                this.f67963x.setCallback(((tr.a) FaceLayer.this).f437143e);
                this.f67964y = new RectF(this.f67963x.getBounds());
                this.f453051g = this.f67963x.getIntrinsicWidth();
                this.f453052h = this.f67963x.getIntrinsicHeight();
                ((PasterDataManager) fr.f.c(4)).C(str);
            }
        }

        public void k() {
            if (this.f453056l == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.85f, 1.0f);
                this.f453056l = ofFloat;
                ofFloat.setDuration(200L);
                this.f453056l.setInterpolator(new LinearInterpolator());
                this.f453056l.addUpdateListener(new a());
                this.f453056l.addListener(new C0608b());
            }
            if (this.f453054j) {
                return;
            }
            this.f453056l.start();
        }

        public b(FaceLayer faceLayer, Drawable drawable, d dVar, String str, String str2, String str3, int i3, int i16) {
            this(drawable, dVar, str, str2, str3, i3);
            this.D = i16;
        }
    }

    public boolean J(String str, String str2, Drawable drawable, d dVar, String str3, boolean z16, int i3, int i16, SegmentKeeper segmentKeeper) {
        b bVar;
        if (drawable == null) {
            hd0.c.g(f67956d0, "Face drawable is null.");
            return false;
        }
        if (dVar == null) {
            hd0.c.g(f67956d0, "ItemParams is null.");
            return false;
        }
        if (a0()) {
            hd0.c.g(f67956d0, "has max face count. add face failed.");
            c cVar = this.Z;
            if (cVar != null) {
                cVar.b(40);
            }
            return false;
        }
        if (i3 == 1 || i3 == 3) {
            drawable.setCallback(this.f437143e);
        }
        String str4 = f67956d0;
        hd0.c.d(str4, "addFace before, category : %s , name : %s , LayerParams : %s", str, str2, dVar);
        d a16 = d.a(dVar);
        float f16 = a16.f67973f;
        float f17 = a16.f67969b;
        int i17 = (int) (f16 * f17);
        int i18 = (int) (a16.f67974g * f17);
        if (this.f437145h.height() < i18) {
            a16.f67969b *= this.f437145h.height() / i18;
            i18 = this.f437145h.height();
        }
        PointF pointF = a16.f67968a;
        float f18 = pointF.x;
        float f19 = pointF.y;
        Rect rect = this.f437145h;
        pointF.x = Z(f18, i17, rect.left, rect.right);
        PointF pointF2 = a16.f67968a;
        Rect rect2 = this.f437145h;
        pointF2.y = Z(f19, i18, rect2.top, rect2.bottom);
        hd0.c.a(str4, "addFace after drawRect:" + this.f437145h);
        hd0.c.d(str4, "addFace after, category : %s , name : %s , LayerParams : %s", str, str2, dVar);
        if (TextUtils.isEmpty(a16.f67975h)) {
            hd0.c.a(str4, "Create Normal FaceItem.");
            b bVar2 = new b(this, drawable, a16, str, str2, str3, i3, i16);
            bVar2.h(z16);
            bVar = bVar2;
            if (drawable instanceof i) {
                bVar2.g(hr.c.d(((i) drawable).i()));
                bVar = bVar2;
            }
        } else {
            hd0.c.a(str4, "Create FaceAndTextItem with text:" + a16.f67975h);
            a aVar = new a(this, drawable, a16, str, str2, str3, i3, i16);
            aVar.l();
            bVar = aVar;
        }
        bVar.f453065u = new SegmentKeeper(segmentKeeper);
        O(bVar);
        bVar.f453050f.set(this.J);
        this.K.add(bVar);
        super.n();
        if (bVar.E) {
            this.f67958b0.add(bVar);
        } else {
            b0(bVar, this.f67957a0);
        }
        b0(bVar, this.f67959c0);
        return true;
    }
}

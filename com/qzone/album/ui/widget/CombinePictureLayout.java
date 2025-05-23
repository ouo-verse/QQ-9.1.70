package com.qzone.album.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes39.dex */
public class CombinePictureLayout extends RelativeLayout {
    protected AsyncImageView C;
    protected AsyncImageView D;
    protected AsyncImageView E;
    protected Paint F;
    protected Paint G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected int M;
    protected int N;
    private boolean P;

    /* renamed from: d, reason: collision with root package name */
    protected AsyncImageView f44167d;

    /* renamed from: e, reason: collision with root package name */
    protected AsyncImageView f44168e;

    /* renamed from: f, reason: collision with root package name */
    protected AsyncImageView f44169f;

    /* renamed from: h, reason: collision with root package name */
    protected AsyncImageView f44170h;

    /* renamed from: i, reason: collision with root package name */
    protected AsyncImageView f44171i;

    /* renamed from: m, reason: collision with root package name */
    protected AsyncImageView f44172m;

    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f44173a;

        /* renamed from: b, reason: collision with root package name */
        b f44174b;

        /* renamed from: c, reason: collision with root package name */
        b f44175c;

        public a(String str, b bVar, b bVar2) {
            this.f44173a = str;
            this.f44174b = bVar;
            this.f44175c = bVar2;
        }
    }

    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f44176a;

        /* renamed from: b, reason: collision with root package name */
        int f44177b;

        public b(int i3, int i16) {
            this.f44176a = i3;
            this.f44177b = i16;
        }
    }

    public CombinePictureLayout(Context context) {
        super(context);
        i(context);
    }

    private void d(Canvas canvas) {
        if (this.L > 0) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.L);
            float f16 = height;
            path.lineTo(0.0f, f16);
            path.lineTo(this.L, f16);
            int i3 = this.L;
            path.arcTo(new RectF(0.0f, height - (i3 * 2), i3 * 2, f16), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.F);
        }
    }

    private void e(Canvas canvas) {
        if (this.M > 0) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f16 = height;
            path.moveTo(width - this.M, f16);
            float f17 = width;
            path.lineTo(f17, f16);
            path.lineTo(f17, height - this.M);
            int i3 = this.M;
            path.arcTo(new RectF(width - (i3 * 2), height - (i3 * 2), f17, f16), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.F);
        }
    }

    private void f(Canvas canvas) {
        if (this.J > 0) {
            Path path = new Path();
            path.moveTo(0.0f, this.J);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.J, 0.0f);
            int i3 = this.J;
            path.arcTo(new RectF(0.0f, 0.0f, i3 * 2, i3 * 2), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.F);
        }
    }

    private void g(Canvas canvas) {
        if (this.K > 0) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.K, 0.0f);
            float f16 = width;
            path.lineTo(f16, 0.0f);
            path.lineTo(f16, this.K);
            int i3 = this.K;
            path.arcTo(new RectF(width - (i3 * 2), 0.0f, f16, i3 * 2), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.F);
        }
    }

    private void k(ArrayList<a> arrayList, HashMap<AsyncImageView, a> hashMap) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j(next)) {
                if (hashMap.containsValue(next)) {
                    com.qzone.proxy.feedcomponent.b.e("CombinePictureLayout", "the layoutInfo is already checked.");
                } else {
                    b bVar = next.f44175c;
                    int i3 = bVar.f44176a;
                    b bVar2 = next.f44174b;
                    int i16 = bVar2.f44176a;
                    int i17 = i3 - i16;
                    int i18 = bVar.f44177b;
                    int i19 = bVar2.f44177b;
                    int i26 = i18 - i19;
                    if (i19 == 0 && i16 != 0 && i3 != this.H) {
                        a(this.f44168e, i17, i26, this.N, 0);
                        this.f44168e.setAsyncImage(next.f44173a);
                        hashMap.put(this.f44168e, next);
                    }
                    b bVar3 = next.f44175c;
                    if (bVar3.f44177b == this.I) {
                        b bVar4 = next.f44174b;
                        if (bVar4.f44176a != 0 && bVar4.f44177b != 0 && bVar3.f44176a != this.H) {
                            hashMap.put(this.D, next);
                        }
                    }
                    b bVar5 = next.f44174b;
                    if (bVar5.f44176a == 0 && bVar5.f44177b != 0 && next.f44175c.f44177b != this.I) {
                        a(this.f44170h, i17, i26, 0, this.N);
                        this.f44170h.setAsyncImage(next.f44173a);
                        hashMap.put(this.f44170h, next);
                    }
                    b bVar6 = next.f44175c;
                    if (bVar6.f44176a == this.H) {
                        b bVar7 = next.f44174b;
                        if (bVar7.f44177b != 0 && bVar7.f44176a != 0 && bVar6.f44177b != this.I) {
                            hashMap.put(this.f44172m, next);
                        }
                    }
                    b bVar8 = next.f44174b;
                    if (bVar8.f44176a != 0 && bVar8.f44177b != 0) {
                        b bVar9 = next.f44175c;
                        if (bVar9.f44176a != this.H && bVar9.f44177b != this.I) {
                            hashMap.put(this.f44171i, next);
                        }
                    }
                }
            } else {
                com.qzone.proxy.feedcomponent.b.e("CombinePictureLayout", "the layoutInfo is invalid.");
            }
        }
    }

    private void l(ArrayList<a> arrayList, HashMap<AsyncImageView, a> hashMap) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j(next)) {
                b bVar = next.f44175c;
                int i3 = bVar.f44176a;
                b bVar2 = next.f44174b;
                int i16 = i3 - bVar2.f44176a;
                int i17 = bVar.f44177b - bVar2.f44177b;
                com.qzone.proxy.feedcomponent.b.e("CombinePictureLayout", "the url is " + next.f44173a);
                b bVar3 = next.f44174b;
                if (bVar3.f44176a == 0 && bVar3.f44177b == 0 && !hashMap.containsValue(next)) {
                    a(this.f44167d, i16, i17, 0, 0);
                    this.f44167d.setAsyncImage(next.f44173a);
                    hashMap.put(this.f44167d, next);
                }
                b bVar4 = next.f44174b;
                if (bVar4.f44177b == 0 && next.f44175c.f44176a == this.H && bVar4.f44176a != 0 && !hashMap.containsValue(next)) {
                    a(this.f44169f, i16, i17, this.N, 0);
                    this.f44169f.setAsyncImage(next.f44173a);
                    hashMap.put(this.f44169f, next);
                }
                b bVar5 = next.f44174b;
                if (bVar5.f44176a == 0 && next.f44175c.f44177b == this.I && bVar5.f44177b != 0 && !hashMap.containsValue(next)) {
                    a(this.C, i16, i17, 0, this.N);
                    this.C.setAsyncImage(next.f44173a);
                    hashMap.put(this.C, next);
                }
                b bVar6 = next.f44175c;
                if (bVar6.f44176a == this.H && bVar6.f44177b == this.I) {
                    b bVar7 = next.f44174b;
                    if (bVar7.f44176a != 0 && bVar7.f44177b != 0 && !hashMap.containsValue(next)) {
                        AsyncImageView asyncImageView = this.E;
                        int i18 = this.N;
                        a(asyncImageView, i16, i17, i18, i18);
                        this.E.setAsyncImage(next.f44173a);
                        hashMap.put(this.E, next);
                    }
                }
            } else {
                com.qzone.proxy.feedcomponent.b.e("CombinePictureLayout", "the layoutInfo is invalid.");
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.G, 31);
        super.dispatchDraw(canvas);
        f(canvas);
        g(canvas);
        d(canvas);
        e(canvas);
        canvas.restore();
    }

    public CombinePictureLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
    }

    private void c(HashMap<AsyncImageView, a> hashMap, AsyncImageView asyncImageView) {
        AsyncImageView asyncImageView2;
        AsyncImageView asyncImageView3;
        if (hashMap == null || hashMap.size() == 0 || asyncImageView == null) {
            return;
        }
        a aVar = hashMap.get(asyncImageView);
        if (!j(aVar)) {
            com.qzone.proxy.feedcomponent.b.e("CombinePictureLayout", "the layoutInfo is invalid.");
            return;
        }
        int i3 = 0;
        int i16 = 0;
        for (Map.Entry<AsyncImageView, a> entry : hashMap.entrySet()) {
            if (entry != null) {
                AsyncImageView key = entry.getKey();
                a value = entry.getValue();
                if (key != null && value != null) {
                    b bVar = value.f44175c;
                    int i17 = bVar.f44176a;
                    b bVar2 = value.f44174b;
                    int i18 = bVar2.f44176a;
                    int i19 = i17 - i18;
                    int i26 = bVar.f44177b;
                    int i27 = bVar2.f44177b;
                    int i28 = i26 - i27;
                    b bVar3 = aVar.f44174b;
                    if (bVar3.f44177b == i27 && bVar3.f44176a == i18 + i19 + this.N) {
                        i3 = key.getId();
                    }
                    b bVar4 = aVar.f44174b;
                    int i29 = bVar4.f44176a;
                    b bVar5 = value.f44174b;
                    if (i29 == bVar5.f44176a && bVar4.f44177b == bVar5.f44177b + i28 + this.N) {
                        i16 = key.getId();
                    }
                } else {
                    com.qzone.proxy.feedcomponent.b.e("CombinePictureLayout", "asyncImageView or layoutInfo is null.");
                }
            }
        }
        if (i3 == 0 && (asyncImageView3 = this.f44167d) != null) {
            i3 = asyncImageView3.getId();
        }
        if (i16 == 0 && (asyncImageView2 = this.f44167d) != null) {
            i16 = asyncImageView2.getId();
        }
        int i36 = (this.D == null || asyncImageView.getId() != this.D.getId()) ? i16 : 0;
        int i37 = (this.f44172m == null || asyncImageView.getId() != this.f44172m.getId()) ? i3 : 0;
        b bVar6 = aVar.f44175c;
        int i38 = bVar6.f44176a;
        b bVar7 = aVar.f44174b;
        b(asyncImageView, i38 - bVar7.f44176a, bVar6.f44177b - bVar7.f44177b, i37, i36);
        asyncImageView.setAsyncImage(aVar.f44173a);
    }

    private boolean j(a aVar) {
        return (aVar == null || aVar.f44174b == null || aVar.f44175c == null) ? false : true;
    }

    protected void a(AsyncImageView asyncImageView, int i3, int i16, int i17, int i18) {
        RelativeLayout.LayoutParams layoutParams;
        if (asyncImageView == null || (layoutParams = (RelativeLayout.LayoutParams) asyncImageView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMargins(i17, i18, 0, 0);
        layoutParams.width = i3;
        layoutParams.height = i16;
        asyncImageView.setLayoutParams(layoutParams);
        asyncImageView.setBackgroundColor(getResources().getColor(R.color.f156606d));
        asyncImageView.setVisibility(0);
    }

    protected void b(AsyncImageView asyncImageView, int i3, int i16, int i17, int i18) {
        RelativeLayout.LayoutParams layoutParams;
        if (asyncImageView == null || (layoutParams = (RelativeLayout.LayoutParams) asyncImageView.getLayoutParams()) == null) {
            return;
        }
        if (i17 != 0) {
            layoutParams.addRule(1, i17);
        }
        if (i18 != 0) {
            layoutParams.addRule(3, i18);
        }
        int i19 = this.N;
        if (i19 != 0) {
            layoutParams.setMargins(i19, i19, 0, 0);
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        asyncImageView.setLayoutParams(layoutParams);
        asyncImageView.setVisibility(0);
    }

    private void h() {
        setBackgroundResource(R.drawable.azk);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.H;
            layoutParams.height = this.I;
            setLayoutParams(layoutParams);
            this.P = true;
        }
    }

    private void i(Context context) {
        try {
            View.inflate(context, R.layout.bjf, this);
            this.f44167d = (AsyncImageView) findViewById(R.id.b2j);
            this.f44168e = (AsyncImageView) findViewById(R.id.b2k);
            this.f44169f = (AsyncImageView) findViewById(R.id.b2l);
            this.f44170h = (AsyncImageView) findViewById(R.id.b2m);
            this.f44171i = (AsyncImageView) findViewById(R.id.b2n);
            this.f44172m = (AsyncImageView) findViewById(R.id.b2o);
            this.C = (AsyncImageView) findViewById(R.id.b2p);
            this.D = (AsyncImageView) findViewById(R.id.b2q);
            this.E = (AsyncImageView) findViewById(R.id.b2r);
            Paint paint = new Paint();
            this.F = paint;
            paint.setColor(-1);
            this.F.setAntiAlias(true);
            this.F.setStyle(Paint.Style.FILL);
            this.F.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Paint paint2 = new Paint();
            this.G = paint2;
            paint2.setXfermode(null);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d("CombinePictureLayout", "initView() catch an exception.", e16);
        }
    }

    public CombinePictureLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        i(context);
    }

    public void setImageView(ArrayList<a> arrayList, int i3, int i16, int i17, int[] iArr) {
        if (arrayList == null || iArr == null || iArr.length != 4 || this.f44167d == null || this.f44168e == null || this.f44169f == null || this.f44170h == null || this.f44171i == null || this.f44172m == null || this.C == null || this.D == null || this.E == null) {
            return;
        }
        if (!this.P) {
            this.J = iArr[0];
            this.K = iArr[1];
            this.L = iArr[2];
            this.M = iArr[3];
            this.H = i3;
            this.I = i16;
            this.N = i17;
            h();
        }
        HashMap<AsyncImageView, a> hashMap = new HashMap<>(arrayList.size());
        l(arrayList, hashMap);
        k(arrayList, hashMap);
        if (hashMap.containsKey(this.D)) {
            c(hashMap, this.D);
        }
        if (hashMap.containsKey(this.f44172m)) {
            c(hashMap, this.f44172m);
        }
        if (hashMap.containsKey(this.f44171i)) {
            c(hashMap, this.f44171i);
        }
        hashMap.clear();
    }
}

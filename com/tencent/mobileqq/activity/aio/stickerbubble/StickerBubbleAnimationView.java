package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w61.a;
import w61.c;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StickerBubbleAnimationView extends View implements View.OnAttachStateChangeListener, a.InterfaceC11464a {
    private Map<String, BitmapDrawable[]> C;
    private Map<String, Integer> D;
    private Map<String, List<com.tencent.mobileqq.activity.aio.stickerbubble.a>> E;
    private boolean F;
    private String G;
    private int H;
    private long I;
    private boolean J;
    private Set<String> K;
    private boolean L;
    private long M;
    private List<Long> N;
    private int P;
    private a Q;

    /* renamed from: d, reason: collision with root package name */
    private Paint f179855d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f179856e;

    /* renamed from: f, reason: collision with root package name */
    private Typeface f179857f;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, List<w61.a>> f179858h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, List<w61.a>> f179859i;

    /* renamed from: m, reason: collision with root package name */
    private FrameManager f179860m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void e();

        void h(int i3, int i16);
    }

    public StickerBubbleAnimationView(Context context) {
        super(context);
        this.f179858h = new HashMap();
        this.f179859i = new HashMap();
        this.C = new HashMap();
        this.D = new HashMap();
        this.E = new HashMap();
        this.F = true;
        this.G = "";
        this.H = 0;
        this.K = new HashSet();
        this.N = new ArrayList(70);
        l();
    }

    private float e(long j3) {
        double d16;
        if (this.I == 0) {
            return 0.0f;
        }
        double d17 = (((j3 - r0) % 400) / 400.0d) * 20.0d;
        if (d17 < 10.0d) {
            d16 = d17 - 5.0d;
        } else {
            d16 = (10.0d - (d17 - 10.0d)) - 5.0d;
        }
        return (float) d16;
    }

    private void f() {
        boolean z16;
        boolean z17;
        if (this.f179858h.isEmpty() && this.f179859i.isEmpty()) {
            return;
        }
        Iterator<String> it = this.f179858h.keySet().iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                if (!this.f179858h.get(it.next()).isEmpty()) {
                    z17 = false;
                    break;
                }
            } else {
                z17 = true;
                break;
            }
        }
        Iterator<String> it5 = this.f179859i.keySet().iterator();
        while (true) {
            if (it5.hasNext()) {
                if (!this.f179859i.get(it5.next()).isEmpty()) {
                    break;
                }
            } else {
                z16 = z17;
                break;
            }
        }
        if (z16 && !this.J && !this.L) {
            this.J = true;
            a aVar = this.Q;
            if (aVar != null) {
                aVar.h(this.K.size(), this.H);
            }
            this.G = "";
            this.K.clear();
        }
    }

    private void g(com.tencent.mobileqq.activity.aio.stickerbubble.a aVar, long j3) {
        Map<String, List<w61.a>> map;
        if (aVar.f179864c) {
            map = this.f179859i;
        } else {
            map = this.f179858h;
        }
        List<w61.a> list = map.get(aVar.f179863b);
        if (list == null) {
            list = new LinkedList<>();
            map.put(aVar.f179863b, list);
        }
        list.add(k(aVar, j3));
    }

    private void h(Set<String> set, long j3, Canvas canvas) {
        Iterator<String> it;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            Iterator<String> it5 = set.iterator();
            int i3 = 0;
            while (it5.hasNext()) {
                String next = it5.next();
                if (this.C.containsKey(next)) {
                    BitmapDrawable[] bitmapDrawableArr = this.C.get(next);
                    int intValue = this.D.get(next).intValue();
                    List<w61.a> list = this.f179858h.get(next);
                    if (list != null) {
                        for (w61.a aVar : list) {
                            aVar.c(canvas, j3, j(j3, aVar.f(), bitmapDrawableArr, intValue));
                            it5 = it5;
                        }
                        it = it5;
                        i3 += list.size();
                    } else {
                        it = it5;
                    }
                    List<w61.a> list2 = this.f179859i.get(next);
                    if (list2 != null) {
                        for (Iterator<w61.a> it6 = list2.iterator(); it6.hasNext(); it6 = it6) {
                            w61.a next2 = it6.next();
                            next2.c(canvas, j3, j(j3, next2.f(), bitmapDrawableArr, intValue));
                        }
                        i3 += list2.size();
                    }
                } else {
                    it = it5;
                }
                it5 = it;
            }
            if (this.F) {
                i(canvas, j3);
            }
            QQUIAppSetting.isDebugVersion();
            if (QLog.isColorLevel()) {
                if (this.M % 60 != 0) {
                    QQUIAppSetting.isDebugVersion();
                    return;
                }
                QLog.d("StickerBubble_AnimationView_Cost", 2, "draw " + i3 + " items, take time " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        } catch (Exception e16) {
            QLog.e("StickerBubble_AnimationView", 1, "throw exception in doDraw: ", e16);
            if (QQUIAppSetting.isDebugVersion()) {
                throw new RuntimeException(e16);
            }
        }
    }

    private void i(Canvas canvas, long j3) {
        int n3;
        int i3 = this.H;
        if (i3 <= 1) {
            return;
        }
        if (i3 < 10) {
            n3 = Utils.n((i3 * 2.5f) + 50.0f, getResources());
        } else if (i3 < 100) {
            n3 = Utils.n(((i3 - 10) * 0.2777778f) + 75.0f, getResources());
        } else {
            n3 = Utils.n(100.0f, getResources());
        }
        float f16 = n3;
        String num = Integer.toString(i3);
        this.f179855d.setTextSize(f16);
        this.f179856e.setTextSize(f16);
        float measureText = this.f179855d.measureText(num);
        int width = (int) ((canvas.getWidth() - measureText) / 2.0f);
        int height = (int) ((canvas.getHeight() / 8) - this.f179855d.getFontMetrics().ascent);
        int save = canvas.save();
        if (!this.L) {
            canvas.rotate(e(j3), width + (measureText / 2.0f), height + (this.f179855d.getFontMetrics().ascent / 2.0f));
        }
        float f17 = width;
        float f18 = height;
        canvas.drawText(num, f17, f18, this.f179856e);
        canvas.drawText(num, f17, f18, this.f179855d);
        canvas.restoreToCount(save);
        if (this.I == 0) {
            this.I = j3;
        }
    }

    private BitmapDrawable j(long j3, long j16, BitmapDrawable[] bitmapDrawableArr, int i3) {
        for (int length = (int) (((j3 - j16) / i3) % bitmapDrawableArr.length); length >= 0; length--) {
            BitmapDrawable bitmapDrawable = bitmapDrawableArr[length];
            if (bitmapDrawable != null) {
                return bitmapDrawable;
            }
        }
        return bitmapDrawableArr[0];
    }

    private w61.a k(com.tencent.mobileqq.activity.aio.stickerbubble.a aVar, long j3) {
        float intrinsicWidth = ((aVar.f179868g / this.C.get(aVar.f179863b)[0].getIntrinsicWidth()) / 3.0f) * getContext().getResources().getDisplayMetrics().density;
        if (aVar.f179864c) {
            intrinsicWidth *= 1.7f;
        }
        w61.a aVar2 = new w61.a(this.C.get(aVar.f179863b)[0], aVar.f179862a, new c.b(aVar.f179865d), new c.a(aVar.f179866e), j3, intrinsicWidth, aVar.f179864c, aVar.f179863b, aVar.f179867f);
        aVar2.i(this);
        return aVar2;
    }

    private void l() {
        this.f179860m = new FrameManager(getContext(), this.C, this.D);
        this.P = getContext().getResources().getDisplayMetrics().widthPixels;
        setBackgroundColor(0);
        Paint paint = new Paint();
        this.f179855d = paint;
        paint.setColor(Color.parseColor("#FFDC4F"));
        this.f179855d.setAntiAlias(true);
        Paint paint2 = new Paint(this.f179855d);
        this.f179856e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f179856e.setColor(Color.parseColor("#418DFF"));
        this.f179856e.setStrokeWidth(30.0f);
        Typeface typeface = this.f179857f;
        if (typeface != null) {
            this.f179855d.setTypeface(typeface);
            this.f179856e.setTypeface(this.f179857f);
        }
        setFocusable(false);
        setClickable(false);
        addOnAttachStateChangeListener(this);
    }

    @Override // w61.a.InterfaceC11464a
    public void a(final w61.a aVar) {
        post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                List list;
                List list2 = (List) StickerBubbleAnimationView.this.f179858h.get(aVar.e());
                if ((list2 == null || !list2.remove(aVar)) && (list = (List) StickerBubbleAnimationView.this.f179859i.get(aVar.e())) != null) {
                    list.remove(aVar);
                }
            }
        });
    }

    public void d(com.tencent.mobileqq.activity.aio.stickerbubble.a aVar) {
        if (!this.G.equals(aVar.f179863b)) {
            this.H = 0;
            String str = aVar.f179863b;
            this.G = str;
            this.K.add(str);
        }
        this.J = false;
        this.H++;
        List<com.tencent.mobileqq.activity.aio.stickerbubble.a> list = this.E.get(aVar.f179863b);
        if (list == null) {
            list = new LinkedList<>();
            this.E.put(aVar.f179863b, list);
        }
        list.add(aVar);
    }

    public void m() {
        this.G = "";
    }

    public void n() {
        this.L = true;
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubble_AnimationView", 2, "pauseAnim");
        }
    }

    public void o() {
        this.L = false;
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubble_AnimationView", 2, "resumeAnim");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas.getWidth() < this.P / 2) {
            return;
        }
        SystemClock.uptimeMillis();
        this.M++;
        Set<String> keySet = this.E.keySet();
        this.f179860m.g(keySet);
        long uptimeMillis = SystemClock.uptimeMillis();
        for (String str : keySet) {
            if (this.C.containsKey(str)) {
                List<com.tencent.mobileqq.activity.aio.stickerbubble.a> list = this.E.get(str);
                if (list == null) {
                    return;
                }
                Iterator<com.tencent.mobileqq.activity.aio.stickerbubble.a> it = list.iterator();
                while (it.hasNext()) {
                    g(it.next(), uptimeMillis);
                }
                list.clear();
            }
        }
        h(keySet, uptimeMillis, canvas);
        f();
        QQUIAppSetting.isDebugVersion();
        invalidate();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubble_AnimationView", 2, "onViewAttachedToWindow");
        }
        com.tencent.mobileqq.activity.aio.stickerbubble.frame.b.b();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubble_AnimationView", 2, "onViewDetachedFromWindow");
        }
        this.f179858h.clear();
        this.f179859i.clear();
        this.E.clear();
        this.f179860m.h();
        a aVar = this.Q;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void setAnimationCallback(a aVar) {
        this.Q = aVar;
    }

    public void setShowText(boolean z16) {
        this.F = z16;
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != null) {
            this.f179857f = typeface;
            this.f179855d.setTypeface(typeface);
            this.f179856e.setTypeface(this.f179857f);
        }
    }
}

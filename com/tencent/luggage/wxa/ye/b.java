package com.tencent.luggage.wxa.ye;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends com.tencent.luggage.wxa.we.a implements com.tencent.luggage.wxa.gh.g, com.tencent.luggage.wxa.hp.a {
    public static HashMap M = new HashMap();
    public String C;
    public float D;
    public float E;
    public long F;
    public View.OnClickListener G;
    public int H;
    public int I;
    public GradientDrawable J;
    public float[] K;
    public a L;

    /* renamed from: b, reason: collision with root package name */
    public float f145555b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f145556c;

    /* renamed from: d, reason: collision with root package name */
    public float f145557d;

    /* renamed from: e, reason: collision with root package name */
    public int f145558e;

    /* renamed from: f, reason: collision with root package name */
    public int f145559f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f145560g;

    /* renamed from: h, reason: collision with root package name */
    public View f145561h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f145562i;

    /* renamed from: j, reason: collision with root package name */
    public String f145563j;

    /* renamed from: k, reason: collision with root package name */
    public int f145564k;

    /* renamed from: l, reason: collision with root package name */
    public int f145565l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f145566m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2);
    }

    public b(Context context) {
        this(context, null, 0);
        b();
    }

    private Drawable getShadowDrawable() {
        int i3;
        int i16 = this.f145559f;
        if (i16 != 0) {
            this.J.setColor(i16);
        }
        float[] fArr = this.K;
        float[] fArr2 = this.f145556c;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[0];
        float f16 = fArr2[1];
        fArr[2] = f16;
        fArr[3] = f16;
        float f17 = fArr2[3];
        fArr[4] = f17;
        fArr[5] = f17;
        float f18 = fArr2[2];
        fArr[6] = f18;
        fArr[7] = f18;
        this.J.setCornerRadii(fArr);
        float f19 = this.f145557d;
        if (f19 > 0.0f && (i3 = this.f145558e) != 0) {
            this.J.setStroke((int) f19, i3);
        }
        return this.J;
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        if (getWidth() != 0 && getHeight() != 0) {
            canvas.save();
            canvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
            draw(canvas);
            canvas.restore();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > getChildCount() - 1) {
            i3 = getChildCount() - 1;
        }
        super.addView(view, i3 + 1);
    }

    public void b() {
        this.f145560g.setStyle(Paint.Style.STROKE);
        this.f145560g.setAntiAlias(true);
        setWillNotDraw(false);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.H == 0) {
            this.H = windowManager.getDefaultDisplay().getWidth();
            this.I = windowManager.getDefaultDisplay().getHeight();
        }
    }

    public boolean c() {
        return this.f145562i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean contains = a(this).contains(motionEvent.getRawX(), motionEvent.getRawY());
        if (motionEvent.getActionMasked() == 0 && !a(motionEvent.getX(), motionEvent.getY()) && !contains) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z16;
        float[] fArr = this.f145556c;
        if (fArr != null && fArr.length > 0) {
            super.draw(canvas);
            return;
        }
        float f16 = 0.0f;
        boolean z17 = true;
        if (this.f145555b > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            canvas.save();
            Path path = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            float f17 = this.f145555b;
            path.addRoundRect(rectF, f17, f17, Path.Direction.CW);
            canvas.clipPath(path);
        }
        int i3 = this.f145559f;
        if (i3 != 0) {
            canvas.drawColor(i3);
        }
        float f18 = this.f145557d;
        if (f18 > 0.0f) {
            float f19 = f18 / 2.0f;
            RectF rectF2 = new RectF(f19, f19, getWidth() - f19, getHeight() - f19);
            float f26 = this.f145555b;
            canvas.drawRoundRect(rectF2, f26, f26, this.f145560g);
            if (z16) {
                canvas.restore();
            }
            canvas.save();
            Path path2 = new Path();
            float f27 = this.f145555b;
            if (f27 > 0.0f) {
                float f28 = f27 - this.f145557d;
                if (f28 > 0.0f) {
                    f16 = f28;
                }
            }
            float f29 = this.f145557d;
            path2.addRoundRect(new RectF(f29, f29, getWidth() - this.f145557d, getHeight() - this.f145557d), f16, f16, Path.Direction.CW);
            canvas.clipPath(path2);
        } else {
            z17 = z16;
        }
        super.draw(canvas);
        if (z17) {
            canvas.restore();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        View.OnClickListener onClickListener;
        w.a("MicroMsg.CoverViewContainer", "event: " + motionEvent.getAction());
        if (this.f145562i) {
            bVar = this;
        } else {
            int i3 = this.f145565l;
            if (i3 > 0) {
                bVar = (b) M.get(Integer.valueOf(i3));
            } else {
                bVar = null;
            }
        }
        if (!this.f145562i && (!this.f145566m || !a(bVar, this))) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX() - this.D;
                    float rawY = motionEvent.getRawY() - this.E;
                    if (bVar != null && (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f)) {
                        int x16 = (int) (bVar.getX() + rawX);
                        int y16 = (int) (bVar.getY() + rawY);
                        if (x16 < 0) {
                            x16 = 0;
                        } else {
                            int width = bVar.getWidth() + x16;
                            int i16 = this.H;
                            if (width > i16) {
                                x16 = i16 - bVar.getWidth();
                            }
                        }
                        bVar.setX(x16);
                        if (y16 < 0) {
                            y16 = 0;
                        } else {
                            int height = bVar.getHeight() + y16;
                            int i17 = this.I;
                            if (height > i17) {
                                y16 = i17 - bVar.getHeight();
                            }
                        }
                        bVar.setY(y16);
                        this.D = motionEvent.getRawX();
                        this.E = motionEvent.getRawY();
                        a(HippyPagerPageChangeListener.DRAGGING, bVar, motionEvent);
                    }
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = this.F;
                long j16 = currentTimeMillis - j3;
                if (j3 != 0 && j16 < 300 && j16 >= 0 && (onClickListener = this.G) != null) {
                    onClickListener.onClick(this);
                }
                if (bVar != null) {
                    a("end", bVar, motionEvent);
                }
            }
        } else {
            this.D = motionEvent.getRawX();
            this.E = motionEvent.getRawY();
            this.F = System.currentTimeMillis();
            if (bVar != null) {
                a("start", bVar, motionEvent);
            }
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBgColor(int i3) {
        this.f145559f = i3;
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderColor(int i3) {
        this.f145558e = i3;
        this.f145560g.setColor(i3);
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderRadius(float f16) {
        this.f145555b = f16;
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderWidth(float f16) {
        this.f145557d = f16;
        this.f145560g.setStrokeWidth(f16);
    }

    public void setDragConfig(String str) {
        this.C = str;
    }

    public void setDragEventCallback(a aVar) {
        this.L = aVar;
    }

    public void setIsInterceptEvent(boolean z16) {
        this.f145566m = z16;
    }

    public void setOnCustomerClickListener(View.OnClickListener onClickListener) {
        this.G = onClickListener;
    }

    public void setTargetView(View view) {
        this.f145561h = view;
        super.addView(view, 0, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderRadius(float[] fArr) {
        this.f145556c = fArr;
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        setBackground(getShadowDrawable());
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(c.a(context), attributeSet, i3);
        this.f145560g = new Paint();
        this.f145562i = false;
        this.f145563j = "";
        this.f145566m = false;
        this.H = 0;
        this.I = 0;
        this.J = new GradientDrawable();
        this.K = new float[8];
        b();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > getChildCount() - 1) {
            i3 = getChildCount() - 1;
        }
        super.addView(view, i3 + 1, layoutParams);
    }

    public Object a(Class cls) {
        try {
            if (cls.isAssignableFrom(this.f145561h.getClass())) {
                return this.f145561h;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a(float f16, float f17) {
        float f18 = this.f145555b;
        if (f18 <= 0.0f) {
            return true;
        }
        double pow = Math.pow(f18, 2.0d);
        float width = getWidth();
        float height = getHeight();
        float f19 = this.f145555b;
        if (f16 < f19) {
            if (f17 < f19) {
                if (Math.pow(f19 - f16, 2.0d) + Math.pow(this.f145555b - f17, 2.0d) > pow) {
                    return false;
                }
            } else if (f17 > height - f19 && Math.pow(f19 - f16, 2.0d) + Math.pow((f17 + this.f145555b) - height, 2.0d) > pow) {
                return false;
            }
        } else if (f16 > width - f19) {
            if (f17 < f19) {
                if (Math.pow((f16 + f19) - width, 2.0d) + Math.pow(this.f145555b - f17, 2.0d) > pow) {
                    return false;
                }
            } else if (f17 > height - f19 && Math.pow((f16 + f19) - width, 2.0d) + Math.pow((f17 + this.f145555b) - height, 2.0d) > pow) {
                return false;
            }
        }
        return true;
    }

    public void b(int i3, int i16) {
        this.f145564k = i3;
        this.f145565l = i16;
    }

    public b(Context context, View view) {
        this(context);
        setTargetView(view);
        b();
    }

    public static RectF a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    public void a(boolean z16, int i3, String str) {
        this.f145562i = z16;
        this.f145564k = i3;
        if (z16) {
            this.f145563j = str;
            M.put(Integer.valueOf(i3), this);
        } else {
            M.remove(Integer.valueOf(i3));
        }
    }

    public void a(boolean z16, int i3) {
        a(z16, i3, this.f145563j);
    }

    public void a(int i3) {
        M.remove(Integer.valueOf(i3));
    }

    public final boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (viewGroup == viewGroup2) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt == viewGroup2) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && a((ViewGroup) childAt, viewGroup2)) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, b bVar, MotionEvent motionEvent) {
        a aVar = this.L;
        if (aVar != null) {
            aVar.a(str, bVar.f145563j, a(bVar, bVar.f145564k), a(motionEvent));
        }
    }

    public final JSONObject a(View view, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", i3);
            jSONObject.put("left", com.tencent.luggage.wxa.tk.g.b(view.getX()));
            jSONObject.put("top", com.tencent.luggage.wxa.tk.g.b(view.getY()));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject a(MotionEvent motionEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", this.f145564k);
            jSONObject.put(HippyTKDListViewAdapter.X, com.tencent.luggage.wxa.tk.g.b(motionEvent.getRawX()));
            jSONObject.put("y", com.tencent.luggage.wxa.tk.g.b(motionEvent.getRawY()));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}

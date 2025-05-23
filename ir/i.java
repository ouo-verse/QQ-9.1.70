package ir;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class i extends Drawable {

    /* renamed from: h, reason: collision with root package name */
    public static final int f408322h = c(1.0f, BaseApplication.getContext().getResources());

    /* renamed from: c, reason: collision with root package name */
    protected Context f408325c;

    /* renamed from: d, reason: collision with root package name */
    protected String f408326d;

    /* renamed from: f, reason: collision with root package name */
    protected ValueAnimator f408328f;

    /* renamed from: a, reason: collision with root package name */
    protected ir.a f408323a = new ir.a();

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Integer> f408324b = null;

    /* renamed from: e, reason: collision with root package name */
    protected int f408327e = 0;

    /* renamed from: g, reason: collision with root package name */
    protected Bitmap f408329g = null;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ArrayList<Integer> arrayList = (ArrayList) valueAnimator.getAnimatedValue();
            i iVar = i.this;
            iVar.f408324b = arrayList;
            iVar.invalidateSelf();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface c {
    }

    public i(Context context, String str) {
        this.f408325c = null;
        this.f408326d = null;
        this.f408325c = BaseApplication.getContext();
        this.f408326d = str;
    }

    static /* bridge */ /* synthetic */ c a(i iVar) {
        iVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        ir.a aVar = this.f408323a;
        ValueAnimator ofObject = ValueAnimator.ofObject(aVar, aVar.e(), this.f408323a.d());
        this.f408328f = ofObject;
        ofObject.setInterpolator(new DecelerateInterpolator());
        this.f408328f.addUpdateListener(new a());
        this.f408328f.addListener(new b());
        this.f408328f.setDuration(this.f408323a.c());
        this.f408328f.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap d() {
        if (this.f408329g == null) {
            this.f408329g = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            new Canvas(this.f408329g).drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return this.f408329g;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ArrayList<Integer> arrayList = this.f408324b;
        if (arrayList != null) {
            j(canvas, arrayList);
        }
    }

    public Bitmap f(long j3) {
        Bitmap d16 = d();
        Canvas canvas = new Canvas(d16);
        ArrayList<Integer> f16 = this.f408323a.f(j3);
        if (f16 != null) {
            j(canvas, f16);
        }
        return d16;
    }

    public String g() {
        return this.f408326d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public Bitmap h() {
        return f(this.f408323a.c());
    }

    public int i() {
        return this.f408327e;
    }

    protected abstract void j(Canvas canvas, ArrayList<Integer> arrayList);

    public abstract String[] k(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(ArrayList<Integer> arrayList, int i3, int i16) {
        Integer num;
        return (arrayList == null || arrayList.size() <= i3 || (num = arrayList.get(i3)) == null) ? i16 : num.intValue();
    }

    public static final int c(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.a(i.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}

package com.qzone.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.util.ar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.zipanimate.OnAnimationListener;

/* compiled from: P */
/* loaded from: classes37.dex */
public class MultiAnimationLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private Drawable[] f60422d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView[] f60423e;

    /* renamed from: f, reason: collision with root package name */
    private Context f60424f;

    /* renamed from: h, reason: collision with root package name */
    private a f60425h;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f60426a = 30;

        /* renamed from: b, reason: collision with root package name */
        private boolean f60427b = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f60428c = false;

        /* renamed from: d, reason: collision with root package name */
        private String[] f60429d;

        /* renamed from: e, reason: collision with root package name */
        private b f60430e;

        public a(String... strArr) {
            this.f60429d = strArr;
        }

        public int a() {
            return this.f60426a;
        }

        public OnAnimationListener b() {
            return this.f60430e;
        }

        public int c() {
            String[] strArr = this.f60429d;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }

        public String[] d() {
            return this.f60429d;
        }

        public boolean e() {
            return this.f60428c;
        }

        public boolean f() {
            return this.f60427b;
        }

        public a g(int i3) {
            this.f60426a = i3;
            return this;
        }

        public a h(boolean z16) {
            this.f60428c = z16;
            return this;
        }

        public a i(boolean z16) {
            this.f60427b = z16;
            return this;
        }

        public a j(OnAnimationListener onAnimationListener) {
            this.f60430e = new b(onAnimationListener, c());
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b implements OnAnimationListener {

        /* renamed from: d, reason: collision with root package name */
        private volatile int f60431d = 0;

        /* renamed from: e, reason: collision with root package name */
        private volatile int f60432e = 0;

        /* renamed from: f, reason: collision with root package name */
        private int f60433f;

        /* renamed from: h, reason: collision with root package name */
        private OnAnimationListener f60434h;

        public b(OnAnimationListener onAnimationListener, int i3) {
            this.f60434h = onAnimationListener;
            this.f60433f = i3;
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onAnimationFinished() {
            OnAnimationListener onAnimationListener;
            this.f60432e++;
            com.qzone.proxy.feedcomponent.util.j.e("MultiAnimationLayout", 4, "mAnimationFinishedIndex = " + this.f60432e + " totalSize = " + this.f60433f);
            if (this.f60432e != this.f60433f || (onAnimationListener = this.f60434h) == null) {
                return;
            }
            onAnimationListener.onAnimationFinished();
            this.f60432e = 0;
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onDrawableLoaded() {
            OnAnimationListener onAnimationListener;
            this.f60431d++;
            com.qzone.proxy.feedcomponent.util.j.e("MultiAnimationLayout", 4, "mDrawableLoadedIndex = " + this.f60431d + " totalSize = " + this.f60433f);
            if (this.f60431d != this.f60433f || (onAnimationListener = this.f60434h) == null) {
                return;
            }
            onAnimationListener.onDrawableLoaded();
            this.f60431d = 0;
        }
    }

    public MultiAnimationLayout(Context context) {
        super(context);
        c(context);
    }

    private ImageView a(Drawable drawable) {
        if (this.f60424f == null) {
            return null;
        }
        ImageView imageView = new ImageView(this.f60424f);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        return imageView;
    }

    private Drawable b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Drawable zipAnimationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(zipAnimationDrawable, str, this.f60425h.a());
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(zipAnimationDrawable, ar.l() / 720.0f);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(zipAnimationDrawable);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(zipAnimationDrawable, this.f60425h.f());
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(zipAnimationDrawable, this.f60425h.e());
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationListener(zipAnimationDrawable, this.f60425h.b());
        return zipAnimationDrawable;
    }

    private void c(Context context) {
        this.f60424f = context;
    }

    public void d() {
        Drawable[] drawableArr = this.f60422d;
        if (drawableArr == null) {
            return;
        }
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(drawable);
            }
        }
    }

    public MultiAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void setZipAnimation(a aVar) {
        if (aVar == null || aVar.c() == 0) {
            return;
        }
        this.f60425h = aVar;
        this.f60422d = new Drawable[aVar.c()];
        this.f60423e = new ImageView[aVar.c()];
        for (int i3 = 0; i3 < aVar.c(); i3++) {
            this.f60422d[i3] = b(aVar.d()[i3]);
            this.f60423e[i3] = a(this.f60422d[i3]);
            addView(this.f60423e[i3]);
        }
        for (Drawable drawable : this.f60422d) {
            if (drawable != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(drawable);
            }
        }
    }

    public MultiAnimationLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(context);
    }
}

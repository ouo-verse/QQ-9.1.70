package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.mobileqq.profile.like.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.util.VasPadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HeartLayout extends RelativeLayout implements HeartAnimator.c {
    static IPatchRedirector $redirector_;
    public static int J;
    public static Bitmap[] K;
    public static final int[] L;
    public AtomicInteger C;
    private ArrayList<Pair<WeakReference<URLDrawable>, String>> D;
    public float E;
    public float F;
    public boolean G;
    public float H;
    public boolean I;

    /* renamed from: d, reason: collision with root package name */
    public int f236897d;

    /* renamed from: e, reason: collision with root package name */
    public int f236898e;

    /* renamed from: f, reason: collision with root package name */
    public Rect f236899f;

    /* renamed from: h, reason: collision with root package name */
    public HeartAnimator f236900h;

    /* renamed from: i, reason: collision with root package name */
    public Random f236901i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f236902m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            J = 0;
            L = new int[]{Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a")};
        }
    }

    public HeartLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f236902m = true;
        this.C = new AtomicInteger(0);
        this.D = new ArrayList<>();
        this.G = false;
        this.I = false;
        l();
    }

    private void i(float f16, float f17) {
        Rect rect = this.f236899f;
        if (rect != null && f16 >= rect.left && f16 <= rect.right && f17 >= rect.top) {
            int i3 = rect.bottom;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private URLDrawable k(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (VasToggle.isEnable(VasToggle.FD_BUG_FIX, true)) {
            Iterator<Pair<WeakReference<URLDrawable>, String>> it = this.D.iterator();
            while (it.hasNext()) {
                Pair<WeakReference<URLDrawable>, String> next = it.next();
                URLDrawable uRLDrawable = (URLDrawable) ((WeakReference) next.first).get();
                if (uRLDrawable == null) {
                    it.remove();
                } else if (str.equals(next.second)) {
                    it.remove();
                    return uRLDrawable;
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.getBoolean("key_use_cache", false);
        return VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "praise?seed=" + this.C.getAndIncrement(), new BitmapDrawable(getResources(), bitmap), new int[]{14, 9, 15}, "-praise-", bundle);
    }

    @Override // com.tencent.mobileqq.hotchat.anim.HeartAnimator.c
    public void a(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) animation);
        }
    }

    @Override // com.tencent.mobileqq.hotchat.anim.HeartAnimator.c
    public void b(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.View
    public void clearAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.clearAnimation();
        if (!this.f236902m) {
            return;
        }
        for (int i3 = 0; i3 < super.getChildCount(); i3++) {
            super.getChildAt(i3).clearAnimation();
        }
        super.removeAllViews();
    }

    public void d(Bitmap bitmap, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, bitmap, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            f(null, bitmap, f16, f17, -1L, 0);
        }
    }

    public void e(d dVar, Bitmap bitmap, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, dVar, bitmap, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            f(dVar, bitmap, f16, f17, -1L, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(d dVar, Bitmap bitmap, float f16, float f17, long j3, int i3) {
        Bitmap bitmap2;
        URLDrawable k3;
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, dVar, bitmap, Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (this.f236902m && this.f236900h != null && bitmap != null) {
            String str = null;
            if (dVar != null) {
                bitmap2 = dVar.f260242j;
                if (bitmap == bitmap2) {
                    str = dVar.f260244l;
                } else {
                    bitmap2 = dVar.f260240h;
                    if (bitmap == bitmap2) {
                        str = dVar.f260243k;
                    }
                }
                URLImageView uRLImageView = new URLImageView(getContext());
                k3 = k(str, bitmap2);
                if (k3 == null) {
                    uRLImageView.setImageDrawable(k3);
                } else {
                    uRLImageView.setImageBitmap(bitmap);
                }
                uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                if (!VasPadUtils.INSTANCE.isPadSplitLandscape(getContext())) {
                    f18 = f16 - r1.getSplitLeftWidth(getContext());
                } else {
                    f18 = f16;
                }
                this.f236900h.h(uRLImageView, f18, f17, this, j3, i3, new Runnable(k3, str) { // from class: com.tencent.mobileqq.hotchat.anim.HeartLayout.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ URLDrawable f236903d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f236904e;

                    {
                        this.f236903d = k3;
                        this.f236904e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, HeartLayout.this, k3, str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f236903d != null) {
                            HeartLayout.this.D.add(new Pair(new WeakReference(this.f236903d), this.f236904e));
                        }
                    }
                });
            }
            bitmap2 = null;
            URLImageView uRLImageView2 = new URLImageView(getContext());
            k3 = k(str, bitmap2);
            if (k3 == null) {
            }
            uRLImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if (!VasPadUtils.INSTANCE.isPadSplitLandscape(getContext())) {
            }
            this.f236900h.h(uRLImageView2, f18, f17, this, j3, i3, new Runnable(k3, str) { // from class: com.tencent.mobileqq.hotchat.anim.HeartLayout.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ URLDrawable f236903d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f236904e;

                {
                    this.f236903d = k3;
                    this.f236904e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HeartLayout.this, k3, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (this.f236903d != null) {
                        HeartLayout.this.D.add(new Pair(new WeakReference(this.f236903d), this.f236904e));
                    }
                }
            });
        }
    }

    public void g(Bitmap bitmap, QQAppInterface qQAppInterface, com.tencent.mobileqq.hotchat.ui.a aVar, float f16, float f17, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, bitmap, qQAppInterface, aVar, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            h(null, bitmap, qQAppInterface, aVar, f16, f17, i3, i16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(d dVar, Bitmap bitmap, QQAppInterface qQAppInterface, com.tencent.mobileqq.hotchat.ui.a aVar, float f16, float f17, int i3, int i16) {
        Bitmap bitmap2;
        URLDrawable k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, dVar, bitmap, qQAppInterface, aVar, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f236902m && this.f236900h != null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            PayLikeFloatViewBuilder.AnimationView animationView = new PayLikeFloatViewBuilder.AnimationView(getContext(), qQAppInterface, aVar);
            URLImageView uRLImageView = new URLImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            relativeLayout.addView(uRLImageView, layoutParams);
            relativeLayout.addView(animationView, layoutParams2);
            String str = null;
            if (dVar != null) {
                bitmap2 = dVar.f260242j;
                if (bitmap == bitmap2) {
                    str = dVar.f260244l;
                } else {
                    bitmap2 = dVar.f260240h;
                    if (bitmap == bitmap2) {
                        str = dVar.f260243k;
                    }
                }
                k3 = k(str, bitmap2);
                if (k3 == null) {
                    uRLImageView.setImageDrawable(k3);
                } else {
                    QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
                    uRLImageView.setImageBitmap(bitmap);
                }
                uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f236900h.f(relativeLayout, f16, f17, i3, i16, this, -1L, 0, new Runnable(k3, str) { // from class: com.tencent.mobileqq.hotchat.anim.HeartLayout.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ URLDrawable f236905d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f236906e;

                    {
                        this.f236905d = k3;
                        this.f236906e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, HeartLayout.this, k3, str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f236905d != null) {
                            HeartLayout.this.D.add(new Pair(new WeakReference(this.f236905d), this.f236906e));
                        }
                    }
                });
            }
            bitmap2 = null;
            k3 = k(str, bitmap2);
            if (k3 == null) {
            }
            uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f236900h.f(relativeLayout, f16, f17, i3, i16, this, -1L, 0, new Runnable(k3, str) { // from class: com.tencent.mobileqq.hotchat.anim.HeartLayout.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ URLDrawable f236905d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f236906e;

                {
                    this.f236905d = k3;
                    this.f236906e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HeartLayout.this, k3, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (this.f236905d != null) {
                        HeartLayout.this.D.add(new Pair(new WeakReference(this.f236905d), this.f236906e));
                    }
                }
            });
        }
    }

    public HeartAnimator.a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HeartAnimator.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HeartAnimator heartAnimator = this.f236900h;
        if (heartAnimator != null) {
            return heartAnimator.c();
        }
        return null;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.H = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5;
        this.f236901i = new Random(System.currentTimeMillis());
        HeartAnimator heartAnimator = new HeartAnimator(this);
        this.f236900h = heartAnimator;
        heartAnimator.e(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        this.f236897d = super.getMeasuredWidth();
        this.f236898e = super.getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.I) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.f236902m || !super.isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.G) {
                this.G = false;
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.E, 2.0d) + Math.pow(motionEvent.getY() - this.F, 2.0d))) <= this.H) {
                    i(motionEvent.getX(), motionEvent.getY());
                }
            }
        } else {
            this.E = motionEvent.getX();
            this.F = motionEvent.getY();
            this.G = true;
        }
        return true;
    }

    public void setAnimator(HeartAnimator heartAnimator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) heartAnimator);
        } else {
            this.f236900h = heartAnimator;
        }
    }

    public void setCanDoAnim(boolean z16) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.f236902m = z16;
        if (!z16) {
            for (int childCount = super.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt != null && (bool = (Boolean) childAt.getTag(R.id.gqj)) != null && bool.booleanValue()) {
                    childAt.clearAnimation();
                    super.removeView(childAt);
                }
            }
        }
    }

    public void setHeartListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) aVar);
        }
    }

    public void setListenTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.I = z16;
        }
    }

    public void setRandom(Random random) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) random);
        } else {
            this.f236901i = random;
        }
    }

    public void setSpecialHeart(int i3, Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) set);
            return;
        }
        if (!this.f236902m) {
            return;
        }
        if (i3 >= 0) {
            J = i3;
        }
        if (set != null && set.size() > 0) {
            K = new Bitmap[set.size()];
            int i16 = 0;
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        K[i16] = BitmapFactory.decodeFile(str);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                i16++;
            }
        }
    }

    public void setTouchScope(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.H = f16;
        }
    }

    public void setValidRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) rect);
        } else {
            this.f236899f = rect;
        }
    }

    public HeartLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f236902m = true;
        this.C = new AtomicInteger(0);
        this.D = new ArrayList<>();
        this.G = false;
        this.I = false;
        l();
    }

    public HeartLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f236902m = true;
        this.C = new AtomicInteger(0);
        this.D = new ArrayList<>();
        this.G = false;
        this.I = false;
        l();
    }
}

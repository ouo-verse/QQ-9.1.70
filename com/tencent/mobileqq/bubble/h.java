package com.tencent.mobileqq.bubble;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    private static final ColorFilter f200757p;

    /* renamed from: q, reason: collision with root package name */
    private static int[] f200758q;

    /* renamed from: a, reason: collision with root package name */
    private int f200759a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f200760b;

    /* renamed from: c, reason: collision with root package name */
    private int f200761c;

    /* renamed from: d, reason: collision with root package name */
    private int f200762d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f200763e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f200764f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f200765g;

    /* renamed from: h, reason: collision with root package name */
    private Resources f200766h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f200767i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f200768j;

    /* renamed from: k, reason: collision with root package name */
    public String f200769k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f200770l;

    /* renamed from: m, reason: collision with root package name */
    private NinePatch f200771m;

    /* renamed from: n, reason: collision with root package name */
    private NinePatch f200772n;

    /* renamed from: o, reason: collision with root package name */
    private int f200773o;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71055);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f200757p = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -26.0f, 0.0f, 1.0f, 0.0f, 0.0f, -26.0f, 0.0f, 0.0f, 1.0f, 0.0f, -26.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            f200758q = new int[]{R.attr.state_pressed};
        }
    }

    public h(Resources resources, NinePatch ninePatch, NinePatch ninePatch2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resources, ninePatch, ninePatch2, Integer.valueOf(i3));
            return;
        }
        this.f200759a = 160;
        this.f200764f = false;
        this.f200767i = false;
        this.f200768j = false;
        this.f200766h = resources;
        this.f200771m = ninePatch;
        this.f200772n = ninePatch2;
        this.f200773o = i3;
        Paint paint = new Paint();
        this.f200760b = paint;
        paint.setDither(true);
        if (resources != null) {
            this.f200759a = resources.getDisplayMetrics().densityDpi;
            this.f200761c = BaseAIOUtils.f(c.e(), resources);
            this.f200762d = BaseAIOUtils.f(57.0f, resources);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Canvas canvas) {
        boolean z16;
        int i3;
        NinePatch ninePatch;
        if (canvas == null) {
            return;
        }
        StringBuilder P = l.P();
        P.append("bubblebg://");
        P.append("0_local_default_");
        P.append(this.f200765g);
        String sb5 = P.toString();
        Pair pair = (Pair) ImageCacheHelper.f98636a.g(sb5);
        if (pair != null && (ninePatch = (NinePatch) pair.first) != null) {
            ninePatch.draw(canvas, getBounds(), this.f200760b);
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.f200765g) {
                i3 = com.tencent.mobileqq.R.drawable.skin_aio_friend_bubble_nor;
            } else {
                i3 = com.tencent.mobileqq.R.drawable.skin_aio_user_bubble_nor;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 320;
            options.inTargetDensity = this.f200766h.getDisplayMetrics().densityDpi;
            try {
                c(canvas, sb5, BitmapFactory.decodeResource(this.f200766h, i3, options));
            } catch (OutOfMemoryError e16) {
                QLog.e("VipBubbleDrawable", 1, "drawDefaultBubbleBg, decode default bubble bg error, bubbleId=" + this.f200773o, e16);
            }
        }
    }

    private int b(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getByteCount();
    }

    private void c(Canvas canvas, String str, Bitmap bitmap) {
        byte[] ninePatchChunk;
        if (bitmap != null && (ninePatchChunk = bitmap.getNinePatchChunk()) != null) {
            NinePatch ninePatch = new NinePatch(bitmap, ninePatchChunk, null);
            ninePatch.draw(canvas, getBounds(), this.f200760b);
            ImageCacheHelper.f98636a.i(str, new Pair(ninePatch, Integer.valueOf(b(bitmap))), Business.AIO);
        }
    }

    public void d(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.f200765g = z16;
            this.f200770l = z17;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        NinePatch ninePatch;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Rect bounds = getBounds();
        int save = canvas.save();
        if (!this.f200770l || (ninePatch = this.f200772n) == null) {
            ninePatch = this.f200771m;
        }
        if (ninePatch != null) {
            if (this.f200765g) {
                canvas.scale(-1.0f, 1.0f, bounds.centerX(), bounds.centerY());
            }
            ninePatch.draw(canvas, getBounds(), this.f200760b);
        } else {
            QLog.e("VipBubbleDrawable", 1, "draw, ninePatch null, use default, mUseAnimationBg=" + this.f200770l + ", mNormalNinePatch=" + this.f200771m + ", mAnimationNinePath" + this.f200772n + ", bubbleId=" + this.f200773o + ", drawable=" + this);
            a(canvas);
        }
        canvas.restoreToCount(save);
        HashMap<String, g> hashMap = BubbleDiyFetcher.m().f200571i.get(Integer.valueOf(this.f200773o));
        if (hashMap != null && hashMap.size() > 0) {
            Iterator<g> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().c(this, canvas);
            }
        }
    }

    public void e(QQAppInterface qQAppInterface, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, qQAppInterface, str, Boolean.valueOf(z16));
        } else {
            this.f200765g = z16;
            this.f200769k = str;
        }
    }

    public void f(boolean z16, String str, int[] iArr, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), str, iArr, str2);
        } else {
            this.f200767i = z16;
            this.f200768j = z16;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f200762d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f200761c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        NinePatch ninePatch = this.f200771m;
        if (ninePatch != null) {
            if (ninePatch.hasAlpha()) {
                return -3;
            }
            return -1;
        }
        Paint paint = this.f200760b;
        if (paint != null && paint.getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) iArr)).booleanValue();
        }
        boolean stateSetMatches = StateSet.stateSetMatches(f200758q, iArr);
        if (this.f200763e == stateSetMatches) {
            return false;
        }
        this.f200763e = stateSetMatches;
        if (stateSetMatches && !this.f200764f) {
            this.f200760b.setColorFilter(f200757p);
        } else {
            this.f200760b.setColorFilter(null);
        }
        this.f200764f = false;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f200760b.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) colorFilter);
        }
    }
}

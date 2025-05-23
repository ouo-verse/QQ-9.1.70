package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopActiveLayout extends View implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final int[] L;
    private volatile int C;
    private SizeableBitmapCache D;
    private volatile ArrayList<Bitmap> E;
    private final Object F;
    private Paint G;
    private ArrayList<Bitmap> H;
    private Rect I;
    private RectF J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private Context f302428d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f302429e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f302430f;

    /* renamed from: h, reason: collision with root package name */
    private int f302431h;

    /* renamed from: i, reason: collision with root package name */
    private int f302432i;

    /* renamed from: m, reason: collision with root package name */
    private int f302433m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class SizeableBitmapCache extends ConcurrentHashMap<Integer, Bitmap> implements com.tencent.cache.api.f {
        static IPatchRedirector $redirector_;
        private int mFixSize;

        SizeableBitmapCache(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.mFixSize = i3;
            }
        }

        @Override // com.tencent.cache.api.f
        public int getByteSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.mFixSize;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31127);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            L = new int[]{R.drawable.djo, R.drawable.djp, R.drawable.djp, R.drawable.djq, R.drawable.djr, R.drawable.djs};
        }
    }

    public TroopActiveLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private Bitmap a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2) {
        Bitmap bitmap3 = null;
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            bitmap3 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap3);
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight()), new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight()), paint);
            canvas.drawBitmap(bitmap2, new Rect(bitmap2.getWidth() / 2, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(bitmap.getWidth() / 2, 0, bitmap.getWidth(), bitmap.getHeight()), paint);
            return bitmap3;
        } catch (Throwable th5) {
            QLog.e("TroopActiveLayout", 1, th5, new Object[0]);
            return bitmap3;
        }
    }

    private Bitmap b(int i3) {
        try {
            return BitmapFactory.decodeResource(getResources(), i3, null);
        } catch (OutOfMemoryError e16) {
            QLog.e("TroopActiveLayout", 1, e16, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(int i3) {
        boolean z16;
        int i16;
        int i17;
        Bitmap bitmap;
        boolean z17;
        Bitmap bitmap2;
        boolean z18;
        Looper.myLooper();
        Looper.getMainLooper();
        boolean z19 = true;
        if (i3 % 2 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = i3 - 1;
        } else {
            i16 = i3;
        }
        if (i16 == 0) {
            i16 = 2;
        }
        if (z16) {
            i17 = i3;
        } else {
            i17 = i3 + 1;
        }
        if (!this.D.containsKey(0)) {
            bitmap = b(L[0]);
            if (bitmap != null) {
                this.D.put(0, bitmap);
            } else {
                z17 = true;
                if (i16 < this.f302431h && i16 <= this.f302432i) {
                    if (!this.D.containsKey(Integer.valueOf(i16))) {
                        int i18 = i3 / 2;
                        if (i18 <= 0) {
                            i18 = 1;
                        } else {
                            int[] iArr = L;
                            if (i18 >= iArr.length) {
                                i18 = iArr.length - 1;
                            }
                        }
                        bitmap2 = b(L[i18]);
                        if (bitmap2 != null) {
                            this.D.put(Integer.valueOf(i16), bitmap2);
                        } else {
                            z17 = true;
                        }
                    } else {
                        bitmap2 = this.D.get(Integer.valueOf(i16));
                    }
                } else {
                    bitmap2 = null;
                }
                if (bitmap != null && bitmap2 != null && i17 >= this.f302431h && i17 <= this.f302432i) {
                    if (this.D.containsKey(Integer.valueOf(i17))) {
                        Bitmap a16 = a(bitmap2, bitmap);
                        if (a16 != null) {
                            this.D.put(Integer.valueOf(i17), a16);
                        } else {
                            z17 = true;
                        }
                    } else {
                        this.D.get(Integer.valueOf(i17));
                    }
                }
                if (bitmap != null && bitmap2 == null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z17 || z18) {
                    z19 = false;
                }
                if (!z19) {
                    Handler handler = this.f302429e;
                    handler.sendMessage(Message.obtain(handler, 101, i3, 0));
                    return;
                }
                return;
            }
        } else {
            bitmap = this.D.get(0);
        }
        z17 = false;
        if (i16 < this.f302431h) {
        }
        bitmap2 = null;
        if (bitmap != null) {
            if (this.D.containsKey(Integer.valueOf(i17))) {
            }
        }
        if (bitmap != null) {
        }
        z18 = false;
        if (!z17) {
        }
        z19 = false;
        if (!z19) {
        }
    }

    private void d(int i3) {
        Bitmap[] e16 = e(i3);
        if (e16 == null) {
            Handler handler = this.f302430f;
            handler.sendMessage(Message.obtain(handler, 102, i3, 0));
            return;
        }
        synchronized (this.F) {
            this.E.clear();
            for (Bitmap bitmap : e16) {
                if (bitmap != null) {
                    this.E.add(bitmap);
                }
            }
        }
        requestLayout();
        invalidate();
    }

    private Bitmap[] e(int i3) {
        boolean z16;
        int f16 = f();
        int i16 = 0;
        Bitmap bitmap = this.D.get(0);
        if (i3 % 2 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Bitmap bitmap2 = this.D.get(Integer.valueOf(i3));
            Bitmap bitmap3 = this.D.get(Integer.valueOf(i3 - 1));
            if (bitmap2 != null && bitmap3 != null) {
                int i17 = i3 / 2;
                Bitmap[] bitmapArr = new Bitmap[f16];
                while (i16 < i17) {
                    bitmapArr[i16] = bitmap3;
                    i16++;
                }
                bitmapArr[i17] = bitmap2;
                for (int i18 = i17 + 1; i18 < f16; i18++) {
                    bitmapArr[i18] = bitmap;
                }
                return bitmapArr;
            }
            return null;
        }
        Bitmap bitmap4 = this.D.get(Integer.valueOf(i3));
        if (bitmap4 != null) {
            int i19 = i3 / 2;
            Bitmap[] bitmapArr2 = new Bitmap[f16];
            while (i16 < i19) {
                bitmapArr2[i16] = bitmap4;
                i16++;
            }
            while (i19 < f16) {
                bitmapArr2[i19] = bitmap;
                i19++;
            }
            return bitmapArr2;
        }
        return null;
    }

    private int g(int i3, int i16, int i17) {
        if (i16 <= i17) {
            return Math.min(Math.max(i3, i16), i17);
        }
        throw new IllegalArgumentException(String.format("getValueWithLimit min value %s is greater than max value %s", Integer.valueOf(i16), Integer.valueOf(i17)));
    }

    private int h(int i3, boolean z16) {
        int paddingTop;
        int paddingBottom;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int i16 = 0;
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        this.H.clear();
        synchronized (this.F) {
            this.H.addAll(this.E);
        }
        if (z16) {
            int size2 = this.H.size();
            if (size2 > 0) {
                Iterator<Bitmap> it = this.H.iterator();
                while (it.hasNext()) {
                    i16 += it.next().getWidth();
                }
                i16 += (size2 - 1) * this.f302433m;
                paddingTop = getPaddingLeft();
                paddingBottom = getPaddingRight();
            } else {
                return size;
            }
        } else {
            Iterator<Bitmap> it5 = this.H.iterator();
            while (it5.hasNext()) {
                i16 = Math.max(i16, it5.next().getHeight());
            }
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        return paddingTop + paddingBottom + i16;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return (this.f302432i + 1) / 2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 101) {
            if (i3 == 102) {
                c(message.arg1);
                return false;
            }
            return false;
        }
        d(message.arg1);
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int g16 = g(width - paddingRight, 0, width) - g(paddingLeft, 0, width);
        int g17 = g(height - paddingBottom, 0, height) - g(paddingTop, 0, height);
        if (g16 > 0 && g17 > 0) {
            this.H.clear();
            synchronized (this.F) {
                this.H.addAll(this.E);
            }
            int size = this.H.size();
            if (size <= 0 || (i3 = (g16 - (this.f302433m * (size - 1))) / size) <= 0) {
                return;
            }
            float f16 = g17;
            float f17 = i3;
            float f18 = f16 / f17;
            if (this.K) {
                this.G.setColorFilter(ThemeConstants.NIGHTMODE_COLORFILTER);
            }
            Iterator<Bitmap> it = this.H.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                Bitmap next = it.next();
                if (next != null) {
                    float height2 = next.getHeight() / next.getWidth();
                    Rect rect = this.I;
                    rect.left = 0;
                    rect.top = 0;
                    rect.right = next.getWidth();
                    this.I.bottom = next.getHeight();
                    if (f18 > height2) {
                        RectF rectF = this.J;
                        float f19 = i16;
                        rectF.left = f19;
                        float f26 = (f16 - (height2 * f17)) / 2.0f;
                        rectF.top = f26;
                        rectF.right = f19 + f17;
                        rectF.bottom = f16 - f26;
                    } else {
                        RectF rectF2 = this.J;
                        float f27 = (f17 - (f16 / height2)) / 2.0f;
                        rectF2.left = i16 + f27;
                        rectF2.top = 0.0f;
                        rectF2.right = (i16 + i3) - f27;
                        rectF2.bottom = f16;
                    }
                    canvas.drawBitmap(next, this.I, this.J, this.G);
                    i16 += this.f302433m + i3;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            setMeasuredDimension(h(i3, true), h(i16, false));
        }
    }

    public void setHotLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            if (i3 >= this.f302431h && i3 <= this.f302432i) {
                this.C = i3;
                Handler handler = this.f302429e;
                handler.sendMessage(Message.obtain(handler, 101, i3, 0));
                return;
            }
            throw new IllegalArgumentException(String.format("setHotLevel error, level[%s] is out of range", Integer.valueOf(i3)));
        }
    }

    public TroopActiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TroopActiveLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        Object obj = new Object();
        this.F = obj;
        this.f302431h = 0;
        this.f302432i = 10;
        this.C = 0;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Object g16 = imageCacheHelper.g("TroopActiveLayout_cache");
        if (!(g16 instanceof SizeableBitmapCache)) {
            g16 = new SizeableBitmapCache(41702);
            imageCacheHelper.i("TroopActiveLayout_cache", g16, Business.AIO);
        }
        this.D = (SizeableBitmapCache) g16;
        this.f302428d = context;
        this.f302429e = new Handler(this);
        synchronized (obj) {
            this.E = new ArrayList<>((this.f302432i / 2) + 1);
        }
        this.f302433m = ScreenUtil.dip2px(3.0f);
        this.H = new ArrayList<>((this.f302432i / 2) + 1);
        this.f302430f = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        Paint paint = new Paint();
        this.G = paint;
        paint.setAntiAlias(true);
        this.I = new Rect();
        this.J = new RectF();
        setHotLevel(this.C);
        this.K = "1103".equals(ThemeUtil.getCurrentThemeId());
    }
}

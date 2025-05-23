package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes27.dex */
public class OnlineBatteryProducer {
    static IPatchRedirector $redirector_ = null;
    private static final int PERCENT_LOW = 20;
    private static final String TAG = "OnlineBatteryProducer";
    public static final int TYPE_SIZE_12_DIP = 0;
    public static final int TYPE_SIZE_16_DIP = 3;
    public static final int TYPE_SIZE_24_DIP = 1;
    public static final int TYPE_SIZE_48_DIP = 2;
    private static final int greenGradientColor1;
    private static final int greenGradientColor2;
    private static final int greenGradientColor3;
    private static final int redGradientColor1;
    private static final int redGradientColor2;
    private static final int redGradientColor3;
    private Paint batteryPaint;
    private int batteryTotalWidth;
    private int bottomMargin;
    private LinearGradient greenGradient;
    protected int height;
    private int leftMargin;
    private final Map<Integer, WeakReference<BatteryDrawable>> mBatteryDrawableCache;
    private BitmapDrawable mBitmapDrawable;
    private int mCurPercent;
    private Map<String, WeakReference<BatteryDrawable>> mMuteBatteryDrawableCache;
    private int mType;
    private LinearGradient redGradient;
    private int topMargin;
    protected int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27348);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        greenGradientColor1 = Color.parseColor("#6BCB1F");
        greenGradientColor2 = Color.parseColor("#9CF05B");
        greenGradientColor3 = Color.parseColor("#50A80C");
        redGradientColor1 = Color.parseColor("#FA4242");
        redGradientColor2 = Color.parseColor("#FFA194");
        redGradientColor3 = Color.parseColor("#E91D32");
    }

    public OnlineBatteryProducer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mBatteryDrawableCache = new HashMap();
        this.mMuteBatteryDrawableCache = null;
        this.batteryPaint = new Paint(1);
    }

    private BatteryDrawable createBatteryDrawable(Context context, int i3) {
        BatteryDrawable batteryDrawable = new BatteryDrawable();
        batteryDrawable.setType(i3);
        OnlineBatteryProducer batteryProducer = batteryDrawable.getBatteryProducer();
        if (batteryProducer.width <= 0 || batteryProducer.height <= 0) {
            int n3 = Utils.n(24.0f, context.getResources());
            batteryProducer.width = n3;
            batteryProducer.height = n3;
        }
        batteryDrawable.setBounds(0, 0, batteryProducer.width, batteryProducer.height);
        return batteryDrawable;
    }

    private void drawBatteryPercent(Canvas canvas, int i3) {
        LinearGradient linearGradient;
        int min = Math.min(Math.max(i3, 1), 100);
        Paint paint = this.batteryPaint;
        if (min > 20) {
            linearGradient = this.greenGradient;
        } else {
            linearGradient = this.redGradient;
        }
        paint.setShader(linearGradient);
        int i16 = (this.batteryTotalWidth * min) / 100;
        int i17 = this.leftMargin;
        canvas.drawRect(new Rect(i17, this.topMargin, i16 + i17, this.height - this.bottomMargin), this.batteryPaint);
    }

    private void drawBatteryStaticBackgroundBitmap(Canvas canvas) {
        int i3;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (this.mType == 0) {
            i3 = R.drawable.b9y;
        } else {
            i3 = R.drawable.bfz;
        }
        Drawable drawable = ContextCompat.getDrawable(mobileQQ, i3);
        drawable.setBounds(0, 0, this.width, this.height);
        drawable.draw(canvas);
    }

    private int getSize(Context context, int i3, int i16, int i17, int i18, int i19) {
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i16 = i18;
                } else {
                    i16 = i17;
                }
            } else {
                i16 = i19;
            }
        }
        return Utils.n(i16, context.getResources());
    }

    public void draw(Canvas canvas, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas, i3);
        } else {
            drawBatteryStaticBackgroundBitmap(canvas);
            drawBatteryPercent(canvas, i3);
        }
    }

    public BatteryDrawable getMuteBatteryDrawable(Context context, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BatteryDrawable) iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), str);
        }
        String str2 = i3 + "_" + str;
        if (this.mMuteBatteryDrawableCache == null) {
            this.mMuteBatteryDrawableCache = new HashMap();
        }
        WeakReference<BatteryDrawable> weakReference = this.mMuteBatteryDrawableCache.get(str2);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        BatteryDrawable createBatteryDrawable = createBatteryDrawable(context, i3);
        this.mMuteBatteryDrawableCache.put(str2, new WeakReference<>(createBatteryDrawable));
        return createBatteryDrawable;
    }

    public Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Paint) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.batteryPaint;
    }

    public BatteryDrawable getSelfBatteryDrawable(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BatteryDrawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, i3);
        }
        WeakReference<BatteryDrawable> weakReference = this.mBatteryDrawableCache.get(Integer.valueOf(i3));
        if (weakReference != null && weakReference.get() != null) {
            BatteryDrawable batteryDrawable = weakReference.get();
            batteryDrawable.getSelfPercent();
            return batteryDrawable;
        }
        BatteryDrawable createBatteryDrawable = createBatteryDrawable(context, i3);
        this.mBatteryDrawableCache.put(Integer.valueOf(i3), new WeakReference<>(createBatteryDrawable));
        createBatteryDrawable.getSelfPercent();
        return createBatteryDrawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.mType = i3;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        this.leftMargin = getSize(mobileQQ, i3, 1, 4, 5, 7);
        this.topMargin = getSize(mobileQQ, i3, 3, 6, 8, 10);
        this.bottomMargin = getSize(mobileQQ, i3, 3, 6, 8, 10);
        int size = getSize(mobileQQ, i3, 2, 5, 6, 8);
        int size2 = getSize(mobileQQ, i3, 12, 19, 24, 32);
        this.height = size2;
        this.width = size2;
        this.batteryTotalWidth = (size2 - this.leftMargin) - size;
        int i16 = this.leftMargin;
        float f16 = this.height - this.bottomMargin;
        int i17 = greenGradientColor3;
        this.greenGradient = new LinearGradient(i16, this.topMargin, i16, f16, new int[]{greenGradientColor1, greenGradientColor2, i17, i17}, (float[]) null, Shader.TileMode.MIRROR);
        int i18 = this.leftMargin;
        float f17 = this.height - this.bottomMargin;
        int i19 = redGradientColor3;
        this.redGradient = new LinearGradient(i18, this.topMargin, i18, f17, new int[]{redGradientColor1, redGradientColor2, i19, i19}, (float[]) null, Shader.TileMode.MIRROR);
    }

    public Drawable createBatteryDrawable(int i3, int i16) {
        BitmapDrawable bitmapDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (this.mCurPercent == i3 && (bitmapDrawable = this.mBitmapDrawable) != null && i16 == this.mType) {
            return bitmapDrawable;
        }
        init(i16);
        this.mCurPercent = i3;
        long currentTimeMillis = System.currentTimeMillis();
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (this.width <= 0 || this.height <= 0) {
            QLog.d(TAG, 1, "width: " + this.width + " height: " + this.height);
            int n3 = Utils.n(24.0f, mobileQQ.getResources());
            this.width = n3;
            this.height = n3;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawBatteryStaticBackgroundBitmap(canvas);
        drawBatteryPercent(canvas, i3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "createBatteryDrawable cost time : " + (System.currentTimeMillis() - currentTimeMillis));
        }
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(mobileQQ.getResources(), createBitmap);
        this.mBitmapDrawable = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, this.width, this.height);
        return this.mBitmapDrawable;
    }
}

package com.tencent.mobileqq.loverzone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoveZoneTabRedDotView extends View {
    static IPatchRedirector $redirector_;
    public static final String E;
    private float C;
    private Drawable.Callback D;

    /* renamed from: d, reason: collision with root package name */
    private String f243121d;

    /* renamed from: e, reason: collision with root package name */
    private final int f243122e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f243123f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f243124h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f243125i;

    /* renamed from: m, reason: collision with root package name */
    private Rect f243126m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Drawable.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoveZoneTabRedDotView.this);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            } else {
                LoveZoneTabRedDotView.this.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, drawable, runnable, Long.valueOf(j3));
            } else {
                LoveZoneTabRedDotView.this.scheduleDrawable(drawable, runnable, j3);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, (Object) runnable);
            } else {
                LoveZoneTabRedDotView.this.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            E = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SWEET_MINI_APP, QzoneConfig.SECONDARY_KEY_SETTING_RED_DOT_ANIMATION_SRC, QzoneConfig.DEFAULT_SWEET_SETTING_RED_DOT_ANIMATION_SRC);
        }
    }

    public LoveZoneTabRedDotView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f243121d = "";
        this.f243122e = 11;
        this.f243123f = false;
        this.D = new a();
    }

    private boolean b(BusinessInfoCheckUpdate.AppInfo appInfo) {
        JSONObject jSONObject;
        if (appInfo != null && appInfo.iNewFlag.get() != 0 && appInfo.buffer.has()) {
            try {
                JSONObject jSONObject2 = new JSONObject(appInfo.buffer.get());
                JSONObject optJSONObject = jSONObject2.optJSONObject("param");
                String optString = jSONObject2.optString("_show_mission");
                if (optJSONObject != null && !TextUtils.isEmpty(optString) && (jSONObject = (JSONObject) optJSONObject.opt(optString)) != null) {
                    String optString2 = jSONObject.optString(optString);
                    this.f243121d = optString2;
                    if (!TextUtils.isEmpty(optString2)) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e16) {
                QLog.e("LoveZoneTabRedDotView", 1, "buffer handle exception:" + e16);
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f243123f || getVisibility() == 0) {
            this.f243123f = false;
            setVisibility(8);
            if (this.f243124h != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f243124h);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f243124h);
                this.f243124h = null;
            }
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f243123f && getVisibility() == 0) {
            if (this.f243124h == null) {
                requestLayout();
            } else {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.f243124h);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f243123f && this.f243126m != null && this.f243125i != null && !TextUtils.isEmpty(this.f243121d)) {
            canvas.save();
            Drawable drawable = getResources().getDrawable(R.drawable.qq_setting_love_zone_red_touch);
            drawable.getBounds();
            Rect rect = this.f243126m;
            drawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            drawable.draw(canvas);
            this.f243125i.setColor(-1);
            canvas.drawText(this.f243121d, this.f243126m.left + ViewUtils.dpToPx(25.0f), this.C, this.f243125i);
            if (this.f243124h == null) {
                this.f243124h = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.f243124h, E, 18);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.f243124h, false);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.f243124h, true);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).loadAndShowFirstFrame(this.f243124h);
                this.f243124h.setCallback(this.D);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.f243124h);
            }
            Drawable drawable2 = this.f243124h;
            Rect rect2 = this.f243126m;
            drawable2.setBounds(rect2.left, rect2.top - (ViewUtils.dpToPx(2.0f) * 3), this.f243126m.left + ViewUtils.dpToPx(25.0f), (this.f243126m.top + ViewUtils.dpToPx(25.0f)) - (ViewUtils.dpToPx(2.0f) * 3));
            this.f243124h.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        if (TextUtils.isEmpty(this.f243121d)) {
            return;
        }
        if (this.f243125i == null) {
            Paint paint = new Paint(1);
            this.f243125i = paint;
            paint.setTextSize(ViewUtils.dpToPx(11.0f));
            this.f243125i.setTextAlign(Paint.Align.LEFT);
        }
        int size = View.MeasureSpec.getSize(i16);
        int measureText = ((int) this.f243125i.measureText(this.f243121d)) + ViewUtils.dpToPx(6.0f) + ViewUtils.dpToPx(25.0f);
        Paint.FontMetrics fontMetrics = this.f243125i.getFontMetrics();
        int i17 = (int) (fontMetrics.bottom - fontMetrics.top);
        int dpToPx = ((size / 2) - (i17 / 2)) - ViewUtils.dpToPx(2.0f);
        int dpToPx2 = i17 + (ViewUtils.dpToPx(2.0f) * 2);
        if (this.f243126m == null) {
            this.f243126m = new Rect();
        }
        Rect rect = this.f243126m;
        rect.left = 0;
        rect.top = dpToPx;
        rect.right = measureText + 0;
        rect.bottom = dpToPx2 + dpToPx;
        this.C = (dpToPx + ViewUtils.dpToPx(2.0f)) - fontMetrics.top;
        setMeasuredDimension(measureText, i16);
    }

    public void setRedDotData(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInfo);
            return;
        }
        boolean b16 = b(appInfo);
        this.f243123f = b16;
        if (!b16) {
            a();
            setVisibility(8);
        } else {
            setVisibility(0);
            requestLayout();
            c();
        }
        invalidate();
    }

    public LoveZoneTabRedDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f243121d = "";
        this.f243122e = 11;
        this.f243123f = false;
        this.D = new a();
    }
}

package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class di extends dj {

    /* renamed from: m, reason: collision with root package name */
    private int f388592m;

    /* renamed from: n, reason: collision with root package name */
    private Bitmap f388593n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f388594o;

    /* renamed from: p, reason: collision with root package name */
    private PendingIntent f388595p;

    /* renamed from: q, reason: collision with root package name */
    private int f388596q;

    /* renamed from: r, reason: collision with root package name */
    private int f388597r;

    public di(Context context, int i3, String str) {
        super(context, i3, str);
        this.f388592m = 16777216;
        this.f388596q = 16777216;
        this.f388597r = 16777216;
    }

    private Drawable G(int i3, int i16, int i17, float f16) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null));
        shapeDrawable.getPaint().setColor(i3);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i16);
        shapeDrawable.setIntrinsicHeight(i17);
        return shapeDrawable;
    }

    private void K(RemoteViews remoteViews, int i3, int i16, int i17, boolean z16) {
        int h16 = h(6.0f);
        remoteViews.setViewPadding(i3, h16, 0, h16, 0);
        if (z16) {
            remoteViews.setTextColor(i16, -1);
            remoteViews.setTextColor(i17, -1);
        } else {
            remoteViews.setTextColor(i16, -16777216);
            remoteViews.setTextColor(i17, -16777216);
        }
    }

    public di H(Bitmap bitmap) {
        if (y() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f388593n = bitmap;
            } else {
                jz4.c.m("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    public di I(CharSequence charSequence, PendingIntent pendingIntent) {
        if (y()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f388594o = charSequence;
            this.f388595p = pendingIntent;
        }
        return this;
    }

    public di J(String str) {
        if (y() && !TextUtils.isEmpty(str)) {
            try {
                this.f388596q = Color.parseColor(str);
            } catch (Exception unused) {
                jz4.c.m("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    public di L(String str) {
        if (y() && !TextUtils.isEmpty(str)) {
            try {
                this.f388592m = Color.parseColor(str);
            } catch (Exception unused) {
                jz4.c.m("parse colorful notification bg color error");
            }
        }
        return this;
    }

    public di M(String str) {
        if (y() && !TextUtils.isEmpty(str)) {
            try {
                this.f388597r = Color.parseColor(str);
            } catch (Exception unused) {
                jz4.c.m("parse colorful notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dj, com.xiaomi.push.dh
    public void g() {
        boolean z16;
        int i3;
        if (y()) {
            super.g();
            Resources resources = c().getResources();
            String packageName = c().getPackageName();
            int a16 = a(resources, "icon", "id", packageName);
            if (this.f388600d == null) {
                r(a16);
            } else {
                k().setImageViewBitmap(a16, this.f388600d);
            }
            int a17 = a(resources, "title", "id", packageName);
            int a18 = a(resources, "content", "id", packageName);
            k().setTextViewText(a17, this.f388601e);
            k().setTextViewText(a18, this.f388602f);
            if (!TextUtils.isEmpty(this.f388594o)) {
                int a19 = a(resources, "buttonContainer", "id", packageName);
                int a26 = a(resources, "button", "id", packageName);
                int a27 = a(resources, "buttonBg", "id", packageName);
                k().setViewVisibility(a19, 0);
                k().setTextViewText(a26, this.f388594o);
                k().setOnClickPendingIntent(a19, this.f388595p);
                if (this.f388596q != 16777216) {
                    int h16 = h(70.0f);
                    int h17 = h(29.0f);
                    k().setImageViewBitmap(a27, com.xiaomi.push.service.x.n(G(this.f388596q, h16, h17, h17 / 2.0f)));
                    RemoteViews k3 = k();
                    if (u(this.f388596q)) {
                        i3 = -1;
                    } else {
                        i3 = -16777216;
                    }
                    k3.setTextColor(a26, i3);
                }
            }
            int a28 = a(resources, VasProfileTemplatePreloadHelper.BACKGROUND, "id", packageName);
            int a29 = a(resources, ParseCommon.CONTAINER, "id", packageName);
            if (this.f388592m != 16777216) {
                if (hz.b(c()) >= 10) {
                    k().setImageViewBitmap(a28, com.xiaomi.push.service.x.n(G(this.f388592m, 984, 192, 30.0f)));
                } else {
                    k().setImageViewBitmap(a28, com.xiaomi.push.service.x.n(G(this.f388592m, 984, 192, 0.0f)));
                }
                K(k(), a29, a17, a18, u(this.f388592m));
            } else if (this.f388593n != null) {
                if (hz.b(c()) >= 10) {
                    k().setImageViewBitmap(a28, j(this.f388593n, 30.0f));
                } else {
                    k().setImageViewBitmap(a28, this.f388593n);
                }
                Map<String, String> map = this.f388603g;
                if (map != null && this.f388597r == 16777216) {
                    M(map.get("notification_image_text_color"));
                }
                int i16 = this.f388597r;
                if (i16 != 16777216 && u(i16)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                K(k(), a29, a17, a18, z16);
            } else if (Build.VERSION.SDK_INT >= 24) {
                k().setViewVisibility(a16, 8);
                k().setViewVisibility(a28, 8);
                try {
                    y.e(this, "setStyle", ii.c(c(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    jz4.c.m("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(k());
            return;
        }
        x();
    }

    @Override // com.xiaomi.push.dj
    protected String q() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dj
    protected boolean t() {
        if (!hz.i()) {
            return false;
        }
        Resources resources = c().getResources();
        String packageName = c().getPackageName();
        int a16 = a(resources, "icon", "id", packageName);
        int a17 = a(resources, "title", "id", packageName);
        int a18 = a(resources, "content", "id", packageName);
        if (a16 == 0 || a17 == 0 || a18 == 0) {
            return false;
        }
        return true;
    }

    @Override // com.xiaomi.push.dj
    protected String w() {
        return "notification_colorful_copy";
    }
}

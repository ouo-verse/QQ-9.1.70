package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dg extends dj {

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f388588m;

    /* renamed from: n, reason: collision with root package name */
    private Bitmap f388589n;

    /* renamed from: o, reason: collision with root package name */
    private int f388590o;

    public dg(Context context, String str) {
        super(context, str);
        this.f388590o = 16777216;
    }

    public dg G(Bitmap bitmap) {
        if (y() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.f388588m = bitmap;
            } else {
                jz4.c.m("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    public dg H(String str) {
        if (y() && !TextUtils.isEmpty(str)) {
            try {
                this.f388590o = Color.parseColor(str);
            } catch (Exception unused) {
                jz4.c.m("parse banner notification image text color error");
            }
        }
        return this;
    }

    public dg I(Bitmap bitmap) {
        if (y() && bitmap != null) {
            this.f388589n = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.dj, com.xiaomi.push.dh
    public void g() {
        int i3;
        if (y() && this.f388588m != null) {
            super.g();
            Resources resources = c().getResources();
            String packageName = c().getPackageName();
            int a16 = a(resources, VasProfileTemplatePreloadHelper.BACKGROUND, "id", packageName);
            if (hz.b(c()) >= 10) {
                k().setImageViewBitmap(a16, j(this.f388588m, 30.0f));
            } else {
                k().setImageViewBitmap(a16, this.f388588m);
            }
            int a17 = a(resources, "icon", "id", packageName);
            if (this.f388589n != null) {
                k().setImageViewBitmap(a17, this.f388589n);
            } else {
                r(a17);
            }
            int a18 = a(resources, "title", "id", packageName);
            k().setTextViewText(a18, this.f388601e);
            Map<String, String> map = this.f388603g;
            if (map != null && this.f388590o == 16777216) {
                H(map.get("notification_image_text_color"));
            }
            RemoteViews k3 = k();
            int i16 = this.f388590o;
            if (i16 != 16777216 && u(i16)) {
                i3 = -16777216;
            } else {
                i3 = -1;
            }
            k3.setTextColor(a18, i3);
            setCustomContentView(k());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        x();
    }

    @Override // com.xiaomi.push.dj
    protected String q() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.dj
    protected boolean t() {
        if (!hz.i()) {
            return false;
        }
        Resources resources = c().getResources();
        String packageName = c().getPackageName();
        int a16 = a(c().getResources(), VasProfileTemplatePreloadHelper.BACKGROUND, "id", c().getPackageName());
        int a17 = a(resources, "icon", "id", packageName);
        int a18 = a(resources, "title", "id", packageName);
        if (a16 == 0 || a17 == 0 || a18 == 0 || hz.b(c()) < 9) {
            return false;
        }
        return true;
    }

    @Override // com.xiaomi.push.dj
    protected String w() {
        return null;
    }

    @Override // com.xiaomi.push.dj, android.app.Notification.Builder
    /* renamed from: o */
    public dj setLargeIcon(Bitmap bitmap) {
        return this;
    }
}

package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class dj extends dh {

    /* renamed from: b, reason: collision with root package name */
    private RemoteViews f388598b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388599c;

    /* renamed from: d, reason: collision with root package name */
    protected Bitmap f388600d;

    /* renamed from: e, reason: collision with root package name */
    protected CharSequence f388601e;

    /* renamed from: f, reason: collision with root package name */
    protected CharSequence f388602f;

    /* renamed from: g, reason: collision with root package name */
    protected Map<String, String> f388603g;

    /* renamed from: h, reason: collision with root package name */
    private int f388604h;

    /* renamed from: i, reason: collision with root package name */
    private String f388605i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f388606j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<Notification.Action> f388607k;

    /* renamed from: l, reason: collision with root package name */
    private int f388608l;

    public dj(Context context, String str) {
        this(context, 0, str);
    }

    private void A() {
        int a16 = a(c().getResources(), z(), TtmlNode.TAG_LAYOUT, c().getPackageName());
        if (a16 != 0) {
            this.f388598b = new RemoteViews(c().getPackageName(), a16);
            this.f388599c = t();
        } else {
            jz4.c.m("create RemoteViews failed, no such layout resource was found");
        }
    }

    private boolean B() {
        Map<String, String> map = this.f388603g;
        if (map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"))) {
            return true;
        }
        return false;
    }

    private void C() {
        super.setContentTitle(this.f388601e);
        super.setContentText(this.f388602f);
    }

    private boolean D() {
        if (!TextUtils.isEmpty(w()) && !TextUtils.isEmpty(this.f388605i)) {
            return true;
        }
        return false;
    }

    private boolean E() {
        if (D() && F()) {
            return true;
        }
        return false;
    }

    private boolean F() {
        List<StatusBarNotification> y16 = com.xiaomi.push.service.j.e(c(), this.f388605i).y();
        if (y16 != null && !y16.isEmpty()) {
            for (StatusBarNotification statusBarNotification : y16) {
                if (statusBarNotification.getId() == this.f388604h) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    private Bitmap i() {
        return com.xiaomi.push.service.x.n(g.d(c(), this.f388605i));
    }

    private String z() {
        boolean E = E();
        this.f388606j = E;
        if (E) {
            return w();
        }
        return q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.dh
    public void g() {
        super.g();
        Bundle bundle = new Bundle();
        if (D()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f388606j);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", b("large_icon"));
        if (this.f388607k.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f388607k.size()];
            this.f388607k.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (!B() && com.xiaomi.push.service.k.r(c().getContentResolver())) {
            bundle.putCharSequence("mipush.customTitle", this.f388601e);
            bundle.putCharSequence("mipush.customContent", this.f388602f);
        } else {
            C();
        }
        addExtras(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h(float f16) {
        return (int) ((f16 * c().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap j(Bitmap bitmap, float f16) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f16, f16, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public final RemoteViews k() {
        return this.f388598b;
    }

    public dh l(Map<String, String> map) {
        this.f388603g = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public dj addAction(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i3, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public dj addAction(Notification.Action action) {
        if (action != null) {
            this.f388607k.add(action);
        }
        int i3 = this.f388608l;
        this.f388608l = i3 + 1;
        s(i3, action);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public dj setLargeIcon(Bitmap bitmap) {
        this.f388600d = bitmap;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public dj setContentTitle(CharSequence charSequence) {
        this.f388601e = charSequence;
        return this;
    }

    protected abstract String q();

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(int i3) {
        Bitmap i16 = i();
        if (i16 != null) {
            k().setImageViewBitmap(i3, i16);
            return;
        }
        int m3 = g.m(c(), this.f388605i);
        if (m3 != 0) {
            k().setImageViewResource(i3, m3);
        }
    }

    protected abstract boolean t();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean u(int i3) {
        if ((Color.red(i3) * 0.299d) + (Color.green(i3) * 0.587d) + (Color.blue(i3) * 0.114d) < 192.0d) {
            return true;
        }
        return false;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public dj setContentText(CharSequence charSequence) {
        this.f388602f = charSequence;
        return this;
    }

    protected abstract String w();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x() {
        super.setContentTitle(this.f388601e);
        super.setContentText(this.f388602f);
        Bitmap bitmap = this.f388600d;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean y() {
        return this.f388599c;
    }

    public dj(Context context, int i3, String str) {
        super(context);
        this.f388607k = new ArrayList<>();
        this.f388608l = 0;
        this.f388605i = str;
        this.f388604h = i3;
        A();
    }

    protected void s(int i3, Notification.Action action) {
    }
}

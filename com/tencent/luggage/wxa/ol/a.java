package com.tencent.luggage.wxa.ol;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.SystemProperties;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.luggage.wxa.ol.e1;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f136642d = false;

    /* renamed from: a, reason: collision with root package name */
    public final Activity f136643a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136644b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f136645c = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ol.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6559a implements e1.a {
        public C6559a() {
        }

        @Override // com.tencent.luggage.wxa.ol.e1.a
        public void a(View view) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onRootViewResized");
            a.this.b();
        }
    }

    public a(Activity activity) {
        this.f136643a = activity;
    }

    public final void b() {
        if (this.f136644b && !this.f136643a.isFinishing() && f136642d) {
            if (q.b(this.f136643a) == null) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
            } else {
                a();
            }
        }
    }

    public final boolean c() {
        if (this.f136643a.getWindow() != null && (this.f136643a.getWindow().getAttributes().flags & 1024) > 0) {
            return true;
        }
        return false;
    }

    public void d() {
        Activity activity = this.f136643a;
        if (activity != null && activity.getWindow() != null) {
            this.f136643a.getWindow().setSoftInputMode(16);
        }
    }

    public void a(View view) {
        Activity activity = this.f136643a;
        if (activity == null || activity.getWindow() == null || view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        this.f136644b = true;
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (f136642d && a(this.f136643a)) {
            e1.a(viewGroup, new C6559a());
        }
    }

    public void a(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", Integer.valueOf(this.f136645c), Integer.valueOf(layoutParams.flags));
        int i3 = layoutParams.flags;
        if (i3 != this.f136645c) {
            this.f136645c = i3;
            b();
        }
    }

    public void a(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", Integer.valueOf(configuration.orientation));
        b();
    }

    public final void a() {
        q b16 = q.b(this.f136643a);
        Point point = new Point();
        this.f136643a.getWindowManager().getDefaultDisplay().getSize(point);
        int f16 = com.tencent.luggage.wxa.lo.f.f(this.f136643a);
        int i3 = point.y;
        if (c()) {
            f16 = 0;
        }
        int i16 = i3 - f16;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", Integer.valueOf(i16));
        b16.setForceHeight(i16);
    }

    public static boolean a(Context context) {
        String str;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z16 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "qemu.hw.mainkeys");
        } catch (Exception unused) {
        }
        if ("1".equals(str)) {
            return false;
        }
        if ("0".equals(str)) {
            return true;
        }
        return z16;
    }
}

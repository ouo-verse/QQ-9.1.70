package com.tencent.xweb;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.wxa.ar.x0;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebResource extends Resources {
    public static final String TAG = "XWebResource";

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f385068a;

    public XWebResource(Resources resources, Context context) {
        super(resources.getAssets(), context.getResources().getDisplayMetrics(), resources.getConfiguration());
        this.f385068a = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        Context context = (Context) this.f385068a.get();
        if (context != null) {
            return context.getResources().getDisplayMetrics();
        }
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        x0.d(TAG, "updateConfiguration, locale:" + configuration.locale);
        super.updateConfiguration(configuration, displayMetrics);
    }
}

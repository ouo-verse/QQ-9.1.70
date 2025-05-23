package com.tencent.xweb.pinus;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CalledByRuntime;
import com.tencent.xweb.XWebContextWrapper;
import com.tencent.xweb.XWebResource;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class PSContextWrapper extends XWebContextWrapper {
    private static final String TAG = "PSContextWrapper";

    @CalledByRuntime
    public int apkVersion;

    @CalledByRuntime
    public boolean enableV8Lite;

    @CalledByRuntime
    public String extractedCoreDir;

    @CalledByRuntime
    public int forceDarkBehavior;

    @CalledByRuntime
    public boolean isForceDarkMode;

    @CalledByRuntime
    public boolean usingCustomContext;

    public PSContextWrapper(Context context, int i3) {
        super(context);
        this.apkVersion = 0;
        this.usingCustomContext = false;
        this.isForceDarkMode = false;
        this.forceDarkBehavior = 2;
        initContextWrapper(context, i3);
    }

    private void initContextWrapper(Context context, int i3) {
        this.mContext = context;
        this.mLayoutInflater = ((LayoutInflater) context.getApplicationContext().getSystemService("layout_inflater")).cloneInContext(this);
        this.apkVersion = i3;
        this.extractedCoreDir = u0.j(i3);
        String e16 = u0.e(i3);
        boolean usingCustomContextInternal = XWalkEnvironment.getUsingCustomContextInternal();
        this.usingCustomContext = usingCustomContextInternal;
        if (usingCustomContextInternal) {
            this.mResources = new XWebResource(getResources(context, e16), context);
        } else {
            this.mResources = getResources(context, e16);
        }
        x0.d(TAG, "usingCustomContext:" + this.usingCustomContext + ", resources:" + this.mResources);
        Locale locale = XWalkEnvironment.getLocale();
        if (locale != null) {
            x0.d(TAG, "updateResourceLocale, customize locale:" + locale.toLanguageTag());
            updateResourceLocale(locale);
        }
        this.enableV8Lite = XWalkEnvironment.getV8LiteMode();
        if (XWalkEnvironment.isCurrentVersionSupportConfigureV8Lite()) {
            x0.d(TAG, "configure v8 lite supported, enableV8Lite:" + this.enableV8Lite);
        } else {
            x0.d(TAG, "configure v8 lite not supported");
        }
        if (XWalkEnvironment.isCurrentVersionSupportForceDarkMode()) {
            this.isForceDarkMode = XWalkEnvironment.getForceDarkMode();
            this.forceDarkBehavior = XWalkEnvironment.getForceDarkBehavior();
            x0.d(TAG, "force dark mode supported, isForceDarkMode:" + this.isForceDarkMode + ", forceDarkBehavior:" + this.forceDarkBehavior);
        } else {
            x0.d(TAG, "force dark mode not supported");
        }
        Resources resources = this.mResources;
        if (resources != null && this.mApplicationInfo != null) {
            this.mTheme = resources.newTheme();
            if (getPackageInfo(context, e16) != null) {
                Resources.Theme theme = context.getTheme();
                if (theme != null) {
                    this.mTheme.setTo(theme);
                }
                this.mTheme.applyStyle(this.mApplicationInfo.theme, true);
            }
        }
    }

    @Override // com.tencent.xweb.XWebContextWrapper
    public ClassLoader getWebViewCoreClassLoader() {
        return PinusStandAloneChannel.getInstance().getClassLoader();
    }
}

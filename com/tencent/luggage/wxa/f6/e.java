package com.tencent.luggage.wxa.f6;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends ContextThemeWrapper {

    /* renamed from: d, reason: collision with root package name */
    public static final c f125382d = new a();

    /* renamed from: a, reason: collision with root package name */
    public Resources f125383a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f125384b;

    /* renamed from: c, reason: collision with root package name */
    public final c f125385c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c {
        @Override // com.tencent.luggage.wxa.f6.e.c
        public DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(displayMetrics);
            return displayMetrics2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration);
    }

    public e(Context context, c cVar) {
        super.attachBaseContext(context);
        this.f125385c = cVar == null ? f125382d : cVar;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (getAssets() != null) {
            if (this.f125383a == null) {
                Resources resources = super.getResources();
                this.f125383a = new b(resources, a(resources.getDisplayMetrics(), resources.getConfiguration()));
                getTheme().getResources().getDisplayMetrics().setTo(this.f125383a.getDisplayMetrics());
            }
            return this.f125383a;
        }
        return super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            LayoutInflater layoutInflater = this.f125384b;
            if (layoutInflater != null) {
                return layoutInflater;
            }
            LayoutInflater layoutInflater2 = (LayoutInflater) super.getSystemService("layout_inflater");
            this.f125384b = layoutInflater2;
            return layoutInflater2;
        }
        return super.getSystemService(str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b extends com.tencent.luggage.wxa.il.a {

        /* renamed from: b, reason: collision with root package name */
        public final Resources f125386b;

        /* renamed from: c, reason: collision with root package name */
        public DisplayMetrics f125387c;

        /* renamed from: d, reason: collision with root package name */
        public Configuration f125388d;

        /* renamed from: e, reason: collision with root package name */
        public DisplayMetrics f125389e;

        public b(Resources resources, DisplayMetrics displayMetrics) {
            super(resources);
            this.f125386b = resources;
            this.f125387c = displayMetrics;
            Configuration configuration = new Configuration(resources.getConfiguration());
            this.f125388d = configuration;
            configuration.densityDpi = this.f125387c.densityDpi;
            this.f125389e = resources.getDisplayMetrics();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(resources.getDisplayMetrics());
            a(configuration2, displayMetrics2, false);
        }

        public final Drawable a(Drawable drawable) {
            DisplayMetrics displayMetrics;
            if ((drawable instanceof BitmapDrawable) && (displayMetrics = this.f125387c) != null) {
                ((BitmapDrawable) drawable).setTargetDensity(displayMetrics.densityDpi);
            }
            return drawable;
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public int getColor(int i3) {
            if (i3 == R.color.ajr) {
                w.f("ScreenAdaptiveContextThemeWrapper", "getColor: hack here! R.color.transparent -> Color.TRANSPARENT");
                return 0;
            }
            return super.getColor(i3);
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public Configuration getConfiguration() {
            Configuration configuration = this.f125388d;
            if (configuration != null) {
                return configuration;
            }
            return super.getConfiguration();
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public int getDimensionPixelOffset(int i3) {
            return a(i3);
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public int getDimensionPixelSize(int i3) {
            return b(i3);
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public DisplayMetrics getDisplayMetrics() {
            DisplayMetrics displayMetrics = this.f125387c;
            if (displayMetrics != null) {
                return displayMetrics;
            }
            return super.getDisplayMetrics();
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public Drawable getDrawable(int i3) {
            DisplayMetrics displayMetrics = this.f125387c;
            if (displayMetrics != null) {
                return getDrawableForDensity(i3, displayMetrics.densityDpi);
            }
            return a(this.f125386b.getDrawable(i3));
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public Drawable getDrawableForDensity(int i3, int i16) {
            DisplayMetrics displayMetrics;
            if (i16 == 0 && (displayMetrics = this.f125387c) != null) {
                i16 = displayMetrics.densityDpi;
            }
            return this.f125386b.getDrawableForDensity(i3, i16);
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
            if (this.f125387c != null) {
                a(configuration, displayMetrics, true);
            } else {
                super.updateConfiguration(configuration, displayMetrics);
            }
        }

        public final void a(Configuration configuration, DisplayMetrics displayMetrics, boolean z16) {
            if (displayMetrics == null) {
                if (this.f125387c != null) {
                    Configuration configuration2 = new Configuration(configuration);
                    this.f125388d = configuration2;
                    configuration2.densityDpi = this.f125387c.densityDpi;
                    DisplayMetrics displayMetrics2 = this.f125386b.getDisplayMetrics();
                    super.updateConfiguration(this.f125388d, this.f125387c);
                    this.f125386b.updateConfiguration(configuration, displayMetrics2);
                    return;
                }
                super.updateConfiguration(configuration, displayMetrics);
                return;
            }
            if (this.f125387c == null || z16) {
                this.f125387c = e.this.a(displayMetrics, configuration);
                Configuration configuration3 = new Configuration(configuration);
                this.f125388d = configuration3;
                configuration3.densityDpi = this.f125387c.densityDpi;
            }
            super.updateConfiguration(this.f125388d, this.f125387c);
            this.f125386b.updateConfiguration(configuration, displayMetrics);
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public int getColor(int i3, Resources.Theme theme) {
            if (i3 == R.color.ajr) {
                w.f("ScreenAdaptiveContextThemeWrapper", "getColor: hack here! R.color.transparent -> Color.TRANSPARENT");
                return 0;
            }
            return super.getColor(i3, theme);
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public Drawable getDrawable(int i3, Resources.Theme theme) {
            DisplayMetrics displayMetrics = this.f125387c;
            if (displayMetrics != null) {
                return getDrawableForDensity(i3, displayMetrics.densityDpi, theme);
            }
            return a(this.f125386b.getDrawable(i3, theme));
        }

        @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
        public Drawable getDrawableForDensity(int i3, int i16, Resources.Theme theme) {
            DisplayMetrics displayMetrics;
            if (i16 == 0 && (displayMetrics = this.f125387c) != null) {
                i16 = displayMetrics.densityDpi;
            }
            return this.f125386b.getDrawableForDensity(i3, i16, theme);
        }
    }

    public final DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration) {
        return this.f125385c.a(displayMetrics, configuration);
    }
}

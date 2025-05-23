package com.tencent.tuxmeterqui.config;

import android.graphics.RectF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxQuestionConfig {
    static IPatchRedirector $redirector_;
    public TuxUIConfig uiConfig;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TuxUIConfig {
        static IPatchRedirector $redirector_;
        public int itemBgDrawableResId;
        public int itemNormalTextColor;
        public int itemSelectTextColor;
        public RectF padding;
        public int parentViewBackgroundColor;
        public int questionBackgroundColor;
        public int titleTextColor;
        public float titleTextSizeSp;
        public int titleTypeface;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes27.dex */
        public @interface TypefaceStyle {
        }

        public TuxUIConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.titleTextSizeSp = -1.0f;
            this.titleTextColor = -1;
            this.titleTypeface = 1;
            this.parentViewBackgroundColor = -1;
            this.itemNormalTextColor = -1;
            this.itemSelectTextColor = -1;
            this.itemBgDrawableResId = -1;
            this.questionBackgroundColor = -1;
        }
    }

    public TuxQuestionConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

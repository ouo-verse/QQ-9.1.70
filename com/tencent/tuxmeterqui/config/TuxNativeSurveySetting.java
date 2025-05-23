package com.tencent.tuxmeterqui.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxNativeSurveySetting implements Serializable {
    static IPatchRedirector $redirector_;
    private final boolean isDarkMode;
    private final boolean isFullScreen;
    private final Map<String, TuxQuestionConfig> questionConfigMap;
    private final TuxQuestionConfig viewQuestionConfig;
    private final TuxRect viewRect;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        private boolean isDarkMode;
        private boolean isFullScreen;
        private final Map<String, TuxQuestionConfig> questionConfigMap;
        private TuxQuestionConfig viewQuestionConfig;
        private TuxRect viewRect;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.isDarkMode = false;
            this.isFullScreen = true;
            this.questionConfigMap = new HashMap();
        }

        public Builder addQuestionConfig(String str, TuxQuestionConfig tuxQuestionConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) tuxQuestionConfig);
            }
            this.questionConfigMap.put(str, tuxQuestionConfig);
            return this;
        }

        public Builder addStarStarQuestionConfig(TuxQuestionConfig tuxQuestionConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) tuxQuestionConfig);
            }
            this.questionConfigMap.put(TuxQuestionType.QUESTION_STAR_STAR, tuxQuestionConfig);
            return this;
        }

        public TuxNativeSurveySetting build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (TuxNativeSurveySetting) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new TuxNativeSurveySetting(this, null);
        }

        public Builder isDarkMode(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.isDarkMode = z16;
            return this;
        }

        public Builder isFullScreen(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.isFullScreen = z16;
            return this;
        }

        public Builder setViewQuestionConfig(TuxQuestionConfig tuxQuestionConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) tuxQuestionConfig);
            }
            this.viewQuestionConfig = tuxQuestionConfig;
            return this;
        }

        public Builder viewRect(TuxRect tuxRect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tuxRect);
            }
            this.viewRect = tuxRect;
            return this;
        }
    }

    /* synthetic */ TuxNativeSurveySetting(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    public Map<String, TuxQuestionConfig> getQuestionConfigMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.questionConfigMap;
    }

    public TuxQuestionConfig getViewQuestionConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TuxQuestionConfig) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.viewQuestionConfig;
    }

    public TuxRect getViewRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TuxRect) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.viewRect;
    }

    public boolean isDarkMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isDarkMode;
    }

    public boolean isFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isFullScreen;
    }

    TuxNativeSurveySetting(@NonNull Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.isDarkMode = builder.isDarkMode;
        this.viewRect = builder.viewRect;
        this.isFullScreen = builder.isFullScreen;
        this.questionConfigMap = builder.questionConfigMap;
        this.viewQuestionConfig = builder.viewQuestionConfig;
    }
}

package com.tencent.mobileqq.qqlive.data.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes17.dex */
public class QQLiveRenderParams {
    static IPatchRedirector $redirector_ = null;
    public static final int RTC_VIDEO_RENDER_MODE_FILL = 0;
    public static final int RTC_VIDEO_RENDER_MODE_FIT = 1;
    private int mFillMode;

    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private QQLiveRenderParams renderParams;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.renderParams = new QQLiveRenderParams();
            }
        }

        public QQLiveRenderParams build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQLiveRenderParams) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.renderParams;
        }

        public Builder setFillMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.renderParams.mFillMode = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCRenderFillMode {
    }

    public QQLiveRenderParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public int getFillMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mFillMode;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "QQLiveRenderParams{mFillMode=" + this.mFillMode + '}';
    }
}

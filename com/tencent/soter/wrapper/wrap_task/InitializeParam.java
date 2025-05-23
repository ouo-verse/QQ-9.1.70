package com.tencent.soter.wrapper.wrap_task;

import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.ISoterLogger;
import com.tencent.soter.core.model.ISoterReporter;
import com.tencent.soter.wrapper.wrap_net.IWrapGetSupportNet;

/* loaded from: classes25.dex */
public class InitializeParam {
    static IPatchRedirector $redirector_;
    private String customAppSecureKeyName;
    private HandlerThread customTaskHandlerThread;
    private String distinguishSalt;
    private IWrapGetSupportNet getSupportNetWrapper;
    private ISoterLogger mSoterLogger;
    private ISoterReporter mSoterReporter;
    private int[] scenes;

    /* loaded from: classes25.dex */
    public static class InitializeParamBuilder {
        static IPatchRedirector $redirector_;
        private InitializeParam mInitializeParam;

        public InitializeParamBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mInitializeParam = new InitializeParam(null);
            }
        }

        public InitializeParam build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (InitializeParam) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.mInitializeParam;
        }

        public InitializeParamBuilder setCustomAppSecureKeyName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.mInitializeParam.customAppSecureKeyName = str;
                return this;
            }
            return (InitializeParamBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }

        public InitializeParamBuilder setDistinguishSalt(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.mInitializeParam.distinguishSalt = str;
                return this;
            }
            return (InitializeParamBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }

        public InitializeParamBuilder setGetSupportNetWrapper(IWrapGetSupportNet iWrapGetSupportNet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mInitializeParam.getSupportNetWrapper = iWrapGetSupportNet;
                return this;
            }
            return (InitializeParamBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iWrapGetSupportNet);
        }

        public InitializeParamBuilder setScenes(int... iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.mInitializeParam.scenes = iArr;
                return this;
            }
            return (InitializeParamBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr);
        }

        public InitializeParamBuilder setSoterLogger(ISoterLogger iSoterLogger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.mInitializeParam.mSoterLogger = iSoterLogger;
                return this;
            }
            return (InitializeParamBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) iSoterLogger);
        }

        public InitializeParamBuilder setSoterReporter(ISoterReporter iSoterReporter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.mInitializeParam.mSoterReporter = iSoterReporter;
                return this;
            }
            return (InitializeParamBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) iSoterReporter);
        }

        public InitializeParamBuilder setTaskHandlerThread(HandlerThread handlerThread) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                this.mInitializeParam.customTaskHandlerThread = handlerThread;
                return this;
            }
            return (InitializeParamBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) handlerThread);
        }
    }

    /* synthetic */ InitializeParam(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) anonymousClass1);
    }

    public String getCustomAppSecureKeyName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.customAppSecureKeyName;
    }

    public HandlerThread getCustomTaskHandlerThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.customTaskHandlerThread;
    }

    public String getDistinguishSalt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.distinguishSalt;
    }

    public IWrapGetSupportNet getGetSupportNetWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IWrapGetSupportNet) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.getSupportNetWrapper;
    }

    public int[] getScenes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.scenes;
    }

    public ISoterLogger getSoterLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ISoterLogger) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mSoterLogger;
    }

    public ISoterReporter getSoterReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ISoterReporter) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mSoterReporter;
    }

    InitializeParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.distinguishSalt = "";
        this.mSoterReporter = null;
        this.customAppSecureKeyName = "";
    }
}

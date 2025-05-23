package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.util.e;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LoadOptions implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int FLAG_CLOSE_REPORT = 32;
    public static final int FLAG_CLOSE_SYNC_LOAD_FAIL_RETRY = 16;
    public static final int FLAG_NO_NEED_CRC = 8;
    public static final int FLAG_NO_NEED_LOAD_SO = 1;
    public static final int FLAG_RETURN_SO_PATH = 2;
    public static final int FLAG_WEAK_RELATED = 4;
    public static LoadOptions sDefault;
    public int flag;
    public boolean isLoadLastSuccWhenFail;
    public String oldSoPathFor32Bit;
    public String oldSoPathFor64Bit;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class LoadOptionsBuilder {
        static IPatchRedirector $redirector_;
        private LoadOptions mLoadOptions;

        public LoadOptionsBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mLoadOptions = new LoadOptions();
            }
        }

        public LoadOptions build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (LoadOptions) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.mLoadOptions;
        }

        public LoadOptionsBuilder setCloseReport(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            if (z16) {
                this.mLoadOptions.flag |= 32;
            } else {
                this.mLoadOptions.flag &= -33;
            }
            return this;
        }

        public LoadOptionsBuilder setCloseRetry(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            if (z16) {
                this.mLoadOptions.flag |= 16;
            } else {
                this.mLoadOptions.flag &= -17;
            }
            return this;
        }

        @Deprecated
        public LoadOptionsBuilder setExtFlag(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            LoadOptions loadOptions = this.mLoadOptions;
            loadOptions.flag = i3 | loadOptions.flag;
            return this;
        }

        public LoadOptionsBuilder setIsLoadLastSuccWhenFail(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.mLoadOptions.isLoadLastSuccWhenFail = z16;
            return this;
        }

        public LoadOptionsBuilder setIsNoNeedCRC(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            if (z16) {
                this.mLoadOptions.flag |= 8;
            } else {
                this.mLoadOptions.flag &= -9;
            }
            return this;
        }

        public LoadOptionsBuilder setIsNoNeedLoad(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            if (z16) {
                this.mLoadOptions.flag |= 1;
            } else {
                this.mLoadOptions.flag &= -2;
            }
            return this;
        }

        public LoadOptionsBuilder setOldSoPathFor32Bit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.mLoadOptions.oldSoPathFor32Bit = str;
            return this;
        }

        public LoadOptionsBuilder setOldSoPathFor64Bit(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.mLoadOptions.oldSoPathFor64Bit = str;
            return this;
        }

        public LoadOptionsBuilder setWeakRelated(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (LoadOptionsBuilder) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            if (z16) {
                this.mLoadOptions.flag |= 4;
            } else {
                this.mLoadOptions.flag &= -5;
            }
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            sDefault = new LoadOptionsBuilder().build();
        }
    }

    public LoadOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isLoadLastSuccWhenFail = false;
            this.flag = 0;
        }
    }

    public String getOldSoPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (e.d()) {
            return this.oldSoPathFor64Bit;
        }
        return this.oldSoPathFor32Bit;
    }

    public boolean isSame(LoadOptions loadOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) loadOptions)).booleanValue();
        }
        if (loadOptions == null || this.isLoadLastSuccWhenFail != loadOptions.isLoadLastSuccWhenFail || !e.f(this.oldSoPathFor32Bit, loadOptions.oldSoPathFor32Bit) || !e.f(this.oldSoPathFor64Bit, loadOptions.oldSoPathFor64Bit) || this.flag != loadOptions.flag) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "LoadOptions{isLLSl=" + this.isLoadLastSuccWhenFail + ", old32Bit='" + this.oldSoPathFor32Bit + "', old64Bit='" + this.oldSoPathFor64Bit + "', flag=" + this.flag + '}';
    }
}

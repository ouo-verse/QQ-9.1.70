package com.tencent.soter.wrapper.wrap_core;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterDataCenter {
    static IPatchRedirector $redirector_ = null;
    public static final int SUPPORT_ALL = 3;
    public static final int SUPPORT_FACEID = 2;
    public static final int SUPPORT_FINGERPRINT = 1;
    public static final int SUPPORT_NOSUPPORT = 0;
    public static final int SUPPORT_UNDEFINED = -1;
    private static volatile SoterDataCenter sInstance;
    private boolean isInit;
    private boolean isSupportSoter;
    private SparseArray<String> sAuthKeyNames;
    private SharedPreferences sStatusSharedPreference;
    private int supportType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17250);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            sInstance = null;
        }
    }

    public SoterDataCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isInit = false;
        this.isSupportSoter = false;
        this.supportType = 0;
        this.sAuthKeyNames = new SparseArray<>(10);
        this.sStatusSharedPreference = null;
    }

    public static SoterDataCenter getInstance() {
        SoterDataCenter soterDataCenter;
        if (sInstance == null) {
            synchronized (SoterDataCenter.class) {
                if (sInstance == null) {
                    sInstance = new SoterDataCenter();
                }
                soterDataCenter = sInstance;
            }
            return soterDataCenter;
        }
        return sInstance;
    }

    public void clearStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        synchronized (SoterDataCenter.class) {
            this.isInit = false;
            this.isSupportSoter = false;
            this.sAuthKeyNames = new SparseArray<>(10);
            this.sStatusSharedPreference = null;
        }
    }

    public SparseArray<String> getAuthKeyNames() {
        SparseArray<String> sparseArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SparseArray) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        synchronized (SoterDataCenter.class) {
            sparseArray = this.sAuthKeyNames;
        }
        return sparseArray;
    }

    public SharedPreferences getStatusSharedPreference() {
        SharedPreferences sharedPreferences;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        synchronized (SoterDataCenter.class) {
            sharedPreferences = this.sStatusSharedPreference;
        }
        return sharedPreferences;
    }

    public int getSupportType() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        synchronized (SoterDataCenter.class) {
            i3 = this.supportType;
        }
        return i3;
    }

    public boolean isInit() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        synchronized (SoterDataCenter.class) {
            z16 = this.isInit;
        }
        return z16;
    }

    public boolean isSupportSoter() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        synchronized (SoterDataCenter.class) {
            z16 = this.isSupportSoter;
        }
        return z16;
    }

    public void setInit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            synchronized (SoterDataCenter.class) {
                this.isInit = z16;
            }
        }
    }

    public void setStatusSharedPreference(SharedPreferences sharedPreferences) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) sharedPreferences);
        } else {
            synchronized (SoterDataCenter.class) {
                this.sStatusSharedPreference = sharedPreferences;
            }
        }
    }

    public void setSupportSoter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            synchronized (SoterDataCenter.class) {
                this.isSupportSoter = z16;
            }
        }
    }

    public void setSupportType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.supportType = i3;
        }
    }
}

package com.tencent.mobileqq.unusedcodecheck;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.Serializable;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LoadedClassInfoObject implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 4092064066694163023L;
    private int allClassCount;
    private int checkCount;

    /* renamed from: d, reason: collision with root package name */
    private transient int f306089d;
    private String firstClassName;
    private String hashResult;
    private String lastClassName;
    private BitSet marker;
    private int partClassCount;
    transient File srcFile;

    public LoadedClassInfoObject(BitSet bitSet, int i3, int i16, String str, String str2, int i17, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bitSet, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, Integer.valueOf(i17), str3);
            return;
        }
        this.allClassCount = i3;
        this.marker = bitSet;
        this.partClassCount = i16;
        this.firstClassName = str;
        this.lastClassName = str2;
        this.checkCount = i17;
        this.hashResult = str3;
    }

    public boolean addIndexAndCheckClassIsLoaded() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        BitSet bitSet = this.marker;
        if (bitSet != null) {
            z16 = bitSet.get(this.f306089d);
        } else {
            z16 = false;
        }
        this.f306089d++;
        return z16;
    }

    public boolean checkConsistency(LoadedClassInfoObject loadedClassInfoObject) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) loadedClassInfoObject)).booleanValue();
        }
        if (this.allClassCount != loadedClassInfoObject.allClassCount || this.partClassCount != loadedClassInfoObject.partClassCount || !this.firstClassName.equals(loadedClassInfoObject.firstClassName) || !this.lastClassName.equals(loadedClassInfoObject.lastClassName)) {
            return false;
        }
        String str2 = this.hashResult;
        if (str2 != null && (str = loadedClassInfoObject.hashResult) != null && !str2.equals(str)) {
            return false;
        }
        return true;
    }

    public int getAllClassCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.allClassCount;
    }

    public int getCheckCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.checkCount;
    }

    public String getFirstClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.firstClassName;
    }

    public String getHashResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.hashResult;
    }

    public String getInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "LoadedClassInfoObject{loadClassCount=" + this.marker.cardinality() + ", partClassCount=" + this.partClassCount + ", allClassCount=" + this.allClassCount + ", firstClassName='" + this.firstClassName + "', lastClassName='" + this.lastClassName + "', checkCount=" + this.checkCount + ", hashResult=" + this.hashResult + '}';
    }

    public String getLastClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.lastClassName;
    }

    public BitSet getMarker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BitSet) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.marker;
    }

    public int getPartClassCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.partClassCount;
    }

    public void setAllClassCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.allClassCount = i3;
        }
    }

    public void setCheckCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.checkCount = i3;
        }
    }

    public void setFirstClassName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.firstClassName = str;
        }
    }

    public void setHashResult(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.hashResult = str;
        }
    }

    public void setLastClassName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.lastClassName = str;
        }
    }

    public void setMarker(BitSet bitSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitSet);
        } else {
            this.marker = bitSet;
        }
    }

    public void setPartClassCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.partClassCount = i3;
        }
    }
}

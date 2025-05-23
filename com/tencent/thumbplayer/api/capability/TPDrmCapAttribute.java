package com.tencent.thumbplayer.api.capability;

import java.io.Serializable;

/* loaded from: classes26.dex */
public class TPDrmCapAttribute implements Serializable {
    private static final long serialVersionUID = 1000000;
    private int mDrmType = -1;
    private int mMaxNumberOfSessions;
    private String mSecurityLevel;
    private int mSupportCryptoSchemeTypes;

    public int getDrmType() {
        return this.mDrmType;
    }

    public int getMaxNumberOfSessions() {
        return this.mMaxNumberOfSessions;
    }

    public String getSecurityLevel() {
        return this.mSecurityLevel;
    }

    public int getSupportCryptoSchemeTypes() {
        return this.mSupportCryptoSchemeTypes;
    }

    public void setDrmType(int i3) {
        this.mDrmType = i3;
    }

    public void setMaxNumberOfSessions(int i3) {
        this.mMaxNumberOfSessions = i3;
    }

    public void setSecurityLevel(String str) {
        this.mSecurityLevel = str;
    }

    public void setSupportCryptoSchemeTypes(int i3) {
        this.mSupportCryptoSchemeTypes = i3;
    }

    public String toString() {
        return "TPDrmCapAttribute{drmType=" + this.mDrmType + ", supportCryptoSchemeTypes=" + this.mSupportCryptoSchemeTypes + ", securityLevel='" + this.mSecurityLevel + "', maxNumberOfSessions=" + this.mMaxNumberOfSessions + '}';
    }
}

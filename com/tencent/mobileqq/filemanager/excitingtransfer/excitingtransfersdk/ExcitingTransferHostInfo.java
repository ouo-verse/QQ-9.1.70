package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferHostInfo {
    public boolean mIsHttps;
    public final boolean mbInvaild;
    public final int mport;
    public final String mstrIp;

    public ExcitingTransferHostInfo() {
        this.mstrIp = null;
        this.mport = 0;
        this.mbInvaild = true;
    }

    public String toString() {
        if (this.mstrIp != null) {
            return this.mstrIp + ":" + this.mport + " - " + this.mbInvaild;
        }
        return ":" + this.mport + " - " + this.mbInvaild;
    }

    public ExcitingTransferHostInfo(String str, int i3) {
        this.mstrIp = str;
        this.mport = i3;
        if (TextUtils.isEmpty(str)) {
            this.mbInvaild = true;
        } else {
            this.mbInvaild = false;
        }
    }

    public ExcitingTransferHostInfo(String str, int i3, boolean z16) {
        this(str, i3);
        this.mIsHttps = z16;
    }
}

package com.tencent.mobileqq.vas.config.business.qvip;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
@Keep
/* loaded from: classes20.dex */
public class QVipWatchWordConfig implements Serializable {
    private boolean enable = true;
    private ArrayList<String> watchUrl = new ArrayList<>();
    private ArrayList<String> pattern = new ArrayList<>();

    public ArrayList<String> getPattern() {
        return this.pattern;
    }

    public ArrayList<String> getWatchUrl() {
        return this.watchUrl;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z16) {
        this.enable = z16;
    }

    public void setPattern(ArrayList<String> arrayList) {
        this.pattern = arrayList;
    }

    public void setWatchUrl(ArrayList<String> arrayList) {
        this.watchUrl = arrayList;
    }
}

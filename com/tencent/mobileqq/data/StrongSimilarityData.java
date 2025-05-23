package com.tencent.mobileqq.data;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StrongSimilarityData {
    public String content;
    public String icon;
    public int timeThread = 1440;
    public int displayDuration = 15;
    public int delayDisplayTime = 5;

    public StrongSimilarityData(String str, String str2) {
        this.icon = str;
        this.content = str2;
    }

    public StrongSimilarityData setDelayDisplayTime(int i3) {
        this.delayDisplayTime = i3;
        return this;
    }

    public StrongSimilarityData setDisplayDuration(int i3) {
        this.displayDuration = i3;
        return this;
    }

    public StrongSimilarityData setTimeThread(int i3) {
        this.timeThread = i3;
        return this;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nicon=");
        String str2 = "null";
        if (TextUtils.isEmpty(this.icon)) {
            str = "null";
        } else {
            str = this.icon;
        }
        sb5.append(str);
        sb5.append("\ncontent=");
        if (!TextUtils.isEmpty(this.content)) {
            str2 = this.content;
        }
        sb5.append(str2);
        sb5.append("\ntimeThread=");
        sb5.append(this.timeThread);
        sb5.append("\ndisplayDuration=");
        sb5.append(this.displayDuration);
        sb5.append("\ndelayDisplayTime=");
        sb5.append(this.delayDisplayTime);
        return sb5.toString();
    }
}

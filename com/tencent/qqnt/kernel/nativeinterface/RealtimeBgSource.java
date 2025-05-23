package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RealtimeBgSource {
    public int sceneType;
    public String sourceType = "";
    public String url = "";

    public int getSceneType() {
        return this.sceneType;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "RealtimeBgSource{sceneType=" + this.sceneType + ",sourceType=" + this.sourceType + JefsClass.INDEX_URL + this.url + ",}";
    }
}

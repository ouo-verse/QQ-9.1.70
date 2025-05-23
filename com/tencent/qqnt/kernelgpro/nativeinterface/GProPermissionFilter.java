package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPermissionFilter {
    public boolean activity;
    public boolean edit;
    public boolean live;
    public boolean speak;
    public boolean speakRule;
    public boolean visible;

    public boolean getActivity() {
        return this.activity;
    }

    public boolean getEdit() {
        return this.edit;
    }

    public boolean getLive() {
        return this.live;
    }

    public boolean getSpeak() {
        return this.speak;
    }

    public boolean getSpeakRule() {
        return this.speakRule;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public String toString() {
        return "GProPermissionFilter{speak=" + this.speak + ",visible=" + this.visible + ",live=" + this.live + ",speakRule=" + this.speakRule + ",activity=" + this.activity + ",edit=" + this.edit + ",}";
    }
}

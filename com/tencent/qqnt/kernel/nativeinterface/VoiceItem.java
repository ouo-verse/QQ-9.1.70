package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class VoiceItem implements Serializable {
    long serialVersionUID = 1;
    public String voiceId = "";
    public String displayName = "";
    public String exampleUrl = "";

    public String getDisplayName() {
        return this.displayName;
    }

    public String getExampleUrl() {
        return this.exampleUrl;
    }

    public String getVoiceId() {
        return this.voiceId;
    }

    public String toString() {
        return "VoiceItem{voiceId=" + this.voiceId + ",displayName=" + this.displayName + ",exampleUrl=" + this.exampleUrl + ",}";
    }
}

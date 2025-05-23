package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AIGCEmojiListInfo {
    public boolean generating;
    public int source;
    public long timestamp;
    public ArrayList<AIGCEmoji> emojis = new ArrayList<>();
    public byte[] pageSession = new byte[0];
    public String templateSchema = "";

    public ArrayList<AIGCEmoji> getEmojis() {
        return this.emojis;
    }

    public boolean getGenerating() {
        return this.generating;
    }

    public byte[] getPageSession() {
        return this.pageSession;
    }

    public int getSource() {
        return this.source;
    }

    public String getTemplateSchema() {
        return this.templateSchema;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "AIGCEmojiListInfo{emojis=" + this.emojis + ",pageSession=" + this.pageSession + ",timestamp=" + this.timestamp + ",generating=" + this.generating + ",templateSchema=" + this.templateSchema + ",source=" + this.source + ",}";
    }
}

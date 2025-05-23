package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAddGuildWithOptionReq {
    public ArrayList<GProJoinGuildAnswerItem> answers;
    public String comment;
    public long guildId;
    public String sig;
    public GProSourceId sourceId;

    public GProAddGuildWithOptionReq() {
        this.sourceId = new GProSourceId();
        this.sig = "";
        this.comment = "";
        this.answers = new ArrayList<>();
    }

    public ArrayList<GProJoinGuildAnswerItem> getAnswers() {
        return this.answers;
    }

    public String getComment() {
        return this.comment;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getSig() {
        return this.sig;
    }

    public GProSourceId getSourceId() {
        return this.sourceId;
    }

    public String toString() {
        return "GProAddGuildWithOptionReq{guildId=" + this.guildId + ",sourceId=" + this.sourceId + ",sig=" + this.sig + ",comment=" + this.comment + ",answers=" + this.answers + ",}";
    }

    public GProAddGuildWithOptionReq(long j3, GProSourceId gProSourceId, String str, String str2, ArrayList<GProJoinGuildAnswerItem> arrayList) {
        this.sourceId = new GProSourceId();
        this.sig = "";
        this.comment = "";
        new ArrayList();
        this.guildId = j3;
        this.sourceId = gProSourceId;
        this.sig = str;
        this.comment = str2;
        this.answers = arrayList;
    }
}

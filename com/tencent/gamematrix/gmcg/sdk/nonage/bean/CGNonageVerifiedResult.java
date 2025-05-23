package com.tencent.gamematrix.gmcg.sdk.nonage.bean;

import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNonageVerifiedResult {
    public static final int INSTRUCTION_LOGOUT = 2;
    public static final int INSTRUCTION_OPEN_URL = 3;
    public static final int INSTRUCTION_TIPS = 1;
    private String context;
    private String duration;
    private List<Instruction> instructions;
    private String ret;
    private String traceId;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Instruction {
        public String data;
        public int modal;

        /* renamed from: msg, reason: collision with root package name */
        public String f107886msg;
        public String ruleName;
        public String title;
        public int type;
        public String url;

        public String toString() {
            return "type = " + this.type + " title = " + this.title + " msg = " + this.f107886msg + " url = " + this.url;
        }
    }

    public String getContext() {
        return this.context;
    }

    public String getDuration() {
        return this.duration;
    }

    public List<Instruction> getInstructions() {
        return this.instructions;
    }

    public String getRet() {
        return this.ret;
    }

    public String getTraceId() {
        return this.traceId;
    }
}

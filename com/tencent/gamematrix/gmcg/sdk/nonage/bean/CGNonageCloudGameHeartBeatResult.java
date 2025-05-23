package com.tencent.gamematrix.gmcg.sdk.nonage.bean;

import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageVerifiedResult;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNonageCloudGameHeartBeatResult {
    private int duration;
    private List<CGNonageVerifiedResult.Instruction> instructions;
    private int interval = 300;

    /* renamed from: msg, reason: collision with root package name */
    private String f107885msg;
    private int ret;
    private String traceId;

    public int getDuration() {
        return this.duration;
    }

    public List<CGNonageVerifiedResult.Instruction> getInstructions() {
        return this.instructions;
    }

    public int getInterval() {
        return this.interval;
    }

    @Nullable
    public CGNonageVerifiedResult.Instruction getLogoutInstruction() {
        List<CGNonageVerifiedResult.Instruction> list = this.instructions;
        if (list != null) {
            for (CGNonageVerifiedResult.Instruction instruction : list) {
                if (instruction.type == 2) {
                    return instruction;
                }
            }
            return null;
        }
        return null;
    }

    public String getMsg() {
        return this.f107885msg;
    }

    public int getRet() {
        return this.ret;
    }

    @Nullable
    public CGNonageVerifiedResult.Instruction getTipsInstruction() {
        List<CGNonageVerifiedResult.Instruction> list = this.instructions;
        if (list != null) {
            for (CGNonageVerifiedResult.Instruction instruction : list) {
                if (instruction.type == 1) {
                    return instruction;
                }
            }
            return null;
        }
        return null;
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Nullable
    public CGNonageVerifiedResult.Instruction getUrlInstruction() {
        List<CGNonageVerifiedResult.Instruction> list = this.instructions;
        if (list != null) {
            for (CGNonageVerifiedResult.Instruction instruction : list) {
                if (instruction.type == 3) {
                    return instruction;
                }
            }
            return null;
        }
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("duration: ");
        stringBuffer.append(this.duration);
        stringBuffer.append(" interval: ");
        stringBuffer.append(this.interval);
        stringBuffer.append(" msg: ");
        stringBuffer.append(this.f107885msg);
        stringBuffer.append(" traceId: ");
        stringBuffer.append(this.traceId);
        List<CGNonageVerifiedResult.Instruction> list = this.instructions;
        if (list != null) {
            Iterator<CGNonageVerifiedResult.Instruction> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString());
            }
        }
        return stringBuffer.toString();
    }
}

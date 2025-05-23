package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;

/* loaded from: classes27.dex */
public class NumberRollEffectParams {
    public int activateTriggerCount;
    public int activateTriggerTotalCount;
    public int activateTriggerType;
    public boolean alwaysTriggered;
    public int countTriggerType;

    /* renamed from: id, reason: collision with root package name */
    public String f381701id;
    public int playCount;
    public ArrayList<String> triggerState;
    private String triggerType;
    public String numberImageFile = "";
    public int materialImageWidth = 0;
    public int materialImageHeight = 0;
    public ArrayList<NumberRollItem> numberRollItems = null;

    public int getTriggerTypeInt() {
        try {
            return Integer.parseInt(this.triggerType);
        } catch (NumberFormatException unused) {
            return PTFaceAttr.PTExpression.FACE_DETECT.value;
        }
    }

    public String getTriggerTypeString() {
        return this.triggerType;
    }

    public void setTriggerType(String str) {
        this.triggerType = str;
    }
}

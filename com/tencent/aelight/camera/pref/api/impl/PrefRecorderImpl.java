package com.tencent.aelight.camera.pref.api.impl;

import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import java.util.ArrayList;
import mq.a;

/* loaded from: classes32.dex */
public class PrefRecorderImpl implements IPrefRecorder {
    @Override // com.tencent.aelight.camera.pref.api.IPrefRecorder
    public void clearTimeEvent(String str) {
        a.d().a(str);
    }

    @Override // com.tencent.aelight.camera.pref.api.IPrefRecorder
    public long getTimeCost(String str) {
        return a.d().g(str);
    }

    @Override // com.tencent.aelight.camera.pref.api.IPrefRecorder
    public ArrayList<Long> getTimeCostRange(String str, int... iArr) {
        return a.d().i(str, iArr);
    }

    @Override // com.tencent.aelight.camera.pref.api.IPrefRecorder
    public void milestone(String str) {
        a.d().j(str);
    }

    @Override // com.tencent.aelight.camera.pref.api.IPrefRecorder
    public void milestoneEnd(String str) {
        a.d().k(str);
    }

    @Override // com.tencent.aelight.camera.pref.api.IPrefRecorder
    public long getTimeCost(String str, int i3) {
        return a.d().h(str, i3);
    }

    @Override // com.tencent.aelight.camera.pref.api.IPrefRecorder
    public void milestoneEnd(String str, long j3) {
        a.d().l(str, j3);
    }
}

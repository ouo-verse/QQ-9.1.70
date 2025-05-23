package com.tencent.aelight.camera.util.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.a;
import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AIOShortVideoUtilImpl implements IAIOShortVideoUtil {
    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public long getBaseActivtiyCreateTime() {
        return a.f66324d;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public long getBaseActivtiyResumeTime() {
        return a.f66326f;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public long getBaseActivtiyStartTime() {
        return a.f66325e;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public long getClickCameraTime() {
        return a.f66322b;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public int getEntranceType(int i3) {
        return a.a(i3);
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public long getPeakLoadTime() {
        return a.f66321a;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public long getStartActivityTime() {
        return a.f66323c;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public void setBaseActivtiyCreateTime(long j3) {
        a.f66324d = j3;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public void setBaseActivtiyResumeTime(long j3) {
        a.f66326f = j3;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public void setBaseActivtiyStartTime(long j3) {
        a.f66325e = j3;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public void setClickCameraTime(long j3) {
        a.f66322b = j3;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public void setPeakLoadTime(long j3) {
        a.f66321a = j3;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public void setStartActivtiyTime(long j3) {
        a.f66323c = j3;
    }

    @Override // com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
    public void handleSysCameraResult(AppInterface appInterface, Activity activity, Intent intent, Object obj, int i3, int i16) {
        a.b((QQAppInterface) appInterface, activity, intent, (SessionInfo) obj, i3, i16);
    }
}

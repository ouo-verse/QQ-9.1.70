package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQTeenModeApi;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQTeenModeApiImpl implements IQQTeenModeApi {
    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQTeenModeApi
    public void jumpToTeenModePage(Context context) {
        if (context instanceof Activity) {
            JumpKidModeMgr.b().t((Activity) context, 8);
        }
    }
}

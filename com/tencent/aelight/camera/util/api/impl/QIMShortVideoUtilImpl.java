package com.tencent.aelight.camera.util.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aebase.QIMShortVideoUtils;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMShortVideoUtilImpl implements IQIMShortVideoUtil {
    @Override // com.tencent.aelight.camera.util.api.IQIMShortVideoUtil
    public boolean isPeakAlive(Context context) {
        return QIMShortVideoUtils.a(context);
    }

    @Override // com.tencent.aelight.camera.util.api.IQIMShortVideoUtil
    public void preLoadPeakProcess(Context context) {
        QIMShortVideoUtils.b(context);
    }

    @Override // com.tencent.aelight.camera.util.api.IQIMShortVideoUtil
    public void preLoadPeakProcess(Context context, String str) {
        QIMShortVideoUtils.d(context, str);
    }

    @Override // com.tencent.aelight.camera.util.api.IQIMShortVideoUtil
    public void preLoadPeakProcess(Context context, Runnable runnable, String str) {
        QIMShortVideoUtils.c(context, runnable, str);
    }
}

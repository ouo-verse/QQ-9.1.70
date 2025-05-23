package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.IToastUtil;
import cooperation.qqcircle.utils.ToastUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ToastUtilImpl implements IToastUtil {
    @Override // com.tencent.mobileqq.qcircle.api.IToastUtil
    public void determineShowByCode(long j3, Context context, int i3, String str, int i16) {
        ToastUtil.determineShowByCode(j3, context, i3, str, i16);
    }
}

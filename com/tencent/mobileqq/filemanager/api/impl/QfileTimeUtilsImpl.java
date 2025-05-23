package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IQfileTimeUtils;
import com.tencent.mobileqq.filemanager.util.al;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileTimeUtilsImpl implements IQfileTimeUtils {
    @Override // com.tencent.mobileqq.filemanager.api.IQfileTimeUtils
    public String formatNewRefreshTime(long j3) {
        return al.a(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQfileTimeUtils
    public String getHistoryGroupByTime(long j3) {
        return al.c(j3);
    }
}

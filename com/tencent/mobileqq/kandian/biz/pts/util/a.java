package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements LogUtil.ProteusLog {
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void d(String str, int i3, String str2) {
        QLog.d(str, i3, str2);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void e(String str, int i3, String str2) {
        QLog.e(str, i3, str2);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void i(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void w(String str, int i3, String str2) {
        QLog.w(str, i3, str2);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void d(String str, int i3, String str2, Throwable th5) {
        QLog.d(str, i3, str2, th5);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void e(String str, int i3, String str2, Throwable th5) {
        QLog.e(str, i3, str2, th5);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void i(String str, int i3, String str2, Throwable th5) {
        QLog.i(str, i3, str2, th5);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog
    public void w(String str, int i3, String str2, Throwable th5) {
        QLog.w(str, i3, str2, th5);
    }
}

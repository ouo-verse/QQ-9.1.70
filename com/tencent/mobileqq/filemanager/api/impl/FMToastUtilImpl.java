package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IFMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFMToastUtil;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMToastUtilImpl implements IFMToastUtil {
    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toast(int i3, int i16) {
        QQFMToastUtil.d(i3, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastCommon(int i3, String str, int i16) {
        QQFMToastUtil.f(i3, str, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastDefault(String str) {
        QQFMToastUtil.h(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastError(int i3) {
        QQFMToastUtil.i(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastNone(int i3) {
        QQFMToastUtil.k(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastSuc(int i3) {
        QQFMToastUtil.l(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastSucLong(String str) {
        QQFMToastUtil.n(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toast(Context context, int i3, int i16) {
        QQFMToastUtil.e(context, i3, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastDefault(int i3) {
        QQFMToastUtil.g(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastError(String str) {
        QQFMToastUtil.j(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMToastUtil
    public void toastSuc(String str) {
        QQFMToastUtil.m(str);
    }
}

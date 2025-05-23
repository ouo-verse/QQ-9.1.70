package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleKaDunOptApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleKaDunOptApiImpl implements IQCircleKaDunOptApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleKaDunOptApi
    public String getQCircleExtParams() {
        String str;
        String str2;
        if (h20.c.f()) {
            str = "1";
        } else {
            str = "0";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str3 = ";1";
        if (h20.c.e()) {
            str2 = ";1";
        } else {
            str2 = ";0";
        }
        sb5.append(str2);
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        if (!h20.c.d()) {
            str3 = ";0";
        }
        sb7.append(str3);
        return sb7.toString();
    }
}

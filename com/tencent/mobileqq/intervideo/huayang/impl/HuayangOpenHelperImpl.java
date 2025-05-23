package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HuayangOpenHelperImpl implements IHuayangOpenHelper {
    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper
    public void doKillProcess(Context context, String str) {
        HuayangOpenHelper.a(context, str);
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper
    public void killProcess(Context context, String str) {
        HuayangOpenHelper.b(context, str);
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper
    public void open(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HuayangOpenHelper.c((QQAppInterface) appInterface, str, str2, str3, str4, str5, str6, str7);
    }
}

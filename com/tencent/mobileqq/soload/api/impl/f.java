package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface f {
    void a(LoadParam loadParam, OnLoadListener onLoadListener);

    void b(String str);

    LoadExtResult c(LoadParam loadParam);

    boolean d(String str);
}

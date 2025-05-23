package com.tencent.mobileqq.intervideo.impl;

import android.content.Context;
import com.tencent.mobileqq.intervideo.IBaseApplicationImplUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BaseApplicationImplUtilImpl implements IBaseApplicationImplUtil {
    @Override // com.tencent.mobileqq.intervideo.IBaseApplicationImplUtil
    public Context getContext() {
        return BaseApplication.getContext();
    }
}

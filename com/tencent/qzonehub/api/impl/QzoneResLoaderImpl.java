package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneResLoader;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneResLoaderImpl implements IQzoneResLoader {
    @Override // com.tencent.qzonehub.api.IQzoneResLoader
    public String getString(String str) {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return "";
        }
        return context.getString(getStringId(str));
    }

    @Override // com.tencent.qzonehub.api.IQzoneResLoader
    public int getStringId(int i3) {
        if (i3 == 2) {
            return R.string.f172153nw1;
        }
        if (i3 == 3) {
            return R.string.f172154nw2;
        }
        if (i3 == 4) {
            return R.string.rsx;
        }
        if (i3 != 5) {
            return -1;
        }
        return R.string.rsu;
    }

    @Override // com.tencent.qzonehub.api.IQzoneResLoader
    public int getStringId(String str) {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return -1;
        }
        return context.getResources().getIdentifier(str, HippyControllerProps.STRING, context.getPackageName());
    }
}

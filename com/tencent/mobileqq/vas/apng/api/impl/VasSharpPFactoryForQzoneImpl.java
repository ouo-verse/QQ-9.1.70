package com.tencent.mobileqq.vas.apng.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.IVasSharpPFactory;
import com.tencent.mobileqq.vas.apng.api.IVasSharpPFactoryForQzone;
import com.tencent.mobileqq.vas.apng.api.SharpPOptions;

/* loaded from: classes20.dex */
public class VasSharpPFactoryForQzoneImpl implements IVasSharpPFactoryForQzone {
    @Override // com.tencent.mobileqq.vas.apng.api.IVasSharpPFactoryForQzone
    public Drawable getSharpPURLDrawable(String str, String str2) {
        return ((IVasSharpPFactory) QRoute.api(IVasSharpPFactory.class)).getSharpPURLDrawable(str, new SharpPOptions(), str2);
    }
}

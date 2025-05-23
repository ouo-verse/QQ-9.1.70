package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.wink.api.IClipService;
import com.tencent.mobileqq.wink.api.IClipServiceFactory;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ClipServiceFactoryImpl implements IClipServiceFactory {
    public static final String TAG = "ClipServiceFactory";
    private static IClipService.a instance = new ClipServiceBinder();

    @Override // com.tencent.mobileqq.wink.api.IClipServiceFactory
    public IClipService.a getClipService() {
        return instance;
    }
}

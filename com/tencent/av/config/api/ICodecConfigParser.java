package com.tencent.av.config.api;

import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICodecConfigParser extends QRouteApi {
    public static final int VERSION_1 = 1;
    public static final int VERSION_2 = 2;

    HWCodecAbility getAVCDecoderAbility();

    HWCodecAbility getAVCEncoderAbility();

    HWCodecAbility getHevcDecoderAbility();

    HWCodecAbility getHevcEncoderAbility();

    void init(IConfigParser iConfigParser);

    boolean isEnableAsyncApi(int i3);
}

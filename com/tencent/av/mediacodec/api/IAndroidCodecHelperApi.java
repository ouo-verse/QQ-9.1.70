package com.tencent.av.mediacodec.api;

import android.content.Context;
import com.tencent.avcore.jni.codec.AndroidCodecStatusCallback;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAndroidCodecHelperApi extends QRouteApi, AndroidCodecStatusCallback {
    ArrayList<HWCodecAbility> checkSupportHWCodecAbility(String str, Context context);

    int getHwDetectOutputFormatForReport();

    boolean isSupportHwCodec1080PFeature();
}

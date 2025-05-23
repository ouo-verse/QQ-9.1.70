package com.tencent.mobileqq.shortvideo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IVideoTrimmer extends QRouteApi {
    VideoConverterConfig getCompressConfig(String str);
}

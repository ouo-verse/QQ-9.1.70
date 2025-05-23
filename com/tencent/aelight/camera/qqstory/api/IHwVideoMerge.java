package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IHwVideoMerge extends QRouteApi {
    boolean ffmpegMergeMultiVideo(List<String> list, String str, int i3);
}

package com.tencent.aelight.camera.api;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEEditorProcess extends QRouteApi {
    void clean();

    boolean isGenerateWorking();

    void preloadQQSysEmojiApng();

    void requestGenerateVideo(@Nullable String str);
}

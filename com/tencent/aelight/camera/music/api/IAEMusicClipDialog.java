package com.tencent.aelight.camera.music.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEMusicClipDialog extends QRouteApi {
    void setIsQCircle(boolean z16);

    void showMusicClipDialogOnWebView(JSONObject jSONObject, Context context);

    void showMusicSelectLoadingOnWebView(JSONObject jSONObject, Context context);
}

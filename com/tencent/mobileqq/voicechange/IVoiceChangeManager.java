package com.tencent.mobileqq.voicechange;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVoiceChangeManager extends QRouteApi {
    String getTagIconURL(int i3);

    String getVoiceChangeRootDir();

    boolean isVoiceChangeFinished(String str);

    boolean preCheckData(ArrayList<c> arrayList, JSONObject jSONObject, AppRuntime appRuntime);

    boolean queryStateByPath(String str, IVoiceChangeHelper.a aVar);

    void requestToCancel(b bVar);

    void requestToPause(b bVar);

    void requestToSend(Context context, b bVar, String str, a aVar);

    void requestToSend(Context context, b bVar, String str, a aVar, IVoiceChangeHelper.a aVar2);

    void requestToStart(Context context, b bVar, String str, a aVar);

    void requestToStart(Context context, b bVar, String str, a aVar, d dVar);

    void voiceChangeEnd(int i3, String str, String str2, int i16, int i17);
}

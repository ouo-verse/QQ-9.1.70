package com.tencent.qzonehub.api.music;

import android.os.Parcelable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneMusicHelper extends QRouteApi {
    Parcelable convertSongInfo(JSONObject jSONObject);

    long getFMID(String str);

    long getSongIDWithMid(String str);
}

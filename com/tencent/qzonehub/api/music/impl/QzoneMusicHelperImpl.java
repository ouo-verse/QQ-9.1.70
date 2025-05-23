package com.tencent.qzonehub.api.music.impl;

import android.os.Parcelable;
import com.tencent.qzonehub.api.music.IQzoneMusicHelper;
import cooperation.qzone.music.QzoneMusicHelper;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneMusicHelperImpl implements IQzoneMusicHelper {
    @Override // com.tencent.qzonehub.api.music.IQzoneMusicHelper
    public Parcelable convertSongInfo(JSONObject jSONObject) {
        return QzoneMusicHelper.convertSongInfo(jSONObject);
    }

    @Override // com.tencent.qzonehub.api.music.IQzoneMusicHelper
    public long getFMID(String str) {
        return QzoneMusicHelper.getFMID(str);
    }

    @Override // com.tencent.qzonehub.api.music.IQzoneMusicHelper
    public long getSongIDWithMid(String str) {
        return QzoneMusicHelper.getSongIDWithMid(str);
    }
}

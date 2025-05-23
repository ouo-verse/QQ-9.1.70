package com.tencent.icgame.game.liveroom.impl.room.util;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.api.room.PreloadSuperPlayerParams;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final IAegisLogApi f115697a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public static PreloadSuperPlayerParams a(int i3, boolean z16, String str, LiveRoomExtraInfo liveRoomExtraInfo) {
        PreloadSuperPlayerParams preloadSuperPlayerParams = new PreloadSuperPlayerParams();
        preloadSuperPlayerParams.playerXYAxis = i3;
        preloadSuperPlayerParams.useTextureView = z16;
        preloadSuperPlayerParams.url = str;
        if (TextUtils.isEmpty(str) && liveRoomExtraInfo != null) {
            String b16 = liveRoomExtraInfo.b("flv_url");
            if (!TextUtils.isEmpty(b16)) {
                try {
                    preloadSuperPlayerParams.url = URLDecoder.decode(b16, "utf-8");
                } catch (UnsupportedEncodingException | NullPointerException e16) {
                    f115697a.e("PreloadSuperPlayerParamsBuilder", "get preload url encode fail!", e16);
                }
            }
        }
        return preloadSuperPlayerParams;
    }
}

package com.tencent.mobileqq.qqvideoplatform;

import android.text.TextUtils;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(int i3, VideoPlayParam videoPlayParam) {
        AIOVideoPlayConfigProcessor.a aVar;
        if (i3 == 11022003 && videoPlayParam.mIsLocal && !TextUtils.isEmpty(videoPlayParam.mVideoPath) && (aVar = (AIOVideoPlayConfigProcessor.a) am.s().x(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END)) != null && aVar.f202430e) {
            try {
                File file = new File(videoPlayParam.mVideoPath);
                if (file.exists()) {
                    file.delete();
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoPlatformUtils", 2, "autoDelBadCache, delete file , path = " + videoPlayParam.mVideoPath);
                    }
                    return true;
                }
                return false;
            } catch (Exception e16) {
                QLog.e("VideoPlatformUtils", 1, "autoDelBadCache error.", e16);
                return false;
            }
        }
        return false;
    }
}

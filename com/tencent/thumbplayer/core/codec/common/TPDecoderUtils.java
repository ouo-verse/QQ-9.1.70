package com.tencent.thumbplayer.core.codec.common;

import android.text.TextUtils;
import com.tencent.thumbplayer.core.codec.capability.TPMediaDecoderInfo;
import com.tencent.thumbplayer.core.codec.capability.TPMediaDecoderInfoMgr;
import com.tencent.thumbplayer.core.utils.TPApplicationContext;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes26.dex */
public class TPDecoderUtils {
    private static final String TAG = "TPDecoderUtils";

    public static int convertDolbyVisionLevelToOmxLevel(int i3) {
        int i16 = 1 << i3;
        if (i16 >= 1 && i16 <= 256) {
            TPNativeLog.printLog(2, TAG, "convertDolbyVisionLevelToOmxLevel dolbyVisionLevel:" + i3 + " omxLevel:" + i16);
            return i16;
        }
        TPNativeLog.printLog(2, TAG, "convertDolbyVisionLevelToOmxLevel Unsupported level" + i3);
        return i3;
    }

    public static int convertDolbyVisionProfileToOmxProfile(int i3) {
        int i16 = 1 << i3;
        if (i3 >= 1 && i3 <= 512) {
            TPNativeLog.printLog(2, TAG, "convertDolbyVisionProfileToOmxProfile dolbyVisionProfile:" + i3 + " omxProfile:" + i16);
            return i16;
        }
        TPNativeLog.printLog(2, TAG, "convertDolbyVisionProfileToOmxProfile Unsupported profile" + i3);
        return i3;
    }

    public static String getDecoderName(String str, boolean z16) {
        TPMediaDecoderInfo[] tPMediaDecoderInfos = TPMediaDecoderInfoMgr.getTPMediaDecoderInfos(TPApplicationContext.getContext());
        if (!TextUtils.equals(str, "audio/eac3")) {
            for (TPMediaDecoderInfo tPMediaDecoderInfo : tPMediaDecoderInfos) {
                if (TextUtils.equals(str, tPMediaDecoderInfo.getDecoderMimeType()) && tPMediaDecoderInfo.isSecureDecoder() == z16) {
                    int currentDecoderCnt = TPMediaCodecInstanceCountMgr.sharedInstance().getCurrentDecoderCnt(tPMediaDecoderInfo.getDecoderName());
                    if (currentDecoderCnt >= tPMediaDecoderInfo.getMaxSupportedInstances() && TPMediaCodecConfig.getMediaCodecInstanceCountLimitEnable()) {
                        TPNativeLog.printLog(2, TAG, "codec: " + tPMediaDecoderInfo.getDecoderName() + " match but the number of instances exceeds the limits, cur:" + currentDecoderCnt + " max:" + tPMediaDecoderInfo.getMaxSupportedInstances());
                    } else {
                        return tPMediaDecoderInfo.getDecoderName();
                    }
                }
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TPMediaDecoderInfo tPMediaDecoderInfo2 : tPMediaDecoderInfos) {
            if ((TextUtils.equals("audio/eac3-joc", tPMediaDecoderInfo2.getDecoderMimeType()) || TextUtils.equals("audio/eac3", tPMediaDecoderInfo2.getDecoderMimeType())) && tPMediaDecoderInfo2.isSecureDecoder() == z16) {
                int currentDecoderCnt2 = TPMediaCodecInstanceCountMgr.sharedInstance().getCurrentDecoderCnt(tPMediaDecoderInfo2.getDecoderName());
                if (currentDecoderCnt2 >= tPMediaDecoderInfo2.getMaxSupportedInstances() && TPMediaCodecConfig.getMediaCodecInstanceCountLimitEnable()) {
                    TPNativeLog.printLog(2, TAG, "codec: " + tPMediaDecoderInfo2.getDecoderName() + " match but the number of instances exceeds the limits, cur:" + currentDecoderCnt2 + " max:" + tPMediaDecoderInfo2.getMaxSupportedInstances());
                } else {
                    arrayList.add(tPMediaDecoderInfo2);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TPMediaDecoderInfo tPMediaDecoderInfo3 = (TPMediaDecoderInfo) it.next();
            if (TextUtils.equals("audio/eac3-joc", tPMediaDecoderInfo3.getDecoderMimeType())) {
                return tPMediaDecoderInfo3.getDecoderName();
            }
        }
        if (arrayList.size() != 0) {
            return ((TPMediaDecoderInfo) arrayList.get(0)).getDecoderName();
        }
        return null;
    }

    public static String getDolbyVisionDecoderName(String str, int i3, int i16, boolean z16) {
        if (!TextUtils.equals("video/dolby-vision", str)) {
            return null;
        }
        int convertDolbyVisionProfileToOmxProfile = convertDolbyVisionProfileToOmxProfile(i3);
        for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderInfoMgr.getTPMediaDecoderInfos(TPApplicationContext.getContext())) {
            TPMediaDecoderInfo.DecoderProfileLevel[] profileLevels = tPMediaDecoderInfo.getProfileLevels();
            if (TextUtils.equals(tPMediaDecoderInfo.getDecoderMimeType(), str)) {
                for (TPMediaDecoderInfo.DecoderProfileLevel decoderProfileLevel : profileLevels) {
                    if (decoderProfileLevel.profile == convertDolbyVisionProfileToOmxProfile && tPMediaDecoderInfo.isSecureDecoder() == z16) {
                        int currentDecoderCnt = TPMediaCodecInstanceCountMgr.sharedInstance().getCurrentDecoderCnt(tPMediaDecoderInfo.getDecoderName());
                        if (currentDecoderCnt >= tPMediaDecoderInfo.getMaxSupportedInstances() && TPMediaCodecConfig.getMediaCodecInstanceCountLimitEnable()) {
                            TPNativeLog.printLog(2, TAG, "codec: " + tPMediaDecoderInfo.getDecoderName() + " match but the number of instances exceeds the limits, cur:" + currentDecoderCnt + " max:" + tPMediaDecoderInfo.getMaxSupportedInstances());
                        } else {
                            TPNativeLog.printLog(2, TAG, "getDolbyVisionDecoderName  profile:" + decoderProfileLevel.profile + " dvProfile:" + i3 + " bSecure:" + z16 + " name:" + tPMediaDecoderInfo.getDecoderName());
                            return tPMediaDecoderInfo.getDecoderName();
                        }
                    }
                }
            }
        }
        return null;
    }
}

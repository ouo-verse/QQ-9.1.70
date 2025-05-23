package com.tencent.thumbplayer.core.codec.capability;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.utils.LocalCache;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes26.dex */
public class TPMediaDecoderInfoMgr {
    private static final ArrayList<String> DECODER_NAME_BLACKLIST;
    private static final String MEDIA_DECODER_INFO_KEY = "DecoderInfos_Key";
    private static final String MEDIA_DECODER_VERSION = "3.0.0.1205.min";
    private static final String MEDIA_DECODER_VERSION_KEY = "Version_Key";
    private static final String TAG = "TPMediaDecoderInfoMgr";
    private static TPMediaDecoderInfo[] sDecoderInfos;
    private static LocalCache sLocalCache;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        DECODER_NAME_BLACKLIST = arrayList;
        arrayList.add("OMX.qti.audio.decoder.flac");
    }

    private static String buildCacheDecoderVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MEDIA_DECODER_VERSION);
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getDeviceName());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getProductBoard());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getProductDevice());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getApiLevel());
        return stringBuffer.toString();
    }

    private static String getCachedVersion() {
        try {
            String asString = sLocalCache.getAsString(MEDIA_DECODER_VERSION_KEY);
            TPNativeLog.printLog(2, TAG, "version:" + asString);
            return asString;
        } catch (Throwable unused) {
            TPNativeLog.printLog(0, TAG, "get version failed");
            return null;
        }
    }

    private static MediaCodecInfo[] getCodecInfos() {
        try {
            return new MediaCodecList(1).getCodecInfos();
        } catch (Exception e16) {
            TPNativeLog.printLog(0, TAG, "getCodecInfos MediaCodecList " + e16.getMessage());
            return new MediaCodecInfo[0];
        }
    }

    private static TPMediaDecoderInfo[] getLocalCacheMediaDecoderInfos() {
        TPNativeLog.printLog(2, "getLocalCacheMediaDecoderInfos");
        if (TextUtils.equals(getCachedVersion(), buildCacheDecoderVersion())) {
            try {
                TPMediaDecoderInfo[] tPMediaDecoderInfoArr = (TPMediaDecoderInfo[]) sLocalCache.getAsObject(MEDIA_DECODER_INFO_KEY);
                if (tPMediaDecoderInfoArr != null) {
                    TPNativeLog.printLog(2, TAG, "getLocalCacheMediaDecoderInfos length " + tPMediaDecoderInfoArr.length);
                    return tPMediaDecoderInfoArr;
                }
                return null;
            } catch (Throwable unused) {
                TPNativeLog.printLog(0, TAG, "getLocalCacheMediaDecoderInfos failed");
                return null;
            }
        }
        return null;
    }

    private static TPMediaDecoderInfo[] getSystemMediaDecoderInfos() {
        TPNativeLog.printLog(2, TAG, "getSystemMediaDecoderInfos");
        MediaCodecInfo[] codecInfos = getCodecInfos();
        if (codecInfos == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (!mediaCodecInfo.isEncoder() && !DECODER_NAME_BLACKLIST.contains(mediaCodecInfo.getName())) {
                for (String str : mediaCodecInfo.getSupportedTypes()) {
                    try {
                        TPMediaDecoderInfo tPMediaDecoderInfo = new TPMediaDecoderInfo(str, mediaCodecInfo);
                        TPNativeLog.printLog(2, TAG, "MediaCodecInfo codecName: " + mediaCodecInfo.getName() + ", supportedMimeType: " + str + ", isVideoSofwareDecoder: " + tPMediaDecoderInfo.isVideoSofwareDecoder());
                        if (!tPMediaDecoderInfo.isVideoSofwareDecoder()) {
                            arrayList.add(tPMediaDecoderInfo);
                        }
                    } catch (Exception e16) {
                        TPNativeLog.printLog(1, TAG, "create TPMediaDecoderInfo codecName(" + mediaCodecInfo.getName() + ") has exception:" + e16.getMessage());
                    }
                }
            }
        }
        return (TPMediaDecoderInfo[]) arrayList.toArray(new TPMediaDecoderInfo[arrayList.size()]);
    }

    @NonNull
    public static synchronized TPMediaDecoderInfo[] getTPMediaDecoderInfos(@NonNull Context context) {
        TPMediaDecoderInfo[] tPMediaDecoderInfoArr;
        synchronized (TPMediaDecoderInfoMgr.class) {
            if (sDecoderInfos == null) {
                initMediaDecoderInfos(context);
            }
            TPMediaDecoderInfo[] tPMediaDecoderInfoArr2 = sDecoderInfos;
            if (tPMediaDecoderInfoArr2 == null) {
                tPMediaDecoderInfoArr = new TPMediaDecoderInfo[0];
            } else {
                tPMediaDecoderInfoArr = (TPMediaDecoderInfo[]) Arrays.copyOf(tPMediaDecoderInfoArr2, tPMediaDecoderInfoArr2.length);
            }
        }
        return tPMediaDecoderInfoArr;
    }

    public static synchronized void initMediaDecoderInfos(@NonNull Context context) {
        synchronized (TPMediaDecoderInfoMgr.class) {
            TPNativeLog.printLog(2, TAG, "initMediaDecoderInfos start");
            sLocalCache = LocalCache.get(context.getApplicationContext());
            TPMediaDecoderInfo[] localCacheMediaDecoderInfos = getLocalCacheMediaDecoderInfos();
            if (localCacheMediaDecoderInfos == null && (localCacheMediaDecoderInfos = getSystemMediaDecoderInfos()) != null) {
                storeLocalCacheMediaDecoderInfos(localCacheMediaDecoderInfos);
            }
            sDecoderInfos = localCacheMediaDecoderInfos;
            TPNativeLog.printLog(2, TAG, "initMediaDecoderInfos end");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void storeLocalCacheMediaDecoderInfos(TPMediaDecoderInfo[] tPMediaDecoderInfoArr) {
        TPNativeLog.printLog(2, TAG, "storeLocalCacheMediaDecoderInfos");
        try {
            sLocalCache.put(MEDIA_DECODER_VERSION_KEY, buildCacheDecoderVersion());
            sLocalCache.put(MEDIA_DECODER_INFO_KEY, (Serializable) tPMediaDecoderInfoArr);
        } catch (Throwable unused) {
            TPNativeLog.printLog(0, TAG, "storeLocalCacheMediaDecoderInfos failed");
        }
    }
}

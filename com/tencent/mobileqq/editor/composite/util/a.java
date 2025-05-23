package com.tencent.mobileqq.editor.composite.util;

import android.graphics.PointF;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.h;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(String str, String str2, PublishVideoEntry publishVideoEntry) {
        String[] strArr;
        if (publishVideoEntry != null && publishVideoEntry.videoMaxrate > 0) {
            if (VideoEnvironment.isAvcodecNewVersion()) {
                strArr = new String[]{"-threads", "1", Argument.START_TIME, "0.0", "-accurate_seek", Argument.FILE_INPUT, str, Argument.DURATION, String.valueOf(publishVideoEntry.recordTime / 1000.0d), "-vf", "null", "-metadata:s", "rotate=0", Argument.AUDIO_CODEC, FileReaderHelper.AAC_EXT, Argument.VIDEO_CODEC, "libo264rt", "-movflags", "faststart", Argument.BITRATE_VIDEO, String.valueOf(publishVideoEntry.videoMaxrate), "-y", str2};
            } else {
                strArr = new String[]{"-threads", "1", Argument.START_TIME, "0.0", "-accurate_seek", Argument.FILE_INPUT, str, Argument.DURATION, String.valueOf(publishVideoEntry.recordTime / 1000.0d), "-vf", "null", "-metadata:s", "rotate=0", Argument.AUDIO_CODEC, FileReaderHelper.AAC_EXT, Argument.VIDEO_CODEC, VideoConverterConfig.SoftwareConfig.ENCODER_X264, "-movflags", "faststart", "-preset", "veryfast", "-tune", "psnr", "-profile:v", "high", "-level", "3.0", Argument.BITRATE_VIDEO, String.valueOf(publishVideoEntry.videoMaxrate), "-y", str2};
            }
            try {
                String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
                String shortVideoSoLibName = VideoEnvironment.getShortVideoSoLibName();
                new VideoConverter(new h()).setFFmpegBinAndSoPath(FFmpegFileUtils.getFFmpeg(BaseApplication.getContext()), shortVideoSoPath + shortVideoSoLibName, false);
                return new VideoConverter().executeFFmpegCmd(Arrays.asList(strArr));
            } catch (Error e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("CompositeUtil", 2, "TrimNative.trim: error", e16);
                }
                return 0;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("CompositeUtil", 2, "TrimNative.trim: ", e17);
                }
                return 0;
            }
        }
        return -1;
    }

    public static int b(int i3) {
        int i16 = i3 % 16;
        if (i16 != 0) {
            if (i16 < 8) {
                return i3 - i16;
            }
            return i3 + (16 - i16);
        }
        return i3;
    }

    public static long c(String str) {
        if (!FileUtils.fileExists(str)) {
            return 0L;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            return Long.valueOf(extractMetadata).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static ArrayList<DynamicStickerData> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ArrayList<DynamicStickerData> arrayList = new ArrayList<>();
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("list");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        if (jSONObject != null) {
                            DynamicStickerData dynamicStickerData = new DynamicStickerData();
                            dynamicStickerData.centerP = new PointF((float) jSONObject.optDouble("centerP_x"), (float) jSONObject.optDouble("centerP_y"));
                            dynamicStickerData.scale = (float) jSONObject.optDouble("scale");
                            dynamicStickerData.rotate = (float) jSONObject.optDouble(CanvasView.ACTION_ROTATE);
                            dynamicStickerData.translateX = (float) jSONObject.optDouble("translateX");
                            dynamicStickerData.translateY = (float) jSONObject.optDouble("translateY");
                            dynamicStickerData.width = (float) jSONObject.optDouble("width");
                            dynamicStickerData.height = (float) jSONObject.optDouble("height");
                            dynamicStickerData.layerWidth = jSONObject.optInt("layerWidth");
                            dynamicStickerData.layerHeight = jSONObject.optInt("layerHeight");
                            dynamicStickerData.path = jSONObject.optString("path");
                            dynamicStickerData.type = jSONObject.optInt("type", 0);
                            dynamicStickerData.data = jSONObject.optString("data", "");
                            dynamicStickerData.mGifDecoder = c.a(dynamicStickerData);
                            arrayList.add(dynamicStickerData);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("CompositeUtil", 2, "getDynamicStickersFromJson= " + arrayList);
                    }
                    return arrayList;
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CompositeUtil", 2, "e= " + e16);
            }
        }
        return null;
    }
}

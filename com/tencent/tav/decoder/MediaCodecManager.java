package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.CodecPerfReportSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MediaCodecManager {
    public static boolean CREATE_DECODE_BY_FORMAT = false;
    public static boolean CREATE_ENCODE_BY_FORMAT = false;
    private static final String TAG = "MediaCodecManager";
    private static final List<String> codecNames = new ArrayList();
    private static final List<CodecPerfReportSession> codecPerfReportSessionList = new ArrayList();

    public static synchronized void addCodecPerfReportSession(CodecPerfReportSession codecPerfReportSession) {
        synchronized (MediaCodecManager.class) {
            codecPerfReportSessionList.add(codecPerfReportSession);
        }
    }

    static MediaFormat checkCopyFormatWithoutFps(String str, MediaFormat mediaFormat) {
        if (!str.startsWith("video")) {
            return mediaFormat;
        }
        return MediaFormat.createVideoFormat(mediaFormat.getString("mime"), mediaFormat.getInteger("width"), mediaFormat.getInteger("height"));
    }

    private static MediaCodec codecCreated(String str, MediaCodec mediaCodec) {
        if (!str.startsWith("video")) {
            return mediaCodec;
        }
        codecNames.add(mediaCodec.getName());
        try {
            notifyReportSessions(mediaCodec);
        } catch (Exception e16) {
            Logger.e(TAG, "putReportInfo: ", e16);
        }
        Logger.i(TAG, "codecCreated: codecNames = " + codecNames);
        return mediaCodec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized MediaCodec createDecoder(MediaFormat mediaFormat) throws IOException {
        String str;
        synchronized (MediaCodecManager.class) {
            String string = mediaFormat.getString("mime");
            if (CREATE_DECODE_BY_FORMAT) {
                try {
                    str = CodecHelper.findDecoderForFormat(mediaFormat);
                } catch (Throwable th5) {
                    th = th5;
                    str = null;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        return codecCreated(string, MediaCodec.createByCodecName(str));
                    }
                } catch (Throwable th6) {
                    th = th6;
                    Logger.e(TAG, "createDecoder: createByCodecName fail, name = " + str, th);
                    return codecCreated(string, MediaCodec.createDecoderByType(string));
                }
            }
            return codecCreated(string, MediaCodec.createDecoderByType(string));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized MediaCodec createEncoder(MediaFormat mediaFormat) throws IOException {
        synchronized (MediaCodecManager.class) {
            String string = mediaFormat.getString("mime");
            if (CREATE_ENCODE_BY_FORMAT) {
                String str = null;
                try {
                    str = CodecHelper.findEncoderForFormat(checkCopyFormatWithoutFps(string, mediaFormat));
                    if (!TextUtils.isEmpty(str)) {
                        return codecCreated(string, MediaCodec.createByCodecName(str));
                    }
                } catch (Throwable th5) {
                    Logger.e(TAG, "createEncoder: createByCodecName fail, name = " + str, th5);
                }
            }
            return codecCreated(string, MediaCodec.createEncoderByType(string));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized List<String> getCodecNames() {
        List<String> list;
        synchronized (MediaCodecManager.class) {
            list = codecNames;
        }
        return list;
    }

    private static synchronized void notifyReportSessions(MediaCodec mediaCodec) {
        synchronized (MediaCodecManager.class) {
            Iterator<CodecPerfReportSession> it = codecPerfReportSessionList.iterator();
            while (it.hasNext()) {
                it.next().onCodecCreated(codecNames, mediaCodec);
            }
        }
    }

    public static synchronized void releaseCodec(MediaCodec mediaCodec) {
        synchronized (MediaCodecManager.class) {
            String codecName = CodecHelper.getCodecName(mediaCodec);
            if (codecName == null) {
                return;
            }
            codecNames.remove(codecName);
            try {
                mediaCodec.release();
                Logger.i(TAG, "releaseCodec: codecName = " + codecName);
            } catch (Throwable th5) {
                Logger.e(TAG, "releaseCodec: field", th5);
            }
            Logger.i(TAG, "releaseCodec left: codecNames = " + codecNames);
        }
    }

    public static synchronized void removeCodecPerfReportSession(CodecPerfReportSession codecPerfReportSession) {
        synchronized (MediaCodecManager.class) {
            codecPerfReportSessionList.remove(codecPerfReportSession);
        }
    }
}

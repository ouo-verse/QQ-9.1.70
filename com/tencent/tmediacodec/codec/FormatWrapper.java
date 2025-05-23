package com.tencent.tmediacodec.codec;

import android.media.MediaFormat;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class FormatWrapper {
    static IPatchRedirector $redirector_ = null;
    public static final int NO_VALUE = -1;
    public static final String TAG = "FormatWrapper";
    public int channelCount;

    @NonNull
    private String codecs;
    public int height;

    @NonNull
    public ArrayList<byte[]> initializationData;
    private boolean isVideo;
    private boolean isVideoFieldInit;
    public int maxHeight;
    public int maxInputSize;
    public int maxWidth;
    public int rotationDegrees;

    @NonNull
    public final String sampleMimeType;
    public int sampleRate;
    public int width;

    public FormatWrapper(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.codecs = "";
        this.initializationData = new ArrayList<>();
        this.width = -1;
        this.height = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.maxInputSize = -1;
        this.sampleMimeType = str;
    }

    private static String configCsdArray(String str, byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append(", length:");
        sb5.append(bArr.length);
        sb5.append("  [");
        for (int i3 = 0; i3 < Math.min(bArr.length, 20); i3++) {
            if (i3 != 0) {
                sb5.append(" ,");
            }
            sb5.append((int) bArr[i3]);
        }
        sb5.append("]");
        return sb5.toString();
    }

    public static FormatWrapper create(@NonNull MediaFormat mediaFormat) {
        FormatWrapper formatWrapper = new FormatWrapper(mediaFormat.getString("mime"));
        try {
            formatWrapper.sampleRate = getInteger(mediaFormat, "sample-rate");
            formatWrapper.maxInputSize = getInteger(mediaFormat, "max-input-size");
            formatWrapper.initializationData = TUtils.getCsdBuffers(mediaFormat);
            if (formatWrapper.isVideo()) {
                formatWrapper.rotationDegrees = getInteger(mediaFormat, "rotation-degrees");
                formatWrapper.width = getInteger(mediaFormat, "width");
                formatWrapper.height = getInteger(mediaFormat, "height");
                formatWrapper.maxWidth = getInteger(mediaFormat, "max-width");
                formatWrapper.maxHeight = getInteger(mediaFormat, "max-height");
            } else {
                formatWrapper.channelCount = getInteger(mediaFormat, "channel-count");
            }
        } catch (Throwable th5) {
            LogUtils.e("FormatWrapper", "create format error", th5);
        }
        return formatWrapper;
    }

    public static void dumpCsdArray(ArrayList<byte[]> arrayList) {
        if (arrayList != null && LogUtils.isLogEnable()) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sb5.append(configCsdArray(TUtils.CSD_INDEX_ARRAY[i3], arrayList.get(i3)));
                sb5.append("\n");
            }
            LogUtils.d("FormatWrapper", "csdData size:" + arrayList.size() + "    " + sb5.toString());
        }
    }

    public static int getInteger(@NonNull MediaFormat mediaFormat, @NonNull String str) {
        return getInteger(mediaFormat, str, -1);
    }

    public final boolean initializationDataEquals(@NonNull FormatWrapper formatWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) formatWrapper)).booleanValue();
        }
        if (this.initializationData.size() != formatWrapper.initializationData.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.initializationData.size(); i3++) {
            if (!this.initializationData.get(i3).equals(formatWrapper.initializationData.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!this.isVideoFieldInit) {
            this.isVideoFieldInit = true;
            this.isVideo = TUtils.isVideo(this.sampleMimeType);
        }
        return this.isVideo;
    }

    public static int getInteger(@NonNull MediaFormat mediaFormat, @NonNull String str, int i3) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i3;
    }
}

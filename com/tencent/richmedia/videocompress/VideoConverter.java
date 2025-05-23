package com.tencent.richmedia.videocompress;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.tencent.richmedia.videocompress.converter.HardwareConverter;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import com.tencent.richmedia.videocompress.utils.Logger;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class VideoConverter {
    private VideoConverterImpl convertImpl = new VideoConverterImpl();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface Processor {
        VideoConverterConfig getEncodeConfig(int i3, int i16);

        void onCancel();

        void onFail(Throwable th5);

        void onProgress(int i3);

        void onSuccess();
    }

    public VideoConverter() {
    }

    public boolean cancelCompress() {
        return this.convertImpl.cancel();
    }

    public int executeFFmpegCmd(List<String> list) {
        return this.convertImpl.executeFFmpegCmd(list);
    }

    @RequiresApi(api = 18)
    public void setChangeOutputFrameRateDisabled(boolean z16) {
        HardwareConverter.setChangeOutputFrameRateDisabled(z16);
    }

    public void setCompressMode(int i3) {
        this.convertImpl.setCompressMode(i3);
    }

    public void setFFmpegBinAndSoPath(String str, String str2, boolean z16) {
        this.convertImpl.setFFmpegBinAndSoPath(str, str2, z16);
    }

    public void setOutPutVideoCodecMIMEType(String str) {
        this.convertImpl.setOutPutVideoCodecMIMEType(str);
    }

    public int startCompress(Context context, String str, Processor processor, boolean z16) {
        return this.convertImpl.start(context, str, processor, z16);
    }

    public VideoConverter(Logger logger) {
        ConvertLog.setLogger(logger);
    }
}

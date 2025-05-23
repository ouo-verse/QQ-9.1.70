package com.tencent.mobileqq.ptt;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.RecordParams;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQRecorderUtils extends QRouteApi {
    public static final int ABNORMAL_NO_DATA = 0;
    public static final int ABNORMAL_NO_VOLUME = 1;
    public static final String ABNORMAL_RECORD_URL = "https://kf.qq.com/touch/sappfaq/210331qMJbAf210331RZBBba.html";
    public static final int AUDIO_FORMAT = 2;
    public static final int CHANNEL_CONFIG = 2;
    public static final int VOLUME_STATE_INIT = 0;
    public static final int VOLUME_STATE_LOW = 1;
    public static final int VOLUME_STATE_NORMAL = 2;

    int bytesInMillisecond(int i3, int i16, int i17);

    int bytesInSecond(int i3);

    int bytesInSecond(int i3, int i16, int i17);

    boolean checkExternalStorageForRecord();

    boolean checkIntenalStorageForRecord(int i3);

    d createQQRecorder(Context context);

    int dsToIs(double d16);

    int getFilePlayTime(String str);

    String getLastRecorderPath();

    double getMillisecond(int i3, int i16, int i17, long j3);

    int getPttRecordTime(double d16);

    int getPttShowTime(int i3);

    RecordParams.RecorderParam getRecorderParam();

    ArrayList<Byte> getSampleWaveData(String str, int i3);

    int msToSec(double d16);

    void setLastRecorderPath(String str);
}

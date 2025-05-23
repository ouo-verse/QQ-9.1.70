package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.RecordParams;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        public static final IPatchRedirector $redirector_ = null;

        int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam);

        void onInitFailed(String str, RecordParams.RecorderParam recorderParam);

        void onInitSuccess();

        void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam);

        void onRecorderEnd(String str, RecordParams.RecorderParam recorderParam, double d16);

        void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2);

        void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam);

        void onRecorderSilceEnd(String str, byte[] bArr, int i3, int i16, double d16, RecordParams.RecorderParam recorderParam);

        int onRecorderStart();

        void onRecorderVolumeStateChanged(int i3);
    }

    boolean a();

    void b(a aVar);

    void c(String str, boolean z16);

    void d(String str);

    void e(RecordParams.RecorderParam recorderParam);

    boolean isRecording();

    void release();

    void start(String str);

    boolean stop();
}

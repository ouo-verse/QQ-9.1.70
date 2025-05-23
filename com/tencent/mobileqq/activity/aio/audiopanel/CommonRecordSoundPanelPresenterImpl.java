package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.temp.IQavTemp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.ptt.temp.api.IMediaPlayerManagerTempApi;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.util.WeakReference;

/* loaded from: classes10.dex */
public class CommonRecordSoundPanelPresenterImpl implements i, d.a {
    private int D;

    /* renamed from: e, reason: collision with root package name */
    protected double f178264e;

    /* renamed from: f, reason: collision with root package name */
    protected int f178265f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.ptt.d f178266h;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<j> f178268m;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f178263d = true;

    /* renamed from: i, reason: collision with root package name */
    protected int f178267i = 0;
    private int C = 180000;
    protected Handler E = new a(Looper.getMainLooper());

    /* loaded from: classes10.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j h16 = CommonRecordSoundPanelPresenterImpl.this.h();
            int i3 = message.what;
            if (i3 != 1) {
                switch (i3) {
                    case 16711686:
                        if (QLog.isColorLevel()) {
                            QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
                        }
                        CommonRecordSoundPanelPresenterImpl.this.f178266h.stop();
                        AudioUtil.n(R.raw.f169427y, false);
                        if (h16 != null) {
                            h16.c().sendEmptyMessage(16711686);
                            QQAudioUtils.i(h16.a(), false);
                            return;
                        }
                        return;
                    case 16711687:
                        CommonRecordSoundPanelPresenterImpl.this.b(102);
                        if (h16 != null && h16.c() != null) {
                            h16.c().sendEmptyMessage(16711687);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            CommonRecordSoundPanelPresenterImpl.this.b(1);
            if (h16 != null) {
                h16.reset();
                QQToast.makeText(h16.a(), h16.a().getString(R.string.f8t), 1).show();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public void a(int i3) {
        this.D = i3;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public void b(int i3) {
        h();
        com.tencent.mobileqq.ptt.d dVar = this.f178266h;
        if (dVar != null && !dVar.a() && !this.E.hasMessages(16711686)) {
            this.E.removeMessages(16711688);
            this.E.removeMessages(16711686);
            this.E.removeMessages(16711687);
            if (QLog.isColorLevel()) {
                QLog.d("CommonRecordSoundPanelPresenterImpl", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
            }
            this.f178267i = i3;
            if (this.f178266h != null) {
                this.E.sendMessageDelayed(this.E.obtainMessage(16711686), 200L);
            }
        }
    }

    public int c() {
        return this.f178267i;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public void d() {
        RecordParams.RecorderParam recorderParam;
        String transferFilePath;
        Handler handler = this.E;
        if (handler != null) {
            if (handler.hasMessages(16711688)) {
                this.E.removeMessages(16711688);
            }
            this.E.removeMessages(16711688);
            this.E.removeMessages(16711686);
            this.E.removeMessages(16711687);
        }
        j h16 = h();
        if (h16 == null) {
            return;
        }
        h16.a().getWindow().addFlags(128);
        ((IMediaPlayerManagerTempApi) QRoute.api(IMediaPlayerManagerTempApi.class)).mediaPlayer_doStop(true, h16.getApp());
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
        intent.setPackage(h16.getApp().getApp().getPackageName());
        h16.getApp().getApp().sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.d("CommonRecordSoundPanelPresenterImpl", 2, "startRecord() is called");
        }
        if (this.f178266h == null) {
            this.f178266h = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(h16.a());
        }
        if (this.D == 0) {
            recorderParam = new RecordParams.RecorderParam(RecordParams.f307250a, 0, 0);
            transferFilePath = TransFileUtil.getTransferFilePath(h16.getApp().getCurrentAccountUin(), null, 2, null);
        } else {
            recorderParam = new RecordParams.RecorderParam(RecordParams.f307251b, 16000, 1);
            transferFilePath = TransFileUtil.getTransferFilePath(h16.getApp().getCurrentAccountUin(), null, 25, null);
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(transferFilePath);
        File file = new File(sDKPrivatePath);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AIOAudioPanel", 2, "recorderInit, createNewFile cause exception", e16);
            }
        }
        this.f178266h.e(recorderParam);
        if (QLog.isColorLevel()) {
            QLog.i("QQRecorder", 2, "path: " + sDKPrivatePath);
        }
        this.f178266h.b(this);
        QQAudioUtils.i(h16.a(), true);
        if (QLog.isColorLevel()) {
            QLog.d("CommonRecordSoundPanelPresenterImpl", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
        }
        this.f178266h.start(sDKPrivatePath);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public void e(int i3) {
        this.f178267i = i3;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public void f(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public boolean g() {
        j h16 = h();
        if (h16 == null) {
            return false;
        }
        IQQRecorderUtils iQQRecorderUtils = (IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class);
        BaseApplication context = BaseApplication.getContext();
        int titleBarHeight = ((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTitleBarHeight(context);
        if (!iQQRecorderUtils.checkExternalStorageForRecord()) {
            QLog.w("CommonRecordSoundPanelPresenterImpl", 1, "[recordeCheck] insufficient external storage space");
            QQToast.makeText(context, R.string.f224266ig, 0).show(titleBarHeight);
            return false;
        }
        if (!iQQRecorderUtils.checkIntenalStorageForRecord(iQQRecorderUtils.getRecorderParam().f307257f)) {
            QLog.w("CommonRecordSoundPanelPresenterImpl", 1, "[recordeCheck] insufficient internal storage space");
            QQToast.makeText(context, R.string.by8, 0).show(titleBarHeight);
            return false;
        }
        if (((IQavTemp) QRoute.api(IQavTemp.class)).isVideoChatting(h16.getApp())) {
            QLog.w("CommonRecordSoundPanelPresenterImpl", 1, "[recordeCheck] isVideoChatting");
            QQToast.makeText(BaseApplication.getContext(), R.string.f171206d52, 0).show();
            return false;
        }
        if (!AudioUtil.h(1)) {
            return true;
        }
        QLog.w("CommonRecordSoundPanelPresenterImpl", 1, "[recordeCheck] meizu forbid");
        ((IPttUtils) QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(h16.a());
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public double getRecordTime() {
        return this.f178264e;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public String getTimeStrByMillis(double d16) {
        return ((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(d16);
    }

    public j h() {
        WeakReference<j> weakReference = this.f178268m;
        if (weakReference != null && !weakReference.isEnqueued()) {
            return this.f178268m.get();
        }
        return null;
    }

    public void i(String str, boolean z16, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + str);
        }
        byte[] a16 = RecordParams.a(recorderParam.f307257f, recorderParam.f307255d);
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).createBufferTask(str);
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(str, a16, a16.length);
        AudioUtil.n(R.raw.f169428z, false);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.i
    public boolean isRecording() {
        com.tencent.mobileqq.ptt.d dVar = this.f178266h;
        if (dVar != null && dVar.isRecording()) {
            return true;
        }
        return false;
    }

    public int j() {
        this.E.sendEmptyMessageDelayed(16711687, this.C - 200);
        return this.C;
    }

    public void k(j jVar) {
        if (jVar != null) {
            this.f178268m = new WeakReference<>(jVar);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
        }
        return j();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
        }
        final j h16 = h();
        if (h16 != null) {
            this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    h16.reset();
                    QQToast.makeText(h16.a(), h16.a().getString(R.string.f8t), 0).show();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(final String str, RecordParams.RecorderParam recorderParam, double d16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + str);
        }
        this.E.removeMessages(1);
        final j h16 = h();
        if (this.f178265f < 1200) {
            this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    j jVar = h16;
                    if (jVar != null) {
                        QQToast.makeText(jVar.getApp().getApp(), R.string.f170312ly, 1).show(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTitleBarHeight(h16.a()));
                        h16.d(str);
                        h16.reset();
                    }
                }
            });
            return;
        }
        int c16 = c();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + c16);
        }
        if (c16 == 102) {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).flush(str);
            if (h16 != null) {
                Message obtainMessage = h16.c().obtainMessage(102);
                obtainMessage.obj = str;
                h16.c().sendMessage(obtainMessage);
                return;
            }
            return;
        }
        if (c16 == 1) {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).cancelBufferTask(str);
            this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    j jVar = h16;
                    if (jVar != null) {
                        jVar.d(str);
                        h16.reset();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
        QLog.e("AIOAudioPanel", 1, "RecordSoundPanel.onRecorderError() is called,path is:" + str + ", throwable: " + str2);
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).cancelBufferTask(str);
        final j h16 = h();
        if (h16 == null) {
            return;
        }
        h16.e(str);
        this.E.removeMessages(1);
        this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.6
            @Override // java.lang.Runnable
            public void run() {
                h16.reset();
                QQToast.makeText(h16.a(), h16.a().getString(R.string.f8r), 0).show();
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
        }
        final j h16 = h();
        if (h16 != null) {
            this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    h16.b();
                }
            });
            i(str, true, recorderParam);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String str, byte[] bArr, int i3, final int i16, final double d16, RecordParams.RecorderParam recorderParam) {
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(str, bArr, i3);
        if (this.f178263d) {
            this.f178263d = false;
            this.E.removeMessages(1);
        }
        this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.8
            @Override // java.lang.Runnable
            public void run() {
                j h16 = CommonRecordSoundPanelPresenterImpl.this.h();
                if (h16 != null) {
                    h16.f(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getVolumeLevel(i16));
                    h16.setRecordTime(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(d16));
                    CommonRecordSoundPanelPresenterImpl.this.f178264e = d16;
                }
            }
        });
        this.f178265f = (int) d16;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
        }
        final j h16 = h();
        if (h16 != null) {
            this.f178265f = 0;
            h16.c().sendEmptyMessage(3);
            this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    h16.startRecord();
                }
            });
            this.E.removeMessages(1);
            this.E.sendEmptyMessageDelayed(1, 2000L);
            this.f178263d = true;
            return 250;
        }
        return 250;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int i3) {
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
    }
}

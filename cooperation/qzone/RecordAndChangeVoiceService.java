package cooperation.qzone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.a;
import com.tencent.mobileqq.voicechange.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.utils.Base64;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin;
import cooperation.qzone.webviewplugin.QZonePublishVoiceShuoShuoH5Plugin;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes38.dex */
public class RecordAndChangeVoiceService implements a, IVoiceChangeHelper.a {
    public static final String ACTION_TYPE = "com.tencent.qq.syncSecretShuoshuoMsgType";
    public static final String BROADCAST_SYNC_SECRET_SHUOSHUO_MESSAGE = "com.tencent.qq.syncSecretShuoshuoMsg";
    public static final int FROM_SECRET = 0;
    public static final int FROM_VOICE_MOOD = 1;
    private static final String TAG = "RecordAndChangeVoiceService";
    private static RecordAndChangeVoiceService sRecordAndChangeVoiceService;
    private String base64Callback;
    private long changedVoiceTime;
    private int currentVoiceID;
    private QZonePublishSecretShuoShuoH5Plugin mQZonePublishSecretShuoShuoH5Plugin;
    private String recordPath;
    private long recordTime;
    private String sVCSoPath;
    public b voiceChangeParams;

    RecordAndChangeVoiceService() {
        String J = TraeHelper.J(BaseApplication.getContext());
        this.sVCSoPath = J;
        if (TextUtils.isEmpty(J)) {
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_START_DOWNLOAD_VOICECHANGE_SO, null);
        }
    }

    public static RecordAndChangeVoiceService getInstance() {
        if (sRecordAndChangeVoiceService == null) {
            synchronized (TAG) {
                if (sRecordAndChangeVoiceService == null) {
                    sRecordAndChangeVoiceService = new RecordAndChangeVoiceService();
                }
            }
        }
        return sRecordAndChangeVoiceService;
    }

    public static void sendBroadcastSecretShuoshuoMsg(Context context, int i3) {
        Intent intent = new Intent(BROADCAST_SYNC_SECRET_SHUOSHUO_MESSAGE);
        Bundle bundle = new Bundle();
        bundle.putInt(ACTION_TYPE, i3);
        intent.putExtras(bundle);
        context.sendBroadcast(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String encodeBase64File(String str) throws Exception {
        byte[] bArr;
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        byte[] bArr2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            bArr = null;
        }
        try {
            bArr2 = new byte[(int) file.length()];
            fileInputStream.read(bArr2);
            try {
                fileInputStream.close();
            } catch (Exception e16) {
                QZLog.e(TAG, 1, e16, new Object[0]);
            }
        } catch (Throwable th6) {
            th = th6;
            bArr = bArr2;
            fileInputStream2 = fileInputStream;
            try {
                QZLog.e(TAG, 1, th, new Object[0]);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e17) {
                        QZLog.e(TAG, 1, e17, new Object[0]);
                    }
                }
                bArr2 = bArr;
                if (bArr2 == null) {
                }
            } catch (Throwable th7) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e18) {
                        QZLog.e(TAG, 1, e18, new Object[0]);
                    }
                }
                throw th7;
            }
        }
        if (bArr2 == null) {
            return Base64.encodeToString(bArr2, 0);
        }
        return "";
    }

    public void getMoodVoiceData(String str, int i3, QZonePublishSecretShuoShuoH5Plugin qZonePublishSecretShuoShuoH5Plugin) {
        if (TextUtils.isEmpty(this.sVCSoPath)) {
            String J = TraeHelper.J(BaseApplication.getContext());
            this.sVCSoPath = J;
            if (TextUtils.isEmpty(J)) {
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_START_DOWNLOAD_VOICECHANGE_SO, null);
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.sxa), 1);
                return;
            }
            return;
        }
        QZLog.d(TAG, 2, "getMoodVoiceData callback" + str + " voiceID " + i3);
        this.base64Callback = str;
        this.mQZonePublishSecretShuoShuoH5Plugin = qZonePublishSecretShuoShuoH5Plugin;
        ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToSend(BaseApplication.getContext(), this.voiceChangeParams, this.sVCSoPath, this);
        synchronized (IVoiceChangeManager.class) {
            ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).queryStateByPath(this.recordPath, this);
        }
    }

    public void getMoodVoiceRecordTime(String str, QZonePublishSecretShuoShuoH5Plugin qZonePublishSecretShuoShuoH5Plugin) {
        QZLog.d(TAG, 2, "getMoodVoiceRecordTime");
        if (this.voiceChangeParams == null) {
            return;
        }
        int i3 = this.currentVoiceID;
        if (i3 != 0 && (i3 == 0 || this.changedVoiceTime != 0)) {
            long j3 = (this.changedVoiceTime + 500) / 1000;
            qZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceRecordTime(str, j3);
            QZLog.d(TAG, 2, "onReplyGetMoodVoiceRecordTime: " + j3);
            return;
        }
        long j16 = (this.recordTime + 500) / 1000;
        qZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceRecordTime(str, j16);
        QZLog.d(TAG, 2, "onReplyGetMoodVoiceRecordTime: " + j16);
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeHelper.a
    public void onCompressFinished(String str, int i3, int i16) {
        try {
            StringBuilder sb5 = new StringBuilder("data:audio/amr;base64,");
            sb5.append(encodeBase64File(str));
            QZLog.d(TAG, 2, "base64=" + sb5.toString());
            this.mQZonePublishSecretShuoShuoH5Plugin.onReplyGetMoodVoiceData(this.base64Callback, sb5.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void playChangeVoiceAudio(int i3) {
        if (TextUtils.isEmpty(this.sVCSoPath)) {
            String J = TraeHelper.J(BaseApplication.getContext());
            this.sVCSoPath = J;
            if (TextUtils.isEmpty(J)) {
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_START_DOWNLOAD_VOICECHANGE_SO, null);
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.sx_), 1);
                return;
            }
            return;
        }
        b bVar = this.voiceChangeParams;
        if (bVar != null) {
            this.currentVoiceID = i3;
            bVar.f313144g = i3;
            ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToStart(BaseApplication.getContext(), this.voiceChangeParams, this.sVCSoPath, this);
        }
    }

    public void playMoodVoice(String str, int i3, QZonePublishSecretShuoShuoH5Plugin qZonePublishSecretShuoShuoH5Plugin) {
        QZLog.d(TAG, 2, "playMoodVoice voiceID: " + i3);
        if (i3 == 3) {
            this.changedVoiceTime = ((float) this.recordTime) / 0.6f;
        } else if (i3 == 4) {
            this.changedVoiceTime = ((float) this.recordTime) * 0.5833333f;
        } else {
            this.changedVoiceTime = this.recordTime;
        }
        long j3 = (this.changedVoiceTime + 500) / 1000;
        qZonePublishSecretShuoShuoH5Plugin.onReplyPlayMoodVoice(str, j3);
        QZLog.d(TAG, 2, "onReplyPlayMoodVoice changeVoiceTime=" + this.changedVoiceTime + ", time = " + j3);
        playChangeVoiceAudio(i3);
    }

    public void cleanData() {
        this.recordPath = null;
        this.base64Callback = null;
        this.voiceChangeParams = null;
        this.recordTime = -1L;
        this.changedVoiceTime = -1L;
        this.currentVoiceID = -1;
        this.mQZonePublishSecretShuoShuoH5Plugin = null;
    }

    public void onReceiveRecordData(Intent intent, int i3) {
        this.currentVoiceID = 0;
        this.changedVoiceTime = 0L;
        this.recordPath = intent.getStringExtra("key_record_path");
        this.recordTime = intent.getLongExtra("key_record_time", 0L);
        int intExtra = intent.getIntExtra("key_record_param_sample_rate", 0);
        int intExtra2 = intent.getIntExtra("key_record_param_bit_rate", 0);
        int intExtra3 = intent.getIntExtra("key_record_param_audio_type", 0);
        if (!TextUtils.isEmpty(this.recordPath) && this.recordTime > 0) {
            this.voiceChangeParams = new b(this.recordPath, intExtra, intExtra2, intExtra3, 0);
            if (i3 == 0) {
                sendBroadcastSecretShuoshuoMsg(BaseApplication.getContext(), 1);
                return;
            } else {
                if (i3 != 1) {
                    return;
                }
                QZonePublishVoiceShuoShuoH5Plugin.onNotifyH5RecordOk();
                return;
            }
        }
        sendBroadcastSecretShuoshuoMsg(BaseApplication.getContext(), 6);
    }

    public void stopPlayingMoodVoice() {
        QZLog.d(TAG, 2, "stopPlayingMoodVoice");
        if (this.voiceChangeParams != null) {
            ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToPause(this.voiceChangeParams);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onError() {
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onPlayEnd() {
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onPlayStop() {
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onSlicePlayed(int i3, int i16, int i17) {
    }
}

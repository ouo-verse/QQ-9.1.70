package cooperation.qzone;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.o;
import com.tencent.mobileqq.shortvideo.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.DownloadResultCallback;
import eipc.EIPCResult;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneVideoSoDownloadModule extends QIPCModule {
    public static final String ACTION_CHECK_AVCODEC_IS_OK = "action_check_avcodec_is_ok";
    public static final String ACTION_DOWNLOAD_AVCODEC = "action_download_avcodec";
    public static final String KEY_DOWNLOAD_RESULT_RECEIVER = "key_download_result_receiver";
    public static final String KEY_ERROR_MESSAGE = "key_error_message";
    public static final String KEY_IS_AVCODEC_OK = "key_is_avcodec_ok";
    public static final String NAME = "QzoneVideoSoDownloadModule";
    public static final int RESULT_CODE_CONFIG_FAILED = -2;
    public static final int RESULT_CODE_DOWNLOAD_FAILED = -3;
    public static final int RESULT_CODE_FAILED = -1;
    public static final int RESULT_CODE_SUCCESS = 0;
    private static final String TAG = "QzoneVideoSoDownloadModule";
    private static QzoneVideoSoDownloadModule sInstance;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private class MyISVConfig implements x.a {
        private QQAppInterface app;
        private ResultReceiver mReceiver;

        public MyISVConfig(QQAppInterface qQAppInterface, ResultReceiver resultReceiver) {
            this.app = qQAppInterface;
            this.mReceiver = resultReceiver;
        }

        @Override // com.tencent.mobileqq.shortvideo.x.a
        public void onConfigResult(int i3, int i16) {
            VideoEnvironment.LogDownLoad("QzoneVideoSoDownloadModule", "result=" + i3 + ",serverError=" + i16, null);
            if (i3 != 1 && i3 != 0) {
                QzoneVideoSoDownloadModule.this.sendErrorMessage(this.mReceiver, -2, HardCodeUtil.qqStr(R.string.sbp) + i16 + "]");
                o.c(1, i16);
                return;
            }
            if (i16 != 0) {
                QzoneVideoSoDownloadModule.this.sendErrorMessage(this.mReceiver, -2, HardCodeUtil.qqStr(R.string.scd) + i16 + "]");
                o.c(1, i16);
                return;
            }
            ArrayList arrayList = new ArrayList(1);
            int f16 = ShortVideoResourceManager.f(this.app, arrayList);
            if (f16 == 0) {
                ShortVideoResourceManager.q(this.app, arrayList, new MyShortVideoResource(this.mReceiver));
                return;
            }
            QzoneVideoSoDownloadModule.this.sendErrorMessage(this.mReceiver, -2, HardCodeUtil.qqStr(R.string.sen) + f16 + "]");
            o.c(1, f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private class MyShortVideoResource implements ShortVideoResourceManager.e {
        ResultReceiver mReceiver;

        public MyShortVideoResource(ResultReceiver resultReceiver) {
            this.mReceiver = resultReceiver;
        }

        @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
        public void onDownloadFinish(String str, int i3, String str2) {
            QLog.i("QzoneVideoSoDownloadModule", 1, "onDownloadFinish name=" + str + " result=" + i3 + " filePath=" + str2);
            if (str.startsWith("new_qq_android_native_short_video_")) {
                if (i3 != 0) {
                    QzoneVideoSoDownloadModule.this.sendErrorMessage(this.mReceiver, -3, HardCodeUtil.qqStr(R.string.sbm) + i3 + "]");
                    o.c(2, i3);
                    return;
                }
                if (this.mReceiver != null) {
                    this.mReceiver.send(0, new Bundle());
                }
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
        public void onUpdateProgress(String str, long j3, long j16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QzoneVideoSoDownloadModule", 4, "onUpdateProgress: name=" + str + " curOffset=" + j3 + " totalLen=" + j16);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
        public void onNetWorkNone() {
            QLog.e("QzoneVideoSoDownloadModule", 1, "onNetWorkNone");
            QzoneVideoSoDownloadModule.this.sendErrorMessage(this.mReceiver, -3, HardCodeUtil.qqStr(R.string.sbd));
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class QzoneVideoSoDownloadResultReceiver extends ResultReceiver {
        private DownloadResultCallback mCallback;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            DownloadResultCallback downloadResultCallback = this.mCallback;
            if (downloadResultCallback != null) {
                downloadResultCallback.callback(i3, bundle);
            }
        }

        public QzoneVideoSoDownloadResultReceiver(DownloadResultCallback downloadResultCallback) {
            super(null);
            this.mCallback = downloadResultCallback;
        }
    }

    QzoneVideoSoDownloadModule(String str) {
        super(str);
    }

    public static QzoneVideoSoDownloadModule getInstance() {
        if (sInstance == null) {
            synchronized (QzoneVideoSoDownloadModule.class) {
                if (sInstance == null) {
                    sInstance = new QzoneVideoSoDownloadModule("QzoneVideoSoDownloadModule");
                }
            }
        }
        return sInstance;
    }

    public static ResultReceiver getReceiverForSending(DownloadResultCallback downloadResultCallback) {
        QzoneVideoSoDownloadResultReceiver qzoneVideoSoDownloadResultReceiver = new QzoneVideoSoDownloadResultReceiver(downloadResultCallback);
        Parcel obtain = Parcel.obtain();
        qzoneVideoSoDownloadResultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        return resultReceiver;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneVideoSoDownloadModule", 2, "action = " + str);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("QzoneVideoSoDownloadModule", 2, "onRemoteInvoke cannot get QQAppInterface");
            }
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if ("action_download_avcodec".equals(str)) {
            QLog.i("QzoneVideoSoDownloadModule", 1, "try download libavcodec");
            if (NetworkUtil.isNetworkAvailable(null) && bundle != null) {
                ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("key_download_result_receiver");
                if (resultReceiver == null) {
                    QLog.e("QzoneVideoSoDownloadModule", 1, "receiver == null");
                    return EIPCResult.createResult(-1, null);
                }
                ShortVideoResourceManager.M(qQAppInterface, new MyISVConfig(qQAppInterface, resultReceiver));
                return EIPCResult.createResult(0, new Bundle());
            }
            return EIPCResult.createResult(-1, null);
        }
        if (!"action_check_avcodec_is_ok".equals(str)) {
            return null;
        }
        boolean checkAndLoadAVCodec = VideoEnvironment.checkAndLoadAVCodec();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("key_is_avcodec_ok", checkAndLoadAVCodec);
        return EIPCResult.createResult(0, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendErrorMessage(ResultReceiver resultReceiver, int i3, String str) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_error_message", str);
            resultReceiver.send(i3, bundle);
        }
    }
}

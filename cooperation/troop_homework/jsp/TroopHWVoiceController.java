package cooperation.troop_homework.jsp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TroopHWVoiceController implements VoicePlayer.a, d.a {
    public static String F = "shard_pref_name";
    private d D;

    /* renamed from: e, reason: collision with root package name */
    private SharedPreferences f390997e;

    /* renamed from: f, reason: collision with root package name */
    protected WeakReference<Context> f390998f;

    /* renamed from: h, reason: collision with root package name */
    private String f390999h;

    /* renamed from: m, reason: collision with root package name */
    private b f391001m;

    /* renamed from: d, reason: collision with root package name */
    public int f390996d = 360000;

    /* renamed from: i, reason: collision with root package name */
    private int f391000i = 0;
    private VoicePlayer C = null;
    private Handler E = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context;
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 3) {
                    TroopHWVoiceController.this.D.stop();
                    AudioUtil.n(R.raw.f169427y, false);
                    WeakReference<Context> weakReference = TroopHWVoiceController.this.f390998f;
                    if (weakReference == null || (context = weakReference.get()) == null) {
                        return;
                    }
                    QQAudioUtils.i(context, false);
                    return;
                }
                return;
            }
            if (TroopHWVoiceController.this.f391001m != null) {
                TroopHWVoiceController.this.f391001m.i(1, TroopHWVoiceController.this.f390999h);
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                String str = (String) obj;
                TroopHWVoiceController.this.l(str);
                TroopHWVoiceController.this.n(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        void a(String str, double d16);

        void f();

        void g();

        void i(int i3, String str);

        void o(int i3, String str);
    }

    public TroopHWVoiceController(Context context, b bVar) {
        this.f390998f = new WeakReference<>(context);
        this.f391001m = bVar;
    }

    public static SharedPreferences e(Context context) {
        return context.getSharedPreferences(F, 0);
    }

    private boolean i() {
        Context context;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopHWVoiceController", 2, "VideoProcessAlive");
            }
            return true;
        }
        WeakReference<Context> weakReference = this.f390998f;
        if (weakReference != null && (context = weakReference.get()) != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (it.next().processName.equals(Constants.Process.VIDEO_PROCESS)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void m(String str) {
        Context context;
        WeakReference<Context> weakReference = this.f390998f;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        SharedPreferences e16 = e(context);
        this.f390997e = e16;
        SharedPreferences.Editor edit = e16.edit();
        edit.remove(str);
        edit.commit();
    }

    public String f(String str) {
        Context context;
        WeakReference<Context> weakReference = this.f390998f;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return null;
        }
        SharedPreferences e16 = e(context);
        this.f390997e = e16;
        return e16.getString(str, null);
    }

    public void g(String str) {
        Context context;
        boolean z16;
        boolean z17;
        WeakReference<Context> weakReference = this.f390998f;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Environment.getExternalStorageState().equals("mounted") && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) {
                if (i()) {
                    QQToast.makeText(BaseApplication.getContext(), R.string.f171206d52, 0).show();
                    return;
                }
                if (AudioUtil.h(1)) {
                    ((IPttUtils) QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(context);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopHWVoiceController", 2, "startRecord() is called");
                }
                if (this.D == null) {
                    this.D = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(context);
                }
                RecordParams.RecorderParam recorderParam = new RecordParams.RecorderParam(RecordParams.f307250a, 0, 0);
                String transferFilePath = TransFileUtil.getTransferFilePath(str, null, 2, null);
                this.D.e(recorderParam);
                if (QLog.isColorLevel()) {
                    QLog.i("QQRecorder", 2, "path: " + transferFilePath);
                }
                this.D.b(this);
                QQAudioUtils.i(context, true);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopHWVoiceController", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
                }
                this.D.start(transferFilePath);
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), R.string.h_0, 0).show();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), R.string.ck7, 0).show();
    }

    public void h() {
        d dVar = this.D;
        if (dVar != null && !dVar.a()) {
            this.E.removeMessages(3);
            this.E.removeMessages(2);
            this.E.sendEmptyMessageDelayed(3, 200L);
        }
    }

    public void j(String str) {
        QLog.d("TroopHWVoiceController", 1, "playOnlineRecord:" + str);
        this.f390999h = str;
        String f16 = f(str);
        if (!TextUtils.isEmpty(f16) && !new File(f16).exists()) {
            QLog.d("TroopHWVoiceController", 1, "get local recordPath but file not exist");
            m(str);
            f16 = null;
        }
        if (this.f391001m != null && !TextUtils.isEmpty(f16)) {
            this.f391001m.i(1, str);
            l(f16);
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.troop_homework.jsp.TroopHWVoiceController.1
                @Override // java.lang.Runnable
                public void run() {
                    String h16 = TroopHomeworkHelper.h(TroopHWVoiceController.this.f390999h);
                    QLog.d("TroopHWVoiceController", 1, "downloadAudio result path:" + h16 + "," + TroopHWVoiceController.this.f390999h);
                    if (!TextUtils.isEmpty(h16)) {
                        Message obtainMessage = TroopHWVoiceController.this.E.obtainMessage();
                        obtainMessage.what = 0;
                        obtainMessage.obj = h16;
                        obtainMessage.sendToTarget();
                    }
                }
            }, null, false);
        }
    }

    public void k(int i3, String str) {
        if (!TextUtils.isEmpty(str) && this.C == null) {
            VoicePlayer voicePlayer = new VoicePlayer(str, new Handler(), RecordParams.b(str));
            this.C = voicePlayer;
            voicePlayer.y(BaseApplication.getContext());
            this.C.z();
            this.C.l(this);
            this.f391000i = i3;
            this.C.A();
        }
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.C == null) {
            int b16 = RecordParams.b(str);
            QLog.d("TroopHWVoiceController", 1, "do play type " + b16 + ", " + str);
            VoicePlayer voicePlayer = new VoicePlayer(str, new Handler(), b16);
            this.C = voicePlayer;
            voicePlayer.y(BaseApplication.getContext());
            this.C.z();
            this.C.l(this);
            this.C.A();
            return;
        }
        QLog.d("TroopHWVoiceController", 1, "play ignored for mPlayer is not null:" + str);
    }

    public void n(String str) {
        Context context;
        WeakReference<Context> weakReference = this.f390998f;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        SharedPreferences e16 = e(context);
        this.f390997e = e16;
        SharedPreferences.Editor edit = e16.edit();
        edit.putString(this.f390999h, str);
        edit.commit();
    }

    public boolean o() {
        VoicePlayer voicePlayer = this.C;
        if (voicePlayer != null) {
            voicePlayer.v();
            this.C = null;
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
        int i3 = this.f390996d - 200;
        this.f390996d = i3;
        this.E.sendEmptyMessageDelayed(2, i3);
        return this.f390996d + 200;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(String str, RecordParams.RecorderParam recorderParam, double d16) {
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).flush(str);
        this.f391001m.a(str, d16);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).cancelBufferTask(str);
        this.f391001m.f();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam) {
        byte[] a16 = RecordParams.a(recorderParam.f307257f, recorderParam.f307255d);
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).createBufferTask(str);
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(str, a16, a16.length);
        AudioUtil.n(R.raw.f169428z, false);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String str, byte[] bArr, int i3, int i16, double d16, RecordParams.RecorderParam recorderParam) {
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(str, bArr, i3);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        this.f391001m.g();
        return 250;
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        o();
        b bVar = this.f391001m;
        if (bVar == null) {
            return;
        }
        int i17 = this.f391000i;
        if (i17 > 0) {
            bVar.o(i17, str);
            this.f391000i = 0;
        } else {
            bVar.i(3, this.f390999h);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int i3) {
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}

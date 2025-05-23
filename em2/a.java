package em2;

import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.a;
import com.tencent.qcircle.weseevideo.model.MediaConfig;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat;
import com.tencent.ttpic.voicechanger.common.audio.VoiceChanger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements a.b {

    /* renamed from: o, reason: collision with root package name */
    public static int f396586o;

    /* renamed from: p, reason: collision with root package name */
    public static int f396587p;

    /* renamed from: c, reason: collision with root package name */
    private int f396590c;

    /* renamed from: f, reason: collision with root package name */
    private String f396593f;

    /* renamed from: g, reason: collision with root package name */
    protected VoiceChanger f396594g;

    /* renamed from: h, reason: collision with root package name */
    private int f396595h;

    /* renamed from: j, reason: collision with root package name */
    private String f396597j;

    /* renamed from: k, reason: collision with root package name */
    private AudioCapture.b f396598k;

    /* renamed from: n, reason: collision with root package name */
    com.tencent.mobileqq.videocodec.mediacodec.recorder.a f396601n;

    /* renamed from: a, reason: collision with root package name */
    private final String f396588a = "AudioChangerManager";

    /* renamed from: b, reason: collision with root package name */
    private RandomAccessFile f396589b = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f396591d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f396592e = false;

    /* renamed from: i, reason: collision with root package name */
    private String f396596i = null;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f396599l = null;

    /* renamed from: m, reason: collision with root package name */
    private int f396600m = 0;

    static {
        int i3 = AudioRecorderCompat.SAMPLE_RATES[4];
        f396586o = i3;
        f396587p = (int) (i3 * 0.02d * 1.0d * 4.0d);
    }

    public a(String str, int i3, AudioCapture.b bVar) {
        this.f396597j = null;
        this.f396597j = FileUtils.genSeperateFileDir(str) + "audio_data_cache" + File.separator;
        this.f396598k = bVar;
    }

    private boolean e() {
        if (f() && !TextUtils.isEmpty(this.f396597j) && this.f396598k != null) {
            return true;
        }
        return false;
    }

    private boolean f() {
        try {
            File file = new File(this.f396597j);
            if (!file.exists()) {
                return file.mkdir();
            }
            if (file.isFile()) {
                file.delete();
                return file.mkdir();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.a.b
    public void a() {
        ms.a.a("AudioChangerManager", "[onAudioFileEncodeFailed]");
        AudioCapture.b bVar = this.f396598k;
        if (bVar != null) {
            bVar.onAudioError(-6);
        }
        this.f396601n = null;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.a.b
    public void b() {
        ms.a.a("AudioChangerManager", "[onAudioFileEncoded]");
        this.f396598k.onAudioChangeCaptured(this.f396593f);
        this.f396601n = null;
    }

    public void c() {
        if (!e()) {
            return;
        }
        this.f396596i = this.f396597j + VidUtil.generateVid() + MediaConfig.AUDIO_PCM_FILE_POSTFIX;
        this.f396594g = new VoiceChanger(this.f396596i, f396586o, this.f396590c, this.f396595h);
        try {
            this.f396589b = new RandomAccessFile(this.f396596i, "rw");
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        }
        if (this.f396599l == null) {
            this.f396599l = new byte[f396587p];
        }
        this.f396600m = 0;
        if (this.f396592e && this.f396601n == null) {
            com.tencent.mobileqq.videocodec.mediacodec.recorder.a aVar = new com.tencent.mobileqq.videocodec.mediacodec.recorder.a();
            this.f396601n = aVar;
            aVar.l(CodecParam.mAudioSampleRate);
            this.f396601n.k(this);
            this.f396601n.h(this.f396593f);
            ms.a.a("AudioChangerManager", "New mHwAudioEncoder");
        }
    }

    public boolean d() {
        if (this.f396591d && FeatureManager.Features.PAG.isFunctionReady() && ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).lightSdkIsFunctionReadyWithConfig()) {
            return true;
        }
        return false;
    }

    public void g() {
        VoiceChanger voiceChanger = this.f396594g;
        if (voiceChanger != null) {
            voiceChanger.release();
        }
        RandomAccessFile randomAccessFile = this.f396589b;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        this.f396599l = null;
        com.tencent.mobileqq.videocodec.mediacodec.recorder.a aVar = this.f396601n;
        if (aVar != null) {
            aVar.i();
        }
        if (!this.f396592e) {
            this.f396598k.onAudioChangeCaptured(this.f396596i);
        }
    }
}

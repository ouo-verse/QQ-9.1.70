package com.tencent.mobileqq.ark.api.silk;

import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* loaded from: classes11.dex */
public class SilkAudioPlayer {

    /* renamed from: a, reason: collision with root package name */
    private VoicePlayer f199150a;

    /* renamed from: b, reason: collision with root package name */
    private final AudioManager f199151b;

    /* renamed from: c, reason: collision with root package name */
    private final b f199152c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f199153d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f199154e = false;

    /* renamed from: f, reason: collision with root package name */
    private final AudioManager.OnAudioFocusChangeListener f199155f = new a();

    /* loaded from: classes11.dex */
    class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            if (SilkAudioPlayer.this.f199150a != null && i3 == -1) {
                SilkAudioPlayer.this.f199152c.a1(false);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b extends VoicePlayer.a {
        void a1(boolean z16);

        void onDownloadFailed(int i3);

        void onDownloadFinish(File file);

        void onDownloadStart();

        void onError();

        void onPlayStart();

        void s1();
    }

    public SilkAudioPlayer(@NonNull b bVar) {
        if (bVar != null) {
            this.f199152c = bVar;
            this.f199151b = (AudioManager) BaseApplication.getContext().getSystemService("audio");
            return;
        }
        throw new NullPointerException("SilkAudioPlayer's listener is null");
    }

    private String e(String str) {
        try {
            if (!q.p(str)) {
                String transferFilePath = TransFileUtil.getTransferFilePath(BaseApplicationImpl.sApplication.getRuntime().getCurrentAccountUin(), MD5.toMD5(str), 23, null);
                File file = new File(transferFilePath);
                if (file.exists() && file.length() > 0) {
                    return transferFilePath;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("SilkAudioPlayer", 2, String.format("playLocal file not exist : %s", str));
                }
                return null;
            }
            return str;
        } catch (Exception e16) {
            QLog.e("SilkAudioPlayer", 1, "playLocal check resource file error ", e16);
            return null;
        }
    }

    private int g(String str) {
        try {
            synchronized (this.f199153d) {
                VoicePlayer voicePlayer = this.f199150a;
                if (voicePlayer != null) {
                    voicePlayer.v();
                    this.f199150a = null;
                }
                VoicePlayer voicePlayer2 = new VoicePlayer(str, new Handler(ThreadManagerV2.getSubThreadLooper()), 1);
                this.f199150a = voicePlayer2;
                voicePlayer2.l(this.f199152c);
                this.f199150a.A();
                AudioManager audioManager = this.f199151b;
                if (audioManager != null) {
                    audioManager.requestAudioFocus(this.f199155f, 3, 2);
                }
            }
            this.f199152c.s1();
            return 1;
        } catch (Exception e16) {
            this.f199152c.onError();
            QLog.e("SilkAudioPlayer", 1, "playLocal play audio error ", e16);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(String str) {
        String e16 = e(str);
        if (e16 == null) {
            return -1;
        }
        if (this.f199154e) {
            this.f199152c.onError();
            return 0;
        }
        return g(e16);
    }

    public void f(final String str) {
        this.f199154e = false;
        this.f199152c.onPlayStart();
        if (h(str) != -1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                SilkAudioPlayer.this.f199152c.onDownloadStart();
                String transferFilePath = TransFileUtil.getTransferFilePath(BaseApplicationImpl.sApplication.getRuntime().getCurrentAccountUin(), MD5.toMD5(str), 23, null);
                File file = new File(transferFilePath);
                int downloadData = HttpDownloadUtil.downloadData(BaseApplicationImpl.sApplication.getRuntime(), str, file);
                if (SilkAudioPlayer.this.f199154e) {
                    return;
                }
                if (downloadData == 0) {
                    SilkAudioPlayer.this.f199152c.onDownloadFinish(file);
                    SilkAudioPlayer.this.h(transferFilePath);
                } else {
                    SilkAudioPlayer.this.f199152c.onDownloadFailed(downloadData);
                }
            }
        }, 128, null, true);
    }

    public void i() {
        try {
            this.f199154e = true;
            synchronized (this.f199153d) {
                VoicePlayer voicePlayer = this.f199150a;
                if (voicePlayer != null) {
                    voicePlayer.v();
                    this.f199150a = null;
                }
                AudioManager audioManager = this.f199151b;
                if (audioManager != null) {
                    audioManager.abandonAudioFocus(this.f199155f);
                }
            }
        } catch (Exception e16) {
            QLog.e("SilkAudioPlayer", 1, "stop e=" + e16);
        }
    }
}

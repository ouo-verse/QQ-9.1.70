package com.tencent.mobileqq.qqexpand.widget.voice;

import android.media.AudioManager;
import android.os.Handler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ExpandVoicePlayer {

    /* renamed from: a, reason: collision with root package name */
    private VoicePlayer f264275a;

    /* renamed from: b, reason: collision with root package name */
    private final QBaseActivity f264276b;

    /* renamed from: c, reason: collision with root package name */
    private final AudioManager f264277c;

    /* renamed from: d, reason: collision with root package name */
    private final b f264278d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f264279e = false;

    /* renamed from: f, reason: collision with root package name */
    private final Object f264280f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private final AudioManager.OnAudioFocusChangeListener f264281g = new a();

    /* loaded from: classes16.dex */
    class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            if (ExpandVoicePlayer.this.f264275a != null && i3 == -1 && ExpandVoicePlayer.this.f264278d != null) {
                ExpandVoicePlayer.this.f264278d.a1(false);
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface b extends VoicePlayer.a {
        void a1(boolean z16);

        void onDownloadFailed(int i3);

        void onDownloadFinish(File file);
    }

    public ExpandVoicePlayer(b bVar, QBaseActivity qBaseActivity) {
        this.f264278d = bVar;
        this.f264276b = qBaseActivity;
        this.f264277c = (AudioManager) qBaseActivity.getSystemService("audio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppRuntime g() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        if (g() != null) {
            return g().getCurrentAccountUin();
        }
        return "";
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoicePlayer", 2, "abandonAudioFocus");
        }
        AudioManager audioManager = this.f264277c;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.f264281g);
        }
    }

    public void i(final String str) {
        if (!j(str)) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ExpandVoicePlayer.this.f264276b != null && ExpandVoicePlayer.this.f264276b.isFinishing()) {
                        QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file not exist download on executeOnFileThread but activity isFinishing");
                        return;
                    }
                    QLog.i("ExtendFriendVoicePlayer", 2, "playLocal file not exist executeOnFileThread");
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(TransFileUtil.getTransferFilePath(ExpandVoicePlayer.this.h(), MD5.toMD5(str), 23, null));
                    File file = new File(sDKPrivatePath);
                    int downloadData = HttpDownloadUtil.downloadData(ExpandVoicePlayer.this.g(), str, file);
                    if (downloadData == 0) {
                        ExpandVoicePlayer.this.f264278d.onDownloadFinish(file);
                        ExpandVoicePlayer.this.j(sDKPrivatePath);
                    } else {
                        ExpandVoicePlayer.this.f264278d.onDownloadFailed(downloadData);
                    }
                }
            });
        }
    }

    public boolean j(String str) {
        QBaseActivity qBaseActivity = this.f264276b;
        if (qBaseActivity != null && qBaseActivity.isFinishing()) {
            QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file but activity isFinish");
            return false;
        }
        try {
            if (!q.p(str) && this.f264276b != null) {
                String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(TransFileUtil.getTransferFilePath(h(), MD5.toMD5(str), 23, null));
                File file = new File(sDKPrivatePath);
                if (file.exists() && file.length() > 0) {
                    str = sDKPrivatePath;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("ExtendFriendVoicePlayer", 2, String.format("playLocal file not exist : %s", str));
                }
                return false;
            }
            synchronized (this.f264280f) {
                VoicePlayer voicePlayer = this.f264275a;
                if (voicePlayer != null) {
                    voicePlayer.v();
                    this.f264275a = null;
                }
                VoicePlayer voicePlayer2 = new VoicePlayer(str, new Handler(), 1);
                this.f264275a = voicePlayer2;
                voicePlayer2.z();
                this.f264275a.l(this.f264278d);
                this.f264275a.A();
                AudioManager audioManager = this.f264277c;
                if (audioManager != null) {
                    audioManager.requestAudioFocus(this.f264281g, 3, 2);
                }
            }
            return true;
        } catch (Exception e16) {
            QLog.e("ExtendFriendVoicePlayer", 1, "playLocal", e16);
            return false;
        }
    }

    public void k() {
        try {
            synchronized (this.f264280f) {
                VoicePlayer voicePlayer = this.f264275a;
                if (voicePlayer != null) {
                    voicePlayer.v();
                    this.f264275a = null;
                }
                a();
            }
        } catch (Exception e16) {
            QLog.e("ExtendFriendVoicePlayer", 1, "stop e=" + e16);
        }
    }
}

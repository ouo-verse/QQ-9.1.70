package com.tencent.mobileqq.qqaudio.audioplayer;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.f;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.util.List;

/* loaded from: classes16.dex */
public class AudioPlayer extends AudioPlayerBase {
    static IPatchRedirector $redirector_;
    private boolean P;
    private boolean Q;
    private boolean R;
    f.a[] S;
    private BroadcastReceiver T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements BluetoothProfile.ServiceListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f262115a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f262116b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BluetoothAdapter f262117c;

        a(String str, int i3, BluetoothAdapter bluetoothAdapter) {
            this.f262115a = str;
            this.f262116b = i3;
            this.f262117c = bluetoothAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AudioPlayer.this, str, Integer.valueOf(i3), bluetoothAdapter);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i3, BluetoothProfile bluetoothProfile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bluetoothProfile);
                return;
            }
            if (i3 == 1) {
                BluetoothHeadset bluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
                List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
                if (connectedDevices != null && connectedDevices.size() > 0) {
                    BluetoothDevice bluetoothDevice = connectedDevices.get(0);
                    if (bluetoothDevice != null && bluetoothDevice.getBluetoothClass() != null) {
                        c.f262174c = bluetoothDevice.getBluetoothClass().getDeviceClass();
                    } else {
                        c.f262174c = 0;
                    }
                } else {
                    c.f262174c = 0;
                }
                AudioPlayer.this.v(this.f262115a, this.f262116b);
                this.f262117c.closeProfileProxy(1, bluetoothHeadset);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f262119a;

        /* renamed from: b, reason: collision with root package name */
        int f262120b;

        /* renamed from: c, reason: collision with root package name */
        boolean f262121c;

        /* renamed from: d, reason: collision with root package name */
        long f262122d;

        /* renamed from: e, reason: collision with root package name */
        long f262123e;

        b(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AudioPlayer.this, str, Integer.valueOf(i3));
                return;
            }
            this.f262121c = false;
            this.f262122d = 0L;
            this.f262123e = 0L;
            this.f262119a = str;
            this.f262120b = i3;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_Old", 2, "onReceive ACTION_SCO_AUDIO_STATE_UPDATED = " + intExtra + " " + this.f262119a + ", time=" + uptimeMillis);
            }
            if (1 == intExtra) {
                if (this.f262123e == 0) {
                    this.f262123e = uptimeMillis;
                    AudioPlayer audioPlayer = AudioPlayer.this;
                    audioPlayer.R(audioPlayer.f262129i);
                    AudioPlayerBase.N = true;
                    if (!AudioPlayer.this.r()) {
                        AudioPlayer.this.v(this.f262119a, this.f262120b);
                        return;
                    }
                    return;
                }
                return;
            }
            if (2 == intExtra) {
                this.f262121c = true;
                return;
            }
            if (intExtra == 0) {
                if (this.f262122d == 0) {
                    this.f262122d = uptimeMillis;
                    return;
                }
                if (this.f262121c) {
                    AudioPlayer.this.H();
                }
                long j3 = this.f262123e;
                if ((j3 != 0 && uptimeMillis - j3 <= 2000) || uptimeMillis - this.f262122d <= 1000) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioPlayer_Old", 2, "sco disconnected quickly.");
                    }
                    c.f262175d = true;
                    if (AudioPlayer.this.Q && !AudioPlayer.this.f262129i.isBluetoothA2dpOn()) {
                        AudioPlayer.this.Q = false;
                    }
                    if (!AudioPlayer.this.r()) {
                        AudioPlayer.this.v(this.f262119a, this.f262120b);
                        return;
                    } else {
                        AudioPlayer.this.w(0);
                        return;
                    }
                }
                if (AudioPlayer.this.r()) {
                    AudioPlayer audioPlayer2 = AudioPlayer.this;
                    audioPlayer2.w(audioPlayer2.f262128h.getCurrentPosition());
                }
            }
        }
    }

    public AudioPlayer(Context context, AudioPlayerBase.b bVar) {
        super(context, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.P = false;
        this.Q = false;
        this.R = true;
    }

    private int O(Context context) {
        if (context == null) {
            return 0;
        }
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) context.getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                QLog.d("AudioPlayer_Old", 1, "checkHasBluetoothDeviceConnected device: " + ((Object) audioDeviceInfo.getProductName()) + " type: " + audioDeviceInfo.getType());
                return audioDeviceInfo.getType();
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(AudioManager audioManager) {
        audioManager.setBluetoothScoOn(true);
    }

    private void U(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_Old", 2, "tryStartBlueToothSco " + str);
        }
        V();
        b bVar = new b(str, i3);
        this.f262130m.registerReceiver(bVar, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        this.T = bVar;
        this.f262129i.startBluetoothSco();
    }

    private void V() {
        if (this.T != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_Old", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
            }
            try {
                this.f262130m.unregisterReceiver(this.T);
            } catch (Exception unused) {
            }
            this.T = null;
        }
    }

    public void N(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        if (com.tencent.mobileqq.inject.a.f238063a.a() >= 31 && Build.VERSION.SDK_INT >= 31 && BaseApplication.getContext().checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) != 0) {
            c.f262174c = O(BaseApplication.getContext());
            v(str, i3);
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            c.f262174c = 0;
            v(str, i3);
            return;
        }
        if (!defaultAdapter.isEnabled()) {
            c.f262174c = 0;
            v(str, i3);
        } else if (defaultAdapter.getProfileConnectionState(1) != 2) {
            c.f262174c = 0;
            v(str, i3);
        } else if (defaultAdapter.getProfileConnectionState(2) == 2) {
            c.f262174c = 0;
            v(str, i3);
        } else {
            defaultAdapter.getProfileProxy(BaseApplication.getContext(), new a(str, i3, defaultAdapter), 1);
        }
    }

    public void P(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.Q = z16;
        if (r()) {
            w(this.f262128h.getCurrentPosition() - f.f262189a);
        }
    }

    public void Q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        this.P = z16;
        if (r()) {
            w(this.f262128h.getCurrentPosition() - f.f262189a);
        }
    }

    public boolean S(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, z16)).booleanValue();
        }
        return T(z16, false, 0);
    }

    public boolean T(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3))).booleanValue();
        }
        if (this.P || this.Q || (z16 == this.R && !z17)) {
            return false;
        }
        this.R = z16;
        if (r()) {
            w(i3);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase, com.tencent.mobileqq.qqaudio.audioplayer.j
    public void a(i iVar, int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, iVar, Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
        } else {
            V();
            super.a(iVar, i3, i16, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase, com.tencent.mobileqq.qqaudio.audioplayer.j
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            V();
            super.b(str);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (this.Q && !this.f262129i.isBluetoothA2dpOn()) {
            this.Q = false;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    protected f.a p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (f.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.S == null) {
            this.S = f.a();
        }
        if (this.f262129i.isBluetoothScoOn() && c.f262173b) {
            return this.S[4];
        }
        if (this.P) {
            return this.S[2];
        }
        if (this.Q) {
            return this.S[3];
        }
        return this.S[!this.R ? 1 : 0];
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9 A[Catch: Exception -> 0x0136, all -> 0x015a, TRY_ENTER, TryCatch #7 {Exception -> 0x0136, blocks: (B:30:0x0046, B:46:0x00b9, B:47:0x00e8, B:53:0x00c2, B:70:0x0135), top: B:29:0x0046, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0111 A[Catch: all -> 0x015a, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:14:0x001c, B:18:0x002d, B:20:0x0033, B:23:0x0038, B:25:0x0040, B:30:0x0046, B:42:0x007a, B:46:0x00b9, B:47:0x00e8, B:48:0x010b, B:50:0x0111, B:53:0x00c2, B:63:0x00b3, B:72:0x0132, B:70:0x0135, B:82:0x0137, B:84:0x013d, B:85:0x0146), top: B:2:0x0001, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c2 A[Catch: Exception -> 0x0136, all -> 0x015a, TryCatch #7 {Exception -> 0x0136, blocks: (B:30:0x0046, B:46:0x00b9, B:47:0x00e8, B:53:0x00c2, B:70:0x0135), top: B:29:0x0046, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095 A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #6 {all -> 0x008a, blocks: (B:33:0x004a, B:56:0x008f, B:58:0x0095), top: B:32:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected synchronized boolean v(String str, int i3) {
        byte b16;
        byte b17;
        int i16;
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (i3 < 0) {
            i3 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.C = str;
        ThreadManagerV2.remove(this);
        if (!h()) {
            return false;
        }
        if (c.f262174c == -1) {
            N(str, i3);
            return true;
        }
        if (c.h(this.f262129i)) {
            U(str, i3);
            return true;
        }
        try {
            I();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e16) {
                e = e16;
            }
            try {
                try {
                    b17 = QQAudioUtils.f(fileInputStream);
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream2 = fileInputStream;
                    b16 = -1;
                    if (QLog.isColorLevel()) {
                    }
                    if (fileInputStream2 != null) {
                    }
                    b17 = b16;
                    if (b17 >= 0) {
                    }
                    com.tencent.mobileqq.qqaudio.b.a(i16);
                    this.f262128h.setDataSource(str);
                    this.f262128h.seekTo(i3);
                    this.f262128h.b(-1, b17);
                    this.f262128h.d(this);
                    this.f262128h.a(this.f262126e);
                    this.f262128h.start();
                    if (QLog.isColorLevel()) {
                    }
                    return true;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioPlayer_Old", 2, "try start path=" + str + " fsType=" + ((int) b17));
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                        if (b17 >= 0) {
                        }
                        com.tencent.mobileqq.qqaudio.b.a(i16);
                        this.f262128h.setDataSource(str);
                        this.f262128h.seekTo(i3);
                        this.f262128h.b(-1, b17);
                        this.f262128h.d(this);
                        this.f262128h.a(this.f262126e);
                        this.f262128h.start();
                        if (QLog.isColorLevel()) {
                        }
                        return true;
                    }
                } catch (Exception e18) {
                    e = e18;
                    b16 = b17;
                    fileInputStream2 = fileInputStream;
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioPlayer_Old", 2, "play exception" + e.getMessage());
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    b17 = b16;
                    if (b17 >= 0) {
                        this.f262128h = new SilkPlayer();
                        i16 = 1;
                    } else {
                        this.f262128h = new AmrPlayer();
                        QLog.e("AudioPlayer_Old", 1, "play : fsType = " + ((int) b17) + ", use amrPlayer");
                        i16 = 2;
                    }
                    com.tencent.mobileqq.qqaudio.b.a(i16);
                    this.f262128h.setDataSource(str);
                    this.f262128h.seekTo(i3);
                    this.f262128h.b(-1, b17);
                    this.f262128h.d(this);
                    this.f262128h.a(this.f262126e);
                    this.f262128h.start();
                    if (QLog.isColorLevel()) {
                        QLog.d("zivonchen", 2, "play music time = " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    return true;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_Old", 2, "play on error, ", e19);
            }
            a(this.f262128h, 2, 0, e19.toString(), this.f262128h.c());
            return false;
        }
    }
}

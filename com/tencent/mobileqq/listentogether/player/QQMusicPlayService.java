package com.tencent.mobileqq.listentogether.player;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import mqq.app.NewIntent;

/* loaded from: classes15.dex */
public class QQMusicPlayService extends Service implements MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    private static volatile ISong F;
    private static volatile int G;
    private static volatile int H;
    private static MediaPlayer I;
    private static boolean J;
    private static boolean K;
    private static boolean L;
    private static int M;
    private HandlerThread D;
    private b E;

    /* renamed from: d, reason: collision with root package name */
    private c f241093d;

    /* renamed from: e, reason: collision with root package name */
    private Messenger f241094e;

    /* renamed from: f, reason: collision with root package name */
    private d f241095f;

    /* renamed from: i, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f241097i;

    /* renamed from: h, reason: collision with root package name */
    private final LinkedHashSet<Messenger> f241096h = new LinkedHashSet<>();

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f241098m = false;
    private volatile boolean C = false;

    /* renamed from: com.tencent.mobileqq.listentogether.player.QQMusicPlayService$3, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f241099d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f241100e;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f241099d) {
                this.f241100e[0] = QQMusicPlayService.E();
                this.f241099d.notifyAll();
            }
        }
    }

    /* loaded from: classes15.dex */
    class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,focusChange:" + i3);
            try {
                synchronized (QQMusicPlayService.this) {
                    if (i3 != -3) {
                        if (i3 != -2) {
                            if (i3 != -1) {
                                if (i3 == 1) {
                                    if (QQMusicPlayService.G == 3 && QQMusicPlayService.I != null && !QQMusicPlayService.I.isPlaying() && !QQMusicPlayService.this.C) {
                                        QQMusicPlayService.I.setVolume(1.0f, 1.0f);
                                    }
                                    QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,gain focus");
                                    QQMusicPlayService.this.Q(true, false);
                                }
                            } else {
                                if (QQMusicPlayService.I != null && QQMusicPlayService.I.isPlaying()) {
                                    QQMusicPlayService.I.stop();
                                    QQMusicPlayService.this.S(QQMusicPlayService.H(), 4);
                                    QQMusicPlayReport.b(QQMusicPlayService.L, QQMusicPlayService.M);
                                }
                                QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,loss focus permanent");
                                QQMusicPlayService.this.Q(false, false);
                                if (QQMusicPlayService.this.E != null) {
                                    QQMusicPlayService.this.E.sendEmptyMessage(11);
                                }
                            }
                        } else {
                            if (QQMusicPlayService.I != null && QQMusicPlayService.I.isPlaying()) {
                                QQMusicPlayService.I.pause();
                                QQMusicPlayService.this.S(QQMusicPlayService.H(), 3);
                            }
                            QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,loss focus transient");
                            QQMusicPlayService.this.Q(false, true);
                        }
                    } else {
                        if (QQMusicPlayService.I != null && QQMusicPlayService.I.isPlaying() && !QQMusicPlayService.this.C) {
                            QQMusicPlayService.I.setVolume(0.5f, 0.5f);
                        }
                        QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,temporarily lost audio focus");
                    }
                }
            } catch (Exception e16) {
                QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange:" + e16.getMessage(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QQMusicPlayService> f241102a;

        b(QQMusicPlayService qQMusicPlayService, Looper looper) {
            super(looper);
            this.f241102a = new WeakReference<>(qQMusicPlayService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            QQMusicPlayService qQMusicPlayService = this.f241102a.get();
            if (qQMusicPlayService == null) {
                super.handleMessage(message);
                return;
            }
            try {
                int i16 = message.what;
                boolean z16 = false;
                if (i16 != 1) {
                    switch (i16) {
                        case 6:
                            if (QQMusicPlayService.I == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_START_PLAY], sPlayer is null");
                                    return;
                                }
                                return;
                            }
                            Bundle data = message.getData();
                            data.setClassLoader(ISong.class.getClassLoader());
                            ISong iSong = (ISong) data.getParcelable("key_song");
                            if (iSong != null && iSong.Q() != null && iSong.Q().size() != 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] [%s]", iSong));
                                }
                                if (!iSong.equals(QQMusicPlayService.F) || (QQMusicPlayService.G != 2 && QQMusicPlayService.G != 1)) {
                                    if (QQMusicPlayService.I.isPlaying()) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "------------stopped-------------");
                                        }
                                        QQMusicPlayService.I.stop();
                                        QQMusicPlayReport.b(QQMusicPlayService.L, QQMusicPlayService.M);
                                    }
                                    qQMusicPlayService.S(QQMusicPlayService.H(), 0);
                                    qQMusicPlayService.f241098m = false;
                                    qQMusicPlayService.U(iSong);
                                    qQMusicPlayService.N(iSong);
                                    if (iSong.S() > 0) {
                                        qQMusicPlayService.M(iSong.S());
                                        return;
                                    }
                                    return;
                                }
                                int E = QQMusicPlayService.E();
                                int abs = E < 0 ? -1 : Math.abs(E - iSong.S());
                                if (QQMusicPlayService.G == 2 && (E < 0 || Math.abs(E - iSong.S()) > 3000)) {
                                    QQMusicPlayService.M++;
                                    qQMusicPlayService.M(iSong.S());
                                    z16 = true;
                                }
                                QLog.i("ListenTogether.Seek", 1, "player start play player seek: " + E + " music seek: " + iSong.S() + " currentTime: " + System.currentTimeMillis());
                                if (z16) {
                                    QQMusicPlayReport.c(abs, NetworkUtil.getNetworkType(qQMusicPlayService));
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] err url is null [%s]", iSong));
                                return;
                            }
                            return;
                        case 7:
                            if (QQMusicPlayService.I == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY], sPlayer is null");
                                    return;
                                }
                                return;
                            }
                            QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY]");
                            if (QQMusicPlayService.G == 2 || (QQMusicPlayService.G == 1 && QQMusicPlayService.I != null)) {
                                ((AudioManager) qQMusicPlayService.getSystemService("audio")).abandonAudioFocus(qQMusicPlayService.f241097i);
                                if (QQMusicPlayService.I.isPlaying()) {
                                    QQMusicPlayService.I.pause();
                                }
                                qQMusicPlayService.f241098m = true;
                                qQMusicPlayService.S(QQMusicPlayService.H(), 3);
                                return;
                            }
                            return;
                        case 8:
                            if (QQMusicPlayService.I == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY], sPlayer is null");
                                    return;
                                }
                                return;
                            }
                            QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY]");
                            if (QQMusicPlayService.G != 3 || QQMusicPlayService.I == null) {
                                if (QQMusicPlayService.G != 6) {
                                    if (QQMusicPlayService.G == 5) {
                                        qQMusicPlayService.f241098m = false;
                                        qQMusicPlayService.N(QQMusicPlayService.F);
                                        return;
                                    }
                                    return;
                                }
                                if (NetworkUtil.isNetworkAvailable(qQMusicPlayService.getApplicationContext())) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("QQMusicPlay.QQMusicPlayService", 2, String.format("resume from network interrupt, start play %s", QQMusicPlayService.F));
                                    }
                                    qQMusicPlayService.f241098m = false;
                                    qQMusicPlayService.N(QQMusicPlayService.F);
                                    return;
                                }
                                return;
                            }
                            qQMusicPlayService.f241098m = false;
                            AudioManager audioManager = (AudioManager) qQMusicPlayService.getSystemService("audio");
                            int requestAudioFocus = audioManager.requestAudioFocus(qQMusicPlayService.f241097i, 3, 1);
                            boolean isMusicActive = audioManager.isMusicActive();
                            if (QLog.isColorLevel()) {
                                QLog.d("QQMusicPlay.QQMusicPlayService", 2, "resumePlay requestAudioFocus,result:" + requestAudioFocus + " isMusicActive:" + isMusicActive);
                            }
                            if (requestAudioFocus == 1) {
                                QQMusicPlayService.I.start();
                                qQMusicPlayService.S(QQMusicPlayService.H(), 2);
                                return;
                            } else {
                                qQMusicPlayService.S(QQMusicPlayService.H(), 7);
                                if (qQMusicPlayService.E != null) {
                                    qQMusicPlayService.E.sendEmptyMessage(11);
                                    return;
                                }
                                return;
                            }
                        case 9:
                            qQMusicPlayService.C = message.getData().getBoolean("key_mute", false);
                            if (QLog.isColorLevel()) {
                                QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_MUTE_PLAY] %b", Boolean.valueOf(qQMusicPlayService.C)));
                            }
                            if (QQMusicPlayService.I != null) {
                                float f16 = qQMusicPlayService.C ? 0.0f : 1.0f;
                                QQMusicPlayService.I.setVolume(f16, f16);
                                return;
                            }
                            return;
                        case 10:
                        case 11:
                            if (QQMusicPlayService.I == null) {
                                if (QLog.isColorLevel()) {
                                    Object[] objArr = new Object[1];
                                    objArr[0] = Boolean.valueOf(message.what == 10);
                                    QLog.e("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b],sPlayer is null", objArr));
                                    return;
                                }
                                return;
                            }
                            Object[] objArr2 = new Object[1];
                            objArr2[0] = Boolean.valueOf(message.what == 10);
                            QLog.d("QQMusicPlay.QQMusicPlayService", 1, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b]", objArr2));
                            if (QQMusicPlayService.I != null && QQMusicPlayService.I.isPlaying()) {
                                QQMusicPlayService.I.stop();
                                QQMusicPlayReport.b(QQMusicPlayService.L, QQMusicPlayService.M);
                            }
                            ((AudioManager) qQMusicPlayService.getSystemService("audio")).abandonAudioFocus(qQMusicPlayService.f241097i);
                            qQMusicPlayService.f241098m = true;
                            qQMusicPlayService.S(QQMusicPlayService.H(), 4);
                            qQMusicPlayService.stopSelf();
                            return;
                        case 12:
                            e eVar = (e) message.obj;
                            if (eVar == null) {
                                return;
                            }
                            Object[] objArr3 = new Object[1];
                            objArr3[0] = QQMusicPlayService.F == null ? "null" : QQMusicPlayService.F.getId();
                            QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("--->handleMessage[MSG_FROM_SERVICE_RELEASE] [%s]", objArr3));
                            qQMusicPlayService.f241096h.clear();
                            MediaPlayer mediaPlayer = eVar.f241106a;
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                                if (QQMusicPlayService.I == eVar.f241106a) {
                                    QQMusicPlayService.I = null;
                                }
                            }
                            getLooper().quit();
                            return;
                        case 13:
                            break;
                        case 14:
                            if (QQMusicPlayService.G == 2) {
                                qQMusicPlayService.E.sendEmptyMessageDelayed(14, 500L);
                                break;
                            } else {
                                qQMusicPlayService.E.removeMessages(14);
                                break;
                            }
                        default:
                            super.handleMessage(message);
                            return;
                    }
                    if (QLog.isColorLevel() && (i3 = message.what) == 13) {
                        Object[] objArr4 = new Object[1];
                        objArr4[0] = Boolean.valueOf(i3 == 13);
                        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_SYNC_PROGRESS=%b]", objArr4));
                    }
                    if (QQMusicPlayService.F != null) {
                        qQMusicPlayService.T(QQMusicPlayService.H(), QQMusicPlayService.E(), QQMusicPlayService.H);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT]");
                }
                Messenger messenger = message.replyTo;
                if (messenger != null) {
                    qQMusicPlayService.B(messenger);
                    Message obtain = Message.obtain((Handler) null, 0);
                    obtain.setData(new Bundle());
                    try {
                        messenger.send(obtain);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT] sendToClient excepiton", e16);
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage exception==>", th5);
            }
        }
    }

    /* loaded from: classes15.dex */
    private static class c implements INetInfoHandler {

        /* renamed from: d, reason: collision with root package name */
        long f241103d = 0;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<QQMusicPlayService> f241104e;

        c(QQMusicPlayService qQMusicPlayService) {
            this.f241104e = new WeakReference<>(qQMusicPlayService);
        }

        private void a(int i3) {
            QQMusicPlayService qQMusicPlayService = this.f241104e.get();
            if (qQMusicPlayService == null || System.currentTimeMillis() - this.f241103d < 500) {
                return;
            }
            this.f241103d = System.currentTimeMillis();
            boolean z16 = true;
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 6) {
                z16 = false;
            }
            qQMusicPlayService.R(z16);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            a(4);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            a(3);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            a(1);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            a(2);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            a(6);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            a(5);
        }
    }

    /* loaded from: classes15.dex */
    private class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                QLog.d("QQMusicPlay.QQMusicPlayService", 1, "QQMusicPlayBroadcastReceiver onReceive,action:" + intent.getAction());
                String action = intent.getAction();
                if (action != null) {
                    if (!action.equals(QQAppInterface.QQ_ACTION_LOGOUT) && !action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_ACCOUNT_KICKED) && !action.equals(NewIntent.ACTION_FORCE_LOGOUT)) {
                        if (!action.equals("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName()) && !action.equals(NewIntent.ACTION_LOGOUT) && !action.equals("QQMusicPlay_exit_action")) {
                            return;
                        }
                    }
                    if (QQMusicPlayService.this.E != null) {
                        QQMusicPlayService.this.E.sendEmptyMessage(11);
                    } else {
                        QQMusicPlayService.this.stopSelf();
                    }
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    private class e {

        /* renamed from: a, reason: collision with root package name */
        MediaPlayer f241106a;

        /* renamed from: b, reason: collision with root package name */
        ISong f241107b;

        e(MediaPlayer mediaPlayer, ISong iSong) {
            this.f241106a = mediaPlayer;
            this.f241107b = iSong;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Messenger messenger) {
        Iterator<Messenger> it = this.f241096h.iterator();
        while (it.hasNext()) {
            if (!it.next().getBinder().isBinderAlive()) {
                it.remove();
            }
        }
        this.f241096h.add(messenger);
    }

    public static ISong C() {
        return F;
    }

    public static int D() {
        return H;
    }

    public static int E() {
        if (I != null && (G == 2 || G == 3)) {
            try {
                return I.getCurrentPosition();
            } catch (Exception e16) {
                QLog.d("QQMusicPlay.QQMusicPlayService", 1, "getPlayPosition exception state=", ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).getPlayStateStr(G), e16.getStackTrace());
                return -1;
            }
        }
        if (!QLog.isColorLevel()) {
            return -1;
        }
        QLog.d("QQMusicPlay.QQMusicPlayService", 2, "getPlayPosition  -1");
        return -1;
    }

    public static int F() {
        return G;
    }

    public static String G() {
        ISong iSong = F;
        if (iSong != null) {
            if (G == 1 || G == 2 || G == 3) {
                return iSong.getId();
            }
            return null;
        }
        return null;
    }

    public static String H() {
        ISong iSong = F;
        if (iSong != null) {
            return iSong.getId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        I = reportMediaPlayer;
        reportMediaPlayer.setOnErrorListener(this);
        I.setOnPreparedListener(this);
        I.setOnCompletionListener(this);
        I.setOnBufferingUpdateListener(this);
        I.setAudioStreamType(3);
    }

    private boolean J() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QQMusicPlayService");
        this.D = baseHandlerThread;
        try {
            baseHandlerThread.start();
            this.E = new b(this, this.D.getLooper());
            return false;
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                QLog.e("QQMusicPlay.QQMusicPlayService", 1, "initThread exception, stop self ==>", th5);
                stopSelf();
                if (this.E == null) {
                    return true;
                }
                return false;
            } catch (Throwable th6) {
                if (this.E == null) {
                    return true;
                }
                throw th6;
            }
        }
    }

    public static boolean K() {
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlay.QQMusicPlayService", 2, "isPlaying : sPlayState " + ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).getPlayStateStr(G));
        }
        if (G == 2 || G == 1) {
            return true;
        }
        return false;
    }

    public static void L(String str) {
        if (K()) {
            Intent intent = new Intent();
            intent.setAction("QQMusicPlay_exit_action");
            BaseApplicationImpl.getApplication().getApplicationContext().sendBroadcast(intent);
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("notifyExit by[%s]", str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3) {
        if (I != null) {
            if (G == 2 || G == 3) {
                try {
                    I.seekTo(i3);
                } catch (IllegalStateException e16) {
                    e16.printStackTrace();
                    QLog.e("QQMusicPlay.QQMusicPlayService", 1, "seekTo", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(ISong iSong) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        String I2 = iSong.I();
        boolean z17 = false;
        L = false;
        M = 0;
        if (!TextUtils.isEmpty(I2) && new File(I2).exists() && new File(I2).canRead()) {
            L = true;
            P(I2);
            arrayList.add(Uri.fromFile(new File(I2)).toString());
            z16 = true;
        } else {
            if (!J) {
                O();
                S(iSong.getId(), 6);
            } else if (iSong.Q() != null) {
                arrayList.addAll(iSong.Q());
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("realStartPlay urls=[%s]", Arrays.toString(arrayList.toArray())));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            try {
                O();
                I.setDataSource((String) arrayList.get(i3));
                S(iSong.getId(), 1);
                I.prepare();
                z17 = true;
                break;
            } catch (IOException e16) {
                QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IOException => ", Integer.valueOf(i3)), e16);
                O();
                if (i3 == arrayList.size() - 1) {
                    S(iSong.getId(), 6);
                }
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
                QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalArgumentException => ", Integer.valueOf(i3)), e17);
            } catch (IllegalStateException e18) {
                e18.printStackTrace();
                QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalStateException => ", Integer.valueOf(i3)), e18);
            } catch (SecurityException e19) {
                e19.printStackTrace();
                QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] SecurityException => ", Integer.valueOf(i3)), e19);
            } catch (Throwable th5) {
                QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] Throwable => ", Integer.valueOf(i3)), th5);
                O();
                if (i3 == arrayList.size() - 1) {
                    S(iSong.getId(), 6);
                }
            }
            i3++;
        }
        I.start();
        if (z17) {
            S(iSong.getId(), 2);
        }
        QQMusicPlayReport.a(z16, NetworkUtil.getNetworkType(this));
    }

    private void O() {
        MediaPlayer mediaPlayer = I;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.RandomAccessFile] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void P(String str) {
        Throwable th5;
        IOException e16;
        RandomAccessFile randomAccessFile;
        try {
            try {
                randomAccessFile = new RandomAccessFile(new File((String) str), "rw");
            } catch (IOException e17) {
                e16 = e17;
                randomAccessFile = null;
            } catch (Throwable th6) {
                th5 = th6;
                str = 0;
                if (str != 0) {
                }
                throw th5;
            }
            try {
                byte readByte = randomAccessFile.readByte();
                randomAccessFile.seek(0L);
                randomAccessFile.write(readByte);
                str = randomAccessFile;
            } catch (IOException e18) {
                e16 = e18;
                e16.printStackTrace();
                str = randomAccessFile;
                if (randomAccessFile == null) {
                    return;
                }
                str.close();
            }
            try {
                str.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (str != 0) {
                try {
                    str.close();
                } catch (IOException unused2) {
                }
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Q(boolean z16, boolean z17) {
        K = z16;
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateFocusStateNotify [%b_%b]", Boolean.valueOf(z16), Boolean.valueOf(z17)));
        }
        Iterator<Messenger> it = this.f241096h.iterator();
        while (it.hasNext()) {
            Messenger next = it.next();
            try {
                if (next.getBinder().isBinderAlive()) {
                    Message obtain = Message.obtain((Handler) null, 4);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("key_focus_state", z16);
                    bundle.putBoolean("key_focus_transient", z17);
                    obtain.setData(bundle);
                    next.send(obtain);
                }
            } catch (RemoteException e16) {
                QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateFocusStateNotify sendToClient exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void R(boolean z16) {
        J = z16;
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateNetStateNotify [%b]", Boolean.valueOf(z16)));
        }
        Iterator<Messenger> it = this.f241096h.iterator();
        while (it.hasNext()) {
            Messenger next = it.next();
            try {
                if (next.getBinder().isBinderAlive()) {
                    Message obtain = Message.obtain((Handler) null, 3);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("key_net_state", z16);
                    obtain.setData(bundle);
                    next.send(obtain);
                }
            } catch (RemoteException e16) {
                QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateNetStateNotify sendToClient exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void S(String str, int i3) {
        b bVar;
        if (i3 >= 0 && i3 <= 8) {
            G = i3;
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updatePlayStateNotify %s [state=%s]", str, ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).getPlayStateStr(i3)));
            }
            if (G == 2 && (bVar = this.E) != null) {
                bVar.sendEmptyMessage(14);
            }
            if (!TextUtils.isEmpty(str)) {
                Iterator<Messenger> it = this.f241096h.iterator();
                while (it.hasNext()) {
                    Messenger next = it.next();
                    try {
                        if (next.getBinder().isBinderAlive()) {
                            Message obtain = Message.obtain((Handler) null, 2);
                            Bundle bundle = new Bundle();
                            bundle.putString("key_id", str);
                            bundle.putInt("key_play_state", i3);
                            obtain.setData(bundle);
                            next.send(obtain);
                        }
                    } catch (RemoteException e16) {
                        QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updatePlayStateNotify sendToClient exception", e16);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("playState value " + i3 + " is illegal.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void T(String str, int i3, int i16) {
        Iterator<Messenger> it = this.f241096h.iterator();
        while (it.hasNext()) {
            Messenger next = it.next();
            try {
                if (next.getBinder().isBinderAlive()) {
                    Message obtain = Message.obtain((Handler) null, 15);
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_position", i3);
                    bundle.putInt("key_duration", i16);
                    bundle.putString("key_id", str);
                    obtain.setData(bundle);
                    next.send(obtain);
                }
            } catch (RemoteException e16) {
                QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateProgressNotify sendToClient exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void U(ISong iSong) {
        H = 0;
        F = iSong;
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("updateSongNotify [id=%s]", iSong.getId()));
        Iterator<Messenger> it = this.f241096h.iterator();
        while (it.hasNext()) {
            Messenger next = it.next();
            try {
                if (next.getBinder().isBinderAlive()) {
                    Message obtain = Message.obtain((Handler) null, 5);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("key_song", iSong);
                    obtain.setData(bundle);
                    next.send(obtain);
                }
            } catch (RemoteException e16) {
                QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateSongNotify sendToClient exception", e16);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onBind");
        return this.f241094e.getBinder();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
        if (QLog.isColorLevel() && i3 < 100) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->onBufferingUpdate %d/100", Integer.valueOf(i3)));
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCompletion");
        }
        S(H(), 8);
        QQMusicPlayReport.b(L, M);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCreate");
        }
        this.f241097i = new a();
        if (J()) {
            return;
        }
        this.f241094e = new Messenger(this.E);
        this.f241095f = new d();
        this.E.post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.player.QQMusicPlayService.2
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter(QQAppInterface.QQ_ACTION_LOGOUT);
                intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
                intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
                intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
                intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
                intentFilter.addAction(NewIntent.ACTION_LOGOUT);
                intentFilter.addAction("QQMusicPlay_exit_action");
                try {
                    BaseApplication.getContext().registerReceiver(QQMusicPlayService.this.f241095f, intentFilter);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("QQMusicPlay.QQMusicPlayService", 1, "onCreate registerReceiver exception===>", e16);
                }
                QQMusicPlayService.J = NetworkUtil.isNetworkAvailable(QQMusicPlayService.this.getApplicationContext());
                QQMusicPlayService qQMusicPlayService = QQMusicPlayService.this;
                qQMusicPlayService.f241093d = new c(qQMusicPlayService);
                AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), QQMusicPlayService.this.f241093d);
                try {
                    QQMusicPlayService.this.I();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    QLog.e("QQMusicPlay.QQMusicPlayService", 1, "initMediaPlayer exception===>", th5);
                }
            }
        });
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onDestroy");
        if (this.E != null) {
            this.E.sendMessage(this.E.obtainMessage(12, new e(I, F)));
            this.E = null;
        }
        H = 0;
        ((AudioManager) getSystemService("audio")).abandonAudioFocus(this.f241097i);
        try {
            BaseApplication.getContext().unregisterReceiver(this.f241095f);
        } catch (Exception unused) {
        }
        c cVar = this.f241093d;
        if (cVar != null) {
            try {
                AppNetConnInfo.unregisterNetInfoHandler(cVar);
            } catch (Exception unused2) {
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, String.format("--->onError [%d %d]", Integer.valueOf(i3), Integer.valueOf(i16)));
        if (i3 == 100) {
            MediaPlayer mediaPlayer2 = I;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            I();
        }
        ((AudioManager) getSystemService("audio")).abandonAudioFocus(this.f241097i);
        O();
        S(H(), 5);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = I;
        if (mediaPlayer2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("QQMusicPlay.QQMusicPlayService", 2, "player is null while invoking method onPrepared");
            }
            stopSelf();
            return;
        }
        H = mediaPlayer2.getDuration();
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, "--->onPrepared:sDuration " + H);
        b bVar = this.E;
        if (bVar != null) {
            bVar.sendEmptyMessage(14);
        }
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        int requestAudioFocus = audioManager.requestAudioFocus(this.f241097i, 3, 1);
        boolean isMusicActive = audioManager.isMusicActive();
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlay.QQMusicPlayService", 2, "--->onPrepared requestAudioFocus,result:" + requestAudioFocus + " isMusicActive:" + isMusicActive);
        }
        if (requestAudioFocus != 1) {
            S(H(), 7);
            b bVar2 = this.E;
            if (bVar2 != null) {
                bVar2.sendEmptyMessage(11);
            }
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onRebind");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onStart startId=" + i3);
        super.onStart(intent, i3);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        Message message;
        if (intent != null && (message = (Message) intent.getParcelableExtra("key_message")) != null) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("--->onStartCommand startId=%d what=%d", Integer.valueOf(i16), Integer.valueOf(message.what)));
            if (this.E != null && !this.D.isAlive()) {
                try {
                    this.E.getLooper().quit();
                } catch (Throwable unused) {
                }
                J();
            }
            b bVar = this.E;
            if (bVar != null) {
                bVar.sendMessage(message);
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onUnbind");
        return super.onUnbind(intent);
    }
}

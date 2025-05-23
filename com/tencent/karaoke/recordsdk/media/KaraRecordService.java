package com.tencent.karaoke.recordsdk.media;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.recordsdk.media.audio.o;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraRecordService extends Service {
    private d J;

    /* renamed from: e, reason: collision with root package name */
    private KaraMediaReceiver f116949e;

    /* renamed from: d, reason: collision with root package name */
    private final IBinder f116948d = new a();

    /* renamed from: f, reason: collision with root package name */
    private long f116950f = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f116951h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f116952i = false;

    /* renamed from: m, reason: collision with root package name */
    private byte f116953m = 0;
    private int C = 0;
    private boolean D = false;
    private int E = 0;
    private b F = new b(-1, 1);
    private b G = new b(1, 1);
    private b H = new b(2, 1);
    private b I = this.F;
    private WeakReference<com.tencent.karaoke.recordsdk.media.audio.k> K = null;
    private o L = null;
    private com.tencent.karaoke.recordsdk.media.a M = null;
    private com.tencent.karaoke.recordsdk.media.a N = null;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a extends Binder {
        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f116955a;

        /* renamed from: b, reason: collision with root package name */
        private int f116956b;

        public b(int i3, int i16) {
            this.f116955a = i3;
            this.f116956b = i16;
        }

        public static String b(int i3) {
            if (i3 != -1) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return "UNKNOWN";
                        }
                        return "MODE_PLAY";
                    }
                    return "MODE_PLAYBACK";
                }
                return "MODE_SING";
            }
            return "MODE_NONE";
        }

        public static String d(int i3) {
            switch (i3) {
                case 1:
                    return "STATE_IDLE";
                case 2:
                    return "STATE_PREPARING";
                case 3:
                    return "STATE_PREPARED";
                case 4:
                    return "STATE_STARTED";
                case 5:
                    return "STATE_PAUSED";
                case 6:
                default:
                    return "UNKNOWN";
                case 7:
                    return "STATE_STOPPED";
                case 8:
                    return "STATE_ERROR";
            }
        }

        public int a() {
            return this.f116955a;
        }

        public int c() {
            return this.f116956b;
        }

        public String toString() {
            return "ModeState[" + b(this.f116955a) + ", " + d(this.f116956b) + "]";
        }
    }

    public int a() {
        return this.I.a();
    }

    public int b() {
        d dVar = this.J;
        if (dVar == null) {
            return 0;
        }
        return dVar.a();
    }

    public int c() {
        return this.G.c();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogUtil.i("KaraRecordService", "onBind begin. " + intent.toString());
        return this.f116948d;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtil.i("KaraRecordService", "onCreate");
        this.f116949e = new KaraMediaReceiver();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(this.f116949e, intentFilter);
        uz0.e.d(this);
        if (tz0.a.a() == null) {
            tz0.a.b(this);
        }
        this.J = new d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i("KaraRecordService", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        unregisterReceiver(this.f116949e);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        LogUtil.i("KaraRecordService", "onRebind");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        LogUtil.i("KaraRecordService", "onStartCommand");
        return super.onStartCommand(intent, i3, i16);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        LogUtil.i("KaraRecordService", "onUnbind");
        return super.onUnbind(intent);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getMode = " + a() + ";");
        sb5.append("getSingState = " + c() + ";");
        sb5.append("getPlayTime = " + b() + ";");
        return sb5.toString();
    }
}

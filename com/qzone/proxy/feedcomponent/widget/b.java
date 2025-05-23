package com.qzone.proxy.feedcomponent.widget;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static AudioManager f50943a = null;

    /* renamed from: b, reason: collision with root package name */
    static Object f50944b = null;

    /* renamed from: c, reason: collision with root package name */
    static int f50945c = -2;

    /* renamed from: d, reason: collision with root package name */
    static SparseIntArray f50946d = new SparseIntArray();

    /* renamed from: e, reason: collision with root package name */
    public static f f50947e;

    /* renamed from: f, reason: collision with root package name */
    static int f50948f;

    /* renamed from: g, reason: collision with root package name */
    static Handler f50949g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            AudioManager audioManager;
            if (i3 == b.f50945c || i3 == 1 || i3 != -1 || (audioManager = b.f50943a) == null) {
                return;
            }
            audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) b.f50944b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.proxy.feedcomponent.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class HandlerC0434b extends Handler {
        HandlerC0434b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean b16 = b.b();
            if (b16) {
                AudioMediaPlayer.a().g(0);
            } else {
                AudioMediaPlayer.a().g(3);
            }
            if (FeedGlobalEnv.g().isAudioPlayerParameter()) {
                b.e(FeedGlobalEnv.getContext(), b16 ? 2 : 0);
            }
        }
    }

    static {
        try {
            f50943a = (AudioManager) FeedGlobalEnv.getContext().getSystemService("audio");
        } catch (Exception unused) {
        }
        f50948f = -999;
        f50949g = new HandlerC0434b(Looper.getMainLooper());
    }

    public static void a() {
        try {
            Object obj = f50944b;
            if (obj == null) {
                return;
            }
            AudioManager audioManager = f50943a;
            if (audioManager != null) {
                audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) obj);
            }
            f50944b = null;
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("AudioHelper", "AudioHelper abandonAudioFocus: " + th5.getMessage(), th5);
        }
    }

    public static boolean b() {
        f fVar = f50947e;
        if (fVar == null) {
            return false;
        }
        return fVar.c();
    }

    public static void e(Context context, int i3) {
        AudioManager audioManager = f50943a;
        if (audioManager == null) {
            return;
        }
        try {
            if (f50948f == -999) {
                f50948f = audioManager.getMode();
            }
            if (f50948f == i3) {
                return;
            }
            if (f50943a.getMode() == 0) {
                f50946d.put(0, SystemMethodProxy.getStreamVolume(f50943a, 3));
            }
            f50943a.setMode(i3);
            f50948f = i3;
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    AudioManager audioManager2 = f50943a;
                    audioManager2.setStreamVolume(3, audioManager2.getStreamMaxVolume(3), 8);
                    return;
                }
                return;
            }
            if (f50946d.indexOfKey(i3) >= 0) {
                f50943a.setStreamVolume(3, f50946d.get(i3), 8);
                f50946d.delete(0);
            }
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d("AudioHelper", "AudioHelper " + e16.toString(), e16);
        }
    }

    public static void f() {
        e(FeedGlobalEnv.getContext(), 0);
    }

    public static void g() {
        AudioManager audioManager = f50943a;
        if (audioManager == null || SystemMethodProxy.getStreamVolume(audioManager, 3) != 0) {
            return;
        }
        ToastUtils.b(FeedGlobalEnv.getContext(), "\u8bf7\u6253\u5f00\u97f3\u91cf\u6536\u542c");
    }

    public static boolean h() {
        if (f50947e == null) {
            f50947e = new f(FeedGlobalEnv.getContext(), f50949g);
        }
        f fVar = f50947e;
        if (fVar == null) {
            return false;
        }
        fVar.d();
        return true;
    }

    public static boolean i() {
        f fVar = f50947e;
        if (fVar == null) {
            return false;
        }
        fVar.e();
        return true;
    }

    public static int c(int i3) {
        try {
            if (f50944b != null) {
                return 0;
            }
            a aVar = new a();
            f50944b = aVar;
            AudioManager audioManager = f50943a;
            if (audioManager != null) {
                return audioManager.requestAudioFocus(aVar, i3, 2);
            }
            return 0;
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("AudioHelper", "AudioHelper requestAudioFocus: " + th5.getMessage(), th5);
            return 0;
        }
    }

    public static void d() {
        c(3);
    }
}

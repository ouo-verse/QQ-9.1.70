package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.raft.codegenmeta.utils.RLog;

@HippyNativeModule(name = "AudioPlayerModule")
/* loaded from: classes20.dex */
public class AudioPlayerModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f337477a = true;

    /* renamed from: b, reason: collision with root package name */
    private final HippyEngineContext f337478b;

    /* renamed from: c, reason: collision with root package name */
    private a f337479c;

    /* renamed from: d, reason: collision with root package name */
    private String f337480d;

    public AudioPlayerModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337480d = "STOPPED";
        this.f337478b = hippyEngineContext;
        this.f337479c = new a();
    }

    private a a(Context context, Uri uri, MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f337480d = "BUFFERING";
        try {
            a aVar = new a();
            aVar.a(context, uri);
            aVar.b(3);
            if (onPreparedListener != null) {
                aVar.a(onPreparedListener);
                aVar.a();
            } else {
                aVar.i();
            }
            return aVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @HippyMethod(name = "destroyNotification")
    public void destroyNotification() {
        LogUtils.d("AudioPlayerModule", "destroyNotification");
    }

    @HippyMethod(name = ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS)
    public void getStatus(Promise promise) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("status", a());
        hippyMap.pushInt("duration", this.f337479c.h() / 1000);
        hippyMap.pushInt("progress", this.f337479c.g() / 1000);
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = DKWebViewController.DKHippyWebviewFunction.GO_BAC)
    public void goBack(Float f16) {
        try {
            int g16 = this.f337479c.g() - (Math.round(f16.floatValue()) * 1000);
            if (g16 < 0) {
                g16 = 0;
            }
            seekTo(g16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @HippyMethod(name = DKWebViewController.DKHippyWebviewFunction.GO_FORWARD)
    public void goForward(Float f16) {
        try {
            int g16 = this.f337479c.g() + (Math.round(f16.floatValue()) * 1000);
            if (g16 > 0) {
                g16 = 0;
            }
            seekTo(g16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @HippyMethod(name = "pause")
    public void pause() {
        try {
            try {
                a aVar = this.f337479c;
                if (aVar != null) {
                    aVar.c();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.f337480d = "PAUSED";
        }
    }

    @HippyMethod(name = "play")
    public void play(String str, Promise promise) {
        try {
            Uri parse = Uri.parse(str);
            stop();
            a a16 = a(this.f337478b.getGlobalConfigs().getContext(), parse, new MediaPlayer.OnPreparedListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.AudioPlayerModule.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    AudioPlayerModule.this.resume();
                }
            });
            this.f337479c = a16;
            if (!f337477a && a16 == null) {
                throw new AssertionError();
            }
            a16.a(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.AudioPlayerModule.2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    AudioPlayerModule.this.f337480d = "COMPLETED";
                }
            });
            promise.resolve("OK");
        } catch (Exception e16) {
            e16.printStackTrace();
            promise.resolve(RLog.ERROR);
        }
    }

    @HippyMethod(name = "resume")
    public void resume() {
        try {
            try {
                a aVar = this.f337479c;
                if (aVar != null) {
                    aVar.d();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.f337480d = "BUFFERING";
        }
    }

    @HippyMethod(name = "seekTo")
    public void seekTo(int i3) {
        try {
            try {
                a aVar = this.f337479c;
                if (aVar != null) {
                    aVar.a(i3);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.f337480d = "BUFFERING";
        }
    }

    @HippyMethod(name = "stop")
    public void stop() {
        try {
            try {
                a aVar = this.f337479c;
                if (aVar != null) {
                    aVar.e();
                    this.f337479c.f();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            this.f337480d = "STOPPED";
        }
    }

    private String a() {
        return this.f337479c.b() ? "PLAYING" : this.f337480d;
    }
}

package com.tencent.biz.pubaccount.weishi.player;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private AudioManager f81119b;

    /* renamed from: a, reason: collision with root package name */
    private Handler f81118a = new HandlerC0828b(Looper.getMainLooper(), this);

    /* renamed from: c, reason: collision with root package name */
    private final AudioManager.OnAudioFocusChangeListener f81120c = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            x.j("WSPlayerAudioControlLog", "[WSPlayerAudioControl.java][requestAudioFocus] onAudioFocusChange focusChange:" + i3);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.player.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    private static class HandlerC0828b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private b f81122a;

        HandlerC0828b(Looper looper, b bVar) {
            super(looper);
            this.f81122a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                this.f81122a.e();
            } else {
                if (i3 != 2) {
                    return;
                }
                this.f81122a.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final b f81123a = new b();
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        AudioManager audioManager = this.f81119b;
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.f81120c);
    }

    public static b d() {
        return c.f81123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f81119b == null) {
            this.f81119b = (AudioManager) BaseApplicationImpl.getApplication().getSystemService("audio");
        }
        this.f81119b.requestAudioFocus(this.f81120c, 3, 2);
    }

    public void f(boolean z16) {
        x.j("WSPlayerAudioControlLog", "[WSPlayerAudioControl.java][requestOrAbandonAudioFocus] isFocus:" + z16);
        this.f81118a.removeMessages(1);
        this.f81118a.removeMessages(2);
        if (z16) {
            this.f81118a.sendEmptyMessage(1);
        } else {
            this.f81118a.sendEmptyMessageDelayed(2, 1500L);
        }
    }
}

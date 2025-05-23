package com.tencent.karaoke.recordsdk.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.component.utils.LogUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraMediaReceiver extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    private int f116945c;

    /* renamed from: b, reason: collision with root package name */
    private AudioManager f116944b = null;

    /* renamed from: d, reason: collision with root package name */
    private Handler f116946d = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<f> f116943a = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            if (message.what == 1) {
                boolean isBluetoothA2dpOn = KaraMediaReceiver.this.f116944b.isBluetoothA2dpOn();
                if (message.arg1 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 == isBluetoothA2dpOn) {
                    if (!KaraMediaReceiver.this.f116944b.isWiredHeadsetOn()) {
                        KaraMediaReceiver.this.f(z16);
                    }
                } else {
                    if (KaraMediaReceiver.this.f116945c > 1000) {
                        LogUtil.w("KaraMediaReceiver", "handleMessage -> has already detect over 1000");
                        return;
                    }
                    LogUtil.i("KaraMediaReceiver", "handleMessage -> continue");
                    KaraMediaReceiver.this.f116946d.removeMessages(1);
                    Message obtainMessage = KaraMediaReceiver.this.f116946d.obtainMessage(1);
                    obtainMessage.arg1 = message.arg1;
                    KaraMediaReceiver.this.f116946d.sendMessageDelayed(obtainMessage, 500L);
                    KaraMediaReceiver.d(KaraMediaReceiver.this);
                }
            }
        }
    }

    static /* synthetic */ int d(KaraMediaReceiver karaMediaReceiver) {
        int i3 = karaMediaReceiver.f116945c;
        karaMediaReceiver.f116945c = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z16) {
        LogUtil.i("KaraMediaReceiver", "callOnHeadsetPlug -> isPlug:" + z16);
        synchronized (this.f116943a) {
            Iterator<f> it = this.f116943a.iterator();
            while (it.hasNext()) {
                it.next().onHeadsetPlug(z16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtil.i("KaraMediaReceiver", "onReceive: " + action);
        if (this.f116944b == null) {
            try {
                this.f116944b = (AudioManager) context.getSystemService("audio");
            } catch (RuntimeException e16) {
                LogUtil.w("KaraMediaReceiver", e16);
            }
        }
        boolean z16 = true;
        this.f116946d.removeMessages(1);
        ?? r75 = 0;
        boolean z17 = false;
        this.f116945c = 0;
        if ("android.intent.action.HEADSET_PLUG".equals(action)) {
            if (intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                LogUtil.i("KaraMediaReceiver", "onReceive -> state:" + intExtra);
                if (intExtra == 0) {
                    z16 = false;
                }
                AudioManager audioManager = this.f116944b;
                if (audioManager != null) {
                    z16 = audioManager.isWiredHeadsetOn();
                    z17 = this.f116944b.isBluetoothA2dpOn();
                }
                if (!z17) {
                    f(z16);
                    return;
                }
                return;
            }
            AudioManager audioManager2 = this.f116944b;
            if (audioManager2 != null) {
                if (!audioManager2.isBluetoothA2dpOn()) {
                    f(this.f116944b.isWiredHeadsetOn());
                    return;
                }
                return;
            }
            LogUtil.i("KaraMediaReceiver", "onReceive -> unknown state, so do nothing");
            return;
        }
        if (!"android.bluetooth.device.action.ACL_CONNECTED".equals(action) && !"android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                LogUtil.i("KaraMediaReceiver", "onReceive -> bluetooth state:" + intExtra2);
                if (intExtra2 == 10) {
                    LogUtil.i("KaraMediaReceiver", "onReceive -> bluetooth off");
                    AudioManager audioManager3 = this.f116944b;
                    if (audioManager3 != null) {
                        if (!audioManager3.isWiredHeadsetOn()) {
                            f(false);
                            return;
                        }
                        return;
                    }
                    f(false);
                    return;
                }
                if (intExtra2 == 13) {
                    LogUtil.i("KaraMediaReceiver", "onReceive -> bluetooth turning off");
                    return;
                }
                return;
            }
            return;
        }
        if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
            r75 = 1;
        } else {
            action.equals("android.bluetooth.device.action.ACL_DISCONNECTED");
        }
        AudioManager audioManager4 = this.f116944b;
        if (audioManager4 != null) {
            if (audioManager4.isBluetoothA2dpOn() != r75) {
                Message obtainMessage = this.f116946d.obtainMessage(1);
                obtainMessage.arg1 = r75;
                this.f116946d.sendMessageDelayed(obtainMessage, 500L);
                return;
            } else {
                if (!this.f116944b.isWiredHeadsetOn()) {
                    f(r75);
                    return;
                }
                return;
            }
        }
        f(r75);
    }
}

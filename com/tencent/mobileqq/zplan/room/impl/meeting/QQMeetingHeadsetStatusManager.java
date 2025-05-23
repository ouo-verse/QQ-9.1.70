package com.tencent.mobileqq.zplan.room.impl.meeting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010$\u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010'\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager;", "Landroid/content/BroadcastReceiver;", "", "isPlug", "", "i", "Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager$a;", "listener", h.F, "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "", "a", "Ljava/lang/String;", "TAG", "", "b", "Ljava/util/List;", "mHeadListeners", "Landroid/media/AudioManager;", "c", "Landroid/media/AudioManager;", "mAudioManager", "", "d", "I", "mBTConnectionDetectCount", "e", "MAX_BT_DETECT_COUNT", "f", "MSG_BT_CONNECTION", "g", "Landroid/content/Context;", "mAppContext", "Z", "j", "()Z", "setRegister", "(Z)V", "isRegister", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQMeetingHeadsetStatusManager extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AudioManager mAudioManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mBTConnectionDetectCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Context mAppContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isRegister;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QQMeetingHeadsetStatusManager";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<a> mHeadListeners = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int MAX_BT_DETECT_COUNT = 1000;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int MSG_BT_CONNECTION = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager$a;", "", "", "isPlugged", "", "onHeadsetPlug", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void onHeadsetPlug(boolean isPlugged);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == QQMeetingHeadsetStatusManager.this.MSG_BT_CONNECTION) {
                AudioManager audioManager = QQMeetingHeadsetStatusManager.this.mAudioManager;
                Intrinsics.checkNotNull(audioManager);
                boolean isBluetoothA2dpOn = audioManager.isBluetoothA2dpOn();
                boolean z16 = msg2.arg1 == 1;
                if (z16 == isBluetoothA2dpOn) {
                    AudioManager audioManager2 = QQMeetingHeadsetStatusManager.this.mAudioManager;
                    Intrinsics.checkNotNull(audioManager2);
                    if (audioManager2.isWiredHeadsetOn()) {
                        return;
                    }
                    QQMeetingHeadsetStatusManager.this.i(z16);
                    return;
                }
                if (QQMeetingHeadsetStatusManager.this.mBTConnectionDetectCount > QQMeetingHeadsetStatusManager.this.MAX_BT_DETECT_COUNT) {
                    QLog.w(QQMeetingHeadsetStatusManager.this.TAG, 1, "handleMessage -> has already detect over 1000");
                    return;
                }
                QLog.i(QQMeetingHeadsetStatusManager.this.TAG, 1, "handleMessage -> continue");
                removeMessages(QQMeetingHeadsetStatusManager.this.MSG_BT_CONNECTION);
                Message obtainMessage = obtainMessage(QQMeetingHeadsetStatusManager.this.MSG_BT_CONNECTION);
                Intrinsics.checkNotNullExpressionValue(obtainMessage, "this.obtainMessage(MSG_BT_CONNECTION)");
                obtainMessage.arg1 = msg2.arg1;
                sendMessageDelayed(obtainMessage, 500L);
                QQMeetingHeadsetStatusManager.this.mBTConnectionDetectCount++;
            }
        }
    }

    public QQMeetingHeadsetStatusManager() {
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mAppContext = context;
        this.mHandler = new b(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean isPlug) {
        QLog.i(this.TAG, 1, "callOnHeadsetPlug -> isPlug:" + isPlug);
        synchronized (this.mHeadListeners) {
            Iterator<a> it = this.mHeadListeners.iterator();
            while (it.hasNext()) {
                it.next().onHeadsetPlug(isPlug);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void l() {
        synchronized (this.mHeadListeners) {
            this.mHeadListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsRegister() {
        return this.isRegister;
    }

    public final void k(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mAppContext == null) {
            QLog.e(this.TAG, 1, "registerEarBackReceiver() ERROR: context is null!");
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        try {
            this.mAppContext.registerReceiver(this, intentFilter);
            h(listener);
            this.isRegister = true;
        } catch (Exception unused) {
        }
    }

    public final void m() {
        Context context = this.mAppContext;
        if (context == null) {
            QLog.e(this.TAG, 1, "unRegisterEarBackReceiver() ERROR: context is null!");
            return;
        }
        try {
            context.unregisterReceiver(this);
            l();
            this.isRegister = false;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v3 */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        ?? r36 = 1;
        QLog.i(this.TAG, 1, "onReceive: " + action);
        if (this.mAudioManager == null) {
            try {
                Object systemService = context.getSystemService("audio");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                this.mAudioManager = (AudioManager) systemService;
            } catch (RuntimeException e16) {
                QLog.w(this.TAG, 1, e16.getMessage(), e16);
            }
        }
        this.mHandler.removeMessages(this.MSG_BT_CONNECTION);
        boolean z16 = false;
        this.mBTConnectionDetectCount = 0;
        if (Intrinsics.areEqual("android.intent.action.HEADSET_PLUG", action)) {
            if (intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                QLog.i(this.TAG, 1, "onReceive -> state:" + intExtra);
                boolean z17 = intExtra != 0;
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null) {
                    Intrinsics.checkNotNull(audioManager);
                    z17 = audioManager.isWiredHeadsetOn();
                    AudioManager audioManager2 = this.mAudioManager;
                    Intrinsics.checkNotNull(audioManager2);
                    z16 = audioManager2.isBluetoothA2dpOn();
                }
                if (z16) {
                    return;
                }
                i(z17);
                return;
            }
            AudioManager audioManager3 = this.mAudioManager;
            if (audioManager3 != null) {
                Intrinsics.checkNotNull(audioManager3);
                if (audioManager3.isBluetoothA2dpOn()) {
                    return;
                }
                AudioManager audioManager4 = this.mAudioManager;
                Intrinsics.checkNotNull(audioManager4);
                i(audioManager4.isWiredHeadsetOn());
                return;
            }
            QLog.i(this.TAG, 1, "onReceive -> unknown state, so do nothing");
            return;
        }
        if (!Intrinsics.areEqual("android.bluetooth.device.action.ACL_CONNECTED", action) && !Intrinsics.areEqual("android.bluetooth.device.action.ACL_DISCONNECTED", action)) {
            if (Intrinsics.areEqual(action, "android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                QLog.i(this.TAG, 1, "onReceive -> bluetooth state:" + intExtra2);
                if (intExtra2 != 10) {
                    if (intExtra2 != 13) {
                        return;
                    }
                    QLog.i(this.TAG, 1, "onReceive -> bluetooth turning off");
                    return;
                }
                QLog.i(this.TAG, 1, "onReceive -> bluetooth off");
                AudioManager audioManager5 = this.mAudioManager;
                if (audioManager5 != null) {
                    Intrinsics.checkNotNull(audioManager5);
                    if (audioManager5.isWiredHeadsetOn()) {
                        return;
                    }
                    i(false);
                    return;
                }
                i(false);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(action, "android.bluetooth.device.action.ACL_CONNECTED")) {
            Intrinsics.areEqual(action, "android.bluetooth.device.action.ACL_DISCONNECTED");
            r36 = 0;
        }
        AudioManager audioManager6 = this.mAudioManager;
        if (audioManager6 != null) {
            Intrinsics.checkNotNull(audioManager6);
            if (audioManager6.isBluetoothA2dpOn() != r36) {
                Message obtainMessage = this.mHandler.obtainMessage(this.MSG_BT_CONNECTION);
                Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler.obtainMessage(MSG_BT_CONNECTION)");
                obtainMessage.arg1 = r36;
                this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                return;
            }
            AudioManager audioManager7 = this.mAudioManager;
            Intrinsics.checkNotNull(audioManager7);
            if (audioManager7.isWiredHeadsetOn()) {
                return;
            }
            i(r36);
            return;
        }
        i(r36);
    }

    private final void h(a listener) {
        if (listener != null) {
            synchronized (this.mHeadListeners) {
                if (!this.mHeadListeners.contains(listener)) {
                    this.mHeadListeners.add(listener);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}

package com.tencent.mobileqq.zplan.room.impl.trtc;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 A2\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b?\u0010@J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001J\u0006\u0010\u0007\u001a\u00020\u0003J \u0010\r\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010!\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u001a\u0010$\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010%\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\"H\u0016J*\u0010)\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016J\u001a\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u00101\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u00102\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u00103\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u000fR\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R0\u0010>\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010:0\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010:`;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/c;", "Lcom/tencent/trtc/TRTCCloudListener;", "registerListener", "", "M", "unreisterListener", "O", "N", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "userVolumes", "", "totalVolume", "onUserVoiceVolume", "errCode", "", "errMsg", "Landroid/os/Bundle;", "extraInfo", "onError", "warningCode", "warningMsg", "onWarning", "", "result", "onEnterRoom", "reason", "onExitRoom", "onSwitchRole", "onSwitchRoom", "userId", "onConnectOtherRoom", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "", "available", "onUserAudioAvailable", "onUserVideoAvailable", "streamType", "width", "height", "onFirstVideoFrame", "onSendFirstLocalAudioFrame", "onConnectionLost", "onTryToReconnect", "onConnectionRecovery", "onMicDidReady", NotificationCompat.CATEGORY_ERROR, "onStartPublishing", "onStopPublishing", "onStartPublishCDNStream", "onStopPublishCDNStream", "str", "L", "", "a", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Lmqq/util/WeakReference;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "listenerRef", "<init>", "()V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends TRTCCloudListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<WeakReference<TRTCCloudListener>> listenerRef = new ArrayList<>();

    public final void L(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        QLog.i("ZplanTRTCListener", 1, str);
    }

    public final void M(TRTCCloudListener registerListener) {
        Intrinsics.checkNotNullParameter(registerListener, "registerListener");
        synchronized (this.lock) {
            boolean z16 = false;
            for (int size = this.listenerRef.size() - 1; -1 < size; size--) {
                TRTCCloudListener tRTCCloudListener = this.listenerRef.get(size).get();
                if (tRTCCloudListener != null) {
                    if (Intrinsics.areEqual(tRTCCloudListener, registerListener)) {
                        z16 = true;
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    Intrinsics.checkNotNullExpressionValue(this.listenerRef.remove(size), "listenerRef.removeAt(i)");
                }
            }
            if (!z16) {
                this.listenerRef.add(new WeakReference<>(registerListener));
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void N() {
        synchronized (this.lock) {
            this.listenerRef.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void O(TRTCCloudListener unreisterListener) {
        Intrinsics.checkNotNullParameter(unreisterListener, "unreisterListener");
        synchronized (this.lock) {
            for (int size = this.listenerRef.size() - 1; -1 < size; size--) {
                TRTCCloudListener tRTCCloudListener = this.listenerRef.get(size).get();
                if (tRTCCloudListener != null) {
                    if (Intrinsics.areEqual(tRTCCloudListener, unreisterListener)) {
                        this.listenerRef.remove(size);
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    Intrinsics.checkNotNullExpressionValue(this.listenerRef.remove(size), "listenerRef.removeAt(i)");
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectOtherRoom(String userId, int errCode, String errMsg) {
        L("onConnectOterRoom " + userId + " " + errCode + " " + errMsg);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onConnectOtherRoom(userId, errCode, errMsg);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionLost() {
        L("onConnectionLost");
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onConnectionLost();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionRecovery() {
        L("onConnecionRecovery");
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onConnectionRecovery();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int errCode, String errMsg, Bundle extraInfo) {
        L("error => " + errCode + ", " + errMsg + ", " + extraInfo);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onError(errCode, errMsg, extraInfo);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int reason) {
        L("exitRoom => " + reason);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onExitRoom(reason);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(String userId, int streamType, int width, int height) {
        L("onFirstVideoFrame: " + userId + ", " + streamType + ", " + width + ", " + height);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onFirstVideoFrame(userId, streamType, width, height);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMicDidReady() {
        L("onMicDidReady");
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onMicDidReady();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(String userId) {
        L("onRemoteUserEnterRoom -> userid: " + userId);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onRemoteUserEnterRoom(userId);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(String userId, int reason) {
        L("onRemoteUserLeaveRoom " + userId + ", " + reason);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onRemoteUserLeaveRoom(userId, reason);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalAudioFrame() {
        L("sendFirstLocalAudioFrame");
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSendFirstLocalAudioFrame();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStartPublishCDNStream(int err, String errMsg) {
        L("onStartPublishCDN fun -> " + err + ", " + errMsg);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStopPublishing(err, errMsg);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStartPublishing(int err, String errMsg) {
        L("onStartPublishing " + err + " " + errMsg);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStartPublishing(err, errMsg);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStopPublishCDNStream(int err, String errMsg) {
        L("onStopPublishCDNStream " + err + " , " + errMsg);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStopPublishCDNStream(err, errMsg);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStopPublishing(int err, String errMsg) {
        L("onStopPublishing " + err + ", " + errMsg);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStopPublishing(err, errMsg);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRole(int errCode, String errMsg) {
        L("switchRole -> " + errCode + ", " + errMsg);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSwitchRoom(errCode, errMsg);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRoom(int errCode, String errMsg) {
        L("onSwitchRoom -> " + errCode + ", " + errMsg);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSwitchRoom(errCode, errMsg);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onTryToReconnect() {
        L("onTryToReconnect");
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onTryToReconnect();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(String userId, boolean available) {
        L("onUserAudioAvailable " + userId + " " + available);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onUserAudioAvailable(userId, available);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(String userId, boolean available) {
        L("onUserVideoAvailable " + userId + ", " + available);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onUserVideoAvailable(userId, available);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> userVolumes, int totalVolume) {
        synchronized (this.lock) {
            Iterator<T> it = this.listenerRef.iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onUserVoiceVolume(userVolumes, totalVolume);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onWarning(int warningCode, String warningMsg, Bundle extraInfo) {
        QLog.d("ZplanTRTCListener", 1, "warning => " + warningCode + ", " + warningMsg + ", " + extraInfo);
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onWarning(warningCode, warningMsg, extraInfo);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long result) {
        if (result > 0) {
            QLog.i("ZplanTRTCListener", 1, "onEnterRoom success, costTime= " + result + "ms");
        } else {
            QLog.e("ZplanTRTCListener", 1, "onEnterRoom error, result= " + result);
        }
        synchronized (this.lock) {
            Iterator it = new ArrayList(this.listenerRef).iterator();
            while (it.hasNext()) {
                TRTCCloudListener tRTCCloudListener = (TRTCCloudListener) ((WeakReference) it.next()).get();
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onEnterRoom(result);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}

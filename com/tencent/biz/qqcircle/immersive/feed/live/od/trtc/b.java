package com.tencent.biz.qqcircle.immersive.feed.live.od.trtc;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements ITRTCRoomListener {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<ITRTCRoomListener> f86359a;

    public b(ITRTCRoomListener iTRTCRoomListener) {
        this.f86359a = new WeakReference<>(iTRTCRoomListener);
    }

    public boolean a(ITRTCRoomListener iTRTCRoomListener) {
        if (this.f86359a.get() == iTRTCRoomListener) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f86359a.get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onEnterRoom(long j3, String str) {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEnterRoom(j3, str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onEvent(int i3, int i16, String str, Bundle bundle) {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEvent(i3, i16, str, bundle);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onExitRoom(int i3) {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onExitRoom(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onFirstLocalAudioFrameSent() {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onFirstLocalAudioFrameSent();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onFirstLocalVideoFrameSent(int i3) {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onFirstLocalVideoFrameSent(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onRemoteUserEnterRoom(String str) {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onRemoteUserEnterRoom(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onRemoteUserLeaveRoom(String str, int i3) {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onRemoteUserLeaveRoom(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onSwitchRoom(int i3, String str) {
        ITRTCRoomListener iTRTCRoomListener = this.f86359a.get();
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onSwitchRoom(i3, str);
        }
    }
}

package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;

/* loaded from: classes23.dex */
public abstract class VoIPProxy {

    /* loaded from: classes23.dex */
    public static final class MultiUserInfo {
        public boolean mMicOn;
        public String mOpenId;
        public long mUin;

        public String toString() {
            return "MultiUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + "', mMicOn=" + this.mMicOn + '}';
        }
    }

    /* loaded from: classes23.dex */
    public interface VoIPListener {
        void onEnterRoom();

        void onError(int i3);

        void onUserAudioAvailable(MultiUserInfo multiUserInfo, boolean z16);

        void onUserEnter(MultiUserInfo multiUserInfo);

        void onUserExit(MultiUserInfo multiUserInfo);

        void onUserSpeaking(MultiUserInfo multiUserInfo, boolean z16);

        void onUserUpdate(List<MultiUserInfo> list);
    }

    public abstract int enableLocalAudio(boolean z16);

    public abstract int enableRemoteAudio(boolean z16);

    public abstract void exitRoom();

    public abstract void init(long j3, VoIPListener voIPListener);

    public abstract int joinRoom(long j3, long j16, String str, byte[] bArr);

    public abstract void setAudioRoute(int i3);

    public abstract void unInit();

    public abstract void updateRoomInfo();
}

package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcRoom {
    static IPatchRedirector $redirector_;
    private static volatile NtrtcRoom sInstance;
    private NtrtcRoomCallbackImplWrapper mCallbackWrapper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15430);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            sInstance = null;
        }
    }

    NtrtcRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCallbackWrapper = null;
        }
    }

    public static void destroyInstance() {
        if (sInstance != null) {
            synchronized (NtrtcRoom.class) {
                sInstance = null;
            }
        }
    }

    public static NtrtcRoom getInstance() {
        if (sInstance == null) {
            synchronized (NtrtcRoom.class) {
                if (sInstance == null) {
                    sInstance = new NtrtcRoom();
                }
            }
        }
        return sInstance;
    }

    public native String getAVSDKInfo(long j3, String str);

    public native long getChatRoomID(long j3);

    public native int hasAVShiftAbility(long j3);

    public native int sendAVAvatar2DMsg(long j3, byte[] bArr, boolean z16);

    public native int sendAVAvatar2DSwitchRequest(long j3, boolean z16, int i3, int i16, String str);

    public native int sendAVFunChatMsg(long j3, int i3, byte[] bArr);

    public native int sendSuperAVAvatarMsg(long j3, byte[] bArr, long j16);

    public native void setAVChatScene(int i3, int i16);

    @RequiresApi(api = 21)
    public int setCallback(NtrtcRoomCallback ntrtcRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcRoomCallback)).intValue();
        }
        if (ntrtcRoomCallback != null) {
            NtrtcRoomCallbackImplWrapper ntrtcRoomCallbackImplWrapper = new NtrtcRoomCallbackImplWrapper();
            this.mCallbackWrapper = ntrtcRoomCallbackImplWrapper;
            ntrtcRoomCallbackImplWrapper.setBusiCallback(ntrtcRoomCallback);
            return setCallbackNative(this.mCallbackWrapper);
        }
        NtrtcRoomCallbackImplWrapper ntrtcRoomCallbackImplWrapper2 = this.mCallbackWrapper;
        if (ntrtcRoomCallbackImplWrapper2 != null) {
            ntrtcRoomCallbackImplWrapper2.setBusiCallback(null);
            this.mCallbackWrapper = null;
        }
        return setCallbackNative(null);
    }

    public native int setCallbackNative(NtrtcRoomCallback ntrtcRoomCallback);

    public native int switchAudio(long j3);

    public native int switchVideo(long j3);
}

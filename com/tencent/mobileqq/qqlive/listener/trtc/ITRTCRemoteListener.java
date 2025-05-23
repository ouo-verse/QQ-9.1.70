package com.tencent.mobileqq.qqlive.listener.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ITRTCRemoteListener {
    public static final IPatchRedirector $redirector_ = null;

    void onConnectOtherRoom(String str, int i3, String str2);

    void onDisConnectOtherRoom(int i3, String str);

    void onFirstAudioFrame(String str);

    void onFirstVideoFrame(String str, int i3, int i16, int i17);

    void onNetworkQuality(QQLiveQuality qQLiveQuality, ArrayList<QQLiveQuality> arrayList);

    void onUserAudioAvailable(String str, boolean z16);

    void onUserSei(String str, byte[] bArr);

    void onUserVideoAvailable(String str, boolean z16);

    void onUserVoiceVolume(ArrayList<RemoteUserAudioInfo> arrayList, int i3);
}

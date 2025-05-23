package com.gcloudsdk.gcloud.voice;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IGCloudVoiceNotify {
    void OnApplyMessageKey(int i3);

    void OnDownloadFile(int i3, String str, String str2);

    void OnEnableMagicVoice(int i3, String str, boolean z16);

    void OnEnableRecvMagicVoice(int i3, boolean z16);

    void OnEnableTranslate(int i3, String str, int i16);

    void OnEvent(int i3, String str);

    void OnJoinRoom(int i3, String str, int i16);

    void OnMagicVoiceMsg(int i3, String str);

    void OnMemberVoice(String str, int i3, int i16);

    void OnMemberVoice(int[] iArr, int i3);

    void OnMicState(int i3);

    void OnPlayBGMEnd();

    void OnPlayRecordedFile(int i3, String str);

    void OnPlayingData(char[] cArr, int i3);

    void OnQuitRoom(int i3, String str);

    void OnRSTS(int i3, int i16, int i17, String str, String str2, String str3, int i18);

    void OnRSTSSpeechToSpeech(int i3, int i16, int i17, String str, String str2, String str3, int i18);

    void OnRSTSSpeechToText(int i3, int i16, int i17, String str, String str2, int i18);

    void OnRealTimeTranslateText(String str, int i3, String str2, int i16, String str3);

    void OnRecordKaraokeDone(int i3);

    void OnRecording(char[] cArr, int i3);

    void OnReportPlayer(int i3, String str);

    void OnRoleChanged(int i3, String str, int i16, int i17);

    void OnRoomMemberInfo(int i3, String str, int i16, String str2);

    void OnSTTReport(int i3, String str, String str2, String str3);

    void OnSpeechFileToText(int i3, String str, String str2, int i16);

    void OnSpeechFileTranslate(int i3, String str, String str2, String str3, int i16);

    void OnSpeechToText(int i3, String str, String str2);

    void OnSpeechTranslate(int i3, String str, String str2, String str3, int i16);

    void OnStatusUpdate(int i3, String str, int i16);

    void OnStreamSpeechToText(int i3, int i16, String str, String str2);

    void OnTextToSpeech(int i3, String str, int i16, String str2);

    void OnTextToSpeechFile(int i3, String str, int i16, String str2);

    void OnTextToStreamSpeech(int i3, String str, int i16);

    void OnTextTranslate(int i3, int i16, String str, int i17, String str2);

    void OnUploadFile(int i3, String str, String str2);
}

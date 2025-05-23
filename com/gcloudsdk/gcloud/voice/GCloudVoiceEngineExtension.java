package com.gcloudsdk.gcloud.voice;

import com.gcloudsdk.apollo.ApolloVoiceLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudVoiceEngineExtension {
    private static GCloudVoiceEngineHelper JNIHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    public GCloudVoiceEngineExtension() {
        JNIHelper = new GCloudVoiceEngineHelper();
        GCloudVoiceEngineHelper.EngineJniInstance();
    }

    public int APITrace(String str, String str2) {
        return GCloudVoiceEngineHelper.APITrace(str, str2);
    }

    public int ApplyMessageKey_Token(String str, int i3, int i16) {
        return GCloudVoiceEngineHelper.ApplyMessageKey(str, i3, i16);
    }

    public int AuditionFileForMagicType(String str, String str2) {
        return GCloudVoiceEngineHelper.AuditionFileForMagicType(str, str2);
    }

    public int DownloadRecordedFile(String str, String str2, int i3, boolean z16) {
        return GCloudVoiceEngineHelper.DownloadRecordedFile(str, str2, i3, z16);
    }

    public int EnableAccFilePlay(boolean z16) {
        return GCloudVoiceEngineHelper.EnableAccFilePlay(z16);
    }

    public void EnableBluetoothSCO(boolean z16) {
        GCloudVoiceEngineHelper.EnableBluetoothSCO(z16);
    }

    public int EnableCivilFile(boolean z16) {
        return GCloudVoiceEngineHelper.EnableCivilFile(z16);
    }

    public int EnableCivilVoice(boolean z16) {
        return GCloudVoiceEngineHelper.EnableCivilVoice(z16);
    }

    public int EnableEarBack(boolean z16) {
        return GCloudVoiceEngineHelper.EnableEarBack(z16);
    }

    public int EnableKeyWordsDetect(boolean z16) {
        return GCloudVoiceEngineHelper.EnableKeyWordsDetect(z16);
    }

    public int EnableLog(boolean z16) {
        return GCloudVoiceEngineHelper.EnableLog(z16);
    }

    public int EnableMagicVoice(String str, boolean z16) {
        return GCloudVoiceEngineHelper.EnableMagicVoice(str, z16);
    }

    public int EnableMultiRoom(boolean z16) {
        return GCloudVoiceEngineHelper.EnableMultiRoom(z16);
    }

    public int EnableNativeBGMPlay(boolean z16) {
        return GCloudVoiceEngineHelper.EnableNativeBGMPlay(z16);
    }

    public int EnableRecvMagicVoice(boolean z16) {
        return GCloudVoiceEngineHelper.EnableRecvMagicVoice(z16);
    }

    public int EnableReportALL(boolean z16) {
        return GCloudVoiceEngineHelper.EnableReportALL(z16);
    }

    public int EnableReportALLAbroad(boolean z16) {
        return GCloudVoiceEngineHelper.EnableReportALLAbroad(z16);
    }

    public int EnableRoomMicrophone(String str, boolean z16) {
        return GCloudVoiceEngineHelper.EnableRoomMicrophone(str, z16);
    }

    public int EnableRoomSpeaker(String str, boolean z16) {
        return GCloudVoiceEngineHelper.EnableRoomSpeaker(str, z16);
    }

    public int EnableSpeakerOn(boolean z16) {
        return GCloudVoiceEngineHelper.EnableSpeakerOn(z16);
    }

    public int EnableTranslate(String str, boolean z16, int i3, int i16) {
        return GCloudVoiceEngineHelper.EnableTranslate(str, z16, i3, i16);
    }

    public int ForbidMemberVoice(int i3, boolean z16) {
        return GCloudVoiceEngineHelper.ForbidMemberVoice(i3, z16, "");
    }

    public int GetAccFileTotalTimeByMs() {
        return GCloudVoiceEngineHelper.GetAccFileTotalTimeByMs();
    }

    public int GetAccPlayTimeByMs() {
        return GCloudVoiceEngineHelper.GetAccPlayTimeByMs();
    }

    public int GetBGMFileTime() {
        return GCloudVoiceEngineHelper.GetAccFileTotalTimeByMs();
    }

    public int GetBGMLevel() {
        return GCloudVoiceEngineHelper.GetBGMLevel();
    }

    public int GetBGMPlayState() {
        return GCloudVoiceEngineHelper.GetBGMPlayState();
    }

    public int GetBGMPlayTime() {
        return GCloudVoiceEngineHelper.GetAccPlayTimeByMs();
    }

    public int GetCurPlayTimeForPreview() {
        return GCloudVoiceEngineHelper.GetCurPlayTimeForPreview();
    }

    public int GetFileParam(String str, Integer num, Float f16) {
        return GCloudVoiceEngineHelper.GetFileParam(str, num, f16);
    }

    public int GetMicLevel() {
        return GCloudVoiceEngineHelper.GetMicLevel();
    }

    public int GetMicState() {
        return GCloudVoiceEngineHelper.GetMicState();
    }

    public int GetMuteResult() {
        return GCloudVoiceEngineHelper.GetMuteResult();
    }

    public int GetRecordKaraokeTotalTime() {
        return GCloudVoiceEngineHelper.GetRecordKaraokeTotalTime();
    }

    public int GetRoomMembers(String str, RoomMember[] roomMemberArr) {
        if (roomMemberArr != null && roomMemberArr.length != 0) {
            int length = roomMemberArr.length;
            String[] strArr = new String[length];
            int[] iArr = new int[length];
            int[] iArr2 = new int[length];
            int GetRoomMembers = GCloudVoiceEngineHelper.GetRoomMembers(str, strArr, iArr, iArr2);
            if (GetRoomMembers > 0) {
                for (int i3 = 0; i3 < GetRoomMembers && i3 < roomMemberArr.length; i3++) {
                    RoomMember roomMember = roomMemberArr[i3];
                    if (roomMember == null) {
                        ApolloVoiceLog.LogI("getroommbers ret=" + GetRoomMembers + " but roommembers is null,maybe you need new it");
                        return 0;
                    }
                    roomMember.openid = strArr[i3];
                    roomMember.memberid = iArr[i3];
                    roomMember.status = iArr2[i3];
                }
            }
            return GetRoomMembers;
        }
        return GCloudVoiceEngineHelper.GetRoomMembers(str, null, null, null);
    }

    public int GetSpeakerLevel() {
        return GCloudVoiceEngineHelper.GetSpeakerLevel();
    }

    public int GetSpeakerState() {
        return GCloudVoiceEngineHelper.GetSpeakerState();
    }

    public int Invoke(int i3, int i16, int i17, int[] iArr) {
        return GCloudVoiceEngineHelper.Invoke(i3, i16, i17, iArr);
    }

    public int IsRecordComplete(boolean z16) {
        return GCloudVoiceEngineHelper.IsRecordComplete(z16);
    }

    public int IsSaveMagicFile(boolean z16) {
        return GCloudVoiceEngineHelper.IsSaveMagicFile(z16);
    }

    public int IsSpeaking() {
        return GCloudVoiceEngineHelper.IsSpeaking();
    }

    public int JoinNationalRoom_Scenes(String str, String str2, int i3, int i16) {
        return GCloudVoiceEngineHelper.JoinNationalRoomByScenes(str, str2, i3, i16);
    }

    public int JoinNationalRoom_Token(String str, int i3, String str2, int i16, int i17) {
        return GCloudVoiceEngineHelper.JoinNationalRoom(str, i3, str2, i16, i17);
    }

    public int JoinRangeRoom_Scenes(String str, String str2, int i3) {
        return GCloudVoiceEngineHelper.JoinRangeRoomByScenes(str, str2, i3);
    }

    public int JoinTeamRoom_Scenes(String str, String str2, int i3) {
        return GCloudVoiceEngineHelper.JoinTeamRoomByScenes(str, str2, i3);
    }

    public int JoinTeamRoom_Token(String str, String str2, int i3, int i16) {
        return GCloudVoiceEngineHelper.JoinTeamRoom(str, str2, i3, i16);
    }

    public int PauseBGMPlay() {
        return GCloudVoiceEngineHelper.PauseBGMPlay();
    }

    public int PauseKaraoke() {
        return GCloudVoiceEngineHelper.PauseKaraoke();
    }

    public int QuitRoom_Scenes(String str, int i3) {
        return GCloudVoiceEngineHelper.QuitRoomByScenes(str, i3);
    }

    public int RSTSSpeechToSpeech(int i3, int[] iArr, int i16, String str, int i17, float f16, float f17, int i18) {
        return GCloudVoiceEngineHelper.RSTSSpeechToSpeech(i3, iArr, i16, str, i17, f16, f17, i18);
    }

    public int RSTSSpeechToText(int i3, int[] iArr, int i16, int i17) {
        return GCloudVoiceEngineHelper.RSTSSpeechToText(i3, iArr, i16, i17);
    }

    public int RSTSStartRecording(int i3, int[] iArr, int i16, int i17, int i18) {
        return GCloudVoiceEngineHelper.RSTSStartRecording(i3, iArr, i16, i17, i18);
    }

    public int RSTSStopRecording() {
        return GCloudVoiceEngineHelper.RSTSStopRecording();
    }

    public int ReportPlayer(String[] strArr, int i3, String str) {
        return GCloudVoiceEngineHelper.ReportPlayer(strArr, i3, str);
    }

    public int ResumeBGMPlay() {
        return GCloudVoiceEngineHelper.ResumeBGMPlay();
    }

    public int ResumeKaraoke() {
        return GCloudVoiceEngineHelper.ResumeKaraoke();
    }

    public int RoomGeneralDataChannel(String str, String str2) {
        return GCloudVoiceEngineHelper.RoomGeneralDataChannel(str, str2);
    }

    public int SeekTimeMsForAcc(int i3) {
        return GCloudVoiceEngineHelper.SeekTimeMsForAcc(i3);
    }

    public int SeekTimeMsForPreview(int i3) {
        return GCloudVoiceEngineHelper.SeekTimeMsForPreview(i3);
    }

    public int SetAudience(int[] iArr, String str) {
        return GCloudVoiceEngineHelper.SetAudience(iArr, iArr.length, str);
    }

    public int SetBGMPath(String str) {
        return GCloudVoiceEngineHelper.SetBGMPath(str);
    }

    public int SetBGMPlayTime(int i3) {
        return GCloudVoiceEngineHelper.SeekTimeMsForAcc(i3);
    }

    public int SetBGMVol(int i3) {
        return GCloudVoiceEngineHelper.SetBGMVol(i3);
    }

    public int SetBitRate(int i3) {
        return GCloudVoiceEngineHelper.SetBitRate(i3);
    }

    public int SetCivilBinPath(String str) {
        return GCloudVoiceEngineHelper.SetCivilBinPath(str);
    }

    public int SetDataFree(boolean z16) {
        return GCloudVoiceEngineHelper.SetDataFree(z16);
    }

    public int SetKaraokeAccVol(int i3) {
        return GCloudVoiceEngineHelper.SetKaraokeAccVol(i3);
    }

    public int SetKaraokeVoiceDelay(int i3) {
        return GCloudVoiceEngineHelper.SetKaraokeVoiceDelay(i3);
    }

    public int SetKaraokeVoiceVol(int i3) {
        return GCloudVoiceEngineHelper.SetKaraokeVoiceVol(i3);
    }

    public int SetMagicVoiceMsgType(String str) {
        return GCloudVoiceEngineHelper.SetMagicVoiceMsgType(str);
    }

    public int SetMicVolume(int i3) {
        return GCloudVoiceEngineHelper.SetMicVolume(i3);
    }

    public int SetPlayerInfoAbroad(String[] strArr, int[] iArr, int[] iArr2, int i3) {
        return GCloudVoiceEngineHelper.SetPlayerInfoAbroad(strArr, iArr, iArr2, i3);
    }

    public int SetRSTTServerInfo(String str, String str2, String str3) {
        return GCloudVoiceEngineHelper.SetRSTTServerInfo(str, str2, str3);
    }

    public int SetReportBufferTime(int i3) {
        return GCloudVoiceEngineHelper.SetReportBufferTime(i3);
    }

    public int SetReportedPlayerInfo(String[] strArr, int[] iArr, int i3) {
        return GCloudVoiceEngineHelper.SetReportedPlayerInfo(strArr, iArr, i3);
    }

    public int SetServerInfo(String str) {
        return GCloudVoiceEngineHelper.SetServerInfo(str);
    }

    public int SetSpeakerVolume(int i3) {
        return GCloudVoiceEngineHelper.SetSpeakerVolume(i3);
    }

    public int SetVoiceEffects(int i3) {
        return GCloudVoiceEngineHelper.SetVoiceEffects(i3);
    }

    public int SpeechFileToText(String str, int i3, int i16, int i17) {
        return GCloudVoiceEngineHelper.SpeechFileToText(str, i3, i16, i17);
    }

    public int SpeechFileTranslate(String str, int i3, int i16, int i17, float f16, float f17, int i18) {
        return GCloudVoiceEngineHelper.SpeechFileTranslate(str, i3, i16, i17, f16, f17, i18);
    }

    public int SpeechToText_Token(String str, String str2, int i3, int i16, int i17) {
        return GCloudVoiceEngineHelper.SpeechToText(str, str2, i3, i16, i17);
    }

    public int SpeechTranslate(String str, int i3, int i16, int i17, int i18) {
        return GCloudVoiceEngineHelper.SpeechTranslate(str, i3, i16, i17, i18);
    }

    public int StartBGMPlay() {
        return GCloudVoiceEngineHelper.StartBGMPlay();
    }

    public int StartKaraokeRecording(String str, String str2, String str3) {
        return GCloudVoiceEngineHelper.StartKaraokeRecording(str, str2, str3);
    }

    public int StartPreview() {
        return GCloudVoiceEngineHelper.StartPreview();
    }

    public int StopBGMPlay() {
        return GCloudVoiceEngineHelper.StopBGMPlay();
    }

    public int StopKaraokeRecording() {
        return GCloudVoiceEngineHelper.StopKaraokeRecording();
    }

    public int StopPreview() {
        return GCloudVoiceEngineHelper.StopPreview();
    }

    public int TestMic() {
        return GCloudVoiceEngineHelper.TestMic();
    }

    public int TextToSpeech(String str, int i3, int i16, int i17) {
        return GCloudVoiceEngineHelper.TextToSpeech(str, i3, i16, i17);
    }

    public int TextToSpeechFile(String str, int i3, String str2, int i16, float f16, float f17, int i17) {
        return GCloudVoiceEngineHelper.TextToSpeechFile(str, i3, str2, i16, f16, f17, i17);
    }

    public int TextToStreamSpeechStart(String str, String str2, int i3, String str3) {
        return GCloudVoiceEngineHelper.TextToStreamSpeechStart(str, str2, i3, str3);
    }

    public int TextToStreamSpeechStop() {
        return GCloudVoiceEngineHelper.TextToStreamSpeechStop();
    }

    public int TextTranslate(String str, int i3, int i16, int i17) {
        return GCloudVoiceEngineHelper.TextTranslate(str, i3, i16, i17);
    }

    public int UploadRecordedFile(String str, int i3, boolean z16) {
        return GCloudVoiceEngineHelper.UploadRecordedFile(str, i3, z16);
    }

    public int ForbidMemberVoice(int i3, boolean z16, String str) {
        return GCloudVoiceEngineHelper.ForbidMemberVoice(i3, z16, str);
    }
}

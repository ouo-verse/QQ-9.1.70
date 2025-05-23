package com.gcloudsdk.gcloud.voice;

import android.app.Activity;
import android.content.Context;
import com.gcloudsdk.apollo.ApolloVoiceDeviceMgr;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudVoiceEngine extends GCloudVoiceEngineExtension {
    private static volatile GCloudVoiceEngine _instance;
    private Context appContext = null;
    private GCloudVoiceEngineHelper JNIHelper = new GCloudVoiceEngineHelper();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class TaskID {
        public int ID = -1;

        public TaskID() {
        }
    }

    static {
        try {
            System.loadLibrary("GVoice");
        } catch (UnsatisfiedLinkError unused) {
            System.err.println("Load library GVoice failed!!!");
            System.exit(1);
        }
    }

    GCloudVoiceEngine() {
        GCloudVoiceEngineHelper.EngineJniInstance();
    }

    public static GCloudVoiceEngine getInstance() {
        if (_instance == null) {
            synchronized (GCloudVoiceEngine.class) {
                if (_instance == null) {
                    _instance = new GCloudVoiceEngine();
                }
            }
        }
        return _instance;
    }

    public int ApplyMessageKey(int i3) {
        return GCloudVoiceEngineHelper.ApplyMessageKey(i3);
    }

    public int ChangeRole(int i3) {
        return GCloudVoiceEngineHelper.ChangeRole(i3, "");
    }

    public int CloseMic() {
        return GCloudVoiceEngineHelper.CloseMic();
    }

    public int CloseSpeaker() {
        return GCloudVoiceEngineHelper.CloseSpeaker();
    }

    public int DownloadRecordedFile(String str, String str2, int i3) {
        return GCloudVoiceEngineHelper.DownloadRecordedFile(str, str2, i3);
    }

    public int Init() {
        return GCloudVoiceEngineHelper.Init();
    }

    public int JoinNationalRoom(String str, int i3, int i16) {
        return GCloudVoiceEngineHelper.JoinNationalRoom(str, i3, i16);
    }

    public int JoinRangeRoom(String str, int i3) {
        return GCloudVoiceEngineHelper.JoinRangeRoom(str, i3);
    }

    public int JoinTeamRoom(String str, int i3) {
        return GCloudVoiceEngineHelper.JoinTeamRoom(str, i3);
    }

    public int OpenMic() {
        return GCloudVoiceEngineHelper.OpenMic();
    }

    public int OpenSpeaker() {
        return GCloudVoiceEngineHelper.OpenSpeaker();
    }

    public int Pause() {
        return GCloudVoiceEngineHelper.Pause();
    }

    public int PlayRecordedFile(String str) {
        return GCloudVoiceEngineHelper.PlayRecordedFile(str);
    }

    public int Poll() {
        return GCloudVoiceEngineHelper.Poll();
    }

    public int QuitRoom(String str, int i3) {
        return GCloudVoiceEngineHelper.QuitRoom(str, i3);
    }

    public int Resume() {
        return GCloudVoiceEngineHelper.Resume();
    }

    public int SetAppInfo(String str, String str2, String str3) {
        return GCloudVoiceEngineHelper.SetAppInfo(str, str2, str3);
    }

    public int SetMode(int i3) {
        return GCloudVoiceEngineHelper.SetMode(i3);
    }

    public int SetNotify(IGCloudVoiceNotify iGCloudVoiceNotify) {
        ApolloVoiceDeviceMgr.setGCloudVoiceNotify(iGCloudVoiceNotify);
        return GCloudVoiceEngineHelper.SetNotify(iGCloudVoiceNotify);
    }

    public int SpeechToText(String str, int i3, int i16) {
        return GCloudVoiceEngineHelper.SpeechToText(str, i3, i16);
    }

    public int StartRecording(String str) {
        return GCloudVoiceEngineHelper.StartRecording(str);
    }

    public int StopPlayFile() {
        return GCloudVoiceEngineHelper.StopPlayFile();
    }

    public int StopRecording() {
        return GCloudVoiceEngineHelper.StopRecording();
    }

    public int UpdateCoordinate(String str, long j3, long j16, long j17, long j18) {
        return GCloudVoiceEngineHelper.UpdateCoordinate(str, j3, j16, j17, j18);
    }

    public int UploadRecordedFile(String str, int i3) {
        return GCloudVoiceEngineHelper.UploadRecordedFile(str, i3);
    }

    public int init(Context context, Activity activity) {
        ApolloVoiceDeviceMgr.ApolloVoiceDeviceInit(context, activity);
        if (context != null) {
            GCloudVoiceEngineHelper.AndroidInit();
            return 0;
        }
        return 0;
    }

    public int ChangeRole(int i3, String str) {
        return GCloudVoiceEngineHelper.ChangeRole(i3, str);
    }
}

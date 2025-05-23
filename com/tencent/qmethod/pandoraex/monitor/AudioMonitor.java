package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.media.MediaSyncEvent;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioMonitor {
    private static final String SYSTEM_CALL_AUDIO = "call system api:AudioRecord.";
    private static final String TAG = "AudioMonitor";

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void setAudioSource(MediaRecorder mediaRecorder, int i3) throws IllegalStateException {
        if (i3 != 1) {
            mediaRecorder.setAudioSource(i3);
        } else if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("recorder", "MR#SET_AUD_SRC#I", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            mediaRecorder.setAudioSource(i3);
        }
    }

    public static void start(MediaRecorder mediaRecorder) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("recorder", "MR#STRT", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            mediaRecorder.start();
        }
    }

    public static void startRecording(AudioRecord audioRecord) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("recorder", "AR#STRT_REC", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            audioRecord.startRecording();
        }
    }

    @SuppressLint({"NewApi"})
    public static void startRecording(AudioRecord audioRecord, MediaSyncEvent mediaSyncEvent) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("recorder", "AR#STRT_REC#M", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            audioRecord.startRecording(mediaSyncEvent);
        }
    }
}

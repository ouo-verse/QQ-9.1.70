package com.tencent.avcore.jni.audiodevice;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.avcore.jni.NtrtcAudioDevice;
import com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes3.dex */
public class AudioDeviceInterface {
    static IPatchRedirector $redirector_ = null;
    private static final int DEVICE_RET_CODE_RECORD_MANAGER_IS_NULL = -3;
    private static final int DEVICE_RET_CODE_RECORD_NOT_STARTED = -1;
    private static final int DEVICE_RET_CODE_RECORD_READ_FAILED = -6;
    private static final int DEVICE_RET_CODE_RECORD_READ_LEN_ERROR = -7;
    private static final int DEVICE_RET_CODE_RECORD_RECORDER_IS_NULL = -2;
    private static final int DEVICE_RET_CODE_RECORD_START_FAILED = -5;
    private static final int DEVICE_RET_CODE_RECORD_STOP_FAILED = -4;
    private static final String TAG = "AudioDeviceInterface";
    private static boolean _dumpEnable;
    private static boolean _logEnable;
    private boolean _IsBluetoothStreamVolume;
    private int _RecordSamplerate;
    private NtrtcAudioDevice _ad;
    private AudioManager _audioManager;
    private AudioRecord _audioRecord;
    private boolean _audioRecordChanged;
    private boolean _audioRouteChanged;
    private int _audioSource;
    private int _audioSourcePolicy;
    private int _audioStreamTypePolicy;
    private AudioTrack _audioTrack;
    private int _bufferedPlaySamples;
    private int _bufferedRecSamples;
    private int _channelPlayType;
    private int _channelRecordType;
    private String _connectedDev;
    private Context _context;
    private boolean _doPlayInit;
    private boolean _doRecInit;
    private boolean _isPlaying;
    private boolean _isRecording;
    private int _modePolicy;
    private ByteBuffer _playBuffer;
    private int _playPosition;
    private int _playSamplerate;
    private File _play_dump;
    private FileOutputStream _play_out;
    private ByteBuffer _recBuffer;
    private File _rec_dump;
    private FileOutputStream _rec_out;
    private int _sessionId;
    private int _streamType;
    private byte[] _tempBufPlay;
    private byte[] _tempBufRec;
    private int mAudioScene;
    private int switchState;
    private boolean usingJava;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13612);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            _dumpEnable = false;
            _logEnable = true;
        }
    }

    public AudioDeviceInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this._audioTrack = null;
        this._audioRecord = null;
        this._streamType = 0;
        this._playSamplerate = 8000;
        this._RecordSamplerate = 8000;
        this._audioSource = 0;
        this._sessionId = 0;
        this._context = null;
        this._modePolicy = -1;
        this._audioSourcePolicy = -1;
        this._audioStreamTypePolicy = -1;
        this._audioManager = null;
        this._doPlayInit = true;
        this._doRecInit = true;
        this._isRecording = false;
        this._isPlaying = false;
        this._bufferedRecSamples = 0;
        this._bufferedPlaySamples = 0;
        this._playPosition = 0;
        this._rec_dump = null;
        this._play_dump = null;
        this._rec_out = null;
        this._play_out = null;
        this._channelPlayType = 4;
        this._channelRecordType = 4;
        this._IsBluetoothStreamVolume = false;
        this._ad = null;
        this._connectedDev = TraeConstants.DEVICE_NONE;
        this._audioRouteChanged = false;
        this._audioRecordChanged = false;
        this.mAudioScene = 0;
        this.usingJava = true;
        this.switchState = 0;
        try {
            this._playBuffer = ByteBuffer.allocateDirect(1920);
            this._recBuffer = ByteBuffer.allocateDirect(1920);
        } catch (Exception e16) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, e16.getMessage());
            }
        }
        this._tempBufPlay = new byte[1920];
        this._tempBufRec = new byte[1920];
        int i3 = Build.VERSION.SDK_INT;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "AudioDeviceInterface apiLevel:" + i3);
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, " SDK_INT:" + i3);
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "manufacture:" + Build.MANUFACTURER);
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "MODEL:" + DeviceInfoMonitor.getModel());
        }
    }

    private int GetPlayoutVolume() {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService("audio");
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager != null) {
            return SystemMethodProxy.getStreamVolume(audioManager, 0);
        }
        return -1;
    }

    private int InitPlayback(int i3, int i16) {
        int streamType;
        int i17;
        AVCoreLog.i(TAG, "InitPlayback start. sampleRate: " + i3 + ", nChannels: " + i16);
        if (this._isPlaying) {
            AVCoreLog.i(TAG, "InitPlayback end. _isPlaying: true.");
            return 0;
        }
        int i18 = 2;
        if (i16 <= 2 && i16 >= 1) {
            if (this._audioManager == null) {
                try {
                    this._audioManager = (AudioManager) this._context.getSystemService("audio");
                } catch (Exception e16) {
                    AVCoreLog.e(TAG, "InitPlayback failed. err: " + e16.getMessage());
                    return -2;
                }
            }
            if (i16 == 2) {
                this._channelPlayType = 12;
            } else {
                this._channelPlayType = 4;
            }
            this._playSamplerate = i3;
            int minBufferSize = AudioTrack.getMinBufferSize(i3, this._channelPlayType, 2);
            int i19 = (((i3 * 20) * i16) * 2) / 1000;
            this._bufferedPlaySamples = 0;
            AVCoreLog.i(TAG, "InitPlayback... minPlayBufSize:" + minBufferSize + " 20msFz:" + i19 + ", _channelPlayType: " + this._channelPlayType + ", _audioRouteChanged: " + this._audioRouteChanged);
            AudioTrack audioTrack = this._audioTrack;
            if (audioTrack != null) {
                audioTrack.release();
                this._audioTrack = null;
            }
            int[] iArr = {0, 0, 3, 1};
            this._streamType = TraeUtils.getAudioStreamType(this._audioStreamTypePolicy);
            if (this._audioRouteChanged) {
                if (this._audioManager.getMode() == 0 && this._connectedDev.equals(TraeConstants.DEVICE_SPEAKERPHONE)) {
                    this._streamType = 3;
                } else {
                    this._streamType = 0;
                }
                this._audioRouteChanged = false;
            }
            if (this.mAudioScene == 5) {
                this._streamType = 3;
            }
            iArr[0] = this._streamType;
            int i26 = 0;
            int i27 = minBufferSize;
            for (int i28 = 4; i26 < i28 && this._audioTrack == null; i28 = 4) {
                this._streamType = iArr[i26];
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.i(TAG, "InitPlayback: min play buf size is " + minBufferSize + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
                }
                int i29 = 1;
                while (true) {
                    if (i29 > i18) {
                        break;
                    }
                    int i36 = minBufferSize * i29;
                    if (i36 < i19 * 4 && i29 < i18) {
                        i17 = i36;
                    } else {
                        try {
                            i17 = i36;
                            try {
                                ReportAudioTrack reportAudioTrack = new ReportAudioTrack(this._streamType, this._playSamplerate, this._channelPlayType, 2, i17, 1);
                                this._audioTrack = reportAudioTrack;
                                if (reportAudioTrack.getState() != 1) {
                                    AVCoreLog.e(TAG, "InitPlayback failed. state: " + this._audioTrack.getState());
                                    this._audioTrack.release();
                                    this._audioTrack = null;
                                } else {
                                    i27 = i17;
                                    break;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                AVCoreLog.e(TAG, "InitPlayback failed. err: " + e.getMessage() + " _audioTrack:" + this._audioTrack);
                                AudioTrack audioTrack2 = this._audioTrack;
                                if (audioTrack2 != null) {
                                    audioTrack2.release();
                                }
                                this._audioTrack = null;
                                i29++;
                                i27 = i17;
                                i18 = 2;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            i17 = i36;
                        }
                    }
                    i29++;
                    i27 = i17;
                    i18 = 2;
                }
                i26++;
                i18 = 2;
            }
            if (this._audioTrack == null) {
                AVCoreLog.e(TAG, "InitPlayback failed. _audioTrack == null.");
                return -3;
            }
            NtrtcAudioDevice ntrtcAudioDevice = this._ad;
            if (ntrtcAudioDevice != null && this._audioManager != null) {
                ntrtcAudioDevice.voiceCallAudioParamChanged(this._streamType);
            }
            this._playPosition = this._audioTrack.getPlaybackHeadPosition();
            if (this._connectedDev.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                streamType = 6;
            } else {
                streamType = this._audioTrack.getStreamType();
            }
            if (streamType == 6) {
                this._IsBluetoothStreamVolume = true;
            } else {
                this._IsBluetoothStreamVolume = false;
            }
            TraeUtils.forceVolumeControlStream(this._audioManager, streamType);
            AVCoreLog.i(TAG, "InitPlayback end. streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i27);
            return 0;
        }
        AVCoreLog.e(TAG, "InitPlayback failed. nChannels: " + i16);
        return -1;
    }

    private int InitRecording(int i3, int i16) {
        int i17;
        int[] iArr;
        int i18;
        int i19;
        int i26;
        AVCoreLog.i(TAG, "InitRecording start. sampleRate: " + i3 + ", nChannels: " + i16);
        if (this._isRecording) {
            AVCoreLog.i(TAG, "InitRecording end. _isRecording: true.");
            return 0;
        }
        if (i16 <= 2 && i16 >= 1) {
            if (this._audioManager == null) {
                try {
                    this._audioManager = (AudioManager) this._context.getSystemService("audio");
                } catch (Exception e16) {
                    AVCoreLog.e(TAG, "InitRecording failed. err: " + e16.getMessage());
                    return -2;
                }
            }
            this._channelRecordType = 16;
            if (i16 == 2) {
                this._channelRecordType = 12;
            }
            this._RecordSamplerate = i3;
            int minBufferSize = AudioRecord.getMinBufferSize(i3, this._channelRecordType, 2);
            int i27 = (((i3 * 20) * i16) * 2) / 1000;
            this._bufferedRecSamples = (i3 * 5) / 200;
            AVCoreLog.i(TAG, "InitRecording... min rec buf size is " + minBufferSize + " sr:" + getLowlatencySamplerate() + " fp:" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i27 + ", _bufferedRecSamples: " + this._bufferedRecSamples);
            AudioRecord audioRecord = this._audioRecord;
            if (audioRecord != null) {
                audioRecord.release();
                this._audioRecord = null;
            }
            int i28 = 4;
            int[] iArr2 = {0, 1, 5, 0};
            iArr2[0] = TraeUtils.getAudioSource(this._audioSourcePolicy);
            if (this._audioRecordChanged) {
                if (this._audioManager.getMode() == 0 && this._connectedDev.equals(TraeConstants.DEVICE_SPEAKERPHONE)) {
                    iArr2[0] = TraeUtils.getAudioSource(0);
                } else {
                    iArr2[0] = TraeUtils.getAudioSource(7);
                }
                AVCoreLog.i(TAG, "InitRecording... _audioRecordChanged as[0]:" + iArr2[0]);
                this._audioRecordChanged = false;
            }
            int i29 = 0;
            int i36 = minBufferSize;
            while (i29 < i28 && this._audioRecord == null) {
                this._audioSource = iArr2[i29];
                int i37 = 1;
                while (true) {
                    if (i37 <= 2) {
                        int i38 = minBufferSize * i37;
                        if (i38 < i27 * 4 && i37 < 2) {
                            i19 = i38;
                            i26 = i37;
                            i17 = i29;
                            iArr = iArr2;
                            i18 = i28;
                        } else {
                            try {
                                try {
                                    i19 = i38;
                                    i26 = i37;
                                    i17 = i29;
                                    iArr = iArr2;
                                    i18 = 4;
                                    try {
                                        AudioRecord audioRecord2 = new AudioRecord(this._audioSource, i3, this._channelRecordType, 2, i19);
                                        this._audioRecord = audioRecord2;
                                        if (audioRecord2.getState() != 1) {
                                            AVCoreLog.e(TAG, "InitRecording failed. state: " + this._audioRecord.getState());
                                            this._audioRecord.release();
                                            this._audioRecord = null;
                                        } else {
                                            i36 = i19;
                                            break;
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                        AVCoreLog.e(TAG, "InitRecording failed. err: " + e.getMessage() + " _audioRecord:" + this._audioRecord);
                                        AudioRecord audioRecord3 = this._audioRecord;
                                        if (audioRecord3 != null) {
                                            audioRecord3.release();
                                        }
                                        this._audioRecord = null;
                                        i37 = i26 + 1;
                                        i28 = i18;
                                        i36 = i19;
                                        i29 = i17;
                                        iArr2 = iArr;
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    i19 = i38;
                                    i26 = i37;
                                    i17 = i29;
                                    iArr = iArr2;
                                    i18 = 4;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                i19 = i38;
                                i26 = i37;
                                i17 = i29;
                                iArr = iArr2;
                                i18 = i28;
                            }
                        }
                        i37 = i26 + 1;
                        i28 = i18;
                        i36 = i19;
                        i29 = i17;
                        iArr2 = iArr;
                    } else {
                        i17 = i29;
                        iArr = iArr2;
                        i18 = i28;
                        break;
                    }
                }
                i29 = i17 + 1;
                i28 = i18;
                iArr2 = iArr;
            }
            if (this._audioRecord == null) {
                AVCoreLog.e(TAG, "InitRecording failed. _audioRecord == null.");
                return -3;
            }
            AVCoreLog.i(TAG, "InitRecording end. audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + i3 + " recBufSize:" + i36);
            return this._bufferedRecSamples;
        }
        AVCoreLog.e(TAG, "InitRecording failed. nChannels: " + i16);
        return -1;
    }

    private int InitSetting(int i3, int i16, int i17) {
        this._audioSourcePolicy = i3;
        this._audioStreamTypePolicy = i16;
        this._modePolicy = i17;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy);
            return 0;
        }
        return 0;
    }

    public static final void LogTraceEntry(String str) {
        if (!_logEnable) {
            return;
        }
        String str2 = getTraceInfo() + " entry:" + str;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, str2);
        }
    }

    public static final void LogTraceExit() {
        if (!_logEnable) {
            return;
        }
        String str = getTraceInfo() + " exit";
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, str);
        }
    }

    private int OpenslesNeedResetAudioTrack(boolean z16) {
        Context context;
        try {
        } catch (Exception e16) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "PlayAudio Exception: " + e16.getMessage());
            }
        }
        if (this._modePolicy != -1 && TraeUtils.isCloseSystemAPM()) {
            if (this._audioRouteChanged || z16) {
                if (this._audioManager == null && (context = this._context) != null) {
                    this._audioManager = (AudioManager) context.getSystemService("audio");
                }
                AudioManager audioManager = this._audioManager;
                if (audioManager == null) {
                    return 0;
                }
                if (audioManager.getMode() == 0 && this._connectedDev.equals(TraeConstants.DEVICE_SPEAKERPHONE)) {
                    this._audioStreamTypePolicy = 3;
                } else {
                    this._audioStreamTypePolicy = 0;
                }
                this._audioRouteChanged = false;
                this._audioRecordChanged = false;
            }
            return this._audioStreamTypePolicy;
        }
        return -1;
    }

    private int PlayAudio(int i3) {
        boolean z16;
        Context context;
        int streamType;
        int i16;
        Object obj;
        Object obj2;
        FileOutputStream fileOutputStream;
        int i17 = i3;
        if (this._isPlaying && this._audioTrack != null) {
            int i18 = 0;
            try {
                int i19 = 1;
                if (this._doPlayInit) {
                    try {
                        Process.setThreadPriority(-19);
                    } catch (Exception e16) {
                        AVCoreLog.e(TAG, "PlayAudio failed. setThreadPriority failed. err: " + e16.getMessage());
                    }
                    this._doPlayInit = false;
                }
                if (_dumpEnable && (fileOutputStream = this._play_out) != null) {
                    try {
                        fileOutputStream.write(this._tempBufPlay, 0, 0);
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                if (!this._audioRouteChanged) {
                    z16 = false;
                } else {
                    if (this._audioManager == null && (context = this._context) != null) {
                        this._audioManager = (AudioManager) context.getSystemService("audio");
                    }
                    if (this._audioManager.getMode() == 0 && this._connectedDev.equals(TraeConstants.DEVICE_SPEAKERPHONE)) {
                        this._streamType = 3;
                    } else {
                        this._streamType = 0;
                    }
                    if (this._streamType == this._audioTrack.getStreamType()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    this._audioRouteChanged = false;
                }
                this._playBuffer.get(this._tempBufPlay);
                if (z16) {
                    AVCoreLog.i(TAG, "PlayAudio. _needResetAudioTrack.  _streamType: " + this._streamType + ", at.st: " + this._audioTrack.getStreamType());
                    try {
                        this._playBuffer.rewind();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        Object obj3 = null;
                        if (this._audioTrack.getPlayState() == 3) {
                            try {
                                AVCoreLog.i(TAG, "StopPlayback stoping...");
                                this._audioTrack.stop();
                                AVCoreLog.i(TAG, "StopPlayback flushing... state: " + this._audioTrack.getPlayState());
                                this._audioTrack.flush();
                                AVCoreLog.i(TAG, "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
                                this._audioTrack.release();
                                this._audioTrack = null;
                            } catch (IllegalStateException e18) {
                                AVCoreLog.e(TAG, "StopPlayback failed. err: " + e18.getMessage());
                            }
                        }
                        int i26 = 2;
                        int minBufferSize = AudioTrack.getMinBufferSize(this._playSamplerate, this._channelPlayType, 2);
                        int i27 = 4;
                        int[] iArr = {0, 0, 3, 1};
                        iArr[0] = this._streamType;
                        int i28 = (((this._playSamplerate * 20) * 1) * 2) / 1000;
                        if (this._channelPlayType == 12) {
                            i28 *= 2;
                        }
                        int i29 = i28;
                        while (i18 < i27 && this._audioTrack == null) {
                            this._streamType = iArr[i18];
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(TAG, "InitPlayback: min play buf size is " + minBufferSize + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
                            }
                            int i36 = i19;
                            while (true) {
                                if (i36 <= i26) {
                                    int i37 = minBufferSize * i36;
                                    if (i37 < i29 * 4 && i36 < i26) {
                                        i16 = i19;
                                    } else {
                                        try {
                                            try {
                                                this._audioTrack = new ReportAudioTrack(this._streamType, this._playSamplerate, this._channelPlayType, 2, i37, 1);
                                                if (AVCoreLog.isColorLevel()) {
                                                    AVCoreLog.e(TAG, " _audioTrack:" + this._audioTrack);
                                                }
                                                i16 = 1;
                                                if (this._audioTrack.getState() != 1) {
                                                    if (AVCoreLog.isColorLevel()) {
                                                        AVCoreLog.e(TAG, "InitPlayback: play not initialized playBufSize:" + i37 + " sr:" + this._playSamplerate);
                                                    }
                                                    this._audioTrack.release();
                                                    this._audioTrack = null;
                                                } else {
                                                    obj = null;
                                                    break;
                                                }
                                            } catch (Exception e19) {
                                                e = e19;
                                                i16 = 1;
                                                if (AVCoreLog.isColorLevel()) {
                                                    AVCoreLog.e(TAG, e.getMessage() + " _audioTrack:" + this._audioTrack);
                                                }
                                                AudioTrack audioTrack = this._audioTrack;
                                                if (audioTrack != null) {
                                                    audioTrack.release();
                                                }
                                                obj2 = null;
                                                this._audioTrack = null;
                                                i36++;
                                                i26 = 2;
                                                int i38 = i16;
                                                obj3 = obj2;
                                                i19 = i38;
                                            }
                                        } catch (Exception e26) {
                                            e = e26;
                                            i16 = i19;
                                        }
                                    }
                                    obj2 = null;
                                    i36++;
                                    i26 = 2;
                                    int i382 = i16;
                                    obj3 = obj2;
                                    i19 = i382;
                                } else {
                                    Object obj4 = obj3;
                                    i16 = i19;
                                    obj = obj4;
                                    break;
                                }
                            }
                            i18++;
                            i26 = 2;
                            i27 = 4;
                            int i39 = i16;
                            obj3 = obj;
                            i19 = i39;
                        }
                        AudioTrack audioTrack2 = this._audioTrack;
                        if (audioTrack2 != null) {
                            try {
                                audioTrack2.play();
                                this._ad.voiceCallAudioParamChanged(this._streamType);
                                AudioManager audioManager = this._audioManager;
                                if (this._connectedDev.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                                    streamType = 6;
                                } else {
                                    streamType = this._audioTrack.getStreamType();
                                }
                                TraeUtils.forceVolumeControlStream(audioManager, streamType);
                            } catch (Exception unused) {
                            }
                        }
                        if (AVCoreLog.isColorLevel()) {
                            AVCoreLog.e(TAG, "  track reset used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                            return i17;
                        }
                        return i17;
                    } catch (Exception e27) {
                        e = e27;
                    }
                } else {
                    int write = this._audioTrack.write(this._tempBufPlay, 0, i17);
                    try {
                        this._playBuffer.rewind();
                        if (write < 0) {
                            AVCoreLog.e(TAG, "PlayAudio failed. Could not write data from sc (write = " + write + ", length = " + i17 + ")");
                            return -2;
                        }
                        if (write != i17 && AVCoreLog.isColorLevel()) {
                            AVCoreLog.e(TAG, "Could not write all data from sc (write = " + write + ", length = " + i17 + ")");
                        }
                        this._bufferedPlaySamples += write >> 1;
                        int playbackHeadPosition = this._audioTrack.getPlaybackHeadPosition();
                        if (playbackHeadPosition < this._playPosition) {
                            this._playPosition = 0;
                        }
                        this._bufferedPlaySamples -= playbackHeadPosition - this._playPosition;
                        this._playPosition = playbackHeadPosition;
                        boolean z17 = this._isRecording;
                        return write;
                    } catch (Exception e28) {
                        e = e28;
                        i17 = write;
                    }
                }
            } catch (Exception e29) {
                e = e29;
                i17 = 0;
            }
            AVCoreLog.e(TAG, "PlayAudio failed. err: " + e.getMessage());
            return i17;
        }
        AVCoreLog.e(TAG, "PlayAudio failed. _isPlaying: " + this._isPlaying + ", _audioTrack: " + this._audioTrack);
        return -1;
    }

    private int RecordAudio(int i3) {
        boolean z16;
        Context context;
        FileOutputStream fileOutputStream;
        if (this._isRecording && this._audioRecord != null) {
            int i16 = 0;
            try {
                if (this._doRecInit) {
                    try {
                        Process.setThreadPriority(-19);
                    } catch (Exception e16) {
                        AVCoreLog.e(TAG, "RecordAudio failed. setThreadPriority failed. err: " + e16.getMessage());
                    }
                    this._doRecInit = false;
                }
                if (!this._audioRecordChanged) {
                    z16 = false;
                } else {
                    if (this._audioManager == null && (context = this._context) != null) {
                        this._audioManager = (AudioManager) context.getSystemService("audio");
                    }
                    AudioManager audioManager = this._audioManager;
                    if (audioManager == null) {
                        return -3;
                    }
                    if (audioManager.getMode() == 0 && this._connectedDev.equals(TraeConstants.DEVICE_SPEAKERPHONE)) {
                        this._audioSource = TraeUtils.getAudioSource(0);
                    } else {
                        this._audioSource = TraeUtils.getAudioSource(7);
                    }
                    if (this._audioSource == this._audioRecord.getAudioSource()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    this._audioRecordChanged = false;
                }
                if (z16) {
                    AVCoreLog.i(TAG, "RecordAudio. _needResetAudioRecord: true.");
                    this._recBuffer.rewind();
                    if (this._audioRecord.getRecordingState() == 3) {
                        try {
                            AVCoreLog.i(TAG, "StopRecording stop... state: " + this._audioRecord.getRecordingState());
                            this._audioRecord.stop();
                        } catch (IllegalStateException e17) {
                            AVCoreLog.e(TAG, "StopRecording stop failed. err: " + e17.getMessage());
                            e17.printStackTrace();
                            return -4;
                        }
                    }
                    AVCoreLog.i(TAG, "StopRecording releaseing... state: " + this._audioRecord.getRecordingState());
                    this._audioRecord.release();
                    this._audioRecord = null;
                    int i17 = 2;
                    int minBufferSize = AudioRecord.getMinBufferSize(this._RecordSamplerate, this._channelRecordType, 2);
                    int[] iArr = {0, 1, 5, 0};
                    iArr[0] = TraeUtils.getAudioSource(this._audioSource);
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.e(TAG, "ReInitRecording: " + iArr[0]);
                    }
                    int i18 = (((this._RecordSamplerate * 20) * 1) * 2) / 1000;
                    if (this._channelRecordType == 12) {
                        i18 *= 2;
                    }
                    int i19 = i18;
                    int i26 = 0;
                    for (int i27 = 4; i26 < i27 && this._audioRecord == null; i27 = 4) {
                        this._audioSource = iArr[i26];
                        int i28 = 1;
                        while (i28 <= i17) {
                            int i29 = minBufferSize * i28;
                            if (i29 >= i19 * 4 || i28 >= i17) {
                                try {
                                    AudioRecord audioRecord = new AudioRecord(this._audioSource, this._RecordSamplerate, this._channelRecordType, 2, i29);
                                    this._audioRecord = audioRecord;
                                    if (audioRecord.getState() != 1) {
                                        if (AVCoreLog.isColorLevel()) {
                                            AVCoreLog.e(TAG, "InitRecording:  rec not initialized,try agine,  minbufsize:" + i29 + " sr:" + this._RecordSamplerate + " as:" + this._audioSource);
                                        }
                                        this._audioRecord.release();
                                        this._audioRecord = null;
                                    }
                                } catch (Exception e18) {
                                    if (AVCoreLog.isColorLevel()) {
                                        AVCoreLog.e(TAG, e18.getMessage() + " _audioRecord:" + this._audioRecord);
                                    }
                                    AudioRecord audioRecord2 = this._audioRecord;
                                    if (audioRecord2 != null) {
                                        audioRecord2.release();
                                    }
                                    this._audioRecord = null;
                                }
                            }
                            i28++;
                            i17 = 2;
                        }
                        i26++;
                        i17 = 2;
                    }
                    AudioRecord audioRecord3 = this._audioRecord;
                    if (audioRecord3 == null) {
                        return 0;
                    }
                    try {
                        AudioMonitor.startRecording(audioRecord3);
                        return 0;
                    } catch (IllegalStateException e19) {
                        AVCoreLog.e(TAG, "StartRecording failed. err: " + e19.getMessage());
                        e19.printStackTrace();
                        return -5;
                    }
                }
                this._recBuffer.rewind();
                int read = this._audioRecord.read(this._tempBufRec, 0, i3);
                try {
                    if (read < 0) {
                        AVCoreLog.e(TAG, "RecordAudio failed. Could not read data from sc (read = " + read + ", length = " + i3 + ")");
                        return -6;
                    }
                    this._recBuffer.put(this._tempBufRec, 0, read);
                    if (_dumpEnable && (fileOutputStream = this._rec_out) != null) {
                        try {
                            fileOutputStream.write(this._tempBufRec, 0, read);
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (read != i3) {
                        AVCoreLog.e(TAG, "RecordAudio failed. Could not read all data from sc (read = " + read + ", length = " + i3 + ")");
                        return -7;
                    }
                    return read;
                } catch (Exception e27) {
                    e = e27;
                    i16 = read;
                    AVCoreLog.e(TAG, "RecordAudio failed. err: " + e.getMessage());
                    return i16;
                }
            } catch (Exception e28) {
                e = e28;
                AVCoreLog.e(TAG, "RecordAudio failed. err: " + e.getMessage());
                return i16;
            }
        }
        AVCoreLog.e(TAG, "RecordAudio failed. _isRecording: " + this._isRecording + ", _audioRecord: " + this._audioRecord);
        return -1;
    }

    private int SetPlayoutVolume(int i3) {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService("audio");
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager != null) {
            audioManager.setStreamVolume(0, i3, 0);
            return 0;
        }
        return -1;
    }

    private int StartPlayback() {
        AVCoreLog.i(TAG, "StartPlayback start.");
        if (this._isPlaying) {
            AVCoreLog.i(TAG, "StartPlayback end. _isPlaying: " + this._isPlaying);
            return 0;
        }
        AudioTrack audioTrack = this._audioTrack;
        int i3 = -1;
        if (audioTrack == null) {
            AVCoreLog.e(TAG, "StartPlayback failed. _audioTrack: " + this._audioTrack);
            return -1;
        }
        try {
            audioTrack.play();
            if (_dumpEnable) {
                AudioManager audioManager = this._audioManager;
                if (audioManager != null) {
                    i3 = audioManager.getMode();
                }
                this._play_dump = new File(getDumpFilePath("jniplay.pcm", i3));
                try {
                    this._play_out = new FileOutputStream(this._play_dump);
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
            }
            this._isPlaying = true;
            AVCoreLog.i(TAG, "StartPlayback end.");
            return 0;
        } catch (IllegalStateException e17) {
            AVCoreLog.e(TAG, "StartPlayback failed. err: " + e17.getMessage());
            e17.printStackTrace();
            return -2;
        }
    }

    private int StartRecording() {
        AVCoreLog.i(TAG, "StartRecording start.");
        if (this._isRecording) {
            AVCoreLog.i(TAG, "StartRecording end. _isRecording: " + this._isRecording);
            return 0;
        }
        AudioRecord audioRecord = this._audioRecord;
        int i3 = -1;
        if (audioRecord == null) {
            AVCoreLog.e(TAG, "StartRecording failed. _audioRecord: " + this._audioRecord);
            return -1;
        }
        try {
            AudioMonitor.startRecording(audioRecord);
            if (_dumpEnable) {
                AudioManager audioManager = this._audioManager;
                if (audioManager != null) {
                    i3 = audioManager.getMode();
                }
                this._rec_dump = new File(getDumpFilePath("jnirecord.pcm", i3));
                try {
                    this._rec_out = new FileOutputStream(this._rec_dump);
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
            }
            this._isRecording = true;
            AVCoreLog.i(TAG, "StartRecording end.");
            return 0;
        } catch (IllegalStateException e17) {
            AVCoreLog.e(TAG, "StartRecording failed. err: " + e17.getMessage());
            e17.printStackTrace();
            return -2;
        }
    }

    private int StopPlayback() {
        AVCoreLog.i(TAG, "StopPlayback start.");
        AudioTrack audioTrack = this._audioTrack;
        if (audioTrack == null) {
            AVCoreLog.i(TAG, "StopPlayback end. _audioTrack:" + this._audioTrack);
            return 0;
        }
        if (audioTrack.getPlayState() == 3) {
            try {
                AVCoreLog.i(TAG, "StopPlayback stoping...");
                this._audioTrack.stop();
                AVCoreLog.i(TAG, "StopPlayback flushing... state: " + this._audioTrack.getPlayState());
                this._audioTrack.flush();
            } catch (IllegalStateException e16) {
                AVCoreLog.e(TAG, "StopPlayback failed. err: " + e16.getMessage());
                e16.printStackTrace();
                return -1;
            }
        }
        AVCoreLog.i(TAG, "StopPlayback releaseing... state: " + this._audioTrack.getPlayState());
        this._audioTrack.release();
        this._audioTrack = null;
        this._isPlaying = false;
        AVCoreLog.i(TAG, "StopPlayback end.");
        return 0;
    }

    private int StopRecording() {
        AVCoreLog.i(TAG, "StopRecording start.");
        AudioRecord audioRecord = this._audioRecord;
        if (audioRecord == null) {
            AVCoreLog.i(TAG, "StopRecording end. _audioRecord: " + this._audioRecord);
            return 0;
        }
        if (audioRecord.getRecordingState() == 3) {
            try {
                AVCoreLog.i(TAG, "StopRecording stop... state: " + this._audioRecord.getRecordingState());
                this._audioRecord.stop();
            } catch (IllegalStateException e16) {
                AVCoreLog.e(TAG, "StopRecording failed. err: " + e16.getMessage());
                e16.printStackTrace();
                return -1;
            }
        }
        AVCoreLog.i(TAG, "StopRecording releaseing... state: " + this._audioRecord.getRecordingState());
        this._audioRecord.release();
        this._audioRecord = null;
        this._isRecording = false;
        AVCoreLog.i(TAG, "StopRecording end.");
        return 0;
    }

    @TargetApi(16)
    private int getAudioSessionId(AudioRecord audioRecord) {
        return 0;
    }

    private String getDumpFilePath(String str, int i3) {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "manufacture:" + Build.MANUFACTURER);
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "MODEL:" + DeviceInfoMonitor.getModel());
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + DeviceInfoMonitor.getModel() + "-as-" + TraeUtils.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + i3 + "-" + str;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "dump:" + str2);
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "dump replace:" + str2.replace(" ", "_"));
        }
        return str2.replace(" ", "_");
    }

    private int getLowlatencyFramesPerBuffer() {
        String str;
        Context context = this._context;
        if (context != null) {
            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            if (AVCoreLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("LOW_LATENCY:");
                if (hasSystemFeature) {
                    str = "Y";
                } else {
                    str = "N";
                }
                sb5.append(str);
                AVCoreLog.e(TAG, sb5.toString());
            }
            return 0;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
        }
        return 0;
    }

    private int getLowlatencySamplerate() {
        String str;
        Context context = this._context;
        if (context != null) {
            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            if (AVCoreLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("LOW_LATENCY:");
                if (hasSystemFeature) {
                    str = "Y";
                } else {
                    str = "N";
                }
                sb5.append(str);
                AVCoreLog.e(TAG, sb5.toString());
            }
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "getLowlatencySamplerate not support right now!");
            }
            return 0;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
        }
        return 0;
    }

    public static String getTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        stringBuffer.append("");
        stringBuffer.append(stackTrace[2].getClassName());
        stringBuffer.append(".");
        stringBuffer.append(stackTrace[2].getMethodName());
        stringBuffer.append(MsgSummary.STR_COLON);
        stringBuffer.append(stackTrace[2].getLineNumber());
        return stringBuffer.toString();
    }

    private void initTRAEAudioManager() {
        if (this._context != null) {
            TraeAudioManager.getInstance().init(this._context);
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "initTRAEAudioManager , TraeAudioSession startService");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOutputChanage(String str) {
        AudioManager audioManager;
        String str2;
        String str3;
        String str4;
        int streamType;
        Context context;
        setAudioRouteSwitchState(str);
        this._connectedDev = str;
        if (this._audioManager == null && (context = this._context) != null) {
            try {
                this._audioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception e16) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(TAG, e16.getMessage());
                    return;
                }
                return;
            }
        }
        if (this._audioManager != null && this._audioTrack != null) {
            if (this._connectedDev.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                streamType = 6;
            } else {
                streamType = this._audioTrack.getStreamType();
            }
            boolean z16 = this._IsBluetoothStreamVolume;
            if (z16 && streamType != 6) {
                TraeUtils.forceVolumeControlStream(this._audioManager, streamType);
                this._IsBluetoothStreamVolume = false;
            } else if (!z16 && streamType == 6) {
                TraeUtils.forceVolumeControlStream(this._audioManager, streamType);
                this._IsBluetoothStreamVolume = true;
            }
        }
        if (this._modePolicy != -1 && TraeUtils.isCloseSystemAPM()) {
            if (AVCoreLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" onOutputChanage:");
                sb5.append(str);
                if (this._audioManager == null) {
                    str3 = " am==null";
                } else {
                    str3 = " mode:" + this._audioManager.getMode();
                }
                sb5.append(str3);
                sb5.append(" st:");
                sb5.append(this._streamType);
                if (this._audioTrack == null) {
                    str4 = "_audioTrack==null";
                } else {
                    str4 = " at.st:" + this._audioTrack.getStreamType();
                }
                sb5.append(str4);
                AVCoreLog.e(TAG, sb5.toString());
            }
            try {
                if (this._audioManager == null) {
                    this._audioManager = (AudioManager) this._context.getSystemService("audio");
                }
                if (AVCoreLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(" curr mode:");
                    sb6.append(str);
                    if (this._audioManager == null) {
                        str2 = "am==null";
                    } else {
                        str2 = " mode:" + this._audioManager.getMode();
                    }
                    sb6.append(str2);
                    AVCoreLog.e(TAG, sb6.toString());
                }
                if (this._connectedDev.equals(TraeConstants.DEVICE_SPEAKERPHONE) && (audioManager = this._audioManager) != null) {
                    audioManager.setMode(0);
                }
            } catch (Exception e17) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(TAG, e17.getMessage());
                }
            }
            this._audioRouteChanged = true;
            this._audioRecordChanged = true;
        }
    }

    private void setAudioRouteSwitchState(String str) {
        if (str.equals(TraeConstants.DEVICE_EARPHONE)) {
            this.switchState = 1;
            return;
        }
        if (str.equals(TraeConstants.DEVICE_SPEAKERPHONE)) {
            this.switchState = 2;
            return;
        }
        if (str.equals(TraeConstants.DEVICE_WIRED_HEADSET)) {
            this.switchState = 3;
        } else if (str.equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
            this.switchState = 4;
        } else {
            this.switchState = 0;
        }
    }

    public static native void setPreprocessState(int i3);

    private int sigHowling(int i3) {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "java onHowling flg:" + i3);
        }
        if (this._ad == null) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "onHowling too early" + i3);
                return -1;
            }
            return -1;
        }
        return 0;
    }

    private void uninitTRAEAudioManager() {
        if (this._context != null) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "uninitTRAEAudioManager , stopService");
            }
            TraeAudioManager.getInstance().release();
        } else if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "uninitTRAEAudioManager , context null");
        }
    }

    public int call_postprocess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        this.switchState = 0;
        NtrtcAudioDevice ntrtcAudioDevice = this._ad;
        if (ntrtcAudioDevice != null) {
            ntrtcAudioDevice.voiceCallPostProcess();
            this._ad.release();
            this._ad = null;
        }
        return 0;
    }

    public int call_preprocess(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        this.switchState = 0;
        this._streamType = TraeUtils.getAudioStreamType(this._audioStreamTypePolicy);
        if (i3 == 5) {
            this._streamType = 3;
            this._modePolicy = 0;
            this.mAudioScene = i3;
        }
        if (this._ad == null) {
            NtrtcAudioDevice ntrtcAudioDevice = new NtrtcAudioDevice();
            this._ad = ntrtcAudioDevice;
            ntrtcAudioDevice.init(new ITraeAudioCallback() { // from class: com.tencent.avcore.jni.audiodevice.AudioDeviceInterface.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioDeviceInterface.this);
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onBeginConnectDevice(String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 11)) {
                        iPatchRedirector2.redirect((short) 11, (Object) this, (Object) str);
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onConnectDeviceRes(int i16, String str, boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                        iPatchRedirector2.redirect((short) 6, this, Integer.valueOf(i16), str, Boolean.valueOf(z16));
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onDeviceChangeableUpdate(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onDeviceExternalSwitch(String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 12)) {
                        iPatchRedirector2.redirect((short) 12, (Object) this, (Object) str);
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onDeviceListUpdate(long j3, String[] strArr, String str, String str2, String str3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, Long.valueOf(j3), strArr, str, str2, str3);
                    } else if (AudioDeviceInterface.this.usingJava) {
                        AudioDeviceInterface.this.onOutputChanage(str);
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onGetConnectedDeviceRes(int i16, String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                        iPatchRedirector2.redirect((short) 7, (Object) this, i16, (Object) str);
                    } else if (i16 == 0) {
                        AudioDeviceInterface.this.onOutputChanage(str);
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onGetDeviceListRes(int i16, String[] strArr, String str, String str2, String str3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, this, Integer.valueOf(i16), strArr, str, str2, str3);
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onGetStreamTypeRes(int i16, int i17, int i18) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 9)) {
                        iPatchRedirector2.redirect((short) 9, this, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onServiceStateUpdate(long j3, boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16));
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onStreamTypeUpdate(long j3, int i16, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                        iPatchRedirector2.redirect((short) 8, this, Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }

                @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
                public void onVoiceCallPreProcessRes(int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 10)) {
                        iPatchRedirector2.redirect((short) 10, (Object) this, i16);
                    }
                }
            }, true);
        }
        NtrtcAudioDevice ntrtcAudioDevice2 = this._ad;
        if (ntrtcAudioDevice2 != null) {
            ntrtcAudioDevice2.getConnectedDevice(-1030L);
            this._ad.voiceCallPreProcess(this._modePolicy, this._streamType, this.mAudioScene);
        }
        return 0;
    }

    public int getAudioRouteSwitchState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.switchState;
    }

    public void setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this._context = context;
        }
    }

    public void setJavaInterface(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            this.usingJava = false;
        } else {
            this.usingJava = true;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "setJavaInterface flg:" + i3);
        }
    }
}

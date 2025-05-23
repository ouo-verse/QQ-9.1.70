package com.tencent.mobileqq.tritonaudio.webaudio;

import android.media.MediaFormat;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioDecoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class WebAudioManager {
    public static int SCRIPT_PROCESSOR_AUDIO_NODE_TYPE = 5;
    public static final String TAG = "WebAudioManager";
    private final LogDelegate logDelegate;
    private boolean scriptNodeHasStarted = false;
    public AtomicInteger sAtxId = new AtomicInteger();
    private final HashMap<Integer, AudioContext> audioContextHashMap = new HashMap<>();
    private final HashMap<Integer, Integer> scriptProcessNodeSizeMap = new HashMap<>();
    private final HashMap<Integer, DecodeAsPlayStatus> decodeBufferIdStatusMap = new HashMap<>();
    private final HashMap<Integer, ArrayList<Integer>> decodeBufferIdArrayMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private class DecodeAsPlayStatus {
        public static final int STATUS_DECODE_DONE = 3;
        public static final int STATUS_DECODING_WITHOUT_SET_QUEUE = 1;
        public static final int STATUS_DECODING_WITH_ALREADY_SETTED_QUEUE = 2;
        public static final int STATUS_INIT = 0;
        private int status = 0;
        private int decodeId = -1;
        private ArrayList<Integer> channelIdList = new ArrayList<>();

        public DecodeAsPlayStatus() {
        }
    }

    public WebAudioManager(LogDelegate logDelegate) {
        this.logDelegate = logDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer(final Argument argument, final int i3, final int i16) {
        TritonAudioThreadPool.getAudioThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (AudioNativeManager.isSourceStopped(i3)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(WebAudioPlugin.AUDIO_ID, i16);
                        jSONObject.put("channelId", i3);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    Argument argument2 = argument;
                    if (argument2 != null) {
                        argument2.subscribe(WebAudioPlugin.API_ON_SOURCE_ENDED, jSONObject.toString());
                        return;
                    }
                }
                TritonAudioThreadPool.getAudioThreadPool().schedule(this, 1000L, TimeUnit.MILLISECONDS);
            }
        });
    }

    public void closeAudioContext() {
        if (this.audioContextHashMap.isEmpty()) {
            return;
        }
        AudioNativeManager.closeAudioContext();
        this.audioContextHashMap.clear();
        this.decodeBufferIdArrayMap.clear();
        this.decodeBufferIdStatusMap.clear();
    }

    public int copyToChannel(byte[] bArr, int i3, int i16, int i17, int i18) {
        return AudioNativeManager.copyToChannel(bArr, i3, i16, i17, i18);
    }

    public JSONObject createAudioContext() {
        int incrementAndGet = this.sAtxId.incrementAndGet();
        this.audioContextHashMap.put(Integer.valueOf(incrementAndGet), new AudioContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WebAudioPlugin.AUDIO_ID, incrementAndGet);
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logDelegate;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "createAudioContext error:", th5);
            }
        }
        return jSONObject;
    }

    public JSONObject createBuffer(int i3, int i16, int i17, int i18) {
        if (this.audioContextHashMap.get(Integer.valueOf(i3)) == null) {
            return null;
        }
        int createBuffer = AudioNativeManager.createBuffer(i16, i17 * i16 * 2, i18);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bufferId", createBuffer);
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logDelegate;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "createBuffer error:", th5);
            }
        }
        return jSONObject;
    }

    public JSONObject createBufferSource(int i3) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext == null) {
            return null;
        }
        int createBufferSource = audioContext.createBufferSource();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelId", createBufferSource);
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logDelegate;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "createBufferSource error:", th5);
            }
        }
        return jSONObject;
    }

    public void createScriptProcessor(int i3, int i16, int i17, int i18) {
        int i19 = i16 * i18;
        AudioNativeManager.createScriptProcessorNode(i19, i17, i18);
        this.scriptProcessNodeSizeMap.put(Integer.valueOf(i3), Integer.valueOf(i19));
    }

    public void decodeAudioDataAndReturnBufferIdAsync(final int i3, final byte[] bArr, final Argument argument) {
        TritonAudioThreadPool.getAudioThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.5
            @Override // java.lang.Runnable
            public void run() {
                final AudioDecoder audioDecoder = new AudioDecoder();
                audioDecoder.setOnDecodeProcessListener(new AudioDecoder.OnDecodeProcessListener() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.5.1
                    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d4, code lost:
                    
                        r5 = new org.json.JSONObject();
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d9, code lost:
                    
                        r5.put("decodeId", r2);
                        r5.put("status", com.tencent.mobileqq.app.face.FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        r3.callback(r5.toString());
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:25:0x00f8, code lost:
                    
                        r5 = move-exception;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:27:0x0101, code lost:
                    
                        if (r4.this$1.this$0.logDelegate != null) goto L35;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:28:0x0103, code lost:
                    
                        r4.this$1.this$0.logDelegate.printLog(com.tencent.mobileqq.triton.utils.LogDelegate.Level.ERROR, com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.TAG, "onDecodeProcess isfirst jsonexception:", r5);
                     */
                    @Override // com.tencent.mobileqq.tritonaudio.webaudio.AudioDecoder.OnDecodeProcessListener
                    @RequiresApi(api = 16)
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onDecodeProcess(byte[] bArr2, MediaFormat mediaFormat, boolean z16, boolean z17) {
                        ArrayList arrayList;
                        synchronized (WebAudioManager.class) {
                            if (!WebAudioManager.this.decodeBufferIdStatusMap.containsKey(Integer.valueOf(i3))) {
                                WebAudioManager.this.decodeBufferIdStatusMap.put(Integer.valueOf(i3), new DecodeAsPlayStatus());
                            }
                            DecodeAsPlayStatus decodeAsPlayStatus = (DecodeAsPlayStatus) WebAudioManager.this.decodeBufferIdStatusMap.get(Integer.valueOf(i3));
                            ArrayList arrayList2 = (ArrayList) WebAudioManager.this.decodeBufferIdArrayMap.get(Integer.valueOf(i3));
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            if (z17) {
                                decodeAsPlayStatus.status = 3;
                                return;
                            }
                            int loadRawData = AudioNativeManager.loadRawData(bArr2, audioDecoder.getSampleRate(), audioDecoder.getChannelCount(), audioDecoder.getBitsPerChannel());
                            arrayList2.add(Integer.valueOf(loadRawData));
                            WebAudioManager.this.decodeBufferIdArrayMap.put(Integer.valueOf(i3), arrayList2);
                            int i16 = decodeAsPlayStatus.status;
                            if (i16 == 0) {
                                decodeAsPlayStatus.status = 1;
                            } else if (i16 == 2 && (arrayList = decodeAsPlayStatus.channelIdList) != null && !arrayList.isEmpty()) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    AudioNativeManager.setQueueBuffer(((Integer) it.next()).intValue(), loadRawData);
                                }
                            }
                        }
                    }
                });
                audioDecoder.decodeInMemory(bArr, i3);
            }
        });
    }

    public boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public AudioContext getAudioContext(int i3) {
        return this.audioContextHashMap.get(Integer.valueOf(i3));
    }

    public byte[] getBufferChannelData(int i3, int i16) {
        return AudioNativeManager.getBufferChannelData(i3, i16);
    }

    public float getCurrentGain(int i3, int i16) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext == null) {
            return -1.0f;
        }
        return audioContext.getCurrentGain(i16);
    }

    public void resumeAudioContext() {
        if (this.audioContextHashMap.isEmpty()) {
            return;
        }
        AudioNativeManager.resumeAudioContext();
    }

    public void setBufferSourceLoop(int i3, int i16, boolean z16) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext == null) {
            return;
        }
        audioContext.setBufferSourceLoop(i16, z16);
    }

    public void setCurrentGain(int i3, int i16, double d16) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext == null) {
            return;
        }
        audioContext.setCurrentGain(i16, d16);
    }

    public JSONObject setDecodingQueueBuffer(int i3, int i16) {
        DecodeAsPlayStatus decodeAsPlayStatus;
        HashMap<Integer, ArrayList<Integer>> hashMap;
        ArrayList<Integer> arrayList;
        synchronized (WebAudioManager.class) {
            HashMap<Integer, DecodeAsPlayStatus> hashMap2 = this.decodeBufferIdStatusMap;
            if (hashMap2 != null && hashMap2.containsKey(Integer.valueOf(i16)) && (decodeAsPlayStatus = this.decodeBufferIdStatusMap.get(Integer.valueOf(i16))) != null && (hashMap = this.decodeBufferIdArrayMap) != null && hashMap.containsKey(Integer.valueOf(i16)) && (arrayList = this.decodeBufferIdArrayMap.get(Integer.valueOf(i16))) != null && !arrayList.isEmpty()) {
                int i17 = decodeAsPlayStatus.status;
                if (i17 != 1 && i17 != 2) {
                    if (i17 == 3) {
                        Iterator<Integer> it = arrayList.iterator();
                        while (it.hasNext()) {
                            AudioNativeManager.setQueueBuffer(i3, it.next().intValue());
                        }
                    }
                } else {
                    Iterator<Integer> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        AudioNativeManager.setQueueBuffer(i3, it5.next().intValue());
                    }
                    decodeAsPlayStatus.status = 2;
                    decodeAsPlayStatus.channelIdList.add(Integer.valueOf(i3));
                }
            }
        }
        return new JSONObject();
    }

    public void setQueueBuffer(int i3, int i16) {
        AudioNativeManager.setQueueBuffer(i3, i16);
        if (!this.scriptNodeHasStarted) {
            AudioNativeManager.play(-2, 0.0f);
        }
        this.scriptNodeHasStarted = true;
    }

    public JSONObject setSourceBuffer(int i3, int i16) {
        AudioNativeManager.bindBufferToSource(i16, i3);
        return new JSONObject();
    }

    public JSONObject sourceStart(final Argument argument, final int i3, final int i16, int i17, final int i18, int i19) {
        long j3;
        long j16;
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext == null) {
            return null;
        }
        long currentTime = audioContext.getCurrentTime();
        long j17 = i17 * 1000;
        long j18 = j17 - currentTime;
        if (j18 > 0) {
            j3 = j17;
            TritonAudioThreadPool.getAudioThreadPool().schedule(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.1
                @Override // java.lang.Runnable
                public void run() {
                    AudioNativeManager.play(i16, i18);
                    WebAudioManager.this.startTimer(argument, i16, i3);
                }
            }, j18, TimeUnit.MILLISECONDS);
        } else {
            j3 = j17;
            AudioNativeManager.play(i16, i18);
            startTimer(argument, i16, i3);
        }
        if (j18 > 0) {
            j16 = j3;
        } else {
            j16 = currentTime;
        }
        if (i19 > 0) {
            TritonAudioThreadPool.getAudioThreadPool().schedule(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioNativeManager.stopSource(i16);
                }
            }, (j16 - currentTime) + (i19 * 1000), TimeUnit.MILLISECONDS);
        }
        return new JSONObject();
    }

    public JSONObject sourceStop(int i3, final int i16, int i17) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext == null) {
            return null;
        }
        long currentTime = (i17 * 1000) - audioContext.getCurrentTime();
        if (currentTime > 0) {
            TritonAudioThreadPool.getAudioThreadPool().schedule(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.4
                @Override // java.lang.Runnable
                public void run() {
                    AudioNativeManager.stopSource(i16);
                }
            }, currentTime, TimeUnit.MILLISECONDS);
        } else {
            AudioNativeManager.stopSource(i16);
        }
        return new JSONObject();
    }

    public void startAudioProcess(final Argument argument, int i3) {
        final int intValue = ((this.scriptProcessNodeSizeMap.get(Integer.valueOf(i3)).intValue() * 2) * 60) / 44100;
        TritonAudioThreadPool.getAudioThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.6
            @Override // java.lang.Runnable
            public void run() {
                int onAudioProcess = AudioNativeManager.onAudioProcess(-2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("bufferId", onAudioProcess);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                Argument argument2 = argument;
                if (argument2 != null) {
                    argument2.subscribe(WebAudioPlugin.API_ON_WEB_AUDIO_SCRIPT_PROCESSOR, jSONObject.toString());
                }
                TritonAudioThreadPool.getAudioThreadPool().schedule(this, intValue, TimeUnit.MILLISECONDS);
            }
        });
    }

    public void suspendAudioContext() {
        if (this.audioContextHashMap.isEmpty()) {
            return;
        }
        AudioNativeManager.suspendAudioContext();
    }

    public boolean writeFile(byte[] bArr, String str, boolean z16, int i3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z16);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr, 0, i3);
                fileOutputStream.flush();
                fileOutputStream.close();
                z17 = true;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z17;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }

    public void resumeAudioContext(int i3) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext != null) {
            audioContext.resume();
        }
    }

    public void suspendAudioContext(int i3) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext != null) {
            audioContext.suspend();
        }
    }

    public void closeAudioContext(int i3) {
        AudioContext audioContext = this.audioContextHashMap.get(Integer.valueOf(i3));
        if (audioContext != null) {
            audioContext.close();
        }
        this.audioContextHashMap.remove(Integer.valueOf(i3));
    }
}

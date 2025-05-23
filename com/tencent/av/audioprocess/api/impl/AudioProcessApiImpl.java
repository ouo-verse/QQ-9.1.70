package com.tencent.av.audioprocess.api.impl;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import au.b;
import au.c;
import au.d;
import au.e;
import au.f;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.ui.funchat.record.i;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.log.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.jvm.internal.ShortCompanionObject;

/* loaded from: classes32.dex */
public class AudioProcessApiImpl implements IAudioProcessApi, i {
    private static final int MAX_QUEUE_SIZE = 25;
    private static final int MAX_RECOG_DATA_LEN = 9600000;
    private static final int SUB_PERIOD_CNT = 5;
    private static final int SUB_PERIOD_TIME_LEN_MS = 2000;
    public static final String TAG = "AudioProcessApiImpl";
    private b mOnRecog;
    private c mOnRecord;
    private boolean mIsInited = false;
    private int mPlayState = 0;
    private int mPlayMixSrcType = 1;
    private int mRecordState = 0;
    private int mRecordMixSrcType = 5;
    private int mRecogState = 0;
    private String mRecogTxt = "";
    private long mRecogTimeStart = 0;
    List<e> mFileInfoList = new ArrayList();
    Queue<byte[]> mPCMDataQueueFromOutside = new LinkedList();
    private byte[] mPCMDataFromOutside = null;
    private int mPCMDataLenFromOutside = 0;
    private int mRecogDataLen = 0;
    private byte[] mRecogData = null;
    private final Object mLock = new Object();
    private final Object mLockPCMDataFromOutside = new Object();
    private final Object mLockRecog = new Object();
    private IAVEngineCommon mEngineCommon = null;
    private f mSetAudioFrameCallback = null;
    private long mSubPeriodStartTimestampMs = 0;
    private int mSubPeriodIdx = 0;
    private int[] mInputCntList = new int[5];
    private int[] mOutputCntList = new int[5];
    private int mLastMixResult = -1;

    private int getAudioDataSourceType(int i3) {
        boolean z16;
        if ((i3 & 8) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 1;
        }
        return 3;
    }

    private static List<byte[]> getPCMDataFromMP3File(List<e> list, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (list.get(i16).f26946d == 1 && list.get(i16).f26952j != null && list.get(i16).f26943a != null) {
                byte[] bArr = new byte[i3];
                int decodeMP3Frame = decodeMP3Frame(bArr, list.get(i16));
                if (decodeMP3Frame == 0) {
                    scaleVolume(bArr, list.get(i16).f26948f);
                    arrayList.add(bArr);
                } else if (decodeMP3Frame == 1 || decodeMP3Frame == 2) {
                    a.b(TAG, "getPCMDataFromMP3File failed. ret = " + decodeMP3Frame);
                    if (list.get(i16).f26943a != null) {
                        try {
                            list.get(i16).f26943a.stop();
                            list.get(i16).f26943a.release();
                        } catch (IllegalStateException e16) {
                            a.h(TAG, "mp3Decoder stop failed.", e16);
                        }
                        list.get(i16).f26943a = null;
                    }
                    if (list.get(i16).f26952j != null) {
                        list.get(i16).f26952j.release();
                        list.get(i16).f26952j = null;
                    }
                    if (decodeMP3Frame != 1 && list.get(i16).f26947e > 1) {
                        if (list.get(i16).f26947e > 1) {
                            list.get(i16).f26947e--;
                            MediaExtractor mediaExtractor = new MediaExtractor();
                            d startDecodeMP3 = startDecodeMP3(mediaExtractor, list.get(i16).f26945c);
                            if (startDecodeMP3 != null && startDecodeMP3.f26943a != null) {
                                list.get(i16).f26952j = mediaExtractor;
                                list.get(i16).f26943a = startDecodeMP3.f26943a;
                            } else {
                                a.b(TAG, "getPCMDataFromMP3File failed. startDecodeMP3 failed.");
                                list.remove(i16);
                            }
                        }
                    } else {
                        list.remove(i16);
                    }
                }
            }
        }
        return arrayList;
    }

    private static List<byte[]> getPCMDataFromPCMFile(List<e> list, int i3) {
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        while (i16 < list.size()) {
            if (list.get(i16).f26946d == 0) {
                if (list.get(i16).f26949g + i3 > list.get(i16).f26951i && list.get(i16).f26947e <= 1) {
                    a.b(TAG, "getPCMDataFromPCMFile failed. FileInfo. i = " + i16 + ", mixCnt = " + list.get(i16).f26947e);
                    if (list.get(i16).f26950h != null) {
                        try {
                            try {
                                list.get(i16).f26950h.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        } finally {
                        }
                    }
                } else {
                    byte[] bArr = new byte[i3];
                    Arrays.fill(bArr, (byte) 0);
                    if (list.get(i16).f26949g + i3 > list.get(i16).f26951i) {
                        list.get(i16).f26947e--;
                        if (list.get(i16).f26947e <= 0 && list.get(i16).f26950h != null) {
                            try {
                                try {
                                    list.get(i16).f26950h.close();
                                } finally {
                                }
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                            list.remove(i16);
                        } else {
                            list.get(i16).f26949g = 0;
                            try {
                                list.get(i16).f26950h.seek(0L);
                            } catch (IOException unused) {
                                a.b(TAG, "getPCMDataFromPCMFile failed. file.seek failed. i = " + i16);
                            }
                        }
                    }
                    if (!readFile(bArr, list.get(i16).f26949g, list.get(i16).f26950h)) {
                        try {
                            try {
                                list.get(i16).f26950h.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                            list.remove(i16);
                        } finally {
                        }
                    } else {
                        scaleVolume(bArr, list.get(i16).f26948f);
                        arrayList.add(bArr);
                        list.get(i16).f26949g += i3;
                    }
                }
            }
            i16++;
        }
        return arrayList;
    }

    private void inputStat(byte[] bArr, int i3) {
        int[] iArr = this.mInputCntList;
        int i16 = this.mSubPeriodIdx;
        iArr[i16] = iArr[i16] + 1;
    }

    private static List<byte[]> mergePCMDataList(List<byte[]> list, List<byte[]> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                arrayList.add(list.get(i3));
            }
        }
        if (list2 != null) {
            for (int i16 = 0; i16 < list2.size(); i16++) {
                arrayList.add(list2.get(i16));
            }
        }
        return arrayList;
    }

    private static RandomAccessFile openFile(String str) {
        try {
            return new RandomAccessFile(str, "r");
        } catch (IOException e16) {
            a.c(TAG, "openFile failed. pcmFilename = " + str, e16);
            return null;
        }
    }

    private void outputStat(byte[] bArr, int i3, int i16) {
        if (this.mLastMixResult != i16) {
            a.d(TAG, "audioStreamStat. mix ret: " + this.mLastMixResult + "->" + i16);
        }
        this.mLastMixResult = i16;
        if (i16 <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mSubPeriodStartTimestampMs == 0) {
            this.mSubPeriodStartTimestampMs = currentTimeMillis;
        }
        int[] iArr = this.mOutputCntList;
        int i17 = this.mSubPeriodIdx;
        iArr[i17] = iArr[i17] + 1;
        if (currentTimeMillis - this.mSubPeriodStartTimestampMs >= 2000) {
            if (i17 == 4) {
                a.d(TAG, "audioStreamStat. input cnt[" + this.mInputCntList[0] + "," + this.mInputCntList[1] + "," + this.mInputCntList[2] + "," + this.mInputCntList[3] + "," + this.mInputCntList[4] + "], output cnt[" + this.mOutputCntList[0] + "," + this.mOutputCntList[1] + "," + this.mOutputCntList[2] + "," + this.mOutputCntList[3] + "," + this.mOutputCntList[4] + "]");
                Arrays.fill(this.mInputCntList, 0);
                Arrays.fill(this.mOutputCntList, 0);
                this.mSubPeriodIdx = 0;
            } else {
                this.mSubPeriodIdx = i17 + 1;
            }
            this.mSubPeriodStartTimestampMs = currentTimeMillis;
        }
    }

    private static boolean readFile(byte[] bArr, int i3, RandomAccessFile randomAccessFile) {
        try {
            randomAccessFile.seek(i3);
            int read = randomAccessFile.read(bArr);
            boolean z16 = bArr.length == read;
            if (!z16) {
                a.b(TAG, "readFile failed. readLen = " + read + ", data.length = " + bArr.length);
            }
            return z16;
        } catch (IOException e16) {
            a.c(TAG, "readFile failed. ", e16);
            return false;
        }
    }

    private static void saveData(byte[] bArr, int i3, boolean z16, String str) {
        Calendar calendar = Calendar.getInstance();
        int i16 = calendar.get(1);
        int i17 = calendar.get(2) + 1;
        int i18 = calendar.get(5);
        int i19 = calendar.get(11);
        String b16 = com.tencent.av.b.b();
        Object[] objArr = new Object[7];
        objArr[0] = z16 ? "\u8bc6\u522b\u6210\u529f" : "\u8bc6\u522b\u5931\u8d25";
        objArr[1] = str;
        objArr[2] = Long.valueOf(System.currentTimeMillis());
        objArr[3] = Integer.valueOf(i16 % 100);
        objArr[4] = Integer.valueOf(i17);
        objArr[5] = Integer.valueOf(i18);
        objArr[6] = Integer.valueOf(i19);
        saveData(b16, String.format("com.tencent.mobileqq_AVGameVoiceRecogData_16000_1_%s_%s_%d_%02d.%02d.%02d.%02d.log", objArr), bArr, i3);
    }

    private void setAudioFrameCallback(int i3, i iVar) {
        f fVar = this.mSetAudioFrameCallback;
        if (fVar != null) {
            fVar.f(i3, iVar);
        } else {
            a.b(TAG, "setAudioFrameCallback failed. mSetAudioFrameCallback == null.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        r8 = r6.getInteger("sample-rate");
        r9 = r6.getInteger("channel-count");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        if (r9 <= 2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        com.tencent.qav.log.a.b(com.tencent.av.audioprocess.api.impl.AudioProcessApiImpl.TAG, "startDecodeMP3 failed. channelNum > 2.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        r3.f26944b = r9;
        r11.selectTrack(r5);
        r11 = android.media.MediaCodec.createDecoderByType(r7);
        r3.f26943a = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        r11.configure(r6, (android.view.Surface) null, (android.media.MediaCrypto) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        r11 = 16;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0077, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
    
        com.tencent.qav.log.a.c(com.tencent.av.audioprocess.api.impl.AudioProcessApiImpl.TAG, "startDecodeMP3 failed. configure exception: ", r11);
        r3.f26943a.release();
        r3.f26943a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static d startDecodeMP3(MediaExtractor mediaExtractor, String str) {
        int i3;
        int i16;
        File file = new File(str);
        a.d(TAG, "startDecodeMP3. mp3FilePath = " + str);
        if (mediaExtractor != null && file.exists()) {
            d dVar = new d();
            try {
                mediaExtractor.setDataSource(str);
                int i17 = 0;
                int i18 = 0;
                while (true) {
                    if (i18 >= mediaExtractor.getTrackCount()) {
                        i3 = 0;
                        i16 = 0;
                        break;
                    }
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i18);
                    String string = trackFormat.getString("mime");
                    if (string.startsWith("audio")) {
                        break;
                    }
                    i18++;
                }
                MediaCodec mediaCodec = dVar.f26943a;
                if (mediaCodec == null) {
                    a.b(TAG, "startDecodeMP3 failed. mAudioCodec == null.");
                    return null;
                }
                try {
                    mediaCodec.start();
                    a.d(TAG, "startDecodeMP3 successfully. mp3FilePath = " + str + ", fileSize = " + file.length() + ", sampleRate = " + i17 + ", channelNum = " + i16 + ", sampleSize = " + i3);
                    return dVar;
                } catch (Exception e16) {
                    a.c(TAG, "startDecodeMP3 failed. AudioCodec.start failed.", e16);
                    dVar.f26943a.release();
                    dVar.f26943a = null;
                    return null;
                }
            } catch (IOException e17) {
                a.c(TAG, "startDecodeMP3 failed. exception: ", e17);
                MediaCodec mediaCodec2 = dVar.f26943a;
                if (mediaCodec2 != null) {
                    mediaCodec2.release();
                    dVar.f26943a = null;
                }
                return null;
            }
        }
        a.b(TAG, "startDecodeMP3 failed. !mp3File.exists().");
        return null;
    }

    private void uninitStat() {
        if (this.mInputCntList[0] > 0) {
            a.d(TAG, "uninitStat. audioStreamStat. input cnt[" + this.mInputCntList[0] + "," + this.mInputCntList[1] + "," + this.mInputCntList[2] + "," + this.mInputCntList[3] + "," + this.mInputCntList[4] + "], output cnt[" + this.mOutputCntList[0] + "," + this.mOutputCntList[1] + "," + this.mOutputCntList[2] + "," + this.mOutputCntList[3] + "," + this.mOutputCntList[4] + "]");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x004c, code lost:
    
        if (r6 > 10.0f) goto L23;
     */
    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addFile(String str, int i3, float f16, int i16) {
        MediaCodec mediaCodec;
        if (this.mIsInited && this.mEngineCommon != null && !TextUtils.isEmpty(str) && i16 > 0) {
            synchronized (this.mLock) {
                for (int i17 = 0; i17 < this.mFileInfoList.size(); i17++) {
                    if (this.mFileInfoList.get(i17).f26945c.equalsIgnoreCase(str)) {
                        return;
                    }
                }
                e eVar = new e();
                eVar.f26945c = str;
                eVar.f26946d = i3;
                eVar.f26947e = i16;
                float f17 = f16 >= 0.1f ? 10.0f : 0.1f;
                f16 = f17;
                eVar.f26948f = f16;
                if (i3 == 0) {
                    RandomAccessFile openFile = openFile(str);
                    if (openFile != null) {
                        eVar.f26950h = openFile;
                        try {
                            eVar.f26951i = openFile.length();
                        } catch (IOException e16) {
                            a.c(TAG, "addFile failed. get pcm file length failed.", e16);
                            try {
                                openFile.close();
                                return;
                            } catch (IOException e17) {
                                e17.printStackTrace();
                                return;
                            }
                        }
                    } else {
                        a.b(TAG, "addFile failed. open pcm file failed.");
                        return;
                    }
                } else if (i3 == 1) {
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    d startDecodeMP3 = startDecodeMP3(mediaExtractor, str);
                    if (startDecodeMP3 != null && (mediaCodec = startDecodeMP3.f26943a) != null) {
                        eVar.f26952j = mediaExtractor;
                        eVar.f26943a = mediaCodec;
                        eVar.f26944b = startDecodeMP3.f26944b;
                        eVar.f26953k = new MediaCodec.BufferInfo();
                    } else {
                        mediaExtractor.release();
                        a.b(TAG, "addFile failed. startDecodeMP3 failed.");
                        return;
                    }
                } else {
                    a.b(TAG, "addFile failed. fileType = " + i3);
                    return;
                }
                synchronized (this.mLock) {
                    this.mFileInfoList.add(eVar);
                }
                a.d(TAG, "addFile successfully. fileinfo = " + eVar);
                return;
            }
        }
        a.b(TAG, "addFile failed. !mIsInited || mEngineCommon == null || mixCnt <= 0.");
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void addPCMData(byte[] bArr, int i3) {
        if (this.mIsInited && this.mEngineCommon != null && bArr != null && bArr.length >= i3) {
            inputStat(bArr, i3);
            synchronized (this.mLockPCMDataFromOutside) {
                int i16 = this.mPCMDataLenFromOutside;
                if (i16 > 0) {
                    byte[] bArr2 = new byte[i16 + i3];
                    System.arraycopy(this.mPCMDataFromOutside, 0, bArr2, 0, i16);
                    System.arraycopy(bArr, 0, bArr2, this.mPCMDataLenFromOutside, i3);
                    this.mPCMDataLenFromOutside = 0;
                    bArr = bArr2;
                }
                int length = bArr.length / 1920;
                if (length > 0) {
                    int size = (this.mPCMDataQueueFromOutside.size() + length) - 25;
                    for (int i17 = 0; i17 < size; i17++) {
                        this.mPCMDataQueueFromOutside.poll();
                    }
                    for (int i18 = 0; i18 < length; i18++) {
                        byte[] bArr3 = new byte[1920];
                        System.arraycopy(bArr, i18 * 1920, bArr3, 0, 1920);
                        this.mPCMDataQueueFromOutside.offer(bArr3);
                    }
                    int length2 = bArr.length % 1920;
                    if (length2 > 0) {
                        if (this.mPCMDataFromOutside == null) {
                            this.mPCMDataFromOutside = new byte[1920];
                        }
                        System.arraycopy(bArr, bArr.length - length2, this.mPCMDataFromOutside, 0, length2);
                        this.mPCMDataLenFromOutside = length2;
                    }
                } else {
                    if (this.mPCMDataFromOutside == null) {
                        this.mPCMDataFromOutside = new byte[1920];
                    }
                    int length3 = bArr.length;
                    System.arraycopy(bArr, 0, this.mPCMDataFromOutside, 0, length3);
                    this.mPCMDataLenFromOutside = length3;
                }
            }
            return;
        }
        a.b(TAG, "addPCMData failed. !mIsInited || mEngineCommon == null || pcmData == null.");
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public boolean init(IAVEngineCommon iAVEngineCommon, f fVar) {
        if (this.mIsInited) {
            return true;
        }
        if (iAVEngineCommon != null && fVar != null) {
            this.mEngineCommon = iAVEngineCommon;
            this.mSetAudioFrameCallback = fVar;
            this.mIsInited = true;
            initStat();
            a.d(TAG, "init successfully.");
            return true;
        }
        this.mIsInited = false;
        a.c(TAG, "init failed. engineCommon = " + iAVEngineCommon + " setAudioFrameCallback = " + fVar, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        return false;
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public boolean isPlayStarted() {
        return this.mPlayState != 0;
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public boolean isRecogStarted() {
        return this.mRecogState != 0;
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public boolean isRecordStarted() {
        return this.mRecordState != 0;
    }

    public void mix(byte[] bArr, int i3, int i16) {
        if (i3 != 3 && i3 != 1) {
            if (i3 != 100 && i3 == 8) {
                synchronized (this.mLockRecog) {
                    if (isRecogStarted() && !TextUtils.isEmpty(this.mRecogTxt) && this.mRecogTimeStart == 0 && isSpeaking3(bArr)) {
                        this.mRecogTimeStart = System.currentTimeMillis();
                        a.a(TAG, "reset RecogTimeStart");
                    }
                }
                return;
            }
            return;
        }
        if (this.mPlayState != 1 || (this.mPlayMixSrcType & 2) <= 0) {
            return;
        }
        if (this.mFileInfoList.size() > 0 || this.mPCMDataQueueFromOutside.size() > 0) {
            List<byte[]> mergePCMDataList = mergePCMDataList(getPCMDataFromPCMFile(this.mFileInfoList, i16), getPCMDataFromMP3File(this.mFileInfoList, i16));
            if (this.mPCMDataQueueFromOutside.size() > 0) {
                synchronized (this.mLockPCMDataFromOutside) {
                    if (this.mPCMDataQueueFromOutside.size() > 0) {
                        mergePCMDataList.add(this.mPCMDataQueueFromOutside.poll());
                    }
                }
            }
            boolean mix = mix(bArr, mergePCMDataList);
            if (i3 == 1) {
                outputStat(bArr, i16, mix ? 1 : 0);
            }
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi, com.tencent.av.ui.funchat.record.i
    public void onReceiveAudioFrame(byte[] bArr, int i3, int i16) {
        if (this.mIsInited) {
            if (i16 % 2 != 0) {
                a.b(TAG, "onReceiveAudioFrame. size = " + i16);
                i16 += -1;
            }
            synchronized (this.mLock) {
                long currentTimeMillis = System.currentTimeMillis();
                mix(bArr, i3, i16);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 50) {
                    a.g(TAG, "onReceiveAudioFrame. mix. srcType = " + i3 + ", big timelen = " + currentTimeMillis2);
                }
            }
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void pausePlay() {
        if (isPlayStarted()) {
            this.mPlayState = 2;
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void pauseRecord() {
        if (isRecordStarted()) {
            this.mRecordState = 2;
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void removeAllFiles() {
        e eVar;
        synchronized (this.mLock) {
            for (int i3 = 0; i3 < this.mFileInfoList.size(); i3++) {
                if (this.mFileInfoList.get(i3).f26950h != null) {
                    try {
                        try {
                            this.mFileInfoList.get(i3).f26950h.close();
                            eVar = this.mFileInfoList.get(i3);
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            eVar = this.mFileInfoList.get(i3);
                        }
                        eVar.f26950h = null;
                    } catch (Throwable th5) {
                        this.mFileInfoList.get(i3).f26950h = null;
                        throw th5;
                    }
                } else {
                    if (this.mFileInfoList.get(i3).f26952j != null || this.mFileInfoList.get(i3).f26943a != null) {
                        if (this.mFileInfoList.get(i3).f26943a != null) {
                            try {
                                this.mFileInfoList.get(i3).f26943a.stop();
                                this.mFileInfoList.get(i3).f26943a.release();
                            } catch (IllegalStateException e17) {
                                a.h(TAG, "mp3Decoder stop failed.", e17);
                            }
                            this.mFileInfoList.get(i3).f26943a = null;
                        }
                        if (this.mFileInfoList.get(i3).f26952j != null) {
                            this.mFileInfoList.get(i3).f26952j.release();
                            this.mFileInfoList.get(i3).f26952j = null;
                        }
                    }
                }
            }
            this.mFileInfoList.clear();
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void removeFile(String str) {
        List<e> list;
        synchronized (this.mLock) {
            int i3 = 0;
            while (i3 < this.mFileInfoList.size()) {
                if (this.mFileInfoList.get(i3).f26945c.equalsIgnoreCase(str)) {
                    try {
                        if (this.mFileInfoList.get(i3).f26950h != null) {
                            try {
                                this.mFileInfoList.get(i3).f26950h.close();
                                list = this.mFileInfoList;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                list = this.mFileInfoList;
                            }
                            list.remove(i3);
                            return;
                        }
                        if (this.mFileInfoList.get(i3).f26952j == null && this.mFileInfoList.get(i3).f26943a == null) {
                            return;
                        }
                        if (this.mFileInfoList.get(i3).f26943a != null) {
                            try {
                                this.mFileInfoList.get(i3).f26943a.stop();
                                this.mFileInfoList.get(i3).f26943a.release();
                            } catch (IllegalStateException e17) {
                                a.h(TAG, "mp3Decoder stop failed.", e17);
                            }
                            this.mFileInfoList.get(i3).f26943a = null;
                        }
                        if (this.mFileInfoList.get(i3).f26952j != null) {
                            this.mFileInfoList.get(i3).f26952j.release();
                            this.mFileInfoList.get(i3).f26952j = null;
                        }
                        return;
                    } finally {
                        this.mFileInfoList.remove(i3);
                    }
                }
                i3++;
            }
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void resumePlay() {
        if (isPlayStarted()) {
            this.mPlayState = 1;
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void resumeRecord() {
        if (isRecordStarted()) {
            this.mRecordState = 1;
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void scaleVolumeValue(byte[] bArr, float f16) {
        scaleVolume(bArr, f16);
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public boolean startPlay(int i3) {
        if (this.mIsInited && this.mEngineCommon != null) {
            if (isPlayStarted()) {
                return true;
            }
            if (i3 <= 0) {
                a.b(TAG, "startPlay failed. mixSrcType = " + i3);
                return false;
            }
            int audioDataSourceType = getAudioDataSourceType(i3);
            int registerAudioDataCallback = this.mEngineCommon.registerAudioDataCallback(audioDataSourceType, true);
            if (registerAudioDataCallback != 0) {
                a.b(TAG, "startPlay failed. registerAudioDataCallback failed. ret = " + registerAudioDataCallback);
                return false;
            }
            int audioDataFormat = this.mEngineCommon.setAudioDataFormat(audioDataSourceType, 48000, 1, 16);
            if (audioDataFormat != 0) {
                a.b(TAG, "startPlay failed. setAudioDataFormat failed. ret = " + audioDataFormat);
                return false;
            }
            setAudioFrameCallback(1, this);
            this.mPlayMixSrcType = i3;
            this.mPlayState = 1;
            a.d(TAG, "startPlay successfully. mixSrcType = " + i3 + ", ret = " + audioDataFormat);
            return true;
        }
        a.b(TAG, "startPlay failed. !mIsInited || mEngineCommon == null.");
        return false;
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public boolean startRecog(b bVar) {
        if (this.mIsInited && this.mEngineCommon != null) {
            if (isRecogStarted()) {
                return true;
            }
            a.b(TAG, "startRecog failed. !ret.");
            return false;
        }
        a.b(TAG, "startRecog failed. !mIsInited || mEngineCommon == null.");
        return false;
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public boolean startRecord(int i3, c cVar) {
        int i16;
        if (this.mIsInited && this.mEngineCommon != null) {
            if (com.tencent.av.utils.d.d()) {
                QQToast.makeText(BaseApplicationImpl.getApplication(), R.string.f170529za2, 1).show();
                return false;
            }
            if (isRecordStarted()) {
                return true;
            }
            if (i3 > 0 && ((i16 = i3 & 4) != 0 || (i3 & 1) != 0)) {
                if (i16 > 0) {
                    int registerAudioDataCallback = this.mEngineCommon.registerAudioDataCallback(0, true);
                    int audioDataFormat = this.mEngineCommon.setAudioDataFormat(0, 48000, 1, 16);
                    if (registerAudioDataCallback != 0 || audioDataFormat != 0) {
                        a.b(TAG, "startRecord failed. MIX_SRC_TYPE_MIC. ret1 = " + registerAudioDataCallback + ", ret2 = " + audioDataFormat);
                        return false;
                    }
                }
                if ((i3 & 1) > 0) {
                    int registerAudioDataCallback2 = this.mEngineCommon.registerAudioDataCallback(4, true);
                    int audioDataFormat2 = this.mEngineCommon.setAudioDataFormat(4, 48000, 1, 16);
                    if (registerAudioDataCallback2 != 0 || audioDataFormat2 != 0) {
                        a.b(TAG, "startRecord failed. MIX_SRC_TYPE_RECV. ret1 = " + registerAudioDataCallback2 + ", ret2 = " + audioDataFormat2);
                        return false;
                    }
                }
                setAudioFrameCallback(0, this);
                this.mRecordMixSrcType = i3;
                this.mRecordState = 1;
                a.d(TAG, "startRecord successfully. mixSrcType = " + i3);
                return true;
            }
            a.b(TAG, "startRecord failed. mixSrcType = " + i3);
            return false;
        }
        a.b(TAG, "startRecord failed. !mIsInited || mEngineCommon == null.");
        return false;
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void stopPlay() {
        if (this.mIsInited && this.mEngineCommon != null && isPlayStarted()) {
            try {
                setAudioFrameCallback(1, null);
                int unregisterAudioDataCallback = this.mEngineCommon.unregisterAudioDataCallback(getAudioDataSourceType(this.mPlayMixSrcType));
                this.mPlayState = 0;
                a.d(TAG, "stopPlay successfully. ret = " + unregisterAudioDataCallback);
            } catch (Exception e16) {
                a.c(TAG, "stopPlay failed. ", e16);
            }
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void stopRecog() {
        if (this.mIsInited && this.mEngineCommon != null && isRecogStarted()) {
            try {
                setAudioFrameCallback(1, null);
                this.mEngineCommon.unregisterAudioDataCallback(8);
                this.mEngineCommon.enableLocalSpeechRecognizeModel(false);
                this.mRecogState = 0;
                a.d(TAG, "stopRecog sucessfully.");
            } catch (Exception e16) {
                a.c(TAG, "stopRecog failed.", e16);
            }
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void stopRecord() {
        if (this.mIsInited && this.mEngineCommon != null && isRecordStarted()) {
            try {
                setAudioFrameCallback(0, null);
                this.mRecordState = 0;
                a.d(TAG, "stopRecord sucessfully.");
            } catch (Exception e16) {
                a.c(TAG, "stopRecord failed.", e16);
            }
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void unInit() {
        e eVar;
        if (this.mIsInited) {
            uninitStat();
            stopPlay();
            stopRecord();
            stopRecog();
            this.mEngineCommon = null;
            synchronized (this.mLock) {
                for (int i3 = 0; i3 < this.mFileInfoList.size(); i3++) {
                    if (this.mFileInfoList.get(i3).f26950h != null) {
                        try {
                            try {
                                this.mFileInfoList.get(i3).f26950h.close();
                                eVar = this.mFileInfoList.get(i3);
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                eVar = this.mFileInfoList.get(i3);
                            }
                            eVar.f26950h = null;
                        } catch (Throwable th5) {
                            this.mFileInfoList.get(i3).f26950h = null;
                            throw th5;
                        }
                    } else {
                        if (this.mFileInfoList.get(i3).f26952j != null || this.mFileInfoList.get(i3).f26943a != null) {
                            if (this.mFileInfoList.get(i3).f26943a != null) {
                                try {
                                    this.mFileInfoList.get(i3).f26943a.stop();
                                    this.mFileInfoList.get(i3).f26943a.release();
                                } catch (IllegalStateException e17) {
                                    a.h(TAG, "mp3Decoder stop failed.", e17);
                                }
                                this.mFileInfoList.get(i3).f26943a = null;
                            }
                            if (this.mFileInfoList.get(i3).f26952j != null) {
                                this.mFileInfoList.get(i3).f26952j.release();
                                this.mFileInfoList.get(i3).f26952j = null;
                            }
                        }
                    }
                }
                this.mFileInfoList.clear();
            }
            synchronized (this.mLockPCMDataFromOutside) {
                this.mPCMDataQueueFromOutside.clear();
            }
            this.mIsInited = false;
            a.d(TAG, "uninit successfully.");
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessApi
    public void updateRecogTxt(String str) {
        if (isRecogStarted()) {
            synchronized (this.mLockRecog) {
                this.mRecogTxt = str;
                this.mRecogTimeStart = 0L;
            }
        }
    }

    private void initStat() {
        this.mSubPeriodStartTimestampMs = 0L;
        this.mSubPeriodIdx = 0;
        Arrays.fill(this.mInputCntList, 0);
        Arrays.fill(this.mOutputCntList, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int decodeMP3Frame(byte[] bArr, e eVar) {
        int i3;
        int dequeueInputBuffer;
        int dequeueOutputBuffer;
        MediaFormat outputFormat;
        int i16;
        if (bArr == null || eVar == null || eVar.f26952j == null || eVar.f26943a == null) {
            return 1;
        }
        byte[] bArr2 = eVar.f26955m;
        if (bArr2 != null) {
            int i17 = eVar.f26954l;
            int length = bArr.length;
            int i18 = eVar.f26944b;
            if ((length * i18) + i17 <= bArr2.length) {
                if (i18 == 1) {
                    System.arraycopy(bArr2, i17, bArr, 0, bArr.length);
                } else {
                    for (int i19 = 0; i19 < bArr.length; i19 += 2) {
                        byte[] bArr3 = eVar.f26955m;
                        int i26 = eVar.f26954l;
                        int i27 = i19 * 2;
                        bArr[i19] = bArr3[i26 + i27];
                        bArr[i19 + 1] = bArr3[i26 + i27 + 1];
                    }
                }
                eVar.f26954l += bArr.length * eVar.f26944b;
                return 0;
            }
            if (i17 < bArr2.length) {
                i3 = (bArr2.length - i17) / i18;
                if (i18 == 1) {
                    System.arraycopy(bArr2, i17, bArr, 0, i3);
                } else {
                    for (int i28 = 0; i28 < i3; i28 += 2) {
                        byte[] bArr4 = eVar.f26955m;
                        int i29 = eVar.f26954l;
                        int i36 = i28 * 2;
                        bArr[i28] = bArr4[i29 + i36];
                        bArr[i28 + 1] = bArr4[i29 + i36 + 1];
                    }
                }
                eVar.f26954l += eVar.f26944b * i3;
                ByteBuffer[] inputBuffers = eVar.f26943a.getInputBuffers();
                dequeueInputBuffer = eVar.f26943a.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer < 0) {
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    int readSampleData = eVar.f26952j.readSampleData(byteBuffer, 0);
                    if (readSampleData > 0) {
                        eVar.f26943a.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, 0L, 0);
                        eVar.f26952j.advance();
                    } else {
                        eVar.f26943a.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 0);
                        return 2;
                    }
                } else if (dequeueInputBuffer == -1) {
                    return 3;
                }
                ByteBuffer[] outputBuffers = eVar.f26943a.getOutputBuffers();
                dequeueOutputBuffer = eVar.f26943a.dequeueOutputBuffer(eVar.f26953k, 10000L);
                if (dequeueOutputBuffer >= 0 || (i16 = eVar.f26953k.size) <= (bArr.length - i3) * eVar.f26944b) {
                    if (dequeueOutputBuffer == -2 && (outputFormat = eVar.f26943a.getOutputFormat()) != null) {
                        try {
                            a.g(TAG, "decodeMP3Frame but format changed. INFO_OUTPUT_FORMAT_CHANGED. sampleRate = " + outputFormat.getInteger("sample-rate") + ", pcmEncoding = " + outputFormat.getInteger("pcm-encoding") + ", channelCount = " + outputFormat.getInteger("channel-count"));
                        } catch (ClassCastException unused) {
                            a.b(TAG, "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. ClassCastException.");
                        } catch (NullPointerException unused2) {
                            a.b(TAG, "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. NullPointerException.");
                        }
                    }
                    return 3;
                }
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                byte[] bArr5 = eVar.f26955m;
                if (bArr5 == null || bArr5.length != i16) {
                    eVar.f26955m = new byte[i16];
                }
                byteBuffer2.get(eVar.f26955m);
                byteBuffer2.clear();
                if (eVar.f26944b == 1) {
                    System.arraycopy(eVar.f26955m, 0, bArr, i3, bArr.length - i3);
                } else {
                    for (int i37 = 0; i37 < bArr.length - i3; i37 += 2) {
                        int i38 = i3 + i37;
                        byte[] bArr6 = eVar.f26955m;
                        int i39 = i37 * 2;
                        bArr[i38] = bArr6[i39];
                        bArr[i38 + 1] = bArr6[i39 + 1];
                    }
                }
                eVar.f26954l = (bArr.length - i3) * eVar.f26944b;
                eVar.f26943a.releaseOutputBuffer(dequeueOutputBuffer, false);
                return 0;
            }
        }
        i3 = 0;
        ByteBuffer[] inputBuffers2 = eVar.f26943a.getInputBuffers();
        dequeueInputBuffer = eVar.f26943a.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
        }
        ByteBuffer[] outputBuffers2 = eVar.f26943a.getOutputBuffers();
        dequeueOutputBuffer = eVar.f26943a.dequeueOutputBuffer(eVar.f26953k, 10000L);
        if (dequeueOutputBuffer >= 0) {
        }
        if (dequeueOutputBuffer == -2) {
            a.g(TAG, "decodeMP3Frame but format changed. INFO_OUTPUT_FORMAT_CHANGED. sampleRate = " + outputFormat.getInteger("sample-rate") + ", pcmEncoding = " + outputFormat.getInteger("pcm-encoding") + ", channelCount = " + outputFormat.getInteger("channel-count"));
        }
        return 3;
    }

    private static boolean isSpeaking3(byte[] bArr) {
        double d16 = 0.0d;
        for (int i3 = 0; i3 < bArr.length / 2; i3++) {
            int i16 = i3 * 2;
            d16 += Math.pow((short) (((bArr[i16 + 1] & 255) << 8) | (bArr[i16] & 255)), 2.0d);
        }
        double log10 = Math.log10((((d16 * 2.0d) / bArr.length) / 32767.0d) / 32767.0d) * 10.0d;
        if (log10 < -30.0d) {
            log10 = -30.0d;
        }
        double d17 = -log10;
        if (d17 < 27.0d) {
            a.a(TAG, "isSpeaking3 rms=" + (d17 + 0.5d));
        }
        return d17 < 27.0d;
    }

    public static void scaleVolume(byte[] bArr, float f16) {
        if (bArr == null) {
            return;
        }
        for (int i3 = 0; i3 < bArr.length / 2; i3++) {
            int i16 = i3 * 2;
            int i17 = i16 + 1;
            short s16 = (short) (((short) ((bArr[i16] & 255) | ((bArr[i17] & 255) << 8))) * f16);
            short s17 = ShortCompanionObject.MAX_VALUE;
            if (s16 <= Short.MAX_VALUE) {
                s17 = ShortCompanionObject.MIN_VALUE;
                if (s16 >= Short.MIN_VALUE) {
                    bArr[i16] = (byte) (s16 & 255);
                    bArr[i17] = (byte) ((65280 & s16) >> 8);
                }
            }
            s16 = s17;
            bArr[i16] = (byte) (s16 & 255);
            bArr[i17] = (byte) ((65280 & s16) >> 8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    private static void saveData(String str, String str2, byte[] bArr, int i3) {
        FileOutputStream fileOutputStream;
        IOException e16;
        FileNotFoundException e17;
        File file = new File(str);
        File file2 = new File(str + ((String) str2));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
        }
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2, true);
                    if (bArr != null) {
                        try {
                            fileOutputStream.write(bArr, 0, i3);
                        } catch (FileNotFoundException e19) {
                            e17 = e19;
                            e17.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return;
                        } catch (IOException e26) {
                            e16 = e26;
                            e16.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return;
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (FileNotFoundException e27) {
                    fileOutputStream = null;
                    e17 = e27;
                } catch (IOException e28) {
                    fileOutputStream = null;
                    e16 = e28;
                } catch (Throwable th5) {
                    str2 = 0;
                    th = th5;
                    if (str2 != 0) {
                        try {
                            str2.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e36) {
                e36.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static boolean mix(byte[] bArr, List<byte[]> list) {
        if (bArr == null) {
            a.g(TAG, "no to mix this data. param error. mixData == null.");
            return false;
        }
        if (list == null) {
            a.g(TAG, "no to mix this data. param error. pcmDataList == null.");
            return false;
        }
        if (list.size() == 0) {
            a.g(TAG, "no to mix this data. param error. pcmDataList.size() == 0.");
            return false;
        }
        if (list.get(0).length % 2 != 0) {
            a.g(TAG, "no to mix this data. param error. pcmDataList.get(0).length = " + list.get(0).length);
            return false;
        }
        if (bArr.length < list.get(0).length) {
            a.g(TAG, "no to mix this data. param error. mixData.length = " + bArr.length + ", pcmDataList.get(0).length = " + list.get(0).length);
            return false;
        }
        int size = list.size();
        int length = list.get(0).length;
        if (size == 1) {
            System.arraycopy(list.get(0), 0, bArr, 0, length);
        } else {
            for (int i3 = 0; i3 < length / 2; i3++) {
                int i16 = 0;
                for (int i17 = 0; i17 < size; i17++) {
                    int i18 = i3 * 2;
                    i16 += (short) ((list.get(i17)[i18] & 255) | ((list.get(i17)[i18 + 1] & 255) << 8));
                }
                int i19 = i16 / size;
                int i26 = 32767;
                if (i19 <= 32767) {
                    i26 = -32768;
                    if (i19 >= -32768) {
                        int i27 = i3 * 2;
                        short s16 = (short) i19;
                        bArr[i27] = (byte) (s16 & 255);
                        bArr[i27 + 1] = (byte) ((s16 & 65280) >> 8);
                    }
                }
                i19 = i26;
                int i272 = i3 * 2;
                short s162 = (short) i19;
                bArr[i272] = (byte) (s162 & 255);
                bArr[i272 + 1] = (byte) ((s162 & 65280) >> 8);
            }
        }
        return true;
    }
}

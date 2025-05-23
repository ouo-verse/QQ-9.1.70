package ld0;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IHwVideoMerge;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes5.dex */
public class a {
    public ArrayList<Long> a(List<String> list, String str) {
        if (list != null && list.size() != 1 && !TextUtils.isEmpty(str)) {
            long c16 = im2.a.c(str);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str2 : list) {
                if (linkedHashMap.containsKey(str2)) {
                    long longValue = ((Long) linkedHashMap.get(str2)).longValue();
                    linkedHashMap.put(str2, Long.valueOf(longValue + longValue));
                } else {
                    linkedHashMap.put(str2, Long.valueOf(im2.a.c(str2)));
                }
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator it = linkedHashMap.keySet().iterator();
            long j3 = 0;
            long j16 = 0;
            while (it.hasNext()) {
                j16 += ((Long) linkedHashMap.get((String) it.next())).longValue();
                arrayList.add(Long.valueOf(j16));
            }
            if (j16 > c16) {
                j3 = ((j16 - c16) / (linkedHashMap.size() - 1)) / 2;
            }
            if (arrayList.size() > 1) {
                arrayList.remove(arrayList.size() - 1);
            }
            int size = arrayList.size();
            long j17 = -50;
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.set(i3, Long.valueOf((arrayList.get(i3).longValue() - j3) + j17));
                j17 -= j3 * 2;
            }
            return arrayList;
        }
        return null;
    }

    public ArrayList<Long> b(List<String> list) {
        if (list != null && list.size() != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : list) {
                if (linkedHashMap.containsKey(str)) {
                    long longValue = ((Long) linkedHashMap.get(str)).longValue();
                    linkedHashMap.put(str, Long.valueOf(longValue + longValue));
                } else {
                    linkedHashMap.put(str, Long.valueOf(im2.a.c(str)));
                }
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator it = linkedHashMap.keySet().iterator();
            long j3 = -10;
            while (it.hasNext()) {
                j3 += ((Long) linkedHashMap.get((String) it.next())).longValue();
                arrayList.add(Long.valueOf(j3));
            }
            if (arrayList.size() > 1) {
                arrayList.remove(arrayList.size() - 1);
            }
            return arrayList;
        }
        return null;
    }

    public boolean c(List<String> list, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                for (int i3 = 0; i3 < list.size(); i3++) {
                    try {
                        try {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(list.get(i3), "r");
                            byte[] bArr = new byte[51200];
                            while (true) {
                                try {
                                    try {
                                        int read = randomAccessFile.read(bArr);
                                        if (read != -1) {
                                            fileOutputStream2.write(bArr, 0, read);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Exception e17) {
                                            e17.printStackTrace();
                                        }
                                        throw th5;
                                    }
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
                                    }
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e26) {
                                        e26.printStackTrace();
                                    }
                                    return false;
                                }
                            }
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th = th6;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e28) {
                        e = e28;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e29) {
                                e29.printStackTrace();
                            }
                        }
                        return false;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (IOException e36) {
                    e36.printStackTrace();
                    return true;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e37) {
            e = e37;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(List<String> list, String str, int i3, int i16, MediaFormat mediaFormat) {
        int i17;
        int i18;
        int i19;
        int i26;
        if (i3 > 0 && i16 > 0) {
            i19 = i3;
            i18 = i16;
            i26 = 0;
        } else {
            d.a aVar = new d.a();
            try {
                int a16 = d.a(list.get(0), aVar);
                i17 = aVar.f288248a[2];
                if (a16 < 0) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e("QimSegmentMergeUtil", 2, "MediaMetadataUtils.getRotationDegree error: " + a16);
                            return false;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e("QimSegmentMergeUtil", 2, e.getMessage(), e);
                            return false;
                        }
                        int[] iArr = aVar.f288248a;
                        int i27 = iArr[0];
                        i18 = iArr[1];
                        i19 = i27;
                        i26 = i17;
                        if (!QQAudioHelper.i()) {
                        }
                    }
                }
            } catch (Exception e17) {
                e = e17;
                i17 = 0;
            }
            int[] iArr2 = aVar.f288248a;
            int i272 = iArr2[0];
            i18 = iArr2[1];
            i19 = i272;
            i26 = i17;
        }
        if (!QQAudioHelper.i()) {
            return ((IHwVideoMerge) QRoute.api(IHwVideoMerge.class)).ffmpegMergeMultiVideo(list, str, i26);
        }
        ArrayList<DecodeConfig> arrayList = new ArrayList();
        for (int i28 = 0; i28 < list.size(); i28++) {
            arrayList.add(new DecodeConfig(list.get(i28), 0, false, true));
        }
        c cVar = new c(str, i19, i18, CodecParam.mMaxrate, 1, false, i26);
        cVar.f312570o = true;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(1048576);
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            File file = new File(cVar.f312558c);
            if (!file.exists()) {
                FileUtils.createFileIfNotExits(file.getAbsolutePath());
            }
            MediaMuxer mediaMuxer = new MediaMuxer(cVar.f312558c, 0);
            mediaMuxer.setOrientationHint(cVar.f312568m);
            int addTrack = mediaMuxer.addTrack(mediaFormat);
            mediaMuxer.start();
            int i29 = 1;
            long j3 = 0;
            for (DecodeConfig decodeConfig : arrayList) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(decodeConfig.inputFilePath);
                    int i36 = 0;
                    while (true) {
                        if (i36 >= mediaExtractor.getTrackCount()) {
                            break;
                        }
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i36);
                        if (trackFormat.getString("mime").startsWith("video/")) {
                            mediaExtractor.selectTrack(i36);
                            trackFormat.setInteger("rotation-degrees", decodeConfig.rotation);
                            break;
                        }
                        i36++;
                    }
                    long j16 = 0;
                    long j17 = 0;
                    while (true) {
                        allocate.clear();
                        int readSampleData = mediaExtractor.readSampleData(allocate, 0);
                        if (readSampleData < 0) {
                            break;
                        }
                        j16 = mediaExtractor.getSampleTime() + j3;
                        if (j16 > 0) {
                            j17 = j16 - bufferInfo.presentationTimeUs;
                        }
                        bufferInfo.offset = 0;
                        bufferInfo.size = readSampleData;
                        bufferInfo.flags = i29;
                        bufferInfo.presentationTimeUs = j16;
                        mediaMuxer.writeSampleData(addTrack, allocate, bufferInfo);
                        mediaExtractor.advance();
                        i29 = 0;
                    }
                    j3 = j16 + j17;
                    mediaExtractor.release();
                } catch (IOException e18) {
                    mediaExtractor.release();
                    mediaMuxer.release();
                    e18.printStackTrace();
                    return false;
                }
            }
            mediaMuxer.stop();
            mediaMuxer.release();
            return true;
        } catch (Exception e19) {
            QLog.e("QimSegmentMergeUtil", 2, e19, new Object[0]);
            return false;
        }
    }
}

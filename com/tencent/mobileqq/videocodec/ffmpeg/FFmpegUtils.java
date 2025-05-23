package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import hd0.c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import vc0.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FFmpegUtils {
    static IPatchRedirector $redirector_;

    public FFmpegUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void changeOrientationInVideo(Context context, String str, String str2, String str3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 12;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2, str3) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$inputFilePath;
            final /* synthetic */ String val$orientation;
            final /* synthetic */ String val$outputVideoPath;

            {
                this.val$inputFilePath = str;
                this.val$orientation = str2;
                this.val$outputVideoPath = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                    return;
                }
                add(str);
                add(str2);
                add(str3);
            }
        };
        fFmpegCommandUnit.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit);
        FFmpeg fFmpeg = FFmpeg.getInstance(context);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    private static void clipAudio(PublishVideoEntry publishVideoEntry, ExecuteBinResponseCallback executeBinResponseCallback, String str, int i3, int i16, String str2, ArrayList<FFmpegCommandUnit> arrayList) {
        if (d.d(str2)) {
            d.i(str2);
        }
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 3;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2, i3, i16) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.12
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$bgMusicDuration;
            final /* synthetic */ int val$bgMusicOffset;
            final /* synthetic */ String val$bgMusicPath;
            final /* synthetic */ String val$outputClipAudioPath;

            {
                this.val$bgMusicPath = str;
                this.val$outputClipAudioPath = str2;
                this.val$bgMusicOffset = i3;
                this.val$bgMusicDuration = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                add(str);
                add(str2);
                add(Integer.valueOf(i3));
                add(Integer.valueOf(i16));
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback(publishVideoEntry) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.13
            static IPatchRedirector $redirector_;
            final /* synthetic */ PublishVideoEntry val$info;

            {
                this.val$info = publishVideoEntry;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExecuteBinResponseCallback.this, (Object) publishVideoEntry);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3);
                    return;
                }
                QLog.e(FFmpeg.TAG, 1, str3);
                ExecuteBinResponseCallback.this.onFailure(str3);
                QLog.w(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " clip audio failed  msg\uff1a" + str3);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                super.onStart();
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " clip audio start");
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str3);
                    return;
                }
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " clip audio end cost\uff1a" + String.valueOf(System.currentTimeMillis() - this.startTime));
            }
        };
        arrayList.add(fFmpegCommandUnit);
    }

    public static void combinBackgroundMusic(Context context, String str, String str2, int i3, int i16, String str3, ExecuteBinResponseCallback executeBinResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        combinBackgroundMusic(context, str, str2, i3, i16, str3, true, executeBinResponseCallback);
    }

    public static void combinBackgroundMusicWithVideCodecH264(Context context, String str, String str2, int i3, int i16, String str3, ExecuteBinResponseCallback executeBinResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        combineBackgroundMusicInner(false, context, str, str2, "h264", i3, i16, str3, false, executeBinResponseCallback);
    }

    private static void combineBackgroundMusicInner(boolean z16, Context context, String str, String str2, String str3, int i3, int i16, String str4, boolean z17, ExecuteBinResponseCallback executeBinResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        FFmpeg fFmpeg;
        long currentTimeMillis = System.currentTimeMillis();
        String auidoType = getAuidoType(str2);
        String str5 = a.f441366f;
        File file = new File(str5);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str5);
        stringBuffer.append(str2.hashCode());
        stringBuffer.append("_");
        stringBuffer.append(i3);
        stringBuffer.append("_");
        stringBuffer.append(i16);
        stringBuffer.append(auidoType);
        String str6 = new String(stringBuffer);
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 3;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str2, str6, i3, i16) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$bgMusicDuration;
            final /* synthetic */ int val$bgMusicOffset;
            final /* synthetic */ String val$bgMusicPath;
            final /* synthetic */ String val$outputClipAudioPath;

            {
                this.val$bgMusicPath = str2;
                this.val$outputClipAudioPath = str6;
                this.val$bgMusicOffset = i3;
                this.val$bgMusicDuration = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str2, str6, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                add(str2);
                add(str6);
                add(Integer.valueOf(i3));
                add(Integer.valueOf(i16));
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback() { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExecuteBinResponseCallback.this);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str7) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str7);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(FFmpeg.TAG, 2, str7);
                }
                ExecuteBinResponseCallback.this.onFailure(str7);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                } else {
                    super.onStart();
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str7) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str7);
                    return;
                }
                String valueOf = String.valueOf(System.currentTimeMillis() - this.startTime);
                if (QLog.isColorLevel()) {
                    QLog.w(FFmpeg.TAG, 2, "\u97f3\u4e50\u622a\u53d6\u6210\u529f\u8017\u65f6\uff1a" + valueOf);
                }
            }
        };
        arrayList.add(fFmpegCommandUnit);
        FFmpegCommandUnit fFmpegCommandUnit2 = new FFmpegCommandUnit();
        fFmpegCommandUnit2.cmdType = 4;
        fFmpegCommandUnit2.arguments = new ArrayList<Object>(str, str6, str3, str4, z17, i16) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.8
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$bgMusicDuration;
            final /* synthetic */ boolean val$isLoopAudio;
            final /* synthetic */ String val$outputClipAudioPath;
            final /* synthetic */ String val$outputPath;
            final /* synthetic */ String val$videoPath;
            final /* synthetic */ String val$videocodec;

            {
                this.val$videoPath = str;
                this.val$outputClipAudioPath = str6;
                this.val$videocodec = str3;
                this.val$outputPath = str4;
                this.val$isLoopAudio = z17;
                this.val$bgMusicDuration = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str6, str3, str4, Boolean.valueOf(z17), Integer.valueOf(i16));
                    return;
                }
                add(str);
                add(str6);
                add(str3);
                add(str4);
                add(Boolean.valueOf(z17));
                add(Integer.valueOf(i16));
            }
        };
        fFmpegCommandUnit2.callback = new ExecuteBinResponseCallback(str6, currentTimeMillis) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.9
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$mergeStartTime;
            final /* synthetic */ String val$outputClipAudioPath;

            {
                this.val$outputClipAudioPath = str6;
                this.val$mergeStartTime = currentTimeMillis;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ExecuteBinResponseCallback.this, str6, Long.valueOf(currentTimeMillis));
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str7) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) str7);
                } else {
                    ExecuteBinResponseCallback.this.onFailure(str7);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFinish(boolean z18) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, z18);
                    return;
                }
                File file2 = new File(this.val$outputClipAudioPath);
                if (file2.exists()) {
                    file2.delete();
                }
                ExecuteBinResponseCallback.this.onFinish(z18);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    super.onStart();
                    ExecuteBinResponseCallback.this.onStart();
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str7) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str7);
                    return;
                }
                String.valueOf(System.currentTimeMillis() - this.startTime);
                if (com.tencent.mobileqq.monitor.a.f247270d) {
                    com.tencent.mobileqq.monitor.a.f247272f.d(1, System.currentTimeMillis() - this.val$mergeStartTime);
                }
                ExecuteBinResponseCallback.this.onSuccess(str7);
                c.k(FFmpeg.TAG, " recordVideo combinBackgroundMusic success end");
            }
        };
        arrayList.add(fFmpegCommandUnit2);
        if (z16) {
            fFmpeg = FFmpeg.newInstance(context, true);
        } else {
            fFmpeg = FFmpeg.getInstance(context, true);
        }
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static void combineDoodle(Context context, String str, String str2, String str3, ExecuteBinResponseCallback executeBinResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 15;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2, str3) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.10
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$doodlePath;
            final /* synthetic */ String val$outPath;
            final /* synthetic */ String val$videoPath;

            {
                this.val$videoPath = str;
                this.val$doodlePath = str2;
                this.val$outPath = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                    return;
                }
                add(str);
                add(str2);
                add(str3);
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback() { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExecuteBinResponseCallback.this);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str4) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) str4);
                } else {
                    ExecuteBinResponseCallback.this.onFailure(str4);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFinish(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, z16);
                } else {
                    ExecuteBinResponseCallback.this.onFinish(z16);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    super.onStart();
                    ExecuteBinResponseCallback.this.onStart();
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str4) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str4);
                } else {
                    ExecuteBinResponseCallback.this.onSuccess(str4);
                }
            }
        };
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        arrayList.add(fFmpegCommandUnit);
        FFmpeg fFmpeg = FFmpeg.getInstance(context, true);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static boolean combineTwoImg(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Bitmap decodeFile = SafeBitmapFactory.decodeFile(str2);
            Bitmap decodeFile2 = SafeBitmapFactory.decodeFile(str);
            if (decodeFile != null && decodeFile2 != null) {
                return combineTwoImg(decodeFile2, decodeFile, str3);
            }
        }
        return false;
    }

    private static void combineVideoAndAudio(String str, PublishVideoEntry publishVideoEntry, boolean z16, ExecuteBinResponseCallback executeBinResponseCallback, int i3, long j3, String str2, ArrayList<FFmpegCommandUnit> arrayList, String str3, String str4, String str5) {
        if (d.d(str)) {
            d.i(str);
        }
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 4;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str5, str4, str, z16, i3) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.14
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$bgMusicDuration;
            final /* synthetic */ String val$finalMixAudioPath;
            final /* synthetic */ String val$finalNoneAudioVideoPath;
            final /* synthetic */ boolean val$isLoopAudio;
            final /* synthetic */ String val$outputPath;

            {
                this.val$finalNoneAudioVideoPath = str5;
                this.val$finalMixAudioPath = str4;
                this.val$outputPath = str;
                this.val$isLoopAudio = z16;
                this.val$bgMusicDuration = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str5, str4, str, Boolean.valueOf(z16), Integer.valueOf(i3));
                    return;
                }
                add(str5);
                add(str4);
                add("h264");
                add(str);
                add(Boolean.valueOf(z16));
                add(Integer.valueOf(i3));
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback(publishVideoEntry, str2, str4, str5, str3, j3) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.15
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$finalMixAudioPath;
            final /* synthetic */ String val$finalNoneAudioVideoPath;
            final /* synthetic */ PublishVideoEntry val$info;
            final /* synthetic */ String val$localAudioPath;
            final /* synthetic */ long val$mergeStartTime;
            final /* synthetic */ String val$outputClipAudioPath;

            {
                this.val$info = publishVideoEntry;
                this.val$outputClipAudioPath = str2;
                this.val$finalMixAudioPath = str4;
                this.val$finalNoneAudioVideoPath = str5;
                this.val$localAudioPath = str3;
                this.val$mergeStartTime = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ExecuteBinResponseCallback.this, publishVideoEntry, str2, str4, str5, str3, Long.valueOf(j3));
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str6) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) str6);
                    return;
                }
                ExecuteBinResponseCallback.this.onFailure(str6);
                ExecuteBinResponseCallback executeBinResponseCallback2 = ExecuteBinResponseCallback.this;
                if (executeBinResponseCallback2 instanceof VideoCompositeHelper.d) {
                    ((VideoCompositeHelper.d) executeBinResponseCallback2).a(941007);
                }
                QLog.w(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " combineVideoAndAudio failed msg\uff1a" + str6);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFinish(boolean z17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, z17);
                    return;
                }
                File file = new File(this.val$outputClipAudioPath);
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(this.val$finalMixAudioPath);
                if (file2.exists()) {
                    file2.delete();
                }
                File file3 = new File(this.val$finalNoneAudioVideoPath);
                if (file3.exists()) {
                    file3.delete();
                }
                File file4 = new File(this.val$localAudioPath);
                if (file4.exists()) {
                    file4.delete();
                }
                ExecuteBinResponseCallback.this.onFinish(z17);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                super.onStart();
                ExecuteBinResponseCallback.this.onStart();
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " combineVideoAndAudio start");
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str6) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str6);
                    return;
                }
                String valueOf = String.valueOf(System.currentTimeMillis() - this.startTime);
                if (com.tencent.mobileqq.monitor.a.f247270d) {
                    com.tencent.mobileqq.monitor.a.f247272f.d(1, System.currentTimeMillis() - this.val$mergeStartTime);
                }
                ExecuteBinResponseCallback.this.onSuccess(str6);
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " combineVideoAndAudio end cost time\uff1a" + valueOf);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fakeid:");
                sb5.append(this.val$info.fakeVid);
                sb5.append(" mergeMusic success end");
                QLog.i(FFmpeg.TAG, 1, sb5.toString());
            }
        };
        arrayList.add(fFmpegCommandUnit);
    }

    public static void compressLocalVideo(Context context, String str, int i3, int i16, int i17, boolean z16, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 11;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, i3, i16, i17, z16, str2) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$bitrate;
            final /* synthetic */ int val$duration;
            final /* synthetic */ String val$inputFilePath;
            final /* synthetic */ boolean val$isMute;
            final /* synthetic */ String val$outputFilePath;
            final /* synthetic */ int val$start;

            {
                this.val$inputFilePath = str;
                this.val$start = i3;
                this.val$duration = i16;
                this.val$bitrate = i17;
                this.val$isMute = z16;
                this.val$outputFilePath = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), str2);
                    return;
                }
                add(str);
                add(Integer.valueOf(i3));
                add(Integer.valueOf(i16));
                add(Integer.valueOf(i17));
                add(Boolean.valueOf(z16));
                add(str2);
            }
        };
        fFmpegCommandUnit.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit);
        FFmpeg fFmpeg = FFmpeg.getInstance(context);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static void compressVideoWithBitrate(String str, String str2, int i3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        boolean isAvcodecNewVersion = VideoEnvironment.isAvcodecNewVersion();
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add(Argument.BITRATE_VIDEO);
        arrayList.add("" + i3);
        if (!isAvcodecNewVersion) {
            arrayList.add("-profile:v");
            arrayList.add("baseline");
        }
        arrayList.add("-bufsize");
        arrayList.add("800k");
        arrayList.add("-r");
        arrayList.add("25");
        if (isAvcodecNewVersion) {
            arrayList.add("-c:v");
            arrayList.add("libo264rt");
        }
        arrayList.add("-c:a");
        arrayList.add("copy");
        arrayList.add(new File(str2).getCanonicalPath());
        FFmpeg.getInstance(BaseApplication.getContext()).execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public static void convertPicToVideo(Context context, String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 9;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$inputPicPath;
            final /* synthetic */ String val$outputVideoPath;

            {
                this.val$inputPicPath = str;
                this.val$outputVideoPath = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                } else {
                    add(str);
                    add(str2);
                }
            }
        };
        fFmpegCommandUnit.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit);
        FFmpeg fFmpeg = FFmpeg.getInstance(context);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static void convertPicToVideoWidthDuration(Context context, String str, String str2, String str3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 20;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2, str3) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$duration;
            final /* synthetic */ String val$inputPicPath;
            final /* synthetic */ String val$outputVideoPath;

            {
                this.val$inputPicPath = str;
                this.val$outputVideoPath = str2;
                this.val$duration = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                    return;
                }
                add(str);
                add(str2);
                add(str3);
            }
        };
        fFmpegCommandUnit.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit);
        FFmpeg fFmpeg = FFmpeg.getInstance(context);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static void convertVideoToMp3(boolean z16, Context context, String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        FFmpeg fFmpeg;
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 16;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.25
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$inputVideoPath;
            final /* synthetic */ String val$outputMusicPath;

            {
                this.val$inputVideoPath = str;
                this.val$outputMusicPath = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                } else {
                    add(str);
                    add(str2);
                }
            }
        };
        fFmpegCommandUnit.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit);
        if (z16) {
            fFmpeg = FFmpeg.newInstance(context, false);
        } else {
            fFmpeg = FFmpeg.getInstance(context);
        }
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static void detectMediaVolume(Context context, String str, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 22;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.24
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$inputFilePath;

            {
                this.val$inputFilePath = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                } else {
                    add(str);
                }
            }
        };
        fFmpegCommandUnit.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit);
        FFmpeg fFmpeg = FFmpeg.getInstance(context);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static void generateGifFromVideoWithPalette(String str, String str2, String str3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.START_TIME);
        arrayList.add("0");
        arrayList.add(Argument.DURATION);
        arrayList.add("4");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str2);
        arrayList.add("-lavfi");
        arrayList.add("fps=18,scale=280:-1:flags=lanczos,paletteuse=dither=floyd_steinberg");
        arrayList.add("-y");
        arrayList.add(str3);
        FFmpeg.getInstance(BaseApplication.getContext()).execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public static void generatePalettePNG(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.START_TIME);
        arrayList.add("0");
        arrayList.add(Argument.DURATION);
        arrayList.add("1");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add("-vf");
        arrayList.add("fps=18,scale=280:-1:flags=lanczos,palettegen=stats_mode=diff");
        arrayList.add("-y");
        arrayList.add(str2);
        FFmpeg.getInstance(BaseApplication.getContext()).execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    private static void getAudioFromMp4(PublishVideoEntry publishVideoEntry, String str, String str2, ExecuteBinResponseCallback executeBinResponseCallback, ArrayList<FFmpegCommandUnit> arrayList) {
        if (d.d(str2)) {
            d.i(str2);
        }
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 18;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.18
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$outputPath;
            final /* synthetic */ String val$videoPath;

            {
                this.val$videoPath = str;
                this.val$outputPath = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                } else {
                    add(str);
                    add(str2);
                }
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback(publishVideoEntry) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.19
            static IPatchRedirector $redirector_;
            final /* synthetic */ PublishVideoEntry val$info;

            {
                this.val$info = publishVideoEntry;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExecuteBinResponseCallback.this, (Object) publishVideoEntry);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(FFmpeg.TAG, 2, str3);
                }
                ExecuteBinResponseCallback.this.onFailure(str3);
                ExecuteBinResponseCallback executeBinResponseCallback2 = ExecuteBinResponseCallback.this;
                if (executeBinResponseCallback2 instanceof VideoCompositeHelper.d) {
                    ((VideoCompositeHelper.d) executeBinResponseCallback2).a(941004);
                }
                QLog.w(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " getAudioFromMp4 failed message\uff1a" + str3);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                super.onStart();
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " getAudioFromMp4 start");
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str3);
                    return;
                }
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " getAudioFromMp4 success cost\uff1a" + String.valueOf(System.currentTimeMillis() - this.startTime) + "ms\n");
            }
        };
        arrayList.add(fFmpegCommandUnit);
    }

    public static String getAuidoType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("http") && str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str = str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf <= -1 || lastIndexOf >= str.length() - 1) {
            return "";
        }
        return str.substring(lastIndexOf);
    }

    public static String getSavePublishVidFileName(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QQStoryMoment");
        sb5.append(System.currentTimeMillis());
        sb5.append("_");
        sb5.append(str);
        if (str2 == null) {
            str2 = ".mp4";
        }
        sb5.append(str2);
        return sb5.toString();
    }

    private static void getVideoFromMp4(PublishVideoEntry publishVideoEntry, String str, String str2, ExecuteBinResponseCallback executeBinResponseCallback, ArrayList<FFmpegCommandUnit> arrayList) {
        if (d.d(str)) {
            d.i(str);
        }
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 19;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str2, str) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.16
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$finalNoneAudioVideoPath;
            final /* synthetic */ String val$videoPath;

            {
                this.val$videoPath = str2;
                this.val$finalNoneAudioVideoPath = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str2, (Object) str);
                } else {
                    add(str2);
                    add(str);
                }
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback(publishVideoEntry) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.17
            static IPatchRedirector $redirector_;
            final /* synthetic */ PublishVideoEntry val$info;

            {
                this.val$info = publishVideoEntry;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExecuteBinResponseCallback.this, (Object) publishVideoEntry);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(FFmpeg.TAG, 2, str3);
                }
                ExecuteBinResponseCallback.this.onFailure(str3);
                ExecuteBinResponseCallback executeBinResponseCallback2 = ExecuteBinResponseCallback.this;
                if (executeBinResponseCallback2 instanceof VideoCompositeHelper.d) {
                    ((VideoCompositeHelper.d) executeBinResponseCallback2).a(941006);
                }
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " getVideoFromMp4 failed msg\uff1a" + str3);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                super.onStart();
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " getVideoFromMp4 start");
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str3);
                    return;
                }
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " getVideoFromMp4 success cost\uff1a" + String.valueOf(System.currentTimeMillis() - this.startTime));
            }
        };
        arrayList.add(fFmpegCommandUnit);
    }

    public static boolean isProcessCompleted(Process process) {
        return Util.isProcessCompleted(process);
    }

    public static void killRunningProcesses() {
        FFmpeg.getInstance(BaseApplication.getContext()).killRunningProcessesForShortVideo(false);
    }

    private static void mixMusicAndOriginal(PublishVideoEntry publishVideoEntry, String str, String str2, String str3, float f16, float f17, ExecuteBinResponseCallback executeBinResponseCallback, ArrayList<FFmpegCommandUnit> arrayList) {
        if (d.d(str3)) {
            d.i(str3);
        }
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 17;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2, str3, f16, f17) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.22
            static IPatchRedirector $redirector_;
            final /* synthetic */ float val$bgMusicVolume;
            final /* synthetic */ String val$mixAudioPath;
            final /* synthetic */ String val$otherSourcePath;
            final /* synthetic */ String val$sourcePath;
            final /* synthetic */ float val$targetFileVolume;

            {
                this.val$sourcePath = str;
                this.val$otherSourcePath = str2;
                this.val$mixAudioPath = str3;
                this.val$targetFileVolume = f16;
                this.val$bgMusicVolume = f17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, str3, Float.valueOf(f16), Float.valueOf(f17));
                    return;
                }
                add(str);
                add(str2);
                add(str3);
                add(Float.valueOf(f16));
                add(Float.valueOf(f17));
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback(publishVideoEntry) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.23
            static IPatchRedirector $redirector_;
            final /* synthetic */ PublishVideoEntry val$info;

            {
                this.val$info = publishVideoEntry;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExecuteBinResponseCallback.this, (Object) publishVideoEntry);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str4) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str4);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(FFmpeg.TAG, 2, str4);
                }
                ExecuteBinResponseCallback.this.onFailure(str4);
                QLog.w(FFmpeg.TAG, 2, "fakeid:" + this.val$info.fakeVid + " combine mix music and original failed " + str4);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                super.onStart();
                QLog.i(FFmpeg.TAG, 2, "fakeid:" + this.val$info.fakeVid + " combine mix music and original start");
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str4) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str4);
                    return;
                }
                QLog.i(FFmpeg.TAG, 2, "fakeid:" + this.val$info.fakeVid + " combine mix music and original\uff1a" + String.valueOf(System.currentTimeMillis() - this.startTime));
            }
        };
        arrayList.add(fFmpegCommandUnit);
    }

    public static void mixOriginalAndBackgroundMusic(Context context, String str, String str2, PublishVideoEntry publishVideoEntry, boolean z16, ExecuteBinResponseCallback executeBinResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        boolean z17;
        String str3;
        String str4 = publishVideoEntry.backgroundMusicPath;
        int i3 = publishVideoEntry.backgroundMusicOffset;
        int i16 = publishVideoEntry.backgroundMusicDuration;
        float floatValue = Float.valueOf(publishVideoEntry.getStringExtra(PublishVideoEntry.ENTRY_KEY_ORIGINAL_RECORD_VOLUME, String.valueOf(0.7f))).floatValue();
        float floatValue2 = Float.valueOf(publishVideoEntry.getStringExtra(PublishVideoEntry.ENTRY_KEY_BACKGROUND_VOLUME, String.valueOf(1.0f))).floatValue();
        long currentTimeMillis = System.currentTimeMillis();
        String auidoType = getAuidoType(str4);
        if (!auidoType.equals(".mp4") && !auidoType.equals(".m4a")) {
            z17 = false;
        } else {
            z17 = true;
        }
        String str5 = a.f441366f;
        File file = new File(str5);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str5);
        stringBuffer.append(str4.hashCode());
        stringBuffer.append("_");
        stringBuffer.append(i3);
        stringBuffer.append("_");
        stringBuffer.append(i16);
        stringBuffer.append(".m4a");
        String str6 = new String(stringBuffer);
        String str7 = publishVideoEntry.videoUploadTempDir + "clipNoneMp4Temp" + auidoType;
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        if (z17) {
            str3 = str6;
        } else {
            str3 = str7;
        }
        clipAudio(publishVideoEntry, executeBinResponseCallback, str4, i3, i16, str3, arrayList);
        if (!z17) {
            transcodeAudio(publishVideoEntry, str7, str6, executeBinResponseCallback, arrayList);
        }
        String str8 = publishVideoEntry.videoUploadTempDir + ShortVideoConstants.SV_MEDIACODEC_ENCODE_AUDIO_MP4;
        String str9 = publishVideoEntry.videoUploadTempDir + ShortVideoConstants.SV_MEDIACODEC_VIDEO_AUDIO_SUFFIX;
        String str10 = publishVideoEntry.videoUploadTempDir + ShortVideoConstants.SV_MEDIACODEC_TRANSCODE_AUDIO_SUFFIX;
        if (publishVideoEntry.isLocalPublish) {
            getAudioFromMp4(publishVideoEntry, str, str9, executeBinResponseCallback, arrayList);
            transcodeAudio(publishVideoEntry, str9, str10, executeBinResponseCallback, arrayList);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str5);
        stringBuffer2.append(str8.hashCode());
        stringBuffer2.append("_mix_with_music");
        stringBuffer2.append(".mp4");
        String str11 = new String(stringBuffer2);
        String str12 = str5 + str.hashCode() + ShortVideoConstants.SV_MEDIACODEC_VIDEO_ENCODE_NONE_AUDIO_VIDEO_MP4;
        if (!publishVideoEntry.isLocalPublish) {
            str10 = str8;
        }
        mixMusicAndOriginal(publishVideoEntry, str10, str6, str11, floatValue, floatValue2, executeBinResponseCallback, arrayList);
        getVideoFromMp4(publishVideoEntry, str12, str, executeBinResponseCallback, arrayList);
        combineVideoAndAudio(str2, publishVideoEntry, z16, executeBinResponseCallback, i16, currentTimeMillis, str6, arrayList, str9, str11, str12);
        FFmpeg fFmpeg = FFmpeg.getInstance(context, true);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    public static void setTimestamp(Context context, String str, String str2, int i3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 13;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2, i3) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$inputFilePath;
            final /* synthetic */ String val$outputFilePath;
            final /* synthetic */ int val$rotation;

            {
                this.val$inputFilePath = str;
                this.val$outputFilePath = str2;
                this.val$rotation = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
                    return;
                }
                add(str);
                add(str2);
                add(Integer.valueOf(i3));
            }
        };
        fFmpegCommandUnit.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit);
        FFmpeg fFmpeg = FFmpeg.getInstance(context);
        if (fFmpeg.isFFmpegCommandRunning()) {
            fFmpeg.insertFFmpegQueue(arrayList);
        } else {
            fFmpeg.cmdFFmpegQueue(arrayList);
        }
    }

    private static void transcodeAudio(PublishVideoEntry publishVideoEntry, String str, String str2, ExecuteBinResponseCallback executeBinResponseCallback, ArrayList<FFmpegCommandUnit> arrayList) {
        if (d.d(str2)) {
            d.i(str2);
        }
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        fFmpegCommandUnit.cmdType = 21;
        fFmpegCommandUnit.arguments = new ArrayList<Object>(str, str2) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.20
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$inputAudioPath;
            final /* synthetic */ String val$outputPath;

            {
                this.val$inputAudioPath = str;
                this.val$outputPath = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                } else {
                    add(str);
                    add(str2);
                }
            }
        };
        fFmpegCommandUnit.callback = new ExecuteBinResponseCallback(publishVideoEntry) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils.21
            static IPatchRedirector $redirector_;
            final /* synthetic */ PublishVideoEntry val$info;

            {
                this.val$info = publishVideoEntry;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExecuteBinResponseCallback.this, (Object) publishVideoEntry);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(FFmpeg.TAG, 2, str3);
                }
                ExecuteBinResponseCallback.this.onFailure(str3);
                ExecuteBinResponseCallback executeBinResponseCallback2 = ExecuteBinResponseCallback.this;
                if (executeBinResponseCallback2 instanceof VideoCompositeHelper.d) {
                    ((VideoCompositeHelper.d) executeBinResponseCallback2).a(941005);
                }
                QLog.w(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " transcodeAudio failed message\uff1a" + str3);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                super.onStart();
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " transcodeAudio start");
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str3);
                    return;
                }
                QLog.i(FFmpeg.TAG, 1, "fakeid:" + this.val$info.fakeVid + " transcodeAudio success cost\uff1a" + String.valueOf(System.currentTimeMillis() - this.startTime) + "ms\n");
            }
        };
        arrayList.add(fFmpegCommandUnit);
    }

    public static void video2Gif(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add("-y");
        arrayList.add(str2);
        FFmpeg.getInstance(BaseApplication.getContext()).execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public static void combinBackgroundMusic(Context context, String str, String str2, int i3, int i16, String str3, boolean z16, ExecuteBinResponseCallback executeBinResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        combineBackgroundMusicInner(false, context, str, str2, "copy", i3, i16, str3, z16, executeBinResponseCallback);
    }

    public static boolean combineTwoImg(Bitmap bitmap, Bitmap bitmap2, String str) {
        if (bitmap != null && bitmap2 != null && !TextUtils.isEmpty(str)) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = bitmap2.getWidth();
            int height2 = bitmap2.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            if (width == width2 && height == height2) {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            } else {
                Matrix matrix = new Matrix();
                matrix.postScale(width / width2, height / height2);
                canvas.drawBitmap(bitmap2, matrix, null);
            }
            canvas.save();
            try {
                try {
                    BaseImageUtil.saveBitmapToFile(createBitmap, new File(str));
                    bitmap.recycle();
                    bitmap2.recycle();
                    return true;
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(FFmpeg.TAG, 2, "FFmpegUtils combineTwoImg IOException " + e16.getMessage());
                    }
                    bitmap.recycle();
                    bitmap2.recycle();
                    return false;
                }
            } catch (Throwable th5) {
                bitmap.recycle();
                bitmap2.recycle();
                throw th5;
            }
        }
        QLog.e(FFmpeg.TAG, 2, "FFmpegUtils combineTwoImg error");
        return false;
    }

    public static Bitmap combineTwoImg(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null && bitmap2 == null) {
            QLog.e(FFmpeg.TAG, 2, "FFmpegUtils combineTwoImg error");
            return null;
        }
        if (bitmap == null) {
            return bitmap2;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (width == width2 && height == height2) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(width / width2, height / height2);
            canvas.drawBitmap(bitmap2, matrix, null);
        }
        canvas.save();
        bitmap.recycle();
        bitmap2.recycle();
        return createBitmap;
    }
}

package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.xweb.FileReaderHelper;
import hd0.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vc0.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FFmpeg {
    static IPatchRedirector $redirector_ = null;
    public static final String MESSAGE_COPY_CMD_FAIL = "copy_fail";
    public static final String MESSAGE_COPY_CMD_SUCCESS = "copy_success";
    public static final String MESSAGE_INPUT_NULL = "input path is null";
    public static final String MESSAGE_TS_DONE = "TS file exists";
    protected static final long MINIMUM_TIMEOUT = 10000;
    protected static final int RESULT_FIAL = 0;
    protected static final int RESULT_NOT_DONE = -9999;
    protected static final int RESULT_SUCCESS = 1;
    public static final String TAG = "FFmpegCmd";
    protected static volatile FFmpeg instance;
    public final Context context;
    public FFmpegExecuteAsyncTask ffmpegExecuteAsyncTask;
    public ArrayList<FFmpegCommandUnit> mCmdQueue;
    public FFmpegCommandUnit mCurrentCommandUnit;
    public String mCurrentTaskUni;
    public boolean mIsFFmpegingCloseScreen;
    protected boolean mIsWorkThreadCallback;
    public int mLastTaskResult;
    protected long timeout;
    public ArrayList<String> tsFileList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            instance = null;
        }
    }

    FFmpeg(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.timeout = Long.MAX_VALUE;
        this.mIsWorkThreadCallback = false;
        this.mCmdQueue = new ArrayList<>();
        this.tsFileList = new ArrayList<>();
        this.mIsFFmpegingCloseScreen = false;
        this.mLastTaskResult = -9999;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        Util.setFileExecutable(new File(FFmpegFileUtils.getFFmpeg(applicationContext)));
    }

    private void detectMediaInfoVolume(String str, ExecuteBinResponseCallback executeBinResponseCallback) throws FFmpegCommandAlreadyRunningException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add(Argument.FILTER_COMPLEX);
        arrayList.add("volumedetect");
        arrayList.add("-c:v");
        arrayList.add("copy");
        arrayList.add("-f");
        arrayList.add("null");
        arrayList.add("/dev/null");
        execute((String[]) arrayList.toArray(new String[0]), executeBinResponseCallback);
    }

    private void getAudioFromMP4(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add("-vn");
        arrayList.add(Argument.AUDIO_CODEC);
        arrayList.add("copy");
        arrayList.add(str2);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public static FFmpeg getInstance(Context context) {
        return getInstance(context, false);
    }

    private void getVideoFromMP4(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add("-an");
        arrayList.add(Argument.VIDEO_CODEC);
        arrayList.add("copy");
        arrayList.add(str2);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    private void mixAudio(String str, String str2, String str3, float f16, float f17, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException {
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str2);
        arrayList.add(Argument.FILTER_COMPLEX);
        arrayList.add("[0:a]volume=" + f16 + "[a0];[1:a]volume=" + f17 + "[a1];[a0][a1]amix=inputs=2:duration=first:dropout_transition=3");
        arrayList.add("-strict");
        arrayList.add("-2");
        arrayList.add("-vn");
        arrayList.add(str3);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public static FFmpeg newInstance(Context context, boolean z16) {
        FFmpeg fFmpeg = new FFmpeg(context);
        fFmpeg.mIsWorkThreadCallback = z16;
        return fFmpeg;
    }

    private String parseCmdStringByMillSecond(int i3) {
        return String.format("%02d:%02d:%02d.%03d", Integer.valueOf((int) Math.floor(i3 / 3600000)), Integer.valueOf(((int) Math.floor(i3 % 3600000)) / 60000), Integer.valueOf((int) Math.floor((i3 % 60000) / 1000)), Integer.valueOf((int) Math.floor(i3 % 1000)));
    }

    public void changeOrientationInVideo(String str, String str2, String str3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, str3, fFmpegExecuteResponseCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add("-metadata:s:v");
        arrayList.add("rotate=" + str2);
        arrayList.add("-codec");
        arrayList.add("copy");
        arrayList.add(new File(str3).getCanonicalPath());
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void changeOrientationInVideoByTranspose(String str, String str2, String str3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, str3, fFmpegExecuteResponseCallback);
            return;
        }
        int intValue = Integer.valueOf(str2).intValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add("-vf");
        int i3 = intValue % 360;
        if (i3 != 0) {
            if (i3 != 90) {
                if (i3 != 180) {
                    if (i3 != 270) {
                        c.v(TAG, "unSupport orientation:%s", str2);
                        return;
                    }
                    arrayList.add("transpose=1,transpose=1,transpose=1");
                } else {
                    arrayList.add("transpose=1,transpose=1");
                }
            } else {
                arrayList.add("transpose=1");
            }
            if (VideoEnvironment.isAvcodecNewVersion()) {
                arrayList.add("-c:v");
                arrayList.add("libo264rt");
                arrayList.add("-o264rt_params");
                arrayList.add("RCMode=-1:MinQp=22:MaxQp=22");
            }
            arrayList.add("-c:a");
            arrayList.add("copy");
            arrayList.add(new File(str3).getCanonicalPath());
            execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
            return;
        }
        c.a(TAG, "no need rotate.");
    }

    public boolean checkSameTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str)).booleanValue();
        }
        String str2 = this.mCurrentTaskUni;
        if (str2 != null && str != null && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public void clipAudio(String str, String str2, int i3, int i16, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), fFmpegExecuteResponseCallback);
            return;
        }
        c.t(TAG, "clipAudio arguments: \n inAudio" + str + "\n outAudio:" + str2 + "\n start:" + i3 + "\n duration:" + i16);
        if (!d.k(str)) {
            c.g(TAG, "clipAudio but inAudio file is not exist");
            fFmpegExecuteResponseCallback.onFailure(String.valueOf(941001));
            fFmpegExecuteResponseCallback.onFinish(false);
            return;
        }
        String parseCmdStringByMillSecond = parseCmdStringByMillSecond(i3);
        String parseCmdStringByMillSecond2 = parseCmdStringByMillSecond(i16);
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add(Argument.START_TIME);
        arrayList.add(parseCmdStringByMillSecond);
        arrayList.add(Argument.DURATION);
        arrayList.add(parseCmdStringByMillSecond2);
        arrayList.add(Argument.AUDIO_CODEC);
        arrayList.add("copy");
        arrayList.add("-vn");
        arrayList.add(new File(str2).getCanonicalPath());
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void cmdFFmpegQueue(ArrayList<FFmpegCommandUnit> arrayList) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) arrayList);
            return;
        }
        this.mCmdQueue = arrayList;
        if (arrayList.size() <= 0) {
            return;
        }
        FFmpegCommandUnit remove = this.mCmdQueue.remove(0);
        ArrayList<Object> arrayList2 = remove.arguments;
        String[] strArr = remove.cmd;
        ExecuteBinResponseCallback executeBinResponseCallback = new ExecuteBinResponseCallback(remove.callback, strArr, this.mCmdQueue) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ String[] val$cmd;
            final /* synthetic */ ArrayList val$nextQueue;
            final /* synthetic */ FFmpegExecuteResponseCallback val$unitCallback;

            {
                this.val$unitCallback = r6;
                this.val$cmd = strArr;
                this.val$nextQueue = r8;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FFmpeg.this, r6, strArr, r8);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) str);
                } else {
                    c.g(FFmpeg.TAG, str);
                    this.val$unitCallback.onFailure(str);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFinish(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, z16);
                    return;
                }
                if (this.val$cmd == null) {
                    this.val$unitCallback.onFinish(z16);
                }
                if (z16) {
                    try {
                        FFmpeg.this.cmdFFmpegQueue(this.val$nextQueue);
                    } catch (FFmpegCommandAlreadyRunningException e16) {
                        this.val$unitCallback.onFailure(e16.getMessage());
                        c.g(FFmpeg.TAG, e16.getMessage());
                    } catch (IOException e17) {
                        this.val$unitCallback.onFailure(e17.getMessage());
                        c.g(FFmpeg.TAG, e17.getMessage());
                    }
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onProgress(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                } else {
                    this.val$unitCallback.onProgress(str);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    this.val$unitCallback.onStart();
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                } else {
                    this.val$unitCallback.onSuccess(str);
                }
            }
        };
        if (strArr != null) {
            execute(strArr, executeBinResponseCallback);
            return;
        }
        switch (remove.cmdType) {
            case 1:
                watermark((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), ((Integer) arrayList2.get(3)).intValue(), ((Integer) arrayList2.get(4)).intValue(), executeBinResponseCallback);
                return;
            case 2:
                concatMedia((List) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback, ((Boolean) arrayList2.get(2)).booleanValue());
                return;
            case 3:
                clipAudio((String) arrayList2.get(0), (String) arrayList2.get(1), ((Integer) arrayList2.get(2)).intValue(), ((Integer) arrayList2.get(3)).intValue(), executeBinResponseCallback);
                return;
            case 4:
                combineAudioAndVideo((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), (String) arrayList2.get(3), ((Boolean) arrayList2.get(4)).booleanValue(), ((Integer) arrayList2.get(5)).intValue(), executeBinResponseCallback);
                return;
            case 5:
                mp4Tots((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 6:
                concatTsOutput((List) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 7:
                concatMediaByTs((List) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 8:
                concatDifferentCodingMedia((List) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 9:
                convertPicToVideo((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 10:
                hflip((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 11:
                compressVideo((String) arrayList2.get(0), ((Integer) arrayList2.get(1)).intValue(), ((Integer) arrayList2.get(2)).intValue(), ((Integer) arrayList2.get(3)).intValue(), ((Boolean) arrayList2.get(4)).booleanValue(), (String) arrayList2.get(5), executeBinResponseCallback);
                return;
            case 12:
                changeOrientationInVideoByTranspose((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), executeBinResponseCallback);
                return;
            case 13:
                setTimestamp((String) arrayList2.get(0), (String) arrayList2.get(1), ((Integer) arrayList2.get(2)).intValue(), executeBinResponseCallback);
                return;
            case 14:
                emptyFFmengCmd((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 15:
                combineDoodle((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), executeBinResponseCallback);
                return;
            case 16:
                convertMp4ToMp3((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 17:
                mixAudio((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), ((Float) arrayList2.get(3)).floatValue(), ((Float) arrayList2.get(4)).floatValue(), executeBinResponseCallback);
                return;
            case 18:
                getAudioFromMP4((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 19:
                getVideoFromMP4((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 20:
                convertPicToVideoWithTime((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), executeBinResponseCallback);
                return;
            case 21:
                transcodeM4a((String) arrayList2.get(0), (String) arrayList2.get(1), executeBinResponseCallback);
                return;
            case 22:
                detectMediaInfoVolume((String) arrayList2.get(0), executeBinResponseCallback);
                return;
            default:
                return;
        }
    }

    public Clip combineAudioAndVideo(String str, String str2, String str3, String str4, boolean z16, int i3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Clip) iPatchRedirector.redirect((short) 23, this, str, str2, str3, str4, Boolean.valueOf(z16), Integer.valueOf(i3), fFmpegExecuteResponseCallback);
        }
        Clip clip = new Clip(str4);
        clip.videoCodec = str3;
        return combineAudioAndVideo(str, str2, z16, clip, i3, fFmpegExecuteResponseCallback);
    }

    public void combineDoodle(String str, String str2, String str3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, str2, str3, fFmpegExecuteResponseCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str2);
        if (VideoEnvironment.isAvcodecNewVersion()) {
            arrayList.add("-c:v");
            arrayList.add("libo264rt");
        }
        arrayList.add(Argument.FILTER_COMPLEX);
        arrayList.add("[1:v]scale=iw:ih[s];[0:v][s]overlay=0:0");
        arrayList.add(str3);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void compressVideo(String str, int i3, int i16, int i17, boolean z16, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        int i18;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), str2, fFmpegExecuteResponseCallback);
            return;
        }
        int[] p16 = d.p(str);
        if (p16 == null) {
            fFmpegExecuteResponseCallback.onFailure(MESSAGE_INPUT_NULL);
            fFmpegExecuteResponseCallback.onFinish(false);
            c.g(TAG, "compressVideo input path is null");
            return;
        }
        int i27 = p16[1];
        int i28 = p16[2];
        if (i27 <= 960 && i28 <= 960) {
            i26 = -1;
            i18 = -1;
        } else {
            if (i28 < i27) {
                i19 = (i27 * 540) / i28;
                i18 = 540;
            } else {
                i18 = i28;
                i19 = i27;
            }
            if (i27 <= i28) {
                i18 = (i28 * 540) / i27;
                i26 = 540;
            } else {
                i26 = i19;
            }
            if (i18 % 2 != 0) {
                i18++;
            }
            if (i26 % 2 != 0) {
                i26++;
            }
        }
        long o16 = d.o(str);
        if (o16 != -1 && o16 < 2202009.6d) {
            z17 = false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        if (i16 != 0) {
            arrayList.add(Argument.START_TIME);
            arrayList.add(String.valueOf(i3 / 1000) + "." + String.valueOf(i3 % 1000));
            arrayList.add("-accurate_seek");
        }
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        if (i16 != 0) {
            arrayList.add(Argument.DURATION);
            arrayList.add(String.valueOf(i16 / 1000) + "." + String.valueOf(i16 % 1000));
        }
        if (i26 > 0 && i18 > 0) {
            arrayList.add("-vf");
            arrayList.add("scale=" + i26 + ":" + i18);
        }
        if (z16) {
            arrayList.add("-an");
        } else {
            arrayList.add(Argument.AUDIO_CODEC);
            arrayList.add(FileReaderHelper.AAC_EXT);
        }
        arrayList.add(Argument.VIDEO_CODEC);
        if (VideoEnvironment.isAvcodecNewVersion()) {
            arrayList.add("libo264rt");
        } else {
            arrayList.add(VideoConverterConfig.SoftwareConfig.ENCODER_X264);
        }
        if (z17) {
            arrayList.add(Argument.BITRATE_VIDEO);
            arrayList.add("" + i17);
        }
        arrayList.add("-bufsize");
        arrayList.add("800k");
        arrayList.add("-r");
        arrayList.add("25");
        arrayList.add("-metadata");
        arrayList.add("title=" + System.currentTimeMillis());
        arrayList.add("-movflags");
        arrayList.add("faststart");
        arrayList.add(new File(str2).getCanonicalPath());
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void concatDifferentCodingMedia(List<String> list, String str, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, str, fFmpegExecuteResponseCallback);
            return;
        }
        c.t(TAG, "concatDifferentCodingMedia arguments: \n inMedias:" + list + "\n outMedia:" + str);
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(Argument.FILE_INPUT);
            arrayList.add(new File(list.get(i3)).getCanonicalPath());
            sb5.append("[" + i3 + ":0]");
            sb5.append(" ");
            sb5.append("[" + i3 + ":1]");
            sb5.append(" ");
        }
        sb5.append("concat=n=" + list.size() + ":v=1:a=1 [v] [a]");
        arrayList.add(Argument.FILTER_COMPLEX);
        arrayList.add(sb5.toString());
        arrayList.add("-map");
        arrayList.add("[v]");
        arrayList.add("-map");
        arrayList.add("[a]");
        arrayList.add(new File(str).getCanonicalPath());
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void concatMedia(List<String> list, String str, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback, boolean z16) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, str, fFmpegExecuteResponseCallback, Boolean.valueOf(z16));
            return;
        }
        c.t(TAG, "concatMedia arguments: \n inMedias:" + list + "\n outMedia:" + str);
        new File(str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a.f441371k);
        sb5.append("temp.txt");
        File file = new File(sb5.toString());
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
            for (int i3 = 0; i3 < list.size(); i3++) {
                try {
                    bufferedWriter2.write("file '" + new File(list.get(i3)).getCanonicalPath() + "'");
                    bufferedWriter2.newLine();
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    throw th;
                }
            }
            bufferedWriter2.flush();
            bufferedWriter2.close();
            ArrayList arrayList = new ArrayList();
            arrayList.add("-y");
            arrayList.add("-f");
            arrayList.add(Argument.CONCAT);
            arrayList.add(Argument.FILE_INPUT);
            arrayList.add(file.getCanonicalPath());
            if (z16) {
                arrayList.add("-c:v");
                if (VideoEnvironment.isAvcodecNewVersion()) {
                    arrayList.add("libo264rt");
                } else {
                    arrayList.add(VideoConverterConfig.SoftwareConfig.ENCODER_X264);
                }
                arrayList.add("-bsf:a");
                arrayList.add("aac_adtstoasc");
            } else {
                arrayList.add(LogCmdOptions.CLEAR);
                arrayList.add("copy");
            }
            arrayList.add(new File(str).getCanonicalPath());
            execute((String[]) arrayList.toArray(new String[0]), new ExecuteBinResponseCallback(fFmpegExecuteResponseCallback, file) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ FFmpegExecuteResponseCallback val$callback;
                final /* synthetic */ File val$tempFile;

                {
                    this.val$callback = fFmpegExecuteResponseCallback;
                    this.val$tempFile = file;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FFmpeg.this, fFmpegExecuteResponseCallback, file);
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onFailure(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                        iPatchRedirector2.redirect((short) 6, (Object) this, (Object) str2);
                    } else {
                        this.val$callback.onFailure(str2);
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onFinish(boolean z17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, z17);
                        return;
                    }
                    if (this.val$tempFile.exists()) {
                        this.val$tempFile.delete();
                    }
                    for (int i16 = 0; i16 < FFmpeg.this.tsFileList.size(); i16++) {
                        File file2 = new File(FFmpeg.this.tsFileList.get(i16));
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                    FFmpeg.this.tsFileList = new ArrayList<>();
                    this.val$callback.onFinish(z17);
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onProgress(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) str2);
                    } else {
                        this.val$callback.onProgress(str2);
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onStart() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onSuccess(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str2);
                    } else {
                        this.val$callback.onSuccess(str2);
                    }
                }
            });
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void concatMediaByTs(List<String> list, String str, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, str, fFmpegExecuteResponseCallback);
            return;
        }
        c.t(TAG, "concatMediaByTs arguments: \n inMedias:" + list + "\n outMedia:" + str);
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str2 = list.get(i3);
            String str3 = a.f441371k + new File(str2).getName().split("\\.")[0] + ".ts";
            File file = new File(str3);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
            fFmpegCommandUnit.cmdType = 5;
            fFmpegCommandUnit.arguments = new ArrayList<Object>(str2, str3) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$inputPath;
                final /* synthetic */ String val$tsFilePath;

                {
                    this.val$inputPath = str2;
                    this.val$tsFilePath = str3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FFmpeg.this, str2, str3);
                    } else {
                        add(str2);
                        add(str3);
                    }
                }
            };
            fFmpegCommandUnit.callback = new ExecuteBinResponseCallback(fFmpegExecuteResponseCallback) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ FFmpegExecuteResponseCallback val$endCallback;

                {
                    this.val$endCallback = fFmpegExecuteResponseCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FFmpeg.this, (Object) fFmpegExecuteResponseCallback);
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onFailure(String str4) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str4);
                        return;
                    }
                    c.t(FFmpeg.TAG, "concatMediaByTs change ts onFail: " + str4);
                    this.val$endCallback.onFailure(str4);
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onSuccess(String str4) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str4);
                        return;
                    }
                    c.t(FFmpeg.TAG, "concatMediaByTs change ts onSuccess: " + str4);
                }
            };
            arrayList.add(fFmpegCommandUnit);
        }
        FFmpegCommandUnit fFmpegCommandUnit2 = new FFmpegCommandUnit();
        ArrayList<String> arrayList2 = this.tsFileList;
        fFmpegCommandUnit2.cmdType = 2;
        fFmpegCommandUnit2.arguments = new ArrayList<Object>(arrayList2, str) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$outMedia;
            final /* synthetic */ ArrayList val$tsList;

            {
                this.val$tsList = arrayList2;
                this.val$outMedia = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FFmpeg.this, arrayList2, str);
                    return;
                }
                add(arrayList2);
                add(str);
                add(Boolean.TRUE);
            }
        };
        fFmpegCommandUnit2.callback = fFmpegExecuteResponseCallback;
        arrayList.add(fFmpegCommandUnit2);
        cmdFFmpegQueue(arrayList);
    }

    public void concatTsOutput(List<String> list, String str, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, str, fFmpegExecuteResponseCallback);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"concat:");
        for (int i3 = 0; i3 < list.size(); i3++) {
            stringBuffer.append(list.get(i3));
            if (i3 != list.size() - 1) {
                stringBuffer.append("|");
            }
        }
        stringBuffer.append("\"");
        this.tsFileList = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new String(stringBuffer));
        arrayList.add(LogCmdOptions.CLEAR);
        arrayList.add("copy");
        arrayList.add("-bsf:a");
        arrayList.add("aac_adtstoasc");
        arrayList.add(str);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void convertMp4ToMp3(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, fFmpegExecuteResponseCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add("-vn");
        arrayList.add("-c:a");
        arrayList.add("copy");
        arrayList.add(new File(str2).getCanonicalPath());
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c.v(TAG, "extractAudioFromMp4 args: %s", Arrays.toString(strArr));
        execute(strArr, fFmpegExecuteResponseCallback);
    }

    public void convertPicToVideo(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, fFmpegExecuteResponseCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add("-analyzeduration");
        arrayList.add("2147483647");
        arrayList.add("-probesize");
        arrayList.add("2147483647");
        arrayList.add("-framerate");
        arrayList.add("1/3");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        if (VideoEnvironment.isAvcodecNewVersion()) {
            arrayList.add("-vf");
            arrayList.add("scale='min(1920,iw)':min'(1920,ih)':force_original_aspect_ratio=decrease");
            arrayList.add("-c:v");
            arrayList.add("libo264rt");
        } else {
            arrayList.add(Argument.VIDEO_CODEC);
            arrayList.add(VideoConverterConfig.SoftwareConfig.ENCODER_X264);
            arrayList.add("-preset");
            arrayList.add("veryslow");
        }
        arrayList.add("-bufsize");
        arrayList.add("800k");
        arrayList.add("-metadata");
        arrayList.add("title=" + System.currentTimeMillis());
        arrayList.add("-movflags");
        arrayList.add("faststart");
        arrayList.add("-r");
        arrayList.add("25");
        arrayList.add(new File(str2).getCanonicalPath());
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c.v(TAG, "convertPicToVideo args: %s", Arrays.toString(strArr));
        execute(strArr, fFmpegExecuteResponseCallback);
    }

    public void convertPicToVideoWithTime(String str, String str2, String str3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, str3, fFmpegExecuteResponseCallback);
            return;
        }
        boolean isAvcodecNewVersion = VideoEnvironment.isAvcodecNewVersion();
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add("-analyzeduration");
        arrayList.add("2147483647");
        arrayList.add("-probesize");
        arrayList.add("2147483647");
        arrayList.add("-framerate");
        arrayList.add("1/3");
        arrayList.add("-loop");
        arrayList.add("1");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        if (isAvcodecNewVersion) {
            arrayList.add("-vf");
            arrayList.add("scale='min(1920,iw)':min'(1920,ih)':force_original_aspect_ratio=decrease");
            arrayList.add("-c:v");
            arrayList.add("libo264rt");
        } else {
            arrayList.add(Argument.VIDEO_CODEC);
            arrayList.add(VideoConverterConfig.SoftwareConfig.ENCODER_X264);
        }
        arrayList.add("-pix_fmt");
        arrayList.add("yuv420p");
        arrayList.add(Argument.DURATION);
        arrayList.add(str3);
        if (!isAvcodecNewVersion) {
            arrayList.add("-preset");
            arrayList.add("veryslow");
        }
        arrayList.add("-bufsize");
        arrayList.add("800k");
        arrayList.add("-metadata");
        arrayList.add("title=" + System.currentTimeMillis());
        arrayList.add("-movflags");
        arrayList.add("faststart");
        arrayList.add("-r");
        arrayList.add("25");
        arrayList.add(new File(str2).getCanonicalPath());
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c.v(TAG, "convertPicToVideoWithTime args: %s", Arrays.toString(strArr));
        execute(strArr, fFmpegExecuteResponseCallback);
    }

    public void emptyFFmengCmd(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, fFmpegExecuteResponseCallback);
            return;
        }
        c.t(TAG, "fake ffmeng command. arguments: \n inMedia:" + str + "\n outMedia:" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            boolean x16 = d.x(this.context, str, str2);
            if (x16) {
                fFmpegExecuteResponseCallback.onSuccess(MESSAGE_COPY_CMD_SUCCESS);
            } else {
                fFmpegExecuteResponseCallback.onFailure(MESSAGE_COPY_CMD_FAIL);
            }
            fFmpegExecuteResponseCallback.onFinish(x16);
            c.t(TAG, "copy video to album result is " + x16);
            return;
        }
        fFmpegExecuteResponseCallback.onFailure(MESSAGE_INPUT_NULL);
        c.g(TAG, "fake ffmeng command. input path is null");
        fFmpegExecuteResponseCallback.onFinish(false);
    }

    public void execute(String[] strArr, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr, (Object) fFmpegExecuteResponseCallback);
            return;
        }
        FFmpegExecuteAsyncTask fFmpegExecuteAsyncTask = this.ffmpegExecuteAsyncTask;
        if (fFmpegExecuteAsyncTask != null && !fFmpegExecuteAsyncTask.isProcessCompleted()) {
            c.g(TAG, "FFmpeg command is already running");
            throw new FFmpegCommandAlreadyRunningException("FFmpeg command is already running, you are only allowed to run single command at a time");
        }
        if (strArr.length != 0) {
            String str = strArr[strArr.length - 1];
            this.mCurrentCommandUnit = new FFmpegCommandUnit(strArr, str, fFmpegExecuteResponseCallback);
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > -1 && lastIndexOf < str.length() - 1) {
                File file = new File(str.substring(0, lastIndexOf + 1));
                if (!file.exists()) {
                    file.mkdir();
                }
            }
            ExecuteBinResponseCallback executeBinResponseCallback = new ExecuteBinResponseCallback(fFmpegExecuteResponseCallback) { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ FFmpegExecuteResponseCallback val$callback;

                {
                    this.val$callback = fFmpegExecuteResponseCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FFmpeg.this, (Object) fFmpegExecuteResponseCallback);
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onFailure(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                        iPatchRedirector2.redirect((short) 6, (Object) this, (Object) str2);
                    } else {
                        this.val$callback.onFailure(str2);
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onFinish(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    if (FFmpeg.this.mCmdQueue.size() == 0) {
                        FFmpeg.this.mLastTaskResult = z16 ? 1 : 0;
                        FFmpeg.instance = null;
                    }
                    this.val$callback.onFinish(z16);
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onProgress(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) str2);
                    } else {
                        this.val$callback.onProgress(str2);
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onStart() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    } else {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
                public void onSuccess(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str2);
                    } else {
                        this.val$callback.onSuccess(str2);
                    }
                }
            };
            String[] strArr2 = (String[]) Util.concatenate((String[]) Util.concatenate(new String[]{FFmpegFileUtils.getFFmpeg(this.context)}, strArr), new String[]{FFmpegFileUtils.getAVCodecSoFilePath(this.context)});
            FFmpegExecuteAsyncTask fFmpegExecuteAsyncTask2 = new FFmpegExecuteAsyncTask(this.context, strArr2, this.timeout, this.mIsWorkThreadCallback, executeBinResponseCallback);
            this.ffmpegExecuteAsyncTask = fFmpegExecuteAsyncTask2;
            fFmpegExecuteAsyncTask2.execute(new Void[0]);
            c.t(TAG, "command execute: " + TextUtils.join(" ", strArr2));
            return;
        }
        throw new IllegalArgumentException("shell command cannot be empty");
    }

    public void hflip(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, str2, fFmpegExecuteResponseCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add("-vf");
        arrayList.add("transpose=1");
        if (VideoEnvironment.isAvcodecNewVersion()) {
            arrayList.add("-c:v");
            arrayList.add("libo264rt");
        }
        arrayList.add("-metadata:s:v");
        arrayList.add("rotate=0");
        arrayList.add(str2);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void insertFFmpegQueue(ArrayList<FFmpegCommandUnit> arrayList) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) arrayList);
            return;
        }
        killRunningProcesses(false);
        c.t(TAG, "[insertFFmpegQueue][old] " + TextUtils.join(" ", arrayList.toArray()));
        FFmpegCommandUnit fFmpegCommandUnit = this.mCurrentCommandUnit;
        if (fFmpegCommandUnit != null) {
            this.mCmdQueue.add(0, fFmpegCommandUnit);
        }
        this.mCmdQueue.addAll(0, arrayList);
        cmdFFmpegQueue(this.mCmdQueue);
        c.t(TAG, "[insertFFmpegQueue][new] " + TextUtils.join(" ", arrayList.toArray()));
    }

    public boolean isFFmpegCommandRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        FFmpegExecuteAsyncTask fFmpegExecuteAsyncTask = this.ffmpegExecuteAsyncTask;
        if (fFmpegExecuteAsyncTask != null && !fFmpegExecuteAsyncTask.isProcessCompleted()) {
            return true;
        }
        return false;
    }

    public void killRunningProcesses(boolean z16) {
        FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        FFmpegExecuteAsyncTask fFmpegExecuteAsyncTask = this.ffmpegExecuteAsyncTask;
        if (fFmpegExecuteAsyncTask != null && !fFmpegExecuteAsyncTask.isProcessCompleted()) {
            Util.killFFmpegProcess(this.ffmpegExecuteAsyncTask);
            this.ffmpegExecuteAsyncTask = null;
            this.mLastTaskResult = -9999;
            FFmpegCommandUnit fFmpegCommandUnit = this.mCurrentCommandUnit;
            if (fFmpegCommandUnit != null) {
                if (fFmpegCommandUnit.output != null) {
                    File file = new File(this.mCurrentCommandUnit.output);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                if (z16 && (fFmpegExecuteResponseCallback = this.mCurrentCommandUnit.callback) != null) {
                    fFmpegExecuteResponseCallback.onFailure("FFmpeg\u4efb\u52a1\u88ab\u5f3a\u5236Kill\u6389");
                    this.mCurrentCommandUnit.callback.onFinish(false);
                    c.t(TAG, "FFmpeg\u4efb\u52a1\u88ab\u5f3a\u5236Kill\u6389");
                }
            }
            c.a(TAG, "KillFFmpeg!");
        }
    }

    public void killRunningProcessesForShortVideo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        FFmpegExecuteAsyncTask fFmpegExecuteAsyncTask = this.ffmpegExecuteAsyncTask;
        if (fFmpegExecuteAsyncTask != null && !fFmpegExecuteAsyncTask.isProcessCompleted()) {
            Util.killFFmpegProcess(this.ffmpegExecuteAsyncTask);
            this.ffmpegExecuteAsyncTask = null;
            this.mLastTaskResult = -9999;
            FFmpegCommandUnit fFmpegCommandUnit = this.mCurrentCommandUnit;
            if (fFmpegCommandUnit != null) {
                if (fFmpegCommandUnit.output != null) {
                    File file = new File(this.mCurrentCommandUnit.output);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback = this.mCurrentCommandUnit.callback;
                if (fFmpegExecuteResponseCallback != null) {
                    fFmpegExecuteResponseCallback.onFailure("FFmpeg\u4efb\u52a1\u88ab\u5f3a\u5236Kill\u6389");
                    this.mCurrentCommandUnit.callback.onFinish(false);
                    c.t(TAG, "FFmpeg\u4efb\u52a1\u88ab\u5f3a\u5236Kill\u6389");
                }
            }
            c.a(TAG, "KillFFmpeg!");
        }
    }

    public void mp4Tots(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, fFmpegExecuteResponseCallback);
            return;
        }
        c.t(TAG, "mp4Tots arguments: \n input:" + str + "\n outputPath:" + str2);
        this.tsFileList.add(str2);
        if (d.k(str2)) {
            fFmpegExecuteResponseCallback.onSuccess(MESSAGE_TS_DONE);
            fFmpegExecuteResponseCallback.onFinish(true);
            c.t(TAG, MESSAGE_TS_DONE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add(LogCmdOptions.CLEAR);
        arrayList.add("copy");
        arrayList.add("-bsf:v");
        arrayList.add("h264_mp4toannexb");
        arrayList.add("-f");
        arrayList.add("mpegts");
        arrayList.add(str2);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void setCurrentTaskUni(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.mCurrentTaskUni = str;
        }
    }

    public void setFFMpegCanExe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            Util.setFileExecutable(new File(FFmpegFileUtils.getFFmpeg(this.context)));
        }
    }

    public void setTimestamp(String str, String str2, int i3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3), fFmpegExecuteResponseCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        arrayList.add("-metadata");
        arrayList.add("title=" + System.currentTimeMillis());
        arrayList.add("-metadata");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("comment=");
        sb5.append("dev=" + ah.s() + "/os=" + ah.t() + "/appVer=" + AppSetting.d());
        arrayList.add(sb5.toString());
        if (i3 != -1) {
            arrayList.add("-metadata:s:v:0");
            arrayList.add("rotate=" + i3);
        }
        arrayList.add("-movflags");
        arrayList.add("faststart");
        arrayList.add("-codec");
        arrayList.add("copy");
        arrayList.add(new File(str2).getCanonicalPath());
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void transcodeM4a(String str, String str2, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws IOException, FFmpegCommandAlreadyRunningException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, fFmpegExecuteResponseCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add("-ab");
        arrayList.add("96k");
        arrayList.add(Argument.FREQ_AUDIO);
        arrayList.add("44100");
        arrayList.add(Argument.CHANNELS_AUDIO);
        arrayList.add("1");
        arrayList.add("-vn");
        arrayList.add(Argument.AUDIO_CODEC);
        arrayList.add(FileReaderHelper.AAC_EXT);
        arrayList.add(str2);
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void watermark(String str, String str2, String str3, boolean z16, int i3, int i16, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        boolean f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), fFmpegExecuteResponseCallback);
            return;
        }
        c.t(TAG, "watermark arguments: \n inImage" + str + "\n inMedia:" + str2 + "\n outMedia:" + str3 + "\n videoWidth:" + i3 + "\n videoHeight:" + i16);
        if (str2 == null || str3 == null) {
            fFmpegExecuteResponseCallback.onFailure(MESSAGE_INPUT_NULL);
            fFmpegExecuteResponseCallback.onFinish(false);
            c.t(TAG, "watermark input path is null");
            return;
        }
        if (str == null) {
            if (z16) {
                f16 = d.x(this.context, str2, str3);
            } else {
                f16 = d.f(str2, str3);
            }
            if (f16) {
                fFmpegExecuteResponseCallback.onSuccess(MESSAGE_COPY_CMD_SUCCESS);
            } else {
                fFmpegExecuteResponseCallback.onFailure(MESSAGE_COPY_CMD_FAIL);
            }
            fFmpegExecuteResponseCallback.onFinish(f16);
            c.t(TAG, "watermark inImage == null, copy to" + str3 + " result is " + f16);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str2).getCanonicalPath());
        arrayList.add("-vf");
        arrayList.add("movie=" + str + " [watermark]; [watermark]scale=" + i3 + ":" + i16 + " [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out] ");
        if (VideoEnvironment.isAvcodecNewVersion()) {
            arrayList.add("-c:v");
            arrayList.add("libo264rt");
        }
        arrayList.add("-max_muxing_queue_size");
        arrayList.add("9999");
        arrayList.add(new File(str3).getCanonicalPath());
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
    }

    public void watermarkWithRotation(String str, String str2, String str3, int i3, int i16, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), fFmpegExecuteResponseCallback);
            return;
        }
        c.t(TAG, "watermarkWithRotation arguments: \n inImage" + str + "\n inMedia:" + str2 + "\n outMedia:" + str3 + "\n videoWidth:" + i3 + "\n videoHeight:" + i16);
        if (str2 != null && str3 != null) {
            if (str == null) {
                boolean x16 = d.x(this.context, str2, str3);
                if (x16) {
                    fFmpegExecuteResponseCallback.onSuccess(MESSAGE_COPY_CMD_SUCCESS);
                } else {
                    fFmpegExecuteResponseCallback.onFailure(MESSAGE_COPY_CMD_FAIL);
                }
                fFmpegExecuteResponseCallback.onFinish(x16);
                c.t(TAG, "watermarkWithRotation inImage == null, copy to DCIM result is " + x16);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("-y");
            arrayList.add(Argument.FILE_INPUT);
            arrayList.add(new File(str2).getCanonicalPath());
            arrayList.add("-vf");
            arrayList.add("[in]transpose=1 [in]; movie=" + str + " [watermark]; [watermark]scale=" + i3 + ":" + i16 + " [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out]");
            if (VideoEnvironment.isAvcodecNewVersion()) {
                arrayList.add("-c:v");
                arrayList.add("libo264rt");
            }
            arrayList.add("-metadata:s:v");
            arrayList.add("rotate=0");
            arrayList.add(new File(str3).getCanonicalPath());
            execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
            return;
        }
        fFmpegExecuteResponseCallback.onFailure(MESSAGE_INPUT_NULL);
        c.t(TAG, "watermarkWithRotation input path is null");
        fFmpegExecuteResponseCallback.onFinish(false);
    }

    public static FFmpeg getInstance(Context context, boolean z16) {
        if (instance == null) {
            synchronized (FFmpeg.class) {
                if (instance == null) {
                    instance = new FFmpeg(context);
                }
            }
        }
        instance.mIsWorkThreadCallback = z16;
        return instance;
    }

    public Clip combineAudioAndVideo(String str, String str2, boolean z16, Clip clip, int i3, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Clip) iPatchRedirector.redirect((short) 24, this, str, str2, Boolean.valueOf(z16), clip, Integer.valueOf(i3), fFmpegExecuteResponseCallback);
        }
        c.t(TAG, "combineAudioAndVideo arguments: \n inVideo" + str + "\n inAudio:" + str2 + "\n outMedia:" + clip);
        if (!d.k(str)) {
            c.g(TAG, "clipAudio but inVideo file is not exist");
            fFmpegExecuteResponseCallback.onFailure(String.valueOf(941002));
            fFmpegExecuteResponseCallback.onFinish(false);
            return clip;
        }
        if (!d.k(str2)) {
            c.g(TAG, "clipAudio but inAudio file is not exist");
            fFmpegExecuteResponseCallback.onFailure(String.valueOf(941002));
            fFmpegExecuteResponseCallback.onFinish(false);
            return clip;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(new File(str).getCanonicalPath());
        if (z16) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str2);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            long j3 = i3;
            try {
                j3 = Long.parseLong(extractMetadata);
            } catch (Exception unused) {
            }
            int ceil = (int) Math.ceil(i3 / ((float) j3));
            if (ceil > 1) {
                String canonicalPath = new File(str2).getCanonicalPath();
                String str3 = new File(str2).getParent() + "/catAudioFile.txt";
                StringBuilder sb5 = new StringBuilder();
                for (int i16 = 0; i16 < ceil; i16++) {
                    if (i16 > 0) {
                        sb5.append("\n");
                    }
                    sb5.append("file '");
                    sb5.append(canonicalPath);
                    sb5.append("'");
                }
                FileUtils.writeFile(str3, sb5.toString());
                arrayList.add("-f");
                arrayList.add(Argument.CONCAT);
                arrayList.add("-safe");
                arrayList.add("0");
                arrayList.add(Argument.FILE_INPUT);
                arrayList.add(str3);
            } else {
                arrayList.add(Argument.FILE_INPUT);
                arrayList.add(new File(str2).getCanonicalPath());
            }
        } else {
            arrayList.add(Argument.FILE_INPUT);
            arrayList.add(new File(str2).getCanonicalPath());
        }
        arrayList.add("-map_chapters");
        arrayList.add("-1");
        arrayList.add("-strict");
        arrayList.add("-2");
        arrayList.add(Argument.VIDEO_CODEC);
        String str4 = clip.videoCodec;
        if (str4 != null) {
            arrayList.add(str4);
        } else {
            arrayList.add("copy");
        }
        arrayList.add(Argument.AUDIO_CODEC);
        String str5 = clip.audioCodec;
        if (str5 != null) {
            arrayList.add(str5);
        } else {
            arrayList.add(FileReaderHelper.AAC_EXT);
        }
        FFmpegUtils.getAuidoType(str2);
        arrayList.add("-bsf:a");
        arrayList.add("aac_adtstoasc");
        if (clip.videoBitrate != -1) {
            arrayList.add(Argument.BITRATE_VIDEO);
            arrayList.add(clip.videoBitrate + "k");
        }
        if (clip.videoFps != null) {
            arrayList.add("-r");
            arrayList.add(clip.videoFps);
        }
        if (clip.audioBitrate != -1) {
            arrayList.add(Argument.BITRATE_AUDIO);
            arrayList.add(clip.audioBitrate + "k");
        }
        if (clip.width > 0) {
            arrayList.add("-s");
            arrayList.add(clip.width + HippyTKDListViewAdapter.X + clip.height);
        }
        if (clip.format != null) {
            arrayList.add("-f");
            arrayList.add(clip.format);
        }
        File file = new File(clip.path);
        if (z16) {
            arrayList.add("-shortest");
        }
        arrayList.add(file.getCanonicalPath());
        execute((String[]) arrayList.toArray(new String[0]), fFmpegExecuteResponseCallback);
        return clip;
    }

    public void watermark(String str, String str2, String str3, int i3, int i16, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) throws FFmpegCommandAlreadyRunningException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            watermark(str, str2, str3, true, i3, i16, fFmpegExecuteResponseCallback);
        } else {
            iPatchRedirector.redirect((short) 19, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), fFmpegExecuteResponseCallback);
        }
    }
}

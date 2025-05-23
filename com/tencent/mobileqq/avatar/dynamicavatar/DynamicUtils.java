package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.g;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.xweb.FileReaderHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DynamicUtils {
    static IPatchRedirector $redirector_;

    public static int a(String str, String str2, int i3, Context context) {
        return b(str, str2, i3, context, 25);
    }

    public static int b(String str, String str2, int i3, Context context, int i16) {
        long currentTimeMillis = System.currentTimeMillis();
        if (ShortVideoTrimmer.initVideoTrim(context)) {
            VideoConverterConfig compressConfig = ShortVideoTrimmer.getCompressConfig(str);
            compressConfig.destWidth = i3;
            compressConfig.destHeight = i3;
            if (QLog.isColorLevel()) {
                QLog.i("DynamicUtils", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
            }
            int c16 = c(context, str, str2, i3, i16);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (c16 == 0) {
                long length = new File(str).length();
                long length2 = new File(str2).length();
                if (QLog.isColorLevel()) {
                    QLog.i("DynamicUtils", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress ret = " + c16 + ", cost:" + currentTimeMillis2 + "ms, fileSourceSize=" + length + ", fileTargetSize=" + length2);
                    return c16;
                }
                return c16;
            }
            return c16;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v27, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(Context context, String str, String str2, int i3, int i16) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader3;
        BufferedReader bufferedReader3;
        long currentTimeMillis = System.currentTimeMillis();
        VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
        videoConverterConfig.destWidth = i3;
        videoConverterConfig.destHeight = i3;
        videoConverterConfig.rotate = "0";
        videoConverterConfig.destQmax = i16;
        String[] d16 = d(str, str2, videoConverterConfig);
        if (d16 == null) {
            h("[@] compressVideo :args == null");
        }
        ?? shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(context);
        ?? shortVideoSoLibName = VideoEnvironment.getShortVideoSoLibName();
        h("[@] compressVideo :soFullDir=" + shortVideoSoPath + "  soName=" + shortVideoSoLibName);
        ?? r26 = 0;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        r26 = 0;
        try {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
                processBuilder.redirectErrorStream(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(FFmpegFileUtils.getFFmpeg(context));
                h("[@] compressVideo :cmds[0]=" + arrayList.get(0));
                for (String str3 : d16) {
                    arrayList.add(str3);
                }
                ?? sb5 = new StringBuilder();
                sb5.append(shortVideoSoPath);
                sb5.append(shortVideoSoLibName);
                arrayList.add(sb5.toString());
                processBuilder.command(arrayList);
                h("[@] compressVideo :cmds[last]=" + arrayList.get(arrayList.size() - 1));
                Process start = processBuilder.start();
                InputStream inputStream4 = start.getInputStream();
                try {
                    shortVideoSoPath = new InputStreamReader(inputStream4);
                    try {
                        shortVideoSoLibName = new BufferedReader(shortVideoSoPath);
                        try {
                            start.waitFor();
                            r26 = start.exitValue();
                            h("[@] compressVideo :ret=" + r26);
                            while (true) {
                                String readLine = shortVideoSoLibName.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                h("[@] compressVideo log:" + readLine);
                            }
                            start.destroy();
                            h("[@] compressVideo destroy OK.");
                            if (inputStream4 != null) {
                                try {
                                    inputStream4.close();
                                } catch (IOException unused) {
                                }
                            }
                            shortVideoSoPath.close();
                            shortVideoSoLibName.close();
                        } catch (IOException e16) {
                            e = e16;
                            inputStream = inputStream4;
                            inputStreamReader3 = shortVideoSoPath;
                            bufferedReader3 = shortVideoSoLibName;
                            e.printStackTrace();
                            h("[@] compressVideo [IOException] exp=" + e.toString());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused2) {
                                    r26 = -1001;
                                    shortVideoSoPath = inputStreamReader3;
                                    shortVideoSoLibName = bufferedReader3;
                                    h("[@] compressVideo time cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, ret=" + r26);
                                    if (r26 != 0) {
                                    }
                                    return r26;
                                }
                            }
                            if (inputStreamReader3 != null) {
                                inputStreamReader3.close();
                            }
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                            r26 = -1001;
                            shortVideoSoPath = inputStreamReader3;
                            shortVideoSoLibName = bufferedReader3;
                            h("[@] compressVideo time cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, ret=" + r26);
                            if (r26 != 0) {
                            }
                            return r26;
                        } catch (InterruptedException e17) {
                            e = e17;
                            inputStream2 = inputStream4;
                            inputStreamReader2 = shortVideoSoPath;
                            bufferedReader2 = shortVideoSoLibName;
                            e.printStackTrace();
                            h("[@] compressVideo [InterruptedException] exp=" + e.toString());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException unused3) {
                                    r26 = -1002;
                                    shortVideoSoPath = inputStreamReader2;
                                    shortVideoSoLibName = bufferedReader2;
                                    h("[@] compressVideo time cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, ret=" + r26);
                                    if (r26 != 0) {
                                    }
                                    return r26;
                                }
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            r26 = -1002;
                            shortVideoSoPath = inputStreamReader2;
                            shortVideoSoLibName = bufferedReader2;
                            h("[@] compressVideo time cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, ret=" + r26);
                            if (r26 != 0) {
                            }
                            return r26;
                        } catch (Exception e18) {
                            e = e18;
                            inputStream3 = inputStream4;
                            inputStreamReader = shortVideoSoPath;
                            bufferedReader = shortVideoSoLibName;
                            e.printStackTrace();
                            h("[@] compressVideo [Exception] exp=" + e.toString());
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException unused4) {
                                    r26 = -1003;
                                    shortVideoSoPath = inputStreamReader;
                                    shortVideoSoLibName = bufferedReader;
                                    h("[@] compressVideo time cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, ret=" + r26);
                                    if (r26 != 0) {
                                    }
                                    return r26;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            r26 = -1003;
                            shortVideoSoPath = inputStreamReader;
                            shortVideoSoLibName = bufferedReader;
                            h("[@] compressVideo time cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, ret=" + r26);
                            if (r26 != 0) {
                            }
                            return r26;
                        } catch (Throwable th5) {
                            th = th5;
                            r26 = inputStream4;
                            if (r26 != 0) {
                                try {
                                    r26.close();
                                } catch (IOException unused5) {
                                    throw th;
                                }
                            }
                            if (shortVideoSoPath != 0) {
                                shortVideoSoPath.close();
                            }
                            if (shortVideoSoLibName != 0) {
                                shortVideoSoLibName.close();
                            }
                            throw th;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        shortVideoSoLibName = 0;
                    } catch (InterruptedException e26) {
                        e = e26;
                        shortVideoSoLibName = 0;
                    } catch (Exception e27) {
                        e = e27;
                        shortVideoSoLibName = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        shortVideoSoLibName = 0;
                    }
                } catch (IOException e28) {
                    e = e28;
                    shortVideoSoPath = 0;
                    shortVideoSoLibName = 0;
                } catch (InterruptedException e29) {
                    e = e29;
                    shortVideoSoPath = 0;
                    shortVideoSoLibName = 0;
                } catch (Exception e36) {
                    e = e36;
                    shortVideoSoPath = 0;
                    shortVideoSoLibName = 0;
                } catch (Throwable th7) {
                    th = th7;
                    shortVideoSoPath = 0;
                    shortVideoSoLibName = 0;
                }
            } catch (IOException e37) {
                e = e37;
                inputStreamReader3 = null;
                bufferedReader3 = null;
            } catch (InterruptedException e38) {
                e = e38;
                inputStreamReader2 = null;
                bufferedReader2 = null;
            } catch (Exception e39) {
                e = e39;
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th8) {
                th = th8;
                shortVideoSoPath = 0;
                shortVideoSoLibName = 0;
            }
            h("[@] compressVideo time cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, ret=" + r26);
            if (r26 != 0) {
                try {
                    File file = new File(str2);
                    if (file.exists()) {
                        file.delete();
                        h("[@] compressVideo [delete video] ret=" + r26);
                    }
                } catch (Exception unused6) {
                }
            }
            return r26;
        } catch (Throwable th9) {
            th = th9;
        }
    }

    private static String[] d(String str, String str2, VideoConverterConfig videoConverterConfig) {
        String str3;
        if (ShortVideoTrimmer.getCpuCores() < 2) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        String str4 = String.valueOf(videoConverterConfig.destWidth) + HippyTKDListViewAdapter.X + String.valueOf(videoConverterConfig.destHeight);
        h("[@] generateCommand threads=" + str3 + "  resolution=" + str4);
        if (VideoEnvironment.isAvcodecNewVersion()) {
            return new String[]{LogCmdOptions.DUMP, "-y", "-threads", str3, "-copyts", "-copytb", "0", Argument.FILE_INPUT, str, "-metadata:s", "rotate=" + videoConverterConfig.rotate, Argument.AUDIO_CODEC, FileReaderHelper.AAC_EXT, Argument.VIDEO_CODEC, "libo264rt", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-s", str4, "-movflags", "faststart", str2};
        }
        return new String[]{LogCmdOptions.DUMP, "-y", "-threads", str3, "-copyts", "-copytb", "0", Argument.FILE_INPUT, str, "-metadata:s", "rotate=" + videoConverterConfig.rotate, Argument.AUDIO_CODEC, FileReaderHelper.AAC_EXT, Argument.VIDEO_CODEC, "libo264rt", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(videoConverterConfig.destQmax), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str4, "-movflags", "faststart", str2};
    }

    public static String e(String str, int i3) {
        String str2 = new String();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            str2 = BaseApplication.getContext().getExternalFilesDir(null).getPath() + "/dynamicAvatar_" + i3 + "_" + System.currentTimeMillis() + ".mp4";
            if (QLog.isColorLevel()) {
                QLog.i("DynamicUtils", 2, "getDynamicAvatarCompressPath: sourcePath=" + str + "/n compressPath=" + str2);
            }
        }
        return str2;
    }

    public static Bitmap f(Bitmap bitmap, int i3, int i16) {
        Bitmap createBitmap;
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e16) {
            e = e16;
        }
        try {
            new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, i3, i16), new Paint(6));
            return createBitmap;
        } catch (OutOfMemoryError e17) {
            e = e17;
            bitmap2 = createBitmap;
            if (QLog.isColorLevel()) {
                QLog.i("qqBaseActivity", 2, e.getMessage(), e);
            }
            return bitmap2;
        }
    }

    public static Bitmap g(int i3, int i16, int i17) {
        Bitmap bitmap;
        try {
            bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.i("qqBaseActivity", 2, e16.getMessage(), e16);
            }
            bitmap = null;
        }
        if (bitmap != null) {
            Paint paint = new Paint(7);
            bitmap.eraseColor(0);
            Canvas canvas = new Canvas(bitmap);
            Rect rect = new Rect(0, 0, i3, i16);
            paint.setColor(Color.parseColor("#38000000"));
            canvas.drawRect(rect, paint);
            paint.setColor(0);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawCircle(i3 * 0.5f, i16 * 0.5f, i17, paint);
        }
        return bitmap;
    }

    private static void h(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("DynamicUtils", 2, str);
        }
    }

    public static void i(AppInterface appInterface, String str, int i3) {
        g.a(appInterface, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }

    public static void j(AppInterface appInterface, String str, int i3) {
        ThreadManagerV2.post(new Runnable(str, i3) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f200010e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f200011f;

            {
                this.f200010e = str;
                this.f200011f = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AppInterface.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    DynamicUtils.i(AppInterface.this, this.f200010e, this.f200011f);
                }
            }
        }, 2, null, true);
    }

    public static void k(QQAppInterface qQAppInterface, String str, int i3, int i16, int i17) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = i3;
        pu.a aVar = new pu.a();
        aVar.b(i16);
        aVar.b(i17);
        transferRequest.mExtentionInfo = aVar.a();
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    public static void l(QQAppInterface qQAppInterface, String str) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = 48;
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    public static boolean m(long j3, long j16) {
        if (j3 <= 0 || j16 <= 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
        calendar2.setTimeInMillis(j16);
        if (calendar.get(1) != calendar2.get(1) || calendar.get(6) != calendar2.get(6)) {
            return false;
        }
        return true;
    }
}

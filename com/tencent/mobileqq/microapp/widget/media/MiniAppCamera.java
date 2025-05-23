package com.tencent.mobileqq.microapp.widget.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.CamcorderProfile;
import android.media.MediaMetadataRetriever;
import android.media.MediaRecorder;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppCamera extends CameraSurfaceView {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static MediaRecorder f246183m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f246184n;

    /* renamed from: o, reason: collision with root package name */
    private static String f246185o;

    public MiniAppCamera(Context context, WebviewContainer webviewContainer) {
        super(context, webviewContainer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) webviewContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap c(String str) {
        int width;
        int height;
        int max;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(500L, 2);
                if (bitmap != null && (max = Math.max((width = bitmap.getWidth()), (height = bitmap.getHeight()))) > 512) {
                    float f16 = 512.0f / max;
                    bitmap = Bitmap.createScaledBitmap(bitmap, Math.round(width * f16), Math.round(f16 * height), true);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException e16) {
                e16.printStackTrace();
            }
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                mediaMetadataRetriever.release();
            } catch (Throwable th6) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e17) {
                    e17.printStackTrace();
                }
                throw th6;
            }
        }
        return bitmap;
    }

    public void a(WebviewContainer webviewContainer, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, webviewContainer, str, Integer.valueOf(i3), str2);
            return;
        }
        try {
            CameraMonitor.takePicture(CameraSurfaceView.f246169a, null, null, new d(this, str2, str, webviewContainer, i3));
        } catch (Exception e16) {
            webviewContainer.callbackJsEventFail(str, null, i3);
            e16.printStackTrace();
        }
    }

    public void b(WebviewContainer webviewContainer, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            ThreadManagerV2.excute(new h(this, str, webviewContainer, i3), 16, null, true);
        } else {
            iPatchRedirector.redirect((short) 4, this, webviewContainer, str, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Bitmap bitmap, File file, String str) throws IOException {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        int i3;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        try {
            if ("normal".equals(str)) {
                i3 = 80;
            } else {
                i3 = HippyImageInfo.QUALITY_LOW.equals(str) ? 60 : 100;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, Math.min(100, i3), bufferedOutputStream);
            bufferedOutputStream.flush();
            String compressImageJpg = BaseImageUtil.compressImageJpg(file.getAbsolutePath(), file.getAbsolutePath(), CameraSurfaceView.f246170h, CameraSurfaceView.f246171i, i3);
            try {
                bufferedOutputStream.close();
            } catch (Exception unused) {
            }
            try {
                fileOutputStream.close();
            } catch (Exception unused2) {
            }
            return compressImageJpg;
        } catch (Throwable th7) {
            th = th7;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused3) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (Exception unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public void a(WebviewContainer webviewContainer, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, webviewContainer, str, Integer.valueOf(i3));
            return;
        }
        if (f246184n) {
            return;
        }
        try {
            if (f246183m == null) {
                f246183m = new MediaRecorder();
            }
            f246183m.setCamera(CameraSurfaceView.f246169a);
            f246183m.setPreviewDisplay(getHolder().getSurface());
            f246183m.setOnErrorListener(new f(this));
            f246183m.setOnInfoListener(new g(this, webviewContainer, str, i3));
            CameraMonitor.setVideoSource(f246183m, 1);
            AudioMonitor.setAudioSource(f246183m, 0);
            f246183m.setOutputFormat(2);
            f246183m.setMaxDuration(3000);
            f246183m.setVideoEncoder(2);
            f246183m.setAudioEncoder(0);
            CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
            if (camcorderProfile != null) {
                f246183m.setProfile(camcorderProfile);
            }
            f246185o = com.tencent.mobileqq.microapp.appbrand.b.b.a().a("mp4");
            new File(f246185o).getParentFile().mkdirs();
            f246183m.setOutputFile(f246185o);
            CameraSurfaceView.f246169a.unlock();
            f246183m.prepare();
            AudioMonitor.start(f246183m);
            f246184n = true;
        } catch (Exception e16) {
            e16.printStackTrace();
            webviewContainer.callbackJsEventFail(str, null, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, WebviewContainer webviewContainer, int i3) {
        JSONObject b16 = com.tencent.mobileqq.microapp.a.c.b(str, (JSONObject) null);
        webviewContainer.appBrandRuntime.f245904i.evaluateCallbackJs(i3, b16 != null ? b16.toString() : "");
    }
}

package com.tencent.mobileqq.editor.composite.step;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dov.story.api.ISVParamManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class VideoStoryPicToVideo {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final String f203989c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f203990d;

    /* renamed from: e, reason: collision with root package name */
    private static VideoStoryPicToVideo f203991e;

    /* renamed from: a, reason: collision with root package name */
    private Context f203992a;

    /* renamed from: b, reason: collision with root package name */
    private c f203993b;

    /* loaded from: classes6.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    /* loaded from: classes6.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f204000a;

        /* renamed from: b, reason: collision with root package name */
        String f204001b;

        public b(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.f204000a = i3;
                this.f204001b = str;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f204000a;
        }

        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f204000a = i3;
            }
        }

        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                this.f204001b = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42281);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
        f203989c = str;
        f203990d = str + "cache/videostory/";
    }

    VideoStoryPicToVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203992a = BaseApplication.getContext();
        File file = new File(f203990d);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (QLog.isColorLevel()) {
                QLog.d("VideoStoryPicToVideo", 2, "VideoStoryPicToVideo, createDir:" + mkdirs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: Exception | OutOfMemoryError -> 0x00b7, TRY_ENTER, TryCatch #12 {Exception | OutOfMemoryError -> 0x00b7, blocks: (B:10:0x002b, B:13:0x002e, B:17:0x0053, B:20:0x005b, B:24:0x0065, B:26:0x006b, B:28:0x006f, B:32:0x00a4, B:58:0x0048, B:54:0x004d, B:76:0x00ae, B:69:0x00b3, B:70:0x00b6, B:70:0x00b6), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[Catch: Exception | OutOfMemoryError -> 0x00b7, TryCatch #12 {Exception | OutOfMemoryError -> 0x00b7, blocks: (B:10:0x002b, B:13:0x002e, B:17:0x0053, B:20:0x005b, B:24:0x0065, B:26:0x006b, B:28:0x006f, B:32:0x00a4, B:58:0x0048, B:54:0x004d, B:76:0x00ae, B:69:0x00b3, B:70:0x00b6, B:70:0x00b6), top: B:2:0x001a }] */
    @RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str, String str2, String str3, int i3, int i16, boolean z16, int i17, a aVar) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap;
        int i18 = i3;
        int i19 = i16;
        b bVar = new b(0, "success");
        Bitmap bitmap2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = null;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                    bufferedInputStream = null;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream, 32768);
                } catch (Exception e17) {
                    e = e17;
                    bufferedInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = null;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Exception unused2) {
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    bitmap = j.k(bufferedInputStream, null, i18, i19);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                        if (bitmap == null) {
                        }
                        if (bitmap != null) {
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    bitmap = null;
                    if (bitmap == null) {
                        bitmap = j.i(str, i18, i19);
                    }
                    if (bitmap != null) {
                        if (aVar != null) {
                            bVar.b(942014);
                            bVar.c("create bitmap failed");
                            aVar.b(bVar);
                            return;
                        }
                        return;
                    }
                    int exifOrientation = BaseImageUtil.getExifOrientation(str);
                    if (exifOrientation != 0 && exifOrientation % 90 == 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(exifOrientation, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        if (exifOrientation == 90 || exifOrientation == 270) {
                            i19 = i18;
                            i18 = i19;
                        }
                        bitmap.recycle();
                        bitmap2 = createBitmap;
                    } else {
                        bitmap2 = bitmap;
                    }
                    int i26 = i18;
                    int i27 = i19;
                    if (bitmap2 == null) {
                        if (aVar != null) {
                            bVar.b(942014);
                            bVar.c("create bitmap failed");
                            aVar.b(bVar);
                            return;
                        }
                        return;
                    }
                    c cVar = new c(str2, i26, i27, ((ISVParamManager) QRoute.api(ISVParamManager.class)).getBitRate(2) * 4 * 1000, Integer.valueOf(str3).intValue() * 1000, z16, i17);
                    this.f203993b = cVar;
                    cVar.r(16);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bitmap2);
                    this.f203993b.q(arrayList, aVar);
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception | OutOfMemoryError unused7) {
        }
    }

    public static VideoStoryPicToVideo d() {
        if (f203991e == null) {
            synchronized (VideoStoryPicToVideo.class) {
                if (f203991e == null) {
                    f203991e = new VideoStoryPicToVideo();
                }
            }
        }
        return f203991e;
    }

    public String c(String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        File file = new File(str);
        String name = file.getName();
        if (!TextUtils.isEmpty(name)) {
            name = (name.replace(".", "_") + "_" + file.length() + "_" + str2) + ".mp4";
        }
        if (!TextUtils.isEmpty(name)) {
            str3 = f203990d + name;
        } else {
            str3 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoStoryPicToVideo", 2, "genOupPath" + str3);
        }
        return str3;
    }

    public void e(String str, String str2, String str3, int i3, int i16, boolean z16, int i17, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), aVar);
            return;
        }
        b bVar = new b(0, "success");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (str3.equals("0")) {
                bVar.b(941003);
                bVar.c("duration is 0");
                aVar.b(bVar);
                return;
            } else {
                if (FileUtils.fileExistsAndNotEmpty(str2)) {
                    if (aVar != null) {
                        bVar.b(0);
                        bVar.c("success");
                        aVar.a(bVar);
                        return;
                    }
                    return;
                }
                ThreadManagerV2.newFreeThread(new Runnable(str, str2, str3, i3, i16, z16, i17, aVar) { // from class: com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int C;
                    final /* synthetic */ a D;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f203994d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f203995e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f203996f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f203997h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ int f203998i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ boolean f203999m;

                    {
                        this.f203994d = str;
                        this.f203995e = str2;
                        this.f203996f = str3;
                        this.f203997h = i3;
                        this.f203998i = i16;
                        this.f203999m = z16;
                        this.C = i17;
                        this.D = aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, VideoStoryPicToVideo.this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            VideoStoryPicToVideo.this.b(this.f203994d, this.f203995e, this.f203996f, this.f203997h, this.f203998i, this.f203999m, this.C, this.D);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                }, "videoStoryPicToVideo", 5).start();
                return;
            }
        }
        bVar.b(940007);
        bVar.c("Invalid argument");
        aVar.b(bVar);
    }
}

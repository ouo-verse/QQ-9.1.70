package dov.com.qq.im.ae.current;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.common.GifUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.widget.QzoneEmotionUtils;
import dov.com.qq.im.video.GifEncoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class GIFCreator {

    /* renamed from: i, reason: collision with root package name */
    private static String f394436i = "GIFCreator";

    /* renamed from: b, reason: collision with root package name */
    private Handler f394438b;

    /* renamed from: d, reason: collision with root package name */
    private b f394440d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f394441e;

    /* renamed from: h, reason: collision with root package name */
    private String f394444h;

    /* renamed from: a, reason: collision with root package name */
    private String f394437a = ((IAEPath) QRoute.api(IAEPath.class)).getGifPreviewCache();

    /* renamed from: c, reason: collision with root package name */
    private GifEncoder f394439c = new GifEncoder();

    /* renamed from: f, reason: collision with root package name */
    private String f394442f = this.f394437a + System.currentTimeMillis() + QzoneEmotionUtils.SIGN_ICON_URL_END;

    /* renamed from: g, reason: collision with root package name */
    private String f394443g = this.f394437a + System.currentTimeMillis() + "_compressed.gif";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(AIInput.KEY_FRAME);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        void onGifCreateFail();

        void onGifCreateSuccess(String str);
    }

    public GIFCreator(String str) {
        this.f394444h = str;
        this.f394441e = i(str);
        try {
            File file = new File(this.f394437a);
            if (!file.isDirectory()) {
                QLog.d(f394436i, 4, this.f394437a + " is not a directory");
                boolean mkdirs = file.mkdirs();
                QLog.d(f394436i, 4, "mkdirs return " + mkdirs);
            }
        } catch (Exception e16) {
            QLog.d(f394436i, 4, "check dir exception, msg = " + e16.getMessage());
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("GIFCreatorHT" + System.currentTimeMillis());
        baseHandlerThread.start();
        this.f394438b = new Handler(baseHandlerThread.getLooper());
    }

    private List<String> i(String str) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory() && (list = file.list(new a())) != null) {
            Arrays.sort(list);
            for (String str2 : list) {
                arrayList.add(str + File.separator + str2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    private static byte[] j(File file) {
        FileInputStream fileInputStream;
        ?? isFile = file.isFile();
        FileInputStream fileInputStream2 = null;
        try {
            if (isFile != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    return byteArray;
                } catch (IOException e19) {
                    e = e19;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    return null;
                }
            }
            QLog.d(f394436i, 4, "file not found, path = " + file.getAbsolutePath());
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = isFile;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap k(String str, int i3, int i16, boolean z16) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            bitmap.setPremultiplied(z16);
            byte[] j3 = j(new File(str));
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            if (j3 != null) {
                allocate.put(j3);
            }
            allocate.position(0);
            bitmap.copyPixelsFromBuffer(allocate);
        } catch (Exception e16) {
            QLog.d(f394436i, 4, "readRawBytesToBitmap exception, msg = " + e16.getMessage());
        } catch (OutOfMemoryError unused) {
            QLog.d(f394436i, 4, "readRawBytesToBitmap OOM");
        }
        return bitmap;
    }

    public void h() {
        FileUtils.deleteDirectory(this.f394444h);
    }

    public void l(final b bVar) {
        this.f394440d = bVar;
        QLog.d(f394436i, 4, "start create gif, gif path = ", this.f394442f);
        this.f394438b.post(new Runnable() { // from class: dov.com.qq.im.ae.current.GIFCreator.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                QLog.d(GIFCreator.f394436i, 4, "gif encode loop");
                try {
                    GIFCreator.this.f394439c.c(320, 320, GIFCreator.this.f394442f);
                    GIFCreator.this.f394439c.e(false);
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = GIFCreator.this.f394441e.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String str = (String) it.next();
                            Bitmap k3 = GIFCreator.this.k(str, 320, 320, false);
                            if (k3 != null) {
                                QLog.d(GIFCreator.f394436i, 4, "gif encode frame start");
                                GIFCreator.this.f394439c.b(k3, 55);
                                QLog.d(GIFCreator.f394436i, 4, "gif encode frame end");
                                k3.recycle();
                            } else {
                                QLog.d(GIFCreator.f394436i, 4, "gif encode frame but bitmap == null, png path = ", str);
                                z16 = false;
                                break;
                            }
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                    GIFCreator.this.f394439c.a();
                    QLog.d(GIFCreator.f394436i, 4, "gif encode duration = " + (System.currentTimeMillis() - currentTimeMillis));
                    q.d(GIFCreator.this.f394443g);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    int compressGif = GifUtil.compressGif(GIFCreator.this.f394442f, GIFCreator.this.f394443g, 30);
                    QLog.d(GIFCreator.f394436i, 4, "gif compress duration = " + (System.currentTimeMillis() - currentTimeMillis2));
                    QLog.d(GIFCreator.f394436i, 4, "gif compress ret = " + compressGif);
                    if (compressGif <= 0) {
                        z16 = false;
                    }
                    q.d(GIFCreator.this.f394442f);
                    QLog.d(GIFCreator.f394436i, 4, "gif create success, gif path = ", GIFCreator.this.f394443g);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        if (z16) {
                            bVar2.onGifCreateSuccess(GIFCreator.this.f394443g);
                        } else {
                            bVar2.onGifCreateFail();
                        }
                    }
                    GIFCreator.this.f394438b.getLooper().quit();
                } catch (FileNotFoundException e16) {
                    QLog.d(GIFCreator.f394436i, 4, "gifEncoder init exception, gifPath = " + GIFCreator.this.f394442f + ", msg = " + e16.getMessage());
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.onGifCreateFail();
                    }
                    GIFCreator.this.f394438b.getLooper().quit();
                }
            }
        });
    }
}

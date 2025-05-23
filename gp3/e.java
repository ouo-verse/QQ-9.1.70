package gp3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.img.ImageCache;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    protected static e f403041b;

    /* renamed from: c, reason: collision with root package name */
    protected static byte[] f403042c = new byte[1];

    /* renamed from: a, reason: collision with root package name */
    protected LruCache<String, Bitmap> f403043a = new LruCache<>(50);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements qp3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f403044a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f403045b;

        a(b bVar, String str) {
            this.f403044a = bVar;
            this.f403045b = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v8 */
        @Override // qp3.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, String str2, String str3) {
            Throwable th5;
            InputStream inputStream;
            String str4 = ImageLoader.TAG;
            com.tencent.open.base.f.a(ImageLoader.TAG, "-->imgDownloadError path = " + str2 + " localUrl = " + str3);
            if (!Common.w()) {
                Bitmap bitmap = null;
                bitmap = null;
                bitmap = null;
                bitmap = null;
                bitmap = null;
                ?? r56 = 0;
                try {
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f403045b).openConnection();
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setRequestMethod("GET");
                        inputStream = httpURLConnection.getInputStream();
                    } catch (MalformedURLException e17) {
                        e = e17;
                        inputStream = null;
                    } catch (IOException e18) {
                        e = e18;
                        inputStream = null;
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (r56 != 0) {
                        }
                        throw th5;
                    }
                    try {
                        bitmap = BitmapFactory.decodeStream(inputStream);
                    } catch (MalformedURLException e19) {
                        e = e19;
                        e.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        str4 = ImageLoader.TAG;
                        com.tencent.open.base.f.a(ImageLoader.TAG, "-->imgDownloaded bitmap = " + bitmap);
                        if (bitmap != null) {
                        }
                    } catch (IOException e26) {
                        e = e26;
                        e.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        str4 = ImageLoader.TAG;
                        com.tencent.open.base.f.a(ImageLoader.TAG, "-->imgDownloaded bitmap = " + bitmap);
                        if (bitmap != null) {
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    str4 = ImageLoader.TAG;
                    com.tencent.open.base.f.a(ImageLoader.TAG, "-->imgDownloaded bitmap = " + bitmap);
                    if (bitmap != null) {
                        Bitmap circleFaceBitmap = BaseImageUtil.getCircleFaceBitmap(com.tencent.open.adapter.a.f().e(), bitmap, 50, 50);
                        synchronized (e.f403042c) {
                            e.this.f403043a.put(str, circleFaceBitmap);
                        }
                        this.f403044a.onImageLoaded(this.f403045b, circleFaceBitmap, str3);
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    r56 = str4;
                    if (r56 != 0) {
                        try {
                            r56.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    throw th5;
                }
            }
        }

        @Override // qp3.b
        public void b(String str, String str2, String str3) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str3);
                com.tencent.open.base.f.a(ImageLoader.TAG, "-->imgDownloaded path = " + str2 + " localUrl = " + str3);
                Bitmap circleFaceBitmap = BaseImageUtil.getCircleFaceBitmap(com.tencent.open.adapter.a.f().e(), decodeFile, 50, 50);
                synchronized (e.f403042c) {
                    e.this.f403043a.put(str, circleFaceBitmap);
                }
                this.f403044a.onImageLoaded(this.f403045b, circleFaceBitmap, str3);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void onImageLoaded(String str, Bitmap bitmap, String str2);
    }

    protected e() {
    }

    public static e a() {
        if (f403041b == null) {
            synchronized (f403042c) {
                if (f403041b == null) {
                    f403041b = new e();
                }
            }
        }
        return f403041b;
    }

    public Bitmap b(String str) {
        Bitmap bitmap;
        String encodeHexStr = MD5Utils.encodeHexStr(str);
        synchronized (f403042c) {
            bitmap = this.f403043a.get(encodeHexStr);
        }
        return bitmap;
    }

    public void c(String str, b bVar) {
        ImageCache.c("app", str, new a(bVar, str));
    }

    public void d(String str) {
        String encodeHexStr = MD5Utils.encodeHexStr(str);
        synchronized (f403042c) {
            this.f403043a.remove(encodeHexStr);
        }
        ImageCache.a(str);
    }
}

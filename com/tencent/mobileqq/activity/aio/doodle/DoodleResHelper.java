package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.doodle.IScribbleResMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DoodleResHelper {

    /* renamed from: d, reason: collision with root package name */
    static volatile DoodleResHelper f178407d;

    /* renamed from: a, reason: collision with root package name */
    private final String f178408a = "DoodleResHelper";

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, a> f178409b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f178410c = 0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Bitmap> f178419a;

        /* renamed from: b, reason: collision with root package name */
        boolean f178420b;

        /* renamed from: c, reason: collision with root package name */
        int f178421c;

        /* renamed from: d, reason: collision with root package name */
        int f178422d;

        a() {
        }
    }

    DoodleResHelper() {
    }

    private String d(String str, int i3) {
        return "Aio_Doodle/Type_" + i3 + "_" + str;
    }

    public static DoodleResHelper k() {
        if (f178407d == null) {
            synchronized (DoodleResHelper.class) {
                if (f178407d == null) {
                    f178407d = new DoodleResHelper();
                }
            }
        }
        return f178407d;
    }

    public void a() {
        synchronized (DoodleResHelper.class) {
            this.f178409b = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap b(int i3, int i16) {
        BufferedInputStream bufferedInputStream;
        InputStream inputStream;
        Bitmap bitmap;
        String e16 = e(i3, i16);
        InputStream inputStream2 = null;
        r2 = null;
        Bitmap bitmap2 = null;
        r2 = null;
        InputStream inputStream3 = null;
        BufferedInputStream bufferedInputStream2 = null;
        if (TextUtils.isEmpty(e16) || i16 <= 0) {
            return null;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        ?? f16 = imageCacheHelper.f(d(e16, 0));
        try {
            try {
                if (f16 != 0) {
                    return f16;
                }
                try {
                    f16 = new FileInputStream(e16);
                    try {
                        bufferedInputStream = new BufferedInputStream(f16);
                        try {
                            bitmap2 = BitmapFactory.decodeStream(bufferedInputStream);
                            if (bitmap2 != null && 3 != i3) {
                                imageCacheHelper.i(d(e16, 0), bitmap2, Business.AIO);
                            }
                            try {
                                f16.close();
                            } catch (IOException unused) {
                            }
                            try {
                                bufferedInputStream.close();
                                return bitmap2;
                            } catch (IOException unused2) {
                                return bitmap2;
                            }
                        } catch (Exception unused3) {
                            bitmap = bitmap2;
                            inputStream3 = f16;
                            i3 = bitmap;
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                                i3 = i3;
                            }
                            return i3;
                        } catch (OutOfMemoryError unused5) {
                            i3 = bitmap2;
                            bufferedInputStream2 = bufferedInputStream;
                            inputStream = f16;
                            if (QLog.isColorLevel()) {
                                QLog.e("DoodleResHelper", 2, "getBitmap OOM!");
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                                i3 = i3;
                            }
                            return i3;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream2 = f16;
                            if (inputStream2 != null) {
                            }
                            if (bufferedInputStream == null) {
                            }
                        }
                    } catch (Exception unused7) {
                        bitmap = null;
                        bufferedInputStream = null;
                    } catch (OutOfMemoryError unused8) {
                        i3 = 0;
                        inputStream = f16;
                    }
                } catch (Exception unused9) {
                    i3 = 0;
                    bufferedInputStream = null;
                } catch (OutOfMemoryError unused10) {
                    i3 = 0;
                    inputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = null;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused11) {
                        }
                    }
                    if (bufferedInputStream == null) {
                        try {
                            bufferedInputStream.close();
                            throw th;
                        } catch (IOException unused12) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException unused13) {
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap c(int i3, int i16) {
        WeakReference<Bitmap> weakReference;
        Bitmap bitmap;
        if (i3 <= 0 || i16 <= 0) {
            return null;
        }
        synchronized (DoodleResHelper.class) {
            if (this.f178409b == null) {
                this.f178409b = new HashMap();
            }
            if (this.f178409b.size() > 0) {
                Iterator<Map.Entry<Integer, a>> it = this.f178409b.entrySet().iterator();
                while (it.hasNext()) {
                    a value = it.next().getValue();
                    if (value != null && (weakReference = value.f178419a) != null && weakReference.get() != null) {
                        if (value.f178420b && value.f178422d == i16 && value.f178421c == i3) {
                            WeakReference<Bitmap> weakReference2 = value.f178419a;
                            if (weakReference2 != null) {
                                bitmap = weakReference2.get();
                            } else {
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                QLog.d("DoodleResHelper", 2, "getBitmap find idle :" + this.f178409b.size());
                                value.f178420b = false;
                                return bitmap;
                            }
                        }
                    }
                    it.remove();
                    QLog.d("DoodleResHelper", 2, "getBitmap remove a invalid item");
                }
            }
            QLog.d("DoodleResHelper", 2, "getBitmap add new item");
            a aVar = new a();
            aVar.f178422d = i16;
            aVar.f178421c = i3;
            try {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                    aVar.f178419a = new WeakReference<>(createBitmap);
                    aVar.f178420b = false;
                    Map<Integer, a> map = this.f178409b;
                    int i17 = this.f178410c;
                    this.f178410c = i17 + 1;
                    map.put(Integer.valueOf(i17), aVar);
                    QLog.d("DoodleResHelper", 2, "getBitmap create new cache:" + this.f178409b.size());
                    return createBitmap;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DoodleResHelper", 2, "getBitmap exception:" + e16);
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return null;
                }
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("DoodleResHelper", 2, "getBitmap exception OOM!" + e17.toString());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleResHelper", 2, "getBitmap error!");
                }
                return null;
            }
        }
    }

    public String e(int i3, int i16) {
        String str;
        if (i3 == 0) {
            str = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetResPath(1, i16);
        } else if (i3 == 1) {
            str = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetResPath(2, i16);
        } else if (i3 == 2) {
            String GetResPath = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetResPath(2, i16);
            str = GetResPath.substring(0, GetResPath.lastIndexOf(46)) + "ex.gif";
        } else if (i3 == 3) {
            String GetResPath2 = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetResPath(2, i16);
            str = GetResPath2.substring(0, GetResPath2.lastIndexOf(46)) + "pre.png";
        } else {
            str = null;
        }
        if (!FileUtils.fileExists(str)) {
            return null;
        }
        return str;
    }

    public List<Integer> f(int i3) {
        ArrayList<Integer> GetPaintVisibleIdList;
        ArrayList arrayList = new ArrayList();
        if (i3 != 1 && i3 != 2) {
            if (i3 == 0 && (GetPaintVisibleIdList = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetPaintVisibleIdList()) != null && GetPaintVisibleIdList.size() > 0) {
                arrayList.addAll(GetPaintVisibleIdList);
            }
        } else {
            ArrayList<Integer> GetGifVisibleIdList = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetGifVisibleIdList();
            if (GetGifVisibleIdList != null && GetGifVisibleIdList.size() > 0) {
                arrayList.addAll(GetGifVisibleIdList);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006d, code lost:
    
        if (r3 == null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap g(int i3, int i16) {
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap;
        FileInputStream fileInputStream = null;
        r0 = null;
        Bitmap bitmap2 = null;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        if (i16 < 0) {
            return null;
        }
        String i17 = i(i3, i16);
        if (TextUtils.isEmpty(i17) || i16 <= 0) {
            return null;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(d(i17, 0));
        if (f16 != null) {
            return f16;
        }
        try {
            FileInputStream fileInputStream4 = new FileInputStream(i17);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream4);
                try {
                    bitmap2 = BitmapFactory.decodeStream(bufferedInputStream);
                    imageCacheHelper.i(d(i17, 0), bitmap2, Business.AIO);
                    try {
                        fileInputStream4.close();
                    } catch (IOException unused) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                        return bitmap2;
                    }
                } catch (Exception unused3) {
                    bitmap = bitmap2;
                    fileInputStream2 = fileInputStream4;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                } catch (OutOfMemoryError unused5) {
                    bitmap = bitmap2;
                    fileInputStream3 = fileInputStream4;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException unused6) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream4;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            throw th;
                        } catch (IOException unused8) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused9) {
                bitmap = null;
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused10) {
                bitmap = null;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
            }
        } catch (Exception unused11) {
            bitmap = null;
            bufferedInputStream = null;
        } catch (OutOfMemoryError unused12) {
            bitmap = null;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
        }
        return bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
    
        if (r3 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007e, code lost:
    
        if (r3 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable h(int i3, int i16) {
        BufferedInputStream bufferedInputStream;
        BitmapDrawable bitmapDrawable;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (i16 < 0) {
            return null;
        }
        String i17 = i(i3, i16);
        if (TextUtils.isEmpty(i17)) {
            return null;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Object g16 = imageCacheHelper.g(d(i17, 1));
        if (g16 != null) {
            return (Drawable) g16;
        }
        try {
            fileInputStream = new FileInputStream(i17);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (Exception unused) {
                bufferedInputStream = null;
                bitmapDrawable = null;
            } catch (OutOfMemoryError unused2) {
                bufferedInputStream = null;
                bitmapDrawable = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
        } catch (Exception unused3) {
            bufferedInputStream = null;
            bitmapDrawable = null;
        } catch (OutOfMemoryError unused4) {
            bufferedInputStream = null;
            bitmapDrawable = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
        try {
            try {
                bitmapDrawable = new BitmapDrawable(BaseApplication.getContext().getApplicationContext().getResources(), BitmapFactory.decodeStream(bufferedInputStream));
                try {
                    imageCacheHelper.i(d(i17, 1), bitmapDrawable, Business.AIO);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused5) {
                    }
                } catch (Exception unused6) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused7) {
                        }
                    }
                } catch (OutOfMemoryError unused8) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused9) {
                        }
                    }
                }
            } catch (Exception unused10) {
                bitmapDrawable = null;
            } catch (OutOfMemoryError unused11) {
                bitmapDrawable = null;
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused12) {
                return bitmapDrawable;
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused13) {
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                    throw th;
                } catch (IOException unused14) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public String i(int i3, int i16) {
        String GetResIconPath;
        if (i3 == 0) {
            GetResIconPath = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetResIconPath(1, i16);
        } else if (i3 != 2 && i3 != 1) {
            GetResIconPath = null;
        } else {
            GetResIconPath = ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).GetResIconPath(2, i16);
        }
        if (!FileUtils.fileExists(GetResIconPath)) {
            return null;
        }
        return GetResIconPath;
    }

    public Drawable j(int i3, int i16, boolean z16) {
        int i17;
        String e16 = e(i3, i16);
        if (TextUtils.isEmpty(e16) || i16 <= 0) {
            return null;
        }
        File file = new File(e16);
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        String uri = file.toURI().toString();
        if (z16) {
            i17 = 2;
        } else {
            i17 = 3;
        }
        Object g16 = imageCacheHelper.g(d(uri, i17));
        if (g16 != null) {
            return (Drawable) g16;
        }
        BaseApplication context = BaseApplication.getContext();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.c0c);
        obtain.mLoadingDrawable = context.getResources().getDrawable(R.drawable.c0c);
        obtain.mExtraInfo = null;
        obtain.mUseMemoryCache = false;
        if (i3 == 1) {
            obtain.mUseUnFinishCache = false;
        } else {
            obtain.mUseUnFinishCache = true;
            if (z16) {
                obtain.isFlashPic = true;
            } else {
                obtain.isFlashPic = false;
            }
        }
        if (i3 != 0 && i3 != 3) {
            if (i3 == 2 && z16) {
                obtain.mPlayGifImage = true;
            } else if (i3 == 1 && z16) {
                obtain.mPlayGifImage = true;
            }
        } else {
            obtain.mPlayGifImage = false;
        }
        URLDrawable drawable = URLDrawable.getDrawable(file, obtain);
        if (i3 == 2 || i3 == 1) {
            drawable.setIgnorePause(true);
        }
        return drawable;
    }

    public boolean l(int i3, int i16) {
        if (TextUtils.isEmpty(e(i3, i16))) {
            return false;
        }
        return true;
    }

    public boolean m(int i3, int i16) {
        if (TextUtils.isEmpty(i(i3, i16))) {
            return false;
        }
        return true;
    }

    public boolean n(int i3, int i16) {
        if (l(i3, i16) && m(i3, i16)) {
            return true;
        }
        return false;
    }

    public void o(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        synchronized (DoodleResHelper.class) {
            Map<Integer, a> map = this.f178409b;
            if (map == null) {
                return;
            }
            for (a aVar : map.values()) {
                WeakReference<Bitmap> weakReference = aVar.f178419a;
                if (weakReference != null && weakReference.get() == bitmap) {
                    aVar.f178420b = true;
                    QLog.d("DoodleResHelper", 2, "releaseBitmap succ:" + this.f178409b.size());
                    return;
                }
            }
            a aVar2 = new a();
            aVar2.f178422d = bitmap.getHeight();
            aVar2.f178421c = bitmap.getWidth();
            aVar2.f178419a = new WeakReference<>(bitmap);
            aVar2.f178420b = true;
            Map<Integer, a> map2 = this.f178409b;
            int i3 = this.f178410c;
            this.f178410c = i3 + 1;
            map2.put(Integer.valueOf(i3), aVar2);
            QLog.d("DoodleResHelper", 2, "releaseBitmap add new one:" + this.f178409b.size());
        }
    }

    public void p(final int i3, final int i16, final View view, final com.tencent.mobileqq.scribble.b bVar) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    int i17 = i3;
                    if (i17 == 0) {
                        ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(1, i16, view, bVar);
                    } else if (i17 == 1 || i17 == 2) {
                        ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(2, i16, view, bVar);
                    }
                }
            });
            return;
        }
        if (i3 == 0) {
            ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(1, i16, view, bVar);
        } else if (i3 == 1 || i3 == 2) {
            ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(2, i16, view, bVar);
        }
    }

    public void q(final int i3, final int i16, final View view, final com.tencent.mobileqq.scribble.b bVar) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    MobileQQ.sMobileQQ.waitAppRuntime(null);
                    int i17 = i3;
                    if (i17 == 0) {
                        ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(3, i16, view, bVar);
                    } else if (i17 == 1 || i17 == 2) {
                        ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(4, i16, view, bVar);
                    }
                }
            });
            return;
        }
        if (i3 == 0) {
            ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(3, i16, view, bVar);
        } else if (i3 == 1 || i3 == 2) {
            ((IScribbleResMgr) QRoute.api(IScribbleResMgr.class)).StartDownloadRes(4, i16, view, bVar);
        }
    }
}

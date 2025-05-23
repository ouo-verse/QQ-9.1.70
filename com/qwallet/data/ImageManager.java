package com.qwallet.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.LruCache;
import com.qwallet.utils.QWalletUtils;
import com.qwallet.view.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageManager {

    /* renamed from: f, reason: collision with root package name */
    protected static d f41473f = new d();

    /* renamed from: b, reason: collision with root package name */
    protected Context f41475b;

    /* renamed from: e, reason: collision with root package name */
    private IPreloadServiceProxy f41478e;

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<b> f41474a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f41476c = false;

    /* renamed from: d, reason: collision with root package name */
    protected Handler f41477d = new a(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                synchronized (ImageManager.this.f41474a) {
                    b bVar = (b) message.obj;
                    if (bVar.f41494m || bVar.f41500s >= 2) {
                        if (!bVar.f41491j) {
                            bVar.f41482a.a(bVar);
                        }
                        if (bVar.f41492k != null) {
                            for (int i3 = 0; i3 < bVar.f41492k.size(); i3++) {
                                ImageManager.this.d(bVar, bVar.f41492k.get(i3));
                                if (!bVar.f41492k.get(i3).f41491j) {
                                    bVar.f41492k.get(i3).f41482a.a(bVar.f41492k.get(i3));
                                }
                            }
                        }
                        ImageManager.this.f41474a.remove(bVar);
                    }
                }
                ImageManager imageManager = ImageManager.this;
                if (!imageManager.f41476c && imageManager.j()) {
                    ImageManager.this.m();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public c f41482a;

        /* renamed from: b, reason: collision with root package name */
        public String f41483b;

        /* renamed from: c, reason: collision with root package name */
        public String f41484c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f41485d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f41486e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f41487f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f41488g;

        /* renamed from: h, reason: collision with root package name */
        public int f41489h;

        /* renamed from: i, reason: collision with root package name */
        public int f41490i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f41491j = false;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList<b> f41492k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f41493l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f41494m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f41495n;

        /* renamed from: o, reason: collision with root package name */
        public String f41496o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f41497p;

        /* renamed from: q, reason: collision with root package name */
        public Bitmap f41498q;

        /* renamed from: r, reason: collision with root package name */
        public long f41499r;

        /* renamed from: s, reason: collision with root package name */
        protected int f41500s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f41501t;

        /* renamed from: u, reason: collision with root package name */
        protected boolean f41502u;

        public void a(b bVar) {
            if (bVar == null) {
                return;
            }
            if (this.f41492k == null) {
                this.f41492k = new ArrayList<>();
            }
            this.f41492k.add(bVar);
        }

        public boolean b() {
            if (this.f41482a == null || TextUtils.isEmpty(this.f41483b)) {
                return false;
            }
            return true;
        }

        public boolean c() {
            if (!this.f41491j) {
                return false;
            }
            if (this.f41492k != null) {
                for (int i3 = 0; i3 < this.f41492k.size(); i3++) {
                    if (!this.f41492k.get(i3).f41491j) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class c {
        public abstract void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d extends LruCache<String, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        protected SparseArray<WeakReference<Bitmap>> f41503a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f41504b;

        public d() {
            super((int) ((((float) Runtime.getRuntime().maxMemory()) / 1024.0f) / 8.0f));
            this.f41503a = new SparseArray<>();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap create(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int hashCode = str.hashCode();
            WeakReference<Bitmap> weakReference = this.f41503a.get(hashCode);
            if (weakReference != null) {
                this.f41503a.remove(hashCode);
                Bitmap bitmap = weakReference.get();
                if (bitmap != null && !bitmap.isRecycled()) {
                    return bitmap;
                }
            }
            return (Bitmap) super.create(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z16, String str, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z16, str, bitmap, bitmap2);
            if (str != null && bitmap != null && !bitmap.isRecycled()) {
                boolean z17 = this.f41504b;
                this.f41503a.put(str.hashCode(), new WeakReference<>(bitmap));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
        }
    }

    public ImageManager(Context context) {
        this.f41475b = context.getApplicationContext();
    }

    private void b(b bVar, boolean z16) {
        bVar.f41502u = false;
        if (z16) {
            this.f41476c = false;
        }
    }

    private boolean e(b bVar, boolean z16, boolean z17, File file) {
        int i3;
        int i16;
        try {
            if (bVar.f41487f) {
                k kVar = new k(bVar.f41496o);
                bVar.f41497p = kVar;
                if (kVar.getBitmap() == null && !z17 && file.delete()) {
                    l(bVar, z16, true);
                    return false;
                }
            } else if (bVar.f41488g) {
                if (bVar.f41490i <= 0 && bVar.f41489h <= 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDensity = 320;
                    if (MobileQQ.sMobileQQ.getResources().getDisplayMetrics().densityDpi > options.inDensity) {
                        options.inTargetDensity = 320;
                    } else {
                        options.inTargetDensity = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().densityDpi;
                    }
                    bVar.f41498q = BitmapFactory.decodeFile(bVar.f41496o, options);
                    if (bVar.f41498q == null && !z17 && file.delete()) {
                        l(bVar, z16, true);
                        return false;
                    }
                }
                bVar.f41485d = false;
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(bVar.f41496o, options2);
                int i17 = bVar.f41490i;
                if (i17 > 0) {
                    i3 = options2.outHeight / i17;
                } else {
                    i3 = 0;
                }
                int i18 = bVar.f41489h;
                if (i18 > 0) {
                    i16 = options2.outWidth / i18;
                } else {
                    i16 = 0;
                }
                options2.inJustDecodeBounds = false;
                if (i3 <= i16) {
                    i3 = i16;
                }
                options2.inSampleSize = i3;
                options2.inDensity = 320;
                if (MobileQQ.sMobileQQ.getResources().getDisplayMetrics().densityDpi > options2.inDensity) {
                    options2.inTargetDensity = 320;
                } else {
                    options2.inTargetDensity = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().densityDpi;
                }
                bVar.f41498q = BitmapFactory.decodeFile(bVar.f41496o, options2);
                if (bVar.f41498q == null) {
                    l(bVar, z16, true);
                    return false;
                }
            }
            if (bVar.f41485d) {
                k(bVar);
            }
        } catch (Exception e16) {
            f.a(com.tencent.component.media.image.ImageManager.TAG, e16.toString());
        } catch (OutOfMemoryError e17) {
            f.a(com.tencent.component.media.image.ImageManager.TAG, e17.toString());
        }
        return true;
    }

    private void g(final b bVar, final boolean z16) {
        synchronized (this.f41474a) {
            for (int size = this.f41474a.size() - 1; size >= 0; size--) {
                if (bVar.f41483b.equals(this.f41474a.get(size).f41483b)) {
                    if (this.f41474a.get(size).f41482a != bVar.f41482a || bVar.f41501t) {
                        this.f41474a.get(size).a(bVar);
                    }
                    return;
                }
            }
            if (this.f41475b == null) {
                return;
            }
            this.f41474a.add(bVar);
            if (z16) {
                this.f41476c = true;
            }
            bVar.f41500s++;
            bVar.f41502u = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.qwallet.data.ImageManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageManager.this.l(bVar, z16, false);
                }
            }, 64, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(b bVar, boolean z16, boolean z17) {
        boolean z18;
        if (bVar.c()) {
            b(bVar, z16);
            return;
        }
        if (this.f41475b == null) {
            b(bVar, z16);
            this.f41477d.obtainMessage(1, bVar).sendToTarget();
            return;
        }
        String md5Encode = ((IQWalletApi) QRoute.api(IQWalletApi.class)).md5Encode(bVar.f41483b);
        if (md5Encode != null && md5Encode.length() > 0) {
            String h16 = h(bVar.f41483b);
            if (TextUtils.isEmpty(h16)) {
                h16 = bVar.f41484c;
                if (h16 == null) {
                    h16 = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQWalletTmpPath();
                }
                if (!TextUtils.isEmpty(h16)) {
                    if (h16.charAt(h16.length() - 1) != '/' && h16.charAt(h16.length() - 1) != '\\') {
                        h16 = h16 + '/';
                    }
                    h16 = h16 + md5Encode;
                }
            }
            if (TextUtils.isEmpty(h16)) {
                b(bVar, z16);
                return;
            }
            File file = new File(h16);
            boolean exists = file.exists();
            if (!exists) {
                if (bVar.f41493l) {
                    File file2 = new File(MobileQQ.sMobileQQ.getFilesDir() + "/" + md5Encode);
                    if (file2.exists()) {
                        FileUtils.copyFile(file2, file);
                        if (file.exists()) {
                            file2.delete();
                        } else {
                            file = file2;
                        }
                    }
                }
                if (exists) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (HttpDownloadUtil.downloadData(null, bVar.f41483b, file, 1) == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    bVar.f41499r = System.currentTimeMillis() - currentTimeMillis;
                    bVar.f41495n = true;
                } else {
                    z18 = true;
                }
                if (!bVar.c()) {
                    b(bVar, z16);
                    return;
                }
                String absolutePath = file.getAbsolutePath();
                bVar.f41496o = absolutePath;
                bVar.f41494m = z18;
                if (z18 && absolutePath != null && absolutePath.length() > 0 && !e(bVar, z16, z17, file)) {
                    return;
                }
                b(bVar, z16);
                if (bVar.c()) {
                    if (!bVar.f41485d) {
                        bVar.f41498q = null;
                        Drawable drawable = bVar.f41497p;
                        if (drawable != null) {
                            QWalletUtils.a(drawable);
                        }
                        bVar.f41497p = null;
                        return;
                    }
                    return;
                }
                this.f41477d.obtainMessage(1, bVar).sendToTarget();
                return;
            }
            exists = true;
            if (exists) {
            }
            if (!bVar.c()) {
            }
        } else {
            b(bVar, z16);
        }
    }

    public void c() {
        synchronized (this.f41474a) {
            for (int i3 = 0; i3 < this.f41474a.size(); i3++) {
                this.f41474a.get(i3).f41491j = true;
                if (this.f41474a.get(i3).f41492k != null) {
                    for (int i16 = 0; i16 < this.f41474a.get(i3).f41492k.size(); i16++) {
                        this.f41474a.get(i3).f41492k.get(i16).f41491j = true;
                    }
                }
            }
            this.f41474a.clear();
        }
    }

    protected void d(b bVar, b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.f41494m = bVar.f41494m;
            bVar2.f41495n = bVar.f41495n;
            bVar2.f41496o = bVar.f41496o;
            bVar2.f41497p = bVar.f41497p;
            bVar2.f41498q = bVar.f41498q;
            bVar2.f41499r = bVar.f41499r;
        }
    }

    public void f(b bVar) {
        if (bVar == null || !bVar.b() || n(bVar)) {
            return;
        }
        try {
            g(bVar, false);
        } catch (Exception e16) {
            QLog.e(com.tencent.component.media.image.ImageManager.TAG, 1, "", e16);
        }
    }

    public String h(String str) {
        if (this.f41478e == null) {
            this.f41478e = (IPreloadServiceProxy) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI);
        }
        return com.tencent.mobileqq.qwallet.preload.a.n(str);
    }

    public String i(b bVar) {
        String md5Encode;
        if (bVar == null || (md5Encode = ((IQWalletApi) QRoute.api(IQWalletApi.class)).md5Encode(bVar.f41483b)) == null || md5Encode.length() <= 0) {
            return null;
        }
        String h16 = h(bVar.f41483b);
        if (TextUtils.isEmpty(h16)) {
            String str = bVar.f41484c;
            if (str == null) {
                str = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQWalletTmpPath();
            }
            h16 = str;
            if (!TextUtils.isEmpty(h16)) {
                if (h16.charAt(h16.length() - 1) != '/' && h16.charAt(h16.length() - 1) != '\\') {
                    h16 = h16 + '/';
                }
                h16 = h16 + md5Encode;
            }
        }
        if (TextUtils.isEmpty(h16)) {
            return null;
        }
        File file = new File(h16);
        if (!file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    protected boolean j() {
        if (this.f41474a.size() <= 0) {
            return false;
        }
        for (int size = this.f41474a.size() - 1; size >= 0; size--) {
            if (this.f41474a.get(size).f41502u || this.f41474a.get(size).f41500s <= 0) {
                return false;
            }
        }
        return true;
    }

    protected void k(b bVar) {
        Bitmap bitmap;
        synchronized (f41473f) {
            if (bVar.f41490i <= 0 && bVar.f41489h <= 0) {
                Bitmap bitmap2 = bVar.f41498q;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap = bVar.f41498q;
                } else {
                    Drawable drawable = bVar.f41497p;
                    if (drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
                        bitmap = null;
                    }
                }
                if (bitmap != null) {
                    f41473f.put(bVar.f41483b, bitmap);
                }
            }
        }
    }

    protected void m() {
        int i3;
        synchronized (this.f41474a) {
            for (int i16 = 0; i16 < this.f41474a.size(); i16++) {
                b bVar = this.f41474a.get(i16);
                if (!bVar.f41502u && !bVar.f41494m && (i3 = bVar.f41500s) > 0 && i3 < 2) {
                    this.f41474a.remove(i16);
                    g(bVar, true);
                    return;
                }
            }
        }
    }

    protected boolean n(b bVar) {
        synchronized (f41473f) {
            Bitmap bitmap = f41473f.get(bVar.f41483b);
            if (bitmap == null) {
                return false;
            }
            if (bitmap.isRecycled()) {
                f41473f.remove(bVar.f41483b);
                return false;
            }
            if (bVar.f41487f) {
                bVar.f41497p = new k(MobileQQ.sMobileQQ.getResources(), bitmap);
                bVar.f41494m = true;
            } else if (bVar.f41488g) {
                if (bVar.f41490i <= 0 && bVar.f41489h <= 0) {
                    bVar.f41498q = bitmap;
                    bVar.f41494m = true;
                }
                if (!bVar.f41486e) {
                    return false;
                }
            }
            this.f41477d.obtainMessage(1, bVar).sendToTarget();
            return true;
        }
    }
}

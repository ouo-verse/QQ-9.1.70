package cooperation.qzone.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import sy3.b;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ResDownloadManger {
    public static final int ALBUM_CROSSOVER_LOADING_BG_RESZIP = 4;
    public static final int ALBUM_CROSSOVER_LOADING_FIRST_BG_RESZIP = 7;
    public static final int BUFFER_SIZE_DECODE_BOUND = 8192;
    public static final String CRASH_TAG = "crash";
    public static final int QZONE_ADS_RES = 9;
    public static final int QZONE_FEED_RESZIP = 5;
    public static final int QZONE_OPEN_CAMERA_ANIM_RES = 10;
    public static final int QZONE_PHOTO_CATEGORY_EMPTY_PAGE_BG = 11;
    public static final int QZONE_PLUS_PUBLISH_VIDEO_GUIDE_ANIM_RES = 6;
    public static final int QZONE_POPUPWINDOW_NIGHT_MODE_ZIP = 13;
    public static final int QZONE_POPUPWINDOW_ZIP = 8;
    public static final int QZONE_RECENT_PHOTO_CALENDAR = 12;
    private static String[] RESURL = {"https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_yellow_icon_v1.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_themeAlbum.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_plus_publish_video_anim_guide_resource.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_first_page_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_default.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_ads_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_list_slide_out_video_capture_anim.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_photo_category_empty_bgs.zip", "https://d3g.qq.com/sngapp/app/update/20181210212921_4631/qzone_recent_photo_calendar.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_night_mode.zip"};
    private static String ResPath = null;
    public static final String TAG = "ResDownloadManger";
    public static final int THEME_ALBUM_RESZIP = 1;
    public static final int YELLOW_DIAMOND_RESZIP = 0;
    private static String ZipPath;
    private static ResDownloadManger mInstance;
    private LruCache<String, Bitmap> mMemoryCache;
    private QzonePreDownloadManager mImageDownloader = null;
    private Context context = BaseApplication.getContext();
    private final MultiHashMap<String, ResEntry> mPendingRequests = new MultiHashMap<>();
    private Downloader.DownloadListener mDownloadListener = new Downloader.DownloadListener() { // from class: cooperation.qzone.util.ResDownloadManger.2
        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            for (ResEntry resEntry : ResDownloadManger.this.collectPendingRequest(str, true)) {
                ResLoadListener resLoadListener = resEntry.mResLoadListener.get();
                if (resLoadListener != null) {
                    resLoadListener.onFailed(resEntry.type, resEntry.fileName);
                }
                resEntry.recycle();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            Bitmap bitmap;
            ResDownloadManger.unzipFile(ResDownloadManger.getZipPath(str));
            for (ResEntry resEntry : ResDownloadManger.this.collectPendingRequest(str, true)) {
                ResLoadListener resLoadListener = resEntry.mResLoadListener.get();
                if (resLoadListener != null) {
                    File file = ResDownloadManger.getFile(resEntry.mUrl, resEntry.fileName);
                    if (ResDownloadManger.isFileValid(file)) {
                        synchronized (this) {
                            Bitmap bitmap2 = null;
                            try {
                                bitmap = (Bitmap) ResDownloadManger.this.mMemoryCache.get(resEntry.mUrlKey);
                                if (bitmap == null) {
                                    try {
                                        bitmap = ResDownloadManger.decodeFileWithBuffer(file.getAbsolutePath(), null);
                                    } catch (Exception e16) {
                                        e = e16;
                                        bitmap2 = bitmap;
                                        e.printStackTrace();
                                        bitmap = bitmap2;
                                        if (bitmap != null) {
                                        }
                                        resEntry.recycle();
                                    } catch (OutOfMemoryError e17) {
                                        e = e17;
                                        bitmap2 = bitmap;
                                        QLog.e("crash", 1, e.toString());
                                        bitmap = bitmap2;
                                        if (bitmap != null) {
                                        }
                                        resEntry.recycle();
                                    }
                                }
                            } catch (Exception e18) {
                                e = e18;
                            } catch (OutOfMemoryError e19) {
                                e = e19;
                            }
                        }
                        if (bitmap != null) {
                            ResDownloadManger.this.mMemoryCache.put(resEntry.mUrlKey, bitmap);
                            resLoadListener.onDownloaded(resEntry.type, resEntry.fileName, bitmap);
                        } else {
                            resLoadListener.onFailed(resEntry.type, resEntry.fileName);
                        }
                    } else {
                        resLoadListener.onFailed(resEntry.type, resEntry.fileName);
                    }
                }
                resEntry.recycle();
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    };

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ResLoadListener {
        void onDownloaded(int i3, String str, Bitmap bitmap);

        void onFailed(int i3, String str);
    }

    ResDownloadManger() {
        ZipPath = getStorePath(VasConstant.INTERNAL_QZONE_RES_ZIP_DIR);
        ResPath = getStorePath(VasConstant.INTERNAL_QZONE_RES_DIR);
        this.mMemoryCache = new LruCache<>((int) (b.a() / 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean addPendingRequest(String str, ResEntry resEntry) {
        boolean z16;
        synchronized (this.mPendingRequests) {
            int sizeOf = this.mPendingRequests.sizeOf(str);
            this.mPendingRequests.add(str, resEntry);
            if (sizeOf == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<ResEntry> collectPendingRequest(String str, boolean z16) {
        return collectPendingRequest(str, z16, null);
    }

    private static void createAndClearFile(File file) {
        if (!file.exists()) {
            file.mkdir();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
            return;
        }
        file.mkdir();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (r4 != null) goto L37;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0040: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:65), block:B:26:0x0040 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFileWithBuffer(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        Bitmap bitmap = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                bitmap = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 8192), null, options);
            } catch (Exception e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "", e);
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return bitmap;
            } catch (OutOfMemoryError e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "", e);
                }
            }
            try {
                fileInputStream.close();
            } catch (IOException unused) {
                return bitmap;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResEntry generateEntry(String str, int i3, String str2, ResLoadListener resLoadListener) {
        ResEntry obtain = ResEntry.obtain(i3, str2);
        obtain.mUrl = str;
        obtain.mResLoadListener = new WeakReference<>(resLoadListener);
        obtain.type = i3;
        obtain.fileName = str2;
        return obtain;
    }

    private synchronized QzonePreDownloadManager getDownloader() {
        QzonePreDownloadManager qzonePreDownloadManager = this.mImageDownloader;
        if (qzonePreDownloadManager != null) {
            return qzonePreDownloadManager;
        }
        QzonePreDownloadManager qzonePreDownloadManager2 = QzonePreDownloadManager.getInstance();
        this.mImageDownloader = qzonePreDownloadManager2;
        return qzonePreDownloadManager2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File getFile(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return new File(ResPath + str.substring(str.lastIndexOf("/") + 1, str.length() - 4) + File.separator + str2 + ".png");
        }
        return null;
    }

    public static int getQzoneSkinFeedDropMenuResId() {
        if (QQTheme.isNowThemeIsNightForQzone()) {
            return 13;
        }
        return 8;
    }

    private static String getStorePath(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        String str2 = File.separator;
        if (!absolutePath.endsWith(str2)) {
            return absolutePath + str2;
        }
        return absolutePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getZipPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return ZipPath + str.substring(str.lastIndexOf("/") + 1, str.length());
    }

    public static ResDownloadManger getmInstance() {
        if (mInstance == null) {
            synchronized (ResDownloadManger.class) {
                mInstance = new ResDownloadManger();
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFileValid(File file) {
        if (file != null && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }

    public static void setResUrl(int i3, String str) {
        RESURL[i3] = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void starDownLoad(ResEntry resEntry) {
        if (URLUtil.isNetworkUrl(resEntry.mUrl)) {
            String zipPath = getZipPath(resEntry.mUrl);
            if (isFileDownload(resEntry.type)) {
                throwErrorMsg(resEntry);
            } else {
                getDownloader().download(resEntry.mUrl, zipPath, true, this.mDownloadListener);
            }
        }
    }

    private void throwErrorMsg(ResEntry resEntry) {
        QLog.e(TAG, 1, "startDownLoad is intercept, because file exists and try to download none resourse drawable:" + resEntry.fileName + ",it will cause always download same zip file");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unzipFile(String str) {
        String str2 = ResPath + str.substring(str.lastIndexOf("/") + 1, str.length() - 4);
        createAndClearFile(new File(str2));
        ZipUtils.unZipFolder(str, str2);
    }

    public Drawable getDrawable(int i3, String str, ResLoadListener resLoadListener) {
        Bitmap resBitmap = getResBitmap(i3, str, resLoadListener);
        if (resBitmap != null) {
            resBitmap.setDensity(320);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resBitmap);
            bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
            return bitmapDrawable;
        }
        return null;
    }

    public Drawable getDrawableAsync(int i3, String str, ResLoadListener resLoadListener) {
        Bitmap resBitmapAsync = getResBitmapAsync(i3, str, resLoadListener, null);
        if (resBitmapAsync != null) {
            resBitmapAsync.setDensity(320);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resBitmapAsync);
            bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
            return bitmapDrawable;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_LEBA_NEW, 4, "qzonepouwindow:\u4e0b\u8f7d\u8d44\u6e90\u5931\u8d25");
        }
        return null;
    }

    public Drawable getDrawableByBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.setDensity(320);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
            return bitmapDrawable;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap getResBitmap(int i3, String str, ResLoadListener resLoadListener) {
        ResEntry generateEntry;
        Bitmap bitmap;
        OutOfMemoryError e16;
        Exception e17;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap bitmap2 = this.mMemoryCache.get(i3 + " " + str);
        if (bitmap2 != null) {
            return bitmap2;
        }
        String str2 = RESURL[i3];
        File file = getFile(str2, str);
        if (isFileValid(file)) {
            synchronized (this) {
                try {
                    bitmap = this.mMemoryCache.get(i3 + " " + str);
                } catch (Exception e18) {
                    bitmap = bitmap2;
                    e17 = e18;
                } catch (OutOfMemoryError e19) {
                    bitmap = bitmap2;
                    e16 = e19;
                }
                if (bitmap != null) {
                    return bitmap;
                }
                try {
                    QLog.w(TAG, 1, "getResBitmap bitmap == null ! next to decodeFile");
                    bitmap2 = decodeFileWithBuffer(file.getAbsolutePath(), null);
                } catch (Exception e26) {
                    e17 = e26;
                    QLog.e("crash", 1, e17.toString());
                    bitmap2 = bitmap;
                    if (bitmap2 != null) {
                    }
                    generateEntry = generateEntry(str2, i3, str, resLoadListener);
                    if (addPendingRequest(str2, generateEntry)) {
                    }
                    return bitmap2;
                } catch (OutOfMemoryError e27) {
                    e16 = e27;
                    QLog.e("crash", 1, e16.toString());
                    bitmap2 = bitmap;
                    if (bitmap2 != null) {
                    }
                    generateEntry = generateEntry(str2, i3, str, resLoadListener);
                    if (addPendingRequest(str2, generateEntry)) {
                    }
                    return bitmap2;
                }
                if (bitmap2 != null) {
                    this.mMemoryCache.put(i3 + " " + str, bitmap2);
                    return bitmap2;
                }
            }
        } else {
            QLog.w(TAG, 1, "getResBitmap isFileValid: false");
        }
        generateEntry = generateEntry(str2, i3, str, resLoadListener);
        if (addPendingRequest(str2, generateEntry)) {
            starDownLoad(generateEntry);
        }
        return bitmap2;
    }

    public Bitmap getResBitmapAsync(final int i3, final String str, final ResLoadListener resLoadListener, final BitmapFactory.Options options) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap bitmap = this.mMemoryCache.get(i3 + " " + str);
        if (bitmap != null) {
            return bitmap;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: cooperation.qzone.util.ResDownloadManger.1
            /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Bitmap bitmap2;
                Bitmap bitmap3;
                String str2 = ResDownloadManger.RESURL[i3];
                File file = ResDownloadManger.getFile(str2, str);
                if (!ResDownloadManger.isFileValid(file)) {
                    ResEntry generateEntry = ResDownloadManger.this.generateEntry(str2, i3, str, resLoadListener);
                    if (ResDownloadManger.this.addPendingRequest(str2, generateEntry)) {
                        ResDownloadManger.this.starDownLoad(generateEntry);
                        return;
                    }
                    return;
                }
                synchronized (this) {
                    Bitmap bitmap4 = null;
                    try {
                        bitmap3 = (Bitmap) ResDownloadManger.this.mMemoryCache.get(i3 + " " + str);
                        try {
                        } catch (Exception e16) {
                            e = e16;
                            bitmap4 = bitmap3;
                            QLog.e("crash", 1, e.toString());
                            bitmap2 = bitmap4;
                            if (bitmap2 != null) {
                            }
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            bitmap4 = bitmap3;
                            QLog.e("crash", 1, e.toString());
                            bitmap2 = bitmap4;
                            if (bitmap2 != null) {
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                    }
                    if (bitmap3 != null) {
                        ResLoadListener resLoadListener2 = resLoadListener;
                        if (resLoadListener2 != null) {
                            resLoadListener2.onDownloaded(i3, str, bitmap3);
                        }
                        return;
                    }
                    bitmap2 = ResDownloadManger.decodeFileWithBuffer(file.getAbsolutePath(), options);
                    if (bitmap2 != null) {
                        ResDownloadManger.this.mMemoryCache.put(i3 + " " + str, bitmap2);
                        ResLoadListener resLoadListener3 = resLoadListener;
                        if (resLoadListener3 != null) {
                            resLoadListener3.onDownloaded(i3, str, bitmap2);
                        }
                    }
                }
            }
        });
        return bitmap;
    }

    public boolean isFileDownload(int i3) {
        String str = RESURL[i3];
        File file = new File(ResPath + str.substring(str.lastIndexOf("/"), str.length() - 4) + File.separator);
        if (file.isDirectory() && file.list() != null && file.list().length > 0) {
            return true;
        }
        return false;
    }

    public void removeCache(int i3, ArrayList<String> arrayList) {
        if (this.mMemoryCache != null && arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                this.mMemoryCache.remove(i3 + " " + next);
            }
        }
    }

    private Collection<ResEntry> collectPendingRequest(String str, boolean z16, Collection<ResEntry> collection) {
        synchronized (this.mPendingRequests) {
            Collection<ResEntry> collection2 = (Collection) (z16 ? this.mPendingRequests.remove(str) : this.mPendingRequests.get(str));
            if (collection == null) {
                return collection2;
            }
            collection.clear();
            if (collection2 != null) {
                collection.addAll(collection2);
            }
            return collection;
        }
    }

    public Drawable getDrawableAsync(int i3, String str, ResLoadListener resLoadListener, BitmapFactory.Options options) {
        Bitmap resBitmapAsync = getResBitmapAsync(i3, str, resLoadListener, options);
        if (resBitmapAsync == null) {
            return null;
        }
        resBitmapAsync.setDensity(320);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resBitmapAsync);
        bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
        return bitmapDrawable;
    }
}

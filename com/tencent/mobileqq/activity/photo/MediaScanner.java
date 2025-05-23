package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaScanner {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "QQAlbum";
    private static AtomicBoolean mIsScanning;
    public static AtomicBoolean misInitialized;
    private static MediaScanner sInstance;
    private String mExternalStorageDirectoryPath;
    private HashSet<String> mFileObserverPaths;
    private HashSet<FileObserver> mFileObservers;
    private HashSet<String> mMd5Set;
    private MediaDatabaseHelper mSqLiteOpenHelper;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface OnMediaInfoScannerListener {
        void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface OnMediaScannerListener {
        void onPhotoListDatasetDurationChanged(int i3, LocalMediaInfo localMediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class QueryTaskRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        LocalMediaInfo localMediaInfo;
        OnMediaInfoScannerListener onMediaScannerListener;

        QueryTaskRunnable(OnMediaInfoScannerListener onMediaInfoScannerListener, LocalMediaInfo localMediaInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onMediaInfoScannerListener, (Object) localMediaInfo);
            } else {
                this.onMediaScannerListener = onMediaInfoScannerListener;
                this.localMediaInfo = localMediaInfo;
            }
        }

        private void getVideoInfoFromExif(LocalMediaInfo localMediaInfo, OnMediaInfoScannerListener onMediaInfoScannerListener) throws IOException {
            ExifInterface exifInterface = new ExifInterface(localMediaInfo.path);
            String attribute = exifInterface.getAttribute("GPSLatitude");
            String attribute2 = exifInterface.getAttribute("GPSLatitudeRef");
            String attribute3 = exifInterface.getAttribute("GPSLongitude");
            String attribute4 = exifInterface.getAttribute("GPSLongitudeRef");
            if (attribute != null && attribute2 != null && attribute3 != null && attribute4 != null) {
                if (attribute2.equals("N")) {
                    localMediaInfo.latitude = MediaScanner.convertGpsToDegreeE6(attribute);
                } else {
                    localMediaInfo.latitude = 0 - MediaScanner.convertGpsToDegreeE6(attribute);
                }
                if (attribute4.equals("E")) {
                    localMediaInfo.longitude = MediaScanner.convertGpsToDegreeE6(attribute3);
                } else {
                    localMediaInfo.longitude = 0 - MediaScanner.convertGpsToDegreeE6(attribute3);
                }
            }
            if (localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0) {
                QLog.e("QQAlbum", 2, "queryMediaInfoAsync() width=0 || height=0, path=" + localMediaInfo.path);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(localMediaInfo.path, options);
                localMediaInfo.mediaWidth = options.outWidth;
                localMediaInfo.mediaHeight = options.outHeight;
                QLog.e("QQAlbum", 2, "queryMediaInfoAsync() After decode metadata width=" + localMediaInfo.mediaWidth + " height=" + localMediaInfo.mediaHeight + " mime=" + localMediaInfo.mMimeType);
            }
            onMediaInfoScannerListener.onMediaInfoChanged(localMediaInfo, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WeakReference weakReference = new WeakReference(this.onMediaScannerListener);
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) new WeakReference(this.localMediaInfo).get();
            OnMediaInfoScannerListener onMediaInfoScannerListener = (OnMediaInfoScannerListener) weakReference.get();
            try {
                if (localMediaInfo != null && onMediaInfoScannerListener != null) {
                    if (localMediaInfo.mMimeType.contains("video")) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        MediaScanner.getDuration(localMediaInfo, mediaMetadataRetriever);
                        MediaScanner.getRotation(localMediaInfo, mediaMetadataRetriever);
                        MediaScanner.getWidthAndHeight(localMediaInfo, mediaMetadataRetriever);
                        MediaScanner.getLocation(localMediaInfo, mediaMetadataRetriever);
                        mediaMetadataRetriever.release();
                        onMediaInfoScannerListener.onMediaInfoChanged(localMediaInfo, true);
                        MediaScanner.getInstance(BaseApplication.getContext()).mSqLiteOpenHelper.updateMediaScnnerInfoDuration(localMediaInfo.path, localMediaInfo.mDuration);
                        return;
                    }
                    getVideoInfoFromExif(localMediaInfo, onMediaInfoScannerListener);
                    return;
                }
                QLog.e("QQAlbum", 2, "info == null || listener == null");
            } catch (Exception e16) {
                QLog.e("QQAlbum", 2, "queryMediaInfoAsync() error=" + e16.getMessage());
                QLog.e("QQAlbum", 2, "queryMediaInfoAsync() StackTrace=" + Log.getStackTraceString(e16));
                if (onMediaInfoScannerListener != null) {
                    onMediaInfoScannerListener.onMediaInfoChanged(localMediaInfo, false);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        misInitialized = new AtomicBoolean(false);
        sInstance = null;
        mIsScanning = new AtomicBoolean(false);
    }

    MediaScanner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mFileObservers = new HashSet<>();
        this.mFileObserverPaths = new HashSet<>();
        this.mExternalStorageDirectoryPath = null;
    }

    private void addFileObserver(String str) {
        if (new File(str).exists() && !this.mFileObserverPaths.contains(str)) {
            this.mFileObserverPaths.add(str);
            MediaScannerFileObserver mediaScannerFileObserver = new MediaScannerFileObserver(sInstance, str);
            mediaScannerFileObserver.startWatching();
            this.mFileObservers.add(mediaScannerFileObserver);
        }
    }

    public static void buildVideoMediaInfo(LocalMediaInfo localMediaInfo) throws Throwable {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        getDuration(localMediaInfo, mediaMetadataRetriever);
        getRotation(localMediaInfo, mediaMetadataRetriever);
        getWidthAndHeight(localMediaInfo, mediaMetadataRetriever);
        getLocation(localMediaInfo, mediaMetadataRetriever);
        mediaMetadataRetriever.release();
    }

    private boolean checkNoMedia(String str, boolean z16) {
        if (z16 && !isNomediaFileExisit(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "doScanFolder() isNomediaFileExisit()=false, return");
                return true;
            }
            return true;
        }
        return false;
    }

    public static int convertGpsToDegreeE6(String str) {
        String[] split = str.split(",", 3);
        String[] split2 = split[0].split("/", 2);
        double doubleValue = Double.valueOf(split2[0]).doubleValue() / Double.valueOf(split2[1]).doubleValue();
        String[] split3 = split[1].split("/", 2);
        double doubleValue2 = Double.valueOf(split3[0]).doubleValue() / Double.valueOf(split3[1]).doubleValue();
        String[] split4 = split[2].split("/", 2);
        return (int) ((doubleValue + (doubleValue2 / 60.0d) + ((Double.valueOf(split4[0]).doubleValue() / Double.valueOf(split4[1]).doubleValue()) / 3600.0d)) * 1000000.0d);
    }

    @TargetApi(10)
    private MediaScannerInfo createMediaScannerInfo(MediaMetadataRetriever mediaMetadataRetriever, String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            try {
                MediaScannerInfo mediaScannerInfo = new MediaScannerInfo();
                mediaScannerInfo.duration = 0L;
                mediaScannerInfo.modifiedDate = file.lastModified() / 1000;
                mediaScannerInfo.fileSize = file.length();
                mediaScannerInfo.name = str2.substring(str2.lastIndexOf("/") + 1);
                mediaScannerInfo.path = str2;
                mediaScannerInfo.folderPath = str;
                mediaScannerInfo.mimeType = "video/mp4";
                mediaScannerInfo.md5 = String.valueOf(mediaScannerInfo.fileSize);
                return mediaScannerInfo;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "createMediaScannerInfo() error=" + e16.getMessage());
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    @TargetApi(10)
    private void doScanFolder(String str, boolean z16) throws IOException {
        File file = new File(str);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "doScanFolder() folderPath=" + str);
        }
        if (this.mSqLiteOpenHelper == null) {
            return;
        }
        if (file.exists() && file.isDirectory()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "doScanFolder() videoFolder.exists()=true");
            }
            if (!checkNoMedia(str, z16) && needScanFolder(str)) {
                scanFolder(str, file);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "doScanFolder() videoFolder.exists() = false");
        }
    }

    private void doScanWechatVideos() throws IOException {
        if (this.mExternalStorageDirectoryPath != null && this.mSqLiteOpenHelper != null) {
            String str = this.mExternalStorageDirectoryPath + "/tencent/MicroMsg";
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (file.isDirectory() && file.getName().length() == 32) {
                    String str2 = str + "/" + file.getName() + "/video";
                    doScanFolder(str2, true);
                    addFileObserver(str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getDuration(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        mediaMetadataRetriever.setDataSource(localMediaInfo.path);
        try {
            localMediaInfo.mDuration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (NumberFormatException e16) {
            QLog.e("QQAlbum", 2, "getDuration error. ", e16);
        }
    }

    public static synchronized MediaScanner getInstance(Context context) {
        MediaScanner mediaScanner;
        synchronized (MediaScanner.class) {
            if (sInstance == null) {
                sInstance = new MediaScanner(context);
            }
            mediaScanner = sInstance;
        }
        return mediaScanner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getLocation(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(23);
        if (extractMetadata != null) {
            try {
                ArrayList arrayList = new ArrayList(3);
                StringBuilder sb5 = new StringBuilder();
                int i3 = 0;
                for (char c16 : extractMetadata.toCharArray()) {
                    if (i3 >= 2) {
                        break;
                    }
                    if (c16 != '+' && c16 != '-' && c16 != '\n' && c16 != 0) {
                        if (!Character.isDigit(c16) && c16 != '.') {
                            QLog.e("QQAlbum", 2, "Can not under stand the location string: " + extractMetadata + " !");
                        }
                        sb5.append(c16);
                    }
                    if (sb5.length() > 0) {
                        arrayList.add(Integer.valueOf((int) (Double.parseDouble(sb5.toString()) * 1000000.0d)));
                        sb5.setLength(0);
                        i3++;
                    }
                    sb5.append(c16);
                }
                if (sb5.length() > 0) {
                    arrayList.add(Integer.valueOf((int) (Double.parseDouble(sb5.toString()) * 1000000.0d)));
                }
                if (arrayList.size() >= 2) {
                    localMediaInfo.latitude = ((Integer) arrayList.get(0)).intValue();
                    localMediaInfo.longitude = ((Integer) arrayList.get(1)).intValue();
                }
            } catch (NumberFormatException e16) {
                QLog.e("QQAlbum", 2, "getLocation error. ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getRotation(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        try {
            localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        } catch (NumberFormatException e16) {
            QLog.e("QQAlbum", 2, "getRotation error. ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getWidthAndHeight(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        try {
            localMediaInfo.mediaWidth = Integer.parseInt(extractMetadata);
            localMediaInfo.mediaHeight = Integer.parseInt(extractMetadata2);
        } catch (NumberFormatException e16) {
            QLog.e("QQAlbum", 2, "getWidthAndHeight error. ", e16);
        }
    }

    private void handleMoveToEvent(String str, String str2) {
        MediaDatabaseHelper mediaDatabaseHelper;
        String str3 = str + "/" + str2;
        File file = new File(str3);
        if (this.mMd5Set == null && (mediaDatabaseHelper = this.mSqLiteOpenHelper) != null) {
            this.mMd5Set = mediaDatabaseHelper.queryAllMediaScannerInfoMd5Set();
        }
        if (this.mMd5Set != null && this.mSqLiteOpenHelper != null) {
            if (file.exists()) {
                MediaScannerInfo createMediaScannerInfo = createMediaScannerInfo(null, str, str3);
                if (createMediaScannerInfo != null && !this.mMd5Set.contains(createMediaScannerInfo.md5)) {
                    this.mMd5Set.add(createMediaScannerInfo.md5);
                    this.mSqLiteOpenHelper.insertMediaScannerInfo(createMediaScannerInfo);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, "handleFileObserverEvent() info=null");
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "handleFileObserverEvent() mMd5Set.contains( md5 ) = true");
            }
        }
    }

    private boolean isNomediaFileExisit(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "isNomediaFileExisit() folderpath=" + str + ", mExternalStorageDirectoryPath=" + this.mExternalStorageDirectoryPath);
        }
        if (new File(this.mExternalStorageDirectoryPath).equals(new File(str))) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "isNomediaFileExisit() root folder, return false");
                return false;
            }
            return false;
        }
        File file = new File(str + "/.nomedia");
        if (file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "isNomediaFileExisit() nomediaFile=" + file + " exist, return true");
            }
            return true;
        }
        return isNomediaFileExisit(new File(str).getParent());
    }

    private boolean needScanFolder(String str) {
        long lastModified = new File(str).lastModified();
        MediaScannerFolderInfo queryMediaScannerFolderInfoByFolderpath = this.mSqLiteOpenHelper.queryMediaScannerFolderInfoByFolderpath(str);
        if (queryMediaScannerFolderInfoByFolderpath != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "needScanFolder() lastModified=" + lastModified + ", info.modifiedDate=" + queryMediaScannerFolderInfoByFolderpath.modifiedDate);
            }
            if (lastModified == queryMediaScannerFolderInfoByFolderpath.modifiedDate) {
                return false;
            }
            return true;
        }
        return true;
    }

    private void preScan() {
        HashSet<String> queryAllMediaScannerFolderPathSet;
        Iterator<String> it;
        MediaDatabaseHelper mediaDatabaseHelper = this.mSqLiteOpenHelper;
        if (mediaDatabaseHelper == null || (it = (queryAllMediaScannerFolderPathSet = mediaDatabaseHelper.queryAllMediaScannerFolderPathSet()).iterator()) == null) {
            return;
        }
        while (it.hasNext()) {
            if (new File(it.next()).exists()) {
                it.remove();
            }
        }
        this.mSqLiteOpenHelper.deleteMediaScannerInfoByFolderPathSet(queryAllMediaScannerFolderPathSet);
    }

    private void scanFolder(String str, File file) {
        HashSet<String> hashSet;
        File[] listFiles = file.listFiles();
        HashSet<String> queryAllMediaScannerInfoPathSetByFolder = this.mSqLiteOpenHelper.queryAllMediaScannerInfoPathSetByFolder(str);
        ArrayList<MediaScannerInfo> arrayList = new ArrayList<>();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".mp4")) {
                    String str2 = str + "/" + file2.getName();
                    if (!queryAllMediaScannerInfoPathSetByFolder.contains(str2) && (hashSet = this.mMd5Set) != null && !hashSet.contains(String.valueOf(file2.length()))) {
                        MediaScannerInfo createMediaScannerInfo = createMediaScannerInfo(null, str, str2);
                        if (createMediaScannerInfo != null) {
                            arrayList.add(createMediaScannerInfo);
                            this.mMd5Set.add(String.valueOf(createMediaScannerInfo.fileSize));
                        }
                    } else {
                        queryAllMediaScannerInfoPathSetByFolder.remove(str2);
                    }
                }
            }
        }
        this.mSqLiteOpenHelper.deleteMediaScannerInfoByPathSet(queryAllMediaScannerInfoPathSetByFolder);
        this.mSqLiteOpenHelper.insertMediaScannerInfoByList(arrayList);
        updateScanFolderInfo(str);
    }

    private void updateScanFolderInfo(String str) {
        long lastModified = new File(str).lastModified();
        MediaScannerFolderInfo queryMediaScannerFolderInfoByFolderpath = this.mSqLiteOpenHelper.queryMediaScannerFolderInfoByFolderpath(str);
        if (queryMediaScannerFolderInfoByFolderpath != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "needScanFolder() lastModified=" + lastModified + ", info.modifiedDate=" + queryMediaScannerFolderInfoByFolderpath.modifiedDate);
            }
            if (lastModified > queryMediaScannerFolderInfoByFolderpath.modifiedDate) {
                queryMediaScannerFolderInfoByFolderpath.modifiedDate = lastModified;
                this.mSqLiteOpenHelper.updateMediaScnnerFolderInfo(queryMediaScannerFolderInfoByFolderpath);
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "needScanFolder() lastModified > info.modifiedDate , run updateMediaScnnerFolderInfo()");
                    return;
                }
                return;
            }
            return;
        }
        MediaScannerFolderInfo mediaScannerFolderInfo = new MediaScannerFolderInfo();
        mediaScannerFolderInfo.folderpath = str;
        mediaScannerFolderInfo.modifiedDate = lastModified;
        this.mSqLiteOpenHelper.insertMediaScnnerFolderInfo(mediaScannerFolderInfo);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "updateScanFolderInfo() run insertMediaScnnerFolderInfo()");
        }
    }

    public void buildAndUpdateVideo(LocalMediaInfo localMediaInfo) throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) localMediaInfo);
        } else {
            buildVideoMediaInfo(localMediaInfo);
            this.mSqLiteOpenHelper.updateMediaScnnerInfoDuration(localMediaInfo.path, localMediaInfo.mDuration);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.concurrent.atomic.AtomicBoolean] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public synchronized void doScan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return;
        }
        if (misInitialized.get()) {
            return;
        }
        if (!mIsScanning.get()) {
            mIsScanning.set(true);
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "doScan() start");
            }
            boolean z16 = 0;
            try {
                try {
                    preScan();
                    doScanWechatVideos();
                    mIsScanning.set(false);
                    z16 = misInitialized;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    mIsScanning.set(false);
                    z16 = misInitialized;
                }
                z16.set(true);
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "doScan() finish");
                }
            } catch (Throwable th5) {
                mIsScanning.set(z16);
                misInitialized.set(true);
                throw th5;
            }
        }
    }

    public synchronized ArrayList<MediaScannerInfo> getMediaScannerInfos(boolean z16, int i3) {
        ArrayList<MediaScannerInfo> queryAllLongVideoMediaScannerInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        String str = null;
        if (this.mSqLiteOpenHelper == null) {
            return null;
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        if (i3 != -1) {
            str = String.valueOf(i3);
        }
        if (!z16) {
            queryAllLongVideoMediaScannerInfo = this.mSqLiteOpenHelper.queryAllMediaScannerInfo(str);
        } else {
            queryAllLongVideoMediaScannerInfo = this.mSqLiteOpenHelper.queryAllLongVideoMediaScannerInfo(str);
        }
        return queryAllLongVideoMediaScannerInfo;
    }

    public synchronized int getMediaScannerInfosCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.mSqLiteOpenHelper == null) {
            return 0;
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return 0;
        }
        return this.mSqLiteOpenHelper.queryAllMediaScannerInfoCnt();
    }

    @TargetApi(10)
    public void handleFileObserverEvent(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "handleFileObserverEvent() is called event=" + i3);
        }
        if (!misInitialized.get()) {
            return;
        }
        if (i3 != 8 && i3 != 128) {
            if (i3 == 512) {
                String str3 = str + "/" + str2;
                if (new File(str3).exists() || this.mSqLiteOpenHelper == null) {
                    return;
                }
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str3);
                this.mSqLiteOpenHelper.deleteMediaScannerInfoByPathSet(hashSet);
                return;
            }
            return;
        }
        handleMoveToEvent(str, str2);
    }

    @TargetApi(10)
    public void queryMediaInfoAsync(OnMediaInfoScannerListener onMediaInfoScannerListener, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onMediaInfoScannerListener, (Object) localMediaInfo);
            return;
        }
        QueryTaskRunnable queryTaskRunnable = new QueryTaskRunnable(onMediaInfoScannerListener, localMediaInfo);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(queryTaskRunnable, 64, null, true);
        } else {
            queryTaskRunnable.run();
        }
    }

    @TargetApi(10)
    public void queryMediaInfoDuration(OnMediaScannerListener onMediaScannerListener, LocalMediaInfo localMediaInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, onMediaScannerListener, localMediaInfo, Integer.valueOf(i3));
        } else {
            ThreadManagerV2.excute(new Runnable(new WeakReference(localMediaInfo), new WeakReference(onMediaScannerListener), i3) { // from class: com.tencent.mobileqq.activity.photo.MediaScanner.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference val$infoReference;
                final /* synthetic */ WeakReference val$listenerReference;
                final /* synthetic */ int val$position;

                {
                    this.val$infoReference = r6;
                    this.val$listenerReference = r7;
                    this.val$position = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MediaScanner.this, r6, r7, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) this.val$infoReference.get();
                        OnMediaScannerListener onMediaScannerListener2 = (OnMediaScannerListener) this.val$listenerReference.get();
                        if (localMediaInfo2 != null && onMediaScannerListener2 != null) {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(localMediaInfo2.path);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                            mediaMetadataRetriever.release();
                            localMediaInfo2.mDuration = Long.parseLong(extractMetadata);
                            onMediaScannerListener2.onPhotoListDatasetDurationChanged(this.val$position, localMediaInfo2);
                            MediaScanner.getInstance(BaseApplication.getContext()).mSqLiteOpenHelper.updateMediaScnnerInfoDuration(localMediaInfo2.path, localMediaInfo2.mDuration);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQAlbum", 2, "queryMediaInfoDuration() error=" + e16.getMessage());
                        }
                    }
                }
            }, 64, null, true);
        }
    }

    MediaScanner(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.mFileObservers = new HashSet<>();
        this.mFileObserverPaths = new HashSet<>();
        this.mExternalStorageDirectoryPath = null;
        this.mSqLiteOpenHelper = MediaDatabaseHelper.getInstance(context);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            this.mExternalStorageDirectoryPath = externalStorageDirectory.getAbsolutePath();
        }
        MediaDatabaseHelper mediaDatabaseHelper = this.mSqLiteOpenHelper;
        if (mediaDatabaseHelper != null) {
            this.mMd5Set = mediaDatabaseHelper.queryAllMediaScannerInfoMd5Set();
        }
    }
}

package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.utils.Logger;
import com.tencent.oskplayer.cache.FileDataSink;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class NetworkCache {

    @NonNull
    private final LottieNetworkCacheProvider cacheProvider;

    public NetworkCache(@NonNull LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.cacheProvider = lottieNetworkCacheProvider;
    }

    private static String filenameForUrl(String str, FileExtension fileExtension, boolean z16) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("lottie_cache_");
        sb5.append(str.replaceAll("\\W+", ""));
        if (z16) {
            str2 = fileExtension.tempExtension();
        } else {
            str2 = fileExtension.extension;
        }
        sb5.append(str2);
        return sb5.toString();
    }

    @Nullable
    private File getCachedFile(String str) throws FileNotFoundException {
        File file = new File(parentDir(), filenameForUrl(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(parentDir(), filenameForUrl(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File parentDir() {
        File cacheDir = this.cacheProvider.getCacheDir();
        if (cacheDir.isFile()) {
            cacheDir.delete();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public void clear() {
        File parentDir = parentDir();
        if (parentDir.exists()) {
            File[] listFiles = parentDir.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : parentDir.listFiles()) {
                    file.delete();
                }
            }
            parentDir.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> fetch(String str) {
        FileExtension fileExtension;
        try {
            File cachedFile = getCachedFile(str);
            if (cachedFile == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(cachedFile);
            if (cachedFile.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            Logger.debug("Cache hit for " + str + " at " + cachedFile.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void renameTempFile(String str, FileExtension fileExtension) {
        File file = new File(parentDir(), filenameForUrl(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(FileDataSink.TEMP_FILE, ""));
        boolean renameTo = file.renameTo(file2);
        Logger.debug("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            Logger.warning("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File writeTempCacheFile(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(parentDir(), filenameForUrl(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}

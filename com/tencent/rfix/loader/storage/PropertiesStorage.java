package com.tencent.rfix.loader.storage;

import android.content.Context;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.FileLockHelper;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

/* loaded from: classes25.dex */
public class PropertiesStorage implements IRFixStorage {
    private static final String TAG = "RFix.PropertiesStorage";
    private final File file;
    private final Properties properties = new Properties();

    public PropertiesStorage(Context context, String str) {
        this.file = new File(PatchFileUtils.getPatchDirectory(context), str + ".prop");
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public boolean contains(String str) {
        return this.properties.containsKey(str);
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public boolean delete(boolean z16) {
        if (!this.file.exists()) {
            return true;
        }
        FileLockHelper fileLockHelper = null;
        try {
            if (z16) {
                try {
                    fileLockHelper = FileLockHelper.getFileLock(new File(this.file.getAbsolutePath() + ".lock"));
                } catch (FileNotFoundException unused) {
                    PatchFileUtils.closeQuietly(fileLockHelper);
                    return false;
                } catch (Exception e16) {
                    RFixLog.e(TAG, "delete fail!", e16);
                    PatchFileUtils.closeQuietly(fileLockHelper);
                    return false;
                }
            }
            return this.file.delete();
        } finally {
            PatchFileUtils.closeQuietly(fileLockHelper);
        }
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public boolean getBoolean(String str, boolean z16) {
        if (this.properties.containsKey(str)) {
            return Boolean.parseBoolean(this.properties.getProperty(str));
        }
        return z16;
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public int getInt(String str, int i3) {
        if (this.properties.containsKey(str)) {
            return Integer.parseInt(this.properties.getProperty(str));
        }
        return i3;
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public long getLong(String str, long j3) {
        if (this.properties.containsKey(str)) {
            return Long.parseLong(this.properties.getProperty(str));
        }
        return j3;
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public String getString(String str, String str2) {
        if (this.properties.containsKey(str)) {
            return this.properties.getProperty(str);
        }
        return str2;
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public void load(boolean z16) {
        FileInputStream fileInputStream;
        FileLockHelper fileLock;
        if (!this.file.exists()) {
            return;
        }
        FileLockHelper fileLockHelper = null;
        if (z16) {
            try {
                fileLock = FileLockHelper.getFileLock(new File(this.file.getAbsolutePath() + ".lock"));
            } catch (FileNotFoundException unused) {
                fileInputStream = null;
                PatchFileUtils.closeQuietly(fileLockHelper);
                PatchFileUtils.closeQuietly(fileInputStream);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
                try {
                    RFixLog.e(TAG, "load fail!", e);
                    PatchFileUtils.closeQuietly(fileLockHelper);
                    PatchFileUtils.closeQuietly(fileInputStream);
                } catch (Throwable th5) {
                    th = th5;
                    PatchFileUtils.closeQuietly(fileLockHelper);
                    PatchFileUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                PatchFileUtils.closeQuietly(fileLockHelper);
                PatchFileUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } else {
            fileLock = null;
        }
        try {
            fileInputStream = new FileInputStream(this.file);
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
        } catch (Exception e17) {
            fileLockHelper = fileLock;
            e = e17;
            fileInputStream = null;
        } catch (Throwable th7) {
            fileLockHelper = fileLock;
            th = th7;
            fileInputStream = null;
        }
        try {
            this.properties.load(fileInputStream);
            PatchFileUtils.closeQuietly(fileLock);
        } catch (FileNotFoundException unused3) {
            fileLockHelper = fileLock;
            PatchFileUtils.closeQuietly(fileLockHelper);
            PatchFileUtils.closeQuietly(fileInputStream);
        } catch (Exception e18) {
            fileLockHelper = fileLock;
            e = e18;
            RFixLog.e(TAG, "load fail!", e);
            PatchFileUtils.closeQuietly(fileLockHelper);
            PatchFileUtils.closeQuietly(fileInputStream);
        } catch (Throwable th8) {
            fileLockHelper = fileLock;
            th = th8;
            PatchFileUtils.closeQuietly(fileLockHelper);
            PatchFileUtils.closeQuietly(fileInputStream);
            throw th;
        }
        PatchFileUtils.closeQuietly(fileInputStream);
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public void putBoolean(String str, boolean z16) {
        this.properties.setProperty(str, String.valueOf(z16));
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public void putInt(String str, int i3) {
        this.properties.setProperty(str, String.valueOf(i3));
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public void putLong(String str, long j3) {
        this.properties.setProperty(str, String.valueOf(j3));
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public void putString(String str, String str2) {
        Properties properties = this.properties;
        if (str2 == null) {
            str2 = "";
        }
        properties.setProperty(str, str2);
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public void remove(String str) {
        this.properties.remove(str);
    }

    @Override // com.tencent.rfix.loader.storage.IRFixStorage
    public void save(boolean z16) {
        FileOutputStream fileOutputStream;
        FileLockHelper fileLock;
        FileLockHelper fileLockHelper = null;
        if (z16) {
            try {
                fileLock = FileLockHelper.getFileLock(new File(this.file.getAbsolutePath() + ".lock"));
            } catch (Exception e16) {
                e = e16;
                fileOutputStream = null;
                try {
                    RFixLog.e(TAG, "save fail!", e);
                    PatchFileUtils.closeQuietly(fileLockHelper);
                    PatchFileUtils.closeQuietly(fileOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    PatchFileUtils.closeQuietly(fileLockHelper);
                    PatchFileUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                PatchFileUtils.closeQuietly(fileLockHelper);
                PatchFileUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } else {
            fileLock = null;
        }
        try {
            File parentFile = this.file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            fileOutputStream = new FileOutputStream(this.file);
        } catch (Exception e17) {
            fileLockHelper = fileLock;
            e = e17;
            fileOutputStream = null;
        } catch (Throwable th7) {
            fileLockHelper = fileLock;
            th = th7;
            fileOutputStream = null;
        }
        try {
            this.properties.store(fileOutputStream, (String) null);
            PatchFileUtils.closeQuietly(fileLock);
        } catch (Exception e18) {
            fileLockHelper = fileLock;
            e = e18;
            RFixLog.e(TAG, "save fail!", e);
            PatchFileUtils.closeQuietly(fileLockHelper);
            PatchFileUtils.closeQuietly(fileOutputStream);
        } catch (Throwable th8) {
            fileLockHelper = fileLock;
            th = th8;
            PatchFileUtils.closeQuietly(fileLockHelper);
            PatchFileUtils.closeQuietly(fileOutputStream);
            throw th;
        }
        PatchFileUtils.closeQuietly(fileOutputStream);
    }
}

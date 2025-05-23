package com.tencent.mobileqq.richmedia.capture.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CaptureRedDotConfig implements Serializable {
    public static final String CACHE_RED_DOT_NAME = "qim_red_dot_config.cfg";
    public static final String DEFAULT_CATEGORY_ID = "defaultCategoryId";
    public static final String DEFAULT_CATEGORY_VERSION = "defaultCategoryVersion";
    public static final String DEFAULT_USE_ID = "defaultUseId";
    public static final String DEFAULT_USE_VERSION = "defaultUseVersion";
    public static final int DOT_DEFAULT_CATEGORY = 5;
    public static final int DOT_TYPE_DEFAULT_USE = 4;
    public static final int DOT_TYPE_ITEM_ICON = 3;
    public static final int DOT_TYPE_SECOND_ICON = 2;
    public static final int DOT_TYPE_TOP_ICON = 1;
    public static final String ICON_VERSION_ID = "iconRedDotVersion";
    public static final int ILLEGAL_INDEX = -1;
    public static final String RED_DOT_LIST = "itemNeedRedDot";
    public static final String RED_DOT_LIST_VERSION = "itemRedDotVersion";
    public static final String SHOW_RED_DOT = "needRedDot";
    public static int SHOW_TIME_DEFAULT = 86400000;
    public static final String TAG = "QIMRedDotConfig";
    public static final int TYPE_FILTER_REDDOT = 1;
    public static final int TYPE_PTV_TEMPLATE_REDDOT = 2;
    public static final String VERSION_ID = "redDotVersion";
    private static final long serialVersionUID = 1;
    public int defaultCategoryId;
    public int defaultCategoryVer;
    public String defaultUseId;
    public int defaultUseVer;
    public long firstShowTime;
    public boolean hasChoose;
    public boolean hasShow;
    public boolean hasUse;
    public int iconVersion;
    public int redDotVersion;
    public boolean showRedDot;
    public int showTime;
    public int type;
    public HashMap<String, RedDotItemConfig> redDotItems = new HashMap<>();
    public transient boolean isShowing = false;
    public transient boolean update = false;
    public HashMap<Integer, CategoryRedConfig> categories = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class CategoryRedConfig implements Serializable {
        public int categoryId;
        public long firstShowTime;
        public boolean hasShow;
        public transient boolean isShowing = false;
        public boolean showRedDot;
        public int version;

        public String toString() {
            return "{categoryId=" + this.categoryId + ", version=" + this.version + ", showRedDot=" + this.showRedDot + ", hasShow=" + this.hasShow + ", firstShowTime=" + this.firstShowTime + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class RedDotItemConfig implements Serializable {
        public String filterId;
        public long firstShowTime;
        public boolean hasShow;
        public transient boolean isShowing = false;

        public String toString() {
            return "RedDotItemConfig{filterId='" + this.filterId + "', hasShow=" + this.hasShow + ", firstShowTime=" + this.firstShowTime + '}';
        }
    }

    public CaptureRedDotConfig(int i3) {
        this.type = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CaptureRedDotConfig getRedDotConfigFromFile(String str, String str2) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str, "qim_red_dot_config.cfg");
        if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig" + str2, 2, "getRedDotConfigFromFile path=" + file.getPath() + " exist=" + file.exists());
        }
        if (!file.exists()) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        } catch (Exception e16) {
            e = e16;
            objectInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (objectInputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                CaptureRedDotConfig captureRedDotConfig = (CaptureRedDotConfig) objectInputStream.readObject();
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig" + str2, 2, "read getRedDotConfigFromFile success! " + captureRedDotConfig);
                }
                try {
                    objectInputStream.close();
                } catch (IOException unused) {
                }
                return captureRedDotConfig;
            } catch (Throwable th6) {
                th = th6;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            file.delete();
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig", 2, "read getRedDotConfigFromFile failed " + e.getMessage());
            }
            if (objectInputStream == null) {
                return null;
            }
            try {
                objectInputStream.close();
                return null;
            } catch (IOException unused3) {
                return null;
            }
        }
    }

    public static void saveRedDotConfig(final CaptureRedDotConfig captureRedDotConfig, final String str, final String str2) {
        if (captureRedDotConfig != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig" + str2, 2, "saveRedDotConfig|config= " + captureRedDotConfig);
            }
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.1
                /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
                
                    if (r3 != null) goto L41;
                 */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    ObjectOutputStream objectOutputStream;
                    Exception e16;
                    synchronized (this) {
                        File file = new File(str, "qim_red_dot_config.cfg");
                        if (file.exists()) {
                            file.delete();
                        }
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                        } catch (Exception e17) {
                            objectOutputStream = null;
                            e16 = e17;
                        } catch (Throwable th5) {
                            th = th5;
                            if (objectOutputStream2 != null) {
                            }
                            throw th;
                        }
                        try {
                            try {
                                objectOutputStream.writeObject(captureRedDotConfig);
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMRedDotConfig" + str2, 2, "save saveRedDotConfig success!");
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e18) {
                            e16 = e18;
                            e16.printStackTrace();
                            QLog.e("QIMRedDotConfig", 2, "save saveRedDotConfig failed!" + e16.getMessage());
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            });
        }
    }

    public boolean needShowRedDot(int i3, int i16, String str) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                return showRedDot(i16, str);
            }
            return showCategoryRedDot(i16);
        }
        return showIconRedDot();
    }

    public boolean showCategoryRedDot(int i3) {
        CategoryRedConfig categoryRedConfig;
        if (this.categories.size() > 0 && (categoryRedConfig = this.categories.get(Integer.valueOf(i3))) != null && categoryRedConfig.showRedDot) {
            if (!categoryRedConfig.hasShow) {
                if (categoryRedConfig.firstShowTime > 0) {
                    if (System.currentTimeMillis() - categoryRedConfig.firstShowTime < this.showTime) {
                        categoryRedConfig.isShowing = true;
                        return true;
                    }
                    this.update = true;
                    categoryRedConfig.hasShow = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot out of time | id=" + categoryRedConfig.categoryId);
                        return false;
                    }
                    return false;
                }
                this.update = true;
                categoryRedConfig.firstShowTime = System.currentTimeMillis();
                categoryRedConfig.isShowing = true;
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot hasShow | id=" + categoryRedConfig.categoryId);
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean showIconRedDot() {
        if (!this.showRedDot) {
            return false;
        }
        if (this.hasShow) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig", 2, "showIconRedDot hasShow | type=" + this.type);
            }
            return false;
        }
        if (this.firstShowTime > 0) {
            if (System.currentTimeMillis() - this.firstShowTime >= this.showTime) {
                this.hasShow = true;
                this.update = true;
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig", 2, "showIconRedDot out of time | type=" + this.type);
                }
                return false;
            }
            this.isShowing = true;
            return true;
        }
        this.firstShowTime = System.currentTimeMillis();
        this.isShowing = true;
        this.update = true;
        return true;
    }

    public boolean showRedDot(int i3, String str) {
        RedDotItemConfig redDotItemConfig;
        if (!this.redDotItems.isEmpty() && !TextUtils.isEmpty(str) && !str.equals(this.defaultUseId) && (redDotItemConfig = this.redDotItems.get(str)) != null) {
            if (!redDotItemConfig.hasShow) {
                if (redDotItemConfig.firstShowTime > 0) {
                    if (System.currentTimeMillis() - redDotItemConfig.firstShowTime < this.showTime) {
                        redDotItemConfig.isShowing = true;
                        return true;
                    }
                    this.update = true;
                    redDotItemConfig.hasShow = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMRedDotConfig", 2, "showRedDot out of time | id=" + redDotItemConfig.filterId);
                    }
                } else {
                    this.update = true;
                    redDotItemConfig.firstShowTime = System.currentTimeMillis();
                    redDotItemConfig.isShowing = true;
                    return true;
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig", 2, "showRedDot hasShow | id=" + redDotItemConfig.filterId);
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("QIMRedDotConfig{");
        sb5.append("type=");
        sb5.append(this.type);
        sb5.append(", iconVersion=");
        sb5.append(this.iconVersion);
        sb5.append(", showRedDot=");
        sb5.append(this.showRedDot);
        sb5.append(", hasShow=");
        sb5.append(this.hasShow);
        sb5.append(", firstShowTime=");
        sb5.append(this.firstShowTime);
        sb5.append(", defaultUseVer=");
        sb5.append(this.defaultUseVer);
        sb5.append(", defaultUseId='");
        sb5.append(this.defaultUseId);
        sb5.append('\'');
        sb5.append(", hasUse=");
        sb5.append(this.hasUse);
        sb5.append(", defaultCategoryVer=");
        sb5.append(this.defaultCategoryVer);
        sb5.append(", defaultCategoryId=");
        sb5.append(this.defaultCategoryId);
        sb5.append(", hasChoose=");
        sb5.append(this.hasChoose);
        sb5.append(", redDotVersion=");
        sb5.append(this.redDotVersion);
        sb5.append(", redDotItems=");
        sb5.append(this.redDotItems);
        sb5.append(", showTime=");
        sb5.append(this.showTime);
        Iterator<Map.Entry<Integer, CategoryRedConfig>> it = this.categories.entrySet().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().getValue() + "\n");
        }
        sb5.append('}');
        return sb5.toString();
    }

    public boolean updateRedDotInfo(int i3, int i16, String str) {
        boolean z16 = false;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && this.defaultCategoryId != -1 && !this.hasChoose) {
                            this.hasChoose = true;
                            z16 = true;
                        }
                    } else if (!TextUtils.isEmpty(this.defaultUseId) && !this.hasUse) {
                        this.hasUse = true;
                        z16 = true;
                    }
                } else {
                    RedDotItemConfig redDotItemConfig = this.redDotItems.get(str);
                    if (redDotItemConfig != null && redDotItemConfig.isShowing && !redDotItemConfig.hasShow) {
                        redDotItemConfig.hasShow = true;
                        redDotItemConfig.firstShowTime = 0L;
                        redDotItemConfig.isShowing = false;
                        z16 = true;
                    }
                }
            } else {
                CategoryRedConfig categoryRedConfig = this.categories.get(Integer.valueOf(i16));
                if (categoryRedConfig != null && categoryRedConfig.isShowing && !categoryRedConfig.hasShow) {
                    categoryRedConfig.hasShow = true;
                    categoryRedConfig.firstShowTime = 0L;
                    categoryRedConfig.isShowing = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMRedDotConfig", 2, "\u66f4\u65b0has show = " + categoryRedConfig.hasShow);
                    }
                    z16 = true;
                }
            }
        } else if (this.isShowing && !this.hasShow) {
            this.hasShow = true;
            this.firstShowTime = 0L;
            this.isShowing = false;
            z16 = true;
        }
        if (z16) {
            this.update = true;
        }
        return z16;
    }
}

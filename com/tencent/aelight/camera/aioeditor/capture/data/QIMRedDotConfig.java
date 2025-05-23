package com.tencent.aelight.camera.aioeditor.capture.data;

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

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMRedDotConfig implements Serializable {
    public static final String CACHE_RED_DOT_NAME = "qim_red_dot_config.cfg";
    public static final String COMB0_ICON_VERSION_ID = "combo_iconRedDotVersion";
    public static final String COMBO_DEFAULT_CATEGORY_ID = "combo_defaultCategoryId";
    public static final String COMBO_DEFAULT_CATEGORY_VERSION = "combo_defaultCategoryVersion";
    public static final String COMBO_SHOW_RED_DOT = "combo_needRedDot";
    public static final String DEFAULT_CATEGORY_ID = "defaultCategoryId";
    public static final String DEFAULT_CATEGORY_VERSION = "defaultCategoryVersion";
    public static final String DEFAULT_USE_ID = "defaultUseId";
    public static final String DEFAULT_USE_VERSION = "defaultUseVersion";
    public static final int DOT_TYPE_COMBO_CATEGORY = 7;
    public static final int DOT_TYPE_DEFAULT_USE = 4;
    public static final int DOT_TYPE_FILTER_CATEGORY = 5;
    public static final int DOT_TYPE_ITEM_ICON = 3;
    public static final int DOT_TYPE_SECOND_ICON = 2;
    public static final int DOT_TYPE_TOP_ICON = 1;
    public static final int DOT_TYPE_TOP_ICON_COMBO = 6;
    public static final String ICON_VERSION_ID = "iconRedDotVersion";
    public static final int ILLEGAL_INDEX = -1;
    public static final String RED_DOT_LIST = "itemNeedRedDot";
    public static final String RED_DOT_LIST_VERSION = "itemRedDotVersion";
    public static final String SHOW_RED_DOT = "needRedDot";
    public static final int SHOW_TIME = 86400000;
    public static final String TAG = "QIMRedDotConfig";
    public static final int TYPE_FILTER_REDDOT = 1;
    public static final int TYPE_PTV_TEMPLATE_REDDOT = 2;
    public static final String VERSION_ID = "redDotVersion";
    private static final long serialVersionUID = 1;
    public int comboDefaultCategoryId;
    public int comboDefaultCategoryVer;
    public long comboFirstShowTime;
    public boolean comboHasChoose;
    public boolean comboHasShow;
    public int comboIconVersion;
    public boolean comboShowRedDot;
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
    public int type;
    public HashMap<String, RedDotItemConfig> redDotItems = new HashMap<>();
    public transient boolean isShowing = false;
    public transient boolean isComboShowing = false;
    public transient boolean update = false;
    public HashMap<Integer, CategoryRedConfig> categories = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes32.dex */
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
    /* loaded from: classes32.dex */
    public static class RedDotItemConfig implements Serializable {
        public String filterId;
        public long firstShowTime;
        public boolean hasShow;
        public transient boolean isShowing = false;

        public String toString() {
            return "RedDotItemConfig{filterId='" + this.filterId + "', hasShow=" + this.hasShow + ", firstShowTime=" + this.firstShowTime + '}';
        }
    }

    public QIMRedDotConfig(int i3) {
        this.type = i3;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
    public static QIMRedDotConfig getRedDotConfigFromFile(String str) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str, "qim_red_dot_config.cfg");
        if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig", 2, "getRedDotConfigFromFile path=" + file.getPath() + " exist=" + file.exists());
        }
        ?? exists = file.exists();
        try {
            if (exists == 0) {
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
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            try {
                QIMRedDotConfig qIMRedDotConfig = (QIMRedDotConfig) objectInputStream.readObject();
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig", 2, "read getRedDotConfigFromFile success! " + qIMRedDotConfig);
                }
                try {
                    objectInputStream.close();
                } catch (IOException unused2) {
                }
                return qIMRedDotConfig;
            } catch (Exception e17) {
                e = e17;
                file.delete();
                QLog.e("QIMRedDotConfig", 1, "read getRedDotConfigFromFile failed ", e);
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
        } catch (Throwable th6) {
            th = th6;
            objectInputStream2 = exists;
        }
    }

    public boolean showCategoryRedDot(int i3) {
        CategoryRedConfig categoryRedConfig;
        if (this.categories.size() <= 0 || (categoryRedConfig = this.categories.get(Integer.valueOf(i3))) == null || !categoryRedConfig.showRedDot) {
            return false;
        }
        if (categoryRedConfig.hasShow) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot hasShow | id=" + categoryRedConfig.categoryId);
            return false;
        }
        if (categoryRedConfig.firstShowTime <= 0) {
            this.update = true;
            categoryRedConfig.firstShowTime = System.currentTimeMillis();
            categoryRedConfig.isShowing = true;
            return true;
        }
        if (System.currentTimeMillis() - categoryRedConfig.firstShowTime < 86400000) {
            categoryRedConfig.isShowing = true;
            return true;
        }
        this.update = true;
        categoryRedConfig.hasShow = true;
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot out of time | id=" + categoryRedConfig.categoryId);
        return false;
    }

    public boolean showComboIconRedDot() {
        if (!this.comboShowRedDot) {
            return false;
        }
        if (this.comboHasShow) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig", 2, "showIconRedDot hasShow | type=" + this.type);
            }
            return false;
        }
        if (this.comboFirstShowTime <= 0) {
            this.comboFirstShowTime = System.currentTimeMillis();
            this.isComboShowing = true;
            this.update = true;
            return true;
        }
        if (System.currentTimeMillis() - this.comboFirstShowTime >= 86400000) {
            this.comboHasShow = true;
            this.update = true;
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig", 2, "showIconRedDot out of time | type=" + this.type);
            }
            return false;
        }
        this.isComboShowing = true;
        return true;
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
        if (this.firstShowTime <= 0) {
            this.firstShowTime = System.currentTimeMillis();
            this.isShowing = true;
            this.update = true;
            return true;
        }
        if (System.currentTimeMillis() - this.firstShowTime >= 86400000) {
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

    public boolean showRedDot(int i3, String str) {
        RedDotItemConfig redDotItemConfig;
        if (!this.redDotItems.isEmpty() && !TextUtils.isEmpty(str) && !str.equals(this.defaultUseId) && (redDotItemConfig = this.redDotItems.get(str)) != null) {
            if (redDotItemConfig.hasShow) {
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig", 2, "showRedDot hasShow | id=" + redDotItemConfig.filterId);
                }
            } else {
                if (redDotItemConfig.firstShowTime <= 0) {
                    this.update = true;
                    redDotItemConfig.firstShowTime = System.currentTimeMillis();
                    redDotItemConfig.isShowing = true;
                    return true;
                }
                if (System.currentTimeMillis() - redDotItemConfig.firstShowTime < 86400000) {
                    redDotItemConfig.isShowing = true;
                    return true;
                }
                this.update = true;
                redDotItemConfig.hasShow = true;
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig", 2, "showRedDot out of time | id=" + redDotItemConfig.filterId);
                }
            }
        }
        return false;
    }

    public String toString() {
        return "QIMRedDotConfig{type=" + this.type + ", iconVersion=" + this.iconVersion + ", showRedDot=" + this.showRedDot + ", hasShow=" + this.hasShow + ", firstShowTime=" + this.firstShowTime + ", comboIconVersion=" + this.comboIconVersion + ", comboShowRedDot=" + this.comboShowRedDot + ", comboHasShow=" + this.comboHasShow + ", comboFirstShowTime=" + this.comboFirstShowTime + ", defaultUseVer=" + this.defaultUseVer + ", defaultUseId='" + this.defaultUseId + "', hasUse=" + this.hasUse + ", defaultCategoryVer=" + this.defaultCategoryVer + ", defaultCategoryId=" + this.defaultCategoryId + ", hasChoose=" + this.hasChoose + ", redDotVersion=" + this.redDotVersion + ", redDotItems=" + this.redDotItems + '}';
    }

    public static void saveRedDotConfig(final QIMRedDotConfig qIMRedDotConfig, final String str) {
        if (qIMRedDotConfig == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig", 2, "saveRedDotConfig|config= " + qIMRedDotConfig);
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.data.QIMRedDotConfig.1
            /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
            
                if (r3 != null) goto L42;
             */
            /* JADX WARN: Not initialized variable reg: 3, insn: 0x0073: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x0073 */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                ObjectOutputStream objectOutputStream;
                Exception e16;
                ObjectOutputStream objectOutputStream2;
                synchronized (this) {
                    File file = new File(str, "qim_red_dot_config.cfg");
                    if (file.exists()) {
                        file.delete();
                    }
                    ObjectOutputStream objectOutputStream3 = null;
                    try {
                        try {
                            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                        } catch (Exception e17) {
                            objectOutputStream = null;
                            e16 = e17;
                        } catch (Throwable th5) {
                            th = th5;
                            if (objectOutputStream3 != null) {
                            }
                            throw th;
                        }
                        try {
                            objectOutputStream.writeObject(qIMRedDotConfig);
                            if (QLog.isColorLevel()) {
                                QLog.d("QIMRedDotConfig", 2, "save saveRedDotConfig success!");
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
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        objectOutputStream3 = objectOutputStream2;
                        if (objectOutputStream3 != null) {
                            try {
                                objectOutputStream3.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            }
        });
    }

    public boolean updateRedDotInfo(int i3, int i16, String str) {
        boolean z16 = false;
        switch (i3) {
            case 1:
                if (this.isShowing && !this.hasShow) {
                    this.hasShow = true;
                    this.firstShowTime = 0L;
                    this.isShowing = false;
                    z16 = true;
                    break;
                }
                break;
            case 2:
                CategoryRedConfig categoryRedConfig = this.categories.get(Integer.valueOf(i16));
                if (categoryRedConfig != null && categoryRedConfig.isShowing && !categoryRedConfig.hasShow) {
                    categoryRedConfig.hasShow = true;
                    categoryRedConfig.firstShowTime = 0L;
                    categoryRedConfig.isShowing = false;
                    z16 = true;
                    break;
                }
                break;
            case 3:
                RedDotItemConfig redDotItemConfig = this.redDotItems.get(str);
                if (redDotItemConfig != null && redDotItemConfig.isShowing && !redDotItemConfig.hasShow) {
                    redDotItemConfig.hasShow = true;
                    redDotItemConfig.firstShowTime = 0L;
                    redDotItemConfig.isShowing = false;
                    z16 = true;
                    break;
                }
                break;
            case 4:
                if (!TextUtils.isEmpty(this.defaultUseId) && !this.hasUse) {
                    this.hasUse = true;
                    z16 = true;
                    break;
                }
                break;
            case 5:
                if (this.defaultCategoryId != -1 && !this.hasChoose) {
                    this.hasChoose = true;
                    z16 = true;
                    break;
                }
                break;
            case 6:
                if (this.isComboShowing && !this.comboHasShow) {
                    this.comboHasShow = true;
                    this.comboFirstShowTime = 0L;
                    this.isComboShowing = false;
                    z16 = true;
                    break;
                }
                break;
            case 7:
                if (this.comboDefaultCategoryId != -1 && !this.comboHasChoose) {
                    this.comboHasChoose = true;
                    z16 = true;
                    break;
                }
                break;
        }
        if (z16) {
            this.update = true;
        }
        return z16;
    }

    public boolean needShowRedDot(int i3, int i16, String str) {
        if (i3 == 1) {
            return showIconRedDot();
        }
        if (i3 == 2) {
            return showCategoryRedDot(i16);
        }
        if (i3 == 3) {
            return showRedDot(i16, str);
        }
        if (i3 != 6) {
            return false;
        }
        return showComboIconRedDot();
    }
}

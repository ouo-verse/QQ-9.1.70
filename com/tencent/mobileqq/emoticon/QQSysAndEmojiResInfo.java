package com.tencent.mobileqq.emoticon;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiPanelCategory;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QQSysAndEmojiResInfo {
    static IPatchRedirector $redirector_ = null;
    public static final String EMO_ID = "emoId";
    public static final String EXT_ANI_STICKER_CONFIG_FILE_NAME = "ext_anisticker_config.json";
    public static final String EXT_ANI_STICKER_QLOTTIE_FOLDER_NAME = "ext_qlottie/";
    public static final String EXT_ANI_STICKER_SYS_FACE_RES_FOLDER_NAME = "ext_anisticker_sysface_res/";
    public static final String FACE_CONFIG_FILE_NAME = "face_config.json";
    public static final String QLOTTIE_FOLDER_NAME = "qlottie/";
    public static final String SYS_FACE_RES_FOLDER_NAME = "sysface_res/";
    public static final String TAG = "QQSysAndEmojiBaseInfo";
    protected final ConcurrentHashMap<Integer, QQEmoConfigItem> mConfigItemMap;
    protected final HashMap<String, String> mDesToEMCodeMap;
    protected final HashMap<String, Integer> mEMCodeToLocalMap;
    protected final Object mLock;
    protected final ArrayList<Integer> mOrderList;
    protected QQSysAndEmojiResReloader mResReloader;
    protected final HashMap<Integer, Integer> mServerToLocalMap;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class QQEmoConfigItem {
        static IPatchRedirector $redirector_;
        public String AQLid;
        public String AniStickerHeight;
        public String AniStickerId;
        public String AniStickerPackId;
        public String AniStickerPackName;
        public int AniStickerType;
        public String AniStickerWidth;
        public String EMCode;
        public String QCid;
        public String QDes;
        public String QHide;
        public String QSid;
        public String isCMEmoji;
        public String isStatic;
        public String keywords;

        public QQEmoConfigItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends QQEmoConfigItem {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public DownloadBaseEmojiInfo f204650a;

        /* renamed from: b, reason: collision with root package name */
        public EmojiPanelCategory f204651b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public QQSysAndEmojiResInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mConfigItemMap = new ConcurrentHashMap<>();
        this.mServerToLocalMap = new HashMap<>();
        this.mDesToEMCodeMap = new HashMap<>();
        this.mEMCodeToLocalMap = new HashMap<>();
        this.mOrderList = new ArrayList<>();
        this.mLock = new Object();
    }

    public void addReloadDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (this.mResReloader == null) {
            setReloadController();
        }
        this.mResReloader.addReloadList(i3);
    }

    public boolean checkEmoticonShouldHide(int i3) {
        QQEmoConfigItem qQEmoConfigItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        ConcurrentHashMap<Integer, QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap == null) {
            return false;
        }
        if (concurrentHashMap.containsKey(Integer.valueOf(i3)) && (qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3))) != null) {
            return isEmoticonHide(qQEmoConfigItem);
        }
        return true;
    }

    public abstract String getAniStickerPackageId(int i3);

    public abstract String getAniStickerPackageName(int i3);

    public int getConfigEmoCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        ConcurrentHashMap<Integer, QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null) {
            return concurrentHashMap.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QQEmoConfigItem getConfigItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQEmoConfigItem) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return this.mConfigItemMap.get(Integer.valueOf(i3));
    }

    public abstract String getDescription(int i3);

    public abstract Drawable getDrawable(int i3);

    public abstract URL getDrawableURL(int i3);

    public String getEMCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        HashMap<String, String> hashMap = this.mDesToEMCodeMap;
        if (hashMap != null && hashMap.containsKey(str)) {
            return this.mDesToEMCodeMap.get(str);
        }
        return null;
    }

    public ArrayList<Integer> getFullFaceCodeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ConcurrentHashMap<Integer, QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.addAll(concurrentHashMap.keySet());
            return arrayList;
        }
        return null;
    }

    public abstract URL getGifDrawableURL(int i3);

    public String[] getKeywords(int i3) {
        QQEmoConfigItem qQEmoConfigItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && (qQEmoConfigItem = concurrentHashMap.get(Integer.valueOf(i3))) != null && !TextUtils.isEmpty(qQEmoConfigItem.keywords)) {
            return qQEmoConfigItem.keywords.trim().split("\\|");
        }
        return null;
    }

    public abstract int getLocalId(int i3);

    public int getLocalIdFromEMCode(String str) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).intValue();
        }
        HashMap<String, Integer> hashMap = this.mEMCodeToLocalMap;
        if (hashMap != null && hashMap.containsKey(str) && (num = this.mEMCodeToLocalMap.get(str)) != null) {
            return num.intValue();
        }
        return -1;
    }

    public abstract int getMaxLocalId();

    public ArrayList<Integer> getOrderList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.mOrderList != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            synchronized (this.mLock) {
                arrayList.addAll(this.mOrderList);
            }
            return arrayList;
        }
        return null;
    }

    public abstract String getQSid(int i3);

    public abstract int getServerId(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getUrlDrawable(URL url, Drawable drawable, boolean z16, int i3) {
        Drawable drawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Drawable) iPatchRedirector.redirect((short) 14, this, url, drawable, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        try {
            drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.mar);
        } catch (Exception e16) {
            ColorDrawable colorDrawable = new ColorDrawable();
            QLog.e(TAG, 1, "getDrawable exception e: = " + e16.getMessage());
            drawable2 = colorDrawable;
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (drawable == null) {
                obtain.mLoadingDrawable = drawable2;
                obtain.mFailedDrawable = drawable2;
            } else {
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
            }
            if (url == null) {
                return obtain.mFailedDrawable;
            }
            obtain.mUseApngImage = z16;
            obtain.mPlayGifImage = z16;
            URLDrawable realGetURLDrawable = realGetURLDrawable(url, obtain);
            if (realGetURLDrawable != null) {
                realGetURLDrawable.addHeader(EMO_ID, Integer.toString(i3));
            }
            return realGetURLDrawable;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getUrlDrawable exception e: = " + th5.getMessage());
            if (drawable == null) {
                return drawable2;
            }
            return drawable;
        }
    }

    public boolean isEmoticonHide(QQEmoConfigItem qQEmoConfigItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQEmoConfigItem)).booleanValue();
        }
        if (qQEmoConfigItem == null) {
            return false;
        }
        return "1".equals(qQEmoConfigItem.QHide);
    }

    public abstract boolean isResReady(int i3);

    public abstract void parseConfigData(@NonNull com.tencent.mobileqq.emoticon.a aVar);

    public abstract void preLoadURLDrawable();

    protected URLDrawable realGetURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 15, (Object) this, (Object) url, (Object) uRLDrawableOptions);
        }
        return URLDrawable.getDrawable(url, uRLDrawableOptions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reloadDrawable(Drawable drawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable, i3);
            return;
        }
        if (drawable instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getStatus() != 1 && uRLDrawable.getStatus() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reloadDrawable restartDownload:", Integer.valueOf(i3));
                }
                uRLDrawable.addHeader(EMO_ID, Integer.toString(i3));
                uRLDrawable.restartDownload();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reloadDrawable do nothing:", Integer.valueOf(i3));
            }
        }
    }

    public abstract void reportEmoClick(int i3, int i16);

    public abstract void reportEmoClick(int i3, int i16, int i17);

    public void resDownloadFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQSysAndEmojiResReloader qQSysAndEmojiResReloader = this.mResReloader;
        if (qQSysAndEmojiResReloader != null) {
            qQSysAndEmojiResReloader.nofityReloadList();
        }
    }

    public abstract void setReloadController();
}

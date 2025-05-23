package com.tencent.mobileqq.emoticon;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anisticker.download.AniStickerResReloaderMgr;
import com.tencent.qqnt.emotion.pic.libra.SysFaceAndEmojiLibraPicLoader;
import com.tencent.qqnt.emotion.pic.libra.SysFaceAndEmojiLibraPicOption;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSysFaceResImpl extends QQSysAndEmojiResInfo implements QQSysAndEmojiResReloader.IResReloadListener {
    static IPatchRedirector $redirector_ = null;
    private static final String CATEGORY_ANI_STICKER = "AniSticker";
    private static final String CATEGORY_EXT_ANI_STICKER = "ExtensionAniSticker";
    private static final String CATEGORY_SYS_FACE = "sysface";
    protected static final String QZONE_CHI_GUA = "/\u5403\u74dc";
    public static final int SYSFACE_ANISTICKER = 1;
    public static final int SYSFACE_NORMAL = 0;
    public static final int SYSFACE_RANDOM = 2;
    public static final int SYSFACE_RANDOM_CHAIN_STICKER = 3;
    public static final String TAG = "QQSysFaceResImpl";
    protected final ArrayList<Integer> mAniStickerOrderList;
    protected final ArrayList<Integer> mExtAniStickerOrderList;
    protected final ArrayList<Integer> mFavPanelAniStickerOrderList;
    protected int mMaxLocalId;
    protected int mMaxServerId;
    private final boolean mUseLibra;

    public QQSysFaceResImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAniStickerOrderList = new ArrayList<>();
        this.mExtAniStickerOrderList = new ArrayList<>();
        this.mFavPanelAniStickerOrderList = new ArrayList<>();
        boolean p16 = QQSysFaceSwitcher.f204652a.p();
        this.mUseLibra = p16;
        QLog.i(TAG, 1, "emoticon_sys_face_optimize_115851637:" + p16);
        int i3 = 0;
        while (true) {
            int[] iArr = EmotcationConstants.LOCALE_TO_SERVER;
            if (i3 < iArr.length) {
                int i16 = iArr[i3];
                if (i16 >= 0) {
                    this.mServerToLocalMap.put(Integer.valueOf(i16), Integer.valueOf(i3));
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void handleFaceOrder(List<Integer> list) {
        for (Integer num : list) {
            int indexOf = this.mOrderList.indexOf(num);
            if (indexOf >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[parseConfigData]replace localId=", num, ", index=", Integer.valueOf(indexOf));
                }
                this.mOrderList.remove(indexOf);
                this.mOrderList.add(indexOf, num);
            } else {
                this.mOrderList.add(num);
            }
            int indexOf2 = this.mAniStickerOrderList.indexOf(num);
            if (indexOf2 >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[parseConfigData]replace anisticker localId=", num, ", aniStickerIndex=", Integer.valueOf(indexOf2));
                }
                this.mAniStickerOrderList.remove(indexOf2);
                this.mAniStickerOrderList.add(indexOf2, num);
            } else {
                this.mAniStickerOrderList.add(num);
            }
        }
    }

    private void parseConfigInner(@NonNull JSONArray jSONArray, @NonNull ArrayList<Integer> arrayList, @Nullable ArrayList<Integer> arrayList2) {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = (QQSysAndEmojiResInfo.QQEmoConfigItem) com.tencent.mobileqq.jsonconverter.a.f(jSONObject, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
                if (qQEmoConfigItem == null) {
                    QLog.e(TAG, 1, "[parseConfigInner] convertFromJSONObject error! itemObj=", jSONObject);
                } else {
                    parseQQEmoConfigItem(qQEmoConfigItem, arrayList, arrayList2);
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "[parseConfigInner] parse emojiArray error! ", e16);
            }
        }
    }

    public void addAniStickerReloadDrawable(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3, (Object) str);
        } else {
            AniStickerResReloaderMgr.INSTANCE.a().a(1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearCacheData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mConfigItemMap.clear();
        this.mOrderList.clear();
        this.mAniStickerOrderList.clear();
        this.mExtAniStickerOrderList.clear();
        this.mFavPanelAniStickerOrderList.clear();
        this.mDesToEMCodeMap.clear();
        this.mEMCodeToLocalMap.clear();
    }

    public AniStickerInfo getAniStickerInfo(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (AniStickerInfo) iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), str, str2);
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3));
            if (qQEmoConfigItem == null) {
                return null;
            }
            AniStickerInfo.Builder builder = new AniStickerInfo.Builder();
            builder.fromEmoItem(qQEmoConfigItem);
            if (str != null) {
                builder.setResultId(str);
            }
            if (str2 != null) {
                builder.setSurpriseId(str2);
            }
            return builder.build();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[getAniStickerInfo] failed, localId=", Integer.valueOf(i3));
        }
        return null;
    }

    public ArrayList<Integer> getAniStickerOrderList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.mAniStickerOrderList != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            synchronized (this.mLock) {
                arrayList.addAll(this.mAniStickerOrderList);
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getAniStickerPackageId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3));
            if (qQEmoConfigItem != null) {
                return qQEmoConfigItem.AniStickerPackId;
            }
            QLog.e(TAG, 1, "[getAniStickerPackageId] item is null! localId=", Integer.valueOf(i3));
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getAniStickerPackageName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3));
            if (qQEmoConfigItem != null) {
                return qQEmoConfigItem.AniStickerPackName;
            }
            QLog.e(TAG, 1, "[getAniStickerPackageName] item is null! localId=", Integer.valueOf(i3));
        }
        return "";
    }

    public int getAniStickerType(int i3) {
        QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap == null || (qQEmoConfigItem = concurrentHashMap.get(Integer.valueOf(i3))) == null) {
            return 0;
        }
        return qQEmoConfigItem.AniStickerType;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getDescription(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3));
            if (qQEmoConfigItem != null) {
                return qQEmoConfigItem.QDes;
            }
            QLog.e(TAG, 1, "[getDescription] item is null! localId=", Integer.valueOf(i3));
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public Drawable getDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Drawable) iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
        Drawable faceDrawableFromLocal = QQSysFaceUtil.getFaceDrawableFromLocal(i3);
        if (this.mUseLibra) {
            return getLibraApngDrawable(faceDrawableFromLocal, false, i3);
        }
        return getUrlDrawable(getDrawableURL(i3), faceDrawableFromLocal, false, i3);
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public URL getDrawableURL(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (URL) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        try {
            return new URL("qqsys_emoji", "host_qqsys_static", String.valueOf(i3));
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDrawable ,", e16);
            }
            return null;
        }
    }

    public String getEMCode(int i3) {
        QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3)) && (qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3))) != null) {
            return qQEmoConfigItem.EMCode;
        }
        return null;
    }

    public ArrayList<Integer> getExtAniStickerOrderList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.mExtAniStickerOrderList != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            synchronized (this.mLock) {
                arrayList.addAll(this.mExtAniStickerOrderList);
            }
            return arrayList;
        }
        return null;
    }

    public ArrayList<Integer> getFavPanelAniStickerOrderList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mFavPanelAniStickerOrderList != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            synchronized (this.mLock) {
                arrayList.addAll(this.mFavPanelAniStickerOrderList);
            }
            return arrayList;
        }
        return null;
    }

    public Drawable getGifDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Drawable) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        Drawable faceDrawableFromLocal = QQSysFaceUtil.getFaceDrawableFromLocal(i3);
        if (this.mUseLibra) {
            return getLibraApngDrawable(faceDrawableFromLocal, true, i3);
        }
        return getUrlDrawable(getGifDrawableURL(i3), faceDrawableFromLocal, true, i3);
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public URL getGifDrawableURL(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (URL) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        try {
            return new URL("qqsys_emoji", "host_qqsys_apng", String.valueOf(i3));
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getGifDrawable ", e16);
            }
            return null;
        }
    }

    @Deprecated
    public Drawable getGifURLDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Drawable) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        return getUrlDrawable(getGifDrawableURL(i3), QQSysFaceUtil.getFaceDrawableFromLocal(i3), true, i3);
    }

    protected Drawable getLibraApngDrawable(Drawable drawable, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Drawable) iPatchRedirector.redirect((short) 20, this, drawable, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        if (drawable == null) {
            try {
                drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.mar);
            } catch (Exception e16) {
                ColorDrawable colorDrawable = new ColorDrawable();
                QLog.e(TAG, 1, "getDrawable exception e: = " + e16.getMessage());
                drawable = colorDrawable;
            }
        }
        if (z16) {
            i16 = 4;
        }
        return SysFaceAndEmojiLibraPicLoader.INSTANCE.a().g(new SysFaceAndEmojiLibraPicOption(1, i3, i16, drawable));
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public int getLocalId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        Integer num = this.mServerToLocalMap.get(Integer.valueOf(i3));
        if (num != null && num.intValue() >= 0) {
            return num.intValue();
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public int getMaxLocalId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.mMaxLocalId;
    }

    public int getMaxServerId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.mMaxServerId;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getQSid(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return Integer.toString(getServerId(i3));
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public int getServerId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        int[] iArr = EmotcationConstants.LOCALE_TO_SERVER;
        if (i3 < iArr.length && i3 >= 0) {
            return iArr[i3];
        }
        return i3;
    }

    public boolean isCMEmoji(int i3) {
        QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, i3)).booleanValue();
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3)) && (qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3))) != null) {
            return "1".equals(qQEmoConfigItem.isCMEmoji);
        }
        return false;
    }

    public boolean isDynamicResReady(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, i3)).booleanValue();
        }
        String fullResPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(4, i3);
        if (!TextUtils.isEmpty(fullResPath) && new File(fullResPath).exists()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public boolean isResReady(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, i3)).booleanValue();
        }
        String fullResPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(2, i3);
        if (!TextUtils.isEmpty(fullResPath)) {
            return new File(fullResPath).exists();
        }
        return false;
    }

    public boolean isStaticFace(int i3) throws ArrayIndexOutOfBoundsException {
        QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, i3)).booleanValue();
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3)) && (qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3))) != null) {
            return "1".equals(qQEmoConfigItem.isStatic);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void parseConfigData(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (!(aVar instanceof f)) {
            return;
        }
        f fVar = (f) aVar;
        JSONObject b16 = fVar.b();
        if (b16 == null) {
            QLog.e(TAG, 1, "[parseConfigData] error, faceConfigJson is null!");
            return;
        }
        JSONArray optJSONArray = b16.optJSONArray(CATEGORY_SYS_FACE);
        if (optJSONArray == null) {
            QLog.e(TAG, 1, "[parseConfigData] error, sysFaceArray is null!");
            return;
        }
        synchronized (this.mLock) {
            clearCacheData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        parseConfigInner(optJSONArray, this.mOrderList, this.mAniStickerOrderList);
        JSONObject a16 = fVar.a();
        if (a16 != null) {
            JSONArray optJSONArray2 = a16.optJSONArray(CATEGORY_ANI_STICKER);
            if (optJSONArray2 != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                parseConfigInner(optJSONArray2, arrayList, null);
                synchronized (this.mLock) {
                    handleFaceOrder(arrayList);
                }
            } else {
                QLog.w(TAG, 1, "[parseConfigData] error, aniSickerArray is null!");
            }
            JSONArray optJSONArray3 = a16.optJSONArray(CATEGORY_EXT_ANI_STICKER);
            if (optJSONArray3 != null) {
                parseConfigInner(optJSONArray3, this.mExtAniStickerOrderList, null);
            } else {
                QLog.w(TAG, 1, "[parseConfigData] error, extAniSickerArray is null!");
            }
        }
        List<Integer> a17 = com.tencent.mobileqq.config.business.o.a();
        if (a17 != null) {
            this.mFavPanelAniStickerOrderList.addAll(a17);
        }
        QLog.d(TAG, 1, "sysface configItem:", Integer.valueOf(this.mConfigItemMap.size()), ", orderlist:", Integer.valueOf(this.mOrderList.size()), ", extAniStickerOrderlist:", Integer.valueOf(this.mExtAniStickerOrderList.size()), ", maxLid:", Integer.valueOf(this.mMaxLocalId), ", maxSid:", Integer.valueOf(this.mMaxServerId), ", costTime = [", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseQQEmoConfigItem(QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, qQEmoConfigItem, arrayList, arrayList2);
            return;
        }
        try {
            int parseInt = Integer.parseInt(qQEmoConfigItem.AQLid);
            if (!TextUtils.isEmpty(qQEmoConfigItem.EMCode)) {
                String str = "[em]e" + qQEmoConfigItem.EMCode + QzoneEmotionUtils.EMO_TAIL;
                String str2 = qQEmoConfigItem.QDes;
                if (!TextUtils.isEmpty(str2) && str2.equals(QZONE_CHI_GUA)) {
                    str2 = "/chigua";
                }
                this.mDesToEMCodeMap.put(str2, str);
                this.mEMCodeToLocalMap.put(str, Integer.valueOf(parseInt));
            }
            this.mConfigItemMap.put(Integer.valueOf(parseInt), qQEmoConfigItem);
            if (arrayList != null && !isEmoticonHide(qQEmoConfigItem)) {
                arrayList.add(Integer.valueOf(parseInt));
            }
            if (arrayList2 != null && qQEmoConfigItem.AniStickerType > 0) {
                arrayList2.add(Integer.valueOf(parseInt));
            }
            if (parseInt > this.mMaxLocalId) {
                this.mMaxLocalId = parseInt;
            }
            int parseInt2 = Integer.parseInt(qQEmoConfigItem.QSid);
            if (parseInt2 > this.mMaxServerId) {
                this.mMaxServerId = parseInt2;
            }
        } catch (Throwable unused) {
            QLog.d(TAG, 1, "error occur in sysface AQLid:", qQEmoConfigItem.AQLid);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void preLoadURLDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (this.mConfigItemMap == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[preLoadURLDrawable]");
        }
        try {
            HashMap hashMap = new HashMap(this.mConfigItemMap);
            for (Integer num : hashMap.keySet()) {
                if (num.intValue() >= 260 && !"-1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem) hashMap.get(num)).QSid) && !this.mUseLibra) {
                    Drawable drawable = getDrawable(num.intValue());
                    if (drawable instanceof URLDrawable) {
                        ((URLDrawable) drawable).downloadImediatly();
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[preLoadURLDrawable] error! stack=", th5);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void reportEmoClick(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            reportEmoClick(i3, i16, -1);
        } else {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void setReloadController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            this.mResReloader = new QQSysAndEmojiResReloader(this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.IResReloadListener
    public void startReloadDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            if (this.mUseLibra) {
                return;
            }
            reloadDrawable(getDrawable(i3), i3);
            reloadDrawable(getGifDrawable(i3), i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void reportEmoClick(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        int serverId = getServerId(i3);
        if (serverId == 0) {
            serverId = 1000;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A7A2", "0X800A7A2", serverId, 0, String.valueOf(i16), com.tencent.qqnt.emotion.utils.q.f356700a.a(i17), "", "");
    }
}

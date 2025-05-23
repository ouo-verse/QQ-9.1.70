package com.tencent.mobileqq.emoticon;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQEmojiResImpl extends QQSysAndEmojiResInfo implements QQSysAndEmojiResReloader.IResReloadListener {
    static IPatchRedirector $redirector_ = null;
    private static final String CATEGORY_NAME = "emoji";
    public static final String TAG = "QQEmojiResImpl";
    protected int mMaxLocalId;

    public QQEmojiResImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = com.tencent.qqnt.emoji.a.EMOJI_CODES;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearCacheData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mConfigItemMap.clear();
        this.mOrderList.clear();
        this.mDesToEMCodeMap.clear();
        this.mEMCodeToLocalMap.clear();
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getAniStickerPackageId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getAniStickerPackageName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getDescription(int i3) {
        QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = this.mConfigItemMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3)) && (qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3))) != null) {
            return qQEmoConfigItem.QDes;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public Drawable getDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        if (i3 < EmotcationConstants.VALID_EMOJI_COUNT) {
            return com.tencent.qqnt.emotion.utils.s.g(BaseApplication.getContext().getResources(), EmotcationConstants.FIRST_EMOJI_RES + i3);
        }
        if (i3 >= 1000) {
            return QQEmojiUtil.loadEmojiFromDisk(BaseApplication.getContext().getResources(), i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getEmojiDrawable in new way. localId=" + i3);
        }
        return getUrlDrawable(getDrawableURL(i3), null, false, i3);
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public URL getDrawableURL(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (URL) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        URL url = null;
        try {
            URL url2 = new URL("qqsys_emoji", "host_emoji", Integer.toString(i3));
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getDrawable url:" + url2.toString());
                    return url2;
                }
                return url2;
            } catch (MalformedURLException e16) {
                e = e16;
                url = url2;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getDrawable ,", e);
                }
                return url;
            }
        } catch (MalformedURLException e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public URL getGifDrawableURL(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (URL) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        return getDrawableURL(i3);
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public int getLocalId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        int i16 = EmotcationConstants.EMOJI_MAP.get(i3, -1);
        if (i16 >= 0) {
            return i16;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public int getMaxLocalId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mMaxLocalId;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public String getQSid(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = this.mConfigItemMap.get(Integer.valueOf(i3));
        if (qQEmoConfigItem != null) {
            return qQEmoConfigItem.QSid;
        }
        int serverId = getServerId(i3);
        QLog.e(TAG, 1, "[getQSid] item is null! serverId=", Integer.valueOf(serverId));
        return Integer.toString(serverId);
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public int getServerId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        int[] iArr = com.tencent.qqnt.emoji.a.EMOJI_CODES;
        if (i3 < iArr.length && i3 >= 0) {
            return iArr[i3];
        }
        if (QQSysFaceSwitcher.f204652a.a() && this.mConfigItemMap.containsKey(Integer.valueOf(i3))) {
            return i3;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public boolean isResReady(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, i3)).booleanValue();
        }
        String fullResPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(3, getServerId(i3));
        if (!TextUtils.isEmpty(fullResPath)) {
            return new File(fullResPath).exists();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void parseConfigData(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (!(aVar instanceof f)) {
            return;
        }
        JSONObject b16 = ((f) aVar).b();
        if (b16 == null) {
            QLog.e(TAG, 1, "[parseConfigData] error, faceConfigJson is null!");
            return;
        }
        JSONArray optJSONArray = b16.optJSONArray("emoji");
        if (optJSONArray == null) {
            QLog.e(TAG, 1, "[parseConfigData] error, sysFaceArray is null!");
            return;
        }
        clearCacheData();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                parseQQEmoConfigItem((QQSysAndEmojiResInfo.QQEmoConfigItem) com.tencent.mobileqq.jsonconverter.a.f(optJSONArray.getJSONObject(i3), QQSysAndEmojiResInfo.QQEmoConfigItem.class));
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "[parseConfigData] parse emojiArray error! ", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "emoji configItem:", Integer.valueOf(this.mConfigItemMap.size()), " ,orderlist:", Integer.valueOf(this.mOrderList.size()), ", maxLid:", Integer.valueOf(this.mMaxLocalId), " ,costTime = [", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseQQEmoConfigItem(QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQEmoConfigItem);
            return;
        }
        try {
            int parseInt = Integer.parseInt(qQEmoConfigItem.AQLid);
            Integer.parseInt(qQEmoConfigItem.QCid);
            if (!TextUtils.isEmpty(qQEmoConfigItem.EMCode)) {
                String str = "[em]e" + qQEmoConfigItem.EMCode + QzoneEmotionUtils.EMO_TAIL;
                this.mDesToEMCodeMap.put(qQEmoConfigItem.QDes, str);
                this.mEMCodeToLocalMap.put(str, Integer.valueOf(parseInt));
            }
            this.mConfigItemMap.put(Integer.valueOf(parseInt), qQEmoConfigItem);
            if (!isEmoticonHide(qQEmoConfigItem)) {
                this.mOrderList.add(Integer.valueOf(parseInt));
            }
            if (parseInt > this.mMaxLocalId) {
                this.mMaxLocalId = parseInt;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error occur in emoji AQLid:", qQEmoConfigItem.AQLid, ", stack=", QLog.getStackTraceString(th5));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void preLoadURLDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void reportEmoClick(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            reportEmoClick(i3, i16, -1);
        } else {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void setReloadController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mResReloader = new QQSysAndEmojiResReloader(this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.IResReloadListener
    public void startReloadDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            reloadDrawable(getDrawable(i3), i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void reportEmoClick(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            ReportController.o(null, "dc00898", "", "", "0X800A7A3", "0X800A7A3", getServerId(i3), 0, String.valueOf(i16), "", "", "");
        } else {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}

package com.tencent.mobileqq.emoticon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.emoticon.download.RandomAccessFileManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.text.AppleEmojiManager;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQEmojiUtil {
    static IPatchRedirector $redirector_ = null;
    public static int EMOJI_COUNT = 0;
    private static String KEY_DELETE_ALL_EMOJI = null;
    private static String KEY_DELETE_ALL_EMOJI_VERSION = null;
    public static final String TAG = "EmojiUtil";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EMOJI_COUNT = 165;
        KEY_DELETE_ALL_EMOJI = "103006";
        KEY_DELETE_ALL_EMOJI_VERSION = "key_delete_all_emoji_version_";
    }

    public QQEmojiUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean containsEmoji(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (EmotcationConstants.EMOJI_MAP.get(str.codePointAt(i3), -1) >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static void deleteAllEmojiIfNeeded() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 2, "deleteAllEmojiIfNeeded appRuntime is null");
            return;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString(KEY_DELETE_ALL_EMOJI, "");
        if (TextUtils.isEmpty(loadConfigAsString)) {
            QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").remove(KEY_DELETE_ALL_EMOJI_VERSION + currentAccountUin);
            QLog.i(TAG, 2, "deleteAllEmojiIfNeeded switchContent: '" + loadConfigAsString + "'");
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String string = fromV2.getString(KEY_DELETE_ALL_EMOJI_VERSION + currentAccountUin, "");
        QLog.i(TAG, 2, "deleteAllEmojiIfNeeded switchContent: '" + loadConfigAsString + "', localSwitchContent: '" + string + "'");
        if (!loadConfigAsString.equals(string)) {
            com.tencent.qqnt.msg.f.a().delAllBaseEmojiResource(new IOperateCallback() { // from class: com.tencent.mobileqq.emoticon.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQEmojiUtil.lambda$deleteAllEmojiIfNeeded$0(i3, str);
                }
            });
            fromV2.putString(KEY_DELETE_ALL_EMOJI_VERSION + currentAccountUin, loadConfigAsString);
        }
    }

    public static int getEmojiCount() {
        int configEmoCount = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getConfigEmoCount();
        int[] iArr = EmotcationConstants.EMOJI_CODES;
        if (configEmoCount < iArr.length) {
            return iArr.length;
        }
        return configEmoCount;
    }

    public static String getEmojiDescription(int i3) {
        String description = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getDescription(i3);
        if (TextUtils.isEmpty(description)) {
            if (i3 >= 0) {
                String[] strArr = EmotcationConstants.EMOJI_CONTENT_DESC;
                if (i3 < strArr.length) {
                    return strArr[i3];
                }
            }
            return "\u672a\u77e5";
        }
        return description;
    }

    public static Drawable getEmojiDrawable(int i3) {
        if (i3 < 0) {
            QLog.e(TAG, 1, new IllegalArgumentException("[getEmojiDrawable] invalidate face localId=" + i3), new Object[0]);
            return null;
        }
        return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getDrawable(i3);
    }

    public static int getEmojiLocalId(int i3) {
        return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getLocalId(i3);
    }

    public static int getEmojiUnicode(int i3) {
        return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getServerId(i3);
    }

    public static String getEmojiUnicodeString(int i3) {
        int emojiUnicode = getEmojiUnicode(i3);
        if (emojiUnicode != -1) {
            return String.valueOf(Character.toChars(emojiUnicode));
        }
        String str = EmotcationConstants.LOCAL_ID_TO_EMOJI_UNICODE_MAP.get(Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static int getLocalIdFromEMCode(String str) {
        return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getLocalIdFromEMCode(str);
    }

    public static ArrayList<Integer> getOrderList() {
        ArrayList<Integer> orderList = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getOrderList();
        if (orderList != null && orderList.size() > 0) {
            return orderList;
        }
        QLog.w(TAG, 1, "[getOrderList] use local default emoji orderList.");
        ArrayList<Integer> arrayList = new ArrayList<>(EMOJI_COUNT);
        for (int i3 = 0; i3 < EMOJI_COUNT; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList;
    }

    public static boolean isEmoReady(int i3) {
        return QQSysAndEmojiResMgr.getInstance().getResImpl(2).isResReady(i3);
    }

    public static boolean isValidEmojiId(int i3) {
        int maxLocalId = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getMaxLocalId();
        if (maxLocalId <= 0) {
            maxLocalId = EmotcationConstants.EMOJI_CODES.length - 1;
        }
        if (i3 >= 0 && i3 <= maxLocalId) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteAllEmojiIfNeeded$0(int i3, String str) {
        QLog.i(TAG, 2, "[deleteAllEmojiIfNeeded] delAllBaseEmojiResource result: " + i3 + ", errMsg: " + str);
    }

    public static Drawable loadEmojiFromDisk(Resources resources, int i3) {
        RandomAccessFile randomAccessFile;
        String str = "emotion://" + i3;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Object g16 = imageCacheHelper.g(str);
        if (g16 instanceof com.tencent.cache.api.g) {
            return ((Drawable.ConstantState) ((com.tencent.cache.api.g) g16).b()).newDrawable(resources);
        }
        try {
            RandomAccessFileManager i16 = RandomAccessFileManager.i();
            String str2 = AppleEmojiManager.EMOJI_FILE;
            randomAccessFile = i16.j(str2);
            try {
                randomAccessFile.seek(i3 - 1000);
                byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4);
                randomAccessFile.read(buf, 0, 4);
                int bytesToInt = AppleEmojiManager.bytesToInt(buf);
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                if (bytesToInt >= 0 && bytesToInt <= 4096) {
                    byte[] buf2 = ByteArrayPool.getGenericInstance().getBuf(4096);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(buf2, 0, randomAccessFile.read(buf2, 0, bytesToInt));
                    int q16 = Utils.q(decodeByteArray);
                    if (q16 > 0) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeByteArray);
                        imageCacheHelper.i(str, new com.tencent.cache.api.g(bitmapDrawable.getConstantState(), q16), Business.Conversation);
                        if (QLog.isColorLevel()) {
                            QLog.d(AppleEmojiManager.TAG, 2, "loadEmojiFromDisk:", Integer.valueOf(i3), " load success");
                        }
                        RandomAccessFileManager.i().g(str2);
                        return bitmapDrawable;
                    }
                    RandomAccessFileManager.i().g(str2);
                    return null;
                }
                QLog.d(AppleEmojiManager.TAG, 4, "index:" + i3);
                RandomAccessFileManager.i().g(str2);
                return null;
            } catch (Throwable unused) {
                if (randomAccessFile == null) {
                    try {
                        AppleEmojiManager.reDownloadAppleEmoji();
                    } finally {
                        if (randomAccessFile != null) {
                            RandomAccessFileManager.i().g(AppleEmojiManager.EMOJI_FILE);
                        }
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
    }
}

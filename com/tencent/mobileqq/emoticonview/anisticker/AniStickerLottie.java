package com.tencent.mobileqq.emoticonview.anisticker;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.a;
import com.tencent.rlottie.b;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AniStickerLottie {
    static IPatchRedirector $redirector_ = null;
    public static final String CACHE_CLEAR_TAG = "AniStickerCache";
    public static final String CACHE_SIGNATURE = "qq_emoticon_res";
    private static boolean LOTTIE_CACHE_ENABLE = false;
    public static final String LOTTIE_CACHE_MD5 = "lottie_cache_md5";
    private static boolean LOTTIE_SO_READY = false;
    public static final String TAG = "AniStickerLottie";

    public AniStickerLottie() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean cacheEnabled() {
        return LOTTIE_CACHE_ENABLE;
    }

    public static synchronized void clearCache() {
        synchronized (AniStickerLottie.class) {
            setCacheEnabled(false);
            a.d(BaseApplication.getContext());
            QLog.d(TAG, 1, "clear cache, setting,  isSuccess:", Boolean.valueOf(a.b(BaseApplication.getContext()).c()));
            setCacheEnabled(true);
        }
    }

    private static SharedPreferences getSp() {
        return BaseApplication.getContext().getSharedPreferences(QQSysAndEmojiResMgr.SP_QQ_EMOTICON, 4);
    }

    public static void init() {
        boolean d16 = a.d(BaseApplication.getContext());
        LOTTIE_SO_READY = d16;
        if (!d16) {
            return;
        }
        a.b(null).b(CACHE_SIGNATURE);
        a.b(null).a(new b.a() { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.rlottie.b.a
            public void onClearCache(long j3, long j16, long j17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, String.valueOf(j3));
                hashMap.put("cacheSize", String.valueOf(j16));
                hashMap.put("cacheCount", String.valueOf(j16));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", AniStickerLottie.CACHE_CLEAR_TAG, true, 0L, 0L, hashMap, null);
            }
        });
    }

    public static boolean lottieEnabled() {
        return LOTTIE_SO_READY;
    }

    public static boolean needClearEmoticonLottieCache() {
        SharedPreferences sp5 = getSp();
        String string = sp5.getString("md5_type_5", "");
        String string2 = sp5.getString(LOTTIE_CACHE_MD5, "");
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cacheMd5:", string2, " newMd5:", string);
        }
        if (TextUtils.isEmpty(string2) || string2.equals(string)) {
            z16 = false;
        }
        if (TextUtils.isEmpty(string2) || z16) {
            sp5.edit().putString(LOTTIE_CACHE_MD5, string).apply();
        }
        return z16;
    }

    public static synchronized void refreshCache() {
        synchronized (AniStickerLottie.class) {
            setCacheEnabled(false);
            b b16 = a.b(BaseApplication.getContext());
            boolean needClearEmoticonLottieCache = needClearEmoticonLottieCache();
            boolean j3 = b16.j();
            if (!needClearEmoticonLottieCache && j3) {
                setCacheEnabled(true);
            } else {
                ThreadManagerV2.excute(new Runnable(needClearEmoticonLottieCache, j3) { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ boolean val$clearLottieCache;
                    final /* synthetic */ boolean val$hasCacheChecked;

                    {
                        this.val$clearLottieCache = needClearEmoticonLottieCache;
                        this.val$hasCacheChecked = j3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(needClearEmoticonLottieCache), Boolean.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            AniStickerLottie.refreshCacheSync(this.val$clearLottieCache, this.val$hasCacheChecked);
                        }
                    }
                }, 64, null, false);
            }
        }
    }

    public static synchronized void refreshCacheSync(boolean z16, boolean z17) {
        synchronized (AniStickerLottie.class) {
            a.d(BaseApplication.getContext());
            b b16 = a.b(BaseApplication.getContext());
            if (z16) {
                QLog.d(TAG, 1, "clear cache, emoticon,  isSuccess:", Boolean.valueOf(b16.e(CACHE_SIGNATURE)));
            }
            if (!z17) {
                b16.d();
                QLog.d(TAG, 1, "clear cache, over Limit");
            }
            setCacheEnabled(true);
        }
    }

    public static boolean setCacheEnabled(boolean z16) {
        LOTTIE_CACHE_ENABLE = z16;
        return z16;
    }
}

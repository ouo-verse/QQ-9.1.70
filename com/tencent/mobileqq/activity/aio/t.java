package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.nt.ZPlanCoupleAIOBackgroundContainer;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.theme.diy.DIYThemeUtils;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import com.tencent.qqnt.aio.utils.AIOContainerUtils;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public String f179994a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f179995b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f179996c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f179997d;

    @Nullable
    private static Bitmap a(Context context, String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(Build.BRAND)) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;
        j.a f16 = com.tencent.mobileqq.util.j.f(str, options);
        Bitmap bitmap = f16.f306778a;
        if (bitmap != null && f16.f306779b == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatBackground", 2, "getChatBackground, decodeFileForResult ok, path=" + str + ", path=" + str + ", inSampleSize" + options.inSampleSize);
            }
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getChatBackground Err ; path = ");
            sb5.append(str);
            sb5.append(", bg=");
            if (bitmap == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", inSampleSize");
            sb5.append(options.inSampleSize);
            QLog.e("ChatBackground", 1, sb5.toString());
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", "d_" + f16.f306779b);
            hashMap.put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector statisticCollector = StatisticCollector.getInstance(context);
            String account = ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount();
            if (bitmap != null) {
                z19 = true;
            } else {
                z19 = false;
            }
            statisticCollector.collectPerformance(account, "ChatBackgroundDecoder", z19, 1L, 0L, hashMap, "", false);
        } catch (Exception unused) {
        }
        if (f16.f306779b == 1) {
            QLog.e("ChatBackground", 1, "getChatBackground OOM ; path = " + str);
            for (int i3 = options.inSampleSize * 2; i3 <= 32; i3 *= 2) {
                options.inSampleSize = i3;
                f16 = com.tencent.mobileqq.util.j.f(str, options);
                bitmap = f16.f306778a;
                if (QLog.isColorLevel() || bitmap == null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("getChatBackground, miniDecode, result=");
                    sb6.append(f16.f306779b);
                    sb6.append(", path=");
                    sb6.append(str);
                    sb6.append(",simpleSize=");
                    sb6.append(i3);
                    sb6.append(", bg=");
                    if (bitmap != null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    sb6.append(z18);
                    QLog.d("ChatBackground", 2, sb6.toString());
                }
                if (f16.f306779b == 1) {
                }
            }
            try {
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("param_FailCode", "dd_" + f16.f306779b);
                hashMap2.put("param_themeid", ThemeUtil.getCurrentThemeId());
                StatisticCollector statisticCollector2 = StatisticCollector.getInstance(context);
                String account2 = ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount();
                if (bitmap != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                statisticCollector2.collectPerformance(account2, "ChatBackgroundDecoder", z17, 1L, 0L, hashMap2, "", false);
            } catch (Exception unused2) {
            }
        }
        return bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0080, code lost:
    
        if (r8 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap b(Context context, String str, Bitmap bitmap, File file) {
        boolean b16 = com.tencent.qqsharpP.a.b(context);
        if (QLog.isColorLevel() || !b16) {
            QLog.d("ChatBackground", 2, "getChatBackground, sharpP exists, path=" + str + ", sharpPAv=" + b16);
        }
        if (b16) {
            boolean z16 = false;
            try {
                try {
                    bitmap = SharpPUtil.decodeSharpPByFilePath(file.getAbsolutePath());
                } catch (UnsatisfiedLinkError e16) {
                    QLog.e("ChatBackground", 1, "sharpP decodeSharpPByFilePath UnsatisfiedLinkError, msg:" + e16.getMessage());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getChatBackground, sharpP decode result=");
                }
            } finally {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getChatBackground, sharpP decode result=");
                if (bitmap != null) {
                    z16 = true;
                }
                sb6.append(z16);
                sb6.append(", path=");
                sb6.append(str);
                QLog.d("ChatBackground", 1, sb6.toString());
            }
        }
        return bitmap;
    }

    public static boolean c(Context context, String str, String str2, int i3, boolean z16, int i16, t tVar) {
        if (tVar == null) {
            QLog.e("ChatBackground", 1, "getChatBackground out=null");
            return false;
        }
        if (((IAIOChatBackgroundApi) QRoute.api(IAIOChatBackgroundApi.class)).isAvatarBackground(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2), 0)) {
            return n(context, tVar, ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getZPlanChatBackgroundPicPath(str, str2, 0));
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(context, str);
        String d16 = d(str2, mMKVData);
        QLog.d("ChatBackground_Time", 1, "getChatBackground, out.isDecodeSuccess=" + tVar.f179997d + ", path=" + d16 + ", out.path=" + tVar.f179994a);
        return k(context, str, i16, tVar, mMKVData, d16);
    }

    private static String d(String str, SharedPreferences sharedPreferences) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = sharedPreferences.getString(str, null);
        } else {
            str2 = null;
        }
        String str3 = "null";
        if (((str2 != null && !str2.equals("null")) || (str2 = sharedPreferences.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, null)) != null) && !String.valueOf(ThemeBackground.AVATAR_BG_ID).equals(ChatBackgroundUtil.getId(str2))) {
            str3 = str2;
        }
        return ThemeDiyStyleLogic.getDiyVFSPath(str3);
    }

    public static String e(Context context, String str, String str2) {
        return d(str2, ChatBackgroundUtil.getMMKVData(context, str));
    }

    private static ColorStateList f(SharedPreferences sharedPreferences, String str, Bitmap bitmap) {
        String str2 = AppConstants.CHAT_BACKGOURND_NICKNAME_COLOR + str;
        if (sharedPreferences.contains(str2)) {
            return ColorStateList.valueOf(sharedPreferences.getInt(str2, -10395552));
        }
        int h16 = h(bitmap);
        sharedPreferences.edit().putInt(str2, h16).commit();
        return ColorStateList.valueOf(h16);
    }

    public static ColorStateList g(Context context, String str, String str2) {
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(context, str);
        String str3 = AppConstants.CHAT_BACKGOURND_NICKNAME_COLOR + str2;
        if (mMKVData.contains(str3)) {
            return ColorStateList.valueOf(mMKVData.getInt(str3, -10395552));
        }
        return null;
    }

    public static int h(Bitmap bitmap) {
        if (bitmap == null) {
            return -10395552;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[height];
        bitmap.getPixels(iArr, 0, 1, width / 2, 0, 1, height);
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < height; i18++) {
            int i19 = iArr[i18];
            i3 += Color.red(i19);
            i16 += Color.green(i19);
            i17 += Color.blue(i19);
        }
        if ((((i3 + i16) + i17) / height) / 3 > 220) {
            return -10395552;
        }
        return -1;
    }

    private static ColorStateList i(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Bitmap a16 = a(context, str);
            if (a16 == null) {
                QLog.e("ChatBackground", 1, "getZPlanTextClr failed, backgroundBitmap null.");
                return null;
            }
            int h16 = h(a16);
            a16.recycle();
            return ColorStateList.valueOf(h16);
        }
        QLog.e("ChatBackground", 1, "getZPlanTextClr failed, context or bgPicPath invalid.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0165 A[Catch: OutOfMemoryError -> 0x01f4, Exception -> 0x024c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {OutOfMemoryError -> 0x01f4, blocks: (B:4:0x0011, B:6:0x001c, B:8:0x0032, B:11:0x0039, B:13:0x0045, B:15:0x0049, B:17:0x0054, B:19:0x0078, B:21:0x007e, B:23:0x0089, B:25:0x009b, B:27:0x00a6, B:29:0x00d5, B:31:0x00d9, B:33:0x0113, B:38:0x011c, B:40:0x0165, B:41:0x012b, B:43:0x0133, B:46:0x014f, B:48:0x00ef, B:50:0x00f3, B:61:0x0028), top: B:3:0x0011, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void j(Context context, t tVar, String str, boolean z16) {
        Shader.TileMode tileMode;
        Drawable drawable;
        boolean z17;
        boolean z18;
        int i3;
        Shader.TileMode tileMode2;
        Bitmap bitmap;
        boolean z19;
        boolean z26;
        try {
            try {
                try {
                    tileMode = Shader.TileMode.REPEAT;
                    if (!QQTheme.isVasTheme()) {
                        drawable = context.getResources().getDrawable(R.drawable.qui_msg_list_bg);
                    } else {
                        drawable = context.getResources().getDrawable(R.drawable.chat_bg_texture);
                    }
                } catch (Exception e16) {
                    QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM2 or Err:" + e16.getMessage());
                    tVar.f179996c = context.getResources().getDrawable(R.drawable.gub);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_FailCode", "EE");
                    hashMap.put("param_themeid", ThemeUtil.getCurrentThemeId());
                    StatisticCollector.getInstance(context).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, hashMap, "", false);
                }
            } catch (OutOfMemoryError e17) {
                QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM1:" + e17.getMessage());
                tVar.f179996c = context.getResources().getDrawable(R.drawable.gub);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("param_FailCode", "OOM1");
                hashMap2.put("param_themeid", ThemeUtil.getCurrentThemeId());
                StatisticCollector.getInstance(context).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, hashMap2, "", false);
            }
        } catch (Exception unused) {
        }
        if (drawable == null) {
            QLog.e("ChatBackground", 1, "setAIOBackgroundBmp Drawable d == null.");
            return;
        }
        ThemeBackground.sAIOBusinessFlag.setUseStatic();
        if (ThemeUtil.isNowThemeIsAnimate() && (!(context instanceof FragmentActivity) || !AIOContainerUtils.f352240a.c((FragmentActivity) context))) {
            String animatePathByTag = ThemeUtil.getAnimatePathByTag(3);
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_use_rect", true);
            bundle.putBoolean(VasApngUtil.KEY_PLAY_APNG, z16);
            int[] iArr = {0};
            if (VasNormalToggle.VAS_CHANGE_GLD_2_NATIVE_AIO.isEnable(false) && Build.VERSION.SDK_INT >= 34) {
                Drawable dynamicDrawable = ThemeBackground.getDynamicDrawable(animatePathByTag, "qq_skin_aio.mp4", R.drawable.chat_bg_texture);
                if (dynamicDrawable instanceof IGLDrawable) {
                    ((IGLDrawable) dynamicDrawable).setLockWH(true);
                    tVar.f179996c = dynamicDrawable;
                    ThemeBackground.sAIOBusinessFlag.setUseVideo();
                    z26 = true;
                    if (z26 && new File(animatePathByTag).exists()) {
                        z17 = false;
                        tVar.f179996c = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), animatePathByTag, "-chatBg-", drawable, iArr, "-chatBg-", bundle);
                        ThemeBackground.sAIOBusinessFlag.setUseApng();
                        z18 = true;
                    } else {
                        z17 = false;
                        z18 = z26;
                    }
                }
            }
            z26 = false;
            if (z26) {
            }
            z17 = false;
            z18 = z26;
        } else {
            z17 = false;
            z18 = false;
        }
        if (!z18) {
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
                tileMode2 = ((BitmapDrawable) drawable).getTileModeX();
                i3 = ((BitmapDrawable) drawable).getGravity();
            } else if (drawable instanceof SkinnableBitmapDrawable) {
                bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                tileMode2 = ((SkinnableBitmapDrawable) drawable).getTileModeX();
                i3 = ((SkinnableBitmapDrawable) drawable).getGravity();
            } else {
                i3 = 119;
                tileMode2 = tileMode;
                bitmap = null;
            }
            if (bitmap != null && tileMode2 != Shader.TileMode.REPEAT && i3 == 48) {
                ChatBackgroundDrawable chatBackgroundDrawable = new ChatBackgroundDrawable(context.getResources(), bitmap);
                chatBackgroundDrawable.setGravity(i3);
                tVar.f179996c = chatBackgroundDrawable;
                if (bitmap == null) {
                    HashMap<String, String> hashMap3 = new HashMap<>();
                    hashMap3.put("param_FailCode", "dNull");
                    hashMap3.put("param_themeid", ThemeUtil.getCurrentThemeId());
                    StatisticCollector.getInstance(context).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, hashMap3, "", false);
                }
            }
            tVar.f179996c = drawable;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setAIOBackgroundBmp, bgBitmap=");
                sb5.append(bitmap);
                sb5.append(", type=");
                if (tileMode2 == Shader.TileMode.REPEAT) {
                    z19 = true;
                } else {
                    z19 = z17;
                }
                sb5.append(z19);
                sb5.append(", gravity=");
                sb5.append(i3);
                QLog.d("ChatBackground", 2, sb5.toString());
            }
            if (bitmap == null) {
            }
        }
        if (tVar.f179996c != null) {
            tVar.f179997d = true;
        } else {
            QLog.e("ChatBackground", 1, "setAIOBackgroundBmp out.img == null");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(3:23|24|25)|(4:(1:40)(1:35)|36|(1:38)|39)|41|42|43|44|36|(0)|39) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a3, code lost:
    
        com.tencent.qphone.base.util.QLog.d("ChatBackground_Time", 2, "getChatBackground error");
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean k(Context context, String str, int i3, t tVar, SharedPreferences sharedPreferences, String str2) {
        boolean z16;
        boolean z17;
        boolean z18;
        if ((i3 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((i3 & 2) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (tVar.f179996c != null && tVar.f179997d && !TextUtils.isEmpty(tVar.f179994a) && tVar.f179994a.equals(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatBackground", 2, "getChatBackground, bg not change, path=" + str2);
            }
            return false;
        }
        try {
        } catch (OutOfMemoryError unused) {
            QLog.e("ChatBackground", 1, "getChatBackground OOM0 ; path = " + str2);
            tVar.f179996c = context.getResources().getDrawable(R.drawable.gub);
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", "OOM0");
                hashMap.put("param_themeid", ThemeUtil.getCurrentThemeId());
                StatisticCollector.getInstance(context).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, hashMap, "", false);
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(str2) && !"null".equals(str2) && !"none".equals(str2)) {
            if (z17 && ChatBackgroundManager.t(new File(str2))) {
                l(context, tVar, sharedPreferences, str2);
            } else {
                m(context, str, tVar, sharedPreferences, str2, z16, z18);
            }
            if (tVar.f179996c == null) {
                QLog.e("ChatBackground", 1, "getChatBackground error out.img == null");
            }
            return true;
        }
        tVar.f179994a = "null";
        tVar.f179995b = context.getResources().getColorStateList(R.color.qui_common_text_secondary);
        j(context, tVar, str2, z16);
        if (tVar.f179996c == null) {
        }
        return true;
    }

    private static void l(Context context, t tVar, SharedPreferences sharedPreferences, String str) {
        Drawable drawable;
        long uptimeMillis = SystemClock.uptimeMillis();
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null) {
            f16 = a(context, str);
        }
        Bitmap bitmap = f16;
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (bitmap != null) {
            imageCacheHelper.i(str, bitmap, Business.AIO);
            drawable = new ChatBackgroundDrawable(context.getResources(), bitmap);
        } else {
            drawable = context.getResources().getDrawable(R.drawable.chat_bg_texture);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_use_rect", true);
        bundle.putBoolean("key_double_bitmap", true);
        URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "-chatBg-", drawable, new int[]{0}, "-chatBg-", bundle);
        tVar.f179996c = apngDrawable;
        if (apngDrawable == null && bitmap != null) {
            tVar.f179996c = new ChatBackgroundDrawable(context.getResources(), bitmap);
        }
        tVar.f179994a = str;
        tVar.f179997d = true;
        if (bitmap != null) {
            tVar.f179995b = f(sharedPreferences, str, bitmap);
        }
        QLog.d("ChatBackground_Time", 1, "APNG_getBitmap " + (uptimeMillis2 - uptimeMillis) + " APNG_init " + (SystemClock.uptimeMillis() - uptimeMillis2));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m(Context context, String str, t tVar, SharedPreferences sharedPreferences, String str2, boolean z16, boolean z17) {
        boolean z18;
        boolean z19;
        boolean z26;
        Bitmap f16 = ImageCacheHelper.f98636a.f(str2);
        if (f16 != null && f16.isRecycled()) {
            f16 = null;
        }
        if (f16 == null) {
            File file = new File(str2);
            if (file.exists() && file.isFile()) {
                long uptimeMillis = SystemClock.uptimeMillis();
                f16 = a(context, str2);
                QLog.e("ChatBackground_Time", 1, "Normal_getBitmap " + (SystemClock.uptimeMillis() - uptimeMillis));
            } else {
                File file2 = new File(com.tencent.qqsharpP.a.a(file));
                if (file2.exists()) {
                    f16 = b(context, str2, f16, file2);
                } else {
                    QLog.e("ChatBackground", 1, "getChatBackground Error, file == null ; path = " + str2);
                    try {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("param_FailCode", "dd_5");
                        hashMap.put("param_themeid", ThemeUtil.getCurrentThemeId());
                        StatisticCollector statisticCollector = StatisticCollector.getInstance(context);
                        String account = ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount();
                        if (f16 != null) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        statisticCollector.collectPerformance(account, "ChatBackgroundDecoder", z26, 1L, 0L, hashMap, "", false);
                    } catch (Exception unused) {
                    }
                    z18 = true;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getChatBackground, check bg=");
                    if (f16 == null) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    sb5.append(z19);
                    sb5.append(", path=");
                    sb5.append(str2);
                    QLog.d("ChatBackground", 1, sb5.toString());
                    if (f16 == null) {
                        ImageCacheHelper.f98636a.i(str2, f16, Business.AIO);
                        tVar.f179994a = str2;
                        tVar.f179996c = new ChatBackgroundDrawable(context.getResources(), f16);
                        tVar.f179995b = f(sharedPreferences, str2, f16);
                        tVar.f179997d = true;
                        return;
                    }
                    String string = ThemeBackground.getSharedPreferences(context, str, 0).getString("theme_bg_aio_path_url", null);
                    if (!TextUtils.isEmpty(string)) {
                        QLog.d("ChatBackground", 1, "getChatBackground, downloading, url=" + string + ", path=" + str2);
                        ResData resData = new ResData();
                        resData.path = str2;
                        resData.url = string;
                        resData.loadingType = 3;
                        tVar.f179996c = DIYThemeUtils.getDIYDrawable(context, resData, 0, 0, -1, z17);
                        tVar.f179994a = str2;
                        return;
                    }
                    QLog.e("ChatBackground", 1, "getChatBackground, bg == null, path=" + str2 + ", fileErr=" + z18);
                    tVar.f179994a = "null";
                    try {
                        tVar.f179995b = context.getResources().getColorStateList(R.color.qui_common_text_secondary);
                    } catch (RuntimeException unused2) {
                        QLog.d("ChatBackground_Time", 2, "getChatBackground error");
                    }
                    j(context, tVar, str2, z16);
                    if (!z18) {
                        tVar.f179997d = false;
                        return;
                    }
                    return;
                }
            }
        }
        z18 = false;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("getChatBackground, check bg=");
        if (f16 == null) {
        }
        sb52.append(z19);
        sb52.append(", path=");
        sb52.append(str2);
        QLog.d("ChatBackground", 1, sb52.toString());
        if (f16 == null) {
        }
    }

    private static boolean n(Context context, t tVar, String str) {
        if (TextUtils.isEmpty(str) || !str.contains("https")) {
            return false;
        }
        if (tVar.f179996c != null && tVar.f179997d && !TextUtils.isEmpty(tVar.f179994a) && tVar.f179994a.equals(str)) {
            return false;
        }
        ZPlanCoupleAIOBackgroundContainer.Companion companion = ZPlanCoupleAIOBackgroundContainer.INSTANCE;
        int b16 = companion.b();
        int a16 = companion.a(context);
        QLog.i("ChatBackground", 1, "updateZPlanBackgroundByPath, path: " + str + ", bgWidth: " + b16 + ", bgHeight: " + a16);
        Drawable backgroundDrawable = ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getBackgroundDrawable(CoupleAvatarSubScene.AIO, b16, a16, str, tVar.f179996c);
        if (backgroundDrawable == null) {
            QLog.e("ChatBackground", 1, "updateZPlanBackgroundByPath failed, drawable null.");
            return false;
        }
        tVar.f179994a = str;
        tVar.f179996c = backgroundDrawable;
        tVar.f179995b = i(context, str);
        tVar.f179997d = true;
        return true;
    }
}

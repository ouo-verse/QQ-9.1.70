package com.tencent.mobileqq.qqexpand.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f264088a = {"expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png", "expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png", "expand_square_blank.png", "expand_voice_animation.json", "expand_summary_bg.png", "expand_summary_default_bg.png", "expand_guide_wording.png", "expand_guide_profile.png", "expand_guide_switch.png", "expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f264089b = {"expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f264090c = {"expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f264091d = {"expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png"};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0062 -> B:14:0x0081). Please report as a decompilation issue!!! */
    public static Bitmap a(String str, BitmapFactory.Options options) {
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        InputStream inputStream = null;
        bitmap = null;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            ?? exists = file.exists();
            try {
                try {
                } catch (Exception e16) {
                    QLog.w("ExtendFriendResourceUtil", 1, "", e16);
                    exists = exists;
                }
                if (exists != 0) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (Exception e17) {
                        e = e17;
                        bufferedInputStream = null;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        bufferedInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                                QLog.w("ExtendFriendResourceUtil", 1, "", e19);
                            }
                        }
                        throw th;
                    }
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e26) {
                            QLog.w("ExtendFriendResourceUtil", 1, "", e26);
                        }
                        bitmap = decodeStream;
                        exists = bufferedInputStream;
                    } catch (Exception e27) {
                        e = e27;
                        QLog.d("ExtendFriendResourceUtil", 1, String.format("decodeFile fail, filePath=%s", str), e);
                        exists = bufferedInputStream;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                            exists = bufferedInputStream;
                        }
                        return bitmap;
                    } catch (OutOfMemoryError e28) {
                        e = e28;
                        QLog.d("ExtendFriendResourceUtil", 1, String.format("decodeFile fail, filePath=%s", str), e);
                        exists = bufferedInputStream;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                            exists = bufferedInputStream;
                        }
                        return bitmap;
                    }
                } else {
                    QLog.d("ExtendFriendResourceUtil", 1, String.format("decodeFile fail, file not exists filePath=%s", str));
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = exists;
            }
        }
        return bitmap;
    }

    private static String b() {
        File filesDir = MobileQQ.sMobileQQ.getFilesDir();
        if (filesDir != null) {
            String str = filesDir.getAbsolutePath() + "/pddata/prd/ef_flutter_res_v5";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                return str;
            }
            return str;
        }
        return null;
    }

    public static String c() {
        return String.format("%s/res", b());
    }

    private static String d() {
        File filesDir = MobileQQ.sMobileQQ.getFilesDir();
        if (filesDir != null) {
            String str = filesDir.getAbsolutePath() + "/pddata/prd/ef_res";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                return str;
            }
            return str;
        }
        return null;
    }

    public static String e(String str) {
        return String.format("%s/%s", f(), str);
    }

    public static String f() {
        return String.format("%s/res", d());
    }

    public static boolean g(String[] strArr) {
        for (String str : strArr) {
            if (!new File(str).exists()) {
                QLog.e("ExtendFriendResourceUtil", 1, String.format("isFilesExist check fail. filePath=%s", str));
                return false;
            }
        }
        return true;
    }
}

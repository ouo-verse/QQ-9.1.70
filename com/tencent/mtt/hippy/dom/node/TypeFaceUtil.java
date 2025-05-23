package com.tencent.mtt.hippy.dom.node;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TypeFaceUtil {
    private static final String FONTS_PATH = "fonts/";
    private static final String TAG = "TypeFaceUtil";
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FONT_EXTENSIONS = {".ttf", ".otf"};
    private static final Map<String, Typeface> mFontCache = new HashMap();

    public static Typeface addTypeface(String str, String str2, int i3) {
        String str3 = str + i3;
        Typeface typeface = mFontCache.get(str3);
        if (typeface != null) {
            return typeface;
        }
        try {
            typeface = Typeface.createFromFile(str2);
        } catch (RuntimeException e16) {
            e16.printStackTrace();
        }
        if (typeface != null) {
            mFontCache.put(str3, typeface);
        }
        return typeface;
    }

    public static Typeface addTypefaceWithBase64(String str, String str2, int i3) {
        String str3 = str + i3;
        Typeface typeface = mFontCache.get(str3);
        if (typeface != null) {
            return typeface;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String fontPath = getFontPath(ContextHolder.getAppContext(), str3);
        byte[] realTTFBase64 = getRealTTFBase64(str2);
        deleteFontFile(fontPath);
        saveFontFile(fontPath, realTTFBase64);
        Typeface addTypeface = addTypeface(str, fontPath, 0);
        deleteFontFile(fontPath);
        return addTypeface;
    }

    public static void apply(Paint paint, int i3, int i16, String str, HippyFontScaleAdapter hippyFontScaleAdapter) {
        int style;
        Typeface typeface = paint.getTypeface();
        int i17 = 0;
        if (typeface == null) {
            style = 0;
        } else {
            style = typeface.getStyle();
        }
        if (i16 == 1 || ((style & 1) != 0 && i16 == -1)) {
            i17 = 1;
        }
        if (i3 == 2 || ((2 & style) != 0 && i3 == -1)) {
            i17 |= 2;
        }
        if (str != null) {
            typeface = getTypeface(str, i17, hippyFontScaleAdapter);
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i17);
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
        } else {
            paint.setTypeface(Typeface.defaultFromStyle(i17));
        }
    }

    public static boolean checkFontExist(String str, int i3) {
        if (mFontCache.get(str + i3) != null) {
            return true;
        }
        return false;
    }

    private static Typeface createTypeface(String str, int i3, HippyFontScaleAdapter hippyFontScaleAdapter) {
        String str2 = EXTENSIONS[i3];
        Typeface typeface = null;
        for (String str3 : FONT_EXTENSIONS) {
            try {
                typeface = Typeface.createFromAsset(ContextHolder.getAppContext().getAssets(), FONTS_PATH + str + str2 + str3);
            } catch (Exception e16) {
                LogUtils.e(TAG, "createTypeface: " + e16.getMessage());
            }
        }
        if (typeface == null && hippyFontScaleAdapter != null) {
            String customFontFilePath = hippyFontScaleAdapter.getCustomFontFilePath(str, i3);
            if (!TextUtils.isEmpty(customFontFilePath)) {
                try {
                    typeface = Typeface.createFromFile(customFontFilePath);
                } catch (Exception e17) {
                    LogUtils.e(TAG, "createTypeface: " + e17.getMessage());
                }
            }
        }
        if (typeface == null) {
            return Typeface.create(str, i3);
        }
        return typeface;
    }

    private static void deleteFontFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    private static String getFontPath(Context context, String str) {
        return context.getCacheDir().getAbsolutePath() + File.separator + str + ".ttf";
    }

    private static byte[] getRealTTFBase64(String str) {
        LogUtils.d(TAG, "\u539f\u59cb\u5b57\u5e93\u6570\u636e base64Str\uff1a" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("base64,");
        if (indexOf > 0) {
            str = str.substring(indexOf + 7);
        }
        return Base64.decode(str, 0);
    }

    public static Typeface getTypeface(String str, int i3, HippyFontScaleAdapter hippyFontScaleAdapter) {
        String str2 = str + i3;
        Map<String, Typeface> map = mFontCache;
        Typeface typeface = map.get(str2);
        if (typeface == null) {
            typeface = createTypeface(str, i3, hippyFontScaleAdapter);
        }
        if (typeface != null) {
            map.put(str2, typeface);
        }
        return typeface;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x002d -> B:8:0x0030). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void saveFontFile(String str, byte[] bArr) {
        Throwable th5;
        BufferedOutputStream bufferedOutputStream;
        IOException e16;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str)));
            } catch (IOException e18) {
                bufferedOutputStream = null;
                e16 = e18;
            } catch (Throwable th6) {
                bufferedOutputStream = null;
                th5 = th6;
                if (bufferedOutputStream != null) {
                }
                throw th5;
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (IOException e19) {
                e16 = e19;
                e16.printStackTrace();
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th5;
        }
    }
}

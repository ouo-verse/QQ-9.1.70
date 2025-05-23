package com.tencent.ams.dsdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BitmapUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BitmapUtils";

    public BitmapUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap bitmapFromFile(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return bitmapFromFilePath(file.getAbsolutePath());
        }
        return null;
    }

    public static Bitmap bitmapFromFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th5) {
            DLog.e("BitmapUtils", "decode bitmap error: " + th5.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #0 {all -> 0x008a, blocks: (B:6:0x0007, B:8:0x0011, B:10:0x001b, B:11:0x0024, B:14:0x0035), top: B:5:0x0007 }] */
    @RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap blur(Bitmap bitmap, float f16) {
        Bitmap bitmap2;
        Bitmap createBitmap;
        Bitmap.Config config;
        if (bitmap == null) {
            return null;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Build.VERSION.SDK_INT >= 26) {
                Bitmap.Config config2 = bitmap.getConfig();
                config = Bitmap.Config.HARDWARE;
                if (config2 == config) {
                    bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, false);
                    createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    if (createBitmap != null) {
                        return bitmap;
                    }
                    RenderScript create = RenderScript.create(DKEngine.getApplicationContext());
                    Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap2);
                    Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
                    ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    create2.setRadius(f16);
                    create2.setInput(createFromBitmap);
                    create2.forEach(createTyped);
                    createTyped.copyTo(createBitmap);
                    createFromBitmap.destroy();
                    createTyped.destroy();
                    create2.destroy();
                    create.destroy();
                    DLog.d("BitmapUtils", "blur bitmap success, cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                    return createBitmap;
                }
            }
            bitmap2 = bitmap;
            createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            if (createBitmap != null) {
            }
        } catch (Throwable th5) {
            DLog.w("BitmapUtils", "blur failed: " + th5);
            return bitmap;
        }
    }
}

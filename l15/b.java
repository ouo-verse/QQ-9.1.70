package l15;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.qzone.module.vipcomponent.common.VipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        if (r3 == null) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b A[Catch: all -> 0x0081, TryCatch #3 {all -> 0x0081, blocks: (B:50:0x000a, B:52:0x000e, B:14:0x0085, B:16:0x008b, B:28:0x0093, B:30:0x0099, B:4:0x002f, B:6:0x003a, B:10:0x0042, B:45:0x0059, B:47:0x0065, B:48:0x0077), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #3 {all -> 0x0081, blocks: (B:50:0x000a, B:52:0x000e, B:14:0x0085, B:16:0x008b, B:28:0x0093, B:30:0x0099, B:4:0x002f, B:6:0x003a, B:10:0x0042, B:45:0x0059, B:47:0x0065, B:48:0x0077), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        Bitmap bitmap;
        FileInputStream fileInputStream2 = null;
        try {
            if (options != null) {
                try {
                    if (options.inJustDecodeBounds) {
                        FileInputStream fileInputStream3 = new FileInputStream(str);
                        try {
                            fileInputStream2 = fileInputStream3;
                            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream3, 8192), null, options);
                            if (fileInputStream2 == null) {
                                try {
                                    fileInputStream2.close();
                                    return bitmap;
                                } catch (IOException unused) {
                                    return bitmap;
                                }
                            }
                            return bitmap;
                        } catch (Exception e16) {
                            e = e16;
                            fileInputStream = null;
                            fileInputStream2 = fileInputStream3;
                            if (QLog.isColorLevel()) {
                            }
                            if (fileInputStream2 != null) {
                            }
                            return fileInputStream;
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            fileInputStream = null;
                            fileInputStream2 = fileInputStream3;
                            if (QLog.isColorLevel()) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream2 = fileInputStream3;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    fileInputStream = fileInputStream2;
                }
            }
            if (SharpPUtils.isSharpP(new File(str))) {
                Bitmap decodeSharpP = SharpPUtils.decodeSharpP(str);
                bitmap = decodeSharpP;
                bitmap = decodeSharpP;
                if (decodeSharpP != 0 && options != null) {
                    try {
                        options.outHeight = decodeSharpP.getHeight();
                        options.outWidth = decodeSharpP.getWidth();
                        bitmap = decodeSharpP;
                    } catch (Exception e26) {
                        fileInputStream = decodeSharpP;
                        e = e26;
                        if (QLog.isColorLevel()) {
                            QLog.e(VipUtils.TAG, 2, "", e);
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return fileInputStream;
                    } catch (OutOfMemoryError e27) {
                        fileInputStream = decodeSharpP;
                        e = e27;
                        if (QLog.isColorLevel()) {
                            QLog.e(VipUtils.TAG, 2, "", e);
                        }
                    }
                }
            } else if (BaseApplicationImpl.getApplication().getRuntime() instanceof PluginRuntime) {
                bitmap = ImageManager.getInstance().getDecoder().decodeFile(new File(str), options);
            } else {
                bitmap = SafeBitmapFactory.decodeFile(str, options);
            }
            if (fileInputStream2 == null) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static int b(String str) {
        String str2;
        int lastIndexOf;
        int lastIndexOf2;
        if (e(str) || (lastIndexOf = str.lastIndexOf((str2 = File.separator))) == -1 || lastIndexOf == str.length() - 1) {
            return 0;
        }
        String substring = str.substring(0, lastIndexOf);
        if (e(substring) || (lastIndexOf2 = substring.lastIndexOf(str2)) == -1 || lastIndexOf2 == substring.length() - 1) {
            return 0;
        }
        try {
            return Integer.parseInt(substring.substring(lastIndexOf2 + 1));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String c(String str) {
        int lastIndexOf;
        int length;
        if (TextUtils.isEmpty(str) || str.length() < 4 || (lastIndexOf = str.lastIndexOf("/") + 1) > (length = str.length() - 4)) {
            return "";
        }
        return str.substring(lastIndexOf, length);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = File.separator;
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf == -1) {
            return str;
        }
        if (lastIndexOf == str.length() - 1) {
            return "";
        }
        String substring = str.substring(0, lastIndexOf);
        if (TextUtils.isEmpty(substring)) {
            return "";
        }
        int lastIndexOf2 = substring.lastIndexOf(str2);
        if (lastIndexOf2 == -1) {
            return substring;
        }
        if (lastIndexOf2 == substring.length() - 1) {
            return "";
        }
        return substring.substring(lastIndexOf2 + 1);
    }

    public static boolean e(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }
}

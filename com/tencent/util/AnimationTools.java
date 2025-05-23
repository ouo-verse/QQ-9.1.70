package com.tencent.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AnimationTools {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "DecodeDrawables";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements Comparator<File> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private int b(String str) {
            int parseInt;
            try {
                int lastIndexOf = str.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    parseInt = Integer.parseInt(str);
                } else {
                    parseInt = Integer.parseInt(str.substring(0, lastIndexOf));
                }
                return parseInt;
            } catch (Exception unused) {
                return 0;
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            return b(file.getName()) - b(file2.getName());
        }
    }

    public AnimationTools() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100 A[LOOP:1: B:39:0x00fe->B:40:0x0100, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable[] decodeDrawablesFromPath(String str) {
        BufferedInputStream bufferedInputStream;
        StringBuilder sb5;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "folderPath:" + str);
        }
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "folderPath not exist");
            }
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            sortByFileNameNum(listFiles);
            int length = listFiles.length;
            Drawable[] drawableArr = new Drawable[length];
            int i3 = 0;
            boolean z16 = false;
            while (i3 < listFiles.length) {
                File file2 = listFiles[i3];
                if (file2 != null && file2.isFile() && FileUtils.isPicFile(listFiles[i3].getAbsolutePath())) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(listFiles[i3].getAbsolutePath()));
                        try {
                            drawableArr[i3] = new BitmapDrawable(bufferedInputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 2, "decode fail - OutOfMemoryError" + th);
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e16) {
                                        e = e16;
                                        if (QLog.isColorLevel()) {
                                            sb5 = new StringBuilder();
                                            sb5.append("decode fail - close bis fail");
                                            sb5.append(e);
                                            QLog.e(TAG, 2, sb5.toString());
                                        }
                                    }
                                }
                                z16 = true;
                                if (z16) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                while (i3 >= 0) {
                                }
                                return null;
                            } catch (Throwable th6) {
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e17) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e(TAG, 2, "decode fail - close bis fail" + e17);
                                        }
                                    }
                                }
                                throw th6;
                            }
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e18) {
                            e = e18;
                            if (QLog.isColorLevel()) {
                                sb5 = new StringBuilder();
                                sb5.append("decode fail - close bis fail");
                                sb5.append(e);
                                QLog.e(TAG, 2, sb5.toString());
                            }
                            z16 = true;
                            if (z16) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            while (i3 >= 0) {
                            }
                            return null;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedInputStream = null;
                    }
                    if (z16 || ((BitmapDrawable) drawableArr[i3]).getBitmap() == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "decode fail till" + listFiles[i3].getAbsolutePath());
                        }
                        while (i3 >= 0) {
                            destroyDrawable(drawableArr[i3]);
                            i3--;
                        }
                        return null;
                    }
                }
                i3++;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                if (drawableArr[i17] != null) {
                    i16++;
                }
            }
            if (i16 < 1) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "no valid frame");
                }
                return null;
            }
            return drawableArr;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "nothing in unzip folder");
        }
        return null;
    }

    public static void delete(String str, boolean z16, File file) {
        QLog.d(TAG, 2, "1.0 delete " + str + z16 + file + file.exists());
        if (str == null) {
            return;
        }
        File file2 = new File(str);
        QLog.d(TAG, 2, "1.0 delete tag0" + file2 + file2.exists());
        if (!file2.exists()) {
            QLog.d(TAG, 2, "1.0 delete tag1" + file.exists());
            return;
        }
        if (file2.isFile()) {
            QLog.d(TAG, 2, "1.0 delete tag2" + file2 + file2.exists() + file.exists());
            file2.delete();
            QLog.d(TAG, 2, "1.0 delete tag3" + file2 + file2.exists() + file.exists());
            return;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null) {
            QLog.d(TAG, 2, "1.0 delete tag4" + file.exists());
            return;
        }
        for (File file3 : listFiles) {
            QLog.d(TAG, 2, "1.0 delete tag5" + file3 + file.exists());
            delete(file3.getAbsolutePath(), z16, file);
            QLog.d(TAG, 2, "1.0 delete tag6" + file3 + file.exists());
        }
        if (!z16) {
            QLog.d(TAG, 2, "1.0 delete tag7" + file2 + file.exists());
            file2.delete();
            QLog.d(TAG, 2, "1.0 delete tag8" + file2 + file.exists());
        }
    }

    public static void destroyDrawable(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return;
        }
        try {
            drawable.setCallback(null);
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
            }
        }
    }

    public static void sortByFileNameNum(File[] fileArr) {
        Arrays.sort(fileArr, new a());
    }

    public static boolean unzipAtomically(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        String str3 = str + "Tmp";
        File file2 = new File(str3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unzipAtomically1" + file + file.exists() + file2 + file2.exists());
        }
        FileUtils.delete(str3, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unzipAtomically2" + file + file.exists() + file2 + file2.exists());
        }
        if (QLog.isColorLevel() && !file.exists()) {
            try {
                FileUtils.writeFile(new byte[]{0, 0}, str);
                QLog.d(TAG, 2, "3." + file + file.exists());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("intern");
                delete(sb5.toString(), false, file);
                QLog.d(TAG, 2, "4." + file + file.exists());
                FileUtils.writeFile(new byte[]{0, 0}, str);
                QLog.d(TAG, 2, "0." + file + file.exists());
                delete(str3, false, file);
                QLog.d(TAG, 2, "2." + file + file.exists());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        try {
            if (!FileUtils.uncompressZipEntry(str, str3)) {
                return false;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(str2);
        FileUtils.delete(str2, false);
        if (!FileUtils.renameFile(file2, file3) || !file3.exists()) {
            return false;
        }
        return true;
    }
}

package com.tencent.mobileqq.filemanager.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class FilePicURLDrawlableHelper {

    /* renamed from: a, reason: collision with root package name */
    public static int f209167a;

    /* renamed from: b, reason: collision with root package name */
    public static int f209168b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f209169c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f209170d;

    /* renamed from: e, reason: collision with root package name */
    private static List<String> f209171e;

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f209173a;

        /* renamed from: b, reason: collision with root package name */
        public int f209174b;
    }

    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f209175a;

        /* renamed from: b, reason: collision with root package name */
        int f209176b;

        public String toString() {
            return "Type [type1=" + this.f209175a + ", type2=" + this.f209176b + "]";
        }
    }

    static {
        int i3 = BaseChatItemLayout.N;
        if (i3 > 0) {
            com.tencent.mobileqq.widget.n.f317096c = i3;
            com.tencent.mobileqq.widget.n.f317095b = (int) (BaseChatItemLayout.N * 0.5625f);
        }
        f209167a = com.tencent.mobileqq.widget.n.f317096c;
        f209168b = com.tencent.mobileqq.widget.n.f317095b;
        float f16 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
        if (f16 != 0.0f) {
            f209167a = (int) (com.tencent.mobileqq.widget.n.f317096c / f16);
            f209168b = (int) (com.tencent.mobileqq.widget.n.f317095b / f16);
        }
        f209169c = com.tencent.mobileqq.widget.n.f317095b;
        f209170d = com.tencent.mobileqq.widget.n.f317096c;
        f209171e = new ArrayList();
    }

    private static int a(int i3, int i16, int i17) {
        if (i3 != 0 && i16 != 0) {
            int i18 = 1;
            while (true) {
                i3 >>= 1;
                i16 >>= 1;
                if (i3 < i17 || i16 < i17) {
                    break;
                }
                i18 *= 2;
            }
            if (i18 < 1) {
                return 1;
            }
            return i18;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r9 > r8) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a b(int i3, int i16, b bVar, boolean z16) {
        int i17;
        int i18;
        int i19;
        int round;
        int i26 = com.tencent.mobileqq.widget.n.f317096c;
        int i27 = com.tencent.mobileqq.widget.n.f317095b;
        int i28 = bVar.f209176b;
        if (i28 == 1 || i28 == 3 || i28 == 6) {
            if (i3 > i16) {
                i17 = i16;
            } else {
                i17 = i3;
            }
            int i29 = (int) (i17 * 1.7777778f);
            if (i3 > i16) {
                i29 = i17;
                i17 = i29;
            }
            if (i17 <= i3) {
                i3 = i17;
            }
            if (i29 <= i16) {
                i16 = i29;
            }
        }
        if (i3 > i16) {
            i19 = i3;
            i18 = i16;
        } else {
            i18 = i3;
            i19 = i16;
        }
        int i36 = bVar.f209175a;
        if (i36 != 1) {
            if (i36 != 2) {
                if (i36 == 4) {
                    round = (int) (i18 * 1.7777778f);
                    if (i3 > i16) {
                        int i37 = i18;
                        i18 = round;
                        round = i37;
                    }
                    if (i18 <= i3) {
                        i3 = i18;
                    }
                }
            } else {
                float f16 = i26 / (i19 * 1.0f);
                i3 = Math.round(i3 * f16);
                i16 = Math.round(i16 * f16);
            }
        } else {
            float f17 = i27 / (i18 * 1.0f);
            int round2 = Math.round(i3 * f17);
            round = Math.round(i16 * f17);
            if (i3 <= i16) {
                i27 = i26;
                i26 = i27;
            }
            if (i26 > round2) {
                i3 = round2;
            } else {
                i3 = i26;
            }
            if (i27 <= round) {
                i16 = i27;
            }
            i16 = round;
        }
        a aVar = new a();
        aVar.f209173a = i3;
        aVar.f209174b = i16;
        return aVar;
    }

    public static URL c(final FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return null;
        }
        String str = fileManagerEntity.strMiddleThumPath;
        if (fileManagerEntity.status == 16 && !q.f(str)) {
            if (q.f(fileManagerEntity.strLargeThumPath)) {
                str = fileManagerEntity.strLargeThumPath;
            } else if (q.f(fileManagerEntity.strThumbPath)) {
                str = fileManagerEntity.strThumbPath;
            }
        }
        if (!q.f(str) && q.f(fileManagerEntity.strLargeThumPath)) {
            str = fileManagerEntity.strLargeThumPath;
            if (t(fileManagerEntity)) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FilePicURLDrawlableHelper.k(FileManagerEntity.this);
                    }
                }, 8, null, false);
            }
        }
        String str2 = str;
        if (!FileUtils.fileExistsAndNotEmpty(str2)) {
            return null;
        }
        try {
            URL d16 = AsyncImageView.d(str2, -1, -1, new File(str2), false, false, true);
            if (d16 == null) {
                return null;
            }
            return d16;
        } catch (Exception unused) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("FilePicURLDrawlableHelper<FileAssistant>", 1, "createFilePicDrawlableURL generateAIOThumbURL error!");
            return null;
        }
    }

    public static URL d(FileManagerEntity fileManagerEntity) {
        boolean z16;
        if (fileManagerEntity == null) {
            return null;
        }
        if (fileManagerEntity.getCloudType() == 3 && !FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strMiddleThumPath)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String g16 = g(fileManagerEntity.getFilePath());
            if (g16 == null) {
                return null;
            }
            String str = fileManagerEntity.strFileMd5;
            if (TextUtils.isEmpty(str)) {
                str = fileManagerEntity.Uuid;
            }
            if (TextUtils.isEmpty(str)) {
                String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(fileManagerEntity.getFilePath()));
                if (!TextUtils.isEmpty(bytes2HexStr)) {
                    str = bytes2HexStr.toUpperCase();
                }
            }
            String str2 = lc1.b.a().getDefaultThumbPath() + o(5, com.tencent.securitysdk.utils.c.b(str));
            if (FileUtils.fileExistsAndNotEmpty(g16) && !q.f(fileManagerEntity.strMiddleThumPath) && FileUtils.renameFile(new File(g16), new File(str2))) {
                fileManagerEntity.strMiddleThumPath = str2;
            }
        }
        return c(fileManagerEntity);
    }

    public static void e(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig entity is null, so return");
            return;
        }
        if (fileManagerEntity.nFileType != 0) {
            QLog.i("FilePicURLDrawlableHelper<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "] createQXlargeThumbWithOrig is not image file!");
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strLargeThumPath)) {
            QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig Thumb file " + fileManagerEntity.strLargeThumPath + " already exist");
            return;
        }
        String i3 = i(fileManagerEntity.getFilePath(), lc1.b.a().getDefaultThumbPath() + o(7, p(fileManagerEntity)), 2);
        if (i3 == null) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig failed");
        } else {
            fileManagerEntity.strLargeThumPath = i3;
        }
    }

    private static void f(FileManagerEntity fileManagerEntity, String str) {
        String i3 = i(str, lc1.b.a().getDefaultThumbPath() + o(5, p(fileManagerEntity)), 1);
        if (i3 == null) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge failed");
            return;
        }
        fileManagerEntity.strMiddleThumPath = i3;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            qQAppInterface.getFileManagerDataCenter().f0(fileManagerEntity);
            qQAppInterface.getFileManagerNotifyCenter().b(true, 3, null);
        }
    }

    public static String g(String str) {
        String str2;
        if (!q.f(str)) {
            return null;
        }
        String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(str));
        n();
        String str3 = lc1.b.a().getDefaultThumbPath() + o(5, bytes2HexStr);
        String str4 = str3 + "_original_.tmp";
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            str2 = str;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        try {
            if (!FileUtils.fileExistsAndNotEmpty(str4)) {
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).compressAIOThumbnail(str2, str4, true, "", 1);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!FileUtils.fileExistsAndNotEmpty(str4) || !FileUtils.renameFile(new File(str4), new File(str3))) {
            return null;
        }
        return str3;
    }

    public static a h(int i3, int i16, boolean z16) {
        int i17;
        int i18;
        if (i3 > i16) {
            i18 = i3;
            i17 = i16;
        } else {
            i17 = i3;
            i18 = i16;
        }
        b q16 = q(i17, i18);
        int a16 = a(i3, i16, com.tencent.mobileqq.widget.n.f317096c);
        return b(i3 * a16, i16 * a16, q16, false);
    }

    public static String i(String str, String str2, int i3) {
        String str3 = null;
        if (u(str2) == -1) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile temp Thumb file " + str2 + " is creating");
            return null;
        }
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile file " + str + " is not exist");
        } else {
            n();
            String str4 = str2 + ".tmp";
            try {
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).compressAIOThumbnail(str, str4, true, "", i3);
                if (!FileUtils.fileExistsAndNotEmpty(str4)) {
                    QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str4 + " failed");
                } else if (!FileUtils.renameFile(new File(str4), new File(str2))) {
                    FileUtils.delete(str4, true);
                    QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile rename tmp Thumb file " + str4 + " failed");
                } else {
                    str3 = str2;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str4 + " failed");
            }
        }
        v(str2);
        return str3;
    }

    public static void j(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig entity is null, so return null");
        } else {
            if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strMiddleThumPath)) {
                return;
            }
            f(fileManagerEntity, fileManagerEntity.getFilePath());
        }
    }

    public static void k(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge entity is null, so return null");
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strMiddleThumPath)) {
            QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge Thumb file " + fileManagerEntity.strMiddleThumPath + " already exist");
            return;
        }
        f(fileManagerEntity, fileManagerEntity.strLargeThumPath);
    }

    public static void l(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge entity is null, so return null");
        } else {
            FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strMiddleThumPath);
            f(fileManagerEntity, fileManagerEntity.strMiddleThumPath);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r3 != null) goto L38;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0041: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:66), block:B:26:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap m(String str, BitmapFactory.Options options) {
        BufferedInputStream bufferedInputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        Bitmap bitmap = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            } catch (Exception e16) {
                e = e16;
                bufferedInputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                bitmap = BitmapFactory.decodeStream(bufferedInputStream, null, options);
            } catch (Exception e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e("FilePicURLDrawlableHelper<FileAssistant>", 2, "decodeFileWithBufferedStream Exception", e);
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return bitmap;
            } catch (OutOfMemoryError e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e("FilePicURLDrawlableHelper<FileAssistant>", 2, "decodeFileWithBufferedStream OutOfMemoryError", e);
                }
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                return bitmap;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private static void n() {
        File file = new File(lc1.b.a().getDefaultThumbPath());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String o(int i3, String str) {
        String str2;
        switch (i3) {
            case 0:
                str2 = "micro-dsc-";
                break;
            case 1:
                str2 = "minni-dsc-";
                break;
            case 2:
                str2 = "small-dsc-";
                break;
            case 3:
                str2 = "middle-dsc-";
                break;
            case 4:
                str2 = "large-dsc-";
                break;
            case 5:
                str2 = "qlarge-dsc-";
                break;
            case 6:
                str2 = "xlarge-dsc-";
                break;
            case 7:
                str2 = "qxlarge-dsc-";
                break;
            case 8:
                str2 = "screen-dsc-";
                break;
            default:
                str2 = "x-dsc-";
                break;
        }
        return str2 + str;
    }

    public static String p(FileManagerEntity fileManagerEntity) {
        String b16;
        if (fileManagerEntity == null) {
            QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "getThumbPath entity is null, so return null");
            return null;
        }
        if (!TextUtils.isEmpty(fileManagerEntity.strFileMd5)) {
            b16 = com.tencent.securitysdk.utils.c.b(fileManagerEntity.strFileMd5);
        } else if (!TextUtils.isEmpty(fileManagerEntity.Uuid)) {
            b16 = com.tencent.securitysdk.utils.c.b(fileManagerEntity.Uuid);
        } else if (q.f(fileManagerEntity.getFilePath())) {
            byte[] md5 = FileManagerUtil.getMd5(fileManagerEntity.getFilePath());
            if (md5 != null && md5.length > 0) {
                b16 = HexUtil.bytes2HexStr(md5).toUpperCase();
            } else {
                b16 = com.tencent.securitysdk.utils.c.b(fileManagerEntity.fileName);
            }
        } else {
            b16 = com.tencent.securitysdk.utils.c.b(fileManagerEntity.fileName);
        }
        if (b16 != null) {
            return b16.replace("/", "");
        }
        return b16;
    }

    private static b q(int i3, int i16) {
        int i17;
        int i18;
        int i19 = com.tencent.mobileqq.widget.n.f317096c;
        int i26 = com.tencent.mobileqq.widget.n.f317095b;
        int i27 = 1;
        int i28 = 2;
        if (i3 > i19) {
            if (!r(i3, i16)) {
                i27 = 2;
            }
            i28 = i27;
        } else if (i3 <= i19 && i3 > i26) {
            if (i16 > i19) {
                if (r(i3, i16)) {
                    i28 = 3;
                } else {
                    i27 = 2;
                    i28 = 4;
                }
            } else {
                if (i16 <= i19 && i16 > i26) {
                    i17 = 5;
                    i28 = i17;
                    i27 = 3;
                }
                i27 = 0;
                i28 = i27;
            }
        } else {
            if (i3 <= i26 && i3 > 0) {
                if (i16 > i19) {
                    i18 = 6;
                } else if (i16 <= i19 && i16 > i26) {
                    if (r(i3, i16)) {
                        i18 = 7;
                    } else {
                        i17 = 8;
                        i28 = i17;
                        i27 = 3;
                    }
                } else if (i16 <= i26 && i16 > 0) {
                    if (r(i3, i16)) {
                        i18 = 9;
                    } else {
                        i17 = 10;
                        i28 = i17;
                        i27 = 3;
                    }
                }
                i28 = i18;
                i27 = 4;
            }
            i27 = 0;
            i28 = i27;
        }
        b bVar = new b();
        bVar.f209175a = i27;
        bVar.f209176b = i28;
        return bVar;
    }

    public static boolean r(int i3, int i16) {
        if (i16 > ((int) (i3 * 1.7777778f))) {
            return true;
        }
        return false;
    }

    public static boolean s(int i3, int i16) {
        if (i16 <= 0 || i3 <= 0) {
            return true;
        }
        if (i3 > i16) {
            i16 = i3;
            i3 = i16;
        }
        if (r(i3, i16)) {
            return true;
        }
        return false;
    }

    public static boolean t(FileManagerEntity fileManagerEntity) {
        return s(fileManagerEntity.imgWidth, fileManagerEntity.imgHeight);
    }

    public static long u(String str) {
        synchronized (f209171e) {
            if (f209171e.contains(str)) {
                return -1L;
            }
            f209171e.add(str);
            return 1L;
        }
    }

    private static void v(String str) {
        synchronized (f209171e) {
            f209171e.remove(str);
        }
    }
}

package n0;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileInputStream;
import com.tencent.mm.vfs.VFSFileOutputStream;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ao;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(VFSFile vFSFile, VFSFile vFSFile2) {
        return b(vFSFile, vFSFile2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(VFSFile vFSFile, VFSFile vFSFile2, boolean z16) {
        VFSFileInputStream vFSFileInputStream;
        byte[] bArr;
        if (vFSFile.isFile()) {
            VFSFileOutputStream vFSFileOutputStream = null;
            try {
                if (vFSFile2.exists()) {
                    if (z16) {
                        return false;
                    }
                    um2.a.a(vFSFile.getAbsolutePath(), vFSFile2.getAbsolutePath());
                    vFSFile2.delete();
                }
                VFSFileOutputStream vFSFileOutputStream2 = new VFSFileOutputStream(vFSFile2);
                try {
                    vFSFileInputStream = new VFSFileInputStream(vFSFile);
                    try {
                        try {
                            bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                        } catch (IOException e16) {
                            e = e16;
                            vFSFileOutputStream = vFSFileOutputStream2;
                            try {
                                e.printStackTrace();
                                if (vFSFileOutputStream != null) {
                                    try {
                                        vFSFileOutputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (vFSFileInputStream != null) {
                                    try {
                                        vFSFileInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                return false;
                            } catch (Throwable th5) {
                                th = th5;
                                if (vFSFileOutputStream != null) {
                                    try {
                                        vFSFileOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (vFSFileInputStream == null) {
                                    try {
                                        vFSFileInputStream.close();
                                        throw th;
                                    } catch (IOException unused4) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            vFSFileOutputStream = vFSFileOutputStream2;
                            if (vFSFileOutputStream != null) {
                            }
                            if (vFSFileInputStream == null) {
                            }
                        }
                    } catch (OutOfMemoryError unused5) {
                        bArr = new byte[4096];
                    }
                    while (true) {
                        int read = vFSFileInputStream.read(bArr);
                        if (read != -1) {
                            vFSFileOutputStream2.write(bArr, 0, read);
                            vFSFileOutputStream2.flush();
                        } else {
                            try {
                                break;
                            } catch (IOException unused6) {
                            }
                        }
                    }
                    vFSFileOutputStream2.close();
                    try {
                        vFSFileInputStream.close();
                    } catch (IOException unused7) {
                    }
                } catch (IOException e17) {
                    e = e17;
                    vFSFileInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    vFSFileInputStream = null;
                }
            } catch (IOException e18) {
                e = e18;
                vFSFileInputStream = null;
            } catch (Throwable th8) {
                th = th8;
                vFSFileInputStream = null;
            }
        }
        if (vFSFile.isDirectory()) {
            VFSFile[] listFiles = vFSFile.listFiles();
            vFSFile2.mkdir();
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                a(listFiles[i3].getAbsoluteFile(), new VFSFile(vFSFile2.getAbsoluteFile() + "/" + listFiles[i3].getName()));
            }
            return true;
        }
        return true;
    }

    public static boolean c(File file, File file2) {
        return a(new VFSFile(file), new VFSFile(file2));
    }

    public static boolean d(File file, File file2, boolean z16) {
        return b(new VFSFile(file), new VFSFile(file2), z16);
    }

    public static String e(Context context, String str) {
        Bitmap bitmap;
        String str2 = null;
        if (FileManagerUtil.getFileType(str) == 0) {
            bitmap = b.b(str, 150, 150);
        } else if (FileManagerUtil.getFileType(str) == 2) {
            bitmap = b.d(str, 150, 150);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        try {
            try {
                String i3 = i(context, str);
                try {
                    q.q(bitmap, i3);
                    bitmap.recycle();
                    b.e(i3, b.a(str));
                    return i3;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    str2 = i3;
                    e.printStackTrace();
                    return str2;
                } catch (IOException e17) {
                    e = e17;
                    str2 = i3;
                    e.printStackTrace();
                    return str2;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            }
        } catch (OutOfMemoryError e26) {
            e26.printStackTrace();
            return null;
        }
    }

    public static void f(VFSFile vFSFile) {
        VFSFile[] listFiles;
        if (vFSFile.isDirectory() && (listFiles = vFSFile.listFiles()) != null && listFiles.length > 0) {
            for (VFSFile vFSFile2 : listFiles) {
                f(vFSFile2);
            }
        }
        vFSFile.delete();
    }

    public static void g(File file) {
        f(new VFSFile(file));
    }

    public static String h(long j3) {
        return ao.a(j3);
    }

    public static String i(Context context, String str) {
        VFSFile vFSFile = new VFSFile(Utils.w(context) + "thumbnails/");
        if (!vFSFile.exists()) {
            vFSFile.mkdirs();
        }
        return vFSFile.getAbsolutePath() + "/" + FileManagerUtil.getFileName(str) + ".JPG";
    }
}

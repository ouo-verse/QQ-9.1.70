package com.tencent.mobileqq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class v {
    static IPatchRedirector $redirector_;

    public static int a(String str) {
        int i3;
        String estimateFileType = FileUtils.estimateFileType(str);
        if ("jpg".equals(estimateFileType)) {
            i3 = 1000;
        } else if ("png".equals(estimateFileType)) {
            i3 = 1001;
        } else if ("bmp".equals(estimateFileType)) {
            i3 = 1005;
        } else if ("gif".equals(estimateFileType)) {
            i3 = 2000;
        } else if ("apng".equals(estimateFileType)) {
            i3 = 2001;
        } else if ("sharpp".equals(estimateFileType)) {
            i3 = 1004;
        } else if ("webp".equals(estimateFileType)) {
            i3 = 1002;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ImgType", 2, "sender imgType is " + i3);
        }
        return i3;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0097: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:152), block:B:59:0x0097 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<Integer> b(String str) throws OutOfMemoryError {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        boolean z16;
        BufferedInputStream bufferedInputStream3 = null;
        ArrayList<Integer> arrayList = null;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        bm.a();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
        int i3 = 0;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException e16) {
                e = e16;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedInputStream3 != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 1024);
                    if (-1 != read) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
                bufferedInputStream.close();
                z16 = true;
            } catch (IOException e18) {
                e = e18;
                e.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                z16 = false;
                if (z16) {
                }
                byteArrayOutputStream.close();
                bm.b("peak_pgjpeg", "getSliceInfos");
                return arrayList;
            }
            if (z16) {
                arrayList = new ArrayList<>(10);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int length = byteArray.length;
                while (i3 < length) {
                    int i16 = i3 + 1;
                    if (byteArray[i3] == -1) {
                        byte b16 = byteArray[i16];
                        if (b16 != -39) {
                            if (b16 == -38) {
                                arrayList.add(Integer.valueOf(i16 - 1));
                                i3 = i16 + 1;
                            }
                        }
                    }
                    i3 = i16;
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
            bm.b("peak_pgjpeg", "getSliceInfos");
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream3 = bufferedInputStream2;
            if (bufferedInputStream3 != null) {
                try {
                    bufferedInputStream3.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean c(int i3) {
        if (i3 < 2000 && i3 != 3) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x006b -> B:34:0x00ba). Please report as a decompilation issue!!! */
    public static boolean d(String str) {
        FileInputStream fileInputStream;
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && BaseImageUtil.isJPEGImage(str)) {
            bm.a();
            FileChannel fileChannel = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileChannel = fileInputStream.getChannel();
                        MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size());
                        int size = (int) fileChannel.size();
                        int i3 = 0;
                        while (i3 < size) {
                            int i16 = i3 + 1;
                            if (map.get(i3) == -1 && i16 < size) {
                                i3 = i16 + 1;
                                byte b16 = map.get(i16);
                                if (b16 == -62 || b16 == -58 || b16 == -54 || b16 == -50) {
                                    z16 = true;
                                    break;
                                }
                            } else {
                                i3 = i16;
                            }
                        }
                        try {
                            fileChannel.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        fileInputStream.close();
                    } catch (FileNotFoundException unused) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        bm.b("peak_pgjpeg", "isProgressiveJpeg");
                        return z16;
                    } catch (IOException unused2) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        bm.b("peak_pgjpeg", "isProgressiveJpeg");
                        return z16;
                    } catch (IndexOutOfBoundsException unused3) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        bm.b("peak_pgjpeg", "isProgressiveJpeg");
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                throw th;
                            } catch (IOException e27) {
                                e27.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused4) {
                    fileInputStream = null;
                } catch (IOException unused5) {
                    fileInputStream = null;
                } catch (IndexOutOfBoundsException unused6) {
                    fileInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                }
            } catch (IOException e28) {
                e28.printStackTrace();
            }
            bm.b("peak_pgjpeg", "isProgressiveJpeg");
        }
        return z16;
    }
}

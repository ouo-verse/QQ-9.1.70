package com.tencent.mobileqq.zplan.avatar.encoder;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {
    public static boolean a(Context context, String str, String str2, int i3, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean f16 = f(context, str2, g(str, str2, i3, z16));
        QLog.i("[zplan]ApolloVideoUtils", 1, "compressVideo " + str + " timecost=" + (System.currentTimeMillis() - currentTimeMillis));
        return f16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v31, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v33, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v36, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Collection, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v25, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [int] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(Context context, String str, List<String> list) {
        if (ShortVideoTrimmer.initVideoTrim(context) && context != null && !TextUtils.isEmpty(str) && list != 0) {
            ?? shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(context);
            String shortVideoSoLibName = VideoEnvironment.getShortVideoSoLibName();
            QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd: soFullDir=" + shortVideoSoPath + " soName=" + shortVideoSoLibName);
            ?? r65 = 0;
            r6 = null;
            r6 = null;
            r6 = null;
            r6 = null;
            r6 = null;
            r6 = null;
            r65 = 0;
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2 = null;
            BufferedReader bufferedReader3 = null;
            r65 = 0;
            try {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
                    processBuilder.redirectErrorStream(true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(FFmpegFileUtils.getFFmpeg(context));
                    arrayList.addAll(list);
                    arrayList.add(shortVideoSoPath + shortVideoSoLibName);
                    processBuilder.command(arrayList);
                    QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd: cmdParam[last]=" + arrayList.get(arrayList.size() - 1));
                    Process start = processBuilder.start();
                    list = start.getInputStream();
                    try {
                        shortVideoSoPath = new InputStreamReader(list);
                        try {
                            BufferedReader bufferedReader4 = new BufferedReader(shortVideoSoPath);
                            try {
                                start.waitFor();
                                int exitValue = start.exitValue();
                                QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd: ret=" + exitValue);
                                while (true) {
                                    String readLine = bufferedReader4.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd log:" + readLine);
                                }
                                start.destroy();
                                QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd destroy OK.");
                                try {
                                    bufferedReader4.close();
                                    shortVideoSoPath.close();
                                    shortVideoSoPath = shortVideoSoPath;
                                    r65 = exitValue;
                                    list = list;
                                    if (list != 0) {
                                        list.close();
                                        shortVideoSoPath = shortVideoSoPath;
                                        r65 = exitValue;
                                        list = list;
                                    }
                                } catch (IOException e16) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("execCmd finally [Exception] exp=");
                                    sb5.append(e16.toString());
                                    QLog.e("[zplan]ApolloVideoUtils", 1, sb5.toString());
                                    shortVideoSoPath = shortVideoSoPath;
                                    r65 = exitValue;
                                    list = sb5;
                                }
                            } catch (IOException e17) {
                                e = e17;
                                bufferedReader = bufferedReader4;
                                e.printStackTrace();
                                QLog.e("[zplan]ApolloVideoUtils", 1, "execCmd [IOException] exp=" + e.toString());
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e18) {
                                        list = new StringBuilder<>();
                                        list.append("execCmd finally [Exception] exp=");
                                        list.append(e18.toString());
                                        QLog.e("[zplan]ApolloVideoUtils", 1, list.toString());
                                        r65 = -1001;
                                        shortVideoSoPath = shortVideoSoPath;
                                        list = list;
                                        if (r65 != 0) {
                                        }
                                        QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd ret=" + r65);
                                        if (r65 == 0) {
                                        }
                                    }
                                }
                                if (shortVideoSoPath != 0) {
                                    shortVideoSoPath.close();
                                }
                                if (list != 0) {
                                    list.close();
                                }
                                r65 = -1001;
                                shortVideoSoPath = shortVideoSoPath;
                                list = list;
                                if (r65 != 0) {
                                }
                                QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd ret=" + r65);
                                if (r65 == 0) {
                                }
                            } catch (InterruptedException e19) {
                                e = e19;
                                bufferedReader2 = bufferedReader4;
                                e.printStackTrace();
                                QLog.e("[zplan]ApolloVideoUtils", 1, "execCmd [InterruptedException] exp=" + e.toString());
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e26) {
                                        list = new StringBuilder<>();
                                        list.append("execCmd finally [Exception] exp=");
                                        list.append(e26.toString());
                                        QLog.e("[zplan]ApolloVideoUtils", 1, list.toString());
                                        r65 = -1002;
                                        shortVideoSoPath = shortVideoSoPath;
                                        list = list;
                                        if (r65 != 0) {
                                        }
                                        QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd ret=" + r65);
                                        if (r65 == 0) {
                                        }
                                    }
                                }
                                if (shortVideoSoPath != 0) {
                                    shortVideoSoPath.close();
                                }
                                if (list != 0) {
                                    list.close();
                                }
                                r65 = -1002;
                                shortVideoSoPath = shortVideoSoPath;
                                list = list;
                                if (r65 != 0) {
                                }
                                QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd ret=" + r65);
                                if (r65 == 0) {
                                }
                            } catch (Exception e27) {
                                e = e27;
                                bufferedReader3 = bufferedReader4;
                                e.printStackTrace();
                                QLog.e("[zplan]ApolloVideoUtils", 1, "execCmd [Exception] exp=" + e.toString());
                                if (bufferedReader3 != null) {
                                    try {
                                        bufferedReader3.close();
                                    } catch (IOException e28) {
                                        list = new StringBuilder<>();
                                        list.append("execCmd finally [Exception] exp=");
                                        list.append(e28.toString());
                                        QLog.e("[zplan]ApolloVideoUtils", 1, list.toString());
                                        r65 = -1003;
                                        shortVideoSoPath = shortVideoSoPath;
                                        list = list;
                                        if (r65 != 0) {
                                        }
                                        QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd ret=" + r65);
                                        if (r65 == 0) {
                                        }
                                    }
                                }
                                if (shortVideoSoPath != 0) {
                                    shortVideoSoPath.close();
                                }
                                if (list != 0) {
                                    list.close();
                                }
                                r65 = -1003;
                                shortVideoSoPath = shortVideoSoPath;
                                list = list;
                                if (r65 != 0) {
                                }
                                QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd ret=" + r65);
                                if (r65 == 0) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                r65 = bufferedReader4;
                                if (r65 != 0) {
                                    try {
                                        r65.close();
                                    } catch (IOException e29) {
                                        QLog.e("[zplan]ApolloVideoUtils", 1, "execCmd finally [Exception] exp=" + e29.toString());
                                        throw th;
                                    }
                                }
                                if (shortVideoSoPath != 0) {
                                    shortVideoSoPath.close();
                                }
                                if (list != 0) {
                                    list.close();
                                }
                                throw th;
                            }
                        } catch (IOException e36) {
                            e = e36;
                        } catch (InterruptedException e37) {
                            e = e37;
                        } catch (Exception e38) {
                            e = e38;
                        }
                    } catch (IOException e39) {
                        e = e39;
                        shortVideoSoPath = 0;
                    } catch (InterruptedException e46) {
                        e = e46;
                        shortVideoSoPath = 0;
                    } catch (Exception e47) {
                        e = e47;
                        shortVideoSoPath = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        shortVideoSoPath = 0;
                    }
                } catch (IOException e48) {
                    e = e48;
                    list = 0;
                    shortVideoSoPath = 0;
                } catch (InterruptedException e49) {
                    e = e49;
                    list = 0;
                    shortVideoSoPath = 0;
                } catch (Exception e56) {
                    e = e56;
                    list = 0;
                    shortVideoSoPath = 0;
                } catch (Throwable th7) {
                    th = th7;
                    list = 0;
                    shortVideoSoPath = 0;
                }
                if (r65 != 0) {
                    try {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                            QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd [delete video] ret=" + r65);
                        }
                    } catch (Exception e57) {
                        QLog.e("[zplan]ApolloVideoUtils", 1, "execCmd file delete [Exception] exp=" + e57.toString());
                    }
                }
                QLog.i("[zplan]ApolloVideoUtils", 1, "execCmd ret=" + r65);
                return r65 == 0;
            } catch (Throwable th8) {
                th = th8;
            }
        } else {
            QLog.e("[zplan]ApolloVideoUtils", 1, "execCmd exit: " + context + ", " + str);
            return false;
        }
    }

    private static List<String> g(String str, String str2, int i3, boolean z16) {
        String str3 = i3 + HippyTKDListViewAdapter.X + i3;
        String str4 = "title=\"" + System.currentTimeMillis() + "\"";
        ArrayList arrayList = new ArrayList();
        arrayList.add(LogCmdOptions.DUMP);
        arrayList.add("-y");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add("-s");
        arrayList.add(str3);
        if (z16) {
            arrayList.add("-metadata");
            arrayList.add(str4);
        }
        arrayList.add(str2);
        return arrayList;
    }

    public static void h(AppInterface appInterface, String str, int i3, int i16, int i17) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = i3;
        pu.a aVar = new pu.a();
        aVar.b(i16);
        aVar.b(i17);
        transferRequest.mExtentionInfo = aVar.a();
        ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "all")).transferAsync(transferRequest);
    }

    public static void i(AppInterface appInterface, String str) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = 48;
        ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "all")).transferAsync(transferRequest);
    }

    public static void c(byte[] bArr, int[] iArr, int i3, int i16) {
        int length = bArr.length / 2;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            for (int i26 = 0; i26 < i3; i26++) {
                int i27 = iArr[i18];
                int i28 = (16711680 & i27) >> 16;
                int i29 = (65280 & i27) >> 8;
                int i36 = (i27 & 255) >> 0;
                int i37 = (((((i28 * 66) + (i29 * 129)) + (i36 * 25)) + 128) >> 8) + 16;
                int i38 = (((((i28 * (-38)) - (i29 * 74)) + (i36 * 112)) + 128) >> 8) + 128;
                int i39 = (((((i28 * 112) - (i29 * 94)) - (i36 * 18)) + 128) >> 8) + 128;
                int i46 = i19 % 2;
                if (i46 == 0 && i18 % 2 == 0) {
                    int i47 = i17 + 1;
                    bArr[i17] = (byte) (i37 < 0 ? 0 : Math.min(i37, 255));
                    int i48 = i47 + 1;
                    bArr[i48] = (byte) (i38 < 0 ? 0 : Math.min(i38, 255));
                    bArr[length + 1] = (byte) (i39 < 0 ? 0 : Math.min(i39, 255));
                    i17 = i48;
                } else if (i46 == 0 && i18 % 2 == 1) {
                    int i49 = i17 + 1;
                    bArr[i17] = (byte) (i37 < 0 ? 0 : Math.min(i37, 255));
                    i17 = i49;
                } else if (i46 == 1 && i18 % 2 == 0) {
                    int i56 = length + 1;
                    bArr[length] = (byte) (i37 < 0 ? 0 : Math.min(i37, 255));
                    length = i56 + 1;
                } else if (i46 == 1 && i18 % 2 == 1) {
                    int i57 = length + 1;
                    bArr[length] = (byte) (i37 < 0 ? 0 : Math.min(i37, 255));
                    length = i57;
                }
                i18++;
            }
        }
    }

    public static void b(byte[] bArr, int[] iArr, int i3, int i16) {
        int i17 = i3 * i16;
        int i18 = (i17 / 4) + i17;
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < i16; i27++) {
            int i28 = 0;
            while (i28 < i3) {
                int i29 = iArr[i26];
                int i36 = (16711680 & i29) >> 16;
                int i37 = (65280 & i29) >> 8;
                int i38 = 255;
                int i39 = (i29 & 255) >> 0;
                int i46 = (((((i36 * 66) + (i37 * 129)) + (i39 * 25)) + 128) >> 8) + 16;
                int i47 = (((((i36 * (-38)) - (i37 * 74)) + (i39 * 112)) + 128) >> 8) + 128;
                int i48 = (((((i36 * 112) - (i37 * 94)) - (i39 * 18)) + 128) >> 8) + 128;
                int i49 = i19 + 1;
                if (i46 < 0) {
                    i46 = 0;
                } else if (i46 > 255) {
                    i46 = 255;
                }
                bArr[i19] = (byte) i46;
                if (i27 % 2 == 0 && i26 % 2 == 0) {
                    int i56 = i18 + 1;
                    if (i48 < 0) {
                        i48 = 0;
                    } else if (i48 > 255) {
                        i48 = 255;
                    }
                    bArr[i18] = (byte) i48;
                    int i57 = i17 + 1;
                    if (i47 < 0) {
                        i38 = 0;
                    } else if (i47 <= 255) {
                        i38 = i47;
                    }
                    bArr[i17] = (byte) i38;
                    i17 = i57;
                    i18 = i56;
                }
                i26++;
                i28++;
                i19 = i49;
            }
        }
    }

    public static void d(byte[] bArr, int[] iArr, int i3, int i16) {
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            for (int i26 = 0; i26 < i3; i26++) {
                int i27 = iArr[i18];
                int i28 = (16711680 & i27) >> 16;
                int i29 = (65280 & i27) >> 8;
                int i36 = 255;
                int i37 = (i27 & 255) >> 0;
                int i38 = (((((i28 * 66) + (i29 * 129)) + (i37 * 25)) + 128) >> 8) + 16;
                int i39 = (((((i28 * (-38)) - (i29 * 74)) + (i37 * 112)) + 128) >> 8) + 128;
                int i46 = (((((i28 * 112) - (i29 * 94)) - (i37 * 18)) + 128) >> 8) + 128;
                int i47 = i17 + 1;
                if (i38 < 0) {
                    i38 = 0;
                } else if (i38 > 255) {
                    i38 = 255;
                }
                bArr[i17] = (byte) i38;
                if (i19 % 2 == 0 && i18 % 2 == 0) {
                    int i48 = i47 + 1;
                    if (i39 < 0) {
                        i39 = 0;
                    } else if (i39 > 255) {
                        i39 = 255;
                    }
                    bArr[i48] = (byte) i39;
                    int i49 = i47 + 3;
                    if (i46 < 0) {
                        i36 = 0;
                    } else if (i46 <= 255) {
                        i36 = i46;
                    }
                    bArr[i49] = (byte) i36;
                }
                if (i18 % 2 == 0) {
                    i47++;
                }
                i17 = i47;
                i18++;
            }
        }
    }

    public static void e(byte[] bArr, int[] iArr, int i3, int i16) {
        int i17 = i3 * i16;
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < i16; i26++) {
            int i27 = 0;
            while (i27 < i3) {
                int i28 = iArr[i19];
                int i29 = (16711680 & i28) >> 16;
                int i36 = (65280 & i28) >> 8;
                int i37 = 255;
                int i38 = (i28 & 255) >> 0;
                int i39 = (((((i29 * 66) + (i36 * 129)) + (i38 * 25)) + 128) >> 8) + 16;
                int i46 = (((((i29 * (-38)) - (i36 * 74)) + (i38 * 112)) + 128) >> 8) + 128;
                int i47 = (((((i29 * 112) - (i36 * 94)) - (i38 * 18)) + 128) >> 8) + 128;
                int i48 = i18 + 1;
                if (i39 < 0) {
                    i39 = 0;
                } else if (i39 > 255) {
                    i39 = 255;
                }
                bArr[i18] = (byte) i39;
                if (i26 % 2 == 0 && i19 % 2 == 0) {
                    int i49 = i17 + 1;
                    if (i46 < 0) {
                        i46 = 0;
                    } else if (i46 > 255) {
                        i46 = 255;
                    }
                    bArr[i17] = (byte) i46;
                    i17 = i49 + 1;
                    if (i47 < 0) {
                        i37 = 0;
                    } else if (i47 <= 255) {
                        i37 = i47;
                    }
                    bArr[i49] = (byte) i37;
                }
                i19++;
                i27++;
                i18 = i48;
            }
        }
    }
}

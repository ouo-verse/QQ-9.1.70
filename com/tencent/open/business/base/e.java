package com.tencent.open.business.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.base.f;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    public static String a(int i3) {
        if (i3 != 1) {
            if (i3 != 50) {
                if (i3 != 100) {
                    if (i3 != 52) {
                        if (i3 != 53) {
                            return "";
                        }
                        return "ANDROIDQQ.PK.APPAIO";
                    }
                    return "ANDROIDQQ.BRAG.APPAIO";
                }
                return "ANDROIDQQ.INVITE.APPAIO";
            }
            return "ANDROIDQQ.REQUEST.APPAIO";
        }
        return "ANDROIDQQ.FREEGIFT.APPAIO";
    }

    public static String b(int i3, int i16, int i17) {
        if (i3 == 352) {
            if (i16 != 1 && i16 != 3) {
                if (i16 == 7 || i16 == 8) {
                    if (i17 != 0 && i17 != 2) {
                        if (i17 != 1) {
                            return "";
                        }
                        return "ANDROIDQQ.SENDSTORY.FEED2";
                    }
                    return "ANDROIDQQ.SENDSTORY.FEED1";
                }
            } else {
                return "ANDROIDQQ.INSTALL.FEED";
            }
        }
        return "";
    }

    public static String c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("ANDROIDQQ.YYB") || str.startsWith("ANDROIDQQ.NEWYYB"))) {
            return str;
        }
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int indexOf = str.indexOf("ANDROIDQQ");
                if (indexOf != -1) {
                    int i3 = indexOf + 9;
                    StringBuilder sb5 = new StringBuilder(str);
                    sb5.insert(i3, ".");
                    sb5.insert(i3 + 1, str2);
                    str3 = sb5.toString();
                } else {
                    f.a("VIA", "jointYybVia via dont contain ANDROIDQQ");
                }
            }
        } catch (Exception e16) {
            f.d("VIA", "jointYybVia>>>", e16);
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        return str3;
    }

    public static void d(String str, String str2, String str3) {
        g(str, str2, str3, false);
    }

    public static void e(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && str4 != null) {
            f.e("reportForVia", "reportForVia actionType=" + str + " via=" + str2 + ", appid=" + str4);
            com.tencent.open.business.viareport.c.a().d(str3, str4, str2, str, "", false, false);
        }
    }

    public static void f(String str, String str2, String str3, String str4, Bundle bundle) {
        if (str != null && str2 != null && str3 != null) {
            f.e("reportForVia", "reportForVia actionType=" + str + " via=" + str2 + ", appid=" + str3);
            com.tencent.open.business.viareport.c.a().c(String.valueOf(com.tencent.open.adapter.a.f().l()), str3, str2, str, com.tencent.open.adapter.a.f().i(), bundle, str4, false, false);
        }
    }

    public static void g(String str, String str2, String str3, boolean z16) {
        if (str != null && str2 != null && str3 != null) {
            f.e("reportForVia", "reportForVia actionType=" + str + " via=" + str2 + ", appid=" + str3);
            com.tencent.open.business.viareport.c.a().d(String.valueOf(com.tencent.open.adapter.a.f().l()), str3, str2, str, "", false, z16);
        }
    }

    public static void h(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && str3 != null) {
            f.e("reportForVia", "reportForVia actionType=" + str + " via=" + str2 + ", appid=" + str3);
            com.tencent.open.business.viareport.c.a().d(String.valueOf(com.tencent.open.adapter.a.f().l()), str3, str2, str, str4, false, false);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00c5 -> B:18:0x00c8). Please report as a decompilation issue!!! */
    public static void i(Context context, String str) {
        BufferedReader bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        try {
            try {
                try {
                    String str2 = context.getFilesDir() + File.separator + "yyb_via_info.txt";
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str2));
                    try {
                        String readLine = bufferedReader2.readLine();
                        String readLine2 = bufferedReader2.readLine();
                        String readLine3 = bufferedReader2.readLine();
                        if (!TextUtils.isEmpty(readLine) && !TextUtils.isEmpty(readLine2) && !TextUtils.isEmpty(readLine3)) {
                            f.a("VIA", "reportForYYbInstalledEvent, actionType = " + readLine + ", via = " + readLine2 + ", appid = " + readLine3);
                            e(readLine, readLine2, str, readLine3);
                            if (new File(str2).exists()) {
                                context.deleteFile("yyb_via_info.txt");
                            }
                        } else {
                            f.c("VIA", "reportForYYbInstalledEvent failed , actionType = " + readLine + ", via = " + readLine2 + ", appid = " + readLine3);
                        }
                        bufferedReader2.close();
                        bufferedReader = readLine;
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            bufferedReader = bufferedReader;
                        }
                    } catch (IOException e17) {
                        e = e17;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            bufferedReader = bufferedReader;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                } catch (IOException e26) {
                    e = e26;
                }
            } catch (IOException e27) {
                e27.printStackTrace();
                bufferedReader = bufferedReader;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void j(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    try {
                        String str4 = context.getFilesDir() + File.separator + "yyb_via_info.txt";
                        if (new File(str4).exists()) {
                            context.deleteFile("yyb_via_info.txt");
                        }
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str4));
                        try {
                            bufferedWriter2.write(str);
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(str2);
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(str3);
                            bufferedWriter2.flush();
                            f.a("VIA", "saveYybViaInfo, actionType = " + str + ", via = " + str2 + ", appid = " + str3);
                            bufferedWriter2.close();
                        } catch (FileNotFoundException e16) {
                            bufferedWriter = bufferedWriter2;
                            e = e16;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        } catch (IOException e17) {
                            bufferedWriter = bufferedWriter2;
                            e = e17;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        } catch (Throwable th5) {
                            bufferedWriter = bufferedWriter2;
                            th = th5;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e19) {
                        e = e19;
                    } catch (IOException e26) {
                        e = e26;
                    }
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            f.c("VIA", "saveYybViaInfo failed, actionType = " + str + ", via = " + str2 + ", appid = " + str3);
        }
    }
}

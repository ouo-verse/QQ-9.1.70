package com.tencent.biz.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TraceUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Foundation/QQCommon/src/main/resources/Inject_Util.yml", version = 1)
    public static ArrayList<Class<? extends d>> f78474a;

    static {
        ArrayList<Class<? extends d>> arrayList = new ArrayList<>();
        f78474a = arrayList;
        arrayList.add(TraceUtil.class);
    }

    public static void a(String str) {
        try {
            f78474a.get(0).newInstance().beginTimeTrack(str);
        } catch (IllegalAccessException e16) {
            QLog.e("Util", 1, "beginTimeTrack error:" + e16);
        } catch (InstantiationException e17) {
            QLog.e("Util", 1, "beginTimeTrack error:" + e17);
        }
    }

    public static boolean b(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            File file2 = listFiles[i3];
            if (file2 != null) {
                if (file2.isFile()) {
                    c(listFiles[i3].getAbsolutePath());
                } else {
                    b(listFiles[i3].getAbsolutePath());
                }
            }
        }
        file.delete();
        if (QLog.isColorLevel()) {
            QLog.d("Util", 2, "deleteDirectory dirPath:", str);
        }
        return true;
    }

    public static boolean c(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                file.delete();
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static void d(String str) {
        try {
            f78474a.get(0).newInstance().endTimeTrack(str);
        } catch (IllegalAccessException e16) {
            QLog.e("Util", 1, "endTimeTrack error:" + e16);
        } catch (InstantiationException e17) {
            QLog.e("Util", 1, "endTimeTrack error:" + e17);
        }
    }

    public static String e(String str, String... strArr) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (strArr != null && strArr.length != 0) {
                StringBuilder sb5 = new StringBuilder("");
                for (String str3 : strArr) {
                    if (!TextUtils.isEmpty(str3)) {
                        sb5.append("|");
                        sb5.append(str3);
                    }
                }
                str2 = String.format("(?<=(a1|a2|key|token|uin|uid|sid|sig|stwxweb%s)=\\S)[^; ]+(?=[^;$])", sb5.toString());
            } else {
                str2 = "(?<=(a1|a2|key|token|uin|uid|sid|sig|stwxweb)=\\S)[^; ]+(?=[^;$])";
            }
            return str.toLowerCase().replaceAll(str2, "*");
        }
        return str;
    }

    public static String f(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("((?i)sid|uin|uid|sec_sig|sig|address|ptsigx|MOBINFO)=[^&#]+", "$1=****");
    }

    public static String g(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String replaceAll = str.replaceAll("(?<=\\?|#|&)((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*&", "").replaceAll("[\\?#&]((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*(?=#|$)", "").replaceAll("(?<=\\?|#|&)((?i)from)=androidqq&", "").replaceAll("[\\?#&]((?i)from)=androidqq(?=#|$)", "");
        for (String str2 : strArr) {
            replaceAll = replaceAll.replace(str2, "");
        }
        return replaceAll;
    }

    public static String h(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static final void i(AppRuntime appRuntime, String str, String str2, long j3, long j16, String str3) {
        j(appRuntime, str, "connect_share2qq", str2, j3, j16, str3);
    }

    public static final void j(AppRuntime appRuntime, String str, String str2, String str3, long j3, long j16, String str4) {
        String str5;
        String str6;
        String str7;
        String str8 = "";
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        if (str == null) {
            str6 = "";
        } else {
            str6 = str;
        }
        if (j16 <= 0) {
            str7 = "";
        } else {
            str7 = String.valueOf(j16);
        }
        if (j3 > 0) {
            str8 = String.valueOf(j3);
        }
        ReportController.o(appRuntime, "P_CliOper", "qqconnect", str6, str2, str3, 0, 0, str8, str7, str5, "");
    }

    public static void k(Context context, int i3, String str, String str2) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i3);
        intent.putExtra("key_error_msg", str);
        intent.putExtra("key_error_detail", str2);
        intent.putExtra("key_response", "");
        ((Activity) context).setResult(-1, intent);
    }
}

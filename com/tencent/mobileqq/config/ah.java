package com.tencent.mobileqq.config;

import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    public static final String[][] f202262a = {new String[]{"q_qlogo_cn_2g", "q_qlogo_cn_3g", "q_qlogo_cn_4g", "q_qlogo_cn_wifi"}, new String[]{"p_qlogo_cn_2g", "p_qlogo_cn_3g", "p_plogo_cn_4g", "p_plogo_cn_wifi"}, new String[]{"p_qpic_cn_2g", "p_qpic_cn_3g", "p_qpic_cn_4g", "p_qpic_cn_wifi"}, new String[]{"pgdt_gtimg_cn_2g", "pgdt_gtimg_cn_3g", "pgdt_gtimg_cn_4g", "pgdt_gtimg_cn_wifi"}, new String[]{"sqimg_qq_com_2g", "sqimg_qq_com_3g", "sqimg_qq_com_4g", "sqimg_qq_com_wifi"}, new String[]{"download_wegame_qq_com_2g", "download_wegame_qq_com_3g", "download_wegame_qq_com_4g", "download_wegame_qq_com_wifi"}, new String[]{"wfqqreader_3g_qq_cn_2g", "wfqqreader_3g_qq_cn_3g", "wfqqreader_3g_qq_cn_4g", "wfqqreader_3g_qq_cn_wifi"}, new String[]{"buluo_qq_com_2g", "buluo_qq_com_3g", "buluo_qq_com_4g", "buluo_qq_com_wifi"}};

    /* renamed from: b, reason: collision with root package name */
    private static boolean[] f202263b = new boolean[13];

    /* renamed from: c, reason: collision with root package name */
    private static String[] f202264c = new String[14];

    /* renamed from: d, reason: collision with root package name */
    private static String[] f202265d = new String[14];

    /* renamed from: e, reason: collision with root package name */
    private static Hashtable<String, ArrayList<String>>[] f202266e = new Hashtable[11];

    static {
        for (int i3 = 0; i3 <= 7; i3++) {
            f202266e[i3] = new Hashtable<>(4);
        }
        for (int i16 = 8; i16 < 11; i16++) {
            f202266e[i16] = new Hashtable<>(3);
        }
    }

    public static String a(ArrayList<FileStorageServerListInfo> arrayList) {
        FileStorageServerListInfo fileStorageServerListInfo;
        String valueOf = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
        if (valueOf.equals(f202265d[13]) && !TextUtils.isEmpty(f202264c[13])) {
            return f202264c[13];
        }
        if (arrayList == null || arrayList.isEmpty() || (fileStorageServerListInfo = arrayList.get((int) ((Math.random() * arrayList.size()) + 1.0d))) == null) {
            return null;
        }
        f202265d[13] = valueOf;
        String[] strArr = f202264c;
        String str = fileStorageServerListInfo.sIP;
        strArr[13] = str;
        return str;
    }

    public static String b(int i3) {
        char c16;
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork == 1) {
            c16 = 3;
        } else if (systemNetwork == 2) {
            c16 = 0;
        } else if (systemNetwork == 3) {
            c16 = 1;
        } else if (systemNetwork == 4) {
            c16 = 2;
        } else {
            QLog.i("PicIPManager", 1, "getIpList netType unknown netType=" + systemNetwork);
            return null;
        }
        if (f202262a[i3][c16].equals(f202265d[i3]) && !TextUtils.isEmpty(f202264c[i3])) {
            return f202264c[i3];
        }
        if (!f202263b[i3]) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("QQHeadIPList", 4);
            if (sharedPreferences == null) {
                return null;
            }
            for (int i16 = 0; i16 <= 3; i16++) {
                String string = sharedPreferences.getString(f202262a[i3][i16], null);
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("\\|");
                    if (split != null && split.length > 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (String str : split) {
                            arrayList.add(str);
                        }
                        f202266e[i3].put(f202262a[i3][i16], arrayList);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("PicIPManager", 2, "getIpList array=" + string);
                    }
                }
            }
            f202263b[i3] = true;
        }
        Hashtable<String, ArrayList<String>> hashtable = f202266e[i3];
        String[][] strArr = f202262a;
        ArrayList<String> arrayList2 = hashtable.get(strArr[i3][c16]);
        if (arrayList2 != null && arrayList2.size() > 0) {
            f202264c[i3] = arrayList2.get((int) (Math.random() * arrayList2.size()));
            f202265d[i3] = strArr[i3][c16];
        }
        return f202264c[i3];
    }

    public static String c(ArrayList<FileStorageServerListInfo> arrayList) {
        FileStorageServerListInfo fileStorageServerListInfo;
        String valueOf = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
        if (valueOf.equals(f202265d[12]) && !TextUtils.isEmpty(f202264c[12])) {
            return f202264c[12];
        }
        if (arrayList == null || arrayList.isEmpty() || (fileStorageServerListInfo = arrayList.get((int) ((Math.random() * arrayList.size()) + 1.0d))) == null) {
            return null;
        }
        f202265d[12] = valueOf;
        String[] strArr = f202264c;
        String str = fileStorageServerListInfo.sIP;
        strArr[12] = str;
        return str;
    }

    public static String d(int i3, String str) {
        String str2;
        String valueOf = String.valueOf(com.tencent.mobileqq.utils.ah.k(BaseApplication.getContext()));
        if (valueOf.equals(f202265d[i3]) && !TextUtils.isEmpty(f202264c[i3])) {
            return f202264c[i3];
        }
        if (!f202263b[i3]) {
            if (QLog.isColorLevel()) {
                QLog.i("PicIPManager", 2, "getQzoneIp " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i3 == 10) {
                str2 = ".*qzonestyle.gtimg.cn";
            } else if (i3 == 8) {
                str2 = "ugc.qpic.cn";
            } else if (i3 == 9) {
                str2 = "a[0-9].qpic.cn";
            } else if (i3 == 11) {
                str2 = ".*qzs.qq.com";
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray(str2);
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i16);
                    String string = jSONObject.getString("apn");
                    String string2 = jSONObject.getString("ip");
                    ArrayList<String> arrayList = f202266e[i3].get(string);
                    if (arrayList == null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        arrayList2.add(string2);
                        f202266e[i3].put(string, arrayList2);
                    } else {
                        arrayList.add(string2);
                    }
                }
                f202263b[i3] = true;
            } catch (JSONException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        ArrayList<String> arrayList3 = f202266e[i3].get(valueOf);
        if (arrayList3 == null || arrayList3.isEmpty()) {
            return null;
        }
        f202264c[i3] = arrayList3.get((int) (Math.random() * arrayList3.size()));
        f202265d[i3] = valueOf;
        return f202264c[i3];
    }

    public static void e() {
        if (QLog.isColorLevel()) {
            QLog.i("PicIPManager", 2, "resetInitedFlag.");
        }
        for (int i3 = 0; i3 <= 7; i3++) {
            f202263b[i3] = false;
        }
    }

    public static boolean f(FileStoragePushFSSvcList fileStoragePushFSSvcList) {
        int i3;
        SharedPreferences.Editor editor;
        DomainIpChannel domainIpChannel;
        ArrayList<DomainIpList> arrayList;
        char c16;
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        char c17 = 4;
        if (systemNetwork == 1) {
            i3 = 3;
        } else if (systemNetwork == 2) {
            i3 = 0;
        } else if (systemNetwork == 3) {
            i3 = 1;
        } else if (systemNetwork == 4) {
            i3 = 2;
        } else {
            QLog.i("PicIPManager", 1, "saveQQHeadIpList netType unknown netType=" + systemNetwork);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PicIPManager", 2, "saveQQHeadIpList netType=" + systemNetwork);
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("QQHeadIPList", 4);
        if (sharedPreferences != null) {
            editor = sharedPreferences.edit();
        } else {
            editor = null;
        }
        for (int i16 = 0; i16 <= 7; i16++) {
            ArrayList<String> arrayList2 = f202266e[i16].get(Integer.valueOf(i3));
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                arrayList2.clear();
            }
            if (editor != null) {
                editor.putString(f202262a[i16][i3], "");
            }
            f202264c[i16] = null;
            f202265d[i16] = null;
        }
        if (editor != null) {
            editor.commit();
        }
        if (fileStoragePushFSSvcList != null && (domainIpChannel = fileStoragePushFSSvcList.domainIpChannel) != null && (arrayList = domainIpChannel.vDomain_iplists) != null) {
            Iterator<DomainIpList> it = arrayList.iterator();
            while (it.hasNext()) {
                DomainIpList next = it.next();
                ArrayList<DomainIpInfo> arrayList3 = next.vIplist;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    for (int i17 = 0; i17 < next.vIplist.size(); i17++) {
                        sb5.append(NetworkUtil.intAddr2Ip(next.vIplist.get(i17).uIp));
                        if (i17 < next.vIplist.size() - 1) {
                            sb5.append("|");
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("PicIPManager", 2, "saveQQHeadIpList.uDomain_type=" + next.uDomain_type + ".strBuilder=" + sb5.toString());
                    }
                    int i18 = next.uDomain_type;
                    if (i18 == 8) {
                        c16 = 0;
                    } else if (i18 == 9) {
                        c16 = 1;
                    } else if (i18 == 10) {
                        c16 = 2;
                    } else if (i18 == 11) {
                        c16 = 3;
                    } else if (i18 == 12) {
                        c16 = c17;
                    } else if (i18 == 13) {
                        c16 = 5;
                    } else if (i18 == 14) {
                        c16 = 6;
                    } else if (i18 == 15) {
                        c16 = 7;
                    }
                    ArrayList<DomainIpInfo> arrayList4 = next.vIplist;
                    if (arrayList4 != null && arrayList4.size() != 0) {
                        StringBuilder sb6 = new StringBuilder();
                        ArrayList<String> arrayList5 = new ArrayList<>();
                        for (int i19 = 0; i19 < next.vIplist.size(); i19++) {
                            String intAddr2Ip = NetworkUtil.intAddr2Ip(next.vIplist.get(i19).uIp);
                            arrayList5.add(intAddr2Ip);
                            sb6.append(intAddr2Ip);
                            if (i19 < next.vIplist.size() - 1) {
                                sb6.append("|");
                            }
                        }
                        Hashtable<String, ArrayList<String>> hashtable = f202266e[c16];
                        String[][] strArr = f202262a;
                        hashtable.put(strArr[c16][i3], arrayList5);
                        if (QLog.isColorLevel()) {
                            QLog.i("PicIPManager", 2, "saveQQHeadIpList.sIpList=" + arrayList5 + ",sb=" + sb6.toString());
                        }
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putString(strArr[c16][i3], sb6.toString()).commit();
                        }
                        c17 = 4;
                    }
                }
            }
        }
        return true;
    }
}

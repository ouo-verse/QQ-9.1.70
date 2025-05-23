package com.tencent.mobileqq.tianshu.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.redtouch.g;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RedTouchUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String GAME_CENTER_RES_ID = "489";
    private static final String TAG = "RedPointLog.RedTouchUtil";
    private static BusinessInfoCheckUpdate.AppInfo cacheInfo;
    private static Object lock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            lock = new Object();
            cacheInfo = null;
        }
    }

    public RedTouchUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static JSONObject buidRedJson(List<BusinessInfoCheckUpdate.RedTypeInfo> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONObject.put("red_type", list.get(i3).red_type.get());
                jSONObject.put("red_content", list.get(i3).red_content.get());
                jSONObject.put("red_desc", list.get(i3).red_desc.get());
            }
        }
        return jSONObject;
    }

    private static List<String> buildPaths(List<String> list, JSONArray jSONArray) {
        if (jSONArray != null) {
            list = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3, "");
                if (!TextUtils.isEmpty(optString)) {
                    list.add(optString);
                }
            }
        }
        return list;
    }

    public static JSONObject buildRedJson(List<BusinessInfoCheckUpdate.RedTypeInfo> list) throws JSONException {
        return buidRedJson(list);
    }

    public static int getAppIdByPath(String str) {
        if (str == null) {
            QLog.d(TAG, 1, "input path is empty");
            return -1;
        }
        if (str.contains(".")) {
            String[] split = str.split("\\.");
            if (split == null || split.length <= 0) {
                return -1;
            }
            try {
                return Integer.parseInt(split[split.length - 1]);
            } catch (NumberFormatException e16) {
                QLog.d(TAG, 1, " parse int error " + e16);
                return -1;
            }
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e17) {
            QLog.d(TAG, 1, " parse int error " + e17);
            return -1;
        }
    }

    private static BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(AppInterface appInterface, String str) {
        byte[] fileToBytes;
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            File file = new File(appInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + appInterface.getCurrentAccountUin());
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "getappinfo create file exception ");
                    }
                    return null;
                }
            }
            synchronized (lock) {
                fileToBytes = FileUtils.fileToBytes(file);
            }
            if (fileToBytes == null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getappinfo body = null");
                }
                return null;
            }
            BusinessInfoCheckUpdate.TimeRspBody timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
            try {
                timeRspBody.mergeFrom(fileToBytes);
                if (!timeRspBody.rptMsgAppInfo.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "getappinfo localTimeRspBody null ");
                    }
                    return null;
                }
                for (BusinessInfoCheckUpdate.AppInfo appInfo : timeRspBody.rptMsgAppInfo.get()) {
                    if (appInfo.path.get().equals(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "getappinfo path= " + appInfo.path.get() + ";inewflag = " + appInfo.iNewFlag.get());
                        }
                        return appInfo;
                    }
                }
                return null;
            } catch (Exception e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getappinfo mergeFrom exception ");
                }
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo path or browserapp = null");
        }
        return null;
    }

    public static List<BusinessInfoCheckUpdate.AppInfo> getAppInfoListByPath(AppInterface appInterface, List<String> list) {
        byte[] fileToBytes;
        if (appInterface != null && list != null && !list.isEmpty()) {
            File file = new File(appInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + appInterface.getCurrentAccountUin());
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "getappinfolist create file exception ");
                    }
                    return null;
                }
            }
            synchronized (lock) {
                fileToBytes = FileUtils.fileToBytes(file);
            }
            if (fileToBytes == null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getappinfolist body = null");
                }
                return null;
            }
            BusinessInfoCheckUpdate.TimeRspBody timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
            try {
                timeRspBody.mergeFrom(fileToBytes);
                if (!timeRspBody.rptMsgAppInfo.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "getappinfolist localTimeRspBody null ");
                    }
                    return null;
                }
                List<BusinessInfoCheckUpdate.AppInfo> list2 = timeRspBody.rptMsgAppInfo.get();
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    Iterator<BusinessInfoCheckUpdate.AppInfo> it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            BusinessInfoCheckUpdate.AppInfo next = it.next();
                            if (next.path.get().equals(str)) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, "getappinfolist path= " + next.path.get() + ";inewflag = " + next.iNewFlag.get());
                                }
                                arrayList.add(next);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (Exception e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getappinfolist mergeFrom exception ");
                }
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfolist paths is empty or browserapp = null");
        }
        return null;
    }

    public static BusinessInfoCheckUpdate.AppInfo getGameCenterAppInfoCache() {
        return cacheInfo;
    }

    public static String getLastClickPath(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.w(TAG, 1, "getLastClickPath appInterface is null");
            return "";
        }
        return QMMKV.from(appInterface.getApp(), "vas_mmkv_configurations").decodeString("redTouchPreflastClickPath", "");
    }

    private static int getReddot(AppInterface appInterface, List<BusinessInfoCheckUpdate.AppInfo> list, int i3) {
        if (appInterface != null && list != null && !list.isEmpty()) {
            String lastClickPath = getLastClickPath(appInterface);
            String str = list.get(0).path.get();
            if (!TextUtils.isEmpty(str) && str.equals(lastClickPath)) {
                return 1;
            }
            return i3;
        }
        return i3;
    }

    public static String getReportBufferString(String str) {
        JSONObject jSONObject;
        int i3;
        String str2;
        if (str == null) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject(str);
            if (jSONObject3.has("msg")) {
                jSONObject = jSONObject3.getJSONObject("msg");
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    JSONObject jSONObject4 = new JSONObject();
                    String str3 = (String) keys.next();
                    JSONObject jSONObject5 = jSONObject.getJSONObject(str3);
                    if (jSONObject5.has("stat")) {
                        i3 = jSONObject5.getInt("stat");
                    } else {
                        i3 = -1;
                    }
                    if (i3 == 1) {
                        if (!jSONObject5.has("content")) {
                            str2 = "";
                        } else {
                            str2 = jSONObject5.getString("content");
                        }
                        jSONObject4.put(str3, str2);
                        jSONArray.mo162put(jSONObject4);
                    }
                }
            }
            jSONObject2.put("msg", jSONArray);
            return jSONObject2.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|2|3|4|(6:5|6|7|8|9|(7:10|11|(2:172|173)(1:13)|14|15|(2:164|165)(1:17)|18))|(2:161|162)(2:21|(1:23)(15:159|160|(4:26|27|28|29)(3:86|87|(38:90|91|92|93|94|95|96|97|99|100|101|(5:105|106|107|102|103)|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|31|32|(7:34|35|36|37|38|39|40)(1:79)|41|42|(1:44)|(2:46|(4:50|(1:52)(1:56)|53|54))|57|(0)(0)|53|54)(1:89))|30|31|32|(0)(0)|41|42|(0)|(0)|57|(0)(0)|53|54))|24|(0)(0)|30|31|32|(0)(0)|41|42|(0)|(0)|57|(0)(0)|53|54|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(3:(3:105|106|107)|102|103) */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01fc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0203, code lost:
    
        r15 = "jsEnd";
        r6 = "jsStart";
        r1 = "buffer";
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0281, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0282, code lost:
    
        r8 = "getAppInfo:";
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x024f A[Catch: Exception -> 0x0281, TRY_LEAVE, TryCatch #20 {Exception -> 0x0281, blocks: (B:32:0x0249, B:34:0x024f), top: B:31:0x0249 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, Object> parseGetAppInfo(AppInterface appInterface, long j3, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        BusinessInfoCheckUpdate.AppInfo appInfo;
        String str9;
        int i3;
        String str10;
        String str11;
        String str12;
        BusinessInfoCheckUpdate.AppInfo appInfo2;
        String str13;
        String str14;
        int i16;
        String str15;
        String string;
        String string2;
        boolean z16;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        BusinessInfoCheckUpdate.AppInfo appInfo3;
        List<BusinessInfoCheckUpdate.RedTypeInfo> list;
        int i17;
        int i18;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        ArrayList<String> arrayList = new ArrayList<>();
        int i19 = -2;
        try {
        } catch (Exception e16) {
            e = e16;
            str2 = "buffer";
            str3 = "callback";
            str4 = "getAppInfo:";
            str5 = "jsEnd";
            str6 = "jsStart";
        }
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            string = jSONObject3.getString("callback");
            try {
                string2 = jSONObject3.getString("path");
                try {
                    if (!jSONObject3.has(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL)) {
                        str7 = "";
                    } else {
                        try {
                            str7 = jSONObject3.getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
                        } catch (Exception e17) {
                            e = e17;
                            str9 = string;
                            str8 = string2;
                            str3 = "callback";
                            str7 = "";
                            str4 = "getAppInfo:";
                            str5 = "jsEnd";
                            str6 = "jsStart";
                            appInfo = null;
                            str2 = "buffer";
                            i3 = 0;
                            str10 = str9;
                            if (!QLog.isColorLevel()) {
                            }
                            try {
                                jSONObject.put("code", -1);
                                jSONObject.put("errorMessage", "jsonexception");
                                jSONObject.put(str6, j3);
                                jSONObject.put(str5, System.currentTimeMillis());
                                i19 = -1;
                                appInfo2 = appInfo;
                                str13 = str7;
                                str14 = str8;
                                str12 = str10;
                            } catch (JSONException e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, "getAppInfo error1:" + e18);
                                }
                                str12 = str10;
                                appInfo2 = appInfo;
                                str13 = str7;
                                str14 = str8;
                            }
                            if (QLog.isColorLevel()) {
                            }
                            if (appInterface != null) {
                            }
                            i16 = i3;
                            if (appInfo2 != null) {
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("ret", String.valueOf(i19));
                            bundle.putString(str2, str15);
                            bundle.putString("red", String.valueOf(i16));
                            bundle.putStringArrayList("missions", arrayList);
                            bundle.putString("path", str14);
                            bundle.putString(str11, str13);
                            bundle.putString(str3, str12);
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("callbackId", str12);
                            hashMap.put("req", bundle);
                            hashMap.put("jsonResult", jSONObject.toString());
                            return hashMap;
                        }
                    }
                    try {
                        if (jSONObject3.has("getFromCacheFirst")) {
                            try {
                                z16 = jSONObject3.getBoolean("getFromCacheFirst");
                            } catch (Exception e19) {
                                e = e19;
                                str9 = string;
                                str8 = string2;
                                str3 = "callback";
                                str4 = "getAppInfo:";
                                str5 = "jsEnd";
                                str6 = "jsStart";
                                appInfo = null;
                                str2 = "buffer";
                                i3 = 0;
                                str10 = str9;
                                if (!QLog.isColorLevel()) {
                                }
                                jSONObject.put("code", -1);
                                jSONObject.put("errorMessage", "jsonexception");
                                jSONObject.put(str6, j3);
                                jSONObject.put(str5, System.currentTimeMillis());
                                i19 = -1;
                                appInfo2 = appInfo;
                                str13 = str7;
                                str14 = str8;
                                str12 = str10;
                                if (QLog.isColorLevel()) {
                                }
                                if (appInterface != null) {
                                }
                                i16 = i3;
                                if (appInfo2 != null) {
                                }
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("ret", String.valueOf(i19));
                                bundle2.putString(str2, str15);
                                bundle2.putString("red", String.valueOf(i16));
                                bundle2.putStringArrayList("missions", arrayList);
                                bundle2.putString("path", str14);
                                bundle2.putString(str11, str13);
                                bundle2.putString(str3, str12);
                                HashMap<String, Object> hashMap2 = new HashMap<>();
                                hashMap2.put("callbackId", str12);
                                hashMap2.put("req", bundle2);
                                hashMap2.put("jsonResult", jSONObject.toString());
                                return hashMap2;
                            }
                        } else {
                            z16 = false;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        str8 = string2;
                        str3 = "callback";
                        str4 = "getAppInfo:";
                        str5 = "jsEnd";
                        str6 = "jsStart";
                        str2 = "buffer";
                        str9 = string;
                        appInfo = null;
                        i3 = 0;
                        str10 = str9;
                        if (!QLog.isColorLevel()) {
                        }
                        jSONObject.put("code", -1);
                        jSONObject.put("errorMessage", "jsonexception");
                        jSONObject.put(str6, j3);
                        jSONObject.put(str5, System.currentTimeMillis());
                        i19 = -1;
                        appInfo2 = appInfo;
                        str13 = str7;
                        str14 = str8;
                        str12 = str10;
                        if (QLog.isColorLevel()) {
                        }
                        if (appInterface != null) {
                        }
                        i16 = i3;
                        if (appInfo2 != null) {
                        }
                        Bundle bundle22 = new Bundle();
                        bundle22.putString("ret", String.valueOf(i19));
                        bundle22.putString(str2, str15);
                        bundle22.putString("red", String.valueOf(i16));
                        bundle22.putStringArrayList("missions", arrayList);
                        bundle22.putString("path", str14);
                        bundle22.putString(str11, str13);
                        bundle22.putString(str3, str12);
                        HashMap<String, Object> hashMap22 = new HashMap<>();
                        hashMap22.put("callbackId", str12);
                        hashMap22.put("req", bundle22);
                        hashMap22.put("jsonResult", jSONObject.toString());
                        return hashMap22;
                    }
                } catch (Exception e27) {
                    e = e27;
                    str8 = string2;
                    str3 = "callback";
                    str4 = "getAppInfo:";
                    str5 = "jsEnd";
                    str6 = "jsStart";
                    str2 = "buffer";
                    str9 = string;
                    str7 = "";
                }
            } catch (Exception e28) {
                e = e28;
                str3 = "callback";
                str4 = "getAppInfo:";
                str5 = "jsEnd";
                str6 = "jsStart";
                str2 = "buffer";
                str9 = string;
                str7 = "";
                str8 = str7;
            }
        } catch (Exception e29) {
            e = e29;
            str3 = "callback";
            str4 = "getAppInfo:";
            str5 = "jsEnd";
            str6 = "jsStart";
            str2 = "buffer";
            str7 = "";
            str8 = str7;
            appInfo = null;
            str9 = str3;
            i3 = 0;
            str10 = str9;
            if (!QLog.isColorLevel()) {
            }
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "jsonexception");
            jSONObject.put(str6, j3);
            jSONObject.put(str5, System.currentTimeMillis());
            i19 = -1;
            appInfo2 = appInfo;
            str13 = str7;
            str14 = str8;
            str12 = str10;
            if (QLog.isColorLevel()) {
            }
            if (appInterface != null) {
            }
            i16 = i3;
            if (appInfo2 != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putString("ret", String.valueOf(i19));
            bundle222.putString(str2, str15);
            bundle222.putString("red", String.valueOf(i16));
            bundle222.putStringArrayList("missions", arrayList);
            bundle222.putString("path", str14);
            bundle222.putString(str11, str13);
            bundle222.putString(str3, str12);
            HashMap<String, Object> hashMap222 = new HashMap<>();
            hashMap222.put("callbackId", str12);
            hashMap222.put("req", bundle222);
            hashMap222.put("jsonResult", jSONObject.toString());
            return hashMap222;
        }
        if ("489".equals(string2) && z16) {
            BusinessInfoCheckUpdate.AppInfo gameCenterAppInfoCache = getGameCenterAppInfoCache();
            if (gameCenterAppInfoCache == null) {
                appInfoByPath = getAppInfoByPath(appInterface, string2);
            } else {
                QLog.i(TAG, 2, "[parseGetAppInfo] get gamecenter appInfo from cache.");
                jSONObject.put("isFromCache", true);
                appInfo3 = gameCenterAppInfoCache;
                if (appInfo3 != null) {
                    try {
                        jSONObject.put("code", -3);
                        jSONObject.put("errorMessage", "not red info");
                        jSONObject.put("jsStartTime", j3);
                        jSONObject.put("jsEndTime", System.currentTimeMillis());
                        str8 = string2;
                        str3 = "callback";
                        str5 = "jsEnd";
                        str6 = "jsStart";
                        str2 = "buffer";
                        i19 = -3;
                    } catch (Exception e36) {
                        e = e36;
                        str8 = string2;
                        str3 = "callback";
                        str4 = "getAppInfo:";
                        str5 = "jsEnd";
                        str6 = "jsStart";
                        str2 = "buffer";
                        i3 = 0;
                        appInfo = appInfo3;
                        str9 = string;
                        str10 = str9;
                        if (!QLog.isColorLevel()) {
                        }
                        jSONObject.put("code", -1);
                        jSONObject.put("errorMessage", "jsonexception");
                        jSONObject.put(str6, j3);
                        jSONObject.put(str5, System.currentTimeMillis());
                        i19 = -1;
                        appInfo2 = appInfo;
                        str13 = str7;
                        str14 = str8;
                        str12 = str10;
                        if (QLog.isColorLevel()) {
                        }
                        if (appInterface != null) {
                        }
                        i16 = i3;
                        if (appInfo2 != null) {
                        }
                        Bundle bundle2222 = new Bundle();
                        bundle2222.putString("ret", String.valueOf(i19));
                        bundle2222.putString(str2, str15);
                        bundle2222.putString("red", String.valueOf(i16));
                        bundle2222.putStringArrayList("missions", arrayList);
                        bundle2222.putString("path", str14);
                        bundle2222.putString(str11, str13);
                        bundle2222.putString(str3, str12);
                        HashMap<String, Object> hashMap2222 = new HashMap<>();
                        hashMap2222.put("callbackId", str12);
                        hashMap2222.put("req", bundle2222);
                        hashMap2222.put("jsonResult", jSONObject.toString());
                        return hashMap2222;
                    }
                } else {
                    try {
                    } catch (Exception e37) {
                        e = e37;
                        str8 = string2;
                        str3 = "callback";
                        str4 = "getAppInfo:";
                        str5 = "jsEnd";
                        str6 = "jsStart";
                        str2 = "buffer";
                        appInfo = appInfo3;
                        str9 = string;
                    }
                    if (appInfo3.red_display_info.get() != null) {
                        try {
                            list = appInfo3.red_display_info.red_type_info.get();
                            try {
                                jSONObject.put("code", 0);
                                str8 = string2;
                            } catch (Exception e38) {
                                e = e38;
                                str8 = string2;
                            }
                        } catch (Exception e39) {
                            e = e39;
                            str8 = string2;
                            str3 = "callback";
                            str5 = "jsEnd";
                            str6 = "jsStart";
                            str2 = "buffer";
                            appInfo = appInfo3;
                            str9 = string;
                            str4 = "getAppInfo:";
                            i3 = 0;
                            str10 = str9;
                            if (!QLog.isColorLevel()) {
                            }
                            jSONObject.put("code", -1);
                            jSONObject.put("errorMessage", "jsonexception");
                            jSONObject.put(str6, j3);
                            jSONObject.put(str5, System.currentTimeMillis());
                            i19 = -1;
                            appInfo2 = appInfo;
                            str13 = str7;
                            str14 = str8;
                            str12 = str10;
                            if (QLog.isColorLevel()) {
                            }
                            if (appInterface != null) {
                            }
                            i16 = i3;
                            if (appInfo2 != null) {
                            }
                            Bundle bundle22222 = new Bundle();
                            bundle22222.putString("ret", String.valueOf(i19));
                            bundle22222.putString(str2, str15);
                            bundle22222.putString("red", String.valueOf(i16));
                            bundle22222.putStringArrayList("missions", arrayList);
                            bundle22222.putString("path", str14);
                            bundle22222.putString(str11, str13);
                            bundle22222.putString(str3, str12);
                            HashMap<String, Object> hashMap22222 = new HashMap<>();
                            hashMap22222.put("callbackId", str12);
                            hashMap22222.put("req", bundle22222);
                            hashMap22222.put("jsonResult", jSONObject.toString());
                            return hashMap22222;
                        }
                        try {
                            jSONObject2.put("appID", appInfo3.uiAppId.get());
                            jSONObject2.put("iNewFlag", appInfo3.iNewFlag.get());
                            int i26 = appInfo3.iNewFlag.get();
                            try {
                                JSONArray jSONArray = new JSONArray();
                                i3 = i26;
                                str3 = "callback";
                                for (int i27 = 0; i27 < appInfo3.missions.size(); i27++) {
                                    try {
                                        jSONArray.mo162put(appInfo3.missions.get(i27));
                                        arrayList.add(appInfo3.missions.get(i27));
                                    } catch (Exception e46) {
                                        e = e46;
                                        str4 = "getAppInfo:";
                                        str5 = "jsEnd";
                                        str6 = "jsStart";
                                        str2 = "buffer";
                                        i19 = 0;
                                        appInfo = appInfo3;
                                        str9 = string;
                                        str10 = str9;
                                        if (!QLog.isColorLevel()) {
                                        }
                                        jSONObject.put("code", -1);
                                        jSONObject.put("errorMessage", "jsonexception");
                                        jSONObject.put(str6, j3);
                                        jSONObject.put(str5, System.currentTimeMillis());
                                        i19 = -1;
                                        appInfo2 = appInfo;
                                        str13 = str7;
                                        str14 = str8;
                                        str12 = str10;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (appInterface != null) {
                                        }
                                        i16 = i3;
                                        if (appInfo2 != null) {
                                        }
                                        Bundle bundle222222 = new Bundle();
                                        bundle222222.putString("ret", String.valueOf(i19));
                                        bundle222222.putString(str2, str15);
                                        bundle222222.putString("red", String.valueOf(i16));
                                        bundle222222.putStringArrayList("missions", arrayList);
                                        bundle222222.putString("path", str14);
                                        bundle222222.putString(str11, str13);
                                        bundle222222.putString(str3, str12);
                                        HashMap<String, Object> hashMap222222 = new HashMap<>();
                                        hashMap222222.put("callbackId", str12);
                                        hashMap222222.put("req", bundle222222);
                                        hashMap222222.put("jsonResult", jSONObject.toString());
                                        return hashMap222222;
                                    }
                                }
                                jSONObject2.put("redInfo", buidRedJson(list));
                                jSONObject2.put("missions", jSONArray);
                                jSONObject2.put("type", appInfo3.type.get());
                                jSONObject2.put(QFSEdgeItem.KEY_EXTEND, appInfo3.extend.get());
                                str2 = "buffer";
                            } catch (Exception e47) {
                                e = e47;
                                i3 = i26;
                                str3 = "callback";
                            }
                            try {
                                jSONObject2.put(str2, appInfo3.buffer.get());
                                jSONObject2.put("path", appInfo3.path.get());
                                jSONObject2.put("appset", appInfo3.appset.get());
                                jSONObject2.put("modify_ts", appInfo3.modify_ts.get());
                                jSONObject2.put(WidgetCacheConstellationData.NUM, appInfo3.num.get());
                                jSONObject2.put("push_red_ts", appInfo3.push_red_ts.get());
                                jSONObject.put("data", jSONObject2);
                                str6 = "jsStart";
                                try {
                                    jSONObject.put(str6, j3);
                                    BusinessInfoCheckUpdate.AppInfo appInfo4 = appInfo3;
                                    try {
                                        appInfo = appInfo4;
                                        str5 = "jsEnd";
                                        try {
                                            jSONObject.put(str5, System.currentTimeMillis());
                                            i17 = i3;
                                            i19 = 0;
                                            if (!QLog.isColorLevel()) {
                                                str4 = "getAppInfo:";
                                                i18 = i17;
                                            } else {
                                                StringBuilder sb5 = new StringBuilder();
                                                str4 = "getAppInfo:";
                                                try {
                                                    sb5.append(str4);
                                                    i18 = i17;
                                                    try {
                                                        sb5.append(jSONObject.toString());
                                                        QLog.i(TAG, 2, sb5.toString());
                                                    } catch (Exception e48) {
                                                        e = e48;
                                                        str9 = string;
                                                        i3 = i18;
                                                        str10 = str9;
                                                        if (!QLog.isColorLevel()) {
                                                        }
                                                        jSONObject.put("code", -1);
                                                        jSONObject.put("errorMessage", "jsonexception");
                                                        jSONObject.put(str6, j3);
                                                        jSONObject.put(str5, System.currentTimeMillis());
                                                        i19 = -1;
                                                        appInfo2 = appInfo;
                                                        str13 = str7;
                                                        str14 = str8;
                                                        str12 = str10;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (appInterface != null) {
                                                        }
                                                        i16 = i3;
                                                        if (appInfo2 != null) {
                                                        }
                                                        Bundle bundle2222222 = new Bundle();
                                                        bundle2222222.putString("ret", String.valueOf(i19));
                                                        bundle2222222.putString(str2, str15);
                                                        bundle2222222.putString("red", String.valueOf(i16));
                                                        bundle2222222.putStringArrayList("missions", arrayList);
                                                        bundle2222222.putString("path", str14);
                                                        bundle2222222.putString(str11, str13);
                                                        bundle2222222.putString(str3, str12);
                                                        HashMap<String, Object> hashMap2222222 = new HashMap<>();
                                                        hashMap2222222.put("callbackId", str12);
                                                        hashMap2222222.put("req", bundle2222222);
                                                        hashMap2222222.put("jsonResult", jSONObject.toString());
                                                        return hashMap2222222;
                                                    }
                                                } catch (Exception e49) {
                                                    e = e49;
                                                    i18 = i17;
                                                    str9 = string;
                                                    i3 = i18;
                                                    str10 = str9;
                                                    if (!QLog.isColorLevel()) {
                                                    }
                                                    jSONObject.put("code", -1);
                                                    jSONObject.put("errorMessage", "jsonexception");
                                                    jSONObject.put(str6, j3);
                                                    jSONObject.put(str5, System.currentTimeMillis());
                                                    i19 = -1;
                                                    appInfo2 = appInfo;
                                                    str13 = str7;
                                                    str14 = str8;
                                                    str12 = str10;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (appInterface != null) {
                                                    }
                                                    i16 = i3;
                                                    if (appInfo2 != null) {
                                                    }
                                                    Bundle bundle22222222 = new Bundle();
                                                    bundle22222222.putString("ret", String.valueOf(i19));
                                                    bundle22222222.putString(str2, str15);
                                                    bundle22222222.putString("red", String.valueOf(i16));
                                                    bundle22222222.putStringArrayList("missions", arrayList);
                                                    bundle22222222.putString("path", str14);
                                                    bundle22222222.putString(str11, str13);
                                                    bundle22222222.putString(str3, str12);
                                                    HashMap<String, Object> hashMap22222222 = new HashMap<>();
                                                    hashMap22222222.put("callbackId", str12);
                                                    hashMap22222222.put("req", bundle22222222);
                                                    hashMap22222222.put("jsonResult", jSONObject.toString());
                                                    return hashMap22222222;
                                                }
                                            }
                                            str12 = string;
                                            i3 = i18;
                                            appInfo2 = appInfo;
                                            str13 = str7;
                                            str14 = str8;
                                            str11 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
                                        } catch (Exception e56) {
                                            e = e56;
                                            str9 = string;
                                            str4 = "getAppInfo:";
                                            i19 = 0;
                                            str10 = str9;
                                            if (!QLog.isColorLevel()) {
                                            }
                                            jSONObject.put("code", -1);
                                            jSONObject.put("errorMessage", "jsonexception");
                                            jSONObject.put(str6, j3);
                                            jSONObject.put(str5, System.currentTimeMillis());
                                            i19 = -1;
                                            appInfo2 = appInfo;
                                            str13 = str7;
                                            str14 = str8;
                                            str12 = str10;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (appInterface != null) {
                                            }
                                            i16 = i3;
                                            if (appInfo2 != null) {
                                            }
                                            Bundle bundle222222222 = new Bundle();
                                            bundle222222222.putString("ret", String.valueOf(i19));
                                            bundle222222222.putString(str2, str15);
                                            bundle222222222.putString("red", String.valueOf(i16));
                                            bundle222222222.putStringArrayList("missions", arrayList);
                                            bundle222222222.putString("path", str14);
                                            bundle222222222.putString(str11, str13);
                                            bundle222222222.putString(str3, str12);
                                            HashMap<String, Object> hashMap222222222 = new HashMap<>();
                                            hashMap222222222.put("callbackId", str12);
                                            hashMap222222222.put("req", bundle222222222);
                                            hashMap222222222.put("jsonResult", jSONObject.toString());
                                            return hashMap222222222;
                                        }
                                    } catch (Exception e57) {
                                        e = e57;
                                        appInfo = appInfo4;
                                        str5 = "jsEnd";
                                        str9 = string;
                                        str4 = "getAppInfo:";
                                        i19 = 0;
                                        str10 = str9;
                                        if (!QLog.isColorLevel()) {
                                        }
                                        jSONObject.put("code", -1);
                                        jSONObject.put("errorMessage", "jsonexception");
                                        jSONObject.put(str6, j3);
                                        jSONObject.put(str5, System.currentTimeMillis());
                                        i19 = -1;
                                        appInfo2 = appInfo;
                                        str13 = str7;
                                        str14 = str8;
                                        str12 = str10;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (appInterface != null) {
                                        }
                                        i16 = i3;
                                        if (appInfo2 != null) {
                                        }
                                        Bundle bundle2222222222 = new Bundle();
                                        bundle2222222222.putString("ret", String.valueOf(i19));
                                        bundle2222222222.putString(str2, str15);
                                        bundle2222222222.putString("red", String.valueOf(i16));
                                        bundle2222222222.putStringArrayList("missions", arrayList);
                                        bundle2222222222.putString("path", str14);
                                        bundle2222222222.putString(str11, str13);
                                        bundle2222222222.putString(str3, str12);
                                        HashMap<String, Object> hashMap2222222222 = new HashMap<>();
                                        hashMap2222222222.put("callbackId", str12);
                                        hashMap2222222222.put("req", bundle2222222222);
                                        hashMap2222222222.put("jsonResult", jSONObject.toString());
                                        return hashMap2222222222;
                                    }
                                } catch (Exception e58) {
                                    e = e58;
                                    appInfo = appInfo3;
                                }
                            } catch (Exception e59) {
                                e = e59;
                                str5 = "jsEnd";
                                str6 = "jsStart";
                                appInfo = appInfo3;
                                str9 = string;
                                str4 = "getAppInfo:";
                                i19 = 0;
                                str10 = str9;
                                if (!QLog.isColorLevel()) {
                                }
                                jSONObject.put("code", -1);
                                jSONObject.put("errorMessage", "jsonexception");
                                jSONObject.put(str6, j3);
                                jSONObject.put(str5, System.currentTimeMillis());
                                i19 = -1;
                                appInfo2 = appInfo;
                                str13 = str7;
                                str14 = str8;
                                str12 = str10;
                                if (QLog.isColorLevel()) {
                                }
                                if (appInterface != null) {
                                }
                                i16 = i3;
                                if (appInfo2 != null) {
                                }
                                Bundle bundle22222222222 = new Bundle();
                                bundle22222222222.putString("ret", String.valueOf(i19));
                                bundle22222222222.putString(str2, str15);
                                bundle22222222222.putString("red", String.valueOf(i16));
                                bundle22222222222.putStringArrayList("missions", arrayList);
                                bundle22222222222.putString("path", str14);
                                bundle22222222222.putString(str11, str13);
                                bundle22222222222.putString(str3, str12);
                                HashMap<String, Object> hashMap22222222222 = new HashMap<>();
                                hashMap22222222222.put("callbackId", str12);
                                hashMap22222222222.put("req", bundle22222222222);
                                hashMap22222222222.put("jsonResult", jSONObject.toString());
                                return hashMap22222222222;
                            }
                        } catch (Exception e65) {
                            e = e65;
                            str3 = "callback";
                            str5 = "jsEnd";
                            str6 = "jsStart";
                            str2 = "buffer";
                            appInfo = appInfo3;
                            str9 = string;
                            str4 = "getAppInfo:";
                            i3 = 0;
                            i19 = 0;
                            str10 = str9;
                            if (!QLog.isColorLevel()) {
                                StringBuilder sb6 = new StringBuilder();
                                str11 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
                                sb6.append("getAppInfo error:");
                                sb6.append(e);
                                QLog.i(TAG, 2, sb6.toString());
                            } else {
                                str11 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
                            }
                            jSONObject.put("code", -1);
                            jSONObject.put("errorMessage", "jsonexception");
                            jSONObject.put(str6, j3);
                            jSONObject.put(str5, System.currentTimeMillis());
                            i19 = -1;
                            appInfo2 = appInfo;
                            str13 = str7;
                            str14 = str8;
                            str12 = str10;
                            if (QLog.isColorLevel()) {
                            }
                            if (appInterface != null) {
                            }
                            i16 = i3;
                            if (appInfo2 != null) {
                            }
                            Bundle bundle222222222222 = new Bundle();
                            bundle222222222222.putString("ret", String.valueOf(i19));
                            bundle222222222222.putString(str2, str15);
                            bundle222222222222.putString("red", String.valueOf(i16));
                            bundle222222222222.putStringArrayList("missions", arrayList);
                            bundle222222222222.putString("path", str14);
                            bundle222222222222.putString(str11, str13);
                            bundle222222222222.putString(str3, str12);
                            HashMap<String, Object> hashMap222222222222 = new HashMap<>();
                            hashMap222222222222.put("callbackId", str12);
                            hashMap222222222222.put("req", bundle222222222222);
                            hashMap222222222222.put("jsonResult", jSONObject.toString());
                            return hashMap222222222222;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, str4 + jSONObject.toString());
                        }
                        if (appInterface != null) {
                            String lastClickPath = getLastClickPath(appInterface);
                            if (!TextUtils.isEmpty(str14) && str14.equals(lastClickPath)) {
                                i16 = 1;
                                if (appInfo2 != null) {
                                    str15 = "";
                                } else {
                                    str15 = getReportBufferString(appInfo2.buffer.get());
                                }
                                Bundle bundle2222222222222 = new Bundle();
                                bundle2222222222222.putString("ret", String.valueOf(i19));
                                bundle2222222222222.putString(str2, str15);
                                bundle2222222222222.putString("red", String.valueOf(i16));
                                bundle2222222222222.putStringArrayList("missions", arrayList);
                                bundle2222222222222.putString("path", str14);
                                bundle2222222222222.putString(str11, str13);
                                bundle2222222222222.putString(str3, str12);
                                HashMap<String, Object> hashMap2222222222222 = new HashMap<>();
                                hashMap2222222222222.put("callbackId", str12);
                                hashMap2222222222222.put("req", bundle2222222222222);
                                hashMap2222222222222.put("jsonResult", jSONObject.toString());
                                return hashMap2222222222222;
                            }
                        }
                        i16 = i3;
                        if (appInfo2 != null) {
                        }
                        Bundle bundle22222222222222 = new Bundle();
                        bundle22222222222222.putString("ret", String.valueOf(i19));
                        bundle22222222222222.putString(str2, str15);
                        bundle22222222222222.putString("red", String.valueOf(i16));
                        bundle22222222222222.putStringArrayList("missions", arrayList);
                        bundle22222222222222.putString("path", str14);
                        bundle22222222222222.putString(str11, str13);
                        bundle22222222222222.putString(str3, str12);
                        HashMap<String, Object> hashMap22222222222222 = new HashMap<>();
                        hashMap22222222222222.put("callbackId", str12);
                        hashMap22222222222222.put("req", bundle22222222222222);
                        hashMap22222222222222.put("jsonResult", jSONObject.toString());
                        return hashMap22222222222222;
                    }
                    str8 = string2;
                    str3 = "callback";
                    str5 = "jsEnd";
                    str6 = "jsStart";
                    str2 = "buffer";
                }
                appInfo = appInfo3;
                i17 = 0;
                if (!QLog.isColorLevel()) {
                }
                str12 = string;
                i3 = i18;
                appInfo2 = appInfo;
                str13 = str7;
                str14 = str8;
                str11 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
                if (QLog.isColorLevel()) {
                }
                if (appInterface != null) {
                }
                i16 = i3;
                if (appInfo2 != null) {
                }
                Bundle bundle222222222222222 = new Bundle();
                bundle222222222222222.putString("ret", String.valueOf(i19));
                bundle222222222222222.putString(str2, str15);
                bundle222222222222222.putString("red", String.valueOf(i16));
                bundle222222222222222.putStringArrayList("missions", arrayList);
                bundle222222222222222.putString("path", str14);
                bundle222222222222222.putString(str11, str13);
                bundle222222222222222.putString(str3, str12);
                HashMap<String, Object> hashMap222222222222222 = new HashMap<>();
                hashMap222222222222222.put("callbackId", str12);
                hashMap222222222222222.put("req", bundle222222222222222);
                hashMap222222222222222.put("jsonResult", jSONObject.toString());
                return hashMap222222222222222;
            }
        } else {
            appInfoByPath = getAppInfoByPath(appInterface, string2);
        }
        appInfo3 = appInfoByPath;
        if (appInfo3 != null) {
        }
        appInfo = appInfo3;
        i17 = 0;
        if (!QLog.isColorLevel()) {
        }
        str12 = string;
        i3 = i18;
        appInfo2 = appInfo;
        str13 = str7;
        str14 = str8;
        str11 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
        if (QLog.isColorLevel()) {
        }
        if (appInterface != null) {
        }
        i16 = i3;
        if (appInfo2 != null) {
        }
        Bundle bundle2222222222222222 = new Bundle();
        bundle2222222222222222.putString("ret", String.valueOf(i19));
        bundle2222222222222222.putString(str2, str15);
        bundle2222222222222222.putString("red", String.valueOf(i16));
        bundle2222222222222222.putStringArrayList("missions", arrayList);
        bundle2222222222222222.putString("path", str14);
        bundle2222222222222222.putString(str11, str13);
        bundle2222222222222222.putString(str3, str12);
        HashMap<String, Object> hashMap2222222222222222 = new HashMap<>();
        hashMap2222222222222222.put("callbackId", str12);
        hashMap2222222222222222.put("req", bundle2222222222222222);
        hashMap2222222222222222.put("jsonResult", jSONObject.toString());
        return hashMap2222222222222222;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:1|2|3|4|5|6|7|8|9|(3:148|149|150)(1:11)|12|13|14|(3:62|63|(1:65)(25:66|67|(9:71|72|73|74|75|(17:77|78|79|80|81|82|83|84|85|86|88|89|90|(2:93|91)|94|95|96)(2:110|111)|97|68|69)|118|119|120|121|122|123|124|125|126|127|128|23|24|(1:26)|27|(1:47)(1:31)|32|(1:34)(1:46)|(1:45)(1:38)|(1:40)(1:44)|41|42))|16|17|18|19|20|21|22|23|24|(0)|27|(1:29)|47|32|(0)(0)|(1:36)|45|(0)(0)|41|42|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x022e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0233, code lost:
    
        r7 = r9;
        r13 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0230, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0231, code lost:
    
        r9 = "errorMessage";
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, Object> parseGetAppInfoList(AppInterface appInterface, long j3, String str) {
        long j16;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i3;
        List<BusinessInfoCheckUpdate.AppInfo> list;
        String str7;
        int i16;
        List<BusinessInfoCheckUpdate.AppInfo> list2;
        int i17;
        BusinessInfoCheckUpdate.AppInfo appInfo;
        ArrayList<String> arrayList;
        String str8;
        String str9;
        String string;
        JSONArray jSONArray;
        String string2;
        List<BusinessInfoCheckUpdate.AppInfo> appInfoListByPath;
        String str10;
        long j17 = j3;
        String str11 = "jsEnd";
        String str12 = "errorMessage";
        String str13 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
        String str14 = "callback";
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        ArrayList arrayList2 = new ArrayList();
        int i18 = -2;
        try {
        } catch (Exception e16) {
            e = e16;
            j16 = j17;
            str2 = "jsEnd";
            str3 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
            str4 = "callback";
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            string = jSONObject2.getString("callback");
            try {
                jSONArray = jSONObject2.getJSONArray("pathList");
                if (!jSONObject2.has(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL)) {
                    string2 = "";
                } else {
                    try {
                        string2 = jSONObject2.getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
                    } catch (Exception e17) {
                        e = e17;
                        j16 = j17;
                        str2 = "jsEnd";
                        str3 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
                        str4 = "callback";
                        str5 = "";
                        str12 = "errorMessage";
                        i3 = 0;
                        list = null;
                        str6 = string;
                        e.printStackTrace();
                        try {
                            jSONObject.put("code", -1);
                            jSONObject.put(str12, "jsonexception");
                            jSONObject.put("jsStart", j16);
                            jSONObject.put(str2, System.currentTimeMillis());
                            i16 = -1;
                            str7 = str6;
                        } catch (JSONException e18) {
                            e18.printStackTrace();
                            str7 = str6;
                            i16 = i18;
                        }
                        int i19 = i3;
                        list2 = list;
                        if (QLog.isColorLevel()) {
                        }
                        int reddot = getReddot(appInterface, list2, i19);
                        if (list2 == null) {
                        }
                        i17 = 0;
                        appInfo = null;
                        if (!arrayList2.isEmpty()) {
                        }
                        if (list2 != null) {
                        }
                        str8 = "";
                        if (appInfo != null) {
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("ret", String.valueOf(i16));
                        bundle.putString("buffer", str9);
                        bundle.putString("red", String.valueOf(reddot));
                        bundle.putStringArrayList("missions", arrayList);
                        bundle.putString("path", str8);
                        bundle.putString(str3, str5);
                        bundle.putString(str4, str7);
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("callbackId", str7);
                        hashMap.put("req", bundle);
                        hashMap.put("jsonResult", jSONObject.toString());
                        return hashMap;
                    }
                }
            } catch (Exception e19) {
                e = e19;
                j16 = j17;
                str2 = "jsEnd";
                str3 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
                str4 = "callback";
                str12 = "errorMessage";
                str6 = string;
                str5 = "";
            }
        } catch (Exception e26) {
            e = e26;
            j16 = j17;
            str2 = "jsEnd";
            str3 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
            str4 = "callback";
            str12 = "errorMessage";
            str5 = "";
            str6 = str4;
            i3 = 0;
            list = null;
            e.printStackTrace();
            jSONObject.put("code", -1);
            jSONObject.put(str12, "jsonexception");
            jSONObject.put("jsStart", j16);
            jSONObject.put(str2, System.currentTimeMillis());
            i16 = -1;
            str7 = str6;
            int i192 = i3;
            list2 = list;
            if (QLog.isColorLevel()) {
            }
            int reddot2 = getReddot(appInterface, list2, i192);
            if (list2 == null) {
            }
            i17 = 0;
            appInfo = null;
            if (!arrayList2.isEmpty()) {
            }
            if (list2 != null) {
            }
            str8 = "";
            if (appInfo != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("ret", String.valueOf(i16));
            bundle2.putString("buffer", str9);
            bundle2.putString("red", String.valueOf(reddot2));
            bundle2.putStringArrayList("missions", arrayList);
            bundle2.putString("path", str8);
            bundle2.putString(str3, str5);
            bundle2.putString(str4, str7);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("callbackId", str7);
            hashMap2.put("req", bundle2);
            hashMap2.put("jsonResult", jSONObject.toString());
            return hashMap2;
        }
        try {
            appInfoListByPath = getAppInfoListByPath(appInterface, buildPaths(null, jSONArray));
        } catch (Exception e27) {
            e = e27;
            j16 = j17;
            str2 = "jsEnd";
            str3 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
            str4 = "callback";
            str12 = "errorMessage";
            str6 = string;
            str5 = string2;
            i3 = 0;
            list = null;
            e.printStackTrace();
            jSONObject.put("code", -1);
            jSONObject.put(str12, "jsonexception");
            jSONObject.put("jsStart", j16);
            jSONObject.put(str2, System.currentTimeMillis());
            i16 = -1;
            str7 = str6;
            int i1922 = i3;
            list2 = list;
            if (QLog.isColorLevel()) {
            }
            int reddot22 = getReddot(appInterface, list2, i1922);
            if (list2 == null) {
            }
            i17 = 0;
            appInfo = null;
            if (!arrayList2.isEmpty()) {
            }
            if (list2 != null) {
            }
            str8 = "";
            if (appInfo != null) {
            }
            Bundle bundle22 = new Bundle();
            bundle22.putString("ret", String.valueOf(i16));
            bundle22.putString("buffer", str9);
            bundle22.putString("red", String.valueOf(reddot22));
            bundle22.putStringArrayList("missions", arrayList);
            bundle22.putString("path", str8);
            bundle22.putString(str3, str5);
            bundle22.putString(str4, str7);
            HashMap<String, Object> hashMap22 = new HashMap<>();
            hashMap22.put("callbackId", str7);
            hashMap22.put("req", bundle22);
            hashMap22.put("jsonResult", jSONObject.toString());
            return hashMap22;
        }
        if (appInfoListByPath != null) {
            try {
            } catch (Exception e28) {
                e = e28;
                j16 = j17;
                str2 = "jsEnd";
                list = appInfoListByPath;
                str3 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
                str4 = "callback";
                str6 = string;
                str5 = string2;
                str12 = "errorMessage";
                i3 = 0;
                e.printStackTrace();
                jSONObject.put("code", -1);
                jSONObject.put(str12, "jsonexception");
                jSONObject.put("jsStart", j16);
                jSONObject.put(str2, System.currentTimeMillis());
                i16 = -1;
                str7 = str6;
                int i19222 = i3;
                list2 = list;
                if (QLog.isColorLevel()) {
                }
                int reddot222 = getReddot(appInterface, list2, i19222);
                if (list2 == null) {
                }
                i17 = 0;
                appInfo = null;
                if (!arrayList2.isEmpty()) {
                }
                if (list2 != null) {
                }
                str8 = "";
                if (appInfo != null) {
                }
                Bundle bundle222 = new Bundle();
                bundle222.putString("ret", String.valueOf(i16));
                bundle222.putString("buffer", str9);
                bundle222.putString("red", String.valueOf(reddot222));
                bundle222.putStringArrayList("missions", arrayList);
                bundle222.putString("path", str8);
                bundle222.putString(str3, str5);
                bundle222.putString(str4, str7);
                HashMap<String, Object> hashMap222 = new HashMap<>();
                hashMap222.put("callbackId", str7);
                hashMap222.put("req", bundle222);
                hashMap222.put("jsonResult", jSONObject.toString());
                return hashMap222;
            }
            if (!appInfoListByPath.isEmpty()) {
                i3 = 0;
                for (BusinessInfoCheckUpdate.AppInfo appInfo2 : appInfoListByPath) {
                    try {
                        try {
                            list = appInfoListByPath;
                            try {
                                if (appInfo2.red_display_info.get() != null) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    str4 = str14;
                                    try {
                                        ArrayList arrayList3 = new ArrayList();
                                        str3 = str13;
                                        try {
                                            List<BusinessInfoCheckUpdate.RedTypeInfo> list3 = appInfo2.red_display_info.red_type_info.get();
                                            str10 = str11;
                                            try {
                                                jSONObject3.put("appID", appInfo2.uiAppId.get());
                                                jSONObject3.put("iNewFlag", appInfo2.iNewFlag.get());
                                                int i26 = appInfo2.iNewFlag.get();
                                                try {
                                                    JSONArray jSONArray3 = new JSONArray();
                                                    i3 = i26;
                                                    for (int i27 = 0; i27 < appInfo2.missions.size(); i27++) {
                                                        jSONArray3.mo162put(appInfo2.missions.get(i27));
                                                        arrayList3.add(appInfo2.missions.get(i27));
                                                    }
                                                    arrayList2.add(arrayList3);
                                                    jSONObject3.put("redInfo", buildRedJson(list3));
                                                    jSONObject3.put(QFSEdgeItem.KEY_EXTEND, appInfo2.extend.get());
                                                    jSONObject3.put("missions", jSONArray3);
                                                    jSONObject3.put("type", appInfo2.type.get());
                                                    jSONObject3.put("buffer", appInfo2.buffer.get());
                                                    jSONObject3.put("path", appInfo2.path.get());
                                                    jSONObject3.put("appset", appInfo2.appset.get());
                                                    jSONObject3.put("modify_ts", appInfo2.modify_ts.get());
                                                    jSONObject3.put(WidgetCacheConstellationData.NUM, appInfo2.num.get());
                                                    jSONObject3.put("push_red_ts", appInfo2.push_red_ts.get());
                                                    jSONArray2.mo162put(jSONObject3);
                                                } catch (Exception e29) {
                                                    e = e29;
                                                    i3 = i26;
                                                    j16 = j3;
                                                    str6 = string;
                                                    str5 = string2;
                                                    str12 = "errorMessage";
                                                    str2 = str10;
                                                    e.printStackTrace();
                                                    jSONObject.put("code", -1);
                                                    jSONObject.put(str12, "jsonexception");
                                                    jSONObject.put("jsStart", j16);
                                                    jSONObject.put(str2, System.currentTimeMillis());
                                                    i16 = -1;
                                                    str7 = str6;
                                                    int i192222 = i3;
                                                    list2 = list;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    int reddot2222 = getReddot(appInterface, list2, i192222);
                                                    if (list2 == null) {
                                                    }
                                                    i17 = 0;
                                                    appInfo = null;
                                                    if (!arrayList2.isEmpty()) {
                                                    }
                                                    if (list2 != null) {
                                                    }
                                                    str8 = "";
                                                    if (appInfo != null) {
                                                    }
                                                    Bundle bundle2222 = new Bundle();
                                                    bundle2222.putString("ret", String.valueOf(i16));
                                                    bundle2222.putString("buffer", str9);
                                                    bundle2222.putString("red", String.valueOf(reddot2222));
                                                    bundle2222.putStringArrayList("missions", arrayList);
                                                    bundle2222.putString("path", str8);
                                                    bundle2222.putString(str3, str5);
                                                    bundle2222.putString(str4, str7);
                                                    HashMap<String, Object> hashMap2222 = new HashMap<>();
                                                    hashMap2222.put("callbackId", str7);
                                                    hashMap2222.put("req", bundle2222);
                                                    hashMap2222.put("jsonResult", jSONObject.toString());
                                                    return hashMap2222;
                                                }
                                            } catch (Exception e36) {
                                                e = e36;
                                            }
                                        } catch (Exception e37) {
                                            e = e37;
                                            j16 = j3;
                                            str2 = str11;
                                            str5 = string2;
                                            str12 = "errorMessage";
                                            str6 = string;
                                            e.printStackTrace();
                                            jSONObject.put("code", -1);
                                            jSONObject.put(str12, "jsonexception");
                                            jSONObject.put("jsStart", j16);
                                            jSONObject.put(str2, System.currentTimeMillis());
                                            i16 = -1;
                                            str7 = str6;
                                            int i1922222 = i3;
                                            list2 = list;
                                            if (QLog.isColorLevel()) {
                                            }
                                            int reddot22222 = getReddot(appInterface, list2, i1922222);
                                            if (list2 == null) {
                                            }
                                            i17 = 0;
                                            appInfo = null;
                                            if (!arrayList2.isEmpty()) {
                                            }
                                            if (list2 != null) {
                                            }
                                            str8 = "";
                                            if (appInfo != null) {
                                            }
                                            Bundle bundle22222 = new Bundle();
                                            bundle22222.putString("ret", String.valueOf(i16));
                                            bundle22222.putString("buffer", str9);
                                            bundle22222.putString("red", String.valueOf(reddot22222));
                                            bundle22222.putStringArrayList("missions", arrayList);
                                            bundle22222.putString("path", str8);
                                            bundle22222.putString(str3, str5);
                                            bundle22222.putString(str4, str7);
                                            HashMap<String, Object> hashMap22222 = new HashMap<>();
                                            hashMap22222.put("callbackId", str7);
                                            hashMap22222.put("req", bundle22222);
                                            hashMap22222.put("jsonResult", jSONObject.toString());
                                            return hashMap22222;
                                        }
                                    } catch (Exception e38) {
                                        e = e38;
                                        str3 = str13;
                                    }
                                } else {
                                    str10 = str11;
                                    str3 = str13;
                                    str4 = str14;
                                }
                                j17 = j3;
                                appInfoListByPath = list;
                                str14 = str4;
                                str13 = str3;
                                str11 = str10;
                            } catch (Exception e39) {
                                e = e39;
                                str3 = str13;
                                str4 = str14;
                                j16 = j3;
                                str2 = str11;
                                str5 = string2;
                                str12 = "errorMessage";
                                str6 = string;
                                e.printStackTrace();
                                jSONObject.put("code", -1);
                                jSONObject.put(str12, "jsonexception");
                                jSONObject.put("jsStart", j16);
                                jSONObject.put(str2, System.currentTimeMillis());
                                i16 = -1;
                                str7 = str6;
                                int i19222222 = i3;
                                list2 = list;
                                if (QLog.isColorLevel()) {
                                }
                                int reddot222222 = getReddot(appInterface, list2, i19222222);
                                if (list2 == null) {
                                }
                                i17 = 0;
                                appInfo = null;
                                if (!arrayList2.isEmpty()) {
                                }
                                if (list2 != null) {
                                }
                                str8 = "";
                                if (appInfo != null) {
                                }
                                Bundle bundle222222 = new Bundle();
                                bundle222222.putString("ret", String.valueOf(i16));
                                bundle222222.putString("buffer", str9);
                                bundle222222.putString("red", String.valueOf(reddot222222));
                                bundle222222.putStringArrayList("missions", arrayList);
                                bundle222222.putString("path", str8);
                                bundle222222.putString(str3, str5);
                                bundle222222.putString(str4, str7);
                                HashMap<String, Object> hashMap222222 = new HashMap<>();
                                hashMap222222.put("callbackId", str7);
                                hashMap222222.put("req", bundle222222);
                                hashMap222222.put("jsonResult", jSONObject.toString());
                                return hashMap222222;
                            }
                        } catch (Exception e46) {
                            e = e46;
                            list = appInfoListByPath;
                        }
                    } catch (Exception e47) {
                        e = e47;
                        j16 = j17;
                        str2 = str11;
                        list = appInfoListByPath;
                        str3 = str13;
                        str4 = str14;
                        str6 = string;
                        str5 = string2;
                        str12 = "errorMessage";
                    }
                }
                String str15 = str11;
                list = appInfoListByPath;
                str3 = str13;
                str4 = str14;
                try {
                    jSONObject.put("code", 0);
                    jSONObject.put("data", jSONArray2);
                    j16 = j3;
                    try {
                        jSONObject.put("jsStart", j16);
                        str2 = str15;
                        try {
                            jSONObject.put(str2, System.currentTimeMillis());
                            i16 = 0;
                            str7 = string;
                            str5 = string2;
                        } catch (Exception e48) {
                            e = e48;
                            str6 = string;
                            str5 = string2;
                            str12 = "errorMessage";
                            i18 = 0;
                            e.printStackTrace();
                            jSONObject.put("code", -1);
                            jSONObject.put(str12, "jsonexception");
                            jSONObject.put("jsStart", j16);
                            jSONObject.put(str2, System.currentTimeMillis());
                            i16 = -1;
                            str7 = str6;
                            int i192222222 = i3;
                            list2 = list;
                            if (QLog.isColorLevel()) {
                            }
                            int reddot2222222 = getReddot(appInterface, list2, i192222222);
                            if (list2 == null) {
                            }
                            i17 = 0;
                            appInfo = null;
                            if (!arrayList2.isEmpty()) {
                            }
                            if (list2 != null) {
                            }
                            str8 = "";
                            if (appInfo != null) {
                            }
                            Bundle bundle2222222 = new Bundle();
                            bundle2222222.putString("ret", String.valueOf(i16));
                            bundle2222222.putString("buffer", str9);
                            bundle2222222.putString("red", String.valueOf(reddot2222222));
                            bundle2222222.putStringArrayList("missions", arrayList);
                            bundle2222222.putString("path", str8);
                            bundle2222222.putString(str3, str5);
                            bundle2222222.putString(str4, str7);
                            HashMap<String, Object> hashMap2222222 = new HashMap<>();
                            hashMap2222222.put("callbackId", str7);
                            hashMap2222222.put("req", bundle2222222);
                            hashMap2222222.put("jsonResult", jSONObject.toString());
                            return hashMap2222222;
                        }
                    } catch (Exception e49) {
                        e = e49;
                        str2 = str15;
                        str6 = string;
                        str5 = string2;
                        str12 = "errorMessage";
                        i18 = 0;
                        e.printStackTrace();
                        jSONObject.put("code", -1);
                        jSONObject.put(str12, "jsonexception");
                        jSONObject.put("jsStart", j16);
                        jSONObject.put(str2, System.currentTimeMillis());
                        i16 = -1;
                        str7 = str6;
                        int i1922222222 = i3;
                        list2 = list;
                        if (QLog.isColorLevel()) {
                        }
                        int reddot22222222 = getReddot(appInterface, list2, i1922222222);
                        if (list2 == null) {
                        }
                        i17 = 0;
                        appInfo = null;
                        if (!arrayList2.isEmpty()) {
                        }
                        if (list2 != null) {
                        }
                        str8 = "";
                        if (appInfo != null) {
                        }
                        Bundle bundle22222222 = new Bundle();
                        bundle22222222.putString("ret", String.valueOf(i16));
                        bundle22222222.putString("buffer", str9);
                        bundle22222222.putString("red", String.valueOf(reddot22222222));
                        bundle22222222.putStringArrayList("missions", arrayList);
                        bundle22222222.putString("path", str8);
                        bundle22222222.putString(str3, str5);
                        bundle22222222.putString(str4, str7);
                        HashMap<String, Object> hashMap22222222 = new HashMap<>();
                        hashMap22222222.put("callbackId", str7);
                        hashMap22222222.put("req", bundle22222222);
                        hashMap22222222.put("jsonResult", jSONObject.toString());
                        return hashMap22222222;
                    }
                } catch (Exception e56) {
                    e = e56;
                    j16 = j3;
                }
                int i19222222222 = i3;
                list2 = list;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getAppInfoList:" + jSONObject.toString());
                }
                int reddot222222222 = getReddot(appInterface, list2, i19222222222);
                if (list2 == null && !list2.isEmpty()) {
                    i17 = 0;
                    appInfo = list2.get(0);
                } else {
                    i17 = 0;
                    appInfo = null;
                }
                if (!arrayList2.isEmpty()) {
                    arrayList = new ArrayList<>();
                } else {
                    arrayList = (ArrayList) arrayList2.get(i17);
                }
                if (list2 != null || list2.isEmpty()) {
                    str8 = "";
                } else {
                    str8 = list2.get(i17).path.get();
                }
                if (appInfo != null) {
                    str9 = "";
                } else {
                    str9 = getReportBufferString(appInfo.buffer.get());
                }
                Bundle bundle222222222 = new Bundle();
                bundle222222222.putString("ret", String.valueOf(i16));
                bundle222222222.putString("buffer", str9);
                bundle222222222.putString("red", String.valueOf(reddot222222222));
                bundle222222222.putStringArrayList("missions", arrayList);
                bundle222222222.putString("path", str8);
                bundle222222222.putString(str3, str5);
                bundle222222222.putString(str4, str7);
                HashMap<String, Object> hashMap222222222 = new HashMap<>();
                hashMap222222222.put("callbackId", str7);
                hashMap222222222.put("req", bundle222222222);
                hashMap222222222.put("jsonResult", jSONObject.toString());
                return hashMap222222222;
            }
        }
        j16 = j17;
        str2 = "jsEnd";
        list = appInfoListByPath;
        str3 = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
        str4 = "callback";
        jSONObject.put("code", -3);
        str12 = "errorMessage";
        jSONObject.put(str12, "not find red info");
        jSONObject.put("jsStartTime", j16);
        jSONObject.put("jsEndTime", System.currentTimeMillis());
        i16 = -3;
        i3 = 0;
        str7 = string;
        str5 = string2;
        int i192222222222 = i3;
        list2 = list;
        if (QLog.isColorLevel()) {
        }
        int reddot2222222222 = getReddot(appInterface, list2, i192222222222);
        if (list2 == null) {
        }
        i17 = 0;
        appInfo = null;
        if (!arrayList2.isEmpty()) {
        }
        if (list2 != null) {
        }
        str8 = "";
        if (appInfo != null) {
        }
        Bundle bundle2222222222 = new Bundle();
        bundle2222222222.putString("ret", String.valueOf(i16));
        bundle2222222222.putString("buffer", str9);
        bundle2222222222.putString("red", String.valueOf(reddot2222222222));
        bundle2222222222.putStringArrayList("missions", arrayList);
        bundle2222222222.putString("path", str8);
        bundle2222222222.putString(str3, str5);
        bundle2222222222.putString(str4, str7);
        HashMap<String, Object> hashMap2222222222 = new HashMap<>();
        hashMap2222222222.put("callbackId", str7);
        hashMap2222222222.put("req", bundle2222222222);
        hashMap2222222222.put("jsonResult", jSONObject.toString());
        return hashMap2222222222;
    }

    public static HashMap<String, Object> parseSetAppInfoParam(String str) {
        String str2;
        HashMap<String, Object> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject();
        new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            str2 = jSONObject2.getString("callback");
            try {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("appInfo");
                BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
                appInfo.uiAppId.set(jSONObject3.getInt("appID"));
                appInfo.iNewFlag.set(jSONObject3.getInt("iNewFlag"));
                JSONArray jSONArray = jSONObject3.getJSONArray("missions");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    appInfo.missions.add(jSONArray.getString(i3));
                }
                appInfo.type.set(jSONObject3.getInt("type"));
                appInfo.buffer.set(jSONObject3.getString("buffer"));
                appInfo.path.set(jSONObject3.getString("path"));
                appInfo.appset.set(jSONObject3.getInt("appset"));
                appInfo.modify_ts.set(jSONObject3.getInt("modify_ts"));
                appInfo.num.set(jSONObject3.getInt(WidgetCacheConstellationData.NUM));
                appInfo.push_red_ts.set(jSONObject3.getInt("push_red_ts"));
                appInfo.extend.set(jSONObject3.getString(QFSEdgeItem.KEY_EXTEND));
                Bundle bundle = new Bundle();
                bundle.putParcelable("red", g.a(appInfo));
                hashMap.put("callback", str2);
                hashMap.put("req", bundle);
                hashMap.put("code", 0);
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                try {
                    jSONObject.put("code", -1);
                    jSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
                hashMap.put("callback", str2);
                hashMap.put("code", -1);
                hashMap.put("errorJson", jSONObject.toString());
                return hashMap;
            }
        } catch (Exception e18) {
            e = e18;
            str2 = "callback";
        }
        return hashMap;
    }

    public static void setGameCenterAppInfoCache(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[setGameCenterAppInfoCache] set appInfo cache.");
        }
        cacheInfo = appInfo;
    }
}

package com.tencent.biz.qqstory.model;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class g implements xc0.a {
    private boolean b(List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        String str = list.get(0);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_STORY_COMMON_CONFIG, 2, "config content: " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("certificationLink");
            h hVar = (h) i.c(10);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("text");
                String optString2 = optJSONObject.optString("url");
                if (!TextUtils.isEmpty(optString) && HttpUtil.isValidUrl(optString2)) {
                    hVar.m("CertificationLinkText", optString);
                    hVar.m("CertificationLinkUrl", optString2);
                } else {
                    hVar.m("CertificationLinkText", "");
                    hVar.m("CertificationLinkUrl", "");
                }
            } else {
                hVar.m("CertificationLinkText", "");
                hVar.m("CertificationLinkUrl", "");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("localVideo");
            if (optJSONObject2 != null) {
                int i3 = optJSONObject2.getInt("scanInterval");
                if (i3 == 0) {
                    i3 = 1439;
                }
                hVar.m("localVideoScanInterval", String.valueOf(i3));
            } else {
                hVar.m("localVideoScanInterval", "1441");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("multiFragmentBlackModelList");
            if (optJSONArray != null) {
                String lowerCase = DeviceInfoMonitor.getModel().toLowerCase();
                int length = optJSONArray.length();
                hVar.m("boolean_enable_multi_video_fragment", Boolean.TRUE);
                for (int i16 = 0; i16 < length; i16++) {
                    String optString3 = optJSONArray.optString(i16);
                    if (!lowerCase.equalsIgnoreCase(optString3) && !"all".equalsIgnoreCase(optString3)) {
                    }
                    hVar.m("boolean_enable_multi_video_fragment", Boolean.FALSE);
                    break;
                }
            } else {
                hVar.m("boolean_enable_multi_video_fragment", Boolean.TRUE);
            }
            int optInt = jSONObject.optInt("qim_sync_to_qq", 0);
            QLog.d(LogTag.TAG_STORY_COMMON_CONFIG, 2, "qim_sync_to_qq: " + str);
            hVar.m("key_qim_int_qim_sync_to_qq_default", Integer.valueOf(optInt));
            return true;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.w(LogTag.TAG_STORY_COMMON_CONFIG, 2, e16.getMessage());
            }
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:5|(6:8|(1:10)(1:28)|11|(2:13|14)(3:16|(3:18|(1:26)(2:20|(2:22|23)(1:25))|24)|27)|15|6)|29|30|(5:31|32|33|34|(1:36)(1:120))|(3:37|38|39)|40|41|42|43|(4:44|45|(1:47)(1:111)|48)|49|50|51|52|(1:54)(1:106)|(2:104|105)|(1:57)|(1:59)|(1:61)|(1:63)|(1:65)|(1:67)|(1:69)|(1:71)|(1:73)|(1:75)|(1:77)|78|(1:80)|81|(1:83)|84|(1:86)|87|(1:89)|90|(1:92)|93|(2:95|102)(1:103)) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x024a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x024b, code lost:
    
        hd0.c.g("Q.qqstory.config.QQStoryConfigServletHandler", "get maxVideoSize= " + r5 + " from json error:" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01d0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d1, code lost:
    
        hd0.c.g("Q.qqstory.config.QQStoryConfigServletHandler", "get highBitrate= " + r5 + " from json error:" + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02d8 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02e4 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02f0 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02f8 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0304 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0310 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x031c A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0328 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0334 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0340 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x034c A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0360 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0371 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0382 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0393 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03a4 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03b5 A[Catch: Exception -> 0x02d3, TRY_LEAVE, TryCatch #4 {Exception -> 0x02d3, blocks: (B:105:0x02c8, B:57:0x02d8, B:59:0x02e4, B:61:0x02f0, B:63:0x02f8, B:65:0x0304, B:67:0x0310, B:69:0x031c, B:71:0x0328, B:73:0x0334, B:75:0x0340, B:77:0x034c, B:78:0x0356, B:80:0x0360, B:81:0x0367, B:83:0x0371, B:84:0x0378, B:86:0x0382, B:87:0x0389, B:89:0x0393, B:90:0x039a, B:92:0x03a4, B:93:0x03ab, B:95:0x03b5), top: B:104:0x02c8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(List<String> list, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        List<String> list2 = list;
        if (list2 == null || list.isEmpty()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        int i16 = 0;
        while (i16 < list.size()) {
            String str11 = list2.get(i16);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_STORY_VIDEO_CONFIG, 2, "receiveAllConfigs|type: -128,content: " + str11 + ",version: " + i3);
            }
            if (TextUtils.isEmpty(str11)) {
                QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "received TAG_STORY_VIDEO_CONFIG IGNORE THIS ACTION  because of SAME VERSION or empty content");
            } else {
                for (String str12 : str11.split("\n")) {
                    String[] split = str12.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length == 2) {
                        hashMap.put(split[0].trim(), split[1].trim());
                        if (QLog.isColorLevel()) {
                            QLog.i(LogTag.TAG_STORY_VIDEO_CONFIG, 2, "STORY_VIDEO_CONFIG, name=" + split[0].trim() + ", val=" + split[1].trim());
                        }
                    }
                }
            }
            i16++;
            list2 = list;
        }
        h hVar = (h) i.c(10);
        String str13 = (String) hashMap.get("key");
        String str14 = (String) hashMap.get("Width");
        String str15 = (String) hashMap.get("Height");
        String str16 = (String) hashMap.get("Maxrate");
        String str17 = (String) hashMap.get("Minrate");
        String str18 = (String) hashMap.get("crf");
        String str19 = (String) hashMap.get("qmax");
        String str20 = (String) hashMap.get("qmin");
        String str21 = (String) hashMap.get("qdiff");
        String str22 = (String) hashMap.get("newWidth");
        String str23 = (String) hashMap.get("newHeight");
        String str24 = (String) hashMap.get("newBitRate");
        String str25 = (String) hashMap.get("cq");
        try {
            str = "localUploadVideoSizeLimit";
        } catch (NumberFormatException e16) {
            e = e16;
            str = "localUploadVideoSizeLimit";
        }
        try {
            hVar.m("boolean_enable_cq_mode", Boolean.valueOf(Integer.valueOf(str25).intValue() == 0));
            str2 = LogTag.TAG_STORY_VIDEO_CONFIG;
        } catch (NumberFormatException e17) {
            e = e17;
            StringBuilder sb5 = new StringBuilder();
            str2 = LogTag.TAG_STORY_VIDEO_CONFIG;
            sb5.append("get enableCqMode= ");
            sb5.append(str25);
            sb5.append(" from json error:");
            sb5.append(e);
            hd0.c.g("Q.qqstory.config.QQStoryConfigServletHandler", sb5.toString());
            String str26 = (String) hashMap.get("hbr");
            hVar.m("int_high_bitrate", Integer.valueOf(Integer.valueOf(str26).intValue()));
            str3 = (String) hashMap.get("hprf");
            hVar.m("boolean_need_high_profile", Boolean.valueOf(Integer.valueOf(str3).intValue() != 1));
            String str27 = (String) hashMap.get("mvs");
            hVar.m("int_upload_video_size_limit", Integer.valueOf(Integer.valueOf(str27).intValue()));
            if (QLog.isColorLevel()) {
            }
            if (str22 != null) {
            }
            if (str23 != null) {
            }
            if (str24 != null) {
            }
            if (str13 != null) {
            }
            if (str14 != null) {
            }
            if (str15 != null) {
            }
            if (str16 != null) {
            }
            if (str17 != null) {
            }
            if (str18 != null) {
            }
            if (str19 != null) {
            }
            if (str20 != null) {
            }
            if (str21 != null) {
            }
            String str28 = str;
            str5 = (String) hashMap.get(str28);
            if (str5 != null) {
            }
            str6 = (String) hashMap.get("localUploadVideoMinResolutionLimit");
            if (str6 != null) {
            }
            str7 = (String) hashMap.get("localUploadVideoDurationLimit");
            if (str7 != null) {
            }
            str8 = (String) hashMap.get("localUploadVideoRatioLimit");
            if (str8 != null) {
            }
            str9 = (String) hashMap.get("localUploadImageSizeLimit");
            if (str9 != null) {
            }
            str10 = (String) hashMap.get("localUploadImageMinResolutionLimit");
            if (str10 != null) {
            }
        }
        String str262 = (String) hashMap.get("hbr");
        hVar.m("int_high_bitrate", Integer.valueOf(Integer.valueOf(str262).intValue()));
        str3 = (String) hashMap.get("hprf");
        try {
            hVar.m("boolean_need_high_profile", Boolean.valueOf(Integer.valueOf(str3).intValue() != 1));
        } catch (NumberFormatException e18) {
            hd0.c.g("Q.qqstory.config.QQStoryConfigServletHandler", "get codecProfile= " + str3 + " from json error:" + e18);
        }
        String str272 = (String) hashMap.get("mvs");
        hVar.m("int_upload_video_size_limit", Integer.valueOf(Integer.valueOf(str272).intValue()));
        if (QLog.isColorLevel()) {
            str4 = str2;
        } else {
            str4 = str2;
            QLog.i(str4, 2, "key = " + str13 + " Width = " + str14 + "Height = " + str15 + "Maxrate = " + str16 + "Minrate = " + str17 + " newWidth=" + str22 + " newHeight=" + str23 + " newBitRate=" + str24);
        }
        if (str22 != null) {
            try {
                hVar.m("NewStoryVideoWidth", Integer.valueOf(str22));
            } catch (Exception e19) {
                QLog.w(str4, 2, "save sp error", e19);
                return true;
            }
        }
        if (str23 != null) {
            hVar.m("NewStoryVideoHeight", Integer.valueOf(str23));
        }
        if (str24 != null) {
            hVar.m("NewStoryBitRate", Integer.valueOf(str24));
        }
        if (str13 != null) {
            hVar.m("StoryVideoKey", str13);
        }
        if (str14 != null) {
            hVar.m("StoryVideoWidth", Integer.valueOf(str14));
        }
        if (str15 != null) {
            hVar.m("StoryVideoHeight", Integer.valueOf(str15));
        }
        if (str16 != null) {
            hVar.m("StoryVideoMaxrate", Integer.valueOf(str16));
        }
        if (str17 != null) {
            hVar.m("StoryVideoMinrate", Integer.valueOf(str17));
        }
        if (str18 != null) {
            hVar.m("key_encode_crf", Integer.valueOf(str18));
        }
        if (str19 != null) {
            hVar.m("key_encode_qmax", Integer.valueOf(str19));
        }
        if (str20 != null) {
            hVar.m("key_encode_qmin", Integer.valueOf(str20));
        }
        if (str21 != null) {
            hVar.m("key_encode_qdiff", Integer.valueOf(str21));
        }
        String str282 = str;
        str5 = (String) hashMap.get(str282);
        if (str5 != null) {
            hVar.m(str282, Integer.valueOf(str5));
        }
        str6 = (String) hashMap.get("localUploadVideoMinResolutionLimit");
        if (str6 != null) {
            hVar.m("localUploadVideoMinResolutionLimit", Integer.valueOf(str6));
        }
        str7 = (String) hashMap.get("localUploadVideoDurationLimit");
        if (str7 != null) {
            hVar.m("localUploadVideoDurationLimit", Integer.valueOf(str7));
        }
        str8 = (String) hashMap.get("localUploadVideoRatioLimit");
        if (str8 != null) {
            hVar.m("localUploadVideoRatioLimit", Integer.valueOf(str8));
        }
        str9 = (String) hashMap.get("localUploadImageSizeLimit");
        if (str9 != null) {
            hVar.m("localUploadImageSizeLimit", Integer.valueOf(str9));
        }
        str10 = (String) hashMap.get("localUploadImageMinResolutionLimit");
        if (str10 != null) {
            return true;
        }
        hVar.m("localUploadImageMinResolutionLimit", Integer.valueOf(str10));
        return true;
    }

    public abstract boolean a(int i3, Intent intent, ConfigurationService$Config configurationService$Config, List<String> list);

    public boolean c(int i3, Intent intent, ConfigurationService$Config configurationService$Config) {
        String stringExtra = intent.getStringExtra("key_uin");
        int P1 = ea.P1(QQStoryContext.g().getApp(), h.k(i3), stringExtra);
        int i16 = configurationService$Config.version.get();
        List<String> l3 = ConfigServlet.l(configurationService$Config, P1, i3);
        boolean z16 = false;
        if (l3 == null) {
            return false;
        }
        if (i3 != -151) {
            if (i3 == -128) {
                z16 = d(l3, i16);
            }
        } else {
            z16 = b(l3);
        }
        if (!z16) {
            return a(i3, intent, configurationService$Config, l3);
        }
        return z16;
    }
}

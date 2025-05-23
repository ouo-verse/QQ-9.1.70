package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import java.util.HashMap;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerErrorAction implements RFWPlayerCollectBaseAction {
    private static final HashMap<String, String> ERROR_TYPE;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        ERROR_TYPE = hashMap;
        hashMap.put("1000", "\u7cfb\u7edf\u64ad\u653e\u5668\u9519\u8bef");
        hashMap.put("1100", "thumb\u901a\u7528\u9519\u8bef");
        hashMap.put("1101", "thumb \u7f51\u7edc\u9519\u8bef");
        hashMap.put("1102", "thumb\u89e3\u5c01\u88c5\u9519\u8bef");
        hashMap.put("1103", "thumb\u89e3\u7801\u9519\u8bef");
        hashMap.put("1106", "thumb\u6e32\u67d3\u9519\u8bef");
        hashMap.put("1107", "thumb DRM\u9274\u6743\u9519\u8bef");
        hashMap.put("1108", "thumb \u7f51\u7edc\u9519\u8bef");
        hashMap.put("1300", "\u5e94\u7528\u5c42TP \u9519\u8bef");
        hashMap.put("1400", "\u4e0b\u8f7d \u7f51\u7edc\u6807\u8bc6\u9519\u8bef");
        hashMap.put("1401", "\u4e0b\u8f7d http \u9519\u8bef");
        hashMap.put("1402", "\u4e0b\u8f7d CDN\u9519\u8bef");
        hashMap.put("1403", "\u4e0b\u8f7d cgi\u9519\u8bef");
        hashMap.put("1404", "\u4e0b\u8f7d info \u9519\u8bef");
        hashMap.put("1510", "\u4e0b\u8f7d offline\u6570\u636e\u4e22\u5931");
        hashMap.put("1600", "\u4e0b\u8f7d \u6587\u4ef6\u7cfb\u7edf\u9519\u8bef");
        hashMap.put("1601", "\u4e0b\u8f7d vfs\u81ea\u9002\u5e94\u9519\u8bef");
        hashMap.put("1711", "\u4e0b\u8f7d flv\u5b58\u50a8\u9519\u8bef");
        hashMap.put("1712", "\u4e0b\u8f7d flv\u5e27\u9519\u8bef");
        hashMap.put("1713", "\u4e0b\u8f7d flv\u89e3\u6790\u9519\u8bef");
        hashMap.put("1714", "\u4e0b\u8f7d flv\u4e0b\u8f7d\u5931\u8d25");
    }

    public /* synthetic */ String a(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ void b(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str2 = (String) obj;
                rFWPlayerCollectParams.setPlayerErrorCode(str2);
                if (str2.length() > 4) {
                    String str3 = ERROR_TYPE.get(str2.substring(0, 4));
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "\u672a\u77e5";
                    }
                    rFWPlayerCollectParams.setErrorMsg(str3);
                }
                b(a(str), "onError", rFWPlayerCollectParams.toString());
            }
        }
    }
}

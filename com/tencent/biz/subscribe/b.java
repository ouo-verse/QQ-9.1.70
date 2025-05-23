package com.tencent.biz.subscribe;

import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f95693a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f95694b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f95695c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f95696d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f95697e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f95698f;

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap<String, String> f95699g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap<String, String> f95700h;

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap<String, String> f95701i;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f95702j;

    static {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("cache/");
        f95693a = sDKPrivatePath;
        String sDKPrivatePath2 = VFSAssistantUtils.getSDKPrivatePath("qsubscribe/");
        f95694b = sDKPrivatePath2;
        String str = sDKPrivatePath2 + ProtocolDownloaderConstants.FILE_PREFIX;
        f95695c = str;
        f95696d = sDKPrivatePath2 + "cache/";
        String str2 = str + "animation/";
        f95697e = str2;
        f95698f = sDKPrivatePath + "tencent_sdk_download/";
        HashMap<String, String> hashMap = new HashMap<>();
        f95699g = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        f95700h = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        f95701i = hashMap3;
        hashMap.put("follow_guide_pics", "https://downv6.qq.com/video_story/certified_account/animation_pics/follow_guide_pics.zip");
        hashMap.put("praise_guide_pics", "https://downv6.qq.com/video_story/certified_account/animation_pics/praise_guide_pics.zip");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append("follow_guide_pics");
        String str3 = File.separator;
        sb5.append(str3);
        hashMap2.put("follow_guide_pics", sb5.toString());
        hashMap2.put("praise_guide_pics", str2 + "praise_guide_pics" + str3);
        hashMap3.put("follow_guide_pics", "KEY_SUBSCRIBE_FOLLOW_GUIDE_DOWNLOAD_URL");
        hashMap3.put("praise_guide_pics", "KEY_SUBSCRIBE_FOLLOW_PRAISE_DOWNLOAD_URL");
        f95702j = new String[]{"follow_guide_pics", "praise_guide_pics"};
    }

    public static String a(String str, String str2) {
        String format = String.format("https://h5.qzone.qq.com/subscription/addgoods/%s?_proxy=1&_wv=3", str);
        if (str2 != null && !StringUtil.isEmpty(str2)) {
            return format + "&id=" + URLEncoder.encode(str2);
        }
        return format;
    }

    public static String b(String str) {
        StringBuilder sb5 = new StringBuilder();
        String str2 = f95695c;
        sb5.append(str2);
        sb5.append(str);
        String sb6 = sb5.toString();
        if (QLog.isColorLevel()) {
            QLog.d("SubscribeConstants", 4, "QSUSCRIBE_DOWNLOAD_ROOT_PATH" + str2 + "   getSDKPrivatePath realPath=" + sb6);
        }
        return sb6;
    }

    public static String c(String str) {
        return String.format("https://h5.qzone.qq.com/subscription/openshop/%s?_proxy=1&_wv=3", str);
    }

    public static String d(String str) {
        return "https://h5.qzone.qq.com/subscription/morerecommend/{uin}?_proxy=1&_wv=3&_p=".replace("{uin}", str);
    }
}

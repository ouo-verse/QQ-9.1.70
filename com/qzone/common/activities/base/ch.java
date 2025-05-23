package com.qzone.common.activities.base;

import android.graphics.drawable.Drawable;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ch {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f45516a = {11, 3, 1, 0};

    public static Drawable b(String str) {
        return ImageManager.getInstance().getImageByUrlInMemory(str);
    }

    public static String d(Map<Integer, PictureUrl> map, int i3) {
        if (map == null) {
            return "";
        }
        if (map.containsKey(Integer.valueOf(i3)) && map.get(Integer.valueOf(i3)) != null && map.get(Integer.valueOf(i3)).url != null) {
            return map.get(Integer.valueOf(i3)).url;
        }
        for (int i16 : f45516a) {
            if (map.containsKey(Integer.valueOf(i16)) && map.get(Integer.valueOf(i16)) != null && map.get(Integer.valueOf(i16)).url != null) {
                return map.get(Integer.valueOf(i16)).url;
            }
        }
        return "";
    }

    public static DetailDataOutShare e(String str, String str2, String str3, int i3, int i16) {
        DetailDataOutShare detailDataOutShare = new DetailDataOutShare();
        detailDataOutShare.sTitle = str;
        detailDataOutShare.sSummary = str2;
        detailDataOutShare.mapPhotoUrl = f(str3, i3, i16);
        return detailDataOutShare;
    }

    public static Map<Integer, PictureUrl> f(String str, int i3, int i16) {
        HashMap hashMap = new HashMap();
        PictureUrl pictureUrl = new PictureUrl(str, i3, i16);
        pictureUrl.pictureType = 0;
        pictureUrl.enlargeRate = 200;
        pictureUrl.pivotXRate = 0.0f;
        pictureUrl.pivotYRate = 0.0f;
        hashMap.put(11, pictureUrl);
        hashMap.put(3, pictureUrl);
        hashMap.put(4, pictureUrl);
        hashMap.put(1, pictureUrl);
        hashMap.put(0, pictureUrl);
        return hashMap;
    }

    public static String c(Map<Integer, PictureUrl> map) {
        return d(map, -1);
    }

    public static boolean a(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null || businessFeedData.getOperationInfo() == null || !com.qzone.proxy.feedcomponent.util.f.c(businessFeedData)) {
            return false;
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "GiveRedPacket", "\u6b63\u5728\u7a7a\u95f4\u53d1\u653e\u7ea2\u5305");
        if (com.qzone.proxy.feedcomponent.util.f.a(businessFeedData)) {
            str = businessFeedData.getOriginalInfo().getCellUserInfo().getUser().nickName + config;
        } else {
            str = businessFeedData.getCellUserInfo().getUser().nickName + config;
        }
        businessFeedData.getOperationInfo().shareData = e(str, "GO>>", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_redpocket_logo.png", 83, 95);
        return true;
    }
}

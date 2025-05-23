package com.tencent.mobileqq.wink.publish.util;

import android.os.Parcelable;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.widget.QzoneEmotionUtils;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {
    public static void a(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        systemAndEmojiEmoticonInfo.addToCommonUsed(MobileQQ.sMobileQQ.waitAppRuntime(null), (Parcelable) null);
    }

    public static String b(int i3, int i16) {
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoString(i3, i16);
    }

    public static String c(int i3) {
        return QQSysFaceUtil.getFaceString(i3);
    }

    public static String d(String str) {
        return QzoneEmotionUtils.splash2Emo(str);
    }
}

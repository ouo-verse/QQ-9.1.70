package com.qzone.reborn.qzmoment.comment;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {
    public static void a(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        systemAndEmojiEmoticonInfo.addToCommonUsed(MobileQQ.sMobileQQ.peekAppRuntime(), (Parcelable) null);
    }

    public static String b(int i3, int i16) {
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoString(i3, i16);
    }

    public static View c(Context context, EmoticonCallback emoticonCallback) {
        return new SystemAndEmojiUniversalPanel.Builder(context).setEmoticonCallback(emoticonCallback).setShowCommonUsedSystemEmoji(true).create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()));
    }

    public static String d(int i3) {
        return QQSysFaceUtil.getFaceString(i3);
    }
}

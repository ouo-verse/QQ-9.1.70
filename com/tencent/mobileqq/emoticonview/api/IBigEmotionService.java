package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IBigEmotionService extends QRouteApi {
    void openEmojiDetailPage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, String str2, boolean z16, Intent intent, boolean z17);

    void openEmojiDetailPage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, String str2, boolean z16, Intent intent, boolean z17, boolean z18, int i16, String str3);

    void openQQBrowserWithoutAD(Context context, String str, long j3, Intent intent, boolean z16, int i3);
}

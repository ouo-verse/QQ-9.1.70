package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IApolloUtil extends QRouteApi {
    String getApolloMessageDesc(MessageRecord messageRecord);

    URLDrawable getDrawable(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions, String str2);

    int getReportSessionType(int i3);

    void onEmoticonNewIconShown(int i3);

    void onNewEmoticonClick(int i3);

    void onPopupGuideShown();

    void playShareMsgAction(AppRuntime appRuntime, Object obj, MessageRecord messageRecord, int i3, int i16);

    boolean shouldShowNewIcon(int i3);

    boolean shouldShowPopupGuide();
}

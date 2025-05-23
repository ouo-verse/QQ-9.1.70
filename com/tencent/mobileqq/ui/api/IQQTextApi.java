package com.tencent.mobileqq.ui.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IQQTextApi extends QRouteApi {
    CharSequence buildQQText(CharSequence charSequence);

    int getEmojiTypeEmoji();

    int getEmojiTypeSmall();

    int getEmojiTypeSystem();

    int getGrabEmotcation();
}

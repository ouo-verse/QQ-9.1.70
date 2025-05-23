package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoAddedAuthCallbackService extends QRouteApi {
    ad createEmoAddedAuthCallback(BaseQQAppInterface baseQQAppInterface, Context context, CustomEmotionData customEmotionData, Object obj, int i3);
}

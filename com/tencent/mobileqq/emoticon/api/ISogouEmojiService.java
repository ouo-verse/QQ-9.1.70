package com.tencent.mobileqq.emoticon.api;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.ISogouEmoji;
import com.tencent.mobileqq.emoticonview.NTEmoticonSenderApi;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ISogouEmojiService extends QRouteApi {
    ISogouEmoji createSogouEmojiForNT(Activity activity, BaseQQAppInterface baseQQAppInterface, NTEmoticonSenderApi nTEmoticonSenderApi);
}

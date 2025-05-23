package com.tencent.mobileqq.richmediabrowser.api;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ICommentDanmakuDepend extends QRouteApi {
    TextView createETTextView(Context context, String str, int i3, int i16, float f16);

    boolean getAioAnonymousStatus(String str);

    int getAnonymousHeadId(String str);

    String getAnonymousHeadUrl(int i3);

    String getAnonymousNickName(String str);

    int getChatEmotionSizeWithDP();
}

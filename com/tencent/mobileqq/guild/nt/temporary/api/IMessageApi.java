package com.tencent.mobileqq.guild.nt.temporary.api;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IMessageApi extends QRouteApi {
    String getContent(Object obj);

    byte[] getData(Object obj);

    int getExtraFlag(Object obj);

    long getMessageTime(Object obj);

    int getMessageType(Object obj);

    String getSenderUin(Object obj);

    SpannableStringBuilder highlightString(Object obj, CharSequence charSequence, TextView textView, Context context);

    boolean isGiftMsg(Object obj);

    boolean isGrayTipMsg(Object obj);

    Object newMessage();

    void setContent(Object obj, String str);
}

package com.tencent.mobileqq.text.style.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISmallEmojiSpanService extends QRouteApi {
    ISmallEmojiSpan createSmallEmojiSpan(char[] cArr, int i3, boolean z16, boolean z17);

    ISmallEmojiSpan createSmallEmojiSpan(char[] cArr, int i3, boolean z16, boolean z17, boolean z18);
}

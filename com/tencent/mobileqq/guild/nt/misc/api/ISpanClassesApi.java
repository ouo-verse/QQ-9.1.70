package com.tencent.mobileqq.guild.nt.misc.api;

import android.text.Spannable;
import av1.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface ISpanClassesApi extends QRouteApi {
    Class<?> emoticonSpanClass();

    b[] extractSpans(Spannable spannable);

    Class<?> guildEmoticonSpanClass();

    Object newGuildEmoticonSpan(int i3, int i16, int i17);
}

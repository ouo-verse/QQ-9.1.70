package com.tencent.mobileqq.guild.api;

import android.text.Editable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildTextUtil extends QRouteApi {
    int countText(CharSequence charSequence);

    float countTextF(CharSequence charSequence);

    CharSequence filterTailSpace(Editable editable);
}

package com.tencent.mobileqq.guild.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildUIApi extends QRouteApi {
    Drawable getMixBackgroundDrawable(String str);
}

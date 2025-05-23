package com.tencent.mobileqq.vip.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipIconUtilsForQzone extends QRouteApi {
    Drawable getQzoneLetterSwitchIcon(String str, List<String> list, String str2, String str3, int i3);
}

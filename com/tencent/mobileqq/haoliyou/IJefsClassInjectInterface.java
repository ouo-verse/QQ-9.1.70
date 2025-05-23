package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mobileqq.bigbrother.a;
import com.tencent.mobileqq.bigbrother.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IJefsClassInjectInterface {
    boolean isUserAllow();

    void monitorInstallIntent(String str, Intent intent);

    void openThirdApp();

    void sendCheckDownloadReq(Context context, String str, String str2, String str3, String str4, a aVar);

    void thirdAppIntercept(Context context, String str, String str2, String str3, String str4, String str5, List<ResolveInfo> list, String str6, c cVar);
}

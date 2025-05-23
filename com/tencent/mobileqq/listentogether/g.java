package com.tencent.mobileqq.listentogether;

import android.content.Context;
import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class g {
    public static boolean a(QQAppInterface qQAppInterface, Message message) {
        return ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).checkIsTogetherOpenArkMsg(message);
    }

    public static void b(QQAppInterface qQAppInterface, Context context, int i3, String str, int i16) {
        ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).gotoListenTogetherSettingPage(context, i3, str, i16);
    }

    public static void c(RecentContactInfo recentContactInfo, Intent intent) {
        ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).handleIntentFromNTArkMsg(recentContactInfo, intent);
    }

    public static void d(QQAppInterface qQAppInterface, Message message, Intent intent) {
        ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).handleListenTogetherIntentFromArkMsg(message, intent);
    }

    public static void e(Context context, int i3, String str, int i16, boolean z16, String str2) {
        ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).onJoinClick(context, i3, str, i16, z16, str2);
    }
}

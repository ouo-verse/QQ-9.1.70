package com.tencent.mobileqq.matchfriend.share;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.utils.d;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {
    public static void b(Context context, AppInterface appInterface, int i3, String str) {
        d dVar = new d(context);
        dVar.c("pg_kl_new_test_share_bottom", null);
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        hashMap.put("kl_new_test_share_to", Integer.valueOf(i3));
        if (i3 == 1) {
            hashMap.put("kl_new_to_openid", str);
        } else if (i3 == 2) {
            hashMap.put("to_uin", str);
        }
        dVar.k("ev_kl_new_test_share_send", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void a(a aVar, Context context) {
        throw null;
    }
}

package com.tencent.mobileqq.activity.contacts.base;

import android.content.Context;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.alphabet.api.INTFriendApi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static c a(int i3, Context context, String str) {
        if (i3 != 4 && i3 != 0) {
            return null;
        }
        return (c) ((INTFriendApi) QRoute.api(INTFriendApi.class)).getBuddyItem(i3, context, str);
    }

    public static c b(int i3, Entity entity, QQAppInterface qQAppInterface, Context context) {
        if (i3 == 0) {
            return new BuddyListFriends(qQAppInterface, context, entity);
        }
        if (i3 == 2) {
            return new com.tencent.mobileqq.activity.contacts.troop.a(qQAppInterface, context, entity, 2);
        }
        if (i3 == 3) {
            return new com.tencent.mobileqq.activity.contacts.troop.a(qQAppInterface, context, entity, 3);
        }
        if (i3 == 4) {
            return new BuddyListFriends(qQAppInterface, context, entity);
        }
        return null;
    }
}

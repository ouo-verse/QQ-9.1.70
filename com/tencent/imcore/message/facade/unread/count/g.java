package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.unread.filter.UnreadMsgFilterProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.api.IChatsUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Provider<List<Object>> f116644a;

    /* renamed from: b, reason: collision with root package name */
    public static final Provider<List<Object>> f116645b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f116644a = new UnreadMsgFilterProvider();
            f116645b = new UnreadCountProvider();
        }
    }

    public static int a() {
        return ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(1);
    }

    public static int b() {
        return ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountNoiseByChatType(103);
    }

    public static int c(QQAppInterface qQAppInterface, QQMessageFacade qQMessageFacade) {
        return ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(1);
    }
}

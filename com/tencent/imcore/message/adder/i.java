package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface i {
    boolean[] a(AppRuntime appRuntime, IMessageFacade iMessageFacade, MessageRecord messageRecord, EntityManager entityManager, RecentUserProxy recentUserProxy, String str, int i3, boolean z16, int i16);
}

package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.mobileqq.matchfriend.api.IMatchFriendFloatingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.relation.common.api.IRelationFloatWindow;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendFloatingApiImpl implements IMatchFriendFloatingApi {
    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendFloatingApi
    public boolean checkFloatWindowShowing() {
        return ((IRelationFloatWindow) QRoute.api(IRelationFloatWindow.class)).checkFloatWindowShowing(com.tencent.mobileqq.matchfriend.widget.a.CLASS_NAME);
    }
}

package com.tencent.mobileqq.qqexpand.manager.impl;

import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandClassManager;
import com.tencent.mobileqq.qqexpand.manager.c;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandClassManagerImpl implements IExpandClassManager {
    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandClassManager
    public String getExpandHandlerClassName() {
        return ExpandHandlerImpl.class.getName();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandClassManager
    public Class getExpandLimitChatManagerClass() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandClassManager
    public Class getExpandManagerClass() {
        return ExpandManager.class;
    }
}

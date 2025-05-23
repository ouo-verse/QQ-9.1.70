package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.a;
import com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloClassFactoryImpl implements IApolloClassFactory {
    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory
    public String getApolloExtensionHandlerClassName() {
        return ApolloExtensionHandler.E;
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory
    public Class getApolloExtensionServletClass() {
        return a.class;
    }
}

package com.tencent.now.od.cs;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f338504a = LoggerFactory.getLogger("ODCSChannel");

    /* renamed from: b, reason: collision with root package name */
    private static Map<Long, IQQCmdPushCallback> f338505b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static Map<Long, List<Object>> f338506c = new ConcurrentHashMap();

    public static void a(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver) {
        ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId()).getProxySsoService().sendQQLiveProxyReq(str, str2, bArr, iQQLiveProxySsoObserver);
    }
}

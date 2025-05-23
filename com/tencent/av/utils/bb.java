package com.tencent.av.utils;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private EntityManager f77075a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Entity> f77076b = new ConcurrentHashMap<>();

    public bb(VideoAppInterface videoAppInterface) {
        this.f77075a = videoAppInterface.getEntityManagerFactory(videoAppInterface.getCurrentAccountUin()).createEntityManager();
    }

    public ExtensionInfo a(String str) {
        ConcurrentHashMap<String, Entity> concurrentHashMap;
        ExtensionInfo extensionInfo = null;
        if (str != null && !"".equals(str)) {
            ConcurrentHashMap<String, Entity> concurrentHashMap2 = this.f77076b;
            if (concurrentHashMap2 != null) {
                extensionInfo = (ExtensionInfo) concurrentHashMap2.get(str);
            }
            if (extensionInfo != null) {
                return extensionInfo;
            }
            extensionInfo = (ExtensionInfo) DBMethodProxy.find(this.f77075a, (Class<? extends Entity>) ExtensionInfo.class, str);
            if (extensionInfo != null && (concurrentHashMap = this.f77076b) != null) {
                synchronized (concurrentHashMap) {
                    this.f77076b.put(str, extensionInfo);
                }
            }
        }
        return extensionInfo;
    }
}

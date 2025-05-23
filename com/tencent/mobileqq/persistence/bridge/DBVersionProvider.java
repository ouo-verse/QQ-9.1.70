package com.tencent.mobileqq.persistence.bridge;

import com.tencent.mobileqq.data.entitymanager.Provider;

/* loaded from: classes16.dex */
public class DBVersionProvider implements Provider<Integer> {
    private static final int DB_VERSION = 441;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    public Integer get() {
        return Integer.valueOf(DB_VERSION);
    }
}

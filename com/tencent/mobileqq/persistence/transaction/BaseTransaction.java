package com.tencent.mobileqq.persistence.transaction;

import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface BaseTransaction<T> {
    public static final String DEFAULT_STRING = "default_string";

    void doDBOperate(EntityManager entityManager);

    T getResult();
}

package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.transaction.Transaction;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface TransactionOps {
    void cancelTransactionTask(Transaction transaction);

    void preConnect();

    void resumeTransactionTask(Transaction transaction);

    void stopTransactionTask(Transaction transaction);

    int submitTransactionTask(Transaction transaction);
}

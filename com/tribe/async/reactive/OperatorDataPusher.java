package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

/* loaded from: classes27.dex */
class OperatorDataPusher<UP, DOWN> extends BaseDataPusher<DOWN> {
    private Operator<UP, DOWN> mOperator;
    private DataPusher<UP> mUpDataPusher;

    public OperatorDataPusher(DataPusher<UP> dataPusher, Operator<UP, DOWN> operator) {
        this.mUpDataPusher = dataPusher;
        this.mOperator = operator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tribe.async.reactive.BaseDataPusher, com.tribe.async.reactive.AsyncFunction
    public void apply(Observer<DOWN> observer) {
        super.apply((Observer) observer);
        AssertUtils.checkNotNull(observer);
        this.mUpDataPusher.apply(this.mOperator.apply(observer));
    }
}

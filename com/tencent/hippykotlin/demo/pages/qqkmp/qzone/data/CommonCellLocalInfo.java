package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLocalInfo;", "", "()V", "fakeType", "", "getFakeType", "()I", "setFakeType", "(I)V", "isFake", "", "isReal", "setFake", "", "setReal", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellLocalInfo {
    public static final int FAKE_TYPE_FAKE = 1;
    public static final int FAKE_TYPE_REAL = 0;
    private int fakeType;
    public static final int $stable = 8;

    public final int getFakeType() {
        return this.fakeType;
    }

    public final boolean isFake() {
        return this.fakeType == 1;
    }

    public final boolean isReal() {
        return this.fakeType == 0;
    }

    public final void setFakeType(int i3) {
        this.fakeType = i3;
    }

    public final void setFake() {
        this.fakeType = 1;
    }

    public final void setReal() {
        this.fakeType = 0;
    }
}

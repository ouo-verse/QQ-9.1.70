package com.tencent.ecommerce.biz.showwindow.repo.window;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "goodsType", "b", "Ljava/lang/String;", "mediaProductId", "c", "retCode", "d", "getMsg", "()Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.showwindow.repo.window.i, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class FailItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int goodsType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String mediaProductId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int retCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    public FailItem(int i3, String str, int i16, String str2) {
        this.goodsType = i3;
        this.mediaProductId = str;
        this.retCode = i16;
        this.msg = str2;
    }

    public int hashCode() {
        int i3 = this.goodsType * 31;
        String str = this.mediaProductId;
        int hashCode = (((i3 + (str != null ? str.hashCode() : 0)) * 31) + this.retCode) * 31;
        String str2 = this.msg;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FailItem(goodsType=" + this.goodsType + ", mediaProductId=" + this.mediaProductId + ", retCode=" + this.retCode + ", msg=" + this.msg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FailItem)) {
            return false;
        }
        FailItem failItem = (FailItem) other;
        return this.goodsType == failItem.goodsType && Intrinsics.areEqual(this.mediaProductId, failItem.mediaProductId) && this.retCode == failItem.retCode && Intrinsics.areEqual(this.msg, failItem.msg);
    }
}

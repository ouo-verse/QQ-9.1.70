package com.tencent.ecommerce.biz.shophome.repo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/repo/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "shareAction", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "b", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "shareInfo", "c", "Ljava/lang/String;", "shareToFriendUin", "d", "shareToFriendUinName", "e", "()I", "shareToFriendUinType", "<init>", "(ILcom/tencent/ecommerce/biz/shophome/repo/b;Ljava/lang/String;Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shophome.repo.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShareActionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int shareAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECShareInfo shareInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shareToFriendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shareToFriendUinName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int shareToFriendUinType;

    public ECShareActionInfo(int i3, ECShareInfo eCShareInfo, String str, String str2, int i16) {
        this.shareAction = i3;
        this.shareInfo = eCShareInfo;
        this.shareToFriendUin = str;
        this.shareToFriendUinName = str2;
        this.shareToFriendUinType = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getShareToFriendUinType() {
        return this.shareToFriendUinType;
    }

    public int hashCode() {
        int i3 = this.shareAction * 31;
        ECShareInfo eCShareInfo = this.shareInfo;
        int hashCode = (i3 + (eCShareInfo != null ? eCShareInfo.hashCode() : 0)) * 31;
        String str = this.shareToFriendUin;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.shareToFriendUinName;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.shareToFriendUinType;
    }

    public String toString() {
        return "ECShareActionInfo(shareAction=" + this.shareAction + ", shareInfo=" + this.shareInfo + ", shareToFriendUin=" + this.shareToFriendUin + ", shareToFriendUinName=" + this.shareToFriendUinName + ", shareToFriendUinType=" + this.shareToFriendUinType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShareActionInfo)) {
            return false;
        }
        ECShareActionInfo eCShareActionInfo = (ECShareActionInfo) other;
        return this.shareAction == eCShareActionInfo.shareAction && Intrinsics.areEqual(this.shareInfo, eCShareActionInfo.shareInfo) && Intrinsics.areEqual(this.shareToFriendUin, eCShareActionInfo.shareToFriendUin) && Intrinsics.areEqual(this.shareToFriendUinName, eCShareActionInfo.shareToFriendUinName) && this.shareToFriendUinType == eCShareActionInfo.shareToFriendUinType;
    }
}

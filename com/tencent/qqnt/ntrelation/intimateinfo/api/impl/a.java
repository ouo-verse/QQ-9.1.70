package com.tencent.qqnt.ntrelation.intimateinfo.api.impl;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/a;", "", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "ntIntimateDetailInfo", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "", "b", "Lcom/tencent/mobileqq/data/Friends;", "friends", "a", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f360078a = new a();

    a() {
    }

    public final boolean a(com.tencent.qqnt.ntrelation.intimateinfo.bean.a ntIntimateDetailInfo, Friends friends) {
        Intrinsics.checkNotNullParameter(ntIntimateDetailInfo, "ntIntimateDetailInfo");
        Intrinsics.checkNotNullParameter(friends, "friends");
        ntIntimateDetailInfo.b();
        if (ntIntimateDetailInfo.b() == null) {
            return false;
        }
        friends.iconFlag = ntIntimateDetailInfo.b();
        return true;
    }

    public final boolean b(com.tencent.qqnt.ntrelation.intimateinfo.bean.a ntIntimateDetailInfo, ExtensionInfo extensionInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ntIntimateDetailInfo, "ntIntimateDetailInfo");
        Intrinsics.checkNotNullParameter(extensionInfo, "extensionInfo");
        if (Integer.MIN_VALUE != ntIntimateDetailInfo.j()) {
            extensionInfo.intimate_type = ntIntimateDetailInfo.j();
            z16 = true;
        } else {
            z16 = false;
        }
        if (Integer.MIN_VALUE != ntIntimateDetailInfo.f()) {
            extensionInfo.intimate_level = ntIntimateDetailInfo.f();
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntIntimateDetailInfo.e()) {
            extensionInfo.intimate_chatDays = ntIntimateDetailInfo.e();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntIntimateDetailInfo.k()) {
            extensionInfo.last_intimate_chatTime = ntIntimateDetailInfo.k();
            z16 = true;
        }
        Boolean o16 = ntIntimateDetailInfo.o();
        if (o16 != null) {
            extensionInfo.isExtinguish = o16.booleanValue();
            z16 = true;
        }
        Boolean p16 = ntIntimateDetailInfo.p();
        if (p16 != null) {
            extensionInfo.isListenTogetherOpen = p16.booleanValue();
            z16 = true;
        }
        com.tencent.mobileqq.mutualmark.info.a aVar = (com.tencent.mobileqq.mutualmark.info.a) extensionInfo.getBusinessData(com.tencent.mobileqq.mutualmark.info.a.class, new Object[0]);
        if (Intrinsics.areEqual(extensionInfo.mutual_marks_store_json, ntIntimateDetailInfo.m())) {
            return z16;
        }
        extensionInfo.mutual_marks_store_json = ntIntimateDetailInfo.m();
        aVar.a(extensionInfo);
        return true;
    }
}

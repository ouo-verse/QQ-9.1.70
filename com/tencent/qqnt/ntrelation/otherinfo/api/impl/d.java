package com.tencent.qqnt.ntrelation.otherinfo.api.impl;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/impl/d;", "", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "ntOtherDetailInfo", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "", "a", "Lcom/tencent/mobileqq/data/SpecialCareInfo;", "specialCareInfo", "b", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f360189a = new d();

    d() {
    }

    public final boolean a(com.tencent.qqnt.ntrelation.otherinfo.bean.a ntOtherDetailInfo, ExtensionInfo extensionInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ntOtherDetailInfo, "ntOtherDetailInfo");
        Intrinsics.checkNotNullParameter(extensionInfo, "extensionInfo");
        if (ntOtherDetailInfo.G() != Integer.MIN_VALUE) {
            extensionInfo.messageEnablePreviewNew = ntOtherDetailInfo.G();
            z16 = true;
        } else {
            z16 = false;
        }
        if (ntOtherDetailInfo.M() != Integer.MIN_VALUE) {
            extensionInfo.messageEnableSoundNew = ntOtherDetailInfo.M();
            z16 = true;
        }
        if (ntOtherDetailInfo.G() != Integer.MIN_VALUE) {
            extensionInfo.messageEnablePreviewNew = ntOtherDetailInfo.G();
            z16 = true;
        }
        if (ntOtherDetailInfo.l() != Integer.MIN_VALUE) {
            extensionInfo.isSharingLocation = ntOtherDetailInfo.l();
            z16 = true;
        }
        Boolean k3 = ntOtherDetailInfo.k();
        if (k3 != null) {
            k3.booleanValue();
            extensionInfo.isAioShortcutBarOpen = Intrinsics.areEqual(ntOtherDetailInfo.k(), Boolean.TRUE);
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.w()) {
            extensionInfo.chatInputType = ntOtherDetailInfo.w();
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.Z()) {
            extensionInfo.showC2CPanel = ntOtherDetailInfo.Z();
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.V()) {
            extensionInfo.pttChangeVoiceType = ntOtherDetailInfo.V();
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.v()) {
            extensionInfo.audioPanelType = ntOtherDetailInfo.v();
            z16 = true;
        }
        Boolean e06 = ntOtherDetailInfo.e0();
        if (e06 != null) {
            e06.booleanValue();
            extensionInfo.isDataChanged = Intrinsics.areEqual(ntOtherDetailInfo.e0(), Boolean.TRUE);
            z16 = true;
        }
        Boolean k16 = ntOtherDetailInfo.k();
        if (k16 != null) {
            k16.booleanValue();
            extensionInfo.isAioShortcutBarOpen = Intrinsics.areEqual(ntOtherDetailInfo.k(), Boolean.TRUE);
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.y()) {
            extensionInfo.hiddenChatSwitch = ntOtherDetailInfo.y();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.E()) {
            extensionInfo.latestPLUpdateTimestamp = ntOtherDetailInfo.E();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.C()) {
            extensionInfo.lastPullPLNewsTimestamp = ntOtherDetailInfo.C();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.B()) {
            extensionInfo.lastPLNewsTimestamp = ntOtherDetailInfo.B();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.A()) {
            extensionInfo.lastIceBreakCheckTs = ntOtherDetailInfo.A();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.z()) {
            extensionInfo.lastIceBreakChatTs = ntOtherDetailInfo.z();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.F()) {
            extensionInfo.makeFrdsTs = ntOtherDetailInfo.F();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.d0()) {
            extensionInfo.topPositionTime = ntOtherDetailInfo.d0();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.c0()) {
            extensionInfo.mTogetherBusinessFlag = ntOtherDetailInfo.c0();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.b()) {
            extensionInfo.colorRingId = ntOtherDetailInfo.b();
            z16 = true;
        }
        if (Long.MIN_VALUE != ntOtherDetailInfo.x()) {
            extensionInfo.commingRingId = ntOtherDetailInfo.x();
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.G()) {
            extensionInfo.messageEnablePreviewNew = ntOtherDetailInfo.G();
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.M()) {
            extensionInfo.messageEnableSoundNew = ntOtherDetailInfo.M();
            z16 = true;
        }
        if (Integer.MIN_VALUE != ntOtherDetailInfo.N()) {
            extensionInfo.messageEnableVibrateNew = ntOtherDetailInfo.N();
            z16 = true;
        }
        if (Long.MIN_VALUE == ntOtherDetailInfo.c()) {
            return z16;
        }
        extensionInfo.friendRingId = (int) ntOtherDetailInfo.c();
        return true;
    }

    public final boolean b(com.tencent.qqnt.ntrelation.otherinfo.bean.a ntOtherDetailInfo, SpecialCareInfo specialCareInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ntOtherDetailInfo, "ntOtherDetailInfo");
        Intrinsics.checkNotNullParameter(specialCareInfo, "specialCareInfo");
        if (ntOtherDetailInfo.e() != Integer.MIN_VALUE) {
            specialCareInfo.specialRingSwitch = ntOtherDetailInfo.e();
            z16 = true;
        } else {
            z16 = false;
        }
        if (ntOtherDetailInfo.f() == Long.MIN_VALUE) {
            return z16;
        }
        specialCareInfo.dateTime = ntOtherDetailInfo.f();
        return true;
    }
}

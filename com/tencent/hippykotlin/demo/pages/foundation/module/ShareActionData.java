package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShareActionData {
    public final boolean directShowShareDialog;
    public final String guildId;
    public final String label;
    public final String uin;
    public final int uinType;

    public ShareActionData() {
        this(null, null, 0, null, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.guildId, QQAudioParams$$ExternalSyntheticOutline0.m(this.uinType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.label, this.uin.hashCode() * 31, 31), 31), 31);
        boolean z16 = this.directShowShareDialog;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShareActionData(uin=");
        m3.append(this.uin);
        m3.append(", label=");
        m3.append(this.label);
        m3.append(", uinType=");
        m3.append(this.uinType);
        m3.append(", guildId=");
        m3.append(this.guildId);
        m3.append(", directShowShareDialog=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.directShowShareDialog, ')');
    }

    public ShareActionData(String str, String str2, int i3, String str3, boolean z16) {
        this.uin = str;
        this.label = str2;
        this.uinType = i3;
        this.guildId = str3;
        this.directShowShareDialog = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareActionData)) {
            return false;
        }
        ShareActionData shareActionData = (ShareActionData) obj;
        return Intrinsics.areEqual(this.uin, shareActionData.uin) && Intrinsics.areEqual(this.label, shareActionData.label) && this.uinType == shareActionData.uinType && Intrinsics.areEqual(this.guildId, shareActionData.guildId) && this.directShowShareDialog == shareActionData.directShowShareDialog;
    }

    public /* synthetic */ ShareActionData(String str, String str2, int i3, String str3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", -1, "", false);
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import q25.f;

/* loaded from: classes31.dex */
public final class NBPPublishStatusData {
    public final String cornerIcon;
    public final String dressKey;
    public final f filamentResource;
    public final String icon;
    public final boolean male;
    public final int motionId;
    public final String motionImage;
    public final int richStatusId;
    public final int statusId;
    public final long tid;
    public final String title;
    public final int uniqueId;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NBPPublishStatusData() {
        this(r2, r2, null, 4095);
        int i3 = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int a16 = d.a(this.tid) * 31;
        boolean z16 = this.male;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.motionImage, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, QQAudioParams$$ExternalSyntheticOutline0.m(this.motionId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, QQAudioParams$$ExternalSyntheticOutline0.m(this.richStatusId, QQAudioParams$$ExternalSyntheticOutline0.m(this.statusId, QQAudioParams$$ExternalSyntheticOutline0.m(this.uniqueId, (a16 + i3) * 31, 31), 31), 31), 31), 31), 31), 31);
        f fVar = this.filamentResource;
        return this.cornerIcon.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.dressKey, (m3 + (fVar == null ? 0 : fVar.hashCode())) * 31, 31);
    }

    public final String toString() {
        return "NBPPublishStatusData(tid=" + this.tid + ", male=" + this.male + ", uniqueId=" + this.uniqueId + ", statusId=" + this.statusId + ", richStatusId=" + this.richStatusId + ", icon=" + this.icon + ", motionId=" + this.motionId + ", title=" + this.title + ", motionImage=" + this.motionImage + ", filamentResource=" + this.filamentResource + ", dressKey=" + this.dressKey + ", cornerIcon=" + this.cornerIcon + ')';
    }

    public NBPPublishStatusData(long j3, boolean z16, int i3, int i16, int i17, String str, int i18, String str2, String str3, f fVar, String str4, String str5) {
        this.tid = j3;
        this.male = z16;
        this.uniqueId = i3;
        this.statusId = i16;
        this.richStatusId = i17;
        this.icon = str;
        this.motionId = i18;
        this.title = str2;
        this.motionImage = str3;
        this.filamentResource = fVar;
        this.dressKey = str4;
        this.cornerIcon = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPPublishStatusData)) {
            return false;
        }
        NBPPublishStatusData nBPPublishStatusData = (NBPPublishStatusData) obj;
        return this.tid == nBPPublishStatusData.tid && this.male == nBPPublishStatusData.male && this.uniqueId == nBPPublishStatusData.uniqueId && this.statusId == nBPPublishStatusData.statusId && this.richStatusId == nBPPublishStatusData.richStatusId && Intrinsics.areEqual(this.icon, nBPPublishStatusData.icon) && this.motionId == nBPPublishStatusData.motionId && Intrinsics.areEqual(this.title, nBPPublishStatusData.title) && Intrinsics.areEqual(this.motionImage, nBPPublishStatusData.motionImage) && Intrinsics.areEqual(this.filamentResource, nBPPublishStatusData.filamentResource) && Intrinsics.areEqual(this.dressKey, nBPPublishStatusData.dressKey) && Intrinsics.areEqual(this.cornerIcon, nBPPublishStatusData.cornerIcon);
    }

    public /* synthetic */ NBPPublishStatusData(int i3, int i16, String str, int i17) {
        this(0L, (i17 & 2) != 0, 0, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? "" : null, 0, (i17 & 128) != 0 ? "" : str, (i17 & 256) != 0 ? "" : null, null, (i17 & 1024) != 0 ? "" : null, (i17 & 2048) != 0 ? "" : null);
    }
}

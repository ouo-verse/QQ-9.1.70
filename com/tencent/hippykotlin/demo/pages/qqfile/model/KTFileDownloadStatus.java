package com.tencent.hippykotlin.demo.pages.qqfile.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class KTFileDownloadStatus {
    public int fileDownloadStatus;
    public float process;

    public KTFileDownloadStatus(float f16, int i3) {
        this.process = f16;
        this.fileDownloadStatus = i3;
    }

    public final int hashCode() {
        return BoxType$EnumUnboxingSharedUtility.ordinal(this.fileDownloadStatus) + (Float.floatToIntBits(this.process) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("KTFileDownloadStatus(process=");
        m3.append(this.process);
        m3.append(", fileDownloadStatus=");
        m3.append(DownloadStatus$EnumUnboxingLocalUtility.stringValueOf(this.fileDownloadStatus));
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTFileDownloadStatus)) {
            return false;
        }
        KTFileDownloadStatus kTFileDownloadStatus = (KTFileDownloadStatus) obj;
        return Float.compare(this.process, kTFileDownloadStatus.process) == 0 && this.fileDownloadStatus == kTFileDownloadStatus.fileDownloadStatus;
    }
}

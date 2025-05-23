package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ImageLoadingTask {
    public final boolean blockShow;
    public final String key;

    public ImageLoadingTask(String str, boolean z16) {
        this.key = str;
        this.blockShow = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        boolean z16 = this.blockShow;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ImageLoadingTask(key=");
        m3.append(this.key);
        m3.append(", blockShow=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.blockShow, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageLoadingTask)) {
            return false;
        }
        ImageLoadingTask imageLoadingTask = (ImageLoadingTask) obj;
        return Intrinsics.areEqual(this.key, imageLoadingTask.key) && this.blockShow == imageLoadingTask.blockShow;
    }
}

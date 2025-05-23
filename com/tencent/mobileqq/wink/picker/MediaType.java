package com.tencent.mobileqq.wink.picker;

import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/MediaType;", "", "(Ljava/lang/String;I)V", "isImage", "", "isLocalMedia", "isQZoneMedia", "isTempCaptured", BaseProfileQZoneComponent.KEY_IS_VIDEO, "LOCAL_ALL", "LOCAL_IMAGE", "LOCAL_VIDEO", "QZONE_ALL", "QZONE_IMAGE", "QZONE_VIDEO", "TEMP_CAPTURED", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum MediaType {
    LOCAL_ALL,
    LOCAL_IMAGE,
    LOCAL_VIDEO,
    QZONE_ALL,
    QZONE_IMAGE,
    QZONE_VIDEO,
    TEMP_CAPTURED;

    public final boolean isImage() {
        if (this != QZONE_IMAGE && this != LOCAL_IMAGE) {
            return false;
        }
        return true;
    }

    public final boolean isLocalMedia() {
        if (this != LOCAL_ALL && this != LOCAL_IMAGE && this != LOCAL_VIDEO) {
            return false;
        }
        return true;
    }

    public final boolean isQZoneMedia() {
        if (this != QZONE_ALL && this != QZONE_IMAGE && this != QZONE_VIDEO) {
            return false;
        }
        return true;
    }

    public final boolean isTempCaptured() {
        if (this == TEMP_CAPTURED) {
            return true;
        }
        return false;
    }

    public final boolean isVideo() {
        if (this != QZONE_VIDEO && this != LOCAL_VIDEO) {
            return false;
        }
        return true;
    }
}

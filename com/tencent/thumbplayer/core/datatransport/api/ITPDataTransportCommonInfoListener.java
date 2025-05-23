package com.tencent.thumbplayer.core.datatransport.api;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPDataTransportCommonInfoListener {
    public static final int COMMON_INFO_TYPE_DID_RELEASE_MEMORY = 3;
    public static final int COMMON_INFO_TYPE_NATIVE_CONFIG = 0;
    public static final int COMMON_INFO_TYPE_QUIC_QUALITY_REPORT_UPDATE = 1;
    public static final int COMMON_INFO_TYPE_WILL_RELEASE_MEMORY = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface CommonInfoType {
    }

    void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo);
}

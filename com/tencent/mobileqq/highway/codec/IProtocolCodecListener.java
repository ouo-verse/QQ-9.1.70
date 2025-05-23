package com.tencent.mobileqq.highway.codec;

import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import java.util.List;

/* loaded from: classes9.dex */
public interface IProtocolCodecListener {

    /* loaded from: classes9.dex */
    public interface CODEC_ERROR_CODE {
        public static final int DECODE_DATA_EXCEED = 1;
        public static final int DECODE_DATA_INVALID_FORMAT = 2;
    }

    void onDecodeInvalidData(int i3);

    void onDecodeSucessfully(List<HwResponse> list);

    void onEncodePkgError(HwRequest hwRequest, int i3);
}

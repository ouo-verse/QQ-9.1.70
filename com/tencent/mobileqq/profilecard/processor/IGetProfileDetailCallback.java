package com.tencent.mobileqq.profilecard.processor;

import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes16.dex */
public interface IGetProfileDetailCallback {
    void onGetProfileDetailRequestForLogin(List<Short> list);

    void onGetProfileDetailResponseBegin(Bundle bundle);

    void onGetProfileDetailResponseEnd(Bundle bundle, boolean z16, Card card);

    void onGetProfileDetailTLV(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer);

    void onGetProfileDetailTLVBegin(Bundle bundle, long j3, Card card);

    void onGetProfileDetailTLVEnd(Bundle bundle, long j3, Card card);

    void requestParseProfileLocation(Card card);
}

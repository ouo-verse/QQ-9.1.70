package com.tencent.mobileqq.qwallet;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletPayApi extends QRouteApi {

    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f277003a;

        /* renamed from: b, reason: collision with root package name */
        public int f277004b;

        /* renamed from: c, reason: collision with root package name */
        public int f277005c;

        /* renamed from: d, reason: collision with root package name */
        public String f277006d;

        /* renamed from: e, reason: collision with root package name */
        public String f277007e;

        /* renamed from: f, reason: collision with root package name */
        public long f277008f;

        /* renamed from: g, reason: collision with root package name */
        public long f277009g;

        /* renamed from: h, reason: collision with root package name */
        public int f277010h = 0;
    }

    void clearAllPayData();

    a getIdlePayData(boolean z16);

    int getIdlePayDataCount();

    int getPayBridgeCode(int i3);

    void onQQForeground(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void removePayingData();
}

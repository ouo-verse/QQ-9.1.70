package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import qshadow.QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public final /* synthetic */ class d implements w93.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WinkDataServiceHandler f318424a;

    public /* synthetic */ d(WinkDataServiceHandler winkDataServiceHandler) {
        this.f318424a = winkDataServiceHandler;
    }

    @Override // w93.a
    public final void a(boolean z16, long j3, String str, BaseRequest baseRequest, MessageMicro messageMicro) {
        WinkDataServiceHandler.H2(this.f318424a, z16, j3, str, baseRequest, (QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp) messageMicro);
    }
}

package com.tencent.qqlive.module.videoreport.dtreport.api;

import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider;

/* loaded from: classes22.dex */
public interface IDTParamProvider extends IDTUserInfoProvider, IDTAppInfoProvider, IDTVisitProvider, IEventDynamicParams {
    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    /* synthetic */ String getAccountID();

    /* synthetic */ String getActiveInfo();

    /* synthetic */ String getAdCode();

    /* synthetic */ String getCallFrom();

    /* synthetic */ String getCallScheme();

    /* synthetic */ String getFactoryChannelId();

    /* synthetic */ String getGuid();

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    /* synthetic */ String getMainLogin();

    /* synthetic */ String getModifyChannelId();

    /* synthetic */ String getOaid();

    /* synthetic */ String getOmgbzid();

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    /* synthetic */ String getQQ();

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    /* synthetic */ String getQQOpenID();

    /* synthetic */ String getSIMType();

    @IDTVisitProvider.StartType
    /* synthetic */ int getStartType();

    /* synthetic */ String getTid();

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    /* synthetic */ String getWbOpenID();

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    /* synthetic */ String getWxOpenID();

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    /* synthetic */ String getWxUnionID();
}

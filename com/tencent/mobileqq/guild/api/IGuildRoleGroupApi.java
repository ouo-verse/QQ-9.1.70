package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildRoleGroupApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a(IGProGuildRoleInfo iGProGuildRoleInfo);
    }

    boolean getIsOperate(IGProGuildInfo iGProGuildInfo, int i3);

    boolean getIsVisitorOperate(IGProGuildInfo iGProGuildInfo, int i3);

    void getLevelRoleInfo(String str, String str2, String str3, a aVar);

    boolean getVisibleForVisitor(IGProGuildInfo iGProGuildInfo);
}

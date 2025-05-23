package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.guild.message.base.o;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMessageCallbackRegister extends QRouteApi {
    ArrayList<Class<? extends o>> getUniteGrayTipNotifyPushCheckerList();
}

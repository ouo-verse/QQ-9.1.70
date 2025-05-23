package com.tencent.mobileqq.filemanager.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileIPv6StrateyController extends QRouteApi {
    int debugGetLocalConfigIPv6Strategy();

    boolean debugIsLocalConfigEnableC2CIPv6();

    boolean debugIsLocalConfigEnableDatalineIPv6();

    boolean debugIsLocalConfigEnableDiscIPv6();

    boolean debugIsLocalConfigEnableGroupIPv6();

    boolean debugIsUseLocalConfig();

    void debugSetLocalConfigEnableC2CIPv6(boolean z16);

    void debugSetLocalConfigEnableDatalineIPv6(boolean z16);

    void debugSetLocalConfigEnableDiscIPv6(boolean z16);

    void debugSetLocalConfigEnableGroupIPv6(boolean z16);

    void debugSetLocalConfigIPv6Strategy(int i3);

    void debugSetUseLocalConfig(boolean z16);

    List<ExcitingTransferHostInfo> getIPV6listForExcitingUpload(BaseQQAppInterface baseQQAppInterface, int i3);

    List<String> getIPV6listForMediaPlatfrom(BaseQQAppInterface baseQQAppInterface, int i3, List<String> list);

    d.c getIPlistForV6Domain(BaseQQAppInterface baseQQAppInterface, d.a aVar, int i3);

    boolean isConfigEnableIPV6(BaseQQAppInterface baseQQAppInterface, int i3);
}

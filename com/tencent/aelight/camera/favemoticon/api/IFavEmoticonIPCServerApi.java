package com.tencent.aelight.camera.favemoticon.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes3.dex */
public interface IFavEmoticonIPCServerApi extends QRouteApi {
    public static final String MODULE_NAME_FAV_EMOTICON = "FavEmoticonQIPCModule";

    QIPCModule getFavEmoticonIPCModule();
}

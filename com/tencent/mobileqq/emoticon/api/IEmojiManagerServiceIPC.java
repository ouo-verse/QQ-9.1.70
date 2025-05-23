package com.tencent.mobileqq.emoticon.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmojiManagerServiceIPC extends QRouteApi {
    public static final String MODULE_NAME = "EmojiManagerServiceQIPC";
    public static final String TAG = "EmojiManagerServiceQIPC";

    /* loaded from: classes12.dex */
    public interface AddMarketEmoticonToFavoriteCallback {
        void onResult(int i3);
    }

    void addMarketEmoticonToFavorite(String str, String str2, boolean z16, AddMarketEmoticonToFavoriteCallback addMarketEmoticonToFavoriteCallback);

    QIPCModule createModule();
}

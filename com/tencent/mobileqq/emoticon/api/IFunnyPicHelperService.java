package com.tencent.mobileqq.emoticon.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFunnyPicHelperService extends QRouteApi {
    void checkLoadEmotionPic(Context context, List<CustomEmotionData> list, BaseQQAppInterface baseQQAppInterface, IPicDownloadListener iPicDownloadListener);

    void checkLoadEmotionPic(boolean z16, Context context, List<CustomEmotionData> list, AppInterface appInterface, IPicDownloadListener iPicDownloadListener);

    AbsDownloader createFunnyPicDownloader();

    void resolveFunnyPicJson(AppInterface appInterface);
}

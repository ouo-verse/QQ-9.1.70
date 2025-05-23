package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IMarketFaceDiffApi extends QRouteApi {
    void authDownloadEmoticonByFav(String str, String str2);

    void bindView(long j3, ImageView imageView, String str, IPicEmoticonInfo iPicEmoticonInfo, boolean z16);

    boolean isSupportMagicFace();

    void openEmoMarket(Context context, String str, int i3, String str2, boolean z16);

    void syncUpload(Context context, CustomEmotionData customEmotionData);

    boolean verifyMagicFacePackageIntact(String str);
}

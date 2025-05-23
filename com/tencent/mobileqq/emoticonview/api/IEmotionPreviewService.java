package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmotionPreviewService extends QRouteApi {
    IPreviewThumbAdapter createPreviewThumbAdapter(Context context, IPreviewThumbAdapter.IThumbItemClickListener iThumbItemClickListener);
}

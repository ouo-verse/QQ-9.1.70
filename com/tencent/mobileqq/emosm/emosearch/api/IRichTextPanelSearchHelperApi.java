package com.tencent.mobileqq.emosm.emosearch.api;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.emosearch.c;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.panel.d;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes6.dex */
public interface IRichTextPanelSearchHelperApi extends QRouteApi {
    IEmotionHotPicSearchAdapter createSearchAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback);

    c createSearchHelper(IPanelInteractionListener iPanelInteractionListener, Context context, d dVar);
}

package com.tencent.mobileqq.emosm.emosearch.api.impl;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi;
import com.tencent.mobileqq.emosm.emosearch.c;
import com.tencent.mobileqq.emosm.emosearch.e;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.panel.d;

/* loaded from: classes6.dex */
public class RichTextPanelSearchHelperApiImpl implements IRichTextPanelSearchHelperApi {
    @Override // com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi
    public IEmotionHotPicSearchAdapter createSearchAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        return new EmotionHotPicSearchAdapter(iEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonCallback);
    }

    @Override // com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi
    public c createSearchHelper(IPanelInteractionListener iPanelInteractionListener, Context context, d dVar) {
        return new e(iPanelInteractionListener, context, dVar);
    }
}

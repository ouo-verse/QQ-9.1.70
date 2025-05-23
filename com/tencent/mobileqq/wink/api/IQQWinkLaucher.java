package com.tencent.mobileqq.wink.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IQQWinkLaucher extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public enum WinkHomePageType {
        TYPE_COLLECTION_PICKER,
        TYPE_UNIVERSAL_PICKER
    }

    void jumpToWinkAIAvatarMainFragment(Context context, Intent intent);

    void jumpToWinkEditor(Context context, Bundle bundle);

    void jumpToWinkEditorWithCompressMedia(Context context, Bundle bundle, b bVar);

    void jumpToWinkPreview(Context context, Bundle bundle);

    void jumpToWinkTemplateFeed(Context context, Intent intent);

    boolean preloadWebView(String str, boolean z16);
}

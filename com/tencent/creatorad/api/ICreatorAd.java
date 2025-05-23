package com.tencent.creatorad.api;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface ICreatorAd extends QRouteApi {
    void instanceAd(String str, int i3, ViewGroup viewGroup, @Nullable ViewGroup.LayoutParams layoutParams);

    void notifyBannerParentStatus(ViewGroup viewGroup, int i3, int i16);

    void preloadAdList(List<String> list, int i3);

    void startCreatorAdDemoFragment(Activity activity);
}

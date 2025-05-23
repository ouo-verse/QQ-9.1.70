package com.tencent.mobileqq.wxmini.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWxMiniHostSceneManager extends QRouteApi {
    int combine(String str, String str2, String str3, int i3);

    int convertFromRefer(int i3);

    int formatHostScene(@Nullable String str, int i3);

    String formatShareGuildFeedsUrl(String str);

    int transformDropDownHostScene(int i3, boolean z16, int i16);
}

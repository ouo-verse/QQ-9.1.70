package com.tencent.qzonehub.api.utils;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneGroupAlbumArkUtil extends QRouteApi {
    boolean handleGroupArkUrl(Context context, String str);

    boolean isFromGroupAlbumArk(String str, String str2, String str3);

    boolean isFromShortcutUrl(long j3);

    void jumpToGroupAlbumEntry(Context context, String str);
}

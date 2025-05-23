package com.tencent.mobileqq.vas.handler.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IClubContentUpdateHandler extends QRouteApi {
    void checkJsonVersion(Context context);

    void saveQVIPResConfigContent(String str);
}

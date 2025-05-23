package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IScreenAnimationRedTouchHelper extends QRouteApi {
    boolean downloadFile(String str, File file);

    long getLebaListItemResId(Object obj);
}

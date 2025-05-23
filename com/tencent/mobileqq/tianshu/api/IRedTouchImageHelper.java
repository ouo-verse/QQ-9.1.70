package com.tencent.mobileqq.tianshu.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IRedTouchImageHelper extends QRouteApi {
    View getApngImageView(String str, Context context);
}

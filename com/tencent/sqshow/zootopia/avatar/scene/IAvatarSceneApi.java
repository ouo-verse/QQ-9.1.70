package com.tencent.sqshow.zootopia.avatar.scene;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/scene/IAvatarSceneApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "currentViewType", "", "enterFirstFrame", "", "viewType", "isSameViewType", "", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes34.dex */
public interface IAvatarSceneApi extends QRouteApi {
    int currentViewType();

    void enterFirstFrame(int viewType);

    boolean isSameViewType(int viewType);
}

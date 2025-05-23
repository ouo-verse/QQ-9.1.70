package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IRelationFriendsSearchHelper extends QRouteApi {
    ArrayList<Object> search(String str, AppInterface appInterface);
}

package com.tencent.mobileqq.troop.troopcreate.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IRelationFriendsTroopViewHelper extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        ArrayList<ResultRecord> a();

        ArrayList<String> b();

        void c();
    }
}

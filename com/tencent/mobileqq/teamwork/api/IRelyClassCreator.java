package com.tencent.mobileqq.teamwork.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IRelyClassCreator extends QRouteApi {
    ISimpleTextView getSimpleTextViewImpl(Context context);

    a getTeamWorkFileImportForH5(Object obj, AppInterface appInterface);

    a getTeamWorkFileImportJobForC2C(Object obj, AppInterface appInterface);

    a getTeamWorkFileImportJobForDisc(Object obj, AppInterface appInterface);

    a getTeamWorkFileImportJobForGroup(Object obj, AppInterface appInterface);

    JSONObject queryFileEntityInfo(Object obj, AppInterface appInterface);
}

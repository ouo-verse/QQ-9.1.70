package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITDocAIOImportFacade extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(boolean z16, int i3, String str);

        void b();
    }

    void cancelImport(Context context);

    void getConnectCookie(Activity activity, IGetExternalInterface.d dVar);

    boolean isAIOImportEnable();

    void reportSaveToTencentDocs(String str, Map<String, Object> map);

    void saveToTencentDocs(Activity activity, int i3, String str, String str2, List<AIOMsgItem> list, a aVar);
}

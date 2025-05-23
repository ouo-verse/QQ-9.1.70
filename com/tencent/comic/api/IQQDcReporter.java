package com.tencent.comic.api;

import android.content.Context;
import com.tencent.comic.data.e;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQDcReporter extends QRouteApi {
    String getColdStartImei(Context context);

    @Deprecated
    String getImei(Context context);

    String getQimei();

    void reportDC00145(AppInterface appInterface, String str, Context context, String str2, String str3, String str4, String str5, String... strArr);

    void reportDC00145(AppInterface appInterface, String str, String str2, String str3, String str4, String... strArr);

    void reportDC00145_2(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String... strArr);

    void reportDC00145_3(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String... strArr);

    void reportDC01327(AppInterface appInterface, e eVar);

    void reportDCEvent(BaseQQAppInterface baseQQAppInterface, String str, List<String> list);

    void reportDCSqliteProfile(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, String... strArr);

    void reportTechReport2021(String str);

    void reportVasStatus(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, String str5);
}

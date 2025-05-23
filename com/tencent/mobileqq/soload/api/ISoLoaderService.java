package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISoLoaderService extends QRouteApi {
    void download(String str, OnLoadListener onLoadListener);

    void download(String[] strArr, OnLoadListener onLoadListener);

    List<String> getCurInitSoList();

    String getInitVer(String str);

    String getSoVer(String str);

    void load(String str, OnLoadListener onLoadListener);

    void loadSequentially(String[] strArr, OnLoadListener onLoadListener, LoadOptions[] loadOptionsArr);

    LoadExtResult loadSequentiallySync(String[] strArr, LoadOptions[] loadOptionsArr);

    LoadExtResult loadSync(String str, LoadOptions loadOptions);

    void reportRlFolderNotExists(String str, String str2, int i3);
}

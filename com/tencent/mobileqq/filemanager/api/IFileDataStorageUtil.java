package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileDataStorageUtil extends QRouteApi {
    boolean getBool(AppRuntime appRuntime, String str, boolean z16);

    int getInt(AppRuntime appRuntime, String str, int i3);

    String getString(AppRuntime appRuntime, String str, String str2);

    void putBool(AppRuntime appRuntime, String str, boolean z16);

    void putInt(AppRuntime appRuntime, String str, int i3);

    void putString(AppRuntime appRuntime, String str, String str2);
}

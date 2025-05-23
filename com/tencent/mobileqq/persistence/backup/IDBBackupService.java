package com.tencent.mobileqq.persistence.backup;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IDBBackupService extends QRouteApi {
    void backupDBMaster(AppRuntime appRuntime);
}

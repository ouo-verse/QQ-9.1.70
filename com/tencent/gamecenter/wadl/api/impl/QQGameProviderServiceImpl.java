package com.tencent.gamecenter.wadl.api.impl;

import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes6.dex */
public class QQGameProviderServiceImpl implements IQQGameProviderService {
    private static final String TAG = "Wadl_QQGameProviderServiceImpl";
    private rl0.b tgpaProvider;
    private rl0.a wadlMiniProvider;

    @Override // com.tencent.gamecenter.wadl.api.IQQGameProviderService
    public int delete(Uri uri, String str, String[] strArr) {
        QLog.d(TAG, 1, "delete uri=" + uri);
        if (IQQGameProviderService.PATH_TGPA_RES_TASK.equals(uri.getPath())) {
            if (this.tgpaProvider == null) {
                this.tgpaProvider = new rl0.b();
            }
            return this.tgpaProvider.d(uri, str, strArr);
        }
        return -6;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameProviderService
    public boolean notifyInstall(String str) {
        if (this.wadlMiniProvider == null) {
            this.wadlMiniProvider = new rl0.a();
        }
        return this.wadlMiniProvider.c(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.d(TAG, 1, "onCreate appRuntime=" + appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.d(TAG, 1, "onDestroy...");
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameProviderService
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) {
        QLog.d(TAG, 1, "openFile uri=" + uri + ",mode=" + str);
        if (IQQGameProviderService.PATH_TGPA_RES_TASK.equals(uri.getPath())) {
            if (this.tgpaProvider == null) {
                this.tgpaProvider = new rl0.b();
            }
            return this.tgpaProvider.g(uri, str);
        }
        if (IQQGameProviderService.PATH_MINI_APP.equals(uri.getPath())) {
            if (this.wadlMiniProvider == null) {
                this.wadlMiniProvider = new rl0.a();
            }
            return this.wadlMiniProvider.d(uri, str);
        }
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameProviderService
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        QLog.d(TAG, 1, "query uri = " + uri);
        if (IQQGameProviderService.PATH_TGPA_RES_TASK.equals(uri.getPath())) {
            if (this.tgpaProvider == null) {
                this.tgpaProvider = new rl0.b();
            }
            return this.tgpaProvider.i(uri, strArr, str, strArr2, str2);
        }
        if (IQQGameProviderService.PATH_MINI_APP.equals(uri.getPath())) {
            if (this.wadlMiniProvider == null) {
                this.wadlMiniProvider = new rl0.a();
            }
            return this.wadlMiniProvider.e(uri, strArr, str, strArr2, str2);
        }
        return null;
    }
}

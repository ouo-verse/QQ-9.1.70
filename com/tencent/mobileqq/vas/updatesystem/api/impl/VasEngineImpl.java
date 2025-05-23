package com.tencent.mobileqq.vas.updatesystem.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import mqq.app.AppRuntime;
import sw4.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasEngineImpl implements IVasEngine {
    private static final String TAG = "VasUpdate_VasUpdateEngineV2";
    private r33.b mNewEngine;

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasEngine
    public void cancelDwonloadItem(long j3, String str) {
        r33.b bVar = this.mNewEngine;
        if (bVar != null && bVar.d(j3) != null) {
            bVar.d(j3).cancelDownload(str);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasEngine
    public void downloadGatherItem(long j3, String str, String[] strArr, String str2) {
        r33.b bVar = this.mNewEngine;
        if (bVar != null && bVar.d(j3) != null) {
            for (String str3 : strArr) {
                bVar.d(j3).startDownload(new BusinessUpdateParams(j3, str3, str2));
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasEngine
    public void downloadItem(long j3, String str, String str2) {
        r33.b bVar = this.mNewEngine;
        if (bVar != null && bVar.d(j3) != null) {
            bVar.d(j3).startDownload(new BusinessUpdateParams(j3, str, str2));
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasEngine
    public <T extends IBusinessCallback> T getBusinessCallback(Class<T> cls) {
        r33.b bVar = this.mNewEngine;
        if (bVar != null) {
            return (T) bVar.e(cls);
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mNewEngine = r33.b.l();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasEngine
    public void queryItemVersion(final int i3, final String str, boolean z16, final QueryItemVersionCallback queryItemVersionCallback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.api.impl.VasEngineImpl.1
            @Override // java.lang.Runnable
            public void run() {
                c dbManager = VasUpdateWrapper.getDbManager();
                if (dbManager != null && (dbManager instanceof com.tencent.mobileqq.vas.updatesystem.impl.b) && queryItemVersionCallback != null) {
                    String b16 = ((com.tencent.mobileqq.vas.updatesystem.impl.b) dbManager).b(0, CommonUtil.sComposeItemId(i3, str));
                    if (QLog.isColorLevel()) {
                        QLog.i(VasEngineImpl.TAG, 2, "queryItemVersion bid = " + i3 + " , scid = " + str);
                    }
                    if (TextUtils.isEmpty(b16)) {
                        queryItemVersionCallback.onQueryItemVer(false, str, "");
                        return;
                    }
                    try {
                        ItemLocalVerPrt parseJsonToItemLocalVerPrt = ItemLocalVerPrt.parseJsonToItemLocalVerPrt(b16);
                        if (parseJsonToItemLocalVerPrt == null) {
                            queryItemVersionCallback.onQueryItemVer(false, str, "");
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(VasEngineImpl.TAG, 2, "queryItemVersion bid = " + i3 + " , scid = " + str + ", md5:" + parseJsonToItemLocalVerPrt.mMd5);
                        }
                        queryItemVersionCallback.onQueryItemVer(true, str, parseJsonToItemLocalVerPrt.mMd5);
                        return;
                    } catch (NoSuchMethodError e16) {
                        QLog.e(VasEngineImpl.TAG, 1, "error happened:" + e16);
                        queryItemVersionCallback.onQueryItemVer(false, str, "");
                        return;
                    }
                }
                QLog.e(VasEngineImpl.TAG, 1, "setWeakHandler cmdManager == null or != VasCmdImpl or callback == null");
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasEngine
    public void startUpdateAllItem() {
        r33.b bVar = this.mNewEngine;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}

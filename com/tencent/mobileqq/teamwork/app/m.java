package com.tencent.mobileqq.teamwork.app;

import android.text.TextUtils;
import com.tencent.localedit.fakenative.packages.ResourcePackage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m extends ResourcePackage {
    @Override // com.tencent.localedit.fakenative.packages.ResourcePackage
    @Nullable
    public String j(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("OfflineResourcePackage", 1, "getResourceDownloadUrl docsType is empty");
            return null;
        }
        return ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getConfig().F.get(str);
    }
}

package com.tencent.mobileqq.avatar.impl;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.IQQAvatarUpdateAvatarUtilsApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarMagicAvatarUtilsApi;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarIpcUpdateAvatarUtilsApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JL\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/avatar/impl/QQAvatarUpdateAvatarUtilsApiImpl;", "Lcom/tencent/mobileqq/avatar/IQQAvatarUpdateAvatarUtilsApi;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getAppInterface", "", "path", "", "syncQzone", "Lcom/tencent/mobileqq/avatar/IQQAvatarUpdateAvatarUtilsApi$a;", "callback", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "extensionInfoMap", "", "setUserAvatar", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQAvatarUpdateAvatarUtilsApiImpl implements IQQAvatarUpdateAvatarUtilsApi {
    private final QQAppInterface getAppInterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.avatar.IQQAvatarUpdateAvatarUtilsApi
    public void setUserAvatar(String path, boolean syncQzone, IQQAvatarUpdateAvatarUtilsApi.a callback, HashMap<String, Serializable> extensionInfoMap) {
        QQAppInterface appInterface = getAppInterface();
        if (appInterface != null) {
            Intent intent = new Intent();
            intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_MINI_APP");
            IQQAvatarMagicAvatarUtilsApi iQQAvatarMagicAvatarUtilsApi = (IQQAvatarMagicAvatarUtilsApi) QRoute.api(IQQAvatarMagicAvatarUtilsApi.class);
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            iQQAvatarMagicAvatarUtilsApi.setSyncQzoneSwitch(application, syncQzone);
            intent.putExtra(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, syncQzone);
            if (extensionInfoMap != null) {
                intent.putExtra("PhotoConst.EXT_INFO", extensionInfoMap);
            }
            ProfileCardUtil.a j06 = ProfileCardUtil.j0(appInterface, path, intent, true);
            if (j06.f306430a == 0) {
                if (callback != null) {
                    IQQAvatarUpdateAvatarUtilsApi.a.C7430a.a(callback, true, null, 2, null);
                }
            } else if (callback != null) {
                callback.onResult(false, j06.f306431b);
            }
        }
    }
}

package com.tencent.mobileqq.qqecommerce.base.account;

import android.text.TextUtils;
import com.tencent.ecommerce.base.account.api.IECAccountManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/account/a;", "Lcom/tencent/ecommerce/base/account/api/IECAccountManager;", "", "getCurrentAccount", "", "getCurrentAccountNickName", "getCurrentAccountHeadUrl", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements IECAccountManager {
    @Override // com.tencent.ecommerce.base.account.api.IECAccountManager
    public long getCurrentAccount() {
        return ECRuntimeManager.INSTANCE.e();
    }

    @Override // com.tencent.ecommerce.base.account.api.IECAccountManager
    public String getCurrentAccountHeadUrl() {
        String replaceBeforeLast$default;
        ECRuntimeManager.Companion companion = ECRuntimeManager.INSTANCE;
        String valueOf = String.valueOf(companion.e());
        AppRuntime c16 = companion.c();
        IQQAvatarDataService iQQAvatarDataService = c16 != null ? (IQQAvatarDataService) c16.getRuntimeService(IQQAvatarDataService.class, "") : null;
        Setting qQHeadSettingFromDB = iQQAvatarDataService != null ? iQQAvatarDataService.getQQHeadSettingFromDB(valueOf) : null;
        if (qQHeadSettingFromDB == null || TextUtils.isEmpty(qQHeadSettingFromDB.url)) {
            return "";
        }
        String url = ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).get1080QQHeadDownLoadUrl(qQHeadSettingFromDB.url, qQHeadSettingFromDB.bFaceFlags);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        replaceBeforeLast$default = StringsKt__StringsKt.replaceBeforeLast$default(url, "/", "https://q.qlogo.cn", (String) null, 4, (Object) null);
        return replaceBeforeLast$default;
    }

    @Override // com.tencent.ecommerce.base.account.api.IECAccountManager
    public String getCurrentAccountNickName() {
        ECRuntimeManager.Companion companion = ECRuntimeManager.INSTANCE;
        String valueOf = String.valueOf(companion.e());
        AppRuntime c16 = companion.c();
        IFriendDataService iFriendDataService = c16 != null ? (IFriendDataService) c16.getRuntimeService(IFriendDataService.class, "all") : null;
        Friends friend = iFriendDataService != null ? iFriendDataService.getFriend(valueOf, true, true, true) : null;
        String friendName = friend != null ? friend.getFriendName() : null;
        return friendName == null ? "QQEcommerce" : friendName;
    }
}

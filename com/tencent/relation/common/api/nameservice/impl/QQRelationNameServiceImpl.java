package com.tencent.relation.common.api.nameservice.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.relation.common.bean.nameservice.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/relation/common/api/nameservice/impl/QQRelationNameServiceImpl;", "Lcom/tencent/relation/common/api/nameservice/IQQRelationNameService;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "friendsSimpleInfo", "", "getAliasFirst", "getDefaultName", "Lcom/tencent/relation/common/bean/nameservice/a;", "configBlock", "nameWithConfig", "Lcom/tencent/qqnt/kernel/api/y;", "getProfileService", "<init>", "()V", "Companion", "a", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QQRelationNameServiceImpl implements IQQRelationNameService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "QQRelationNameServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/relation/common/api/nameservice/impl/QQRelationNameServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.relation.common.api.nameservice.impl.QQRelationNameServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQRelationNameServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String getAliasFirst(d friendsSimpleInfo) {
        String x16 = friendsSimpleInfo.x();
        if (!TextUtils.isEmpty(friendsSimpleInfo.c())) {
            return friendsSimpleInfo.c();
        }
        return x16;
    }

    private final String getDefaultName(d friendsSimpleInfo) {
        String r16 = friendsSimpleInfo.r();
        if (!TextUtils.isEmpty(r16)) {
            return r16;
        }
        String p16 = friendsSimpleInfo.p();
        if (!TextUtils.isEmpty(p16)) {
            return p16;
        }
        String x16 = friendsSimpleInfo.x();
        if (TextUtils.isEmpty(x16)) {
            return null;
        }
        return x16;
    }

    @Override // com.tencent.relation.common.api.nameservice.IQQRelationNameService
    @Nullable
    public y getProfileService() {
        IKernelService iKernelService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (y) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getProfileService();
        }
        return null;
    }

    @Override // com.tencent.relation.common.api.nameservice.IQQRelationNameService
    @Nullable
    public String nameWithConfig(@NotNull a configBlock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) configBlock);
        }
        Intrinsics.checkNotNullParameter(configBlock, "configBlock");
        String b16 = configBlock.b();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(b16);
        ArrayList<d> friendSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendSimpleInfoWithUid(arrayList, "QQRelationNameServiceImpl");
        if (friendSimpleInfoWithUid != null && friendSimpleInfoWithUid.size() != 0) {
            d dVar = friendSimpleInfoWithUid.get(0);
            if (dVar == null) {
                return "";
            }
            int a16 = configBlock.a();
            if (a16 != 0) {
                if (a16 != 1) {
                    return null;
                }
                return getAliasFirst(dVar);
            }
            return getDefaultName(dVar);
        }
        return ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(b16);
    }
}

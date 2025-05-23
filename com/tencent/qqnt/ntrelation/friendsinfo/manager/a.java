package com.tencent.qqnt.ntrelation.friendsinfo.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00062\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001c\u0010\u000e\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/a;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "userSimpleInfoMap", "", "e", "profiles", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "statusInfo", "a", "statusMap", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "userDetailInfo", "c", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360048a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f360048a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(HashMap<String, UserSimpleInfo> userSimpleInfoMap) {
        ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> arrayList = new ArrayList<>();
        Collection<UserSimpleInfo> values = userSimpleInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "userSimpleInfoMap.values");
        for (UserSimpleInfo userSimpleInfo : values) {
            if (userSimpleInfo.coreInfo != null || userSimpleInfo.baseInfo != null || userSimpleInfo.relationFlags != null) {
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                String str = userSimpleInfo.uid;
                Intrinsics.checkNotNullExpressionValue(str, "userSimpleInfo.uid");
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(str, "SimpleInfoDispatchManager");
                if (friendsSimpleInfoWithUid == null) {
                    return;
                } else {
                    c.f360050a.t(friendsSimpleInfoWithUid);
                }
            }
            if (userSimpleInfo.vasInfo != null) {
                IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
                String str2 = userSimpleInfo.uid;
                Intrinsics.checkNotNullExpressionValue(str2, "userSimpleInfo.uid");
                NTVasSimpleInfo vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(str2, "SimpleInfoDispatchManager");
                if (vasSimpleInfoWithUid == null) {
                    return;
                } else {
                    lx3.a.f415742a.d(vasSimpleInfoWithUid);
                }
            }
            if (userSimpleInfo.intimate != null) {
                IIntimateInfoService iIntimateInfoService = (IIntimateInfoService) QRoute.api(IIntimateInfoService.class);
                String str3 = userSimpleInfo.uid;
                Intrinsics.checkNotNullExpressionValue(str3, "userSimpleInfo.uid");
                com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = iIntimateInfoService.getIntimateSimpleInfoWithUid(str3, "SimpleInfoDispatchManager");
                if (intimateSimpleInfoWithUid == null) {
                    return;
                } else {
                    arrayList.add(intimateSimpleInfoWithUid);
                }
            }
            if (userSimpleInfo.otherFlags != null) {
                IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
                String str4 = userSimpleInfo.uid;
                Intrinsics.checkNotNullExpressionValue(str4, "userSimpleInfo.uid");
                com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = iOtherInfoService.getOtherSimpleInfoWithUid(str4, "SimpleInfoDispatchManager");
                if (otherSimpleInfoWithUid == null) {
                    return;
                } else {
                    com.tencent.qqnt.ntrelation.otherinfo.manager.a.f360224a.d(otherSimpleInfoWithUid);
                }
            }
            StatusInfo statusInfo = userSimpleInfo.status;
            if (statusInfo != null) {
                f360048a.a(statusInfo);
            }
        }
        if (!arrayList.isEmpty()) {
            com.tencent.qqnt.ntrelation.intimateinfo.manager.a.f360090a.b(arrayList);
        }
    }

    public final void a(@Nullable StatusInfo statusInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) statusInfo);
            return;
        }
        if (statusInfo == null) {
            return;
        }
        String str = statusInfo.uid;
        if (str == null) {
            str = "";
        }
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c(str, String.valueOf(statusInfo.uin));
        com.tencent.qqnt.ntrelation.util.j.f360277a.d("SimpleInfoDispatchManager", statusInfo, cVar);
        com.tencent.qqnt.ntrelation.onlinestatusinfo.manager.a.f360174a.c(cVar);
    }

    public final void b(@Nullable HashMap<String, StatusInfo> statusMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) statusMap);
        } else {
            if (statusMap == null) {
                return;
            }
            Iterator<StatusInfo> it = statusMap.values().iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    public final void c(@Nullable UserDetailInfo userDetailInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) userDetailInfo);
        }
    }

    public final void d(@Nullable HashMap<String, UserSimpleInfo> profiles) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) profiles);
        } else {
            if (profiles == null) {
                return;
            }
            e(profiles);
        }
    }
}

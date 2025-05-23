package com.tencent.mobileqq.pluspanel;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/pluspanel/b;", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "Lmqq/app/AppRuntime;", "appInterface", "", "", "a", "getRedPointPaths", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<String> a(AppRuntime appInterface) {
        boolean z16;
        boolean z17;
        HashSet hashSet = new HashSet();
        try {
            List<Integer> c2CRedDotIdList = ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getC2CRedDotIdList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : c2CRedDotIdList) {
                if (((Number) obj).intValue() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(String.valueOf(((Number) it.next()).intValue()));
            }
            if (appInterface instanceof QQAppInterface) {
                List<TroopAIOAppInfo> appInfoList = ((ITroopAioAppService) appInterface.getRuntimeService(ITroopAioAppService.class, "")).getAllAppsFromCache();
                Intrinsics.checkNotNullExpressionValue(appInfoList, "appInfoList");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : appInfoList) {
                    if (((TroopAIOAppInfo) obj2).appid > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList2.add(obj2);
                    }
                }
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    hashSet.add(String.valueOf(((TroopAIOAppInfo) it5.next()).appid));
                }
            }
        } catch (Throwable th5) {
            QLog.e("PlusPanelRedPointAppIdInterface", 1, th5, new Object[0]);
        }
        return new ArrayList(hashSet);
    }

    @Override // com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
    @NotNull
    public List<String> getRedPointPaths(@NotNull AppRuntime appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        if (QLog.isColorLevel()) {
            QLog.d("PlusPanelRedPointAppIdInterface", 2, "getRedPointPaths");
        }
        return a(appInterface);
    }
}

package com.tencent.qqnt.chats.filter;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactModuleShieldInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/filter/a;", "Llw3/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactModuleShieldInfo;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements lw3.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // lw3.a
    @NotNull
    public List<RecentContactModuleShieldInfo> a() {
        Set<String> g16;
        String str;
        Set<String> h16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<RecentContactModuleShieldInfo> arrayList = new ArrayList();
        QRouteApi api = QRoute.api(IUixConvertAdapterApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUixConvertAdapterApi::class.java)");
        IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) api;
        if (ServiceAccountFolderManager.s() && ServiceAccountFolderManager.q() && (h16 = ServiceAccountFolderManager.h()) != null) {
            Intrinsics.checkNotNullExpressionValue(h16, "getWhiteListPublicAccountStudy()");
            for (String it : h16) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String uidFromUin = iUixConvertAdapterApi.getUidFromUin(Util.toLongOrDefault(it, 0L));
                if (uidFromUin == null) {
                    str2 = "";
                } else {
                    str2 = uidFromUin;
                }
                arrayList.add(new RecentContactModuleShieldInfo(str2, it, 103, true, 0));
            }
        }
        if (ServiceAccountFolderManager.r() && ServiceAccountFolderManager.p() && (g16 = ServiceAccountFolderManager.g()) != null) {
            Intrinsics.checkNotNullExpressionValue(g16, "getWhiteListPublicAccountSimpleMode()");
            for (String it5 : g16) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                String uidFromUin2 = iUixConvertAdapterApi.getUidFromUin(Util.toLongOrDefault(it5, 0L));
                if (uidFromUin2 == null) {
                    str = "";
                } else {
                    str = uidFromUin2;
                }
                arrayList.add(new RecentContactModuleShieldInfo(str, it5, 103, true, 0));
            }
        }
        boolean p16 = ServiceAccountFolderManager.p();
        if (p16 || ServiceAccountFolderManager.q()) {
            if (!p16 || !((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isHitPublicAccountFolderExp() || SimpleUIUtil.isNowElderMode()) {
                arrayList.add(new RecentContactModuleShieldInfo("", "", 30, false, 0));
            }
            arrayList.add(new RecentContactModuleShieldInfo("", "", 103, false, 0));
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("[getWhiteConfigList] : ");
            for (RecentContactModuleShieldInfo recentContactModuleShieldInfo : arrayList) {
                sb5.append("{uid=" + recentContactModuleShieldInfo.uid + ", uin=" + recentContactModuleShieldInfo.uin + ", type=" + recentContactModuleShieldInfo.chatType + "}, isShow=" + recentContactModuleShieldInfo.isShow);
            }
            QLog.d("PublicAccountChatsNtFilter", 2, sb5);
        }
        return arrayList;
    }
}

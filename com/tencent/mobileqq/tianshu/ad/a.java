package com.tencent.mobileqq.tianshu.ad;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tianshu/ad/a;", "", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "advList", "a", "Lcom/tencent/mobileqq/tianshu/config/a;", "b", "Lcom/tencent/mobileqq/tianshu/config/a;", "requestAdBlackList", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f293021a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final com.tencent.mobileqq.tianshu.config.a requestAdBlackList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34058);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f293021a = new a();
            requestAdBlackList = (com.tencent.mobileqq.tianshu.config.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tianshu_common_ad_reqpuest_black_list");
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final List<TianShuAdPosItemData> a(@Nullable List<? extends TianShuAdPosItemData> advList) {
        boolean z16;
        boolean z17;
        ArrayList<Integer> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) advList);
        }
        StringBuilder sb5 = new StringBuilder("filterAdList:");
        List<? extends TianShuAdPosItemData> list = advList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return advList;
        }
        ArrayList arrayList = new ArrayList();
        for (TianShuAdPosItemData tianShuAdPosItemData : advList) {
            int i3 = tianShuAdPosItemData.mPosId;
            com.tencent.mobileqq.tianshu.config.a aVar = requestAdBlackList;
            if (aVar != null && (a16 = aVar.a()) != null && a16.contains(Integer.valueOf(i3))) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                sb5.append(i3 + " in black,");
            } else {
                sb5.append(i3 + " in white,");
                arrayList.add(tianShuAdPosItemData);
            }
        }
        QLog.d("TianshuAdRequestLimitManager", 1, sb5);
        return arrayList;
    }
}

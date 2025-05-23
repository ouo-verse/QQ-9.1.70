package com.qwallet.home;

import androidx.lifecycle.ViewModel;
import com.qwallet.utils.QWalletUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H$J\b\u0010\u0006\u001a\u00020\u0005H$J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H$J\b\u0010\n\u001a\u00020\tH\u0004J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/qwallet/home/c;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "N1", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "M1", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "L1", "", "Q1", "", "actionId", "O1", "", "actionName", "d1", "d2", "d3", "P1", "<init>", "()V", "i", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public abstract class c extends ViewModel {
    @Nullable
    protected abstract TianShuAccess.AdItem L1();

    @NotNull
    protected abstract TianShuGetAdvCallback M1();

    @NotNull
    protected abstract List<TianShuAdPosItemData> N1();

    public final void O1(int actionId) {
        String str;
        TianShuAccess.AdItem L1 = L1();
        if (L1 == null) {
            QLog.e("BaseTianShuViewModel", 1, "report error, adItem is null");
            return;
        }
        String str2 = "";
        if (!L1.iAdId.has()) {
            str = "";
        } else {
            str = String.valueOf(L1.iAdId.get());
        }
        if (L1.traceinfo.has()) {
            str2 = L1.traceinfo.get();
        }
        ml2.c.f416921a.a(actionId, str, str2);
    }

    public final void P1(@NotNull String actionName, @NotNull String d16, @NotNull String d26, @NotNull String d36) {
        String replace$default;
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(d16, "d1");
        Intrinsics.checkNotNullParameter(d26, "d2");
        Intrinsics.checkNotNullParameter(d36, "d3");
        QLog.d("BaseTianShuViewModel", 1, "actionName=" + actionName + " d1=" + d16 + " d2=" + d26 + " d3=" + d36);
        com.tencent.mobileqq.qwallet.c.e(actionName, d16, d26, d36, AppSetting.f99551k);
        replace$default = StringsKt__StringsJVMKt.replace$default(actionName, '.', util.base64_pad_url, false, 4, (Object) null);
        QWalletUtils.s(replace$default, "", d16, d26, d36);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q1() {
        if (QLog.isColorLevel()) {
            QLog.i("BaseTianShuViewModel", 2, "requestTianShu");
        }
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(N1(), M1());
    }
}

package com.dataline.nt;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactModuleShieldInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/dataline/nt/c;", "Llw3/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactModuleShieldInfo;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class c implements lw3.a {
    @Override // lw3.a
    @NotNull
    public List<RecentContactModuleShieldInfo> a() {
        ArrayList<RecentContactModuleShieldInfo> arrayList = new ArrayList();
        if (AppSetting.p(MobileQQ.sMobileQQ)) {
            DataLineRecentContactUtil dataLineRecentContactUtil = DataLineRecentContactUtil.f32313a;
            String DATALINE_IPAD_UIN = AppConstants.DATALINE_IPAD_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_IPAD_UIN, "DATALINE_IPAD_UIN");
            arrayList.add(new RecentContactModuleShieldInfo(dataLineRecentContactUtil.h(DATALINE_IPAD_UIN), DATALINE_IPAD_UIN, 8, false, 0));
        } else {
            DataLineRecentContactUtil dataLineRecentContactUtil2 = DataLineRecentContactUtil.f32313a;
            String DATALINE_PHONE_UIN = AppConstants.DATALINE_PHONE_UIN;
            Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_PHONE_UIN");
            arrayList.add(new RecentContactModuleShieldInfo(dataLineRecentContactUtil2.h(DATALINE_PHONE_UIN), DATALINE_PHONE_UIN, 8, false, 0));
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("[getWhiteConfigList] : ");
            for (RecentContactModuleShieldInfo recentContactModuleShieldInfo : arrayList) {
                sb5.append("{uid=" + recentContactModuleShieldInfo.uid + ", uin=" + recentContactModuleShieldInfo.uin + ", type=" + recentContactModuleShieldInfo.chatType + "}, isShow=" + recentContactModuleShieldInfo.isShow);
            }
            QLog.d("DataLineFilter", 2, sb5);
        }
        return arrayList;
    }
}

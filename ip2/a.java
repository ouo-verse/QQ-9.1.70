package ip2;

import addcontacts.AccountSearchPb$hotwordrecord;
import addcontacts.AccountSearchPb$record;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    String f408133a = null;

    @Override // ip2.b
    x b(un2.a aVar, List<y> list, String str, boolean z16, String str2) {
        if (list != null) {
            lo2.d dVar = (lo2.d) list.get(0);
            if (dVar != null && dVar.H() != null) {
                String str3 = dVar.H().hotword.get();
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F74", "0X8006F74", 0, 0, dVar.s(), str3, String.valueOf(dVar.H().hotword_type.get()), "");
            }
            if (dVar == null || dVar.I() == null) {
                if (list.size() > 1) {
                    dVar = (lo2.d) list.get(1);
                } else {
                    dVar = null;
                }
            }
            if (dVar != null && dVar.I() != null) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", str, String.valueOf(dVar.I().account_id.get()));
            }
        }
        rn2.d.d(110);
        this.f408133a = str2;
        return new do2.b(aVar, list, str, str2);
    }

    @Override // ip2.b
    y c(AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord, String str, CharSequence charSequence, String str2, CharSequence charSequence2) {
        return new lo2.d(accountSearchPb$hotwordrecord, str, charSequence, str2, charSequence2);
    }

    @Override // ip2.b
    y d(AccountSearchPb$record accountSearchPb$record, String str, CharSequence charSequence) {
        return new lo2.d(accountSearchPb$record, str, charSequence);
    }
}

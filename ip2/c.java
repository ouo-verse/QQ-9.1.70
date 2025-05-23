package ip2;

import addcontacts.AccountSearchPb$hotwordrecord;
import addcontacts.AccountSearchPb$record;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends b {
    @Override // ip2.b
    x b(un2.a aVar, List<y> list, String str, boolean z16, String str2) {
        rn2.d.d(70);
        return new com.tencent.mobileqq.search.model.d(aVar, list, str);
    }

    @Override // ip2.b
    y c(AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord, String str, CharSequence charSequence, String str2, CharSequence charSequence2) {
        return null;
    }

    @Override // ip2.b
    y d(AccountSearchPb$record accountSearchPb$record, String str, CharSequence charSequence) {
        return new do2.c(accountSearchPb$record, str, charSequence);
    }
}

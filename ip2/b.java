package ip2;

import addcontacts.AccountSearchPb$hotwordrecord;
import addcontacts.AccountSearchPb$record;
import addcontacts.AccountSearchPb$search;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$comm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b implements d<x> {
    @Override // ip2.d
    public List<x> a(Object... objArr) {
        SummaryCardBusiEntry$comm summaryCardBusiEntry$comm;
        byte[] bArr;
        String str;
        int i3;
        boolean z16;
        boolean z17;
        CharSequence Eh;
        boolean z18;
        int i16;
        if (objArr == null || objArr.length < 3) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof SummaryCardBusiEntry$comm) {
            summaryCardBusiEntry$comm = (SummaryCardBusiEntry$comm) obj;
        } else {
            summaryCardBusiEntry$comm = null;
        }
        Object obj2 = objArr[1];
        if (obj2 instanceof byte[]) {
            bArr = (byte[]) obj2;
        } else {
            bArr = null;
        }
        Object obj3 = objArr[2];
        if (obj3 instanceof String) {
            str = (String) obj3;
        } else {
            str = null;
        }
        if (summaryCardBusiEntry$comm == null || bArr == null) {
            return null;
        }
        AccountSearchPb$search accountSearchPb$search = new AccountSearchPb$search();
        un2.a aVar = new un2.a();
        try {
            accountSearchPb$search.mergeFrom(bArr);
            aVar.f439268a = summaryCardBusiEntry$comm.service.get();
            aVar.f439269b = accountSearchPb$search.start.get();
            if (accountSearchPb$search.end.get() == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            aVar.f439270c = z18;
            aVar.f439272e = accountSearchPb$search.list.get();
            aVar.f439273f = accountSearchPb$search.hotword_record.get();
            aVar.f439271d = accountSearchPb$search.highlight.get();
            aVar.f439274g = accountSearchPb$search.article_more_url.get();
            aVar.f439277j = accountSearchPb$search.bool_keyword_suicide.get();
            aVar.f439278k = accountSearchPb$search.bool_exact_search.get();
            List<AccountSearchPb$record> list = aVar.f439272e;
            if (list != null && list.size() > 0) {
                int i17 = aVar.f439268a;
                if (i17 == 80000000) {
                    for (AccountSearchPb$record accountSearchPb$record : accountSearchPb$search.list.get()) {
                        if (accountSearchPb$record.sign.get() != null) {
                            accountSearchPb$record.richStatus = RichStatus.parseStatus(accountSearchPb$record.sign.get().toByteArray());
                        }
                    }
                } else if (i17 == 80000001 && accountSearchPb$search.bool_location_group.has()) {
                    if (accountSearchPb$search.bool_location_group.get()) {
                        i16 = 1;
                    } else {
                        i16 = 2;
                    }
                    aVar.f439275h = i16;
                }
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        List<AccountSearchPb$record> list2 = aVar.f439272e;
        if (list2 == null || list2.size() == 0) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("search", 2, "recordList size " + aVar.f439272e.size());
        }
        new ArrayList().add(aVar);
        ArrayList arrayList = new ArrayList(3);
        int size = aVar.f439272e.size();
        String str2 = aVar.f439274g;
        AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord = aVar.f439273f.get();
        if (accountSearchPb$hotwordrecord != null && accountSearchPb$hotwordrecord.hotword.has()) {
            i3 = 80000001;
            arrayList.add(c(accountSearchPb$hotwordrecord, str, SearchUtils.Z(accountSearchPb$hotwordrecord.hotword.get(), (ArrayList) aVar.f439271d, 255), str2, SearchUtils.Z(accountSearchPb$hotwordrecord.hotword_title.get(), (ArrayList) aVar.f439271d, 255)));
        } else {
            i3 = 80000001;
        }
        for (int i18 = 0; i18 < size; i18++) {
            AccountSearchPb$record accountSearchPb$record2 = aVar.f439272e.get(i18);
            if (aVar.f439268a == 80000003) {
                Eh = SearchUtils.Z(accountSearchPb$record2.name.get(), (ArrayList) aVar.f439271d, 255);
            } else {
                Eh = SearchBaseFragment.Eh(accountSearchPb$record2.name.get(), aVar.f439271d);
            }
            arrayList.add(d(accountSearchPb$record2, str, Eh));
        }
        if (aVar.f439268a == i3) {
            if (aVar.f439275h == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            z16 = z17;
        } else {
            z16 = false;
        }
        ArrayList arrayList2 = new ArrayList(3);
        x b16 = b(aVar, arrayList, str, z16, str2);
        arrayList2.add(new com.tencent.mobileqq.search.model.i(b16));
        arrayList2.add(b16);
        return arrayList2;
    }

    abstract x b(un2.a aVar, List<y> list, String str, boolean z16, String str2);

    abstract y c(AccountSearchPb$hotwordrecord accountSearchPb$hotwordrecord, String str, CharSequence charSequence, String str2, CharSequence charSequence2);

    abstract y d(AccountSearchPb$record accountSearchPb$record, String str, CharSequence charSequence);
}

package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import pb.unify.search.UnifySearchAssociationWord$SuggestUrlItem;
import tencent.im.oidb.search.DynamicTabSearch$SubHotWord;

/* compiled from: P */
/* loaded from: classes11.dex */
public class di implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public di() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        }
    }

    public void b(int i3, List<BusinessGroupWord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) list);
        }
    }

    public void c(String str, Integer num, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, num, str2);
        }
    }

    public void d(String str, UnifySearchAssociationWord$SuggestUrlItem unifySearchAssociationWord$SuggestUrlItem, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, unifySearchAssociationWord$SuggestUrlItem, Integer.valueOf(i3));
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
    }

    public void f(List<com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.b> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, list, Boolean.valueOf(z16));
        }
    }

    public void g(ToServiceMsg toServiceMsg, Integer num, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, num, obj);
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
    }

    public void i(String str, List<com.tencent.mobileqq.search.model.am> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) list);
        }
    }

    public void j(String str, boolean z16, String str2, int i3, String str3, long[] jArr, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), str3, jArr, str4);
        }
    }

    public void k(String str, boolean z16, String str2, byte[] bArr, boolean z17, List<com.tencent.mobileqq.search.model.x> list, long[] jArr, String str3, List<DynamicTabSearch$SubHotWord> list2, boolean z18, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), str2, bArr, Boolean.valueOf(z17), list, jArr, str3, list2, Boolean.valueOf(z18), str4, Integer.valueOf(i3), str5);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UnifySearchObserver", 2, "UnifySearchObserver onUpdate type" + i3 + " isSuccess=" + z16 + " data=" + obj);
        }
        if (i3 != 1000) {
            if (i3 != 1002) {
                if (i3 != 1005) {
                    switch (i3) {
                        case 1008:
                            if (obj != null) {
                                Object[] objArr = (Object[]) obj;
                                g((ToServiceMsg) objArr[0], (Integer) objArr[1], objArr[2]);
                                return;
                            }
                            return;
                        case 1009:
                            if (obj != null) {
                                Object[] objArr2 = (Object[]) obj;
                                String str = (String) objArr2[0];
                                if (z16) {
                                    i(str, (List) objArr2[1]);
                                    return;
                                } else {
                                    h(str);
                                    return;
                                }
                            }
                            h("");
                            return;
                        case 1010:
                            if (obj != null) {
                                Object[] objArr3 = (Object[]) obj;
                                if (z16) {
                                    f((List) objArr3[0], ((Boolean) objArr3[1]).booleanValue());
                                    return;
                                } else {
                                    e(((Boolean) objArr3[0]).booleanValue());
                                    return;
                                }
                            }
                            e(false);
                            return;
                        default:
                            return;
                    }
                }
                if (z16) {
                    Object[] objArr4 = (Object[]) obj;
                    d((String) objArr4[0], (UnifySearchAssociationWord$SuggestUrlItem) objArr4[1], ((Integer) objArr4[2]).intValue());
                    return;
                } else {
                    Object[] objArr5 = (Object[]) obj;
                    c((String) objArr5[0], (Integer) objArr5[1], (String) objArr5[2]);
                    return;
                }
            }
            if (obj != null) {
                if (z16) {
                    Object[] objArr6 = (Object[]) obj;
                    b(((Integer) objArr6[0]).intValue(), (List) objArr6[1]);
                    return;
                } else {
                    Object[] objArr7 = (Object[]) obj;
                    a(((Integer) objArr7[0]).intValue(), (String) objArr7[1]);
                    return;
                }
            }
            a(-1, "");
            return;
        }
        if (z16) {
            Object[] objArr8 = (Object[]) obj;
            String str2 = (String) objArr8[0];
            boolean booleanValue = ((Boolean) objArr8[1]).booleanValue();
            String str3 = (String) objArr8[2];
            byte[] bArr = (byte[]) objArr8[3];
            boolean booleanValue2 = ((Boolean) objArr8[4]).booleanValue();
            List<com.tencent.mobileqq.search.model.x> list = (List) objArr8[5];
            long[] jArr = (long[]) objArr8[6];
            String str4 = (String) objArr8[7];
            List<DynamicTabSearch$SubHotWord> list2 = (List) objArr8[8];
            boolean booleanValue3 = ((Boolean) objArr8[9]).booleanValue();
            String str5 = (String) objArr8[10];
            int intValue = ((Integer) objArr8[11]).intValue();
            String str6 = (String) objArr8[12];
            k(str2, booleanValue, str3, bArr, booleanValue2, list, jArr, str4, list2, booleanValue3, str5, intValue, str6);
            if (QLog.isColorLevel()) {
                QLog.i("Q.uniteSearch.UnifySearchObserver", 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH isEnd = " + booleanValue2 + " mask;" + Arrays.toString(jArr) + " key=" + str2 + " time=" + str3 + " traceId=" + str6);
                return;
            }
            return;
        }
        Object[] objArr9 = (Object[]) obj;
        String str7 = (String) objArr9[0];
        boolean booleanValue4 = ((Boolean) objArr9[1]).booleanValue();
        String str8 = (String) objArr9[2];
        Integer num = (Integer) objArr9[3];
        String str9 = (String) objArr9[4];
        long[] jArr2 = (long[]) objArr9[5];
        String str10 = (String) objArr9[6];
        j(str7, booleanValue4, str8, num.intValue(), str9, jArr2, str10);
        if (QLog.isColorLevel()) {
            QLog.w("Q.uniteSearch.UnifySearchObserver", 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH error!  mask;" + Arrays.toString(jArr2) + " key=" + str7 + " time=" + str8 + " traceId=" + str10);
        }
    }
}

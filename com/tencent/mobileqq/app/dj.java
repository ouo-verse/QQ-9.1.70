package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import tencent.im.oidb.search.DynamicAssociationWord$SuggestUrlItem;
import tencent.im.oidb.search.DynamicTabSearch$SubHotWord;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dj implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.uniteSearch.UniteSearchObserver";

    public dj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void handleAssociateResult(String str, int i3, List<AssociateSearchWordsFragment.AssociateItem> list, List<DynamicAssociationWord$SuggestUrlItem> list2, DynamicAssociationWord$SuggestUrlItem dynamicAssociationWord$SuggestUrlItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), list, list2, dynamicAssociationWord$SuggestUrlItem);
        }
    }

    public void handleAssociateResultError(String str, Integer num, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, num, str2);
        }
    }

    public void handleAssociateWordResult(String str, List<String> list, List<String> list2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, list, list2, Integer.valueOf(i3));
        }
    }

    public void handleBusiHotWordError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) str);
        }
    }

    public void handleBusiHotWordResult(int i3, List<BusinessGroupWord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) list);
        }
    }

    public void handleCompletedUrlError(String str, Integer num, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, num, str2);
        }
    }

    public void handleCompletedUrlResult(String str, DynamicAssociationWord$SuggestUrlItem dynamicAssociationWord$SuggestUrlItem, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, dynamicAssociationWord$SuggestUrlItem, Integer.valueOf(i3));
        }
    }

    public void handleSearchDiscoveryError(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
    }

    public void handleSearchDiscoveryResult(List<SearchEntryDataModel> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list, i3);
        }
    }

    public void handleSearchHippyDiscoveryResult(ToServiceMsg toServiceMsg, Integer num, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, toServiceMsg, num, obj);
        }
    }

    public void handleTabSearchError(String str, boolean z16, String str2, int i3, String str3, long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), str3, jArr);
        }
    }

    public void handleTabSearchResult(String str, boolean z16, String str2, byte[] bArr, boolean z17, List<com.tencent.mobileqq.search.model.x> list, long[] jArr, String str3, List<DynamicTabSearch$SubHotWord> list2, boolean z18, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), str2, bArr, Boolean.valueOf(z17), list, jArr, str3, list2, Boolean.valueOf(z18), str4, Integer.valueOf(i3));
    }

    public void handleUniteSearchError(String str, boolean z16, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), str3);
        }
    }

    public void handleUniteSearchResult(String str, boolean z16, String str2, byte[] bArr, boolean z17, List<Object> list, List<com.tencent.mobileqq.search.model.x> list2, int i3, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), str2, bArr, Boolean.valueOf(z17), list, list2, Integer.valueOf(i3), Boolean.valueOf(z18));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "UniteSearchObserver onUpdate type" + i3 + " isSuccess=" + z16 + " data=" + obj);
        }
        int i17 = -1;
        switch (i3) {
            case 1000:
                if (z16) {
                    Object[] objArr = (Object[]) obj;
                    String str = (String) objArr[0];
                    boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                    String str2 = (String) objArr[2];
                    byte[] bArr = (byte[]) objArr[3];
                    boolean booleanValue2 = ((Boolean) objArr[4]).booleanValue();
                    List<com.tencent.mobileqq.search.model.x> list = (List) objArr[5];
                    long[] jArr = (long[]) objArr[6];
                    handleTabSearchResult(str, booleanValue, str2, bArr, booleanValue2, list, jArr, (String) objArr[7], (List) objArr[8], ((Boolean) objArr[9]).booleanValue(), (String) objArr[10], ((Integer) objArr[11]).intValue());
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH isEnd = " + booleanValue2 + " mask;" + Arrays.toString(jArr) + " key=" + str + " time=" + str2);
                        return;
                    }
                    return;
                }
                Object[] objArr2 = (Object[]) obj;
                String str3 = (String) objArr2[0];
                boolean booleanValue3 = ((Boolean) objArr2[1]).booleanValue();
                String str4 = (String) objArr2[2];
                Integer num = (Integer) objArr2[3];
                String str5 = (String) objArr2[4];
                long[] jArr2 = (long[]) objArr2[5];
                handleTabSearchError(str3, booleanValue3, str4, num.intValue(), str5, jArr2);
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH error!  mask;" + Arrays.toString(jArr2) + " key=" + str3 + " time=" + str4);
                    return;
                }
                return;
            case 1001:
            case 1003:
            default:
                return;
            case 1002:
                if (obj != null) {
                    if (z16) {
                        Object[] objArr3 = (Object[]) obj;
                        handleBusiHotWordResult(((Integer) objArr3[0]).intValue(), (List) objArr3[1]);
                        return;
                    } else {
                        Object[] objArr4 = (Object[]) obj;
                        handleBusiHotWordError(((Integer) objArr4[0]).intValue(), (String) objArr4[1]);
                        return;
                    }
                }
                handleBusiHotWordError(-1, "");
                return;
            case 1004:
                if (z16) {
                    Object[] objArr5 = (Object[]) obj;
                    handleUniteSearchResult((String) objArr5[0], ((Boolean) objArr5[1]).booleanValue(), (String) objArr5[2], (byte[]) objArr5[3], ((Boolean) objArr5[4]).booleanValue(), (List) objArr5[5], (List) objArr5[6], ((Integer) objArr5[7]).intValue(), ((Boolean) objArr5[8]).booleanValue());
                    return;
                }
                Object[] objArr6 = (Object[]) obj;
                handleUniteSearchError((String) objArr6[0], ((Boolean) objArr6[1]).booleanValue(), (String) objArr6[2], ((Integer) objArr6[3]).intValue(), (String) objArr6[4]);
                return;
            case 1005:
                if (z16) {
                    Object[] objArr7 = (Object[]) obj;
                    handleCompletedUrlResult((String) objArr7[0], (DynamicAssociationWord$SuggestUrlItem) objArr7[1], ((Integer) objArr7[2]).intValue());
                    return;
                } else {
                    Object[] objArr8 = (Object[]) obj;
                    handleCompletedUrlError((String) objArr8[0], (Integer) objArr8[1], (String) objArr8[2]);
                    return;
                }
            case 1006:
                if (z16) {
                    Object[] objArr9 = (Object[]) obj;
                    handleAssociateResult((String) objArr9[0], ((Integer) objArr9[1]).intValue(), (List) objArr9[2], (List) objArr9[3], (DynamicAssociationWord$SuggestUrlItem) objArr9[4]);
                    return;
                } else {
                    Object[] objArr10 = (Object[]) obj;
                    handleAssociateResultError((String) objArr10[0], (Integer) objArr10[1], (String) objArr10[2]);
                    return;
                }
            case 1007:
                if (obj != null) {
                    if (z16) {
                        Object[] objArr11 = (Object[]) obj;
                        List<SearchEntryDataModel> list2 = (List) objArr11[0];
                        Integer num2 = (Integer) objArr11[1];
                        if (num2 != null) {
                            i17 = num2.intValue();
                        }
                        handleSearchDiscoveryResult(list2, i17);
                        return;
                    }
                    Object[] objArr12 = (Object[]) obj;
                    Integer num3 = (Integer) objArr12[0];
                    String str6 = (String) objArr12[1];
                    Integer num4 = (Integer) objArr12[2];
                    if (num3 != null) {
                        i16 = num3.intValue();
                    } else {
                        i16 = -1;
                    }
                    if (num4 != null) {
                        i17 = num4.intValue();
                    }
                    handleSearchDiscoveryError(i16, str6, i17);
                    return;
                }
                handleSearchDiscoveryError(-1, null, -1);
                return;
            case 1008:
                if (obj != null) {
                    Object[] objArr13 = (Object[]) obj;
                    handleSearchHippyDiscoveryResult((ToServiceMsg) objArr13[0], (Integer) objArr13[1], objArr13[2]);
                    return;
                }
                return;
        }
    }
}

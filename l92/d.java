package l92;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Bundle;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        String str;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 32) {
                                    if (i3 != 40) {
                                        if (i3 != 60) {
                                            if (i3 != 61) {
                                                switch (i3) {
                                                    case 13:
                                                        if (z16 && obj != null) {
                                                            Object[] objArr = (Object[]) obj;
                                                            h(z16, ((Long) objArr[0]).longValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                                                            return;
                                                        }
                                                        return;
                                                    case 14:
                                                        if (obj instanceof String) {
                                                            str = (String) obj;
                                                        } else {
                                                            str = "";
                                                        }
                                                        e(z16, str);
                                                        return;
                                                    case 15:
                                                        if (obj instanceof Object[]) {
                                                            Object[] objArr2 = (Object[]) obj;
                                                            n(z16, (ArrayList) objArr2[0], ((Integer) objArr2[1]).intValue());
                                                            return;
                                                        }
                                                        return;
                                                    default:
                                                        int i36 = -1;
                                                        switch (i3) {
                                                            case 46:
                                                                t(z16);
                                                                return;
                                                            case 47:
                                                                if (obj != null) {
                                                                    s(z16, obj);
                                                                    return;
                                                                } else {
                                                                    s(false, null);
                                                                    return;
                                                                }
                                                            case 48:
                                                                Object[] objArr3 = (Object[]) obj;
                                                                if (objArr3 != null && objArr3.length == 5) {
                                                                    Object obj2 = objArr3[1];
                                                                    if (obj2 instanceof Integer) {
                                                                        i16 = ((Integer) obj2).intValue();
                                                                    } else {
                                                                        i16 = -1;
                                                                    }
                                                                    Object obj3 = objArr3[2];
                                                                    if (obj3 instanceof Integer) {
                                                                        i17 = ((Integer) obj3).intValue();
                                                                    } else {
                                                                        i17 = -1;
                                                                    }
                                                                    Object obj4 = objArr3[3];
                                                                    if (obj4 instanceof Integer) {
                                                                        i18 = ((Integer) obj4).intValue();
                                                                    } else {
                                                                        i18 = -1;
                                                                    }
                                                                    Object obj5 = objArr3[4];
                                                                    if (obj5 instanceof Integer) {
                                                                        i19 = ((Integer) obj5).intValue();
                                                                    } else {
                                                                        i19 = -1;
                                                                    }
                                                                    j(z16, (ArrayList) objArr3[0], i16, i17, i18, i19);
                                                                    return;
                                                                }
                                                                j(false, null, -1, -1, -1, -1);
                                                                return;
                                                            case 49:
                                                                a(z16);
                                                                return;
                                                            case 50:
                                                                if (obj != null) {
                                                                    Object[] objArr4 = (Object[]) obj;
                                                                    if (objArr4.length == 5) {
                                                                        Object obj6 = objArr4[1];
                                                                        if (obj6 instanceof Integer) {
                                                                            i29 = ((Integer) obj6).intValue();
                                                                        } else {
                                                                            i29 = -1;
                                                                        }
                                                                        Object obj7 = objArr4[2];
                                                                        if (obj7 instanceof Integer) {
                                                                            i26 = ((Integer) obj7).intValue();
                                                                        } else {
                                                                            i26 = -1;
                                                                        }
                                                                        Object obj8 = objArr4[3];
                                                                        if (obj8 instanceof Integer) {
                                                                            i27 = ((Integer) obj8).intValue();
                                                                        } else {
                                                                            i27 = -1;
                                                                        }
                                                                        Object obj9 = objArr4[4];
                                                                        if (obj9 instanceof Integer) {
                                                                            i36 = ((Integer) obj9).intValue();
                                                                        }
                                                                        i28 = i36;
                                                                        i36 = i29;
                                                                    } else {
                                                                        i26 = -1;
                                                                        i27 = -1;
                                                                        i28 = -1;
                                                                    }
                                                                    l(z16, (ArrayList) objArr4[0], i36, i26, i27, i28);
                                                                    return;
                                                                }
                                                                l(false, null, -1, -1, -1, -1);
                                                                return;
                                                            case 51:
                                                                if (z16 && (obj instanceof Object[])) {
                                                                    Object[] objArr5 = (Object[]) obj;
                                                                    k(z16, objArr5[0], ((Boolean) objArr5[1]).booleanValue());
                                                                    return;
                                                                }
                                                                k(z16, obj, false);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                            }
                                            if (z16 && (obj instanceof Object[])) {
                                                Object[] objArr6 = (Object[]) obj;
                                                d(((Integer) objArr6[0]).intValue(), ((Integer) objArr6[1]).intValue(), ((Integer) objArr6[2]).intValue(), ((Integer) objArr6[3]).intValue(), ((Integer) objArr6[4]).intValue(), ((Integer) objArr6[5]).intValue(), ((Integer) objArr6[6]).intValue(), ((Integer) objArr6[7]).intValue(), (String) objArr6[8]);
                                                return;
                                            }
                                            return;
                                        }
                                        if (z16 && (obj instanceof Object[])) {
                                            Object[] objArr7 = (Object[]) obj;
                                            c(((Boolean) objArr7[0]).booleanValue(), ((Integer) objArr7[1]).intValue(), ((Integer) objArr7[2]).intValue(), ((Integer) objArr7[3]).intValue(), ((Integer) objArr7[4]).intValue(), ((Integer) objArr7[5]).intValue(), ((Integer) objArr7[6]).intValue(), (String) objArr7[7]);
                                            return;
                                        }
                                        return;
                                    }
                                    if (obj != null) {
                                        Object[] objArr8 = (Object[]) obj;
                                        g(z16, (String) objArr8[0], (mobile_sub_get_cover_rsp) objArr8[1]);
                                        return;
                                    }
                                    return;
                                }
                                if (obj instanceof Bundle) {
                                    Bundle bundle = (Bundle) obj;
                                    if (bundle.getInt("favoriteSource") != 43 && bundle.getInt("favoriteSource") != 51) {
                                        m(z16, bundle.getString("selfUin"), bundle.getString(IProfileProtocolConst.PARAM_TARGET_UIN), bundle.getInt(FloatCacheData.ICOUNT, 0), bundle.getInt("from", 0));
                                        return;
                                    } else {
                                        o(z16, bundle.getString("selfUin"), bundle.getString(IProfileProtocolConst.PARAM_TARGET_UIN), bundle.getInt("toplist_type"), bundle.getInt(FloatCacheData.ICOUNT, 0));
                                        return;
                                    }
                                }
                                return;
                            }
                            if (obj instanceof Object[]) {
                                Object[] objArr9 = (Object[]) obj;
                                r((String) objArr9[0], ((Integer) objArr9[1]).intValue());
                                return;
                            }
                            return;
                        }
                        Object[] objArr10 = (Object[]) obj;
                        if (z16 && objArr10 != null && objArr10.length == 6) {
                            long longValue = ((Long) objArr10[0]).longValue();
                            boolean booleanValue = ((Boolean) objArr10[1]).booleanValue();
                            boolean booleanValue2 = ((Boolean) objArr10[2]).booleanValue();
                            byte[] bArr = (byte[]) objArr10[3];
                            String str2 = (String) objArr10[4];
                            i(z16, longValue, booleanValue, booleanValue2, bArr, str2);
                            return;
                        }
                        i(false, 0L, false, false, null, null);
                        return;
                    }
                    Object[] objArr11 = (Object[]) obj;
                    q(z16, (String) objArr11[0], (List) objArr11[1], (String) objArr11[2], ((Integer) objArr11[3]).intValue(), ((Integer) objArr11[4]).intValue());
                    return;
                }
                Object[] objArr12 = (Object[]) obj;
                b(z16, objArr12[0], ((Boolean) objArr12[1]).booleanValue(), (String) objArr12[2]);
                return;
            }
            f();
            return;
        }
        Object[] objArr13 = (Object[]) obj;
        p(z16, ((Integer) objArr13[0]).intValue(), ((Integer) objArr13[1]).intValue(), (List) objArr13[2], (List) objArr13[3], (String) objArr13[4], ((Integer) objArr13[5]).intValue(), ((Integer) objArr13[6]).intValue(), (String) objArr13[7]);
    }

    public void f() {
    }

    protected void a(boolean z16) {
    }

    protected void t(boolean z16) {
    }

    protected void e(boolean z16, String str) {
    }

    protected void r(String str, int i3) {
    }

    protected void s(boolean z16, Object obj) {
    }

    protected void g(boolean z16, String str, mobile_sub_get_cover_rsp mobile_sub_get_cover_rspVar) {
    }

    protected void k(boolean z16, Object obj, boolean z17) {
    }

    protected void n(boolean z16, ArrayList<Object> arrayList, int i3) {
    }

    public void b(boolean z16, Object obj, boolean z17, String str) {
    }

    public void h(boolean z16, long j3, String str, int i3, int i16) {
    }

    protected void m(boolean z16, String str, String str2, int i3, int i16) {
    }

    protected void o(boolean z16, String str, String str2, int i3, int i16) {
    }

    public void i(boolean z16, long j3, boolean z17, boolean z18, byte[] bArr, String str) {
    }

    protected void j(boolean z16, ArrayList<Object> arrayList, int i3, int i16, int i17, int i18) {
    }

    protected void l(boolean z16, ArrayList<Object> arrayList, int i3, int i16, int i17, int i18) {
    }

    public void q(boolean z16, String str, List<Object> list, String str2, int i3, int i16) {
    }

    protected void c(boolean z16, int i3, int i16, int i17, int i18, int i19, int i26, String str) {
    }

    protected void d(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, String str) {
    }

    public void p(boolean z16, int i3, int i16, List<Object> list, List<Object> list2, String str, int i17, int i18, String str2) {
    }
}

package com.tencent.mobileqq.friends.intimate;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBandIntimateRelationship(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDisbandIntimateRelationship(boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
    }

    protected void onGetIntimateInfo(boolean z16, String str, IntimateInfo intimateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, intimateInfo);
        }
    }

    protected void onGetUpgradeIntimateInfo(boolean z16, String str, IntimateInfo intimateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, intimateInfo);
        }
    }

    protected void onHandleGetLoverIntimateInfo(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onMutualMarkCardUpdate(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    protected void onSendDateTypeEventToServer(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    protected void onTroopWithCommonFriendsListUpdate(boolean z16, int i3, ArrayList<com.tencent.mobileqq.activity.contact.troop.c> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), arrayList);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 6) {
                                if (i3 != 11) {
                                    if (i3 != 8) {
                                        if (i3 == 9) {
                                            if (obj instanceof Object[]) {
                                                Object[] objArr = (Object[]) obj;
                                                onGetUpgradeIntimateInfo(z16, (String) objArr[0], (IntimateInfo) objArr[1]);
                                                return;
                                            } else {
                                                onGetUpgradeIntimateInfo(false, "", null);
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    if (obj instanceof Object[]) {
                                        Object[] objArr2 = (Object[]) obj;
                                        onTroopWithCommonFriendsListUpdate(z16, ((Integer) objArr2[0]).intValue(), (ArrayList) objArr2[1]);
                                        return;
                                    }
                                    return;
                                }
                                if (obj instanceof Object[]) {
                                    Object[] objArr3 = (Object[]) obj;
                                    if (objArr3.length >= 2) {
                                        onMutualMarkCardUpdate(((Long) objArr3[0]).longValue(), ((Boolean) objArr3[1]).booleanValue());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (obj instanceof Object[]) {
                                Object[] objArr4 = (Object[]) obj;
                                if (objArr4.length >= 1) {
                                    onSendDateTypeEventToServer(z16, ((Long) objArr4[0]).longValue());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (z16 && (obj instanceof Object[])) {
                            onHandleGetLoverIntimateInfo(z16, (Object[]) obj);
                            return;
                        } else {
                            onHandleGetLoverIntimateInfo(false, null);
                            return;
                        }
                    }
                    if (obj instanceof Object[]) {
                        Object[] objArr5 = (Object[]) obj;
                        onUpdateIntimateRelationship(z16, (String) objArr5[0], ((Integer) objArr5[1]).intValue(), ((Integer) objArr5[2]).intValue(), ((Integer) objArr5[3]).intValue());
                        return;
                    } else {
                        onUpdateIntimateRelationship(false, "", -1, -1, -1);
                        return;
                    }
                }
                if (obj instanceof Object[]) {
                    onBandIntimateRelationship(z16, (String) ((Object[]) obj)[0]);
                    return;
                } else {
                    onBandIntimateRelationship(false, "");
                    return;
                }
            }
            if (obj instanceof Object[]) {
                Object[] objArr6 = (Object[]) obj;
                onDisbandIntimateRelationship(z16, (String) objArr6[0], ((Boolean) objArr6[1]).booleanValue());
                return;
            } else {
                onDisbandIntimateRelationship(z16, "", false);
                return;
            }
        }
        if (obj instanceof Object[]) {
            Object[] objArr7 = (Object[]) obj;
            onGetIntimateInfo(z16, (String) objArr7[0], (IntimateInfo) objArr7[1]);
        } else {
            onGetIntimateInfo(false, "", null);
        }
    }

    protected void onUpdateIntimateRelationship(boolean z16, String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}

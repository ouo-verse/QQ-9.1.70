package com.tencent.mobileqq.avatar.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onGetApolloHeadInfo(boolean z16, String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str, Byte.valueOf(b16));
        }
    }

    protected void onGetHeadInfo(boolean z16, Setting setting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), setting);
        }
    }

    public void onGetHeadInfoEmpty(boolean z16, int i3, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), list);
        }
    }

    protected void onStrangerHeadReady(boolean z16, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.app.BusinessObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUpdate(int i3, boolean z16, Object obj) {
        FaceInfo faceInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        switch (i3) {
            case 0:
                onGetHeadInfo(z16, (Setting) obj);
                return;
            case 1:
                Object[] objArr = (Object[]) obj;
                String str = (String) objArr[0];
                if (objArr.length > 1) {
                    Object obj2 = objArr[1];
                    if (obj2 instanceof FaceInfo) {
                        faceInfo = (FaceInfo) obj2;
                        if (onUpdateCustomHead(z16, str, faceInfo)) {
                            onUpdateCustomHead(z16, str);
                            return;
                        }
                        return;
                    }
                }
                faceInfo = null;
                if (onUpdateCustomHead(z16, str, faceInfo)) {
                }
            case 2:
                onUpdateMobileQQHead(z16, (String) ((Object[]) obj)[0]);
                return;
            case 3:
                onUpdateTroopHead(z16, (String) ((Object[]) obj)[0]);
                return;
            case 4:
                Object[] objArr2 = (Object[]) obj;
                onUpdateStrangerHead(z16, (String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                return;
            case 5:
                Object[] objArr3 = (Object[]) obj;
                onUpdateQCallHead(z16, (String) objArr3[0], ((Integer) objArr3[1]).intValue(), ((Boolean) objArr3[2]).booleanValue());
                return;
            case 6:
                if (obj instanceof Object[]) {
                    Object[] objArr4 = (Object[]) obj;
                    if (objArr4.length > 1) {
                        onGetHeadInfoEmpty(z16, ((Integer) objArr4[0]).intValue(), (ArrayList) objArr4[1]);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (obj instanceof Object[]) {
                    Object[] objArr5 = (Object[]) obj;
                    onGetApolloHeadInfo(z16, (String) objArr5[0], ((Byte) objArr5[1]).byteValue());
                    return;
                }
                return;
            case 8:
                if (obj instanceof Object[]) {
                    Object[] objArr6 = (Object[]) obj;
                    onUpdateApolloHead(z16, (String) objArr6[0], ((Integer) objArr6[1]).intValue());
                    return;
                }
                return;
            case 9:
                Object[] objArr7 = (Object[]) obj;
                onStrangerHeadReady(z16, (String) objArr7[0], ((Integer) objArr7[1]).intValue(), (String) objArr7[2]);
                return;
            default:
                return;
        }
    }

    protected void onUpdateApolloHead(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateCustomHead(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str);
    }

    protected void onUpdateMobileQQHead(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onUpdateQCallHead(boolean z16, String str, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
        }
    }

    protected void onUpdateStrangerHead(boolean z16, String str, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
        }
    }

    protected void onUpdateTroopHead(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), str);
        }
    }

    protected boolean onUpdateCustomHead(boolean z16, String str, FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, faceInfo)).booleanValue();
    }
}

package com.tencent.mobileqq.troop.api.observer;

import android.util.Pair;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int TYPE_CMD_TROOP_AVATAR;
    public static final int TYPE_GET_TROOP_AVATAR;
    public static final int TYPE_NOTIFY_GET_NEW_TROOP_HEAD;
    private static int sNotificationTypeStart;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        int i3 = 0 + 1;
        TYPE_GET_TROOP_AVATAR = 0;
        int i16 = i3 + 1;
        TYPE_CMD_TROOP_AVATAR = i3;
        sNotificationTypeStart = i16 + 1;
        TYPE_NOTIFY_GET_NEW_TROOP_HEAD = i16;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_cmdTroopAvatar(int i3, boolean z16, Object obj) {
        int i16;
        int i17;
        String str;
        String str2;
        List<TroopClipPic> list;
        List<TroopClipPic> list2;
        int i18;
        String str3;
        if (i3 == TYPE_CMD_TROOP_AVATAR && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            int i19 = -1;
            String str4 = null;
            if (objArr.length <= 5) {
                Object obj2 = objArr[4];
                if (obj2 instanceof List) {
                    list2 = (List) obj2;
                } else {
                    list2 = null;
                }
                Object obj3 = objArr[3];
                if (obj3 instanceof Integer) {
                    i18 = ((Integer) obj3).intValue();
                } else {
                    i18 = -1;
                }
                Object obj4 = objArr[2];
                if (obj4 instanceof String) {
                    str3 = (String) obj4;
                } else {
                    str3 = null;
                }
                Object obj5 = objArr[1];
                if (obj5 instanceof Integer) {
                    i19 = ((Integer) obj5).intValue();
                }
                Object obj6 = objArr[0];
                if (obj6 instanceof String) {
                    str4 = (String) obj6;
                }
                list = list2;
                i17 = i18;
                i16 = i19;
                str = str4;
                str2 = str3;
            } else {
                i16 = -1;
                i17 = -1;
                str = null;
                str2 = null;
                list = null;
            }
            onCmdTroopAvatar(z16, str, i16, str2, i17, list);
        }
    }

    private void onUpdate_getTroopAvatar(int i3, boolean z16, Object obj) {
        int i16;
        int i17;
        String str;
        String str2;
        List<TroopClipPic> list;
        List<TroopClipPic> list2;
        int i18;
        String str3;
        if (i3 == TYPE_GET_TROOP_AVATAR && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            int i19 = -1;
            String str4 = null;
            if (objArr.length <= 5) {
                Object obj2 = objArr[4];
                if (obj2 instanceof List) {
                    list2 = (List) obj2;
                } else {
                    list2 = null;
                }
                Object obj3 = objArr[3];
                if (obj3 instanceof Integer) {
                    i18 = ((Integer) obj3).intValue();
                } else {
                    i18 = -1;
                }
                Object obj4 = objArr[2];
                if (obj4 instanceof String) {
                    str3 = (String) obj4;
                } else {
                    str3 = null;
                }
                Object obj5 = objArr[1];
                if (obj5 instanceof Integer) {
                    i19 = ((Integer) obj5).intValue();
                }
                Object obj6 = objArr[0];
                if (obj6 instanceof String) {
                    str4 = (String) obj6;
                }
                list = list2;
                i17 = i18;
                i16 = i19;
                str = str4;
                str2 = str3;
            } else {
                i16 = -1;
                i17 = -1;
                str = null;
                str2 = null;
                list = null;
            }
            onGetTroopAvatar(z16, str, i16, str2, i17, list);
        }
    }

    private void onUpdate_notifyGetNewTroopHead(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_GET_NEW_TROOP_HEAD) {
            return;
        }
        Pair pair = (Pair) obj;
        onUpdateNewTroopFaceIcon(z16, ((Boolean) pair.first).booleanValue(), (String) pair.second);
    }

    protected void onCmdTroopAvatar(boolean z16, String str, int i3, String str2, int i16, List<TroopClipPic> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetTroopAvatar(boolean z16, String str, int i3, String str2, int i16, List<TroopClipPic> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), list);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        onUpdate_getTroopAvatar(i3, z16, obj);
        onUpdate_cmdTroopAvatar(i3, z16, obj);
        onUpdate_notifyGetNewTroopHead(i3, z16, obj);
    }

    protected void onUpdateNewTroopFaceIcon(boolean z16, boolean z17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
        }
    }
}

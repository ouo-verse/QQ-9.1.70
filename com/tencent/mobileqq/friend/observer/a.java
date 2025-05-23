package com.tencent.mobileqq.friend.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements b {
    static IPatchRedirector $redirector_ = null;
    public static final String ADD_DIRECT = "addDirect";

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onAddBatchPhoneFriend(boolean z16, ArrayList<AddBatchPhoneFriendResult> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), arrayList);
        }
    }

    protected void onAddFriendSecCheck(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void onAddReqStatesChanged(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onBatchQueryAddFriendPermission(boolean z16, Set set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), set);
        }
    }

    protected void onGetAutoInfo(boolean z16, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
        }
    }

    protected void onGetInfoWithOpenId(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void onQueryUinSafetyFlag(boolean z16, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 15) {
                if (i3 != 33) {
                    if (i3 != 71) {
                        if (i3 != 100) {
                            if (i3 != 105) {
                                if (i3 != 113) {
                                    if (i3 != 11) {
                                        if (i3 != 12) {
                                            if (i3 != 68 && i3 != 69) {
                                                switch (i3) {
                                                    case 126:
                                                        HashMap<String, Integer> hashMap = new HashMap<>();
                                                        if (z16 && (obj instanceof Bundle)) {
                                                            Bundle bundle = (Bundle) obj;
                                                            ArrayList<String> stringArrayList = bundle.getStringArrayList("qzone_permission_uins");
                                                            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("qzone_permission_res");
                                                            for (int i17 = 0; i17 < stringArrayList.size(); i17++) {
                                                                hashMap.put(stringArrayList.get(i17), integerArrayList.get(i17));
                                                            }
                                                            i16 = bundle.getInt("qzone_permission_status");
                                                        } else {
                                                            i16 = -1;
                                                        }
                                                        onUpdateSetFriendPermission(z16, hashMap, i16);
                                                        return;
                                                    case 127:
                                                        HashMap<String, Integer> hashMap2 = new HashMap<>();
                                                        if (z16 && (obj instanceof Bundle)) {
                                                            Bundle bundle2 = (Bundle) obj;
                                                            ArrayList<String> stringArrayList2 = bundle2.getStringArrayList("qzone_permission_uins");
                                                            ArrayList<Integer> integerArrayList2 = bundle2.getIntegerArrayList("qzone_permission_sets");
                                                            for (int i18 = 0; i18 < stringArrayList2.size(); i18++) {
                                                                hashMap2.put(stringArrayList2.get(i18), integerArrayList2.get(i18));
                                                            }
                                                        }
                                                        onUpdateFetchFriendPermission(z16, hashMap2);
                                                        return;
                                                    case 128:
                                                        ArrayList<String> arrayList = new ArrayList<>();
                                                        if (z16 && (obj instanceof Bundle)) {
                                                            arrayList = ((Bundle) obj).getStringArrayList("qzone_permission_uins");
                                                        }
                                                        onUpdateFetchByPageFriendPermission(z16, arrayList);
                                                        return;
                                                    case 129:
                                                        if (obj instanceof Set) {
                                                            onBatchQueryAddFriendPermission(z16, (Set) obj);
                                                            return;
                                                        }
                                                        return;
                                                    default:
                                                        return;
                                                }
                                            }
                                            Bundle bundle3 = (Bundle) obj;
                                            onQueryUinSafetyFlag(z16, bundle3.getLong("uin"), bundle3.getInt(FriendListHandler.KEY_SAFETY_FLAG));
                                            return;
                                        }
                                        onUpdateAddFriendSetting(z16, (Bundle) obj);
                                        return;
                                    }
                                    Bundle bundle4 = (Bundle) obj;
                                    String string = bundle4.getString("uin");
                                    int i19 = bundle4.getInt(QzoneIPCModule.RESULT_CODE, 1);
                                    boolean z19 = bundle4.getBoolean(ADD_DIRECT, false);
                                    if (i19 == 0) {
                                        z18 = true;
                                    }
                                    onUpdateAddFriend(z16, z18, z19, string, bundle4);
                                    return;
                                }
                                onAddFriendSecCheck(z16, (Bundle) obj);
                                return;
                            }
                            onAddBatchPhoneFriend(z16, (ArrayList) obj);
                            return;
                        }
                        if (obj instanceof String) {
                            onAddReqStatesChanged(z16, (String) obj);
                            return;
                        }
                        return;
                    }
                    Bundle bundle5 = (Bundle) obj;
                    onGetInfoWithOpenId(z16, bundle5.getString("uin"), bundle5.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME));
                    return;
                }
                Bundle bundle6 = (Bundle) obj;
                String string2 = bundle6.getString("uin");
                if (z16) {
                    onGetAutoInfo(true, string2, bundle6.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME), bundle6.getInt("group_id", 0));
                    return;
                } else {
                    onGetAutoInfo(false, string2, "", 0);
                    return;
                }
            }
            onUpdateDelFriend(z16, obj);
            return;
        }
        if (!z16 || !((Boolean) obj).booleanValue()) {
            z17 = false;
        }
        onUpdateFriendList(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
        }
    }

    protected void onUpdateAddFriendSetting(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateDelFriend(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onUpdateFetchByPageFriendPermission(boolean z16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), list);
        }
    }

    protected void onUpdateFetchFriendPermission(boolean z16, HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void onUpdateFriendList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onUpdateSetFriendPermission(boolean z16, HashMap<String, Integer> hashMap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), hashMap, Integer.valueOf(i3));
        }
    }
}

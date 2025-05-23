package com.tencent.mobileqq.phonecontact.observer;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.data.RecommendContactInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_AUTO_BIND = "k_buto_bind";
    public static final String KEY_RESULT = "k_result";
    public static final String KEY_UIN = "k_uin";
    public static final int REASON_ALL_TIMEOUT = 2;
    public static final int REASON_NOBIND_HASBIND = 4;
    public static final int REASON_NOBIND_NODATA = 5;
    public static final int REASON_NONE = 0;
    public static final int REASON_NO_BIND = 1;
    public static final int REASON_PART_TIMEOUT = 3;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUploadAndQueryContact(boolean z16, int i3) {
        onUploadContact(z16, i3);
        if (z16) {
            onQueryContactList(true, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getBindErrorMessage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (i3 == 217) {
            return HardCodeUtil.qqStr(R.string.l0t);
        }
        if (i3 != 219 && i3 != 216) {
            if (i3 == 224) {
                return HardCodeUtil.qqStr(R.string.l0q);
            }
            if (i3 == 223) {
                return HardCodeUtil.qqStr(R.string.l0r);
            }
            return HardCodeUtil.qqStr(R.string.l0u);
        }
        return HardCodeUtil.qqStr(R.string.l0y);
    }

    protected void onBindMobile(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancelBind(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
    }

    protected void onDisableMobileMatch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
    }

    protected void onGetBindUinWithPhone(boolean z16, boolean z17, boolean z18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str);
        }
    }

    protected void onGetNewerGuideRecommended(List<RecommendContactInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        }
    }

    protected void onGetNewerGuideRecommendedNotBind(List<RecommendContactInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) list);
        }
    }

    protected void onHideContact(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    protected void onPushRecommendUpdate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    protected void onQueryBindState(boolean z16, boolean z17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
        }
    }

    protected void onQueryContactList(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onQueryLastLoginInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        }
    }

    protected void onReBindMblWTLogin(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onRebindMobile(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), bundle);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 1;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 != 12) {
            if (i3 != 23) {
                ArrayList arrayList = null;
                if (i3 != 40) {
                    if (i3 != 100) {
                        if (i3 != 19) {
                            if (i3 != 20) {
                                switch (i3) {
                                    case 14:
                                        if (bundle != null) {
                                            i18 = bundle.getInt("param_fail_reason", 0);
                                        }
                                        onUploadContact(z16, i18);
                                        return;
                                    case 15:
                                        if (bundle != null) {
                                            i18 = bundle.getInt("param_fail_reason", 0);
                                        }
                                        onUpdateContact(z16, i18);
                                        return;
                                    case 16:
                                        if (bundle != null) {
                                            i16 = bundle.getInt(KEY_RESULT);
                                        } else {
                                            i16 = -1;
                                        }
                                        onVerifyBindSms(z16, i16);
                                        return;
                                    case 17:
                                        onResendSms(z16);
                                        return;
                                    default:
                                        switch (i3) {
                                            case 26:
                                                onGetBindUinWithPhone(z16, bundle.getBoolean("bindOK"), bundle.getBoolean("hadBind"), bundle.getString("bindUin"));
                                                return;
                                            case 27:
                                                onReBindMblWTLogin(z16, bundle.getBoolean("bind_state", false));
                                                return;
                                            case 28:
                                                if (bundle == null || !bundle.getBoolean("hasUpdate")) {
                                                    i17 = 0;
                                                }
                                                onQueryContactList(z16, i17);
                                                return;
                                            default:
                                                switch (i3) {
                                                    case 30:
                                                        if (z16) {
                                                            i18 = bundle.getInt("param_update_flag");
                                                        }
                                                        onQueryContactList(z16, i18);
                                                        return;
                                                    case 31:
                                                        if (bundle != null) {
                                                            i18 = bundle.getInt("param_fail_reason", 0);
                                                        }
                                                        onUploadAndQueryContact(z16, i18);
                                                        return;
                                                    case 32:
                                                        onQueryLastLoginInfo(z16);
                                                        return;
                                                    case 33:
                                                        onDisableMobileMatch(z16);
                                                        return;
                                                    case 34:
                                                        onHideContact(z16);
                                                        return;
                                                    case 35:
                                                        onBindMobile(z16, bundle);
                                                        return;
                                                    case 36:
                                                        if (bundle != null) {
                                                            arrayList = bundle.getParcelableArrayList(RecommendContactInfo.class.getSimpleName());
                                                        }
                                                        onGetNewerGuideRecommended(arrayList);
                                                        return;
                                                    case 37:
                                                        if (bundle != null) {
                                                            i18 = bundle.getInt("param_fail_reason", 0);
                                                        }
                                                        onUploadContactNotBind(z16, i18);
                                                        return;
                                                    case 38:
                                                        if (bundle != null) {
                                                            i18 = bundle.getInt("param_fail_reason", 0);
                                                        }
                                                        onUpdateContactNotBind(z16, i18);
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                            }
                            onCancelBind(z16);
                            return;
                        }
                        onRebindMobile(z16, bundle);
                        return;
                    }
                    onUploadProgressUpdated(bundle.getInt("current_percentage"), bundle.getInt("expected_percentage"));
                    return;
                }
                if (bundle != null) {
                    arrayList = bundle.getParcelableArrayList(RecommendContactInfo.class.getSimpleName());
                }
                onGetNewerGuideRecommendedNotBind(arrayList);
                return;
            }
            onPushRecommendUpdate(z16);
            return;
        }
        if (z16) {
            onQueryBindState(true, bundle.getBoolean("bind_state"), bundle.getLong("param_query_from"));
        } else {
            onQueryBindState(false, false, 0L);
        }
    }

    protected void onResendSms(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }

    protected void onUpdateContact(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onUpdateContactNotBind(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onUploadContact(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onUploadContactNotBind(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onUploadProgressUpdated(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onVerifyBindSms(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }
}

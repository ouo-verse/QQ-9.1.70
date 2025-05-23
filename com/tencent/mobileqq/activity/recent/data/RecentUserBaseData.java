package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation$NotParcel;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class RecentUserBaseData extends RecentBaseData {
    static IPatchRedirector $redirector_ = null;
    protected static final String DES_DEFAULT_HAVE_MSG = "%s,%s,%d\u6761\u672a\u8bfb,%s";
    protected static final String DES_DEFAULT_NO_MSG = "%s,%s,%s";
    private static final String TAG = "RecentUserBaseData";

    @ParcelAnnotation$NotParcel
    private Bundle mArgsBundle;

    @ParcelAnnotation$NotParcel
    private ConcurrentHashMap<String, Boolean> mBundleMap;
    private boolean mIsFeatureOn;

    @ParcelAnnotation$NotParcel
    public RecentUser mUser;

    public RecentUserBaseData(RecentUser recentUser) throws NullPointerException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
            return;
        }
        this.mIsFeatureOn = false;
        if (recentUser != null) {
            this.mUser = recentUser;
            return;
        }
        throw new NullPointerException("RecentUser is null");
    }

    private boolean b(String str, boolean z16) {
        Bundle bundle = this.mArgsBundle;
        if (bundle == null) {
            QLog.e(TAG, 1, "getArgsBundleNotSafe, mArgsBundle == null, key: " + str + " defValue: " + z16);
            return z16;
        }
        try {
            return bundle.getBoolean(str, z16);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getArgsBundleNotSafe error, key: " + str + " defValue: " + z16, e16);
            return z16;
        }
    }

    private boolean c(String str, boolean z16) {
        Object orDefault;
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.mBundleMap;
        if (concurrentHashMap != null) {
            try {
                orDefault = concurrentHashMap.getOrDefault(str, Boolean.valueOf(z16));
                return ((Boolean) orDefault).booleanValue();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getArgsBundleSafe mBundleMap error, key: " + str + " defValue: " + z16, e16);
                return z16;
            }
        }
        QLog.e(TAG, 1, "getArgsBundleSafe, mBundleMap == null, key: " + str + " defValue: " + z16);
        return z16;
    }

    private void h(String str, boolean z16) {
        Bundle bundle = this.mArgsBundle;
        if (bundle == null) {
            QLog.e(TAG, 1, "putArgsBundleNotSafe, mArgsBundle == null, key: " + str + " value: " + z16);
            return;
        }
        try {
            bundle.putBoolean(str, z16);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "putArgsBundleNotSafe error, key: " + str + " value: " + z16, e16);
        }
    }

    private void i(String str, boolean z16) {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.mBundleMap;
        if (concurrentHashMap == null) {
            QLog.e(TAG, 1, "putArgsBundleSafe, mBundleMap == null, key: " + str + " value: " + z16);
            return;
        }
        try {
            concurrentHashMap.put(str, Boolean.valueOf(z16));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "putArgsBundleSafe mBundleMap error, key: " + str + " value: " + z16, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.mIsFeatureOn) {
            return c(str, z16);
        }
        return b(str, z16);
    }

    public RecentUser d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RecentUser) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mUser;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mUser.troopUin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void extraUpdate(BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, baseQQAppInterface, context, msgSummary);
        } else {
            super.extraUpdate(baseQQAppInterface, context, msgSummary, true);
        }
    }

    protected boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        } else if (this.mIsFeatureOn) {
            i(str, z16);
        } else {
            h(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastDraftTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.mUser.lastmsgdrafttime;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.mUser.lastmsgtime;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public int getRecentUserType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mUser.getType();
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public String getRecentUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mUser.uin;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public final boolean isUnreadMsgNumInTabNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        int i3 = this.mUnreadFlag;
        if (i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (isUnreadMsgNumInTabNum() && f()) {
            int i3 = this.mMenuFlag & (-983041);
            this.mMenuFlag = i3;
            if (this.mUnreadNum != 0) {
                this.mMenuFlag = i3 | 65536;
            } else {
                this.mMenuFlag = i3 | 131072;
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        if (this.mIsFeatureOn) {
            ConcurrentHashMap<String, Boolean> concurrentHashMap = this.mBundleMap;
            if (concurrentHashMap == null) {
                this.mBundleMap = new ConcurrentHashMap<>();
            } else {
                concurrentHashMap.clear();
            }
        } else {
            Bundle bundle = this.mArgsBundle;
            if (bundle == null) {
                this.mArgsBundle = new Bundle();
            } else {
                bundle.clear();
            }
        }
        this.mMsgExtroInfo = "";
        RecentUser recentUser = this.mUser;
        if (recentUser != null) {
            this.fromRegisterProxy = recentUser.updatedByRegisterProxy;
        }
    }

    public RecentUserBaseData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mIsFeatureOn = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}

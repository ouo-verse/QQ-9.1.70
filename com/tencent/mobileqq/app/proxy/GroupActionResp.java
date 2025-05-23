package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GroupActionResp {
    static IPatchRedirector $redirector_ = null;
    public static final int ERR_CHECK_VIP_FAILED = 65;
    public static final int ERR_GROUPS_MORE_THAN15_FOR_NOT_VIP = 66;
    public static final int ERR_GROUPS_MORE_THAN_30 = 64;
    public static final int ERR_GROUPS_OVERFLOW = 21;
    public static final int ERR_GROUPS_TOO_MANY = 17;
    public static final int ERR_GROUP_NAME_TOO_LONG = 16;
    public static final int ERR_INVALID_GROUP_ID = 19;
    public static final int ERR_INVALID_SEQ = 20;
    public static final int ERR_LIMIT_HOSTING_RTX = 80;
    public static final int ERR_NO = 0;
    public static final int ERR_OTHER_SYSTEM_1 = 18;
    public static final int ERR_OTHER_SYSTEM_2 = 23;
    public static final int ERR_OTHER_SYSTEM_3 = 24;
    public static final int ERR_OTHER_SYSTEM_4 = 33;
    public AddGroupResp mAddResp;
    public DelGroupResp mDelResp;
    public int mErrCode;
    public String mErrMsg;
    public RenameGroupResp mRenameResp;
    public ReSortGroupResp mResortResp;
    public int mType;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface GroupActionType {
        public static final int E_ADD_GROUP = 1;
        public static final int E_DELETE_GROUP = 3;
        public static final int E_RENAME_GROUP = 2;
        public static final int E_RESORT_GROUP = 4;
    }

    public GroupActionResp(int i3, String str, AddGroupResp addGroupResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, addGroupResp);
            return;
        }
        this.mType = 1;
        this.mErrCode = i3;
        this.mAddResp = addGroupResp;
        this.mErrMsg = str;
    }

    public GroupActionResp(int i3, String str, RenameGroupResp renameGroupResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, renameGroupResp);
            return;
        }
        this.mType = 2;
        this.mErrCode = i3;
        this.mRenameResp = renameGroupResp;
        this.mErrMsg = str;
    }

    public GroupActionResp(int i3, String str, DelGroupResp delGroupResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, delGroupResp);
            return;
        }
        this.mType = 3;
        this.mErrCode = i3;
        this.mDelResp = delGroupResp;
        this.mErrMsg = str;
    }

    public GroupActionResp(int i3, String str, ReSortGroupResp reSortGroupResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, reSortGroupResp);
            return;
        }
        this.mType = 4;
        this.mErrCode = i3;
        this.mResortResp = reSortGroupResp;
        this.mErrMsg = str;
    }
}

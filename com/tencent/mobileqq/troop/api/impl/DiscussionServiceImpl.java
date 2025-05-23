package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.utils.ac;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DiscussionServiceImpl implements IDiscussionService {
    static IPatchRedirector $redirector_;
    private AppInterface app;
    private com.tencent.mobileqq.app.n mManager;

    public DiscussionServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public Object findDiscussionInfoByID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.app.n nVar = this.mManager;
        if (nVar == null) {
            return null;
        }
        nVar.h(str);
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    @Nullable
    public String getDiscUinByTroopUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.app.n nVar = this.mManager;
        if (nVar == null) {
            return null;
        }
        return nVar.j(str);
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public Object getDiscussList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) this);
        }
        com.tencent.mobileqq.app.n nVar = this.mManager;
        if (nVar == null) {
            return new ArrayList();
        }
        return nVar.k();
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public int getDiscussionManager_COLLECT_MAX_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 80;
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public Object getDiscussionMemberInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        }
        return this.mManager.l(str, String.valueOf(str2));
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public Object getDiscussionMemberInfoListByUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return ((com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).m(str);
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public Object getDiscussionMemberInfoMapByUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        return ((com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).n(str);
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public Object getDiscussionMemberMapByUins(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, (Object) strArr);
        }
        return ((com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).p(strArr);
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public String getDiscussionMemberName(String str, String str2) {
        com.tencent.mobileqq.app.n nVar;
        DiscussionMemberInfo l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || (nVar = this.mManager) == null || (l3 = nVar.l(str, String.valueOf(str2))) == null) {
            return "";
        }
        return l3.getDiscussionMemberName();
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public String getDiscussionMemberNickName(AppRuntime appRuntime, String str, String str2) {
        com.tencent.mobileqq.app.n nVar;
        DiscussionMemberInfo l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, appRuntime, str, str2);
        }
        if (appRuntime == null || str == null || str2 == null || (nVar = this.mManager) == null || (l3 = nVar.l(str, str2)) == null) {
            return "";
        }
        if (!TextUtils.isEmpty(l3.memberName)) {
            return l3.memberName;
        }
        return l3.inteRemark;
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public int getDiscussionMemberNum(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).intValue();
        }
        return this.mManager.q(str);
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public String getDiscussionName(String str) {
        com.tencent.mobileqq.app.n nVar;
        DiscussionInfo h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (!TextUtils.isEmpty(str) || (nVar = this.mManager) == null || (h16 = nVar.h(str)) == null) ? "" : h16.discussionName : (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public int getFavoriteCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return ((com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).r();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime);
        } else if (appRuntime instanceof AppInterface) {
            this.app = (AppInterface) appRuntime;
            this.mManager = (com.tencent.mobileqq.app.n) appRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.mManager = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public void saveTroopAndDiscUinMap(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
            return;
        }
        com.tencent.mobileqq.app.n nVar = this.mManager;
        if (nVar == null) {
            return;
        }
        nVar.H(str, str2);
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public Object findDiscussionInfoByID(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.mManager.i(str, z16) : iPatchRedirector.redirect((short) 14, this, str, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionService
    public String getDiscussionName(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) str);
        }
        AppInterface appInterface = this.app;
        return appInterface instanceof QQAppInterface ? ac.p((QQAppInterface) appInterface, context, str) : "";
    }
}

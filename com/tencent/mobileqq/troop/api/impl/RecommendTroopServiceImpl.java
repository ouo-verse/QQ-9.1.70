package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RecommendTroopServiceImpl implements IRecommendTroopService {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "RecommendTroopServiceImpl";
    private AppInterface app;

    /* renamed from: em, reason: collision with root package name */
    protected EntityManager f294233em;
    public int isEnd;
    SharedPreferences pref;

    public RecommendTroopServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IRecommendTroopService
    public String getLastMessage() {
        List<MessageRecord> msgList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
            if (iMessageFacade != null && (msgList = iMessageFacade.getMsgList(AppConstants.RECOMMEND_TROOP_UIN, 4001)) != null && msgList.size() > 0) {
                for (int size = msgList.size() - 1; size >= 0; size--) {
                    MessageRecord messageRecord = msgList.get(size);
                    int i3 = messageRecord.msgtype;
                    if ((i3 == -1039 || i3 == -1040) && (str = messageRecord.f203106msg) != null && str.length() > 0) {
                        return messageRecord.f203106msg;
                    }
                }
            }
        } catch (NullPointerException unused) {
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.api.IRecommendTroopService
    public int isEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.isEnd;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime instanceof AppInterface) {
            AppInterface appInterface = (AppInterface) appRuntime;
            this.app = appInterface;
            this.pref = appInterface.getApp().getSharedPreferences("recommend_troop_info" + this.app.getAccount(), 0);
            this.f294233em = this.app.getEntityManagerFactory().createEntityManager();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IRecommendTroopService
    public void setEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.isEnd = i3;
        }
    }
}

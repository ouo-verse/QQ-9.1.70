package com.tencent.mobileqq.troop.api.impl;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DiscussionHandlerServiceImpl implements IDiscussionHandlerService {
    static IPatchRedirector $redirector_;
    protected AppRuntime mApp;

    public DiscussionHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void addDiscussMember(long j3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), obj);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            ((DiscussionHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).E2(j3, (ArrayList) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void checkPstnIconInfoAndUpdate(String str) {
        DiscussionHandler discussionHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if ((appRuntime instanceof AppInterface) && (discussionHandler = (DiscussionHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)) != null && discussionHandler.Z2() != null) {
            discussionHandler.Z2().v(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void collectDiscussion(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            ((DiscussionHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).K2(j3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void createDiscuss(String str, Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, obj, Integer.valueOf(i3));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            ((DiscussionHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).L2(str, (ArrayList) obj, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void getAtAllRemainCountInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        } else {
            ((DiscussionHandler) ((AppInterface) this.mApp).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).getAtAllRemainCountInfo(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public Bitmap getDiscussionFaceIcon(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            return ((DiscussionHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).W2(str, z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void kickOutMemberFromDiscussion(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            ((DiscussionHandler) ((AppInterface) this.mApp).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).e4(j3, j16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void unCollectDiscussion(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            ((DiscussionHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).s4(j3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void updateDiscussionIcon(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            ((DiscussionHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).t4(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDiscussionHandlerService
    public void createDiscuss(String str, Object obj, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, obj, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            ((DiscussionHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).M2(str, (ArrayList) obj, i3, j3);
        }
    }
}

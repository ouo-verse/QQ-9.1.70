package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkFileExportHandlerImpl extends BusinessHandler implements Handler.Callback, ITeamWorkFileExportHandler {
    public static final String TAG = "TeamWorkFileExportHandlerImpl";
    private AppInterface app;

    public TeamWorkFileExportHandlerImpl(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
    }

    private void doRequestAfterGetTicket(final Runnable runnable) {
        if (this.app == null) {
            return;
        }
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.api.impl.t
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
            public final void a(String str) {
                TeamWorkFileExportHandlerImpl.lambda$doRequestAfterGetTicket$0(runnable, str);
            }
        });
    }

    public static String getClassName() {
        return TeamWorkFileExportHandlerImpl.class.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doRequestAfterGetTicket$0(Runnable runnable, String str) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.executeOnNetWorkThread(runnable);
        } else {
            QLog.i(TAG, 1, "pskey async is empty, domain: docs.qq.com");
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler
    public void fileExportDownloadRequest(final String str, final String str2, final String str3, final String str4) {
        doRequestAfterGetTicket(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileExportHandlerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (TeamWorkFileExportHandlerImpl.this.app != null && !TextUtils.isEmpty(str)) {
                    TeamWorkHttpUtils.y(TeamWorkFileExportHandlerImpl.this.app, str, str2, str3, str4, TeamWorkFileExportHandlerImpl.this.app.getCurrentAccountUin());
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.mobileqq.teamwork.v.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}

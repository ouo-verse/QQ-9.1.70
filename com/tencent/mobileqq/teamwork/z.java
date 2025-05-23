package com.tencent.mobileqq.teamwork;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class z implements com.tencent.mobileqq.teamwork.api.a {

    /* renamed from: a, reason: collision with root package name */
    public TeamWorkFileImportInfo f292445a;

    /* renamed from: b, reason: collision with root package name */
    protected ITeamWorkFileImportHandler f292446b;

    public z(TeamWorkFileImportInfo teamWorkFileImportInfo, AppInterface appInterface) {
        this.f292445a = teamWorkFileImportInfo;
        if (appInterface != null) {
            this.f292446b = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z16) {
        boolean z17;
        if (z16 && FileUtils.fileExistsAndNotEmpty(this.f292445a.f292077h)) {
            if (QLog.isColorLevel()) {
                QLog.i("TeamWorkFileImportJob", 2, "---notifyUIFailed try local fileName: " + this.f292445a.f292074f);
            }
            this.f292446b.removeFileImporting(this.f292445a);
            TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292445a;
            z17 = false;
            teamWorkFileImportInfo.I = false;
            this.f292446b.addToFileImportingMap(teamWorkFileImportInfo);
            this.f292446b.fileImportFromLocalFile(this.f292445a);
        } else {
            z17 = true;
        }
        if (z17) {
            this.f292446b.notifyUIError(this.f292445a);
        }
    }

    public void b(AppInterface appInterface) {
    }
}

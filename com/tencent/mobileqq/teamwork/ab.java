package com.tencent.mobileqq.teamwork;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ab extends z {
    public ab(TeamWorkFileImportInfo teamWorkFileImportInfo, AppInterface appInterface) {
        super(teamWorkFileImportInfo, appInterface);
    }

    @Override // com.tencent.mobileqq.teamwork.z
    public void b(AppInterface appInterface) {
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292445a;
        if (teamWorkFileImportInfo != null && appInterface != null) {
            this.f292446b.addToFileImportingMap(teamWorkFileImportInfo);
            this.f292446b.fileImportFromLocalFileForDataLine(this.f292445a);
        }
    }
}

package kr2;

import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    public static void b(final IGetExternalInterface.d dVar) {
        final INativeEngineFileBrowserWrapper.a aVar = new INativeEngineFileBrowserWrapper.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            dVar.a(aVar);
            return;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        aVar.f291658a = currentAccountUin;
        aVar.f291659b = ITeamWorkHandler.DOCS_DOMAIN;
        TeamWorkHttpUtils.C(currentAccountUin, ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.d() { // from class: kr2.a
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                b.c(INativeEngineFileBrowserWrapper.a.this, dVar, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(INativeEngineFileBrowserWrapper.a aVar, IGetExternalInterface.d dVar, Object obj) {
        aVar.f291660c = "TOK=TDQQImport;" + obj;
        dVar.a(aVar);
    }
}

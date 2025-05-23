package com.tencent.biz.addContactTroopView;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.manager.Manager;
import tencent.im.troop_view.troopviewInfo$RspBody;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements Manager {

    /* renamed from: d, reason: collision with root package name */
    protected AppInterface f78350d;

    /* renamed from: e, reason: collision with root package name */
    protected troopviewInfo$RspBody f78351e;

    /* renamed from: f, reason: collision with root package name */
    protected final String f78352f = "AddContactTroopManage";

    public a(AppInterface appInterface) {
        this.f78350d = appInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(troopviewInfo$RspBody troopviewinfo_rspbody) {
        if (troopviewinfo_rspbody == null || !troopviewinfo_rspbody.has()) {
            return false;
        }
        return FileUtils.pushData2File(new File(this.f78350d.getApplication().getFilesDir(), "AddContactTroopManage" + this.f78350d.getCurrentAccountUin()).getAbsolutePath(), troopviewinfo_rspbody.toByteArray(), false);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}

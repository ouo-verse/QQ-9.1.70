package kl0;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends com.tencent.gamecenter.wadl.biz.db.a {
    public c() {
        super(MobileQQ.sMobileQQ, "TASKS_3");
    }

    public boolean a(String str) {
        return exists("packageName=?", new String[]{str}, "packageName");
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getCreateTableFields() {
        return WadlProxyConsts.VM_TABLE_FIELDS;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getTableKey() {
        return "packageName";
    }
}

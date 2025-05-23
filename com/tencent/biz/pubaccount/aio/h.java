package com.tencent.biz.pubaccount.aio;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pv3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/h;", "Lpv3/a;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "b", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class h implements pv3.a {
    @Override // pv3.a
    public CharSequence a(CharSequence charSequence) {
        return a.C11043a.a(this, charSequence);
    }

    @Override // pv3.a
    public CharSequence b(com.tencent.aio.api.runtime.a context) {
        String uinFromUid;
        AppRuntime peekAppRuntime;
        IPublicAccountDataManager iPublicAccountDataManager;
        Object findPublicAccountInfo;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        AIOParam g17;
        AIOSession r17;
        AIOContact c17;
        String str = null;
        Integer valueOf = (context == null || (g17 = context.g()) == null || (r17 = g17.r()) == null || (c17 = r17.c()) == null) ? null : Integer.valueOf(c17.e());
        if (context != null && (g16 = context.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        }
        if (valueOf == null || valueOf.intValue() != 103) {
            return "";
        }
        if ((str == null || str.length() == 0) || (uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str)) == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (iPublicAccountDataManager = (IPublicAccountDataManager) peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")) == null) {
            return "";
        }
        if ((uinFromUid.length() == 0) || (findPublicAccountInfo = iPublicAccountDataManager.findPublicAccountInfo(uinFromUid)) == null || !(findPublicAccountInfo instanceof PublicAccountInfo)) {
            return "";
        }
        return ((PublicAccountInfo) findPublicAccountInfo).name;
    }
}

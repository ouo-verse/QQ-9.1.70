package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0002\u00a8\u0006\u0005"}, d2 = {"", "uid", "tag", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final com.tencent.qqnt.ntrelation.intimateinfo.bean.a b(String str, String str2) {
        return ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(str, str2);
    }
}

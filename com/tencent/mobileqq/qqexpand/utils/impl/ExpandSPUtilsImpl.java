package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils;
import com.tencent.mobileqq.qqexpand.utils.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/impl/ExpandSPUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IExpandSPUtils;", "()V", "canPopDialog", "", "popStateName", "", "getGreetLimitCode", "", "uin", "getGreetLimitString", "getGreetLimitTime", "", "setExtendFriendsConfigTaskId", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "setGreetLimit", "code", "tips", "setUserCategoryPullTime", "time", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExpandSPUtilsImpl implements IExpandSPUtils {
    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
    public boolean canPopDialog(String popStateName) {
        return f.a(popStateName);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
    public int getGreetLimitCode(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return f.c(uin);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
    public String getGreetLimitString(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return f.d(uin);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
    public long getGreetLimitTime(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return f.e(uin);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
    public void setExtendFriendsConfigTaskId(String uin, String taskId) {
        f.h(uin, taskId);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
    public void setGreetLimit(String uin, int code, String tips) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        f.i(uin, code, tips);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
    public void setUserCategoryPullTime(String uin, long time) {
        f.j(uin, time);
    }
}

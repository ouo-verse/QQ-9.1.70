package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016JP\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J0\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/impl/ExpandReportUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IExpandReportUtils;", "()V", "getManageTestPlanParams", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "initReport", "", "onUserActionToTunnel", "event", "isSucc", "", "longElapse", "", "longSize", "params", "", "immediat", "var9", "reportEnterExpandClick", "from", "reportEnterExpandPage", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExpandReportUtilsImpl implements IExpandReportUtils {
    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils
    public String getManageTestPlanParams(BaseQQAppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        return d.a(appInterface);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils
    public void initReport() {
        d.d();
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils
    public void onUserActionToTunnel(String event, boolean isSucc, long longElapse, long longSize, Map<String, String> params, boolean immediat, boolean var9) {
        Intrinsics.checkNotNullParameter(event, "event");
        d.e(event, isSucc, longElapse, longSize, params, immediat, var9);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils
    public void reportEnterExpandClick(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        d.g(from);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils
    public void reportEnterExpandPage(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        d.i(from);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils
    public void onUserActionToTunnel(String event, boolean isSucc, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        d.f(event, isSucc, params);
    }
}

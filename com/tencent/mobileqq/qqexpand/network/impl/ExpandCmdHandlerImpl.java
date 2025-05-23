package com.tencent.mobileqq.qqexpand.network.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.network.b;
import com.tencent.mobileqq.qqexpand.network.d;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J.\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/network/impl/ExpandCmdHandlerImpl;", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdHandler;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "", "cmdString", "", "buffer", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "", "sendSSORequest", "sendDirectConnectSSORequest", "<init>", "()V", "Companion", "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandCmdHandlerImpl implements IExpandCmdHandler {
    public static final String TAG = "ExpandCmdHandlerImpl";

    @Override // com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler
    public void sendDirectConnectSSORequest(BaseQQAppInterface appInterface, String cmdString, byte[] buffer, d callback) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        ExpandCmdHandler d16 = ExpandCmdHandler.d(appInterface);
        if (d16 == null) {
            QLog.e(TAG, 2, cmdString + " sendSSORequest error handler is null");
            if (callback != null) {
                callback.a(null, new b(-1, "handler is null"));
                return;
            }
            return;
        }
        d16.h(cmdString, buffer, callback);
    }

    @Override // com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler
    public void sendSSORequest(BaseQQAppInterface appInterface, String cmdString, byte[] buffer, d callback) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        ExpandCmdHandler d16 = ExpandCmdHandler.d(appInterface);
        if (d16 == null) {
            QLog.e(TAG, 2, cmdString + " sendSSORequest error handler is null");
            if (callback != null) {
                callback.a(null, new b(-1, "handler is null"));
                return;
            }
            return;
        }
        d16.j(cmdString, buffer, callback);
    }
}

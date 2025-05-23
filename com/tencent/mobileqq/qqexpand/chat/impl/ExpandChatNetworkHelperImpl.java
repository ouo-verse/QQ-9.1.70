package com.tencent.mobileqq.qqexpand.chat.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatNetworkHelper;
import com.tencent.mobileqq.qqexpand.network.d;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/impl/ExpandChatNetworkHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatNetworkHelper;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "matchUin", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "", "requestAbleToGreet", "reportGreet", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandChatNetworkHelperImpl implements IExpandChatNetworkHelper {
    private final String TAG = "ExpandChatNetworkHelperImpl";

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatNetworkHelper
    public void reportGreet(BaseQQAppInterface app, long matchUin, d callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (QLog.isDebugVersion()) {
            QLog.d(this.TAG, 1, "start reportGreet matchUin:" + matchUin);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IExpandChatNetworkHelper
    public void requestAbleToGreet(BaseQQAppInterface app, long matchUin, d callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (QLog.isDebugVersion()) {
            QLog.d(this.TAG, 1, "start requestAbleToGreet matchUin:" + matchUin);
        }
    }
}

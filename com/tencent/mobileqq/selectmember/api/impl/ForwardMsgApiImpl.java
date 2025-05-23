package com.tencent.mobileqq.selectmember.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.selectmember.api.IForwardMsgApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/selectmember/api/impl/ForwardMsgApiImpl;", "Lcom/tencent/mobileqq/selectmember/api/IForwardMsgApi;", "Landroid/app/Activity;", "caller", "Landroid/content/Intent;", "intent", "", "directForwardMsg", "Landroid/view/View;", "captionForwardPreview", "Landroid/content/Context;", "startForwardActivity", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ForwardMsgApiImpl implements IForwardMsgApi {
    private static final String TAG = "ForwardMsgApiImpl";

    @Override // com.tencent.mobileqq.selectmember.api.IForwardMsgApi
    public View captionForwardPreview(Activity caller, Intent intent) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(intent, "intent");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return k.d(intent, (QQAppInterface) peekAppRuntime, caller).getContentPreview();
    }

    @Override // com.tencent.mobileqq.selectmember.api.IForwardMsgApi
    public void directForwardMsg(Activity caller, Intent intent) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            k.d(intent, (QQAppInterface) peekAppRuntime, caller).forwardDirectly(intent.getStringExtra("direct_show_msg"));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "directForwardMsg error: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.IForwardMsgApi
    public void startForwardActivity(Context caller, Intent intent) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ForwardBaseOption.startForwardActivity(caller, intent, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
    }
}
